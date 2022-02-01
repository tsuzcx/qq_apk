package com.tencent.mobileqq.qwallet.ipc.impl;

import Wallet.AcsMsg;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;
import com.tencent.mobileqq.qwallet.hb.emoji.ConvertParam;
import com.tencent.mobileqq.qwallet.ipc.IComIPCUtils;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.io.Serializable;

public class ComIPCUtilsImpl
  implements IComIPCUtils
{
  public static final String KEY_ACTION = "action";
  public static final String KEY_CALL_TYPE = "call_type";
  public static final String KEY_CODE = "code";
  public static final String KEY_IS_SYNC = "is_sync";
  public static final String KEY_LOAD_ITEM = "load_item";
  public static final String KEY_LOAD_PARAM = "load_param";
  public static final String KEY_MINI_LAUNCH_PARAM = "mini_launch_param";
  public static final String KEY_NAME = "name";
  public static final String KEY_OPER_TYPE = "oper_type";
  public static final String KEY_PATH = "path";
  public static final String KEY_RECEIVER = "receiver";
  public static final String KEY_REQ_ID = "req_id";
  public static final String KEY_REQ_PARAM = "req_param";
  public static final String KEY_RESULT = "res";
  public static final String KEY_UIN = "uin";
  public static final String KEY_VERSION = "version";
  public static final int OPER_TYPE_CANCEL_ALARM_NOTIFACATION = 12;
  public static final int OPER_TYPE_COMPOSITE_GIF = 7;
  public static final int OPER_TYPE_GET_FRIEND_NICK_NAME = 0;
  public static final int OPER_TYPE_GET_REMINDER_SETTING_OPEN = 9;
  public static final int OPER_TYPE_LAUNCH_MINI_APP = 1;
  public static final int OPER_TYPE_NOTIFY_MINIAPP_LIFE_ACTION = 5;
  public static final int OPER_TYPE_QWALLET_CFG_NOTIFY = 15;
  public static final int OPER_TYPE_QWALLET_CFG_NOTIFY_UNREGIST = 16;
  public static final int OPER_TYPE_RECORD_APP_START = 3;
  public static final int OPER_TYPE_RED_POINT_DO_CLICK = 6;
  public static final int OPER_TYPE_REMOVE_MESSAGE_RECORD = 13;
  public static final int OPER_TYPE_REMOVE_TASK = 8;
  public static final int OPER_TYPE_SET_ALARM_NOTIFACATION = 11;
  public static final int OPER_TYPE_SET_REMINDER_SETTING_OPEN = 10;
  public static final int OPER_TYPE_START_APOLLO_GAME = 4;
  public static final int OPER_TYPE_TEST_FILE_EXIST = 18;
  public static final int OPER_TYPE_TRY_UPDATE_MINI_APP = 2;
  
  public static void compositeAndTransGif(ConvertParam paramConvertParam, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 7);
    localBundle.putSerializable("req_param", paramConvertParam);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle, paramEIPCResultCallback);
  }
  
  public static int getFileExistStatusInMainProcess(String paramString)
  {
    if ((QWalletHelperImpl.getAppRuntime() instanceof BaseQQAppInterface)) {
      try
      {
        boolean bool = new File(paramString).exists();
        if (bool) {
          return 2;
        }
        return 1;
      }
      catch (Throwable paramString)
      {
        QLog.e("getFileExistStatus", 1, paramString, new Object[0]);
        return 3;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 18);
    localBundle.putString("path", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle);
    if ((paramString != null) && (paramString.isSuccess()) && (paramString.data != null)) {
      try
      {
        if (paramString.data.containsKey("res"))
        {
          int i = paramString.data.getInt("res");
          return i;
        }
        return 4;
      }
      catch (Throwable paramString)
      {
        QLog.e("getFileExistStatus IPC", 1, paramString, new Object[0]);
        return 5;
      }
    }
    return 6;
  }
  
  public static void redPointDoClick(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 6);
    localBundle.putString("req_param", paramString);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle, null);
  }
  
  public static void registIPCUpdateListener(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener)
  {
    if (paramConfigUpdateListener == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 15);
    localBundle.putString("key", paramString);
    localBundle.putInt("code", paramConfigUpdateListener.hashCode());
    localBundle.putParcelable("receiver", PreloadStaticApi.a(new ComIPCUtilsImpl.1(null, paramConfigUpdateListener, paramString)));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle, null);
  }
  
  public static void removeTask(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 8);
    localBundle.putInt("req_id", paramInt);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle, null);
  }
  
  public static void unRegistIPCUpdateListener(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener)
  {
    if (paramConfigUpdateListener == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 16);
    localBundle.putString("key", paramString);
    localBundle.putInt("code", paramConfigUpdateListener.hashCode());
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle, null);
  }
  
  public void cancelAlarmNotifaction(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 12);
    localBundle.putSerializable("req_param", paramAcsMsg);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle, null);
  }
  
  public String getFriendNickName(String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("oper_type", 0);
    ((Bundle)localObject).putString("uin", paramString);
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "ComIPCUtilsImpl", (Bundle)localObject);
    localObject = paramString;
    if (localEIPCResult != null)
    {
      localObject = paramString;
      if (localEIPCResult.isSuccess())
      {
        localObject = paramString;
        if (localEIPCResult.data != null) {
          localObject = localEIPCResult.data.getString("res");
        }
      }
    }
    return localObject;
  }
  
  public boolean isQQReminderOpen()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("oper_type", 9);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "ComIPCUtilsImpl", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()) && (((EIPCResult)localObject).data != null)) {
      return ((EIPCResult)localObject).data.getBoolean("res");
    }
    return false;
  }
  
  public void recordAppStart(Serializable paramSerializable)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 3);
    localBundle.putSerializable("req_param", paramSerializable);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle, null);
  }
  
  public void removeMessageRecord(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 13);
    localBundle.putSerializable("req_param", paramAcsMsg);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle, null);
  }
  
  public void setAlarmNotifaction(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 11);
    localBundle.putSerializable("req_param", paramAcsMsg);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle, null);
  }
  
  public void setQQReminderSwitch(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 10);
    localBundle.putBoolean("req_param", paramBoolean);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle, null);
  }
  
  public void startApolloGame(StartCheckParam paramStartCheckParam)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 4);
    localBundle.putSerializable("req_param", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.ComIPCUtilsImpl
 * JD-Core Version:    0.7.0.1
 */