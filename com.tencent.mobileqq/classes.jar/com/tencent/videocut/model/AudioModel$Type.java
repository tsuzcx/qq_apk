package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/AudioModel$Type;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "MUSIC", "RECORD", "SOUND", "EXTRACT", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum AudioModel$Type
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Type> ADAPTER = (ProtoAdapter)new AudioModel.Type.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(Type.class));
  public static final AudioModel.Type.Companion Companion;
  private final int value;
  
  static
  {
    Type localType1 = new Type("MUSIC", 0, 0);
    MUSIC = localType1;
    Type localType2 = new Type("RECORD", 1, 1);
    RECORD = localType2;
    Type localType3 = new Type("SOUND", 2, 2);
    SOUND = localType3;
    Type localType4 = new Type("EXTRACT", 3, 3);
    EXTRACT = localType4;
    $VALUES = new Type[] { localType1, localType2, localType3, localType4 };
    Companion = new AudioModel.Type.Companion(null);
  }
  
  private AudioModel$Type(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final Type fromValue(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel.Type
 * JD-Core Version:    0.7.0.1
 */