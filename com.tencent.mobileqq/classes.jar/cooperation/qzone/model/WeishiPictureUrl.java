package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeishiPictureUrl
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiPictureUrl> CREATOR = new WeishiPictureUrl.1();
  public int key;
  public PictureUrl pictureUrl;
  
  public WeishiPictureUrl() {}
  
  public WeishiPictureUrl(int paramInt, PictureUrl paramPictureUrl)
  {
    this.key = paramInt;
    this.pictureUrl = paramPictureUrl;
  }
  
  protected WeishiPictureUrl(Parcel paramParcel)
  {
    this.key = paramParcel.readInt();
    this.pictureUrl = ((PictureUrl)paramParcel.readParcelable(PictureUrl.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.key);
    paramParcel.writeParcelable(this.pictureUrl, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.WeishiPictureUrl
 * JD-Core Version:    0.7.0.1
 */