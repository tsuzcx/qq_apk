package com.tencent.mobileqq.utils;

import amtj;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import anzo;
import anzv;
import axsb;
import bbtd;
import bfuf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler.ARPromotionEntryHandler;
import com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler.ARPromotionResHandler;
import com.tencent.mobileqq.utils.confighandler.ConfigHandler;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.mobileqq.utils.confighandler.GestureConfigHandler;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallHandler;
import com.tencent.mobileqq.utils.confighandler.QAVSoConfigHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import lbp;
import lzn;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class BusinessCommonConfig
  implements Manager
{
  public static final String BusinessNotify_QQ_to_SubProcess = "tencent.businessnotify.qq.to.subprocess";
  public static final String BusinessNotify_SubProcess_to_QQ = "tencent.businessnotify.subprocess.to.qq";
  public final String TAG = "BusinessCommonConfig_" + AudioHelper.b();
  ARPromotionConfigHandler.ARPromotionEntryHandler mARPromotionEntryHandler = null;
  ARPromotionConfigHandler.ARPromotionResHandler mARPromotionResHandler = null;
  QQAppInterface mApp;
  BroadcastReceiver mBroadcastReceiver = null;
  GestureConfigHandler mGestureConfigHandler = null;
  QAVFunCallHandler mQAVFunCallHandler = null;
  QAVSoConfigHandler mQAVSoConfigHandler = null;
  
  public BusinessCommonConfig(QQAppInterface paramQQAppInterface)
  {
    QLog.w(this.TAG, 1, "BusinessCommonConfig, mApp[" + this.mApp + "]");
    this.mApp = paramQQAppInterface;
    registReceiverToReceSubProcessNotify(paramQQAppInterface);
  }
  
  public static BusinessCommonConfig getInstance(AppRuntime paramAppRuntime)
  {
    return (BusinessCommonConfig)paramAppRuntime.getManager(278);
  }
  
  public static boolean isResReady(String paramString1, SharedPreferences paramSharedPreferences, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramSharedPreferences == null)
    {
      bool2 = bool1;
      return bool2;
    }
    String str = paramSharedPreferences.getString(paramString2, null);
    if ((TextUtils.isEmpty(str)) || (!str.equals(paramString3)))
    {
      paramSharedPreferences = localObject;
      bool1 = bool2;
      if (AudioHelper.f())
      {
        paramSharedPreferences = "md5不一样，sp_md5[" + str + "], configMd5[" + paramString3 + "]";
        bool1 = bool2;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!AudioHelper.f()) {
        break;
      }
      QLog.w(paramString1, 1, "isResReady, md5Key[" + paramString2 + "], ready[" + bool1 + "], " + paramSharedPreferences);
      return bool1;
      if (!FileUtils.fileExists(paramString4))
      {
        paramSharedPreferences = localObject;
        bool1 = bool2;
        if (AudioHelper.f())
        {
          paramSharedPreferences = amtj.a(2131700420) + paramString4 + "]";
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = true;
        paramSharedPreferences = localObject;
      }
    }
  }
  
  public static void notifyQQDownload(int paramInt1, String paramString, int paramInt2)
  {
    QLog.w("BusinessCommonConfig", 1, "notifyQQDownload, bussinessType[" + paramInt1 + "], bussinessSubName[" + paramString + "], itemIndxe[" + paramInt2 + "]");
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.businessnotify.subprocess.to.qq");
    localIntent.putExtra("event", 1);
    localIntent.putExtra("bussinessType", paramInt1);
    localIntent.putExtra("bussinessSubName", paramString);
    localIntent.putExtra("download_Index", paramInt2);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void onDownloadRequest(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("bussinessType", 0);
    String str = paramIntent.getStringExtra("bussinessSubName");
    int j = paramIntent.getIntExtra("download_Index", 0);
    QLog.w("BusinessCommonConfig", 1, "onDownloadRequest, bussinessType[" + i + "], bussinessSubName[" + str + "], download_Index[" + j + "]");
    switch (i)
    {
    default: 
      return;
    case 2: 
      anzv.a(paramQQAppInterface).a(paramQQAppInterface, str);
      return;
    case 1: 
      bbtd.a();
      return;
    }
    lzn.a().a(str);
  }
  
  public static void saveMd5(String paramString1, SharedPreferences paramSharedPreferences, String paramString2, String paramString3)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    boolean bool = paramSharedPreferences.edit().putString(paramString2, paramString3).commit();
    QLog.w(paramString1, 1, "saveMd5, ret[" + bool + "], spMd5Key[" + paramString2 + "], md5[" + paramString3 + "]");
  }
  
  public static void sendConfigUpdateNotify(int paramInt, String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.businessnotify.qq.to.subprocess");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("bussinessType", paramInt);
    localIntent.putExtra("event", 2);
    localIntent.putExtra("config_Content", paramString);
    localBaseApplicationImpl.sendBroadcast(localIntent);
    QLog.w("BusinessCommonConfig", 1, "sendConfigUpdateNotify, bussinessType[" + paramInt + "]");
  }
  
  public static void sendDownloadResultNotify(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.businessnotify.qq.to.subprocess");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("bussinessType", paramInt1);
    localIntent.putExtra("bussinessSubName", paramString);
    localIntent.putExtra("event", 1);
    localIntent.putExtra("download_Index", paramInt2);
    localIntent.putExtra("download_Progress", paramInt3);
    localBaseApplicationImpl.sendBroadcast(localIntent);
    QLog.w("BusinessCommonConfig", 1, "sendDownloadResultNotify, bussinessType[" + paramInt1 + "], bussinessSubName[" + paramString + "], index[" + paramInt2 + "], process[" + paramInt3 + "]");
  }
  
  public <T extends ConfigInfo> Boolean decodeConfig(QQAppInterface paramQQAppInterface, int paramInt, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    Intent localIntent;
    int i;
    Object localObject4;
    Object localObject2;
    for (;;)
    {
      ConfigHandler localConfigHandler;
      String str;
      int j;
      int k;
      Class localClass;
      Object localObject1;
      Throwable localThrowable2;
      try
      {
        localConfigHandler = getConfigHandler(paramInt);
        if (localConfigHandler == null)
        {
          AudioHelper.c(amtj.a(2131700406) + paramInt);
          return Boolean.valueOf(false);
        }
        str = localConfigHandler.getTag();
        if (paramConfig == null)
        {
          QLog.d(localConfigHandler.getTag(), 1, "handleResp_Config, config is null");
          return Boolean.valueOf(false);
        }
        j = localConfigHandler.getConfigVer();
        if (paramConfig.msg_content_list == null) {
          break label1191;
        }
        paramInt = paramConfig.msg_content_list.size();
        k = paramConfig.version.get();
        QLog.w(str, 1, "handleResp_Config, serverVersion[" + k + "], localVersion[" + j + "], size[" + paramInt + "]");
        if (k == j)
        {
          localConfigHandler.onGetConfigFinish(paramQQAppInterface, null, null);
          return Boolean.valueOf(true);
        }
        localClass = localConfigHandler.getConfigInfoClass();
        paramIntent = null;
        if ((paramInt <= 0) && (k != 0))
        {
          localConfigHandler.saveConfig(null, k);
          localIntent = null;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.w(this.TAG, 1, "decodeConfig, Exception", paramQQAppInterface);
        if (!AudioHelper.e()) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = localClass.getName();
          paramIntent = (Intent)localObject1;
          paramConfig = (ConfigInfo)localClass.newInstance();
        }
        catch (Exception localException2)
        {
          int m;
          Object localObject5;
          paramConfig = localIntent;
          break;
        }
        try
        {
          paramConfig.setUin(paramQQAppInterface.getAccount());
          paramConfig.serverVer = k;
          localConfigHandler.onGetConfigFinish(paramQQAppInterface, null, paramConfig);
          return Boolean.valueOf(true);
        }
        catch (Exception localException1)
        {
          paramIntent = (Intent)localObject2;
          break;
          continue;
          localObject2 = localException1;
          paramIntent = localIntent;
        }
      }
      QLog.w(str, 1, "new 实例失败1, cls[" + paramIntent + "]", localThrowable2);
      if (AudioHelper.e())
      {
        throw new IllegalArgumentException(str + "new 实例失败1, cls[" + paramIntent + "]");
        throw new IllegalArgumentException(amtj.a(2131700408));
        localThrowable2 = null;
        i = 0;
        localObject4 = null;
        localIntent = null;
        if (i < paramInt)
        {
          paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
          if (paramIntent != null)
          {
            m = paramIntent.task_id.get();
            localObject1 = paramIntent.content.get();
            if (localObject1 != null)
            {
              if (paramIntent.compress.get() == 1)
              {
                localObject5 = axsb.a(((ByteStringMicro)localObject1).toByteArray());
                if (localObject5 == null) {}
              }
              for (;;)
              {
                try
                {
                  paramIntent = new String((byte[])localObject5, "UTF-8");
                  localObject1 = "";
                }
                catch (UnsupportedEncodingException paramIntent)
                {
                  for (;;)
                  {
                    try
                    {
                      localObject1 = localClass.getName();
                    }
                    catch (Exception localException5)
                    {
                      boolean bool;
                      Object localObject7;
                      Exception localException7;
                      Object localObject6;
                      localObject2 = null;
                      continue;
                      paramIntent = localIntent;
                      localObject2 = localException2;
                      localObject3 = localObject4;
                    }
                    try
                    {
                      localObject5 = (ConfigInfo)localClass.newInstance();
                    }
                    catch (Exception localException3)
                    {
                      localObject7 = null;
                      localObject4 = localObject2;
                      localObject2 = localObject7;
                    }
                  }
                  try
                  {
                    ((ConfigInfo)localObject5).setUin(paramQQAppInterface.getAccount());
                    ((ConfigInfo)localObject5).serverVer = k;
                    bool = ((ConfigInfo)localObject5).tryParse(str, paramIntent);
                    if (!bool) {
                      localObject5 = null;
                    }
                  }
                  catch (Exception localException6)
                  {
                    localObject4 = localObject2;
                    localObject2 = localException6;
                    localException7 = localException3;
                    localObject6 = localObject2;
                    localObject2 = localException7;
                    break;
                  }
                  try
                  {
                    AudioHelper.c(str + amtj.a(2131700397));
                    localObject4 = localObject1;
                    localObject1 = localObject5;
                    QLog.w(str, 1, "handleResp_Config, index[" + i + "], task_id[" + m + "], downloadInfo[" + localObject1 + "], jsonContent[" + paramIntent + "]");
                    if (localObject1 == null) {
                      break label1213;
                    }
                    if (m != ((ConfigInfo)localObject1).task_id) {
                      break label1185;
                    }
                    if (!TextUtils.isEmpty(paramIntent))
                    {
                      localConfigHandler.saveConfig(paramIntent, k);
                      localConfigHandler.onGetConfigFinish(paramQQAppInterface, paramIntent, (ConfigInfo)localObject1);
                    }
                    return Boolean.valueOf(true);
                  }
                  catch (Exception localException4)
                  {
                    localObject4 = localObject2;
                    localObject2 = null;
                    break;
                  }
                  paramIntent = paramIntent;
                  paramIntent.printStackTrace();
                  localObject1 = amtj.a(2131700391) + paramIntent.getMessage();
                  paramIntent = null;
                  continue;
                }
                catch (OutOfMemoryError paramIntent)
                {
                  paramIntent.printStackTrace();
                  localObject1 = amtj.a(2131700394) + paramIntent.getMessage();
                  System.gc();
                  try
                  {
                    paramIntent = new String((byte[])localObject5, "UTF-8");
                  }
                  catch (Throwable localThrowable1)
                  {
                    paramIntent = null;
                    localObject2 = amtj.a(2131700389) + localThrowable1.getMessage();
                  }
                  continue;
                }
                QLog.i(str, 1, "decodeConfig. jsonContent = " + paramIntent);
                bool = TextUtils.isEmpty(paramIntent);
                if (bool) {
                  break label939;
                }
                localObject2 = amtj.a(2131700413);
                paramIntent = null;
                continue;
                paramIntent = ((ByteStringMicro)localObject2).toStringUtf8();
                localObject2 = amtj.a(2131700409);
              }
              QLog.w(str, 1, "new 实例失败2, cls[" + localObject4 + "]", (Throwable)localObject5);
              if (AudioHelper.e())
              {
                throw new IllegalArgumentException(str + "new 实例失败2, cls[" + localObject4 + "]");
                label939:
                QLog.d(str, 2, String.format("handleResp_Config, err, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s], %s", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt), localObject2 }));
                break label1244;
              }
            }
            else
            {
              QLog.d(str, 1, String.format("handleResp_Config, sub_content为空, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt) }));
              break label1244;
            }
          }
          else
          {
            QLog.d(str, 1, String.format("handleResp_Config, content为空, index[%s], serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt) }));
            break label1244;
          }
        }
        label1185:
        break label1220;
      }
      continue;
      label1191:
      paramInt = -1;
    }
    for (;;)
    {
      label1213:
      label1220:
      i += 1;
      localObject4 = localObject3;
      localIntent = paramIntent;
      Object localObject3 = localObject2;
      break;
      label1244:
      paramIntent = localIntent;
      localObject2 = localObject3;
      localObject3 = localObject4;
    }
  }
  
  public <T extends ConfigInfo> Boolean decodeConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    Object localObject1 = null;
    localObject3 = null;
    for (;;)
    {
      try
      {
        localConfigHandler = getConfigHandler(paramInt);
        if (localConfigHandler == null)
        {
          AudioHelper.c(amtj.a(2131700390) + paramInt);
          return Boolean.valueOf(false);
        }
        str1 = localConfigHandler.getTag();
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = localConfigHandler.getConfigInfoClass();
          str2 = ((Class)localObject1).getName();
        }
      }
      catch (Exception paramQQAppInterface)
      {
        ConfigHandler localConfigHandler;
        String str1;
        String str2;
        ConfigInfo localConfigInfo;
        Object localObject2;
        QLog.w(this.TAG, 1, "decodeConfig, Exception", paramQQAppInterface);
        if (!AudioHelper.e()) {
          continue;
        }
        throw new IllegalArgumentException(amtj.a(2131700418));
      }
      try
      {
        localConfigInfo = (ConfigInfo)((Class)localObject1).newInstance();
        localConfigInfo.setUin(paramQQAppInterface.getAccount());
        localConfigInfo.serverVer = lbp.a(paramInt);
        localObject1 = localConfigInfo;
        if (!localConfigInfo.tryParse(str1, paramString))
        {
          AudioHelper.c(str1 + amtj.a(2131700407));
          localObject1 = null;
        }
      }
      catch (Exception localException)
      {
        QLog.w(str1, 1, "new 实例失败2, cls[" + str2 + "]", localException);
        localObject2 = localObject3;
        if (!AudioHelper.e()) {
          continue;
        }
        throw new IllegalArgumentException(str1 + "new 实例失败2, cls[" + str2 + "]");
      }
    }
    QLog.w(str1, 1, "handleResp_Config, downloadInfo[" + localObject1 + "], jsonContent[" + paramString + "]");
    localConfigHandler.onGetConfigFinish(paramQQAppInterface, paramString, (ConfigInfo)localObject1);
    return Boolean.valueOf(true);
  }
  
  public void doOnReconnect()
  {
    getConfigHandler(382).doOnReconnect(this.mApp);
  }
  
  public void fillConfigVersion(int paramInt, ConfigurationService.ConfigSeq paramConfigSeq)
  {
    int i = 0;
    ConfigHandler localConfigHandler = getConfigHandler(paramInt);
    if (localConfigHandler == null) {
      return;
    }
    String str = localConfigHandler.getTag();
    int j = localConfigHandler.getConfigVer();
    if (AudioHelper.a(9) == 1)
    {
      QLog.w(str, 1, "强制拉取配置, 原localVersion[" + j + "]");
      localConfigHandler.saveConfig(null, 0);
    }
    for (;;)
    {
      paramConfigSeq.version.set(i);
      paramConfigSeq.compress.set(1);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w(str, 1, "fillVersion, configType[" + paramInt + "], localVersion[" + i + "]");
      return;
      i = j;
    }
  }
  
  public ConfigHandler getConfigHandler(int paramInt)
  {
    Object localObject1;
    switch (paramInt)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        if (this.mGestureConfigHandler == null) {
          this.mGestureConfigHandler = new GestureConfigHandler();
        }
        localObject1 = this.mGestureConfigHandler;
        continue;
      }
      finally {}
      if (this.mQAVSoConfigHandler == null) {
        this.mQAVSoConfigHandler = new QAVSoConfigHandler();
      }
      localObject1 = this.mQAVSoConfigHandler;
      continue;
      if (this.mARPromotionEntryHandler == null)
      {
        QLog.w(this.TAG, 1, "ARPromotionEntryHandler, mApp[" + this.mApp + "]");
        this.mARPromotionEntryHandler = new ARPromotionConfigHandler.ARPromotionEntryHandler(this.mApp.getAccount());
      }
      localObject1 = this.mARPromotionEntryHandler;
      continue;
      if (this.mARPromotionResHandler == null)
      {
        QLog.w(this.TAG, 1, "ARPromotionResHandler, mApp[" + this.mApp + "]");
        this.mARPromotionResHandler = new ARPromotionConfigHandler.ARPromotionResHandler(this.mApp.getAccount());
      }
      localObject1 = this.mARPromotionResHandler;
      continue;
      if (this.mQAVFunCallHandler == null)
      {
        QLog.w(this.TAG, 1, "QAVFunCallHandler, mApp[" + this.mApp + "]");
        this.mQAVFunCallHandler = new QAVFunCallHandler(this.mApp.getAccount());
      }
      localObject1 = this.mQAVFunCallHandler;
    }
  }
  
  public void handleResp_Config_Fail(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean, ConfigurationService.RespGetConfig paramRespGetConfig)
  {
    paramQQAppInterface = getConfigHandler(paramInt);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getTag();
      if (paramBoolean) {
        break label52;
      }
      QLog.d(paramQQAppInterface, 2, "handleResp_Config_Fail");
    }
    label52:
    do
    {
      return;
      paramQQAppInterface = "BusinessCommonConfig." + paramInt;
      break;
      if (paramRespGetConfig.result.get() != 0)
      {
        paramInt = paramRespGetConfig.result.get();
        QLog.d(paramQQAppInterface, 2, "handleResp_Config_Fail, result[" + paramInt + "]");
        return;
      }
    } while ((paramRespGetConfig.config_list != null) && (paramRespGetConfig.config_list.size() != 0));
    QLog.d(paramQQAppInterface, 2, "handleResp_Config_Fail, config_list is null");
  }
  
  public void handleResp_Config_NoResp(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ConfigHandler localConfigHandler = getConfigHandler(paramInt);
    if (QLog.isDevelopLevel()) {
      if (localConfigHandler == null) {
        break label46;
      }
    }
    label46:
    for (String str = localConfigHandler.getTag();; str = "BusinessCommonConfig." + paramInt)
    {
      QLog.w(str, 1, "handleResp_Config_NoResp");
      if (localConfigHandler != null) {
        localConfigHandler.onGetConfigFinish(paramQQAppInterface, null, null);
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    QLog.w(this.TAG, 1, "onDestroy, mBroadcastReceiver[" + this.mBroadcastReceiver + "]");
    if (this.mBroadcastReceiver != null)
    {
      this.mApp.getApp().unregisterReceiver(this.mBroadcastReceiver);
      this.mBroadcastReceiver = null;
    }
    this.mGestureConfigHandler = null;
    this.mQAVSoConfigHandler = null;
    this.mARPromotionEntryHandler = null;
    this.mARPromotionResHandler = null;
    this.mQAVFunCallHandler = null;
  }
  
  boolean registReceiverToReceSubProcessNotify(QQAppInterface paramQQAppInterface)
  {
    this.mBroadcastReceiver = new bfuf(this, paramQQAppInterface);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.businessnotify.subprocess.to.qq");
    return paramQQAppInterface.getApp().registerReceiver(this.mBroadcastReceiver, localIntentFilter) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BusinessCommonConfig
 * JD-Core Version:    0.7.0.1
 */