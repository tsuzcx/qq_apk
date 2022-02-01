package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class WeishiInterestInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiInterestInfo> CREATOR = new WeishiInterestInfo.1();
  public String desc;
  public ArrayList<Long> uinList;
  
  public WeishiInterestInfo() {}
  
  protected WeishiInterestInfo(Parcel paramParcel)
  {
    this.uinList = paramParcel.readArrayList(Long.class.getClassLoader());
    this.desc = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.uinList);
    paramParcel.writeString(this.desc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.WeishiInterestInfo
 * JD-Core Version:    0.7.0.1
 */