package cooperation.qqreader;

import ajhd;
import ajjj;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import awqx;
import befq;
import bezo;
import bfcz;
import bfka;
import bflh;
import bfli;
import bfll;
import bfln;
import bflo;
import bflp;
import bfmp;
import bfne;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.plugin.PluginInfo;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;
import cooperation.qqindividuality.QQIndividualityProxyActivity;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QRBridgeActivity
  extends Activity
  implements Handler.Callback
{
  public static String a;
  public static boolean a;
  public static String b = "-1";
  public static boolean b;
  private long jdField_a_of_type_Long;
  Bundle jdField_a_of_type_AndroidOsBundle = null;
  public befq a;
  public bfcz a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  private QRBridgeActivity.PluginLaunchReceiver jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver;
  public boolean c;
  public boolean d;
  volatile boolean e = false;
  private boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "-1";
  }
  
  private void a(Context paramContext)
  {
    QRBridgeUtil.loadReaderPluginModule(paramContext);
  }
  
  private boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|0|0|0|0");
    bfne.d("QRBridgeActivity", "isNeedMiddlePagePreloadProcess dpc = " + str);
    boolean bool1 = bool3;
    if (!TextUtils.isEmpty(str))
    {
      Integer[] arrayOfInteger = new Integer[5];
      Arrays.fill(arrayOfInteger, Integer.valueOf(0));
      bool1 = bool3;
      if (DeviceProfileManager.a(str, arrayOfInteger, new ajhd()) >= arrayOfInteger.length) {
        if (arrayOfInteger[4].intValue() != 1) {
          break label107;
        }
      }
    }
    label107:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  private void d()
  {
    PluginInfo localPluginInfo = this.jdField_a_of_type_Bfcz.a("qqreaderplugin.apk");
    int j = 0;
    int i = j;
    if (localPluginInfo != null)
    {
      if (localPluginInfo.mState != 4) {
        break label69;
      }
      bfne.d("QRBridgeActivity", "initPlugin STATE_INSTALLED");
      i = 1;
    }
    while (i == 0)
    {
      bflp.a(2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(1001, 400L);
      bflp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      label69:
      if (localPluginInfo.mState == 1)
      {
        bfne.d("QRBridgeActivity", "initPlugin STATE_DOWNLOADING");
        i = j;
      }
      else
      {
        bfne.d("QRBridgeActivity", "initPlugin installPlugin");
        bflp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        i = j;
      }
    }
    this.f = true;
    b();
  }
  
  private void e()
  {
    bfmp.a().a();
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
    Object localObject;
    if (bflo.a(this) == -1)
    {
      localObject = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localObject == null) {
        break label397;
      }
    }
    label384:
    label392:
    label397:
    for (int i = ((Card)localObject).shGender;; i = -1)
    {
      if ((i != 0) && (i != 1))
      {
        i = a();
        bfne.d("QRBridgeActivity", "set prefer by random " + i);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "VIP_QQREADER", "", "0X8005877", "0X8005877", 0, 0, "" + i, "", "", "");
        bflo.a(this, i);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("auto_launch", this.f);
        if (!"action_from_list".equals(this.jdField_a_of_type_AndroidOsBundle.get("action_type"))) {
          break label392;
        }
        if (!QIPCServerHelper.getInstance().isModuleRunning("qqindividuality_plugin.apk")) {
          break label369;
        }
        localObject = new Intent(this, QQIndividualityProxyActivity.class);
        label181:
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra(bfka.l, 1);
        ((Intent)localObject).putExtra(bfka.e, "path");
        ((Intent)localObject).putExtra(bfka.f, "name");
        ((Intent)localObject).putExtra("k_source", 3);
        ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        ((Intent)localObject).setFlags(67108864);
        if (!QIPCServerHelper.getInstance().isModuleRunning("qqindividuality_plugin.apk")) {
          break label384;
        }
        QQIndividualityProxyActivity.a(this, (Intent)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, null, -1);
      }
      for (;;)
      {
        finish();
        bfne.d("QRBridgeActivity", "QRBridgeActivity start EditActivity");
        return;
        bfne.d("QRBridgeActivity", "set prefer by gender " + i);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "VIP_QQREADER", "", "0X8005876", "0X8005876", 0, 0, "" + i, "", "", "");
        break;
        label369:
        localObject = new Intent(this, QQIndividualityBridgeActivity.class);
        break label181;
        startActivity((Intent)localObject);
      }
      c();
      return;
    }
  }
  
  public void a(PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_Bfcz.isReady()) {
        this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(1001, 400L);
      }
      return;
    }
    bfne.d("QRBridgeActivity", "handlePluginInfo:" + paramPluginBaseInfo.mState);
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      return;
    case -2: 
      this.jdField_a_of_type_Befq.sendEmptyMessage(1003);
      return;
    case 0: 
      this.jdField_a_of_type_Bfcz.a("qqreaderplugin.apk");
    case 1: 
    case 2: 
      int i = (int)(paramPluginBaseInfo.mDownloadProgress * 90.0F);
      this.jdField_a_of_type_Befq.obtainMessage(1000, i, 0).sendToTarget();
      this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      this.jdField_a_of_type_Befq.sendEmptyMessage(1002);
      this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 5: 
      this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(1001, 400L);
      return;
    }
    this.c = true;
    this.f = false;
    b();
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    if (localObject == null) {
      return false;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b()
  {
    if ((!this.d) && (a()))
    {
      a(this);
      this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(1004, 5000L);
      return;
    }
    a();
  }
  
  public void c()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(1134028), 1000L);
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(1134040), 1000L);
    }
    bezo.a(null);
    QRBridgeUtil.loadReaderPluginModule(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      if (!this.e)
      {
        this.e = true;
        a();
      }
      bfne.d("QRBridgeActivity", "not have reader process launch BroadcastReceiver");
      return true;
    } while (isFinishing());
    a(this.jdField_a_of_type_Bfcz.a("qqreaderplugin.apk"));
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bfne.d("QRBridgeActivity", "QRBridgeActivity onCreate");
    e();
    QRBridgeUtil.preloadPSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "books.qq.com");
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    getWindow().setBackgroundDrawableResource(2131101491);
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Long = getIntent().getLongExtra("click_start_time", 0L);
    long l2 = this.jdField_a_of_type_Long;
    bfne.d("cost_time_tag", "QRBridgeActivity :clickToOnCreate =" + (l1 - l2));
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      finish();
      return;
    }
    setContentView(new FrameLayout(this), new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_Bfcz = ((bfcz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(27));
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.middlePagePreloadProcess");
    this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver = new QRBridgeActivity.PluginLaunchReceiver(this);
    getApplicationContext().registerReceiver(this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver, paramBundle);
    this.jdField_a_of_type_Befq = new befq(this);
    this.d = a("com.tencent.mobileqq:tool");
    paramBundle = (bfli)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(129);
    paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), System.currentTimeMillis());
    paramBundle.b();
    d();
    paramBundle = new Intent();
    paramBundle.putExtra("key_click_leba_start_time", this.jdField_a_of_type_Long);
    paramBundle.putExtra("key_enter_qr_bridge_activity_oncreate_time", l1);
    paramBundle.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    paramBundle = bflh.a(this, paramBundle, BaseApplicationImpl.getApplication().getRuntime().getAccount());
    PluginCommunicationHandler.getInstance().register(new bfln());
    PluginCommunicationHandler.getInstance().register(new bfll());
    paramBundle.putExtra("startOpenPageTime", this.jdField_a_of_type_Long);
    paramBundle.putExtra("is_follow_publicaccount", bflo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    if (!paramBundle.hasExtra("big_brother_source_key")) {
      paramBundle.putExtra("big_brother_source_key", "biz_src_jc_neirong");
    }
    Bundle localBundle = paramBundle.getExtras();
    if (localBundle != null)
    {
      boolean bool = localBundle.getBoolean("is_from_qreader_shortcut", false);
      if (localBundle.containsKey("ChannelID"))
      {
        if ((bool) && (b.equals("-1"))) {
          b = jdField_a_of_type_JavaLangString;
        }
        jdField_a_of_type_JavaLangString = localBundle.getString("ChannelID");
      }
    }
    paramBundle.putExtra("key_qr_bridge_activity_start_activity_time", System.currentTimeMillis());
    startActivity(paramBundle);
    finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Befq != null)
    {
      this.jdField_a_of_type_Befq.removeMessages(1004);
      this.jdField_a_of_type_Befq.removeMessages(1001);
    }
    bfne.d("QRBridgeActivity", "QRBridgeActivity onDestroy");
    if (this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver != null) {
      getApplicationContext().unregisterReceiver(this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeActivity
 * JD-Core Version:    0.7.0.1
 */