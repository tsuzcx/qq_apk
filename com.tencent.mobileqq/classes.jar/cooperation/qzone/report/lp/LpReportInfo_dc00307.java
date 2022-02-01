package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import com.tencent.util.QQDeviceInfo;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_dc00307
  implements LpReportInfo
{
  public static final int ACTION_ID_CLICK = 2;
  public static final int ACTION_ID_EXPOSURE = 1;
  public static final int ACTION_ID_RECEIVE_PUSH = 4;
  public static final int ACTION_ID_WEBVIEW_LOADED = 6;
  public static final int ACTION_ID_WEBVIEW_START = 5;
  public static int ACTION_TYPE_RED_PACK = 48;
  public static final int MODULE_ID_1 = 1;
  public static final int MODULE_ID_2 = 2;
  public static final int MODULE_ID_3 = 3;
  public static final int PAGE_ID_ACTIVE_TAB_VIEW = 160;
  public static final int PAGE_ID_CONTACTS_TAB = 161;
  public static final int PAGE_ID_HEALTH_ACCOUNT_DETAIL = 162;
  public static final int PAGE_ID_HEALTH_CONTACT = 165;
  public static final int PAGE_ID_HEALTH_NEW_WEB_VIEW = 159;
  public static final int PAGE_ID_HEALTH_PUSH_MESSAGE = 158;
  public static final int PAGE_ID_HEALTH_SEARCH = 164;
  public static final int PAGE_ID_MESSAGE_TAB = 157;
  public static final int PAGE_ID_MESSAGE_TAB_HEALTH_BANER = 163;
  public static int SUB_ACTION_TYPE_RED_PACK_CLICK = 27;
  public static int SUB_ACTION_TYPE_RED_PACK_EXPOSURE = 26;
  public static final int platform_id = 2;
  public int act_id;
  public int act_type;
  public long data2 = -1L;
  public String ext0;
  public String ext1;
  public int module_id;
  public int page_id = -1;
  public int src_id = -1;
  public int success_or_not = -1;
  public String uin;
  
  public LpReportInfo_dc00307() {}
  
  public LpReportInfo_dc00307(int paramInt1, int paramInt2, int paramInt3)
  {
    this.act_id = paramInt1;
    this.act_type = paramInt2;
    this.module_id = paramInt3;
  }
  
  public String getSimpleInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dc00307:");
    localStringBuilder.append(this.act_id);
    localStringBuilder.append(",");
    localStringBuilder.append(this.act_type);
    return localStringBuilder.toString();
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount())) {
      LpReportUtils.safePut(localHashMap, "uin", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount());
    }
    int i = this.page_id;
    if (i >= 0) {
      LpReportUtils.safePut(localHashMap, "page_id", i);
    }
    i = this.src_id;
    if (i >= 0) {
      LpReportUtils.safePut(localHashMap, "src_id", i);
    }
    LpReportUtils.safePut(localHashMap, "act_id", this.act_id);
    LpReportUtils.safePut(localHashMap, "act_type", this.act_type);
    LpReportUtils.safePut(localHashMap, "platform_id", 2);
    LpReportUtils.safePut(localHashMap, "qq_version", "8.8.17.5770");
    LpReportUtils.safePut(localHashMap, "imei", QQDeviceInfo.getIMEI("52b7f2"));
    LpReportUtils.safePut(localHashMap, "module_id", this.module_id);
    LpReportUtils.safePut(localHashMap, "data_timestamp", String.valueOf(System.currentTimeMillis()));
    LpReportUtils.safePut(localHashMap, "ext0", this.ext0);
    LpReportUtils.safePut(localHashMap, "ext1", this.ext1);
    i = this.success_or_not;
    if (i >= 0) {
      LpReportUtils.safePut(localHashMap, "success_or_not", i);
    }
    long l = this.data2;
    if (l >= 0L) {
      LpReportUtils.safePut(localHashMap, "data2", String.valueOf(l));
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc00307
 * JD-Core Version:    0.7.0.1
 */