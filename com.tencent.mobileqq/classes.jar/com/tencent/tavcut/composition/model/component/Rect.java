package com.tencent.tavcut.composition.model.component;

import .r8.java8methods.utility.Float.hashCode.IF;
import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Rect;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Rect$Builder;", "left", "", "top", "right", "bottom", "unknownFields", "Lokio/ByteString;", "(FFFFLokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Rect
  extends AndroidMessage<Rect, Rect.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Rect> ADAPTER = (ProtoAdapter)new Rect.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Rect.class), "type.googleapis.com/publisher.Rect");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Rect> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final Rect.Companion Companion = new Rect.Companion(null);
  public static final float DEFAULT_BOTTOM = 0.0F;
  public static final float DEFAULT_LEFT = 0.0F;
  public static final float DEFAULT_RIGHT = 0.0F;
  public static final float DEFAULT_TOP = 0.0F;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=4)
  @JvmField
  public final float bottom;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=1)
  @JvmField
  public final float left;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=3)
  @JvmField
  public final float right;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=2)
  @JvmField
  public final float top;
  
  public Rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.left = paramFloat1;
    this.top = paramFloat2;
    this.right = paramFloat3;
    this.bottom = paramFloat4;
  }
  
  @NotNull
  public final Rect copy(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new Rect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Rect)this) {
      return true;
    }
    if (!(paramObject instanceof Rect)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Rect)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.left == paramObject.left) && (this.top == paramObject.top) && (this.right == paramObject.right) && (this.bottom == paramObject.bottom);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = (((unknownFields().hashCode() * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.left)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.top)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.right)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.bottom);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public Rect.Builder newBuilder()
  {
    Rect.Builder localBuilder = new Rect.Builder();
    localBuilder.left = Float.valueOf(this.left);
    localBuilder.top = Float.valueOf(this.top);
    localBuilder.right = Float.valueOf(this.right);
    localBuilder.bottom = Float.valueOf(this.bottom);
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("left=");
    localStringBuilder.append(this.left);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("top=");
    localStringBuilder.append(this.top);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("right=");
    localStringBuilder.append(this.right);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("bottom=");
    localStringBuilder.append(this.bottom);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"Rect{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Rect
 * JD-Core Version:    0.7.0.1
 */