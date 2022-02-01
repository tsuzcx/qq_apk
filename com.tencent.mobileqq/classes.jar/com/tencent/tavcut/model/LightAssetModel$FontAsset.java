package com.tencent.tavcut.model;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/LightAssetModel$FontAsset;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/LightAssetModel$FontAsset$Builder;", "fontFamily", "", "fontStyle", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightAssetModel$FontAsset
  extends AndroidMessage<FontAsset, LightAssetModel.FontAsset.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<FontAsset> ADAPTER = (ProtoAdapter)new LightAssetModel.FontAsset.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FontAsset.class), "type.googleapis.com/publisher.LightAssetModel.FontAsset");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<FontAsset> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final LightAssetModel.FontAsset.Companion Companion = new LightAssetModel.FontAsset.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String fontFamily;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String fontStyle;
  
  public LightAssetModel$FontAsset()
  {
    this(null, null, null, 7, null);
  }
  
  public LightAssetModel$FontAsset(@Nullable String paramString1, @Nullable String paramString2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.fontFamily = paramString1;
    this.fontStyle = paramString2;
  }
  
  @NotNull
  public final FontAsset copy(@Nullable String paramString1, @Nullable String paramString2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new FontAsset(paramString1, paramString2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (FontAsset)this) {
      return true;
    }
    if (!(paramObject instanceof FontAsset)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (FontAsset)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.fontFamily, paramObject.fontFamily)) && (Intrinsics.areEqual(this.fontStyle, paramObject.fontStyle));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int k = unknownFields().hashCode();
      String str = this.fontFamily;
      j = 0;
      if (str != null) {
        i = str.hashCode();
      } else {
        i = 0;
      }
      str = this.fontStyle;
      if (str != null) {
        j = str.hashCode();
      }
      i = (k * 37 + i) * 37 + j;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public LightAssetModel.FontAsset.Builder newBuilder()
  {
    LightAssetModel.FontAsset.Builder localBuilder = new LightAssetModel.FontAsset.Builder();
    localBuilder.fontFamily = this.fontFamily;
    localBuilder.fontStyle = this.fontStyle;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.fontFamily != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontFamily=");
      localStringBuilder.append(Internal.sanitize(this.fontFamily));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fontStyle != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontStyle=");
      localStringBuilder.append(Internal.sanitize(this.fontStyle));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"FontAsset{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LightAssetModel.FontAsset
 * JD-Core Version:    0.7.0.1
 */