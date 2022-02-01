package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/ContentMode;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "aspectFit", "aspectFill", "scaleToFit", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum ContentMode
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ContentMode> ADAPTER = (ProtoAdapter)new ContentMode.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(ContentMode.class));
  public static final ContentMode.Companion Companion;
  private final int value;
  
  static
  {
    ContentMode localContentMode1 = new ContentMode("aspectFit", 0, 0);
    aspectFit = localContentMode1;
    ContentMode localContentMode2 = new ContentMode("aspectFill", 1, 1);
    aspectFill = localContentMode2;
    ContentMode localContentMode3 = new ContentMode("scaleToFit", 2, 2);
    scaleToFit = localContentMode3;
    $VALUES = new ContentMode[] { localContentMode1, localContentMode2, localContentMode3 };
    Companion = new ContentMode.Companion(null);
  }
  
  private ContentMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final ContentMode fromValue(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.ContentMode
 * JD-Core Version:    0.7.0.1
 */