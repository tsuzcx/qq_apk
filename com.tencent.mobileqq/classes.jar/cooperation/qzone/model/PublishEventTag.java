package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PublishEventTag
  implements Parcelable
{
  public static final Parcelable.Creator<PublishEventTag> CREATOR = new PublishEventTag.1();
  public String desc;
  public String id;
  public String picUrl;
  public String protocol;
  public String time;
  public String title;
  public String truncateNum;
  public String uin;
  
  public PublishEventTag() {}
  
  protected PublishEventTag(Parcel paramParcel)
  {
    this.title = paramParcel.readString();
    this.picUrl = paramParcel.readString();
    this.id = paramParcel.readString();
    this.protocol = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.truncateNum = paramParcel.readString();
    this.uin = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.picUrl);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.protocol);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.truncateNum);
    paramParcel.writeString(this.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.PublishEventTag
 * JD-Core Version:    0.7.0.1
 */