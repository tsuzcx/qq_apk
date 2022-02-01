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
  private static int a = 100;
  private static int b = 110;
  private static int c = 120;
  private static int d = 121;
  private static int e = 122;
  private static int f = 177;
  private static int g = 200;
  private static int h = 220;
  private static int i = 232;
  private static byte[] k = new byte[0];
  private static X5UpdateGuard l;
  private Handler j = new Handler(Looper.getMainLooper());
  private IMiniAppContext m;
  private X5UpdateGuard.LoadingDialog n;
  private X5UpdateGuard.PermissionDialog o;
  private Runnable p = new X5UpdateGuard.1(this);
  
  public static X5UpdateGuard a()
  {
    if (l == null) {
      synchronized (k)
      {
        if (l == null) {
          l = new X5UpdateGuard();
        }
      }
    }
    return l;
  }
  
  private void e()
  {
    try
    {
      QLog.d("minisdk_X5UpdateGuard", 1, "Tbs onX5Failed");
      if ((this.n != null) && (this.n.isShowing())) {
        this.n.dismiss();
      }
      QQToast.makeText(this.m.getAttachedActivity(), HardCodeUtil.a(2131903844), 0).show();
      this.m = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("minisdk_X5UpdateGuard", 1, "", localThrowable);
    }
  }
  
  private void f()
  {
    try
    {
      QLog.d("minisdk_X5UpdateGuard", 1, "Tbs onX5Succeed");
      if ((this.n != null) && (this.n.isShowing())) {
        this.n.dismiss();
      }
      if (this.o == null)
      {
        this.o = new X5UpdateGuard.PermissionDialog(this.m.getAttachedActivity(), 2131953338);
        this.o.setTitle(HardCodeUtil.a(2131903842));
        this.o.setMessage(HardCodeUtil.a(2131903841));
        this.o.setNegativeButton(HardCodeUtil.a(2131898212), new X5UpdateGuard.7(this));
        this.o.setPositiveButton(HardCodeUtil.a(2131899883), new X5UpdateGuard.8(this));
        this.o.setCanceledOnTouchOutside(false);
      }
      if (!this.o.isShowing()) {
        this.o.show();
      }
      this.m = null;
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
    int i1 = QbSdk.getTbsVersion(paramIMiniAppContext.getContext());
    int i2 = QbSdk.getTmpDirTbsVersion(paramIMiniAppContext.getContext());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTbsVersion=");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(" tmpDirTbsVersion=");
    ((StringBuilder)localObject).append(i2);
    QLog.d("minisdk_X5UpdateGuard", 1, ((StringBuilder)localObject).toString());
    if (i1 <= 0)
    {
      if (i2 > 0) {
        return;
      }
      if (paramIMiniAppContext.getAttachedActivity() == null) {
        return;
      }
      this.m = paramIMiniAppContext;
      localObject = new X5UpdateGuard.PermissionDialog(paramIMiniAppContext.getAttachedActivity(), 2131953338);
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
    this.j.removeCallbacks(this.p);
    AppBrandTask.runTaskOnUiThread(new X5UpdateGuard.4(this, paramInt));
  }
  
  public void onDownloadProgress(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tbs install onDownloadProgress=");
    localStringBuilder.append(paramInt);
    QLog.d("minisdk_X5UpdateGuard", 1, localStringBuilder.toString());
    this.j.removeCallbacks(this.p);
    AppBrandTask.runTaskOnUiThread(new X5UpdateGuard.6(this, paramInt));
  }
  
  public void onInstallFinish(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tbs onInstallFinish result=");
    localStringBuilder.append(paramInt);
    QLog.d("minisdk_X5UpdateGuard", 1, localStringBuilder.toString());
    this.j.removeCallbacks(this.p);
    AppBrandTask.runTaskOnUiThread(new X5UpdateGuard.5(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard
 * JD-Core Version:    0.7.0.1
 */