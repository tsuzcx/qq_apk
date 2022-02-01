package cooperation.qqcircle.utils;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QCircleHostStubUtil
{
  public static final String KEY_GPS_INFO = "key_gps_info";
  public static final String KEY_PARSE_DATA_ERROR_MSG = "key_parse_data_error_msg";
  public static final String KEY_SELECTED_LABEL_ID = "key_selected_label_id";
  public static final String KEY_SELECTED_LABEL_NAME = "key_selected_label_name";
  public static final String KEY_SELECTED_LABEL_RANK = "key_selected_label_rank";
  private static final String TAG = "QCircleHostUtil";
  
  public static boolean checkOperateMaskEnabled(long paramLong, int paramInt)
  {
    return (paramLong & 1 << paramInt) != 0L;
  }
  
  public static String fansNumberFormatTranfer(long paramLong)
  {
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).setMaximumFractionDigits(1);
      ((DecimalFormat)localObject).setGroupingSize(0);
      ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
      StringBuilder localStringBuilder = new StringBuilder();
      double d = paramLong;
      Double.isNaN(d);
      localStringBuilder.append(((DecimalFormat)localObject).format(d / 10000.0D));
      localStringBuilder.append("w");
      return localStringBuilder.toString();
    }
    if (paramLong < 100000000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong / 10000L);
      ((StringBuilder)localObject).append("w");
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("9999");
    ((StringBuilder)localObject).append("w");
    return ((StringBuilder)localObject).toString();
  }
  
  public static AppRuntime getAppRunTime()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
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
      int i;
      label8:
      label19:
      break label8;
    }
    try
    {
      i = Color.parseColor(paramJSONObject.getString(paramString));
      return i;
    }
    catch (Exception paramJSONObject)
    {
      break label19;
    }
    return 0;
  }
  
  public static String getCurrentAccount()
  {
    return ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
  }
  
  public static long getCurrentAccountLongUin()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
  }
  
  public static String getDeviceName()
  {
    return PlatformInfor.getDeviceName();
  }
  
  public static EntityManager getEntityManager()
  {
    if (getAppRunTime() != null) {
      return getAppRunTime().getEntityManagerFactory(getAppRunTime().getAccount()).createEntityManager();
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    return localAppRuntime.getEntityManagerFactory(localAppRuntime.getAccount()).createEntityManager();
  }
  
  public static String getMobileIMei()
  {
    return MobileInfoUtil.getImei();
  }
  
  public static String getMobileResolution()
  {
    return MobileInfoUtil.getResolution();
  }
  
  public static int getNightModeColor(int paramInt)
  {
    double d = paramInt & 0xFFFFFF;
    Double.isNaN(d);
    return (int)(d * 0.6D) | 0xFF000000;
  }
  
  public static String getQQProcessName()
  {
    if (MobileQQ.sMobileQQ != null) {
      return MobileQQ.sMobileQQ.getQQProcessName();
    }
    return "";
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
    return QQTheme.isNowThemeIsNight();
  }
  
  public static boolean isOwner(String paramString)
  {
    return getCurrentAccount().equals(paramString);
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
      QLog.e("QCircleHostUtil", 1, "jsonToLabel error.", paramString);
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
      QLog.e("QCircleHostUtil", 1, "labelToJson error.", localException);
    }
    return paramBundle.toString();
  }
  
  public static void setIsUnLockSuccess(boolean paramBoolean)
  {
    QBaseActivity.setIsUnLockSuccess(true);
  }
  
  public static void setStatusBarColor(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
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
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(67108864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleHostStubUtil
 * JD-Core Version:    0.7.0.1
 */