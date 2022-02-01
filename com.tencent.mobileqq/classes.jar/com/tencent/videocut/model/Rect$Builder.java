package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/Rect$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/Rect;", "()V", "bottom", "", "left", "right", "top", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/Rect$Builder;", "build", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class Rect$Builder
  extends Message.Builder<Rect, Builder>
{
  @JvmField
  public int a;
  @JvmField
  public int b;
  @JvmField
  public int c;
  @JvmField
  public int d;
  
  @NotNull
  public Rect a()
  {
    return new Rect(this.a, this.b, this.c, this.d, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.Rect.Builder
 * JD-Core Version:    0.7.0.1
 */