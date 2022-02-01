package com.tencent.mobileqq.mini.share;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShareQQArkHelper;
import eipc.EIPCClient;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramShareUtils
{
  public static final String MINI_APP_SHARE_APPID = "miniAppShareAppid";
  public static final String MINI_APP_SHARE_APP_TYPE = "miniAppShareAppType";
  public static final String MINI_APP_SHARE_CALLBACK_ID = "miniAppShareCallbackId";
  public static final String MINI_APP_SHARE_DEST_ID = "miniAppShareDestId";
  public static final String MINI_APP_SHARE_DEST_TYPE = "miniAppShareDestType";
  public static final String MINI_APP_SHARE_EVENT = "miniAppShareEvent";
  public static final String MINI_APP_SHARE_FROM = "miniAppShareFrom";
  public static final int MINI_APP_SHARE_FROM_DETAIL = 10;
  public static final int MINI_APP_SHARE_FROM_INNER_BUTTON = 11;
  public static final int MINI_APP_SHARE_FROM_MORE_BUTTON = 12;
  public static final int MINI_APP_SHARE_FROM_PAY = 13;
  public static final String MINI_APP_SHARE_IS_COMPLETE = "miniAppShareIsComplete";
  public static final String MINI_APP_SHARE_SCENE = "miniAppShareScene";
  public static final String MINI_APP_SHARE_SUB_SCENE = "miniAppShareSubScene";
  public static final String MINI_APP_SHARE_TEMPLATE_ID = "miniAppShareTemplateId";
  public static final String MINI_APP_SHARE_TYPE = "miniAppShareType";
  public static final String MINI_APP_SHARE_UPDATABLE_MSG_FROM = "miniAppShareUpdatableMsgFrom";
  public static final long SHARE_APPID_MISMATCHING = -1000710003L;
  public static final long SHARE_OUT_OF_LIMIT = -100070004L;
  private static final String SHARE_PATH_DETAIL = "openMiniApp/detail";
  private static final String SHARE_SCHEME = "miniapp";
  public static final int SHARE_TARGET_QQ = 0;
  public static final int SHARE_TARGET_QQ_DIRECTLY = 2;
  public static final int SHARE_TARGET_QZONE = 1;
  public static final int SHARE_TARGET_SHARE_CHAT = 5;
  public static final int SHARE_TARGET_TO_FRIEND_LIST = 6;
  public static final int SHARE_TARGET_WECHAT_FRIEND = 3;
  public static final int SHARE_TARGET_WECHAT_MOMENTS = 4;
  private static final String TAG = "MiniProgramShareUtils [miniappArkShare]";
  
  private static Bundle buildShareBundle(Activity paramActivity, String paramString, int paramInt, MiniArkShareModel paramMiniArkShareModel, JSONObject paramJSONObject, boolean paramBoolean)
  {
    int j = paramMiniArkShareModel.getMiniAppShareFrom();
    String str1 = paramJSONObject.optString("appName");
    String str2 = paramJSONObject.optString("appView");
    Object localObject2 = paramJSONObject.optString("ver");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "0.0.0.1";
    }
    String str3 = paramJSONObject.optJSONObject("metaData").toString();
    localObject2 = paramJSONObject.optJSONObject("config");
    boolean bool = false;
    paramJSONObject = (JSONObject)localObject2;
    if (localObject2 == null) {}
    for (;;)
    {
      try
      {
        paramJSONObject = new JSONObject().put("type", "normal").put("width", 253);
        if (!"intro".equals(str2)) {
          break label368;
        }
        i = 140;
        paramJSONObject = paramJSONObject.put("height", i).put("forward", 1).put("autoSize", 0);
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("MiniProgramShareUtils [miniappArkShare]", 2, "performShareAsArkMessage", paramJSONObject);
        paramJSONObject = (JSONObject)localObject2;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("is_ark_display_share", true);
      ((Bundle)localObject2).putString("forward_ark_app_name", str1);
      ((Bundle)localObject2).putString("forward_ark_app_view", str2);
      ((Bundle)localObject2).putString("forward_ark_app_prompt", paramString);
      ((Bundle)localObject2).putString("forward_ark_app_meta", str3);
      ((Bundle)localObject2).putString("forward_ark_app_ver", (String)localObject1);
      ((Bundle)localObject2).putString("forward_ark_app_config", paramJSONObject.toString());
      ((Bundle)localObject2).putBoolean("needShareCallBack", paramBoolean);
      paramBoolean = bool;
      if (paramInt == 5) {
        paramBoolean = true;
      }
      ((Bundle)localObject2).putBoolean("miniAppNeedOnlyPreview", paramBoolean);
      ((Bundle)localObject2).putInt("miniAppShareFrom", j);
      ((Bundle)localObject2).putAll(QQCustomArkDialog.AppInfo.a(str1, str2, (String)localObject1, str3, paramActivity.getResources().getDisplayMetrics().scaledDensity, null, null));
      ((Bundle)localObject2).putInt("forward_type", 27);
      ((Bundle)localObject2).putBoolean("forwardDirect", true);
      ((Bundle)localObject2).putString("miniAppShareAppid", paramMiniArkShareModel.getAppId());
      ((Bundle)localObject2).putInt("miniAppShareAppType", paramMiniArkShareModel.getShareBusinessType());
      ((Bundle)localObject2).putInt("miniAppShareScene", j);
      ((Bundle)localObject2).putInt("miniAppShareType", paramMiniArkShareModel.getShareTarget());
      return localObject2;
      label368:
      int i = 272;
    }
  }
  
  public static String getArkPrompt(MiniArkShareModel paramMiniArkShareModel, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("prompt");
    } else {
      paramJSONObject = null;
    }
    Object localObject = paramJSONObject;
    if (TextUtils.isEmpty(paramJSONObject))
    {
      localObject = paramJSONObject;
      if (paramMiniArkShareModel != null)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("[QQ小");
        int i;
        if (paramMiniArkShareModel.getShareBusinessType() == 0) {
          i = 2131706905;
        } else {
          i = 2131706906;
        }
        paramJSONObject.append(HardCodeUtil.a(i));
        paramJSONObject.append("]");
        paramJSONObject.append(paramMiniArkShareModel.getTitle());
        localObject = paramJSONObject.toString();
      }
    }
    return localObject;
  }
  
  public static String getLocalImagePathFromArkMeta(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      localObject = ((JSONObject)localObject).optJSONObject((String)((JSONObject)localObject).names().get(0));
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("preview");
        return localObject;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocalImagePathFromArkMeta get an exception: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",e:");
      localStringBuilder.append(localException);
      QLog.e("MiniProgramShareUtils [miniappArkShare]", 1, localStringBuilder.toString());
      localException.printStackTrace();
    }
    return null;
  }
  
  public static MiniProgramShare.StAdaptShareInfoReq newShareInfoRequest(MiniArkShareModel paramMiniArkShareModel, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static MiniProgramShare.StAdaptShareInfoReq newShareInfoRequest(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, String paramString5, String paramString6, String paramString7, COMM.StCommonExt paramStCommonExt, int paramInt5, String paramString8, int paramInt6, boolean paramBoolean, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void performShareArkAsMessageFailed(int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    boolean bool = false;
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("needShareCallBack", false);
    }
    if (paramInt1 == 5) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_fail", null, null);
    } else if (bool) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
    }
    paramJSONObject = new Bundle();
    paramJSONObject.putString("key_mini_report_event_action_type", "user_click");
    switch (paramInt2)
    {
    default: 
      break;
    case 12: 
      paramJSONObject.putString("key_mini_report_event_sub_action_type", "more_button");
      break;
    case 11: 
      paramJSONObject.putString("key_mini_report_event_sub_action_type", "custom_button");
      break;
    case 10: 
      paramJSONObject.putString("key_mini_report_event_sub_action_type", "more_about");
    }
    paramJSONObject.putString("key_mini_report_event_reserves", "share_QQ");
    paramJSONObject.putString("key_mini_report_event_reserves2", "fail");
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", paramJSONObject, null);
    ShareQQArkHelper.a();
  }
  
  public static boolean performShareAsArkMessage(Activity paramActivity, String paramString, MiniArkShareModel paramMiniArkShareModel, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject != null) && (!paramJSONObject.isNull("appName")) && (!paramJSONObject.isNull("appView")) && (!paramJSONObject.isNull("metaData")))
    {
      boolean bool = paramJSONObject.optBoolean("needShareCallBack", false);
      if ((!bool) && (paramInt != 5)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      paramString = buildShareBundle(paramActivity, paramString, paramInt, paramMiniArkShareModel, paramJSONObject, bool);
      paramJSONObject = paramMiniArkShareModel.getEntryModel();
      ShareChatModel localShareChatModel = paramMiniArkShareModel.getShareChatModel();
      paramInt = paramMiniArkShareModel.getShareTarget();
      int i = paramMiniArkShareModel.getMiniAppShareFrom();
      if (paramInt == 6)
      {
        paramMiniArkShareModel = new Intent();
        paramMiniArkShareModel.putExtra("public_fragment_window_feature", 1);
        paramMiniArkShareModel.putExtras(paramString);
        PublicFragmentActivity.Launcher.a(paramActivity, paramMiniArkShareModel, PublicTransFragmentActivity.class, MiniShareQuicklySendPanelFragment.class);
        return true;
      }
      if (paramJSONObject != null)
      {
        paramMiniArkShareModel = new Bundle();
        paramMiniArkShareModel.putString("key_mini_report_event_action_type", "user_click");
        paramMiniArkShareModel.putString("key_mini_report_event_sub_action_type", "custom_button");
        paramMiniArkShareModel.putString("key_mini_report_event_reserves", "share_QQfast");
        paramMiniArkShareModel.putString("key_mini_report_event_reserves2", "success");
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", paramMiniArkShareModel, null);
        shareToChatDirectly(paramActivity, paramString, paramJSONObject.type, String.valueOf(paramJSONObject.uin), paramJSONObject.name, -1, true);
        return true;
      }
      if (localShareChatModel != null)
      {
        shareToChatDirectly(paramActivity, paramString, localShareChatModel.type, String.valueOf(localShareChatModel.uin), localShareChatModel.name, -1, true);
        return true;
      }
      paramMiniArkShareModel = new Intent(paramActivity, ForwardRecentActivity.class);
      paramMiniArkShareModel.putExtras(paramString);
      if (i == 12)
      {
        ForwardBaseOption.a(paramActivity, paramMiniArkShareModel, 100500, "applet");
        return true;
      }
      ForwardBaseOption.a(paramActivity, paramMiniArkShareModel);
      return true;
    }
    QLog.e("MiniProgramShareUtils [miniappArkShare]", 2, "performShareAsArkMessage Param Error!");
    performShareArkAsMessageFailed(paramInt, paramMiniArkShareModel.getMiniAppShareFrom(), paramJSONObject);
    return false;
  }
  
  public static void shareAsQzoneFeeds(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, String paramString8, String paramString9, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    MiniAppCmdUtil.getInstance().getShareInfo(newShareInfoRequest(paramString1, paramString2, paramString3, (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7, null, paramInt4, paramString8, 1, false, null, paramString9, null, null, ""), paramMiniAppCmdInterface);
  }
  
  public static void shareAsWeChatMsg(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, String paramString8, String paramString9, int paramInt5, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    MiniAppCmdUtil.getInstance().getShareInfo(newShareInfoRequest(paramString1, paramString2, paramString3, (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7, null, paramInt4, paramString8, paramInt5, false, null, paramString9, null, null, ""), paramMiniAppCmdInterface);
  }
  
  public static void shareToChatDirectly(Activity paramActivity, Bundle paramBundle, int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareToChatDirectly, chatType: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",uin: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",name: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("MiniProgramShareUtils [miniappArkShare]", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBundle == null)
    {
      QLog.e("MiniProgramShareUtils [miniappArkShare]", 1, "shareToChatDirectly shareDataBundle is null ");
      return;
    }
    Object localObject = new Intent(paramActivity, TroopCreateLogicActivity.class);
    ((Intent)localObject).putExtra("key_share_from_screen_need_finish", true);
    if (paramBoolean) {
      ((Intent)localObject).putExtra("type", 9);
    } else {
      ((Intent)localObject).putExtra("type", 10);
    }
    paramBundle.putInt("uintype", paramInt1);
    paramBundle.putString("uin", String.valueOf(paramString1));
    paramBundle.putString("uinname", paramString2);
    paramBundle.putInt("miniAppShareDestType", paramInt1);
    paramBundle.putString("miniAppShareDestId", paramString1);
    ((Intent)localObject).putExtras(paramBundle);
    if (paramInt2 != -1)
    {
      paramActivity.startActivityForResult((Intent)localObject, paramInt2);
      return;
    }
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void shareUpdatableMsg(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent(paramContext, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 44);
    localIntent.putExtra("miniAppShareAppid", paramString1);
    localIntent.putExtra("miniAppShareUpdatableMsgFrom", paramInt1);
    localIntent.putExtra("miniAppShareTemplateId", paramString2);
    localIntent.putExtra("miniAppShareEvent", paramString3);
    localIntent.putExtra("miniAppShareCallbackId", paramInt2);
    localIntent.putExtra("miniAppShareSubScene", paramInt3);
    ForwardBaseOption.a(paramContext, localIntent);
  }
  
  public static String updateImagePathToArkMeta(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString1);
      localObject = paramString1;
      JSONArray localJSONArray = localJSONObject1.names();
      localObject = paramString1;
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject((String)localJSONArray.get(0));
      String str = paramString1;
      if (localJSONObject2 != null)
      {
        localObject = paramString1;
        localJSONObject2.put("preview", paramString2);
        localObject = paramString1;
        localJSONObject1.put((String)localJSONArray.get(0), localJSONObject2);
        localObject = paramString1;
        str = localJSONObject1.toString();
      }
      localObject = str;
      paramString1 = new StringBuilder();
      localObject = str;
      paramString1.append("updateImagePathToArkMeta: ");
      localObject = str;
      paramString1.append(str);
      localObject = str;
      QLog.d("MiniProgramShareUtils [miniappArkShare]", 2, paramString1.toString());
      return str;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("updateImagePathToArkMeta get an exception: ");
      paramString2.append((String)localObject);
      paramString2.append(",e:");
      paramString2.append(paramString1);
      QLog.e("MiniProgramShareUtils [miniappArkShare]", 1, paramString2.toString());
      paramString1.printStackTrace();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramShareUtils
 * JD-Core Version:    0.7.0.1
 */