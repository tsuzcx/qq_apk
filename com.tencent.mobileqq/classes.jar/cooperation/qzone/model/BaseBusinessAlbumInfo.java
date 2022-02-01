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
  public boolean isFake = false;
  public boolean isIndividualityAlbum = false;
  public int isShare = 0;
  public int isSharingOwner = 0;
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
  public int sortType = 0;
  
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
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (BaseBusinessAlbumInfo)paramObject;
    String str = this.mAlbumId;
    if (str == null)
    {
      if (paramObject.mAlbumId != null) {
        return false;
      }
    }
    else if (!str.equals(paramObject.mAlbumId)) {
      return false;
    }
    return true;
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
    String str = this.mAlbumId;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return 31 + i;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.BaseBusinessAlbumInfo
 * JD-Core Version:    0.7.0.1
 */