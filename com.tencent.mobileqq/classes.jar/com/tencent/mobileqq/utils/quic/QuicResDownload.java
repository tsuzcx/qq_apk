package com.tencent.mobileqq.utils.quic;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuicResDownload
  implements ShortVideoResourceStatus.ISVConfig
{
  public static boolean a = false;
  private static final String c;
  private QQAppInterface b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getDataDirectory());
    localStringBuilder.append("/data/");
    localStringBuilder.append(BaseApplicationImpl.sApplication.getBaseContext().getPackageName());
    localStringBuilder.append("/app_lib/quic/");
    c = localStringBuilder.toString();
  }
  
  public QuicResDownload(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  public static String a()
  {
    return c;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return true;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("quic_res_config", 4).edit();
    localEditor.putString("quic_res_load_path", paramString).putInt("quic_res_version", paramInt);
    return localEditor.commit();
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("backup");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String c()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("quic_res_config", 4).getString("quic_res_load_path", c);
  }
  
  public static int d()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("quic_res_config", 4).getInt("quic_res_version", 0);
  }
  
  private boolean e()
  {
    boolean bool = NetworkUtil.isWifiConnected(null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("QuicResDownload", "QUIC配置下载中...", null);
      this.b.getShortVideoResourceManager();
      ShortVideoResourceManager.b(this.b, this);
      return bool;
    }
    VideoEnvironment.LogDownLoad("QuicResDownload", HardCodeUtil.a(2131908847), null);
    return bool;
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onConfigResult | result=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",serverError=");
    ((StringBuilder)localObject).append(paramInt2);
    VideoEnvironment.LogDownLoad("QuicResDownload", ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConfigResult| result= RESULT_FAILED error=");
      ((StringBuilder)localObject).append(paramInt2);
      VideoEnvironment.LogDownLoad("QuicResDownload", ((StringBuilder)localObject).toString(), null);
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConfigResult| uncompress config error=");
      ((StringBuilder)localObject).append(paramInt2);
      VideoEnvironment.LogDownLoad("QuicResDownload", ((StringBuilder)localObject).toString(), null);
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a(this.b, (List)localObject);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad("QuicResDownload", "onConfigResult| check config success...", null);
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        ShortVideoResourceManager.SVConfigItem localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
        if (localSVConfigItem.name.startsWith("msf_quic_lib"))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onConfigResult| name=");
          localStringBuilder.append(localSVConfigItem.name);
          localStringBuilder.append(" url=");
          localStringBuilder.append(localSVConfigItem.armv7a_url);
          VideoEnvironment.LogDownLoad("QuicResDownload", localStringBuilder.toString(), null);
          ShortVideoResourceManager.b(this.b, (List)localObject);
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onConfigResult| check config error=");
    ((StringBuilder)localObject).append(paramInt1);
    VideoEnvironment.LogDownLoad("QuicResDownload", ((StringBuilder)localObject).toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.quic.QuicResDownload
 * JD-Core Version:    0.7.0.1
 */