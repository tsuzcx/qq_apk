package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.text.TextUtils;
import bghn;
import bgho;
import bgjw;
import bgkd;
import bgki;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
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
  public static final HashMap<Integer, String> S_CodeMsg_Map = MiniSDKConst.AdConst.CodeMsgMap;
  private static final String TAG = "AppBoxPlugin";
  private Map<Integer, AppBoxPlugin.MiniAppBox> mAppBoxMap = new HashMap();
  
  static boolean isAdUnitIdValid(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  AppBoxPlugin.MiniAppBox getMiniAppBox(int paramInt, String paramString, bgkd parambgkd)
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
        paramString.setJsService(parambgkd.jdField_a_of_type_Bghn);
        paramString.setActivity((Activity)localObject1);
      }
      return paramString;
    }
    if ((this.mMiniAppContext != null) && (this.mApkgInfo != null))
    {
      localObject1 = this.mApkgInfo.appId;
      label101:
      if (this.mMiniAppContext == null) {
        break label163;
      }
    }
    label163:
    for (Activity localActivity = this.mMiniAppContext.a();; localActivity = null)
    {
      paramString = new AppBoxPlugin.MiniAppBox(this, localActivity, paramInt, paramString, (String)localObject1, parambgkd.jdField_a_of_type_Bghn);
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
  
  public String operateAppBox(bgkd parambgkd)
  {
    try
    {
      QMLog.e("AppBoxPlugin", "operateAppBox, jsonParams = " + parambgkd.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject1 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      int i = localJSONObject1.optInt("id", -1);
      Object localObject = localJSONObject1.optString("adUnitId", null);
      if (!isAdUnitIdValid((String)localObject))
      {
        localJSONObject1 = bgki.b(parambgkd.jdField_a_of_type_JavaLangString, localJSONObject1);
        localJSONObject1.put("errCode", 1002);
        localJSONObject1.put("errMsg", "广告单元无效");
        localObject = localJSONObject1.toString();
        parambgkd.a(localJSONObject1, "广告单元无效");
        return localObject;
      }
      localObject = getMiniAppBox(i, (String)localObject, parambgkd);
      String str = localJSONObject1.optString("type");
      int j = localJSONObject1.optInt("compId", -1);
      if ("load".equals(str)) {
        if (!((AppBoxPlugin.MiniAppBox)localObject).load(j, parambgkd.jdField_b_of_type_Int))
        {
          localJSONObject1 = bgki.b(parambgkd.jdField_a_of_type_JavaLangString, localJSONObject1);
          localJSONObject1.put("errCode", 1003);
          localJSONObject1.put("errMsg", "内部错误");
          parambgkd.a(localJSONObject1, "内部错误");
        }
      }
      for (;;)
      {
        return "";
        if ("show".equals(str))
        {
          if (((AppBoxPlugin.MiniAppBox)localObject).show(j, parambgkd.jdField_b_of_type_Int)) {
            continue;
          }
          localJSONObject1 = bgki.b(parambgkd.jdField_a_of_type_JavaLangString, localJSONObject1);
          localJSONObject1.put("errCode", 1003);
          localJSONObject1.put("errMsg", "内部错误");
          parambgkd.a(localJSONObject1, "内部错误");
          continue;
        }
        try
        {
          localJSONObject2.put("errCode", 1003);
          localJSONObject2.put("errMsg", "内部错误");
          parambgkd.a(localJSONObject2, "内部错误");
          return localJSONObject2.toString();
          if (!"destroy".equals(str)) {
            continue;
          }
          if (((AppBoxPlugin.MiniAppBox)localObject).destroy()) {}
          for (JSONObject localJSONObject2 = bgki.a(parambgkd.jdField_a_of_type_JavaLangString, localJSONObject2);; localJSONObject2 = bgki.a(parambgkd.jdField_a_of_type_JavaLangString, localJSONObject2, "内部错误").put("errCode", 1003).put("errMsg", "内部错误"))
          {
            parambgkd.jdField_a_of_type_Bghn.a(parambgkd.jdField_b_of_type_Int, localJSONObject2.toString());
            this.mAppBoxMap.remove(Integer.valueOf(i));
            break;
          }
        }
        catch (Throwable parambgkd)
        {
          break label331;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBoxPlugin", "operateAppBoxfailed e:", localThrowable);
      localJSONObject2 = bgki.b(parambgkd.jdField_a_of_type_JavaLangString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AppBoxPlugin
 * JD-Core Version:    0.7.0.1
 */