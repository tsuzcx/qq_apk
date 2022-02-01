package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/ResourceModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/ResourceModel;", "()V", "extras", "", "", "id", "isReverseMode", "", "Ljava/lang/Boolean;", "normalPath", "path", "picClipRect", "Lcom/tencent/videocut/model/RectF;", "reversePath", "scaleDuration", "", "selectDuration", "selectStart", "size", "Lcom/tencent/videocut/model/SizeF;", "sourceDuration", "sourceStart", "type", "Lcom/tencent/videocut/model/MediaType;", "volume", "", "Ljava/lang/Float;", "build", "(Ljava/lang/Boolean;)Lcom/tencent/videocut/model/ResourceModel$Builder;", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/ResourceModel$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ResourceModel$Builder
  extends Message.Builder<ResourceModel, Builder>
{
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
  public long e;
  @JvmField
  public long f;
  @JvmField
  public long g;
  @JvmField
  @Nullable
  public MediaType h;
  @JvmField
  @Nullable
  public SizeF i;
  @JvmField
  @Nullable
  public Float j;
  @JvmField
  @NotNull
  public Map<String, String> k = MapsKt.emptyMap();
  @JvmField
  @Nullable
  public RectF l;
  @JvmField
  @NotNull
  public String m = "";
  @JvmField
  @NotNull
  public String n = "";
  @JvmField
  @Nullable
  public Boolean o;
  
  @NotNull
  public ResourceModel a()
  {
    String str1 = this.a;
    String str2 = this.b;
    long l1 = this.c;
    long l2 = this.d;
    long l3 = this.e;
    long l4 = this.f;
    long l5 = this.g;
    MediaType localMediaType = this.h;
    SizeF localSizeF = this.i;
    Float localFloat = this.j;
    float f1;
    if (localFloat != null) {
      f1 = localFloat.floatValue();
    } else {
      f1 = 0.0F;
    }
    return new ResourceModel(str1, str2, l1, l2, l3, l4, l5, localMediaType, localSizeF, f1, this.k, this.l, this.m, this.n, this.o, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.ResourceModel.Builder
 * JD-Core Version:    0.7.0.1
 */