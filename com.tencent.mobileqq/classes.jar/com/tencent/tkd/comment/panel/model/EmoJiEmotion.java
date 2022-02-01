package com.tencent.tkd.comment.panel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.tkd.comment.util.ObjectUtil;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

public class EmoJiEmotion
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<EmoJiEmotion> CREATOR = new EmoJiEmotion.1();
  private static final long serialVersionUID = -295687531425559356L;
  public int emoJiResourceId;
  public String emoJiShowName;
  
  public EmoJiEmotion() {}
  
  protected EmoJiEmotion(Parcel paramParcel)
  {
    this.emoJiShowName = paramParcel.readString();
    this.emoJiResourceId = paramParcel.readInt();
  }
  
  public EmoJiEmotion(@Nullable String paramString, int paramInt)
  {
    this.emoJiShowName = paramString;
    this.emoJiResourceId = paramInt;
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
      paramObject = (EmoJiEmotion)paramObject;
      return (this.emoJiResourceId == paramObject.emoJiResourceId) && (ObjectUtil.equals(this.emoJiShowName, paramObject.emoJiShowName));
    }
    return false;
  }
  
  public int hashCode()
  {
    return ObjectUtil.hash(new Object[] { this.emoJiShowName, Integer.valueOf(this.emoJiResourceId) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmoJiEmotion{emoJiShowName='");
    localStringBuilder.append(this.emoJiShowName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", emoJiResourceId=");
    localStringBuilder.append(this.emoJiResourceId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.emoJiShowName);
    paramParcel.writeInt(this.emoJiResourceId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.model.EmoJiEmotion
 * JD-Core Version:    0.7.0.1
 */