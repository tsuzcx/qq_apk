package com.tencent.mobileqq.hotpic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avbb;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="url,tag,picIndex")
public class HotPicData
  extends Entity
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<HotPicData> CREATOR = new avbb();
  public static final int DATA_GIF = 1;
  public static final int DATA_VIDEO = 2;
  public static final String HOT_PIC_HAS_EXTRA = "HOT_PIC_HAS_EXTRA";
  public static final String HOT_PIC_TRANS_FILESIZE = "HOT_PIC_TRANS_FILESIZE";
  public static final String HOT_PIC_TRANS_MD5 = "HOT_PIC_TRANS_MD5";
  public static final String HOT_PIC_TRANS_THUMB_MD5 = "HOT_PIC_TRANS_THUMB_MD5";
  public String appid;
  public String filePath;
  public long fileSize;
  public int fileType;
  public int height;
  public String iconUrl;
  public String jumpUrl;
  public String md5;
  public String name;
  public int originalHeight;
  public String originalMD5;
  public String originalUrl;
  public int originalWidth;
  public long oringinalSize;
  public int picIndex;
  public int sourceType;
  public int tag;
  public String url;
  public int version;
  public int width;
  
  public HotPicData() {}
  
  public HotPicData(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.fileSize = paramParcel.readLong();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.originalMD5 = paramParcel.readString();
    this.oringinalSize = paramParcel.readLong();
    this.originalWidth = paramParcel.readInt();
    this.originalHeight = paramParcel.readInt();
    this.originalUrl = paramParcel.readString();
    this.fileType = paramParcel.readInt();
    this.picIndex = paramParcel.readInt();
    this.sourceType = paramParcel.readInt();
    this.filePath = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.appid = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.name = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
    this.tag = paramParcel.readInt();
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDataType()
  {
    return 1;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("hotpic:");
    localStringBuffer.append(this.version).append(',').append(this.picIndex).append(",").append(this.tag).append(",").append(this.sourceType).append(",");
    localStringBuffer.append(this.url).append(',').append(this.md5).append(',').append(this.width).append('x').append(this.height);
    localStringBuffer.append(this.originalUrl).append(',').append(this.originalMD5).append(',').append(this.originalWidth).append('x').append(this.originalHeight);
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.md5);
    paramParcel.writeLong(this.fileSize);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeString(this.originalMD5);
    paramParcel.writeLong(this.oringinalSize);
    paramParcel.writeInt(this.originalWidth);
    paramParcel.writeInt(this.originalHeight);
    paramParcel.writeString(this.originalUrl);
    paramParcel.writeInt(this.fileType);
    paramParcel.writeInt(this.picIndex);
    paramParcel.writeInt(this.sourceType);
    paramParcel.writeString(this.filePath);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.appid);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeInt(this.tag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicData
 * JD-Core Version:    0.7.0.1
 */