package cooperation.qqindividuality;

import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import beez;
import bfcz;
import bfju;
import bfjv;
import bfjw;
import bfjx;
import bfjy;
import bfka;
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
  public bfjx a;
  public bfjy a;
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
    if (this.jdField_a_of_type_Bfcz == null) {
      return;
    }
    PluginInfo localPluginInfo = this.jdField_a_of_type_Bfcz.a("qqindividuality_plugin.apk");
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
        this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(1000, 200L);
        return;
      }
      c();
      this.jdField_a_of_type_Bfcz.installPlugin("qqindividuality_plugin.apk", new bfjw(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "initPlugin pluginInfo == null");
    }
    c();
    this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(1000, 200L);
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
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_Bfjx, this.jdField_a_of_type_Int);
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
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_Bfjy, this.jdField_a_of_type_Int);
          overridePendingTransition(2130772097, 0);
        }
        else if (this.jdField_b_of_type_Int == e)
        {
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_Bfjy, this.jdField_a_of_type_Int);
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
      this.jdField_a_of_type_Bfjx.show();
    }
    label25:
    while ((this.jdField_b_of_type_Int != e) && (this.jdField_b_of_type_Int != d)) {
      return;
    }
    this.jdField_a_of_type_Bfjy.show();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_b_of_type_Int == c) {
      if (this.jdField_a_of_type_Bfjx != null)
      {
        if (this.jdField_a_of_type_Bfjx.isShowing()) {
          this.jdField_a_of_type_Bfjx.dismiss();
        }
        this.jdField_a_of_type_Bfjx.setOnDismissListener(null);
        this.jdField_a_of_type_Bfjx = null;
      }
    }
    for (;;)
    {
      setResult(paramInt2, paramIntent);
      super.finish();
      return;
      if (((this.jdField_b_of_type_Int == d) || (this.jdField_b_of_type_Int == e)) && (this.jdField_a_of_type_Bfjy != null))
      {
        if (this.jdField_a_of_type_Bfjy.isShowing()) {
          this.jdField_a_of_type_Bfjy.dismiss();
        }
        this.jdField_a_of_type_Bfjy.setOnDismissListener(null);
        this.jdField_a_of_type_Bfjy = null;
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131101491);
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
        this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra(bfka.e);
        this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra(bfka.f);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQIndividuality", 2, "path or name is null , return: " + this.jdField_a_of_type_JavaLangString + " " + this.jdField_b_of_type_JavaLangString);
          }
          setResult(1001);
          super.finish();
        }
        i = super.getResources().getDimensionPixelSize(2131167766);
        this.jdField_a_of_type_Int = getIntent().getIntExtra(bfka.i, -1);
        if ((this.jdField_b_of_type_Int == d) || (this.jdField_b_of_type_Int == e))
        {
          this.jdField_a_of_type_Bfjy = new bfjy(this, this);
          this.jdField_a_of_type_Bfjy.setCanceledOnTouchOutside(false);
          this.jdField_a_of_type_Bfjy.setOnDismissListener(new bfju(this));
        }
      } while (this.jdField_b_of_type_Int != c);
      this.jdField_a_of_type_Bfjx = new bfjx(this, this, i);
      this.jdField_a_of_type_Bfjx.a(ajjy.a(2131644603));
      this.jdField_a_of_type_Bfjx.setCanceledOnTouchOutside(false);
    } while (this.jdField_a_of_type_Int == -1);
    this.jdField_a_of_type_Bfjx.setOnDismissListener(new bfjv(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bfjx != null)
    {
      if (this.jdField_a_of_type_Bfjx.isShowing()) {
        this.jdField_a_of_type_Bfjx.dismiss();
      }
      this.jdField_a_of_type_Bfjx.setOnDismissListener(null);
      this.jdField_a_of_type_Bfjx = null;
    }
    if (this.jdField_a_of_type_Bfjy != null)
    {
      if (this.jdField_a_of_type_Bfjy.isShowing()) {
        this.jdField_a_of_type_Bfjy.dismiss();
      }
      this.jdField_a_of_type_Bfjy.setOnDismissListener(null);
      this.jdField_a_of_type_Bfjy = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity
 * JD-Core Version:    0.7.0.1
 */