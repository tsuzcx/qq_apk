package com.tencent.mobileqq.qqlive.record;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

public class QQLiveRoomRecordManagerProxy
{
  private static Object a = new Object();
  private static QQLiveCurRoomInfo b = null;
  
  private static Bundle a(@NonNull String paramString, @Nullable Bundle paramBundle)
  {
    try
    {
      paramBundle = QIPCClientHelper.getInstance().callServer("QQLiveSdkServerIPCModule", paramString, paramBundle);
      if (paramBundle == null)
      {
        paramBundle = new StringBuilder();
        paramBundle.append(paramString);
        paramBundle.append(", ipc result is null");
        QLog.e("QQLive_IPC_RRM", 1, paramBundle.toString());
        return null;
      }
      if (!paramBundle.isSuccess())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(", result is failed: ");
        localStringBuilder.append(paramBundle.code);
        QLog.e("QQLive_IPC_RRM", 1, localStringBuilder.toString(), paramBundle.e);
        return null;
      }
      if (paramBundle.data == null)
      {
        paramBundle = new StringBuilder();
        paramBundle.append(paramString);
        paramBundle.append(", result's data is null");
        QLog.e("QQLive_IPC_RRM", 1, paramBundle.toString());
        return null;
      }
      paramString = paramBundle.data;
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.e("QQLive_IPC_RRM", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  public static QQLiveCurRoomInfo a(@Nullable String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurRoomInfo, appId=");
      localStringBuilder.append(paramString);
      QLog.d("QQLive_IPC_RRM", 1, localStringBuilder.toString());
    }
    if (a()) {
      return b(paramString);
    }
    return c(paramString);
  }
  
  private static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putInt("key_process_id", MobileQQ.sProcessId);
    paramBundle.putInt("key_process_context_hash", MobileQQ.sMobileQQ.hashCode());
  }
  
  public static void a(@Nullable String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeCurRoomInfo, appId=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", roomId:");
      localStringBuilder.append(paramLong);
      QLog.d("QQLive_IPC_RRM", 1, localStringBuilder.toString());
    }
    if (a())
    {
      c(paramString, paramLong);
      return;
    }
    b(paramString, paramLong);
  }
  
  public static void a(@Nullable String paramString, QQLiveCurRoomInfo paramQQLiveCurRoomInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordCurRoomInfo, appId=");
      localStringBuilder.append(paramString);
      QLog.d("QQLive_IPC_RRM", 1, localStringBuilder.toString());
    }
    if (a())
    {
      c(paramString, paramQQLiveCurRoomInfo);
      return;
    }
    b(paramString, paramQQLiveCurRoomInfo);
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processId: ");
      localStringBuilder.append(MobileQQ.sProcessId);
      QLog.d("QQLive_IPC_RRM", 1, localStringBuilder.toString());
    }
    return MobileQQ.sProcessId == 1;
  }
  
  private static QQLiveCurRoomInfo b(@Nullable String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurRoomInfoInMainProcess, appId=");
      localStringBuilder.append(paramString);
      QLog.d("QQLive_IPC_RRM", 1, localStringBuilder.toString());
    }
    return b;
  }
  
  private static void b(@Nullable String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeCurRoomInfoIPC, appId=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", roomId:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("QQLive_IPC_RRM", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_app_id", paramString);
    ((Bundle)localObject).putLong("key_room_id", paramLong);
    a((Bundle)localObject);
    a("action_room_record_remove", (Bundle)localObject);
  }
  
  private static void b(@Nullable String paramString, QQLiveCurRoomInfo paramQQLiveCurRoomInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurRoomInfoIPC, appId=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQLive_IPC_RRM", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_app_id", paramString);
    ((Bundle)localObject).putParcelable("key_room_record_info", paramQQLiveCurRoomInfo);
    a((Bundle)localObject);
    a("action_room_record_set", (Bundle)localObject);
  }
  
  private static QQLiveCurRoomInfo c(@Nullable String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCurRoomInfoIPC, appId=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQLive_IPC_RRM", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_app_id", paramString);
    a((Bundle)localObject);
    paramString = a("action_room_record_get", (Bundle)localObject);
    if (paramString == null) {
      return null;
    }
    return (QQLiveCurRoomInfo)paramString.getParcelable("key_room_record_info");
  }
  
  private static void c(@Nullable String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("removeCurRoomInfoInMainProcess, appId=");
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append(", roomId:");
      ((StringBuilder)???).append(paramLong);
      QLog.d("QQLive_IPC_RRM", 1, ((StringBuilder)???).toString());
    }
    synchronized (a)
    {
      if (b == null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeCurRoomRecord, curRoomInfo is null, appId:");
          localStringBuilder.append(paramString);
          QLog.d("QQLive_IPC_RRM", 1, localStringBuilder.toString());
        }
        return;
      }
      if (paramLong == -1L)
      {
        b = null;
        if (QLog.isColorLevel()) {
          QLog.d("QQLive_IPC_RRM", 1, "roomId is -1, clear");
        }
        return;
      }
      if (b.roomId != paramLong)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLive_IPC_RRM", 1, "removeCurRoomRecord, roomId diff");
        }
        return;
      }
      b = null;
      return;
    }
  }
  
  private static void c(@Nullable String arg0, QQLiveCurRoomInfo paramQQLiveCurRoomInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurRoomInfoInMainProcess, appId=");
      localStringBuilder.append(???);
      localStringBuilder.append(", info:");
      localStringBuilder.append(paramQQLiveCurRoomInfo);
      if (localStringBuilder.toString() == null) {
        ??? = "null";
      } else {
        ??? = paramQQLiveCurRoomInfo.toString();
      }
      QLog.d("QQLive_IPC_RRM", 1, ???);
    }
    synchronized (a)
    {
      if ((b != null) && (!b.isConditionEquals(paramQQLiveCurRoomInfo))) {
        QLog.e("QQLive_IPC_RRM", 1, "recordCurRoomInfo, curRoomInfo not null");
      }
      b = paramQQLiveCurRoomInfo;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.record.QQLiveRoomRecordManagerProxy
 * JD-Core Version:    0.7.0.1
 */