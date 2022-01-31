import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class moi
{
  static int jdField_a_of_type_Int;
  static long jdField_a_of_type_Long;
  public static String a;
  static boolean jdField_a_of_type_Boolean;
  static int jdField_b_of_type_Int;
  static String jdField_b_of_type_JavaLangString = "0";
  static boolean jdField_b_of_type_Boolean;
  static int jdField_c_of_type_Int;
  static String jdField_c_of_type_JavaLangString = "actAVFunChatVoiceChange";
  static boolean jdField_c_of_type_Boolean;
  static boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeDataReport";
  }
  
  public static void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("typeid", paramInt + "");
    localHashMap.put("duration", paramLong + "");
    UserAction.onUserAction(jdField_c_of_type_JavaLangString, true, -1L, -1L, localHashMap, true);
    lek.a(jdField_a_of_type_JavaLangString, String.format("reportVoiceChange voiceType = %s, duration = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
  }
  
  public static void a(int paramInt, String paramString)
  {
    lek.a(jdField_a_of_type_JavaLangString, String.format("onConnected sessionType = %s, roomid = %s", new Object[] { Integer.valueOf(paramInt), paramString }));
    d = true;
    jdField_b_of_type_JavaLangString = paramString;
    if ((paramInt == 1) || (paramInt == 3))
    {
      if (jdField_a_of_type_Int != 0) {
        jdField_b_of_type_Int = jdField_a_of_type_Int;
      }
      jdField_a_of_type_Boolean = true;
    }
    while ((paramInt != 2) && (paramInt != 4)) {
      return;
    }
    if (jdField_a_of_type_Int != 0) {
      jdField_c_of_type_Int = jdField_a_of_type_Int;
    }
    jdField_b_of_type_Boolean = true;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    lek.a(jdField_a_of_type_JavaLangString, String.format("reportClickEvent key = %s, type = %s, roomid = %s", new Object[] { paramString1, paramString2, jdField_b_of_type_JavaLangString }));
    azmj.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, "", jdField_b_of_type_JavaLangString, "");
  }
  
  public static void a(lid paramlid)
  {
    if ((!jdField_c_of_type_Boolean) || (!d)) {
      return;
    }
    if ((paramlid.d == 1) || (paramlid.d == 2)) {
      if (jdField_a_of_type_Boolean)
      {
        if (jdField_b_of_type_Int == 0) {
          a("0X8007DC3", "");
        }
      }
      else if (jdField_b_of_type_Boolean)
      {
        if (jdField_c_of_type_Int != 0) {
          break label115;
        }
        a("0X8007DC5", "");
      }
    }
    for (;;)
    {
      a(paramlid, 0);
      jdField_c_of_type_Boolean = false;
      d = false;
      jdField_b_of_type_JavaLangString = "0";
      return;
      a("0X8007DC2", jdField_b_of_type_Int + "");
      break;
      label115:
      a("0X8007DC4", jdField_c_of_type_Int + "");
      continue;
      if ((paramlid.d == 3) || (paramlid.d == 4)) {
        if (paramlid.C == 1)
        {
          if (jdField_a_of_type_Boolean)
          {
            if (jdField_b_of_type_Int != 0) {
              break label209;
            }
            a("0X8007E67", "");
          }
          for (;;)
          {
            if (!jdField_b_of_type_Boolean) {
              break label236;
            }
            if (jdField_c_of_type_Int != 0) {
              break label238;
            }
            a("0X8007E69", "");
            break;
            label209:
            a("0X8007E68", jdField_b_of_type_Int + "");
          }
          label236:
          continue;
          label238:
          a("0X8007E6A", jdField_c_of_type_Int + "");
        }
        else if (paramlid.C == 10)
        {
          if (jdField_a_of_type_Boolean)
          {
            if (jdField_b_of_type_Int != 0) {
              break label317;
            }
            a("0X8007E63", "");
          }
          for (;;)
          {
            if (!jdField_b_of_type_Boolean) {
              break label344;
            }
            if (jdField_c_of_type_Int != 0) {
              break label346;
            }
            a("0X8007E65", "");
            break;
            label317:
            a("0X8007E64", jdField_b_of_type_Int + "");
          }
          label344:
          continue;
          label346:
          a("0X8007E66", jdField_c_of_type_Int + "");
        }
      }
    }
  }
  
  public static void a(lid paramlid, int paramInt)
  {
    lek.a(jdField_a_of_type_JavaLangString, String.format("updateReportData sessionType = %d, voiceType = %d", new Object[] { Integer.valueOf(paramlid.d), Integer.valueOf(paramInt) }));
    long l = System.currentTimeMillis();
    if (jdField_a_of_type_Int != 0) {
      a(jdField_a_of_type_Int, (l - jdField_a_of_type_Long) / 1000L);
    }
    jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_Long = l;
    if ((paramlid.d == 1) || (paramlid.d == 3))
    {
      if (jdField_a_of_type_Int != 0) {
        jdField_b_of_type_Int = jdField_a_of_type_Int;
      }
      jdField_a_of_type_Boolean = true;
    }
    while ((paramlid.d != 2) && (paramlid.d != 4)) {
      return;
    }
    if (jdField_a_of_type_Int != 0) {
      jdField_c_of_type_Int = jdField_a_of_type_Int;
    }
    jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     moi
 * JD-Core Version:    0.7.0.1
 */