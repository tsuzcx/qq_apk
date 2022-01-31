package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bfwq;

public class WeishiFeedCommInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiFeedCommInfo> CREATOR = new bfwq();
  public int appid;
  public String cellId;
  public String curlikekey;
  public String feedskey;
  public boolean isLike;
  public int operatemask;
  public int operatemask2;
  public int orgCommentnum;
  public String orglikekey;
  public int orglikenum;
  public int polyPraiseCombo;
  public int polyPraiseItemId;
  public String polyPraisePicUrl;
  public String subId;
  public int ugcRight;
  public String ugckey;
  
  public WeishiFeedCommInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.appid = paramInt;
    this.ugckey = paramString1;
    this.cellId = paramString2;
    this.subId = paramString3;
    this.feedskey = paramString4;
  }
  
  public WeishiFeedCommInfo(Parcel paramParcel)
  {
    this.appid = paramParcel.readInt();
    this.ugckey = paramParcel.readString();
    this.cellId = paramParcel.readString();
    this.subId = paramParcel.readString();
    this.feedskey = paramParcel.readString();
    this.operatemask = paramParcel.readInt();
    this.operatemask2 = paramParcel.readInt();
    this.curlikekey = paramParcel.readString();
    this.orglikekey = paramParcel.readString();
    this.orglikenum = paramParcel.readInt();
    this.orgCommentnum = paramParcel.readInt();
    this.ugcRight = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.isLike = bool;
      this.polyPraiseItemId = paramParcel.readInt();
      this.polyPraisePicUrl = paramParcel.readString();
      this.polyPraiseCombo = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.appid);
    paramParcel.writeString(this.ugckey);
    paramParcel.writeString(this.cellId);
    paramParcel.writeString(this.subId);
    paramParcel.writeString(this.feedskey);
    paramParcel.writeInt(this.operatemask);
    paramParcel.writeInt(this.operatemask2);
    paramParcel.writeString(this.curlikekey);
    paramParcel.writeString(this.orglikekey);
    paramParcel.writeInt(this.orglikenum);
    paramParcel.writeInt(this.orgCommentnum);
    paramParcel.writeInt(this.ugcRight);
    if (this.isLike) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.polyPraiseItemId);
      paramParcel.writeString(this.polyPraisePicUrl);
      paramParcel.writeInt(this.polyPraiseCombo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.WeishiFeedCommInfo
 * JD-Core Version:    0.7.0.1
 */