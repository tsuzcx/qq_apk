import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lmo
{
  lmj jdField_a_of_type_Lmj = null;
  lmp jdField_a_of_type_Lmp = null;
  boolean jdField_a_of_type_Boolean = false;
  
  lmo()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, "QavGPDownloader in QQAppInterface");
    }
    this.jdField_a_of_type_Lmp = new lmp();
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
    if (lmk.a()) {
      lmk.a().a.b(paramString);
    }
  }
  
  public static void a(lmj paramlmj)
  {
    SharedPreferences localSharedPreferences = lmr.a();
    paramlmj = paramlmj.b;
    localSharedPreferences.edit().putString("so_zip_md5", paramlmj).commit();
  }
  
  public static boolean a()
  {
    return lmk.a().a.b();
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
    if (this.jdField_a_of_type_Lmj == null) {
      this.jdField_a_of_type_Lmj = lmj.a();
    }
    localObject = this.jdField_a_of_type_Lmj;
    if (localObject == null)
    {
      QLog.d("QavGPDownloadManager", 2, "downloadInfo == null");
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    if (11 == lmr.a((lmj)localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        QLog.d("QavGPDownloadManager", 2, "downloadTask.start");
        return this.jdField_a_of_type_Lmp.a((lmj)localObject);
      }
      QLog.d("QavGPDownloadManager", 2, "bDownloading = false");
      return bool;
    }
  }
  
  void b(String paramString)
  {
    lmj locallmj = null;
    if (!TextUtils.isEmpty(paramString)) {
      locallmj = lmj.a(paramString);
    }
    this.jdField_a_of_type_Lmj = locallmj;
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("QavGPDownloadManager", 1, "handle_QAG_QavGameplay_Config, mNeedDownloadAfterGetConfig == true");
      this.jdField_a_of_type_Boolean = false;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmo
 * JD-Core Version:    0.7.0.1
 */