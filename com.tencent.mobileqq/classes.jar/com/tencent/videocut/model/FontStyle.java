package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/FontStyle;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "BOLD", "ITALIC", "UNDERSCORE", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum FontStyle
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<FontStyle> ADAPTER = (ProtoAdapter)new FontStyle.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(FontStyle.class));
  public static final FontStyle.Companion Companion;
  private final int value;
  
  static
  {
    FontStyle localFontStyle1 = new FontStyle("BOLD", 0, 0);
    BOLD = localFontStyle1;
    FontStyle localFontStyle2 = new FontStyle("ITALIC", 1, 1);
    ITALIC = localFontStyle2;
    FontStyle localFontStyle3 = new FontStyle("UNDERSCORE", 2, 2);
    UNDERSCORE = localFontStyle3;
    $VALUES = new FontStyle[] { localFontStyle1, localFontStyle2, localFontStyle3 };
    Companion = new FontStyle.Companion(null);
  }
  
  private FontStyle(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final FontStyle fromValue(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.FontStyle
 * JD-Core Version:    0.7.0.1
 */