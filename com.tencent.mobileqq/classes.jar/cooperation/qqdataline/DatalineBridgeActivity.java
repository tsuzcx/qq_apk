package cooperation.qqdataline;

import android.content.Intent;
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
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;

public class DatalineBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private MqqWeakReferenceHandler a;
  private IPluginManager b;
  private QQProgressDialog c;
  private long d;
  private String e;
  private Bundle f;
  
  private void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[DatalineBridgeActivity] handleFailed errCode:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("DatalineBridgeActivity", 1, ((StringBuilder)localObject).toString());
    int i = getResources().getDimensionPixelSize(2131299920);
    localObject = HardCodeUtil.a(2131900891);
    if (-4 == paramInt) {
      localObject = HardCodeUtil.a(2131900909);
    } else if ((-5 != paramInt) && (-1 != paramInt) && (-3 != paramInt) && (-2 != paramInt))
    {
      if (-6 == paramInt) {
        localObject = HardCodeUtil.a(2131900907);
      }
    }
    else {
      localObject = HardCodeUtil.a(2131900904);
    }
    QQToast.makeText(this.app.getApp(), 1, (CharSequence)localObject, 0).show(i);
    finish();
  }
  
  private void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo!");
    }
    int i = 0;
    if (System.currentTimeMillis() - this.d > 30000L) {
      i = 1;
    }
    if (paramPluginBaseInfo == null)
    {
      if (!this.b.isReady())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo is no ready and query it");
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
      paramString.append("[DatalineBridgeActivity] queryPluginInfo mState : ");
      paramString.append(paramPluginBaseInfo.mState);
      paramString.append(" progress:");
      paramString.append(paramPluginBaseInfo.mDownloadProgress);
      QLog.d("DatalineBridgeActivity", 4, paramString.toString());
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!NetworkUtil.isNetworkAvailable(getApplicationContext())) && (System.currentTimeMillis() - this.d > 5000L))
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
      this.b.e("qqdataline.apk");
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
    QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] launchPlugin->");
    Intent localIntent = new Intent();
    boolean bool1 = this.f.getBoolean("string_from", false);
    boolean bool2 = this.f.getBoolean("string_uin", false);
    long l = this.f.getLong("device_din", 0L);
    int i = this.f.getInt("sTitleID", 0);
    if (bool1) {
      localIntent.addFlags(536870912);
    }
    localIntent.putExtra("string_uin", bool2);
    localIntent.putExtra("device_din", l);
    localIntent.putExtra("sTitleID", i);
    if (this.app == null) {
      return;
    }
    Object localObject1 = this.app.getAccount();
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
    if (DatalinePluginProxyActivity.a(this))
    {
      DatalinePluginProxyActivity.a(this, (String)localObject2, localIntent, this.e, -1, null);
      finish();
      overridePendingTransition(0, 0);
      return;
    }
    localIntent.putExtra("userQqResources", 2);
    DatalinePluginProxyActivity.a(this, (String)localObject2, localIntent, this.e, -1, this.c);
    overridePendingTransition(0, 0);
  }
  
  private boolean c()
  {
    if (DatalinePluginProxyActivity.a(this))
    {
      if (this.app == null) {
        return false;
      }
      this.b = ((IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN));
      Object localObject1 = this.b;
      if (localObject1 == null)
      {
        a(-6);
        return false;
      }
      localObject1 = ((IPluginManager)localObject1).d("qqdataline.apk");
      if ((localObject1 != null) && (((PluginBaseInfo)localObject1).mState != 4)) {
        return false;
      }
      QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] launchPlugin");
      Intent localIntent = new Intent();
      boolean bool1 = this.f.getBoolean("string_from", false);
      boolean bool2 = this.f.getBoolean("string_uin", false);
      long l = this.f.getLong("device_din", 0L);
      int i = this.f.getInt("sTitleID", 0);
      if (bool1) {
        localIntent.addFlags(536870912);
      }
      localIntent.putExtra("string_uin", bool2);
      localIntent.putExtra("device_din", l);
      localIntent.putExtra("sTitleID", i);
      localIntent.putExtra("userQqResources", 2);
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
      DatalinePluginProxyActivity.a(this, (String)localObject2, localIntent, this.e, -1, null);
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
    QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] onPluginManagerLoaded SUPPORT_NETWORKING:true");
    if (this.b == null)
    {
      a(-6);
      return;
    }
    this.d = System.currentTimeMillis();
    Object localObject = this.b.d("qqdataline.apk");
    if (localObject != null)
    {
      if (((PluginBaseInfo)localObject).mState == 4)
      {
        b();
      }
      else
      {
        QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] onPluginManagerLoaded start down or install...");
        this.b.e("qqdataline.apk");
      }
    }
    else {
      i = 0;
    }
    if (i == 0)
    {
      localObject = this.c;
      if (localObject != null)
      {
        ((QQProgressDialog)localObject).a(HardCodeUtil.a(2131900903));
        this.c.show();
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
    super.doOnCreate(paramBundle);
    this.f = getIntent().getBundleExtra("_param_");
    this.e = getIntent().getStringExtra("componetname");
    this.a = new MqqWeakReferenceHandler(this);
    if (c()) {
      return true;
    }
    this.c = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299920));
    this.c.a(HardCodeUtil.a(2131900905));
    this.c.setOnDismissListener(new DatalineBridgeActivity.1(this));
    this.a.postDelayed(new DatalineBridgeActivity.2(this), 300L);
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity]  ACTION_QUERY!");
      }
      if (!isFinishing()) {
        a("qqdataline.apk", this.b.d("qqdataline.apk"));
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
    Object localObject = this.c;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).dismiss();
      this.c = null;
    }
    localObject = this.a;
    if (localObject != null) {
      ((MqqWeakReferenceHandler)localObject).removeMessages(1001);
    }
    localObject = this.b;
    if (QLog.isDevelopLevel()) {
      QLog.d("QPlugin", 4, "DatalineBridgeActivity onDestroy");
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqdataline.DatalineBridgeActivity
 * JD-Core Version:    0.7.0.1
 */