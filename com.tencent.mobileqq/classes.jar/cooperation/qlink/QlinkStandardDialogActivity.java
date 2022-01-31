package cooperation.qlink;

import alpo;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import bdbt;
import bdcd;
import bdfq;
import bioj;
import bipp;
import bipq;
import bipr;
import bips;
import bipt;
import bipu;
import bipv;
import bipw;
import bipx;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QlinkStandardDialogActivity
  extends BaseActivity
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  final DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new bipq(this);
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  private void a()
  {
    Object localObject = new bipr(this);
    localObject = bdcd.a(this, 230, getString(2131698677), getString(2131698663), 2131698670, 2131698670, (DialogInterface.OnClickListener)localObject, null);
    ((bdfq)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((bdfq)localObject).show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = bdcd.a(this, 230, getString(2131698656), alpo.a(2131710407) + paramString2 + alpo.a(2131710405), 2131698669, 2131698655, new bipw(this, paramString1, paramString2), new bipx(this));
    paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    paramString1.show();
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    bipu localbipu = new bipu(this);
    bipv localbipv = new bipv(this);
    String str = paramString2;
    if (paramString1 != null)
    {
      str = paramString2;
      if (paramString1.equalsIgnoreCase(paramString2)) {
        str = bdbt.j(this.app, paramString1);
      }
    }
    if (paramBoolean) {}
    for (paramString1 = getString(2131698706) + str + getString(2131698707) + paramInt + getString(2131698708) + paramString3 + getString(2131698709) + paramString4 + "。";; paramString1 = getString(2131698697) + str + getString(2131698698) + paramInt + getString(2131698699) + paramString3 + getString(2131698700) + paramString4 + "。")
    {
      paramString1 = bdcd.a(this, 230, getString(2131698677), paramString1, 2131698724, 2131698725, localbipv, localbipu);
      paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString1.show();
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    bips localbips = new bips(this);
    bipt localbipt = new bipt(this, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {}
    for (int i = 2131698672;; i = 2131698671)
    {
      paramString = bdcd.a(this, 230, getString(2131698677), paramString, 2131698669, i, localbipt, localbips);
      paramString.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString.show();
      return;
    }
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
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bipp(this);
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
    this.app.a().g();
    return;
    a(getIntent().getBooleanExtra("param_send", false), getIntent().getStringExtra("param_uin"), getIntent().getStringExtra("param_nick"), getIntent().getIntExtra("param_transcount", 0), getIntent().getStringExtra("param_jsliuliang"), getIntent().getStringExtra("param_pjspeed"));
    this.app.a().g();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity
 * JD-Core Version:    0.7.0.1
 */