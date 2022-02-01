package cooperation.ilive.lite.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;
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
  public static int b;
  private RoomExtInfo jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private RoomExtInfo jdField_b_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d = true;
  private boolean e = true;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 0;
  }
  
  public static int a()
  {
    String str = BusinessManager.a.b();
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
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
        QLog.e("IliveLiteDataReport", 1, "getStartTime error " + localException);
      }
    }
    return -1L;
  }
  
  public static IliveLiteDataReport a()
  {
    if (jdField_a_of_type_CooperationIliveLiteReportIliveLiteDataReport == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationIliveLiteReportIliveLiteDataReport == null) {
        jdField_a_of_type_CooperationIliveLiteReportIliveLiteDataReport = new IliveLiteDataReport();
      }
      return jdField_a_of_type_CooperationIliveLiteReportIliveLiteDataReport;
    }
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
      for (;;)
      {
        paramReportParams.printStackTrace();
      }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appid = " + paramString1);
    localStringBuilder.append("，pageId = " + paramString2);
    localStringBuilder.append("，itemId = " + paramString3);
    localStringBuilder.append("，moduleId = " + paramString4);
    localStringBuilder.append("，subModuleId = " + paramString5);
    localStringBuilder.append("，itemType = " + paramString6);
    localStringBuilder.append("，actionId = " + paramInt);
    localStringBuilder.append("，busiInfo = " + paramString7);
    QLog.i("IliveLiteDataReport", 1, "isHeart = " + paramBoolean + " live report action : " + localStringBuilder.toString());
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
    if (this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo != null) {
      return this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo.programId;
    }
    return "";
  }
  
  private String c()
  {
    if (this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo != null) {
      return this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo.anchorUid;
    }
    return "";
  }
  
  private String d()
  {
    if (this.jdField_b_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo != null) {
      return this.jdField_b_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo.programId;
    }
    return "";
  }
  
  private String e()
  {
    if (this.jdField_b_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo != null) {
      return this.jdField_b_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo.anchorUid;
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
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_first_enter", str);
      this.jdField_a_of_type_Boolean = false;
      QLog.e("IliveLiteDataReport", 1, "oncreate room " + (l1 - l2));
      VasStatisticCollector.a("lite_oncreateroom", localHashMap, l1 - l2);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    QLog.e("IliveLiteDataReport", 1, " onH5LoadSuccessReport time = " + paramLong);
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
  
  public void a(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong1);
    int i;
    String str;
    if (paramBoolean1)
    {
      i = 1;
      localReportParams.jdField_a_of_type_Int = i;
      if (!paramBoolean1) {
        break label131;
      }
      if (!paramBoolean2) {
        break label122;
      }
      str = this.jdField_a_of_type_JavaLangString;
    }
    label50:
    for (localReportParams.d = str;; localReportParams.d = this.jdField_a_of_type_JavaLangString)
    {
      if (TextUtils.isEmpty(localReportParams.d)) {
        localReportParams.d = this.jdField_a_of_type_JavaLangString;
      }
      localReportParams.jdField_b_of_type_Int = paramInt;
      localReportParams.jdField_a_of_type_Long = paramLong2;
      a("qq_live", "room_page", "", "room", "", 210, a(localReportParams), true);
      return;
      i = 0;
      break;
      label122:
      str = this.jdField_b_of_type_JavaLangString;
      break label50;
    }
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
    long l1;
    long l2;
    if (this.e)
    {
      this.e = false;
      l1 = System.currentTimeMillis();
      l2 = a();
      if (l2 > 0L) {}
    }
    else
    {
      return;
    }
    l1 -= l2;
    HashMap localHashMap = new HashMap();
    if (this.jdField_b_of_type_Boolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_first_enter", str);
      this.jdField_b_of_type_Boolean = false;
      QLog.e("IliveLiteDataReport", 1, " onFirstFrame " + l1);
      VasStatisticCollector.a("lite_onfirstframe", localHashMap, l1);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong);
    localReportParams.jdField_a_of_type_Int = a();
    localReportParams.g = e();
    localReportParams.f = d();
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
    long l1;
    long l2;
    if (this.d)
    {
      this.d = false;
      l1 = System.currentTimeMillis();
      l2 = a();
      if (l2 > 0L) {}
    }
    else
    {
      return;
    }
    l1 -= l2;
    HashMap localHashMap = new HashMap();
    if (this.jdField_c_of_type_Boolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_first_enter", str);
      this.jdField_c_of_type_Boolean = false;
      QLog.e("IliveLiteDataReport", 1, " onH5LoadFinish " + l1);
      VasStatisticCollector.a("lite_H5_load_finish", localHashMap, l1);
      return;
    }
  }
  
  public void c(long paramLong)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong);
    localReportParams.jdField_a_of_type_Int = a();
    localReportParams.g = e();
    localReportParams.f = d();
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
    this.d = true;
    this.e = true;
  }
  
  public void d(long paramLong)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong);
    a("qq_live", "room_page", "", "bottom_end_toast", "", 101, a(localReportParams));
  }
  
  public void e(long paramLong)
  {
    IliveLiteDataReport.ReportParams localReportParams = new IliveLiteDataReport.ReportParams(this);
    localReportParams.e = String.valueOf(paramLong);
    localReportParams.jdField_a_of_type_Int = a();
    localReportParams.jdField_b_of_type_Int = 2;
    a("qq_live", "room_page", "", "open_page", "", 153, a(localReportParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.report.IliveLiteDataReport
 * JD-Core Version:    0.7.0.1
 */