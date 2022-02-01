package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.earlydownload.xmldata.GifData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class GifHandler
  extends EarlyHandler
{
  public Class<? extends XmlData> a()
  {
    return GifData.class;
  }
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func doOnServerResp begins, respData");
      localStringBuilder.append(paramXmlData);
      QLog.d("GifHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
  }
  
  public String b()
  {
    return "actEarlyNativeGif";
  }
  
  public int c()
  {
    return 10041;
  }
  
  public String d()
  {
    return null;
  }
  
  public boolean e()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.GifHandler
 * JD-Core Version:    0.7.0.1
 */