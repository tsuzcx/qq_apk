package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/TextItem$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/TextItem;", "()V", "applyStroke", "", "Ljava/lang/Boolean;", "backgroundAlpha", "", "backgroundColor", "", "fauxBold", "fauxItalic", "fontFamily", "fontPath", "fontStyle", "index", "layerSize", "Lcom/tencent/videocut/model/Size;", "leading", "", "Ljava/lang/Float;", "opacity", "shadowColor", "shadowOpacity", "strokeColor", "strokeWidth", "text", "textColor", "tracking", "(Ljava/lang/Boolean;)Lcom/tencent/videocut/model/TextItem$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/TextItem$Builder;", "build", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/TextItem$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TextItem$Builder
  extends Message.Builder<TextItem, Builder>
{
  @JvmField
  @NotNull
  public String a = "";
  @JvmField
  @NotNull
  public String b = "";
  @JvmField
  @NotNull
  public String c = "";
  @JvmField
  @NotNull
  public String d = "";
  @JvmField
  public float e;
  @JvmField
  @NotNull
  public String f = "";
  @JvmField
  @Nullable
  public Float g;
  @JvmField
  @Nullable
  public Float h;
  @JvmField
  public int i;
  @JvmField
  @Nullable
  public Boolean j;
  @JvmField
  @Nullable
  public Boolean k;
  @JvmField
  @NotNull
  public String l = "";
  @JvmField
  @Nullable
  public Boolean m;
  @JvmField
  @Nullable
  public Float n;
  @JvmField
  @Nullable
  public Float o;
  @JvmField
  @NotNull
  public String p = "";
  @JvmField
  public int q;
  @JvmField
  @Nullable
  public Size r;
  @JvmField
  @NotNull
  public String s = "";
  
  @NotNull
  public TextItem a()
  {
    return new TextItem(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TextItem.Builder
 * JD-Core Version:    0.7.0.1
 */