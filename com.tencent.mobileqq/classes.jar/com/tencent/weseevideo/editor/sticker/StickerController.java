package com.tencent.weseevideo.editor.sticker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.ViewGroup;
import com.tencent.tavcut.session.callback.StickerLyricCallback;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import com.tencent.tavcut.session.callback.StickerStateCallback;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.StickerUtil;
import com.tencent.tavsticker.core.ITAVStickerContextObserver;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.composition.effectnode.VideoEffectType;
import com.tencent.weseevideo.composition.effectnode.WSOverLayBlurManager;
import com.tencent.weseevideo.composition.effectnode.WSOverLayBlurManager.SourceImageObserver;
import com.tencent.weseevideo.editor.sticker.dispatcher.IStickerEventListener;
import com.tencent.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;
import com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.weseevideo.editor.sticker.view.WsStickerContentView;
import com.tencent.weseevideo.editor.sticker.view.WsStickerEditView;
import com.tencent.weseevideo.editor.utils.HandlerUtils;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.jetbrains.annotations.Nullable;

public class StickerController
  implements ITAVStickerContextObserver, VideoRenderChainManager.IStickerContextInterface, IStickerEventListener
{
  private static final String TAG = StickerController.class.getSimpleName();
  private Context ctx;
  private int dataChangedCount = 0;
  private TAVStickerOperationMode operationMode = TAVStickerOperationMode.OP_NONE;
  private Set<TAVStickerOperationMode> operations;
  private WsStickerContentView stickerContentView;
  private TAVStickerContext stickerContext;
  private StickerEditViewIconConfig stickerEditViewIconConfig;
  private StickerLyricCallback stickerLyricCallback;
  private StickerOperationCallback stickerOperationCallback;
  private StickerStateCallback stickerStateCallback;
  
  public StickerController(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StickerController(Context paramContext, @Nullable StickerEditViewIconConfig paramStickerEditViewIconConfig)
  {
    this.ctx = paramContext;
    this.stickerEditViewIconConfig = paramStickerEditViewIconConfig;
    this.stickerContentView = new WsStickerContentView(paramContext);
    init();
  }
  
  private Pair<Float, Float> calcStickerCenterPosition(float paramFloat1, float paramFloat2)
  {
    Pair localPair = new Pair(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2));
    if ((this.stickerContext == null) || (this.stickerContext.getStickers() == null)) {
      localObject = localPair;
    }
    Iterator localIterator;
    do
    {
      return localObject;
      localIterator = this.stickerContext.getStickers().iterator();
      localObject = localPair;
    } while (!localIterator.hasNext());
    Object localObject = (TAVSticker)localIterator.next();
    if ((Math.abs(((TAVSticker)localObject).getCenterX() - ((Float)localPair.first).floatValue()) < 0.01F) && (Math.abs(((TAVSticker)localObject).getCenterY() - ((Float)localPair.second).floatValue()) < 0.01F)) {
      localPair = new Pair(Float.valueOf(((Float)localPair.first).floatValue() + 0.02F), Float.valueOf(((Float)localPair.second).floatValue() + 0.02F));
    }
    for (;;)
    {
      break;
    }
  }
  
  private void configure(TAVStickerContext paramTAVStickerContext)
  {
    paramTAVStickerContext.setTavStickerContentView(this.stickerContentView);
    paramTAVStickerContext.setTavStickerContextDataSource(new StickerController.1(this));
    paramTAVStickerContext.setOnTouchStickerOutsideListener(new StickerController.2(this, paramTAVStickerContext));
    paramTAVStickerContext.registerObserver(this);
  }
  
  private void deleteSticker(TAVStickerContext paramTAVStickerContext, TAVSticker paramTAVSticker)
  {
    if (paramTAVStickerContext == null) {
      return;
    }
    paramTAVStickerContext.removeSticker(paramTAVSticker);
  }
  
  private List<TAVSticker> findStickerByType(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (getStickerContext() == null) {
      return localArrayList;
    }
    synchronized (getStickerContext().getStickers())
    {
      if (getStickerContext().getStickers() == null) {
        return localArrayList;
      }
      Iterator localIterator = getStickerContext().getStickers().iterator();
      while (localIterator.hasNext())
      {
        TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
        if ((localTAVSticker != null) && (paramInt == VideoEffectType.TYPE_SUBTITLE.value) && ("sticker_lyric".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
          localArrayList.add(localTAVSticker);
        }
      }
    }
    return localList1;
  }
  
  private void init()
  {
    this.operations = new HashSet();
    this.operations.add(TAVStickerOperationMode.OP_DRAG);
    this.operations.add(TAVStickerOperationMode.OP_DOUBLE_ZOOM_ROTATE);
    this.operations.add(TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE);
    StickerEventDispatcher.getInstance().addStickerEventListener(this);
  }
  
  public void addSticker(TAVSticker paramTAVSticker)
  {
    Pair localPair = calcStickerCenterPosition(paramTAVSticker.getCenterX(), paramTAVSticker.getCenterY());
    paramTAVSticker.setCenterX(((Float)localPair.first).floatValue());
    paramTAVSticker.setCenterY(((Float)localPair.second).floatValue());
    HandlerUtils.getMainHandler().post(new StickerController.4(this, paramTAVSticker));
  }
  
  public void alignStickers(long paramLong) {}
  
  public TAVStickerContext createStickerContext()
  {
    if (this.stickerContext != null) {
      return this.stickerContext;
    }
    WsStickerContext localWsStickerContext = new WsStickerContext(this.ctx);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      configure(localWsStickerContext);
      this.stickerContext = localWsStickerContext;
      return localWsStickerContext;
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    HandlerUtils.getMainHandler().post(new StickerController.5(this, localWsStickerContext, localCountDownLatch));
    try
    {
      localCountDownLatch.await();
      return localWsStickerContext;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return localWsStickerContext;
    }
    finally
    {
      localCountDownLatch.countDown();
    }
  }
  
  public void deleteLyricSticker()
  {
    HandlerUtils.getMainHandler().post(new StickerController.3(this));
  }
  
  public void destroy()
  {
    releaseStickerContext();
    StickerEventDispatcher.getInstance().removeStickerEventListener(this);
  }
  
  public Context getCtx()
  {
    return this.ctx;
  }
  
  public TAVSticker getCurrentSticker()
  {
    if (this.stickerContext == null) {
      return null;
    }
    return this.stickerContext.getCurrentSticker();
  }
  
  public TAVStickerContext getStickerContext()
  {
    return this.stickerContext;
  }
  
  public void onCurrentStickerStateChanged(TAVStickerContext paramTAVStickerContext, boolean paramBoolean)
  {
    TLog.d(TAG, "onCurrentStickerStateChanged -> isActive : $isActive");
  }
  
  public void onStickerActive(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    TLog.d(TAG, "onStickerActive");
    if (this.stickerStateCallback != null) {
      this.stickerStateCallback.onStickerActive();
    }
    if ((paramTAVStickerEditView instanceof WSOverLayBlurManager.SourceImageObserver)) {
      WSOverLayBlurManager.registerSourceImageObserver(paramTAVStickerContext, paramTAVStickerEditView.getSticker().getUniqueId(), (WSOverLayBlurManager.SourceImageObserver)paramTAVStickerEditView);
    }
  }
  
  public void onStickerAdd(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    TLog.d(TAG, "onStickerAdd");
    if (this.stickerStateCallback != null) {
      this.stickerStateCallback.onStickerAdd(paramTAVStickerContext, paramTAVStickerEditView);
    }
  }
  
  public void onStickerDataChanged(TAVSticker paramTAVSticker, TAVStickerOperationMode paramTAVStickerOperationMode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    TLog.d(TAG, "onStickerDataChanged -> operationMode : $operationMode, centerX : $centerX, cneterY : $centerY, scale : $scale, rotate : $rotate");
    if ((this.dataChangedCount == 0) && (this.operations.contains(paramTAVStickerOperationMode)))
    {
      HandlerUtils.getMainHandler().postDelayed(new StickerController.6(this), 10L);
      this.dataChangedCount += 1;
    }
    this.operationMode = paramTAVStickerOperationMode;
  }
  
  public void onStickerListChanged(TAVStickerContext paramTAVStickerContext)
  {
    TLog.d(TAG, "onStickerListChanged");
  }
  
  public void onStickerRemove(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    TLog.d(TAG, "onStickerRemove");
    if (paramTAVStickerEditView != null) {
      WSOverLayBlurManager.unregisterSourceImageObserver(paramTAVStickerContext, paramTAVStickerEditView.getSticker().getUniqueId());
    }
  }
  
  public void onStickerResign(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    TLog.d(TAG, "onStickerResign");
    WSOverLayBlurManager.unregisterSourceImageObserver(paramTAVStickerContext, paramTAVStickerEditView.getSticker().getUniqueId());
  }
  
  public void onStickerStatusChanged(TAVSticker paramTAVSticker, boolean paramBoolean1, boolean paramBoolean2)
  {
    TLog.d(TAG, "onStickerStatusChanged");
    if ((!paramBoolean1) && (this.dataChangedCount > 0) && (this.operations.contains(this.operationMode)) && (this.stickerStateCallback != null)) {
      this.stickerStateCallback.onStatusChanged(false);
    }
    this.dataChangedCount = 0;
  }
  
  public void releaseStickerContext()
  {
    if (this.stickerContext != null)
    {
      this.stickerContext.unRegisterObserver(this);
      this.stickerContext.release();
    }
    this.stickerContext = null;
  }
  
  public void resignCurrentSticker()
  {
    if (this.stickerContext != null) {
      this.stickerContext.resignCurrentSticker();
    }
  }
  
  public void restoreSticker(List<StickerModel> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StickerModel localStickerModel = (StickerModel)paramList.next();
      if (this.stickerContext != null) {
        this.stickerContext.loadSticker(StickerUtil.stickerModel2TavSticker(localStickerModel), false);
      }
    }
  }
  
  public SubtitleModel saveLyricSticker()
  {
    Object localObject2 = null;
    Object localObject3 = findStickerByType(VideoEffectType.TYPE_SUBTITLE.value);
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      localObject1 = localObject2;
      if (((Iterator)localObject3).hasNext()) {
        localObject1 = WSLyricSticker.dumpToSubtitleModel((TAVSticker)((Iterator)localObject3).next());
      }
    }
    return localObject1;
  }
  
  public void setLyricProcess(long paramLong)
  {
    if ((this.stickerContentView != null) && (this.stickerContentView.getStickerEditView() != null))
    {
      TAVSticker localTAVSticker = this.stickerContentView.getStickerEditView().getSticker();
      if ((this.stickerContentView.getStickerEditView().getMode() == TAVStickerMode.ACTIVE) && (this.stickerContentView.getStickerEditView().getVisibility() == 0) && (localTAVSticker != null))
      {
        double d = localTAVSticker.computeProgress(paramLong);
        this.stickerContentView.getStickerEditView().setProgress(d);
        this.stickerContentView.getStickerEditView().flush();
      }
    }
  }
  
  public void setLyricStartTime(int paramInt)
  {
    if ((this.stickerContentView != null) && (this.stickerContentView.getStickerEditView() != null))
    {
      TAVSticker localTAVSticker = this.stickerContentView.getStickerEditView().getSticker();
      if (("sticker_lyric".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker))) && (this.stickerContentView.getStickerEditView().getVisibility() == 0) && (localTAVSticker != null) && ((localTAVSticker instanceof WSLyricSticker))) {
        ((WSLyricSticker)localTAVSticker).updateMusicStartTime(paramInt);
      }
    }
  }
  
  public void setStickerContainer(ViewGroup paramViewGroup)
  {
    paramViewGroup.removeView(this.stickerContentView);
    if (this.stickerContext != null) {
      this.stickerContext.setStickerContainer(paramViewGroup);
    }
  }
  
  public void setStickerLyricCallback(StickerLyricCallback paramStickerLyricCallback)
  {
    this.stickerLyricCallback = paramStickerLyricCallback;
  }
  
  public void setStickerOperationCallback(StickerOperationCallback paramStickerOperationCallback)
  {
    this.stickerOperationCallback = paramStickerOperationCallback;
  }
  
  public void setStickerStateCallback(StickerStateCallback paramStickerStateCallback)
  {
    this.stickerStateCallback = paramStickerStateCallback;
  }
  
  public void setStickerTouchEnable(boolean paramBoolean)
  {
    if (this.stickerContext != null) {
      this.stickerContext.setTouchable(paramBoolean);
    }
  }
  
  /* Error */
  public TAVSticker updateTextSticker(com.tencent.tavcut.bean.TextEditorData paramTextEditorData)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 107	com/tencent/weseevideo/editor/sticker/StickerController:stickerContext	Lcom/tencent/tavsticker/core/TAVStickerContext;
    //   4: invokevirtual 136	com/tencent/tavsticker/core/TAVStickerContext:getStickers	()Ljava/util/List;
    //   7: invokeinterface 142 1 0
    //   12: astore_3
    //   13: aload_3
    //   14: invokeinterface 148 1 0
    //   19: ifeq +355 -> 374
    //   22: aload_3
    //   23: invokeinterface 152 1 0
    //   28: checkcast 154	com/tencent/tavsticker/model/TAVSticker
    //   31: astore_2
    //   32: aload_2
    //   33: invokevirtual 524	com/tencent/tavsticker/model/TAVSticker:getStickerId	()Ljava/lang/String;
    //   36: aload_1
    //   37: invokevirtual 529	com/tencent/tavcut/bean/TextEditorData:getUniqueID	()Ljava/lang/String;
    //   40: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifeq -30 -> 13
    //   46: aload_0
    //   47: getfield 107	com/tencent/weseevideo/editor/sticker/StickerController:stickerContext	Lcom/tencent/tavsticker/core/TAVStickerContext;
    //   50: aload_2
    //   51: invokevirtual 210	com/tencent/tavsticker/core/TAVStickerContext:removeSticker	(Lcom/tencent/tavsticker/model/TAVSticker;)Z
    //   54: pop
    //   55: new 154	com/tencent/tavsticker/model/TAVSticker
    //   58: dup
    //   59: invokespecial 530	com/tencent/tavsticker/model/TAVSticker:<init>	()V
    //   62: astore_3
    //   63: aload_3
    //   64: aload_1
    //   65: invokevirtual 529	com/tencent/tavcut/bean/TextEditorData:getUniqueID	()Ljava/lang/String;
    //   68: invokevirtual 534	com/tencent/tavsticker/model/TAVSticker:setStickerId	(Ljava/lang/String;)Lcom/tencent/tavsticker/model/TAVSticker;
    //   71: pop
    //   72: aload_3
    //   73: aload_1
    //   74: invokevirtual 537	com/tencent/tavcut/bean/TextEditorData:getItemID	()Ljava/lang/String;
    //   77: invokevirtual 540	com/tencent/tavsticker/model/TAVSticker:setExtras	(Ljava/lang/String;)Lcom/tencent/tavsticker/model/TAVSticker;
    //   80: pop
    //   81: aload_1
    //   82: invokevirtual 543	com/tencent/tavcut/bean/TextEditorData:getPagFilePath	()Ljava/lang/String;
    //   85: invokestatic 549	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +288 -> 376
    //   91: aload_3
    //   92: aload_1
    //   93: invokevirtual 543	com/tencent/tavcut/bean/TextEditorData:getPagFilePath	()Ljava/lang/String;
    //   96: invokevirtual 552	com/tencent/tavsticker/model/TAVSticker:setFilePath	(Ljava/lang/String;)Lcom/tencent/tavsticker/model/TAVSticker;
    //   99: pop
    //   100: aload_3
    //   101: aconst_null
    //   102: invokevirtual 555	com/tencent/tavsticker/model/TAVSticker:setAssetFilePath	(Ljava/lang/String;)Lcom/tencent/tavsticker/model/TAVSticker;
    //   105: pop
    //   106: aload_3
    //   107: aload_2
    //   108: invokevirtual 558	com/tencent/tavsticker/model/TAVSticker:getLayerIndex	()I
    //   111: invokevirtual 562	com/tencent/tavsticker/model/TAVSticker:setLayerIndex	(I)Lcom/tencent/tavsticker/model/TAVSticker;
    //   114: pop
    //   115: aload_3
    //   116: aload_2
    //   117: invokevirtual 565	com/tencent/tavsticker/model/TAVSticker:getScale	()F
    //   120: invokevirtual 568	com/tencent/tavsticker/model/TAVSticker:setScale	(F)Lcom/tencent/tavsticker/model/TAVSticker;
    //   123: pop
    //   124: aload_3
    //   125: aload_2
    //   126: invokevirtual 571	com/tencent/tavsticker/model/TAVSticker:getRotate	()F
    //   129: invokevirtual 574	com/tencent/tavsticker/model/TAVSticker:setRotate	(F)Lcom/tencent/tavsticker/model/TAVSticker;
    //   132: pop
    //   133: aload_3
    //   134: aload_2
    //   135: invokevirtual 158	com/tencent/tavsticker/model/TAVSticker:getCenterX	()F
    //   138: invokevirtual 279	com/tencent/tavsticker/model/TAVSticker:setCenterX	(F)Lcom/tencent/tavsticker/model/TAVSticker;
    //   141: pop
    //   142: aload_3
    //   143: aload_2
    //   144: invokevirtual 175	com/tencent/tavsticker/model/TAVSticker:getCenterY	()F
    //   147: invokevirtual 282	com/tencent/tavsticker/model/TAVSticker:setCenterY	(F)Lcom/tencent/tavsticker/model/TAVSticker;
    //   150: pop
    //   151: aload_3
    //   152: aload_2
    //   153: invokevirtual 577	com/tencent/tavsticker/model/TAVSticker:isEditable	()Z
    //   156: invokevirtual 581	com/tencent/tavsticker/model/TAVSticker:setEditable	(Z)Lcom/tencent/tavsticker/model/TAVSticker;
    //   159: pop
    //   160: aload_3
    //   161: aload_2
    //   162: invokevirtual 584	com/tencent/tavsticker/model/TAVSticker:getMinScale	()F
    //   165: invokevirtual 587	com/tencent/tavsticker/model/TAVSticker:setMinScale	(F)Lcom/tencent/tavsticker/model/TAVSticker;
    //   168: pop
    //   169: aload_3
    //   170: aload_2
    //   171: invokevirtual 590	com/tencent/tavsticker/model/TAVSticker:getMaxScale	()F
    //   174: invokevirtual 593	com/tencent/tavsticker/model/TAVSticker:setMaxScale	(F)Lcom/tencent/tavsticker/model/TAVSticker;
    //   177: pop
    //   178: aload_3
    //   179: aload_2
    //   180: invokevirtual 597	com/tencent/tavsticker/model/TAVSticker:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   183: invokevirtual 601	com/tencent/tavsticker/model/TAVSticker:setTimeRange	(Lcom/tencent/tav/coremedia/CMTimeRange;)Lcom/tencent/tavsticker/model/TAVSticker;
    //   186: pop
    //   187: aload_3
    //   188: aload_1
    //   189: invokevirtual 604	com/tencent/tavcut/bean/TextEditorData:getInteractive	()Ljava/lang/String;
    //   192: invokestatic 610	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   195: invokestatic 614	com/tencent/weseevideo/editor/sticker/model/TAVStickerExKt:setStickerInteractive	(Lcom/tencent/tavsticker/model/TAVSticker;I)V
    //   198: aload_1
    //   199: invokevirtual 617	com/tencent/tavcut/bean/TextEditorData:getStickerType	()Ljava/lang/String;
    //   202: ifnull +72 -> 274
    //   205: aload_1
    //   206: invokevirtual 617	com/tencent/tavcut/bean/TextEditorData:getStickerType	()Ljava/lang/String;
    //   209: ldc_w 619
    //   212: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +59 -> 274
    //   218: aload_3
    //   219: aload_1
    //   220: invokevirtual 617	com/tencent/tavcut/bean/TextEditorData:getStickerType	()Ljava/lang/String;
    //   223: invokestatic 623	com/tencent/weseevideo/editor/sticker/model/TAVStickerExKt:setExtraStickerType	(Lcom/tencent/tavsticker/model/TAVSticker;Ljava/lang/String;)V
    //   226: aload_3
    //   227: iconst_0
    //   228: invokestatic 626	com/tencent/weseevideo/editor/sticker/model/TAVStickerExKt:setStickerLockRatio	(Lcom/tencent/tavsticker/model/TAVSticker;Z)V
    //   231: aload_3
    //   232: iconst_0
    //   233: invokestatic 629	com/tencent/weseevideo/editor/sticker/model/TAVStickerExKt:setStickerEnableRotate	(Lcom/tencent/tavsticker/model/TAVSticker;Z)V
    //   236: aload_3
    //   237: aload_2
    //   238: invokevirtual 565	com/tencent/tavsticker/model/TAVSticker:getScale	()F
    //   241: invokestatic 633	com/tencent/weseevideo/editor/sticker/model/TAVStickerExKt:setStickerScaleX	(Lcom/tencent/tavsticker/model/TAVSticker;F)V
    //   244: aload_3
    //   245: aload_2
    //   246: invokevirtual 565	com/tencent/tavsticker/model/TAVSticker:getScale	()F
    //   249: invokestatic 636	com/tencent/weseevideo/editor/sticker/model/TAVStickerExKt:setStickerScaleY	(Lcom/tencent/tavsticker/model/TAVSticker;F)V
    //   252: aload_3
    //   253: aload_1
    //   254: invokevirtual 639	com/tencent/tavcut/bean/TextEditorData:getBlurTextPath	()Ljava/lang/String;
    //   257: invokestatic 642	com/tencent/weseevideo/editor/sticker/model/TAVStickerExKt:setStickerTextPngPath	(Lcom/tencent/tavsticker/model/TAVSticker;Ljava/lang/String;)V
    //   260: aload_3
    //   261: aload_1
    //   262: invokevirtual 645	com/tencent/tavcut/bean/TextEditorData:getBlurTexturePath	()Ljava/lang/String;
    //   265: invokestatic 648	com/tencent/weseevideo/editor/sticker/model/TAVStickerExKt:setStickerTexturePngPath	(Lcom/tencent/tavsticker/model/TAVSticker;Ljava/lang/String;)V
    //   268: aload_3
    //   269: fconst_0
    //   270: invokevirtual 574	com/tencent/tavsticker/model/TAVSticker:setRotate	(F)Lcom/tencent/tavsticker/model/TAVSticker;
    //   273: pop
    //   274: aload_3
    //   275: invokevirtual 650	com/tencent/tavsticker/model/TAVSticker:init	()Lcom/tencent/tavsticker/model/TAVSticker;
    //   278: pop
    //   279: aload_3
    //   280: invokevirtual 654	com/tencent/tavsticker/model/TAVSticker:getStickerSolidItems	()Ljava/util/ArrayList;
    //   283: astore 4
    //   285: aload 4
    //   287: invokestatic 660	com/tencent/tavsticker/utils/CollectionUtil:isEmptyList	(Ljava/util/List;)Z
    //   290: ifne +117 -> 407
    //   293: aload 4
    //   295: invokeinterface 142 1 0
    //   300: astore 4
    //   302: aload 4
    //   304: invokeinterface 148 1 0
    //   309: ifeq +98 -> 407
    //   312: aload 4
    //   314: invokeinterface 152 1 0
    //   319: checkcast 662	com/tencent/tavsticker/model/TAVStickerSolidItem
    //   322: astore 5
    //   324: aload_1
    //   325: invokevirtual 666	com/tencent/tavcut/bean/TextEditorData:getColorList	()Ljava/util/Map;
    //   328: aload 5
    //   330: invokevirtual 669	com/tencent/tavsticker/model/TAVStickerSolidItem:getLayerName	()Ljava/lang/String;
    //   333: invokeinterface 674 2 0
    //   338: ifeq -36 -> 302
    //   341: aload 5
    //   343: aload_1
    //   344: invokevirtual 666	com/tencent/tavcut/bean/TextEditorData:getColorList	()Ljava/util/Map;
    //   347: aload 5
    //   349: invokevirtual 669	com/tencent/tavsticker/model/TAVStickerSolidItem:getLayerName	()Ljava/lang/String;
    //   352: invokeinterface 678 2 0
    //   357: checkcast 606	java/lang/Integer
    //   360: invokevirtual 681	java/lang/Integer:intValue	()I
    //   363: invokevirtual 684	com/tencent/tavsticker/model/TAVStickerSolidItem:setColor	(I)V
    //   366: goto -64 -> 302
    //   369: astore_1
    //   370: aload_1
    //   371: invokestatic 690	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   374: aconst_null
    //   375: areturn
    //   376: aload_3
    //   377: aload_2
    //   378: invokevirtual 693	com/tencent/tavsticker/model/TAVSticker:getFilePath	()Ljava/lang/String;
    //   381: invokevirtual 552	com/tencent/tavsticker/model/TAVSticker:setFilePath	(Ljava/lang/String;)Lcom/tencent/tavsticker/model/TAVSticker;
    //   384: pop
    //   385: aload_3
    //   386: aload_2
    //   387: invokevirtual 696	com/tencent/tavsticker/model/TAVSticker:getAssetFilePath	()Ljava/lang/String;
    //   390: invokevirtual 555	com/tencent/tavsticker/model/TAVSticker:setAssetFilePath	(Ljava/lang/String;)Lcom/tencent/tavsticker/model/TAVSticker;
    //   393: pop
    //   394: goto -288 -> 106
    //   397: astore 4
    //   399: aload 4
    //   401: invokestatic 690	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   404: goto -206 -> 198
    //   407: aload_3
    //   408: invokevirtual 699	com/tencent/tavsticker/model/TAVSticker:getStickerTextItems	()Ljava/util/ArrayList;
    //   411: invokevirtual 701	java/util/ArrayList:isEmpty	()Z
    //   414: ifne +69 -> 483
    //   417: aload_2
    //   418: invokestatic 704	com/tencent/weseevideo/editor/sticker/model/TAVStickerExKt:isStickerCarryTextFromOther	(Lcom/tencent/tavsticker/model/TAVSticker;)Z
    //   421: ifeq +62 -> 483
    //   424: aload_3
    //   425: invokevirtual 699	com/tencent/tavsticker/model/TAVSticker:getStickerTextItems	()Ljava/util/ArrayList;
    //   428: iconst_0
    //   429: invokevirtual 707	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   432: checkcast 709	com/tencent/tavsticker/model/TAVStickerTextItem
    //   435: aload_1
    //   436: invokevirtual 712	com/tencent/tavcut/bean/TextEditorData:getContent	()Ljava/lang/String;
    //   439: invokevirtual 716	com/tencent/tavsticker/model/TAVStickerTextItem:setText	(Ljava/lang/String;)V
    //   442: aload_3
    //   443: invokevirtual 699	com/tencent/tavsticker/model/TAVSticker:getStickerTextItems	()Ljava/util/ArrayList;
    //   446: iconst_0
    //   447: invokevirtual 707	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   450: checkcast 709	com/tencent/tavsticker/model/TAVStickerTextItem
    //   453: aload_1
    //   454: invokevirtual 719	com/tencent/tavcut/bean/TextEditorData:getTextColor	()I
    //   457: invokevirtual 722	com/tencent/tavsticker/model/TAVStickerTextItem:setTextColor	(I)V
    //   460: aload_3
    //   461: invokevirtual 699	com/tencent/tavsticker/model/TAVSticker:getStickerTextItems	()Ljava/util/ArrayList;
    //   464: iconst_0
    //   465: invokevirtual 707	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   468: checkcast 709	com/tencent/tavsticker/model/TAVStickerTextItem
    //   471: aload_1
    //   472: invokevirtual 725	com/tencent/tavcut/bean/TextEditorData:getFontPath	()Ljava/lang/String;
    //   475: invokevirtual 728	com/tencent/tavsticker/model/TAVStickerTextItem:setFontPath	(Ljava/lang/String;)V
    //   478: aload_3
    //   479: iconst_1
    //   480: invokestatic 731	com/tencent/weseevideo/editor/sticker/model/TAVStickerExKt:setStickerCarryTextFromOther	(Lcom/tencent/tavsticker/model/TAVSticker;Z)V
    //   483: aload_3
    //   484: invokevirtual 734	com/tencent/tavsticker/model/TAVSticker:updateTextData	()V
    //   487: aload_3
    //   488: invokevirtual 737	com/tencent/tavsticker/model/TAVSticker:updateImageData	()V
    //   491: aload_0
    //   492: getfield 89	com/tencent/weseevideo/editor/sticker/StickerController:stickerOperationCallback	Lcom/tencent/tavcut/session/callback/StickerOperationCallback;
    //   495: ifnull +16 -> 511
    //   498: aload_0
    //   499: getfield 89	com/tencent/weseevideo/editor/sticker/StickerController:stickerOperationCallback	Lcom/tencent/tavcut/session/callback/StickerOperationCallback;
    //   502: aload_3
    //   503: invokevirtual 524	com/tencent/tavsticker/model/TAVSticker:getStickerId	()Ljava/lang/String;
    //   506: invokeinterface 742 2 0
    //   511: aload_0
    //   512: getfield 107	com/tencent/weseevideo/editor/sticker/StickerController:stickerContext	Lcom/tencent/tavsticker/core/TAVStickerContext;
    //   515: aload_3
    //   516: invokevirtual 744	com/tencent/tavsticker/core/TAVStickerContext:loadSticker	(Lcom/tencent/tavsticker/model/TAVSticker;)V
    //   519: aload_3
    //   520: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	StickerController
    //   0	521	1	paramTextEditorData	com.tencent.tavcut.bean.TextEditorData
    //   31	387	2	localTAVSticker	TAVSticker
    //   12	508	3	localObject1	Object
    //   283	30	4	localObject2	Object
    //   397	3	4	localException	Exception
    //   322	26	5	localTAVStickerSolidItem	com.tencent.tavsticker.model.TAVStickerSolidItem
    // Exception table:
    //   from	to	target	type
    //   0	13	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   13	106	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   106	187	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   187	198	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   198	274	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   274	302	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   302	366	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   376	394	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   399	404	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   407	483	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   483	511	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   511	519	369	com/tencent/tavsticker/exception/StickerInitializationException
    //   187	198	397	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController
 * JD-Core Version:    0.7.0.1
 */