package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/TransitionModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/TransitionModel;", "()V", "categoryId", "", "duration", "", "id", "isLandscape", "", "Ljava/lang/Boolean;", "landscapePagPath", "pagPath", "path", "position", "", "relatedClipId", "resId", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/TransitionModel$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/videocut/model/TransitionModel$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/TransitionModel$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TransitionModel$Builder
  extends Message.Builder<TransitionModel, Builder>
{
  @JvmField
  @NotNull
  public String a = "";
  @JvmField
  @NotNull
  public String b = "";
  @JvmField
  public int c;
  @JvmField
  public long d;
  @JvmField
  @NotNull
  public String e = "";
  @JvmField
  @NotNull
  public String f = "";
  @JvmField
  @Nullable
  public Boolean g;
  @JvmField
  @NotNull
  public String h = "";
  @JvmField
  @NotNull
  public String i = "";
  @JvmField
  @NotNull
  public String j = "";
  
  @NotNull
  public TransitionModel a()
  {
    String str1 = this.a;
    String str2 = this.b;
    int k = this.c;
    long l = this.d;
    String str3 = this.e;
    String str4 = this.f;
    Boolean localBoolean = this.g;
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = false;
    }
    return new TransitionModel(str1, str2, k, l, str3, str4, bool, this.h, this.i, this.j, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TransitionModel.Builder
 * JD-Core Version:    0.7.0.1
 */