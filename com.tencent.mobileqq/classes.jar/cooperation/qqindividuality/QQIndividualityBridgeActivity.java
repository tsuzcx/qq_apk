package cooperation.qqindividuality;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

public class QQIndividualityBridgeActivity
  extends QQIndividualityBaseBridgeActivity
{
  public static long a;
  public static int c = 0;
  public static int d = 1;
  public static int e = 2;
  int jdField_a_of_type_Int;
  public QQIndividualityBridgeActivity.QQProgressDialogEx a;
  public QQIndividualityBridgeActivity.SignatureLoadingDialogEx a;
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = -1;
  String jdField_b_of_type_JavaLangString = null;
  
  static
  {
    jdField_a_of_type_Long = 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_CooperationPluginIPluginManager == null) {
      return;
    }
    PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqindividuality_plugin.apk");
    if (localPluginInfo != null)
    {
      if (localPluginInfo.mState == 4)
      {
        b();
        return;
      }
      if ((localPluginInfo.mState == 1) || (localPluginInfo.mState == 3))
      {
        c();
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
        return;
      }
      c();
      this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("qqindividuality_plugin.apk", new QQIndividualityBridgeActivity.3(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "initPlugin pluginInfo == null");
    }
    c();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
  }
  
  public void b()
  {
    Intent localIntent = getIntent();
    if (localIntent == null) {}
    for (;;)
    {
      return;
      if (!QIPCServerHelper.getInstance().isModuleRunning("qqindividuality_plugin.apk"))
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_b_of_type_Int == c)
        {
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx, this.jdField_a_of_type_Int);
          overridePendingTransition(2130772121, 0);
        }
      }
      while (-1 == this.jdField_a_of_type_Int)
      {
        super.finish();
        return;
        if (this.jdField_b_of_type_Int == d)
        {
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("is_first_open", true);
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx, this.jdField_a_of_type_Int);
          overridePendingTransition(2130772121, 0);
        }
        else if (this.jdField_b_of_type_Int == e)
        {
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx, this.jdField_a_of_type_Int);
          overridePendingTransition(2130772121, 0);
          continue;
          if (this.jdField_b_of_type_Int == c)
          {
            QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, null, this.jdField_a_of_type_Int);
          }
          else if (this.jdField_b_of_type_Int == d)
          {
            localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, null, this.jdField_a_of_type_Int);
          }
          else if (this.jdField_b_of_type_Int == e)
          {
            QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, null, this.jdField_a_of_type_Int);
            overridePendingTransition(2130772121, 0);
          }
        }
      }
    }
  }
  
  public void c()
  {
    if (!isFinishing())
    {
      if (this.jdField_b_of_type_Int != c) {
        break label25;
      }
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.show();
    }
    label25:
    while ((this.jdField_b_of_type_Int != e) && (this.jdField_b_of_type_Int != d)) {
      return;
    }
    this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_b_of_type_Int == c) {
      if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx != null)
      {
        if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.isShowing()) {
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.dismiss();
        }
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.setOnDismissListener(null);
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx = null;
      }
    }
    for (;;)
    {
      setResult(paramInt2, paramIntent);
      super.finish();
      return;
      if (((this.jdField_b_of_type_Int == d) || (this.jdField_b_of_type_Int == e)) && (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx != null))
      {
        if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.isShowing()) {
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.dismiss();
        }
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.setOnDismissListener(null);
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx = null;
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167305);
    if (Math.abs(System.currentTimeMillis() - jdField_a_of_type_Long) < 800L)
    {
      setResult(1001);
      super.finish();
    }
    do
    {
      int i;
      do
      {
        return true;
        paramBundle = getIntent();
        if (paramBundle != null) {
          this.jdField_b_of_type_Int = paramBundle.getIntExtra("individuality_plugin", -1);
        }
        jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra(QQIndividualityUtils.e);
        this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra(QQIndividualityUtils.f);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQIndividuality", 2, "path or name is null , return: " + this.jdField_a_of_type_JavaLangString + " " + this.jdField_b_of_type_JavaLangString);
          }
          setResult(1001);
          super.finish();
        }
        i = super.getResources().getDimensionPixelSize(2131299166);
        this.jdField_a_of_type_Int = getIntent().getIntExtra(QQIndividualityUtils.i, -1);
        if ((this.jdField_b_of_type_Int == d) || (this.jdField_b_of_type_Int == e))
        {
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx = new QQIndividualityBridgeActivity.SignatureLoadingDialogEx(this, this);
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.setCanceledOnTouchOutside(false);
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.setOnDismissListener(new QQIndividualityBridgeActivity.1(this));
        }
      } while (this.jdField_b_of_type_Int != c);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx = new QQIndividualityBridgeActivity.QQProgressDialogEx(this, this, i);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.a(HardCodeUtil.a(2131710363));
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.setCanceledOnTouchOutside(false);
    } while (this.jdField_a_of_type_Int == -1);
    this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.setOnDismissListener(new QQIndividualityBridgeActivity.2(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx != null)
    {
      if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.isShowing()) {
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.dismiss();
      }
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.setOnDismissListener(null);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx = null;
    }
    if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx != null)
    {
      if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.isShowing()) {
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.dismiss();
      }
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.setOnDismissListener(null);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "destroy.....");
    }
    sTopActivity = null;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity
 * JD-Core Version:    0.7.0.1
 */