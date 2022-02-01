package com.tencent.weseevideo.model.effect;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.weseevideo.model.BaseMediaModel;
import java.util.ArrayList;
import java.util.List;

public class MediaEffectModel
  extends BaseMediaModel
{
  private AEKitModel aeKitModel;
  private BeautyModel beautyModel;
  private CropModel cropModel;
  private LutModel lutModel;
  private MusicModel musicModel = new MusicModel();
  private List<StickerModel> stickerModelList = new ArrayList();
  private SubtitleModel subtitleModel;
  private VideoBeginModel videoBeginModel;
  private VideoEndModel videoEndModel;
  private VideoFenWeiModel videoFenWeiModel;
  
  public AEKitModel getAeKitModel()
  {
    return this.aeKitModel;
  }
  
  @Nullable
  public BeautyModel getBeautyModel()
  {
    return this.beautyModel;
  }
  
  @Nullable
  public CropModel getCropModel()
  {
    return this.cropModel;
  }
  
  @Nullable
  public LutModel getLutModel()
  {
    return this.lutModel;
  }
  
  @NonNull
  public MusicModel getMusicModel()
  {
    return this.musicModel;
  }
  
  @NonNull
  public List<StickerModel> getStickerModelList()
  {
    return this.stickerModelList;
  }
  
  @Nullable
  public SubtitleModel getSubtitleModel()
  {
    return this.subtitleModel;
  }
  
  @Nullable
  public VideoBeginModel getVideoBeginModel()
  {
    return this.videoBeginModel;
  }
  
  @Nullable
  public VideoEndModel getVideoEndModel()
  {
    return this.videoEndModel;
  }
  
  @Nullable
  public VideoFenWeiModel getVideoFenWeiModel()
  {
    return this.videoFenWeiModel;
  }
  
  public void setAeKitModel(AEKitModel paramAEKitModel)
  {
    this.aeKitModel = paramAEKitModel;
  }
  
  public void setBeautyModel(@Nullable BeautyModel paramBeautyModel)
  {
    this.beautyModel = paramBeautyModel;
  }
  
  public void setCropModel(CropModel paramCropModel)
  {
    this.cropModel = paramCropModel;
  }
  
  public void setLutModel(LutModel paramLutModel)
  {
    this.lutModel = paramLutModel;
  }
  
  public void setMusicModel(@NonNull MusicModel paramMusicModel)
  {
    this.musicModel = paramMusicModel;
  }
  
  public void setStickerModelList(@NonNull List<StickerModel> paramList)
  {
    this.stickerModelList = paramList;
  }
  
  public void setSubtitleModel(@Nullable SubtitleModel paramSubtitleModel)
  {
    this.subtitleModel = paramSubtitleModel;
  }
  
  public void setVideoBeginModel(@Nullable VideoBeginModel paramVideoBeginModel)
  {
    this.videoBeginModel = paramVideoBeginModel;
  }
  
  public void setVideoEndModel(@Nullable VideoEndModel paramVideoEndModel)
  {
    this.videoEndModel = paramVideoEndModel;
  }
  
  public void setVideoFenWeiModel(@Nullable VideoFenWeiModel paramVideoFenWeiModel)
  {
    this.videoFenWeiModel = paramVideoFenWeiModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.MediaEffectModel
 * JD-Core Version:    0.7.0.1
 */