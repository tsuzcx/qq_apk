package cooperation.qzone.report.lp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import blru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class LpReportInfo_dc03950
  implements LpReportInfo
{
  public static final String AD_ID_ANNIVERSARY = "171624";
  public static final String AD_ID_COMMENTS = "171620";
  public static final String AD_ID_EXPIRED = "168604";
  public static final String AD_ID_LEAVE_COMMENTS = "171617";
  public static final String AD_ID_LIKE = "171629";
  public static final String AD_ID_VISTOR = "171621";
  public static final String LOVECHATTING_ACTION_TYPE = "16";
  public static final String LOVECHATTING_OPERATION_TYPE_CLICK = "2";
  public static final String LOVECHATTING_OPERATION_TYPE_EXPOSE = "1";
  public static final String LOVECHATTING_RESERVES_C2C_CHATTING_GRAY = "";
  public static final String LOVECHATTING_SUBACTION_TYPE = "1";
  public static final String LOVE_AIO_KEY = "6";
  public static final String LOVE_GRAYTIP_CLOSE = "7";
  public static final String LOVE_GRAYTIP_CLOSE_BEFORE = "8";
  public static final String LOVE_INTERACTIVE_LOGO = "1";
  public static final String LOVE_INTIMACY = "2";
  public static final String LOVE_PASSIVE_FEEDS = "7";
  public static final String LOVE_QZONE_FEEDS_TAIL = "5";
  public static final String LOVE_QZONE_FEEDS_TAIL_GUEST = "9";
  public static final String LOVE_QZONE_HOME_PAGE_PANEL = "3";
  public static final String LOVE_QZONE_HOME_PAGE_PANEL_GUEST = "8";
  public static final String LOVE_QZONE_WIDGET = "4";
  public static final String LOVE_SETTING_ME = "10";
  public static final String LOVE_SLIDE_RESERVES_C2C = "1";
  public static final String LOVE_SLIDE_SUBACTION_TYPE = "6";
  public static final String LOVE_UNKNOWN = "0";
  public static final List<String> LOVE_ZONE_SETTING_ME_RESERVES_LIST = Arrays.asList(new String[] { "168604", "171624", "171621", "171620", "171617", "171629" });
  public static final String LOVE_ZONE_STATIONARY_ADDRESS = "25";
  public static final String REPORT_USER_TYPE_LOVE = "1";
  public static final String REPORT_USER_TYPE_SINGLE = "2";
  public static String TAG = "LpReport.LpReportInfo_dc03950";
  public String actiontype;
  public HashMap<String, String> extraInfoMap;
  private boolean isNeedSample;
  private boolean isReportNow;
  public String operation_type;
  public String qua;
  public String reserves;
  public String subactiontype;
  public long uin;
  public String usertype;
  
  public LpReportInfo_dc03950(String paramString1, String paramString2)
  {
    this.actiontype = paramString1;
    this.subactiontype = paramString2;
    this.isNeedSample = false;
    this.isReportNow = false;
  }
  
  public LpReportInfo_dc03950(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2);
    this.reserves = paramString3;
  }
  
  public LpReportInfo_dc03950(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramString2);
    this.reserves = paramString3;
    this.operation_type = paramString4;
  }
  
  public LpReportInfo_dc03950(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramString2);
    this.reserves = paramString3;
    this.operation_type = paramString4;
    this.usertype = paramString5;
  }
  
  public LpReportInfo_dc03950(String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap)
  {
    this(paramString1, paramString2, paramString3);
    this.extraInfoMap = paramHashMap;
  }
  
  public static String getReportUserType(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
      if (localSharedPreferences != null)
      {
        if (localSharedPreferences.getInt("love_state_for_current_uin" + paramQQAppInterface.c(), 0) == 1) {
          return "1";
        }
        return "2";
      }
    }
    return "2";
  }
  
  public static void report(LpReportInfo_dc03950 paramLpReportInfo_dc03950)
  {
    LpReportManager.getInstance().reportToDC03950(paramLpReportInfo_dc03950, paramLpReportInfo_dc03950.isNeedSample, paramLpReportInfo_dc03950.isReportNow);
  }
  
  public String getSimpleInfo()
  {
    return "dc03950:" + this.actiontype + "," + this.subactiontype + "," + this.reserves + "," + this.operation_type;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    LpReportUtils.safePut(localHashMap, "qua", blru.a());
    if (this.uin == 0L) {}
    for (String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();; str = String.valueOf(this.uin))
    {
      LpReportUtils.safePut(localHashMap, "uin", str);
      LpReportUtils.safePut(localHashMap, "actiontype", this.actiontype);
      LpReportUtils.safePut(localHashMap, "subactiontype", this.subactiontype);
      LpReportUtils.safePut(localHashMap, "reserves", this.reserves);
      LpReportUtils.safePut(localHashMap, "usertype", this.usertype);
      if (!TextUtils.isEmpty(this.operation_type)) {
        LpReportUtils.safePut(localHashMap, "operationtype", this.operation_type);
      }
      if ((this.extraInfoMap != null) && (this.extraInfoMap.size() > 0)) {
        localHashMap.putAll(this.extraInfoMap);
      }
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc03950
 * JD-Core Version:    0.7.0.1
 */