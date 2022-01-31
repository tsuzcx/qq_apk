package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM.Entry;
import bexd;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class MiniProgramLpReportDC04682
{
  private static final String KEY_ACTIV_WBE = "activ_web";
  private static final String KEY_OPT_TYPE = "opt_type";
  private static final String KEY_POS_ID = "pos_id";
  private static final String TAG = "MiniProgramLpReportDC04682";
  
  private static List<COMM.Entry> newCommonInfoEntries(MiniAppConfig paramMiniAppConfig)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(MiniProgramReportHelper.newEntry("platform", "Android"));
    localArrayList.add(MiniProgramReportHelper.newEntry("uin", String.valueOf(bexd.a().a())));
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      localArrayList.add(MiniProgramReportHelper.newEntry("appid", paramMiniAppConfig.config.appId));
      localArrayList.add(MiniProgramReportHelper.newEntry("appname", paramMiniAppConfig.config.name));
    }
    return localArrayList;
  }
  
  private static List<COMM.Entry> newMobileGameAdReportEntries(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject != null)
    {
      localArrayList.add(MiniProgramReportHelper.newEntry("pos_id", String.valueOf(paramJSONObject.optInt("pos_id"))));
      localArrayList.add(MiniProgramReportHelper.newEntry("opt_type", String.valueOf(paramJSONObject.optInt("opt_type"))));
      localArrayList.add(MiniProgramReportHelper.newEntry("activ_web", paramJSONObject.optString("activ_web")));
    }
    return localArrayList;
  }
  
  public static void report(MiniAppConfig paramMiniAppConfig, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(newCommonInfoEntries(paramMiniAppConfig));
    localArrayList.addAll(newMobileGameAdReportEntries(paramJSONObject));
    paramMiniAppConfig = MiniProgramReportHelper.newSingleReportData(7, localArrayList, null);
    MiniProgramReporter.getInstance().addData(paramMiniAppConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04682
 * JD-Core Version:    0.7.0.1
 */