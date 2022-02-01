package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/StickerModel$Type;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "TEXT", "TEXT_TEMPLATE", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum StickerModel$Type
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Type> ADAPTER = (ProtoAdapter)new StickerModel.Type.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(Type.class));
  public static final StickerModel.Type.Companion Companion;
  private final int value;
  
  static
  {
    Type localType1 = new Type("DEFAULT", 0, 0);
    DEFAULT = localType1;
    Type localType2 = new Type("TEXT", 1, 1);
    TEXT = localType2;
    Type localType3 = new Type("TEXT_TEMPLATE", 2, 2);
    TEXT_TEMPLATE = localType3;
    $VALUES = new Type[] { localType1, localType2, localType3 };
    Companion = new StickerModel.Type.Companion(null);
  }
  
  private StickerModel$Type(int paramInt)
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
 * Qualified Name:     com.tencent.videocut.model.StickerModel.Type
 * JD-Core Version:    0.7.0.1
 */