import android.os.RemoteException;
import com.tencent.biz.pubaccount.weishi_new.util.QzoneVerticalVideoPluginApk.2;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.plugin.PluginRecord;
import mqq.os.MqqHandler;

public class saf
  implements bgaz
{
  public static int a;
  public static volatile saf a;
  public static boolean a;
  public static boolean b;
  private long jdField_a_of_type_Long = 120000L;
  private bfzg jdField_a_of_type_Bfzg;
  private volatile boolean c;
  private boolean d = true;
  
  private long a()
  {
    return LocalMultiProcConfig.getLong("sp_weishi_update_plugin", "query_plugin_last_time", -1L);
  }
  
  public static saf a()
  {
    if (jdField_a_of_type_Saf == null) {}
    try
    {
      if (jdField_a_of_type_Saf == null) {
        jdField_a_of_type_Saf = new saf();
      }
      return jdField_a_of_type_Saf;
    }
    finally {}
  }
  
  private void c()
  {
    ThreadManager.getSubThreadHandler().post(new QzoneVerticalVideoPluginApk.2(this));
  }
  
  public void a()
  {
    b();
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk preInstall 01 mIsPreInstalling = " + this.c + " sPreloadPluginState = " + jdField_a_of_type_Int);
    if (jdField_a_of_type_Int == 1)
    {
      QQAppInterface localQQAppInterface2 = (QQAppInterface)QQStoryContext.a();
      QQAppInterface localQQAppInterface1 = localQQAppInterface2;
      if (localQQAppInterface2 == null) {
        localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
      if (localQQAppInterface1 != null)
      {
        bgbh.a().a(localQQAppInterface1);
        if (System.currentTimeMillis() - a() > 60000L) {
          jdField_a_of_type_Int = 0;
        }
      }
    }
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk preInstall 02 mIsPreInstalling = " + this.c + " sPreloadPluginState = " + jdField_a_of_type_Int);
    if ((!this.c) && (jdField_a_of_type_Int != 1))
    {
      this.c = true;
      QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk preInstall OK mIsPreInstalling = " + this.c + " sPreloadPluginState = " + jdField_a_of_type_Int);
      bgax.a(BaseApplicationImpl.getContext(), this);
    }
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    QLog.i("QzoneVerticalVideoPluginApk", 1, "$$$$$$$$$$ QzoneVerticalVideoPluginApk initPluginThreshold sInitPluginThreshold = " + b);
    if (b) {
      return;
    }
    Object localObject = rxi.a();
    sai.b("QzoneVerticalVideoPluginApk", "initPluginThreshold configBean = " + localObject);
    if ((localObject == null) || (((rxi)localObject).a == null))
    {
      sai.d("QzoneVerticalVideoPluginApk", "doDownloadWeishi : configBean is null");
      return;
    }
    localObject = ((rxi)localObject).a;
    this.jdField_a_of_type_Long = (((rxl)localObject).jdField_a_of_type_Long * 1000L);
    this.d = ((rxl)localObject).jdField_a_of_type_Boolean;
    QLog.i("QzoneVerticalVideoPluginApk", 1, "$$$$$$$$$$ QzoneVerticalVideoPluginApk mQueryPluginThreshold  = " + this.jdField_a_of_type_Long + " mIsPreloadInWsRecommend = " + this.d);
    b = true;
  }
  
  public void onQzonePluginClientReady(bfzg parambfzg)
  {
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady start");
    if (parambfzg == null) {
      bgax.a(BaseApplicationImpl.getContext(), this);
    }
    for (;;)
    {
      this.c = false;
      return;
      QQAppInterface localQQAppInterface2 = (QQAppInterface)QQStoryContext.a();
      QQAppInterface localQQAppInterface1 = localQQAppInterface2;
      if (localQQAppInterface2 == null)
      {
        QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady: getAppRuntime return null.");
        localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
      if (localQQAppInterface1 != null) {
        bgbh.a().a(localQQAppInterface1);
      }
      this.jdField_a_of_type_Bfzg = parambfzg;
      long l1 = a();
      long l2 = System.currentTimeMillis();
      long l3 = l2 - l1;
      if ((l1 > 0L) && (l3 < this.jdField_a_of_type_Long))
      {
        this.c = false;
        QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk ERR deltaTime < " + this.jdField_a_of_type_Long + " deltaTime = " + l3 + " curTime = " + l2 + " lastTime = " + l1 + " mIsPreInstalling = " + this.c);
        return;
      }
      QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk OK deltaTime > " + this.jdField_a_of_type_Long + " deltaTime = " + l3 + " curTime = " + l2 + " lastTime = " + l1);
      parambfzg = this.jdField_a_of_type_Bfzg.a("qzone_vertical_video_plugin.apk");
      if (parambfzg != null)
      {
        jdField_a_of_type_Boolean = true;
        QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady start  state = " + parambfzg.state + " ver = " + parambfzg.ver + " old_ver = " + parambfzg.old_ver + " mainVersion = " + parambfzg.mainVersion + " installPath = " + parambfzg.mInstalledPath + " url = " + parambfzg.url + " id = " + parambfzg.id + " isvalid = " + parambfzg.isValid() + " name = " + parambfzg.name);
        if (parambfzg.state == 4)
        {
          this.c = false;
          c();
          QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady installed");
          return;
        }
        try
        {
          this.jdField_a_of_type_Bfzg.a("qzone_vertical_video_plugin.apk", new sag(this), 0);
        }
        catch (RemoteException parambfzg)
        {
          QLog.e("QzoneVerticalVideoPluginApk", 1, parambfzg, new Object[0]);
        }
      }
      else
      {
        QLog.d("QzoneVerticalVideoPluginApk", 1, "record is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     saf
 * JD-Core Version:    0.7.0.1
 */