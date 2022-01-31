package cooperation.qzone.report.lp;

import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class LpReportInfo_dc02795
  implements LpReportInfo
{
  private JSONObject reportInfo;
  
  public LpReportInfo_dc02795(JSONObject paramJSONObject)
  {
    this.reportInfo = paramJSONObject;
  }
  
  public static void report(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return;
    }
    QZLog.i("PublishQueue:report", paramJSONObject.toString());
    LpReportManager.getInstance().reportToDC02795(new LpReportInfo_dc02795(paramJSONObject), paramBoolean, false);
  }
  
  public String getSimpleInfo()
  {
    String str = "dc02795";
    if (this.reportInfo != null) {
      str = "dc02795" + ": task_type=" + this.reportInfo.optString("task_type") + ", task_time:" + this.reportInfo.optString("task_time") + ", media_num:" + this.reportInfo.optString("media_num");
    }
    return str;
  }
  
  public Map toMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.reportInfo != null)
    {
      localHashMap.put("uin", this.reportInfo.optString("uin"));
      localHashMap.put("model", this.reportInfo.optString("model"));
      localHashMap.put("qua", this.reportInfo.optString("qua"));
      localHashMap.put("task_type", this.reportInfo.optString("task_type"));
      localHashMap.put("task_subtype", this.reportInfo.optString("task_subtype"));
      localHashMap.put("task_time", this.reportInfo.optString("task_time"));
      localHashMap.put("retry_count", this.reportInfo.optString("retry_count"));
      localHashMap.put("media_num", this.reportInfo.optString("media_num"));
      localHashMap.put("video_num", this.reportInfo.optString("video_num"));
      localHashMap.put("video_origin_size", this.reportInfo.optString("video_origin_size"));
      localHashMap.put("video_compressed_size", this.reportInfo.optString("video_compressed_size"));
      localHashMap.put("video_compress_time", this.reportInfo.optString("video_compress_time"));
      localHashMap.put("video_extend", this.reportInfo.optString("video_extend"));
      localHashMap.put("photo_num", this.reportInfo.optString("photo_num"));
      localHashMap.put("photo_origin_size", this.reportInfo.optString("photo_origin_size"));
      localHashMap.put("photo_compressed_size", this.reportInfo.optString("photo_compressed_size"));
      localHashMap.put("photo_compress_time", this.reportInfo.optString("photo_compress_time"));
      localHashMap.put("photo_extend", this.reportInfo.optString("photo_extend"));
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc02795
 * JD-Core Version:    0.7.0.1
 */