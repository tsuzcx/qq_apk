package com.tencent.videocut.model;

import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/ExportSettingModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/ExportSettingModel$Builder;", "resolutionLevel", "", "fpsValue", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/videocut/model/ExportSettingModel;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ExportSettingModel
  extends AndroidMessage<ExportSettingModel, ExportSettingModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ExportSettingModel> ADAPTER = (ProtoAdapter)new ExportSettingModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ExportSettingModel.class), "type.googleapis.com/publisher.ExportSettingModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<ExportSettingModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final ExportSettingModel.Companion Companion = new ExportSettingModel.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=2)
  @JvmField
  @Nullable
  public final Integer fpsValue;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer resolutionLevel;
  
  public ExportSettingModel()
  {
    this(null, null, null, 7, null);
  }
  
  public ExportSettingModel(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.resolutionLevel = paramInteger1;
    this.fpsValue = paramInteger2;
  }
  
  @NotNull
  public final ExportSettingModel copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new ExportSettingModel(paramInteger1, paramInteger2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (ExportSettingModel)this) {
      return true;
    }
    if (!(paramObject instanceof ExportSettingModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (ExportSettingModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.resolutionLevel, paramObject.resolutionLevel)) && (Intrinsics.areEqual(this.fpsValue, paramObject.fpsValue));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int k = unknownFields().hashCode();
      Integer localInteger = this.resolutionLevel;
      j = 0;
      if (localInteger != null) {
        i = localInteger.hashCode();
      } else {
        i = 0;
      }
      localInteger = this.fpsValue;
      if (localInteger != null) {
        j = localInteger.hashCode();
      }
      i = (k * 37 + i) * 37 + j;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public ExportSettingModel.Builder newBuilder()
  {
    ExportSettingModel.Builder localBuilder = new ExportSettingModel.Builder();
    localBuilder.a = this.resolutionLevel;
    localBuilder.b = this.fpsValue;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.resolutionLevel != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("resolutionLevel=");
      localStringBuilder.append(this.resolutionLevel);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fpsValue != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fpsValue=");
      localStringBuilder.append(this.fpsValue);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"ExportSettingModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.ExportSettingModel
 * JD-Core Version:    0.7.0.1
 */