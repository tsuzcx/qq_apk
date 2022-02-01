package com.tencent.mobileqq.utils;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.so.ResDownloadControl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionMgr;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler.ARPromotionEntryHandler;
import com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler.ARPromotionResHandler;
import com.tencent.mobileqq.utils.confighandler.ConfigHandler;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.mobileqq.utils.confighandler.GestureConfigHandler;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallHandler;
import com.tencent.mobileqq.utils.confighandler.QAVSoConfigHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class BusinessCommonConfig
  implements Manager
{
  public static final String BusinessNotify_QQ_to_SubProcess = "tencent.businessnotify.qq.to.subprocess";
  public static final String BusinessNotify_SubProcess_to_QQ = "tencent.businessnotify.subprocess.to.qq";
  final String TAG;
  ARPromotionConfigHandler.ARPromotionEntryHandler mARPromotionEntryHandler = null;
  ARPromotionConfigHandler.ARPromotionResHandler mARPromotionResHandler = null;
  QQAppInterface mApp;
  BroadcastReceiver mBroadcastReceiver = null;
  GestureConfigHandler mGestureConfigHandler = null;
  QAVFunCallHandler mQAVFunCallHandler = null;
  QAVSoConfigHandler mQAVSoConfigHandler = null;
  
  public BusinessCommonConfig(QQAppInterface paramQQAppInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("BusinessCommonConfig_");
    ((StringBuilder)localObject).append(QQAudioHelper.d());
    this.TAG = ((StringBuilder)localObject).toString();
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BusinessCommonConfig, mApp[");
    localStringBuilder.append(this.mApp);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    this.mApp = paramQQAppInterface;
    registReceiverToReceSubProcessNotify(paramQQAppInterface);
  }
  
  public static BusinessCommonConfig getInstance(AppRuntime paramAppRuntime)
  {
    return (BusinessCommonConfig)paramAppRuntime.getManager(QQManagerFactory.BUSINESS_COMMON_CONFIG_MANAGER);
  }
  
  public static boolean isResReady(String paramString1, SharedPreferences paramSharedPreferences, String paramString2, String paramString3, String paramString4)
  {
    boolean bool2 = false;
    if (paramSharedPreferences == null) {
      return false;
    }
    Object localObject = null;
    String str = paramSharedPreferences.getString(paramString2, null);
    boolean bool1;
    if ((!TextUtils.isEmpty(str)) && (str.equals(paramString3)))
    {
      if (!FileUtils.fileExists(paramString4))
      {
        bool1 = bool2;
        paramSharedPreferences = localObject;
        if (QQAudioHelper.f())
        {
          paramSharedPreferences = new StringBuilder();
          paramSharedPreferences.append(HardCodeUtil.a(2131899512));
          paramSharedPreferences.append(paramString4);
          paramSharedPreferences.append("]");
          paramSharedPreferences = paramSharedPreferences.toString();
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = true;
        paramSharedPreferences = localObject;
      }
    }
    else
    {
      bool1 = bool2;
      paramSharedPreferences = localObject;
      if (QQAudioHelper.f())
      {
        paramSharedPreferences = new StringBuilder();
        paramSharedPreferences.append("md5不一样，sp_md5[");
        paramSharedPreferences.append(str);
        paramSharedPreferences.append("], configMd5[");
        paramSharedPreferences.append(paramString3);
        paramSharedPreferences.append("]");
        paramSharedPreferences = paramSharedPreferences.toString();
        bool1 = bool2;
      }
    }
    if (QQAudioHelper.f())
    {
      paramString3 = new StringBuilder();
      paramString3.append("isResReady, md5Key[");
      paramString3.append(paramString2);
      paramString3.append("], ready[");
      paramString3.append(bool1);
      paramString3.append("], ");
      paramString3.append(paramSharedPreferences);
      QLog.w(paramString1, 1, paramString3.toString());
    }
    return bool1;
  }
  
  public static void notifyQQDownload(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyQQDownload, bussinessType[");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("], bussinessSubName[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], itemIndxe[");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("]");
    QLog.w("BusinessCommonConfig", 1, ((StringBuilder)localObject).toString());
    localObject = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.businessnotify.subprocess.to.qq");
    localIntent.putExtra("event", 1);
    localIntent.putExtra("bussinessType", paramInt1);
    localIntent.putExtra("bussinessSubName", paramString);
    localIntent.putExtra("download_Index", paramInt2);
    ((BaseApplicationImpl)localObject).sendBroadcast(localIntent);
  }
  
  public static void onDownloadRequest(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("bussinessType", 0);
    String str = paramIntent.getStringExtra("bussinessSubName");
    int j = paramIntent.getIntExtra("download_Index", 0);
    paramIntent = new StringBuilder();
    paramIntent.append("onDownloadRequest, bussinessType[");
    paramIntent.append(i);
    paramIntent.append("], bussinessSubName[");
    paramIntent.append(str);
    paramIntent.append("], download_Index[");
    paramIntent.append(j);
    paramIntent.append("]");
    QLog.w("BusinessCommonConfig", 1, paramIntent.toString());
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        ResDownloadControl.a().a(str);
        return;
      }
      PromotionUtil.b(paramQQAppInterface).a(paramQQAppInterface, str);
      return;
    }
    GestureMgr.a();
  }
  
  public static void saveMd5(String paramString1, SharedPreferences paramSharedPreferences, String paramString2, String paramString3)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    boolean bool = paramSharedPreferences.edit().putString(paramString2, paramString3).commit();
    paramSharedPreferences = new StringBuilder();
    paramSharedPreferences.append("saveMd5, ret[");
    paramSharedPreferences.append(bool);
    paramSharedPreferences.append("], spMd5Key[");
    paramSharedPreferences.append(paramString2);
    paramSharedPreferences.append("], md5[");
    paramSharedPreferences.append(paramString3);
    paramSharedPreferences.append("]");
    QLog.w(paramString1, 1, paramSharedPreferences.toString());
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
    paramString = new StringBuilder();
    paramString.append("sendConfigUpdateNotify, bussinessType[");
    paramString.append(paramInt);
    paramString.append("]");
    QLog.w("BusinessCommonConfig", 1, paramString.toString());
  }
  
  public static void sendDownloadResultNotify(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.businessnotify.qq.to.subprocess");
    localIntent.setPackage(((BaseApplicationImpl)localObject).getPackageName());
    localIntent.putExtra("bussinessType", paramInt1);
    localIntent.putExtra("bussinessSubName", paramString);
    localIntent.putExtra("event", 1);
    localIntent.putExtra("download_Index", paramInt2);
    localIntent.putExtra("download_Progress", paramInt3);
    ((BaseApplicationImpl)localObject).sendBroadcast(localIntent);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendDownloadResultNotify, bussinessType[");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("], bussinessSubName[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], index[");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("], process[");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("]");
    QLog.w("BusinessCommonConfig", 1, ((StringBuilder)localObject).toString());
  }
  
  /* Error */
  public <T extends ConfigInfo> Boolean decodeConfig(QQAppInterface paramQQAppInterface, int paramInt, Intent paramIntent, com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload 4
    //   2: astore_3
    //   3: ldc_w 288
    //   6: astore 16
    //   8: aload_0
    //   9: iload_2
    //   10: invokevirtual 292	com/tencent/mobileqq/utils/BusinessCommonConfig:getConfigHandler	(I)Lcom/tencent/mobileqq/utils/confighandler/ConfigHandler;
    //   13: astore 18
    //   15: aload 18
    //   17: ifnonnull +44 -> 61
    //   20: new 47	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   27: astore_1
    //   28: aload_1
    //   29: ldc_w 293
    //   32: invokestatic 140	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   35: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: iload_2
    //   41: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_1
    //   46: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 296	com/tencent/mobileqq/utils/QQAudioHelper:c	(Ljava/lang/String;)V
    //   52: iconst_0
    //   53: invokestatic 302	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   56: areturn
    //   57: astore_1
    //   58: goto +1245 -> 1303
    //   61: aload 18
    //   63: invokevirtual 307	com/tencent/mobileqq/utils/confighandler/ConfigHandler:getTag	()Ljava/lang/String;
    //   66: astore 19
    //   68: aload_3
    //   69: ifnonnull +20 -> 89
    //   72: aload 18
    //   74: invokevirtual 307	com/tencent/mobileqq/utils/confighandler/ConfigHandler:getTag	()Ljava/lang/String;
    //   77: iconst_1
    //   78: ldc_w 309
    //   81: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: iconst_0
    //   85: invokestatic 302	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   88: areturn
    //   89: aload 18
    //   91: invokevirtual 315	com/tencent/mobileqq/utils/confighandler/ConfigHandler:getConfigVer	()I
    //   94: istore 6
    //   96: aload_3
    //   97: getfield 321	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   100: astore 11
    //   102: aload 11
    //   104: ifnull +14 -> 118
    //   107: aload_3
    //   108: getfield 321	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   111: invokevirtual 326	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   114: istore_2
    //   115: goto +5 -> 120
    //   118: iconst_m1
    //   119: istore_2
    //   120: aload_3
    //   121: getfield 330	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   124: invokevirtual 335	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   127: istore 7
    //   129: new 47	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   136: astore_3
    //   137: aload_3
    //   138: ldc_w 337
    //   141: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_3
    //   146: iload 7
    //   148: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_3
    //   153: ldc_w 339
    //   156: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_3
    //   161: iload 6
    //   163: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_3
    //   168: ldc_w 341
    //   171: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_3
    //   176: iload_2
    //   177: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_3
    //   182: ldc 78
    //   184: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 19
    //   190: iconst_1
    //   191: aload_3
    //   192: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 84	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: iload 7
    //   200: iload 6
    //   202: if_icmpne +16 -> 218
    //   205: aload 18
    //   207: aload_1
    //   208: aconst_null
    //   209: aconst_null
    //   210: invokevirtual 345	com/tencent/mobileqq/utils/confighandler/ConfigHandler:onGetConfigFinish	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/utils/confighandler/ConfigInfo;)V
    //   213: iconst_1
    //   214: invokestatic 302	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   217: areturn
    //   218: aload 18
    //   220: invokevirtual 349	com/tencent/mobileqq/utils/confighandler/ConfigHandler:getConfigInfoClass	()Ljava/lang/Class;
    //   223: astore 20
    //   225: iload_2
    //   226: ifgt +185 -> 411
    //   229: iload 7
    //   231: ifeq +180 -> 411
    //   234: aload 18
    //   236: aconst_null
    //   237: iload 7
    //   239: invokevirtual 353	com/tencent/mobileqq/utils/confighandler/ConfigHandler:saveConfig	(Ljava/lang/String;I)V
    //   242: aload 20
    //   244: invokevirtual 358	java/lang/Class:getName	()Ljava/lang/String;
    //   247: astore 11
    //   249: aload 20
    //   251: invokevirtual 362	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   254: checkcast 364	com/tencent/mobileqq/utils/confighandler/ConfigInfo
    //   257: astore_3
    //   258: aload_3
    //   259: aload_1
    //   260: invokevirtual 369	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   263: invokevirtual 372	com/tencent/mobileqq/utils/confighandler/ConfigInfo:setUin	(Ljava/lang/String;)V
    //   266: aload_3
    //   267: iload 7
    //   269: i2l
    //   270: putfield 376	com/tencent/mobileqq/utils/confighandler/ConfigInfo:serverVer	J
    //   273: goto +76 -> 349
    //   276: astore 4
    //   278: goto +18 -> 296
    //   281: astore 4
    //   283: aconst_null
    //   284: astore_3
    //   285: goto +11 -> 296
    //   288: astore 4
    //   290: aconst_null
    //   291: astore 11
    //   293: aload 11
    //   295: astore_3
    //   296: new 47	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   303: astore 12
    //   305: aload 12
    //   307: ldc_w 378
    //   310: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 12
    //   316: aload 11
    //   318: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 12
    //   324: ldc 78
    //   326: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 19
    //   332: iconst_1
    //   333: aload 12
    //   335: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: aload 4
    //   340: invokestatic 381	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   343: invokestatic 383	com/tencent/mobileqq/utils/QQAudioHelper:b	()Z
    //   346: ifne +16 -> 362
    //   349: aload 18
    //   351: aload_1
    //   352: aconst_null
    //   353: aload_3
    //   354: invokevirtual 345	com/tencent/mobileqq/utils/confighandler/ConfigHandler:onGetConfigFinish	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/utils/confighandler/ConfigInfo;)V
    //   357: iconst_1
    //   358: invokestatic 302	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   361: areturn
    //   362: new 47	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   369: astore_1
    //   370: aload_1
    //   371: aload 19
    //   373: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_1
    //   378: ldc_w 378
    //   381: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_1
    //   386: aload 11
    //   388: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload_1
    //   393: ldc 78
    //   395: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: new 385	java/lang/IllegalArgumentException
    //   402: dup
    //   403: aload_1
    //   404: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokespecial 386	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   410: athrow
    //   411: aconst_null
    //   412: astore 13
    //   414: aload 13
    //   416: astore 12
    //   418: aload 12
    //   420: astore 11
    //   422: iconst_0
    //   423: istore 5
    //   425: iload 5
    //   427: iload_2
    //   428: if_icmpge +947 -> 1375
    //   431: aload 4
    //   433: getfield 321	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   436: iload 5
    //   438: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   441: checkcast 391	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   444: astore_3
    //   445: aload_3
    //   446: ifnull +777 -> 1223
    //   449: aload_3
    //   450: getfield 395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   453: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   456: istore 8
    //   458: aload_3
    //   459: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   462: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   465: astore 15
    //   467: aload 15
    //   469: ifnull +692 -> 1161
    //   472: ldc_w 409
    //   475: astore 14
    //   477: aload_3
    //   478: getfield 412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   481: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   484: istore 9
    //   486: iload 9
    //   488: iconst_1
    //   489: if_icmpne +197 -> 686
    //   492: aload 15
    //   494: invokevirtual 418	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   497: invokestatic 423	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   500: astore 15
    //   502: aload 15
    //   504: ifnull +169 -> 673
    //   507: new 119	java/lang/String
    //   510: dup
    //   511: aload 15
    //   513: aload 16
    //   515: invokespecial 426	java/lang/String:<init>	([BLjava/lang/String;)V
    //   518: astore_3
    //   519: goto +181 -> 700
    //   522: astore_3
    //   523: aload_3
    //   524: invokevirtual 429	java/lang/OutOfMemoryError:printStackTrace	()V
    //   527: new 47	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   534: astore 14
    //   536: aload 14
    //   538: ldc_w 430
    //   541: invokestatic 140	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   544: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 14
    //   550: aload_3
    //   551: invokevirtual 433	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   554: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 14
    //   560: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: astore 14
    //   565: invokestatic 438	java/lang/System:gc	()V
    //   568: new 119	java/lang/String
    //   571: dup
    //   572: aload 15
    //   574: aload 16
    //   576: invokespecial 426	java/lang/String:<init>	([BLjava/lang/String;)V
    //   579: astore_3
    //   580: goto +768 -> 1348
    //   583: astore_3
    //   584: new 47	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   591: astore 14
    //   593: aload 14
    //   595: ldc_w 439
    //   598: invokestatic 140	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   601: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload 14
    //   607: aload_3
    //   608: invokevirtual 440	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   611: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload 14
    //   617: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: astore 14
    //   622: aconst_null
    //   623: astore_3
    //   624: goto +724 -> 1348
    //   627: astore_3
    //   628: aload_3
    //   629: invokevirtual 441	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   632: new 47	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   639: astore 14
    //   641: aload 14
    //   643: ldc_w 442
    //   646: invokestatic 140	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   649: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: pop
    //   653: aload 14
    //   655: aload_3
    //   656: invokevirtual 443	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   659: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload 14
    //   665: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: astore 14
    //   670: goto +11 -> 681
    //   673: ldc_w 444
    //   676: invokestatic 140	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   679: astore 14
    //   681: aconst_null
    //   682: astore_3
    //   683: goto +17 -> 700
    //   686: aload 15
    //   688: invokevirtual 447	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   691: astore_3
    //   692: ldc_w 448
    //   695: invokestatic 140	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   698: astore 14
    //   700: aload_3
    //   701: astore 15
    //   703: new 47	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   710: astore_3
    //   711: aload_3
    //   712: ldc_w 450
    //   715: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload_3
    //   720: aload 15
    //   722: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload 19
    //   728: iconst_1
    //   729: aload_3
    //   730: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 453	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   736: aload 15
    //   738: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   741: istore 10
    //   743: iload 10
    //   745: ifne +348 -> 1093
    //   748: aload 13
    //   750: astore_3
    //   751: aload 20
    //   753: invokevirtual 358	java/lang/Class:getName	()Ljava/lang/String;
    //   756: astore 13
    //   758: aload 13
    //   760: astore_3
    //   761: aload 20
    //   763: invokevirtual 362	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   766: checkcast 364	com/tencent/mobileqq/utils/confighandler/ConfigInfo
    //   769: astore 14
    //   771: aload 14
    //   773: aload_1
    //   774: invokevirtual 369	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   777: invokevirtual 372	com/tencent/mobileqq/utils/confighandler/ConfigInfo:setUin	(Ljava/lang/String;)V
    //   780: aload 14
    //   782: iload 7
    //   784: i2l
    //   785: putfield 376	com/tencent/mobileqq/utils/confighandler/ConfigInfo:serverVer	J
    //   788: aload 14
    //   790: aload 19
    //   792: aload 15
    //   794: invokevirtual 457	com/tencent/mobileqq/utils/confighandler/ConfigInfo:tryParse	(Ljava/lang/String;Ljava/lang/String;)Z
    //   797: istore 10
    //   799: aload 14
    //   801: astore_3
    //   802: iload 10
    //   804: ifne +54 -> 858
    //   807: aload 13
    //   809: astore_3
    //   810: new 47	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   817: astore 14
    //   819: aload 13
    //   821: astore_3
    //   822: aload 14
    //   824: aload 19
    //   826: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: pop
    //   830: aload 13
    //   832: astore_3
    //   833: aload 14
    //   835: ldc_w 458
    //   838: invokestatic 140	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   841: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload 13
    //   847: astore_3
    //   848: aload 14
    //   850: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: invokestatic 296	com/tencent/mobileqq/utils/QQAudioHelper:c	(Ljava/lang/String;)V
    //   856: aconst_null
    //   857: astore_3
    //   858: goto +71 -> 929
    //   861: astore 17
    //   863: aload 14
    //   865: astore_3
    //   866: goto +10 -> 876
    //   869: astore 17
    //   871: aload_3
    //   872: astore 13
    //   874: aconst_null
    //   875: astore_3
    //   876: new 47	java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   883: astore 14
    //   885: aload 14
    //   887: ldc_w 460
    //   890: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: pop
    //   894: aload 14
    //   896: aload 13
    //   898: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: pop
    //   902: aload 14
    //   904: ldc 78
    //   906: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: aload 19
    //   912: iconst_1
    //   913: aload 14
    //   915: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   918: aload 17
    //   920: invokestatic 381	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   923: invokestatic 383	com/tencent/mobileqq/utils/QQAudioHelper:b	()Z
    //   926: ifne +118 -> 1044
    //   929: new 47	java/lang/StringBuilder
    //   932: dup
    //   933: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   936: astore 14
    //   938: aload 14
    //   940: ldc_w 462
    //   943: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: aload 14
    //   949: iload 5
    //   951: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: aload 14
    //   957: ldc_w 464
    //   960: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: aload 14
    //   966: iload 8
    //   968: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   971: pop
    //   972: aload 14
    //   974: ldc_w 466
    //   977: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: pop
    //   981: aload 14
    //   983: aload_3
    //   984: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 14
    //   990: ldc_w 468
    //   993: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload 14
    //   999: aload 15
    //   1001: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: pop
    //   1005: aload 14
    //   1007: ldc 78
    //   1009: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: pop
    //   1013: aload 19
    //   1015: iconst_1
    //   1016: aload 14
    //   1018: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1021: invokestatic 84	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1024: aload 13
    //   1026: astore 14
    //   1028: aload_3
    //   1029: ifnull +333 -> 1362
    //   1032: iload 8
    //   1034: aload_3
    //   1035: getfield 471	com/tencent/mobileqq/utils/confighandler/ConfigInfo:taskId	I
    //   1038: if_icmpne +313 -> 1351
    //   1041: goto +232 -> 1273
    //   1044: new 47	java/lang/StringBuilder
    //   1047: dup
    //   1048: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1051: astore_1
    //   1052: aload_1
    //   1053: aload 19
    //   1055: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: pop
    //   1059: aload_1
    //   1060: ldc_w 460
    //   1063: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload_1
    //   1068: aload 13
    //   1070: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: aload_1
    //   1075: ldc 78
    //   1077: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: pop
    //   1081: new 385	java/lang/IllegalArgumentException
    //   1084: dup
    //   1085: aload_1
    //   1086: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1089: invokespecial 386	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1092: athrow
    //   1093: aload 19
    //   1095: iconst_2
    //   1096: ldc_w 473
    //   1099: bipush 6
    //   1101: anewarray 4	java/lang/Object
    //   1104: dup
    //   1105: iconst_0
    //   1106: iload 5
    //   1108: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1111: aastore
    //   1112: dup
    //   1113: iconst_1
    //   1114: iload 8
    //   1116: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1119: aastore
    //   1120: dup
    //   1121: iconst_2
    //   1122: iload 7
    //   1124: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1127: aastore
    //   1128: dup
    //   1129: iconst_3
    //   1130: iload 6
    //   1132: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1135: aastore
    //   1136: dup
    //   1137: iconst_4
    //   1138: iload_2
    //   1139: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1142: aastore
    //   1143: dup
    //   1144: iconst_5
    //   1145: aload 14
    //   1147: aastore
    //   1148: invokestatic 482	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1151: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1154: aload 13
    //   1156: astore 14
    //   1158: goto +204 -> 1362
    //   1161: aload 19
    //   1163: iconst_1
    //   1164: ldc_w 484
    //   1167: iconst_5
    //   1168: anewarray 4	java/lang/Object
    //   1171: dup
    //   1172: iconst_0
    //   1173: iload 5
    //   1175: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1178: aastore
    //   1179: dup
    //   1180: iconst_1
    //   1181: iload 8
    //   1183: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1186: aastore
    //   1187: dup
    //   1188: iconst_2
    //   1189: iload 7
    //   1191: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1194: aastore
    //   1195: dup
    //   1196: iconst_3
    //   1197: iload 6
    //   1199: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1202: aastore
    //   1203: dup
    //   1204: iconst_4
    //   1205: iload_2
    //   1206: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1209: aastore
    //   1210: invokestatic 482	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1213: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1216: aload 13
    //   1218: astore 14
    //   1220: goto +142 -> 1362
    //   1223: aload 19
    //   1225: iconst_1
    //   1226: ldc_w 486
    //   1229: iconst_4
    //   1230: anewarray 4	java/lang/Object
    //   1233: dup
    //   1234: iconst_0
    //   1235: iload 5
    //   1237: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1240: aastore
    //   1241: dup
    //   1242: iconst_1
    //   1243: iload 7
    //   1245: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1248: aastore
    //   1249: dup
    //   1250: iconst_2
    //   1251: iload 6
    //   1253: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1256: aastore
    //   1257: dup
    //   1258: iconst_3
    //   1259: iload_2
    //   1260: invokestatic 478	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1263: aastore
    //   1264: invokestatic 482	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1267: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1270: goto +96 -> 1366
    //   1273: aload 15
    //   1275: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1278: ifne +21 -> 1299
    //   1281: aload 18
    //   1283: aload 15
    //   1285: iload 7
    //   1287: invokevirtual 353	com/tencent/mobileqq/utils/confighandler/ConfigHandler:saveConfig	(Ljava/lang/String;I)V
    //   1290: aload 18
    //   1292: aload_1
    //   1293: aload 15
    //   1295: aload_3
    //   1296: invokevirtual 345	com/tencent/mobileqq/utils/confighandler/ConfigHandler:onGetConfigFinish	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/utils/confighandler/ConfigInfo;)V
    //   1299: goto +22 -> 1321
    //   1302: astore_1
    //   1303: aload_0
    //   1304: getfield 69	com/tencent/mobileqq/utils/BusinessCommonConfig:TAG	Ljava/lang/String;
    //   1307: iconst_1
    //   1308: ldc_w 488
    //   1311: aload_1
    //   1312: invokestatic 381	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1315: invokestatic 383	com/tencent/mobileqq/utils/QQAudioHelper:b	()Z
    //   1318: ifne +8 -> 1326
    //   1321: iconst_1
    //   1322: invokestatic 302	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1325: areturn
    //   1326: new 385	java/lang/IllegalArgumentException
    //   1329: dup
    //   1330: ldc_w 489
    //   1333: invokestatic 140	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1336: invokespecial 386	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1339: astore_1
    //   1340: goto +5 -> 1345
    //   1343: aload_1
    //   1344: athrow
    //   1345: goto -2 -> 1343
    //   1348: goto -648 -> 700
    //   1351: aload 15
    //   1353: astore 11
    //   1355: aload_3
    //   1356: astore 12
    //   1358: aload 13
    //   1360: astore 14
    //   1362: aload 14
    //   1364: astore 13
    //   1366: iload 5
    //   1368: iconst_1
    //   1369: iadd
    //   1370: istore 5
    //   1372: goto -947 -> 425
    //   1375: aload 11
    //   1377: astore 15
    //   1379: aload 12
    //   1381: astore_3
    //   1382: goto -109 -> 1273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1385	0	this	BusinessCommonConfig
    //   0	1385	1	paramQQAppInterface	QQAppInterface
    //   0	1385	2	paramInt	int
    //   0	1385	3	paramIntent	Intent
    //   0	1385	4	paramConfig	com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
    //   423	948	5	i	int
    //   94	1158	6	j	int
    //   127	1159	7	k	int
    //   456	726	8	m	int
    //   484	6	9	n	int
    //   741	62	10	bool	boolean
    //   100	1276	11	localObject1	Object
    //   303	1077	12	localObject2	Object
    //   412	953	13	localObject3	Object
    //   475	888	14	localObject4	Object
    //   465	913	15	localObject5	Object
    //   6	569	16	str1	String
    //   861	1	17	localException1	Exception
    //   869	50	17	localException2	Exception
    //   13	1278	18	localConfigHandler	ConfigHandler
    //   66	1158	19	str2	String
    //   223	539	20	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   20	52	57	java/lang/Exception
    //   72	84	57	java/lang/Exception
    //   107	115	57	java/lang/Exception
    //   205	213	57	java/lang/Exception
    //   234	242	57	java/lang/Exception
    //   296	349	57	java/lang/Exception
    //   349	362	57	java/lang/Exception
    //   362	411	57	java/lang/Exception
    //   492	502	57	java/lang/Exception
    //   507	519	57	java/lang/Exception
    //   523	568	57	java/lang/Exception
    //   568	580	57	java/lang/Exception
    //   584	622	57	java/lang/Exception
    //   628	670	57	java/lang/Exception
    //   673	681	57	java/lang/Exception
    //   258	273	276	java/lang/Exception
    //   249	258	281	java/lang/Exception
    //   242	249	288	java/lang/Exception
    //   507	519	522	java/lang/OutOfMemoryError
    //   568	580	583	java/lang/Throwable
    //   507	519	627	java/io/UnsupportedEncodingException
    //   771	799	861	java/lang/Exception
    //   751	758	869	java/lang/Exception
    //   761	771	869	java/lang/Exception
    //   810	819	869	java/lang/Exception
    //   822	830	869	java/lang/Exception
    //   833	845	869	java/lang/Exception
    //   848	856	869	java/lang/Exception
    //   8	15	1302	java/lang/Exception
    //   61	68	1302	java/lang/Exception
    //   89	102	1302	java/lang/Exception
    //   120	198	1302	java/lang/Exception
    //   218	225	1302	java/lang/Exception
    //   431	445	1302	java/lang/Exception
    //   449	467	1302	java/lang/Exception
    //   477	486	1302	java/lang/Exception
    //   686	700	1302	java/lang/Exception
    //   703	743	1302	java/lang/Exception
    //   876	929	1302	java/lang/Exception
    //   929	1024	1302	java/lang/Exception
    //   1032	1041	1302	java/lang/Exception
    //   1044	1093	1302	java/lang/Exception
    //   1093	1154	1302	java/lang/Exception
    //   1161	1216	1302	java/lang/Exception
    //   1223	1270	1302	java/lang/Exception
    //   1273	1299	1302	java/lang/Exception
  }
  
  public <T extends ConfigInfo> Boolean decodeConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    try
    {
      ConfigHandler localConfigHandler = getConfigHandler(paramInt);
      if (localConfigHandler == null)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(HardCodeUtil.a(2131899484));
        paramQQAppInterface.append(paramInt);
        QQAudioHelper.c(paramQQAppInterface.toString());
        return Boolean.valueOf(false);
      }
      String str1 = localConfigHandler.getTag();
      boolean bool = TextUtils.isEmpty(paramString);
      Object localObject1 = null;
      StringBuilder localStringBuilder = null;
      Object localObject2;
      if (!bool)
      {
        localObject1 = localConfigHandler.getConfigInfoClass();
        String str2 = ((Class)localObject1).getName();
        try
        {
          localObject3 = (ConfigInfo)((Class)localObject1).newInstance();
          ((ConfigInfo)localObject3).setUin(paramQQAppInterface.getAccount());
          ((ConfigInfo)localObject3).serverVer = QAVConfig.c(paramInt);
          localObject1 = localObject3;
          if (!((ConfigInfo)localObject3).tryParse(str1, paramString))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(str1);
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899500));
            QQAudioHelper.c(((StringBuilder)localObject1).toString());
            localObject1 = null;
          }
        }
        catch (Exception localException)
        {
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("new 实例失败2, cls[");
          ((StringBuilder)localObject3).append(str2);
          ((StringBuilder)localObject3).append("]");
          QLog.w(str1, 1, ((StringBuilder)localObject3).toString(), localException);
          if (QQAudioHelper.b()) {
            break label297;
          }
        }
        localObject2 = localStringBuilder;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleResp_Config, downloadInfo[");
        localStringBuilder.append(localObject2);
        localStringBuilder.append("], jsonContent[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w(str1, 1, localStringBuilder.toString());
        break label346;
        label297:
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(str1);
        paramQQAppInterface.append("new 实例失败2, cls[");
        paramQQAppInterface.append(str2);
        paramQQAppInterface.append("]");
        throw new IllegalArgumentException(paramQQAppInterface.toString());
      }
      label346:
      localConfigHandler.onGetConfigFinish(paramQQAppInterface, paramString, localObject2);
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.w(this.TAG, 1, "decodeConfig, Exception", paramQQAppInterface);
      if (QQAudioHelper.b()) {
        break label382;
      }
    }
    return Boolean.valueOf(true);
    label382:
    throw new IllegalArgumentException(HardCodeUtil.a(2131899510));
  }
  
  public void doOnReconnect()
  {
    getConfigHandler(382).doOnReconnect(this.mApp);
  }
  
  public void fillConfigVersion(int paramInt, ConfigurationService.ConfigSeq paramConfigSeq)
  {
    ConfigHandler localConfigHandler = getConfigHandler(paramInt);
    if (localConfigHandler == null) {
      return;
    }
    String str = localConfigHandler.getTag();
    int j = localConfigHandler.getConfigVer();
    int i = j;
    if (QQAudioHelper.b(9) == 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("强制拉取配置, 原localVersion[");
      localStringBuilder.append(j);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      localConfigHandler.saveConfig(null, 0);
      i = 0;
    }
    paramConfigSeq.version.set(i);
    paramConfigSeq.compress.set(1);
    if (QLog.isDevelopLevel())
    {
      paramConfigSeq = new StringBuilder();
      paramConfigSeq.append("fillVersion, configType[");
      paramConfigSeq.append(paramInt);
      paramConfigSeq.append("], localVersion[");
      paramConfigSeq.append(i);
      paramConfigSeq.append("]");
      QLog.w(str, 1, paramConfigSeq.toString());
    }
  }
  
  public ConfigHandler getConfigHandler(int paramInt)
  {
    if (paramInt != 223) {
      if (paramInt != 367) {
        if (paramInt != 382) {
          if (paramInt != 364) {
            if (paramInt != 365) {
              return null;
            }
          }
        }
      }
    }
    StringBuilder localStringBuilder;
    try
    {
      if (this.mARPromotionEntryHandler == null)
      {
        localObject1 = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ARPromotionEntryHandler, mApp[");
        localStringBuilder.append(this.mApp);
        localStringBuilder.append("]");
        QLog.w((String)localObject1, 1, localStringBuilder.toString());
        this.mARPromotionEntryHandler = new ARPromotionConfigHandler.ARPromotionEntryHandler(this.mApp.getAccount());
      }
      localObject1 = this.mARPromotionEntryHandler;
      return localObject1;
    }
    finally {}
    if (this.mARPromotionResHandler == null)
    {
      localObject1 = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ARPromotionResHandler, mApp[");
      localStringBuilder.append(this.mApp);
      localStringBuilder.append("]");
      QLog.w((String)localObject1, 1, localStringBuilder.toString());
      this.mARPromotionResHandler = new ARPromotionConfigHandler.ARPromotionResHandler(this.mApp.getAccount());
    }
    Object localObject1 = this.mARPromotionResHandler;
    return localObject1;
    if (this.mQAVFunCallHandler == null)
    {
      localObject1 = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QAVFunCallHandler, mApp[");
      localStringBuilder.append(this.mApp);
      localStringBuilder.append("]");
      QLog.w((String)localObject1, 1, localStringBuilder.toString());
      this.mQAVFunCallHandler = new QAVFunCallHandler(this.mApp.getAccount());
    }
    localObject1 = this.mQAVFunCallHandler;
    return localObject1;
    if (this.mQAVSoConfigHandler == null) {
      this.mQAVSoConfigHandler = new QAVSoConfigHandler();
    }
    localObject1 = this.mQAVSoConfigHandler;
    return localObject1;
    if (this.mGestureConfigHandler == null) {
      this.mGestureConfigHandler = new GestureConfigHandler();
    }
    localObject1 = this.mGestureConfigHandler;
    return localObject1;
  }
  
  public void handleResp_Config_Fail(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean, ConfigurationService.RespGetConfig paramRespGetConfig)
  {
    paramQQAppInterface = getConfigHandler(paramInt);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getTag();
    }
    else
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("BusinessCommonConfig.");
      paramQQAppInterface.append(paramInt);
      paramQQAppInterface = paramQQAppInterface.toString();
    }
    if (!paramBoolean)
    {
      QLog.d(paramQQAppInterface, 2, "handleResp_Config_Fail");
      return;
    }
    if (paramRespGetConfig.result.get() != 0)
    {
      paramInt = paramRespGetConfig.result.get();
      paramRespGetConfig = new StringBuilder();
      paramRespGetConfig.append("handleResp_Config_Fail, result[");
      paramRespGetConfig.append(paramInt);
      paramRespGetConfig.append("]");
      QLog.d(paramQQAppInterface, 2, paramRespGetConfig.toString());
      return;
    }
    if ((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) {
      QLog.d(paramQQAppInterface, 2, "handleResp_Config_Fail, config_list is null");
    }
  }
  
  public void handleResp_Config_NoResp(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ConfigHandler localConfigHandler = getConfigHandler(paramInt);
    if (QLog.isDevelopLevel())
    {
      Object localObject;
      if (localConfigHandler != null)
      {
        localObject = localConfigHandler.getTag();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BusinessCommonConfig.");
        ((StringBuilder)localObject).append(paramInt);
        localObject = ((StringBuilder)localObject).toString();
      }
      QLog.w((String)localObject, 1, "handleResp_Config_NoResp");
    }
    if (localConfigHandler != null) {
      localConfigHandler.onGetConfigFinish(paramQQAppInterface, null, null);
    }
  }
  
  public void onDestroy()
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, mBroadcastReceiver[");
    localStringBuilder.append(this.mBroadcastReceiver);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
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
    this.mBroadcastReceiver = new BusinessCommonConfig.1(this, paramQQAppInterface);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.businessnotify.subprocess.to.qq");
    return paramQQAppInterface.getApp().registerReceiver(this.mBroadcastReceiver, localIntentFilter) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BusinessCommonConfig
 * JD-Core Version:    0.7.0.1
 */