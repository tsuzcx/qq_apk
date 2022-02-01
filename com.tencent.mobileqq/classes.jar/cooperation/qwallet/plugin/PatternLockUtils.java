package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import avor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatternLockUtils
{
  public static final int ALL_FAILED_GAP_TIME = 600;
  public static final int CHECK_PWD_MIN_TIME = 120;
  private static final String KEY_CFT_USER_TYPE = "cft_user_type";
  private static final String KEY_CHECK_INTERVAL_TIME = "check_interval_time";
  private static final String KEY_EXIT_INTERVAL_TIME = "exitinterval_time";
  private static final String KEY_FORGROUND_INTERVAL_TIME = "forground_interval_time";
  private static final String KEY_IS_FIRST_CREATE = "is_first_create";
  private static final String KEY_IS_FIRST_ENTER_AFTER_LOGIN = "isFirstEnterAfterLogin";
  private static final String KEY_IS_NEED_SYNC = "is_need_sync";
  private static final String KEY_IS_NEW_CREATE = "is_new_create";
  private static final String KEY_LAST_UNLOCK_FAILED_TIME = "last_unlock_failed_time";
  private static final String KEY_PWD = "lock_pwd";
  private static final String KEY_PWD_TYPE = "lock_pwd_type";
  private static final String KEY_SHAREPRE_NAME = "qwallet_patternlock";
  private static final String KEY_UNLOCK_FAILED_TIMES = "unlock_failed_times";
  public static final int LENGHT_MIN = 4;
  private static final String TAG = "Q.qwallet.pay.pattutils";
  public static final int UNLOCK_MAXTIMES = 5;
  
  public static String encodeToLocalPWD(Context paramContext, String paramString1, String paramString2)
  {
    String str = QWalletHelper.getQWDevId();
    paramContext = encodeToServerPWD(paramContext, paramString1, paramString2);
    return MD5.toMD5(str + paramContext);
  }
  
  public static String encodeToServerPWD(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = MD5.toMD5(paramString1 + paramString2);
    return MD5.toMD5(paramContext + paramString2);
  }
  
  public static long getCheckIntervalTime(Context paramContext, String paramString)
  {
    long l2 = getSharedPreferences(paramContext).getLong("check_interval_time" + paramString, -1L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getCheckIntervalTime.uin=" + paramString + ",checkIntervalTime=" + l2);
    }
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 120L;
    }
    return l1;
  }
  
  public static long getForgroundIntervalTime(Context paramContext, String paramString)
  {
    long l = getSharedPreferences(paramContext).getLong("forground_interval_time" + paramString, -1L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getForgroundIntervalTime.uin=" + paramString + ",forgroundIntervalTime=" + l);
    }
    if (l < 0L) {
      return 0L;
    }
    return l;
  }
  
  public static long getLastExitWalletTime(Context paramContext, String paramString)
  {
    long l = getSharedPreferences(paramContext).getLong("exitinterval_time" + paramString, -1L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getLastExitWalletTime.uin=" + paramString + ",exitIntervalTime=" + l);
    }
    if (l < 0L) {
      return 0L;
    }
    return l;
  }
  
  public static long getLastUnlockFailedTime(Context paramContext, String paramString)
  {
    long l = getSharedPreferences(paramContext).getLong("last_unlock_failed_time" + paramString, 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getLastUnlockFailedTime.uin=" + paramString + ",allFailedTime=" + l);
    }
    return l;
  }
  
  public static String getPWD(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext).getString("lock_pwd" + paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getGesturePWD.uin=" + paramString + ",pw=" + paramContext);
    }
    return paramContext;
  }
  
  public static int getPWDType(Context paramContext, String paramString)
  {
    int i = getSharedPreferences(paramContext).getInt("lock_pwd_type" + paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getGesturePWD.uin=" + paramString + ",pwdType=" + i);
    }
    return i;
  }
  
  private static SharedPreferences getSharedPreferences(Context paramContext)
  {
    return paramContext.getSharedPreferences("qwallet_patternlock", 4);
  }
  
  public static boolean getSyncPatternLockState(Context paramContext, String paramString)
  {
    boolean bool = getSharedPreferences(paramContext).getBoolean("is_need_sync" + paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getSyncPatternLockState.uin=" + paramString + ",isNeedSync=" + bool);
    }
    return bool;
  }
  
  public static int getUnlockFailedTimes(Context paramContext, String paramString)
  {
    int i = getSharedPreferences(paramContext).getInt("unlock_failed_times" + paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getUnlockFailedTime.uin=" + paramString + ",failedTimes=" + i);
    }
    return i;
  }
  
  public static boolean isFirstCreatePatternLock(Context paramContext, String paramString)
  {
    boolean bool = getSharedPreferences(paramContext).getBoolean("is_first_create" + paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "isFirstCreatePatternLock.uin=" + paramString + ",isFirst=" + bool);
    }
    return bool;
  }
  
  public static boolean isFirstEnterAfterLogin(Context paramContext, String paramString)
  {
    boolean bool = getSharedPreferences(paramContext).getBoolean("isFirstEnterAfterLogin" + paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "isFirstEnterAfterLogin.uin=" + paramString + ",isFirstEnterAfterLogin=" + bool);
    }
    return bool;
  }
  
  public static boolean isNeedOpenPatternLock(Context paramContext, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            String str = getPWD(paramContext, paramString);
            if ((str == null) || (str.length() <= 0)) {
              return false;
            }
            bool1 = bool2;
          } while (isNewCreatePatternLock(paramContext, paramString));
          bool1 = bool2;
        } while (isFirstEnterAfterLogin(paramContext, paramString));
        bool1 = bool2;
      } while (getUnlockFailedTimes(paramContext, paramString) >= 5);
      bool1 = bool2;
    } while (getCheckIntervalTime(paramContext, paramString) + getLastExitWalletTime(paramContext, paramString) <= NetConnInfoCenter.getServerTimeMillis() / 1000L);
    return false;
  }
  
  public static boolean isNewCreatePatternLock(Context paramContext, String paramString)
  {
    boolean bool = getSharedPreferences(paramContext).getBoolean("is_new_create" + paramString, false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "isNewCreatePatternLock.uin=" + paramString + ",isNew=" + bool);
    }
    return bool;
  }
  
  public static boolean isOpenQWalletLockWhenJumpToQWallet(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (GesturePWDUtils.getAppForground(paramActivity)) {
      return false;
    }
    paramString = paramString.toLowerCase();
    if (!paramString.startsWith("mqqapi://wallet/open?")) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = paramString.split("\\?");
        if (paramString.length != 2) {
          return false;
        }
        Object localObject1 = paramString[1].split("&");
        paramString = new HashMap();
        if (localObject1 != null)
        {
          i = 0;
          if (i < localObject1.length)
          {
            localObject2 = localObject1[i].split("=");
            if ((localObject2 == null) || (localObject2.length != 2)) {
              break label245;
            }
            paramString.put(localObject2[0], localObject2[1]);
            break label245;
          }
        }
        localObject1 = (String)paramString.get("src_type");
        Object localObject2 = (String)paramString.get("viewtype");
        paramString = (String)paramString.get("view");
        if ((localObject1 == null) || (!((String)localObject1).equals("web"))) {
          break;
        }
        if ((localObject2 == null) || (!((String)localObject2).equals("0"))) {
          break label254;
        }
        if ((paramString != null) && (!paramString.equals("0")))
        {
          boolean bool = paramString.equals("1");
          if (!bool) {
            return false;
          }
        }
      }
      catch (Exception paramActivity)
      {
        return false;
      }
      return isPatternLockOpened(paramActivity, paramQQAppInterface.getCurrentAccountUin());
      label245:
      i += 1;
    }
    return false;
    label254:
    return false;
  }
  
  public static boolean isPatternLockOpened(Context paramContext, String paramString)
  {
    paramContext = getPWD(paramContext, paramString);
    return (paramContext != null) && (paramContext.length() > 0);
  }
  
  public static String patternToString(List<avor> paramList)
  {
    if (paramList == null) {
      return "";
    }
    int j = paramList.size();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      avor localavor = (avor)paramList.get(i);
      int k = localavor.a();
      localStringBuilder.append((char)(localavor.b() + k * 3 + 49));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void setCheckIntervalTime(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setCheckIntervalTime.uin=" + paramString + ",curTime=" + paramLong);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putLong("check_interval_time" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static void setFirstCreatePatternLock(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setFirstCreatePatternLock.uin=" + paramString + ",isFirst=" + paramBoolean);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putBoolean("is_first_create" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void setFirstEnterAfterLoginState(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setFirstEnterAfterLoginState.uin=" + paramString + ",isFirstState=" + paramBoolean);
    }
    getSharedPreferences(paramContext).edit().putBoolean("isFirstEnterAfterLogin" + paramString, paramBoolean).commit();
    if (paramBoolean) {
      setSyncPatternLockState(paramContext, paramString, true);
    }
  }
  
  public static void setForgroundIntervalTime(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setForgroundIntervalTime.uin=" + paramString + ",curTime=" + paramLong);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putLong("forground_interval_time" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static void setLastExitWalletTime(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setLastExitWalletTime,curTime=" + paramLong);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putLong("exitinterval_time" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static void setLastUnlockFailedTime(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setLastUnlockFailedTime.uin=" + paramString + ",curTime=" + paramLong);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putLong("last_unlock_failed_time" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void setNewCreatePatternLock(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setNewCreatePatternLock.uin=" + paramString + ",isNew=" + paramBoolean);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putBoolean("is_new_create" + paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static void setPWD(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setGesturePWD.uin=" + paramString1 + ",pw=" + paramString2);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putString("lock_pwd" + paramString1, paramString2);
    paramContext.apply();
  }
  
  public static void setPWDType(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setGesturePWD.uin=" + paramString + ",pwdType=" + paramInt);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putInt("lock_pwd_type" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static void setSyncPatternLockState(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setSyncPatternLockState.uin=" + paramString + ",isNeedSync=" + paramBoolean);
    }
    getSharedPreferences(paramContext).edit().putBoolean("is_need_sync" + paramString, paramBoolean).apply();
  }
  
  public static void setUnlockFailedTimes(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setUnlockFailedTime.uin=" + paramString + ",failedTimes=" + paramInt);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putInt("unlock_failed_times" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static List<avor> stringToPattern(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.indexOf(i) - 49;
      localArrayList.add(avor.a(j / 3, j % 3));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.PatternLockUtils
 * JD-Core Version:    0.7.0.1
 */