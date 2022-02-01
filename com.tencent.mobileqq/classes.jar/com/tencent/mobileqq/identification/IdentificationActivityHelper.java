package com.tencent.mobileqq.identification;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.util.FaceSharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.ytcommon.util.YTCommonInterface;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class IdentificationActivityHelper
  implements EIPCResultCallback
{
  public static boolean b = false;
  public int a;
  public AtomicBoolean c = new AtomicBoolean(false);
  private QQIdentiferActivity d;
  private IdentificationBaseModel e;
  
  @RequiresApi(api=18)
  public IdentificationActivityHelper(QQIdentiferActivity paramQQIdentiferActivity, int paramInt)
  {
    this.d = paramQQIdentiferActivity;
    this.e = IdentificationBaseModel.a(paramInt, paramQQIdentiferActivity.getIntent(), paramQQIdentiferActivity);
    this.a = paramInt;
  }
  
  private void a(Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  public static void j()
  {
    QLog.d("qq_Identification.Helper", 1, "start preResDownload");
    if ((!FaceConfigManager.b()) || (FaceConfigManager.c()))
    {
      FaceSharedPreUtils.a("");
      FaceSharedPreUtils.a(0);
      FaceSharedPreUtils.b(0);
      QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_res_download", null, null);
    }
  }
  
  private boolean l()
  {
    QQIdentiferActivity localQQIdentiferActivity = this.d;
    return (localQQIdentiferActivity == null) || (localQQIdentiferActivity.isFinishing());
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().post(new IdentificationActivityHelper.1(this));
  }
  
  public void a(EIPCResultCallback paramEIPCResultCallback)
  {
    QLog.d("qq_Identification.Helper", 1, "start dowloadRes");
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_res_download", null, paramEIPCResultCallback);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    a(new IdentificationActivityHelper.3(this, paramBoolean, paramInt));
  }
  
  protected void b()
  {
    QLog.d("qq_Identification.Helper", 1, "start init res");
    if (c())
    {
      QLog.d("qq_Identification.Helper", 1, new Object[] { "preCheck is pass, so version is ", Integer.valueOf(FaceSharedPreUtils.b()), " current bits is : ", Integer.valueOf(FaceConfigManager.f()) });
      e();
      return;
    }
    QLog.d("qq_Identification.Helper", 1, "local res is invalid");
    d();
  }
  
  protected boolean c()
  {
    return (!FaceConfigManager.c()) && (FaceConfigManager.b());
  }
  
  protected void d()
  {
    FaceSharedPreUtils.a("");
    FaceSharedPreUtils.a(0);
    FaceSharedPreUtils.b(0);
    a(this);
  }
  
  public void e()
  {
    if (l())
    {
      QLog.e("qq_Identification.Helper", 1, "initYoutuSdk, activity invalid");
      return;
    }
    b = g();
    QLog.d("qq_Identification.Helper", 1, new Object[] { "start init youtu sdk, mIsLoadSo is ", Boolean.valueOf(b) });
    if (!b)
    {
      a(false, 207);
      return;
    }
    int i = i();
    QLog.d("qq_Identification.Helper", 1, new Object[] { "yt init result is : ", Integer.valueOf(i) });
    if (i != 0)
    {
      a(false, 207);
      return;
    }
    i = h();
    QLog.d("qq_Identification.Helper", 1, new Object[] { "initFaceResMode result is ", Integer.valueOf(i) });
    if (i != 0)
    {
      a(false, 207);
      return;
    }
    f();
  }
  
  protected void f()
  {
    this.c.set(true);
    this.e.a(true, this.d);
    YtLogger.setLoggerListener(new IdentificationActivityHelper.2(this));
    a(true, 0);
  }
  
  protected boolean g()
  {
    if (b) {
      return true;
    }
    boolean bool = this.e.a(IdentificationBaseModel.d);
    String str = FaceConfigManager.a(this.d);
    IdentificationBaseModel localIdentificationBaseModel = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("identification/so/");
    return bool & localIdentificationBaseModel.a(localStringBuilder.toString(), IdentificationBaseModel.c);
  }
  
  protected int h()
  {
    String str = FaceConfigManager.a(this.d);
    return this.e.a(this.d, str);
  }
  
  protected int i()
  {
    return YTCommonInterface.initAuthForQQ(this.d);
  }
  
  public void k()
  {
    this.c.set(false);
    this.e.a();
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = paramEIPCResult.isSuccess();
    QLog.e("qq_Identification.Helper", 1, new Object[] { "download result is : ", Boolean.valueOf(bool) });
    if (!bool)
    {
      a(false, 214);
      return;
    }
    bool = FaceConfigManager.b();
    QLog.d("qq_Identification.Helper", 1, new Object[] { "checkLocalResValid : ", Boolean.valueOf(bool) });
    if (!bool)
    {
      a(false, 215);
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationActivityHelper
 * JD-Core Version:    0.7.0.1
 */