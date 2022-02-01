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
import cooperation.plugin.PluginInfo;

public class DatalineBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  private String jdField_a_of_type_JavaLangString;
  
  private void a(int paramInt)
  {
    QLog.e("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] handleFailed errCode:" + paramInt);
    int i = getResources().getDimensionPixelSize(2131299166);
    String str = HardCodeUtil.a(2131702782);
    if (-4 == paramInt) {
      str = HardCodeUtil.a(2131702800);
    }
    for (;;)
    {
      QQToast.a(this.app.getApp(), 1, str, 0).b(i);
      finish();
      return;
      if ((-5 == paramInt) || (-1 == paramInt) || (-3 == paramInt) || (-2 == paramInt)) {
        str = HardCodeUtil.a(2131702795);
      } else if (-6 == paramInt) {
        str = HardCodeUtil.a(2131702798);
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
      if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isReady())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo is no ready and query it");
        }
        if (i != 0)
        {
          a(-5);
          return;
        }
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
        return;
      }
      a(-1);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo mState : " + paramPluginBaseInfo.mState + " progress:" + paramPluginBaseInfo.mDownloadProgress);
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!NetworkUtil.g(getApplicationContext())) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 5000L))
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
      this.jdField_a_of_type_CooperationPluginIPluginManager.d("qqdataline.apk");
    case 1: 
    case 2: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
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
      this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN));
      if (this.jdField_a_of_type_CooperationPluginIPluginManager == null)
      {
        a(-6);
        return false;
      }
      Object localObject1 = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqdataline.apk");
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
        localObject2 = ContactUtils.a(this.app, this.app.getAccount());
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
      localObject2 = ContactUtils.a(this.app, this.app.getAccount());
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
      DatalinePluginProxyActivity.a(this, localException, localIntent, this.jdField_a_of_type_JavaLangString, -1, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
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
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN));
    QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] onPluginManagerLoaded SUPPORT_NETWORKING:true");
    if (this.jdField_a_of_type_CooperationPluginIPluginManager == null) {
      a(-6);
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqdataline.apk");
      int j = 0;
      int i = j;
      if (localPluginInfo != null)
      {
        if (localPluginInfo.mState != 4) {
          break label124;
        }
        b();
      }
      for (i = 1; i == 0; i = j)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131702794));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
        return;
        label124:
        QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] onPluginManagerLoaded start down or install...");
        this.jdField_a_of_type_CooperationPluginIPluginManager.d("qqdataline.apk");
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getBundleExtra("_param_");
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("componetname");
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    if (a()) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299166));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131702796));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new DatalineBridgeActivity.1(this));
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new DatalineBridgeActivity.2(this), 300L);
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
        a("qqdataline.apk", this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqdataline.apk"));
      }
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1001);
    }
    if ((this.jdField_a_of_type_CooperationPluginIPluginManager == null) || (QLog.isDevelopLevel())) {
      QLog.d("QPlugin", 4, "DatalineBridgeActivity onDestroy");
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqdataline.DatalineBridgeActivity
 * JD-Core Version:    0.7.0.1
 */