package com.tencent.mobileqq.kandian.repo.ugc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpic.HotPicData;

public class ReadInJoyDraftboxItem$PicData
  implements Parcelable
{
  public static final Parcelable.Creator<PicData> CREATOR = new ReadInJoyDraftboxItem.PicData.1();
  public HotPicData a;
  public String b;
  public int c = -1;
  
  public ReadInJoyDraftboxItem$PicData() {}
  
  public ReadInJoyDraftboxItem$PicData(Parcel paramParcel)
  {
    this.a = ((HotPicData)paramParcel.readParcelable(HotPicData.class.getClassLoader()));
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PicData{hotPicData=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", localPic='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem.PicData
 * JD-Core Version:    0.7.0.1
 */