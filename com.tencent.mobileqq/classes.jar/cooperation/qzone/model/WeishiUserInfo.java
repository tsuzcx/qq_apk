package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeishiUserInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiUserInfo> CREATOR = new WeishiUserInfo.1();
  public String logo;
  public String nickName;
  public long uin;
  
  public WeishiUserInfo() {}
  
  public WeishiUserInfo(long paramLong, String paramString)
  {
    this.uin = paramLong;
    this.nickName = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.uin);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.logo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.WeishiUserInfo
 * JD-Core Version:    0.7.0.1
 */