package cooperation.qzone.model;

import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_PHOTO.Album;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class BusinessAlbumInfo
  extends BaseBusinessAlbumInfo
{
  public static final int BABY_ALBUM_TYPE = 8;
  public static final int BABY_ANONYMITY_TYPE_VALUE = 5;
  public static final Parcelable.Creator<BusinessAlbumInfo> CREATOR = new BusinessAlbumInfo.1();
  public static final int DEFAULT_ALBUM_TYPE = 1;
  public static final int DEFAULT_ANONYMITY_TYPE = 1;
  public static final int LOVE_ALBUM_TYPE = 11;
  public static final int LOVE_ANONYMITY_TYPE_VALUE = 8;
  public static final int MULTI_ALBUM_TYPE = 12;
  public static final int MULTI_ANONYMITY_TYPE_VALUT = 9;
  public static final int TRAVEL_ALBUM_TYPE = 9;
  public static final int TRAVEL_ANONYMITY_TYPE_VALUE = 6;
  public static final int TRAVEL_BIG_EVENT_TYPE = 1001;
  public static final int VIDEO_ALBUM_TYPE = 7;
  public static final int VIDEO_TYPE = 10;
  
  private BusinessAlbumInfo(Parcel paramParcel)
  {
    this.mUin = paramParcel.readLong();
    this.mAlbumId = paramParcel.readString();
    this.mPrivacy = paramParcel.readInt();
    this.mTotal = paramParcel.readInt();
    this.mCover = paramParcel.readString();
    this.mTitle = paramParcel.readString();
    this.mLastUploadTime = paramParcel.readLong();
    this.mAlbumType = paramParcel.readInt();
    this.mSvrTime = paramParcel.readLong();
    this.mAnonymity = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.isIndividualityAlbum = bool;
      this.opmask = paramParcel.readInt();
      this.allow_share = paramParcel.readInt();
      this.individualCover = paramParcel.readString();
      this.isShare = paramParcel.readInt();
      this.isSharingOwner = paramParcel.readInt();
      this.sortType = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public BusinessAlbumInfo(String paramString)
  {
    super(paramString);
  }
  
  public static BusinessAlbumInfo create(Album paramAlbum)
  {
    boolean bool = true;
    if (paramAlbum == null) {
      return null;
    }
    BusinessAlbumInfo localBusinessAlbumInfo = new BusinessAlbumInfo(paramAlbum.albumid);
    localBusinessAlbumInfo.mPrivacy = paramAlbum.priv;
    localBusinessAlbumInfo.mTitle = paramAlbum.name;
    localBusinessAlbumInfo.mTotal = paramAlbum.total;
    localBusinessAlbumInfo.mUin = paramAlbum.uin;
    localBusinessAlbumInfo.mAlbumType = paramAlbum.type;
    localBusinessAlbumInfo.mSvrTime = paramAlbum.svrtime;
    localBusinessAlbumInfo.mCover = paramAlbum.coverurl;
    if ((getAlbumAnonymityByType(paramAlbum.type) == 1) && (paramAlbum.material != null) && (paramAlbum.individual != 0L)) {}
    for (;;)
    {
      localBusinessAlbumInfo.isIndividualityAlbum = bool;
      localBusinessAlbumInfo.opmask = paramAlbum.opmask;
      localBusinessAlbumInfo.allow_share = paramAlbum.allow_share;
      localBusinessAlbumInfo.individualCover = getIndividualCoverUrl(paramAlbum);
      localBusinessAlbumInfo.isShare = paramAlbum.is_share;
      localBusinessAlbumInfo.sortType = paramAlbum.sort_type;
      return localBusinessAlbumInfo;
      bool = false;
    }
  }
  
  public static BusinessAlbumInfo create(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new BusinessAlbumInfo(paramString);
  }
  
  public static BusinessAlbumInfo createFrom(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5, int paramInt6, boolean paramBoolean1, String paramString4, boolean paramBoolean2)
  {
    paramString1 = new BusinessAlbumInfo(paramString1);
    paramString1.mAlbumType = paramInt1;
    paramString1.mTitle = paramString2;
    paramString1.mCover = paramString3;
    paramString1.mPrivacy = paramInt2;
    paramString1.mTotal = paramInt3;
    paramString1.mAnonymity = paramInt4;
    boolean bool;
    if (paramLong == 1L)
    {
      bool = true;
      paramString1.isIndividualityAlbum = bool;
      paramString1.opmask = paramInt5;
      paramString1.allow_share = paramInt6;
      if (!paramBoolean1) {
        break label115;
      }
      paramInt1 = 1;
      label77:
      paramString1.isShare = paramInt1;
      if (paramLong == 1L) {
        paramString1.individualCover = paramString4;
      }
      if (!paramBoolean2) {
        break label120;
      }
    }
    label115:
    label120:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.isSharingOwner = paramInt1;
      return paramString1;
      bool = false;
      break;
      paramInt1 = 0;
      break label77;
    }
  }
  
  public static int getAlbumAnonymityByType(int paramInt)
  {
    int i = 8;
    if (paramInt == 8) {
      i = 5;
    }
    do
    {
      return i;
      if (paramInt == 9) {
        return 6;
      }
    } while (paramInt == 11);
    return 1;
  }
  
  public static String getIndividualCoverUrl(Album paramAlbum)
  {
    if ((paramAlbum == null) || (paramAlbum.individual != 1L) || (paramAlbum.material == null)) {}
    while ((paramAlbum.material.stBanner == null) || (TextUtils.isEmpty(paramAlbum.material.stBanner.strUrl))) {
      return null;
    }
    return paramAlbum.material.stBanner.strUrl;
  }
  
  public static String getPrivNameFromAlbum(int paramInt)
  {
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (i == 0)
    {
      return null;
      i = 2131716845;
      continue;
      i = 2131716846;
      continue;
      i = 2131716591;
      continue;
      i = 2131716589;
      continue;
      i = 2131716594;
      continue;
      i = 2131716590;
    }
    return BaseApplication.getContext().getResources().getString(i);
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
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
        paramObject = (BusinessAlbumInfo)paramObject;
        if (this.mAlbumId != null) {
          break;
        }
      } while (paramObject.mAlbumId == null);
      return false;
    } while (this.mAlbumId.equals(paramObject.mAlbumId));
    return false;
  }
  
  public String getPrivacyDescription()
  {
    return BusinessAlbumInfo.Privacy.getDescription(this.mPrivacy);
  }
  
  public int hashCode()
  {
    if (this.mAlbumId == null) {}
    for (int i = 0;; i = this.mAlbumId.hashCode()) {
      return i + 31;
    }
  }
  
  public boolean isShareAlbum()
  {
    return this.isShare == 1;
  }
  
  public void updateFrom(BusinessAlbumInfo paramBusinessAlbumInfo)
  {
    if (paramBusinessAlbumInfo == null) {
      return;
    }
    this.mUin = paramBusinessAlbumInfo.mUin;
    this.mTotal = paramBusinessAlbumInfo.mTotal;
    this.mPrivacy = paramBusinessAlbumInfo.mPrivacy;
    this.mAlbumType = paramBusinessAlbumInfo.mAlbumType;
    if (!isEmpty(paramBusinessAlbumInfo.mTitle)) {
      this.mTitle = paramBusinessAlbumInfo.mTitle;
    }
    if (!isEmpty(paramBusinessAlbumInfo.mCover)) {
      this.mCover = paramBusinessAlbumInfo.mCover;
    }
    this.mSvrTime = paramBusinessAlbumInfo.mSvrTime;
    this.mAnonymity = paramBusinessAlbumInfo.mAnonymity;
    this.isIndividualityAlbum = paramBusinessAlbumInfo.isIndividualityAlbum;
    this.opmask = paramBusinessAlbumInfo.opmask;
    this.allow_share = paramBusinessAlbumInfo.allow_share;
    this.individualCover = paramBusinessAlbumInfo.individualCover;
    this.isShare = paramBusinessAlbumInfo.isShare;
    this.isSharingOwner = paramBusinessAlbumInfo.isSharingOwner;
    this.sortType = paramBusinessAlbumInfo.sortType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.BusinessAlbumInfo
 * JD-Core Version:    0.7.0.1
 */