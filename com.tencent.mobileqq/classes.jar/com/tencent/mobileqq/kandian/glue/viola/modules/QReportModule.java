package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.IQReportModule;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.module.BaseModule;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class QReportModule
  extends BaseModule
  implements IQReportModule, Destroyable
{
  public static final String MODULE_NAME = "QReport";
  public static final String TAG = "QReportModule";
  
  private HashMap getDTBase()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = (QQAppInterface)ReadInJoyUtils.b();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getAccount();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("open_id", localObject);
      }
    }
    localHashMap.put("app", "qq");
    localHashMap.put("av", "8.8.17");
    localHashMap.put("imei", DeviceInfoUtil.b());
    localHashMap.put("oper_time", Long.toString(System.currentTimeMillis()));
    localHashMap.put("domain", "1");
    localHashMap.put("md", Build.MODEL);
    localHashMap.put("net_type", Integer.toString(HttpUtil.getNetWorkType()));
    localHashMap.put("client_ip", DatalineMathUtil.a(DatalineMathUtil.a()));
    if (BaseApplication.getContext() != null)
    {
      localObject = BaseApplication.getContext().getResources().getDisplayMetrics();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((DisplayMetrics)localObject).widthPixels);
      localStringBuilder.append("*");
      localStringBuilder.append(((DisplayMetrics)localObject).widthPixels);
      localHashMap.put("sr", localStringBuilder.toString());
    }
    return localHashMap;
  }
  
  private void reportDTImpl(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    if (paramContext != null)
    {
      HashMap localHashMap = getDTBase();
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        Object localObject1;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localObject1 = "'undefined'";
          Object localObject2 = paramJSONObject.get(str);
          if ((localObject2 instanceof String)) {
            localObject1 = (String)localObject2;
          } else if ((!(localObject2 instanceof Number)) && (!(localObject2 instanceof Long)) && (!(localObject2 instanceof Integer)) && (!(localObject2 instanceof Double)) && (!(localObject2 instanceof Float)))
          {
            if ((localObject2 instanceof Boolean)) {
              localObject1 = localObject2.toString();
            }
          }
          else {
            localObject1 = localObject2.toString();
          }
          localHashMap.put(str, localObject1);
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("reportDTImpl JSONException  e: ");
          ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
          QLog.d("QReportModule", 2, ((StringBuilder)localObject1).toString());
        }
        StatisticCollector.getInstance(paramContext).collectPerformance(null, paramString, true, -1L, 0L, localHashMap, null);
      }
    }
  }
  
  public void destroy() {}
  
  @JSMethod(uiThread=false)
  public void reportDT(@NonNull String paramString, JSONObject paramJSONObject)
  {
    reportDTImpl(BaseApplication.getContext(), paramString, paramJSONObject);
  }
  
  @JSMethod(uiThread=false)
  public void reportT(@NonNull String paramString, JSONObject paramJSONObject)
  {
    String str1 = "";
    String str2 = paramJSONObject.optString("r2", "");
    String str3 = paramJSONObject.optString("r3", "");
    String str4 = paramJSONObject.optString("r4", "");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("r5");
    String str5 = BridgeModuleHelper.a(paramJSONObject, localJSONObject);
    paramJSONObject = str1;
    if (localJSONObject != null) {
      paramJSONObject = localJSONObject.toString();
    }
    PublicAccountReportUtils.a(null, str5, paramString, paramString, 0, 0, str2, str3, str4, paramJSONObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.QReportModule
 * JD-Core Version:    0.7.0.1
 */