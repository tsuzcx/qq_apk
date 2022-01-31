import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class mqn
{
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AVEnterPopActionSheetUtil";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramSessionInfo == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "app == null || context == null || sessionInfo == null");
    }
    do
    {
      do
      {
        return;
      } while (mui.a());
      mui localmui = mui.a(paramContext);
      int[] arrayOfInt = new int[5];
      localmui.a(2131689581);
      arrayOfInt[0] = 1;
      localmui.b(2131720351);
      arrayOfInt[1] = 2;
      localmui.b(2131720373);
      localmui.c(2131690596);
      localmui.a(new mqo());
      localmui.a(new mqp(localmui, arrayOfInt, paramSessionInfo, paramQQAppInterface, paramContext, paramInt));
      localmui.show();
    } while (paramInt != 3);
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      axqw.b(paramQQAppInterface, "CliOper", "", "", "0X800A517", "0X800A517", 0, 2, "", "", "", "");
      return;
    }
    axqw.b(paramQQAppInterface, "CliOper", "", "", "0X800A517", "0X800A517", 0, 1, "", "", "", "");
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramSessionInfo == null)) {
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "enterGroupVideo,, isAudio[" + paramBoolean + "], msgSelfUin[" + paramQQAppInterface.c() + "], uinType[" + paramSessionInfo.jdField_a_of_type_Int + "], groupId[" + paramSessionInfo.jdField_a_of_type_JavaLangString + "], curFriendNick[" + paramSessionInfo.d + "], troopUin[" + paramSessionInfo.b + "]");
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      aefi.a(paramQQAppInterface, paramContext, paramSessionInfo, 10, paramBoolean, paramQQAppInterface.c());
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt, Map<String, String> paramMap)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramSessionInfo == null)) {}
    do
    {
      return;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "enterC2CAudioVideo,, isAudio[" + paramBoolean + "], fromType[" + paramInt + "], msgSelfUin[" + paramQQAppInterface.c() + "], uinType[" + paramSessionInfo.jdField_a_of_type_Int + "], groupId[" + paramSessionInfo.jdField_a_of_type_JavaLangString + "], curFriendNick[" + paramSessionInfo.d + "], troopUin[" + paramSessionInfo.b + "]");
      localObject = (askl)paramQQAppInterface.getManager(11);
    } while (localObject == null);
    String str;
    if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
      str = ((askl)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (Object localObject = paramSessionInfo.jdField_a_of_type_JavaLangString;; localObject = ((askl)localObject).b(str))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.b, true, true, null, "from_internal", paramMap);
      return;
      str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mqn
 * JD-Core Version:    0.7.0.1
 */