package com.tencent.tavcut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/LightAssetModel$MediaType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "VIDEO_ONLY", "PHOTO_ONLY", "MULTI_MEDIA", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public enum LightAssetModel$MediaType
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<MediaType> ADAPTER = (ProtoAdapter)new LightAssetModel.MediaType.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(MediaType.class));
  public static final LightAssetModel.MediaType.Companion Companion;
  private final int value;
  
  static
  {
    MediaType localMediaType1 = new MediaType("VIDEO_ONLY", 0, 0);
    VIDEO_ONLY = localMediaType1;
    MediaType localMediaType2 = new MediaType("PHOTO_ONLY", 1, 1);
    PHOTO_ONLY = localMediaType2;
    MediaType localMediaType3 = new MediaType("MULTI_MEDIA", 2, 2);
    MULTI_MEDIA = localMediaType3;
    $VALUES = new MediaType[] { localMediaType1, localMediaType2, localMediaType3 };
    Companion = new LightAssetModel.MediaType.Companion(null);
  }
  
  private LightAssetModel$MediaType(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final MediaType fromValue(int paramInt)
  {
    return Companion.fromValue(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LightAssetModel.MediaType
 * JD-Core Version:    0.7.0.1
 */