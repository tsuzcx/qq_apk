package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.text.TextUtils;
import behp;
import behq;
import bekp;
import bekr;
import bekx;
import betc;
import bfhh;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class AppBoxPlugin
  extends BaseJsPlugin
{
  public static final String API_OPERATE_APP_BOX = "operateAppBox";
  public static final String API_OPERATE_DESTROY = "destroy";
  public static final String API_OPERATE_LOAD = "load";
  public static final String API_OPERATE_SHOW = "show";
  private static final String ERRCODE = "errCode";
  private static final String ERRMSG = "errMsg";
  public static final String EVENT_APP_BOX_CLOSE = "onAppBoxClose";
  public static final String KEY_REF_ID = "biz_src_miniapp";
  public static final HashMap<Integer, String> S_CodeMsg_Map = bfhh.a;
  private static final String TAG = "AppBoxPlugin";
  private Map<Integer, AppBoxPlugin.MiniAppBox> mAppBoxMap = new HashMap();
  
  static boolean isAdUnitIdValid(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  AppBoxPlugin.MiniAppBox getMiniAppBox(int paramInt, String paramString, bekr parambekr)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.mAppBoxMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramString = (AppBoxPlugin.MiniAppBox)this.mAppBoxMap.get(Integer.valueOf(paramInt));
      if (paramString != null)
      {
        localObject1 = localObject2;
        if (this.mMiniAppContext != null) {
          localObject1 = this.mMiniAppContext.a();
        }
        paramString.setJsService(parambekr.jdField_a_of_type_Behp);
        paramString.setActivity((Activity)localObject1);
      }
      return paramString;
    }
    if ((this.mMiniAppContext != null) && (this.mApkgInfo != null))
    {
      localObject1 = this.mApkgInfo.d;
      label101:
      if (this.mMiniAppContext == null) {
        break label163;
      }
    }
    label163:
    for (Activity localActivity = this.mMiniAppContext.a();; localActivity = null)
    {
      paramString = new AppBoxPlugin.MiniAppBox(this, localActivity, paramInt, paramString, (String)localObject1, parambekr.jdField_a_of_type_Behp);
      this.mAppBoxMap.put(Integer.valueOf(paramInt), paramString);
      break;
      localObject1 = "";
      break label101;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.mAppBoxMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      AppBoxPlugin.MiniAppBox localMiniAppBox = (AppBoxPlugin.MiniAppBox)((Map.Entry)localIterator.next()).getValue();
      if (localMiniAppBox != null) {
        localMiniAppBox.destroy();
      }
    }
  }
  
  public String operateAppBox(bekr parambekr)
  {
    try
    {
      betc.d("AppBoxPlugin", "operateAppBox, jsonParams = " + parambekr.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject1 = new JSONObject(parambekr.jdField_b_of_type_JavaLangString);
      int i = localJSONObject1.optInt("id", -1);
      Object localObject = localJSONObject1.optString("adUnitId", null);
      if (!isAdUnitIdValid((String)localObject))
      {
        localJSONObject1 = bekx.b(parambekr.jdField_a_of_type_JavaLangString, localJSONObject1);
        localJSONObject1.put("errCode", 1002);
        localJSONObject1.put("errMsg", "广告单元无效");
        localObject = localJSONObject1.toString();
        parambekr.a(localJSONObject1, "广告单元无效");
        return localObject;
      }
      localObject = getMiniAppBox(i, (String)localObject, parambekr);
      String str = localJSONObject1.optString("type");
      int j = localJSONObject1.optInt("compId", -1);
      if ("load".equals(str)) {
        if (!((AppBoxPlugin.MiniAppBox)localObject).load(j, parambekr.jdField_b_of_type_Int))
        {
          localJSONObject1 = bekx.b(parambekr.jdField_a_of_type_JavaLangString, localJSONObject1);
          localJSONObject1.put("errCode", 1003);
          localJSONObject1.put("errMsg", "内部错误");
          parambekr.a(localJSONObject1, "内部错误");
        }
      }
      for (;;)
      {
        return "";
        if ("show".equals(str))
        {
          if (((AppBoxPlugin.MiniAppBox)localObject).show(j, parambekr.jdField_b_of_type_Int)) {
            continue;
          }
          localJSONObject1 = bekx.b(parambekr.jdField_a_of_type_JavaLangString, localJSONObject1);
          localJSONObject1.put("errCode", 1003);
          localJSONObject1.put("errMsg", "内部错误");
          parambekr.a(localJSONObject1, "内部错误");
          continue;
        }
        try
        {
          localJSONObject2.put("errCode", 1003);
          localJSONObject2.put("errMsg", "内部错误");
          parambekr.a(localJSONObject2, "内部错误");
          return localJSONObject2.toString();
          if (!"destroy".equals(str)) {
            continue;
          }
          if (((AppBoxPlugin.MiniAppBox)localObject).destroy()) {}
          for (JSONObject localJSONObject2 = bekx.a(parambekr.jdField_a_of_type_JavaLangString, localJSONObject2);; localJSONObject2 = bekx.a(parambekr.jdField_a_of_type_JavaLangString, localJSONObject2, "内部错误").put("errCode", 1003).put("errMsg", "内部错误"))
          {
            parambekr.jdField_a_of_type_Behp.a(parambekr.jdField_b_of_type_Int, localJSONObject2.toString());
            this.mAppBoxMap.remove(Integer.valueOf(i));
            break;
          }
        }
        catch (Throwable parambekr)
        {
          break label331;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      betc.d("AppBoxPlugin", "operateAppBoxfailed e:", localThrowable);
      localJSONObject2 = bekx.b(parambekr.jdField_a_of_type_JavaLangString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AppBoxPlugin
 * JD-Core Version:    0.7.0.1
 */