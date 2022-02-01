package com.tencent.tkd.weibo.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/bean/EditObject;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "wording", "", "type", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "(Ljava/lang/String;Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;)V", "atType", "", "getAtType", "()I", "setAtType", "(I)V", "avatarUrl", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "href", "getHref", "setHref", "id", "getId", "key", "getKey", "setKey", "getType", "()Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "setType", "(Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;)V", "getWording", "setWording", "describeContents", "toString", "writeToParcel", "", "flags", "CREATOR", "EditObjectType", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class EditObject
  implements Parcelable, Serializable
{
  public static final EditObject.CREATOR CREATOR = new EditObject.CREATOR(null);
  private static final long serialVersionUID = 0L;
  private int atType;
  @NotNull
  private String avatarUrl;
  @NotNull
  private String href;
  @NotNull
  private String key;
  @NotNull
  private EditObject.EditObjectType type;
  @NotNull
  private String wording;
  
  public EditObject(@NotNull Parcel paramParcel) {}
  
  public EditObject(@NotNull String paramString, @NotNull EditObject.EditObjectType paramEditObjectType)
  {
    this.wording = paramString;
    this.type = paramEditObjectType;
    this.key = "";
    this.href = "";
    this.avatarUrl = "";
    this.atType = 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int getAtType()
  {
    return this.atType;
  }
  
  @NotNull
  public final String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  @NotNull
  public final String getHref()
  {
    return this.href;
  }
  
  @NotNull
  public final String getId()
  {
    if (this.type == EditObject.EditObjectType.TYPE_URL) {
      return this.href;
    }
    return this.key;
  }
  
  @NotNull
  public final String getKey()
  {
    return this.key;
  }
  
  @NotNull
  public final EditObject.EditObjectType getType()
  {
    return this.type;
  }
  
  @NotNull
  public final String getWording()
  {
    return this.wording;
  }
  
  public final void setAtType(int paramInt)
  {
    this.atType = paramInt;
  }
  
  public final void setAvatarUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.avatarUrl = paramString;
  }
  
  public final void setHref(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.href = paramString;
  }
  
  public final void setKey(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.key = paramString;
  }
  
  public final void setType(@NotNull EditObject.EditObjectType paramEditObjectType)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObjectType, "<set-?>");
    this.type = paramEditObjectType;
  }
  
  public final void setWording(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.wording = paramString;
  }
  
  @NotNull
  public String toString()
  {
    return "EditObject: [" + "id = " + getId() + ", " + "wording = " + this.wording + ", " + "type = " + this.type + ", " + "key = " + this.key + ", " + "href = " + this.href + ", " + "avatarUrl = " + this.avatarUrl + "]\n";
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.wording);
    paramParcel.writeParcelable((Parcelable)this.type, paramInt);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.href);
    paramParcel.writeString(this.avatarUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.bean.EditObject
 * JD-Core Version:    0.7.0.1
 */