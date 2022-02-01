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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/BackgroundResPack;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/BackgroundResPack$Builder;", "ratio16to9", "", "ratio9to16", "ratio1to1", "ratio3to4", "ratio4to3", "ratio1to2", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class BackgroundResPack
  extends AndroidMessage<BackgroundResPack, BackgroundResPack.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<BackgroundResPack> ADAPTER = (ProtoAdapter)new BackgroundResPack.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(BackgroundResPack.class), "type.googleapis.com/publisher.BackgroundResPack");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<BackgroundResPack> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final BackgroundResPack.Companion Companion = new BackgroundResPack.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String ratio16to9;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=3)
  @JvmField
  @Nullable
  public final String ratio1to1;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=6)
  @JvmField
  @Nullable
  public final String ratio1to2;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @Nullable
  public final String ratio3to4;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=5)
  @JvmField
  @Nullable
  public final String ratio4to3;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String ratio9to16;
  
  public BackgroundResPack()
  {
    this(null, null, null, null, null, null, null, 127, null);
  }
  
  public BackgroundResPack(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.ratio16to9 = paramString1;
    this.ratio9to16 = paramString2;
    this.ratio1to1 = paramString3;
    this.ratio3to4 = paramString4;
    this.ratio4to3 = paramString5;
    this.ratio1to2 = paramString6;
  }
  
  @NotNull
  public final BackgroundResPack copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new BackgroundResPack(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (BackgroundResPack)this) {
      return true;
    }
    if (!(paramObject instanceof BackgroundResPack)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (BackgroundResPack)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.ratio16to9, paramObject.ratio16to9)) && (Intrinsics.areEqual(this.ratio9to16, paramObject.ratio9to16)) && (Intrinsics.areEqual(this.ratio1to1, paramObject.ratio1to1)) && (Intrinsics.areEqual(this.ratio3to4, paramObject.ratio3to4)) && (Intrinsics.areEqual(this.ratio4to3, paramObject.ratio4to3)) && (Intrinsics.areEqual(this.ratio1to2, paramObject.ratio1to2));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i2 = unknownFields().hashCode();
      String str = this.ratio16to9;
      int i1 = 0;
      if (str != null) {
        i = str.hashCode();
      } else {
        i = 0;
      }
      str = this.ratio9to16;
      if (str != null) {
        j = str.hashCode();
      } else {
        j = 0;
      }
      str = this.ratio1to1;
      int k;
      if (str != null) {
        k = str.hashCode();
      } else {
        k = 0;
      }
      str = this.ratio3to4;
      int m;
      if (str != null) {
        m = str.hashCode();
      } else {
        m = 0;
      }
      str = this.ratio4to3;
      int n;
      if (str != null) {
        n = str.hashCode();
      } else {
        n = 0;
      }
      str = this.ratio1to2;
      if (str != null) {
        i1 = str.hashCode();
      }
      i = (((((i2 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public BackgroundResPack.Builder newBuilder()
  {
    BackgroundResPack.Builder localBuilder = new BackgroundResPack.Builder();
    localBuilder.a = this.ratio16to9;
    localBuilder.b = this.ratio9to16;
    localBuilder.c = this.ratio1to1;
    localBuilder.d = this.ratio3to4;
    localBuilder.e = this.ratio4to3;
    localBuilder.f = this.ratio1to2;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.ratio16to9 != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ratio16to9=");
      localStringBuilder.append(Internal.sanitize(this.ratio16to9));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.ratio9to16 != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ratio9to16=");
      localStringBuilder.append(Internal.sanitize(this.ratio9to16));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.ratio1to1 != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ratio1to1=");
      localStringBuilder.append(Internal.sanitize(this.ratio1to1));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.ratio3to4 != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ratio3to4=");
      localStringBuilder.append(Internal.sanitize(this.ratio3to4));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.ratio4to3 != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ratio4to3=");
      localStringBuilder.append(Internal.sanitize(this.ratio4to3));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.ratio1to2 != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ratio1to2=");
      localStringBuilder.append(Internal.sanitize(this.ratio1to2));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"BackgroundResPack{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.BackgroundResPack
 * JD-Core Version:    0.7.0.1
 */