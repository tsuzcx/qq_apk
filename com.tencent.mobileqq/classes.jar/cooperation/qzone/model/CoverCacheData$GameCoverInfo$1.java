package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CoverCacheData$GameCoverInfo$1
  implements Parcelable.Creator<CoverCacheData.GameCoverInfo>
{
  public CoverCacheData.GameCoverInfo createFromParcel(Parcel paramParcel)
  {
    CoverCacheData.GameCoverInfo localGameCoverInfo = new CoverCacheData.GameCoverInfo();
    if (paramParcel != null)
    {
      localGameCoverInfo.xCoordLU = paramParcel.readDouble();
      localGameCoverInfo.yCoordLU = paramParcel.readDouble();
      localGameCoverInfo.xCoordRD = paramParcel.readDouble();
      localGameCoverInfo.yCoordRD = paramParcel.readDouble();
      localGameCoverInfo.jmpUrl = paramParcel.readString();
      localGameCoverInfo.schema = paramParcel.readString();
      localGameCoverInfo.jmpType = paramParcel.readInt();
    }
    return localGameCoverInfo;
  }
  
  public CoverCacheData.GameCoverInfo[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData.GameCoverInfo.1
 * JD-Core Version:    0.7.0.1
 */