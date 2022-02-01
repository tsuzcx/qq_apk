package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AniStickerSendMessageCallBack
  implements ISendMessageCallback
{
  private static final String TAG = "AniStickerSendMessageCallBack";
  private BaseSessionInfo sessionInfo;
  
  public static AniStickerSendMessageCallBack.AniStickerTextParseResult parseMsgForAniSticker(String paramString, BaseSessionInfo paramBaseSessionInfo)
  {
    AniStickerSendMessageCallBack.AniStickerTextParseResult localAniStickerTextParseResult = new AniStickerSendMessageCallBack.AniStickerTextParseResult();
    boolean bool1 = StringUtil.isEmpty(paramString);
    boolean bool2 = false;
    if ((!bool1) && (paramString.length() <= 2))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      if (localStringBuilder.codePointAt(0) == 20)
      {
        int j = localStringBuilder.charAt(1);
        int i = j;
        if (j == 250) {
          i = 10;
        }
        if (QQSysFaceUtil.isValidFaceId(i))
        {
          localAniStickerTextParseResult.emoLocalId = i;
          localAniStickerTextParseResult.emoType = 1;
          localAniStickerTextParseResult.singleAniSticker = true;
        }
      }
    }
    else
    {
      localAniStickerTextParseResult.singleAniSticker = false;
    }
    if ((!QQSysFaceUtil.isAniSticker(localAniStickerTextParseResult.emoLocalId)) && (!QQSysFaceUtil.isRandomAniSticker(localAniStickerTextParseResult.emoLocalId))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localAniStickerTextParseResult.configAniSticker = bool1;
    if (paramBaseSessionInfo != null)
    {
      if (paramBaseSessionInfo.a != 0)
      {
        bool1 = bool2;
        if (paramBaseSessionInfo.a != 1) {}
      }
      else
      {
        bool1 = true;
      }
      localAniStickerTextParseResult.sessionAvailable = bool1;
    }
    localAniStickerTextParseResult.msg = paramString;
    return localAniStickerTextParseResult;
  }
  
  public static boolean sendAniSticker(int paramInt, BaseSessionInfo paramBaseSessionInfo)
  {
    AniStickerInfo localAniStickerInfo = QQSysFaceUtil.getAniStickerInfo(paramInt);
    if ((localAniStickerInfo != null) && (paramBaseSessionInfo != null))
    {
      MessageForAniSticker localMessageForAniSticker = new MessageForAniSticker();
      localMessageForAniSticker.sourceType = 1;
      localMessageForAniSticker.msg = localAniStickerInfo.text;
      localMessageForAniSticker.text = localAniStickerInfo.text;
      localMessageForAniSticker.sevrId = localAniStickerInfo.sevrId;
      localMessageForAniSticker.packId = localAniStickerInfo.aniStickerPackId;
      localMessageForAniSticker.stickerId = localAniStickerInfo.aniStickerId;
      localMessageForAniSticker.stickerType = localAniStickerInfo.aniStickerType;
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      ChatActivityFacade.a((QQAppInterface)localAppRuntime, paramBaseSessionInfo, localMessageForAniSticker, 0);
      if (localMessageForAniSticker.isAniStickerRandom()) {
        paramBaseSessionInfo = "0X800BCCC";
      } else {
        paramBaseSessionInfo = "0X800BBD5";
      }
      ReportController.b(localAppRuntime, "dc00898", "", "", paramBaseSessionInfo, paramBaseSessionInfo, localAniStickerInfo.sevrId, 0, "", "", "", "");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AniStickerSendMessageCallBack", 2, "sendAniStickerMsg. when AniStickerInfo or session null");
    }
    return false;
  }
  
  public void afterMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean beforeMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    this.sessionInfo = paramAIOContext.O();
    return false;
  }
  
  public boolean onMessageSending(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    paramAIOContext = parseMsgForAniSticker(paramSendLogicParam.a(), this.sessionInfo);
    if (paramAIOContext.isAniStickerEnable()) {
      return sendAniSticker(paramAIOContext.emoLocalId, this.sessionInfo);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AniStickerSendMessageCallBack
 * JD-Core Version:    0.7.0.1
 */