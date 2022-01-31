import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class ljt
{
  static long jdField_a_of_type_Long;
  static String jdField_a_of_type_JavaLangString = "EffectFilterTools";
  static boolean jdField_a_of_type_Boolean;
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface.a(1))
    {
      paramVideoAppInterface = (FilterItem)((ljs)paramVideoAppInterface.a(1)).a();
      a(paramVideoAppInterface);
      lek.c(jdField_a_of_type_JavaLangString, "DataReport onUserdFilter:" + paramVideoAppInterface + "|" + jdField_a_of_type_Boolean);
      if (!jdField_a_of_type_Boolean) {
        break label77;
      }
    }
    label77:
    for (paramVideoAppInterface = "0X80076B2";; paramVideoAppInterface = "0X80076B1")
    {
      a(paramVideoAppInterface);
      return;
    }
  }
  
  static void a(FilterItem paramFilterItem)
  {
    long l1 = System.currentTimeMillis();
    lek.c(jdField_a_of_type_JavaLangString, "DataReport onUserdFilter:" + paramFilterItem + "|" + jdField_a_of_type_Long);
    if ((paramFilterItem != null) && (!paramFilterItem.isEmptyFilter()))
    {
      if (jdField_a_of_type_Long != 0L)
      {
        long l2 = l1 - jdField_a_of_type_Long;
        lek.c(jdField_a_of_type_JavaLangString, "DataReport onUserdFilter:" + l2);
        if (l2 > 5000L)
        {
          jdField_a_of_type_Boolean = true;
          a(paramFilterItem, l2 / 1000L);
        }
      }
      lek.c(jdField_a_of_type_JavaLangString, "DataReport onUserdFilter 33:" + jdField_a_of_type_Long);
    }
    jdField_a_of_type_Long = l1;
  }
  
  public static void a(FilterItem paramFilterItem, long paramLong)
  {
    paramFilterItem = paramFilterItem.getId();
    lek.c(jdField_a_of_type_JavaLangString, "DataReport onStateReport:" + paramFilterItem + "|" + paramLong);
    HashMap localHashMap = new HashMap();
    localHashMap.put("filterName", paramFilterItem);
    localHashMap.put("duration", String.valueOf(paramLong));
    UserAction.onUserAction("actAVFunChatFilter", true, -1L, -1L, localHashMap, true);
    try
    {
      UserAction.flushObjectsToDB(true);
      return;
    }
    catch (Exception paramFilterItem)
    {
      lek.e(jdField_a_of_type_JavaLangString, paramFilterItem.getMessage());
    }
  }
  
  public static void a(String paramString)
  {
    azqs.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    lek.c(jdField_a_of_type_JavaLangString, "DataReport onSupport:" + paramBoolean);
    if (paramBoolean) {}
    for (String str = "0X80076AF";; str = "0X80076B0")
    {
      a(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ljt
 * JD-Core Version:    0.7.0.1
 */