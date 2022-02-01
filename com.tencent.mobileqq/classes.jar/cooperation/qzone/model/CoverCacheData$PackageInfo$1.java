package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CoverCacheData$PackageInfo$1
  implements Parcelable.Creator<CoverCacheData.PackageInfo>
{
  public CoverCacheData.PackageInfo createFromParcel(Parcel paramParcel)
  {
    CoverCacheData.PackageInfo localPackageInfo = new CoverCacheData.PackageInfo();
    if (paramParcel != null)
    {
      localPackageInfo.prePic = paramParcel.readString();
      localPackageInfo.PackageUrl = paramParcel.readString();
      localPackageInfo.md5 = paramParcel.readString();
      localPackageInfo.weather = paramParcel.readInt();
      localPackageInfo.daytime = paramParcel.readInt();
      localPackageInfo.coverStyle = paramParcel.readInt();
      localPackageInfo.degrade_pic = paramParcel.readString();
    }
    return localPackageInfo;
  }
  
  public CoverCacheData.PackageInfo[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData.PackageInfo.1
 * JD-Core Version:    0.7.0.1
 */