package cooperation.qzone.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RedTouchExtendButton$RedInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RedInfo> CREATOR = new RedTouchExtendButton.RedInfo.1();
  public static final int RED_TOUCH_IMAGE = 3;
  public static final int RED_TOUCH_NONE = 100;
  public static final int RED_TOUCH_RED_POINT = 0;
  public static final int RED_TOUCH_TEXT = 4;
  public String desc;
  public boolean isNew;
  public String redText;
  public int redType;
  public int resId;
  public String resUrl;
  
  public RedTouchExtendButton$RedInfo() {}
  
  public RedTouchExtendButton$RedInfo(Parcel paramParcel)
  {
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.isNew = bool;
      this.redType = paramParcel.readInt();
      this.resId = paramParcel.readInt();
      this.redText = paramParcel.readString();
      this.resUrl = paramParcel.readString();
      this.desc = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public RedTouchExtendButton$RedInfo(RedInfo paramRedInfo)
  {
    if (paramRedInfo != null)
    {
      this.isNew = paramRedInfo.isNew;
      this.redType = paramRedInfo.redType;
      this.resId = paramRedInfo.resId;
      this.redText = paramRedInfo.redText;
      this.resUrl = paramRedInfo.resUrl;
      this.desc = paramRedInfo.desc;
    }
  }
  
  private boolean equals(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {}
    while ((paramObject1 != null) && (paramObject1.equals(paramObject2))) {
      return true;
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof RedInfo));
      paramObject = (RedInfo)paramObject;
    } while ((!equals(Boolean.valueOf(paramObject.isNew), Boolean.valueOf(this.isNew))) || (!equals(paramObject.redText, this.redText)) || (!equals(Integer.valueOf(paramObject.redType), Integer.valueOf(this.redType))) || (!equals(paramObject.resUrl, this.resUrl)) || (!equals(paramObject.desc, this.desc)) || (!equals(Integer.valueOf(paramObject.resId), Integer.valueOf(this.resId))));
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.isNew) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.redType);
      paramParcel.writeInt(this.resId);
      paramParcel.writeString(this.redText);
      paramParcel.writeString(this.resUrl);
      paramParcel.writeString(this.desc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.widget.RedTouchExtendButton.RedInfo
 * JD-Core Version:    0.7.0.1
 */