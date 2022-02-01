package com.tencent.weseevideo.editor.sticker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.callback.StickerLyricCallback;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import com.tencent.tavcut.session.callback.StickerStateCallback;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.StickerUtil;
import com.tencent.tavsticker.core.ITAVStickerContextObserver;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.model.TAVStickerSolidItem;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.composition.effectnode.VideoEffectType;
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
import java.util.Map;
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
  }
  
  public void onStickerResign(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    TLog.d(TAG, "onStickerResign");
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
  
  public TAVSticker updateTextSticker(TextEditorData paramTextEditorData)
  {
    Object localObject1;
    TAVSticker localTAVSticker;
    for (;;)
    {
      try
      {
        localObject1 = this.stickerContext.getStickers().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localTAVSticker = (TAVSticker)((Iterator)localObject1).next();
          if (!localTAVSticker.getStickerId().equals(paramTextEditorData.getUniqueID())) {
            continue;
          }
          this.stickerContext.removeSticker(localTAVSticker);
          localObject1 = new TAVSticker();
          ((TAVSticker)localObject1).setStickerId(paramTextEditorData.getUniqueID());
          ((TAVSticker)localObject1).setExtras(paramTextEditorData.getItemID());
          if (!TextUtils.isEmpty(paramTextEditorData.getPagFilePath()))
          {
            ((TAVSticker)localObject1).setFilePath(paramTextEditorData.getPagFilePath());
            ((TAVSticker)localObject1).setAssetFilePath(null);
            ((TAVSticker)localObject1).setLayerIndex(localTAVSticker.getLayerIndex());
            ((TAVSticker)localObject1).setScale(localTAVSticker.getScale());
            ((TAVSticker)localObject1).setRotate(localTAVSticker.getRotate());
            ((TAVSticker)localObject1).setCenterX(localTAVSticker.getCenterX());
            ((TAVSticker)localObject1).setCenterY(localTAVSticker.getCenterY());
            ((TAVSticker)localObject1).setEditable(localTAVSticker.isEditable());
            ((TAVSticker)localObject1).setMinScale(localTAVSticker.getMinScale());
            ((TAVSticker)localObject1).setMaxScale(localTAVSticker.getMaxScale());
            ((TAVSticker)localObject1).setTimeRange(localTAVSticker.getTimeRange());
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
            if (CollectionUtil.isEmptyList((List)localObject2)) {
              break;
            }
            localObject2 = ((List)localObject2).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            TAVStickerSolidItem localTAVStickerSolidItem = (TAVStickerSolidItem)((Iterator)localObject2).next();
            if (!paramTextEditorData.getColorList().containsKey(localTAVStickerSolidItem.getLayerName())) {
              continue;
            }
            localTAVStickerSolidItem.setColor(((Integer)paramTextEditorData.getColorList().get(localTAVStickerSolidItem.getLayerName())).intValue());
            continue;
          }
        }
        else
        {
          return null;
        }
      }
      catch (StickerInitializationException paramTextEditorData)
      {
        Logger.e(paramTextEditorData);
      }
      ((TAVSticker)localObject1).setFilePath(localTAVSticker.getFilePath());
      ((TAVSticker)localObject1).setAssetFilePath(localTAVSticker.getAssetFilePath());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController
 * JD-Core Version:    0.7.0.1
 */