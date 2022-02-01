package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WeishiUserInfo$1
  implements Parcelable.Creator<WeishiUserInfo>
{
  public WeishiUserInfo createFromParcel(Parcel paramParcel)
  {
    WeishiUserInfo localWeishiUserInfo = new WeishiUserInfo();
    localWeishiUserInfo.uin = paramParcel.readLong();
    localWeishiUserInfo.nickName = paramParcel.readString();
    localWeishiUserInfo.logo = paramParcel.readString();
    return localWeishiUserInfo;
  }
  
  public WeishiUserInfo[] newArray(int paramInt)
  {
    return new WeishiUserInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.WeishiUserInfo.1
 * JD-Core Version:    0.7.0.1
 */