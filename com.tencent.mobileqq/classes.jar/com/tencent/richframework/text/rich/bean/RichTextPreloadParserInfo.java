package com.tencent.richframework.text.rich.bean;

import android.text.Spanned;
import android.text.SpannedString;
import com.tencent.qphone.base.util.QLog;

public class RichTextPreloadParserInfo
{
  public String a;
  private Spanned b;
  private String c;
  
  public RichTextPreloadParserInfo(String paramString, Spanned paramSpanned)
  {
    this.a = paramString;
    this.b = paramSpanned;
  }
  
  public Spanned a()
  {
    Spanned localSpanned = this.b;
    if (localSpanned != null) {
      return localSpanned;
    }
    return new SpannedString("");
  }
  
  public void a(Spanned paramSpanned)
  {
    this.b = paramSpanned;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public String b()
  {
    String str = this.a;
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public String c()
  {
    try
    {
      Object localObject = a();
      if (localObject == null) {
        return "";
      }
      int i = localObject.toString().hashCode();
      if (this.c != null) {
        return this.c;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCacheKey  e = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("RichTextPreloadParserInfo", 1, localStringBuilder.toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo
 * JD-Core Version:    0.7.0.1
 */