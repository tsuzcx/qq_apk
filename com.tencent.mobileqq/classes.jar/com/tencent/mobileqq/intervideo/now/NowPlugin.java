package com.tencent.mobileqq.intervideo.now;

import aedk;
import aedl;
import aedm;
import aedn;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.sixgod.pluginsdk.component.ContainerActivity;
import com.sixgod.pluginsdk.log.SGLog;
import com.tencent.biz.now.PluginRecordHelper;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.SixgodLog;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.NowDownloadManager;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.NowDownloadTaskInfo;
import com.tencent.mobileqq.intervideo.now.runtime.NowAppHelper;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.proxyinner.plugin.loader.NowQTServiceProxy;
import com.tencent.proxyinner.utility.LogUploadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.txproxy.HostEventListener;
import com.tencent.txproxy.HostInterface;
import com.tencent.txproxy.InitParam;
import com.tencent.txproxy.RunPluginParams;
import com.tencent.txproxy.XEventListener;
import com.tencent.txproxy.XPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;

public class NowPlugin
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  public Bundle a;
  ContainerActivity jdField_a_of_type_ComSixgodPluginsdkComponentContainerActivity;
  public PluginRecordHelper a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  LoginKeyHelper jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper = new LoginKeyHelper();
  SixgodLog jdField_a_of_type_ComTencentMobileqqIntervideoSixgodLog = new SixgodLog();
  private NowDownloadManager jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager;
  public NowDataReporter a;
  public HostInterface a;
  private XEventListener jdField_a_of_type_ComTencentTxproxyXEventListener = new aedm(this);
  public XPlugin a;
  public String a;
  public List a;
  public boolean a;
  boolean b;
  boolean c = false;
  
  public NowPlugin()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper = new PluginRecordHelper();
    this.jdField_a_of_type_ComTencentTxproxyHostInterface = new aedk(this);
    this.jdField_a_of_type_ComTencentTxproxyXPlugin = XPlugin.getPlugin("Live");
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.setHostInterface(this.jdField_a_of_type_ComTencentTxproxyHostInterface);
  }
  
  public NowPlugin(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper = new PluginRecordHelper();
    this.jdField_a_of_type_ComTencentTxproxyHostInterface = new aedk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter = new NowDataReporter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentTxproxyXPlugin = XPlugin.getPlugin("Live");
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.setHostInterface(this.jdField_a_of_type_ComTencentTxproxyHostInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Intent a()
  {
    Intent localIntent = new Intent();
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(str).longValue();
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.d("XProxy|NowProxy", 2, "getCurrentAccountUin can not convert to long");
      }
    }
    localIntent.putExtra("platform", 2);
    localIntent.putExtra("QQ", l1);
    if (localTicketManager.getA2(str) != null) {
      localIntent.putExtra("A2", HexUtil.a(localTicketManager.getA2(str)));
    }
    localIntent.putExtra("STKEY", localTicketManager.getStkey(str, 16));
    localIntent.putExtra("ST", localTicketManager.getSt(str, 16));
    if (localTicketManager.getSkey(str) != null) {
      localIntent.putExtra("SKEY", localTicketManager.getSkey(str).getBytes());
    }
    localIntent.putExtra("WTAPPID", 16L);
    localIntent.putExtra("withlogin", true);
    return localIntent;
  }
  
  private String a(String paramString1, String paramString2, Bundle paramBundle)
  {
    String str = "h5";
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("qzone"))) {
      paramString1 = "plugin";
    }
    do
    {
      return paramString1;
      if (paramString1.equals("8001")) {
        return "plugin";
      }
      paramString1 = str;
    } while (paramBundle == null);
    return paramBundle.getString("first_jump_mode", "h5");
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    g();
    this.jdField_a_of_type_Int = paramInt;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.install(paramBundle);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.loadPlugin(null);
      return;
    }
    paramBundle = new Bundle();
    paramBundle.putString("pkgname", BaseApplicationImpl.getContext().getPackageName());
    paramBundle.putString("appid", String.valueOf(2));
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.loadPlugin(paramBundle);
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      if (paramLong != 0L) {
        break label262;
      }
    }
    label262:
    for (str = "https://now.qq.com/qq/play.html?_bid=2374&_wv=16778245&from=50320";; str = "https://now.qq.com/h5/index.html?_bid=2336&_wv=16778245&from=50320&roomid=" + paramLong)
    {
      long l = System.currentTimeMillis();
      paramString1 = str + "&fromid=" + this.jdField_a_of_type_JavaLangString + "&_t=" + l;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(this.jdField_a_of_type_JavaLangString, String.valueOf(paramLong), paramString2, paramString1);
      paramString2 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      paramString2.putExtra("hide_operation_bar", true);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("op_type", "now_live");
      paramString2.putExtra("key_isReadModeEnabled", true);
      paramString2.setFlags(268435456);
      paramString2.putExtra("insertPluginsArray", new String[] { "nowlive" });
      QLog.i("XProxy|NowProxy", 1, "跳转web页面 URL = " + paramString1 + " time = " + l);
      WebAccelerator.a(BaseApplicationImpl.getContext(), paramString2, paramString1);
      paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (IVPluginEvtListener)paramString1.next();
        if (paramString2 != null) {
          paramString2.a("Live");
        }
      }
    }
  }
  
  private void a(NowProxy.ListNameData paramListNameData, long paramLong, int paramInt, String paramString, Bundle paramBundle)
  {
    boolean bool1 = PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.now");
    boolean bool2 = paramBundle.getBoolean("jump_now_switch", false);
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tnow2://openpage/anchor?roomid=" + paramLong + "&fromid=" + paramString + "&startsource=" + paramString));
    localIntent.setFlags(268435456);
    ComponentName localComponentName = localIntent.resolveActivity(BaseApplicationImpl.getContext().getPackageManager());
    int i = 1;
    if ((bool2) && (bool1) && (localComponentName != null))
    {
      localIntent.putExtras(paramBundle);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      paramInt = i;
      if (paramInt == 0) {
        break label230;
      }
      paramListNameData = "1";
      label148:
      if (!paramString.equals("kandian_video")) {
        break label237;
      }
    }
    label230:
    label237:
    for (paramString = "1";; paramString = "0")
    {
      PublicAccountReportUtils.a(null, "", "0X80083C9", "0X80083C9", 0, 0, paramListNameData, paramString, "", "", false);
      return;
      if ((bool1) && (paramInt == 1))
      {
        c(paramBundle);
        paramInt = i;
        break;
      }
      b(paramListNameData, paramLong, paramString, paramBundle);
      paramInt = 0;
      break;
      paramListNameData = "0";
      break label148;
    }
  }
  
  /* Error */
  private void a(NowProxy.ListNameData paramListNameData, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 97	android/content/Intent
    //   3: dup
    //   4: invokestatic 244	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: ldc_w 438
    //   10: invokespecial 296	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   13: astore 8
    //   15: aconst_null
    //   16: astore 4
    //   18: aload_1
    //   19: ifnull +23 -> 42
    //   22: aload_1
    //   23: getfield 443	com/tencent/mobileqq/intervideo/now/NowProxy$ListNameData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   26: astore 4
    //   28: aload 4
    //   30: aload_1
    //   31: getfield 444	com/tencent/mobileqq/intervideo/now/NowProxy$ListNameData:jdField_a_of_type_Int	I
    //   34: invokevirtual 448	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   37: checkcast 163	java/lang/String
    //   40: astore 7
    //   42: aload 4
    //   44: ifnull +54 -> 98
    //   47: aload 4
    //   49: invokevirtual 452	java/util/ArrayList:size	()I
    //   52: ifle +46 -> 98
    //   55: aload_0
    //   56: getfield 454	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   59: ldc_w 456
    //   62: aload 4
    //   64: invokevirtual 460	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   67: aload_0
    //   68: getfield 454	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   71: ldc_w 462
    //   74: aload_1
    //   75: getfield 444	com/tencent/mobileqq/intervideo/now/NowProxy$ListNameData:jdField_a_of_type_Int	I
    //   78: invokevirtual 466	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   81: aload_0
    //   82: getfield 454	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   85: ldc_w 468
    //   88: aload_0
    //   89: getfield 84	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: invokevirtual 470	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   95: invokevirtual 253	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 8
    //   100: aload_0
    //   101: getfield 454	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   104: invokevirtual 412	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   107: pop
    //   108: iload 5
    //   110: ifeq +24 -> 134
    //   113: aload 8
    //   115: ldc_w 472
    //   118: iconst_1
    //   119: invokevirtual 176	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   122: pop
    //   123: aload 8
    //   125: ldc_w 474
    //   128: iload 6
    //   130: invokevirtual 176	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   133: pop
    //   134: aload 8
    //   136: ldc_w 476
    //   139: aload_0
    //   140: getfield 478	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo	Lcom/tencent/mobileqq/intervideo/IVPluginInfo;
    //   143: invokevirtual 481	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   146: pop
    //   147: aload 8
    //   149: ldc_w 310
    //   152: invokevirtual 484	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   155: pop
    //   156: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +32 -> 191
    //   162: ldc_w 489
    //   165: iconst_4
    //   166: new 268	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 491
    //   176: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   182: invokevirtual 282	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   185: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 328	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: invokestatic 495	com/tencent/mobileqq/intervideo/now/NowPerfUtil:a	()V
    //   194: invokestatic 244	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   197: aload 8
    //   199: invokevirtual 416	com/tencent/qphone/base/util/BaseApplication:startActivity	(Landroid/content/Intent;)V
    //   202: return
    //   203: astore 7
    //   205: aconst_null
    //   206: astore 4
    //   208: aload 7
    //   210: invokevirtual 498	java/lang/Exception:printStackTrace	()V
    //   213: goto -171 -> 42
    //   216: astore 7
    //   218: goto -10 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	NowPlugin
    //   0	221	1	paramListNameData	NowProxy.ListNameData
    //   0	221	2	paramLong	long
    //   0	221	4	paramBundle	Bundle
    //   0	221	5	paramBoolean1	boolean
    //   0	221	6	paramBoolean2	boolean
    //   40	1	7	str	String
    //   203	6	7	localException1	Exception
    //   216	1	7	localException2	Exception
    //   13	185	8	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   22	28	203	java/lang/Exception
    //   28	42	216	java/lang/Exception
  }
  
  private void a(NowProxy.ListNameData paramListNameData, long paramLong, String paramString, int paramInt, Bundle paramBundle)
  {
    if (("kandian_video".equals(paramString)) || ("kandian_shouye".equals(paramString))) {
      a(paramListNameData, paramLong, paramInt, paramString, paramBundle);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        if (NowAppHelper.a())
        {
          c(paramBundle);
          return;
        }
        a(paramListNameData, paramLong, this.jdField_a_of_type_JavaLangString, paramBundle);
        return;
      }
    } while (paramInt != 2);
    a(paramListNameData, paramLong, this.jdField_a_of_type_JavaLangString, paramBundle);
  }
  
  private void a(NowProxy.ListNameData paramListNameData, long paramLong, String paramString, Bundle paramBundle)
  {
    QLog.i("XProxy|NowProxy", 1, "dispatchToNowPlugin mBizFromId = " + paramString);
    String str1 = NowProxyParamParser.b(paramBundle);
    String str2 = NowProxyParamParser.f(paramBundle);
    if (str1.equals("1"))
    {
      QLog.i("XProxy|NowProxy", 1, "入口处已经明确指定是录播,直接跳转h5页面");
      paramListNameData = this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.a(NowProxyParamParser.a(str2));
      a(paramLong, paramListNameData + "&" + NowProxyParamParser.g(paramBundle), "record");
      return;
    }
    if (str1.equals("2"))
    {
      QLog.i("XProxy|NowProxy", 1, "入口处已经明确指定是直播，直接跳转结合版房间");
      b(paramListNameData, paramLong, paramString, paramBundle);
      return;
    }
    if (a(this.jdField_a_of_type_JavaLangString, paramBundle))
    {
      QLog.i("XProxy|NowProxy", 1, "入口处不知道开播状态，需要先走cgi拉取录播信息");
      this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.a(paramLong, new aedl(this, paramLong, paramListNameData, paramString, paramBundle), this.jdField_a_of_type_ComTencentTxproxyHostInterface);
      return;
    }
    b(paramListNameData, paramLong, paramString, paramBundle);
  }
  
  private void a(String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    QLog.e("XProxy|NowProxy", 4, "handleDownloadTaskByNowEngine----url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager = new NowDownloadManager();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager.a(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager.a(paramString1, new aedn(this, paramHostEventListener, paramString1));
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager.a(NowDownloadTaskInfo.a(paramString1, "com.tencent.now", paramString2));
  }
  
  private boolean a(String paramString, Bundle paramBundle)
  {
    if (!NowProxyParamParser.a(paramBundle)) {}
    for (;;)
    {
      return false;
      if ((paramString.equals("10001")) || (paramString.equals("10002"))) {}
      for (int i = 1; (i == 0) && (!paramBundle.getString("roomtype", "").equals("8001")); i = 0) {
        return paramBundle.getBoolean("need_record", true);
      }
    }
  }
  
  private void b(NowProxy.ListNameData paramListNameData, long paramLong, String paramString, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    QLog.i("XProxy|NowProxy", 1, "jumpToNowPluginFirst mBizFromId = " + paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      QLog.e("XProxy|NowProxy", 1, "mApp  is null!!!");
    }
    boolean bool3;
    do
    {
      return;
      bool3 = this.jdField_a_of_type_ComTencentTxproxyXPlugin.hasLocalPlugin();
      if (bool3) {
        break;
      }
      paramString = a(paramBundle.getString("roomtype", ""), paramString, paramBundle);
      QLog.i("XProxy|NowProxy", 1, "本地还没有插件，firstJumpMode＝" + paramString);
      if (this.jdField_a_of_type_JavaLangString.startsWith("kandian"))
      {
        if (paramLong == 0L) {}
        for (paramListNameData = "https://now.qq.com/qq/play.html?_bid=2374&_wv=16778245&from=50320";; paramListNameData = "https://now.qq.com/h5/index.html?_bid=2336&_wv=16778245&from=50320&roomid=" + paramLong)
        {
          a(paramLong, paramListNameData + "&_cf=3", "kandian");
          b(BaseApplicationImpl.getContext());
          return;
        }
      }
      if (paramString.equals("h5"))
      {
        a(paramLong, paramBundle.getString("url"), "first_download");
        b(BaseApplicationImpl.getContext());
        return;
      }
    } while (!paramString.equals("plugin"));
    paramBundle.putBoolean("hasplugin", bool3);
    if (this.jdField_a_of_type_ComTencentTxproxyXPlugin.getStatus() >= 6) {}
    for (;;)
    {
      paramBundle.putBoolean("isloaded", bool1);
      a(paramListNameData, paramLong, paramBundle);
      return;
      bool1 = false;
    }
    QLog.i("XProxy|NowProxy", 1, "本地已经下载插件，直接跳转结合版");
    paramBundle.putBoolean("hasplugin", bool3);
    if (this.jdField_a_of_type_ComTencentTxproxyXPlugin.getStatus() >= 6) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramBundle.putBoolean("isloaded", bool1);
      a(paramListNameData, paramLong, paramBundle);
      return;
    }
  }
  
  private void c(Bundle paramBundle)
  {
    QLog.i("XProxy|NowProxy", 1, "已安装了独立app，直接跳转");
    Object localObject = NowProxyParamParser.a(paramBundle);
    long l = NowProxyParamParser.a(paramBundle);
    String str = NowProxyParamParser.d(paramBundle);
    paramBundle.putAll(a().getExtras());
    paramBundle = NowAppHelper.a(str, String.valueOf(l), paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.b(str, String.valueOf(l), (String)localObject, paramBundle);
    paramBundle = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (IVPluginEvtListener)paramBundle.next();
      if (localObject != null) {
        ((IVPluginEvtListener)localObject).a("Live");
      }
    }
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      InitParam localInitParam = new InitParam();
      localInitParam.mPluginName = "now";
      localInitParam.mChannelId = String.valueOf(2);
      localInitParam.mSourceVersion = String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext()));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        localInitParam.mSourceId = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      localInitParam.isLogInHost = true;
      localInitParam.isDataReportInHost = true;
      localInitParam.mMoveSoFileInHost = true;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        localInitParam.mDownloadEngine = ((NowDownloadEngineManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(266)).a();
      }
      if (this.jdField_a_of_type_ComSixgodPluginsdkComponentContainerActivity == null)
      {
        localInitParam.mDefaultLoadApkActivity = "com.tencent.proxyinner.plugin.loader.NowQTServiceProxy";
        localInitParam.mLoadApkActivityClazz = NowQTServiceProxy.class;
      }
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.setInitData(BaseApplicationImpl.getContext(), localInitParam);
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.registerPluginMsgCmd("login.qq.kickout");
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.registerPluginMsgCmd("com.tencent.now.sharetoqq");
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.registerPluginMsgCmd("now.room.destroy");
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.registerPluginMsgCmd("action.now.showloading");
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.registerPluginMsgCmd("action.now.datareport");
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.registerPluginMsgCmd("action.now.removeoutloading");
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.registerPluginMsgCmd("action.now.roomactivity.create");
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.registerPluginMsgCmd("action.now.updateplugin");
      this.b = this.jdField_a_of_type_ComTencentTxproxyXPlugin.hasLocalPlugin();
      QLog.i("XProxy|NowProxy", 2, "addEventListener listener = " + this.jdField_a_of_type_ComTencentTxproxyXEventListener);
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.addEventListener(this.jdField_a_of_type_ComTencentTxproxyXEventListener);
      SGLog.init(this.jdField_a_of_type_ComTencentMobileqqIntervideoSixgodLog);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public int a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      g();
    }
    try
    {
      int i = this.jdField_a_of_type_ComTencentTxproxyXPlugin.getStatus();
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowProxy", 2, "NowPlugin onDestroy");
    }
    c();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter = null;
  }
  
  public void a(Bundle paramBundle)
  {
    if (a())
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tnow://openpage/startlive?from=1"));
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      localIntent.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
    a(0L, "http://a.app.qq.com/o/simple.jsp?pkgname=com.tencent.now&ckey=CK1339000284644", "beginLive");
  }
  
  public void a(IVPluginEvtListener paramIVPluginEvtListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramIVPluginEvtListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramIVPluginEvtListener);
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.cancelRunPlugin(paramString);
  }
  
  public boolean a()
  {
    return PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.now");
  }
  
  public boolean a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy_Perf", 2, "开始预加载Now插件 time = " + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return false;
      g();
    } while ((!NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) && (!this.jdField_a_of_type_ComTencentTxproxyXPlugin.hasLocalPlugin()));
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.loadPlugin(null);
    return true;
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowProxy", 2, "install now start ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (!NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {
      return false;
    }
    a(1, paramBundle);
    return true;
  }
  
  public boolean a(NowProxy.ListNameData paramListNameData, long paramLong, Bundle paramBundle)
  {
    QLog.i("XProxy_Perf", 2, "开始启动Now插件 time = " + System.currentTimeMillis());
    this.jdField_a_of_type_Int = 4;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    String str1 = paramBundle.getString("roomtype", "");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(this.jdField_a_of_type_ComTencentTxproxyXPlugin.hasLocalPlugin(), this.jdField_a_of_type_JavaLangString, String.valueOf(paramLong), str1);
    IVPluginInfo localIVPluginInfo = new IVPluginInfo();
    int i = (int)(Math.random() * 1.0D + 0.5D);
    String str2 = paramBundle.getString("storyid", "");
    Object localObject1 = "";
    if (paramListNameData != null) {}
    for (;;)
    {
      try
      {
        localObject2 = (String)paramListNameData.jdField_a_of_type_JavaUtilArrayList.get(paramListNameData.jdField_a_of_type_Int);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        localException.printStackTrace();
        continue;
      }
      paramBundle.putInt("updateflag", 1);
      localObject2 = new StringBuilder("roomnow://openpage/anchor?");
      ((StringBuilder)localObject2).append("roomid=").append(paramLong).append("&listname=").append((String)localObject1).append("&topicname=").append((String)localObject1).append("&from=").append(this.jdField_a_of_type_JavaLangString).append("&storyid=").append(str2).append("&bizfrom=").append(this.jdField_a_of_type_JavaLangString).append("&qqversion=").append(String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext()))).append("&qquin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()).append("&roomtype=").append(str1);
      localIVPluginInfo.f = ((StringBuilder)localObject2).toString();
      localIVPluginInfo.jdField_a_of_type_Long = paramLong;
      localIVPluginInfo.jdField_b_of_type_Int = i;
      localIVPluginInfo.e = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      localIVPluginInfo.jdField_b_of_type_JavaLangString = "1600000615";
      localIVPluginInfo.c = "com.tencent.now";
      localIVPluginInfo.jdField_a_of_type_JavaLangString = "Live";
      this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = localIVPluginInfo;
      a(paramListNameData, paramLong, paramBundle, false, false);
      return true;
      localObject1 = "";
    }
  }
  
  public boolean a(NowProxy.ListNameData paramListNameData, long paramLong, String paramString, int paramInt, Bundle paramBundle)
  {
    boolean bool = NetworkUtil.g(BaseApplicationImpl.getContext());
    if (!bool)
    {
      Toast.makeText(BaseApplicationImpl.getContext(), "当前网络不可用，请稍候再试", 0).show();
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L)
    {
      QLog.i("XProxy_Perf", 1, "开始处理mqq　scheme,time = " + System.currentTimeMillis() + " 点太快了");
      Toast.makeText(BaseApplicationImpl.getContext(), "你点得太快啦~", 0).show();
      return true;
    }
    this.jdField_a_of_type_Long = l;
    QLog.i("XProxy_Perf", 1, "开始进入now结合版,time = " + System.currentTimeMillis() + " roomid = " + paramLong + "ListNames = " + paramListNameData + "jumpFirst = " + paramInt + "fromidForDataReport = " + this.jdField_a_of_type_JavaLangString);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = NowProxyParamParser.a(localBundle);
    if (this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.a())
    {
      Toast.makeText(BaseApplicationImpl.getContext(), "正在进入直播房间中，请耐心等候", 0).show();
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.b(false, paramString, String.valueOf(paramLong), paramBundle, bool, false);
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(false, paramString, String.valueOf(paramLong), paramBundle, bool, false);
    localBundle.putLong("entryTime", System.currentTimeMillis());
    return b(paramListNameData, paramLong, this.jdField_a_of_type_JavaLangString, paramInt, localBundle);
  }
  
  protected boolean a(boolean paramBoolean)
  {
    QLog.i("XProxy_Perf", 2, "jumpToNowPlugin time = " + System.currentTimeMillis());
    this.c = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo == null) {
      return false;
    }
    RunPluginParams localRunPluginParams = new RunPluginParams();
    localRunPluginParams.mRoomId = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_Long;
    localRunPluginParams.mFromId = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.e;
    localRunPluginParams.mPackageName = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.c;
    localRunPluginParams.useDefaultLoading = false;
    localRunPluginParams.vasSchema = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.f;
    localRunPluginParams.mLauncherName = "com.tencent.litelive.module.videoroom.RoomActivity";
    Intent localIntent = a();
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    localIntent.putExtra("bkgid", this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_b_of_type_Int);
    localRunPluginParams.intent = localIntent;
    QLog.i("XProxy_Perf", 2, "runPlugin time = " + System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.runPlugin(localRunPluginParams);
    return true;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)localIterator.next();
      if (localIVPluginEvtListener != null)
      {
        QLog.i("XProxy|NowProxy", 2, "notifyNowRoomDestroyed");
        localIVPluginEvtListener.c("Live");
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    long l = paramBundle.getLong("roomid");
    paramBundle.getLong("roomtype");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(this.jdField_a_of_type_JavaLangString, String.valueOf(l), paramBundle);
  }
  
  public void b(IVPluginEvtListener paramIVPluginEvtListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramIVPluginEvtListener);
  }
  
  public boolean b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy_Perf", 2, "开始预登录Now插件 time = " + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return false;
      g();
    } while ((!NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) && (!this.jdField_a_of_type_ComTencentTxproxyXPlugin.hasLocalPlugin()));
    this.jdField_a_of_type_Int = 3;
    paramContext = new Bundle();
    paramContext.putString("pkgname", BaseApplicationImpl.getContext().getPackageName());
    paramContext.putString("appid", String.valueOf(2));
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.loadPlugin(paramContext);
    return true;
  }
  
  public boolean b(NowProxy.ListNameData paramListNameData, long paramLong, String paramString, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      if (QLog.isColorLevel()) {
        QLog.i("XProxy_Perf", 2, "API 16以下的系统，直接跳转H5");
      }
      a(paramLong, null, "low_android_version");
      return true;
    }
    if (Build.VERSION.SDK_INT > 27)
    {
      if (QLog.isColorLevel()) {
        QLog.i("XProxy|NowProxy", 1, "大于8.1的系统未兼容前跳转h5");
      }
      a(paramLong, null, "high_android_version");
      return true;
    }
    g();
    if (paramInt == 3)
    {
      paramListNameData = "";
      if (paramBundle != null) {
        paramListNameData = paramBundle.getString("url");
      }
      a(paramLong, paramListNameData, "first_h5");
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("XProxy|NowProxy", 1, "mApp  is null!!!");
      return false;
    }
    a(paramListNameData, paramLong, paramString, paramInt, paramBundle);
    return true;
  }
  
  public void c()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName(BaseApplicationImpl.getContext().getPackageName(), "com.tencent.proxyinner.plugin.loader.NowQTServiceProxy"));
      BaseApplicationImpl.getContext().stopService(localIntent);
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.unload(Boolean.valueOf(true));
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.removeListener(this.jdField_a_of_type_ComTencentTxproxyXEventListener);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    BaseApplicationImpl.getContext().sendBroadcast(new Intent("room.close.audio"));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      LogUploadUtil.upload(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    }
  }
  
  public void f()
  {
    if (a())
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tnow://openpage/recordstory?from=1"));
      localIntent.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
    a(0L, "http://a.app.qq.com/o/simple.jsp?pkgname=com.tencent.now&ckey=CK1339000284644", "recordstory");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowPlugin
 * JD-Core Version:    0.7.0.1
 */