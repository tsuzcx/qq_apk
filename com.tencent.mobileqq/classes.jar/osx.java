import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.1;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.11;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.12;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.13;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.14;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.15;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.16;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.17;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.18;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.19;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.2;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.20;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.3;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.4;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.5;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.6;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.7;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.8;
import com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
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
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class osx
{
  private static int jdField_a_of_type_Int;
  public static final long a;
  private static volatile osx jdField_a_of_type_Osx;
  private static oth jdField_a_of_type_Oth = new oth(null);
  private static int jdField_b_of_type_Int;
  private static boolean jdField_b_of_type_Boolean;
  public static long c;
  private static boolean jdField_c_of_type_Boolean;
  private static long jdField_d_of_type_Long;
  private static boolean jdField_d_of_type_Boolean;
  private static long jdField_e_of_type_Long;
  private static volatile boolean jdField_e_of_type_Boolean;
  private static long jdField_f_of_type_Long;
  private static long jdField_g_of_type_Long;
  private static long h;
  private static long i;
  private static long j;
  private static long k;
  private static long l = System.currentTimeMillis();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Pair<Long, Integer> jdField_a_of_type_AndroidUtilPair;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadinjoySPEventReport.8(this);
  String jdField_a_of_type_JavaLangString = "";
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(1024);
  private List<Object> jdField_a_of_type_JavaUtilList = new LinkedList();
  private osz jdField_a_of_type_Osz;
  public otl a;
  boolean jdField_a_of_type_Boolean = false;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.weishi", "com.tencent.reading", "com.tencent.mtt", "com.tencent.qqlive", "com.tencent.news" };
  long jdField_b_of_type_Long = -1L;
  private Pair<Long, Integer> jdField_b_of_type_AndroidUtilPair;
  private List<Pair<Long, Integer>> jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  public otl b;
  private String[] jdField_b_of_type_ArrayOfJavaLangString = { "ws", "kb", "ll", "sp", "xw" };
  private List<Pair<Long, Integer>> jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private List<Pair<Long, Integer>> jdField_d_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_c_of_type_Long = -1L;
    j = System.currentTimeMillis();
    jdField_c_of_type_Boolean = true;
  }
  
  private osx()
  {
    this.jdField_a_of_type_Otl = new otl(this);
    this.jdField_b_of_type_Otl = this.jdField_a_of_type_Otl;
    p();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
      return 2;
    case 1: 
      return 0;
    }
    return 1;
  }
  
  public static long a()
  {
    return jdField_g_of_type_Long;
  }
  
  public static long a(long paramLong)
  {
    paramLong = Math.max(Math.max(a(), j), paramLong);
    return System.currentTimeMillis() - paramLong;
  }
  
  private String a()
  {
    Object localObject2 = null;
    Object localObject3 = Aladdin.getConfig(225);
    Object localObject1;
    if (localObject3 != null)
    {
      localObject1 = ((AladdinConfig)localObject3).getString("report_app_package_list", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split("\\|");
        localObject2 = ((AladdinConfig)localObject3).getString("report_app_name_list", "");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = ((String)localObject2).split("\\|");
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      if (localObject2 == null) {
        localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
      }
      for (;;)
      {
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = this.jdField_b_of_type_ArrayOfJavaLangString;
        }
        if (localObject2.length != localObject3.length) {
          return "";
        }
        localObject1 = new StringBuilder();
        int m = 0;
        if (m < localObject2.length)
        {
          ((StringBuilder)localObject1).append(localObject3[m]);
          ((StringBuilder)localObject1).append("_");
          String str = bbfr.a(BaseApplicationImpl.getContext(), localObject2[m]);
          if (("0".equals(str)) || (TextUtils.isEmpty(str)))
          {
            ((StringBuilder)localObject1).append("0_");
            ((StringBuilder)localObject1).append("-1");
          }
          for (;;)
          {
            if (m != localObject2.length - 1) {
              ((StringBuilder)localObject1).append("|");
            }
            m += 1;
            break;
            ((StringBuilder)localObject1).append("1_");
            ((StringBuilder)localObject1).append(str);
          }
        }
        QLog.d("ReadinjoySPEventReport", 1, "getAppInstallInfo: " + ((StringBuilder)localObject1).toString());
        return ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      localObject1 = null;
      continue;
      localObject1 = null;
      break;
      localObject1 = null;
    }
  }
  
  public static String a(long paramLong)
  {
    Object localObject1 = null;
    switch ((int)paramLong)
    {
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = String.valueOf(paramLong);
      }
      return localObject2;
      localObject1 = "KongJian";
      continue;
      localObject1 = "YueDu";
      continue;
      localObject1 = "BuLuo";
      continue;
      localObject1 = "DongMan";
      continue;
      localObject1 = "FujinQun";
      continue;
      localObject1 = "XinWen";
      continue;
      localObject1 = "Now";
      continue;
      localObject1 = "RiJi";
      continue;
      localObject1 = "YouXi";
      continue;
      localObject1 = "YinYue";
      continue;
      localObject1 = "ChiHe";
      continue;
      localObject1 = "KeTang";
      continue;
      localObject1 = "YunDong";
      continue;
      localObject1 = "GouWu";
      continue;
      localObject1 = "KongJian";
      continue;
      localObject1 = "FuJin";
      continue;
      localObject1 = "XiaoYuan";
    }
  }
  
  private String a(axuq paramaxuq)
  {
    paramaxuq = paramaxuq.a.iterator();
    while (paramaxuq.hasNext())
    {
      axup localaxup = (axup)paramaxuq.next();
      if ((localaxup instanceof StructMsgItemTitle)) {
        return ((StructMsgItemTitle)localaxup).b();
      }
    }
    return "";
  }
  
  private String a(String paramString)
  {
    String str = onh.a().getAccount();
    return str + "_" + paramString;
  }
  
  private String a(List<ChatMessage> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    paramList = (ChatMessage)paramList.get(paramList.size() - 1);
    if (MessageForStructing.class.isInstance(paramList))
    {
      paramList = ((MessageForStructing)paramList).structingMsg;
      if (StructMsgForGeneralShare.class.isInstance(paramList))
      {
        paramList = ((StructMsgForGeneralShare)paramList).mStructMsgItemLists.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (axup)paramList.next();
          if ((localObject instanceof axuq))
          {
            localObject = a((axuq)localObject);
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
  
  public static osx a()
  {
    if (jdField_a_of_type_Osx == null) {}
    try
    {
      if (jdField_a_of_type_Osx == null) {
        jdField_a_of_type_Osx = new osx();
      }
      return jdField_a_of_type_Osx;
    }
    finally {}
  }
  
  private osz a(List<ChatMessage> paramList)
  {
    osz localosz = new osz(this);
    int m = 0;
    int n = 0;
    Object localObject = bhvy.a();
    long l1 = ((Integer)((Pair)localObject).first).intValue();
    long l2 = ((Integer)((Pair)localObject).second).intValue();
    long l3 = NetConnInfoCenter.getServerTime();
    int i1 = paramList.size() - 1;
    long l4;
    if (i1 >= 0)
    {
      localObject = (ChatMessage)paramList.get(i1);
      l4 = l3 - ((ChatMessage)localObject).time;
      if ((l4 <= l1) || (l4 <= l2)) {}
    }
    else
    {
      paramList = onh.a();
      if ((paramList == null) || (!(paramList instanceof QQAppInterface))) {
        break label446;
      }
      i1 = ((QQAppInterface)paramList).a().b();
      label133:
      paramList = new oidb_cmd0x80a.AttributeList();
      paramList.att_id.set(1);
      paramList.att_name.set("Time");
      paramList.att_value.set(String.valueOf(System.currentTimeMillis() / 1000L));
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("MsgPulse");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(l1 + ":" + n + "`" + l2 + ":" + m);
      oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
      localAttributeList1.att_id.set(3);
      localAttributeList1.att_name.set("Keyword");
      localAttributeList1.att_value.set("");
      oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
      localAttributeList2.att_id.set(4);
      localAttributeList2.att_name.set("LeftBtmRedCnt");
      localAttributeList2.att_value.set(String.valueOf(i1));
      localosz.a = paramList;
      localosz.b = ((oidb_cmd0x80a.AttributeList)localObject);
      localosz.c = localAttributeList1;
      localosz.d = localAttributeList2;
      return localosz;
    }
    int i2;
    if ((!((ChatMessage)localObject).isSendFromLocal()) && (l4 <= l1))
    {
      i2 = n + 1;
      n = m;
      m = i2;
    }
    for (;;)
    {
      i2 = i1 - 1;
      i1 = n;
      n = m;
      m = i1;
      i1 = i2;
      break;
      if ((((ChatMessage)localObject).isSendFromLocal()) && (l4 <= l2))
      {
        i2 = m + 1;
        m = n;
        n = i2;
        continue;
        label446:
        i1 = 0;
        break label133;
      }
      i2 = m;
      m = n;
      n = i2;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.18(paramInt2, paramInt4, paramInt3, paramInt1));
  }
  
  public static void a(int paramInt1, int paramInt2, List<ChatMessage> paramList)
  {
    if (a(paramInt1) < 0) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.15(paramList, paramInt1, paramInt2));
  }
  
  public static void a(int paramInt1, Map<String, String> paramMap, int paramInt2)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.19(paramInt1, paramMap, paramInt2));
  }
  
  public static void a(long paramLong)
  {
    jdField_g_of_type_Long = paramLong;
  }
  
  public static void a(List<otk> paramList)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.16(paramList));
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  private static int b()
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
  
  public static int b(int paramInt)
  {
    int m = 0;
    if (paramInt == MainFragment.jdField_b_of_type_Int) {
      m = 1;
    }
    do
    {
      return m;
      if (paramInt == MainFragment.jdField_d_of_type_Int) {
        return 2;
      }
      if (paramInt == MainFragment.h) {
        return 3;
      }
    } while (paramInt != MainFragment.e);
    return 4;
  }
  
  public static long b()
  {
    return h;
  }
  
  public static void b(int paramInt1, Map<String, String> paramMap, int paramInt2)
  {
    otl localotl = a().jdField_a_of_type_Otl;
    if (paramInt1 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localotl.a(bool);
      ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.20(paramInt1, paramMap, paramInt2));
      return;
    }
  }
  
  public static long c()
  {
    return i;
  }
  
  public static void c(int paramInt)
  {
    int m = 1;
    int n = 1;
    boolean bool1 = false;
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = (MainFragment)((SplashActivity)localObject).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        i1 = MainFragment.jdField_b_of_type_Int;
        if (paramInt != i1) {}
      }
      catch (Exception localException1)
      {
        int i1;
        boolean bool2;
        m = 0;
        actj.a("onMainFragmentTabClick", "onMainFragmentTabClick", localException1);
        continue;
      }
      try
      {
        i1 = ((View)((MainFragment)localObject).a().get(MainFragment.jdField_a_of_type_JavaLangString + "_num")).getVisibility();
        if (i1 != 0) {
          continue;
        }
        bool1 = true;
        m = n;
      }
      catch (Exception localException2)
      {
        continue;
        bool1 = false;
        m = 0;
        continue;
      }
      if (m != 0) {
        c(m, bool1);
      }
      if (paramInt != MainFragment.h) {
        qae.a();
      }
      return;
      bool1 = false;
      m = n;
      continue;
      m = MainFragment.jdField_d_of_type_Int;
      if (paramInt == m)
      {
        n = 2;
        m = n;
        bool2 = ((MainFragment)localObject).a(MainFragment.jdField_b_of_type_JavaLangString).a();
        bool1 = bool2;
        m = n;
      }
      else
      {
        m = MainFragment.h;
        if (paramInt == m)
        {
          n = 3;
          m = n;
          bool2 = ((MainFragment)localObject).a(MainFragment.jdField_d_of_type_JavaLangString).a();
          bool1 = bool2;
          m = n;
        }
        else
        {
          m = MainFragment.e;
          if (paramInt == m)
          {
            n = 4;
            m = n;
            bool2 = ((MainFragment)localObject).a(MainFragment.c).a();
            bool1 = bool2;
            m = n;
          }
          else
          {
            m = 0;
          }
        }
      }
    }
  }
  
  public static void c(int paramInt, boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.13(paramInt, paramBoolean));
  }
  
  public static void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    a(System.currentTimeMillis());
    ota.b();
    ReadInJoyDailyFragment.c();
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.2());
  }
  
  private static boolean c(int paramInt)
  {
    QLog.d("ReadinjoySPEventReport", 2, "canReport : eventID " + paramInt);
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    label275:
    AppRuntime localAppRuntime;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return false;
            long l2 = jdField_e_of_type_Long;
            if (((SPEventReportSwitch.a()) && (l1 - l2 >= SPEventReportSwitch.b() * 1000)) || (SPEventReportSwitch.a(paramInt)))
            {
              return true;
              if (SPEventReportSwitch.a(paramInt))
              {
                return true;
                if (SPEventReportSwitch.a(paramInt))
                {
                  return true;
                  if (SPEventReportSwitch.a(paramInt))
                  {
                    return true;
                    if (((SPEventReportSwitch.a()) && (l1 - jdField_f_of_type_Long >= SPEventReportSwitch.c() * 1000) && (jdField_a_of_type_Int <= 1)) || (SPEventReportSwitch.a(paramInt)))
                    {
                      return true;
                      int m;
                      if (Calendar.getInstance().get(5) != jdField_b_of_type_Int)
                      {
                        m = 1;
                        if ((m == 0) && ((!SPEventReportSwitch.a()) || (!SPEventReportSwitch.a(paramInt)))) {
                          break label275;
                        }
                      }
                      for (boolean bool = true;; bool = false)
                      {
                        return bool;
                        m = 0;
                        break;
                      }
                      return true;
                      try
                      {
                        Pair localPair = bhvy.b();
                        paramInt = (int)(Long.valueOf(onh.a()).longValue() % 100L);
                        if ((localPair != null) && (paramInt >= ((Integer)localPair.first).intValue()))
                        {
                          m = ((Integer)localPair.second).intValue();
                          if (paramInt <= m) {
                            return true;
                          }
                        }
                      }
                      catch (Exception localException)
                      {
                        localException.printStackTrace();
                        return false;
                      }
                    }
                  }
                }
              }
            }
          }
        } while (!SPEventReportSwitch.a(paramInt));
        return true;
      } while (NetConnInfoCenter.getServerTime() - k >= jdField_c_of_type_Long);
      return true;
      localAppRuntime = onh.a();
    } while ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface)) || (!BaseActivity.mAppForground) || (!SPEventReportSwitch.a(paramInt)));
    return true;
  }
  
  public static void d()
  {
    h = NetConnInfoCenter.getServerTime();
  }
  
  public static void d(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.17(paramInt));
  }
  
  public static void d(boolean paramBoolean)
  {
    if (paramBoolean) {}
    do
    {
      return;
      qae.a();
      ReadInJoyDailyFragment.b();
    } while (ota.jdField_a_of_type_Int == 2);
    ota.c();
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.12(a(a())));
  }
  
  public static void e()
  {
    i = System.currentTimeMillis();
  }
  
  public static void e(int paramInt)
  {
    Object localObject = vxy.a();
    if (TextUtils.equals((CharSequence)localObject, (String)bhvy.a("dau_report_type_" + paramInt, "")))
    {
      QLog.d("ReadinjoySPEventReport", 2, "has report dau for type today, type :" + paramInt);
      return;
    }
    bhvy.a("dau_report_type_" + paramInt, localObject);
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("Type");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramInt + "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    sgg.a(94, localArrayList);
  }
  
  public static void f()
  {
    c(true);
  }
  
  private void f(int paramInt)
  {
    if (c(12))
    {
      ArrayList localArrayList = new ArrayList();
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("Type");
      localAttributeList.att_value.set(String.valueOf(paramInt));
      localArrayList.add(localAttributeList);
      sgg.a(12, localArrayList);
    }
  }
  
  private static void f(boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.3(paramBoolean));
  }
  
  public static void g()
  {
    if (jdField_e_of_type_Boolean) {
      return;
    }
    jdField_e_of_type_Boolean = true;
    try
    {
      osn.a();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      BaseApplicationImpl.getContext().registerReceiver(jdField_a_of_type_Oth, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void i()
  {
    d(true);
  }
  
  public static void j()
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.14());
  }
  
  public static void k() {}
  
  public static void l()
  {
    sgg.a(71, new ArrayList());
  }
  
  public static void m()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("daily_folderstatus");
    localAttributeList.att_value.set(olj.a());
    localArrayList.add(localAttributeList);
    sgg.a(91, localArrayList);
  }
  
  public static void n()
  {
    l = System.currentTimeMillis();
  }
  
  private void p() {}
  
  private static void q()
  {
    ThreadManager.getSubThreadHandler().post(new ReadinjoySPEventReport.4());
  }
  
  private void r()
  {
    if (c(14))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_Osz.a);
      localArrayList.add(this.jdField_a_of_type_Osz.c);
      localArrayList.add(this.jdField_a_of_type_Osz.d);
      sgg.a(14, localArrayList);
    }
  }
  
  public ArrayList<oidb_cmd0x80a.AttributeList> a(int paramInt)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList = new ArrayList();
    if (BaseApplicationImpl.sProcessId != 1) {
      return localArrayList;
    }
    Object localObject2;
    Object localObject3;
    int m;
    if ((localObject1 != null) && (((QQAppInterface)localObject1).isLogin()))
    {
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(0);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("UnreadMsg");
      localObject3 = ((QQAppInterface)localObject1).a();
      if (localObject3 != null)
      {
        m = ((QQMessageFacade)localObject3).b();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(String.valueOf(m));
        localArrayList.add(localObject2);
      }
    }
    for (;;)
    {
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(100);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("FolderStatus");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(String.valueOf(onh.jdField_d_of_type_Int));
      localArrayList.add(localObject2);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(101);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("KDInScreen");
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      if (onh.c((QQAppInterface)localObject1)) {}
      for (localObject1 = String.valueOf(1);; localObject1 = String.valueOf(0))
      {
        ((PBStringField)localObject3).set((String)localObject1);
        localArrayList.add(localObject2);
        localObject1 = sgg.b();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(102);
          ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("KDAttrL");
          ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
          localArrayList.add(localObject2);
        }
        localObject1 = new StringBuilder(1024);
        if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
          break label424;
        }
        localObject2 = new ArrayList(this.jdField_b_of_type_JavaUtilList);
        n = 0;
        while (n < ((ArrayList)localObject2).size())
        {
          localObject3 = (Pair)((ArrayList)localObject2).get(n);
          if (n != 0) {
            ((StringBuilder)localObject1).append("`");
          }
          ((StringBuilder)localObject1).append(String.valueOf(((Pair)localObject3).first));
          if (n != 0) {
            ((StringBuilder)localObject1).append(":").append(String.valueOf(((Pair)localObject3).second));
          }
          n += 1;
        }
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      label424:
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(103);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("LeftBtmRedPntPulse");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((StringBuilder)localObject1).toString());
      localArrayList.add(localObject2);
      ((StringBuilder)localObject1).setLength(0);
      ((StringBuilder)localObject1).trimToSize();
      if (this.jdField_c_of_type_JavaUtilList.size() > 0)
      {
        localObject2 = new ArrayList(this.jdField_c_of_type_JavaUtilList);
        n = 0;
        while (n < ((ArrayList)localObject2).size())
        {
          localObject3 = (Pair)((ArrayList)localObject2).get(n);
          if (n != 0) {
            ((StringBuilder)localObject1).append("`");
          }
          ((StringBuilder)localObject1).append(String.valueOf(((Pair)localObject3).first));
          if (n != 0) {
            ((StringBuilder)localObject1).append(":").append(String.valueOf(((Pair)localObject3).second));
          }
          n += 1;
        }
        this.jdField_c_of_type_JavaUtilList.clear();
      }
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(104);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("FirstScnRedPntPulse");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((StringBuilder)localObject1).toString());
      localArrayList.add(localObject2);
      ((StringBuilder)localObject1).setLength(0);
      ((StringBuilder)localObject1).trimToSize();
      if (this.jdField_d_of_type_JavaUtilList.size() > 0)
      {
        localObject2 = new ArrayList(this.jdField_d_of_type_JavaUtilList);
        n = 0;
        while (n < ((ArrayList)localObject2).size())
        {
          localObject3 = (Pair)((ArrayList)localObject2).get(n);
          if (n != 0) {
            ((StringBuilder)localObject1).append("`");
          }
          ((StringBuilder)localObject1).append(String.valueOf(((Pair)localObject3).first));
          if (n != 0) {
            ((StringBuilder)localObject1).append(":").append(String.valueOf(((Pair)localObject3).second));
          }
          n += 1;
        }
        this.jdField_d_of_type_JavaUtilList.clear();
      }
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(105);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("AIOPulse");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((StringBuilder)localObject1).toString());
      localArrayList.add(localObject2);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(106);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("LastRedExposureTime");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(onh.jdField_a_of_type_Long + ":" + onh.jdField_d_of_type_Int);
      localArrayList.add(localObject1);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(107);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("dt_red");
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      long l1;
      if (a())
      {
        localObject1 = String.valueOf(1);
        ((PBStringField)localObject3).set((String)localObject1);
        localArrayList.add(localObject2);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(108);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("last_inforeground_time");
        if (a() <= 0L) {
          break label1310;
        }
        l1 = a();
        label1008:
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(l1 / 1000L));
        localArrayList.add(localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(109);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("last_in_aio_time");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(b()));
        localArrayList.add(localObject1);
        localObject1 = a().a();
        if (localObject1 != null)
        {
          ((osz)localObject1).b.att_id.set(110);
          localArrayList.add(((osz)localObject1).b);
        }
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(112);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("UniversalStateBit");
        localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
        if (!sgg.b()) {
          break label1318;
        }
      }
      int i1;
      label1310:
      label1318:
      for (int n = 1;; n = 0)
      {
        ((PBStringField)localObject2).set(String.valueOf(n));
        localArrayList.add(localObject1);
        i1 = sgg.a(ajsd.aQ);
        localObject3 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(113);
        ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("subscribe_folderstatus");
        localObject1 = olm.a();
        if (paramInt != 70) {
          break label1323;
        }
        n = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (n >= localArrayList.size()) {
            break;
          }
          if (((oidb_cmd0x80a.AttributeList)localArrayList.get(n)).att_id.get() == 2)
          {
            localObject1 = ((oidb_cmd0x80a.AttributeList)localArrayList.get(n)).att_value.get();
            QLog.d("PublicAccountUtil", 2, "replace common kandianSubscribe forderStatus with business value !");
          }
          n += 1;
        }
        localObject1 = String.valueOf(0);
        break;
        l1 = System.currentTimeMillis();
        break label1008;
      }
      label1323:
      localObject2 = localObject1;
      ((oidb_cmd0x80a.AttributeList)localObject3).att_value.set((String)localObject2);
      localArrayList.add(localObject3);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(114);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("subscribe_msgbox_pos");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(i1));
      localArrayList.add(localObject1);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(115);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("subscribe_in_screen");
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      if ((i1 >= 0) && (i1 + 1 <= onh.jdField_a_of_type_Int)) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        ((PBStringField)localObject3).set((String)localObject1);
        localArrayList.add(localObject2);
        localObject1 = vym.c(BaseApplicationImpl.getContext());
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(116);
          ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("wifiName");
          ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1 + "");
          localArrayList.add(localObject2);
        }
        localObject1 = olj.a();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1696;
        }
        localObject3 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(117);
        ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("daily_folderstatus");
        if (paramInt != 90) {
          break;
        }
        paramInt = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (paramInt >= localArrayList.size()) {
            break;
          }
          if (((oidb_cmd0x80a.AttributeList)localArrayList.get(paramInt)).att_id.get() == 2)
          {
            localObject1 = ((oidb_cmd0x80a.AttributeList)localArrayList.get(paramInt)).att_value.get();
            QLog.d("PublicAccountUtil", 2, "replace common kandianDaily forderStatus with business value !");
          }
          paramInt += 1;
        }
      }
      localObject2 = localObject1;
      ((oidb_cmd0x80a.AttributeList)localObject3).att_value.set((String)localObject2);
      localArrayList.add(localObject3);
      label1696:
      paramInt = olj.a();
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(118);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("daily_msgbox_pos");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(paramInt));
      localArrayList.add(localObject1);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(119);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("daily_in_screen");
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      if ((paramInt >= 0) && (paramInt + 1 <= onh.jdField_a_of_type_Int))
      {
        localObject1 = "1";
        ((PBStringField)localObject3).set((String)localObject1);
        localArrayList.add(localObject2);
        boolean bool = SettingCloneUtil.readValue(BaseApplicationImpl.getContext(), onh.a(), "", "qqsetting_notify_showcontent_key", true);
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(120);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("PushPreviewQ");
        localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
        if (!bool) {
          break label2800;
        }
        localObject1 = "1";
        label1884:
        ((PBStringField)localObject3).set((String)localObject1);
        localArrayList.add(localObject2);
        bool = FriendsStatusUtil.a(BaseApplicationImpl.getApplication());
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(121);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("NoDisturbAtNight");
        localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
        if (!bool) {
          break label2807;
        }
        localObject1 = "1";
        label1954:
        ((PBStringField)localObject3).set((String)localObject1);
        localArrayList.add(localObject2);
        paramInt = bhvy.a((QQAppInterface)onh.a());
        if (paramInt != -1)
        {
          localObject1 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(122);
          ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("DongTaiKandian");
          ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(paramInt + "");
          localArrayList.add(localObject1);
        }
        localObject1 = bbdh.b(BaseApplicationImpl.getContext());
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(123);
          ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("BSSID");
          ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
          localArrayList.add(localObject2);
        }
        paramInt = oti.a();
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(124);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("MsgListFristDataIsVisable");
        localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
        if (paramInt != 0) {
          break label2814;
        }
        localObject1 = "1";
        label2163:
        ((PBStringField)localObject3).set((String)localObject1);
        localArrayList.add(localObject2);
        localObject1 = onh.d(-1);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(126);
          ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("ScreenInfo");
          ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
          localArrayList.add(localObject2);
        }
        localObject1 = bbdh.e();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).equals("5")) || (((String)localObject1).equals("5.0")) || (((String)localObject1).compareTo("5.0.0") >= 0)))
        {
          localObject2 = ReadInJoyMMapKvStorage.getInstance(a("80aEvent"));
          localObject1 = ((ReadInJoyMMapKvStorage)localObject2).getValeForKey("content");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if ((((ReadInJoyMMapKvStorage)localObject2).getExpiredTime() == 0) || (((ReadInJoyMMapKvStorage)localObject2).getExpiredTime() >= System.currentTimeMillis() / 1000L)) {
              break label2821;
            }
            ((ReadInJoyMMapKvStorage)localObject2).invalidate();
          }
        }
        label2346:
        bool = axmv.a();
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(128);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("is_jcjj_mode");
        localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
        if (!bool) {
          break label2872;
        }
        localObject1 = "1";
        label2399:
        ((PBStringField)localObject3).set((String)localObject1);
        localArrayList.add(localObject2);
        paramInt = ozo.b();
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(129);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("network");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(paramInt + "");
        localArrayList.add(localObject1);
        paramInt = b();
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(130);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("battery");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(paramInt + "");
        localArrayList.add(localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(131);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("sessionID");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(l / 1000L + "");
        localArrayList.add(localObject1);
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(132);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("redDot");
        localObject1 = new StringBuilder().append(m).append("_");
        if (onh.jdField_d_of_type_Int != 1) {
          break label2879;
        }
        paramInt = 0;
        label2684:
        localObject3 = ((StringBuilder)localObject1).append(paramInt).append("_");
        if (!a()) {
          break label2884;
        }
      }
      label2821:
      label2872:
      label2879:
      label2884:
      for (localObject1 = String.valueOf(1);; localObject1 = String.valueOf(0))
      {
        localObject1 = (String)localObject1;
        ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
        localArrayList.add(localObject2);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(133);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("app_install_list");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(a());
        localArrayList.add(localObject1);
        return localArrayList;
        localObject1 = "0";
        break;
        label2800:
        localObject1 = "0";
        break label1884;
        label2807:
        localObject1 = "0";
        break label1954;
        label2814:
        localObject1 = "0";
        break label2163;
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(127);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("FeatureFrameworkAttr");
        ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
        localArrayList.add(localObject2);
        break label2346;
        localObject1 = "0";
        break label2399;
        paramInt = 1;
        break label2684;
      }
      m = 0;
      break;
      m = 0;
    }
  }
  
  public osz a()
  {
    osz localosz = this.jdField_a_of_type_Osz;
    this.jdField_a_of_type_Osz = null;
    return localosz;
  }
  
  public void a()
  {
    ThreadManager.post(new ReadinjoySPEventReport.1(this), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.5(this, paramInt));
  }
  
  public void a(int paramInt1, List paramList, String paramString, int paramInt2, int paramInt3)
  {
    rif.a(2);
    if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3000) || (a(paramInt2)))
    {
      if (paramInt1 == 1) {
        d();
      }
      for (;;)
      {
        ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.6(this, paramInt1, paramList));
        return;
        a(paramInt2, paramInt3, paramList);
      }
    }
    if (paramInt1 == 1)
    {
      e();
      return;
    }
    a().a(paramString, c());
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(String paramString)
  {
    if ("2909288299".equals(paramString)) {
      ota.a(3);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    try
    {
      if ("2909288299".equals(paramString)) {
        b("GetNextMsg");
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadinjoySPEventReport", 2, "reportPubAioMenuAction", paramString);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.11(this, paramString, paramLong));
  }
  
  public void a(String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3)
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
      if (paramBoolean) {}
      for (Object localObject1 = "1";; localObject1 = "0")
      {
        ((PBStringField)localObject2).set((String)localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("Time");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(a(paramLong)));
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
        sgg.a(3, paramString3);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction actType:" + paramString1);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction", paramString1);
      }
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
      a("Enter", paramLong, paramBoolean1, a(paramList), this.jdField_a_of_type_JavaLangStringBuilder.toString());
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      if (paramBoolean2) {
        ota.a();
      }
    }
  }
  
  public void a(String paramString, axup paramaxup)
  {
    if ("2909288299".equals(paramString))
    {
      b("ClickMsg");
      if ((paramaxup != null) && ((paramaxup instanceof axuq)))
      {
        paramString = a((axuq)paramaxup);
        if (!TextUtils.isEmpty(paramString))
        {
          if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
            this.jdField_a_of_type_JavaLangStringBuilder.append("`");
          }
          this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ota.a(2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      shu.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Long);
      if (paramBoolean)
      {
        this.jdField_a_of_type_JavaLangString = "";
        ota.a();
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
      if (paramInt >= 1000)
      {
        bool1 = bool2;
        if (paramInt <= 1034) {
          bool1 = true;
        }
      }
      break;
    }
    return bool1;
  }
  
  public void b()
  {
    try
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int m = ((QQAppInterface)localObject1).a().b();
      boolean bool = onh.c((QQAppInterface)localObject1);
      oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
      localAttributeList1.att_id.set(1);
      localAttributeList1.att_name.set("UnreadMsg");
      localAttributeList1.att_value.set(String.valueOf(m));
      oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
      localAttributeList2.att_id.set(2);
      localAttributeList2.att_name.set("KDInScreen");
      Object localObject2 = localAttributeList2.att_value;
      if (bool) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        ((PBStringField)localObject2).set((String)localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("FoldStatus");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(onh.jdField_d_of_type_Int + "");
        localObject2 = new ArrayList(3);
        ((List)localObject2).add(localAttributeList1);
        ((List)localObject2).add(localAttributeList2);
        ((List)localObject2).add(localObject1);
        sgg.a(1, (List)localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadinjoySPEventReport", 2, "reportManualRefresMsg unRead:" + m + " isFirst:" + bool);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "reportManualRefresMsg", localException);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt * 1000);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = a(paramInt);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ota.a(2);
  }
  
  public void b(String paramString)
  {
    try
    {
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("ActType");
      localAttributeList.att_value.set(paramString);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localAttributeList);
      sgg.a(3, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction actType:" + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction", paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    a(true);
  }
  
  public long d()
  {
    return jdField_d_of_type_Long;
  }
  
  public void h()
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.7(this));
    this.jdField_g_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osx
 * JD-Core Version:    0.7.0.1
 */