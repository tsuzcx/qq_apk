package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import java.util.HashMap;

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
    String str = QWalletHelperDelegate.getQWDevId();
    paramContext = encodeToServerPWD(paramContext, paramString1, paramString2);
    paramString1 = new StringBuilder();
    paramString1.append(str);
    paramString1.append(paramContext);
    return MD5.toMD5(paramString1.toString());
  }
  
  public static String encodeToServerPWD(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new StringBuilder();
    paramContext.append(paramString1);
    paramContext.append(paramString2);
    paramContext = MD5.toMD5(paramContext.toString());
    paramString1 = new StringBuilder();
    paramString1.append(paramContext);
    paramString1.append(paramString2);
    return MD5.toMD5(paramString1.toString());
  }
  
  public static long getCheckIntervalTime(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check_interval_time");
    localStringBuilder.append(paramString);
    long l = paramContext.getLong(localStringBuilder.toString(), -1L);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getCheckIntervalTime.uin=");
      paramContext.append(paramString);
      paramContext.append(",checkIntervalTime=");
      paramContext.append(l);
      QLog.d("Q.qwallet.pay.pattutils", 2, paramContext.toString());
    }
    if (l < 0L) {
      return 120L;
    }
    return l;
  }
  
  public static long getForgroundIntervalTime(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("forground_interval_time");
    localStringBuilder.append(paramString);
    long l = paramContext.getLong(localStringBuilder.toString(), -1L);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getForgroundIntervalTime.uin=");
      paramContext.append(paramString);
      paramContext.append(",forgroundIntervalTime=");
      paramContext.append(l);
      QLog.d("Q.qwallet.pay.pattutils", 2, paramContext.toString());
    }
    if (l < 0L) {
      return 0L;
    }
    return l;
  }
  
  public static long getLastExitWalletTime(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitinterval_time");
    localStringBuilder.append(paramString);
    long l = paramContext.getLong(localStringBuilder.toString(), -1L);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getLastExitWalletTime.uin=");
      paramContext.append(paramString);
      paramContext.append(",exitIntervalTime=");
      paramContext.append(l);
      QLog.d("Q.qwallet.pay.pattutils", 2, paramContext.toString());
    }
    if (l < 0L) {
      return 0L;
    }
    return l;
  }
  
  public static long getLastUnlockFailedTime(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_unlock_failed_time");
    localStringBuilder.append(paramString);
    long l = paramContext.getLong(localStringBuilder.toString(), 0L);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getLastUnlockFailedTime.uin=");
      paramContext.append(paramString);
      paramContext.append(",allFailedTime=");
      paramContext.append(l);
      QLog.d("Q.qwallet.pay.pattutils", 2, paramContext.toString());
    }
    return l;
  }
  
  public static String getPWD(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lock_pwd");
    localStringBuilder.append(paramString);
    paramContext = paramContext.getString(localStringBuilder.toString(), "");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGesturePWD.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",pw=");
      localStringBuilder.append(paramContext);
      QLog.d("Q.qwallet.pay.pattutils", 2, localStringBuilder.toString());
    }
    return paramContext;
  }
  
  public static int getPWDType(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lock_pwd_type");
    localStringBuilder.append(paramString);
    int i = paramContext.getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getGesturePWD.uin=");
      paramContext.append(paramString);
      paramContext.append(",pwdType=");
      paramContext.append(i);
      QLog.d("Q.qwallet.pay.pattutils", 2, paramContext.toString());
    }
    return i;
  }
  
  private static SharedPreferences getSharedPreferences(Context paramContext)
  {
    return paramContext.getSharedPreferences("qwallet_patternlock", 4);
  }
  
  public static boolean getSyncPatternLockState(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_need_sync");
    localStringBuilder.append(paramString);
    boolean bool = paramContext.getBoolean(localStringBuilder.toString(), true);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getSyncPatternLockState.uin=");
      paramContext.append(paramString);
      paramContext.append(",isNeedSync=");
      paramContext.append(bool);
      QLog.d("Q.qwallet.pay.pattutils", 2, paramContext.toString());
    }
    return bool;
  }
  
  public static int getUnlockFailedTimes(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unlock_failed_times");
    localStringBuilder.append(paramString);
    int i = paramContext.getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getUnlockFailedTime.uin=");
      paramContext.append(paramString);
      paramContext.append(",failedTimes=");
      paramContext.append(i);
      QLog.d("Q.qwallet.pay.pattutils", 2, paramContext.toString());
    }
    return i;
  }
  
  public static boolean isFirstCreatePatternLock(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_first_create");
    localStringBuilder.append(paramString);
    boolean bool = paramContext.getBoolean(localStringBuilder.toString(), true);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isFirstCreatePatternLock.uin=");
      paramContext.append(paramString);
      paramContext.append(",isFirst=");
      paramContext.append(bool);
      QLog.d("Q.qwallet.pay.pattutils", 2, paramContext.toString());
    }
    return bool;
  }
  
  public static boolean isFirstEnterAfterLogin(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isFirstEnterAfterLogin");
    localStringBuilder.append(paramString);
    boolean bool = paramContext.getBoolean(localStringBuilder.toString(), true);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isFirstEnterAfterLogin.uin=");
      paramContext.append(paramString);
      paramContext.append(",isFirstEnterAfterLogin=");
      paramContext.append(bool);
      QLog.d("Q.qwallet.pay.pattutils", 2, paramContext.toString());
    }
    return bool;
  }
  
  public static boolean isNeedOpenPatternLock(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      String str = getPWD(paramContext, paramString);
      bool1 = bool2;
      if (str != null)
      {
        if (str.length() <= 0) {
          return false;
        }
        if (isNewCreatePatternLock(paramContext, paramString)) {
          return true;
        }
        if (isFirstEnterAfterLogin(paramContext, paramString)) {
          return true;
        }
        if (getUnlockFailedTimes(paramContext, paramString) >= 5) {
          return true;
        }
        long l = getCheckIntervalTime(paramContext, paramString);
        bool1 = bool2;
        if (getLastExitWalletTime(paramContext, paramString) + l <= NetConnInfoCenter.getServerTimeMillis() / 1000L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isNewCreatePatternLock(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_new_create");
    localStringBuilder.append(paramString);
    boolean bool = paramContext.getBoolean(localStringBuilder.toString(), false);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isNewCreatePatternLock.uin=");
      paramContext.append(paramString);
      paramContext.append(",isNew=");
      paramContext.append(bool);
      QLog.d("Q.qwallet.pay.pattutils", 2, paramContext.toString());
    }
    return bool;
  }
  
  public static boolean isOpenQWalletLockWhenJumpToQWallet(Activity paramActivity, BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if ((paramActivity != null) && (paramBaseQQAppInterface != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).getAppForground(paramActivity)) {
        return false;
      }
      paramString = paramString.toLowerCase();
      if (!paramString.startsWith("mqqapi://wallet/open?")) {
        return false;
      }
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
              break label256;
            }
            paramString.put(localObject2[0], localObject2[1]);
            break label256;
          }
        }
        localObject1 = (String)paramString.get("src_type");
        Object localObject2 = (String)paramString.get("viewtype");
        paramString = (String)paramString.get("view");
        if (localObject1 != null)
        {
          if (!((String)localObject1).equals("web")) {
            return false;
          }
          if (localObject2 != null)
          {
            if (!((String)localObject2).equals("0")) {
              return false;
            }
            if ((paramString != null) && (!paramString.equals("0")))
            {
              boolean bool = paramString.equals("1");
              if (!bool) {
                return false;
              }
            }
            return isPatternLockOpened(paramActivity, paramBaseQQAppInterface.getCurrentAccountUin());
          }
        }
        return false;
      }
      catch (Exception paramActivity)
      {
        return false;
      }
      label256:
      i += 1;
    }
  }
  
  public static boolean isPatternLockOpened(Context paramContext, String paramString)
  {
    paramContext = getPWD(paramContext, paramString);
    return (paramContext != null) && (paramContext.length() > 0);
  }
  
  public static void setCheckIntervalTime(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCheckIntervalTime.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",curTime=");
      localStringBuilder.append(paramLong);
      QLog.d("Q.qwallet.pay.pattutils", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check_interval_time");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
  }
  
  public static void setFirstCreatePatternLock(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFirstCreatePatternLock.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",isFirst=");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.qwallet.pay.pattutils", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_first_create");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public static void setFirstEnterAfterLoginState(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setFirstEnterAfterLoginState.uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",isFirstState=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.qwallet.pay.pattutils", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isFirstEnterAfterLogin");
    localStringBuilder.append(paramString);
    ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
    if (paramBoolean) {
      setSyncPatternLockState(paramContext, paramString, true);
    }
  }
  
  public static void setForgroundIntervalTime(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setForgroundIntervalTime.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",curTime=");
      localStringBuilder.append(paramLong);
      QLog.d("Q.qwallet.pay.pattutils", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("forground_interval_time");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
  }
  
  public static void setLastExitWalletTime(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLastExitWalletTime,curTime=");
      localStringBuilder.append(paramLong);
      QLog.d("Q.qwallet.pay.pattutils", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitinterval_time");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
  }
  
  public static void setLastUnlockFailedTime(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLastUnlockFailedTime.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",curTime=");
      localStringBuilder.append(paramLong);
      QLog.d("Q.qwallet.pay.pattutils", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_unlock_failed_time");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.commit();
  }
  
  public static void setNewCreatePatternLock(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNewCreatePatternLock.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",isNew=");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.qwallet.pay.pattutils", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_new_create");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  public static void setPWD(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGesturePWD.uin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",pw=");
      localStringBuilder.append(paramString2);
      QLog.d("Q.qwallet.pay.pattutils", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lock_pwd");
    localStringBuilder.append(paramString1);
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.apply();
  }
  
  public static void setPWDType(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGesturePWD.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",pwdType=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.qwallet.pay.pattutils", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lock_pwd_type");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static void setSyncPatternLockState(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSyncPatternLockState.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",isNeedSync=");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.qwallet.pay.pattutils", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_need_sync");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean).apply();
  }
  
  public static void setUnlockFailedTimes(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUnlockFailedTime.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",failedTimes=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.qwallet.pay.pattutils", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unlock_failed_times");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static void syncQWalletPatternLock(BaseQQAppInterface paramBaseQQAppInterface)
  {
    ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).syncQWalletPatternLock(paramBaseQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.PatternLockUtils
 * JD-Core Version:    0.7.0.1
 */