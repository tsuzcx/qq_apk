package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.kandian.base.utils.RIJDisplayStyleManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeReporter;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class ReadinjoySPEventReport
{
  private static long J;
  private static long K = System.currentTimeMillis();
  public static final long a = ;
  public static long e;
  private static volatile ReadinjoySPEventReport h;
  private static long k = 0L;
  private static long l = 0L;
  private static long m = 0L;
  private static int n = 0;
  private static boolean o;
  private static long p;
  private static long q;
  private static long r;
  private static int s;
  private static boolean t;
  private static long u;
  private static boolean v;
  private static boolean w;
  private static ReadinjoySPEventReport.ScreenReceiver x;
  private static volatile boolean y;
  private List<Pair<Long, Integer>> A = Collections.synchronizedList(new ArrayList());
  private List<Pair<Long, Integer>> B = Collections.synchronizedList(new ArrayList());
  private ReadinjoySPEventReport.ExitAIOAttributes C;
  private Pair<Long, Integer> D;
  private Pair<Long, Integer> E;
  private boolean F = false;
  private boolean G;
  private Handler H = new Handler(ThreadManager.getSubThreadLooper());
  private Runnable I = new ReadinjoySPEventReport.8(this);
  private String[] L = { "com.tencent.weishi", "com.tencent.reading", "com.tencent.mtt", "com.tencent.qqlive", "com.tencent.news" };
  private String[] M = { "ws", "kb", "ll", "sp", "xw" };
  String b = "";
  boolean c = false;
  long d = -1L;
  public ReadinjoySPEventReport.UserOptInfo f = new ReadinjoySPEventReport.UserOptInfo(this);
  public ReadinjoySPEventReport.UserOptInfo g = this.f;
  private StringBuilder i = new StringBuilder(1024);
  private List<ReadinjoySPEventReport.TabClickItem> j = new LinkedList();
  private List<Pair<Long, Integer>> z = Collections.synchronizedList(new ArrayList());
  
  static
  {
    e = -1L;
    o = false;
    p = 0L;
    q = 0L;
    r = 0L;
    s = 0;
    t = false;
    u = System.currentTimeMillis();
    v = true;
    w = false;
    x = new ReadinjoySPEventReport.ScreenReceiver(null);
    y = false;
  }
  
  private ReadinjoySPEventReport()
  {
    D();
  }
  
  private void D() {}
  
  private static void E()
  {
    ThreadManager.getSubThreadHandler().post(new ReadinjoySPEventReport.4());
  }
  
  private void F()
  {
    if (l(14))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.C.a);
      localArrayList.add(this.C.c);
      localArrayList.add(this.C.d);
      ReadinjoyReportUtils.a(14, localArrayList);
    }
  }
  
  private int G()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (((QQAppInterface)localObject).isLogin()))
    {
      new oidb_cmd0x80a.AttributeList();
      localObject = ((QQAppInterface)localObject).getMessageFacade();
      if (localObject != null) {
        return ((QQMessageFacade)localObject).w();
      }
    }
    return 0;
  }
  
  private static int H()
  {
    if (RIJShowKanDianTabSp.c()) {
      return 1;
    }
    if (((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).isShowQQCircleMainTabEntrance(StudyModeManager.h())) {
      return 2;
    }
    return 0;
  }
  
  private static void I()
  {
    Object localObject = Aladdin.getConfig(466);
    int i2 = 0;
    int i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (((AladdinConfig)localObject).getIntegerFromString("reportSwitch", 0) == 1) {
        i1 = 1;
      }
    }
    if (i1 == 0)
    {
      QLog.i("ReadinjoySPEventReport", 1, "[reportThirdTabBigT] canReport is false.");
      return;
    }
    localObject = RIJTransMergeKanDianReport.g();
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(H());
      localStringBuilder1.append("");
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addString("third_tab_display", localStringBuilder1.toString());
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("[reportThirdTabBigT] e = ");
      localStringBuilder3.append(localJSONException);
      QLog.e("ReadinjoySPEventReport", 1, localStringBuilder3.toString());
    }
    PublicAccountReportUtils.a(null, "", "0X800BBCA", "0X800BBCA", 0, 0, "", "", "", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build(), false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[reportThirdTabBigT] r5 = ");
      localStringBuilder2.append(((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build());
      QLog.i("ReadinjoySPEventReport", 1, localStringBuilder2.toString());
    }
  }
  
  private static int J()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((BatteryManager)BaseApplicationImpl.getApplication().getSystemService("batterymanager")).getIntProperty(4);
    }
    Intent localIntent = new ContextWrapper(BaseApplicationImpl.getApplication().getApplicationContext()).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (localIntent.getIntExtra("level", -1) * 100 / localIntent.getIntExtra("scale", -1) != 0) {
      return localIntent.getIntExtra("scale", -1);
    }
    return 1;
  }
  
  private String K()
  {
    Object localObject3 = Aladdin.getConfig(225);
    Object localObject2 = null;
    String str;
    if (localObject3 != null)
    {
      localObject1 = ((AladdinConfig)localObject3).getString("report_app_package_list", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = ((String)localObject1).split("\\|");
      } else {
        localObject1 = null;
      }
      str = ((AladdinConfig)localObject3).getString("report_app_name_list", "");
      localObject3 = localObject1;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = str.split("\\|");
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
    }
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = this.L;
    }
    localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = this.M;
    }
    if (localObject1.length != localObject3.length) {
      return "";
    }
    localObject2 = new StringBuilder();
    int i1 = 0;
    while (i1 < localObject1.length)
    {
      ((StringBuilder)localObject2).append(localObject3[i1]);
      ((StringBuilder)localObject2).append("_");
      str = PackageUtil.b(BaseApplicationImpl.getContext(), localObject1[i1]);
      if ((!"0".equals(str)) && (!TextUtils.isEmpty(str)))
      {
        ((StringBuilder)localObject2).append("1_");
        ((StringBuilder)localObject2).append(str);
      }
      else
      {
        ((StringBuilder)localObject2).append("0_");
        ((StringBuilder)localObject2).append("-1");
      }
      if (i1 != localObject1.length - 1) {
        ((StringBuilder)localObject2).append("|");
      }
      i1 += 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getAppInstallInfo: ");
    ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
    QLog.d("ReadinjoySPEventReport", 1, ((StringBuilder)localObject1).toString());
    return ((StringBuilder)localObject2).toString();
  }
  
  public static ReadinjoySPEventReport a()
  {
    if (h == null) {
      try
      {
        if (h == null) {
          h = new ReadinjoySPEventReport();
        }
      }
      finally {}
    }
    return h;
  }
  
  public static String a(long paramLong)
  {
    int i1 = (int)paramLong;
    String str1 = "KongJian";
    switch (i1)
    {
    default: 
      str1 = null;
      break;
    case 10004: 
      str1 = "XiaoYuan";
      break;
    case 10001: 
      str1 = "FuJin";
      break;
    case 3053: 
      str1 = "GouWu";
      break;
    case 3050: 
      str1 = "RiJi";
      break;
    case 1113: 
      str1 = "DongMan";
      break;
    case 1047: 
      str1 = "YinYue";
      break;
    case 1041: 
      str1 = "KeTang";
      break;
    case 886: 
      str1 = "FujinQun";
      break;
    case 879: 
      str1 = "Now";
      break;
    case 871: 
    case 7102: 
      str1 = "XinWen";
      break;
    case 858: 
      str1 = "YunDong";
      break;
    case 826: 
      str1 = "BuLuo";
      break;
    case 769: 
      str1 = "YueDu";
      break;
    case 763: 
      str1 = "ChiHe";
      break;
    case 489: 
      str1 = "YouXi";
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = String.valueOf(paramLong);
    }
    return str2;
  }
  
  private String a(AbsStructMsgItem paramAbsStructMsgItem)
  {
    paramAbsStructMsgItem = paramAbsStructMsgItem.ax.iterator();
    while (paramAbsStructMsgItem.hasNext())
    {
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)paramAbsStructMsgItem.next();
      if ((localAbsStructMsgElement instanceof StructMsgItemTitle)) {
        return ((StructMsgItemTitle)localAbsStructMsgElement).e();
      }
    }
    return "";
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.18(paramInt2, paramInt4, paramInt3, paramInt1));
  }
  
  public static void a(int paramInt1, int paramInt2, List<ChatMessage> paramList)
  {
    if (f(paramInt1) < 0) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.15(paramList, paramInt1, paramInt2));
  }
  
  public static void a(int paramInt1, Map<String, String> paramMap, int paramInt2)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.19(paramInt1, paramMap, paramInt2));
  }
  
  private void a(ReadinjoySPEventReport.CommonAttrBuilder paramCommonAttrBuilder)
  {
    Object localObject = DeviceInfoUtil.g();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).equals("5")) || (((String)localObject).equals("5.0")) || (((String)localObject).compareTo("5.0.0") >= 0)))
    {
      localObject = ReadInJoyMMapKvStorage.getInstance(c("80aEvent"));
      String str = ((ReadInJoyMMapKvStorage)localObject).getValeForKey("content");
      if (!TextUtils.isEmpty(str))
      {
        if ((((ReadInJoyMMapKvStorage)localObject).getExpiredTime() != 0) && (((ReadInJoyMMapKvStorage)localObject).getExpiredTime() < System.currentTimeMillis() / 1000L))
        {
          ((ReadInJoyMMapKvStorage)localObject).invalidate();
          return;
        }
        paramCommonAttrBuilder.a(127, "FeatureFrameworkAttr", str);
      }
    }
  }
  
  private void a(ReadinjoySPEventReport.CommonAttrBuilder paramCommonAttrBuilder, int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 90)
    {
      List localList = paramCommonAttrBuilder.a();
      String str1 = null;
      paramInt = 0;
      for (;;)
      {
        str2 = str1;
        if (paramInt >= localList.size()) {
          break;
        }
        if (((oidb_cmd0x80a.AttributeList)localList.get(paramInt)).att_id.get() == 2)
        {
          str1 = ((oidb_cmd0x80a.AttributeList)localList.get(paramInt)).att_value.get();
          QLog.d("PublicAccountUtil", 2, "replace common kandianDaily forderStatus with business value !");
        }
        paramInt += 1;
      }
    }
    String str2 = KandianDailyReportUtils.e();
    paramInt = KandianDailyReportUtils.d();
    paramCommonAttrBuilder = paramCommonAttrBuilder.a(117, "daily_folderstatus", str2).a(118, "daily_msgbox_pos", String.valueOf(paramInt));
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt + 1 <= RIJDisplayStyleManager.INSTANCE.getRecentListReportVisibleItemCount()) {
        bool1 = true;
      }
    }
    paramCommonAttrBuilder.a(119, "daily_in_screen", bool1);
  }
  
  public static void a(List<ReadinjoySPEventReport.ScrollStep> paramList)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.16(paramList));
  }
  
  private static boolean a(int paramInt, long paramLong)
  {
    long l1 = l;
    return ((SPEventReportSwitch.d()) && (paramLong - l1 >= SPEventReportSwitch.b() * 1000)) || (SPEventReportSwitch.b(paramInt));
  }
  
  public static long b(long paramLong)
  {
    paramLong = Math.max(Math.max(f(), u), paramLong);
    return System.currentTimeMillis() - paramLong;
  }
  
  private String b(List<ChatMessage> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (ChatMessage)paramList.get(paramList.size() - 1);
      if ((paramList instanceof MessageForStructing))
      {
        paramList = ((MessageForStructing)paramList).structingMsg;
        if ((paramList instanceof StructMsgForGeneralShare))
        {
          paramList = ((StructMsgForGeneralShare)paramList).mStructMsgItemLists.iterator();
          while (paramList.hasNext())
          {
            Object localObject = (AbsStructMsgElement)paramList.next();
            if ((localObject instanceof AbsStructMsgItem))
            {
              localObject = a((AbsStructMsgItem)localObject);
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                if (localStringBuilder.length() > 0) {
                  localStringBuilder.append("`");
                }
                localStringBuilder.append((String)localObject);
              }
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void b(int paramInt1, Map<String, String> paramMap, int paramInt2)
  {
    ReadinjoySPEventReport.UserOptInfo localUserOptInfo = a().f;
    boolean bool;
    if (paramInt1 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localUserOptInfo.a(bool);
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.20(paramInt1, paramMap, paramInt2));
  }
  
  public static void b(int paramInt, boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.13(paramInt, paramBoolean));
  }
  
  private static boolean b(int paramInt, long paramLong)
  {
    boolean bool2 = SPEventReportSwitch.d();
    boolean bool1 = true;
    if ((!bool2) || (paramLong - m < SPEventReportSwitch.c() * 1000) || (n > 1))
    {
      if (SPEventReportSwitch.b(paramInt)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private ReadinjoySPEventReport.ExitAIOAttributes c(List<ChatMessage> paramList)
  {
    ReadinjoySPEventReport.ExitAIOAttributes localExitAIOAttributes = new ReadinjoySPEventReport.ExitAIOAttributes(this);
    Object localObject1 = ReadInJoyHelper.x();
    long l1 = ((Integer)((Pair)localObject1).first).intValue();
    long l2 = ((Integer)((Pair)localObject1).second).intValue();
    long l3 = NetConnInfoCenter.getServerTime();
    int i3 = paramList.size() - 1;
    int i2 = 0;
    int i5;
    for (int i1 = 0; i3 >= 0; i1 = i5)
    {
      localObject1 = (ChatMessage)paramList.get(i3);
      long l4 = l3 - ((ChatMessage)localObject1).time;
      if ((l4 > l1) && (l4 > l2)) {
        break;
      }
      int i4;
      if ((!((ChatMessage)localObject1).isSendFromLocal()) && (l4 <= l1))
      {
        i5 = i1 + 1;
        i4 = i2;
      }
      else
      {
        i4 = i2;
        i5 = i1;
        if (((ChatMessage)localObject1).isSendFromLocal())
        {
          i4 = i2;
          i5 = i1;
          if (l4 <= l2)
          {
            i4 = i2 + 1;
            i5 = i1;
          }
        }
      }
      i3 -= 1;
      i2 = i4;
    }
    paramList = RIJQQAppInterfaceUtil.e();
    if ((paramList != null) && ((paramList instanceof QQAppInterface))) {
      i3 = ((QQAppInterface)paramList).getMessageFacade().w();
    } else {
      i3 = 0;
    }
    paramList = new oidb_cmd0x80a.AttributeList();
    paramList.att_id.set(1);
    paramList.att_name.set("Time");
    paramList.att_value.set(String.valueOf(System.currentTimeMillis() / 1000L));
    localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("MsgPulse");
    Object localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(l1);
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append(i1);
    ((StringBuilder)localObject3).append("`");
    ((StringBuilder)localObject3).append(l2);
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append(i2);
    ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
    localObject2 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(3);
    ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("Keyword");
    ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set("");
    localObject3 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(4);
    ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("leftBtmRedCnt");
    ((oidb_cmd0x80a.AttributeList)localObject3).att_value.set(String.valueOf(i3));
    localExitAIOAttributes.a = paramList;
    localExitAIOAttributes.b = ((oidb_cmd0x80a.AttributeList)localObject1);
    localExitAIOAttributes.c = ((oidb_cmd0x80a.AttributeList)localObject2);
    localExitAIOAttributes.d = ((oidb_cmd0x80a.AttributeList)localObject3);
    return localExitAIOAttributes;
  }
  
  private String c(String paramString)
  {
    String str = RIJQQAppInterfaceUtil.e().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void c(long paramLong)
  {
    p = paramLong;
  }
  
  public static void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    c(System.currentTimeMillis());
    ReadinjoySPEventReport.ForeBackGround.b();
    ReadInJoyDailyFragment.d();
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.2());
  }
  
  public static void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    UGRuleManager.a();
    ReadInJoyDailyFragment.c();
    if (ReadinjoySPEventReport.ForeBackGround.a == 2) {
      return;
    }
    ReadinjoySPEventReport.ForeBackGround.c();
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.12(b(f())));
  }
  
  public static void e(int paramInt)
  {
    Object localObject = BaseActivity.sTopActivity;
    int i2 = 0;
    boolean bool = false;
    int i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if ((localObject instanceof SplashActivity))
      {
        localObject = (MainFragment)((SplashActivity)localObject).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        i1 = i2;
        if (localObject != null)
        {
          int i3 = 1;
          try
          {
            i1 = FrameControllerUtil.a;
            if (paramInt == i1)
            {
              i1 = i3;
              try
              {
                localObject = ((MainFragment)localObject).y();
                i1 = i3;
                StringBuilder localStringBuilder = new StringBuilder();
                i1 = i3;
                localStringBuilder.append(FrameControllerUtil.l);
                i1 = i3;
                localStringBuilder.append("_num");
                i1 = i3;
                i2 = ((View)((HashMap)localObject).get(localStringBuilder.toString())).getVisibility();
                if (i2 == 0) {
                  bool = true;
                }
                i1 = 1;
              }
              catch (Exception localException1)
              {
                break label238;
              }
            }
            else
            {
              i1 = FrameControllerUtil.c;
              if (paramInt == i1)
              {
                i1 = 2;
                bool = localException1.a(FrameControllerUtil.m).h();
                i1 = 2;
              }
              else
              {
                i1 = FrameControllerUtil.g;
                if (paramInt == i1)
                {
                  i1 = 3;
                  bool = localException1.a(FrameControllerUtil.q).h();
                  i1 = 3;
                }
                else
                {
                  i3 = FrameControllerUtil.d;
                  i1 = i2;
                  if (paramInt == i3)
                  {
                    i1 = 4;
                    bool = localException1.a(FrameControllerUtil.o).h();
                    i1 = 4;
                  }
                }
              }
            }
          }
          catch (Exception localException2)
          {
            i1 = 0;
            label238:
            AIOUtils.a("onMainFragmentTabClick", "onMainFragmentTabClick", localException2);
          }
        }
      }
    }
    bool = false;
    if (i1 != 0) {
      b(i1, bool);
    }
    if (paramInt != FrameControllerUtil.g) {
      UGRuleManager.a();
    }
  }
  
  public static boolean e()
  {
    return o;
  }
  
  public static int f(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return -1;
        }
        return 1;
      }
      return 0;
    }
    return 2;
  }
  
  public static long f()
  {
    return p;
  }
  
  public static int g(int paramInt)
  {
    if (paramInt == FrameControllerUtil.a) {
      return 1;
    }
    if (paramInt == FrameControllerUtil.c) {
      return 2;
    }
    if (paramInt == FrameControllerUtil.g) {
      return 3;
    }
    if (paramInt == FrameControllerUtil.d) {
      return 4;
    }
    return 0;
  }
  
  public static void g()
  {
    q = NetConnInfoCenter.getServerTime();
  }
  
  public static long h()
  {
    return q;
  }
  
  public static void h(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.17(paramInt));
  }
  
  private static void h(boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.3(paramBoolean));
  }
  
  public static void i()
  {
    r = System.currentTimeMillis();
  }
  
  public static void i(int paramInt)
  {
    Object localObject1 = TimeSliceHelper.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("dau_report_type_");
    ((StringBuilder)localObject2).append(paramInt);
    if (TextUtils.equals((CharSequence)localObject1, (String)RIJSPUtils.b(((StringBuilder)localObject2).toString(), "")))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("has report dau for type today, type :");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("ReadinjoySPEventReport", 2, ((StringBuilder)localObject1).toString());
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("dau_report_type_");
    ((StringBuilder)localObject2).append(paramInt);
    RIJSPUtils.a(((StringBuilder)localObject2).toString(), localObject1);
    localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(1);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("Type");
    localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ((PBStringField)localObject2).set(localStringBuilder.toString());
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject1);
    ReadinjoyReportUtils.a(94, (List)localObject2);
  }
  
  public static long j()
  {
    return r;
  }
  
  public static void k()
  {
    c(true);
  }
  
  public static void l()
  {
    if (y) {
      return;
    }
    y = true;
    try
    {
      ReadInJoySpEventReportUtil.a();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      BaseApplicationImpl.getContext().registerReceiver(x, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static boolean l(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("canReport : eventID ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("ReadinjoySPEventReport", 2, ((StringBuilder)localObject).toString());
    long l1 = System.currentTimeMillis();
    if (paramInt != 7) {
      if (paramInt != 8)
      {
        if (paramInt != 9)
        {
          if (paramInt != 11)
          {
            if (paramInt != 12)
            {
              if (paramInt != 14)
              {
                if ((paramInt == 19) || (paramInt == 23) || (paramInt == 24)) {
                  break label221;
                }
                if (paramInt != 60)
                {
                  if (paramInt != 61) {
                    return false;
                  }
                  return n(paramInt);
                }
                return NetConnInfoCenter.getServerTime() - J < e;
              }
              try
              {
                localObject = ReadInJoyHelper.z();
                paramInt = (int)(Long.valueOf(RIJQQAppInterfaceUtil.d()).longValue() % 100L);
                if ((localObject != null) && (paramInt >= ((Integer)((Pair)localObject).first).intValue()))
                {
                  int i1 = ((Integer)((Pair)localObject).second).intValue();
                  if (paramInt <= i1) {
                    return true;
                  }
                }
                return false;
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
                return false;
              }
            }
            return true;
          }
          else
          {
            return m(paramInt);
          }
        }
        else {
          return b(paramInt, l1);
        }
      }
      else {
        return a(paramInt, l1);
      }
    }
    label221:
    return SPEventReportSwitch.b(paramInt);
  }
  
  private static boolean m(int paramInt)
  {
    int i1 = Calendar.getInstance().get(5);
    int i2 = s;
    boolean bool = true;
    if (i1 != i2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      if ((SPEventReportSwitch.d()) && (SPEventReportSwitch.b(paramInt))) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private static boolean n(int paramInt)
  {
    if (!(RIJQQAppInterfaceUtil.e() instanceof QQAppInterface)) {
      return false;
    }
    if (!BaseActivity.mAppForground) {
      return false;
    }
    return SPEventReportSwitch.b(paramInt);
  }
  
  public static void o()
  {
    d(true);
  }
  
  private void o(int paramInt)
  {
    if (l(12))
    {
      ArrayList localArrayList = new ArrayList();
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("Type");
      localAttributeList.att_value.set(String.valueOf(paramInt));
      localArrayList.add(localAttributeList);
      ReadinjoyReportUtils.a(12, localArrayList);
    }
  }
  
  public static void p()
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    long l1;
    if ((localQQAppInterface != null) && (localQQAppInterface.mAutomator != null) && (localQQAppInterface.mAutomator.g())) {
      l1 = 3000L;
    } else {
      l1 = 0L;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new ReadinjoySPEventReport.14(), l1);
  }
  
  public static void q() {}
  
  public static void r()
  {
    ReadinjoyReportUtils.a(71, new ArrayList());
  }
  
  public static void s()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("daily_folderstatus");
    localAttributeList.att_value.set(KandianDailyReportUtils.e());
    localArrayList.add(localAttributeList);
    ReadinjoyReportUtils.a(91, localArrayList);
  }
  
  public static void t()
  {
    K = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.5(this, paramInt));
  }
  
  public void a(int paramInt1, List paramList, String paramString, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList(this.B);
    if ((paramInt1 == 0) && ((localArrayList.isEmpty()) || (((Integer)((Pair)localArrayList.get(localArrayList.size() - 1)).second).intValue() == 0))) {
      return;
    }
    if ((paramInt2 != 0) && (paramInt2 != 1) && (paramInt2 != 3000) && (!b(paramInt2)))
    {
      if (paramInt1 == 1)
      {
        i();
        return;
      }
      a().a(paramString, j());
      return;
    }
    if (paramInt1 == 1) {
      g();
    } else {
      a(paramInt2, paramInt3, paramList);
    }
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.6(this, paramInt1, paramList));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.b = a(paramInt);
    this.c = paramBoolean;
    this.d = System.currentTimeMillis();
    ReadinjoySPEventReport.ForeBackGround.a(2);
  }
  
  public void a(String paramString)
  {
    if ("2909288299".equals(paramString)) {
      ReadinjoySPEventReport.ForeBackGround.a(3);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    try
    {
      if ("2909288299".equals(paramString))
      {
        b("GetNextMsg");
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "reportPubAioMenuAction", paramString);
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.11(this, paramString, paramLong));
  }
  
  public void a(String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
        localAttributeList1.att_id.set(1);
        localAttributeList1.att_name.set("ActType");
        localAttributeList1.att_value.set(paramString1);
        oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
        localAttributeList2.att_id.set(2);
        localAttributeList2.att_name.set("HasRedPnt");
        Object localObject2 = localAttributeList2.att_value;
        if (!paramBoolean) {
          break label345;
        }
        localObject1 = "1";
        ((PBStringField)localObject2).set((String)localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("Time");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(b(paramLong)));
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(4);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("Exposures");
        ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(paramString2);
        paramString2 = new oidb_cmd0x80a.AttributeList();
        paramString2.att_id.set(5);
        paramString2.att_name.set("Clicks");
        paramString2.att_value.set(paramString3);
        paramString3 = new ArrayList(3);
        paramString3.add(localAttributeList1);
        paramString3.add(localAttributeList2);
        paramString3.add(localObject1);
        paramString3.add(localObject2);
        paramString3.add(paramString2);
        ReadinjoyReportUtils.a(3, paramString3);
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("reportQQNewsAction actType:");
          paramString2.append(paramString1);
          QLog.d("ReadinjoySPEventReport", 2, paramString2.toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction", paramString1);
        }
      }
      return;
      label345:
      Object localObject1 = "0";
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean, List<ChatMessage> paramList)
  {
    a(paramString, paramLong, paramBoolean, paramList, true);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean1, List<ChatMessage> paramList, boolean paramBoolean2)
  {
    if ("2909288299".equals(paramString))
    {
      a("Enter", paramLong, paramBoolean1, b(paramList), this.i.toString());
      this.i.setLength(0);
      if (paramBoolean2) {
        ReadinjoySPEventReport.ForeBackGround.a();
      }
    }
  }
  
  public void a(String paramString, AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ("2909288299".equals(paramString))
    {
      b("ClickMsg");
      if ((paramAbsStructMsgElement != null) && ((paramAbsStructMsgElement instanceof AbsStructMsgItem)))
      {
        paramString = a((AbsStructMsgItem)paramAbsStructMsgElement);
        if (!TextUtils.isEmpty(paramString))
        {
          if (this.i.length() > 0) {
            this.i.append("`");
          }
          this.i.append(paramString);
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {
      this.b = paramString;
    }
    this.c = paramBoolean;
    this.d = System.currentTimeMillis();
    ReadinjoySPEventReport.ForeBackGround.a(2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      ReadinjoyReportUtils.a(this.b, this.c, this.d);
      if (paramBoolean)
      {
        this.b = "";
        ReadinjoySPEventReport.ForeBackGround.a();
      }
    }
  }
  
  public void b()
  {
    ThreadManager.post(new ReadinjoySPEventReport.1(this), 8, null, true);
  }
  
  public void b(String paramString)
  {
    try
    {
      Object localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("ActType");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramString);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      ReadinjoyReportUtils.a(3, localArrayList);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportQQNewsAction actType:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ReadinjoySPEventReport", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction", paramString);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    o = paramBoolean;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt != 1008)
    {
      bool1 = bool2;
      if (paramInt >= 1000)
      {
        bool1 = bool2;
        if (paramInt <= 1034) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public List<oidb_cmd0x80a.AttributeList> c(int paramInt)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = new ArrayList();
    if ((localObject1 instanceof QQAppInterface)) {
      localObject1 = (QQAppInterface)localObject1;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return localObject2;
    }
    ReadinjoySPEventReport.CommonAttrBuilder localCommonAttrBuilder = new ReadinjoySPEventReport.CommonAttrBuilder(this, (List)localObject2);
    if (BaseApplicationImpl.sProcessId != 1) {
      return localObject2;
    }
    localObject2 = localCommonAttrBuilder.a(0, "UnreadMsg", String.valueOf(G())).a(100, "FolderStatus", String.valueOf(RIJKanDianFolderStatus.reportFolderStatus)).a(101, "KDInScreen", RIJMergeKanDianMessage.b((QQAppInterface)localObject1)).a(102, "KDAttrL", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).constructAttributeL()).a(103, "LeftBtmRedPntPulse", ReadinjoySPEventReport.Utils.a(this.z, ":", "`")).a(104, "FirstScnRedPntPulse", ReadinjoySPEventReport.Utils.a(this.A, ":", "`")).a(105, "AIOPulse", ReadinjoySPEventReport.Utils.a(this.B, ":", "`"));
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(RIJKanDianTabReport.a);
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append(RIJKanDianFolderStatus.reportFolderStatus);
    ((ReadinjoySPEventReport.CommonAttrBuilder)localObject2).a(106, "LastRedExposureTime", ((StringBuilder)localObject3).toString()).a(107, "dt_red", e());
    long l1;
    if (f() > 0L) {
      l1 = f();
    } else {
      l1 = System.currentTimeMillis();
    }
    localCommonAttrBuilder.a(108, "last_inforeground_time", String.valueOf(l1 / 1000L));
    localCommonAttrBuilder.a(109, "last_in_aio_time", String.valueOf(h()));
    localObject2 = a().m();
    if (localObject2 != null)
    {
      ((ReadinjoySPEventReport.ExitAIOAttributes)localObject2).b.att_id.set(110);
      localCommonAttrBuilder.a(((ReadinjoySPEventReport.ExitAIOAttributes)localObject2).b);
    }
    localCommonAttrBuilder.a(112, "UniversalStateBit", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isMsgTabStoryNodeListVisible()).a(116, "wifiName", NetworkUtils.e(BaseApplicationImpl.getContext()));
    a(localCommonAttrBuilder, paramInt);
    localCommonAttrBuilder.a(120, "PushPreviewQ", SettingCloneUtil.readValue(BaseApplicationImpl.getContext(), RIJQQAppInterfaceUtil.d(), "", "qqsetting_notify_showcontent_key", true));
    localCommonAttrBuilder.a(121, "NoDisturbAtNight", FriendsStatusUtil.a(BaseApplicationImpl.getApplication()));
    paramInt = ReadInJoyHelper.e((QQAppInterface)RIJQQAppInterfaceUtil.e());
    if (paramInt != -1) {
      localCommonAttrBuilder.a(122, "DongTaiKandian", String.valueOf(paramInt));
    }
    localCommonAttrBuilder.a(123, "BSSID", DeviceInfoUtil.c(BaseApplicationImpl.getContext()));
    localCommonAttrBuilder.a(124, "MsgListFristDataIsVisable", ReadinjoySPEventReport.Utils.a(Integer.valueOf(ReadinjoySPEventReport.ScrollReport.a()), Integer.valueOf(0)));
    a(localCommonAttrBuilder);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(G());
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(ReadinjoySPEventReport.Utils.a(ReadinjoySPEventReport.Utils.a(Integer.valueOf(RIJKanDianFolderStatus.reportFolderStatus), Integer.valueOf(1)), "0", "1"));
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(ReadinjoySPEventReport.Utils.a(e(), String.valueOf(1), String.valueOf(0)));
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject3 = localCommonAttrBuilder.a(126, "ScreenInfo", RIJMergeKanDianMessage.a(-1)).a(128, "is_jcjj_mode", QQTheme.isNowSimpleUI());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ArticleInfoModuleUtils.a());
    localStringBuilder.append("");
    localObject3 = ((ReadinjoySPEventReport.CommonAttrBuilder)localObject3).a(129, "network", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(J());
    localStringBuilder.append("");
    localObject3 = ((ReadinjoySPEventReport.CommonAttrBuilder)localObject3).a(130, "battery", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(K / 1000L);
    localStringBuilder.append("");
    ((ReadinjoySPEventReport.CommonAttrBuilder)localObject3).a(131, "sessionID", localStringBuilder.toString()).a(132, "redDot", (String)localObject2).a(133, "app_install_list", K()).a(134, "is_study_mode", StudyModeManager.h());
    localObject1 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((KandianMergeManager)localObject1).R());
    ((StringBuilder)localObject2).append("");
    localCommonAttrBuilder.a(135, "kdTabNumRed", ((StringBuilder)localObject2).toString());
    localCommonAttrBuilder.a(136, "4TabRedStatus", RIJXTabBadgeReporter.a.b());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(H());
    ((StringBuilder)localObject1).append("");
    localCommonAttrBuilder.a(140, "third_tab_display", ((StringBuilder)localObject1).toString());
    return localCommonAttrBuilder.a();
  }
  
  public void c()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        int i1 = ((QQAppInterface)localObject1).getMessageFacade().w();
        boolean bool = RIJMergeKanDianMessage.b((QQAppInterface)localObject1);
        oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
        localAttributeList1.att_id.set(1);
        localAttributeList1.att_name.set("UnreadMsg");
        localAttributeList1.att_value.set(String.valueOf(i1));
        oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
        localAttributeList2.att_id.set(2);
        localAttributeList2.att_name.set("KDInScreen");
        Object localObject2 = localAttributeList2.att_value;
        if (!bool) {
          break label303;
        }
        localObject1 = "1";
        ((PBStringField)localObject2).set((String)localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("FoldStatus");
        localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(RIJKanDianFolderStatus.reportFolderStatus);
        localStringBuilder.append("");
        ((PBStringField)localObject2).set(localStringBuilder.toString());
        localObject2 = new ArrayList(3);
        ((List)localObject2).add(localAttributeList1);
        ((List)localObject2).add(localAttributeList2);
        ((List)localObject2).add(localObject1);
        ReadinjoyReportUtils.a(1, (List)localObject2);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("reportManualRefresMsg unRead:");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(" isFirst:");
          ((StringBuilder)localObject1).append(bool);
          QLog.d("ReadinjoySPEventReport", 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadinjoySPEventReport", 2, "reportManualRefresMsg", localException);
        }
      }
      return;
      label303:
      String str = "0";
    }
  }
  
  public void d()
  {
    a(true);
  }
  
  public void d(int paramInt)
  {
    this.H.removeCallbacks(this.I);
    this.H.postDelayed(this.I, paramInt * 1000);
  }
  
  public ReadinjoySPEventReport.ExitAIOAttributes m()
  {
    ReadinjoySPEventReport.ExitAIOAttributes localExitAIOAttributes = this.C;
    this.C = null;
    return localExitAIOAttributes;
  }
  
  public void n()
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.7(this));
    this.G = true;
  }
  
  public long u()
  {
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport
 * JD-Core Version:    0.7.0.1
 */