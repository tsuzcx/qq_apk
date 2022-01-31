package cooperation.qqreader;

import amqt;
import amqu;
import amqv;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.comic.VipComicRemoteCommand;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;
import cooperation.qqindividuality.QQIndividualityProxyActivity;
import cooperation.qqindividuality.QQIndividualityUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QRBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener
{
  public static boolean a;
  public static boolean b;
  public int a;
  public long a;
  Bundle jdField_a_of_type_AndroidOsBundle = null;
  public ViewStub a;
  public Button a;
  public TextView a;
  public URLImageView a;
  public WeakReferenceHandler a;
  public IPluginManager a;
  private QRBridgeActivity.PluginLaunchReceiver jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver;
  public QRNumberCircleProgressBar a;
  public QRPluginBooks a;
  public String a;
  public JSONObject a;
  public long b;
  public TextView b;
  public final String b;
  private long c;
  public final String c;
  public boolean c;
  private long d;
  public final String d;
  public boolean d;
  private long e;
  public final String e;
  public boolean e;
  private long jdField_f_of_type_Long;
  public String f;
  volatile boolean jdField_f_of_type_Boolean = false;
  private long jdField_g_of_type_Long;
  public String g;
  private boolean jdField_g_of_type_Boolean;
  private long jdField_h_of_type_Long;
  public String h;
  private boolean jdField_h_of_type_Boolean;
  public String i = "";
  public String j = "";
  
  public QRBridgeActivity()
  {
    this.jdField_b_of_type_JavaLangString = "qr_recommend_bookname";
    this.jdField_c_of_type_JavaLangString = "qr_recommend_book_author";
    this.jdField_d_of_type_JavaLangString = "qr_recommend_book_type";
    this.jdField_e_of_type_JavaLangString = "qr_recommend_slogan";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
  }
  
  private void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, VipProxyRreLoadReaderProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("isMiddlePagePreloadProcess", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    localPluginParams.jdField_d_of_type_JavaLangString = "qqreader";
    localPluginParams.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localPluginParams.jdField_e_of_type_JavaLangString = "com.qqreader.ReaderPreloadReaderProcess";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.a(paramContext, localPluginParams);
  }
  
  private boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|0|0|0|0");
    if (QLog.isColorLevel()) {
      QLog.d("QRBridgeActivity", 2, "isNeedMiddlePagePreloadProcess dpc = " + str);
    }
    boolean bool1 = bool3;
    if (!TextUtils.isEmpty(str))
    {
      Integer[] arrayOfInteger = new Integer[5];
      Arrays.fill(arrayOfInteger, Integer.valueOf(0));
      bool1 = bool3;
      if (DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.StringToIntParser()) >= arrayOfInteger.length) {
        if (arrayOfInteger[4].intValue() != 1) {
          break label114;
        }
      }
    }
    label114:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public int a()
  {
    int k = (int)(Math.random() * 100.0D) + 1;
    if (k <= 30) {
      return 0;
    }
    if (k <= 60) {
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    ThreadManager.post(new amqt(this), 8, null, false);
  }
  
  public void a(int paramInt)
  {
    runOnUiThread(new amqv(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QRBridgeActivity", 4, "QRBridgeActivity launch " + paramString);
    }
    Intent localIntent = new Intent(this, QRPluginProxyActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("is_follow_publicaccount", QRUtility.a(this.app));
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("startOpenPageTime", this.jdField_f_of_type_Long);
    localIntent.putExtra("pluginFinished", this.jdField_b_of_type_Long);
    long l2;
    long l1;
    if (this.jdField_c_of_type_Long > 0L) {
      if (this.jdField_e_of_type_Long > 0L) {
        if (this.jdField_e_of_type_Long - this.jdField_c_of_type_Long > 0L)
        {
          l2 = this.jdField_e_of_type_Long - this.jdField_c_of_type_Long;
          if (this.jdField_d_of_type_Long - this.jdField_e_of_type_Long <= 0L) {
            break label512;
          }
          l1 = this.jdField_d_of_type_Long - this.jdField_e_of_type_Long;
        }
      }
    }
    for (;;)
    {
      label186:
      localIntent.putExtra("install_time", l1);
      localIntent.putExtra("download_time", l2);
      if (this.jdField_e_of_type_Boolean) {}
      for (int k = 1;; k = 0)
      {
        localIntent.putExtra("plugin_isExist", k);
        localIntent.putExtra("is_new_user", this.jdField_g_of_type_Boolean);
        MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
        if (localMqqHandler != null)
        {
          localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(1134028), 1000L);
          localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(1134040), 1000L);
        }
        VipComicRemoteCommand.a(null);
        localIntent.putExtra("redtouch_type", this.jdField_a_of_type_AndroidOsBundle.getInt("redtouch_type", -1));
        localIntent.putExtra("redtouch_push_ts", this.jdField_a_of_type_AndroidOsBundle.getInt("redtouch_push_ts", 0));
        localIntent.putExtra("redtouch_pull_ts", this.jdField_a_of_type_AndroidOsBundle.getInt("redtouch_pull_ts", 0));
        localIntent.putExtra("redtouch_click_ts", this.jdField_a_of_type_AndroidOsBundle.getInt("redtouch_click_ts", 0));
        localIntent.putStringArrayListExtra("redtouch_taskid", this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("redtouch_taskid"));
        if (paramString != null)
        {
          localIntent.putExtra("plugin_data", paramString);
          localIntent.putExtra("account", this.jdField_a_of_type_JavaLangString);
          localIntent.putExtra("load_from_third_app", true);
          localIntent.putExtra("param_plugin_gesturelock", true);
          localIntent.putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
        }
        localIntent.putExtra("urlMap", (Serializable)IndividuationUrlHelper.a());
        localIntent.putExtra("readerDpcConfig", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|0|0|0|0|0"));
        QRJumpAction.a(this, localIntent, this.app.getCurrentAccountUin());
        return;
        l2 = 0L;
        break;
        label512:
        l1 = 0L;
        break label186;
        if (this.jdField_d_of_type_Long <= 0L) {
          break label566;
        }
        if (this.jdField_d_of_type_Long - this.jdField_c_of_type_Long > 0L) {}
        for (l1 = this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;; l1 = 0L)
        {
          l2 = 0L;
          break;
        }
      }
      label566:
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isReady()) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QRBridgeActivity", 2, "handlePluginInfo:" + paramPluginBaseInfo.mState);
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      return;
    case -2: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1003);
      return;
    case 0: 
      this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqreaderplugin.apk");
    case 1: 
    case 2: 
      int k = (int)(paramPluginBaseInfo.mDownloadProgress * 90.0F);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1000, k, 0).sendToTarget();
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1002);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    }
    long l = System.currentTimeMillis();
    this.jdField_d_of_type_Long = l;
    this.jdField_b_of_type_Long = l;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = false;
    a(100);
    g();
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
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
    try
    {
      if ((QRUtility.a(this) == -1) && (this.jdField_a_of_type_Int != -1))
      {
        this.jdField_g_of_type_Boolean = true;
        QRUtility.a(this, this.jdField_a_of_type_Int, true);
        if (QLog.isColorLevel()) {
          QLog.d("QRBridgeActivity", 2, "set prefer by net " + this.jdField_a_of_type_Int);
        }
        ReportController.b(this.app, "P_CliOper", "VIP_QQREADER", "", "0X8005875", "0X8005875", 0, 0, "" + this.jdField_a_of_type_Int, "", "", "");
      }
      if (this.jdField_a_of_type_Int != -1) {
        QRUtility.b(this, this.jdField_a_of_type_Int);
      }
      if (isFinishing()) {
        return;
      }
      if (this.jdField_a_of_type_AndroidViewViewStub != null)
      {
        View localView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131372206));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372208));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372209));
        this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131372205));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_JavaLangString + "|" + this.jdField_g_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable(this.i));
      }
      if ((this.jdField_a_of_type_CooperationQqreaderQRPluginBooks != null) && (this.jdField_a_of_type_OrgJsonJSONObject != null) && (this.jdField_a_of_type_CooperationQqreaderQRPluginBooks.a(this.jdField_a_of_type_OrgJsonJSONObject.optInt("id"))))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqreaderplugin.apk");
    int m = 0;
    int k = m;
    if (localPluginInfo != null)
    {
      if (localPluginInfo.mState != 4) {
        break label80;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QRBridgeActivity", 2, "initPlugin STATE_INSTALLED");
      }
      a(100);
      k = 1;
    }
    while (k == 0)
    {
      QReaderHelper.a(2, this.app);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      d();
      return;
      label80:
      if (localPluginInfo.mState == 1)
      {
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("QRBridgeActivity", 2, "initPlugin STATE_DOWNLOADING");
          k = m;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("QRBridgeActivity", 2, "initPlugin installPlugin");
        }
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("qqreaderplugin.apk", new amqu(this));
        k = m;
      }
    }
    if (QRUtility.a(this) == -1) {
      d();
    }
    this.jdField_h_of_type_Boolean = true;
    g();
  }
  
  public void d()
  {
    a();
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    this.jdField_f_of_type_Long = getIntent().getLongExtra("click_start_time", 0L);
    this.jdField_g_of_type_Long = (this.jdField_h_of_type_Long - this.jdField_f_of_type_Long);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    this.jdField_a_of_type_AndroidOsBundle.putLong("qrbright_create_time", System.currentTimeMillis());
    if (!this.app.isLogin())
    {
      finish();
      return false;
    }
    setContentView(2130970920);
    e();
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    if (QLog.isDevelopLevel()) {
      QLog.d("QRBridgeActivity", 4, "QRBridgeActivity onCreate");
    }
    getWindow().setBackgroundDrawableResource(2131492924);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.closeQRBridgeActivity");
    paramBundle.addAction("com.tencent.mobileqq.middlePagePreloadProcess");
    this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver = new QRBridgeActivity.PluginLaunchReceiver(this);
    getApplicationContext().registerReceiver(this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver, paramBundle);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    this.jdField_e_of_type_Boolean = a("com.tencent.mobileqq:tool");
    this.jdField_c_of_type_Boolean = true;
    paramBundle = (QRProcessManager)this.app.getManager(128);
    paramBundle.a(this.app.c(), System.currentTimeMillis());
    paramBundle.b();
    c();
    return true;
  }
  
  public void e()
  {
    setTitle("阅读中心");
    this.jdField_a_of_type_CooperationQqreaderQRNumberCircleProgressBar = ((QRNumberCircleProgressBar)findViewById(2131372199));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131372201));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_CooperationQqreaderQRPluginBooks = new QRPluginBooks(this);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    int k;
    Object localObject;
    boolean bool;
    if (QRUtility.a(this) == -1)
    {
      k = -1;
      localObject = ((FriendsManager)this.app.getManager(50)).a(this.app.getCurrentAccountUin());
      if (localObject != null) {
        k = ((Card)localObject).shGender;
      }
      if ((k != 0) && (k != 1))
      {
        k = a();
        if (QLog.isColorLevel()) {
          QLog.d("QRBridgeActivity", 2, "set prefer by random " + k);
        }
        ReportController.b(this.app, "P_CliOper", "VIP_QQREADER", "", "0X8005877", "0X8005877", 0, 0, "" + k, "", "", "");
        QRUtility.a(this, k);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("key_params_qq");
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("auto_launch", this.jdField_h_of_type_Boolean);
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qq_adv");
      if (!"action_from_list".equals(this.jdField_a_of_type_AndroidOsBundle.get("action_type"))) {
        break label446;
      }
      if (!QIPCServerHelper.getInstance().isModuleRunning("qqindividuality_plugin.apk")) {
        break label423;
      }
      localObject = new Intent(this, QQIndividualityProxyActivity.class);
      label220:
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject).putExtra(QQIndividualityUtils.l, 1);
      ((Intent)localObject).putExtra(QQIndividualityUtils.jdField_e_of_type_JavaLangString, "path");
      ((Intent)localObject).putExtra(QQIndividualityUtils.jdField_f_of_type_JavaLangString, "name");
      ((Intent)localObject).putExtra("k_source", 3);
      ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ((Intent)localObject).setFlags(67108864);
      if (!QIPCServerHelper.getInstance().isModuleRunning("qqindividuality_plugin.apk")) {
        break label438;
      }
      QQIndividualityProxyActivity.a(this, (Intent)localObject, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, null, -1);
    }
    for (;;)
    {
      finish();
      if (QLog.isDevelopLevel()) {
        QLog.d("QRBridgeActivity", 4, "QRBridgeActivity start EditActivity");
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QRBridgeActivity", 2, "set prefer by gender " + k);
      }
      ReportController.b(this.app, "P_CliOper", "VIP_QQREADER", "", "0X8005876", "0X8005876", 0, 0, "" + k, "", "", "");
      break;
      label423:
      localObject = new Intent(this, QQIndividualityBridgeActivity.class);
      break label220;
      label438:
      startActivity((Intent)localObject);
    }
    label446:
    if ((localObject != null) && (((String)localObject).contains("id")) && (((String)localObject).contains("name")) && (((String)localObject).contains("uin")))
    {
      localObject = ((String)localObject).split("&");
      if (localObject.length >= 3)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readtype=3&");
        localStringBuilder.append(localObject[0]);
        k = localObject[2].indexOf("=");
        this.jdField_a_of_type_JavaLangString = localObject[2].substring(k + 1);
        a(localStringBuilder.toString());
        return;
      }
      a(null);
      return;
    }
    if (bool)
    {
      localObject = new StringBuilder();
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("account");
      ((StringBuilder)localObject).append("readtype=4");
      a(((StringBuilder)localObject).toString());
      return;
    }
    a(null);
  }
  
  public void g()
  {
    if ((!this.jdField_e_of_type_Boolean) && (a()))
    {
      a(this);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1004, 5000L);
      return;
    }
    f();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = 99;
    switch (paramMessage.what)
    {
    case 1003: 
    default: 
    case 1004: 
    case 1000: 
    case 1002: 
    case 1001: 
      do
      {
        do
        {
          return true;
          if (!this.jdField_f_of_type_Boolean)
          {
            this.jdField_f_of_type_Boolean = true;
            f();
          }
        } while (!QLog.isColorLevel());
        QLog.d("QRBridgeActivity", 2, "not have reader process launch BroadcastReceiver");
        return true;
        a(paramMessage.arg1);
        return true;
        int m = this.jdField_a_of_type_CooperationQqreaderQRNumberCircleProgressBar.a();
        if (m < 99) {}
        for (;;)
        {
          a(k);
          return true;
          k = m + 1;
        }
      } while (isFinishing());
      a("qqreaderplugin.apk", this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqreaderplugin.apk"));
      return true;
    }
    b();
    return true;
  }
  
  protected boolean onBackEvent()
  {
    try
    {
      if (this.jdField_a_of_type_CooperationPluginIPluginManager != null)
      {
        localObject = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqreaderplugin.apk");
        if (localObject != null) {
          int k = (int)(((PluginBaseInfo)localObject).mDownloadProgress * 90.0F);
        }
      }
      Object localObject = String.valueOf(this.jdField_g_of_type_Long);
      String str = String.valueOf(System.currentTimeMillis() - this.jdField_h_of_type_Long);
      ReportController.b(this.app, "dc00899", "VIP_QQREADER", "", "0X8007928", "0X8007928", 0, 0, (String)localObject, str, "", "");
      if (QLog.isColorLevel()) {
        QLog.d("QRBridgeActivity", 2, "T1=" + (String)localObject + ",T2=" + str);
      }
    }
    catch (Exception localException)
    {
      label122:
      break label122;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_CooperationQqreaderQRPluginBooks == null) || (this.jdField_a_of_type_OrgJsonJSONObject == null));
    this.jdField_a_of_type_CooperationQqreaderQRPluginBooks.a(this.jdField_a_of_type_OrgJsonJSONObject);
    this.jdField_a_of_type_CooperationQqreaderQRPluginBooks.a();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText("已加书架");
    ReportController.b(this.app, "P_CliOper", "VIP_QQREADER", "", "0X8006C8C", "0X8006C8C", 0, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1004);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
    }
    if ((this.jdField_a_of_type_CooperationPluginIPluginManager == null) || (QLog.isDevelopLevel())) {
      QLog.d("QRBridgeActivity", 4, "QRBridgeActivity onDestroy");
    }
    if (this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver != null) {
      getApplicationContext().unregisterReceiver(this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeActivity
 * JD-Core Version:    0.7.0.1
 */