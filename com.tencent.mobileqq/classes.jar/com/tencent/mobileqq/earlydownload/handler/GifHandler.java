package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.earlydownload.xmldata.GifData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class GifHandler
  extends EarlyHandler
{
  public int a()
  {
    return 10041;
  }
  
  public Class<? extends XmlData> a()
  {
    return GifData.class;
  }
  
  public String a()
  {
    return "actEarlyNativeGif";
  }
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GifHandler", 2, "func doOnServerResp begins, respData" + paramXmlData);
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.GifHandler
 * JD-Core Version:    0.7.0.1
 */