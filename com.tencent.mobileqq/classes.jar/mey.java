import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.RedbagToolbar;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class mey
{
  public static int a;
  public static long a;
  public static String a;
  public static int b;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  static int a(int paramInt)
  {
    int i = 1;
    if ((paramInt & 0x3F) != 0) {
      i = 2;
    }
    return i;
  }
  
  public static void a()
  {
    a("0X8008984", null);
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("RedBagReport", 1, "setCurRoomId, RoomId[" + jdField_a_of_type_JavaLangString + "->" + paramLong + "]");
    }
    jdField_a_of_type_JavaLangString = String.valueOf(paramLong);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, BaseToolbar paramBaseToolbar)
  {
    if (paramBaseToolbar != null)
    {
      paramBaseToolbar = new lye();
      RedbagToolbar.getRedBagBtnStatus(paramVideoAppInterface, paramBaseToolbar);
    }
    for (int j = paramBaseToolbar.jdField_a_of_type_Int;; j = -1)
    {
      int n;
      int k;
      int i;
      if (j != -1)
      {
        n = a(j);
        if (n != 2) {
          break label243;
        }
        k = 0;
        i = 1;
        if (k >= 32) {
          break label243;
        }
        if ((j & i) != i) {}
      }
      for (;;)
      {
        k = 0;
        int m = 1;
        label65:
        if (k < 32)
        {
          if ((j & m) == m) {
            if ((m & 0x3F) == 0) {
              break label130;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ljg.a(bool, String.valueOf(m));
            m <<= 1;
            k += 1;
            break label65;
            k += 1;
            i <<= 1;
            break;
          }
        }
        label130:
        if (QLog.isDevelopLevel()) {
          QLog.w("RedBagReport", 1, "reportClickEvent, key[" + "0X8008977" + "], statusFixedEntrance[" + j + "], mRoomId[" + jdField_a_of_type_JavaLangString + "], light[" + n + "], first[" + i + "]");
        }
        awqx.b(null, "dc00898", "", "", "0X8008977", "0X8008977", n, 0, String.valueOf(i), String.valueOf(j), jdField_a_of_type_JavaLangString, "");
        return;
        label243:
        i = 0;
      }
    }
  }
  
  public static void a(String paramString)
  {
    long l1 = jdField_a_of_type_Long;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      bool1 = bool2;
      if (jdField_a_of_type_Long > 0L)
      {
        long l2 = System.currentTimeMillis();
        long l3 = jdField_a_of_type_Long;
        HashMap localHashMap = new HashMap();
        localHashMap.put("time", String.valueOf(l2 - l3));
        localHashMap.put("redbagId", String.valueOf(paramString));
        localHashMap.put("roomid", jdField_a_of_type_JavaLangString);
        bool1 = UserAction.onUserAction("reportAVRedbagGameTime", true, -1L, -1L, localHashMap, true);
        jdField_a_of_type_Long = 0L;
      }
    }
    if (AudioHelper.d()) {
      QLog.w("RedBagReport", 1, "reportRedbagCount, count[" + b + "], mRoomId[" + jdField_a_of_type_JavaLangString + "], begin[" + l1 + "], ret[" + bool1 + "]");
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("RedBagReport", 1, "reportClickEvent, key[" + paramString1 + "], mFromType[" + jdField_a_of_type_Int + "], value[" + paramString2 + "], mRoomId[" + jdField_a_of_type_JavaLangString + "]");
    }
    awqx.b(null, "dc00898", "", "", paramString1, paramString1, jdField_a_of_type_Int, 0, "", "", jdField_a_of_type_JavaLangString, paramString2);
  }
  
  public static void a(mfa parammfa)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("RedBagReport", 1, "reportClickEvent, key[" + "0X800897F" + "], fromType[" + jdField_a_of_type_Int + "], mSucAboutGame[" + parammfa.jdField_a_of_type_Boolean + "], mExceptionType[" + parammfa.jdField_f_of_type_Int + "], mRoomId[" + jdField_a_of_type_JavaLangString + "]");
    }
    int i = jdField_a_of_type_Int;
    int j = parammfa.jdField_f_of_type_Int;
    if (parammfa.jdField_a_of_type_Boolean) {}
    for (parammfa = "1";; parammfa = "0")
    {
      awqx.b(null, "dc00898", "", "", "0X800897F", "0X800897F", i, 0, String.valueOf(j), parammfa, jdField_a_of_type_JavaLangString, "");
      return;
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    int i = 1;
    int j = a(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.w("RedBagReport", 1, "reportClickEvent, key[" + "0X8008978" + "], mRoomId[" + jdField_a_of_type_JavaLangString + "], ret[" + paramBoolean + "], disableType[" + paramInt + "], light[" + j + "]");
    }
    if (paramBoolean) {}
    for (;;)
    {
      awqx.b(null, "dc00898", "", "", "0X8008978", "0X8008978", j, i, String.valueOf(paramInt), "", jdField_a_of_type_JavaLangString, String.valueOf(j));
      return;
      i = 0;
    }
  }
  
  public static void b()
  {
    a("0X8008985", null);
  }
  
  public static void b(int paramInt)
  {
    String str;
    if (paramInt == 0)
    {
      str = "0X800897B";
      f();
    }
    for (;;)
    {
      a(str, null);
      return;
      if (paramInt == 4) {
        str = "0X800897C";
      } else {
        str = "0X800897D";
      }
    }
  }
  
  public static void b(mfa parammfa)
  {
    String str2 = "0X8008982";
    String str1 = str2;
    switch (parammfa.jdField_e_of_type_Int)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("RedBagReport", 1, "reportClickEvent, key[" + str1 + "], fromType[" + jdField_a_of_type_Int + "], getRedbag_ResultCode[" + parammfa.jdField_e_of_type_JavaLangString + "], getRedbag_ResultState[" + parammfa.jdField_f_of_type_JavaLangString + "], mRoomId[" + jdField_a_of_type_JavaLangString + "], hitScore[" + parammfa.jdField_a_of_type_Int + "]");
      }
      awqx.b(null, "dc00898", "", "", str1, str1, jdField_a_of_type_Int, parammfa.jdField_a_of_type_Int, String.valueOf(parammfa.jdField_f_of_type_Int), parammfa.jdField_e_of_type_JavaLangString, jdField_a_of_type_JavaLangString, parammfa.jdField_f_of_type_JavaLangString);
      return;
      str1 = "0X800897E";
      continue;
      str1 = "0X8008983";
      continue;
      str1 = "0X8008981";
      continue;
      str1 = "0X8008980";
    }
  }
  
  public static void b(boolean paramBoolean, int paramInt)
  {
    String str = "0X8008A99";
    if (!paramBoolean) {
      str = "0X8008A9A";
    }
    awqx.b(null, "dc00898", "", "", str, str, jdField_a_of_type_Int, 0, String.valueOf(paramInt), "", jdField_a_of_type_JavaLangString, null);
  }
  
  public static void c()
  {
    a("0X8008986", null);
  }
  
  public static void d()
  {
    a("0X8008987", null);
  }
  
  public static void e()
  {
    a("0X8008988", null);
  }
  
  public static void f()
  {
    b += 1;
  }
  
  public static void g()
  {
    b = 0;
  }
  
  public static void h()
  {
    if ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (b > 0))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("count", String.valueOf(b));
      localHashMap.put("roomid", jdField_a_of_type_JavaLangString);
      UserAction.onUserAction("reportAVRedbagCount", true, -1L, -1L, localHashMap, true);
    }
    if (AudioHelper.d()) {
      QLog.w("RedBagReport", 1, "reportRedbagCount, count[" + b + "], mRoomId[" + jdField_a_of_type_JavaLangString + "]");
    }
  }
  
  public static void i()
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (AudioHelper.d()) {
      QLog.w("RedBagReport", 1, "setGameBeginTime, mGameBeginTime[" + jdField_a_of_type_Long + "]");
    }
  }
  
  public static void j()
  {
    a("0X8008A98", null);
  }
  
  public static void k()
  {
    a("0X8008CF0", null);
  }
  
  public static void l()
  {
    a("0X8008CF1", null);
  }
  
  public static void m()
  {
    a("0X8008A9B", null);
  }
  
  public static void n()
  {
    a("0X8008CF2", null);
  }
  
  public static void o()
  {
    a("0X8008CF3", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mey
 * JD-Core Version:    0.7.0.1
 */