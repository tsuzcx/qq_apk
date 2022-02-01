package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/MediaType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "VIDEO", "IMAGE", "AUDIO", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum MediaType
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<MediaType> ADAPTER = (ProtoAdapter)new MediaType.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(MediaType.class));
  public static final MediaType.Companion Companion;
  private final int value;
  
  static
  {
    MediaType localMediaType1 = new MediaType("VIDEO", 0, 0);
    VIDEO = localMediaType1;
    MediaType localMediaType2 = new MediaType("IMAGE", 1, 1);
    IMAGE = localMediaType2;
    MediaType localMediaType3 = new MediaType("AUDIO", 2, 2);
    AUDIO = localMediaType3;
    $VALUES = new MediaType[] { localMediaType1, localMediaType2, localMediaType3 };
    Companion = new MediaType.Companion(null);
  }
  
  private MediaType(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final MediaType fromValue(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.MediaType
 * JD-Core Version:    0.7.0.1
 */