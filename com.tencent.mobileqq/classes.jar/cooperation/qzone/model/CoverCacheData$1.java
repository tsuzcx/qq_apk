package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CoverCacheData$1
  implements Parcelable.Creator<CoverCacheData>
{
  public CoverCacheData createFromParcel(Parcel paramParcel)
  {
    CoverCacheData localCoverCacheData = new CoverCacheData();
    if (paramParcel != null)
    {
      localCoverCacheData.uin = paramParcel.readLong();
      localCoverCacheData.coverId = paramParcel.readString();
      localCoverCacheData.type = paramParcel.readString();
      localCoverCacheData.local_url = paramParcel.readString();
      localCoverCacheData.urls = paramParcel.readHashMap(getClass().getClassLoader());
      localCoverCacheData.packageInfo = ((CoverCacheData.PackageInfo)paramParcel.readParcelable(getClass().getClassLoader()));
      localCoverCacheData.gameCoverInfo = ((CoverCacheData.GameCoverInfo)paramParcel.readParcelable(getClass().getClassLoader()));
      localCoverCacheData.photoWall = paramParcel.readArrayList(getClass().getClassLoader());
      localCoverCacheData.isJigsawOpen = paramParcel.readInt();
      localCoverCacheData.mapExtInfo = paramParcel.readHashMap(getClass().getClassLoader());
      localCoverCacheData.backupMapExtInfo = paramParcel.readHashMap(getClass().getClassLoader());
      localCoverCacheData.alian = paramParcel.readInt();
    }
    return localCoverCacheData;
  }
  
  public CoverCacheData[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData.1
 * JD-Core Version:    0.7.0.1
 */