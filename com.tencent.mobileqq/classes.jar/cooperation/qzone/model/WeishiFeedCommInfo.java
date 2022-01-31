package cooperation.qzone.model;

import amew;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeishiFeedCommInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new amew();
  public int appid;
  public String ugckey;
  
  public WeishiFeedCommInfo(int paramInt, String paramString)
  {
    this.appid = paramInt;
    this.ugckey = paramString;
  }
  
  public WeishiFeedCommInfo(Parcel paramParcel)
  {
    this.appid = paramParcel.readInt();
    this.ugckey = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.appid);
    paramParcel.writeString(this.ugckey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.WeishiFeedCommInfo
 * JD-Core Version:    0.7.0.1
 */