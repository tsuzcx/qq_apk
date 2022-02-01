package cooperation.qqcircle.report.datong;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QCircleDTLoginReporter
{
  private static final String TAG = "QCircleDTLoginReporter";
  
  public static void daTongLoginReport(String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramString != null)
    {
      if (paramHashMap == null) {
        return;
      }
      jointScheme(paramString, paramHashMap);
      if (TextUtils.equals((CharSequence)paramHashMap.get("xsj_main_entrance"), "qq_main_tab")) {
        return;
      }
      VideoReport.reportEvent("xsj_login", parseSameReportParams(paramHashMap));
    }
  }
  
  public static void daTongLoginReportMiddlePage(HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      QLog.i("QCircleDTLoginReporter", 1, "daTongLoginReportMiddlePage  attrs == null");
      return;
    }
    paramHashMap = parseSameReportParams(paramHashMap);
    paramHashMap.put("xsj_if_middle_page", Boolean.valueOf(true));
    paramHashMap.put("xsj_if_first_login", Boolean.valueOf(paramBoolean));
    VideoReport.reportEvent("xsj_login", paramHashMap);
  }
  
  private static void dtAddSchemaAttr(HashMap<String, String> paramHashMap, Map<String, Object> paramMap)
  {
    if (paramHashMap != null)
    {
      if (paramMap == null) {
        return;
      }
      String str = (String)paramHashMap.get("key_scheme");
      if (str == null) {
        return;
      }
      paramHashMap = str;
      if (str.length() > 500) {
        paramHashMap = str.substring(0, 500);
      }
      paramMap.put("xsj_schema", paramHashMap);
    }
  }
  
  private static void dtLoginAttrResolve(HashMap<String, String> paramHashMap, Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    if ((paramHashMap != null) && (paramMap != null))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (paramHashMap.containsKey(paramString1))
      {
        paramHashMap = (String)paramHashMap.get(paramString1);
        if (!TextUtils.isEmpty(paramHashMap)) {
          paramMap.put(paramString1, paramHashMap);
        }
      }
      else if (!TextUtils.isEmpty(paramString2))
      {
        paramMap.put(paramString1, paramString2);
      }
    }
  }
  
  private static void jointScheme(String paramString, HashMap<String, String> paramHashMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramHashMap == null) {
        return;
      }
      if (paramHashMap.containsKey("key_scheme"))
      {
        paramString = new StringBuilder();
        paramString.append("jointScheme no joint , scheme = ");
        paramString.append((String)paramHashMap.get("key_scheme"));
        QLog.i("QCircleDTLoginReporter", 1, paramString.toString());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("mqqapi://qcircle/");
      localStringBuilder.append(paramString);
      localStringBuilder.append("?");
      paramString = paramHashMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString.next();
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append("&");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.toString().length() - 1);
      paramHashMap.put("key_scheme", localStringBuilder.toString());
      paramString = new StringBuilder();
      paramString.append("jointScheme  scheme = ");
      paramString.append(localStringBuilder.toString());
      QLog.i("QCircleDTLoginReporter", 1, paramString.toString());
    }
  }
  
  private static Map<String, Object> parseSameReportParams(HashMap<String, String> paramHashMap)
  {
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCircleReportHelper.getQQCirclePageStackNum());
    localStringBuilder.append("");
    localMap.put("xsj_page_stack_num", localStringBuilder.toString());
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_main_entrance", "others");
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_sub_entrance", "default");
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_aio_type", null);
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_share_from_group_id", null);
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_from_uin", null);
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_share_content_host", null);
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_feed_id", null);
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_topic_id", null);
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_poi_msg", null);
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_filter_id", null);
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_push_id", null);
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_author_uin", null);
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_red_dot_main_type", null);
    dtLoginAttrResolve(paramHashMap, localMap, "xsj_red_dot_sub_type", null);
    dtAddSchemaAttr(paramHashMap, localMap);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.datong.QCircleDTLoginReporter
 * JD-Core Version:    0.7.0.1
 */