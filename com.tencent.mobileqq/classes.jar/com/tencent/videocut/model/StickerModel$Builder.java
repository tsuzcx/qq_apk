package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/StickerModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/StickerModel;", "()V", "actionType", "Lcom/tencent/videocut/model/StickerModel$ActionType;", "animationMode", "Lcom/tencent/videocut/model/AnimationMode;", "bgConfig", "", "", "bgPath", "captionInfo", "Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "centerX", "", "centerY", "configType", "duration", "", "editable", "", "editingLayerIndex", "", "filePath", "height", "id", "layerIndex", "localThumbId", "materialId", "maxScale", "minScale", "playEndDuration", "rotate", "scale", "startTime", "textItems", "Lcom/tencent/videocut/model/TextItem;", "thumbUrl", "timelineTrackIndex", "type", "Lcom/tencent/videocut/model/StickerModel$Type;", "width", "build", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class StickerModel$Builder
  extends Message.Builder<StickerModel, Builder>
{
  @JvmField
  @NotNull
  public String A = "";
  @JvmField
  @NotNull
  public String B = "";
  @JvmField
  @NotNull
  public String a = "";
  @JvmField
  @NotNull
  public String b = "";
  @JvmField
  public long c;
  @JvmField
  public long d;
  @JvmField
  public int e;
  @JvmField
  public float f;
  @JvmField
  public float g;
  @JvmField
  public float h;
  @JvmField
  public float i;
  @JvmField
  public boolean j;
  @JvmField
  public int k;
  @JvmField
  public int l;
  @JvmField
  public float m;
  @JvmField
  public float n;
  @JvmField
  @NotNull
  public List<TextItem> o = CollectionsKt.emptyList();
  @JvmField
  @NotNull
  public String p = "";
  @JvmField
  public int q;
  @JvmField
  @NotNull
  public AnimationMode r = AnimationMode.LOOP;
  @JvmField
  @NotNull
  public StickerModel.Type s = StickerModel.Type.DEFAULT;
  @JvmField
  @NotNull
  public String t = "";
  @JvmField
  @Nullable
  public StickerModel.CaptionInfo u;
  @JvmField
  public int v;
  @JvmField
  public int w;
  @JvmField
  public long x;
  @JvmField
  @NotNull
  public StickerModel.ActionType y = StickerModel.ActionType.NONE;
  @JvmField
  @NotNull
  public List<String> z = CollectionsKt.emptyList();
  
  @NotNull
  public StickerModel a()
  {
    return new StickerModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.StickerModel.Builder
 * JD-Core Version:    0.7.0.1
 */