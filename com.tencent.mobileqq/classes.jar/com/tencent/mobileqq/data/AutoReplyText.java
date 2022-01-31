package com.tencent.mobileqq.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import aozm;
import awbv;
import awdg;
import awdj;
import baig;

public class AutoReplyText
  extends awbv
  implements Parcelable, Comparable<AutoReplyText>
{
  public static final Parcelable.Creator<AutoReplyText> CREATOR = new aozm();
  public static final int TEXT_NONE = 2147483647;
  public int mCheckFlag;
  @awdg
  private Bundle mExtra;
  public String mRawText;
  @awdj
  public int mTextId;
  
  public AutoReplyText()
  {
    this.mExtra = new Bundle();
  }
  
  public AutoReplyText(Parcel paramParcel)
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
      paramString = "";
    }
    String str;
    int i;
    int j;
    do
    {
      return paramString;
      str = paramString;
      if (paramBoolean) {
        str = paramString.replace("\r\n", " ").replace('\n', ' ').replace('\r', ' ');
      }
      int k = str.length();
      i = 0;
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
      if (i > 0) {
        break;
      }
      paramString = str;
    } while (j >= str.length());
    return str.substring(i, j);
  }
  
  public int compareTo(@NonNull AutoReplyText paramAutoReplyText)
  {
    if (this.mTextId < paramAutoReplyText.mTextId) {
      return -1;
    }
    if (this.mTextId == paramAutoReplyText.mTextId) {
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
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AutoReplyText)paramObject;
    } while (this.mTextId == paramObject.mTextId);
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
    return new baig(getRawText(), 3, paramInt);
  }
  
  public int getTextId()
  {
    return this.mTextId;
  }
  
  public int hashCode()
  {
    return 177573 + this.mTextId & 0x7FFFFFFF;
  }
  
  public boolean isChecked()
  {
    return this.mCheckFlag == 1;
  }
  
  public String toString()
  {
    return "AutoReplyText{mTextId=" + this.mTextId + ", mRawText='" + this.mRawText + ", mCheckFlag='" + this.mCheckFlag + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mTextId);
    paramParcel.writeString(this.mRawText);
    paramParcel.writeInt(this.mCheckFlag);
    paramParcel.writeBundle(this.mExtra);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.AutoReplyText
 * JD-Core Version:    0.7.0.1
 */