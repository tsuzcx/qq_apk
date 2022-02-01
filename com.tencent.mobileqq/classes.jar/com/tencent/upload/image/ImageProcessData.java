package com.tencent.upload.image;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ImageProcessData
  implements Parcelable
{
  public static final Parcelable.Creator<ImageProcessData> CREATOR = new ImageProcessData.1();
  public boolean autoRotate;
  public boolean compressToWebp;
  public int id;
  public String msg;
  public String originalFilePath;
  public String targetFilePath;
  public int targetHeight;
  public int targetQuality;
  public int targetWidth;
  
  public ImageProcessData(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    this.id = paramInt1;
    this.originalFilePath = paramString1;
    this.targetFilePath = paramString2;
    this.targetWidth = paramInt2;
    this.targetHeight = paramInt3;
    this.targetQuality = paramInt4;
    this.autoRotate = paramBoolean1;
    this.compressToWebp = paramBoolean2;
    this.msg = paramString3;
  }
  
  private ImageProcessData(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.originalFilePath = paramParcel.readString();
    this.targetFilePath = paramParcel.readString();
    this.targetWidth = paramParcel.readInt();
    this.targetHeight = paramParcel.readInt();
    this.targetQuality = paramParcel.readInt();
    int i = paramParcel.readByte();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.autoRotate = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    }
    this.compressToWebp = bool1;
    this.msg = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("file = ");
    localStringBuilder.append(this.originalFilePath);
    localStringBuilder.append(" target w=");
    localStringBuilder.append(this.targetWidth);
    localStringBuilder.append(" h = ");
    localStringBuilder.append(this.targetHeight);
    localStringBuilder.append(" q = ");
    localStringBuilder.append(this.targetQuality);
    localStringBuilder.append(" a = ");
    localStringBuilder.append(this.autoRotate);
    localStringBuilder.append(" webp = ");
    localStringBuilder.append(this.compressToWebp);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.originalFilePath);
    paramParcel.writeString(this.targetFilePath);
    paramParcel.writeInt(this.targetWidth);
    paramParcel.writeInt(this.targetHeight);
    paramParcel.writeInt(this.targetQuality);
    paramParcel.writeByte((byte)this.autoRotate);
    paramParcel.writeByte((byte)this.compressToWebp);
    paramParcel.writeString(this.msg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessData
 * JD-Core Version:    0.7.0.1
 */