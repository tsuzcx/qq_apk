package cooperation.qlink;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;

public class QlinkBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private MqqWeakReferenceHandler a;
  private IPluginManager b;
  private int c;
  private Bundle d;
  private QQProgressDialog e;
  private long f;
  
  private void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[QlinkBridgeActivity] handleFailed errCode:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("QlinkBridgeActivity", 1, ((StringBuilder)localObject).toString());
    int i = getResources().getDimensionPixelSize(2131299920);
    localObject = HardCodeUtil.a(2131907552);
    if (-4 == paramInt) {
      localObject = HardCodeUtil.a(2131907553);
    } else if ((-5 != paramInt) && (-1 != paramInt) && (-3 != paramInt) && (-2 != paramInt))
    {
      if (-6 == paramInt) {
        localObject = HardCodeUtil.a(2131907556);
      }
    }
    else {
      localObject = HardCodeUtil.a(2131907554);
    }
    QQToast.makeText(this.app.getApp(), 1, (CharSequence)localObject, 0).show(i);
    finish();
  }
  
  private void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity] queryPluginInfo!");
    }
    int i = 0;
    if (System.currentTimeMillis() - this.f > 30000L) {
      i = 1;
    }
    if (paramPluginBaseInfo == null)
    {
      if (!this.b.isReady())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity] queryPluginInfo is no ready and query it");
        }
        if (i != 0)
        {
          a(-5);
          return;
        }
        this.a.sendEmptyMessageDelayed(1001, 400L);
        return;
      }
      a(-1);
      return;
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[QlinkBridgeActivity] queryPluginInfo mState : ");
      paramString.append(paramPluginBaseInfo.mState);
      paramString.append(" progress:");
      paramString.append(paramPluginBaseInfo.mDownloadProgress);
      QLog.d("QlinkBridgeActivity", 4, paramString.toString());
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!NetworkUtil.isNetworkAvailable(getApplicationContext())) && (System.currentTimeMillis() - this.f > 5000L))
    {
      a(-4);
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    default: 
      a(-3);
      return;
    case 4: 
      b();
      return;
    case 3: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.a.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 0: 
      this.b.e("qlink_plugin.apk");
    case 1: 
    case 2: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.a.sendEmptyMessageDelayed(1001, 400L);
      return;
    case -1: 
      a(-6);
      return;
    }
    a(-2);
  }
  
  private void b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[QlinkBridgeActivity] launchPlugin mFrom:");
    ((StringBuilder)localObject1).append(this.c);
    QLog.i("QlinkBridgeActivity", 1, ((StringBuilder)localObject1).toString());
    Intent localIntent = QlinkHelper.a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("string_from", this.c);
    localObject1 = this.d;
    if (localObject1 != null) {
      localBundle.putAll((Bundle)localObject1);
    }
    if (this.app == null) {
      return;
    }
    localObject1 = this.app.getAccount();
    try
    {
      String str = ContactUtils.a(this.app, this.app.getAccount());
      localObject1 = str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.app.getAccount();
    }
    localBundle.putString("_SELF_NICK_", (String)localObject2);
    localIntent.putExtra("string_bundle", localBundle);
    if (QlinkPluginProxyActivity.b(this))
    {
      QlinkPluginProxyActivity.a(this, this.app.getAccount(), localIntent, 0, null);
      finish();
      overridePendingTransition(0, 0);
      return;
    }
    QlinkPluginProxyActivity.a(this, this.app.getAccount(), localIntent, 0, this.e);
    overridePendingTransition(0, 0);
  }
  
  private boolean c()
  {
    if (QlinkPluginProxyActivity.b(this))
    {
      Intent localIntent = QlinkHelper.a();
      Bundle localBundle1 = new Bundle();
      localBundle1.putInt("string_from", this.c);
      Bundle localBundle2 = this.d;
      if (localBundle2 != null) {
        localBundle1.putAll(localBundle2);
      }
      localIntent.putExtra("string_bundle", localBundle1);
      localBundle1.putString("_SELF_NICK_", ContactUtils.c(this.app, this.app.getAccount()));
      QlinkPluginProxyActivity.a(this, this.app.getAccount(), localIntent, 0, null);
      finish();
      overridePendingTransition(0, 0);
      return true;
    }
    return false;
  }
  
  public void a()
  {
    this.b = ((IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN));
    int i = 1;
    QLog.i("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] onPluginManagerLoaded SUPPORT_NETWORKING:true");
    if (this.b == null)
    {
      a(-6);
      return;
    }
    this.f = System.currentTimeMillis();
    Object localObject = this.b.d("qlink_plugin.apk");
    if (localObject != null)
    {
      if (((PluginBaseInfo)localObject).mState == 4)
      {
        b();
      }
      else
      {
        QLog.i("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] onPluginManagerLoaded start down or install...");
        this.b.e("qlink_plugin.apk");
      }
    }
    else {
      i = 0;
    }
    if (i == 0)
    {
      localObject = this.e;
      if (localObject != null)
      {
        ((QQProgressDialog)localObject).a(HardCodeUtil.a(2131907555));
        this.e.show();
      }
      this.a.sendEmptyMessageDelayed(1001, 400L);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    try
    {
      super.doOnCreate(paramBundle);
      this.c = getIntent().getIntExtra("_from_", 0);
      this.d = getIntent().getBundleExtra("_param_");
      this.a = new MqqWeakReferenceHandler(this);
      if (BaseApplication.getContext().getSharedPreferences("QlinkResistTerrorist", 0).getInt("QlinkResistTerrorist_res", 0) == 1)
      {
        FileManagerReporter.a("0X8005392");
        if (QLog.isColorLevel()) {
          QLog.e("QlinkBridgeActivity", 2, "[QLINK] QQ - startQlink failed because of QlinkResistTerrorist_res is 1!!!");
        }
        paramBundle = new QlinkBridgeActivity.1(this);
        DialogUtil.a(this, 233, getString(2131896322), getString(2131896347), 2131896321, 2131896321, paramBundle, null).show();
        return false;
      }
      if (c()) {
        return true;
      }
      this.e = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299920));
      this.e.a(HardCodeUtil.a(2131907551));
      this.e.setOnDismissListener(new QlinkBridgeActivity.2(this));
      this.a.postDelayed(new QlinkBridgeActivity.3(this), 300L);
      return true;
    }
    catch (Exception paramBundle)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("oncreate excption:");
      localStringBuilder.append(paramBundle.toString());
      QLog.e("QlinkBridgeActivity", 1, localStringBuilder.toString());
      finish();
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity]  ACTION_QUERY!");
      }
      if (!isFinishing()) {
        a("qlink_plugin.apk", this.b.d("qlink_plugin.apk"));
      }
    }
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.e;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).dismiss();
      this.e = null;
    }
    localObject = this.a;
    if (localObject != null) {
      ((MqqWeakReferenceHandler)localObject).removeMessages(1001);
    }
    localObject = this.b;
    if (QLog.isDevelopLevel()) {
      QLog.d("QPlugin", 4, "QlinkBridgeActivity onDestroy");
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QlinkBridgeActivity
 * JD-Core Version:    0.7.0.1
 */