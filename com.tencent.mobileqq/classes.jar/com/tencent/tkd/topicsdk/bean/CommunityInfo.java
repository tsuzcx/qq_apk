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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "communityId", "", "coverUrl", "title", "intro", "state", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCommunityId", "()Ljava/lang/String;", "setCommunityId", "(Ljava/lang/String;)V", "getCoverUrl", "setCoverUrl", "getIntro", "setIntro", "getState", "setState", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "topicsdk_release"}, k=1, mv={1, 1, 16})
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
  private String state;
  @NotNull
  private String title;
  
  public CommunityInfo()
  {
    this(null, null, null, null, null, 31, null);
  }
  
  public CommunityInfo(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5)
  {
    this.communityId = paramString1;
    this.coverUrl = paramString2;
    this.title = paramString3;
    this.intro = paramString4;
    this.state = paramString5;
  }
  
  @NotNull
  public final String component1()
  {
    return this.communityId;
  }
  
  @NotNull
  public final String component2()
  {
    return this.coverUrl;
  }
  
  @NotNull
  public final String component3()
  {
    return this.title;
  }
  
  @NotNull
  public final String component4()
  {
    return this.intro;
  }
  
  @NotNull
  public final String component5()
  {
    return this.state;
  }
  
  @NotNull
  public final CommunityInfo copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "communityId");
    Intrinsics.checkParameterIsNotNull(paramString2, "coverUrl");
    Intrinsics.checkParameterIsNotNull(paramString3, "title");
    Intrinsics.checkParameterIsNotNull(paramString4, "intro");
    Intrinsics.checkParameterIsNotNull(paramString5, "state");
    return new CommunityInfo(paramString1, paramString2, paramString3, paramString4, paramString5);
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
    return "CommunityInfo(communityId=" + this.communityId + ", coverUrl=" + this.coverUrl + ", title=" + this.title + ", intro=" + this.intro + ", state=" + this.state + ")";
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.communityId);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.intro);
    paramParcel.writeString(this.state);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.CommunityInfo
 * JD-Core Version:    0.7.0.1
 */