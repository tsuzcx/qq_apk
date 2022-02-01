package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/BackgroundModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/BackgroundModel;", "()V", "bgColor", "", "bgFillMode", "Lcom/tencent/videocut/model/BackgroundFillMode;", "bgPagPath", "categoryId", "fillScale", "", "id", "ratioType", "Lcom/tencent/videocut/model/RatioType;", "renderSize", "Lcom/tencent/videocut/model/SizeF;", "resPack", "Lcom/tencent/videocut/model/BackgroundResPack;", "build", "scale", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class BackgroundModel$Builder
  extends Message.Builder<BackgroundModel, Builder>
{
  @JvmField
  @Nullable
  public String a;
  @JvmField
  @Nullable
  public SizeF b;
  @JvmField
  @Nullable
  public BackgroundFillMode c;
  @JvmField
  @Nullable
  public String d;
  @JvmField
  @Nullable
  public String e;
  @JvmField
  @Nullable
  public RatioType f;
  @JvmField
  @Nullable
  public BackgroundResPack g;
  @JvmField
  @Nullable
  public String h;
  @JvmField
  public float i;
  
  @NotNull
  public BackgroundModel a()
  {
    String str2 = this.a;
    SizeF localSizeF = this.b;
    BackgroundFillMode localBackgroundFillMode = this.c;
    String str1 = this.d;
    if (str1 == null) {
      str1 = "";
    }
    return new BackgroundModel(str2, localSizeF, localBackgroundFillMode, str1, this.e, this.f, this.g, this.h, this.i, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.BackgroundModel.Builder
 * JD-Core Version:    0.7.0.1
 */