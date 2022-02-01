package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/StickerModel$CaptionSource;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "VIDEO", "MUSIC", "RECORD", "SEPARATE", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum StickerModel$CaptionSource
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<CaptionSource> ADAPTER = (ProtoAdapter)new StickerModel.CaptionSource.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(CaptionSource.class));
  public static final StickerModel.CaptionSource.Companion Companion;
  private final int value;
  
  static
  {
    CaptionSource localCaptionSource1 = new CaptionSource("VIDEO", 0, 0);
    VIDEO = localCaptionSource1;
    CaptionSource localCaptionSource2 = new CaptionSource("MUSIC", 1, 1);
    MUSIC = localCaptionSource2;
    CaptionSource localCaptionSource3 = new CaptionSource("RECORD", 2, 2);
    RECORD = localCaptionSource3;
    CaptionSource localCaptionSource4 = new CaptionSource("SEPARATE", 3, 3);
    SEPARATE = localCaptionSource4;
    $VALUES = new CaptionSource[] { localCaptionSource1, localCaptionSource2, localCaptionSource3, localCaptionSource4 };
    Companion = new StickerModel.CaptionSource.Companion(null);
  }
  
  private StickerModel$CaptionSource(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final CaptionSource fromValue(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.StickerModel.CaptionSource
 * JD-Core Version:    0.7.0.1
 */