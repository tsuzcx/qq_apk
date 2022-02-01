package cooperation.qqcircle.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.QCircleConfig;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QCircleCommonUtil
{
  public static final String KEY_GPS_INFO = "key_gps_info";
  public static final String KEY_PARSE_DATA_ERROR_MSG = "key_parse_data_error_msg";
  public static final String KEY_SELECTED_LABEL_ID = "key_selected_label_id";
  public static final String KEY_SELECTED_LABEL_NAME = "key_selected_label_name";
  public static final String KEY_SELECTED_LABEL_RANK = "key_selected_label_rank";
  private static final String TAG = "QCircleHostUtil";
  
  public static boolean checkOperateMaskEnabled(long paramLong, int paramInt)
  {
    return (1 << paramInt & paramLong) != 0L;
  }
  
  public static String convertDomainToIp(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      String str = QCircleConfig.getInstance().getConfigValue(paramString1, paramString2);
      RFLog.d("QCircleHostUtil", RFLog.USR, String.format("convertDomainToIp ips:%s, main:%s,second:%s", new Object[] { str, paramString1, paramString2 }));
      paramString2 = new JSONObject(str);
      if (paramString4 != null)
      {
        paramString1 = paramString4;
        if (paramString4.trim().length() != 0) {}
      }
      else
      {
        paramString1 = getUrlHost(paramString3);
      }
      if ((paramString1 != null) && (paramString2.has(paramString1)) && (paramString3.startsWith("https://")))
      {
        paramString2 = paramString2.getJSONArray(paramString1);
        if ((paramString2.length() > 0) && ((paramString2.get(0) instanceof JSONObject)) && (((JSONObject)paramString2.get(0)).has("ip")) && (((JSONObject)paramString2.get(0)).has("port")))
        {
          paramString1 = paramString3.replace(paramString1, String.format("%s:%s", new Object[] { ((JSONObject)paramString2.get(0)).get("ip"), ((JSONObject)paramString2.get(0)).get("port") }));
          RFLog.d("QCircleHostUtil", RFLog.USR, "convertDomainToIp newUrl:" + paramString1);
          return paramString1;
        }
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      RFLog.d("QCircleHostUtil", RFLog.USR, "convertDomainToIp use old url");
      return paramString3;
    }
    RFLog.d("QCircleHostUtil", RFLog.USR, "convertDomainToIp use old url");
    return paramString3;
  }
  
  public static String fansNumberFormatTranfer(long paramLong)
  {
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat();
      localDecimalFormat.setMaximumFractionDigits(1);
      localDecimalFormat.setGroupingSize(0);
      localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
      return localDecimalFormat.format(paramLong / 10000.0D) + "w";
    }
    if (paramLong < 100000000L) {
      return paramLong / 10000L + "w";
    }
    return "9999" + "w";
  }
  
  public static String getAuthIconUrl(int paramInt)
  {
    int i;
    if (paramInt < 1) {
      i = 1;
    }
    for (;;)
    {
      return "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qqcircle/user_auth_lv{authTalentLevel}.png".replace("{authTalentLevel}", String.valueOf(i));
      i = paramInt;
      if (paramInt > 8) {
        i = 8;
      }
    }
  }
  
  public static int getCircleTabFromStatus(int paramInt)
  {
    int i = 2;
    if (paramInt == 0) {
      i = 5;
    }
    while (paramInt == 1) {
      return i;
    }
    if (paramInt == 2) {
      return 1;
    }
    return -1;
  }
  
  public static int getColorFromJSON(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        int i = Color.parseColor(paramJSONObject.getString(paramString));
        return i;
      }
      catch (Exception paramJSONObject) {}
    }
    return 0;
  }
  
  public static long getCurrentAccountLongUin()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
  }
  
  public static int getDefaultThemeColor()
  {
    return getDefaultThemeColor(QQTheme.a());
  }
  
  public static int getDefaultThemeColor(boolean paramBoolean)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    int j = MobileQQ.getContext().getResources().getColor(2131166268);
    int i = j;
    if (paramBoolean) {
      i = getNightModeColor(j);
    }
    return i;
  }
  
  public static int getFollowStatus(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    return 0;
  }
  
  public static int getNightModeColor(int paramInt)
  {
    return (int)((0xFFFFFF & paramInt) * 0.6D) | 0xFF000000;
  }
  
  public static int getPlusReportTypeFrom(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 4: 
      return 4;
    case 5: 
      return 5;
    case 3: 
      return 3;
    }
    return 6;
  }
  
  public static String getUrlHost(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean isFriend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return ((IFriendDataService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFriendDataService.class, "")).isFriend(paramString);
  }
  
  public static boolean isInNightMode()
  {
    return QQTheme.a();
  }
  
  public static boolean isOwner(String paramString)
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount().equals(paramString);
  }
  
  public static Bundle jsonToLabel(Bundle paramBundle, String paramString)
  {
    localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("selectedLabel");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          if (localJSONObject != null)
          {
            paramBundle.add(localJSONObject.getString("id"));
            localArrayList1.add(localJSONObject.getString("name"));
            localArrayList2.add(localJSONObject.getString("rank"));
          }
          i += 1;
        }
      }
      return localBundle;
    }
    catch (Exception paramString)
    {
      RFLog.e("QCircleHostUtil", RFLog.USR, new Object[] { "jsonToLabel error.", paramString });
      localBundle.putString("key_parse_data_error_msg", paramString.getMessage());
      localBundle.putStringArrayList("key_selected_label_id", paramBundle);
      localBundle.putStringArrayList("key_selected_label_name", localArrayList1);
      localBundle.putStringArrayList("key_selected_label_rank", localArrayList2);
    }
  }
  
  public static String labelToJson(Bundle paramBundle)
  {
    ArrayList localArrayList1 = paramBundle.getStringArrayList("key_selected_label_id");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("key_selected_label_name");
    ArrayList localArrayList3 = paramBundle.getStringArrayList("key_selected_label_rank");
    paramBundle = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if ((localArrayList1 != null) && (localArrayList2 != null)) {}
    try
    {
      if ((localArrayList1.size() == localArrayList2.size()) && (localArrayList1.size() == localArrayList3.size()))
      {
        int i = 0;
        while (i < localArrayList1.size())
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("id", localArrayList1.get(i));
          localJSONObject.put("name", localArrayList2.get(i));
          localJSONObject.put("rank", localArrayList3.get(i));
          localJSONArray.put(localJSONObject);
          i += 1;
        }
      }
      paramBundle.put("selectedLabel", localJSONArray);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        RFLog.e("QCircleHostUtil", RFLog.USR, new Object[] { "labelToJson error.", localException });
      }
    }
    return paramBundle.toString();
  }
  
  public static void setDefaultStatusBarColor(Activity paramActivity)
  {
    setStatusBarColor(paramActivity, getDefaultThemeColor());
    ImmersiveUtils.setStatusTextColor(true, paramActivity.getWindow());
  }
  
  public static void setStatusBarColor(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramActivity = paramActivity.getWindow();
        paramActivity.clearFlags(67108864);
        paramActivity.getDecorView().setSystemUiVisibility(1280);
        paramActivity.addFlags(-2147483648);
        paramActivity.setStatusBarColor(paramInt);
        paramActivity.setNavigationBarColor(paramInt);
        return;
      }
    } while (Build.VERSION.SDK_INT < 19);
    paramActivity.getWindow().addFlags(67108864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleCommonUtil
 * JD-Core Version:    0.7.0.1
 */