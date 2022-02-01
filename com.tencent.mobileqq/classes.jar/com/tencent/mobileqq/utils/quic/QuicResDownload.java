package com.tencent.mobileqq.utils.quic;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import anvx;
import bcyc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuicResDownload
  implements bcyc
{
  private static final String jdField_a_of_type_JavaLangString = Environment.getDataDirectory() + "/data/" + BaseApplicationImpl.sApplication.getBaseContext().getPackageName() + "/app_lib/quic/";
  public static boolean a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public QuicResDownload(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("quic_res_config", 4).getInt("quic_res_version", 0);
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  private boolean a()
  {
    boolean bool = NetworkUtil.isWifiConnected(null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("QuicResDownload", "QUIC配置下载中...", null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoResourceManager();
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return bool;
    }
    VideoEnvironment.LogDownLoad("QuicResDownload", anvx.a(2131710698), null);
    return bool;
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
    return jdField_a_of_type_JavaLangString + "backup" + File.separator;
  }
  
  public static String c()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("quic_res_config", 4).getString("quic_res_load_path", jdField_a_of_type_JavaLangString);
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("QuicResDownload", "onConfigResult | result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0) {
        VideoEnvironment.LogDownLoad("QuicResDownload", "onConfigResult| uncompress config error=" + paramInt2, null);
      }
      for (;;)
      {
        return;
        ArrayList localArrayList = new ArrayList(1);
        paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
        if (paramInt1 != 0) {
          break;
        }
        VideoEnvironment.LogDownLoad("QuicResDownload", "onConfigResult| check config success...", null);
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          ShortVideoResourceManager.SVConfigItem localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
          if (localSVConfigItem.name.startsWith("msf_quic_lib"))
          {
            VideoEnvironment.LogDownLoad("QuicResDownload", "onConfigResult| name=" + localSVConfigItem.name + " url=" + localSVConfigItem.armv7a_url, null);
            ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
          }
        }
      }
      VideoEnvironment.LogDownLoad("QuicResDownload", "onConfigResult| check config error=" + paramInt1, null);
      return;
    }
    VideoEnvironment.LogDownLoad("QuicResDownload", "onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.quic.QuicResDownload
 * JD-Core Version:    0.7.0.1
 */