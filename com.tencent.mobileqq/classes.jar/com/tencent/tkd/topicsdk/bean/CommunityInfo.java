package com.tencent.tkd.topicsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "communityId", "", "jumpUrl", "coverUrl", "title", "intro", "state", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCommunityId", "()Ljava/lang/String;", "setCommunityId", "(Ljava/lang/String;)V", "getCoverUrl", "setCoverUrl", "getIntro", "setIntro", "getJumpUrl", "setJumpUrl", "getState", "setState", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "topicsdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class CommunityInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new CommunityInfo.Creator();
  @NotNull
  private String communityId;
  @NotNull
  private String coverUrl;
  @NotNull
  private String intro;
  @NotNull
  private String jumpUrl;
  @NotNull
  private String state;
  @NotNull
  private String title;
  
  public CommunityInfo()
  {
    this(null, null, null, null, null, null, 63, null);
  }
  
  public CommunityInfo(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6)
  {
    this.communityId = paramString1;
    this.jumpUrl = paramString2;
    this.coverUrl = paramString3;
    this.title = paramString4;
    this.intro = paramString5;
    this.state = paramString6;
  }
  
  @NotNull
  public final String component1()
  {
    return this.communityId;
  }
  
  @NotNull
  public final String component2()
  {
    return this.jumpUrl;
  }
  
  @NotNull
  public final String component3()
  {
    return this.coverUrl;
  }
  
  @NotNull
  public final String component4()
  {
    return this.title;
  }
  
  @NotNull
  public final String component5()
  {
    return this.intro;
  }
  
  @NotNull
  public final String component6()
  {
    return this.state;
  }
  
  @NotNull
  public final CommunityInfo copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "communityId");
    Intrinsics.checkParameterIsNotNull(paramString2, "jumpUrl");
    Intrinsics.checkParameterIsNotNull(paramString3, "coverUrl");
    Intrinsics.checkParameterIsNotNull(paramString4, "title");
    Intrinsics.checkParameterIsNotNull(paramString5, "intro");
    Intrinsics.checkParameterIsNotNull(paramString6, "state");
    return new CommunityInfo(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof CommunityInfo)) {
      return Intrinsics.areEqual(this.communityId, ((CommunityInfo)paramObject).communityId);
    }
    return false;
  }
  
  @NotNull
  public final String getCommunityId()
  {
    return this.communityId;
  }
  
  @NotNull
  public final String getCoverUrl()
  {
    return this.coverUrl;
  }
  
  @NotNull
  public final String getIntro()
  {
    return this.intro;
  }
  
  @NotNull
  public final String getJumpUrl()
  {
    return this.jumpUrl;
  }
  
  @NotNull
  public final String getState()
  {
    return this.state;
  }
  
  @NotNull
  public final String getTitle()
  {
    return this.title;
  }
  
  public int hashCode()
  {
    return this.communityId.hashCode();
  }
  
  public final void setCommunityId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.communityId = paramString;
  }
  
  public final void setCoverUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.coverUrl = paramString;
  }
  
  public final void setIntro(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.intro = paramString;
  }
  
  public final void setJumpUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jumpUrl = paramString;
  }
  
  public final void setState(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.state = paramString;
  }
  
  public final void setTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.title = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommunityInfo(communityId=");
    localStringBuilder.append(this.communityId);
    localStringBuilder.append(", jumpUrl=");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append(", coverUrl=");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.title);
    localStringBuilder.append(", intro=");
    localStringBuilder.append(this.intro);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.state);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.communityId);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.intro);
    paramParcel.writeString(this.state);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.CommunityInfo
 * JD-Core Version:    0.7.0.1
 */