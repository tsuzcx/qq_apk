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
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.showGuide = bool;
      this.buttonTitle = paramParcel.readString();
      this.jumpUrl = paramParcel.readString();
      return;
    }
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
    return "KingCardInfo [showGuide=" + this.showGuide + ", buttonTitle=" + this.buttonTitle + ", jumpUrl=" + this.jumpUrl + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.showGuide) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.buttonTitle);
      paramParcel.writeString(this.jumpUrl);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.KingCardInfo
 * JD-Core Version:    0.7.0.1
 */