package com.tencent.tavcut.model;

import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.tavcut.composition.model.component.BackgroundFillMode;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Size;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/Painting;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/Painting$Builder;", "renderSize", "Lcom/tencent/tavcut/composition/model/component/Size;", "screenTransform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "backgroundFillMode", "Lcom/tencent/tavcut/composition/model/component/BackgroundFillMode;", "pagPath", "", "backgroundColor", "fillScale", "", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/tavcut/composition/model/component/Size;Lcom/tencent/tavcut/composition/model/component/ScreenTransform;Lcom/tencent/tavcut/composition/model/component/BackgroundFillMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lokio/ByteString;)V", "Ljava/lang/Float;", "copy", "(Lcom/tencent/tavcut/composition/model/component/Size;Lcom/tencent/tavcut/composition/model/component/ScreenTransform;Lcom/tencent/tavcut/composition/model/component/BackgroundFillMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/tavcut/model/Painting;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Painting
  extends AndroidMessage<Painting, Painting.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Painting> ADAPTER = (ProtoAdapter)new Painting.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Painting.class), "type.googleapis.com/publisher.Painting");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Painting> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final Painting.Companion Companion = new Painting.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=5)
  @JvmField
  @Nullable
  public final String backgroundColor;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.BackgroundFillMode#ADAPTER", tag=3)
  @JvmField
  @Nullable
  public final BackgroundFillMode backgroundFillMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=6)
  @JvmField
  @Nullable
  public final Float fillScale;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @Nullable
  public final String pagPath;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.Size#ADAPTER", tag=1)
  @JvmField
  @Nullable
  public final Size renderSize;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.ScreenTransform#ADAPTER", tag=2)
  @JvmField
  @Nullable
  public final ScreenTransform screenTransform;
  
  public Painting()
  {
    this(null, null, null, null, null, null, null, 127, null);
  }
  
  public Painting(@Nullable Size paramSize, @Nullable ScreenTransform paramScreenTransform, @Nullable BackgroundFillMode paramBackgroundFillMode, @Nullable String paramString1, @Nullable String paramString2, @Nullable Float paramFloat, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.renderSize = paramSize;
    this.screenTransform = paramScreenTransform;
    this.backgroundFillMode = paramBackgroundFillMode;
    this.pagPath = paramString1;
    this.backgroundColor = paramString2;
    this.fillScale = paramFloat;
  }
  
  @NotNull
  public final Painting copy(@Nullable Size paramSize, @Nullable ScreenTransform paramScreenTransform, @Nullable BackgroundFillMode paramBackgroundFillMode, @Nullable String paramString1, @Nullable String paramString2, @Nullable Float paramFloat, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new Painting(paramSize, paramScreenTransform, paramBackgroundFillMode, paramString1, paramString2, paramFloat, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Painting)this) {
      return true;
    }
    if (!(paramObject instanceof Painting)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Painting)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.renderSize, paramObject.renderSize)) && (Intrinsics.areEqual(this.screenTransform, paramObject.screenTransform)) && (this.backgroundFillMode == paramObject.backgroundFillMode) && (Intrinsics.areEqual(this.pagPath, paramObject.pagPath)) && (Intrinsics.areEqual(this.backgroundColor, paramObject.backgroundColor)) && (Intrinsics.areEqual(this.fillScale, paramObject.fillScale));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i2 = unknownFields().hashCode();
      Object localObject = this.renderSize;
      int i1 = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.screenTransform;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.backgroundFillMode;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.pagPath;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.backgroundColor;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.fillScale;
      if (localObject != null) {
        i1 = localObject.hashCode();
      }
      i = (((((i2 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public Painting.Builder newBuilder()
  {
    Painting.Builder localBuilder = new Painting.Builder();
    localBuilder.renderSize = this.renderSize;
    localBuilder.screenTransform = this.screenTransform;
    localBuilder.backgroundFillMode = this.backgroundFillMode;
    localBuilder.pagPath = this.pagPath;
    localBuilder.backgroundColor = this.backgroundColor;
    localBuilder.fillScale = this.fillScale;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.renderSize != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("renderSize=");
      localStringBuilder.append(this.renderSize);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.screenTransform != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("screenTransform=");
      localStringBuilder.append(this.screenTransform);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.backgroundFillMode != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("backgroundFillMode=");
      localStringBuilder.append(this.backgroundFillMode);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.pagPath != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pagPath=");
      localStringBuilder.append(Internal.sanitize(this.pagPath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.backgroundColor != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("backgroundColor=");
      localStringBuilder.append(Internal.sanitize(this.backgroundColor));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fillScale != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fillScale=");
      localStringBuilder.append(this.fillScale);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"Painting{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.Painting
 * JD-Core Version:    0.7.0.1
 */