package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/BackgroundFillMode;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PAG", "SOLID_COLOR", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum BackgroundFillMode
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<BackgroundFillMode> ADAPTER = (ProtoAdapter)new BackgroundFillMode.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(BackgroundFillMode.class));
  public static final BackgroundFillMode.Companion Companion;
  private final int value;
  
  static
  {
    BackgroundFillMode localBackgroundFillMode1 = new BackgroundFillMode("PAG", 0, 0);
    PAG = localBackgroundFillMode1;
    BackgroundFillMode localBackgroundFillMode2 = new BackgroundFillMode("SOLID_COLOR", 1, 1);
    SOLID_COLOR = localBackgroundFillMode2;
    $VALUES = new BackgroundFillMode[] { localBackgroundFillMode1, localBackgroundFillMode2 };
    Companion = new BackgroundFillMode.Companion(null);
  }
  
  private BackgroundFillMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final BackgroundFillMode fromValue(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.BackgroundFillMode
 * JD-Core Version:    0.7.0.1
 */