package com.tencent.mobileqq.utils;

import akby;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class BusinessCommonConfig
  implements Manager
{
  public static String a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  BusinessCommonConfig.GestureConfigHandler jdField_a_of_type_ComTencentMobileqqUtilsBusinessCommonConfig$GestureConfigHandler = null;
  BusinessCommonConfig.WorldCupConfigHandler jdField_a_of_type_ComTencentMobileqqUtilsBusinessCommonConfig$WorldCupConfigHandler = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "BusinessCommonConfig";
  }
  
  public BusinessCommonConfig(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(paramQQAppInterface);
  }
  
  public static BusinessCommonConfig a(QQAppInterface paramQQAppInterface)
  {
    return (BusinessCommonConfig)paramQQAppInterface.getManager(278);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "notifyQQDownload, bussinessType[" + paramInt1 + "], itemIndxe[" + paramInt2 + "]");
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.businessnotify.subprocess.to.qq");
    localIntent.putExtra("event", 1);
    localIntent.putExtra("bussinessType", paramInt1);
    localIntent.putExtra("download_Index", paramInt2);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.businessnotify.qq.to.subprocess");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("bussinessType", paramInt1);
    localIntent.putExtra("event", 1);
    localIntent.putExtra("download_Index", paramInt2);
    localIntent.putExtra("download_Progress", paramInt3);
    localBaseApplicationImpl.sendBroadcast(localIntent);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "sendDownloadResultNotify, bussinessType[" + paramInt1 + "], index[" + paramInt2 + "], process[" + paramInt3 + "]");
  }
  
  public static void a(int paramInt, String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.businessnotify.qq.to.subprocess");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("bussinessType", paramInt);
    localIntent.putExtra("event", 2);
    localIntent.putExtra("config_Content", paramString);
    localBaseApplicationImpl.sendBroadcast(localIntent);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "sendConfigUpdateNotify, bussinessType[" + paramInt + "]");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("bussinessType", 0);
    int j = paramIntent.getIntExtra("download_Index", 0);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onDownloadRequest, bussinessType[" + i + "], download_Index[" + j + "]");
    switch (i)
    {
    default: 
      return;
    case 2: 
      WorldCup.a(paramQQAppInterface, j);
      return;
    }
    GestureMgr.a();
  }
  
  public static void a(String paramString1, SharedPreferences paramSharedPreferences, String paramString2, String paramString3)
  {
    boolean bool = paramSharedPreferences.edit().putString(paramString2, paramString3).commit();
    QLog.w(paramString1, 1, "saveMd5, ret[" + bool + "], spMd5Key[" + paramString2 + "], md5[" + paramString3 + "]");
  }
  
  public static boolean a(String paramString1, SharedPreferences paramSharedPreferences, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = null;
    boolean bool2 = false;
    String str = paramSharedPreferences.getString(paramString2, null);
    boolean bool1;
    if ((TextUtils.isEmpty(str)) || (!str.equals(paramString3)))
    {
      paramSharedPreferences = localObject;
      bool1 = bool2;
      if (AudioHelper.e())
      {
        paramSharedPreferences = "md5不一样，sp_md5[" + str + "], configMd5[" + paramString3 + "]";
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (AudioHelper.e()) {
        QLog.w(paramString1, 1, "isResReady, md5Key[" + paramString2 + "], ready[" + bool1 + "], " + paramSharedPreferences);
      }
      return bool1;
      if (!FileUtils.a(paramString4))
      {
        paramSharedPreferences = localObject;
        bool1 = bool2;
        if (AudioHelper.e())
        {
          paramSharedPreferences = "文件不存在， localPath[" + paramString4 + "]";
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
  
  BusinessCommonConfig.ConfigHandler a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (Object localObject1 = null;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsBusinessCommonConfig$GestureConfigHandler)
    {
      for (;;)
      {
        return localObject1;
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsBusinessCommonConfig$WorldCupConfigHandler == null) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsBusinessCommonConfig$WorldCupConfigHandler = new BusinessCommonConfig.WorldCupConfigHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsBusinessCommonConfig$WorldCupConfigHandler;
        }
        finally {}
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsBusinessCommonConfig$GestureConfigHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsBusinessCommonConfig$GestureConfigHandler = new BusinessCommonConfig.GestureConfigHandler();
      }
    }
  }
  
  /* Error */
  public java.lang.Boolean a(QQAppInterface paramQQAppInterface, int paramInt, Intent paramIntent, com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_2
    //   2: invokevirtual 225	com/tencent/mobileqq/utils/BusinessCommonConfig:a	(I)Lcom/tencent/mobileqq/utils/BusinessCommonConfig$ConfigHandler;
    //   5: astore 14
    //   7: aload 14
    //   9: ifnonnull +30 -> 39
    //   12: new 44	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   19: ldc 227
    //   21: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 230	com/tencent/mobileqq/utils/AudioHelper:c	(Ljava/lang/String;)V
    //   34: iconst_0
    //   35: invokestatic 236	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: areturn
    //   39: aload 14
    //   41: invokevirtual 240	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigHandler:a	()Ljava/lang/String;
    //   44: astore 15
    //   46: aload 4
    //   48: ifnonnull +19 -> 67
    //   51: aload 14
    //   53: invokevirtual 240	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigHandler:a	()Ljava/lang/String;
    //   56: iconst_1
    //   57: ldc 242
    //   59: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: iconst_0
    //   63: invokestatic 236	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: areturn
    //   67: aload 14
    //   69: invokevirtual 248	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigHandler:a	()I
    //   72: istore 6
    //   74: aload 4
    //   76: getfield 254	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   79: ifnull +101 -> 180
    //   82: aload 4
    //   84: getfield 254	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   87: invokevirtual 259	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   90: istore_2
    //   91: aload 4
    //   93: getfield 263	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   96: invokevirtual 268	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   99: istore 7
    //   101: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +56 -> 160
    //   107: aload 15
    //   109: iconst_1
    //   110: new 44	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 273
    //   120: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload 7
    //   125: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: ldc_w 275
    //   131: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: iload 6
    //   136: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: ldc_w 277
    //   142: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: iload_2
    //   146: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: ldc 58
    //   151: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 68	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: iload 7
    //   162: iload 6
    //   164: if_icmpne +21 -> 185
    //   167: aload 14
    //   169: aload_1
    //   170: aconst_null
    //   171: aconst_null
    //   172: invokevirtual 280	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/utils/BusinessCommonConfig$ConfigInfo;)V
    //   175: iconst_1
    //   176: invokestatic 236	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   179: areturn
    //   180: iconst_m1
    //   181: istore_2
    //   182: goto -91 -> 91
    //   185: aload 14
    //   187: invokevirtual 283	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigHandler:a	()Ljava/lang/Class;
    //   190: astore 16
    //   192: iload_2
    //   193: ifgt +114 -> 307
    //   196: iload 7
    //   198: ifeq +109 -> 307
    //   201: aload 14
    //   203: aconst_null
    //   204: iload 7
    //   206: invokevirtual 286	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigHandler:a	(Ljava/lang/String;I)V
    //   209: aload 16
    //   211: invokevirtual 292	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   214: checkcast 294	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigInfo
    //   217: astore_3
    //   218: aload_3
    //   219: aload_1
    //   220: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   223: invokevirtual 296	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigInfo:a	(Ljava/lang/String;)V
    //   226: aload 14
    //   228: aload_1
    //   229: aconst_null
    //   230: aload_3
    //   231: invokevirtual 280	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/utils/BusinessCommonConfig$ConfigInfo;)V
    //   234: iconst_1
    //   235: invokestatic 236	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   238: areturn
    //   239: astore 4
    //   241: aconst_null
    //   242: astore_3
    //   243: aload 15
    //   245: iconst_1
    //   246: new 44	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   253: ldc_w 298
    //   256: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload 16
    //   261: invokevirtual 301	java/lang/Class:getName	()Ljava/lang/String;
    //   264: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 58
    //   269: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: aload 4
    //   277: invokestatic 304	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: new 44	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   287: aload 15
    //   289: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc_w 306
    //   295: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 230	com/tencent/mobileqq/utils/AudioHelper:c	(Ljava/lang/String;)V
    //   304: goto -78 -> 226
    //   307: aconst_null
    //   308: astore 10
    //   310: aconst_null
    //   311: astore 11
    //   313: iconst_0
    //   314: istore 5
    //   316: iload 5
    //   318: iload_2
    //   319: if_icmpge +782 -> 1101
    //   322: aload 4
    //   324: getfield 254	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   327: iload 5
    //   329: invokevirtual 309	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   332: checkcast 311	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   335: astore_3
    //   336: aload_3
    //   337: ifnull +682 -> 1019
    //   340: aload_3
    //   341: getfield 315	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   344: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   347: istore 8
    //   349: aload_3
    //   350: getfield 322	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   353: invokevirtual 327	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   356: astore 12
    //   358: aload 12
    //   360: ifnull +593 -> 953
    //   363: ldc_w 329
    //   366: astore 9
    //   368: aload_3
    //   369: getfield 332	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   372: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   375: iconst_1
    //   376: if_icmpne +379 -> 755
    //   379: aload 12
    //   381: invokevirtual 338	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   384: invokestatic 343	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   387: astore 12
    //   389: aload 12
    //   391: ifnull +354 -> 745
    //   394: new 178	java/lang/String
    //   397: dup
    //   398: aload 12
    //   400: ldc_w 345
    //   403: invokespecial 348	java/lang/String:<init>	([BLjava/lang/String;)V
    //   406: astore_3
    //   407: aload 9
    //   409: astore 12
    //   411: aload_3
    //   412: astore 9
    //   414: aload 12
    //   416: astore_3
    //   417: aload 9
    //   419: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   422: ifne +446 -> 868
    //   425: aload 16
    //   427: invokevirtual 292	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   430: checkcast 294	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigInfo
    //   433: astore 13
    //   435: aload 13
    //   437: astore 12
    //   439: aload 13
    //   441: aload_1
    //   442: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   445: invokevirtual 296	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigInfo:a	(Ljava/lang/String;)V
    //   448: aload 13
    //   450: astore_3
    //   451: aload 13
    //   453: astore 12
    //   455: aload 13
    //   457: aload 15
    //   459: aload 9
    //   461: invokevirtual 351	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigInfo:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   464: ifne +32 -> 496
    //   467: aconst_null
    //   468: astore 12
    //   470: aconst_null
    //   471: astore_3
    //   472: new 44	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   479: aload 15
    //   481: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: ldc_w 353
    //   487: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 230	com/tencent/mobileqq/utils/AudioHelper:c	(Ljava/lang/String;)V
    //   496: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   499: ifeq +67 -> 566
    //   502: aload 15
    //   504: iconst_1
    //   505: new 44	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   512: ldc_w 355
    //   515: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: iload 5
    //   520: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: ldc_w 357
    //   526: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: iload 8
    //   531: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   534: ldc_w 359
    //   537: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_3
    //   541: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   544: ldc_w 364
    //   547: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 9
    //   552: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: ldc 58
    //   557: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 68	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload_3
    //   567: ifnull +270 -> 837
    //   570: iload 8
    //   572: aload_3
    //   573: getfield 368	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigInfo:b	I
    //   576: if_icmpne +535 -> 1111
    //   579: aload 9
    //   581: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   584: ifne +21 -> 605
    //   587: aload 14
    //   589: aload 9
    //   591: iload 7
    //   593: invokevirtual 286	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigHandler:a	(Ljava/lang/String;I)V
    //   596: aload 14
    //   598: aload_1
    //   599: aload 9
    //   601: aload_3
    //   602: invokevirtual 280	com/tencent/mobileqq/utils/BusinessCommonConfig$ConfigHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/utils/BusinessCommonConfig$ConfigInfo;)V
    //   605: iconst_1
    //   606: invokestatic 236	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   609: areturn
    //   610: astore_3
    //   611: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   614: ifeq +480 -> 1094
    //   617: aload_3
    //   618: invokevirtual 371	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   621: new 44	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 373
    //   631: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload_3
    //   635: invokevirtual 376	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   638: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: astore_3
    //   645: aconst_null
    //   646: astore 12
    //   648: aload_3
    //   649: astore 9
    //   651: aload 12
    //   653: astore_3
    //   654: goto -247 -> 407
    //   657: astore_3
    //   658: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   661: ifeq +32 -> 693
    //   664: aload_3
    //   665: invokevirtual 377	java/lang/OutOfMemoryError:printStackTrace	()V
    //   668: new 44	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   675: ldc_w 379
    //   678: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_3
    //   682: invokevirtual 380	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   685: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: astore 9
    //   693: invokestatic 385	java/lang/System:gc	()V
    //   696: new 178	java/lang/String
    //   699: dup
    //   700: aload 12
    //   702: ldc_w 345
    //   705: invokespecial 348	java/lang/String:<init>	([BLjava/lang/String;)V
    //   708: astore_3
    //   709: goto -302 -> 407
    //   712: astore 9
    //   714: aconst_null
    //   715: astore_3
    //   716: new 44	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   723: ldc_w 387
    //   726: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload 9
    //   731: invokevirtual 388	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   734: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: astore 9
    //   742: goto -335 -> 407
    //   745: ldc_w 390
    //   748: astore 9
    //   750: aconst_null
    //   751: astore_3
    //   752: goto -345 -> 407
    //   755: aload 12
    //   757: invokevirtual 393	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   760: astore 9
    //   762: ldc_w 395
    //   765: astore_3
    //   766: goto -349 -> 417
    //   769: astore 12
    //   771: aconst_null
    //   772: astore_3
    //   773: aload 15
    //   775: iconst_1
    //   776: new 44	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   783: ldc_w 397
    //   786: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: aload 16
    //   791: invokevirtual 301	java/lang/Class:getName	()Ljava/lang/String;
    //   794: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: ldc 58
    //   799: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: aload 12
    //   807: invokestatic 304	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   810: new 44	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   817: aload 15
    //   819: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: ldc_w 399
    //   825: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokestatic 230	com/tencent/mobileqq/utils/AudioHelper:c	(Ljava/lang/String;)V
    //   834: goto -338 -> 496
    //   837: aload 11
    //   839: astore 9
    //   841: aload 10
    //   843: astore_3
    //   844: aload 9
    //   846: astore 12
    //   848: aload_3
    //   849: astore 9
    //   851: iload 5
    //   853: iconst_1
    //   854: iadd
    //   855: istore 5
    //   857: aload 12
    //   859: astore 11
    //   861: aload 9
    //   863: astore 10
    //   865: goto -549 -> 316
    //   868: aload 11
    //   870: astore 12
    //   872: aload 10
    //   874: astore 9
    //   876: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   879: ifeq -28 -> 851
    //   882: aload 15
    //   884: iconst_2
    //   885: ldc_w 401
    //   888: bipush 6
    //   890: anewarray 4	java/lang/Object
    //   893: dup
    //   894: iconst_0
    //   895: iload 5
    //   897: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   900: aastore
    //   901: dup
    //   902: iconst_1
    //   903: iload 8
    //   905: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   908: aastore
    //   909: dup
    //   910: iconst_2
    //   911: iload 7
    //   913: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   916: aastore
    //   917: dup
    //   918: iconst_3
    //   919: iload 6
    //   921: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   924: aastore
    //   925: dup
    //   926: iconst_4
    //   927: iload_2
    //   928: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   931: aastore
    //   932: dup
    //   933: iconst_5
    //   934: aload_3
    //   935: aastore
    //   936: invokestatic 410	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   939: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   942: aload 11
    //   944: astore 12
    //   946: aload 10
    //   948: astore 9
    //   950: goto -99 -> 851
    //   953: aload 15
    //   955: iconst_1
    //   956: ldc_w 412
    //   959: iconst_5
    //   960: anewarray 4	java/lang/Object
    //   963: dup
    //   964: iconst_0
    //   965: iload 5
    //   967: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   970: aastore
    //   971: dup
    //   972: iconst_1
    //   973: iload 8
    //   975: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   978: aastore
    //   979: dup
    //   980: iconst_2
    //   981: iload 7
    //   983: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   986: aastore
    //   987: dup
    //   988: iconst_3
    //   989: iload 6
    //   991: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   994: aastore
    //   995: dup
    //   996: iconst_4
    //   997: iload_2
    //   998: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1001: aastore
    //   1002: invokestatic 410	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1005: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1008: aload 11
    //   1010: astore 12
    //   1012: aload 10
    //   1014: astore 9
    //   1016: goto -165 -> 851
    //   1019: aload 15
    //   1021: iconst_1
    //   1022: ldc_w 414
    //   1025: iconst_4
    //   1026: anewarray 4	java/lang/Object
    //   1029: dup
    //   1030: iconst_0
    //   1031: iload 5
    //   1033: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1036: aastore
    //   1037: dup
    //   1038: iconst_1
    //   1039: iload 7
    //   1041: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1044: aastore
    //   1045: dup
    //   1046: iconst_2
    //   1047: iload 6
    //   1049: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1052: aastore
    //   1053: dup
    //   1054: iconst_3
    //   1055: iload_2
    //   1056: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1059: aastore
    //   1060: invokestatic 410	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1063: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1066: aload 11
    //   1068: astore 12
    //   1070: aload 10
    //   1072: astore 9
    //   1074: goto -223 -> 851
    //   1077: astore 13
    //   1079: aload 12
    //   1081: astore_3
    //   1082: aload 13
    //   1084: astore 12
    //   1086: goto -313 -> 773
    //   1089: astore 4
    //   1091: goto -848 -> 243
    //   1094: ldc_w 329
    //   1097: astore_3
    //   1098: goto -453 -> 645
    //   1101: aload 10
    //   1103: astore_3
    //   1104: aload 11
    //   1106: astore 9
    //   1108: goto -529 -> 579
    //   1111: goto -267 -> 844
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1114	0	this	BusinessCommonConfig
    //   0	1114	1	paramQQAppInterface	QQAppInterface
    //   0	1114	2	paramInt	int
    //   0	1114	3	paramIntent	Intent
    //   0	1114	4	paramConfig	com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
    //   314	718	5	i	int
    //   72	976	6	j	int
    //   99	941	7	k	int
    //   347	627	8	m	int
    //   366	326	9	localObject1	Object
    //   712	18	9	localThrowable	java.lang.Throwable
    //   740	367	9	localObject2	Object
    //   308	794	10	localObject3	Object
    //   311	794	11	localObject4	Object
    //   356	400	12	localObject5	Object
    //   769	37	12	localException1	java.lang.Exception
    //   846	239	12	localObject6	Object
    //   433	23	13	localConfigInfo	BusinessCommonConfig.ConfigInfo
    //   1077	6	13	localException2	java.lang.Exception
    //   5	592	14	localConfigHandler	BusinessCommonConfig.ConfigHandler
    //   44	976	15	str	String
    //   190	600	16	localClass	java.lang.Class
    // Exception table:
    //   from	to	target	type
    //   209	218	239	java/lang/Exception
    //   394	407	610	java/io/UnsupportedEncodingException
    //   394	407	657	java/lang/OutOfMemoryError
    //   696	709	712	java/lang/Throwable
    //   425	435	769	java/lang/Exception
    //   439	448	1077	java/lang/Exception
    //   455	467	1077	java/lang/Exception
    //   472	496	1077	java/lang/Exception
    //   218	226	1089	java/lang/Exception
  }
  
  public void a(int paramInt, ConfigurationService.ConfigSeq paramConfigSeq)
  {
    int i = 0;
    BusinessCommonConfig.ConfigHandler localConfigHandler = a(paramInt);
    if (localConfigHandler == null) {
      return;
    }
    String str = localConfigHandler.a();
    paramInt = localConfigHandler.a();
    if (AudioHelper.a(9) == 1)
    {
      QLog.w(str, 1, "强制拉取配置, 原localVersion[" + paramInt + "]");
      localConfigHandler.a(null, 0);
      paramInt = i;
    }
    for (;;)
    {
      paramConfigSeq.version.set(paramInt);
      paramConfigSeq.compress.set(1);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w(str, 1, "fillVersion, localVersion[" + paramInt + "]");
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    BusinessCommonConfig.ConfigHandler localConfigHandler = a(paramInt);
    if (QLog.isDevelopLevel()) {
      if (localConfigHandler == null) {
        break label46;
      }
    }
    label46:
    for (String str = localConfigHandler.a();; str = jdField_a_of_type_JavaLangString + "." + paramInt)
    {
      QLog.w(str, 1, "handleResp_Config_NoResp");
      if (localConfigHandler != null) {
        localConfigHandler.a(paramQQAppInterface, null, null);
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean, ConfigurationService.RespGetConfig paramRespGetConfig)
  {
    paramQQAppInterface = a(paramInt);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramBoolean) {
        break label64;
      }
      if (QLog.isColorLevel()) {
        QLog.d(paramQQAppInterface, 2, "handleResp_Config_Fail");
      }
    }
    label64:
    label121:
    do
    {
      do
      {
        return;
        paramQQAppInterface = jdField_a_of_type_JavaLangString + "." + paramInt;
        break;
        if (paramRespGetConfig.result.get() == 0) {
          break label121;
        }
        paramInt = paramRespGetConfig.result.get();
      } while (!AudioHelper.e());
      QLog.d(paramQQAppInterface, 2, "handleResp_Config_Fail, result[" + paramInt + "]");
      return;
    } while (((paramRespGetConfig.config_list != null) && (paramRespGetConfig.config_list.size() != 0)) || (!AudioHelper.e()));
    QLog.d(paramQQAppInterface, 2, "handleResp_Config_Fail, config_list is null");
  }
  
  boolean a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new akby(this, paramQQAppInterface);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.businessnotify.subprocess.to.qq");
    return paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter) != null;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsBusinessCommonConfig$WorldCupConfigHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsBusinessCommonConfig$GestureConfigHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BusinessCommonConfig
 * JD-Core Version:    0.7.0.1
 */