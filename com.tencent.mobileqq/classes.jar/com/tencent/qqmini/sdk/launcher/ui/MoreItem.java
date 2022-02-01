package com.tencent.qqmini.sdk.launcher.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MoreItem
  implements Parcelable
{
  public static final int ABOUT = 5;
  public static final int COMPLAINT = 6;
  public static final Parcelable.Creator<MoreItem> CREATOR = new MoreItem.1();
  public static final int DEBUG = 7;
  public static final int FAVORITE = 10;
  private static final int FIRST_BUILTIN_ITEM = 1;
  public static final int MAX_EXT_ITEM_ID = 200;
  public static final int MIN_EXT_ITEM_ID = 100;
  public static final int MONITOR = 8;
  public static final int QQ_FAVORITE = 12;
  public static final int RESTART = 9;
  public static final int SHARE_QQ = 1;
  public static final int SHARE_QZONE = 2;
  public static final int SHARE_WX_FRIEND = 3;
  public static final int SHARE_WX_MOMENT = 4;
  public static final int SHORTCUT = 11;
  public int drawable;
  public int id;
  public boolean shareInMiniProcess;
  public String text;
  public boolean visible;
  
  public MoreItem()
  {
    this.visible = true;
  }
  
  public MoreItem(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.visible = bool1;
      this.drawable = paramParcel.readInt();
      this.text = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.shareInMiniProcess = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static boolean isValidExtendedItemId(int paramInt)
  {
    return (paramInt >= 100) && (paramInt <= 200);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.id);
    if (this.visible)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.drawable);
      paramParcel.writeString(this.text);
      if (!this.shareInMiniProcess) {
        break label60;
      }
    }
    label60:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.MoreItem
 * JD-Core Version:    0.7.0.1
 */