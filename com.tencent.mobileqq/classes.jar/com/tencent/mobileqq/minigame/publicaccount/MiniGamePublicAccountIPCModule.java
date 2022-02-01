package com.tencent.mobileqq.minigame.publicaccount;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class MiniGamePublicAccountIPCModule
  extends QIPCModule
{
  public static final String ACTION_DO_ON_RESUME = "action_do_on_resume";
  public static final String ACTION_GET_MINI_GAME_PUBLIC_MSG = "action_get_mini_game_public_account_msg";
  public static final String KEY_MSG_LIST = "key_msg_list";
  public static final String MODULE_NAME = "MiniGamePublicAccountIPCModule";
  private static final String TAG = "MiniGamePublicAccountIPCModule";
  private static MiniGamePublicAccountIPCModule instance;
  
  private MiniGamePublicAccountIPCModule(String paramString)
  {
    super(paramString);
  }
  
  @Nullable
  private JSONObject getArkModel(JSONObject paramJSONObject, String[] paramArrayOfString)
  {
    if (paramJSONObject == null) {
      return null;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(paramArrayOfString[i]);
      if (localJSONObject != null) {
        return localJSONObject;
      }
      i += 1;
    }
    return null;
  }
  
  public static MiniGamePublicAccountIPCModule getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new MiniGamePublicAccountIPCModule("MiniGamePublicAccountIPCModule");
        }
      }
      finally {}
    }
    return instance;
  }
  
  private void handleGetMiniGamePublicAccountMsg(QQAppInterface paramQQAppInterface, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePublicAccountMsgListCount", 4);
        List localList = paramQQAppInterface.getMessageFacade().a(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, 10);
        ArrayList localArrayList = new ArrayList();
        if ((localList != null) && (localList.size() > 0))
        {
          i = localList.size() - 1;
          if (i >= 0)
          {
            MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
            if (AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN.equals(localMessageRecord.frienduin))
            {
              String str = paramQQAppInterface.getAccount();
              if ((localMessageRecord instanceof MessageForArkApp))
              {
                QQGameMsgInfo localQQGameMsgInfo = QQGameMsgInfo.parseMessageRecord(localMessageRecord);
                if (localQQGameMsgInfo != null)
                {
                  parseTianshuReportInfo(localMessageRecord, localQQGameMsgInfo, str, localArrayList.size());
                  localArrayList.add(localQQGameMsgInfo);
                }
              }
            }
            if (localArrayList.size() != j) {
              break label194;
            }
          }
        }
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putSerializable("key_msg_list", localArrayList);
        callbackResult(paramInt, EIPCResult.createSuccessResult(paramQQAppInterface));
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("MiniGamePublicAccountIPCModule", 1, "handleGetMiniGamePublicAccountMsg error", paramQQAppInterface);
        return;
      }
      label194:
      i -= 1;
    }
  }
  
  private void parseTianshuReportInfo(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo, String paramString, int paramInt)
  {
    Object localObject2 = paramMessageRecord.extStr;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramMessageRecord.mExJsonObject.toString();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        paramMessageRecord = new JSONObject((String)localObject1).optString("report_key_bytes_oac_msg_extend", "");
        if (!TextUtils.isEmpty(paramMessageRecord))
        {
          Bundle localBundle = PublicAccountEventReport.a(paramMessageRecord);
          if ((localBundle != null) && (!TextUtils.isEmpty(paramQQGameMsgInfo.arkMetaList)))
          {
            paramMessageRecord = new JSONObject(paramQQGameMsgInfo.arkMetaList);
            localObject1 = getArkModel(paramMessageRecord, new String[] { "xmodal", "notification", "qqgame_model" });
            if (localObject1 == null) {
              return;
            }
            ((JSONObject)localObject1).put("isFromPublicLandingPage", true);
            ((JSONObject)localObject1).put("msgExposePosition", paramInt);
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("adId", paramQQGameMsgInfo.advId);
            ((JSONObject)localObject2).put("appid", "vab_push");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString);
            localStringBuilder.append("_");
            localStringBuilder.append(System.currentTimeMillis() / 1000L);
            ((JSONObject)localObject2).put("traceId", localStringBuilder.toString());
            paramString = localBundle.getString("busi_info");
            if (!TextUtils.isEmpty(paramString)) {
              ((JSONObject)localObject2).put("traceInfo", paramString);
            }
            ((JSONObject)localObject1).put("tianshuAdData", localObject2);
            paramQQGameMsgInfo.arkMetaList = paramMessageRecord.toString();
            return;
          }
        }
      }
      catch (Exception paramMessageRecord)
      {
        QLog.e("MiniGamePublicAccountIPCModule", 1, "parseTianshuReportInfo error ", paramMessageRecord);
      }
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if (!(paramBundle instanceof QQAppInterface)) {
      return null;
    }
    paramBundle = (QQAppInterface)paramBundle;
    if ("action_get_mini_game_public_account_msg".equals(paramString))
    {
      handleGetMiniGamePublicAccountMsg(paramBundle, paramInt);
      return null;
    }
    if ("action_do_on_resume".equals(paramString)) {
      paramBundle.getMessageFacade().a(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, true, true);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountIPCModule
 * JD-Core Version:    0.7.0.1
 */