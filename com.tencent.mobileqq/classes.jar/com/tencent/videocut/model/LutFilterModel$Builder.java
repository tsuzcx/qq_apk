package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/LutFilterModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/LutFilterModel;", "()V", "categoryId", "", "filePath", "filterId", "intensity", "", "Ljava/lang/Float;", "name", "themeId", "build", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/LutFilterModel$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class LutFilterModel$Builder
  extends Message.Builder<LutFilterModel, Builder>
{
  @JvmField
  @Nullable
  public String a;
  @JvmField
  @NotNull
  public String b = "";
  @JvmField
  @NotNull
  public String c = "";
  @JvmField
  @Nullable
  public Float d;
  @JvmField
  @Nullable
  public String e;
  @JvmField
  @Nullable
  public String f;
  
  @NotNull
  public LutFilterModel a()
  {
    String str1 = this.a;
    String str2 = this.b;
    String str3 = this.c;
    Float localFloat = this.d;
    float f1;
    if (localFloat != null) {
      f1 = localFloat.floatValue();
    } else {
      f1 = 0.0F;
    }
    return new LutFilterModel(str1, str2, str3, f1, this.e, this.f, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.LutFilterModel.Builder
 * JD-Core Version:    0.7.0.1
 */