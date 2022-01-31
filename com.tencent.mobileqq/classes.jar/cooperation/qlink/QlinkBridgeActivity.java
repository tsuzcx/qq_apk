package cooperation.qlink;

import ajjy;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import apci;
import babh;
import babr;
import badq;
import bafb;
import bbms;
import bbmy;
import beez;
import bfcz;
import bffm;
import bffn;
import bffo;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

public class QlinkBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private bbms jdField_a_of_type_Bbms;
  private beez jdField_a_of_type_Beez;
  private bfcz jdField_a_of_type_Bfcz;
  
  private void a(int paramInt)
  {
    QLog.e("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] handleFailed errCode:" + paramInt);
    int i = getResources().getDimensionPixelSize(2131167766);
    String str = ajjy.a(2131644088);
    if (-4 == paramInt) {
      str = ajjy.a(2131644089);
    }
    for (;;)
    {
      bbmy.a(this.app.getApp(), 1, str, 0).b(i);
      finish();
      return;
      if ((-5 == paramInt) || (-1 == paramInt) || (-3 == paramInt) || (-2 == paramInt)) {
        str = ajjy.a(2131644090);
      } else if (-6 == paramInt) {
        str = ajjy.a(2131644092);
      }
    }
  }
  
  private void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity] queryPluginInfo!");
    }
    int i = 0;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 30000L) {
      i = 1;
    }
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_Bfcz.isReady())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity] queryPluginInfo is no ready and query it");
        }
        if (i != 0)
        {
          a(-5);
          return;
        }
        this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(1001, 400L);
        return;
      }
      a(-1);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity] queryPluginInfo mState : " + paramPluginBaseInfo.mState + " progress:" + paramPluginBaseInfo.mDownloadProgress);
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!badq.g(getApplicationContext())) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 5000L))
    {
      a(-4);
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    default: 
      a(-3);
      return;
    case -1: 
      a(-6);
      return;
    case 0: 
      this.jdField_a_of_type_Bfcz.a("qlink_plugin.apk");
    case 1: 
    case 2: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 4: 
      b();
      return;
    }
    a(-2);
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (QlinkPluginProxyActivity.a(this))
    {
      Intent localIntent = bffo.a();
      Bundle localBundle = new Bundle();
      localBundle.putInt("string_from", this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
      }
      localIntent.putExtra("string_bundle", localBundle);
      localBundle.putString("_SELF_NICK_", babh.i(this.app, this.app.getAccount()));
      QlinkPluginProxyActivity.a(this, this.app.getAccount(), localIntent, 0, null);
      finish();
      overridePendingTransition(0, 0);
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    QLog.i("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] launchPlugin mFrom:" + this.jdField_a_of_type_Int);
    Intent localIntent = bffo.a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("string_from", this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
    }
    if (this.app == null) {
      return;
    }
    Object localObject1 = this.app.getAccount();
    try
    {
      localObject2 = babh.a(this.app, this.app.getAccount());
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
      }
      QlinkPluginProxyActivity.a(this, this.app.getAccount(), localIntent, 0, this.jdField_a_of_type_Bbms);
      overridePendingTransition(0, 0);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.app.getAccount();
    }
    localBundle.putString("_SELF_NICK_", (String)localObject2);
    localIntent.putExtra("string_bundle", localBundle);
    if (QlinkPluginProxyActivity.a(this))
    {
      QlinkPluginProxyActivity.a(this, this.app.getAccount(), localIntent, 0, null);
      finish();
      overridePendingTransition(0, 0);
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bfcz = ((bfcz)this.app.getManager(27));
    QLog.i("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] onPluginManagerLoaded SUPPORT_NETWORKING:true");
    if (this.jdField_a_of_type_Bfcz == null) {
      a(-6);
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      PluginInfo localPluginInfo = this.jdField_a_of_type_Bfcz.a("qlink_plugin.apk");
      int j = 0;
      int i = j;
      if (localPluginInfo != null)
      {
        if (localPluginInfo.mState != 4) {
          break label122;
        }
        b();
      }
      for (i = 1; i == 0; i = j)
      {
        if (this.jdField_a_of_type_Bbms != null)
        {
          this.jdField_a_of_type_Bbms.a(ajjy.a(2131644091));
          this.jdField_a_of_type_Bbms.show();
        }
        this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(1001, 400L);
        return;
        label122:
        QLog.i("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] onPluginManagerLoaded start down or install...");
        this.jdField_a_of_type_Bfcz.a("qlink_plugin.apk");
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = true;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("_from_", 0);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getBundleExtra("_param_");
    this.jdField_a_of_type_Beez = new beez(this);
    if (BaseApplication.getContext().getSharedPreferences("QlinkResistTerrorist", 0).getInt("QlinkResistTerrorist_res", 0) == 1)
    {
      apci.a("0X8005392");
      if (QLog.isColorLevel()) {
        QLog.e("QlinkBridgeActivity", 2, "[QLINK] QQ - startQlink failed because of QlinkResistTerrorist_res is 1!!!");
      }
      paramBundle = new bffm(this);
      babr.a(this, 233, getString(2131632640), getString(2131632665), 2131632639, 2131632639, paramBundle, null).show();
      bool = false;
    }
    while (a()) {
      return bool;
    }
    this.jdField_a_of_type_Bbms = new bbms(this, getResources().getDimensionPixelSize(2131167766));
    this.jdField_a_of_type_Bbms.a(ajjy.a(2131644087));
    this.jdField_a_of_type_Bbms.setOnDismissListener(new bffn(this));
    this.jdField_a_of_type_Beez.postDelayed(new QlinkBridgeActivity.3(this), 300L);
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity]  ACTION_QUERY!");
      }
      if (!isFinishing()) {
        a("qlink_plugin.apk", this.jdField_a_of_type_Bfcz.a("qlink_plugin.apk"));
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bbms != null)
    {
      this.jdField_a_of_type_Bbms.dismiss();
      this.jdField_a_of_type_Bbms = null;
    }
    if (this.jdField_a_of_type_Beez != null) {
      this.jdField_a_of_type_Beez.removeMessages(1001);
    }
    if ((this.jdField_a_of_type_Bfcz == null) || (QLog.isDevelopLevel())) {
      QLog.d("QPlugin", 4, "QlinkBridgeActivity onDestroy");
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qlink.QlinkBridgeActivity
 * JD-Core Version:    0.7.0.1
 */