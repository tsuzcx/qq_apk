package com.tencent.tkd.comment.panel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.tkd.comment.util.ObjectUtil;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public class Emotion
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<Emotion> CREATOR = new Emotion.1();
  private static final long serialVersionUID = 2688439174094547275L;
  public Object actualEmotion;
  private int emotionType;
  
  public Emotion() {}
  
  public Emotion(int paramInt, @NotNull Object paramObject)
  {
    this.emotionType = paramInt;
    this.actualEmotion = paramObject;
  }
  
  protected Emotion(Parcel paramParcel)
  {
    this.emotionType = paramParcel.readInt();
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
      paramObject = (Emotion)paramObject;
      return (this.emotionType == paramObject.emotionType) && (ObjectUtil.equals(this.actualEmotion, paramObject.actualEmotion));
    }
    return false;
  }
  
  public int getEmotionType()
  {
    return this.emotionType;
  }
  
  public int hashCode()
  {
    return ObjectUtil.hash(new Object[] { this.actualEmotion, Integer.valueOf(this.emotionType) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Emotion{actualEmotion=");
    localStringBuilder.append(this.actualEmotion);
    localStringBuilder.append(", emotionType=");
    localStringBuilder.append(this.emotionType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.emotionType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.model.Emotion
 * JD-Core Version:    0.7.0.1
 */