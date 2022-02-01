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
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.isIndividualityAlbum = bool;
    this.opmask = paramParcel.readInt();
    this.allow_share = paramParcel.readInt();
    this.individualCover = paramParcel.readString();
    this.isShare = paramParcel.readInt();
    this.isSharingOwner = paramParcel.readInt();
    this.sortType = paramParcel.readInt();
  }
  
  public BusinessAlbumInfo(String paramString)
  {
    super(paramString);
  }
  
  public static BusinessAlbumInfo create(Album paramAlbum)
  {
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
    int i = getAlbumAnonymityByType(paramAlbum.type);
    boolean bool = true;
    if ((i != 1) || (paramAlbum.material == null) || (paramAlbum.individual == 0L)) {
      bool = false;
    }
    localBusinessAlbumInfo.isIndividualityAlbum = bool;
    localBusinessAlbumInfo.opmask = paramAlbum.opmask;
    localBusinessAlbumInfo.allow_share = paramAlbum.allow_share;
    localBusinessAlbumInfo.individualCover = getIndividualCoverUrl(paramAlbum);
    localBusinessAlbumInfo.isShare = paramAlbum.is_share;
    localBusinessAlbumInfo.sortType = paramAlbum.sort_type;
    return localBusinessAlbumInfo;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static int getAlbumAnonymityByType(int paramInt)
  {
    if (paramInt == 8) {
      return 5;
    }
    if (paramInt == 9) {
      return 6;
    }
    if (paramInt == 11) {
      return 8;
    }
    return 1;
  }
  
  public static String getIndividualCoverUrl(Album paramAlbum)
  {
    if ((paramAlbum != null) && (paramAlbum.individual == 1L))
    {
      if (paramAlbum.material == null) {
        return null;
      }
      if (paramAlbum.material.stBanner == null) {
        return null;
      }
      if (!TextUtils.isEmpty(paramAlbum.material.stBanner.strUrl)) {
        return paramAlbum.material.stBanner.strUrl;
      }
    }
    return null;
  }
  
  public static String getPrivNameFromAlbum(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    default: 
      paramInt = 0;
      break;
    case 8: 
      paramInt = 2131717107;
      break;
    case 6: 
      paramInt = 2131717111;
      break;
    case 4: 
      paramInt = 2131717108;
      break;
    case 3: 
      paramInt = 2131717363;
      break;
    case 2: 
    case 5: 
      paramInt = 2131717106;
      break;
    case 1: 
      paramInt = 2131717362;
    }
    if (paramInt == 0) {
      return null;
    }
    return BaseApplication.getContext().getResources().getString(paramInt);
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
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (BusinessAlbumInfo)paramObject;
    if (this.mAlbumId == null)
    {
      if (paramObject.mAlbumId != null) {
        return false;
      }
    }
    else if (!this.mAlbumId.equals(paramObject.mAlbumId)) {
      return false;
    }
    return true;
  }
  
  public String getPrivacyDescription()
  {
    return BusinessAlbumInfo.Privacy.getDescription(this.mPrivacy);
  }
  
  public int hashCode()
  {
    int i;
    if (this.mAlbumId == null) {
      i = 0;
    } else {
      i = this.mAlbumId.hashCode();
    }
    return 31 + i;
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