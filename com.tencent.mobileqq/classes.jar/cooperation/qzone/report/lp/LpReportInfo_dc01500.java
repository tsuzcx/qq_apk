package cooperation.qzone.report.lp;

import android.os.Build;
import android.os.Build.VERSION;
import blru;
import com.tencent.common.app.BaseApplicationImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class LpReportInfo_dc01500
  implements LpReportInfo
{
  public static final int DC00321_ACTION_TYPE = 8;
  public static final int DC00321_RESERVE_DOWNLOAD = 2;
  public static final int DC00321_RESERVE_FETCH_CONFIG = 1;
  public static final int DC00321_RESERVE_INSTALL = 3;
  public static final int DC00321_RESERVE_LAUNCH = 4;
  public static final int DC00321_SUB_ACTION_TYPE = 137;
  public static final int ERR_DOWNLOAD_CANCEL = 3;
  public static final int ERR_DOWNLOAD_CANCELED = 1;
  public static final int ERR_DOWNLOAD_FAILED = 2;
  public static final int ERR_INSTALL_EXTRACTLIBS = 3;
  public static final int ERR_INSTALL_EXTRACT_LIBS_TIME_COST = 101;
  public static final int ERR_INSTALL_FILE_NOT_EXIST = 1;
  public static final int ERR_INSTALL_LZMA_TIME_COST = 100;
  public static final int ERR_INSTALL_MD5_NOT_MATCH = 4;
  public static final int ERR_INSTALL_RENAME = 2;
  public static final int ERR_INSTALL_UNCOMPRESS_LZMA = 5;
  public static final int ERR_LAUNCH_NO_ACCOUNT = 6;
  public static final int ERR_LAUNCH_NO_INSTALLED = 7;
  public static final int ERR_LAUNCH_NO_NETWORK = 4;
  public static final int ERR_LAUNCH_PARAMS = 3;
  public static final int ERR_LAUNCH_PLUGIN_UPDATING = 5;
  public static final int ERR_LAUNCH_QQ_PHONE = 2;
  public static final int ERR_LAUNCH_SDK = 1;
  public static final int ERR_OK = 0;
  public static final String EVENT_DOWNLOAD = "event_download";
  public static final String EVENT_FETCH_CONFIG = "event_fetch_config";
  public static final String EVENT_INSTALL = "event_install";
  public static final String EVENT_LAUNCH = "event_launch";
  private static int S_EVENT_INDEX;
  public String attach_info = "";
  public String client_time = "";
  public String download_id = "";
  public int download_type;
  public String event_id = "";
  public int event_index;
  public String network_type = "";
  public String network_type2 = "";
  public String plugin_id = "";
  public String plugin_version = "";
  public String plugin_version2 = "";
  public String qua = "";
  public int ret_code;
  public double time_cost;
  public String uin = "";
  
  public static String getClientTime()
  {
    Date localDate = new Date(System.currentTimeMillis());
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(localDate);
  }
  
  public static void reportConfig(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    LpReportInfo_dc01500 localLpReportInfo_dc01500 = new LpReportInfo_dc01500();
    localLpReportInfo_dc01500.uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localLpReportInfo_dc01500.qua = blru.a();
    localLpReportInfo_dc01500.plugin_id = paramString1;
    localLpReportInfo_dc01500.event_id = "event_fetch_config";
    paramInt = S_EVENT_INDEX;
    S_EVENT_INDEX = paramInt + 1;
    localLpReportInfo_dc01500.event_index = paramInt;
    localLpReportInfo_dc01500.plugin_version = paramString2;
    localLpReportInfo_dc01500.plugin_version2 = paramString3;
    LpReportManager.getInstance().reportToDC01500(localLpReportInfo_dc01500, false, true);
  }
  
  public static void reportDownload(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, double paramDouble, int paramInt2, int paramInt3, String paramString6)
  {
    LpReportInfo_dc01500 localLpReportInfo_dc01500 = new LpReportInfo_dc01500();
    localLpReportInfo_dc01500.uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localLpReportInfo_dc01500.qua = blru.a();
    localLpReportInfo_dc01500.plugin_id = paramString1;
    localLpReportInfo_dc01500.event_id = "event_download";
    paramInt3 = S_EVENT_INDEX;
    S_EVENT_INDEX = paramInt3 + 1;
    localLpReportInfo_dc01500.event_index = paramInt3;
    localLpReportInfo_dc01500.plugin_version = paramString2;
    localLpReportInfo_dc01500.plugin_version2 = paramString3;
    localLpReportInfo_dc01500.download_id = paramString4;
    localLpReportInfo_dc01500.download_type = paramInt1;
    localLpReportInfo_dc01500.client_time = getClientTime();
    localLpReportInfo_dc01500.time_cost = paramDouble;
    localLpReportInfo_dc01500.network_type = paramString5;
    localLpReportInfo_dc01500.attach_info = paramString6;
    localLpReportInfo_dc01500.ret_code = paramInt2;
    LpReportManager.getInstance().reportToDC01500(localLpReportInfo_dc01500, false, true);
  }
  
  public static void reportDownload(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, double paramDouble, int paramInt2, int paramInt3, String paramString6, String paramString7)
  {
    LpReportInfo_dc01500 localLpReportInfo_dc01500 = new LpReportInfo_dc01500();
    localLpReportInfo_dc01500.uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localLpReportInfo_dc01500.qua = blru.a();
    localLpReportInfo_dc01500.plugin_id = paramString1;
    localLpReportInfo_dc01500.event_id = "event_download";
    paramInt3 = S_EVENT_INDEX;
    S_EVENT_INDEX = paramInt3 + 1;
    localLpReportInfo_dc01500.event_index = paramInt3;
    localLpReportInfo_dc01500.plugin_version = paramString2;
    localLpReportInfo_dc01500.plugin_version2 = paramString3;
    localLpReportInfo_dc01500.download_id = paramString4;
    localLpReportInfo_dc01500.download_type = paramInt1;
    localLpReportInfo_dc01500.client_time = getClientTime();
    localLpReportInfo_dc01500.time_cost = paramDouble;
    localLpReportInfo_dc01500.network_type = paramString5;
    localLpReportInfo_dc01500.attach_info = paramString6;
    localLpReportInfo_dc01500.network_type2 = paramString7;
    localLpReportInfo_dc01500.ret_code = paramInt2;
    LpReportManager.getInstance().reportToDC01500(localLpReportInfo_dc01500, false, true);
  }
  
  public static void reportInstall(String paramString1, String paramString2, String paramString3, double paramDouble, int paramInt)
  {
    LpReportInfo_dc01500 localLpReportInfo_dc01500 = new LpReportInfo_dc01500();
    localLpReportInfo_dc01500.uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localLpReportInfo_dc01500.qua = blru.a();
    localLpReportInfo_dc01500.plugin_id = paramString1;
    localLpReportInfo_dc01500.event_id = "event_install";
    int i = S_EVENT_INDEX;
    S_EVENT_INDEX = i + 1;
    localLpReportInfo_dc01500.event_index = i;
    localLpReportInfo_dc01500.plugin_version = paramString2;
    localLpReportInfo_dc01500.plugin_version2 = paramString3;
    localLpReportInfo_dc01500.client_time = getClientTime();
    localLpReportInfo_dc01500.time_cost = paramDouble;
    localLpReportInfo_dc01500.ret_code = paramInt;
    LpReportManager.getInstance().reportToDC01500(localLpReportInfo_dc01500, false, true);
  }
  
  public static void reportInstall(String paramString1, String paramString2, String paramString3, double paramDouble, int paramInt, String paramString4)
  {
    LpReportInfo_dc01500 localLpReportInfo_dc01500 = new LpReportInfo_dc01500();
    localLpReportInfo_dc01500.uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localLpReportInfo_dc01500.qua = blru.a();
    localLpReportInfo_dc01500.plugin_id = paramString1;
    localLpReportInfo_dc01500.event_id = "event_install";
    int i = S_EVENT_INDEX;
    S_EVENT_INDEX = i + 1;
    localLpReportInfo_dc01500.event_index = i;
    localLpReportInfo_dc01500.plugin_version = paramString2;
    localLpReportInfo_dc01500.plugin_version2 = paramString3;
    localLpReportInfo_dc01500.client_time = getClientTime();
    localLpReportInfo_dc01500.time_cost = paramDouble;
    localLpReportInfo_dc01500.ret_code = paramInt;
    localLpReportInfo_dc01500.attach_info = paramString4;
    LpReportManager.getInstance().reportToDC01500(localLpReportInfo_dc01500, false, true);
  }
  
  public static void reportLaunch(String paramString1, String paramString2, double paramDouble, int paramInt, String paramString3)
  {
    LpReportInfo_dc01500 localLpReportInfo_dc01500 = new LpReportInfo_dc01500();
    localLpReportInfo_dc01500.uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localLpReportInfo_dc01500.qua = blru.a();
    localLpReportInfo_dc01500.plugin_id = paramString1;
    localLpReportInfo_dc01500.event_id = "event_launch";
    int i = S_EVENT_INDEX;
    S_EVENT_INDEX = i + 1;
    localLpReportInfo_dc01500.event_index = i;
    localLpReportInfo_dc01500.plugin_version = paramString2;
    localLpReportInfo_dc01500.client_time = getClientTime();
    localLpReportInfo_dc01500.time_cost = (paramDouble / 1000.0D);
    localLpReportInfo_dc01500.ret_code = paramInt;
    localLpReportInfo_dc01500.attach_info = paramString3;
    LpReportManager.getInstance().reportToDC01500(localLpReportInfo_dc01500, false, true);
  }
  
  public String getSimpleInfo()
  {
    return "dc01500: plugin_id:" + this.plugin_id + " event_id:" + this.event_id + " ret_code:" + this.ret_code;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("host_uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    LpReportUtils.safePut(localHashMap, "qua", this.qua);
    LpReportUtils.safePut(localHashMap, "plugin_id", this.plugin_id);
    LpReportUtils.safePut(localHashMap, "plugin_ver", this.plugin_version);
    LpReportUtils.safePut(localHashMap, "plugin_ver2", this.plugin_version2);
    LpReportUtils.safePut(localHashMap, "event_id", this.event_id);
    localHashMap.put("event_index", String.valueOf(this.event_index));
    localHashMap.put("client_time", String.valueOf(this.client_time));
    LpReportUtils.safePut(localHashMap, "time_cost", String.format("%.2f", new Object[] { Double.valueOf(this.time_cost) }));
    localHashMap.put("ret_code", String.valueOf(this.ret_code));
    LpReportUtils.safePut(localHashMap, "network_type", this.network_type);
    LpReportUtils.safePut(localHashMap, "download_id", this.download_id);
    localHashMap.put("download_type", String.valueOf(this.download_type));
    LpReportUtils.safePut(localHashMap, "network_type2", this.network_type2);
    LpReportUtils.safePut(localHashMap, "attach_info", this.attach_info);
    localHashMap.put("device_model", Build.MODEL);
    localHashMap.put("device_os_ver", String.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("appid", String.valueOf(1000027));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc01500
 * JD-Core Version:    0.7.0.1
 */