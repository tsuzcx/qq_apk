package com.tencent.tavcut.composition.model.component;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$Builder;", "index", "", "src", "", "replaceType", "sourceIndex", "scaleMode", "interactive", "", "textReplaceItem", "Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "ReplaceType", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PAGAsset$Replacement
  extends AndroidMessage<Replacement, PAGAsset.Replacement.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Replacement> ADAPTER = (ProtoAdapter)new PAGAsset.Replacement.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Replacement.class), "type.googleapis.com/publisher.PAGAsset.Replacement");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Replacement> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final PAGAsset.Replacement.Companion Companion = new PAGAsset.Replacement.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer index;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=6)
  @JvmField
  @Nullable
  public final Boolean interactive;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=3)
  @JvmField
  @Nullable
  public final Integer replaceType;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=5)
  @JvmField
  @Nullable
  public final Integer scaleMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=4)
  @JvmField
  @Nullable
  public final Integer sourceIndex;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String src;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.TextReplaceItem#ADAPTER", tag=7)
  @JvmField
  @Nullable
  public final TextReplaceItem textReplaceItem;
  
  public PAGAsset$Replacement()
  {
    this(null, null, null, null, null, null, null, null, 255, null);
  }
  
  public PAGAsset$Replacement(@Nullable Integer paramInteger1, @Nullable String paramString, @Nullable Integer paramInteger2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable Boolean paramBoolean, @Nullable TextReplaceItem paramTextReplaceItem, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.index = paramInteger1;
    this.src = paramString;
    this.replaceType = paramInteger2;
    this.sourceIndex = paramInteger3;
    this.scaleMode = paramInteger4;
    this.interactive = paramBoolean;
    this.textReplaceItem = paramTextReplaceItem;
  }
  
  @NotNull
  public final Replacement copy(@Nullable Integer paramInteger1, @Nullable String paramString, @Nullable Integer paramInteger2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable Boolean paramBoolean, @Nullable TextReplaceItem paramTextReplaceItem, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new Replacement(paramInteger1, paramString, paramInteger2, paramInteger3, paramInteger4, paramBoolean, paramTextReplaceItem, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Replacement)this) {
      return true;
    }
    if (!(paramObject instanceof Replacement)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Replacement)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.index, paramObject.index)) && (Intrinsics.areEqual(this.src, paramObject.src)) && (Intrinsics.areEqual(this.replaceType, paramObject.replaceType)) && (Intrinsics.areEqual(this.sourceIndex, paramObject.sourceIndex)) && (Intrinsics.areEqual(this.scaleMode, paramObject.scaleMode)) && (Intrinsics.areEqual(this.interactive, paramObject.interactive)) && (Intrinsics.areEqual(this.textReplaceItem, paramObject.textReplaceItem));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i3 = unknownFields().hashCode();
      Object localObject = this.index;
      int i2 = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.src;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.replaceType;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.sourceIndex;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.scaleMode;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.interactive;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.textReplaceItem;
      if (localObject != null) {
        i2 = localObject.hashCode();
      }
      i = ((((((i3 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public PAGAsset.Replacement.Builder newBuilder()
  {
    PAGAsset.Replacement.Builder localBuilder = new PAGAsset.Replacement.Builder();
    localBuilder.index = this.index;
    localBuilder.src = this.src;
    localBuilder.replaceType = this.replaceType;
    localBuilder.sourceIndex = this.sourceIndex;
    localBuilder.scaleMode = this.scaleMode;
    localBuilder.interactive = this.interactive;
    localBuilder.textReplaceItem = this.textReplaceItem;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.index != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("index=");
      localStringBuilder.append(this.index);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.src != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("src=");
      localStringBuilder.append(Internal.sanitize(this.src));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.replaceType != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("replaceType=");
      localStringBuilder.append(this.replaceType);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.sourceIndex != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sourceIndex=");
      localStringBuilder.append(this.sourceIndex);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.scaleMode != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("scaleMode=");
      localStringBuilder.append(this.scaleMode);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.interactive != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("interactive=");
      localStringBuilder.append(this.interactive);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.textReplaceItem != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("textReplaceItem=");
      localStringBuilder.append(this.textReplaceItem);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"Replacement{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PAGAsset.Replacement
 * JD-Core Version:    0.7.0.1
 */