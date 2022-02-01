package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "SCALE", "REPEAT", "REPEAT_INVERTED", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public enum TimeStretchMode
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<TimeStretchMode> ADAPTER = (ProtoAdapter)new TimeStretchMode.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(TimeStretchMode.class));
  public static final TimeStretchMode.Companion Companion;
  private final int value;
  
  static
  {
    TimeStretchMode localTimeStretchMode1 = new TimeStretchMode("NONE", 0, 0);
    NONE = localTimeStretchMode1;
    TimeStretchMode localTimeStretchMode2 = new TimeStretchMode("SCALE", 1, 1);
    SCALE = localTimeStretchMode2;
    TimeStretchMode localTimeStretchMode3 = new TimeStretchMode("REPEAT", 2, 2);
    REPEAT = localTimeStretchMode3;
    TimeStretchMode localTimeStretchMode4 = new TimeStretchMode("REPEAT_INVERTED", 3, 3);
    REPEAT_INVERTED = localTimeStretchMode4;
    $VALUES = new TimeStretchMode[] { localTimeStretchMode1, localTimeStretchMode2, localTimeStretchMode3, localTimeStretchMode4 };
    Companion = new TimeStretchMode.Companion(null);
  }
  
  private TimeStretchMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final TimeStretchMode fromValue(int paramInt)
  {
    return Companion.fromValue(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.TimeStretchMode
 * JD-Core Version:    0.7.0.1
 */