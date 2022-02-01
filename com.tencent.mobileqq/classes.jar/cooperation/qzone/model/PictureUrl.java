package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class PictureUrl
  implements Parcelable
{
  public static final Parcelable.Creator<PictureUrl> CREATOR = new PictureUrl.1();
  public int enlarge_rate;
  public int height;
  public int pictureType;
  public float pivotXRate;
  public float pivotYRate;
  public String url;
  public int width;
  
  public PictureUrl() {}
  
  public PictureUrl(String paramString, int paramInt1, int paramInt2)
  {
    this.url = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public static boolean isEmpty(PictureUrl paramPictureUrl)
  {
    return (paramPictureUrl == null) || (TextUtils.isEmpty(paramPictureUrl.url));
  }
  
  public boolean contains(String paramString)
  {
    if (this.url == null) {
      return false;
    }
    return this.url.equalsIgnoreCase(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isGif()
  {
    return this.pictureType == 2;
  }
  
  public String toString()
  {
    return "PictureUrl [url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", pictureType=" + this.pictureType + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.pictureType);
    paramParcel.writeFloat(this.pivotXRate);
    paramParcel.writeFloat(this.pivotYRate);
    paramParcel.writeInt(this.enlarge_rate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.PictureUrl
 * JD-Core Version:    0.7.0.1
 */