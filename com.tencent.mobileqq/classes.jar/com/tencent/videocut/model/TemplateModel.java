package com.tencent.videocut.model;

import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/TemplateModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/TemplateModel$Builder;", "id", "", "path", "name", "audioModel", "", "Lcom/tencent/videocut/model/AudioModel;", "fontInfo", "Lcom/tencent/videocut/model/TemplateModel$FontInfo;", "aiInfo", "Lcom/tencent/videocut/model/TemplateModel$AiInfo;", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "AiInfo", "Builder", "Companion", "FontInfo", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TemplateModel
  extends AndroidMessage<TemplateModel, TemplateModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<TemplateModel> ADAPTER = (ProtoAdapter)new TemplateModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TemplateModel.class), "type.googleapis.com/publisher.TemplateModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<TemplateModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final TemplateModel.Companion Companion = new TemplateModel.Companion(null);
  @WireField(adapter="com.tencent.videocut.model.TemplateModel$AiInfo#ADAPTER", label=WireField.Label.REPEATED, tag=6)
  @JvmField
  @NotNull
  public final List<TemplateModel.AiInfo> aiInfo;
  @WireField(adapter="com.tencent.videocut.model.AudioModel#ADAPTER", label=WireField.Label.REPEATED, tag=4)
  @JvmField
  @NotNull
  public final List<AudioModel> audioModel;
  @WireField(adapter="com.tencent.videocut.model.TemplateModel$FontInfo#ADAPTER", label=WireField.Label.REPEATED, tag=5)
  @JvmField
  @NotNull
  public final List<TemplateModel.FontInfo> fontInfo;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String id;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=3)
  @JvmField
  @Nullable
  public final String name;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String path;
  
  public TemplateModel()
  {
    this(null, null, null, null, null, null, null, 127, null);
  }
  
  public TemplateModel(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull List<AudioModel> paramList, @NotNull List<TemplateModel.FontInfo> paramList1, @NotNull List<TemplateModel.AiInfo> paramList2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.id = paramString1;
    this.path = paramString2;
    this.name = paramString3;
    this.audioModel = paramList;
    this.fontInfo = paramList1;
    this.aiInfo = paramList2;
  }
  
  @NotNull
  public final TemplateModel copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull List<AudioModel> paramList, @NotNull List<TemplateModel.FontInfo> paramList1, @NotNull List<TemplateModel.AiInfo> paramList2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "audioModel");
    Intrinsics.checkParameterIsNotNull(paramList1, "fontInfo");
    Intrinsics.checkParameterIsNotNull(paramList2, "aiInfo");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new TemplateModel(paramString1, paramString2, paramString3, paramList, paramList1, paramList2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (TemplateModel)this) {
      return true;
    }
    if (!(paramObject instanceof TemplateModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (TemplateModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.id, paramObject.id)) && (Intrinsics.areEqual(this.path, paramObject.path)) && (Intrinsics.areEqual(this.name, paramObject.name)) && (Intrinsics.areEqual(this.audioModel, paramObject.audioModel)) && (Intrinsics.areEqual(this.fontInfo, paramObject.fontInfo)) && (Intrinsics.areEqual(this.aiInfo, paramObject.aiInfo));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int m = unknownFields().hashCode();
      String str = this.id;
      int k = 0;
      if (str != null) {
        i = str.hashCode();
      } else {
        i = 0;
      }
      str = this.path;
      if (str != null) {
        j = str.hashCode();
      } else {
        j = 0;
      }
      str = this.name;
      if (str != null) {
        k = str.hashCode();
      }
      i = (((((m * 37 + i) * 37 + j) * 37 + k) * 37 + this.audioModel.hashCode()) * 37 + this.fontInfo.hashCode()) * 37 + this.aiInfo.hashCode();
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public TemplateModel.Builder newBuilder()
  {
    TemplateModel.Builder localBuilder = new TemplateModel.Builder();
    localBuilder.a = this.id;
    localBuilder.b = this.path;
    localBuilder.c = this.name;
    localBuilder.d = this.audioModel;
    localBuilder.e = this.fontInfo;
    localBuilder.f = this.aiInfo;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.id != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=");
      localStringBuilder.append(Internal.sanitize(this.id));
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
    if (this.name != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("name=");
      localStringBuilder.append(Internal.sanitize(this.name));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.audioModel).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("audioModel=");
      localStringBuilder.append(this.audioModel);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.fontInfo).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontInfo=");
      localStringBuilder.append(this.fontInfo);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.aiInfo).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("aiInfo=");
      localStringBuilder.append(this.aiInfo);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"TemplateModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TemplateModel
 * JD-Core Version:    0.7.0.1
 */