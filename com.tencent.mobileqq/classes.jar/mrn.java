import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class mrn
{
  public static String a = "AVEnterPopActionSheetUtil";
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramSessionInfo == null)) {
      QLog.e(a, 1, "app == null || context == null || sessionInfo == null");
    }
    do
    {
      do
      {
        return;
      } while (mvn.a());
      mvn localmvn = mvn.a(paramContext);
      int[] arrayOfInt = new int[5];
      localmvn.a(2131689514);
      arrayOfInt[0] = 1;
      localmvn.b(2131719436);
      arrayOfInt[1] = 2;
      localmvn.b(2131719450);
      localmvn.c(2131690697);
      localmvn.a(new mro());
      localmvn.a(new mrp(localmvn, arrayOfInt, paramSessionInfo, paramQQAppInterface, paramContext, paramInt));
      localmvn.show();
    } while (paramInt != 3);
    if (paramSessionInfo.curType == 1)
    {
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X800A517", "0X800A517", 0, 2, "", "", "", "");
      return;
    }
    bdla.b(paramQQAppInterface, "CliOper", "", "", "0X800A517", "0X800A517", 0, 1, "", "", "", "");
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramSessionInfo == null)) {
      return;
    }
    QLog.w(a, 1, "enterGroupVideo,, isAudio[" + paramBoolean + "], msgSelfUin[" + paramQQAppInterface.getCurrentUin() + "], uinType[" + paramSessionInfo.curType + "], groupId[" + paramSessionInfo.curFriendUin + "], curFriendNick[" + paramSessionInfo.curFriendNick + "], troopUin[" + paramSessionInfo.troopUin + "]");
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ahmu.a(paramQQAppInterface, paramContext, paramSessionInfo, 10, paramBoolean, paramQQAppInterface.getCurrentUin(), "");
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt, Map<String, String> paramMap)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramSessionInfo == null)) {}
    do
    {
      return;
      QLog.w(a, 1, "enterC2CAudioVideo,, isAudio[" + paramBoolean + "], fromType[" + paramInt + "], msgSelfUin[" + paramQQAppInterface.getCurrentUin() + "], uinType[" + paramSessionInfo.curType + "], groupId[" + paramSessionInfo.curFriendUin + "], curFriendNick[" + paramSessionInfo.curFriendNick + "], troopUin[" + paramSessionInfo.troopUin + "]");
      localObject = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    } while (localObject == null);
    String str;
    if (paramSessionInfo.curType == 1006) {
      str = ((awyz)localObject).a(paramSessionInfo.curFriendUin);
    }
    for (Object localObject = paramSessionInfo.curFriendUin;; localObject = ((awyz)localObject).b(str))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.curType, str, paramSessionInfo.curFriendNick, (String)localObject, paramBoolean, paramSessionInfo.troopUin, true, true, null, "from_internal", paramMap);
      return;
      str = paramSessionInfo.curFriendUin;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mrn
 * JD-Core Version:    0.7.0.1
 */