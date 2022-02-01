package com.tencent.tmassistant.st;

import android.text.TextUtils;

public abstract class a
{
  public static final String EMPTY = " ";
  public static final String SPLIT = "|";
  
  public abstract String build();
  
  public void doReport()
  {
    SDKReportManager2.getInstance().postReport(getType(), build());
  }
  
  protected String filterSplitStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("|", "");
  }
  
  protected abstract int getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.st.a
 * JD-Core Version:    0.7.0.1
 */