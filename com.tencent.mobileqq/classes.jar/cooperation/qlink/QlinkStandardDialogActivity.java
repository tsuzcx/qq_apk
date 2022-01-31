package cooperation.qlink;

import alud;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import bdgc;
import bdgm;
import bdjz;
import bisq;
import bitw;
import bitx;
import bity;
import bitz;
import biua;
import biub;
import biuc;
import biud;
import biue;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QlinkStandardDialogActivity
  extends BaseActivity
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  final DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new bitx(this);
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  private void a()
  {
    Object localObject = new bity(this);
    localObject = bdgm.a(this, 230, getString(2131698689), getString(2131698675), 2131698682, 2131698682, (DialogInterface.OnClickListener)localObject, null);
    ((bdjz)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((bdjz)localObject).show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = bdgm.a(this, 230, getString(2131698668), alud.a(2131710419) + paramString2 + alud.a(2131710417), 2131698681, 2131698667, new biud(this, paramString1, paramString2), new biue(this));
    paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    paramString1.show();
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    biub localbiub = new biub(this);
    biuc localbiuc = new biuc(this);
    String str = paramString2;
    if (paramString1 != null)
    {
      str = paramString2;
      if (paramString1.equalsIgnoreCase(paramString2)) {
        str = bdgc.j(this.app, paramString1);
      }
    }
    if (paramBoolean) {}
    for (paramString1 = getString(2131698718) + str + getString(2131698719) + paramInt + getString(2131698720) + paramString3 + getString(2131698721) + paramString4 + "。";; paramString1 = getString(2131698709) + str + getString(2131698710) + paramInt + getString(2131698711) + paramString3 + getString(2131698712) + paramString4 + "。")
    {
      paramString1 = bdgm.a(this, 230, getString(2131698689), paramString1, 2131698736, 2131698737, localbiuc, localbiub);
      paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString1.show();
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    bitz localbitz = new bitz(this);
    biua localbiua = new biua(this, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {}
    for (int i = 2131698684;; i = 2131698683)
    {
      paramString = bdgm.a(this, 230, getString(2131698689), paramString, 2131698681, i, localbiua, localbitz);
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
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bitw(this);
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