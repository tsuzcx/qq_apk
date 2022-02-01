package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class KingCardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<KingCardInfo> CREATOR = new KingCardInfo.1();
  public String buttonTitle;
  public String jumpUrl;
  public boolean showGuide;
  
  public KingCardInfo() {}
  
  protected KingCardInfo(Parcel paramParcel)
  {
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.showGuide = bool;
    this.buttonTitle = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
  }
  
  public KingCardInfo(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.showGuide = paramBoolean;
    this.buttonTitle = paramString1;
    this.jumpUrl = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KingCardInfo [showGuide=");
    localStringBuilder.append(this.showGuide);
    localStringBuilder.append(", buttonTitle=");
    localStringBuilder.append(this.buttonTitle);
    localStringBuilder.append(", jumpUrl=");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByte((byte)this.showGuide);
    paramParcel.writeString(this.buttonTitle);
    paramParcel.writeString(this.jumpUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.KingCardInfo
 * JD-Core Version:    0.7.0.1
 */