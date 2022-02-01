package com.tencent.mobileqq.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.text.QQText;

public class AutoReplyText
  extends Entity
  implements Parcelable, Comparable<AutoReplyText>
{
  public static final Parcelable.Creator<AutoReplyText> CREATOR = new AutoReplyText.1();
  public static final int TEXT_NONE = 2147483647;
  public int mCheckFlag = 0;
  @notColumn
  private Bundle mExtra;
  public String mRawText;
  @unique
  public int mTextId;
  
  public AutoReplyText()
  {
    this.mExtra = new Bundle();
  }
  
  protected AutoReplyText(Parcel paramParcel)
  {
    this.mTextId = paramParcel.readInt();
    this.mRawText = paramParcel.readString();
    this.mCheckFlag = paramParcel.readInt();
    this.mExtra = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  public AutoReplyText(String paramString, int paramInt)
  {
    this.mRawText = paramString;
    this.mTextId = paramInt;
    this.mExtra = new Bundle();
  }
  
  public static String trimRawString(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return "";
    }
    String str = paramString;
    if (paramBoolean) {
      str = paramString.replace("\r\n", " ").replace('\n', ' ').replace('\r', ' ');
    }
    int k = str.length();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= k) {
        break;
      }
      int m = str.charAt(i);
      if ((m != 32) && (m != 13))
      {
        j = k;
        if (m != 10) {
          break;
        }
      }
      i += 1;
    }
    while (i < j)
    {
      k = str.charAt(j - 1);
      if ((k != 32) && (k != 13) && (k != 10)) {
        break;
      }
      j -= 1;
    }
    if (i <= 0)
    {
      paramString = str;
      if (j >= str.length()) {}
    }
    else
    {
      paramString = str.substring(i, j);
    }
    return paramString;
  }
  
  public int compareTo(@NonNull AutoReplyText paramAutoReplyText)
  {
    int i = this.mTextId;
    int j = paramAutoReplyText.mTextId;
    if (i < j) {
      return -1;
    }
    if (i == j) {
      return 0;
    }
    return 1;
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
      paramObject = (AutoReplyText)paramObject;
      return this.mTextId == paramObject.mTextId;
    }
    return false;
  }
  
  @NonNull
  public Bundle getExtra()
  {
    return this.mExtra;
  }
  
  public String getRawText()
  {
    if (this.mRawText == null) {
      this.mRawText = "";
    }
    return this.mRawText;
  }
  
  public CharSequence getText(int paramInt)
  {
    return new QQText(getRawText(), 3, paramInt);
  }
  
  public int getTextId()
  {
    return this.mTextId;
  }
  
  public int hashCode()
  {
    return this.mTextId + 177573 & 0x7FFFFFFF;
  }
  
  public boolean isChecked()
  {
    return this.mCheckFlag == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AutoReplyText{mTextId=");
    localStringBuilder.append(this.mTextId);
    localStringBuilder.append(", mRawText='");
    localStringBuilder.append(this.mRawText);
    localStringBuilder.append(", mCheckFlag='");
    localStringBuilder.append(this.mCheckFlag);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mTextId);
    paramParcel.writeString(this.mRawText);
    paramParcel.writeInt(this.mCheckFlag);
    paramParcel.writeBundle(this.mExtra);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.AutoReplyText
 * JD-Core Version:    0.7.0.1
 */