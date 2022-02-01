package com.tencent.qqmini.sdk.report;

import NS_COMM.COMM.Entry;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class MiniProgramLpReportDC04682
{
  private static final String KEY_ACTIV_WBE = "activ_web";
  private static final String KEY_OPT_TYPE = "opt_type";
  private static final String KEY_POS_ID = "pos_id";
  private static final String TAG = "MiniProgramLpReportDC04682";
  
  private static List<COMM.Entry> newCommonInfoEntries(MiniAppInfo paramMiniAppInfo)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(MiniProgramReportHelper.newEntry("platform", "android"));
    localArrayList.add(MiniProgramReportHelper.newEntry("uin", String.valueOf(LoginManager.getInstance().getAccount())));
    if (paramMiniAppInfo != null)
    {
      localArrayList.add(MiniProgramReportHelper.newEntry("appid", paramMiniAppInfo.appId));
      localArrayList.add(MiniProgramReportHelper.newEntry("appname", paramMiniAppInfo.name));
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
  
  public static void report(MiniAppInfo paramMiniAppInfo, JSONObject paramJSONObject)
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report mobile game ad with args: ");
      if (paramJSONObject != null) {
        localObject = paramJSONObject.toString();
      } else {
        localObject = "empty";
      }
      localStringBuilder.append((String)localObject);
      QMLog.d("MiniProgramLpReportDC04682", localStringBuilder.toString());
    }
    Object localObject = new ArrayList();
    ((List)localObject).addAll(newCommonInfoEntries(paramMiniAppInfo));
    ((List)localObject).addAll(newMobileGameAdReportEntries(paramJSONObject));
    if (!QUAUtil.isQQApp()) {
      ((List)localObject).addAll(MiniProgramReportHelper.newThirdSourceEntries());
    }
    paramMiniAppInfo = MiniProgramReportHelper.newSingleReportData(7, (List)localObject, null);
    MiniProgramReporter.getInstance().addData(paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04682
 * JD-Core Version:    0.7.0.1
 */