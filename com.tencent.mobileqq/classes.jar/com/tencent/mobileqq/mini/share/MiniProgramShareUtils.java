package com.tencent.mobileqq.mini.share;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare.StTemplateInfo;
import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import baip;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramShareUtils
{
  public static final String MINI_APP_SHARE_FROM = "miniAppShareFrom";
  public static final int MINI_APP_SHARE_FROM_DETAIL = 10;
  public static final int MINI_APP_SHARE_FROM_INNER_BUTTON = 11;
  public static final int MINI_APP_SHARE_FROM_MORE_BUTTON = 12;
  public static final long SHARE_APPID_MISMATCHING = -1000710003L;
  public static final long SHARE_OUT_OF_LIMIT = -100070004L;
  private static final String SHARE_PATH_DETAIL = "openMiniApp/detail";
  private static final String SHARE_SCHEME = "miniapp";
  private static final String TAG = "MiniProgramShareUtils";
  
  private static String getArkPrompt(MiniArkShareModel paramMiniArkShareModel, JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramJSONObject != null) {
      localObject = paramJSONObject.optString("prompt");
    }
    paramJSONObject = (JSONObject)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramJSONObject = (JSONObject)localObject;
      if (paramMiniArkShareModel != null)
      {
        localObject = new StringBuilder().append("[QQ小");
        if (paramMiniArkShareModel.getShareBusinessType() != 0) {
          break label77;
        }
      }
    }
    label77:
    for (paramJSONObject = ajjy.a(2131641084);; paramJSONObject = ajjy.a(2131641085))
    {
      paramJSONObject = paramJSONObject + "]" + paramMiniArkShareModel.getTitle();
      return paramJSONObject;
    }
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
      QLog.e("MiniProgramShareUtils", 1, "getLocalImagePathFromArkMeta get an exception: " + paramString + ",e:" + localException);
      localException.printStackTrace();
    }
    return null;
  }
  
  public static String jumpUrlForDetail(String paramString)
  {
    return "miniapp://openMiniApp/detail?appid=" + paramString;
  }
  
  public static MiniProgramShare.StAdaptShareInfoReq newShareInfoRequest(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, String paramString5, String paramString6, String paramString7, COMM.StCommonExt paramStCommonExt, int paramInt5, String paramString8, int paramInt6, boolean paramBoolean, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    MiniProgramShare.StAdaptShareInfoReq localStAdaptShareInfoReq = new MiniProgramShare.StAdaptShareInfoReq();
    if (paramString1 != null) {
      localStAdaptShareInfoReq.appid.set(paramString1);
    }
    if (paramString2 != null) {
      localStAdaptShareInfoReq.title.set(paramString2);
    }
    if (paramString3 != null) {
      localStAdaptShareInfoReq.desc.set(paramString3);
    }
    localStAdaptShareInfoReq.time.set(paramInt1);
    localStAdaptShareInfoReq.scene.set(paramInt2);
    localStAdaptShareInfoReq.templetType.set(paramInt3);
    localStAdaptShareInfoReq.businessType.set(paramInt4);
    if (paramString4 != null) {
      localStAdaptShareInfoReq.picUrl.set(paramString4);
    }
    if (paramString5 != null) {
      localStAdaptShareInfoReq.vidUrl.set(paramString5);
    }
    if (paramString6 != null) {
      localStAdaptShareInfoReq.jumpUrl.set(paramString6);
    }
    if (paramString7 != null) {
      localStAdaptShareInfoReq.iconUrl.set(paramString7);
    }
    if (paramStCommonExt != null) {
      localStAdaptShareInfoReq.extInfo.set(paramStCommonExt);
    }
    localStAdaptShareInfoReq.verType.set(paramInt5);
    if (paramString8 != null) {
      localStAdaptShareInfoReq.versionId.set(paramString8);
    }
    localStAdaptShareInfoReq.shareType.set(paramInt6);
    paramString1 = localStAdaptShareInfoReq.withShareTicket;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.set(paramInt1);
      if (paramString9 != null) {
        localStAdaptShareInfoReq.webURL.set(paramString9);
      }
      if (paramString10 != null) {
        localStAdaptShareInfoReq.appidRich.set(paramString10);
      }
      if ((paramString11 != null) && (paramString12 != null))
      {
        paramString1 = new MiniProgramShare.StTemplateInfo();
        paramString1.templateId.set(paramString11);
        paramString1.templateData.set(paramString12);
        localStAdaptShareInfoReq.template.set(paramString1);
      }
      if (paramInt6 == 5) {
        localStAdaptShareInfoReq.rcvOpenId.set(paramString13);
      }
      return localStAdaptShareInfoReq;
    }
  }
  
  private static boolean performShareAsArkMessage(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, EntryModel paramEntryModel, ShareChatModel paramShareChatModel, int paramInt1, int paramInt2, JSONObject paramJSONObject, int paramInt3)
  {
    if ((TextUtils.isEmpty(paramString3)) || (paramJSONObject == null) || (paramJSONObject.isNull("appName")) || (paramJSONObject.isNull("appView")) || (paramJSONObject.isNull("metaData"))) {
      return false;
    }
    String str1 = paramJSONObject.optString("appName");
    String str2 = paramJSONObject.optString("appView");
    paramString4 = paramJSONObject.optString("ver");
    paramString2 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString2 = "0.0.0.1";
    }
    boolean bool = paramJSONObject.optBoolean("needShareCallBack", false);
    if ((!bool) && (paramInt3 != 5)) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
    }
    String str3 = paramJSONObject.optJSONObject("metaData").toString();
    paramJSONObject = paramJSONObject.optJSONObject("config");
    paramString4 = paramJSONObject;
    if (paramJSONObject == null) {}
    for (;;)
    {
      try
      {
        paramString4 = new JSONObject().put("type", "normal").put("width", 253);
        if (!"intro".equals(str2)) {
          continue;
        }
        i = 140;
        paramString4 = paramString4.put("height", i).put("forward", 1).put("autoSize", 0);
      }
      catch (JSONException paramString4)
      {
        int i;
        QLog.e("MiniProgramShareUtils", 2, "performShareAsArkMessage", paramString4);
        paramString4 = paramJSONObject;
        continue;
      }
      paramJSONObject = new Bundle();
      paramJSONObject.putString("sharePicturePath", paramString3);
      paramJSONObject.putString("forward_ark_app_name", str1);
      AppBrandProxy.g().sendCmd("cmd_share_ark_async_message", paramJSONObject, new MiniProgramShareUtils.1(str3, str1, str2, paramString1, paramString2, paramString4, bool, paramInt3, paramInt1, paramActivity, paramInt2, paramEntryModel, paramShareChatModel));
      return true;
      i = 272;
    }
  }
  
  public static void shareAsArkMessage(Activity paramActivity, MiniArkShareModel paramMiniArkShareModel, boolean paramBoolean, int paramInt)
  {
    shareAsArkMessage(paramActivity, paramMiniArkShareModel, paramBoolean, paramInt, null);
  }
  
  public static void shareAsArkMessage(Activity paramActivity, MiniArkShareModel paramMiniArkShareModel, boolean paramBoolean, int paramInt, MiniProgramShareUtils.OnShareListener paramOnShareListener)
  {
    if (paramMiniArkShareModel == null)
    {
      QLog.e("MiniProgramShareUtils", 1, "shareAsArkMessage failed! miniArkShareModel is null");
      return;
    }
    int j = 0;
    int i = j;
    if (!baip.a(paramMiniArkShareModel.getTemplateId()))
    {
      i = j;
      if (!baip.a(paramMiniArkShareModel.getTemplateData())) {
        i = 2;
      }
    }
    if (!TextUtils.isEmpty(paramMiniArkShareModel.getRcvOpenId())) {
      i = 5;
    }
    for (;;)
    {
      MiniAppCmdUtil.getInstance().getShareInfo(newShareInfoRequest(paramMiniArkShareModel.getAppId(), paramMiniArkShareModel.getTitle(), paramMiniArkShareModel.getDescription(), (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), paramMiniArkShareModel.getShareScene(), paramMiniArkShareModel.getShareTemplateType(), paramMiniArkShareModel.getShareBusinessType(), paramMiniArkShareModel.getPicUrl(), paramMiniArkShareModel.getVidUrl(), paramMiniArkShareModel.getJumpUrl(), paramMiniArkShareModel.getIconUrl(), null, paramMiniArkShareModel.getVersionType(), paramMiniArkShareModel.getVersionId(), i, paramBoolean, paramMiniArkShareModel.getWebURL(), paramMiniArkShareModel.getAppidRich(), paramMiniArkShareModel.getTemplateId(), paramMiniArkShareModel.getTemplateData(), paramMiniArkShareModel.getRcvOpenId()), new MiniProgramShareUtils.2(i, paramActivity, paramMiniArkShareModel, paramInt, paramOnShareListener));
      return;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("MiniProgramShareUtils", 2, "shareToChatDirectly, chatType: " + paramInt1 + ",uin: " + paramString1 + ",name: " + paramString2);
    }
    if (paramBundle == null)
    {
      QLog.e("MiniProgramShareUtils", 1, "shareToChatDirectly shareDataBundle is null ");
      return;
    }
    Intent localIntent = new Intent(paramActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("key_share_from_screen_need_finish", true);
    if (paramBoolean)
    {
      localIntent.putExtra("type", 9);
      if (paramInt1 != 0) {
        break label174;
      }
      paramBundle.putInt("uintype", 0);
    }
    for (;;)
    {
      paramBundle.putString("uin", String.valueOf(paramString1));
      paramBundle.putString("uinname", paramString2);
      localIntent.putExtras(paramBundle);
      if (paramInt2 == -1) {
        break label190;
      }
      paramActivity.startActivityForResult(localIntent, paramInt2);
      return;
      localIntent.putExtra("type", 10);
      break;
      label174:
      if (paramInt1 == 1) {
        paramBundle.putInt("uintype", 1);
      }
    }
    label190:
    paramActivity.startActivity(localIntent);
  }
  
  public static String updateImagePathToArkMeta(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString1);
      JSONArray localJSONArray = localJSONObject1.names();
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject((String)localJSONArray.get(0));
      if (localJSONObject2 != null)
      {
        localJSONObject2.put("preview", paramString2);
        localJSONObject1.put((String)localJSONArray.get(0), localJSONObject2);
        paramString2 = localJSONObject1.toString();
        paramString1 = paramString2;
      }
      label93:
      for (;;) {}
    }
    catch (Exception paramString2)
    {
      try
      {
        QLog.d("MiniProgramShareUtils", 2, "updateImagePathToArkMeta: " + paramString1);
        return paramString1;
      }
      catch (Exception paramString2)
      {
        break label93;
      }
      paramString2 = paramString2;
      QLog.e("MiniProgramShareUtils", 1, "updateImagePathToArkMeta get an exception: " + paramString1 + ",e:" + paramString2);
      paramString2.printStackTrace();
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramShareUtils
 * JD-Core Version:    0.7.0.1
 */