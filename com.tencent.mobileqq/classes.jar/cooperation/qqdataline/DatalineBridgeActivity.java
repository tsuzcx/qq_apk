package cooperation.qqdataline;

import alud;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import bdgc;
import bdin;
import bety;
import bhsl;
import biqn;
import biug;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

public class DatalineBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private bety jdField_a_of_type_Bety;
  private bhsl jdField_a_of_type_Bhsl;
  private biqn jdField_a_of_type_Biqn;
  private String jdField_a_of_type_JavaLangString;
  
  private void a(int paramInt)
  {
    QLog.e("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] handleFailed errCode:" + paramInt);
    int i = getResources().getDimensionPixelSize(2131298914);
    String str = alud.a(2131703134);
    if (-4 == paramInt) {
      str = alud.a(2131703152);
    }
    for (;;)
    {
      QQToast.a(this.app.getApp(), 1, str, 0).b(i);
      finish();
      return;
      if ((-5 == paramInt) || (-1 == paramInt) || (-3 == paramInt) || (-2 == paramInt)) {
        str = alud.a(2131703147);
      } else if (-6 == paramInt) {
        str = alud.a(2131703150);
      }
    }
  }
  
  private void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo!");
    }
    int i = 0;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 30000L) {
      i = 1;
    }
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_Biqn.isReady())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo is no ready and query it");
        }
        if (i != 0)
        {
          a(-5);
          return;
        }
        this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1001, 400L);
        return;
      }
      a(-1);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo mState : " + paramPluginBaseInfo.mState + " progress:" + paramPluginBaseInfo.mDownloadProgress);
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!bdin.g(getApplicationContext())) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 5000L))
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
      this.jdField_a_of_type_Biqn.a("qqdataline.apk");
    case 1: 
    case 2: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 4: 
      b();
      return;
    }
    a(-2);
  }
  
  private boolean a()
  {
    if (DatalinePluginProxyActivity.a(this))
    {
      if (this.app == null) {
        return false;
      }
      this.jdField_a_of_type_Biqn = ((biqn)this.app.getManager(27));
      if (this.jdField_a_of_type_Biqn == null)
      {
        a(-6);
        return false;
      }
      Object localObject1 = this.jdField_a_of_type_Biqn.a("qqdataline.apk");
      if ((localObject1 != null) && (((PluginBaseInfo)localObject1).mState != 4)) {
        return false;
      }
      QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] launchPlugin");
      Intent localIntent = new Intent();
      boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("string_from", false);
      boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("string_uin", false);
      long l = this.jdField_a_of_type_AndroidOsBundle.getLong("device_din", 0L);
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("sTitleID", 0);
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
        localObject2 = bdgc.a(this.app, this.app.getAccount());
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          localException.printStackTrace();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.app.getAccount();
      }
      DatalinePluginProxyActivity.a(this, (String)localObject2, localIntent, this.jdField_a_of_type_JavaLangString, -1, null);
      finish();
      overridePendingTransition(0, 0);
      return true;
    }
    return false;
  }
  
  private void b()
  {
    QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] launchPlugin->");
    Intent localIntent = new Intent();
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("string_from", false);
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("string_uin", false);
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("device_din", 0L);
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("sTitleID", 0);
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
      localObject2 = bdgc.a(this.app, this.app.getAccount());
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
      }
      localIntent.putExtra("userQqResources", 2);
      DatalinePluginProxyActivity.a(this, localException, localIntent, this.jdField_a_of_type_JavaLangString, -1, this.jdField_a_of_type_Bety);
      overridePendingTransition(0, 0);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.app.getAccount();
    }
    if (DatalinePluginProxyActivity.a(this))
    {
      DatalinePluginProxyActivity.a(this, (String)localObject2, localIntent, this.jdField_a_of_type_JavaLangString, -1, null);
      finish();
      overridePendingTransition(0, 0);
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Biqn = ((biqn)this.app.getManager(27));
    QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] onPluginManagerLoaded SUPPORT_NETWORKING:true");
    if (this.jdField_a_of_type_Biqn == null) {
      a(-6);
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      PluginInfo localPluginInfo = this.jdField_a_of_type_Biqn.a("qqdataline.apk");
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
        if (this.jdField_a_of_type_Bety != null)
        {
          this.jdField_a_of_type_Bety.a(alud.a(2131703146));
          this.jdField_a_of_type_Bety.show();
        }
        this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1001, 400L);
        return;
        label122:
        QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] onPluginManagerLoaded start down or install...");
        this.jdField_a_of_type_Biqn.a("qqdataline.apk");
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getBundleExtra("_param_");
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("componetname");
    this.jdField_a_of_type_Bhsl = new bhsl(this);
    if (a()) {
      return true;
    }
    this.jdField_a_of_type_Bety = new bety(this, getResources().getDimensionPixelSize(2131298914));
    this.jdField_a_of_type_Bety.a(alud.a(2131703148));
    this.jdField_a_of_type_Bety.setOnDismissListener(new biug(this));
    this.jdField_a_of_type_Bhsl.postDelayed(new DatalineBridgeActivity.2(this), 300L);
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
        QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity]  ACTION_QUERY!");
      }
      if (!isFinishing()) {
        a("qqdataline.apk", this.jdField_a_of_type_Biqn.a("qqdataline.apk"));
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bety != null)
    {
      this.jdField_a_of_type_Bety.dismiss();
      this.jdField_a_of_type_Bety = null;
    }
    if (this.jdField_a_of_type_Bhsl != null) {
      this.jdField_a_of_type_Bhsl.removeMessages(1001);
    }
    if ((this.jdField_a_of_type_Biqn == null) || (QLog.isDevelopLevel())) {
      QLog.d("QPlugin", 4, "DatalineBridgeActivity onDestroy");
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqdataline.DatalineBridgeActivity
 * JD-Core Version:    0.7.0.1
 */