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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mTitle);
    paramParcel.writeInt(this.mPageNum);
    paramParcel.writeInt(this.mLevel);
    paramParcel.writeInt(this.mIsCurOutline);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.reader.PDFOutlineData
 * JD-Core Version:    0.7.0.1
 */