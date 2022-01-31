package cooperation.qqreader;

import alto;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import azqs;
import binb;
import biyw;
import biyz;
import bize;
import bizh;
import bizj;
import bizl;
import bizm;
import bjav;
import bjbl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QRBridgeActivity
  extends Activity
{
  public static String a;
  public static boolean a;
  public static boolean b;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  
  static
  {
    jdField_a_of_type_JavaLangString = "-1";
  }
  
  private void b()
  {
    boolean bool = biyz.a().a();
    if (!bool) {
      bizm.a(2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("auto_launch", bool);
    a();
    biyz.a().b(this);
  }
  
  private void c()
  {
    bjav.a().a();
  }
  
  public int a()
  {
    int i = (int)(Math.random() * 100.0D) + 1;
    if (i <= 30) {
      return 0;
    }
    if (i <= 60) {
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    int i;
    Object localObject;
    if (bizl.a(this) == -1)
    {
      i = -1;
      localObject = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localObject != null) {
        i = ((Card)localObject).shGender;
      }
      if ((i == 0) || (i == 1)) {
        break label177;
      }
      i = a();
      bjbl.e("QRBridgeActivity", "set prefer by random " + i);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "VIP_QQREADER", "", "0X8005877", "0X8005877", 0, 0, "" + i, "", "", "");
    }
    for (;;)
    {
      bizl.a(this, i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(1134028), 1000L);
        ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(1134040), 1000L);
      }
      binb.a(null);
      return;
      label177:
      bjbl.e("QRBridgeActivity", "set prefer by gender " + i);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "VIP_QQREADER", "", "0X8005876", "0X8005876", 0, 0, "" + i, "", "", "");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bjbl.e("QRBridgeActivity", "QRBridgeActivity onCreate");
    if (Build.VERSION.SDK_INT < 26) {
      setRequestedOrientation(1);
    }
    c();
    QRBridgeUtil.preloadPSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "books.qq.com");
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    getWindow().setBackgroundDrawableResource(2131167140);
    long l1 = System.currentTimeMillis();
    long l2 = getIntent().getLongExtra("click_start_time", 0L);
    bjbl.c("cost_time_tag", "QRBridgeActivity :clickToOnCreate =" + (l1 - l2));
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      bjbl.a("QRBridgeActivity", "app is not login");
      finish();
      return;
    }
    setContentView(new FrameLayout(this), new FrameLayout.LayoutParams(-1, -1));
    paramBundle = (bize)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(129);
    paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), System.currentTimeMillis());
    paramBundle.b();
    b();
    paramBundle = new Intent();
    paramBundle.putExtra("key_click_leba_start_time", l2);
    paramBundle.putExtra("key_enter_qr_bridge_activity_oncreate_time", l1);
    paramBundle.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    paramBundle = biyw.a(this, paramBundle, BaseApplicationImpl.getApplication().getRuntime().getAccount());
    PluginCommunicationHandler.getInstance().register(new bizj());
    PluginCommunicationHandler.getInstance().register(new bizh());
    paramBundle.putExtra("startOpenPageTime", l2);
    paramBundle.putExtra("is_follow_publicaccount", bizl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    if (!paramBundle.hasExtra("big_brother_source_key")) {
      paramBundle.putExtra("big_brother_source_key", "biz_src_jc_neirong");
    }
    if (paramBundle.hasExtra("ChannelID")) {
      jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("ChannelID");
    }
    paramBundle.putExtra("key_qr_bridge_activity_start_activity_time", System.currentTimeMillis());
    startActivity(paramBundle);
    finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bjbl.e("QRBridgeActivity", "QRBridgeActivity onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeActivity
 * JD-Core Version:    0.7.0.1
 */