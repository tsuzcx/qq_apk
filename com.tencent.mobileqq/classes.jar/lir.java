import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class lir
{
  static long jdField_a_of_type_Long;
  static String jdField_a_of_type_JavaLangString;
  private static String b = "actAVFunChatDecorate";
  
  public static void a(String paramString, VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface.a(2))
    {
      paramVideoAppInterface = (PendantItem)((liq)paramVideoAppInterface.a(2)).a();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId()))) {
        a(paramString, null);
      }
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    if (!lsq.a(paramString2, jdField_a_of_type_JavaLangString))
    {
      if ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (jdField_a_of_type_Long != 0L))
      {
        long l2 = jdField_a_of_type_Long;
        a(paramString1, jdField_a_of_type_JavaLangString, (l1 - l2) / 1000L);
      }
      jdField_a_of_type_JavaLangString = paramString2;
      jdField_a_of_type_Long = l1;
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      long l = (System.currentTimeMillis() - paramLong) / 1000L;
      HashMap localHashMap = new HashMap();
      localHashMap.put("tempID", paramString2);
      localHashMap.put("duration", l + "");
      UserAction.onUserAction(b, true, -1L, -1L, localHashMap, true);
      lcg.c(paramString1, "onStateReport, ID: " + paramString2 + "  pendant time: " + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lir
 * JD-Core Version:    0.7.0.1
 */