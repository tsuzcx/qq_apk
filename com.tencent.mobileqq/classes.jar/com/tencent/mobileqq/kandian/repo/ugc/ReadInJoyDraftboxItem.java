package com.tencent.mobileqq.kandian.repo.ugc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.persistence.Entity;

public class ReadInJoyDraftboxItem
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<ReadInJoyDraftboxItem> CREATOR = new ReadInJoyDraftboxItem.1();
  public static final int DEFAULT_DRAFTID = -1;
  public static final String TABLE_NAME = "ReadInJoyDraftboxItem";
  public static final int TYPE_ANSWER = 2;
  public static final int TYPE_ARTICLE = 1;
  public static final int TYPE_QUESTION = 3;
  public static final int TYPE_UGC = 0;
  public byte[] content;
  public String digest;
  public byte[] firstPic;
  public ReadInJoyDraftboxItem.PicData firstPicData;
  public long time;
  public String title;
  public int type = 0;
  
  public ReadInJoyDraftboxItem() {}
  
  public ReadInJoyDraftboxItem(Parcel paramParcel)
  {
    this.title = paramParcel.readString();
    this.digest = paramParcel.readString();
    this.time = paramParcel.readLong();
    if (paramParcel.readInt() > 0) {
      paramParcel.readByteArray(this.firstPic);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readByteArray(this.content);
    }
    this.type = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyDraftboxItem{id='");
    localStringBuilder.append(getId());
    localStringBuilder.append('\'');
    localStringBuilder.append("title='");
    localStringBuilder.append(this.title);
    localStringBuilder.append('\'');
    localStringBuilder.append(", digest='");
    localStringBuilder.append(this.digest);
    localStringBuilder.append('\'');
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", firstPicData=");
    localStringBuilder.append(this.firstPicData);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.digest);
    paramParcel.writeLong(this.time);
    byte[] arrayOfByte = this.firstPic;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      paramParcel.writeInt(arrayOfByte.length);
      paramParcel.writeByteArray(this.firstPic);
    }
    else
    {
      paramParcel.writeInt(0);
    }
    arrayOfByte = this.content;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      paramParcel.writeInt(arrayOfByte.length);
      paramParcel.writeByteArray(this.content);
    }
    else
    {
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem
 * JD-Core Version:    0.7.0.1
 */