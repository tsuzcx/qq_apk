package com.tencent.qcircle.weseevideo.editor.sticker;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qcircle.tavcut.session.callback.StickerLyricCallback;
import com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback;
import com.tencent.qcircle.tavcut.session.callback.StickerStateCallback;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.StickerUtil;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSOverLayBlurManager;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSOverLayBlurManager.SourceImageObserver;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerContentView;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.tavsticker.core.ITAVStickerContextObserver;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerContext.InterceptTouchDelegate;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.model.TAVStickerSolidItem;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public class StickerController
  implements VideoRenderChainManager.IStickerContextInterface, IStickerEventListener, ITAVStickerContextObserver
{
  private static final String TAG = "StickerController";
  private Context ctx;
  private int dataChangedCount = 0;
  private TAVStickerContext.InterceptTouchDelegate interceptTouchDelegate;
  private TAVStickerOperationMode operationMode = TAVStickerOperationMode.OP_NONE;
  private Set<TAVStickerOperationMode> operations;
  protected WsStickerContentView stickerContentView;
  protected TAVStickerContext stickerContext;
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
    initContentView(paramContext);
    init();
  }
  
  private Pair<Float, Float> calcStickerCenterPosition(float paramFloat1, float paramFloat2)
  {
    Pair localPair = new Pair(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2));
    Object localObject2 = this.stickerContext;
    Object localObject1 = localPair;
    if (localObject2 != null)
    {
      if (((TAVStickerContext)localObject2).getStickers() == null) {
        return localPair;
      }
      localObject2 = this.stickerContext.getStickers().iterator();
      for (;;)
      {
        localObject1 = localPair;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (TAVSticker)((Iterator)localObject2).next();
        if ((Math.abs(((TAVSticker)localObject1).getCenterX() - ((Float)localPair.first).floatValue()) < 0.01F) && (Math.abs(((TAVSticker)localObject1).getCenterY() - ((Float)localPair.second).floatValue()) < 0.01F)) {
          localPair = new Pair(Float.valueOf(((Float)localPair.first).floatValue() + 0.02F), Float.valueOf(((Float)localPair.second).floatValue() + 0.02F));
        }
      }
    }
    return localObject1;
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
      return localArrayList;
    }
    for (;;)
    {
      throw localObject;
    }
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
    addSticker(paramTAVSticker, true);
  }
  
  public void addSticker(TAVSticker paramTAVSticker, boolean paramBoolean)
  {
    Pair localPair = calcStickerCenterPosition(paramTAVSticker.getCenterX(), paramTAVSticker.getCenterY());
    paramTAVSticker.setCenterX(((Float)localPair.first).floatValue());
    paramTAVSticker.setCenterY(((Float)localPair.second).floatValue());
    HandlerUtils.getMainHandler().post(new StickerController.4(this, paramTAVSticker, paramBoolean));
  }
  
  public void alignStickers(long paramLong) {}
  
  public void checkContainerSize(ViewGroup paramViewGroup)
  {
    this.stickerContentView.parentTop = paramViewGroup.getTop();
    this.stickerContentView.parentLeft = paramViewGroup.getLeft();
  }
  
  /* Error */
  @org.jetbrains.annotations.NotNull
  public TAVStickerContext createStickerContext(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 119	com/tencent/qcircle/weseevideo/editor/sticker/StickerController:stickerContext	Lcom/tencent/tavsticker/core/TAVStickerContext;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +5 -> 11
    //   9: aload_2
    //   10: areturn
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 59	com/tencent/qcircle/weseevideo/editor/sticker/StickerController:ctx	Landroid/content/Context;
    //   16: invokevirtual 323	com/tencent/qcircle/weseevideo/editor/sticker/StickerController:createStickerContextInner	(Landroid/content/Context;)Lcom/tencent/tavsticker/core/TAVStickerContext;
    //   19: astore_3
    //   20: aload_3
    //   21: invokevirtual 327	com/tencent/tavsticker/core/TAVStickerContext:getDispatchTouchEventListener	()Lcom/tencent/tavsticker/core/TAVStickerContext$DispatchTouchEventListener;
    //   24: aload_0
    //   25: getfield 329	com/tencent/qcircle/weseevideo/editor/sticker/StickerController:interceptTouchDelegate	Lcom/tencent/tavsticker/core/TAVStickerContext$InterceptTouchDelegate;
    //   28: invokevirtual 335	com/tencent/tavsticker/core/TAVStickerContext$DispatchTouchEventListener:a	(Lcom/tencent/tavsticker/core/TAVStickerContext$InterceptTouchDelegate;)V
    //   31: invokestatic 341	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   34: invokestatic 347	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   37: invokevirtual 350	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   40: if_acmpne +15 -> 55
    //   43: aload_0
    //   44: aload_3
    //   45: invokespecial 102	com/tencent/qcircle/weseevideo/editor/sticker/StickerController:configure	(Lcom/tencent/tavsticker/core/TAVStickerContext;)V
    //   48: aload_0
    //   49: aload_3
    //   50: putfield 119	com/tencent/qcircle/weseevideo/editor/sticker/StickerController:stickerContext	Lcom/tencent/tavsticker/core/TAVStickerContext;
    //   53: aload_3
    //   54: areturn
    //   55: new 352	java/util/concurrent/CountDownLatch
    //   58: dup
    //   59: iconst_1
    //   60: invokespecial 355	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   63: astore_2
    //   64: invokestatic 282	com/tencent/qcircle/weseevideo/editor/utils/HandlerUtils:getMainHandler	()Landroid/os/Handler;
    //   67: new 357	com/tencent/qcircle/weseevideo/editor/sticker/StickerController$5
    //   70: dup
    //   71: aload_0
    //   72: aload_3
    //   73: aload_2
    //   74: invokespecial 360	com/tencent/qcircle/weseevideo/editor/sticker/StickerController$5:<init>	(Lcom/tencent/qcircle/weseevideo/editor/sticker/StickerController;Lcom/tencent/tavsticker/core/TAVStickerContext;Ljava/util/concurrent/CountDownLatch;)V
    //   77: invokevirtual 293	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   80: pop
    //   81: aload_2
    //   82: invokevirtual 363	java/util/concurrent/CountDownLatch:await	()V
    //   85: aload_2
    //   86: invokevirtual 366	java/util/concurrent/CountDownLatch:countDown	()V
    //   89: aload_3
    //   90: areturn
    //   91: astore_3
    //   92: goto +13 -> 105
    //   95: astore 4
    //   97: aload 4
    //   99: invokevirtual 369	java/lang/Exception:printStackTrace	()V
    //   102: goto -17 -> 85
    //   105: aload_2
    //   106: invokevirtual 366	java/util/concurrent/CountDownLatch:countDown	()V
    //   109: goto +5 -> 114
    //   112: aload_3
    //   113: athrow
    //   114: goto -2 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	StickerController
    //   0	117	1	paramBoolean	boolean
    //   4	102	2	localObject1	Object
    //   19	71	3	localTAVStickerContext	TAVStickerContext
    //   91	22	3	localObject2	Object
    //   95	3	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   81	85	91	finally
    //   97	102	91	finally
    //   81	85	95	java/lang/Exception
  }
  
  protected TAVStickerContext createStickerContextInner(Context paramContext)
  {
    return new WsStickerContext(paramContext);
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
    TAVStickerContext localTAVStickerContext = this.stickerContext;
    if (localTAVStickerContext == null) {
      return null;
    }
    return localTAVStickerContext.getCurrentSticker();
  }
  
  public TAVStickerContext getStickerContext()
  {
    return this.stickerContext;
  }
  
  protected void initContentView(Context paramContext)
  {
    this.stickerContentView = new WsStickerContentView(paramContext);
  }
  
  public void onCurrentStickerStateChanged(TAVStickerContext paramTAVStickerContext, boolean paramBoolean)
  {
    TLog.d(TAG, "onCurrentStickerStateChanged -> isActive : $isActive");
  }
  
  public void onStickerActive(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    TLog.d(TAG, "onStickerActive");
    StickerStateCallback localStickerStateCallback = this.stickerStateCallback;
    if (localStickerStateCallback != null) {
      localStickerStateCallback.onStickerActive();
    }
    if ((paramTAVStickerEditView instanceof WSOverLayBlurManager.SourceImageObserver)) {
      WSOverLayBlurManager.registerSourceImageObserver(paramTAVStickerContext, paramTAVStickerEditView.getSticker().getUniqueId(), (WSOverLayBlurManager.SourceImageObserver)paramTAVStickerEditView);
    }
  }
  
  public void onStickerAdd(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    TLog.d(TAG, "onStickerAdd");
    StickerStateCallback localStickerStateCallback = this.stickerStateCallback;
    if (localStickerStateCallback != null) {
      localStickerStateCallback.onStickerAdd(paramTAVStickerContext, paramTAVStickerEditView);
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
    if ((paramTAVStickerEditView instanceof BlurStickerEditView))
    {
      StickerStateCallback localStickerStateCallback = this.stickerStateCallback;
      if (localStickerStateCallback != null) {
        localStickerStateCallback.onStickerResign(paramTAVStickerEditView.getSticker());
      }
    }
    WSOverLayBlurManager.unregisterSourceImageObserver(paramTAVStickerContext, paramTAVStickerEditView.getSticker().getUniqueId());
  }
  
  public void onStickerStatusChanged(TAVSticker paramTAVSticker, boolean paramBoolean1, boolean paramBoolean2)
  {
    TLog.d(TAG, "onStickerStatusChanged");
    if ((!paramBoolean1) && (this.dataChangedCount > 0) && (this.operations.contains(this.operationMode)))
    {
      paramTAVSticker = this.stickerStateCallback;
      if (paramTAVSticker != null) {
        paramTAVSticker.onStatusChanged(false);
      }
    }
    this.dataChangedCount = 0;
  }
  
  public void releaseStickerContext()
  {
    TAVStickerContext localTAVStickerContext = this.stickerContext;
    if (localTAVStickerContext != null)
    {
      localTAVStickerContext.unRegisterObserver(this);
      this.stickerContext.release();
    }
    this.stickerContext = null;
  }
  
  public void removeAllStickers()
  {
    TAVStickerContext localTAVStickerContext = this.stickerContext;
    if (localTAVStickerContext != null) {
      localTAVStickerContext.removeAllStickers();
    }
  }
  
  public void removeAllStickers(Runnable paramRunnable)
  {
    TAVStickerContext localTAVStickerContext = this.stickerContext;
    HandlerUtils.getMainHandler().post(new StickerController.7(this, localTAVStickerContext, paramRunnable));
  }
  
  public void resignCurrentSticker()
  {
    TAVSticker localTAVSticker = this.stickerContext.getCurrentSticker();
    Object localObject = this.stickerContext;
    if (localObject != null) {
      ((TAVStickerContext)localObject).resignCurrentSticker();
    }
    if (localTAVSticker != null)
    {
      localObject = this.stickerStateCallback;
      if (localObject != null) {
        ((StickerStateCallback)localObject).onStickerResign(localTAVSticker);
      }
    }
  }
  
  public void restoreSticker(List<StickerModel> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StickerModel localStickerModel = (StickerModel)paramList.next();
      TAVStickerContext localTAVStickerContext = this.stickerContext;
      if (localTAVStickerContext != null) {
        localTAVStickerContext.loadSticker(StickerUtil.stickerModel2TavSticker(localStickerModel), false);
      }
    }
  }
  
  public SubtitleModel saveLyricSticker()
  {
    Object localObject = findStickerByType(VideoEffectType.TYPE_SUBTITLE.value);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext()) {
        return WSLyricSticker.dumpToSubtitleModel((TAVSticker)((Iterator)localObject).next());
      }
    }
    return null;
  }
  
  public void setInterceptTouchDelegate(TAVStickerContext.InterceptTouchDelegate paramInterceptTouchDelegate)
  {
    this.interceptTouchDelegate = paramInterceptTouchDelegate;
  }
  
  public void setLyricProcess(long paramLong)
  {
    Object localObject = this.stickerContentView;
    if ((localObject != null) && (((WsStickerContentView)localObject).getStickerEditView() != null))
    {
      localObject = this.stickerContentView.getStickerEditView().getSticker();
      if ((this.stickerContentView.getStickerEditView().getMode() == TAVStickerMode.ACTIVE) && (this.stickerContentView.getStickerEditView().getVisibility() == 0) && (localObject != null))
      {
        double d = ((TAVSticker)localObject).computeProgress(paramLong);
        this.stickerContentView.getStickerEditView().setProgress(d);
        this.stickerContentView.getStickerEditView().flush();
      }
    }
  }
  
  public void setLyricStartTime(int paramInt)
  {
    Object localObject = this.stickerContentView;
    if ((localObject != null) && (((WsStickerContentView)localObject).getStickerEditView() != null))
    {
      localObject = this.stickerContentView.getStickerEditView().getSticker();
      if (("sticker_lyric".equals(TAVStickerExKt.getExtraStickerType((TAVSticker)localObject))) && (this.stickerContentView.getStickerEditView().getVisibility() == 0) && (localObject != null) && ((localObject instanceof WSLyricSticker))) {
        ((WSLyricSticker)localObject).updateMusicStartTime(paramInt);
      }
    }
  }
  
  public void setNeedOperate(boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    this.stickerContentView.setNeedOperate(paramBoolean, paramMotionEvent);
    if (!paramBoolean) {
      resignCurrentSticker();
    }
  }
  
  public void setStickerContainer(ViewGroup paramViewGroup)
  {
    paramViewGroup.removeView(this.stickerContentView);
    checkContainerSize(paramViewGroup);
    TAVStickerContext localTAVStickerContext = this.stickerContext;
    if (localTAVStickerContext != null) {
      localTAVStickerContext.setStickerContainer(paramViewGroup);
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
    TAVStickerContext localTAVStickerContext = this.stickerContext;
    if (localTAVStickerContext != null) {
      localTAVStickerContext.setTouchable(paramBoolean);
    }
  }
  
  public TAVSticker updateTextSticker(TextEditorData paramTextEditorData)
  {
    try
    {
      Object localObject1 = this.stickerContext.getStickers().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        TAVSticker localTAVSticker = (TAVSticker)((Iterator)localObject1).next();
        if (localTAVSticker.getStickerId().equals(paramTextEditorData.getUniqueID()))
        {
          this.stickerContext.removeSticker(localTAVSticker);
          localObject1 = new TAVSticker();
          ((TAVSticker)localObject1).setStickerId(paramTextEditorData.getUniqueID());
          ((TAVSticker)localObject1).setExtras(paramTextEditorData.getItemID());
          if (!TextUtils.isEmpty(paramTextEditorData.getPagFilePath()))
          {
            ((TAVSticker)localObject1).setFilePath(paramTextEditorData.getPagFilePath());
            ((TAVSticker)localObject1).setAssetFilePath(null);
          }
          else
          {
            ((TAVSticker)localObject1).setFilePath(localTAVSticker.getFilePath());
            ((TAVSticker)localObject1).setAssetFilePath(localTAVSticker.getAssetFilePath());
          }
          ((TAVSticker)localObject1).setLayerIndex(localTAVSticker.getLayerIndex());
          ((TAVSticker)localObject1).setScale(localTAVSticker.getScale());
          ((TAVSticker)localObject1).setRotate(localTAVSticker.getRotate());
          ((TAVSticker)localObject1).setCenterX(localTAVSticker.getCenterX());
          ((TAVSticker)localObject1).setCenterY(localTAVSticker.getCenterY());
          ((TAVSticker)localObject1).setEditable(localTAVSticker.isEditable());
          ((TAVSticker)localObject1).setMinScale(localTAVSticker.getMinScale());
          ((TAVSticker)localObject1).setMaxScale(localTAVSticker.getMaxScale());
          ((TAVSticker)localObject1).setTimeRange(localTAVSticker.getTimeRange());
          try
          {
            if (paramTextEditorData.getInteractive().isEmpty()) {
              TAVStickerExKt.setStickerInteractive((TAVSticker)localObject1, 0);
            } else {
              TAVStickerExKt.setStickerInteractive((TAVSticker)localObject1, Integer.parseInt(paramTextEditorData.getInteractive()));
            }
          }
          catch (Exception localException)
          {
            Logger.e(localException);
          }
          if ((paramTextEditorData.getStickerType() != null) && (paramTextEditorData.getStickerType().equals("blur")))
          {
            TAVStickerExKt.setExtraStickerType((TAVSticker)localObject1, paramTextEditorData.getStickerType());
            TAVStickerExKt.setStickerLockRatio((TAVSticker)localObject1, false);
            TAVStickerExKt.setStickerEnableRotate((TAVSticker)localObject1, false);
            TAVStickerExKt.setStickerScaleX((TAVSticker)localObject1, localTAVSticker.getScale());
            TAVStickerExKt.setStickerScaleY((TAVSticker)localObject1, localTAVSticker.getScale());
            TAVStickerExKt.setStickerTextPngPath((TAVSticker)localObject1, paramTextEditorData.getBlurTextPath());
            TAVStickerExKt.setStickerTexturePngPath((TAVSticker)localObject1, paramTextEditorData.getBlurTexturePath());
            ((TAVSticker)localObject1).setRotate(0.0F);
          }
          ((TAVSticker)localObject1).init();
          Object localObject2 = ((TAVSticker)localObject1).getStickerSolidItems();
          if (!CollectionUtil.isEmptyList((List)localObject2))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              TAVStickerSolidItem localTAVStickerSolidItem = (TAVStickerSolidItem)((Iterator)localObject2).next();
              if (paramTextEditorData.getColorList().containsKey(localTAVStickerSolidItem.getLayerName())) {
                localTAVStickerSolidItem.setColor(((Integer)paramTextEditorData.getColorList().get(localTAVStickerSolidItem.getLayerName())).intValue());
              }
            }
          }
          if ((!((TAVSticker)localObject1).getStickerTextItems().isEmpty()) && (TAVStickerExKt.isStickerCarryTextFromOther(localTAVSticker)))
          {
            ((TAVStickerTextItem)((TAVSticker)localObject1).getStickerTextItems().get(0)).setText(paramTextEditorData.getContent());
            ((TAVStickerTextItem)((TAVSticker)localObject1).getStickerTextItems().get(0)).setTextColor(paramTextEditorData.getTextColor());
            ((TAVStickerTextItem)((TAVSticker)localObject1).getStickerTextItems().get(0)).setFontPath(paramTextEditorData.getFontPath());
            TAVStickerExKt.setStickerCarryTextFromOther((TAVSticker)localObject1, true);
          }
          ((TAVSticker)localObject1).updateTextData();
          ((TAVSticker)localObject1).updateImageData();
          if (this.stickerOperationCallback != null) {
            this.stickerOperationCallback.onUpdateTextStickerDone(((TAVSticker)localObject1).getStickerId());
          }
          this.stickerContext.loadSticker((TAVSticker)localObject1);
          return localObject1;
        }
      }
    }
    catch (StickerInitializationException paramTextEditorData)
    {
      Logger.e(paramTextEditorData);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.StickerController
 * JD-Core Version:    0.7.0.1
 */