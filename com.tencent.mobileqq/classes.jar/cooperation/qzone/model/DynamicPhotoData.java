package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bhfd;

public class DynamicPhotoData
  implements Parcelable
{
  public static final Parcelable.Creator<DynamicPhotoData> CREATOR = new bhfd();
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  
  public DynamicPhotoData(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  public DynamicPhotoData(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public DynamicPhotoData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.DynamicPhotoData
 * JD-Core Version:    0.7.0.1
 */