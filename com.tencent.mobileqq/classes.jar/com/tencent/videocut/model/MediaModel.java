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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/MediaModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/MediaModel$Builder;", "id", "", "name", "version", "createTime", "", "updateTime", "duration", "videos", "", "Lcom/tencent/videocut/model/MediaClip;", "audios", "", "Lcom/tencent/videocut/model/AudioModel;", "stickers", "Lcom/tencent/videocut/model/StickerModel;", "backgroundModel", "Lcom/tencent/videocut/model/BackgroundModel;", "filterModels", "Lcom/tencent/videocut/model/FilterModel;", "specialEffects", "Lcom/tencent/videocut/model/SpecialEffectModel;", "transitions", "Lcom/tencent/videocut/model/TransitionModel;", "templateModel", "Lcom/tencent/videocut/model/TemplateModel;", "pips", "Lcom/tencent/videocut/model/PipModel;", "coverInfo", "Lcom/tencent/videocut/model/CoverInfo;", "exportSetting", "Lcom/tencent/videocut/model/ExportSettingModel;", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/videocut/model/BackgroundModel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/videocut/model/TemplateModel;Ljava/util/Map;Lcom/tencent/videocut/model/CoverInfo;Lcom/tencent/videocut/model/ExportSettingModel;Lokio/ByteString;)V", "Ljava/lang/Long;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/videocut/model/BackgroundModel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/videocut/model/TemplateModel;Ljava/util/Map;Lcom/tencent/videocut/model/CoverInfo;Lcom/tencent/videocut/model/ExportSettingModel;Lokio/ByteString;)Lcom/tencent/videocut/model/MediaModel;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MediaModel
  extends AndroidMessage<MediaModel, MediaModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<MediaModel> ADAPTER = (ProtoAdapter)new MediaModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MediaModel.class), "type.googleapis.com/publisher.MediaModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<MediaModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final MediaModel.Companion Companion = new MediaModel.Companion(null);
  @WireField(adapter="com.tencent.videocut.model.AudioModel#ADAPTER", keyAdapter="com.squareup.wire.ProtoAdapter#STRING", tag=1002)
  @JvmField
  @NotNull
  public final Map<String, AudioModel> audios;
  @WireField(adapter="com.tencent.videocut.model.BackgroundModel#ADAPTER", tag=2002)
  @JvmField
  @Nullable
  public final BackgroundModel backgroundModel;
  @WireField(adapter="com.tencent.videocut.model.CoverInfo#ADAPTER", tag=3001)
  @JvmField
  @Nullable
  public final CoverInfo coverInfo;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=4)
  @JvmField
  @Nullable
  public final Long createTime;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=6)
  @JvmField
  @Nullable
  public final Long duration;
  @WireField(adapter="com.tencent.videocut.model.ExportSettingModel#ADAPTER", tag=4001)
  @JvmField
  @Nullable
  public final ExportSettingModel exportSetting;
  @WireField(adapter="com.tencent.videocut.model.FilterModel#ADAPTER", keyAdapter="com.squareup.wire.ProtoAdapter#STRING", tag=2003)
  @JvmField
  @NotNull
  public final Map<String, FilterModel> filterModels;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String id;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String name;
  @WireField(adapter="com.tencent.videocut.model.PipModel#ADAPTER", keyAdapter="com.squareup.wire.ProtoAdapter#STRING", tag=2007)
  @JvmField
  @NotNull
  public final Map<String, PipModel> pips;
  @WireField(adapter="com.tencent.videocut.model.SpecialEffectModel#ADAPTER", keyAdapter="com.squareup.wire.ProtoAdapter#STRING", tag=2004)
  @JvmField
  @NotNull
  public final Map<String, SpecialEffectModel> specialEffects;
  @WireField(adapter="com.tencent.videocut.model.StickerModel#ADAPTER", keyAdapter="com.squareup.wire.ProtoAdapter#STRING", tag=2001)
  @JvmField
  @NotNull
  public final Map<String, StickerModel> stickers;
  @WireField(adapter="com.tencent.videocut.model.TemplateModel#ADAPTER", tag=2006)
  @JvmField
  @Nullable
  public final TemplateModel templateModel;
  @WireField(adapter="com.tencent.videocut.model.TransitionModel#ADAPTER", keyAdapter="com.squareup.wire.ProtoAdapter#STRING", tag=2005)
  @JvmField
  @NotNull
  public final Map<String, TransitionModel> transitions;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=5)
  @JvmField
  @Nullable
  public final Long updateTime;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=3)
  @JvmField
  @Nullable
  public final String version;
  @WireField(adapter="com.tencent.videocut.model.MediaClip#ADAPTER", label=WireField.Label.REPEATED, tag=1001)
  @JvmField
  @NotNull
  public final List<MediaClip> videos;
  
  public MediaModel()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
  }
  
  public MediaModel(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Long paramLong3, @NotNull List<MediaClip> paramList, @NotNull Map<String, AudioModel> paramMap, @NotNull Map<String, ? extends StickerModel> paramMap1, @Nullable BackgroundModel paramBackgroundModel, @NotNull Map<String, FilterModel> paramMap2, @NotNull Map<String, SpecialEffectModel> paramMap3, @NotNull Map<String, TransitionModel> paramMap4, @Nullable TemplateModel paramTemplateModel, @NotNull Map<String, PipModel> paramMap5, @Nullable CoverInfo paramCoverInfo, @Nullable ExportSettingModel paramExportSettingModel, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.id = paramString1;
    this.name = paramString2;
    this.version = paramString3;
    this.createTime = paramLong1;
    this.updateTime = paramLong2;
    this.duration = paramLong3;
    this.videos = paramList;
    this.audios = paramMap;
    this.stickers = paramMap1;
    this.backgroundModel = paramBackgroundModel;
    this.filterModels = paramMap2;
    this.specialEffects = paramMap3;
    this.transitions = paramMap4;
    this.templateModel = paramTemplateModel;
    this.pips = paramMap5;
    this.coverInfo = paramCoverInfo;
    this.exportSetting = paramExportSettingModel;
  }
  
  @NotNull
  public final MediaModel copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Long paramLong3, @NotNull List<MediaClip> paramList, @NotNull Map<String, AudioModel> paramMap, @NotNull Map<String, ? extends StickerModel> paramMap1, @Nullable BackgroundModel paramBackgroundModel, @NotNull Map<String, FilterModel> paramMap2, @NotNull Map<String, SpecialEffectModel> paramMap3, @NotNull Map<String, TransitionModel> paramMap4, @Nullable TemplateModel paramTemplateModel, @NotNull Map<String, PipModel> paramMap5, @Nullable CoverInfo paramCoverInfo, @Nullable ExportSettingModel paramExportSettingModel, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "videos");
    Intrinsics.checkParameterIsNotNull(paramMap, "audios");
    Intrinsics.checkParameterIsNotNull(paramMap1, "stickers");
    Intrinsics.checkParameterIsNotNull(paramMap2, "filterModels");
    Intrinsics.checkParameterIsNotNull(paramMap3, "specialEffects");
    Intrinsics.checkParameterIsNotNull(paramMap4, "transitions");
    Intrinsics.checkParameterIsNotNull(paramMap5, "pips");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new MediaModel(paramString1, paramString2, paramString3, paramLong1, paramLong2, paramLong3, Internal.immutableCopyOf("videos", paramList), (Map)new LinkedHashMap(paramMap), (Map)new LinkedHashMap(paramMap1), paramBackgroundModel, (Map)new LinkedHashMap(paramMap2), (Map)new LinkedHashMap(paramMap3), (Map)new LinkedHashMap(paramMap4), paramTemplateModel, (Map)new LinkedHashMap(paramMap5), paramCoverInfo, paramExportSettingModel, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (MediaModel)this) {
      return true;
    }
    if (!(paramObject instanceof MediaModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (MediaModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.id, paramObject.id)) && (Intrinsics.areEqual(this.name, paramObject.name)) && (Intrinsics.areEqual(this.version, paramObject.version)) && (Intrinsics.areEqual(this.createTime, paramObject.createTime)) && (Intrinsics.areEqual(this.updateTime, paramObject.updateTime)) && (Intrinsics.areEqual(this.duration, paramObject.duration)) && (Intrinsics.areEqual(this.videos, paramObject.videos)) && (Intrinsics.areEqual(this.audios, paramObject.audios)) && (Intrinsics.areEqual(this.stickers, paramObject.stickers)) && (Intrinsics.areEqual(this.backgroundModel, paramObject.backgroundModel)) && (Intrinsics.areEqual(this.filterModels, paramObject.filterModels)) && (Intrinsics.areEqual(this.specialEffects, paramObject.specialEffects)) && (Intrinsics.areEqual(this.transitions, paramObject.transitions)) && (Intrinsics.areEqual(this.templateModel, paramObject.templateModel)) && (Intrinsics.areEqual(this.pips, paramObject.pips)) && (Intrinsics.areEqual(this.coverInfo, paramObject.coverInfo)) && (Intrinsics.areEqual(this.exportSetting, paramObject.exportSetting));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i6 = unknownFields().hashCode();
      Object localObject = this.id;
      int i5 = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.name;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.version;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.createTime;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.updateTime;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.duration;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      int i7 = this.videos.hashCode();
      int i8 = this.audios.hashCode();
      int i9 = this.stickers.hashCode();
      localObject = this.backgroundModel;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      int i10 = this.filterModels.hashCode();
      int i11 = this.specialEffects.hashCode();
      int i12 = this.transitions.hashCode();
      localObject = this.templateModel;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      int i13 = this.pips.hashCode();
      localObject = this.coverInfo;
      int i4;
      if (localObject != null) {
        i4 = localObject.hashCode();
      } else {
        i4 = 0;
      }
      localObject = this.exportSetting;
      if (localObject != null) {
        i5 = localObject.hashCode();
      }
      i = ((((((((((((((((i6 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i7) * 37 + i8) * 37 + i9) * 37 + i2) * 37 + i10) * 37 + i11) * 37 + i12) * 37 + i3) * 37 + i13) * 37 + i4) * 37 + i5;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public MediaModel.Builder newBuilder()
  {
    MediaModel.Builder localBuilder = new MediaModel.Builder();
    localBuilder.a = this.id;
    localBuilder.b = this.name;
    localBuilder.c = this.version;
    localBuilder.d = this.createTime;
    localBuilder.e = this.updateTime;
    localBuilder.f = this.duration;
    localBuilder.g = this.videos;
    localBuilder.h = this.audios;
    localBuilder.i = this.stickers;
    localBuilder.j = this.backgroundModel;
    localBuilder.k = this.filterModels;
    localBuilder.l = this.specialEffects;
    localBuilder.m = this.transitions;
    localBuilder.n = this.templateModel;
    localBuilder.o = this.pips;
    localBuilder.p = this.coverInfo;
    localBuilder.q = this.exportSetting;
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
    if (this.name != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("name=");
      localStringBuilder.append(Internal.sanitize(this.name));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.version != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("version=");
      localStringBuilder.append(Internal.sanitize(this.version));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.createTime != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("createTime=");
      localStringBuilder.append(this.createTime);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.updateTime != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTime=");
      localStringBuilder.append(this.updateTime);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.duration != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("duration=");
      localStringBuilder.append(this.duration);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.videos).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("videos=");
      localStringBuilder.append(this.videos);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((this.audios.isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("audios=");
      localStringBuilder.append(this.audios);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((this.stickers.isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("stickers=");
      localStringBuilder.append(this.stickers);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.backgroundModel != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("backgroundModel=");
      localStringBuilder.append(this.backgroundModel);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((this.filterModels.isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filterModels=");
      localStringBuilder.append(this.filterModels);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((this.specialEffects.isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("specialEffects=");
      localStringBuilder.append(this.specialEffects);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((this.transitions.isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("transitions=");
      localStringBuilder.append(this.transitions);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.templateModel != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("templateModel=");
      localStringBuilder.append(this.templateModel);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((this.pips.isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pips=");
      localStringBuilder.append(this.pips);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.coverInfo != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("coverInfo=");
      localStringBuilder.append(this.coverInfo);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.exportSetting != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("exportSetting=");
      localStringBuilder.append(this.exportSetting);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"MediaModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.MediaModel
 * JD-Core Version:    0.7.0.1
 */