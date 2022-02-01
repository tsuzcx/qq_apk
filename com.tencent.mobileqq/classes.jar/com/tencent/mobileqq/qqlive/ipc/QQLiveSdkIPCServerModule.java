package com.tencent.mobileqq.qqlive.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.record.QQLiveRoomRecordManagerProxy;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class QQLiveSdkIPCServerModule
  extends QIPCModule
{
  public static final String ACTION_ROOM_RECORD_GET = "action_room_record_get";
  public static final String ACTION_ROOM_RECORD_REMOVE = "action_room_record_remove";
  public static final String ACTION_ROOM_RECORD_SET = "action_room_record_set";
  public static QQLiveSdkIPCServerModule INSTANCE = new QQLiveSdkIPCServerModule("QQLiveSdkServerIPCModule");
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_PROCESS_CONTEXT_HASH = "key_process_context_hash";
  public static final String KEY_PROCESS_ID = "key_process_id";
  public static final String KEY_ROOM_ID = "key_room_id";
  public static final String KEY_ROOM_RECORD_INFO = "key_room_record_info";
  private static final String TAG = "QQLive_IPC_SERVER";
  
  public QQLiveSdkIPCServerModule(String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCall: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQLive_IPC_SERVER", 1, ((StringBuilder)localObject).toString());
    }
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    try
    {
      paramInt = paramBundle.getInt("key_process_id", 0);
      int i = paramBundle.getInt("key_process_context_hash", 0);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCall, action:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", processid:");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", processHash:");
        ((StringBuilder)localObject).append(i);
        QLog.d("QQLive_IPC_SERVER", 1, ((StringBuilder)localObject).toString());
      }
      boolean bool = "action_room_record_get".equals(paramString);
      if (bool)
      {
        localObject = paramBundle.getString("key_app_id", null);
        paramBundle = QQLiveRoomRecordManagerProxy.a((String)localObject);
        paramString = paramBundle;
        if (paramBundle != null)
        {
          paramString = paramBundle;
          if (paramBundle.processId == paramInt)
          {
            paramString = paramBundle;
            if (paramBundle.processContextHashCode != i)
            {
              QLog.e("QQLive_IPC_SERVER", 1, "get roominfo, process recreated!");
              QQLiveRoomRecordManagerProxy.a((String)localObject, -1L);
              paramString = null;
            }
          }
        }
        paramBundle = new EIPCResult();
        paramBundle.code = 0;
        Bundle localBundle = new Bundle();
        localBundle.putString("key_app_id", (String)localObject);
        localBundle.putParcelable("key_room_record_info", paramString);
        paramBundle.data = localBundle;
        return paramBundle;
      }
      if ("action_room_record_set".equals(paramString))
      {
        paramString = paramBundle.getString("key_app_id", null);
        paramBundle = (QQLiveCurRoomInfo)paramBundle.getParcelable("key_room_record_info");
        paramBundle.processId = paramInt;
        paramBundle.processContextHashCode = i;
        QQLiveRoomRecordManagerProxy.a(paramString, paramBundle);
        paramBundle = new EIPCResult();
        paramBundle.code = 0;
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_app_id", paramString);
        paramBundle.data = ((Bundle)localObject);
        return paramBundle;
      }
      if ("action_room_record_remove".equals(paramString))
      {
        paramString = paramBundle.getString("key_app_id", null);
        long l = paramBundle.getLong("key_room_id");
        QQLiveRoomRecordManagerProxy.a(paramString, l);
        paramBundle = new EIPCResult();
        paramBundle.code = 0;
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_app_id", paramString);
        ((Bundle)localObject).putLong("key_room_id", l);
        paramBundle.data = ((Bundle)localObject);
        return paramBundle;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("QQLive_IPC_SERVER", 1, paramString, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.ipc.QQLiveSdkIPCServerModule
 * JD-Core Version:    0.7.0.1
 */