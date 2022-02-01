package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/BackgroundResPack$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/BackgroundResPack;", "()V", "ratio16to9", "", "ratio1to1", "ratio1to2", "ratio3to4", "ratio4to3", "ratio9to16", "build", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class BackgroundResPack$Builder
  extends Message.Builder<BackgroundResPack, Builder>
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
  public String d;
  @JvmField
  @Nullable
  public String e;
  @JvmField
  @Nullable
  public String f;
  
  @NotNull
  public BackgroundResPack a()
  {
    return new BackgroundResPack(this.a, this.b, this.c, this.d, this.e, this.f, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.BackgroundResPack.Builder
 * JD-Core Version:    0.7.0.1
 */