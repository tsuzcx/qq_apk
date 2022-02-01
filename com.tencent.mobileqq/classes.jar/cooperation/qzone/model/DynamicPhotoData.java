package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DynamicPhotoData
  implements Parcelable
{
  public static final Parcelable.Creator<DynamicPhotoData> CREATOR = new DynamicPhotoData.1();
  public String mAlbumid = "";
  public String mDesc = "";
  public String mPhotoid = "";
  public String mTitle = "";
  public String mUrl = "";
  
  public DynamicPhotoData(Parcel paramParcel)
  {
    this.mUrl = paramParcel.readString();
    this.mTitle = paramParcel.readString();
    this.mDesc = paramParcel.readString();
    this.mAlbumid = paramParcel.readString();
    this.mPhotoid = paramParcel.readString();
  }
  
  public DynamicPhotoData(String paramString1, String paramString2, String paramString3)
  {
    this.mUrl = paramString1;
    this.mTitle = paramString2;
    this.mDesc = paramString3;
  }
  
  public DynamicPhotoData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mUrl = paramString1;
    this.mTitle = paramString2;
    this.mDesc = paramString3;
    this.mAlbumid = paramString4;
    this.mPhotoid = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mUrl);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mDesc);
    paramParcel.writeString(this.mAlbumid);
    paramParcel.writeString(this.mPhotoid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.DynamicPhotoData
 * JD-Core Version:    0.7.0.1
 */