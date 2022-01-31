package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.xmldata.ApolloJscLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.SOPreLoader;
import java.io.File;

public class ApolloJscHandler
  extends EarlyHandler
{
  public ApolloJscHandler(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.apollo.jsc", paramQQAppInterface);
  }
  
  public static void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (EarlyDownloadManager)((QQAppInterface)localObject).getManager(76);
      if (localObject != null)
      {
        localObject = (ApolloJscHandler)((EarlyDownloadManager)localObject).a("android.qq.apollo.jsc");
        if (localObject != null)
        {
          ((ApolloJscHandler)localObject).a(true);
          QLog.i("ApolloSoLoader_JscHandler", 1, "restartDownload jscLib");
        }
      }
    }
  }
  
  public int a()
  {
    return 10072;
  }
  
  public Class a()
  {
    return ApolloJscLibData.class;
  }
  
  public String a()
  {
    return "ApolloSoLoader_JscHandler";
  }
  
  public void a(String paramString)
  {
    QLog.i("ApolloSoLoader_JscHandler", 1, "[doOnDownloadSuccess] jsc:" + paramString);
    XmlData localXmlData = a();
    if (localXmlData != null) {
      QLog.i("ApolloSoLoader_JscHandler", 1, "version:" + localXmlData.Version);
    }
    if (new File(paramString).exists())
    {
      if (SOPreLoader.a(paramString, 0)) {
        break label130;
      }
      if (localXmlData != null)
      {
        localXmlData.loadState = 0;
        localXmlData.Version = 0;
        EarlyDataFactory.a(localXmlData, new String[] { "loadState", "Version" });
      }
      QLog.e("ApolloSoLoader_JscHandler", 1, "[doOnDownloadSuccess],unzip apollo jsclib failed!");
    }
    for (;;)
    {
      super.a(paramString);
      return;
      label130:
      ApolloSoLoader.a("after_JSC_downloaded");
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ApolloJscHandler
 * JD-Core Version:    0.7.0.1
 */