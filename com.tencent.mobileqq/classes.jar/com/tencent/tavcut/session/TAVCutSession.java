package com.tencent.tavcut.session;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.callback.StickerLyricCallback;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import com.tencent.tavcut.session.callback.StickerStateCallback;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.StickerUtil;
import com.tencent.tavcut.util.Util;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.editor.sticker.dispatcher.IStickerEventListener;
import com.tencent.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;
import com.tencent.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.weseevideo.editor.utils.HandlerUtils;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
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
  protected Context context;
  protected int currentIndex = 0;
  protected String initMediaModelsMD5 = "";
  protected List<MediaModel> mediaModels;
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
    for (;;)
    {
      if (i < localList.size())
      {
        if (((StickerModel)localList.get(i)).getUniqueId().equals(paramTAVSticker.getStickerId())) {
          localList.remove(i);
        }
      }
      else
      {
        if (!(paramTAVSticker instanceof WSLyricSticker)) {
          break;
        }
        paramTAVSticker = WSLyricSticker.dumpToSubtitleModel(paramTAVSticker);
        ((MediaModel)this.mediaModels.get(paramInt)).getMediaEffectModel().setSubtitleModel(paramTAVSticker);
        return;
      }
      i += 1;
    }
    paramTAVSticker = StickerUtil.tavSticker2StickerModel(paramTAVSticker);
    paramTAVSticker.setDuration((float)paramTAVSticker.getEndTime() - paramTAVSticker.getStartTime());
    localList.add(paramTAVSticker);
  }
  
  private void updateStickerModel(TAVSticker paramTAVSticker)
  {
    runTask(new TAVCutSession.7(this, paramTAVSticker));
  }
  
  protected void addSticker(@NonNull StickerController paramStickerController, @NonNull StickerModel paramStickerModel)
  {
    runTask(new TAVCutSession.4(this, paramStickerController, paramStickerModel));
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
    int i;
    Size localSize;
    if (this.sessionConfig != null)
    {
      i = this.sessionConfig.getMaxIntermediateRenderSize();
      if (i != -1)
      {
        localSize = Util.constrainMaxSize(new Size(paramInt1, paramInt2), i);
        localCGSize.width = localSize.getWidth();
        localCGSize.height = localSize.getHeight();
      }
      if (this.sessionConfig == null) {
        break label184;
      }
    }
    label184:
    for (paramInt1 = this.sessionConfig.getMinIntermediateRenderSize();; paramInt1 = -1)
    {
      if (paramInt1 != -1)
      {
        localSize = Util.constrainMinSize(new Size((int)localCGSize.width, (int)localCGSize.height), paramInt1);
        localCGSize.width = localSize.getWidth();
        localCGSize.height = localSize.getHeight();
      }
      Logger.i(TAG, String.format("targetRenderSize = %d * %d", new Object[] { Integer.valueOf((int)localCGSize.width), Integer.valueOf((int)localCGSize.height) }));
      return localCGSize;
      i = -1;
      break;
    }
  }
  
  protected StickerController createStickerController()
  {
    Context localContext = this.context;
    if (this.sessionConfig != null) {}
    for (Object localObject = this.sessionConfig.getStickerEditViewIconConfig();; localObject = null)
    {
      localObject = new StickerController(localContext, (StickerEditViewIconConfig)localObject);
      ((StickerController)localObject).setStickerOperationCallback(this);
      ((StickerController)localObject).setStickerStateCallback(this);
      ((StickerController)localObject).setStickerLyricCallback(this);
      return localObject;
    }
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
  
  public SessionConfig getSessionConfig()
  {
    return this.sessionConfig;
  }
  
  public int getStickerTotalSize()
  {
    if (this.mediaModels == null) {
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < this.mediaModels.size(); j = k)
    {
      Object localObject = (MediaModel)this.mediaModels.get(i);
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
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.stickerControllers.size())
      {
        int j = this.stickerControllers.keyAt(i);
        if ((this.stickerControllers.get(j) != null) && (((StickerController)this.stickerControllers.get(j)).getCurrentSticker() != null)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean mediaChanged()
  {
    return !this.initMediaModelsMD5.equals(getMediaModelsMD5());
  }
  
  public void onAddStickerDone(String paramString)
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onAddStickerDone(paramString);
    }
  }
  
  public void onDeleteButtonClick(String paramString)
  {
    runTask(new TAVCutSession.9(this, paramString));
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onDeleteButtonClick(paramString);
    }
  }
  
  public void onDeleteSticker()
  {
    if (this.stickerLyricCallback != null) {
      this.stickerLyricCallback.onDeleteSticker();
    }
  }
  
  public void onPause()
  {
    StickerEventDispatcher.getInstance().removeStickerEventListener(this.stickerEventListener);
    if ((this.stickerControllers != null) && (this.stickerControllers.size() > 0))
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
      i = 0;
      if (i >= this.stickerControllers.size()) {
        break label79;
      }
      if (((StickerController)this.stickerControllers.get(this.stickerControllers.keyAt(i))).getStickerContext() != paramTAVStickerContext) {
        break label72;
      }
    }
    label72:
    label79:
    for (int i = this.stickerControllers.keyAt(i);; i = -1)
    {
      if (i >= 0) {
        addOrUpdateStickerData(paramTAVStickerEditView.getSticker(), i);
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void onStickerClick(TextEditorData paramTextEditorData)
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onStickerClick(paramTextEditorData);
    }
  }
  
  public void onStickerMoving(String paramString)
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onStickerMoving(paramString);
    }
  }
  
  public void onStickerOutsideClick()
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onStickerOutsideClick();
    }
  }
  
  public void onStickerResign(TAVSticker paramTAVSticker)
  {
    if ((paramTAVSticker instanceof WSLyricSticker)) {
      if (((MediaModel)this.mediaModels.get(this.currentIndex)).getMediaEffectModel().getSubtitleModel() == null) {
        ((MediaModel)this.mediaModels.get(this.currentIndex)).getMediaEffectModel().setSubtitleModel(WSLyricSticker.dumpToSubtitleModel(paramTAVSticker));
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((MediaModel)this.mediaModels.get(this.currentIndex)).getMediaEffectModel().getStickerModelList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((StickerModel)localIterator.next()).getUniqueId().equals(paramTAVSticker.getStickerId()));
      for (int i = 1; i == 0; i = 0)
      {
        ((MediaModel)this.mediaModels.get(this.currentIndex)).getMediaEffectModel().getStickerModelList().add(StickerUtil.tavSticker2StickerModel(paramTAVSticker));
        return;
      }
    }
  }
  
  public void onStickerSelect(TextEditorData paramTextEditorData)
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onStickerSelect(paramTextEditorData);
    }
  }
  
  public void onStickerTouchEnd(TextEditorData paramTextEditorData)
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onStickerTouchEnd(paramTextEditorData);
    }
  }
  
  public void onStickerTouchStart(TextEditorData paramTextEditorData)
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onStickerTouchStart(paramTextEditorData);
    }
  }
  
  public void onTextEditButtonClick(TextEditorData paramTextEditorData)
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onTextEditButtonClick(paramTextEditorData);
    }
  }
  
  public void onUpdateTextStickerDone(String paramString)
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onUpdateTextStickerDone(paramString);
    }
  }
  
  protected void recordInitMediaModelsMD5()
  {
    this.initMediaModelsMD5 = getMediaModelsMD5();
  }
  
  @CallSuper
  public void release()
  {
    runTask(new TAVCutSession.12(this));
  }
  
  void resetAEKitModel(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, float paramFloat1, String paramString1, float paramFloat2, Map<String, String> paramMap, String paramString2)
  {
    if ((this instanceof TAVCutVideoSession)) {}
    for (int i = 2;; i = 1)
    {
      AEKitModel localAEKitModel = new AEKitModel(i);
      localAEKitModel.setEffectStrength(paramFloat1);
      localAEKitModel.setLutPath(paramString1);
      localAEKitModel.setGlowAlpha(paramFloat2);
      localAEKitModel.setAdjustParams(paramMap);
      localAEKitModel.setMaterial(paramString2);
      paramMediaModel.getMediaEffectModel().setAeKitModel(localAEKitModel);
      updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel());
      return;
    }
  }
  
  void resetAEKitModel(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, @Nullable String paramString, float paramFloat)
  {
    if ((this instanceof TAVCutVideoSession)) {}
    for (int i = 2;; i = 1)
    {
      AEKitModel localAEKitModel = new AEKitModel(i);
      localAEKitModel.setLutPath(paramString);
      localAEKitModel.setLutAlpha(paramFloat);
      paramMediaModel.getMediaEffectModel().setAeKitModel(localAEKitModel);
      updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel());
      return;
    }
  }
  
  void resetAEKitModelForAI(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, @Nullable String paramString, float paramFloat1, HashMap<String, String> paramHashMap, int paramInt, float paramFloat2, long paramLong)
  {
    if ((this instanceof TAVCutVideoSession)) {}
    for (int i = 2;; i = 1)
    {
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
      return;
    }
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
      HandlerUtils.getMainHandler().post(new TAVCutSession.10(this, paramRunnable, localSemaphore));
      if (paramBoolean) {}
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
    runTask(new TAVCutSession.5(this, paramInt));
  }
  
  void setEffectStrength(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, float paramFloat)
  {
    AEKitModel localAEKitModel = paramMediaModel.getMediaEffectModel().getAeKitModel();
    if (localAEKitModel == null) {
      return;
    }
    localAEKitModel.setEffectStrength(paramFloat);
    updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel());
  }
  
  @Deprecated
  void setMaterial(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, String paramString)
  {
    AEKitModel localAEKitModel2 = paramMediaModel.getMediaEffectModel().getAeKitModel();
    AEKitModel localAEKitModel1 = localAEKitModel2;
    if (localAEKitModel2 == null) {
      if (!(this instanceof TAVCutVideoSession)) {
        break label64;
      }
    }
    label64:
    for (int i = 2;; i = 1)
    {
      localAEKitModel1 = new AEKitModel(i);
      localAEKitModel1.setMaterial(paramString);
      paramMediaModel.getMediaEffectModel().setAeKitModel(localAEKitModel1);
      updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel());
      return;
    }
  }
  
  public void setSessionConfig(SessionConfig paramSessionConfig)
  {
    runTask(new TAVCutSession.1(this, paramSessionConfig));
  }
  
  public void setStickerLyricCallback(StickerLyricCallback paramStickerLyricCallback)
  {
    runTask(new TAVCutSession.13(this, paramStickerLyricCallback));
  }
  
  public void setStickerOperationCallback(StickerOperationCallback paramStickerOperationCallback)
  {
    runTask(new TAVCutSession.8(this, paramStickerOperationCallback));
  }
  
  void toggleAEKit(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, boolean paramBoolean)
  {
    AEKitModel localAEKitModel = paramMediaModel.getMediaEffectModel().getAeKitModel();
    if (localAEKitModel == null) {
      return;
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAEKitModel.setDisable(paramBoolean);
      updateRenderChain(paramVideoRenderChainManager, paramMediaModel.getMediaEffectModel());
      return;
    }
  }
  
  protected void updateRenderChain(VideoRenderChainManager paramVideoRenderChainManager, MediaEffectModel paramMediaEffectModel)
  {
    if (paramVideoRenderChainManager != null) {
      paramVideoRenderChainManager.updateRenderChain(paramMediaEffectModel);
    }
  }
  
  public void updateTextSticker(TextEditorData paramTextEditorData)
  {
    runTask(new TAVCutSession.6(this, paramTextEditorData));
  }
  
  protected void waitAllTaskComplete()
  {
    if (!this.runAsync) {
      return;
    }
    Semaphore localSemaphore = new Semaphore(0);
    runTask(new TAVCutSession.11(this, localSemaphore));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession
 * JD-Core Version:    0.7.0.1
 */