package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/MediaModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/MediaModel;", "()V", "audios", "", "", "Lcom/tencent/videocut/model/AudioModel;", "backgroundModel", "Lcom/tencent/videocut/model/BackgroundModel;", "coverInfo", "Lcom/tencent/videocut/model/CoverInfo;", "createTime", "", "Ljava/lang/Long;", "duration", "exportSetting", "Lcom/tencent/videocut/model/ExportSettingModel;", "filterModels", "Lcom/tencent/videocut/model/FilterModel;", "id", "name", "pips", "Lcom/tencent/videocut/model/PipModel;", "specialEffects", "Lcom/tencent/videocut/model/SpecialEffectModel;", "stickers", "Lcom/tencent/videocut/model/StickerModel;", "templateModel", "Lcom/tencent/videocut/model/TemplateModel;", "transitions", "Lcom/tencent/videocut/model/TransitionModel;", "updateTime", "version", "videos", "", "Lcom/tencent/videocut/model/MediaClip;", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/MediaModel$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MediaModel$Builder
  extends Message.Builder<MediaModel, Builder>
{
  @JvmField
  @Nullable
  public String a;
  @JvmField
  @Nullable
  public String b;
  @JvmField
  @Nullable
  public String c;
  @JvmField
  @Nullable
  public Long d;
  @JvmField
  @Nullable
  public Long e;
  @JvmField
  @Nullable
  public Long f;
  @JvmField
  @NotNull
  public List<MediaClip> g = CollectionsKt.emptyList();
  @JvmField
  @NotNull
  public Map<String, AudioModel> h = MapsKt.emptyMap();
  @JvmField
  @NotNull
  public Map<String, ? extends StickerModel> i = MapsKt.emptyMap();
  @JvmField
  @Nullable
  public BackgroundModel j;
  @JvmField
  @NotNull
  public Map<String, FilterModel> k = MapsKt.emptyMap();
  @JvmField
  @NotNull
  public Map<String, SpecialEffectModel> l = MapsKt.emptyMap();
  @JvmField
  @NotNull
  public Map<String, TransitionModel> m = MapsKt.emptyMap();
  @JvmField
  @Nullable
  public TemplateModel n;
  @JvmField
  @NotNull
  public Map<String, PipModel> o = MapsKt.emptyMap();
  @JvmField
  @Nullable
  public CoverInfo p;
  @JvmField
  @Nullable
  public ExportSettingModel q;
  
  @NotNull
  public MediaModel a()
  {
    return new MediaModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.MediaModel.Builder
 * JD-Core Version:    0.7.0.1
 */