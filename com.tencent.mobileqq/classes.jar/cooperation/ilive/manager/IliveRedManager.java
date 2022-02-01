package cooperation.ilive.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class IliveRedManager
{
  private static final String TAG = "IliveRedManager";
  public static String sRedShoppingStr2 = "3";
  
  public static String getDrawerLiveReportStr2(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.buffer.has()))
    {
      if (paramAppInfo.iNewFlag.get() == 0) {
        return "3";
      }
      try
      {
        paramAppInfo = new JSONObject(paramAppInfo.buffer.get());
        if (paramAppInfo.has("param")) {
          return "1";
        }
        if (paramAppInfo.has("msg")) {
          return "2";
        }
      }
      catch (JSONException paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    return "3";
  }
  
  public static Pair<String, String> getIliveRecomRedInfo()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAppRuntime == null) {
      return null;
    }
    return parseIliveRecomRedInfo(((IRedTouchManager)localAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(1, String.valueOf(101100)));
  }
  
  public static long getRedAdId(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.buffer.has()) && (paramAppInfo.iNewFlag.get() != 0)) {
      try
      {
        long l = new JSONObject(paramAppInfo.buffer.get()).optLong("ad_id");
        return l;
      }
      catch (JSONException paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    return 0L;
  }
  
  public static boolean isRecomRedJumpUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = RoomManager.a(paramString);
    if (paramString != null)
    {
      if (!paramString.containsKey("recom_info")) {
        return false;
      }
      return TextUtils.isEmpty((CharSequence)paramString.get("recom_info")) ^ true;
    }
    return false;
  }
  
  public static Pair<String, String> parseIliveRecomRedInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.buffer.has()) && (paramAppInfo.iNewFlag.get() != 0)) {
      try
      {
        paramAppInfo = new JSONObject(paramAppInfo.buffer.get());
        long l = paramAppInfo.optLong("ad_id");
        Object localObject = paramAppInfo.optJSONObject("msg");
        if (localObject == null) {
          return null;
        }
        localObject = ((JSONObject)localObject).optJSONObject(String.valueOf(l));
        if (localObject == null) {
          return null;
        }
        localObject = ((JSONObject)localObject).optString("extinfo");
        String str = paramAppInfo.optString("_jump_url");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("parseIliveRecomRedInfo extendInfo = ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" \njson = ");
          localStringBuilder.append(paramAppInfo.toString());
          QLog.i("IliveRedManager", 2, localStringBuilder.toString());
        }
        paramAppInfo = new Pair(localObject, str);
        return paramAppInfo;
      }
      catch (Exception paramAppInfo)
      {
        paramAppInfo.printStackTrace();
        QLog.e("IliveRedManager", 1, "parseIliveRecomRedInfo exception", paramAppInfo);
      }
    }
    return null;
  }
  
  public static String parseShopRedBuffer(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.buffer.has()) && (paramAppInfo.iNewFlag.get() != 0)) {
      try
      {
        paramAppInfo = new JSONObject(paramAppInfo.buffer.get()).optString("_jump_url");
        return paramAppInfo;
      }
      catch (JSONException paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.manager.IliveRedManager
 * JD-Core Version:    0.7.0.1
 */