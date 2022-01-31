package cooperation.qzone.model;

import amvb;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeishiFeedInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new amvb();
  public WeishiBasicInfo basicInfo;
  public WeishiFeedCommInfo feedCommInfo;
  public WeishiOperationInfo operationInfo;
  public WeishiUserInfo userInfo;
  public VideoInfo videoInfo;
  
  public WeishiFeedInfo() {}
  
  public WeishiFeedInfo(Parcel paramParcel)
  {
    this.userInfo = ((WeishiUserInfo)paramParcel.readParcelable(WeishiUserInfo.class.getClassLoader()));
    this.videoInfo = ((VideoInfo)paramParcel.readParcelable(VideoInfo.class.getClassLoader()));
    this.basicInfo = ((WeishiBasicInfo)paramParcel.readParcelable(WeishiBasicInfo.class.getClassLoader()));
    this.feedCommInfo = ((WeishiFeedCommInfo)paramParcel.readParcelable(WeishiFeedCommInfo.class.getClassLoader()));
    this.operationInfo = ((WeishiOperationInfo)paramParcel.readParcelable(WeishiOperationInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.userInfo, paramInt);
    paramParcel.writeParcelable(this.videoInfo, paramInt);
    paramParcel.writeParcelable(this.basicInfo, paramInt);
    paramParcel.writeParcelable(this.feedCommInfo, paramInt);
    paramParcel.writeParcelable(this.operationInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.WeishiFeedInfo
 * JD-Core Version:    0.7.0.1
 */