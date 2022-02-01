package com.tencent.videocut.model;

import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/AudioModel$LyricInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/AudioModel$LyricInfo$Builder;", "strFormat", "", "strLyric", "strMatchLyric", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModel$LyricInfo
  extends AndroidMessage<LyricInfo, AudioModel.LyricInfo.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<LyricInfo> ADAPTER = (ProtoAdapter)new AudioModel.LyricInfo.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LyricInfo.class), "type.googleapis.com/publisher.AudioModel.LyricInfo");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<LyricInfo> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final AudioModel.LyricInfo.Companion Companion = new AudioModel.LyricInfo.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @NotNull
  public final String strFormat;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @NotNull
  public final String strLyric;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=3)
  @JvmField
  @NotNull
  public final String strMatchLyric;
  
  public AudioModel$LyricInfo()
  {
    this(null, null, null, null, 15, null);
  }
  
  public AudioModel$LyricInfo(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.strFormat = paramString1;
    this.strLyric = paramString2;
    this.strMatchLyric = paramString3;
  }
  
  @NotNull
  public final LyricInfo copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    if (paramString1 == null) {
      paramString1 = "";
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    return new LyricInfo(paramString1, paramString2, paramString3, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (LyricInfo)this) {
      return true;
    }
    if (!(paramObject instanceof LyricInfo)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (LyricInfo)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.strFormat, paramObject.strFormat)) && (Intrinsics.areEqual(this.strLyric, paramObject.strLyric)) && (Intrinsics.areEqual(this.strMatchLyric, paramObject.strMatchLyric));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = ((unknownFields().hashCode() * 37 + this.strFormat.hashCode()) * 37 + this.strLyric.hashCode()) * 37 + this.strMatchLyric.hashCode();
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public AudioModel.LyricInfo.Builder newBuilder()
  {
    AudioModel.LyricInfo.Builder localBuilder = new AudioModel.LyricInfo.Builder();
    localBuilder.a = this.strFormat;
    localBuilder.b = this.strLyric;
    localBuilder.c = this.strMatchLyric;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.strFormat != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("strFormat=");
      localStringBuilder.append(Internal.sanitize(this.strFormat));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.strLyric != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("strLyric=");
      localStringBuilder.append(Internal.sanitize(this.strLyric));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.strMatchLyric != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("strMatchLyric=");
      localStringBuilder.append(Internal.sanitize(this.strMatchLyric));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"LyricInfo{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel.LyricInfo
 * JD-Core Version:    0.7.0.1
 */