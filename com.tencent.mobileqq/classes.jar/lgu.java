import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class lgu
{
  static int jdField_a_of_type_Int = 0;
  static long jdField_a_of_type_Long;
  static String jdField_a_of_type_JavaLangString = "";
  static String b = "";
  static String c = "";
  
  public static void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 3) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)))
    {
      long l = System.currentTimeMillis();
      a(jdField_a_of_type_JavaLangString, (l - jdField_a_of_type_Long) / 1000L, jdField_a_of_type_Int);
      jdField_a_of_type_JavaLangString = "";
      jdField_a_of_type_Int = 0;
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    g(paramString);
    if (!TextUtils.isEmpty(b)) {
      a("0X8008025", b);
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if ((paramVideoAppInterface != null) && (paramString != null))
    {
      g(paramString);
      paramVideoAppInterface = (lib)paramVideoAppInterface.a(5);
      boolean bool = paramVideoAppInterface.a(3, "normal");
      if ((paramVideoAppInterface.a(3, "interact")) || (bool)) {
        a("0X8008026", null);
      }
    }
    else
    {
      return;
    }
    a("0X8008027", null);
  }
  
  public static void a(String paramString)
  {
    g(paramString);
    a("0X8008021", null);
  }
  
  public static void a(String paramString, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 3))
    {
      a(paramString, 10L, paramInt);
      return;
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!paramString.equals(jdField_a_of_type_JavaLangString)))
    {
      long l = System.currentTimeMillis();
      a(jdField_a_of_type_JavaLangString, (l - jdField_a_of_type_Long) / 1000L, jdField_a_of_type_Int);
    }
    jdField_a_of_type_JavaLangString = paramString;
    jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    g(paramString2);
    b = paramString1;
  }
  
  public static void a(String paramString, long paramLong, int paramInt)
  {
    lba.f("MagicDataReport", "DOUBLE SCREEN DataReport onStateReport: |" + paramString + "|" + paramLong);
    HashMap localHashMap = new HashMap();
    localHashMap.put("activeName", paramString);
    localHashMap.put("duration", String.valueOf(paramLong));
    UserAction.onUserAction("actAVFunChatFace", true, -1L, -1L, localHashMap, true);
    try
    {
      UserAction.flushObjectsToDB(true);
      int i = 0;
      switch (paramInt)
      {
      default: 
        paramInt = i;
        if (paramInt != 0) {
          b(paramInt, paramString);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        lba.h("MagicDataReport", localException.getMessage());
        continue;
        paramInt = 3;
        continue;
        paramInt = 4;
        continue;
        paramInt = 5;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a("CliOper", paramString1, 0, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    lba.f("MagicDataReport", "reportClickEvent key = " + paramString2 + ", fromType = " + paramInt + ", value = " + paramString3 + ", mRoomId = " + c);
    bcef.b(null, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", c, paramString3);
  }
  
  public static void b(int paramInt, String paramString)
  {
    lba.f("MagicDataReport", "WL_DEBUG reportChangeFace fromType = " + paramInt + ", id = " + paramString);
    if ((TextUtils.isEmpty(c)) || (c.equals("0")))
    {
      VideoController localVideoController = VideoController.a();
      c = localVideoController.a(localVideoController.a().d) + "";
    }
    if (paramInt == 5)
    {
      a("dc00898", "0X800984E", paramInt, paramString);
      return;
    }
    a("dc00898", "0X80088B3", paramInt, paramString);
  }
  
  public static void b(String paramString)
  {
    g(paramString);
    a("0X800812F", null);
  }
  
  public static void c(String paramString)
  {
    g(paramString);
    a("0X8008130", null);
  }
  
  public static void d(String paramString)
  {
    g(paramString);
    a("0X800984D", null);
  }
  
  public static void e(String paramString)
  {
    g(paramString);
    a("0X8008131", null);
  }
  
  public static void f(String paramString)
  {
    g(paramString);
    a("0X8008022", null);
  }
  
  static void g(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("0"))) {
      c = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgu
 * JD-Core Version:    0.7.0.1
 */