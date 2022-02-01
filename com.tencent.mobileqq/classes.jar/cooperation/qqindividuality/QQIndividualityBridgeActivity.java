package cooperation.qqindividuality;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

public class QQIndividualityBridgeActivity
  extends QQIndividualityBaseBridgeActivity
{
  public static long d = 0L;
  public static int k = 0;
  public static int l = 1;
  public static int m = 2;
  public QQIndividualityBridgeActivity.QQProgressDialogEx c;
  boolean e = true;
  public QQIndividualityBridgeActivity.SignatureLoadingDialogEx f;
  String g = null;
  String h = null;
  int i;
  int j = -1;
  
  public void a()
  {
    if (this.b == null) {
      return;
    }
    PluginInfo localPluginInfo = this.b.d("qqindividuality_plugin.apk");
    if (localPluginInfo != null)
    {
      if (localPluginInfo.mState == 4)
      {
        b();
        return;
      }
      if ((localPluginInfo.mState != 1) && (localPluginInfo.mState != 3))
      {
        c();
        this.b.installPlugin("qqindividuality_plugin.apk", new QQIndividualityBridgeActivity.3(this));
        return;
      }
      c();
      this.a.sendEmptyMessageDelayed(1000, 200L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "initPlugin pluginInfo == null");
    }
    c();
    this.a.sendEmptyMessageDelayed(1000, 200L);
  }
  
  public void b()
  {
    Intent localIntent = getIntent();
    if (localIntent == null) {
      return;
    }
    int n;
    if (!QIPCServerHelper.getInstance().isModuleRunning("qqindividuality_plugin.apk"))
    {
      this.e = false;
      n = this.j;
      if (n == k)
      {
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, this.c, this.i);
        overridePendingTransition(2130772196, 0);
      }
      else if (n == l)
      {
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        localIntent.putExtra("is_first_open", true);
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, this.f, this.i);
        overridePendingTransition(2130772196, 0);
      }
      else if (n == m)
      {
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, this.f, this.i);
        overridePendingTransition(2130772196, 0);
      }
    }
    else
    {
      n = this.j;
      if (n == k)
      {
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, null, this.i);
      }
      else if (n == l)
      {
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, null, this.i);
      }
      else if (n == m)
      {
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, null, this.i);
        overridePendingTransition(2130772196, 0);
      }
    }
    if (-1 == this.i) {
      super.finish();
    }
  }
  
  public void c()
  {
    if (!isFinishing())
    {
      int n = this.j;
      if (n == k)
      {
        this.c.show();
        return;
      }
      if ((n == m) || (n == l)) {
        this.f.show();
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    paramInt1 = this.j;
    Object localObject;
    if (paramInt1 == k)
    {
      localObject = this.c;
      if (localObject != null)
      {
        if (((QQIndividualityBridgeActivity.QQProgressDialogEx)localObject).isShowing()) {
          this.c.dismiss();
        }
        this.c.setOnDismissListener(null);
        this.c = null;
      }
    }
    else if ((paramInt1 == l) || (paramInt1 == m))
    {
      localObject = this.f;
      if (localObject != null)
      {
        if (((QQIndividualityBridgeActivity.SignatureLoadingDialogEx)localObject).isShowing()) {
          this.f.dismiss();
        }
        this.f.setOnDismissListener(null);
        this.f = null;
      }
    }
    setResult(paramInt2, paramIntent);
    super.finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131168376);
    if (Math.abs(System.currentTimeMillis() - d) < 800L)
    {
      setResult(1001);
      super.finish();
      return true;
    }
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.j = paramBundle.getIntExtra("individuality_plugin", -1);
    }
    d = System.currentTimeMillis();
    this.g = getIntent().getStringExtra(QQIndividualityUtils.e);
    this.h = getIntent().getStringExtra(QQIndividualityUtils.f);
    if ((TextUtils.isEmpty(this.g)) || (TextUtils.isEmpty(this.h)))
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("path or name is null , return: ");
        paramBundle.append(this.g);
        paramBundle.append(" ");
        paramBundle.append(this.h);
        QLog.d("QQIndividuality", 2, paramBundle.toString());
      }
      setResult(1001);
      super.finish();
    }
    int n = super.getResources().getDimensionPixelSize(2131299920);
    this.i = getIntent().getIntExtra(QQIndividualityUtils.i, -1);
    int i1 = this.j;
    if ((i1 == l) || (i1 == m))
    {
      this.f = new QQIndividualityBridgeActivity.SignatureLoadingDialogEx(this, this);
      this.f.setCanceledOnTouchOutside(false);
      this.f.setOnDismissListener(new QQIndividualityBridgeActivity.1(this));
    }
    if (this.j == k)
    {
      this.c = new QQIndividualityBridgeActivity.QQProgressDialogEx(this, this, n);
      this.c.a(HardCodeUtil.a(2131908034));
      this.c.setCanceledOnTouchOutside(false);
      if (this.i != -1) {
        this.c.setOnDismissListener(new QQIndividualityBridgeActivity.2(this));
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((QQIndividualityBridgeActivity.QQProgressDialogEx)localObject).isShowing()) {
        this.c.dismiss();
      }
      this.c.setOnDismissListener(null);
      this.c = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      if (((QQIndividualityBridgeActivity.SignatureLoadingDialogEx)localObject).isShowing()) {
        this.f.dismiss();
      }
      this.f.setOnDismissListener(null);
      this.f = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "destroy.....");
    }
    sTopActivity = null;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity
 * JD-Core Version:    0.7.0.1
 */