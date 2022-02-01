package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/SpecialEffectModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/SpecialEffectModel;", "()V", "actionScope", "Lcom/tencent/videocut/model/ActionScope;", "animationMode", "Lcom/tencent/videocut/model/AnimationMode;", "bgColor", "", "Ljava/lang/Integer;", "categoryId", "", "createTimeMs", "", "Ljava/lang/Long;", "durationUs", "filePath", "id", "jsContentCache", "jsPath", "landscapeFilePath", "materialId", "name", "portraitFilePath", "scale", "", "Ljava/lang/Float;", "startTimeUs", "timeLineIndex", "type", "Lcom/tencent/videocut/model/SpecialEffectResType;", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/SpecialEffectModel$Builder;", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/SpecialEffectModel$Builder;", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/SpecialEffectModel$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class SpecialEffectModel$Builder
  extends Message.Builder<SpecialEffectModel, Builder>
{
  @JvmField
  @Nullable
  public String a;
  @JvmField
  @Nullable
  public String b;
  @JvmField
  @Nullable
  public Integer c;
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
  @Nullable
  public Float g;
  @JvmField
  @Nullable
  public String h;
  @JvmField
  @Nullable
  public AnimationMode i;
  @JvmField
  @Nullable
  public ActionScope j;
  @JvmField
  @Nullable
  public Integer k;
  @JvmField
  @Nullable
  public String l;
  @JvmField
  @Nullable
  public String m;
  @JvmField
  @Nullable
  public String n;
  @JvmField
  @Nullable
  public String o;
  @JvmField
  @Nullable
  public SpecialEffectResType p;
  @JvmField
  @Nullable
  public String q;
  @JvmField
  @Nullable
  public String r;
  
  @NotNull
  public SpecialEffectModel a()
  {
    return new SpecialEffectModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.SpecialEffectModel.Builder
 * JD-Core Version:    0.7.0.1
 */