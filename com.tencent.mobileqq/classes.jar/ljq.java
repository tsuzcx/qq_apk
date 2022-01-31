import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class ljq
{
  static long jdField_a_of_type_Long;
  static String jdField_a_of_type_JavaLangString;
  static boolean jdField_a_of_type_Boolean;
  
  static long a(String paramString)
  {
    long l1 = 0L;
    long l2 = l1;
    if (!lsq.a(paramString, jdField_a_of_type_JavaLangString))
    {
      long l3 = System.currentTimeMillis();
      lcg.c("EffectZimuManager", "DataReport calTime zimu:" + paramString + "|" + jdField_a_of_type_JavaLangString + "|" + jdField_a_of_type_Long);
      l2 = l1;
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        if (jdField_a_of_type_Long != 0L)
        {
          l1 = l3 - jdField_a_of_type_Long;
          lcg.c("EffectZimuManager", "DataReport zimu:" + l1);
          jdField_a_of_type_Boolean = true;
          l1 /= 1000L;
          a(jdField_a_of_type_JavaLangString, l1);
          axqy.b(null, "CliOper", "", "", "0X800888D", "0X800888D", 0, 0, String.valueOf(l1), "", jdField_a_of_type_JavaLangString, "");
          if (ljo.a(jdField_a_of_type_JavaLangString)) {
            axqy.b(null, "CliOper", "", "", "0X8009193", "0X8009193", 0, 0, String.valueOf(l1), "", jdField_a_of_type_JavaLangString, "");
          }
        }
        lcg.c("EffectZimuManager", "DataReport zimu 33:" + l1);
        l2 = l1;
      }
      jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_Long = l3;
    }
    return l2;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface.a(0))
    {
      paramVideoAppInterface = (ZimuItem)((ljp)paramVideoAppInterface.a(0)).a();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId()))) {
        a(null);
      }
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    lcg.c("EffectZimuManager", "DataReport zimu:" + paramString + "|" + paramLong);
    HashMap localHashMap = new HashMap();
    localHashMap.put("zimuName", paramString);
    localHashMap.put("duration", String.valueOf(paramLong));
    UserAction.onUserAction("actAVFunChatZimu", true, -1L, -1L, localHashMap, true);
    try
    {
      UserAction.flushObjectsToDB(true);
      return;
    }
    catch (Exception paramString)
    {
      lcg.e("EffectZimuManager", paramString.getMessage());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    lcg.c("EffectZimuManager", "DataReport onUsedZimu reportClickEvent:" + paramString1 + "|" + paramString2);
    axqy.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", paramString2, "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    lcg.c("EffectZimuManager", "DataReport onUsedZimu reportClickEvent:" + paramString1 + "|" + paramString2 + "|" + paramString3);
    axqy.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljq
 * JD-Core Version:    0.7.0.1
 */