package cooperation.qqindividuality;

import ampx;
import ampy;
import ampz;
import amqa;
import amqb;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

public class QQIndividualityBridgeActivity
  extends QQIndividualityBaseBridgeActivity
{
  public static long a;
  public static int c;
  public static int d = 1;
  public static int e = 2;
  int jdField_a_of_type_Int;
  public amqa a;
  public amqb a;
  String jdField_a_of_type_JavaLangString = null;
  public boolean a;
  public int b;
  String b;
  
  public QQIndividualityBridgeActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
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
      this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("qqindividuality_plugin.apk", new ampz(this));
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
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_Amqa, this.jdField_a_of_type_Int);
          overridePendingTransition(2131034210, 0);
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
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_Amqb, this.jdField_a_of_type_Int);
          overridePendingTransition(2131034210, 0);
        }
        else if (this.jdField_b_of_type_Int == e)
        {
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_Amqb, this.jdField_a_of_type_Int);
          overridePendingTransition(2131034210, 0);
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
            overridePendingTransition(2131034210, 0);
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
      this.jdField_a_of_type_Amqa.show();
    }
    label25:
    while ((this.jdField_b_of_type_Int != e) && (this.jdField_b_of_type_Int != d)) {
      return;
    }
    this.jdField_a_of_type_Amqb.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_b_of_type_Int == c) {
      if (this.jdField_a_of_type_Amqa != null)
      {
        if (this.jdField_a_of_type_Amqa.isShowing()) {
          this.jdField_a_of_type_Amqa.dismiss();
        }
        this.jdField_a_of_type_Amqa.setOnDismissListener(null);
        this.jdField_a_of_type_Amqa = null;
      }
    }
    for (;;)
    {
      setResult(paramInt2, paramIntent);
      super.finish();
      return;
      if (((this.jdField_b_of_type_Int == d) || (this.jdField_b_of_type_Int == e)) && (this.jdField_a_of_type_Amqb != null))
      {
        if (this.jdField_a_of_type_Amqb.isShowing()) {
          this.jdField_a_of_type_Amqb.dismiss();
        }
        this.jdField_a_of_type_Amqb.setOnDismissListener(null);
        this.jdField_a_of_type_Amqb = null;
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131492924);
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
        i = super.getResources().getDimensionPixelSize(2131558448);
        this.jdField_a_of_type_Int = getIntent().getIntExtra(QQIndividualityUtils.i, -1);
        if ((this.jdField_b_of_type_Int == d) || (this.jdField_b_of_type_Int == e))
        {
          this.jdField_a_of_type_Amqb = new amqb(this, this);
          this.jdField_a_of_type_Amqb.setCanceledOnTouchOutside(false);
          this.jdField_a_of_type_Amqb.setOnDismissListener(new ampx(this));
        }
      } while (this.jdField_b_of_type_Int != c);
      this.jdField_a_of_type_Amqa = new amqa(this, this, i);
      this.jdField_a_of_type_Amqa.a("正在加载，请稍候...");
      this.jdField_a_of_type_Amqa.setCanceledOnTouchOutside(false);
    } while (this.jdField_a_of_type_Int == -1);
    this.jdField_a_of_type_Amqa.setOnDismissListener(new ampy(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Amqa != null)
    {
      if (this.jdField_a_of_type_Amqa.isShowing()) {
        this.jdField_a_of_type_Amqa.dismiss();
      }
      this.jdField_a_of_type_Amqa.setOnDismissListener(null);
      this.jdField_a_of_type_Amqa = null;
    }
    if (this.jdField_a_of_type_Amqb != null)
    {
      if (this.jdField_a_of_type_Amqb.isShowing()) {
        this.jdField_a_of_type_Amqb.dismiss();
      }
      this.jdField_a_of_type_Amqb.setOnDismissListener(null);
      this.jdField_a_of_type_Amqb = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "destroy.....");
    }
    sTopActivity = null;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity
 * JD-Core Version:    0.7.0.1
 */