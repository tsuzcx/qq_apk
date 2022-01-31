import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class mte
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
      } while (mwz.a());
      mwz localmwz = mwz.a(paramContext);
      int[] arrayOfInt = new int[5];
      localmwz.a(2131689581);
      arrayOfInt[0] = 1;
      localmwz.b(2131720910);
      arrayOfInt[1] = 2;
      localmwz.b(2131720932);
      localmwz.c(2131690648);
      localmwz.a(new mtf());
      localmwz.a(new mtg(localmwz, arrayOfInt, paramSessionInfo, paramQQAppInterface, paramContext, paramInt));
      localmwz.show();
    } while (paramInt != 3);
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800A517", "0X800A517", 0, 2, "", "", "", "");
      return;
    }
    azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800A517", "0X800A517", 0, 1, "", "", "", "");
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
      aggj.a(paramQQAppInterface, paramContext, paramSessionInfo, 10, paramBoolean, paramQQAppInterface.c(), "");
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
      localObject = (aufv)paramQQAppInterface.getManager(11);
    } while (localObject == null);
    String str;
    if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
      str = ((aufv)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (Object localObject = paramSessionInfo.jdField_a_of_type_JavaLangString;; localObject = ((aufv)localObject).b(str))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.b, true, true, null, "from_internal", paramMap);
      return;
      str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mte
 * JD-Core Version:    0.7.0.1
 */