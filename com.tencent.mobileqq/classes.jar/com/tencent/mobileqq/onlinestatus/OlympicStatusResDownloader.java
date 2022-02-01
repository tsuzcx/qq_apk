package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean.OlympicConfig;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfProcessor;
import com.tencent.mobileqq.onlinestatus.utils.ZipResourcesDownloader;
import com.tencent.qphone.base.util.QLog;

public class OlympicStatusResDownloader
{
  private ZipResourcesDownloader a = new ZipResourcesDownloader();
  
  public static String b()
  {
    OlympicConfBean.OlympicConfig localOlympicConfig = e();
    if (localOlympicConfig == null)
    {
      QLog.d("OlympicStatusResDownloader", 2, "[getOlympicResPath] config is null");
      return "";
    }
    return ZipResourcesDownloader.a(localOlympicConfig.a, localOlympicConfig.b);
  }
  
  public static String[] c()
  {
    return new String[] { "aio/animation/data.json", "aio/animation/images/", "share/1/", "share/2/", "share/3/", "share/share_mid_animation.png" };
  }
  
  public static boolean d()
  {
    Object localObject = e();
    if (localObject == null)
    {
      QLog.d("OlympicStatusResDownloader", 2, "[isResourceReady] config is null");
      return false;
    }
    String str = ((OlympicConfBean.OlympicConfig)localObject).a;
    localObject = ((OlympicConfBean.OlympicConfig)localObject).b;
    if (!TextUtils.isEmpty(str))
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return false;
      }
      return ZipResourcesDownloader.a(str, (String)localObject, c());
    }
    return false;
  }
  
  public static OlympicConfBean.OlympicConfig e()
  {
    return OlympicConfProcessor.b().b();
  }
  
  public void a()
  {
    QLog.d("OlympicStatusResDownloader", 2, "[OlympicStatusResDownloader] onDestroy call destroy zipDownloader");
    this.a.a();
  }
  
  public void a(AppInterface paramAppInterface)
  {
    Object localObject = OlympicConfProcessor.b().b();
    if (localObject == null)
    {
      QLog.d("OlympicStatusResDownloader", 2, "[OlympicStatusResDownloader] downloadRes config is null");
      return;
    }
    String str = ((OlympicConfBean.OlympicConfig)localObject).a;
    localObject = ((OlympicConfBean.OlympicConfig)localObject).b;
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      ThreadManagerV2.excute(new OlympicStatusResDownloader.1(this, str, (String)localObject, paramAppInterface), 16, null, true);
      return;
    }
    QLog.d("OlympicStatusResDownloader", 2, "[OlympicStatusResDownloader] downloadRes resUrl or md5 is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OlympicStatusResDownloader
 * JD-Core Version:    0.7.0.1
 */