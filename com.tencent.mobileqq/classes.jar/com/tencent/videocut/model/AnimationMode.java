package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/AnimationMode;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LOOP", "FREEZE", "SCALE_UP", "SCALE_BOTH", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum AnimationMode
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<AnimationMode> ADAPTER = (ProtoAdapter)new AnimationMode.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(AnimationMode.class));
  public static final AnimationMode.Companion Companion;
  private final int value;
  
  static
  {
    AnimationMode localAnimationMode1 = new AnimationMode("LOOP", 0, 0);
    LOOP = localAnimationMode1;
    AnimationMode localAnimationMode2 = new AnimationMode("FREEZE", 1, 1);
    FREEZE = localAnimationMode2;
    AnimationMode localAnimationMode3 = new AnimationMode("SCALE_UP", 2, 2);
    SCALE_UP = localAnimationMode3;
    AnimationMode localAnimationMode4 = new AnimationMode("SCALE_BOTH", 3, 3);
    SCALE_BOTH = localAnimationMode4;
    $VALUES = new AnimationMode[] { localAnimationMode1, localAnimationMode2, localAnimationMode3, localAnimationMode4 };
    Companion = new AnimationMode.Companion(null);
  }
  
  private AnimationMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final AnimationMode fromValue(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AnimationMode
 * JD-Core Version:    0.7.0.1
 */