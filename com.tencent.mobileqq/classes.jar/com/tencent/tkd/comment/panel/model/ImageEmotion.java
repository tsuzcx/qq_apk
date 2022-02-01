package com.tencent.tkd.comment.panel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.tkd.comment.util.ObjectUtil;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ImageEmotion
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ImageEmotion> CREATOR = new ImageEmotion.1();
  private static final long serialVersionUID = -3384927111564346895L;
  public int imageHeight;
  public String imagePath;
  public String imageShowName;
  public String imageUrl;
  public int imageWidth;
  
  public ImageEmotion() {}
  
  protected ImageEmotion(Parcel paramParcel)
  {
    this.imageShowName = paramParcel.readString();
    this.imageUrl = paramParcel.readString();
    this.imagePath = paramParcel.readString();
    this.imageWidth = paramParcel.readInt();
    this.imageHeight = paramParcel.readInt();
  }
  
  public ImageEmotion(@Nullable String paramString1, @NotNull String paramString2, @Nullable String paramString3)
  {
    this.imageShowName = paramString1;
    this.imageUrl = paramString2;
    this.imagePath = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ImageEmotion)paramObject;
      return (ObjectUtil.equals(this.imageShowName, paramObject.imageShowName)) && (ObjectUtil.equals(this.imageUrl, paramObject.imageUrl)) && (ObjectUtil.equals(this.imagePath, paramObject.imagePath));
    }
    return false;
  }
  
  public int hashCode()
  {
    return ObjectUtil.hash(new Object[] { this.imageShowName, this.imageUrl, this.imagePath });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageEmotion{imageShowName='");
    localStringBuilder.append(this.imageShowName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imageUrl='");
    localStringBuilder.append(this.imageUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imagePath='");
    localStringBuilder.append(this.imagePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imageWidth=");
    localStringBuilder.append(this.imageWidth);
    localStringBuilder.append(", imageHeight=");
    localStringBuilder.append(this.imageHeight);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.imageShowName);
    paramParcel.writeString(this.imageUrl);
    paramParcel.writeString(this.imagePath);
    paramParcel.writeInt(this.imageWidth);
    paramParcel.writeInt(this.imageHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.model.ImageEmotion
 * JD-Core Version:    0.7.0.1
 */