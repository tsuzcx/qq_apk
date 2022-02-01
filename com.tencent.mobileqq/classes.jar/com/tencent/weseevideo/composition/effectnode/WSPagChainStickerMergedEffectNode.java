package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.weseevideo.model.effect.VideoBeginModel;
import com.tencent.weseevideo.model.effect.VideoEffectModel;
import com.tencent.weseevideo.model.effect.VideoEndModel;
import com.tencent.weseevideo.model.effect.VideoFenWeiModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSPagChainStickerMergedEffectNode
  extends TAVOneClickFilmStickerEffect
{
  private VideoBeginModel mVideoBeginModel;
  private List<VideoEffectModel> mVideoEffectModels;
  private VideoEndModel mVideoEndModel;
  private VideoFenWeiModel mVideoFenWeiModel;
  private final String sEffectId = "WSPagChainStickerMergedEffectNode" + Integer.toHexString(hashCode());
  
  public WSPagChainStickerMergedEffectNode(TAVAutomaticRenderContext paramTAVAutomaticRenderContext)
  {
    super(paramTAVAutomaticRenderContext);
    this.reportKey = "WSPagChainStickerMergedEffectNode";
  }
  
  private List<TAVSticker> findStickerByType(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (isAvailable()) {
      for (;;)
      {
        TAVSticker localTAVSticker;
        synchronized (getStickerContext().getStickers())
        {
          Iterator localIterator = getStickerContext().getStickers().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localTAVSticker = (TAVSticker)localIterator.next();
          if (localTAVSticker == null) {
            continue;
          }
          if ((paramInt == VideoEffectType.TYPE_VIDEO_END.value) && ("sticker_video_end".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
            localArrayList.add(localTAVSticker);
          }
        }
        if ((paramInt == VideoEffectType.TYPE_FEN_WEI.value) && ("sticker_fen_wei".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
          localList1.add(localTAVSticker);
        } else if ((paramInt == VideoEffectType.TYPE_VIDEO_BEGIN.value) && ("sticker_video_begin".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
          localList1.add(localTAVSticker);
        } else if ((paramInt == VideoEffectType.TYPE_SPECIAL_EFFECT.value) && ("sticker_video_special".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
          localList1.add(localTAVSticker);
        } else if ((paramInt == VideoEffectType.TYPE_SUBTITLE.value) && ("sticker_lyric".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
          localList1.add(localTAVSticker);
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
    return (CollectionUtil.isEmptyList(this.mVideoEffectModels)) && (this.mVideoBeginModel == null) && (this.mVideoEndModel == null) && (this.mVideoFenWeiModel == null) && ((getStickerContext() == null) || (getStickerContext().getStickerCount() == 0));
  }
  
  private void removeStickers(List<TAVSticker> paramList)
  {
    if ((isAvailable()) && (!CollectionUtil.isEmptyList(paramList)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TAVSticker localTAVSticker = (TAVSticker)paramList.next();
        getStickerContext().removeSticker(localTAVSticker);
      }
    }
  }
  
  private void updateVideoBeginSticker()
  {
    if (isAvailable())
    {
      removeStickers(findStickerByType(VideoEffectType.TYPE_VIDEO_BEGIN.value));
      if ((this.mVideoBeginModel != null) && (!TextUtils.isEmpty(this.mVideoBeginModel.getFilePath()))) {
        VideoEffectNodeFactory.addPagChainEffectNode(this.mVideoBeginModel, getStickerContext());
      }
    }
  }
  
  private void updateVideoEffectSticker()
  {
    if (isAvailable())
    {
      removeStickers(findStickerByType(VideoEffectType.TYPE_SPECIAL_EFFECT.value));
      if (!CollectionUtil.isEmptyList(this.mVideoEffectModels)) {
        VideoEffectNodeFactory.addVideoSpecialEffectNode(this.mVideoEffectModels, getStickerContext());
      }
    }
  }
  
  private void updateVideoEndSticker()
  {
    if (isAvailable())
    {
      removeStickers(findStickerByType(VideoEffectType.TYPE_VIDEO_END.value));
      if ((this.mVideoEndModel != null) && (!TextUtils.isEmpty(this.mVideoEndModel.getFilePath()))) {
        VideoEffectNodeFactory.addPagChainEffectNode(this.mVideoEndModel, getStickerContext());
      }
    }
  }
  
  private void updateVideoFenWeiSticker()
  {
    if (isAvailable())
    {
      removeStickers(findStickerByType(VideoEffectType.TYPE_FEN_WEI.value));
      if ((this.mVideoFenWeiModel != null) && (!TextUtils.isEmpty(this.mVideoFenWeiModel.getFilePath()))) {
        VideoEffectNodeFactory.addPagChainEffectNode(this.mVideoFenWeiModel, getStickerContext());
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
  
  public VideoBeginModel getVideoBeginModel()
  {
    return this.mVideoBeginModel;
  }
  
  public List<VideoEffectModel> getVideoEffectModels()
  {
    return this.mVideoEffectModels;
  }
  
  public VideoEndModel getVideoEndModel()
  {
    return this.mVideoEndModel;
  }
  
  public VideoFenWeiModel getVideoFenWeiModel()
  {
    return this.mVideoFenWeiModel;
  }
  
  public void setVideoBeginModel(VideoBeginModel paramVideoBeginModel)
  {
    this.mVideoBeginModel = paramVideoBeginModel;
    updateVideoBeginSticker();
  }
  
  public void setVideoEffectModels(List<VideoEffectModel> paramList)
  {
    this.mVideoEffectModels = paramList;
    updateVideoEffectSticker();
  }
  
  public void setVideoEndModel(VideoEndModel paramVideoEndModel)
  {
    this.mVideoEndModel = paramVideoEndModel;
    updateVideoEndSticker();
  }
  
  public void setVideoFenWeiModel(VideoFenWeiModel paramVideoFenWeiModel)
  {
    this.mVideoFenWeiModel = paramVideoFenWeiModel;
    updateVideoFenWeiSticker();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSPagChainStickerMergedEffectNode
 * JD-Core Version:    0.7.0.1
 */