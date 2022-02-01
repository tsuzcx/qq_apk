package cooperation.qlink;

import Override;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import anzj;
import bhlg;
import bhlq;
import bhpc;
import bmim;
import bmjo;
import bmjp;
import bmjq;
import bmjr;
import bmjs;
import bmjt;
import bmju;
import bmjv;
import bmjw;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QlinkStandardDialogActivity
  extends BaseActivity
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  final DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new bmjp(this);
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  private void a()
  {
    Object localObject = new bmjq(this);
    localObject = bhlq.a(this, 230, getString(2131697629), getString(2131697618), 2131697622, 2131697622, (DialogInterface.OnClickListener)localObject, null);
    ((bhpc)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((bhpc)localObject).show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = bhlq.a(this, 230, getString(2131697609), anzj.a(2131708904) + paramString2 + anzj.a(2131708902), 2131697621, 2131697608, new bmjv(this, paramString1, paramString2), new bmjw(this));
    paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    paramString1.show();
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    bmjt localbmjt = new bmjt(this);
    bmju localbmju = new bmju(this);
    String str = paramString2;
    if (paramString1 != null)
    {
      str = paramString2;
      if (paramString1.equalsIgnoreCase(paramString2)) {
        str = bhlg.j(this.app, paramString1);
      }
    }
    if (paramBoolean) {}
    for (paramString1 = getString(2131697658) + str + getString(2131697659) + paramInt + getString(2131697660) + paramString3 + getString(2131697661) + paramString4 + "。";; paramString1 = getString(2131697649) + str + getString(2131697650) + paramInt + getString(2131697651) + paramString3 + getString(2131697652) + paramString4 + "。")
    {
      paramString1 = bhlq.a(this, 230, getString(2131697629), paramString1, 2131697676, 2131697677, localbmju, localbmjt);
      paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString1.show();
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    bmjr localbmjr = new bmjr(this);
    bmjs localbmjs = new bmjs(this, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {}
    for (int i = 2131697624;; i = 2131697623)
    {
      paramString = bhlq.a(this, 230, getString(2131697629), paramString, 2131697621, i, localbmjs, localbmjr);
      paramString.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString.show();
      return;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bmjo(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity
 * JD-Core Version:    0.7.0.1
 */