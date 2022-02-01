package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CoverCacheData$PackageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PackageInfo> CREATOR = new CoverCacheData.PackageInfo.1();
  public String PackageUrl;
  public int coverStyle = -1;
  public int daytime;
  public String degrade_pic;
  public String md5;
  public String prePic;
  public int weather;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.prePic);
    paramParcel.writeString(this.PackageUrl);
    paramParcel.writeString(this.md5);
    paramParcel.writeInt(this.weather);
    paramParcel.writeInt(this.daytime);
    paramParcel.writeInt(this.coverStyle);
    paramParcel.writeString(this.degrade_pic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData.PackageInfo
 * JD-Core Version:    0.7.0.1
 */