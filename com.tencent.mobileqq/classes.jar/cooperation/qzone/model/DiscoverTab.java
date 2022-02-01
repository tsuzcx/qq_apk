package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import cooperation.qzone.widget.RedTouchExtendButton;
import cooperation.qzone.widget.RedTouchExtendButton.RedInfo;

public class DiscoverTab
  implements Parcelable
{
  public static final Parcelable.Creator<DiscoverTab> CREATOR = new DiscoverTab.1();
  public View containerView;
  public int entranceId;
  public int index;
  public boolean isSelect;
  public String name;
  public String qbossTrace;
  public RedTouchExtendButton.RedInfo redInfo;
  public RedTouchExtendButton tabView;
  public String url;
  public boolean useWnsProxy;
  public String wnsHtml;
  
  public DiscoverTab() {}
  
  public DiscoverTab(Parcel paramParcel)
  {
    this.entranceId = paramParcel.readInt();
    this.name = paramParcel.readString();
    this.url = paramParcel.readString();
    this.index = paramParcel.readInt();
    this.redInfo = ((RedTouchExtendButton.RedInfo)paramParcel.readParcelable(getClass().getClassLoader()));
    this.qbossTrace = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.isSelect = bool1;
      if (paramParcel.readInt() != 1) {
        break label108;
      }
    }
    label108:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.useWnsProxy = bool1;
      this.wnsHtml = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.entranceId);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.index);
    paramParcel.writeParcelable(this.redInfo, 0);
    paramParcel.writeString(this.qbossTrace);
    if (this.isSelect)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.useWnsProxy) {
        break label93;
      }
    }
    label93:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.wnsHtml);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.DiscoverTab
 * JD-Core Version:    0.7.0.1
 */