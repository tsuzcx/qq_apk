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
  public static long a = 0L;
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
      if ((localPluginInfo.mState != 1) && (localPluginInfo.mState != 3))
      {
        c();
        this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("qqindividuality_plugin.apk", new QQIndividualityBridgeActivity.3(this));
        return;
      }
      c();
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
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
    if (localIntent == null) {
      return;
    }
    int i;
    if (!QIPCServerHelper.getInstance().isModuleRunning("qqindividuality_plugin.apk"))
    {
      this.jdField_a_of_type_Boolean = false;
      i = this.jdField_b_of_type_Int;
      if (i == c)
      {
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx, this.jdField_a_of_type_Int);
        overridePendingTransition(2130772147, 0);
      }
      else if (i == d)
      {
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        localIntent.putExtra("is_first_open", true);
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx, this.jdField_a_of_type_Int);
        overridePendingTransition(2130772147, 0);
      }
      else if (i == e)
      {
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx, this.jdField_a_of_type_Int);
        overridePendingTransition(2130772147, 0);
      }
    }
    else
    {
      i = this.jdField_b_of_type_Int;
      if (i == c)
      {
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, null, this.jdField_a_of_type_Int);
      }
      else if (i == d)
      {
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, null, this.jdField_a_of_type_Int);
      }
      else if (i == e)
      {
        QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, null, this.jdField_a_of_type_Int);
        overridePendingTransition(2130772147, 0);
      }
    }
    if (-1 == this.jdField_a_of_type_Int) {
      super.finish();
    }
  }
  
  public void c()
  {
    if (!isFinishing())
    {
      int i = this.jdField_b_of_type_Int;
      if (i == c)
      {
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.show();
        return;
      }
      if ((i == e) || (i == d)) {
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.show();
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    paramInt1 = this.jdField_b_of_type_Int;
    Object localObject;
    if (paramInt1 == c)
    {
      localObject = this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx;
      if (localObject != null)
      {
        if (((QQIndividualityBridgeActivity.QQProgressDialogEx)localObject).isShowing()) {
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.dismiss();
        }
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.setOnDismissListener(null);
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx = null;
      }
    }
    else if ((paramInt1 == d) || (paramInt1 == e))
    {
      localObject = this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx;
      if (localObject != null)
      {
        if (((QQIndividualityBridgeActivity.SignatureLoadingDialogEx)localObject).isShowing()) {
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.dismiss();
        }
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.setOnDismissListener(null);
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx = null;
      }
    }
    setResult(paramInt2, paramIntent);
    super.finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167333);
    if (Math.abs(System.currentTimeMillis() - jdField_a_of_type_Long) < 800L)
    {
      setResult(1001);
      super.finish();
      return true;
    }
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("individuality_plugin", -1);
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra(QQIndividualityUtils.e);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra(QQIndividualityUtils.f);
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("path or name is null , return: ");
        paramBundle.append(this.jdField_a_of_type_JavaLangString);
        paramBundle.append(" ");
        paramBundle.append(this.jdField_b_of_type_JavaLangString);
        QLog.d("QQIndividuality", 2, paramBundle.toString());
      }
      setResult(1001);
      super.finish();
    }
    int i = super.getResources().getDimensionPixelSize(2131299168);
    this.jdField_a_of_type_Int = getIntent().getIntExtra(QQIndividualityUtils.i, -1);
    int j = this.jdField_b_of_type_Int;
    if ((j == d) || (j == e))
    {
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx = new QQIndividualityBridgeActivity.SignatureLoadingDialogEx(this, this);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx.setOnDismissListener(new QQIndividualityBridgeActivity.1(this));
    }
    if (this.jdField_b_of_type_Int == c)
    {
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx = new QQIndividualityBridgeActivity.QQProgressDialogEx(this, this, i);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.a(HardCodeUtil.a(2131710342));
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.setCanceledOnTouchOutside(false);
      if (this.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.setOnDismissListener(new QQIndividualityBridgeActivity.2(this));
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx;
    if (localObject != null)
    {
      if (((QQIndividualityBridgeActivity.QQProgressDialogEx)localObject).isShowing()) {
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.dismiss();
      }
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx.setOnDismissListener(null);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$QQProgressDialogEx = null;
    }
    localObject = this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$SignatureLoadingDialogEx;
    if (localObject != null)
    {
      if (((QQIndividualityBridgeActivity.SignatureLoadingDialogEx)localObject).isShowing()) {
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
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity
 * JD-Core Version:    0.7.0.1
 */