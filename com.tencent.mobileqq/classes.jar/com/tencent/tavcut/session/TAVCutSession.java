package com.tencent.tavcut.session;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.bean.TextEditorData;
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
import com.tencent.weseevideo.editor.utils.HandlerUtils;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

public abstract class TAVCutSession
  implements Session, StickerOperationCallback, StickerStateCallback
{
  private static final String TAG = TAVCutImageSession.class.getSimpleName();
  protected Context context;
  protected int currentIndex = 0;
  protected Handler handler;
  protected String initMediaModelsMD5 = "";
  protected List<MediaModel> mediaModels;
  protected SparseArray<VideoRenderChainManager> renderChainManagers = new SparseArray();
  protected boolean runAsync = false;
  protected SessionConfig sessionConfig;
  protected SparseArray<StickerController> stickerControllers = new SparseArray();
  protected IStickerEventListener stickerEventListener;
  protected StickerOperationCallback stickerOperationCallback;
  protected SparseArray<TAVComposition> tavCompositions = new SparseArray();
  
  private void addOrUpdateStickerData(TAVSticker paramTAVSticker)
  {
    addOrUpdateStickerData(paramTAVSticker, this.currentIndex);
  }
  
  private void addOrUpdateStickerData(TAVSticker paramTAVSticker, int paramInt)
  {
    List localList = ((MediaModel)this.mediaModels.get(paramInt)).getMediaEffectModel().getStickerModelList();
    paramInt = 0;
    for (;;)
    {
      if (paramInt < localList.size())
      {
        if (((StickerModel)localList.get(paramInt)).getStickerId().equals(paramTAVSticker.getStickerId())) {
          localList.remove(paramInt);
        }
      }
      else
      {
        paramTAVSticker = StickerUtil.tavSticker2StickerModel(paramTAVSticker);
        paramTAVSticker.setDuration((float)paramTAVSticker.getEndTime() - paramTAVSticker.getStartTime());
        localList.add(paramTAVSticker);
        return;
      }
      paramInt += 1;
    }
  }
  
  private void updateStickerModel(TAVSticker paramTAVSticker)
  {
    runTask(new TAVCutSession.17(this, paramTAVSticker));
  }
  
  protected void addSticker(@NonNull StickerController paramStickerController, @NonNull StickerModel paramStickerModel)
  {
    runTask(new TAVCutSession.14(this, paramStickerController, paramStickerModel));
  }
  
  protected void applyCurrentSticker(StickerController paramStickerController)
  {
    TAVSticker localTAVSticker = paramStickerController.getCurrentSticker();
    if (localTAVSticker != null)
    {
      paramStickerController.resignCurrentSticker();
      onStickerResign(localTAVSticker);
    }
  }
  
  protected void constrainRenderSize(int paramInt1, int paramInt2, VideoRenderChainManager paramVideoRenderChainManager)
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
        break label195;
      }
    }
    label195:
    for (paramInt1 = this.sessionConfig.getMinIntermediateRenderSize();; paramInt1 = -1)
    {
      if (paramInt1 != -1)
      {
        localSize = Util.constrainMinSize(new Size((int)localCGSize.width, (int)localCGSize.height), paramInt1);
        localCGSize.width = localSize.getWidth();
        localCGSize.height = localSize.getHeight();
      }
      Logger.i(TAG, String.format("targetRenderSize = %d * %d", new Object[] { Integer.valueOf((int)localCGSize.width), Integer.valueOf((int)localCGSize.height) }));
      paramVideoRenderChainManager.getComposition().setRenderSize(localCGSize);
      return;
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
  
  public void init(Context paramContext)
  {
    runTask(new TAVCutSession.2(this, paramContext));
  }
  
  public boolean mediaChanged()
  {
    return !this.initMediaModelsMD5.equals(getMediaModelsMD5());
  }
  
  public void onDeleteButtonClick(String paramString)
  {
    runTask(new TAVCutSession.19(this, paramString));
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onDeleteButtonClick(paramString);
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
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
  
  public void onStickerResign(TAVSticker paramTAVSticker)
  {
    Iterator localIterator = ((MediaModel)this.mediaModels.get(this.currentIndex)).getMediaEffectModel().getStickerModelList().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((StickerModel)localIterator.next()).getStickerId().equals(paramTAVSticker.getStickerId()));
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((MediaModel)this.mediaModels.get(this.currentIndex)).getMediaEffectModel().getStickerModelList().add(StickerUtil.tavSticker2StickerModel(paramTAVSticker));
      }
      return;
    }
  }
  
  public void onStickerTouchEnd(String paramString)
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onStickerTouchEnd(paramString);
    }
  }
  
  public void onStickerTouchStart(String paramString)
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onStickerTouchStart(paramString);
    }
  }
  
  public void onTextEditButtonClick(TextEditorData paramTextEditorData)
  {
    if (this.stickerOperationCallback != null) {
      this.stickerOperationCallback.onTextEditButtonClick(paramTextEditorData);
    }
  }
  
  protected void recordInitMediaModelsMD5()
  {
    this.initMediaModelsMD5 = getMediaModelsMD5();
  }
  
  @CallSuper
  public void release()
  {
    runTask(new TAVCutSession.22(this));
  }
  
  protected void removeAEKit(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager)
  {
    runTask(new TAVCutSession.11(this, paramMediaModel, paramVideoRenderChainManager));
  }
  
  protected void removeAIFilter(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager)
  {
    runTask(new TAVCutSession.9(this, paramMediaModel, paramVideoRenderChainManager));
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
      HandlerUtils.getMainHandler().post(new TAVCutSession.20(this, paramRunnable, localSemaphore));
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
      if (this.handler == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("TAVCutSessionHT");
        localHandlerThread.start();
        this.handler = new Handler(localHandlerThread.getLooper());
      }
      this.handler.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  protected void setAEKit(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, float[] paramArrayOfFloat, long paramLong1, long paramLong2)
  {
    runTask(new TAVCutSession.10(this, paramLong1, paramLong2, paramMediaModel, paramVideoRenderChainManager));
  }
  
  protected void setAEKitAIFilter(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, @Nullable String paramString, float paramFloat1, HashMap<String, String> paramHashMap, int paramInt, float paramFloat2, long paramLong1, long paramLong2)
  {
    runTask(new TAVCutSession.6(this, paramMediaModel, paramHashMap, paramString, paramLong1, paramInt, paramFloat1, paramFloat2, paramLong2, paramVideoRenderChainManager));
  }
  
  protected void setAIFilter(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, HashMap<String, String> paramHashMap, long paramLong1, long paramLong2)
  {
    runTask(new TAVCutSession.5(this, paramMediaModel, paramHashMap, paramLong1, paramLong2, paramVideoRenderChainManager));
  }
  
  protected void setAIFilterAlpha(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, float paramFloat, long paramLong1, long paramLong2)
  {
    runTask(new TAVCutSession.8(this, paramMediaModel, paramFloat, paramLong1, paramLong2, paramVideoRenderChainManager));
  }
  
  protected void setCrop(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, CropConfig paramCropConfig)
  {
    runTask(new TAVCutSession.13(this, paramCropConfig, paramMediaModel, paramVideoRenderChainManager));
  }
  
  public void setCurrentIndex(int paramInt)
  {
    runTask(new TAVCutSession.15(this, paramInt));
  }
  
  protected void setGlowAlpha(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, float paramFloat, long paramLong1, long paramLong2)
  {
    runTask(new TAVCutSession.7(this, paramMediaModel, paramFloat, paramLong1, paramLong2, paramVideoRenderChainManager));
  }
  
  protected void setLutAlpha(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, float paramFloat)
  {
    runTask(new TAVCutSession.12(this, paramMediaModel, paramFloat, paramVideoRenderChainManager));
  }
  
  protected void setLutImage(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, @Nullable String paramString, long paramLong1, long paramLong2)
  {
    runTask(new TAVCutSession.3(this, paramMediaModel, paramString, paramLong1, paramLong2, paramVideoRenderChainManager));
  }
  
  protected void setLutImageAndAlpha(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager paramVideoRenderChainManager, @Nullable String paramString, float paramFloat, long paramLong1, long paramLong2)
  {
    runTask(new TAVCutSession.4(this, paramMediaModel, paramString, paramFloat, paramLong1, paramLong2, paramVideoRenderChainManager));
  }
  
  public void setSessionConfig(SessionConfig paramSessionConfig)
  {
    runTask(new TAVCutSession.1(this, paramSessionConfig));
  }
  
  public void setStickerOperationCallback(StickerOperationCallback paramStickerOperationCallback)
  {
    runTask(new TAVCutSession.18(this, paramStickerOperationCallback));
  }
  
  protected void updateRenderChain(VideoRenderChainManager paramVideoRenderChainManager, MediaEffectModel paramMediaEffectModel)
  {
    if (paramVideoRenderChainManager != null) {
      paramVideoRenderChainManager.updateRenderChain(paramMediaEffectModel);
    }
  }
  
  public void updateTextSticker(TextEditorData paramTextEditorData)
  {
    runTask(new TAVCutSession.16(this, paramTextEditorData));
  }
  
  protected void waitAllTaskComplete()
  {
    if (!this.runAsync) {
      return;
    }
    Semaphore localSemaphore = new Semaphore(0);
    runTask(new TAVCutSession.21(this, localSemaphore));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession
 * JD-Core Version:    0.7.0.1
 */