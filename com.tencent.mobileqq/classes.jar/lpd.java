import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lpd
{
  loy jdField_a_of_type_Loy = null;
  lpe jdField_a_of_type_Lpe = null;
  boolean jdField_a_of_type_Boolean = false;
  
  lpd()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, "QavGPDownloader in QQAppInterface");
    }
    this.jdField_a_of_type_Lpe = new lpe();
  }
  
  static void a(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.video.qavgameplaysomgr.notify");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("Event_Progress", paramInt);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, "onEnterBackground");
    }
    a();
  }
  
  public static void a(String paramString)
  {
    if (loz.a()) {
      loz.a().a.b(paramString);
    }
  }
  
  public static void a(loy paramloy)
  {
    SharedPreferences localSharedPreferences = lpg.a();
    paramloy = paramloy.b;
    localSharedPreferences.edit().putString("so_zip_md5", paramloy).commit();
  }
  
  public static boolean a()
  {
    return loz.a().a.b();
  }
  
  private boolean b()
  {
    QLog.d("QavGPDownloadManager", 4, "innerDownload, start");
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (((QQAppInterface)localObject).getManager(21) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavGPDownloadManager", 4, "innerDownload, getNetEngine 为空");
        }
        return false;
      }
    }
    else
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, "appRuntime 不是 QQAppInterface");
      }
      return false;
    }
    if (this.jdField_a_of_type_Loy == null) {
      this.jdField_a_of_type_Loy = loy.a();
    }
    localObject = this.jdField_a_of_type_Loy;
    if (localObject == null)
    {
      QLog.d("QavGPDownloadManager", 2, "downloadInfo == null");
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    if (11 == lpg.a((loy)localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        QLog.d("QavGPDownloadManager", 2, "downloadTask.start");
        return this.jdField_a_of_type_Lpe.a((loy)localObject);
      }
      QLog.d("QavGPDownloadManager", 2, "bDownloading = false");
      return bool;
    }
  }
  
  void b(String paramString)
  {
    loy localloy = null;
    if (!TextUtils.isEmpty(paramString)) {
      localloy = loy.a(paramString);
    }
    this.jdField_a_of_type_Loy = localloy;
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("QavGPDownloadManager", 1, "handle_QAG_QavGameplay_Config, mNeedDownloadAfterGetConfig == true");
      this.jdField_a_of_type_Boolean = false;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lpd
 * JD-Core Version:    0.7.0.1
 */