package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoUrl
  implements Parcelable
{
  public static final Parcelable.Creator<VideoUrl> CREATOR = new VideoUrl.1();
  public int decoderType;
  public String url;
  public int videoRate;
  
  public VideoUrl() {}
  
  public VideoUrl(String paramString)
  {
    this.url = paramString;
    this.decoderType = 1;
  }
  
  public VideoUrl(String paramString, int paramInt)
  {
    this.url = paramString;
    this.decoderType = paramInt;
  }
  
  public VideoUrl(String paramString, int paramInt1, int paramInt2)
  {
    this.url = paramString;
    this.decoderType = paramInt1;
    this.videoRate = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoUrl [url=");
    localStringBuilder.append(this.url);
    localStringBuilder.append(", decoderType=");
    localStringBuilder.append(this.decoderType);
    localStringBuilder.append(", videoRate=");
    localStringBuilder.append(this.videoRate);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.decoderType);
    paramParcel.writeInt(this.videoRate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.VideoUrl
 * JD-Core Version:    0.7.0.1
 */