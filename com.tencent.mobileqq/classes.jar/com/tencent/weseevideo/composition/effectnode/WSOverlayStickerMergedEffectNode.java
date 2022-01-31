package com.tencent.weseevideo.composition.effectnode;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavmovie.filter.TAVStickerOverlayEffect;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.editor.utils.HandlerUtils;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSOverlayStickerMergedEffectNode
  extends TAVStickerOverlayEffect
{
  private VideoRenderChainManager.IStickerContextInterface mContextCreator;
  private List<StickerModel> mStickerModels;
  private final String sEffectId = "WSOverlayStickerMergedEffectNode" + Integer.toHexString(hashCode());
  
  public WSOverlayStickerMergedEffectNode(TAVStickerRenderContext paramTAVStickerRenderContext, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface)
  {
    super(paramTAVStickerRenderContext);
    this.mContextCreator = paramIStickerContextInterface;
    this.reportKey = "WSOverlayStickerMergedEffectNode";
  }
  
  private List<TAVSticker> findStickerByType(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (isAvailable()) {
      synchronized (getStickerContext().getStickers())
      {
        Iterator localIterator = getStickerContext().getStickers().iterator();
        while (localIterator.hasNext())
        {
          TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
          if ((localTAVSticker != null) && (paramInt == VideoEffectType.TYPE_STICKER.value)) {
            localArrayList.add(localTAVSticker);
          }
        }
      }
    }
    return localList1;
  }
  
  private boolean isAvailable()
  {
    return getStickerContext() != null;
  }
  
  private boolean isEmpty()
  {
    return false;
  }
  
  private void removeStickers(List<TAVSticker> paramList)
  {
    if ((isAvailable()) && (!CollectionUtil.isEmptyList(paramList)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TAVSticker localTAVSticker = (TAVSticker)paramList.next();
        TAVStickerRenderContext localTAVStickerRenderContext = getStickerContext();
        if ((localTAVStickerRenderContext instanceof TAVStickerContext)) {
          HandlerUtils.getMainHandler().post(new WSOverlayStickerMergedEffectNode.1(this, localTAVStickerRenderContext, localTAVSticker));
        } else {
          localTAVStickerRenderContext.removeSticker(localTAVSticker);
        }
      }
    }
  }
  
  private void updateCommonSticker(@NonNull CGSize paramCGSize)
  {
    if (isAvailable())
    {
      removeStickers(findStickerByType(VideoEffectType.TYPE_STICKER.value));
      if (!CollectionUtil.isEmptyList(this.mStickerModels)) {
        VideoEffectNodeFactory.addStickerEffectNode(this.mStickerModels, paramCGSize, getStickerContext(), this.mContextCreator);
      }
    }
  }
  
  @NonNull
  public String effectId()
  {
    if (isEmpty()) {
      return "";
    }
    return this.sEffectId;
  }
  
  public List<StickerModel> getStickerModels()
  {
    return this.mStickerModels;
  }
  
  public void setStickerModels(List<StickerModel> paramList, CGSize paramCGSize)
  {
    this.mStickerModels = paramList;
    if (this.mContextCreator == null) {
      updateCommonSticker(paramCGSize);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSOverlayStickerMergedEffectNode
 * JD-Core Version:    0.7.0.1
 */