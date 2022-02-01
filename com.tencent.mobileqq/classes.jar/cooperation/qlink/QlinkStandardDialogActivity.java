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
    localObject = DialogUtil.a(this, 230, getString(2131698399), getString(2131698388), 2131698392, 2131698392, (DialogInterface.OnClickListener)localObject, null);
    ((QQCustomDialog)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((QQCustomDialog)localObject).show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    String str = getString(2131698379);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131709986));
    localStringBuilder.append(paramString2);
    localStringBuilder.append(HardCodeUtil.a(2131709984));
    paramString1 = DialogUtil.a(this, 230, str, localStringBuilder.toString(), 2131698391, 2131698378, new QlinkStandardDialogActivity.8(this, paramString1, paramString2), new QlinkStandardDialogActivity.9(this));
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
        str = ContactUtils.d(this.app, paramString1);
      }
    }
    if (paramBoolean)
    {
      paramString1 = new StringBuilder();
      paramString1.append(getString(2131698428));
      paramString1.append(str);
      paramString1.append(getString(2131698429));
      paramString1.append(paramInt);
      paramString1.append(getString(2131698430));
      paramString1.append(paramString3);
      paramString1.append(getString(2131698431));
      paramString1.append(paramString4);
      paramString1.append("。");
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append(getString(2131698419));
      paramString1.append(str);
      paramString1.append(getString(2131698420));
      paramString1.append(paramInt);
      paramString1.append(getString(2131698421));
      paramString1.append(paramString3);
      paramString1.append(getString(2131698422));
      paramString1.append(paramString4);
      paramString1.append("。");
      paramString1 = paramString1.toString();
    }
    paramString1 = DialogUtil.a(this, 230, getString(2131698399), paramString1, 2131698446, 2131698447, local7, local6);
    paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    paramString1.show();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    QlinkStandardDialogActivity.4 local4 = new QlinkStandardDialogActivity.4(this);
    QlinkStandardDialogActivity.5 local5 = new QlinkStandardDialogActivity.5(this, paramBoolean1, paramBoolean2);
    int i;
    if (paramBoolean1) {
      i = 2131698394;
    } else {
      i = 2131698393;
    }
    paramString = DialogUtil.a(this, 230, getString(2131698399), paramString, 2131698391, i, local5, local4);
    paramString.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    paramString.show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnDestroy()
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
    else
    {
      QLog.e("QlinkStandardDialogActivity", 2, "onCreate: app.getapp()=null");
    }
    switch (getIntent().getIntExtra("str_type", 0))
    {
    default: 
      finish();
      return;
    case 10: 
      paramBundle = getIntent().getStringExtra("_ADD_UIN_NICK_");
      a(getIntent().getStringExtra("_ADD_UIN_"), paramBundle);
      return;
    case 9: 
      a();
      return;
    case 8: 
      a(getIntent().getBooleanExtra("param_send", false), getIntent().getStringExtra("param_uin"), getIntent().getStringExtra("param_nick"), getIntent().getIntExtra("param_transcount", 0), getIntent().getStringExtra("param_jsliuliang"), getIntent().getStringExtra("param_pjspeed"));
      this.app.getQQProxyForQlink().g();
      return;
    }
    a(getIntent().getBooleanExtra("param_send", false), getIntent().getBooleanExtra("_INIT_SEND_IOS_", false), getIntent().getStringExtra("_DLG_CONTENT_"));
    this.app.getQQProxyForQlink().g();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity
 * JD-Core Version:    0.7.0.1
 */