package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.PrecoverData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class PrecoverHandler
  extends EarlyHandler
{
  public PrecoverHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.early.precover", paramQQAppInterface);
  }
  
  public Class<? extends XmlData> a()
  {
    return PrecoverData.class;
  }
  
  public void a(XmlData paramXmlData)
  {
    super.a(paramXmlData);
    if ((QLog.isColorLevel()) && (paramXmlData != null) && ((paramXmlData instanceof PrecoverData))) {
      QLog.d("PrecoverHandler", 2, new Object[] { "doOnServerResp, xmlData=", paramXmlData });
    }
  }
  
  public String b()
  {
    return "actEarlyPrecover";
  }
  
  public int c()
  {
    return 10045;
  }
  
  public String d()
  {
    return "prd";
  }
  
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.PrecoverHandler
 * JD-Core Version:    0.7.0.1
 */