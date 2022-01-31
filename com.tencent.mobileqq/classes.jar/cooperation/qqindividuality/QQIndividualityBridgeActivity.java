package cooperation.qqindividuality;

import alpo;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import bhoe;
import bimg;
import bitc;
import bitd;
import bite;
import bitf;
import bitg;
import biti;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

public class QQIndividualityBridgeActivity
  extends QQIndividualityBaseBridgeActivity
{
  public static long a;
  public static int c;
  public static int d = 1;
  public static int e = 2;
  int jdField_a_of_type_Int;
  public bitf a;
  public bitg a;
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
    if (this.jdField_a_of_type_Bimg == null) {
      return;
    }
    PluginInfo localPluginInfo = this.jdField_a_of_type_Bimg.a("qqindividuality_plugin.apk");
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
        this.jdField_a_of_type_Bhoe.sendEmptyMessageDelayed(1000, 200L);
        return;
      }
      c();
      this.jdField_a_of_type_Bimg.installPlugin("qqindividuality_plugin.apk", new bite(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "initPlugin pluginInfo == null");
    }
    c();
    this.jdField_a_of_type_Bhoe.sendEmptyMessageDelayed(1000, 200L);
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
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_Bitf, this.jdField_a_of_type_Int);
          overridePendingTransition(2130772097, 0);
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
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_Bitg, this.jdField_a_of_type_Int);
          overridePendingTransition(2130772097, 0);
        }
        else if (this.jdField_b_of_type_Int == e)
        {
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_Bitg, this.jdField_a_of_type_Int);
          overridePendingTransition(2130772097, 0);
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
            overridePendingTransition(2130772097, 0);
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
      this.jdField_a_of_type_Bitf.show();
    }
    label25:
    while ((this.jdField_b_of_type_Int != e) && (this.jdField_b_of_type_Int != d)) {
      return;
    }
    this.jdField_a_of_type_Bitg.show();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_b_of_type_Int == c) {
      if (this.jdField_a_of_type_Bitf != null)
      {
        if (this.jdField_a_of_type_Bitf.isShowing()) {
          this.jdField_a_of_type_Bitf.dismiss();
        }
        this.jdField_a_of_type_Bitf.setOnDismissListener(null);
        this.jdField_a_of_type_Bitf = null;
      }
    }
    for (;;)
    {
      setResult(paramInt2, paramIntent);
      super.finish();
      return;
      if (((this.jdField_b_of_type_Int == d) || (this.jdField_b_of_type_Int == e)) && (this.jdField_a_of_type_Bitg != null))
      {
        if (this.jdField_a_of_type_Bitg.isShowing()) {
          this.jdField_a_of_type_Bitg.dismiss();
        }
        this.jdField_a_of_type_Bitg.setOnDismissListener(null);
        this.jdField_a_of_type_Bitg = null;
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167138);
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
        this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra(biti.e);
        this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra(biti.f);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQIndividuality", 2, "path or name is null , return: " + this.jdField_a_of_type_JavaLangString + " " + this.jdField_b_of_type_JavaLangString);
          }
          setResult(1001);
          super.finish();
        }
        i = super.getResources().getDimensionPixelSize(2131298914);
        this.jdField_a_of_type_Int = getIntent().getIntExtra(biti.i, -1);
        if ((this.jdField_b_of_type_Int == d) || (this.jdField_b_of_type_Int == e))
        {
          this.jdField_a_of_type_Bitg = new bitg(this, this);
          this.jdField_a_of_type_Bitg.setCanceledOnTouchOutside(false);
          this.jdField_a_of_type_Bitg.setOnDismissListener(new bitc(this));
        }
      } while (this.jdField_b_of_type_Int != c);
      this.jdField_a_of_type_Bitf = new bitf(this, this, i);
      this.jdField_a_of_type_Bitf.a(alpo.a(2131710771));
      this.jdField_a_of_type_Bitf.setCanceledOnTouchOutside(false);
    } while (this.jdField_a_of_type_Int == -1);
    this.jdField_a_of_type_Bitf.setOnDismissListener(new bitd(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bitf != null)
    {
      if (this.jdField_a_of_type_Bitf.isShowing()) {
        this.jdField_a_of_type_Bitf.dismiss();
      }
      this.jdField_a_of_type_Bitf.setOnDismissListener(null);
      this.jdField_a_of_type_Bitf = null;
    }
    if (this.jdField_a_of_type_Bitg != null)
    {
      if (this.jdField_a_of_type_Bitg.isShowing()) {
        this.jdField_a_of_type_Bitg.dismiss();
      }
      this.jdField_a_of_type_Bitg.setOnDismissListener(null);
      this.jdField_a_of_type_Bitg = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "destroy.....");
    }
    sTopActivity = null;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity
 * JD-Core Version:    0.7.0.1
 */