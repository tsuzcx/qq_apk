import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class pki
  implements pwf
{
  public pki(KandianSubscribeManager paramKandianSubscribeManager) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pay.a();
    if (localQQAppInterface == null) {}
    QQMessageFacade localQQMessageFacade;
    MessageRecord localMessageRecord;
    do
    {
      return;
      localQQMessageFacade = localQQAppInterface.getMessageFacade();
      localMessageRecord = localQQMessageFacade.getLastMsgForMsgTab(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
    } while ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForText)) || (TextUtils.isEmpty(localMessageRecord.msg)) || (!localMessageRecord.msg.contains(ReadInJoyUserInfoModule.a())) || (!TextUtils.equals(localMessageRecord.extStr, paramString)));
    localMessageRecord.msg = localMessageRecord.msg.replace(ReadInJoyUserInfoModule.a(), paramReadInJoyUserInfo.nick);
    localMessageRecord.createMessageUniseq();
    localQQMessageFacade.updateMsgFieldByUniseq(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, "msg", localMessageRecord.msg);
    paramReadInJoyUserInfo = localQQAppInterface.getHandler(Conversation.class);
    if (paramReadInJoyUserInfo != null) {
      paramReadInJoyUserInfo.sendEmptyMessage(1009);
    }
    QLog.d(KandianSubscribeManager.a, 2, "update msg bref, uin : " + paramString + ", msg : " + localMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pki
 * JD-Core Version:    0.7.0.1
 */