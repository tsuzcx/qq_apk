package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.PrecoverData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PrecoverHandler
  extends EarlyHandler
{
  public PrecoverHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.early.precover", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10045;
  }
  
  public Class a()
  {
    return PrecoverData.class;
  }
  
  public String a()
  {
    return "actEarlyPrecover";
  }
  
  public void a(XmlData paramXmlData)
  {
    super.a(paramXmlData);
    if ((QLog.isColorLevel()) && (paramXmlData != null) && ((paramXmlData instanceof PrecoverData))) {
      QLog.d("PrecoverHandler", 2, new Object[] { "doOnServerResp, xmlData=", paramXmlData });
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return "prd";
  }
  
  public boolean c()
  {
    File localFile = new File(c());
    return (localFile != null) && (localFile.exists());
  }
  
  public boolean j()
  {
    File localFile = new File(d());
    return (localFile != null) && (localFile.exists());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.PrecoverHandler
 * JD-Core Version:    0.7.0.1
 */