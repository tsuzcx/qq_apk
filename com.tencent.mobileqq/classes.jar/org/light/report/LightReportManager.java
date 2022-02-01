package org.light.report;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.device.OfflineConfig;
import org.light.report.avreport.AVReportCenter;
import org.light.report.avreport.BaseBean;
import org.light.report.avreport.LightSDKBean;
import org.light.report.avreport.LightSDKReportEvent;
import org.light.utils.LightLogUtil;

public class LightReportManager
{
  private static final String TAG = "LightReportManager";
  private static LightReportInterface mLightReporter;
  
  public static boolean GeneratePerfReport(String paramString)
  {
    new JSONObject();
    try
    {
      String str = new JSONObject(paramString).getString("MaterialID");
      Log.d("GeneratePerfReport", paramString);
      if ((str == null) || (str.isEmpty())) {
        str = "perf";
      }
      new Thread(new LightReportManager.1(str, paramString)).start();
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static native void LaunchFromApp(String paramString1, String paramString2);
  
  public static native void SetCommonParamsExternal(HashMap<String, String> paramHashMap);
  
  public static native String getShareKey();
  
  public static boolean lightReport(String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() == 0) {
        return false;
      }
      Object localObject = paramHashMap.entrySet().iterator();
      while ((localObject != null) && (((Iterator)localObject).hasNext()))
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("-");
        localStringBuilder.append((String)localEntry.getValue());
        Log.i("greatgao", localStringBuilder.toString());
      }
      if (("material_view".equals(paramString)) && (paramHashMap != null) && (paramHashMap.containsKey("material_id")) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("material_id"))))
      {
        localObject = new LightSDKBean(LightSDKReportEvent.SELECT_STICKER.value);
        ((LightSDKBean)localObject).ext_str1 = ((String)paramHashMap.get("material_id"));
        ((LightSDKBean)localObject).ext_str2 = ((String)paramHashMap.get("ai_ability"));
        AVReportCenter.getInstance().commit((BaseBean)localObject, Boolean.valueOf(true));
        localObject = new LightSDKBean(LightSDKReportEvent.PREVIEW_PERFORMANCE.value);
        ((LightSDKBean)localObject).ext_int1 = Integer.valueOf(string2Int((String)paramHashMap.get("render_width"), 1.0F, false));
        ((LightSDKBean)localObject).ext_int2 = Integer.valueOf(string2Int((String)paramHashMap.get("render_height"), 1.0F, false));
        ((LightSDKBean)localObject).ext_int3 = Integer.valueOf(string2Int((String)paramHashMap.get("avg_frame_time"), 1000.0F, true));
        ((LightSDKBean)localObject).ext_int4 = Integer.valueOf((int)string2Long((String)paramHashMap.get("render_count")));
        ((LightSDKBean)localObject).ext_int5 = Integer.valueOf(string2Int((String)paramHashMap.get("avg_memory_usage"), 1024.0F, true));
        ((LightSDKBean)localObject).ext_str1 = ((String)paramHashMap.get("material_id"));
        AVReportCenter.getInstance().commit((BaseBean)localObject, Boolean.valueOf(true));
      }
      if ("tnn_material_report".equals(paramString))
      {
        LightLogUtil.i("LightReportManager", "完成上报TNN");
        paramString = new LightSDKBean(LightSDKReportEvent.PREVIEW_TNN_MATERIAL.value);
        paramString.ext_str1 = ((String)paramHashMap.get("material_id"));
        paramString.ext_str2 = ((String)paramHashMap.get("tnn_inited"));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(OfflineConfig.getPhonePerfLevel(null));
        paramString.ext_str3 = ((StringBuilder)localObject).toString();
        paramString.ext_str4 = "false";
        paramString.ext_str5 = ((String)paramHashMap.get("tnn_model_name"));
        paramString.ext_str6 = ((String)paramHashMap.get("tnn_size"));
        AVReportCenter.getInstance().commit(paramString, Boolean.valueOf(true));
        return true;
      }
      localObject = mLightReporter;
      if (localObject != null)
      {
        ((LightReportInterface)localObject).report(paramString, paramHashMap);
        return true;
      }
    }
    return false;
  }
  
  public static native void reportOutsideData(String paramString, HashMap<String, String> paramHashMap);
  
  public static void setReporter(LightReportInterface paramLightReportInterface)
  {
    mLightReporter = paramLightReportInterface;
  }
  
  public static float string2Float(String paramString)
  {
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (Exception localException)
    {
      label7:
      StringBuilder localStringBuilder;
      break label7;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("string2Float exception:");
    localStringBuilder.append(paramString);
    LightLogUtil.e("LightReportManager", localStringBuilder.toString());
    return -1.0F;
  }
  
  public static int string2Int(String paramString, float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (int)(string2Float(paramString) * paramFloat);
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return (int)(i * paramFloat);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label23:
      StringBuilder localStringBuilder;
      break label23;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("string2Int exception:");
    localStringBuilder.append(paramString);
    LightLogUtil.e("LightReportManager", localStringBuilder.toString());
    return -1;
  }
  
  public static long string2Long(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label7:
      StringBuilder localStringBuilder;
      break label7;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("string2Long exception:");
    localStringBuilder.append(paramString);
    LightLogUtil.e("LightReportManager", localStringBuilder.toString());
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.report.LightReportManager
 * JD-Core Version:    0.7.0.1
 */