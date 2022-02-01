package com.tencent.mobileqq.kandian.glue.viola;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.ViolaBizLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.kandian.biz.viola.constants.IViolaBizLibHandlerConst;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInjoyWebRenderSoLoader;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ViolaBizLibHandler
  extends EarlyHandler
  implements IViolaBizLibHandlerConst
{
  public ViolaBizLibHandler(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.readinjoy.viola_biz_810", paramQQAppInterface);
  }
  
  public static void w()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (IEarlyDownloadService)((QQAppInterface)localObject).getRuntimeService(IEarlyDownloadService.class, "");
      if (localObject != null)
      {
        localObject = (ViolaBizLibHandler)((IEarlyDownloadService)localObject).getEarlyHandler("android.qq.readinjoy.viola_biz_810");
        if (localObject != null)
        {
          ((ViolaBizLibHandler)localObject).a(true);
          QLog.i("viola.ViolaBizLibHandler", 1, "restartDownloadLib");
        }
      }
    }
  }
  
  public static boolean x()
  {
    String str = ReadInjoyWebRenderSoLoader.a();
    int i = 0;
    while (i < IViolaBizLibHandlerConst.a.length)
    {
      File localFile = new File(str, IViolaBizLibHandlerConst.a[i]);
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
  
  public Class<? extends XmlData> a()
  {
    return ViolaBizLibData.class;
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[doOnDownloadSuccess]:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("viola.ViolaBizLibHandler", 1, ((StringBuilder)localObject).toString());
    localObject = h();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("version:");
      localStringBuilder.append(((XmlData)localObject).Version);
      QLog.i("viola.ViolaBizLibHandler", 1, localStringBuilder.toString());
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
        QLog.e("viola.ViolaBizLibHandler", 1, "[doOnDownloadSuccess],unzip android.qq.readinjoy.viola_biz_810 lib failed!");
        return;
      }
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
      if (paramString != null) {
        paramString.edit().putString("res_name", "android.qq.readinjoy.viola_biz_810").commit();
      }
      if ((ViolaLibHandler.w()) && (ViolaSoLoaderManager.a.a().e())) {
        ReadInJoyWebRenderEngine.a("biz doOnDownloadSuccess");
      }
    }
  }
  
  public String b()
  {
    return "viola.ViolaBizLibHandler";
  }
  
  public int c()
  {
    return 10079;
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
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaBizLibHandler
 * JD-Core Version:    0.7.0.1
 */