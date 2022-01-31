import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class mcg
{
  DownloadInfo jdField_a_of_type_ComTencentAvSoDownloadInfo = null;
  mch jdField_a_of_type_Mch = null;
  
  mcg()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, "SoMgrAppDownload in QQAppInterface");
    }
    this.jdField_a_of_type_Mch = new mch();
  }
  
  static void a(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.video.somgr.notify");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("Event_Progress", paramInt);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    SharedPreferences localSharedPreferences = DownloadInfo.getSP();
    if ((paramInt & 0x1) == 1)
    {
      String str = paramDownloadInfo.MD5_zip_so;
      localSharedPreferences.edit().putString("so_zip_md5", str).commit();
    }
    if ((paramInt & 0x2) == 2)
    {
      paramDownloadInfo = paramDownloadInfo.MD5_zip_model;
      localSharedPreferences.edit().putString("model_zip_md5", paramDownloadInfo).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    mce.a().a.b(paramQQAppInterface, paramString, paramConfigInfo);
  }
  
  public static boolean a()
  {
    return mce.a().a.b();
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists())
    {
      if (!paramString2.equalsIgnoreCase(awni.a(paramString1)))
      {
        QLog.i("QavSo", 1, "checkFileValid failed. check md5 failed. filename = " + paramString1 + ", md5FromConfig = " + paramString2);
        return false;
      }
      return true;
    }
    QLog.i("QavSo", 1, "checkFileValid failed. file is not exist. filename = " + paramString1 + ", md5FromConfig = " + paramString2);
    return false;
  }
  
  void b(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_ComTencentAvSoDownloadInfo = ((DownloadInfo)paramConfigInfo);
    if (this.jdField_a_of_type_ComTencentAvSoDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentAvSoDownloadInfo = DownloadInfo.get();
    }
    QLog.w("QavSo", 1, "handle_QAV_So_Config, configInfo[" + paramConfigInfo + "], mDownloadInfo[" + this.jdField_a_of_type_ComTencentAvSoDownloadInfo + "]");
    if (this.jdField_a_of_type_ComTencentAvSoDownloadInfo.is_auto_download) {
      a();
    }
  }
  
  boolean b()
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    boolean bool2;
    if ((localObject instanceof QQAppInterface))
    {
      if (((QQAppInterface)localObject).getManager(21) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavSo", 4, "innerDownload, getNetEngine 为空");
        }
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavSo", 4, "appRuntime 不是 QQAppInterface");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvSoDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentAvSoDownloadInfo = DownloadInfo.get();
    }
    localObject = this.jdField_a_of_type_ComTencentAvSoDownloadInfo;
    if (localObject == null) {
      return false;
    }
    if (11 == mcl.a((DownloadInfo)localObject)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      return this.jdField_a_of_type_Mch.a((DownloadInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mcg
 * JD-Core Version:    0.7.0.1
 */