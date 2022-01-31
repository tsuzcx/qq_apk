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

public class snb
  implements bhjk
{
  public static int a;
  public static volatile snb a;
  public static boolean a;
  public static boolean b;
  private long jdField_a_of_type_Long = 120000L;
  private bhhr jdField_a_of_type_Bhhr;
  private volatile boolean c;
  private boolean d = true;
  
  private long a()
  {
    return LocalMultiProcConfig.getLong("sp_weishi_update_plugin", "query_plugin_last_time", -1L);
  }
  
  public static snb a()
  {
    if (jdField_a_of_type_Snb == null) {}
    try
    {
      if (jdField_a_of_type_Snb == null) {
        jdField_a_of_type_Snb = new snb();
      }
      return jdField_a_of_type_Snb;
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
        bhjs.a().a(localQQAppInterface1);
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
      bhji.a(BaseApplicationImpl.getContext(), this);
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
    Object localObject = ske.a();
    sne.b("QzoneVerticalVideoPluginApk", "initPluginThreshold configBean = " + localObject);
    if ((localObject == null) || (((ske)localObject).a == null))
    {
      sne.d("QzoneVerticalVideoPluginApk", "doDownloadWeishi : configBean is null");
      return;
    }
    localObject = ((ske)localObject).a;
    this.jdField_a_of_type_Long = (((skh)localObject).jdField_a_of_type_Long * 1000L);
    this.d = ((skh)localObject).jdField_a_of_type_Boolean;
    QLog.i("QzoneVerticalVideoPluginApk", 1, "$$$$$$$$$$ QzoneVerticalVideoPluginApk mQueryPluginThreshold  = " + this.jdField_a_of_type_Long + " mIsPreloadInWsRecommend = " + this.d);
    b = true;
  }
  
  public void onQzonePluginClientReady(bhhr parambhhr)
  {
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady start");
    if (parambhhr == null) {
      bhji.a(BaseApplicationImpl.getContext(), this);
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
        bhjs.a().a(localQQAppInterface1);
      }
      this.jdField_a_of_type_Bhhr = parambhhr;
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
      parambhhr = this.jdField_a_of_type_Bhhr.a("qzone_vertical_video_plugin.apk");
      if (parambhhr != null)
      {
        jdField_a_of_type_Boolean = true;
        QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady start  state = " + parambhhr.state + " ver = " + parambhhr.ver + " old_ver = " + parambhhr.old_ver + " mainVersion = " + parambhhr.mainVersion + " installPath = " + parambhhr.mInstalledPath + " url = " + parambhhr.url + " id = " + parambhhr.id + " isvalid = " + parambhhr.isValid() + " name = " + parambhhr.name);
        if (parambhhr.state == 4)
        {
          this.c = false;
          c();
          QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady installed");
          return;
        }
        try
        {
          this.jdField_a_of_type_Bhhr.a("qzone_vertical_video_plugin.apk", new snc(this), 0);
        }
        catch (RemoteException parambhhr)
        {
          QLog.e("QzoneVerticalVideoPluginApk", 1, parambhhr, new Object[0]);
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
 * Qualified Name:     snb
 * JD-Core Version:    0.7.0.1
 */