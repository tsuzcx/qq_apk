package com.tencent.mobileqq.mini.share;

import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramOpenSdkUtil
{
  public static final String ATTR_SHARE_APPID_RICH = "share_id";
  public static final String ATTR_SHARE_TO_QQ_MINI_PROGRAM_APPID = "mini_program_appid";
  public static final String ATTR_SHARE_TO_QQ_MINI_PROGRAM_PATH = "mini_program_path";
  public static final String ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE = "mini_program_type";
  public static final String ATTR_SHARE_TO_QQ_MINI_PROGRAM_WEBURL = "url";
  public static final String KEY_MINI_PROGRAM_ARK_JSON = "KEY_MINI_PROGRAM_ARK_JSON";
  public static final String KEY_MINI_PROGRAM_SHARE_OBJ = "KEY_MINI_PROGRAM_SHARE_OBJ";
  private static final String TAG = "MiniProgramOpenSdkUtil";
  
  public static boolean asyncShareMiniProgram(JumpAction paramJumpAction)
  {
    return (isSharingMiniProgram(paramJumpAction.a)) && (!"to_qzone".equals(paramJumpAction.c));
  }
  
  private static JSONObject buildArkConfig(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("config");
    paramJSONObject = localJSONObject;
    if (localJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("type", "normal");
        paramJSONObject.put("width", 253);
        if (!"intro".equals(paramString)) {
          break label89;
        }
        i = 140;
        paramJSONObject.put("height", i);
        paramJSONObject.put("forward", 1);
        paramJSONObject.put("autoSize", 0);
        return paramJSONObject;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return paramJSONObject;
      label89:
      int i = 272;
    }
  }
  
  private static MiniArkShareModel buildMiniArkShareModel(HashMap<String, String> paramHashMap)
  {
    String str1 = toBase64Decode((String)paramHashMap.get("mini_program_appid"));
    String str2 = toBase64Decode((String)paramHashMap.get("title"));
    String str3 = toBase64Decode((String)paramHashMap.get("description"));
    String str7 = toBase64Decode((String)paramHashMap.get("image_url"));
    String str4 = toBase64Decode((String)paramHashMap.get("mini_program_path"));
    String str8 = toBase64Decode((String)paramHashMap.get("file_data"));
    String str5 = toBase64Decode((String)paramHashMap.get("url"));
    String str6 = (String)paramHashMap.get("share_id");
    try
    {
      i = Integer.parseInt(toBase64Decode((String)paramHashMap.get("mini_program_type")));
    }
    catch (NumberFormatException paramHashMap)
    {
      int i;
      label126:
      break label126;
    }
    i = 3;
    paramHashMap = getFinalPic(str7, str8);
    return new MiniArkShareModelBuilder().setAppId(str1).setTitle(str2).setDescription(str3).setShareScene(3).setShareTemplateType(1).setShareBusinessType(0).setPicUrl(paramHashMap).setVidUrl(null).setJumpUrl(str4).setVersionType(i).setWebURL(str5).setAppidRich(str6).createMiniArkShareModel();
  }
  
  private static MiniProgramShare.StAdaptShareInfoReq buildShareInfoRequest(MiniArkShareModel paramMiniArkShareModel)
  {
    return MiniProgramShareUtils.newShareInfoRequest(paramMiniArkShareModel.getAppId(), paramMiniArkShareModel.getTitle(), paramMiniArkShareModel.getDescription(), (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), paramMiniArkShareModel.getShareScene(), paramMiniArkShareModel.getShareTemplateType(), paramMiniArkShareModel.getShareBusinessType(), paramMiniArkShareModel.getPicUrl(), paramMiniArkShareModel.getVidUrl(), paramMiniArkShareModel.getJumpUrl(), paramMiniArkShareModel.getIconUrl(), null, paramMiniArkShareModel.getVersionType(), paramMiniArkShareModel.getVersionId(), 0, false, paramMiniArkShareModel.getWebURL(), paramMiniArkShareModel.getAppidRich(), paramMiniArkShareModel.getTemplateId(), paramMiniArkShareModel.getTemplateData(), "");
  }
  
  private static void finishPreviousActivity(Context paramContext)
  {
    ILoginRegisterApi localILoginRegisterApi = (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
    if ((!(paramContext instanceof JumpActivity)) && (!localILoginRegisterApi.getLoginActivityClass().isInstance(paramContext))) {
      return;
    }
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      if (!paramContext.isFinishing()) {
        paramContext.finish();
      }
    }
  }
  
  public static void forwardShare(Context paramContext, HashMap<String, String> paramHashMap, Bundle paramBundle, Intent paramIntent)
  {
    if (((paramContext instanceof JumpActivity)) && (((JumpActivity)paramContext).isFinishing()))
    {
      QLog.e("MiniProgramOpenSdkUtil", 1, "((JumpActivity)context).isFinishing()");
      return;
    }
    MiniProgramOpenSdkUtil.TimeOutInfo localTimeOutInfo = new MiniProgramOpenSdkUtil.TimeOutInfo(null);
    MiniProgramOpenSdkUtil.1 local1 = new MiniProgramOpenSdkUtil.1(paramContext, localTimeOutInfo);
    MiniProgramOpenSdkUtil.2 local2 = new MiniProgramOpenSdkUtil.2(localTimeOutInfo, paramContext);
    ThreadManager.getUIHandler().postDelayed(local1, 500L);
    ThreadManager.getUIHandler().postDelayed(local2, 5000L);
    paramIntent.putExtras(paramBundle);
    String str2 = toBase64Decode((String)paramHashMap.get("mini_program_appid"));
    String str3 = toBase64Decode((String)paramHashMap.get("mini_program_path"));
    String str4 = toBase64Decode((String)paramHashMap.get("mini_program_type"));
    String str1 = toBase64Decode((String)paramHashMap.get("image_url"));
    paramBundle = toBase64Decode((String)paramHashMap.get("file_data"));
    String str5 = toBase64Decode((String)paramHashMap.get("title"));
    String str6 = toBase64Decode((String)paramHashMap.get("description"));
    String str7 = toBase64Decode((String)paramHashMap.get("url"));
    if (TextUtils.isEmpty(paramBundle)) {
      paramBundle = str1;
    }
    MiniArkShareModel localMiniArkShareModel = buildMiniArkShareModel(paramHashMap);
    paramHashMap = buildShareInfoRequest(localMiniArkShareModel);
    paramContext = new MiniProgramOpenSdkUtil.3(local2, local1, localTimeOutInfo, str2, str3, str4, str7, localMiniArkShareModel.getAppidRich(), str5, str6, paramBundle, paramContext, paramIntent, str1);
    QLog.d("MiniProgramOpenSdkUtil", 1, "forwardShare");
    ForwardStatisticsReporter.a("KEY_STAGE_1_GET_SHARE_INFO");
    MiniAppCmdUtil.getInstance().getShareInfo(paramHashMap, paramContext);
  }
  
  public static void forwardShareWithTryCatch(Context paramContext, HashMap<String, String> paramHashMap, Bundle paramBundle, Intent paramIntent)
  {
    try
    {
      forwardShare(paramContext, paramHashMap, paramBundle, paramIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("forwardShare has Exception");
      paramHashMap.append(paramContext.getMessage());
      QLog.e("MiniProgramOpenSdkUtil", 1, paramHashMap.toString());
    }
  }
  
  private static String getFinalPic(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        QLog.e("MiniProgramOpenSdkUtil", 1, "getFinalPic previewPicUrl&localImagePath is null");
      }
      for (;;)
      {
        return "";
        int i;
        if ((!URLUtil.isHttpUrl(paramString2)) && (!URLUtil.isHttpsUrl(paramString2))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return paramString2;
        }
        QLog.e("MiniProgramOpenSdkUtil", 1, "getFinalPic localImagePath is null");
      }
    }
    return paramString1;
  }
  
  public static boolean isSharingMiniProgram(HashMap<String, String> paramHashMap)
  {
    String str = toBase64Decode((String)paramHashMap.get("mini_program_appid"));
    paramHashMap = toBase64Decode((String)paramHashMap.get("mini_program_path"));
    return (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramHashMap));
  }
  
  private static void startForwardActivityOfArk(Context paramContext, Intent paramIntent, String paramString, JSONObject paramJSONObject, OpenSdkShareModel paramOpenSdkShareModel)
  {
    QLog.d("MiniProgramOpenSdkUtil", 1, new Object[] { "startForwardActivityOfArk: invoked. arkJson: ", paramJSONObject });
    String str1 = paramJSONObject.optString("app");
    String str2 = paramJSONObject.optString("view");
    String str4 = paramJSONObject.optString("title");
    if (paramJSONObject.optJSONObject("meta") != null)
    {
      String str3 = paramJSONObject.optJSONObject("meta").toString();
      if ((!URLUtil.isHttpUrl(paramString)) && (!URLUtil.isHttpsUrl(paramString))) {}
      paramString = buildArkConfig(paramJSONObject, str2);
      paramIntent.putExtra("is_ark_display_share", true).putExtra("forward_ark_app_name", str1).putExtra("forward_ark_app_view", str2).putExtra("forward_ark_app_prompt", str4).putExtra("forward_ark_app_ver", "0.0.0.1").putExtra("forward_ark_app_config", paramString.toString()).putExtra("forward_type", 11).putExtra("forwardDirect", true);
      paramString = new Bundle();
      paramString.putString("KEY_MINI_PROGRAM_ARK_JSON", paramJSONObject.toString());
      paramString.putString("forward_ark_app_name", str1);
      paramIntent.putExtras(paramString);
      paramIntent.putExtra("is_share_flag", true);
      paramIntent.putExtra("req_type", 2147483646);
      paramIntent.putExtra("forward_mini_program_ark_from_sdk", true);
      com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = true;
      paramIntent.putExtra("KEY_MINI_PROGRAM_SHARE_OBJ", paramOpenSdkShareModel);
      paramIntent.putExtra("forward_ark_app_meta", str3);
      paramIntent.putExtras(QQCustomArkDialog.AppInfo.a(str1, str2, "0.0.0.1", str3, BaseApplicationImpl.context.getResources().getDisplayMetrics().scaledDensity, null, null));
      ForwardBaseOption.a(paramContext, paramIntent);
      finishPreviousActivity(paramContext);
      return;
    }
    QLog.e("MiniProgramOpenSdkUtil", 1, "arkJson.optJSONObject(meta) is null");
  }
  
  @NonNull
  public static String toBase64Decode(@NonNull String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (!"".equals(paramString)) {
        if (paramString.length() == 0) {
          return "";
        }
      }
    }
    try
    {
      str1 = new String(Base64Util.decode(paramString, 0));
      return str1;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  private static void transformArkShareJson(JSONObject paramJSONObject)
  {
    Object localObject1 = paramJSONObject.opt("appName");
    Object localObject2 = paramJSONObject.opt("appView");
    Object localObject3 = paramJSONObject.opt("metaData");
    try
    {
      paramJSONObject.put("app", localObject1);
      paramJSONObject.put("view", localObject2);
      paramJSONObject.put("meta", localObject3);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    paramJSONObject.remove("appName");
    paramJSONObject.remove("appView");
    paramJSONObject.remove("metaData");
  }
  
  private static void transformArkShareJson(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = paramJSONObject.opt("appName");
    Object localObject2 = paramJSONObject.opt("appView");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("metaData");
    if ((localJSONObject1 != null) && (paramString != null)) {}
    try
    {
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject((String)localJSONObject1.names().get(0));
      localJSONObject2.remove("preview");
      localJSONObject2.put("preview", paramString);
      paramJSONObject.put("app", localObject1);
      paramJSONObject.put("view", localObject2);
      paramJSONObject.put("meta", localJSONObject1);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    paramJSONObject.remove("appName");
    paramJSONObject.remove("appView");
    paramJSONObject.remove("metaData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil
 * JD-Core Version:    0.7.0.1
 */