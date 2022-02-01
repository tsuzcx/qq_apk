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
  public static boolean a = false;
  public int a;
  private QQIdentiferActivity jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity;
  private IdentificationBaseModel jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel;
  public AtomicBoolean a;
  
  @RequiresApi(api=18)
  public IdentificationActivityHelper(QQIdentiferActivity paramQQIdentiferActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity = paramQQIdentiferActivity;
    this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel = IdentificationBaseModel.a(paramInt, paramQQIdentiferActivity.getIntent(), paramQQIdentiferActivity);
    this.jdField_a_of_type_Int = paramInt;
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
  
  private boolean c()
  {
    QQIdentiferActivity localQQIdentiferActivity = this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity;
    return (localQQIdentiferActivity == null) || (localQQIdentiferActivity.isFinishing());
  }
  
  public static void f()
  {
    QLog.d("qq_Identification.Helper", 1, "start preResDownload");
    if ((!FaceConfigManager.a()) || (FaceConfigManager.b()))
    {
      FaceSharedPreUtils.a("");
      FaceSharedPreUtils.a(0);
      FaceSharedPreUtils.b(0);
      QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_res_download", null, null);
    }
  }
  
  protected int a()
  {
    String str = FaceConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity);
    return this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity, str);
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
  
  protected boolean a()
  {
    return (!FaceConfigManager.b()) && (FaceConfigManager.a());
  }
  
  protected int b()
  {
    return YTCommonInterface.initAuthForQQ(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity);
  }
  
  protected void b()
  {
    QLog.d("qq_Identification.Helper", 1, "start init res");
    if (a())
    {
      QLog.d("qq_Identification.Helper", 1, new Object[] { "preCheck is pass, so version is ", Integer.valueOf(FaceSharedPreUtils.a()), " current bits is : ", Integer.valueOf(FaceConfigManager.a()) });
      d();
      return;
    }
    QLog.d("qq_Identification.Helper", 1, "local res is invalid");
    c();
  }
  
  protected boolean b()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel.a(IdentificationBaseModel.b);
    String str = FaceConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity);
    IdentificationBaseModel localIdentificationBaseModel = this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("identification/so/");
    return bool & localIdentificationBaseModel.a(localStringBuilder.toString(), IdentificationBaseModel.a);
  }
  
  protected void c()
  {
    FaceSharedPreUtils.a("");
    FaceSharedPreUtils.a(0);
    FaceSharedPreUtils.b(0);
    a(this);
  }
  
  public void d()
  {
    if (c())
    {
      QLog.e("qq_Identification.Helper", 1, "initYoutuSdk, activity invalid");
      return;
    }
    jdField_a_of_type_Boolean = b();
    QLog.d("qq_Identification.Helper", 1, new Object[] { "start init youtu sdk, mIsLoadSo is ", Boolean.valueOf(jdField_a_of_type_Boolean) });
    if (!jdField_a_of_type_Boolean)
    {
      a(false, 207);
      return;
    }
    int i = b();
    QLog.d("qq_Identification.Helper", 1, new Object[] { "yt init result is : ", Integer.valueOf(i) });
    if (i != 0)
    {
      a(false, 207);
      return;
    }
    i = a();
    QLog.d("qq_Identification.Helper", 1, new Object[] { "initFaceResMode result is ", Integer.valueOf(i) });
    if (i != 0)
    {
      a(false, 207);
      return;
    }
    e();
  }
  
  protected void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel.a(true, this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity);
    YtLogger.setLoggerListener(new IdentificationActivityHelper.2(this));
    a(true, 0);
  }
  
  public void g()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel.a();
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
    bool = FaceConfigManager.a();
    QLog.d("qq_Identification.Helper", 1, new Object[] { "checkLocalResValid : ", Boolean.valueOf(bool) });
    if (!bool)
    {
      a(false, 215);
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationActivityHelper
 * JD-Core Version:    0.7.0.1
 */