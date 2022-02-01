package cooperation.ilive.manager;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class IliveRedManager
{
  public static String sRedShoppingStr2 = "3";
  
  public static String getDrawerLiveReportStr2(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo == null) || (!paramAppInfo.buffer.has()) || (paramAppInfo.iNewFlag.get() == 0)) {
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
    return "3";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.manager.IliveRedManager
 * JD-Core Version:    0.7.0.1
 */