package com.tencent.qqmini.proxyimpl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

public class X5UpdateGuard
  implements TbsListener
{
  private static int jdField_a_of_type_Int = 100;
  private static X5UpdateGuard jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static int b = 110;
  private static int c = 120;
  private static int d = 121;
  private static int e = 122;
  private static int f = 177;
  private static int g = 200;
  private static int h = 220;
  private static int i = 232;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private X5UpdateGuard.LoadingDialog jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$LoadingDialog;
  private X5UpdateGuard.PermissionDialog jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$PermissionDialog;
  private IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  private Runnable jdField_a_of_type_JavaLangRunnable = new X5UpdateGuard.1(this);
  
  public static X5UpdateGuard a()
  {
    if (jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard == null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard == null) {
          jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard = new X5UpdateGuard();
        }
      }
    }
    return jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard;
  }
  
  private void a()
  {
    try
    {
      QLog.d("minisdk_X5UpdateGuard", 1, "Tbs onX5Failed");
      if ((this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$LoadingDialog != null) && (this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$LoadingDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$LoadingDialog.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getAttachedActivity(), HardCodeUtil.a(2131705966), 0).a();
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("minisdk_X5UpdateGuard", 1, "", localThrowable);
    }
  }
  
  private void b()
  {
    try
    {
      QLog.d("minisdk_X5UpdateGuard", 1, "Tbs onX5Succeed");
      if ((this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$LoadingDialog != null) && (this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$LoadingDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$LoadingDialog.dismiss();
      }
      if (this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$PermissionDialog == null)
      {
        this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$PermissionDialog = new X5UpdateGuard.PermissionDialog(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getAttachedActivity(), 2131756189);
        this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$PermissionDialog.setTitle(HardCodeUtil.a(2131705964));
        this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$PermissionDialog.setMessage(HardCodeUtil.a(2131705962));
        this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$PermissionDialog.setNegativeButton(HardCodeUtil.a(2131705960), new X5UpdateGuard.7(this));
        this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$PermissionDialog.setPositiveButton(HardCodeUtil.a(2131705963), new X5UpdateGuard.8(this));
        this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$PermissionDialog.setCanceledOnTouchOutside(false);
      }
      if (!this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$PermissionDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard$PermissionDialog.show();
      }
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("minisdk_X5UpdateGuard", 1, "", localThrowable);
    }
  }
  
  public void a(IMiniAppContext paramIMiniAppContext)
  {
    if (paramIMiniAppContext == null) {
      return;
    }
    int j = QbSdk.getTbsVersion(paramIMiniAppContext.getContext());
    int k = QbSdk.getTmpDirTbsVersion(paramIMiniAppContext.getContext());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTbsVersion=");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" tmpDirTbsVersion=");
    ((StringBuilder)localObject).append(k);
    QLog.d("minisdk_X5UpdateGuard", 1, ((StringBuilder)localObject).toString());
    if (j <= 0)
    {
      if (k > 0) {
        return;
      }
      if (paramIMiniAppContext.getAttachedActivity() == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
      localObject = new X5UpdateGuard.PermissionDialog(paramIMiniAppContext.getAttachedActivity(), 2131756189);
      ((X5UpdateGuard.PermissionDialog)localObject).setTitle("小程序运行异常");
      ((X5UpdateGuard.PermissionDialog)localObject).setMessage("升级浏览器组件之后可正常运行小程序，确定要升级么？");
      ((X5UpdateGuard.PermissionDialog)localObject).setNegativeButton("取消", new X5UpdateGuard.2(this));
      ((X5UpdateGuard.PermissionDialog)localObject).setPositiveButton("确定", new X5UpdateGuard.3(this, paramIMiniAppContext));
      ((X5UpdateGuard.PermissionDialog)localObject).setCanceledOnTouchOutside(true);
      ((X5UpdateGuard.PermissionDialog)localObject).show();
    }
  }
  
  public void onDownloadFinish(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tbs onDownloadFinish result=");
    localStringBuilder.append(paramInt);
    QLog.d("minisdk_X5UpdateGuard", 1, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    AppBrandTask.runTaskOnUiThread(new X5UpdateGuard.4(this, paramInt));
  }
  
  public void onDownloadProgress(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tbs install onDownloadProgress=");
    localStringBuilder.append(paramInt);
    QLog.d("minisdk_X5UpdateGuard", 1, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    AppBrandTask.runTaskOnUiThread(new X5UpdateGuard.6(this, paramInt));
  }
  
  public void onInstallFinish(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tbs onInstallFinish result=");
    localStringBuilder.append(paramInt);
    QLog.d("minisdk_X5UpdateGuard", 1, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    AppBrandTask.runTaskOnUiThread(new X5UpdateGuard.5(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard
 * JD-Core Version:    0.7.0.1
 */