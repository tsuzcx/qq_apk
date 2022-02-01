package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.JpegSoData;
import com.tencent.mobileqq.earlydownload.xmldata.PttTransitonAnimData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PttTransitionAnimHandler
  extends EarlyHandler
{
  public PttTransitionAnimHandler(QQAppInterface paramQQAppInterface)
  {
    super("ptt.transition.anim.res.zip", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10094;
  }
  
  public Class<? extends XmlData> a()
  {
    return PttTransitonAnimData.class;
  }
  
  public String a()
  {
    return "PttTransitionAnimZip";
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PttTransitionAnimHandler onDownloadProgeress() curOffset=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" totalLen=");
      localStringBuilder.append(paramLong2);
      QLog.d("EarlyDown", 2, localStringBuilder.toString());
    }
    super.a(paramLong1, paramLong2);
  }
  
  public void a(XmlData paramXmlData)
  {
    if ((QLog.isColorLevel()) && (paramXmlData != null) && ((paramXmlData instanceof JpegSoData))) {
      QLog.d("EarlyDown", 2, new Object[] { "PttTransitionAnimHandler doOnServerResp, xmlData=", paramXmlData });
    }
    super.a(paramXmlData);
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" PttTransitionAnimHandler download success: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = AudioTransitionAnimManager.a;
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        FileUtils.deleteDirectory((String)localObject);
        if (new File((String)localObject).mkdir())
        {
          FileUtils.uncompressZip(paramString, (String)localObject, false);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" PttTransitionAnimHandler uncompressZip success: ");
            localStringBuilder.append(paramString);
            localStringBuilder.append(" tempPath=");
            localStringBuilder.append((String)localObject);
            QLog.d("EarlyDown", 2, localStringBuilder.toString());
          }
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PttTransitionAnimHandler uncompressZip failed: ");
        localStringBuilder.append(localException.getMessage());
        QLog.d("EarlyDown", 2, localStringBuilder.toString());
      }
    }
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
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "PttTransitionAnimHandler onDownloadBegin()");
    }
    super.b(paramXmlData);
  }
  
  public boolean h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "PttTransitionAnimHandler isUserNeedDownload");
    }
    if ((PttTransitonAnimData)a() == null) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PttTransitionAnimHandler isUserNeedDownload return ");
      localStringBuilder.append(true);
      QLog.d("EarlyDown", 2, localStringBuilder.toString());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.PttTransitionAnimHandler
 * JD-Core Version:    0.7.0.1
 */