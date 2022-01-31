package cooperation.qlink;

import ajya;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import bbcz;
import bbdj;
import bbgu;
import bgnk;
import bgoq;
import bgor;
import bgos;
import bgot;
import bgou;
import bgov;
import bgow;
import bgox;
import bgoy;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QlinkStandardDialogActivity
  extends BaseActivity
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  final DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new bgor(this);
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  private void a()
  {
    Object localObject = new bgos(this);
    localObject = bbdj.a(this, 230, getString(2131698387), getString(2131698373), 2131698380, 2131698380, (DialogInterface.OnClickListener)localObject, null);
    ((bbgu)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((bbgu)localObject).show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = bbdj.a(this, 230, getString(2131698366), ajya.a(2131710035) + paramString2 + ajya.a(2131710033), 2131698379, 2131698365, new bgox(this, paramString1, paramString2), new bgoy(this));
    paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    paramString1.show();
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    bgov localbgov = new bgov(this);
    bgow localbgow = new bgow(this);
    String str = paramString2;
    if (paramString1 != null)
    {
      str = paramString2;
      if (paramString1.equalsIgnoreCase(paramString2)) {
        str = bbcz.j(this.app, paramString1);
      }
    }
    if (paramBoolean) {}
    for (paramString1 = getString(2131698416) + str + getString(2131698417) + paramInt + getString(2131698418) + paramString3 + getString(2131698419) + paramString4 + "。";; paramString1 = getString(2131698407) + str + getString(2131698408) + paramInt + getString(2131698409) + paramString3 + getString(2131698410) + paramString4 + "。")
    {
      paramString1 = bbdj.a(this, 230, getString(2131698387), paramString1, 2131698434, 2131698435, localbgow, localbgov);
      paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString1.show();
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    bgot localbgot = new bgot(this);
    bgou localbgou = new bgou(this, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {}
    for (int i = 2131698382;; i = 2131698381)
    {
      paramString = bbdj.a(this, 230, getString(2131698387), paramString, 2131698379, i, localbgou, localbgot);
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
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bgoq(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity
 * JD-Core Version:    0.7.0.1
 */