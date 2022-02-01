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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/TemplateModel$FontInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/TemplateModel$FontInfo$Builder;", "name", "", "style", "path", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TemplateModel$FontInfo
  extends AndroidMessage<FontInfo, TemplateModel.FontInfo.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<FontInfo> ADAPTER = (ProtoAdapter)new TemplateModel.FontInfo.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FontInfo.class), "type.googleapis.com/publisher.TemplateModel.FontInfo");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<FontInfo> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final TemplateModel.FontInfo.Companion Companion = new TemplateModel.FontInfo.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String name;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=3)
  @JvmField
  @Nullable
  public final String path;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String style;
  
  public TemplateModel$FontInfo()
  {
    this(null, null, null, null, 15, null);
  }
  
  public TemplateModel$FontInfo(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.name = paramString1;
    this.style = paramString2;
    this.path = paramString3;
  }
  
  @NotNull
  public final FontInfo copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new FontInfo(paramString1, paramString2, paramString3, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (FontInfo)this) {
      return true;
    }
    if (!(paramObject instanceof FontInfo)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (FontInfo)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.name, paramObject.name)) && (Intrinsics.areEqual(this.style, paramObject.style)) && (Intrinsics.areEqual(this.path, paramObject.path));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int m = unknownFields().hashCode();
      String str = this.name;
      int k = 0;
      if (str != null) {
        i = str.hashCode();
      } else {
        i = 0;
      }
      str = this.style;
      if (str != null) {
        j = str.hashCode();
      } else {
        j = 0;
      }
      str = this.path;
      if (str != null) {
        k = str.hashCode();
      }
      i = ((m * 37 + i) * 37 + j) * 37 + k;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public TemplateModel.FontInfo.Builder newBuilder()
  {
    TemplateModel.FontInfo.Builder localBuilder = new TemplateModel.FontInfo.Builder();
    localBuilder.a = this.name;
    localBuilder.b = this.style;
    localBuilder.c = this.path;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.name != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("name=");
      localStringBuilder.append(Internal.sanitize(this.name));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.style != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("style=");
      localStringBuilder.append(Internal.sanitize(this.style));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.path != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("path=");
      localStringBuilder.append(Internal.sanitize(this.path));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"FontInfo{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TemplateModel.FontInfo
 * JD-Core Version:    0.7.0.1
 */