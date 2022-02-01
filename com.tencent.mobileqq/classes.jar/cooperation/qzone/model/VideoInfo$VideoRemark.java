package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class VideoInfo$VideoRemark
  implements Parcelable
{
  public static final Parcelable.Creator<VideoRemark> CREATOR = new VideoInfo.VideoRemark.1();
  public int actiontype = 0;
  public String actionurl = "";
  public String icondesc = "";
  public String iconurl = "";
  public int orgwebsite = 0;
  public String remark = "";
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDisplayRemark()
  {
    if (TextUtils.isEmpty(this.icondesc)) {
      return this.remark;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.icondesc);
    localStringBuilder.append(" -- ");
    localStringBuilder.append(this.remark);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.iconurl);
    paramParcel.writeString(this.icondesc);
    paramParcel.writeString(this.remark);
    paramParcel.writeInt(this.actiontype);
    paramParcel.writeString(this.actionurl);
    paramParcel.writeInt(this.orgwebsite);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.VideoInfo.VideoRemark
 * JD-Core Version:    0.7.0.1
 */