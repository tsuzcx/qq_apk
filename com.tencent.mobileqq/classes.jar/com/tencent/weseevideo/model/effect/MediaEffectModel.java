package com.tencent.weseevideo.model.effect;

import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.aekit.PreSegModel;
import com.tencent.weseevideo.model.BaseMediaModel;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/effect/MediaEffectModel;", "Lcom/tencent/weseevideo/model/BaseMediaModel;", "()V", "aeKitModel", "Lcom/tencent/tavcut/aekit/AEKitModel;", "getAeKitModel", "()Lcom/tencent/tavcut/aekit/AEKitModel;", "setAeKitModel", "(Lcom/tencent/tavcut/aekit/AEKitModel;)V", "beautyModel", "Lcom/tencent/weseevideo/model/effect/BeautyModel;", "getBeautyModel", "()Lcom/tencent/weseevideo/model/effect/BeautyModel;", "setBeautyModel", "(Lcom/tencent/weseevideo/model/effect/BeautyModel;)V", "cropModel", "Lcom/tencent/weseevideo/model/effect/CropModel;", "getCropModel", "()Lcom/tencent/weseevideo/model/effect/CropModel;", "setCropModel", "(Lcom/tencent/weseevideo/model/effect/CropModel;)V", "gestureModel", "Lcom/tencent/weseevideo/model/effect/GestureModel;", "getGestureModel", "()Lcom/tencent/weseevideo/model/effect/GestureModel;", "setGestureModel", "(Lcom/tencent/weseevideo/model/effect/GestureModel;)V", "lutModel", "Lcom/tencent/weseevideo/model/effect/LutModel;", "getLutModel", "()Lcom/tencent/weseevideo/model/effect/LutModel;", "setLutModel", "(Lcom/tencent/weseevideo/model/effect/LutModel;)V", "musicModel", "Lcom/tencent/weseevideo/model/effect/MusicModel;", "getMusicModel", "()Lcom/tencent/weseevideo/model/effect/MusicModel;", "setMusicModel", "(Lcom/tencent/weseevideo/model/effect/MusicModel;)V", "preSegModel", "Lcom/tencent/tavcut/aekit/PreSegModel;", "getPreSegModel", "()Lcom/tencent/tavcut/aekit/PreSegModel;", "setPreSegModel", "(Lcom/tencent/tavcut/aekit/PreSegModel;)V", "stickerModelList", "", "Lcom/tencent/weseevideo/model/effect/StickerModel;", "getStickerModelList", "()Ljava/util/List;", "setStickerModelList", "(Ljava/util/List;)V", "subtitleModel", "Lcom/tencent/weseevideo/model/effect/SubtitleModel;", "getSubtitleModel", "()Lcom/tencent/weseevideo/model/effect/SubtitleModel;", "setSubtitleModel", "(Lcom/tencent/weseevideo/model/effect/SubtitleModel;)V", "videoBeginModel", "Lcom/tencent/weseevideo/model/effect/VideoBeginModel;", "getVideoBeginModel", "()Lcom/tencent/weseevideo/model/effect/VideoBeginModel;", "setVideoBeginModel", "(Lcom/tencent/weseevideo/model/effect/VideoBeginModel;)V", "videoEndModel", "Lcom/tencent/weseevideo/model/effect/VideoEndModel;", "getVideoEndModel", "()Lcom/tencent/weseevideo/model/effect/VideoEndModel;", "setVideoEndModel", "(Lcom/tencent/weseevideo/model/effect/VideoEndModel;)V", "videoFenWeiModel", "Lcom/tencent/weseevideo/model/effect/VideoFenWeiModel;", "getVideoFenWeiModel", "()Lcom/tencent/weseevideo/model/effect/VideoFenWeiModel;", "setVideoFenWeiModel", "(Lcom/tencent/weseevideo/model/effect/VideoFenWeiModel;)V", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class MediaEffectModel
  extends BaseMediaModel
{
  @Nullable
  private AEKitModel aeKitModel;
  @Nullable
  private BeautyModel beautyModel;
  @Nullable
  private CropModel cropModel;
  @NotNull
  private GestureModel gestureModel = new GestureModel();
  @Nullable
  private LutModel lutModel;
  @NotNull
  private MusicModel musicModel = new MusicModel();
  @Nullable
  private PreSegModel preSegModel;
  @NotNull
  private List<? extends StickerModel> stickerModelList = (List)new CopyOnWriteArrayList();
  @Nullable
  private SubtitleModel subtitleModel;
  @Nullable
  private VideoBeginModel videoBeginModel;
  @Nullable
  private VideoEndModel videoEndModel;
  @Nullable
  private VideoFenWeiModel videoFenWeiModel;
  
  @Nullable
  public final AEKitModel getAeKitModel()
  {
    return this.aeKitModel;
  }
  
  @Nullable
  public final BeautyModel getBeautyModel()
  {
    return this.beautyModel;
  }
  
  @Nullable
  public final CropModel getCropModel()
  {
    return this.cropModel;
  }
  
  @NotNull
  public final GestureModel getGestureModel()
  {
    return this.gestureModel;
  }
  
  @Nullable
  public final LutModel getLutModel()
  {
    return this.lutModel;
  }
  
  @NotNull
  public final MusicModel getMusicModel()
  {
    return this.musicModel;
  }
  
  @Nullable
  public final PreSegModel getPreSegModel()
  {
    return this.preSegModel;
  }
  
  @NotNull
  public final List<StickerModel> getStickerModelList()
  {
    return this.stickerModelList;
  }
  
  @Nullable
  public final SubtitleModel getSubtitleModel()
  {
    return this.subtitleModel;
  }
  
  @Nullable
  public final VideoBeginModel getVideoBeginModel()
  {
    return this.videoBeginModel;
  }
  
  @Nullable
  public final VideoEndModel getVideoEndModel()
  {
    return this.videoEndModel;
  }
  
  @Nullable
  public final VideoFenWeiModel getVideoFenWeiModel()
  {
    return this.videoFenWeiModel;
  }
  
  public final void setAeKitModel(@Nullable AEKitModel paramAEKitModel)
  {
    this.aeKitModel = paramAEKitModel;
  }
  
  public final void setBeautyModel(@Nullable BeautyModel paramBeautyModel)
  {
    this.beautyModel = paramBeautyModel;
  }
  
  public final void setCropModel(@Nullable CropModel paramCropModel)
  {
    this.cropModel = paramCropModel;
  }
  
  public final void setGestureModel(@NotNull GestureModel paramGestureModel)
  {
    Intrinsics.checkParameterIsNotNull(paramGestureModel, "<set-?>");
    this.gestureModel = paramGestureModel;
  }
  
  public final void setLutModel(@Nullable LutModel paramLutModel)
  {
    this.lutModel = paramLutModel;
  }
  
  public final void setMusicModel(@NotNull MusicModel paramMusicModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMusicModel, "<set-?>");
    this.musicModel = paramMusicModel;
  }
  
  public final void setPreSegModel(@Nullable PreSegModel paramPreSegModel)
  {
    this.preSegModel = paramPreSegModel;
  }
  
  public final void setStickerModelList(@NotNull List<? extends StickerModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.stickerModelList = paramList;
  }
  
  public final void setSubtitleModel(@Nullable SubtitleModel paramSubtitleModel)
  {
    this.subtitleModel = paramSubtitleModel;
  }
  
  public final void setVideoBeginModel(@Nullable VideoBeginModel paramVideoBeginModel)
  {
    this.videoBeginModel = paramVideoBeginModel;
  }
  
  public final void setVideoEndModel(@Nullable VideoEndModel paramVideoEndModel)
  {
    this.videoEndModel = paramVideoEndModel;
  }
  
  public final void setVideoFenWeiModel(@Nullable VideoFenWeiModel paramVideoFenWeiModel)
  {
    this.videoFenWeiModel = paramVideoFenWeiModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.MediaEffectModel
 * JD-Core Version:    0.7.0.1
 */