package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class BaseBusinessAlbumInfo
  implements Parcelable, Cloneable
{
  public int allow_share;
  public String individualCover;
  public boolean isAlbumExist = true;
  public boolean isFake;
  public boolean isIndividualityAlbum;
  public int isShare;
  public int isSharingOwner;
  public String mAlbumId;
  public int mAlbumType;
  public int mAnonymity;
  public String mCover;
  public long mLastUploadTime;
  public int mPrivacy;
  public long mSvrTime;
  public String mTitle;
  public int mTotal;
  public long mUin;
  public int opmask;
  public int sortType;
  
  public BaseBusinessAlbumInfo() {}
  
  public BaseBusinessAlbumInfo(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.mUin = paramLong;
    this.mAlbumId = paramString1;
    this.mTitle = paramString2;
    this.mCover = paramString3;
    this.mTotal = paramInt1;
    this.mPrivacy = paramInt2;
    this.mAlbumType = paramInt3;
    this.isIndividualityAlbum = paramBoolean;
  }
  
  public BaseBusinessAlbumInfo(String paramString)
  {
    this.mAlbumId = paramString;
  }
  
  public BaseBusinessAlbumInfo clone()
  {
    BaseBusinessAlbumInfo localBaseBusinessAlbumInfo = new BaseBusinessAlbumInfo(this.mAlbumId);
    localBaseBusinessAlbumInfo.copyFrom(this);
    return localBaseBusinessAlbumInfo;
  }
  
  public void copyFrom(BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo)
  {
    if (paramBaseBusinessAlbumInfo == null) {
      return;
    }
    this.mAlbumId = paramBaseBusinessAlbumInfo.mAlbumId;
    this.mUin = paramBaseBusinessAlbumInfo.mUin;
    this.mTitle = paramBaseBusinessAlbumInfo.mTitle;
    this.mCover = paramBaseBusinessAlbumInfo.mCover;
    this.mTotal = paramBaseBusinessAlbumInfo.mTotal;
    this.mPrivacy = paramBaseBusinessAlbumInfo.mPrivacy;
    this.mLastUploadTime = paramBaseBusinessAlbumInfo.mLastUploadTime;
    this.mAlbumType = paramBaseBusinessAlbumInfo.mAlbumType;
    this.mSvrTime = paramBaseBusinessAlbumInfo.mSvrTime;
    this.mAnonymity = paramBaseBusinessAlbumInfo.mAnonymity;
    this.isIndividualityAlbum = paramBaseBusinessAlbumInfo.isIndividualityAlbum;
    this.opmask = paramBaseBusinessAlbumInfo.opmask;
    this.allow_share = paramBaseBusinessAlbumInfo.allow_share;
    this.individualCover = paramBaseBusinessAlbumInfo.individualCover;
    this.isShare = paramBaseBusinessAlbumInfo.isShare;
    this.isSharingOwner = paramBaseBusinessAlbumInfo.isSharingOwner;
    this.sortType = paramBaseBusinessAlbumInfo.sortType;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (BaseBusinessAlbumInfo)paramObject;
        if (this.mAlbumId != null) {
          break;
        }
      } while (paramObject.mAlbumId == null);
      return false;
    } while (this.mAlbumId.equals(paramObject.mAlbumId));
    return false;
  }
  
  public String getId()
  {
    return this.mAlbumId;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public int hashCode()
  {
    if (this.mAlbumId == null) {}
    for (int i = 0;; i = this.mAlbumId.hashCode()) {
      return i + 31;
    }
  }
  
  public void updateFrom(BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo)
  {
    if (paramBaseBusinessAlbumInfo == null) {
      return;
    }
    this.mUin = paramBaseBusinessAlbumInfo.mUin;
    this.mTotal = paramBaseBusinessAlbumInfo.mTotal;
    this.mPrivacy = paramBaseBusinessAlbumInfo.mPrivacy;
    this.mAlbumType = paramBaseBusinessAlbumInfo.mAlbumType;
    if (!TextUtils.isEmpty(paramBaseBusinessAlbumInfo.mTitle)) {
      this.mTitle = paramBaseBusinessAlbumInfo.mTitle;
    }
    if (!TextUtils.isEmpty(paramBaseBusinessAlbumInfo.mCover)) {
      this.mCover = paramBaseBusinessAlbumInfo.mCover;
    }
    this.mSvrTime = paramBaseBusinessAlbumInfo.mSvrTime;
    this.mAnonymity = paramBaseBusinessAlbumInfo.mAnonymity;
    this.isIndividualityAlbum = paramBaseBusinessAlbumInfo.isIndividualityAlbum;
    this.opmask = paramBaseBusinessAlbumInfo.opmask;
    this.allow_share = paramBaseBusinessAlbumInfo.allow_share;
    this.individualCover = paramBaseBusinessAlbumInfo.individualCover;
    this.isShare = paramBaseBusinessAlbumInfo.isShare;
    this.isSharingOwner = paramBaseBusinessAlbumInfo.isSharingOwner;
    this.sortType = paramBaseBusinessAlbumInfo.sortType;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mUin);
    paramParcel.writeString(this.mAlbumId);
    paramParcel.writeInt(this.mPrivacy);
    paramParcel.writeInt(this.mTotal);
    paramParcel.writeString(this.mCover);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeLong(this.mLastUploadTime);
    paramParcel.writeInt(this.mAlbumType);
    paramParcel.writeLong(this.mSvrTime);
    paramParcel.writeInt(this.mAnonymity);
    if (this.isIndividualityAlbum) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.opmask);
      paramParcel.writeInt(this.allow_share);
      paramParcel.writeString(this.individualCover);
      paramParcel.writeInt(this.isShare);
      paramParcel.writeInt(this.isSharingOwner);
      paramParcel.writeInt(this.sortType);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.BaseBusinessAlbumInfo
 * JD-Core Version:    0.7.0.1
 */