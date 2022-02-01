package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.model.effect.VideoBeginModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoEndModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoFenWeiModel;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
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
  private final String sEffectId;
  
  public WSPagChainStickerMergedEffectNode(TAVAutomaticRenderContext paramTAVAutomaticRenderContext)
  {
    super(paramTAVAutomaticRenderContext);
    paramTAVAutomaticRenderContext = new StringBuilder();
    paramTAVAutomaticRenderContext.append("WSPagChainStickerMergedEffectNode");
    paramTAVAutomaticRenderContext.append(Integer.toHexString(hashCode()));
    this.sEffectId = paramTAVAutomaticRenderContext.toString();
    this.reportKey = "WSPagChainStickerMergedEffectNode";
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
          if (localTAVSticker != null) {
            if ((paramInt == VideoEffectType.TYPE_STICKER.value) && ("blur".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
              localArrayList.add(localTAVSticker);
            } else if ((paramInt == VideoEffectType.TYPE_VIDEO_END.value) && ("sticker_video_end".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
              localArrayList.add(localTAVSticker);
            } else if ((paramInt == VideoEffectType.TYPE_FEN_WEI.value) && ("sticker_fen_wei".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
              localArrayList.add(localTAVSticker);
            } else if ((paramInt == VideoEffectType.TYPE_VIDEO_BEGIN.value) && ("sticker_video_begin".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
              localArrayList.add(localTAVSticker);
            } else if ((paramInt == VideoEffectType.TYPE_SPECIAL_EFFECT.value) && ("sticker_video_special".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
              localArrayList.add(localTAVSticker);
            } else if ((paramInt == VideoEffectType.TYPE_SUBTITLE.value) && ("sticker_lyric".equals(TAVStickerExKt.getExtraStickerType(localTAVSticker)))) {
              localArrayList.add(localTAVSticker);
            }
          }
        }
        return localArrayList;
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
      VideoBeginModel localVideoBeginModel = this.mVideoBeginModel;
      if ((localVideoBeginModel != null) && (!TextUtils.isEmpty(localVideoBeginModel.getFilePath()))) {
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
      VideoEndModel localVideoEndModel = this.mVideoEndModel;
      if ((localVideoEndModel != null) && (!TextUtils.isEmpty(localVideoEndModel.getFilePath()))) {
        VideoEffectNodeFactory.addPagChainEffectNode(this.mVideoEndModel, getStickerContext());
      }
    }
  }
  
  private void updateVideoFenWeiSticker()
  {
    if (isAvailable())
    {
      removeStickers(findStickerByType(VideoEffectType.TYPE_FEN_WEI.value));
      VideoFenWeiModel localVideoFenWeiModel = this.mVideoFenWeiModel;
      if ((localVideoFenWeiModel != null) && (!TextUtils.isEmpty(localVideoFenWeiModel.getFilePath()))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.WSPagChainStickerMergedEffectNode
 * JD-Core Version:    0.7.0.1
 */