package com.tencent.mobileqq.kandian.biz.comment.msgboard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RIJMessageBoardEditorParams$SourceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SourceInfo> CREATOR = new RIJMessageBoardEditorParams.SourceInfo.1();
  public int a;
  public String b;
  
  public RIJMessageBoardEditorParams$SourceInfo() {}
  
  protected RIJMessageBoardEditorParams$SourceInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.msgboard.data.RIJMessageBoardEditorParams.SourceInfo
 * JD-Core Version:    0.7.0.1
 */