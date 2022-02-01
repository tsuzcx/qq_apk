package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class KandianDailyManager$2
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  KandianDailyManager$2(KandianDailyManager paramKandianDailyManager) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {
      return;
    }
    QQMessageFacade localQQMessageFacade = localQQAppInterface.getMessageFacade();
    MessageForStructing localMessageForStructing = (MessageForStructing)localQQMessageFacade.b(AppConstants.KANDIAN_DAILY_UIN, 1008);
    if (localMessageForStructing == null) {
      return;
    }
    if (!localMessageForStructing.mIsParsed) {
      localMessageForStructing.parse();
    }
    if (localMessageForStructing.structingMsg == null) {
      return;
    }
    String str1 = localMessageForStructing.getExtInfoFromExtStr("puin");
    String str2 = localMessageForStructing.structingMsg.mMsgBrief;
    if ((localMessageForStructing.isread) && (!TextUtils.isEmpty(str2)) && (str2.contains(ReadInJoyUserInfoModule.a())) && (TextUtils.equals(str1, paramString)))
    {
      localMessageForStructing.structingMsg.mMsgBrief = str2.replace(ReadInJoyUserInfoModule.a(), paramReadInJoyUserInfo.nick);
      localMessageForStructing.createMessageUniseq();
      localMessageForStructing.doPrewrite();
      localQQMessageFacade.a(localMessageForStructing.frienduin, localMessageForStructing.istroop, localMessageForStructing.uniseq, localMessageForStructing.msgData);
      paramReadInJoyUserInfo = localQQAppInterface.getHandler(Conversation.class);
      if (paramReadInJoyUserInfo != null) {
        paramReadInJoyUserInfo.sendEmptyMessage(1009);
      }
      paramReadInJoyUserInfo = new StringBuilder();
      paramReadInJoyUserInfo.append("update msg bref, uin : ");
      paramReadInJoyUserInfo.append(paramString);
      paramReadInJoyUserInfo.append(", msg : ");
      paramReadInJoyUserInfo.append(localMessageForStructing);
      QLog.d("KandianDailyManager", 2, paramReadInJoyUserInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager.2
 * JD-Core Version:    0.7.0.1
 */