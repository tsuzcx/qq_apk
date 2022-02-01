package cooperation.qlink;

import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QlinkStandardDialogActivity
  extends BaseActivity
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  final DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new QlinkStandardDialogActivity.2(this);
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  private void a()
  {
    Object localObject = new QlinkStandardDialogActivity.3(this);
    localObject = DialogUtil.a(this, 230, getString(2131698334), getString(2131698323), 2131698327, 2131698327, (DialogInterface.OnClickListener)localObject, null);
    ((QQCustomDialog)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((QQCustomDialog)localObject).show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = DialogUtil.a(this, 230, getString(2131698314), HardCodeUtil.a(2131709999) + paramString2 + HardCodeUtil.a(2131709997), 2131698326, 2131698313, new QlinkStandardDialogActivity.8(this, paramString1, paramString2), new QlinkStandardDialogActivity.9(this));
    paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    paramString1.show();
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    QlinkStandardDialogActivity.6 local6 = new QlinkStandardDialogActivity.6(this);
    QlinkStandardDialogActivity.7 local7 = new QlinkStandardDialogActivity.7(this);
    String str = paramString2;
    if (paramString1 != null)
    {
      str = paramString2;
      if (paramString1.equalsIgnoreCase(paramString2)) {
        str = ContactUtils.j(this.app, paramString1);
      }
    }
    if (paramBoolean) {}
    for (paramString1 = getString(2131698363) + str + getString(2131698364) + paramInt + getString(2131698365) + paramString3 + getString(2131698366) + paramString4 + "。";; paramString1 = getString(2131698354) + str + getString(2131698355) + paramInt + getString(2131698356) + paramString3 + getString(2131698357) + paramString4 + "。")
    {
      paramString1 = DialogUtil.a(this, 230, getString(2131698334), paramString1, 2131698381, 2131698382, local7, local6);
      paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString1.show();
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    QlinkStandardDialogActivity.4 local4 = new QlinkStandardDialogActivity.4(this);
    QlinkStandardDialogActivity.5 local5 = new QlinkStandardDialogActivity.5(this, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {}
    for (int i = 2131698329;; i = 2131698328)
    {
      paramString = DialogUtil.a(this, 230, getString(2131698334), paramString, 2131698326, i, local5, local4);
      paramString.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString.show();
      return;
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
  
  public void doOnDestroy()
  {
    if ((this.app != null) && (this.app.getApp() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {
      this.app.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = SplashActivity.sTopActivity;
    super.onCreate(paramBundle);
    if (this.app == null)
    {
      QLog.e("QlinkStandardDialogActivity", 2, "onCreate: app=null");
      return;
    }
    setTitle(null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.qlink.finishdlg");
    if (this.app.getApp() != null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new QlinkStandardDialogActivity.1(this);
      this.app.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    for (;;)
    {
      switch (getIntent().getIntExtra("str_type", 0))
      {
      default: 
        finish();
        return;
        QLog.e("QlinkStandardDialogActivity", 2, "onCreate: app.getapp()=null");
      }
    }
    a(getIntent().getBooleanExtra("param_send", false), getIntent().getBooleanExtra("_INIT_SEND_IOS_", false), getIntent().getStringExtra("_DLG_CONTENT_"));
    this.app.getQQProxyForQlink().g();
    return;
    a(getIntent().getBooleanExtra("param_send", false), getIntent().getStringExtra("param_uin"), getIntent().getStringExtra("param_nick"), getIntent().getIntExtra("param_transcount", 0), getIntent().getStringExtra("param_jsliuliang"), getIntent().getStringExtra("param_pjspeed"));
    this.app.getQQProxyForQlink().g();
    return;
    a();
    return;
    paramBundle = getIntent().getStringExtra("_ADD_UIN_NICK_");
    a(getIntent().getStringExtra("_ADD_UIN_"), paramBundle);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity
 * JD-Core Version:    0.7.0.1
 */