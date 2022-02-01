package dov.com.qq.im.ae.download.old;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEOldQuicResDownload
  implements AEOldShortVideoResStatus.ISVConfig
{
  private static final String jdField_a_of_type_JavaLangString = Environment.getDataDirectory() + "/data/" + BaseApplicationImpl.sApplication.getBaseContext().getPackageName() + "/app_lib/quic/";
  public static boolean a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public AEOldQuicResDownload(QQAppInterface paramQQAppInterface)
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
    boolean bool = NetworkUtil.h(null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("AEOldQuicResDownload", "QUIC配置下载中...", null);
      AEOldShortVideoResManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      AEOldShortVideoResManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return bool;
    }
    VideoEnvironment.LogDownLoad("AEOldQuicResDownload", HardCodeUtil.a(2131711213), null);
    return bool;
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
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("AEOldQuicResDownload", "onConfigResult | result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0) {
        VideoEnvironment.LogDownLoad("AEOldQuicResDownload", "onConfigResult| uncompress config error=" + paramInt2, null);
      }
      for (;;)
      {
        return;
        ArrayList localArrayList = new ArrayList(1);
        paramInt1 = AEOldShortVideoResManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
        if (paramInt1 != 0) {
          break;
        }
        VideoEnvironment.LogDownLoad("AEOldQuicResDownload", "onConfigResult| check config success...", null);
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          AEOldShortVideoResManager.SVConfigItem localSVConfigItem = (AEOldShortVideoResManager.SVConfigItem)localIterator.next();
          if (localSVConfigItem.name.startsWith("msf_quic_lib"))
          {
            VideoEnvironment.LogDownLoad("AEOldQuicResDownload", "onConfigResult| name=" + localSVConfigItem.name + " url=" + localSVConfigItem.armv7a_url, null);
            AEOldShortVideoResManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
          }
        }
      }
      VideoEnvironment.LogDownLoad("AEOldQuicResDownload", "onConfigResult| check config error=" + paramInt1, null);
      return;
    }
    VideoEnvironment.LogDownLoad("AEOldQuicResDownload", "onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldQuicResDownload
 * JD-Core Version:    0.7.0.1
 */