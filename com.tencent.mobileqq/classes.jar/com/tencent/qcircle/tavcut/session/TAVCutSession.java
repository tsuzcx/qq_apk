package com.tencent.qcircle.tavcut.session;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.qcircle.tavcut.aekit.AEKitModel;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qcircle.tavcut.session.callback.StickerLyricCallback;
import com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback;
import com.tencent.qcircle.tavcut.session.callback.StickerStateCallback;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.StickerUtil;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;
import com.tencent.qcircle.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

public abstract class TAVCutSession
  implements Session, StickerLyricCallback, StickerOperationCallback, StickerStateCallback
{
  private static final String TAG = TAVCutImageSession.class.getSimpleName();
  protected final SparseArray<ArrayList<TAVSticker>> bulkStickers = new SparseArray();
  protected Context context;
  protected int currentIndex = 0;
  protected String initMediaModelsMD5 = "";
  protected final SparseArray<MediaBuilderOutput> mediaBuilderOutputs = new SparseArray();
  protected List<MediaModel> mediaModels;
  protected List<String> mediaModelsMD5 = new ArrayList();
  protected final SparseArray<VideoRenderChainManager> renderChainManagers = new SparseArray();
  protected boolean runAsync = false;
  protected SessionConfig sessionConfig;
  protected final SparseArray<StickerController> stickerControllers = new SparseArray();
  protected IStickerEventListener stickerEventListener;
  protected StickerLyricCallback stickerLyricCallback;
  protected StickerOperationCallback stickerOperationCallback;
  protected final SparseArray<TAVComposition> tavCompositions = new SparseArray();
  
  private void addOrUpdateStickerData(TAVSticker paramTAVSticker)
  {
    addOrUpdateStickerData(paramTAVSticker, this.currentIndex);
  }
  
  private void addOrUpdateStickerData(TAVSticker paramTAVSticker, int paramInt)
  {
    List localList = ((MediaModel)this.mediaModels.get(paramInt)).getMediaEffectModel().getStickerModelList();
    int i = 0;
    while (i < localList.size())
    {
      if (((StickerModel)localList.get(i)).getUniqueId().equals(paramTAVSticker.getStickerId()))
      {
        localList.remove(i);
        break;
      }
      i += 1;
    }
    if ((paramTAVSticker instanceof WSLyricSticker))
    {
      paramTAVSticker = WSLyricSticker.dumpToSubtitleModel(paramTAVSticker);
      ((MediaModel)this.mediaModels.get(paramInt)).getMediaEffectModel().setSubtitleModel(paramTAVSticker);
      return;
    }
    paramTAVSticker = StickerUtil.tavSticker2StickerModel(paramTAVSticker);
    paramTAVSticker.setDuration((float)paramTAVSticker.getEndTime() - paramTAVSticker.getStartTime());
    localList.add(paramTAVSticker);
  }
  
  private void updateStickerModel(TAVSticker paramTAVSticker)
  {
    runTask(new TAVCutSession.8(this, paramTAVSticker));
  }
  
  public void addSticker(int paramInt, @NonNull List<StickerModel> paramList, boolean paramBoolean)
  {
    StickerController localStickerController2 = (StickerController)this.stickerControllers.get(paramInt);
    StickerController localStickerController1 = localStickerController2;
    if (localStickerController2 == null)
    {
      localStickerController1 = createStickerController();
      this.stickerControllers.put(paramInt, localStickerController1);
    }
    runTask(new TAVCutSession.5(this, localStickerController1, paramInt, paramList, paramBoolean));
  }
  
  protected void addSticker(@NonNull StickerController paramStickerController, @NonNull StickerModel paramStickerModel)
  {
    addSticker(paramStickerController, paramStickerModel, true);
  }
  
  protected void addSticker(@NonNull StickerController paramStickerController, @NonNull StickerModel paramStickerModel, boolean paramBoolean)
  {
    runTask(new TAVCutSession.4(this, paramStickerController, paramStickerModel, paramBoolean));
  }
  
  protected void applyCurrentSticker(StickerController paramStickerController)
  {
    if (paramStickerController != null)
    {
      TAVSticker localTAVSticker = paramStickerController.getCurrentSticker();
      if (localTAVSticker != null)
      {
        paramStickerController.resignCurrentSticker();
        onStickerResign(localTAVSticker);
      }
    }
  }
  
  void clearAEKitModel(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager)
  {
    paramMediaModel.getMediaEffectModel().setAeKitModel(null);
    updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel());
  }
  
  protected CGSize constrainRenderSize(int paramInt1, int paramInt2)
  {
    CGSize localCGSize = new CGSize(paramInt1, paramInt2);
    Object localObject = this.sessionConfig;
    int i;
    if (localObject != null) {
      i = ((SessionConfig)localObject).getMaxIntermediateRenderSize();
    } else {
      i = -1;
    }
    if (i != -1)
    {
      localObject = Util.constrainMaxSize(new Size(paramInt1, paramInt2), i);
      localCGSize.width = ((Size)localObject).getWidth();
      localCGSize.height = ((Size)localObject).getHeight();
    }
    localObject = this.sessionConfig;
    if (localObject != null) {
      paramInt1 = ((SessionConfig)localObject).getMinIntermediateRenderSize();
    } else {
      paramInt1 = -1;
    }
    if (paramInt1 != -1)
    {
      localObject = Util.constrainMinSize(new Size((int)localCGSize.width, (int)localCGSize.height), paramInt1);
      localCGSize.width = ((Size)localObject).getWidth();
      localCGSize.height = ((Size)localObject).getHeight();
    }
    Logger.i(TAG, String.format("targetRenderSize = %d * %d", new Object[] { Integer.valueOf((int)localCGSize.width), Integer.valueOf((int)localCGSize.height) }));
    return localCGSize;
  }
  
  protected StickerController createStickerController()
  {
    Context localContext = this.context;
    Object localObject = this.sessionConfig;
    if (localObject != null) {
      localObject = ((SessionConfig)localObject).getStickerEditViewIconConfig();
    } else {
      localObject = null;
    }
    localObject = new StickerController(localContext, (StickerEditViewIconConfig)localObject);
    ((StickerController)localObject).setStickerOperationCallback(this);
    ((StickerController)localObject).setStickerStateCallback(this);
    ((StickerController)localObject).setStickerLyricCallback(this);
    return localObject;
  }
  
  public int getCurrentIndex()
  {
    return this.currentIndex;
  }
  
  protected String getMediaModelsMD5()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.mediaModels.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((MediaModel)localIterator.next()).toString());
    }
    return Util.md5(localStringBuilder.toString());
  }
  
  public List<String> getMediaModelsMd5()
  {
    return this.mediaModelsMD5;
  }
  
  public SessionConfig getSessionConfig()
  {
    return this.sessionConfig;
  }
  
  public int getStickerSizeByIndex(int paramInt)
  {
    Object localObject = this.mediaModels;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    localObject = (MediaModel)((List)localObject).get(paramInt);
    paramInt = i;
    if (localObject != null)
    {
      localObject = ((MediaModel)localObject).getMediaEffectModel();
      paramInt = i;
      if (((MediaEffectModel)localObject).getStickerModelList().size() > 0) {
        paramInt = ((MediaEffectModel)localObject).getStickerModelList().size();
      }
    }
    return paramInt;
  }
  
  public int getStickerTotalSize()
  {
    Object localObject = this.mediaModels;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < this.mediaModels.size(); j = k)
    {
      localObject = (MediaModel)this.mediaModels.get(i);
      k = j;
      if (localObject != null)
      {
        localObject = ((MediaModel)localObject).getMediaEffectModel();
        k = j;
        if (((MediaEffectModel)localObject).getStickerModelList().size() > 0) {
          k = j + ((MediaEffectModel)localObject).getStickerModelList().size();
        }
      }
      i += 1;
    }
    return j;
  }
  
  public int init(Context paramContext)
  {
    runTask(new TAVCutSession.2(this, paramContext));
    return 0;
  }
  
  public boolean isTavStickerSelected()
  {
    int i = 0;
    while (i < this.stickerControllers.size())
    {
      int j = this.stickerControllers.keyAt(i);
      if ((this.stickerControllers.get(j) != null) && (((StickerController)this.stickerControllers.get(j)).getCurrentSticker() != null)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean mediaChanged()
  {
    return this.initMediaModelsMD5.equals(getMediaModelsMD5()) ^ true;
  }
  
  public void onAddStickerDone(String paramString)
  {
    StickerOperationCallback localStickerOperationCallback = this.stickerOperationCallback;
    if (localStickerOperationCallback != null) {
      localStickerOperationCallback.onAddStickerDone(paramString);
    }
  }
  
  public void onDeleteButtonClick(String paramString)
  {
    runTask(new TAVCutSession.10(this, paramString));
    StickerOperationCallback localStickerOperationCallback = this.stickerOperationCallback;
    if (localStickerOperationCallback != null) {
      localStickerOperationCallback.onDeleteButtonClick(paramString);
    }
  }
  
  public void onDeleteSticker()
  {
    StickerLyricCallback localStickerLyricCallback = this.stickerLyricCallback;
    if (localStickerLyricCallback != null) {
      localStickerLyricCallback.onDeleteSticker();
    }
  }
  
  public void onPause()
  {
    StickerEventDispatcher.getInstance().removeStickerEventListener(this.stickerEventListener);
    SparseArray localSparseArray = this.stickerControllers;
    if ((localSparseArray != null) && (localSparseArray.size() > 0))
    {
      int i = 0;
      while (i < this.stickerControllers.size())
      {
        StickerEventDispatcher.getInstance().removeStickerEventListener((IStickerEventListener)this.stickerControllers.get(i));
        i += 1;
      }
    }
  }
  
  public void onResume()
  {
    StickerEventDispatcher.getInstance().addStickerEventListener(this.stickerEventListener);
  }
  
  public void onStatusChanged(boolean paramBoolean) {}
  
  public void onStickerActive() {}
  
  public void onStickerAdd(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    if ((paramTAVStickerEditView != null) && (paramTAVStickerEditView.getSticker() != null))
    {
      int k = -1;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.stickerControllers.size()) {
          break;
        }
        SparseArray localSparseArray = this.stickerControllers;
        if (((StickerController)localSparseArray.get(localSparseArray.keyAt(i))).getStickerContext() == paramTAVStickerContext)
        {
          j = this.stickerControllers.keyAt(i);
          break;
        }
        i += 1;
      }
      if (j >= 0) {
        addOrUpdateStickerData(paramTAVStickerEditView.getSticker(), j);
      }
    }
  }
  
  public void onStickerClick(TextEditorData paramTextEditorData)
  {
    StickerOperationCallback localStickerOperationCallback = this.stickerOperationCallback;
    if (localStickerOperationCallback != null) {
      localStickerOperationCallback.onStickerClick(paramTextEditorData);
    }
  }
  
  public void onStickerMoving(String paramString)
  {
    StickerOperationCallback localStickerOperationCallback = this.stickerOperationCallback;
    if (localStickerOperationCallback != null) {
      localStickerOperationCallback.onStickerMoving(paramString);
    }
  }
  
  public void onStickerOutsideClick()
  {
    StickerOperationCallback localStickerOperationCallback = this.stickerOperationCallback;
    if (localStickerOperationCallback != null) {
      localStickerOperationCallback.onStickerOutsideClick();
    }
  }
  
  public void onStickerResign(TAVSticker paramTAVSticker)
  {
    if (((paramTAVSticker instanceof WSLyricSticker)) && (((MediaModel)this.mediaModels.get(this.currentIndex)).getMediaEffectModel().getSubtitleModel() == null)) {
      ((MediaModel)this.mediaModels.get(this.currentIndex)).getMediaEffectModel().setSubtitleModel(WSLyricSticker.dumpToSubtitleModel(paramTAVSticker));
    }
  }
  
  public void onStickerSelect(TextEditorData paramTextEditorData)
  {
    StickerOperationCallback localStickerOperationCallback = this.stickerOperationCallback;
    if (localStickerOperationCallback != null) {
      localStickerOperationCallback.onStickerSelect(paramTextEditorData);
    }
  }
  
  public void onStickerTouchEnd(TextEditorData paramTextEditorData)
  {
    StickerOperationCallback localStickerOperationCallback = this.stickerOperationCallback;
    if (localStickerOperationCallback != null) {
      localStickerOperationCallback.onStickerTouchEnd(paramTextEditorData);
    }
  }
  
  public void onStickerTouchStart(TextEditorData paramTextEditorData)
  {
    StickerOperationCallback localStickerOperationCallback = this.stickerOperationCallback;
    if (localStickerOperationCallback != null) {
      localStickerOperationCallback.onStickerTouchStart(paramTextEditorData);
    }
  }
  
  public void onTextEditButtonClick(TextEditorData paramTextEditorData)
  {
    StickerOperationCallback localStickerOperationCallback = this.stickerOperationCallback;
    if (localStickerOperationCallback != null) {
      localStickerOperationCallback.onTextEditButtonClick(paramTextEditorData);
    }
  }
  
  public void onUpdateTextStickerDone(String paramString)
  {
    StickerOperationCallback localStickerOperationCallback = this.stickerOperationCallback;
    if (localStickerOperationCallback != null) {
      localStickerOperationCallback.onUpdateTextStickerDone(paramString);
    }
  }
  
  protected void recordInitMediaModelsMD5()
  {
    this.initMediaModelsMD5 = getMediaModelsMD5();
    Iterator localIterator = this.mediaModels.iterator();
    while (localIterator.hasNext())
    {
      MediaModel localMediaModel = (MediaModel)localIterator.next();
      this.mediaModelsMD5.add(Util.md5(localMediaModel.toString()));
    }
  }
  
  @CallSuper
  public void release()
  {
    runTask(new TAVCutSession.13(this));
  }
  
  void resetAEKitModel(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, float paramFloat1, String paramString1, float paramFloat2, Map<String, String> paramMap, String paramString2)
  {
    int i;
    if ((this instanceof TAVCutVideoSession)) {
      i = 2;
    } else {
      i = 1;
    }
    AEKitModel localAEKitModel = new AEKitModel(i);
    localAEKitModel.setEffectStrength(paramFloat1);
    localAEKitModel.setLutPath(paramString1);
    localAEKitModel.setGlowAlpha(paramFloat2);
    localAEKitModel.setAdjustParams(paramMap);
    localAEKitModel.setMaterial(paramString2);
    paramMediaModel.getMediaEffectModel().setAeKitModel(localAEKitModel);
    updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel(), false);
  }
  
  void resetAEKitModel(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, @Nullable String paramString, float paramFloat)
  {
    int i;
    if ((this instanceof TAVCutVideoSession)) {
      i = 2;
    } else {
      i = 1;
    }
    AEKitModel localAEKitModel = new AEKitModel(i);
    localAEKitModel.setLutPath(paramString);
    localAEKitModel.setLutAlpha(paramFloat);
    paramMediaModel.getMediaEffectModel().setAeKitModel(localAEKitModel);
    updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel(), false);
  }
  
  void resetAEKitModelForAI(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, @Nullable String paramString, float paramFloat1, HashMap<String, String> paramHashMap, int paramInt, float paramFloat2, long paramLong)
  {
    int i;
    if ((this instanceof TAVCutVideoSession)) {
      i = 2;
    } else {
      i = 1;
    }
    AEKitModel localAEKitModel = new AEKitModel(i);
    localAEKitModel.setAdjustParams(paramHashMap);
    localAEKitModel.setLutPath(paramString);
    localAEKitModel.setStartTime(0L);
    localAEKitModel.setSmoothLevel(paramInt);
    localAEKitModel.setLutAlpha(paramFloat1);
    localAEKitModel.setGlowAlpha(paramFloat2);
    localAEKitModel.setDuration(paramLong);
    paramMediaModel.getMediaEffectModel().setAeKitModel(localAEKitModel);
    updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel());
  }
  
  protected void runOnMainThread(Runnable paramRunnable)
  {
    runOnMainThread(paramRunnable, false);
  }
  
  protected void runOnMainThread(Runnable paramRunnable, boolean paramBoolean)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      Semaphore localSemaphore = new Semaphore(0);
      HandlerUtils.getMainHandler().post(new TAVCutSession.11(this, paramRunnable, localSemaphore));
      if (!paramBoolean) {
        return;
      }
      try
      {
        localSemaphore.acquire();
        return;
      }
      catch (InterruptedException paramRunnable)
      {
        paramRunnable.printStackTrace();
        return;
      }
    }
    paramRunnable.run();
  }
  
  protected void runTask(Runnable paramRunnable)
  {
    if (this.runAsync)
    {
      AsyncTask.SERIAL_EXECUTOR.execute(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  protected void setCrop(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, CropConfig paramCropConfig)
  {
    runTask(new TAVCutSession.3(this, paramCropConfig, paramMediaModel, paramVideoRenderChainManager));
  }
  
  public void setCurrentIndex(int paramInt)
  {
    runTask(new TAVCutSession.6(this, paramInt));
  }
  
  void setEffectStrength(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, float paramFloat)
  {
    AEKitModel localAEKitModel = paramMediaModel.getMediaEffectModel().getAeKitModel();
    if (localAEKitModel == null) {
      return;
    }
    localAEKitModel.setEffectStrength(paramFloat);
    updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel(), false);
  }
  
  @Deprecated
  void setMaterial(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, String paramString)
  {
    AEKitModel localAEKitModel2 = paramMediaModel.getMediaEffectModel().getAeKitModel();
    AEKitModel localAEKitModel1 = localAEKitModel2;
    if (localAEKitModel2 == null)
    {
      int i;
      if ((this instanceof TAVCutVideoSession)) {
        i = 2;
      } else {
        i = 1;
      }
      localAEKitModel1 = new AEKitModel(i);
    }
    localAEKitModel1.setMaterial(paramString);
    paramMediaModel.getMediaEffectModel().setAeKitModel(localAEKitModel1);
    updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel());
  }
  
  public void setSessionConfig(SessionConfig paramSessionConfig)
  {
    runTask(new TAVCutSession.1(this, paramSessionConfig));
  }
  
  public void setStickerLyricCallback(StickerLyricCallback paramStickerLyricCallback)
  {
    runTask(new TAVCutSession.14(this, paramStickerLyricCallback));
  }
  
  public void setStickerOperationCallback(StickerOperationCallback paramStickerOperationCallback)
  {
    runTask(new TAVCutSession.9(this, paramStickerOperationCallback));
  }
  
  void toggleAEKit(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, boolean paramBoolean)
  {
    AEKitModel localAEKitModel = paramMediaModel.getMediaEffectModel().getAeKitModel();
    if (localAEKitModel == null) {
      return;
    }
    localAEKitModel.setDisable(paramBoolean ^ true);
    updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel());
  }
  
  protected void updateRenderChain(VideoRenderChainManager paramVideoRenderChainManager, MediaEffectModel paramMediaEffectModel)
  {
    if (paramVideoRenderChainManager != null) {
      paramVideoRenderChainManager.updateRenderChain(paramMediaEffectModel, true);
    }
  }
  
  protected void updateRenderChain(VideoRenderChainManager paramVideoRenderChainManager, MediaEffectModel paramMediaEffectModel, boolean paramBoolean)
  {
    if (paramVideoRenderChainManager != null) {
      paramVideoRenderChainManager.updateRenderChain(paramMediaEffectModel, paramBoolean);
    }
  }
  
  public void updateTextSticker(TextEditorData paramTextEditorData)
  {
    runTask(new TAVCutSession.7(this, paramTextEditorData));
  }
  
  protected void waitAllTaskComplete()
  {
    if (!this.runAsync) {
      return;
    }
    Semaphore localSemaphore = new Semaphore(0);
    runTask(new TAVCutSession.12(this, localSemaphore));
    try
    {
      localSemaphore.acquire();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutSession
 * JD-Core Version:    0.7.0.1
 */