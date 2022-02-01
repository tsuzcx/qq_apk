package com.tencent.tbs.reader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PDFOutlineData
  implements Parcelable
{
  public static final Parcelable.Creator<PDFOutlineData> CREATOR = new PDFOutlineData.1();
  private int mIsCurOutline;
  private int mLevel;
  private int mPageNum;
  private String mTitle;
  
  public PDFOutlineData() {}
  
  public PDFOutlineData(String paramString, int paramInt1, int paramInt2)
  {
    this.mTitle = paramString;
    this.mPageNum = paramInt1;
    this.mLevel = paramInt2;
    this.mIsCurOutline = 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getOutlineLevel()
  {
    return this.mLevel;
  }
  
  public int getPage()
  {
    return this.mPageNum;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public boolean isCurrOutline()
  {
    return this.mIsCurOutline == 1;
  }
  
  public void setCurrOutline(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.mIsCurOutline = i;
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mTitle);
    paramParcel.writeInt(this.mPageNum);
    paramParcel.writeInt(this.mLevel);
    paramParcel.writeInt(this.mIsCurOutline);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.PDFOutlineData
 * JD-Core Version:    0.7.0.1
 */