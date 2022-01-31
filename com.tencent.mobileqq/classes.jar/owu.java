import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class owu
  implements pgr
{
  public owu(KandianSubscribeManager paramKandianSubscribeManager) {}
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if (localQQAppInterface == null) {}
    QQMessageFacade localQQMessageFacade;
    MessageRecord localMessageRecord;
    do
    {
      return;
      localQQMessageFacade = localQQAppInterface.a();
      localMessageRecord = localQQMessageFacade.b(alof.aR, 1008);
    } while ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForText)) || (TextUtils.isEmpty(localMessageRecord.msg)) || (!localMessageRecord.msg.contains(ReadInJoyUserInfoModule.a())) || (!TextUtils.equals(localMessageRecord.extStr, paramString)));
    localMessageRecord.msg = localMessageRecord.msg.replace(ReadInJoyUserInfoModule.a(), paramReadInJoyUserInfo.nick);
    localMessageRecord.createMessageUniseq();
    localQQMessageFacade.a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, "msg", localMessageRecord.msg);
    paramReadInJoyUserInfo = localQQAppInterface.getHandler(Conversation.class);
    if (paramReadInJoyUserInfo != null) {
      paramReadInJoyUserInfo.sendEmptyMessage(1009);
    }
    QLog.d(KandianSubscribeManager.a, 2, "update msg bref, uin : " + paramString + ", msg : " + localMessageRecord);
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     owu
 * JD-Core Version:    0.7.0.1
 */