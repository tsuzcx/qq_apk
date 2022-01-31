package com.tencent.widget.soload;

import android.text.TextUtils;
import java.io.Serializable;

public class LoadExtResult
  implements Serializable
{
  private int downloadSoNum;
  private int failIndex;
  private boolean isFirstlyLoad = true;
  private String reportStr = "";
  private int resCode;
  private int soNum;
  
  private LoadExtResult a(LoadExtResult paramLoadExtResult)
  {
    if (paramLoadExtResult == null) {
      return this;
    }
    this.soNum += paramLoadExtResult.soNum;
    this.resCode = paramLoadExtResult.resCode;
    this.downloadSoNum += paramLoadExtResult.downloadSoNum;
    if ((this.isFirstlyLoad) || (paramLoadExtResult.isFirstlyLoad)) {}
    for (boolean bool = true;; bool = false)
    {
      this.isFirstlyLoad = bool;
      if (TextUtils.isEmpty(paramLoadExtResult.reportStr)) {
        break;
      }
      if (!TextUtils.isEmpty(this.reportStr)) {
        this.reportStr += "&";
      }
      this.reportStr += paramLoadExtResult.reportStr;
      return this;
    }
  }
  
  public static LoadExtResult create(int paramInt1, int paramInt2)
  {
    return create(paramInt1, paramInt2, false, true, null);
  }
  
  public static LoadExtResult create(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i = 0;
    LoadExtResult localLoadExtResult = new LoadExtResult();
    localLoadExtResult.soNum = paramInt2;
    localLoadExtResult.resCode = paramInt1;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      localLoadExtResult.downloadSoNum = paramInt2;
      localLoadExtResult.isFirstlyLoad = paramBoolean2;
      if (localLoadExtResult.resCode != 0) {
        break label104;
      }
    }
    label104:
    for (paramInt2 = i;; paramInt2 = 1)
    {
      localLoadExtResult.failIndex = paramInt2;
      if (!TextUtils.isEmpty(paramString)) {
        localLoadExtResult.reportStr = (paramString + "=" + paramInt1);
      }
      return localLoadExtResult;
      paramInt2 = 0;
      break;
    }
  }
  
  public static LoadExtResult mergeExtResult(LoadExtResult paramLoadExtResult1, LoadExtResult paramLoadExtResult2)
  {
    if (paramLoadExtResult2 == null) {
      return paramLoadExtResult1;
    }
    return paramLoadExtResult2.a(paramLoadExtResult1);
  }
  
  public int getReportCode()
  {
    int j = this.soNum;
    int k = this.resCode;
    int m = this.failIndex;
    int n = this.downloadSoNum;
    if (this.isFirstlyLoad) {}
    for (int i = 0;; i = 1) {
      return i + (n * 10 + (j * 100000 + k * 1000 + m * 100));
    }
  }
  
  public String getReportStr()
  {
    return this.reportStr;
  }
  
  public void setFailIndex(int paramInt)
  {
    this.failIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.soload.LoadExtResult
 * JD-Core Version:    0.7.0.1
 */