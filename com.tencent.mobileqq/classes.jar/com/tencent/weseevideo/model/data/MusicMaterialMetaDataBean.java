package com.tencent.weseevideo.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.BaseColumns;
import com.google.gson.annotations.SerializedName;
import com.tencent.weishi.module.publisher.data.VolumeAutomaticEffect;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/data/MusicMaterialMetaDataBean;", "Landroid/provider/BaseColumns;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "id", "", "sid", "", "name", "desc", "type", "thumbUrl", "version", "", "miniSptVersion", "packageUrl", "path", "feedlist_time_id", "feedlist_hot_id", "topic_ids", "", "mask", "shortName", "rich_flag", "title", "feedNum", "startTime", "endTime", "orgStartTime", "followFeedId", "mTogetherFeed", "mTogetherType", "mFeedUseType", "mDefaultFeedPosition", "mDefaultTogetherFeed", "collectTime", "audioDuration", "isCollected", "autoPlay", "", "exclusive", "lyric", "secLyric", "lyricFormat", "secLyricFormat", "label", "songLabels", "", "nameIndices", "Lcom/tencent/weseevideo/model/data/MusicMaterialMetaDataBean$HighlightIndex;", "descIndices", "indexInCategory", "mFromDataType", "mTotalTime", "refer", "state", "categroyId", "isCloseLyric", "", "iSource", "segDuration", "recommendInfo", "musicFrom", "isStuckPoint", "stuckPointJsonUrl", "isImportType", "importTime", "startInTime", "endOutTime", "startPlayOffset", "isEdit", "userStartTime", "volume", "", "mTotalTimeMs", "mVolumeAutomaticEffectList", "", "Lcom/tencent/weishi/module/publisher/data/VolumeAutomaticEffect;", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;ILjava/lang/String;IIIILjava/lang/String;Ljava/lang/String;IIIIJIIBILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;IIIIILjava/lang/String;ZIILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZJJJJZJFJLjava/util/List;)V", "endOutTime$annotations", "()V", "mTotalTime$annotations", "startInTime$annotations", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component7", "component8", "component9", "copy", "deepClone", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "HighlightIndex", "libtavcut_debug"}, k=1, mv={1, 1, 16})
@Parcelize
public final class MusicMaterialMetaDataBean
  implements Parcelable, BaseColumns, Serializable
{
  public static final Parcelable.Creator CREATOR = new MusicMaterialMetaDataBean.Creator();
  public static final MusicMaterialMetaDataBean.Companion Companion = new MusicMaterialMetaDataBean.Companion(null);
  public static final int ReferDefault = 0;
  public static final int ReferDuiQi = 2;
  public static final int ReferLocalVideo = 1;
  @JvmField
  public int audioDuration;
  @JvmField
  public byte autoPlay;
  @JvmField
  @Nullable
  public String categroyId;
  @JvmField
  public long collectTime;
  @JvmField
  @Nullable
  public String desc;
  @SerializedName("descindex")
  @JvmField
  @Nullable
  public List<MusicMaterialMetaDataBean.HighlightIndex> descIndices;
  @JvmField
  public long endOutTime;
  @JvmField
  public int endTime;
  @JvmField
  public int exclusive;
  @JvmField
  public int feedNum;
  @JvmField
  @Nullable
  public String feedlist_hot_id;
  @JvmField
  @Nullable
  public String feedlist_time_id;
  @JvmField
  @Nullable
  public String followFeedId;
  @JvmField
  public int iSource;
  @JvmField
  @NotNull
  public String id;
  @JvmField
  public long importTime;
  @JvmField
  public int indexInCategory;
  @JvmField
  public boolean isCloseLyric;
  @JvmField
  public int isCollected;
  @JvmField
  public boolean isEdit;
  @JvmField
  public boolean isImportType;
  @JvmField
  public boolean isStuckPoint;
  @JvmField
  @Nullable
  public String label;
  @JvmField
  @Nullable
  public String lyric;
  @JvmField
  @Nullable
  public String lyricFormat;
  @JvmField
  public int mDefaultFeedPosition;
  @JvmField
  public int mDefaultTogetherFeed;
  @JvmField
  public int mFeedUseType;
  @JvmField
  public int mFromDataType;
  @JvmField
  @Nullable
  public String mTogetherFeed;
  @JvmField
  public int mTogetherType;
  @JvmField
  public int mTotalTime;
  @JvmField
  public long mTotalTimeMs;
  @JvmField
  @Nullable
  public List<VolumeAutomaticEffect> mVolumeAutomaticEffectList;
  @JvmField
  public int mask;
  @JvmField
  public int miniSptVersion;
  @JvmField
  @Nullable
  public String musicFrom;
  @JvmField
  @Nullable
  public String name;
  @SerializedName("titleindex")
  @JvmField
  @Nullable
  public List<MusicMaterialMetaDataBean.HighlightIndex> nameIndices;
  @JvmField
  public int orgStartTime;
  @JvmField
  @Nullable
  public String packageUrl;
  @JvmField
  @Nullable
  public String path;
  @JvmField
  @Nullable
  public String recommendInfo;
  @JvmField
  public int refer;
  @JvmField
  public int rich_flag;
  @JvmField
  @Nullable
  public String secLyric;
  @JvmField
  @Nullable
  public String secLyricFormat;
  @JvmField
  public int segDuration;
  @JvmField
  @Nullable
  public String shortName;
  @JvmField
  public long sid;
  @JvmField
  @Nullable
  public Map<Integer, String> songLabels;
  @JvmField
  public long startInTime;
  @JvmField
  public long startPlayOffset;
  @JvmField
  public int startTime;
  @JvmField
  public int state;
  @JvmField
  @Nullable
  public String stuckPointJsonUrl;
  @JvmField
  @Nullable
  public String thumbUrl;
  @JvmField
  @Nullable
  public String title;
  @JvmField
  @Nullable
  public List<String> topic_ids;
  @JvmField
  @Nullable
  public String type;
  @JvmField
  public long userStartTime;
  @JvmField
  public int version;
  @JvmField
  public float volume;
  
  public MusicMaterialMetaDataBean()
  {
    this(null, 0L, null, null, null, null, 0, 0, null, null, null, null, null, 0, null, 0, null, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0L, 0, 0, (byte)0, 0, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, null, false, 0, 0, null, null, false, null, false, 0L, 0L, 0L, 0L, false, 0L, 0.0F, 0L, null, -1, 2147483647, null);
  }
  
  public MusicMaterialMetaDataBean(@NotNull String paramString1, long paramLong1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, int paramInt1, int paramInt2, @Nullable String paramString6, @Nullable String paramString7, @Nullable String paramString8, @Nullable String paramString9, @Nullable List<String> paramList, int paramInt3, @Nullable String paramString10, int paramInt4, @Nullable String paramString11, int paramInt5, int paramInt6, int paramInt7, int paramInt8, @Nullable String paramString12, @Nullable String paramString13, int paramInt9, int paramInt10, int paramInt11, int paramInt12, long paramLong2, int paramInt13, int paramInt14, byte paramByte, int paramInt15, @Nullable String paramString14, @Nullable String paramString15, @Nullable String paramString16, @Nullable String paramString17, @Nullable String paramString18, @Nullable Map<Integer, String> paramMap, @Nullable List<MusicMaterialMetaDataBean.HighlightIndex> paramList1, @Nullable List<MusicMaterialMetaDataBean.HighlightIndex> paramList2, int paramInt16, int paramInt17, int paramInt18, int paramInt19, int paramInt20, @Nullable String paramString19, boolean paramBoolean1, int paramInt21, int paramInt22, @Nullable String paramString20, @Nullable String paramString21, boolean paramBoolean2, @Nullable String paramString22, boolean paramBoolean3, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean4, long paramLong7, float paramFloat, long paramLong8, @Nullable List<VolumeAutomaticEffect> paramList3)
  {
    this.id = paramString1;
    this.sid = paramLong1;
    this.name = paramString2;
    this.desc = paramString3;
    this.type = paramString4;
    this.thumbUrl = paramString5;
    this.version = paramInt1;
    this.miniSptVersion = paramInt2;
    this.packageUrl = paramString6;
    this.path = paramString7;
    this.feedlist_time_id = paramString8;
    this.feedlist_hot_id = paramString9;
    this.topic_ids = paramList;
    this.mask = paramInt3;
    this.shortName = paramString10;
    this.rich_flag = paramInt4;
    this.title = paramString11;
    this.feedNum = paramInt5;
    this.startTime = paramInt6;
    this.endTime = paramInt7;
    this.orgStartTime = paramInt8;
    this.followFeedId = paramString12;
    this.mTogetherFeed = paramString13;
    this.mTogetherType = paramInt9;
    this.mFeedUseType = paramInt10;
    this.mDefaultFeedPosition = paramInt11;
    this.mDefaultTogetherFeed = paramInt12;
    this.collectTime = paramLong2;
    this.audioDuration = paramInt13;
    this.isCollected = paramInt14;
    this.autoPlay = paramByte;
    this.exclusive = paramInt15;
    this.lyric = paramString14;
    this.secLyric = paramString15;
    this.lyricFormat = paramString16;
    this.secLyricFormat = paramString17;
    this.label = paramString18;
    this.songLabels = paramMap;
    this.nameIndices = paramList1;
    this.descIndices = paramList2;
    this.indexInCategory = paramInt16;
    this.mFromDataType = paramInt17;
    this.mTotalTime = paramInt18;
    this.refer = paramInt19;
    this.state = paramInt20;
    this.categroyId = paramString19;
    this.isCloseLyric = paramBoolean1;
    this.iSource = paramInt21;
    this.segDuration = paramInt22;
    this.recommendInfo = paramString20;
    this.musicFrom = paramString21;
    this.isStuckPoint = paramBoolean2;
    this.stuckPointJsonUrl = paramString22;
    this.isImportType = paramBoolean3;
    this.importTime = paramLong3;
    this.startInTime = paramLong4;
    this.endOutTime = paramLong5;
    this.startPlayOffset = paramLong6;
    this.isEdit = paramBoolean4;
    this.userStartTime = paramLong7;
    this.volume = paramFloat;
    this.mTotalTimeMs = paramLong8;
    this.mVolumeAutomaticEffectList = paramList3;
  }
  
  @NotNull
  public final String component1()
  {
    return this.id;
  }
  
  @Nullable
  public final String component10()
  {
    return this.path;
  }
  
  @Nullable
  public final String component11()
  {
    return this.feedlist_time_id;
  }
  
  @Nullable
  public final String component12()
  {
    return this.feedlist_hot_id;
  }
  
  @Nullable
  public final List<String> component13()
  {
    return this.topic_ids;
  }
  
  public final int component14()
  {
    return this.mask;
  }
  
  @Nullable
  public final String component15()
  {
    return this.shortName;
  }
  
  public final int component16()
  {
    return this.rich_flag;
  }
  
  @Nullable
  public final String component17()
  {
    return this.title;
  }
  
  public final int component18()
  {
    return this.feedNum;
  }
  
  public final int component19()
  {
    return this.startTime;
  }
  
  public final long component2()
  {
    return this.sid;
  }
  
  public final int component20()
  {
    return this.endTime;
  }
  
  public final int component21()
  {
    return this.orgStartTime;
  }
  
  @Nullable
  public final String component22()
  {
    return this.followFeedId;
  }
  
  @Nullable
  public final String component23()
  {
    return this.mTogetherFeed;
  }
  
  public final int component24()
  {
    return this.mTogetherType;
  }
  
  public final int component25()
  {
    return this.mFeedUseType;
  }
  
  public final int component26()
  {
    return this.mDefaultFeedPosition;
  }
  
  public final int component27()
  {
    return this.mDefaultTogetherFeed;
  }
  
  public final long component28()
  {
    return this.collectTime;
  }
  
  public final int component29()
  {
    return this.audioDuration;
  }
  
  @Nullable
  public final String component3()
  {
    return this.name;
  }
  
  public final int component30()
  {
    return this.isCollected;
  }
  
  public final byte component31()
  {
    return this.autoPlay;
  }
  
  public final int component32()
  {
    return this.exclusive;
  }
  
  @Nullable
  public final String component33()
  {
    return this.lyric;
  }
  
  @Nullable
  public final String component34()
  {
    return this.secLyric;
  }
  
  @Nullable
  public final String component35()
  {
    return this.lyricFormat;
  }
  
  @Nullable
  public final String component36()
  {
    return this.secLyricFormat;
  }
  
  @Nullable
  public final String component37()
  {
    return this.label;
  }
  
  @Nullable
  public final Map<Integer, String> component38()
  {
    return this.songLabels;
  }
  
  @Nullable
  public final List<MusicMaterialMetaDataBean.HighlightIndex> component39()
  {
    return this.nameIndices;
  }
  
  @Nullable
  public final String component4()
  {
    return this.desc;
  }
  
  @Nullable
  public final List<MusicMaterialMetaDataBean.HighlightIndex> component40()
  {
    return this.descIndices;
  }
  
  public final int component41()
  {
    return this.indexInCategory;
  }
  
  public final int component42()
  {
    return this.mFromDataType;
  }
  
  public final int component43()
  {
    return this.mTotalTime;
  }
  
  public final int component44()
  {
    return this.refer;
  }
  
  public final int component45()
  {
    return this.state;
  }
  
  @Nullable
  public final String component46()
  {
    return this.categroyId;
  }
  
  public final boolean component47()
  {
    return this.isCloseLyric;
  }
  
  public final int component48()
  {
    return this.iSource;
  }
  
  public final int component49()
  {
    return this.segDuration;
  }
  
  @Nullable
  public final String component5()
  {
    return this.type;
  }
  
  @Nullable
  public final String component50()
  {
    return this.recommendInfo;
  }
  
  @Nullable
  public final String component51()
  {
    return this.musicFrom;
  }
  
  public final boolean component52()
  {
    return this.isStuckPoint;
  }
  
  @Nullable
  public final String component53()
  {
    return this.stuckPointJsonUrl;
  }
  
  public final boolean component54()
  {
    return this.isImportType;
  }
  
  public final long component55()
  {
    return this.importTime;
  }
  
  public final long component56()
  {
    return this.startInTime;
  }
  
  public final long component57()
  {
    return this.endOutTime;
  }
  
  public final long component58()
  {
    return this.startPlayOffset;
  }
  
  public final boolean component59()
  {
    return this.isEdit;
  }
  
  @Nullable
  public final String component6()
  {
    return this.thumbUrl;
  }
  
  public final long component60()
  {
    return this.userStartTime;
  }
  
  public final float component61()
  {
    return this.volume;
  }
  
  public final long component62()
  {
    return this.mTotalTimeMs;
  }
  
  @Nullable
  public final List<VolumeAutomaticEffect> component63()
  {
    return this.mVolumeAutomaticEffectList;
  }
  
  public final int component7()
  {
    return this.version;
  }
  
  public final int component8()
  {
    return this.miniSptVersion;
  }
  
  @Nullable
  public final String component9()
  {
    return this.packageUrl;
  }
  
  @NotNull
  public final MusicMaterialMetaDataBean copy(@NotNull String paramString1, long paramLong1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, int paramInt1, int paramInt2, @Nullable String paramString6, @Nullable String paramString7, @Nullable String paramString8, @Nullable String paramString9, @Nullable List<String> paramList, int paramInt3, @Nullable String paramString10, int paramInt4, @Nullable String paramString11, int paramInt5, int paramInt6, int paramInt7, int paramInt8, @Nullable String paramString12, @Nullable String paramString13, int paramInt9, int paramInt10, int paramInt11, int paramInt12, long paramLong2, int paramInt13, int paramInt14, byte paramByte, int paramInt15, @Nullable String paramString14, @Nullable String paramString15, @Nullable String paramString16, @Nullable String paramString17, @Nullable String paramString18, @Nullable Map<Integer, String> paramMap, @Nullable List<MusicMaterialMetaDataBean.HighlightIndex> paramList1, @Nullable List<MusicMaterialMetaDataBean.HighlightIndex> paramList2, int paramInt16, int paramInt17, int paramInt18, int paramInt19, int paramInt20, @Nullable String paramString19, boolean paramBoolean1, int paramInt21, int paramInt22, @Nullable String paramString20, @Nullable String paramString21, boolean paramBoolean2, @Nullable String paramString22, boolean paramBoolean3, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean4, long paramLong7, float paramFloat, long paramLong8, @Nullable List<VolumeAutomaticEffect> paramList3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    return new MusicMaterialMetaDataBean(paramString1, paramLong1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9, paramList, paramInt3, paramString10, paramInt4, paramString11, paramInt5, paramInt6, paramInt7, paramInt8, paramString12, paramString13, paramInt9, paramInt10, paramInt11, paramInt12, paramLong2, paramInt13, paramInt14, paramByte, paramInt15, paramString14, paramString15, paramString16, paramString17, paramString18, paramMap, paramList1, paramList2, paramInt16, paramInt17, paramInt18, paramInt19, paramInt20, paramString19, paramBoolean1, paramInt21, paramInt22, paramString20, paramString21, paramBoolean2, paramString22, paramBoolean3, paramLong3, paramLong4, paramLong5, paramLong6, paramBoolean4, paramLong7, paramFloat, paramLong8, paramList3);
  }
  
  @NotNull
  public final MusicMaterialMetaDataBean deepClone()
  {
    List localList = this.mVolumeAutomaticEffectList;
    if (localList != null) {}
    for (localList = CollectionsKt.toMutableList((Collection)localList);; localList = null) {
      return copy$default(this, null, 0L, null, null, null, null, 0, 0, null, null, null, null, null, 0, null, 0, null, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0L, 0, 0, (byte)0, 0, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, null, false, 0, 0, null, null, false, null, false, 0L, 0L, 0L, 0L, false, 0L, 0.0F, 0L, localList, -1, 1073741823, null);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof MusicMaterialMetaDataBean))
      {
        paramObject = (MusicMaterialMetaDataBean)paramObject;
        if ((!Intrinsics.areEqual(this.id, paramObject.id)) || (this.sid != paramObject.sid) || (!Intrinsics.areEqual(this.name, paramObject.name)) || (!Intrinsics.areEqual(this.desc, paramObject.desc)) || (!Intrinsics.areEqual(this.type, paramObject.type)) || (!Intrinsics.areEqual(this.thumbUrl, paramObject.thumbUrl)) || (this.version != paramObject.version) || (this.miniSptVersion != paramObject.miniSptVersion) || (!Intrinsics.areEqual(this.packageUrl, paramObject.packageUrl)) || (!Intrinsics.areEqual(this.path, paramObject.path)) || (!Intrinsics.areEqual(this.feedlist_time_id, paramObject.feedlist_time_id)) || (!Intrinsics.areEqual(this.feedlist_hot_id, paramObject.feedlist_hot_id)) || (!Intrinsics.areEqual(this.topic_ids, paramObject.topic_ids)) || (this.mask != paramObject.mask) || (!Intrinsics.areEqual(this.shortName, paramObject.shortName)) || (this.rich_flag != paramObject.rich_flag) || (!Intrinsics.areEqual(this.title, paramObject.title)) || (this.feedNum != paramObject.feedNum) || (this.startTime != paramObject.startTime) || (this.endTime != paramObject.endTime) || (this.orgStartTime != paramObject.orgStartTime) || (!Intrinsics.areEqual(this.followFeedId, paramObject.followFeedId)) || (!Intrinsics.areEqual(this.mTogetherFeed, paramObject.mTogetherFeed)) || (this.mTogetherType != paramObject.mTogetherType) || (this.mFeedUseType != paramObject.mFeedUseType) || (this.mDefaultFeedPosition != paramObject.mDefaultFeedPosition) || (this.mDefaultTogetherFeed != paramObject.mDefaultTogetherFeed) || (this.collectTime != paramObject.collectTime) || (this.audioDuration != paramObject.audioDuration) || (this.isCollected != paramObject.isCollected) || (this.autoPlay != paramObject.autoPlay) || (this.exclusive != paramObject.exclusive) || (!Intrinsics.areEqual(this.lyric, paramObject.lyric)) || (!Intrinsics.areEqual(this.secLyric, paramObject.secLyric)) || (!Intrinsics.areEqual(this.lyricFormat, paramObject.lyricFormat)) || (!Intrinsics.areEqual(this.secLyricFormat, paramObject.secLyricFormat)) || (!Intrinsics.areEqual(this.label, paramObject.label)) || (!Intrinsics.areEqual(this.songLabels, paramObject.songLabels)) || (!Intrinsics.areEqual(this.nameIndices, paramObject.nameIndices)) || (!Intrinsics.areEqual(this.descIndices, paramObject.descIndices)) || (this.indexInCategory != paramObject.indexInCategory) || (this.mFromDataType != paramObject.mFromDataType) || (this.mTotalTime != paramObject.mTotalTime) || (this.refer != paramObject.refer) || (this.state != paramObject.state) || (!Intrinsics.areEqual(this.categroyId, paramObject.categroyId)) || (this.isCloseLyric != paramObject.isCloseLyric) || (this.iSource != paramObject.iSource) || (this.segDuration != paramObject.segDuration) || (!Intrinsics.areEqual(this.recommendInfo, paramObject.recommendInfo)) || (!Intrinsics.areEqual(this.musicFrom, paramObject.musicFrom)) || (this.isStuckPoint != paramObject.isStuckPoint) || (!Intrinsics.areEqual(this.stuckPointJsonUrl, paramObject.stuckPointJsonUrl)) || (this.isImportType != paramObject.isImportType) || (this.importTime != paramObject.importTime) || (this.startInTime != paramObject.startInTime) || (this.endOutTime != paramObject.endOutTime) || (this.startPlayOffset != paramObject.startPlayOffset) || (this.isEdit != paramObject.isEdit) || (this.userStartTime != paramObject.userStartTime) || (Float.compare(this.volume, paramObject.volume) != 0) || (this.mTotalTimeMs != paramObject.mTotalTimeMs) || (!Intrinsics.areEqual(this.mVolumeAutomaticEffectList, paramObject.mVolumeAutomaticEffectList))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    return "MusicMaterialMetaDataBean(id=" + this.id + ", sid=" + this.sid + ", name=" + this.name + ", desc=" + this.desc + ", type=" + this.type + ", thumbUrl=" + this.thumbUrl + ", version=" + this.version + ", miniSptVersion=" + this.miniSptVersion + ", packageUrl=" + this.packageUrl + ", path=" + this.path + ", feedlist_time_id=" + this.feedlist_time_id + ", feedlist_hot_id=" + this.feedlist_hot_id + ", topic_ids=" + this.topic_ids + ", mask=" + this.mask + ", shortName=" + this.shortName + ", rich_flag=" + this.rich_flag + ", title=" + this.title + ", feedNum=" + this.feedNum + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", orgStartTime=" + this.orgStartTime + ", followFeedId=" + this.followFeedId + ", mTogetherFeed=" + this.mTogetherFeed + ", mTogetherType=" + this.mTogetherType + ", mFeedUseType=" + this.mFeedUseType + ", mDefaultFeedPosition=" + this.mDefaultFeedPosition + ", mDefaultTogetherFeed=" + this.mDefaultTogetherFeed + ", collectTime=" + this.collectTime + ", audioDuration=" + this.audioDuration + ", isCollected=" + this.isCollected + ", autoPlay=" + this.autoPlay + ", exclusive=" + this.exclusive + ", lyric=" + this.lyric + ", secLyric=" + this.secLyric + ", lyricFormat=" + this.lyricFormat + ", secLyricFormat=" + this.secLyricFormat + ", label=" + this.label + ", songLabels=" + this.songLabels + ", nameIndices=" + this.nameIndices + ", descIndices=" + this.descIndices + ", indexInCategory=" + this.indexInCategory + ", mFromDataType=" + this.mFromDataType + ", mTotalTime=" + this.mTotalTime + ", refer=" + this.refer + ", state=" + this.state + ", categroyId=" + this.categroyId + ", isCloseLyric=" + this.isCloseLyric + ", iSource=" + this.iSource + ", segDuration=" + this.segDuration + ", recommendInfo=" + this.recommendInfo + ", musicFrom=" + this.musicFrom + ", isStuckPoint=" + this.isStuckPoint + ", stuckPointJsonUrl=" + this.stuckPointJsonUrl + ", isImportType=" + this.isImportType + ", importTime=" + this.importTime + ", startInTime=" + this.startInTime + ", endOutTime=" + this.endOutTime + ", startPlayOffset=" + this.startPlayOffset + ", isEdit=" + this.isEdit + ", userStartTime=" + this.userStartTime + ", volume=" + this.volume + ", mTotalTimeMs=" + this.mTotalTimeMs + ", mVolumeAutomaticEffectList=" + this.mVolumeAutomaticEffectList + ")";
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean
 * JD-Core Version:    0.7.0.1
 */