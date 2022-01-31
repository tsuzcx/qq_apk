import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class oro
  implements pbg
{
  public oro(KandianDailyManager paramKandianDailyManager) {}
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)onh.a();
    if (localQQAppInterface == null) {}
    QQMessageFacade localQQMessageFacade;
    MessageForStructing localMessageForStructing;
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          return;
          localQQMessageFacade = localQQAppInterface.a();
          localMessageForStructing = (MessageForStructing)localQQMessageFacade.b(ajsd.aR, 1008);
        } while (localMessageForStructing == null);
        if (!localMessageForStructing.mIsParsed) {
          localMessageForStructing.parse();
        }
      } while (localMessageForStructing.structingMsg == null);
      str1 = localMessageForStructing.getExtInfoFromExtStr("puin");
      str2 = localMessageForStructing.structingMsg.mMsgBrief;
    } while ((!localMessageForStructing.isread) || (TextUtils.isEmpty(str2)) || (!str2.contains(ReadInJoyUserInfoModule.a())) || (!TextUtils.equals(str1, paramString)));
    localMessageForStructing.structingMsg.mMsgBrief = str2.replace(ReadInJoyUserInfoModule.a(), paramReadInJoyUserInfo.nick);
    localMessageForStructing.createMessageUniseq();
    localMessageForStructing.doPrewrite();
    localQQMessageFacade.a(localMessageForStructing.frienduin, localMessageForStructing.istroop, localMessageForStructing.uniseq, localMessageForStructing.msgData);
    paramReadInJoyUserInfo = localQQAppInterface.getHandler(Conversation.class);
    if (paramReadInJoyUserInfo != null) {
      paramReadInJoyUserInfo.sendEmptyMessage(1009);
    }
    QLog.d("KandianDailyManager", 2, "update msg bref, uin : " + paramString + ", msg : " + localMessageForStructing);
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oro
 * JD-Core Version:    0.7.0.1
 */