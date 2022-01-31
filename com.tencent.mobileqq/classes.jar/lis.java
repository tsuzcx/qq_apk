import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class lis
{
  public static void a()
  {
    try
    {
      boolean bool = a("QuaVChatNewIntent", true, null);
      QLog.d("VideoBeaconReporter", 1, "event_QuaVChatNewIntent, isSucceed[true],  ret[" + bool + "]");
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VideoBeaconReporter", 2, "event_QuaVChatNewIntent:", localThrowable);
    }
  }
  
  public static void a(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    boolean bool2 = true;
    QLog.d("VideoBeaconReporter", 1, "reportQuaOnCloseVideo_onCloseVideo :reason[" + paramInt + "], param0[" + paramLong1 + "], param1[" + paramLong2 + "], param2[" + paramString + "], ");
    for (;;)
    {
      try
      {
        localHashMap = new HashMap();
        l = paramLong1;
        if (paramLong2 != 0L)
        {
          i = (int)paramLong2 + 1000;
          paramInt = i;
          l = paramLong1;
          if (paramString == null) {}
        }
      }
      catch (Throwable paramString)
      {
        HashMap localHashMap;
        long l;
        int i;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("VideoBeaconReporter", 2, "event_QuaOnCloseVideo:", paramString);
        return;
        boolean bool1 = false;
        continue;
        if (l != 0L) {
          continue;
        }
        bool1 = bool2;
        continue;
      }
      try
      {
        l = Long.parseLong(paramString);
        paramInt = i;
      }
      catch (Exception paramString)
      {
        paramInt = i;
        l = paramLong1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoBeaconReporter", 2, "parseLong error:", paramString);
        paramInt = i;
        l = paramLong1;
      }
    }
    localHashMap.put("reason", "" + paramInt);
    localHashMap.put("error_code", "" + l);
    if (paramInt == 1)
    {
      bool1 = bool2;
      if (l != 1L)
      {
        bool1 = bool2;
        if (l != 2L) {}
      }
      else
      {
        bool2 = a("QuaOnCloseVideo", bool1, localHashMap);
        QLog.d("VideoBeaconReporter", 1, "event_QuaOnCloseVideo, isSucceed[" + bool1 + "], node_reason[" + (String)localHashMap.get("reason") + "], node_error_code[" + (String)localHashMap.get("error_code") + "],     ret[" + bool2 + "]");
        return;
      }
    }
  }
  
  public static void a(long paramLong)
  {
    boolean bool1 = true;
    for (;;)
    {
      long l;
      try
      {
        new HashMap();
        l = -1L;
        if (paramLong <= 0L) {
          break label107;
        }
        l = System.currentTimeMillis() - paramLong;
      }
      catch (Throwable localThrowable)
      {
        boolean bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoBeaconReporter", 2, "event_QuaInviteClose:", localThrowable);
        return;
      }
      bool2 = a("QuaInviteClose", bool1, null);
      QLog.d("VideoBeaconReporter", 1, "event_QuaInviteClose, isSucceed[" + bool1 + "],  ret[" + bool2 + "]");
      return;
      label107:
      while (l <= 2000L)
      {
        bool1 = false;
        break;
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        localHashMap = new HashMap();
        if (!paramBoolean1) {
          continue;
        }
        localHashMap.put("broadcast_created", "1");
        if (!paramBoolean2) {
          continue;
        }
        localHashMap.put("vchat_created", "1");
        paramBoolean1 = bool;
      }
      catch (Throwable localThrowable)
      {
        HashMap localHashMap;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("VideoBeaconReporter", 2, "event_QuaProcessWakeUp:", localThrowable);
        return;
        localThrowable.put("vchat_created", "0");
        paramBoolean1 = false;
        continue;
      }
      paramBoolean2 = a("QuaProcessWakeUp", paramBoolean1, localHashMap);
      QLog.d("VideoBeaconReporter", 1, "event_QuaProcessWakeUp, isSucceed[" + paramBoolean1 + "], node_broadcast_created[" + (String)localHashMap.get("broadcast_created") + "], node_vchat_created[" + (String)localHashMap.get("vchat_created") + "],     ret[" + paramBoolean2 + "]");
      return;
      localHashMap.put("broadcast_created", "0");
    }
  }
  
  private static boolean a(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    axrn.a(BaseApplicationImpl.getContext()).a(null, paramString, paramBoolean, 0L, 0L, paramHashMap, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lis
 * JD-Core Version:    0.7.0.1
 */