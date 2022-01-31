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

public class smy
  implements bhkb
{
  public static int a;
  public static volatile smy a;
  public static boolean a;
  public static boolean b;
  private long jdField_a_of_type_Long = 120000L;
  private bhii jdField_a_of_type_Bhii;
  private volatile boolean c;
  private boolean d = true;
  
  private long a()
  {
    return LocalMultiProcConfig.getLong("sp_weishi_update_plugin", "query_plugin_last_time", -1L);
  }
  
  public static smy a()
  {
    if (jdField_a_of_type_Smy == null) {}
    try
    {
      if (jdField_a_of_type_Smy == null) {
        jdField_a_of_type_Smy = new smy();
      }
      return jdField_a_of_type_Smy;
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
        bhkj.a().a(localQQAppInterface1);
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
      bhjz.a(BaseApplicationImpl.getContext(), this);
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
    Object localObject = skb.a();
    snb.b("QzoneVerticalVideoPluginApk", "initPluginThreshold configBean = " + localObject);
    if ((localObject == null) || (((skb)localObject).a == null))
    {
      snb.d("QzoneVerticalVideoPluginApk", "doDownloadWeishi : configBean is null");
      return;
    }
    localObject = ((skb)localObject).a;
    this.jdField_a_of_type_Long = (((ske)localObject).jdField_a_of_type_Long * 1000L);
    this.d = ((ske)localObject).jdField_a_of_type_Boolean;
    QLog.i("QzoneVerticalVideoPluginApk", 1, "$$$$$$$$$$ QzoneVerticalVideoPluginApk mQueryPluginThreshold  = " + this.jdField_a_of_type_Long + " mIsPreloadInWsRecommend = " + this.d);
    b = true;
  }
  
  public void onQzonePluginClientReady(bhii parambhii)
  {
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady start");
    if (parambhii == null) {
      bhjz.a(BaseApplicationImpl.getContext(), this);
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
        bhkj.a().a(localQQAppInterface1);
      }
      this.jdField_a_of_type_Bhii = parambhii;
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
      parambhii = this.jdField_a_of_type_Bhii.a("qzone_vertical_video_plugin.apk");
      if (parambhii != null)
      {
        jdField_a_of_type_Boolean = true;
        QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady start  state = " + parambhii.state + " ver = " + parambhii.ver + " old_ver = " + parambhii.old_ver + " mainVersion = " + parambhii.mainVersion + " installPath = " + parambhii.mInstalledPath + " url = " + parambhii.url + " id = " + parambhii.id + " isvalid = " + parambhii.isValid() + " name = " + parambhii.name);
        if (parambhii.state == 4)
        {
          this.c = false;
          c();
          QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady installed");
          return;
        }
        try
        {
          this.jdField_a_of_type_Bhii.a("qzone_vertical_video_plugin.apk", new smz(this), 0);
        }
        catch (RemoteException parambhii)
        {
          QLog.e("QzoneVerticalVideoPluginApk", 1, parambhii, new Object[0]);
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
 * Qualified Name:     smy
 * JD-Core Version:    0.7.0.1
 */