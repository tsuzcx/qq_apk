package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class KandianSubscribeManager$3
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  KandianSubscribeManager$3(KandianSubscribeManager paramKandianSubscribeManager) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject == null) {
      return;
    }
    QQMessageFacade localQQMessageFacade = ((QQAppInterface)localObject).getMessageFacade();
    MessageRecord localMessageRecord = localQQMessageFacade.b(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
    if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForText)) && (!TextUtils.isEmpty(localMessageRecord.msg)) && (localMessageRecord.msg.contains(ReadInJoyUserInfoModule.a())) && (TextUtils.equals(localMessageRecord.extStr, paramString)))
    {
      localMessageRecord.msg = localMessageRecord.msg.replace(ReadInJoyUserInfoModule.a(), paramReadInJoyUserInfo.nick);
      localMessageRecord.createMessageUniseq();
      localQQMessageFacade.a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, "msg", localMessageRecord.msg);
      paramReadInJoyUserInfo = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (paramReadInJoyUserInfo != null) {
        paramReadInJoyUserInfo.sendEmptyMessage(1009);
      }
      paramReadInJoyUserInfo = KandianSubscribeManager.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update msg bref, uin : ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", msg : ");
      ((StringBuilder)localObject).append(localMessageRecord);
      QLog.d(paramReadInJoyUserInfo, 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager.3
 * JD-Core Version:    0.7.0.1
 */