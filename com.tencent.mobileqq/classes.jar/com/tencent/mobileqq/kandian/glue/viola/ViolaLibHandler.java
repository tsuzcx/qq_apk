package com.tencent.mobileqq.kandian.glue.viola;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.ViolaLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.kandian.biz.viola.constants.IViolaLibHandlerConst;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInjoyWebRenderSoLoader;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ViolaLibHandler
  extends EarlyHandler
  implements IViolaLibHandlerConst
{
  public ViolaLibHandler(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.readinjoy.viola_795", paramQQAppInterface);
  }
  
  public static boolean w()
  {
    String str = ReadInjoyWebRenderSoLoader.a();
    int i = 0;
    while (i < IViolaLibHandlerConst.a.length)
    {
      File localFile = new File(str, IViolaLibHandlerConst.a[i]);
      if (localFile.exists())
      {
        if (!localFile.isFile()) {
          return false;
        }
        i += 1;
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public static void x()
  {
    if (w()) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (IEarlyDownloadService)((QQAppInterface)localObject).getRuntimeService(IEarlyDownloadService.class, "");
      if (localObject != null)
      {
        localObject = (ViolaLibHandler)((IEarlyDownloadService)localObject).getEarlyHandler("android.qq.readinjoy.viola_795");
        if (localObject != null)
        {
          ((ViolaLibHandler)localObject).a(true);
          QLog.i("viola.ViolaLibHandler", 1, "restartDownloadLib");
        }
      }
    }
    if (!ViolaBizLibHandler.x()) {
      ViolaBizLibHandler.w();
    }
  }
  
  public Class<? extends XmlData> a()
  {
    return ViolaLibData.class;
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[doOnDownloadSuccess]:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("viola.ViolaLibHandler", 1, ((StringBuilder)localObject).toString());
    localObject = h();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("version:");
      localStringBuilder.append(((XmlData)localObject).Version);
      QLog.i("viola.ViolaLibHandler", 1, localStringBuilder.toString());
    }
    if (new File(paramString).exists())
    {
      if (!ReadInjoyWebRenderSoLoader.a(paramString))
      {
        if (localObject != null)
        {
          ((XmlData)localObject).loadState = 0;
          ((XmlData)localObject).Version = 0;
          EarlyDataFactory.a((XmlData)localObject, new String[] { "loadState", "Version" });
        }
        QLog.e("viola.ViolaLibHandler", 1, "[doOnDownloadSuccess],unzip readinjoy_viola lib failed!");
        return;
      }
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
      if (paramString != null) {
        paramString.edit().putString("res_name", "android.qq.readinjoy.viola_795").commit();
      }
      if ((ViolaBizLibHandler.x()) && (ViolaSoLoaderManager.a.a().e())) {
        ReadInJoyWebRenderEngine.a("jsc doOnDownloadSuccess");
      }
    }
  }
  
  public String b()
  {
    return "viola.ViolaLibHandler";
  }
  
  public int c()
  {
    return 10071;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaLibHandler
 * JD-Core Version:    0.7.0.1
 */