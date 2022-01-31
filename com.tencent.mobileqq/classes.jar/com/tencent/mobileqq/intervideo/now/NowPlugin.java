package com.tencent.mobileqq.intervideo.now;

import adlc;
import adld;
import adle;
import adlf;
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
import com.tencent.biz.now.CgiHelper;
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
  CgiHelper jdField_a_of_type_ComTencentBizNowCgiHelper = new CgiHelper();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  LoginKeyHelper jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper = new LoginKeyHelper();
  SixgodLog jdField_a_of_type_ComTencentMobileqqIntervideoSixgodLog = new SixgodLog();
  private NowDownloadManager jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager;
  public NowDataReporter a;
  public NowFromData a;
  protected HostInterface a;
  private XEventListener jdField_a_of_type_ComTencentTxproxyXEventListener = new adle(this);
  XPlugin jdField_a_of_type_ComTencentTxproxyXPlugin;
  public List a;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  boolean c = false;
  
  public NowPlugin()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentTxproxyHostInterface = new adlc(this);
    this.jdField_a_of_type_ComTencentTxproxyXPlugin = XPlugin.getPlugin("Live");
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.setHostInterface(this.jdField_a_of_type_ComTencentTxproxyHostInterface);
  }
  
  public NowPlugin(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentTxproxyHostInterface = new adlc(this);
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
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
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
  
  private void a(long paramLong, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("startsrc");
    String str = paramBundle.getString("roomtype", "");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString, String.valueOf(paramLong), str, "");
    if (TextUtils.isEmpty(str)) {}
    for (localObject = "tnow://openpage/anchor?roomid=" + paramLong + "&fromid=" + this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString + "&startsrc=" + (String)localObject;; localObject = "tnow://openpage/enterroom?roomid=" + paramLong + "&roomtype=" + str + "&fromid=" + this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString + "&startsrc=" + (String)localObject)
    {
      QLog.i("XProxy|NowProxy", 1, "开始跳转NOW独立版，scheme = " + (String)localObject);
      localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
      ((Intent)localObject).putExtras(a());
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      ((Intent)localObject).setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity((Intent)localObject);
      paramBundle = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (IVPluginEvtListener)paramBundle.next();
        if (localObject != null) {
          ((IVPluginEvtListener)localObject).a("Live");
        }
      }
    }
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      if (paramLong != 0L) {
        break label268;
      }
    }
    label268:
    for (str = "https://now.qq.com/qq/play.html?_bid=2374&_wv=16778245&from=50320";; str = "https://now.qq.com/h5/index.html?_bid=2336&_wv=16778245&from=50320&roomid=" + paramLong)
    {
      long l = System.currentTimeMillis();
      paramString1 = str + "&fromid=" + this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString + "&_t=" + l;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString, String.valueOf(paramLong), paramString2, paramString1);
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
  
  private void a(NowProxy.ListNameData paramListNameData, long paramLong, int paramInt, NowFromData paramNowFromData, Bundle paramBundle)
  {
    boolean bool2 = PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.now");
    boolean bool1 = false;
    if (paramBundle != null) {
      bool1 = paramBundle.getBoolean("jump_now_switch", false);
    }
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tnow2://openpage/anchor?roomid=" + paramLong + "&fromid=" + paramNowFromData.jdField_a_of_type_JavaLangString + "&startsource=" + paramNowFromData.jdField_a_of_type_JavaLangString));
    localIntent.setFlags(268435456);
    ComponentName localComponentName = localIntent.resolveActivity(BaseApplicationImpl.getContext().getPackageManager());
    if ((bool1) && (bool2) && (localComponentName != null))
    {
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      BaseApplicationImpl.getContext().startActivity(localIntent);
      paramInt = 1;
      if (paramInt == 0) {
        break label251;
      }
      paramListNameData = "1";
      label163:
      if (!paramNowFromData.jdField_b_of_type_JavaLangString.equals("kandian_video")) {
        break label258;
      }
    }
    label258:
    for (paramNowFromData = "1";; paramNowFromData = "0")
    {
      PublicAccountReportUtils.a(null, "", "0X80083C9", "0X80083C9", 0, 0, paramListNameData, paramNowFromData, "", "", false);
      return;
      if ((bool2) && (paramInt == 1))
      {
        a(paramLong, paramBundle);
        paramInt = 1;
        break;
      }
      a(paramListNameData, paramLong, paramNowFromData.jdField_a_of_type_JavaLangString, paramBundle);
      paramInt = 0;
      break;
      label251:
      paramListNameData = "0";
      break label163;
    }
  }
  
  /* Error */
  private void a(NowProxy.ListNameData paramListNameData, long paramLong, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 97	android/content/Intent
    //   3: dup
    //   4: invokestatic 250	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: ldc_w 468
    //   10: invokespecial 375	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   13: astore 6
    //   15: aconst_null
    //   16: astore 4
    //   18: aload_1
    //   19: ifnull +23 -> 42
    //   22: aload_1
    //   23: getfield 473	com/tencent/mobileqq/intervideo/now/NowProxy$ListNameData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   26: astore 4
    //   28: aload 4
    //   30: aload_1
    //   31: getfield 474	com/tencent/mobileqq/intervideo/now/NowProxy$ListNameData:jdField_a_of_type_Int	I
    //   34: invokevirtual 478	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   37: checkcast 163	java/lang/String
    //   40: astore 5
    //   42: aload 4
    //   44: ifnull +54 -> 98
    //   47: aload 4
    //   49: invokevirtual 482	java/util/ArrayList:size	()I
    //   52: ifle +46 -> 98
    //   55: aload_0
    //   56: getfield 178	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   59: ldc_w 484
    //   62: aload 4
    //   64: invokevirtual 488	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   67: aload_0
    //   68: getfield 178	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   71: ldc_w 490
    //   74: aload_1
    //   75: getfield 474	com/tencent/mobileqq/intervideo/now/NowProxy$ListNameData:jdField_a_of_type_Int	I
    //   78: invokevirtual 494	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   81: aload_0
    //   82: getfield 178	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   85: ldc_w 496
    //   88: aload_0
    //   89: getfield 84	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: invokevirtual 498	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   95: invokevirtual 259	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 6
    //   100: aload_0
    //   101: getfield 178	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   104: invokevirtual 182	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   107: pop
    //   108: aload 6
    //   110: ldc_w 500
    //   113: aload_0
    //   114: getfield 502	com/tencent/mobileqq/intervideo/now/NowPlugin:jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo	Lcom/tencent/mobileqq/intervideo/IVPluginInfo;
    //   117: invokevirtual 505	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   120: pop
    //   121: aload 6
    //   123: ldc_w 325
    //   126: invokevirtual 508	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   129: pop
    //   130: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +32 -> 165
    //   136: ldc_w 513
    //   139: iconst_4
    //   140: new 288	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 515
    //   150: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokestatic 366	java/lang/System:currentTimeMillis	()J
    //   156: invokevirtual 298	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   159: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 310	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: invokestatic 519	com/tencent/mobileqq/intervideo/now/NowPerfUtil:d	()V
    //   168: invokestatic 250	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   171: aload 6
    //   173: invokevirtual 333	com/tencent/qphone/base/util/BaseApplication:startActivity	(Landroid/content/Intent;)V
    //   176: return
    //   177: astore 5
    //   179: aconst_null
    //   180: astore 4
    //   182: aload 5
    //   184: invokevirtual 522	java/lang/Exception:printStackTrace	()V
    //   187: goto -145 -> 42
    //   190: astore 5
    //   192: goto -10 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	NowPlugin
    //   0	195	1	paramListNameData	NowProxy.ListNameData
    //   0	195	2	paramLong	long
    //   0	195	4	paramBundle	Bundle
    //   40	1	5	str	String
    //   177	6	5	localException1	Exception
    //   190	1	5	localException2	Exception
    //   13	159	6	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   22	28	177	java/lang/Exception
    //   28	42	190	java/lang/Exception
  }
  
  private void a(NowProxy.ListNameData paramListNameData, long paramLong, NowFromData paramNowFromData, int paramInt, Bundle paramBundle)
  {
    if (("kandian_video".equals(paramNowFromData.jdField_b_of_type_JavaLangString)) || ("kandian_shouye".equals(paramNowFromData.jdField_b_of_type_JavaLangString))) {
      a(paramListNameData, paramLong, paramInt, paramNowFromData, paramBundle);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        NowPerfUtil.b();
        boolean bool = PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.now");
        NowPerfUtil.c();
        if (bool)
        {
          QLog.i("XProxy|NowProxy", 1, "已安装了独立app，直接跳转");
          a(paramLong, paramBundle);
          return;
        }
        a(paramListNameData, paramLong, paramNowFromData.jdField_a_of_type_JavaLangString, paramBundle);
        return;
      }
    } while (paramInt != 2);
    a(paramListNameData, paramLong, paramNowFromData.jdField_a_of_type_JavaLangString, paramBundle);
  }
  
  private void a(NowProxy.ListNameData paramListNameData, long paramLong, String paramString, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    QLog.i("XProxy|NowProxy", 1, "jumpToNowPluginFirst mBizFromId = " + this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_b_of_type_JavaLangString + "fromForDaraReport = " + this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      QLog.e("XProxy|NowProxy", 1, "mApp  is null!!!");
    }
    boolean bool3;
    do
    {
      return;
      String str = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString;
      bool3 = this.jdField_a_of_type_ComTencentTxproxyXPlugin.hasLocalPlugin();
      if (bool3) {
        break;
      }
      paramString = a(paramBundle.getString("roomtype", ""), paramString, paramBundle);
      QLog.i("XProxy|NowProxy", 1, "本地还没有插件，firstJumpMode＝" + paramString);
      if (str.startsWith("kandian"))
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
  
  private void a(String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    QLog.e("XProxy|NowProxy", 4, "handleDownloadTaskByNowEngine----url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager = new NowDownloadManager();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager.a(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager.a(paramString1, new adlf(this, paramHostEventListener, paramString1));
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager.a(NowDownloadTaskInfo.a(paramString1, "com.tencent.now", paramString2));
  }
  
  private boolean a(String paramString, Bundle paramBundle)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString.equals("10001")) || (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString.equals("10002")))
    {
      i = 1;
      if (i == 0) {
        break label45;
      }
    }
    label45:
    while (paramBundle.getString("roomtype", "").equals("8001"))
    {
      return false;
      i = 0;
      break;
    }
    return paramBundle.getBoolean("need_record", true);
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
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(this.jdField_a_of_type_ComTencentTxproxyXPlugin.hasLocalPlugin(), this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString, String.valueOf(paramLong), str1);
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
      localObject2 = new StringBuilder("roomnow://openpage/anchor?");
      ((StringBuilder)localObject2).append("roomid=").append(paramLong).append("&listname=").append((String)localObject1).append("&topicname=").append((String)localObject1).append("&from=").append(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString).append("&storyid=").append(str2).append("&bizfrom=").append(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_b_of_type_JavaLangString).append("&qqversion=").append(String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext()))).append("&qquin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()).append("&roomtype=").append(str1);
      localIVPluginInfo.f = ((StringBuilder)localObject2).toString();
      localIVPluginInfo.jdField_a_of_type_Long = paramLong;
      localIVPluginInfo.jdField_b_of_type_Int = i;
      localIVPluginInfo.e = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      localIVPluginInfo.jdField_b_of_type_JavaLangString = "1600000615";
      localIVPluginInfo.c = "com.tencent.now";
      localIVPluginInfo.jdField_a_of_type_JavaLangString = "Live";
      this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = localIVPluginInfo;
      a(paramListNameData, paramLong, paramBundle);
      return true;
      localObject1 = "";
    }
  }
  
  public boolean a(NowProxy.ListNameData paramListNameData, long paramLong, NowFromData paramNowFromData, int paramInt, Bundle paramBundle)
  {
    NowPerfUtil.a();
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L)
    {
      QLog.i("XProxy_Perf", 1, "开始进入now结合版,time = " + System.currentTimeMillis() + " 点太快了");
      Toast.makeText(BaseApplicationImpl.getContext(), "你点得太快啦~", 0).show();
      return true;
    }
    this.jdField_a_of_type_Long = l;
    if (paramNowFromData == null) {
      paramNowFromData = new NowFromData();
    }
    for (;;)
    {
      QLog.i("XProxy_Perf", 1, "开始进入now结合版,time = " + System.currentTimeMillis() + " roomid = " + paramLong + "ListNames = " + paramListNameData + "jumpFirst = " + paramInt + "fromidForDataReport = " + paramNowFromData.jdField_a_of_type_JavaLangString + "bizFromId = " + paramNowFromData.jdField_b_of_type_JavaLangString);
      if (paramBundle == null) {
        paramBundle = new Bundle();
      }
      for (;;)
      {
        paramBundle.putLong("entryTime", System.currentTimeMillis());
        return b(paramListNameData, paramLong, paramNowFromData, paramInt, paramBundle);
      }
    }
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
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString, String.valueOf(l), paramBundle);
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
  
  public boolean b(NowProxy.ListNameData paramListNameData, long paramLong, NowFromData paramNowFromData, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData = paramNowFromData;
    boolean bool = NetworkUtil.g(BaseApplicationImpl.getContext());
    String str = paramBundle.getString("roomtype", "");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(false, paramNowFromData.jdField_a_of_type_JavaLangString, String.valueOf(paramLong), str, bool, false);
    if (!bool)
    {
      Toast.makeText(BaseApplicationImpl.getContext(), "当前网络不可用，请稍候再试", 0).show();
      return false;
    }
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
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        QLog.e("XProxy|NowProxy", 1, "mApp  is null!!!");
        return false;
      }
      if (a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.jdField_a_of_type_JavaLangString, paramBundle)) {
        this.jdField_a_of_type_ComTencentBizNowCgiHelper.a(paramLong, new adld(this, paramLong, paramListNameData, paramNowFromData, paramInt, paramBundle), this.jdField_a_of_type_ComTencentTxproxyHostInterface);
      } else {
        a(paramListNameData, paramLong, paramNowFromData, paramInt, paramBundle);
      }
    }
  }
  
  protected void c()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowPlugin
 * JD-Core Version:    0.7.0.1
 */