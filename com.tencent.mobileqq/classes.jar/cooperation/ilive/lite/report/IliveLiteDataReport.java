package cooperation.ilive.lite.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.mobilereport.MobileReportManager.ActionInfoBuilder;
import cooperation.qzone.mobilereport.MobileReportManager.ItemInfoBuilder;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import org.json.JSONException;
import org.json.JSONObject;

public class IliveLiteDataReport
{
  public static int a;
  public static long a;
  private static IliveLiteDataReport jdField_a_of_type_CooperationIliveLiteReportIliveLiteDataReport;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static boolean a;
  public static int b;
  private RoomExtInfo jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
  private String jdField_a_of_type_JavaLangString;
  private RoomExtInfo jdField_b_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d = true;
  private boolean e = true;
  private boolean f = true;
  
  static
  {
    jdField_a_of_type_Int = 1001;
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
  }
  
  public static int a()
  {
    String str = BusinessManager.a.b();
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label14:
      break label14;
    }
    return 0;
  }
  
  private long a()
  {
    Object localObject = BusinessManager.a.a();
    if ((localObject != null) && (((EnterRoomConfig)localObject).extData != null))
    {
      localObject = RoomManager.a(((EnterRoomConfig)localObject).extData.getString("mqqschema"));
      try
      {
        long l = Long.parseLong((String)((Map)localObject).get("starttime"));
        return l;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getStartTime error ");
        localStringBuilder.append(localException);
        QLog.e("IliveLiteDataReport", 1, localStringBuilder.toString());
      }
    }
    return -1L;
  }
  
  public static IliveLiteDataReport a()
  {
    if (jdField_a_of_type_CooperationIliveLiteReportIliveLiteDataReport == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_CooperationIliveLiteReportIliveLiteDataReport == null) {
          jdField_a_of_type_CooperationIliveLiteReportIliveLiteDataReport = new IliveLiteDataReport();
        }
      }
    }
    return jdField_a_of_type_CooperationIliveLiteReportIliveLiteDataReport;
  }
  
  public static String a(IliveLiteDataReport.ReportParams paramReportParams)
  {
    if (paramReportParams == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("zt_str1", paramReportParams.jdField_a_of_type_JavaLangString);
      localJSONObject.put("zt_str2", paramReportParams.jdField_b_of_type_JavaLangString);
      localJSONObject.put("zt_str3", paramReportParams.jdField_c_of_type_JavaLangString);
      localJSONObject.put("zt_str4", paramReportParams.d);
      localJSONObject.put("zt_str4", paramReportParams.d);
      localJSONObject.put("zt_int1", String.valueOf(paramReportParams.jdField_a_of_type_Int));
      localJSONObject.put("zt_int2", String.valueOf(paramReportParams.jdField_b_of_type_Int));
      localJSONObject.put("zt_int3", String.valueOf(paramReportParams.jdField_c_of_type_Int));
      localJSONObject.put("program_id", paramReportParams.f);
      localJSONObject.put("roomid", paramReportParams.e);
      localJSONObject.put("ab_token", paramReportParams.h);
      localJSONObject.put("anchor", paramReportParams.g);
      if (paramReportParams.jdField_a_of_type_Long > 0L) {
        localJSONObject.put("timelong", String.valueOf(paramReportParams.jdField_a_of_type_Long));
      }
      localJSONObject.put("report_from", "2");
    }
    catch (JSONException paramReportParams)
    {
      paramReportParams.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    a(paramString1, paramString2, paramString3, paramString4, "", paramString5, paramInt, paramString6, false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, "", paramString5, paramInt, paramString6, paramBoolean);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("appid = ");
    localStringBuilder2.append(paramString1);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("，pageId = ");
    localStringBuilder2.append(paramString2);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("，itemId = ");
    localStringBuilder2.append(paramString3);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("，moduleId = ");
    localStringBuilder2.append(paramString4);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("，subModuleId = ");
    localStringBuilder2.append(paramString5);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("，itemType = ");
    localStringBuilder2.append(paramString6);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("，actionId = ");
    localStringBuilder2.append(paramInt);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("，busiInfo = ");
    localStringBuilder2.append(paramString7);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("isHeart = ");
    localStringBuilder2.append(paramBoolean);
    localStringBuilder2.append(" live report action : ");
    localStringBuilder2.append(localStringBuilder1.toString());
    QLog.i("IliveLiteDataReport", 1, localStringBuilder2.toString());
    paramString3 = new MobileReportManager.ItemInfoBuilder().setItemId(paramString3).setBusiInfo(paramString7).setModuleId(paramString4).setSubModuleId(paramString5).setItemType(paramString6).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt, 0L).build()).build();
    if (paramBoolean)
    {
      MobileReportManager.getInstance().reportActionLiveHeart(paramString1, paramString2, paramString3);
      return;
    }
    MobileReportManager.getInstance().reportActionLive(paramString1, paramString2, paramString3);
  }
  
  private String b()
  {
    RoomExtInfo localRoomExtInfo = this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
    if (localRoomExtInfo != null) {
      return localRoomExtInfo.programId;
    }
    return "";
  }
  
  private String c()
  {
    RoomExtInfo localRoomExtInfo = this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
    if (localRoomExtInfo != null) {
      return localRoomExtInfo.anchorUid;
    }
    return "";
  }
  
  private String d()
  {
    RoomExtInfo localRoomExtInfo = this.jdField_b_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
    if (localRoomExtInfo != null) {
      return localRoomExtInfo.programId;
    }
    return "";
  }
  
  private String e()
  {
    RoomExtInfo localRoomExtInfo = this.jdField_b_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
    if (localRoomExtInfo != null) {
      return localRoomExtInfo.anchorUid;
    }
    return "";
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = a();
    if (l2 <= 0L) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (this.jdField_b_of_type_Boolean) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("is_first_enter", localObject);
    this.jdField_b_of_type_Boolean = false;
    l1 -= l2;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("oncreate room ");
    ((StringBuilder)localObject).append(l1);
    QLog.e("IliveLiteDataReport", 1, ((StringBuilder)localObject).toString());
    VasStatisticCollector.a("lite_oncreateroom", localHashMap, l1);
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onH5LoadSuccessReport time = ");
    localStringBuilder.append(paramLong);
    QLog.e("IliveLiteDataReport", 1, localStringBuilder.toString());
    VasStatisticCollector.b("lite_H5_load_success", paramLong, new Pair[0]);
  }
  
  public void a(long paramLong, int paramInt)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong);
    localReportParams.jdField_a_of_type_Int = paramInt;
    localReportParams.jdField_b_of_type_Int = 1;
    a("qq_live", "room_page", "", "open_page", "", 153, a(localReportParams));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong1);
    localReportParams.jdField_a_of_type_Long = paramLong2;
    a("qq_live", "room_page", "", "switch", "", 209, a(localReportParams));
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong1);
    localReportParams.jdField_a_of_type_Int = a();
    localReportParams.jdField_b_of_type_Int = paramInt;
    localReportParams.jdField_a_of_type_Long = paramLong2;
    a("qq_live", "room_page", "", "client_quit", "", 154, a(localReportParams));
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong1);
    localReportParams.jdField_a_of_type_Int = a();
    localReportParams.jdField_b_of_type_Int = paramInt1;
    localReportParams.jdField_c_of_type_Int = paramInt2;
    localReportParams.jdField_a_of_type_Long = paramLong2;
    a("qq_live", "room_page", "", "video_layer", "", 133, a(localReportParams));
  }
  
  public void a(RoomExtInfo paramRoomExtInfo)
  {
    this.jdField_b_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo = this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo = paramRoomExtInfo;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if (this.f)
    {
      this.f = false;
      long l2 = System.currentTimeMillis();
      long l1 = a();
      if (l1 <= 0L) {
        return;
      }
      l2 -= l1;
      HashMap localHashMap = new HashMap();
      if (this.jdField_c_of_type_Boolean) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      localHashMap.put("is_first_enter", localObject1);
      Object localObject1 = BusinessManager.a.a();
      Object localObject4;
      if ((BusinessManager.a.c()) && (localObject1 != null) && (((BusinessConfig)localObject1).a != null))
      {
        localObject4 = (String)((BusinessConfig)localObject1).a.get("is_float_window_in");
        localObject2 = (String)((BusinessConfig)localObject1).a.get("has_rtmp");
        localObject1 = (String)((BusinessConfig)localObject1).a.get("is_process_launch");
      }
      else
      {
        localObject3 = "0";
        localObject1 = localObject3;
        localObject2 = localObject1;
        localObject4 = localObject1;
        localObject1 = localObject3;
      }
      localHashMap.put("is_float_window_in", localObject4);
      Object localObject3 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject3 = "0";
      }
      localHashMap.put("has_rtmp", localObject3);
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "0";
      }
      localHashMap.put("is_process_init", localObject2);
      this.jdField_c_of_type_Boolean = false;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" real report：onFirstFrame ");
      ((StringBuilder)localObject1).append(l2);
      QLog.e("LiteMonitorTag", 1, ((StringBuilder)localObject1).toString());
      VasStatisticCollector.a("lite_onfirstframe", localHashMap, l2);
      IliveLiteMonitorUtil.a("live_on_first_frame", l1);
      IliveLiteMonitorUtil.a("live_on_first_frame", localHashMap);
      IliveLiteMonitorUtil.c("live_activity_frame");
      IliveLiteMonitorUtil.d();
      IliveLiteMonitorUtil.b("live_enter_tick_time");
    }
  }
  
  public void b(long paramLong)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong);
    localReportParams.jdField_a_of_type_Int = a();
    localReportParams.g = e();
    localReportParams.f = d();
    String str;
    if (jdField_a_of_type_Boolean) {
      str = "1";
    } else {
      str = "0";
    }
    localReportParams.jdField_b_of_type_JavaLangString = str;
    localReportParams.d = this.jdField_b_of_type_JavaLangString;
    a("qq_live", "room_page", "", "room", "", 206, a(localReportParams));
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong1);
    localReportParams.jdField_a_of_type_Long = paramLong2;
    a("qq_live", "room_page", "", "switch", "", 208, a(localReportParams));
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong1);
    localReportParams.jdField_a_of_type_Int = a();
    localReportParams.jdField_b_of_type_Int = paramInt;
    localReportParams.jdField_a_of_type_Long = paramLong2;
    a("qq_live", "room_page", "", "room", "cmd_success", "", 153, a(localReportParams), false);
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = "";
    }
  }
  
  public void c()
  {
    if (this.e)
    {
      this.e = false;
      long l1 = System.currentTimeMillis();
      long l2 = a();
      if (l2 <= 0L) {
        return;
      }
      l1 -= l2;
      HashMap localHashMap = new HashMap();
      if (this.d) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_first_enter", localObject);
      this.d = false;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onH5LoadFinish ");
      ((StringBuilder)localObject).append(l1);
      QLog.e("IliveLiteDataReport", 1, ((StringBuilder)localObject).toString());
      VasStatisticCollector.a("lite_H5_load_finish", localHashMap, l1);
    }
  }
  
  public void c(long paramLong)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong);
    localReportParams.jdField_a_of_type_Int = a();
    localReportParams.g = e();
    localReportParams.f = d();
    String str;
    if (jdField_a_of_type_Boolean) {
      str = "1";
    } else {
      str = "0";
    }
    localReportParams.jdField_b_of_type_JavaLangString = str;
    localReportParams.d = this.jdField_b_of_type_JavaLangString;
    a("qq_live", "room_page", "", "room", "", 207, a(localReportParams));
  }
  
  public void c(long paramLong1, long paramLong2, int paramInt)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong1);
    localReportParams.jdField_a_of_type_Int = a();
    localReportParams.jdField_b_of_type_Int = paramInt;
    localReportParams.jdField_a_of_type_Long = paramLong2;
    a("qq_live", "room_page", "", "see_flow", "", 153, a(localReportParams));
  }
  
  public void d()
  {
    this.e = true;
    this.f = true;
  }
  
  public void d(long paramLong)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong);
    a("qq_live", "room_page", "", "bottom_end_toast", "", 101, a(localReportParams));
  }
  
  public void d(long paramLong1, long paramLong2, int paramInt)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong1);
    localReportParams.jdField_a_of_type_Long = paramLong2;
    localReportParams.jdField_a_of_type_JavaLangString = String.valueOf(paramInt);
    a("qq_live", "room_page", "close", "small_window", "25", 102, a(localReportParams));
  }
  
  public void e(long paramLong)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong);
    localReportParams.jdField_a_of_type_Int = a();
    localReportParams.jdField_b_of_type_Int = 2;
    a("qq_live", "room_page", "", "open_page", "", 153, a(localReportParams));
  }
  
  public void f(long paramLong)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    a("qq_live", "room_page", localStringBuilder.toString(), "small_window", "25", 101, a(localReportParams));
  }
  
  public void g(long paramLong)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong);
    a("qq_live", "room_page", "small_window", "small_window", "25", 102, a(localReportParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.report.IliveLiteDataReport
 * JD-Core Version:    0.7.0.1
 */