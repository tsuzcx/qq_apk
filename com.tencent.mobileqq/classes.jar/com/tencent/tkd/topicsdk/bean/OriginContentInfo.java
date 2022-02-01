package com.tencent.tkd.topicsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "type", "", "imageUrlArray", "", "", "duration", "", "durationString", "repostLevel", "userName", "userId", "jumpUrl", "avatarUrl", "defaultImageUrl", "title", "defaultTitle", "summary", "defaultSummary", "contentInfo", "originContentKey", "repostContentKey", "originJumpUrl", "(ILjava/util/List;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getContentInfo", "setContentInfo", "getDefaultImageUrl", "setDefaultImageUrl", "getDefaultSummary", "setDefaultSummary", "getDefaultTitle", "setDefaultTitle", "getDuration", "()J", "setDuration", "(J)V", "getDurationString", "setDurationString", "getImageUrlArray", "()Ljava/util/List;", "setImageUrlArray", "(Ljava/util/List;)V", "getJumpUrl", "setJumpUrl", "getOriginContentKey", "setOriginContentKey", "getOriginJumpUrl", "setOriginJumpUrl", "getRepostContentKey", "setRepostContentKey", "getRepostLevel", "()I", "setRepostLevel", "(I)V", "getSummary", "setSummary", "getTitle", "setTitle", "getType", "setType", "getUserId", "setUserId", "getUserName", "setUserName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class OriginContentInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new OriginContentInfo.Creator();
  public static final OriginContentInfo.Companion Companion = new OriginContentInfo.Companion(null);
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_WITH_IMAGE = 1;
  public static final int TYPE_WITH_VIDEO = 2;
  private static final long serialVersionUID = 0L;
  @NotNull
  private String avatarUrl;
  @NotNull
  private String contentInfo;
  @NotNull
  private String defaultImageUrl;
  @NotNull
  private String defaultSummary;
  @NotNull
  private String defaultTitle;
  private long duration;
  @NotNull
  private String durationString;
  @NotNull
  private List<String> imageUrlArray;
  @NotNull
  private String jumpUrl;
  @NotNull
  private String originContentKey;
  @NotNull
  private String originJumpUrl;
  @NotNull
  private String repostContentKey;
  private int repostLevel;
  @NotNull
  private String summary;
  @NotNull
  private String title;
  private int type;
  @NotNull
  private String userId;
  @NotNull
  private String userName;
  
  public OriginContentInfo()
  {
    this(0, null, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
  }
  
  public OriginContentInfo(int paramInt1, @NotNull List<String> paramList, long paramLong, @NotNull String paramString1, int paramInt2, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, @NotNull String paramString8, @NotNull String paramString9, @NotNull String paramString10, @NotNull String paramString11, @NotNull String paramString12, @NotNull String paramString13, @NotNull String paramString14)
  {
    this.type = paramInt1;
    this.imageUrlArray = paramList;
    this.duration = paramLong;
    this.durationString = paramString1;
    this.repostLevel = paramInt2;
    this.userName = paramString2;
    this.userId = paramString3;
    this.jumpUrl = paramString4;
    this.avatarUrl = paramString5;
    this.defaultImageUrl = paramString6;
    this.title = paramString7;
    this.defaultTitle = paramString8;
    this.summary = paramString9;
    this.defaultSummary = paramString10;
    this.contentInfo = paramString11;
    this.originContentKey = paramString12;
    this.repostContentKey = paramString13;
    this.originJumpUrl = paramString14;
  }
  
  public final int component1()
  {
    return this.type;
  }
  
  @NotNull
  public final String component10()
  {
    return this.defaultImageUrl;
  }
  
  @NotNull
  public final String component11()
  {
    return this.title;
  }
  
  @NotNull
  public final String component12()
  {
    return this.defaultTitle;
  }
  
  @NotNull
  public final String component13()
  {
    return this.summary;
  }
  
  @NotNull
  public final String component14()
  {
    return this.defaultSummary;
  }
  
  @NotNull
  public final String component15()
  {
    return this.contentInfo;
  }
  
  @NotNull
  public final String component16()
  {
    return this.originContentKey;
  }
  
  @NotNull
  public final String component17()
  {
    return this.repostContentKey;
  }
  
  @NotNull
  public final String component18()
  {
    return this.originJumpUrl;
  }
  
  @NotNull
  public final List<String> component2()
  {
    return this.imageUrlArray;
  }
  
  public final long component3()
  {
    return this.duration;
  }
  
  @NotNull
  public final String component4()
  {
    return this.durationString;
  }
  
  public final int component5()
  {
    return this.repostLevel;
  }
  
  @NotNull
  public final String component6()
  {
    return this.userName;
  }
  
  @NotNull
  public final String component7()
  {
    return this.userId;
  }
  
  @NotNull
  public final String component8()
  {
    return this.jumpUrl;
  }
  
  @NotNull
  public final String component9()
  {
    return this.avatarUrl;
  }
  
  @NotNull
  public final OriginContentInfo copy(int paramInt1, @NotNull List<String> paramList, long paramLong, @NotNull String paramString1, int paramInt2, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, @NotNull String paramString8, @NotNull String paramString9, @NotNull String paramString10, @NotNull String paramString11, @NotNull String paramString12, @NotNull String paramString13, @NotNull String paramString14)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "imageUrlArray");
    Intrinsics.checkParameterIsNotNull(paramString1, "durationString");
    Intrinsics.checkParameterIsNotNull(paramString2, "userName");
    Intrinsics.checkParameterIsNotNull(paramString3, "userId");
    Intrinsics.checkParameterIsNotNull(paramString4, "jumpUrl");
    Intrinsics.checkParameterIsNotNull(paramString5, "avatarUrl");
    Intrinsics.checkParameterIsNotNull(paramString6, "defaultImageUrl");
    Intrinsics.checkParameterIsNotNull(paramString7, "title");
    Intrinsics.checkParameterIsNotNull(paramString8, "defaultTitle");
    Intrinsics.checkParameterIsNotNull(paramString9, "summary");
    Intrinsics.checkParameterIsNotNull(paramString10, "defaultSummary");
    Intrinsics.checkParameterIsNotNull(paramString11, "contentInfo");
    Intrinsics.checkParameterIsNotNull(paramString12, "originContentKey");
    Intrinsics.checkParameterIsNotNull(paramString13, "repostContentKey");
    Intrinsics.checkParameterIsNotNull(paramString14, "originJumpUrl");
    return new OriginContentInfo(paramInt1, paramList, paramLong, paramString1, paramInt2, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    Object localObject = null;
    if (!(paramObject instanceof OriginContentInfo)) {
      paramObject = null;
    }
    for (;;)
    {
      OriginContentInfo localOriginContentInfo = (OriginContentInfo)paramObject;
      paramObject = localObject;
      if (localOriginContentInfo != null) {
        paramObject = localOriginContentInfo.originContentKey;
      }
      return Intrinsics.areEqual(paramObject, this.originContentKey);
    }
  }
  
  @NotNull
  public final String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  @NotNull
  public final String getContentInfo()
  {
    return this.contentInfo;
  }
  
  @NotNull
  public final String getDefaultImageUrl()
  {
    return this.defaultImageUrl;
  }
  
  @NotNull
  public final String getDefaultSummary()
  {
    return this.defaultSummary;
  }
  
  @NotNull
  public final String getDefaultTitle()
  {
    return this.defaultTitle;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  @NotNull
  public final String getDurationString()
  {
    return this.durationString;
  }
  
  @NotNull
  public final List<String> getImageUrlArray()
  {
    return this.imageUrlArray;
  }
  
  @NotNull
  public final String getJumpUrl()
  {
    return this.jumpUrl;
  }
  
  @NotNull
  public final String getOriginContentKey()
  {
    return this.originContentKey;
  }
  
  @NotNull
  public final String getOriginJumpUrl()
  {
    return this.originJumpUrl;
  }
  
  @NotNull
  public final String getRepostContentKey()
  {
    return this.repostContentKey;
  }
  
  public final int getRepostLevel()
  {
    return this.repostLevel;
  }
  
  @NotNull
  public final String getSummary()
  {
    return this.summary;
  }
  
  @NotNull
  public final String getTitle()
  {
    return this.title;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  @NotNull
  public final String getUserId()
  {
    return this.userId;
  }
  
  @NotNull
  public final String getUserName()
  {
    return this.userName;
  }
  
  public int hashCode()
  {
    return this.originContentKey.hashCode();
  }
  
  public final void setAvatarUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.avatarUrl = paramString;
  }
  
  public final void setContentInfo(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.contentInfo = paramString;
  }
  
  public final void setDefaultImageUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.defaultImageUrl = paramString;
  }
  
  public final void setDefaultSummary(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.defaultSummary = paramString;
  }
  
  public final void setDefaultTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.defaultTitle = paramString;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setDurationString(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.durationString = paramString;
  }
  
  public final void setImageUrlArray(@NotNull List<String> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.imageUrlArray = paramList;
  }
  
  public final void setJumpUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jumpUrl = paramString;
  }
  
  public final void setOriginContentKey(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.originContentKey = paramString;
  }
  
  public final void setOriginJumpUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.originJumpUrl = paramString;
  }
  
  public final void setRepostContentKey(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.repostContentKey = paramString;
  }
  
  public final void setRepostLevel(int paramInt)
  {
    this.repostLevel = paramInt;
  }
  
  public final void setSummary(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.summary = paramString;
  }
  
  public final void setTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.title = paramString;
  }
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final void setUserId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.userId = paramString;
  }
  
  public final void setUserName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.userName = paramString;
  }
  
  @NotNull
  public String toString()
  {
    return "OriginContentInfo(type=" + this.type + ", imageUrlArray=" + this.imageUrlArray + ", duration=" + this.duration + ", durationString=" + this.durationString + ", repostLevel=" + this.repostLevel + ", userName=" + this.userName + ", userId=" + this.userId + ", jumpUrl=" + this.jumpUrl + ", avatarUrl=" + this.avatarUrl + ", defaultImageUrl=" + this.defaultImageUrl + ", title=" + this.title + ", defaultTitle=" + this.defaultTitle + ", summary=" + this.summary + ", defaultSummary=" + this.defaultSummary + ", contentInfo=" + this.contentInfo + ", originContentKey=" + this.originContentKey + ", repostContentKey=" + this.repostContentKey + ", originJumpUrl=" + this.originJumpUrl + ")";
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.type);
    paramParcel.writeStringList(this.imageUrlArray);
    paramParcel.writeLong(this.duration);
    paramParcel.writeString(this.durationString);
    paramParcel.writeInt(this.repostLevel);
    paramParcel.writeString(this.userName);
    paramParcel.writeString(this.userId);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeString(this.avatarUrl);
    paramParcel.writeString(this.defaultImageUrl);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.defaultTitle);
    paramParcel.writeString(this.summary);
    paramParcel.writeString(this.defaultSummary);
    paramParcel.writeString(this.contentInfo);
    paramParcel.writeString(this.originContentKey);
    paramParcel.writeString(this.repostContentKey);
    paramParcel.writeString(this.originJumpUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.OriginContentInfo
 * JD-Core Version:    0.7.0.1
 */