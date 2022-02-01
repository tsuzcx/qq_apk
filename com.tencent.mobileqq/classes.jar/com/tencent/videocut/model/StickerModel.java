package com.tencent.videocut.model;

import .r8.java8methods.utility.Boolean.hashCode.IZ;
import .r8.java8methods.utility.Float.hashCode.IF;
import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/StickerModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/StickerModel$Builder;", "id", "", "filePath", "startTime", "", "duration", "layerIndex", "", "scale", "", "rotate", "centerX", "centerY", "editable", "", "width", "height", "minScale", "maxScale", "textItems", "", "Lcom/tencent/videocut/model/TextItem;", "thumbUrl", "timelineTrackIndex", "animationMode", "Lcom/tencent/videocut/model/AnimationMode;", "type", "Lcom/tencent/videocut/model/StickerModel$Type;", "materialId", "captionInfo", "Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "localThumbId", "editingLayerIndex", "playEndDuration", "actionType", "Lcom/tencent/videocut/model/StickerModel$ActionType;", "bgConfig", "bgPath", "configType", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;JJIFFFFZIIFFLjava/util/List;Ljava/lang/String;ILcom/tencent/videocut/model/AnimationMode;Lcom/tencent/videocut/model/StickerModel$Type;Ljava/lang/String;Lcom/tencent/videocut/model/StickerModel$CaptionInfo;IIJLcom/tencent/videocut/model/StickerModel$ActionType;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "equals", "other", "", "hashCode", "newBuilder", "toString", "ActionType", "Builder", "CaptionInfo", "CaptionSource", "Companion", "Type", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public class StickerModel
  extends AndroidMessage<StickerModel, StickerModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<StickerModel> ADAPTER = (ProtoAdapter)new StickerModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(StickerModel.class), "type.googleapis.com/publisher.StickerModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<StickerModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final StickerModel.Companion Companion = new StickerModel.Companion(null);
  @WireField(adapter="com.tencent.videocut.model.StickerModel$ActionType#ADAPTER", tag=25)
  @JvmField
  @NotNull
  public final StickerModel.ActionType actionType;
  @WireField(adapter="com.tencent.videocut.model.AnimationMode#ADAPTER", tag=18)
  @JvmField
  @NotNull
  public final AnimationMode animationMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", label=WireField.Label.REPEATED, tag=26)
  @JvmField
  @NotNull
  public final List<String> bgConfig;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=27)
  @JvmField
  @NotNull
  public final String bgPath;
  @WireField(adapter="com.tencent.videocut.model.StickerModel$CaptionInfo#ADAPTER", tag=21)
  @JvmField
  @Nullable
  public final StickerModel.CaptionInfo captionInfo;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=8)
  @JvmField
  public final float centerX;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=9)
  @JvmField
  public final float centerY;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=28)
  @JvmField
  @NotNull
  public final String configType;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=4)
  @JvmField
  public final long duration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=10)
  @JvmField
  public final boolean editable;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=23)
  @JvmField
  public final int editingLayerIndex;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @NotNull
  public final String filePath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=12)
  @JvmField
  public final int height;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @NotNull
  public final String id;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=5)
  @JvmField
  public final int layerIndex;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=22)
  @JvmField
  public final int localThumbId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=20)
  @JvmField
  @NotNull
  public final String materialId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=14)
  @JvmField
  public final float maxScale;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=13)
  @JvmField
  public final float minScale;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=24)
  @JvmField
  public final long playEndDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=7)
  @JvmField
  public final float rotate;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=6)
  @JvmField
  public final float scale;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=3)
  @JvmField
  public final long startTime;
  @WireField(adapter="com.tencent.videocut.model.TextItem#ADAPTER", label=WireField.Label.REPEATED, tag=15)
  @JvmField
  @NotNull
  public final List<TextItem> textItems;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=16)
  @JvmField
  @NotNull
  public final String thumbUrl;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=17)
  @JvmField
  public final int timelineTrackIndex;
  @WireField(adapter="com.tencent.videocut.model.StickerModel$Type#ADAPTER", tag=19)
  @JvmField
  @NotNull
  public final StickerModel.Type type;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=11)
  @JvmField
  public final int width;
  
  public StickerModel()
  {
    this(null, null, 0L, 0L, 0, 0.0F, 0.0F, 0.0F, 0.0F, false, 0, 0, 0.0F, 0.0F, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, 536870911, null);
  }
  
  public StickerModel(@NotNull String paramString1, @NotNull String paramString2, long paramLong1, long paramLong2, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean, int paramInt2, int paramInt3, float paramFloat5, float paramFloat6, @NotNull List<TextItem> paramList, @NotNull String paramString3, int paramInt4, @NotNull AnimationMode paramAnimationMode, @NotNull StickerModel.Type paramType, @NotNull String paramString4, @Nullable StickerModel.CaptionInfo paramCaptionInfo, int paramInt5, int paramInt6, long paramLong3, @NotNull StickerModel.ActionType paramActionType, @NotNull List<String> paramList1, @NotNull String paramString5, @NotNull String paramString6, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.id = paramString1;
    this.filePath = paramString2;
    this.startTime = paramLong1;
    this.duration = paramLong2;
    this.layerIndex = paramInt1;
    this.scale = paramFloat1;
    this.rotate = paramFloat2;
    this.centerX = paramFloat3;
    this.centerY = paramFloat4;
    this.editable = paramBoolean;
    this.width = paramInt2;
    this.height = paramInt3;
    this.minScale = paramFloat5;
    this.maxScale = paramFloat6;
    this.textItems = paramList;
    this.thumbUrl = paramString3;
    this.timelineTrackIndex = paramInt4;
    this.animationMode = paramAnimationMode;
    this.type = paramType;
    this.materialId = paramString4;
    this.captionInfo = paramCaptionInfo;
    this.localThumbId = paramInt5;
    this.editingLayerIndex = paramInt6;
    this.playEndDuration = paramLong3;
    this.actionType = paramActionType;
    this.bgConfig = paramList1;
    this.bgPath = paramString5;
    this.configType = paramString6;
  }
  
  @NotNull
  public final StickerModel copy(@NotNull String paramString1, @NotNull String paramString2, long paramLong1, long paramLong2, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean, int paramInt2, int paramInt3, float paramFloat5, float paramFloat6, @NotNull List<TextItem> paramList, @NotNull String paramString3, int paramInt4, @NotNull AnimationMode paramAnimationMode, @NotNull StickerModel.Type paramType, @NotNull String paramString4, @Nullable StickerModel.CaptionInfo paramCaptionInfo, int paramInt5, int paramInt6, long paramLong3, @NotNull StickerModel.ActionType paramActionType, @NotNull List<String> paramList1, @NotNull String paramString5, @NotNull String paramString6, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    Intrinsics.checkParameterIsNotNull(paramString2, "filePath");
    Intrinsics.checkParameterIsNotNull(paramList, "textItems");
    Intrinsics.checkParameterIsNotNull(paramString3, "thumbUrl");
    Intrinsics.checkParameterIsNotNull(paramAnimationMode, "animationMode");
    Intrinsics.checkParameterIsNotNull(paramType, "type");
    Intrinsics.checkParameterIsNotNull(paramString4, "materialId");
    Intrinsics.checkParameterIsNotNull(paramActionType, "actionType");
    Intrinsics.checkParameterIsNotNull(paramList1, "bgConfig");
    Intrinsics.checkParameterIsNotNull(paramString5, "bgPath");
    Intrinsics.checkParameterIsNotNull(paramString6, "configType");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new StickerModel(paramString1, paramString2, paramLong1, paramLong2, paramInt1, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBoolean, paramInt2, paramInt3, paramFloat5, paramFloat6, paramList, paramString3, paramInt4, paramAnimationMode, paramType, paramString4, paramCaptionInfo, paramInt5, paramInt6, paramLong3, paramActionType, paramList1, paramString5, paramString6, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (StickerModel)this) {
      return true;
    }
    if (!(paramObject instanceof StickerModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (StickerModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.id, paramObject.id)) && (Intrinsics.areEqual(this.filePath, paramObject.filePath)) && (this.startTime == paramObject.startTime) && (this.duration == paramObject.duration) && (this.layerIndex == paramObject.layerIndex) && (this.scale == paramObject.scale) && (this.rotate == paramObject.rotate) && (this.centerX == paramObject.centerX) && (this.centerY == paramObject.centerY) && (this.editable == paramObject.editable) && (this.width == paramObject.width) && (this.height == paramObject.height) && (this.minScale == paramObject.minScale) && (this.maxScale == paramObject.maxScale) && (Intrinsics.areEqual(this.textItems, paramObject.textItems)) && (Intrinsics.areEqual(this.thumbUrl, paramObject.thumbUrl)) && (this.timelineTrackIndex == paramObject.timelineTrackIndex) && (this.animationMode == paramObject.animationMode) && (this.type == paramObject.type) && (Intrinsics.areEqual(this.materialId, paramObject.materialId)) && (Intrinsics.areEqual(this.captionInfo, paramObject.captionInfo)) && (this.localThumbId == paramObject.localThumbId) && (this.editingLayerIndex == paramObject.editingLayerIndex) && (this.playEndDuration == paramObject.playEndDuration) && (this.actionType == paramObject.actionType) && (Intrinsics.areEqual(this.bgConfig, paramObject.bgConfig)) && (Intrinsics.areEqual(this.bgPath, paramObject.bgPath)) && (Intrinsics.areEqual(this.configType, paramObject.configType));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      j = unknownFields().hashCode();
      int k = this.id.hashCode();
      int m = this.filePath.hashCode();
      int n = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.startTime);
      int i1 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.duration);
      int i2 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.layerIndex);
      int i3 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.scale);
      int i4 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.rotate);
      int i5 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.centerX);
      int i6 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.centerY);
      int i7 = .r8.java8methods.utility.Boolean.hashCode.IZ.hashCode(this.editable);
      int i8 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.width);
      int i9 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.height);
      int i10 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.minScale);
      int i11 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.maxScale);
      int i12 = this.textItems.hashCode();
      int i13 = this.thumbUrl.hashCode();
      int i14 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.timelineTrackIndex);
      int i15 = this.animationMode.hashCode();
      int i16 = this.type.hashCode();
      int i17 = this.materialId.hashCode();
      StickerModel.CaptionInfo localCaptionInfo = this.captionInfo;
      if (localCaptionInfo != null) {
        i = localCaptionInfo.hashCode();
      } else {
        i = 0;
      }
      i = (((((((((((((((((((((((((((j * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i4) * 37 + i5) * 37 + i6) * 37 + i7) * 37 + i8) * 37 + i9) * 37 + i10) * 37 + i11) * 37 + i12) * 37 + i13) * 37 + i14) * 37 + i15) * 37 + i16) * 37 + i17) * 37 + i) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.localThumbId)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.editingLayerIndex)) * 37 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.playEndDuration)) * 37 + this.actionType.hashCode()) * 37 + this.bgConfig.hashCode()) * 37 + this.bgPath.hashCode()) * 37 + this.configType.hashCode();
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public StickerModel.Builder newBuilder()
  {
    StickerModel.Builder localBuilder = new StickerModel.Builder();
    localBuilder.a = this.id;
    localBuilder.b = this.filePath;
    localBuilder.c = this.startTime;
    localBuilder.d = this.duration;
    localBuilder.e = this.layerIndex;
    localBuilder.f = this.scale;
    localBuilder.g = this.rotate;
    localBuilder.h = this.centerX;
    localBuilder.i = this.centerY;
    localBuilder.j = this.editable;
    localBuilder.k = this.width;
    localBuilder.l = this.height;
    localBuilder.m = this.minScale;
    localBuilder.n = this.maxScale;
    localBuilder.o = this.textItems;
    localBuilder.p = this.thumbUrl;
    localBuilder.q = this.timelineTrackIndex;
    localBuilder.r = this.animationMode;
    localBuilder.s = this.type;
    localBuilder.t = this.materialId;
    localBuilder.u = this.captionInfo;
    localBuilder.v = this.localThumbId;
    localBuilder.w = this.editingLayerIndex;
    localBuilder.x = this.playEndDuration;
    localBuilder.y = this.actionType;
    localBuilder.z = this.bgConfig;
    localBuilder.A = this.bgPath;
    localBuilder.B = this.configType;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.id != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=");
      localStringBuilder.append(Internal.sanitize(this.id));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.filePath != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filePath=");
      localStringBuilder.append(Internal.sanitize(this.filePath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    long l = this.startTime;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTime=");
    localStringBuilder.append(this.startTime);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.duration;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("duration=");
    localStringBuilder.append(this.duration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    int i = this.layerIndex;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("layerIndex=");
    localStringBuilder.append(this.layerIndex);
    ((Collection)localObject2).add(localStringBuilder.toString());
    float f = this.scale;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("scale=");
    localStringBuilder.append(this.scale);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.rotate;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("rotate=");
    localStringBuilder.append(this.rotate);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.centerX;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("centerX=");
    localStringBuilder.append(this.centerX);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.centerY;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("centerY=");
    localStringBuilder.append(this.centerY);
    ((Collection)localObject2).add(localStringBuilder.toString());
    boolean bool = this.editable;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("editable=");
    localStringBuilder.append(this.editable);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.width;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("width=");
    localStringBuilder.append(this.width);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.height;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("height=");
    localStringBuilder.append(this.height);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.minScale;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("minScale=");
    localStringBuilder.append(this.minScale);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.maxScale;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxScale=");
    localStringBuilder.append(this.maxScale);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if ((((Collection)this.textItems).isEmpty() ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("textItems=");
      localStringBuilder.append(this.textItems);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.thumbUrl != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("thumbUrl=");
      localStringBuilder.append(Internal.sanitize(this.thumbUrl));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    i = this.timelineTrackIndex;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("timelineTrackIndex=");
    localStringBuilder.append(this.timelineTrackIndex);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.animationMode != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("animationMode=");
      localStringBuilder.append(this.animationMode);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.type != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("type=");
      localStringBuilder.append(this.type);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.materialId != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("materialId=");
      localStringBuilder.append(Internal.sanitize(this.materialId));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.captionInfo != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("captionInfo=");
      localStringBuilder.append(this.captionInfo);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    i = this.localThumbId;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("localThumbId=");
    localStringBuilder.append(this.localThumbId);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.editingLayerIndex;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("editingLayerIndex=");
    localStringBuilder.append(this.editingLayerIndex);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.playEndDuration;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("playEndDuration=");
    localStringBuilder.append(this.playEndDuration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.actionType != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("actionType=");
      localStringBuilder.append(this.actionType);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.bgConfig).isEmpty() ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bgConfig=");
      localStringBuilder.append(Internal.sanitize(this.bgConfig));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.bgPath != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bgPath=");
      localStringBuilder.append(Internal.sanitize(this.bgPath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.configType != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("configType=");
      localStringBuilder.append(Internal.sanitize(this.configType));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"StickerModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.StickerModel
 * JD-Core Version:    0.7.0.1
 */