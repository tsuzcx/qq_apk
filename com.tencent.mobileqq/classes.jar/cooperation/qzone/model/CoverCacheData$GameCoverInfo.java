package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CoverCacheData$GameCoverInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GameCoverInfo> CREATOR = new CoverCacheData.GameCoverInfo.1();
  public int jmpType;
  public String jmpUrl = "";
  public String schema = "";
  public double xCoordLU;
  public double xCoordRD;
  public double yCoordLU;
  public double yCoordRD;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.xCoordLU);
    paramParcel.writeDouble(this.yCoordLU);
    paramParcel.writeDouble(this.xCoordRD);
    paramParcel.writeDouble(this.yCoordRD);
    paramParcel.writeString(this.jmpUrl);
    paramParcel.writeString(this.schema);
    paramParcel.writeInt(this.jmpType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData.GameCoverInfo
 * JD-Core Version:    0.7.0.1
 */