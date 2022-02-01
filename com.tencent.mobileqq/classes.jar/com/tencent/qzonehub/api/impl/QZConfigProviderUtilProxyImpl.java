package com.tencent.qzonehub.api.impl;

import NS_UNDEAL_COUNT.entrance_cfg;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZConfigProviderUtilProxy;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class QZConfigProviderUtilProxyImpl
  implements IQZConfigProviderUtilProxy
{
  private static final String TAG = "QZConfigProviderUtil";
  private static final Set<String> miniAppHighPrioritySecondaryKeys = new HashSet();
  private static final Set<String> qqcircleHighPrioritySecondaryKeys;
  
  static
  {
    miniAppHighPrioritySecondaryKeys.add("miniappshowreddot".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("miniappshowmessagereddot".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("miniappfullscreenshownotificationbtn".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("miniappfullscreenshownotificationreddot".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("miniapptriggerfullscreenheight".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("miniappgetpskeydomain".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("miniappsustempermissionconfig".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("MiniAppMsfTimeoutValue".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("miniappsendrequestbyhttps".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("newsdkenable".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("MiniAppEcShopNumMsgEnable".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("newappsdkenable".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("mini_sdk_prelaunch_enable".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("sdk_dex_config".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("mini_sdk_prelaunch_all_enable".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("mini_sdk_prelaunch_all_delay_time".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("pulldownRefreshMinDistance".toLowerCase());
    miniAppHighPrioritySecondaryKeys.add("ark_scene_white_list".toLowerCase());
    qqcircleHighPrioritySecondaryKeys = new HashSet();
    qqcircleHighPrioritySecondaryKeys.add("qqcircle_enable_eevee_polling");
    qqcircleHighPrioritySecondaryKeys.add("qqcircle_use_eevee_red_point");
  }
  
  private static void deleteConfig()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.b, null, null);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteConfig error");
        localStringBuilder.append(localException.getMessage());
        QLog.e("QZConfigProviderUtil", 2, localStringBuilder.toString(), localException);
      }
    }
  }
  
  private static void deleteCookie()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.c, null, null);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteCookie error ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("QZConfigProviderUtil", 2, localStringBuilder.toString(), localException);
      }
    }
  }
  
  private static void deleteIspCheckTime()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.g, null, null);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteIspCheckTime error");
        localStringBuilder.append(localException.getMessage());
        QLog.e("QZConfigProviderUtil", 2, localStringBuilder.toString(), localException);
      }
    }
  }
  
  private static void deleteIspConfig()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.f, null, null);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteIspConfig error ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("QZConfigProviderUtil", 2, localStringBuilder.toString(), localException);
      }
    }
  }
  
  private static int deleteOneIspConfig(String paramString)
  {
    if (paramString != null)
    {
      if (TextUtils.getTrimmedLength(paramString) <= 0) {
        return 0;
      }
      try
      {
        int i = BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.f, "key=?", new String[] { paramString });
        return i;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("deleteOneIspConfig error:");
          localStringBuilder.append(paramString.getMessage());
          QLog.e("QZConfigProviderUtil", 2, localStringBuilder.toString());
        }
      }
    }
    return 0;
  }
  
  private static int deleteOneMainConfig(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (TextUtils.getTrimmedLength(paramString1) <= 0) {
        return 0;
      }
      if (paramString2 != null)
      {
        if (TextUtils.getTrimmedLength(paramString2) <= 0) {
          return 0;
        }
        try
        {
          int i = BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.b, "main_key=? and second_key=? ", new String[] { paramString1, paramString2 });
          return i;
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QZConfigProviderUtil", 2, paramString1, new Object[] { "deleteOneConfig error:" });
          }
        }
      }
    }
    return 0;
  }
  
  /* Error */
  private static String getOneIspConfig(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_0
    //   9: ifnull +202 -> 211
    //   12: aload_0
    //   13: invokestatic 155	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   16: ifgt +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   24: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   27: getstatic 145	com/tencent/common/config/provider/QZoneConfigProvider:f	Landroid/net/Uri;
    //   30: aconst_null
    //   31: ldc 157
    //   33: iconst_1
    //   34: anewarray 27	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_0
    //   40: aastore
    //   41: aconst_null
    //   42: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_1
    //   46: aload_2
    //   47: astore_0
    //   48: aload_1
    //   49: ifnull +54 -> 103
    //   52: aload_2
    //   53: astore_0
    //   54: aload_1
    //   55: astore_2
    //   56: aload_1
    //   57: invokeinterface 182 1 0
    //   62: ifeq +41 -> 103
    //   65: aload_1
    //   66: astore_2
    //   67: new 27	java/lang/String
    //   70: dup
    //   71: aload_1
    //   72: aload_1
    //   73: ldc 184
    //   75: invokeinterface 187 2 0
    //   80: invokeinterface 191 2 0
    //   85: invokevirtual 195	java/lang/String:getBytes	()[B
    //   88: ldc 197
    //   90: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   93: astore_0
    //   94: goto +9 -> 103
    //   97: astore_3
    //   98: aload_1
    //   99: astore_0
    //   100: goto +30 -> 130
    //   103: aload_0
    //   104: astore_2
    //   105: aload_1
    //   106: ifnull +90 -> 196
    //   109: aload_1
    //   110: astore_2
    //   111: aload_0
    //   112: astore_1
    //   113: aload_2
    //   114: invokeinterface 203 1 0
    //   119: aload_1
    //   120: areturn
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_2
    //   124: goto +75 -> 199
    //   127: astore_3
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: astore_2
    //   132: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +46 -> 181
    //   138: aload_0
    //   139: astore_2
    //   140: new 112	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   147: astore_1
    //   148: aload_0
    //   149: astore_2
    //   150: aload_1
    //   151: ldc 205
    //   153: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_0
    //   158: astore_2
    //   159: aload_1
    //   160: aload_3
    //   161: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   164: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_0
    //   169: astore_2
    //   170: ldc 10
    //   172: iconst_2
    //   173: aload_1
    //   174: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: aload_3
    //   178: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload 5
    //   183: astore_2
    //   184: aload_0
    //   185: ifnull +11 -> 196
    //   188: aload 4
    //   190: astore_1
    //   191: aload_0
    //   192: astore_2
    //   193: goto -80 -> 113
    //   196: aload_2
    //   197: areturn
    //   198: astore_0
    //   199: aload_2
    //   200: ifnull +9 -> 209
    //   203: aload_2
    //   204: invokeinterface 203 1 0
    //   209: aload_0
    //   210: athrow
    //   211: aconst_null
    //   212: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramString	String
    //   45	146	1	localObject1	Object
    //   7	197	2	localObject2	Object
    //   97	1	3	localException1	Exception
    //   127	51	3	localException2	Exception
    //   1	188	4	localObject3	Object
    //   4	178	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   56	65	97	java/lang/Exception
    //   67	94	97	java/lang/Exception
    //   21	46	121	finally
    //   21	46	127	java/lang/Exception
    //   56	65	198	finally
    //   67	94	198	finally
    //   132	138	198	finally
    //   140	148	198	finally
    //   150	157	198	finally
    //   159	168	198	finally
    //   170	181	198	finally
  }
  
  /* Error */
  private static entrance_cfg getOneNavigatorConfig(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_0
    //   9: ifnull +451 -> 460
    //   12: aload_0
    //   13: invokestatic 155	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   16: ifgt +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: iload_1
    //   22: iflt +438 -> 460
    //   25: iload_1
    //   26: sipush 999
    //   29: if_icmple +5 -> 34
    //   32: aconst_null
    //   33: areturn
    //   34: aload_0
    //   35: ldc 209
    //   37: ldc 211
    //   39: invokevirtual 215	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   42: astore_0
    //   43: new 112	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   50: astore_3
    //   51: aload_3
    //   52: aload_0
    //   53: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: ldc 217
    //   60: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_3
    //   65: iload_1
    //   66: invokestatic 220	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   69: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_3
    //   74: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore_0
    //   78: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   81: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   84: getstatic 223	com/tencent/common/config/provider/QZoneConfigProvider:h	Landroid/net/Uri;
    //   87: aconst_null
    //   88: ldc 225
    //   90: iconst_1
    //   91: anewarray 27	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: aload_0
    //   97: aastore
    //   98: aconst_null
    //   99: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   102: astore_3
    //   103: aload_2
    //   104: astore_0
    //   105: aload_3
    //   106: ifnull +225 -> 331
    //   109: aload_2
    //   110: astore_0
    //   111: aload_3
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface 182 1 0
    //   119: ifeq +212 -> 331
    //   122: aload_3
    //   123: astore_2
    //   124: new 227	NS_UNDEAL_COUNT/entrance_cfg
    //   127: dup
    //   128: aload_3
    //   129: aload_3
    //   130: ldc 229
    //   132: invokeinterface 187 2 0
    //   137: invokeinterface 233 2 0
    //   142: new 27	java/lang/String
    //   145: dup
    //   146: aload_3
    //   147: aload_3
    //   148: ldc 235
    //   150: invokeinterface 187 2 0
    //   155: invokeinterface 191 2 0
    //   160: invokevirtual 195	java/lang/String:getBytes	()[B
    //   163: ldc 197
    //   165: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   168: new 27	java/lang/String
    //   171: dup
    //   172: aload_3
    //   173: aload_3
    //   174: ldc 237
    //   176: invokeinterface 187 2 0
    //   181: invokeinterface 191 2 0
    //   186: invokevirtual 195	java/lang/String:getBytes	()[B
    //   189: ldc 197
    //   191: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   194: new 27	java/lang/String
    //   197: dup
    //   198: aload_3
    //   199: aload_3
    //   200: ldc 239
    //   202: invokeinterface 187 2 0
    //   207: invokeinterface 191 2 0
    //   212: invokevirtual 195	java/lang/String:getBytes	()[B
    //   215: ldc 197
    //   217: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   220: aload_3
    //   221: aload_3
    //   222: ldc 241
    //   224: invokeinterface 187 2 0
    //   229: invokeinterface 233 2 0
    //   234: aload_3
    //   235: aload_3
    //   236: ldc 243
    //   238: invokeinterface 187 2 0
    //   243: invokeinterface 233 2 0
    //   248: new 27	java/lang/String
    //   251: dup
    //   252: aload_3
    //   253: aload_3
    //   254: ldc 245
    //   256: invokeinterface 187 2 0
    //   261: invokeinterface 191 2 0
    //   266: invokevirtual 195	java/lang/String:getBytes	()[B
    //   269: ldc 197
    //   271: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   274: new 27	java/lang/String
    //   277: dup
    //   278: aload_3
    //   279: aload_3
    //   280: ldc 247
    //   282: invokeinterface 187 2 0
    //   287: invokeinterface 191 2 0
    //   292: invokevirtual 195	java/lang/String:getBytes	()[B
    //   295: ldc 197
    //   297: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   300: iconst_0
    //   301: aconst_null
    //   302: aload_3
    //   303: aload_3
    //   304: ldc 249
    //   306: invokeinterface 187 2 0
    //   311: invokeinterface 233 2 0
    //   316: invokespecial 252	NS_UNDEAL_COUNT/entrance_cfg:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ILNS_UNDEAL_COUNT/st_report_info;I)V
    //   319: astore_0
    //   320: goto +11 -> 331
    //   323: astore_2
    //   324: aload_3
    //   325: astore_0
    //   326: aload_2
    //   327: astore_3
    //   328: goto +35 -> 363
    //   331: aload_0
    //   332: astore_2
    //   333: aload_3
    //   334: ifnull +103 -> 437
    //   337: aload_0
    //   338: astore_2
    //   339: aload_3
    //   340: invokeinterface 203 1 0
    //   345: aload_0
    //   346: areturn
    //   347: astore_0
    //   348: aload_0
    //   349: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   352: aload_2
    //   353: areturn
    //   354: astore_0
    //   355: aconst_null
    //   356: astore_2
    //   357: goto +83 -> 440
    //   360: astore_3
    //   361: aconst_null
    //   362: astore_0
    //   363: aload_0
    //   364: astore_2
    //   365: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq +50 -> 418
    //   371: aload_0
    //   372: astore_2
    //   373: new 112	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   380: astore 6
    //   382: aload_0
    //   383: astore_2
    //   384: aload 6
    //   386: ldc_w 257
    //   389: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_0
    //   394: astore_2
    //   395: aload 6
    //   397: aload_3
    //   398: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   401: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_0
    //   406: astore_2
    //   407: ldc 10
    //   409: iconst_2
    //   410: aload 6
    //   412: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: aload 4
    //   420: astore_2
    //   421: aload_0
    //   422: ifnull +15 -> 437
    //   425: aload 5
    //   427: astore_2
    //   428: aload_0
    //   429: invokeinterface 203 1 0
    //   434: aload 4
    //   436: astore_2
    //   437: aload_2
    //   438: areturn
    //   439: astore_0
    //   440: aload_2
    //   441: ifnull +17 -> 458
    //   444: aload_2
    //   445: invokeinterface 203 1 0
    //   450: goto +8 -> 458
    //   453: astore_2
    //   454: aload_2
    //   455: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   458: aload_0
    //   459: athrow
    //   460: aconst_null
    //   461: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	paramString	String
    //   0	462	1	paramInt	int
    //   7	117	2	localObject1	Object
    //   323	4	2	localException1	Exception
    //   332	113	2	localObject2	Object
    //   453	2	2	localException2	Exception
    //   50	290	3	localObject3	Object
    //   360	38	3	localException3	Exception
    //   4	431	4	localObject4	Object
    //   1	425	5	localObject5	Object
    //   380	31	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   113	122	323	java/lang/Exception
    //   124	320	323	java/lang/Exception
    //   339	345	347	java/lang/Exception
    //   428	434	347	java/lang/Exception
    //   78	103	354	finally
    //   78	103	360	java/lang/Exception
    //   113	122	439	finally
    //   124	320	439	finally
    //   365	371	439	finally
    //   373	382	439	finally
    //   384	393	439	finally
    //   395	405	439	finally
    //   407	418	439	finally
    //   444	450	453	java/lang/Exception
  }
  
  private static boolean insertNavigatorConfigItem(ContentValues[] paramArrayOfContentValues)
  {
    try
    {
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.h, paramArrayOfContentValues);
      return true;
    }
    catch (Exception paramArrayOfContentValues)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("insertNavigatorConfigItem error:");
        localStringBuilder.append(paramArrayOfContentValues.getMessage());
        QLog.e("QZConfigProviderUtil", 2, localStringBuilder.toString(), paramArrayOfContentValues);
      }
      return false;
    }
    catch (SQLException paramArrayOfContentValues)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("insertNavigatorConfigItem error:");
        localStringBuilder.append(paramArrayOfContentValues.getMessage());
        QLog.e("QZConfigProviderUtil", 2, localStringBuilder.toString(), paramArrayOfContentValues);
      }
    }
    return false;
  }
  
  /* Error */
  private static boolean insertUpdateIspConfigItem(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +176 -> 177
    //   4: aload_0
    //   5: invokestatic 155	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ifnull +163 -> 177
    //   17: aload_1
    //   18: invokestatic 155	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   21: ifgt +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: new 272	android/content/ContentValues
    //   29: dup
    //   30: invokespecial 273	android/content/ContentValues:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: ldc_w 275
    //   38: aload_0
    //   39: invokevirtual 279	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_2
    //   43: ldc 184
    //   45: aload_1
    //   46: invokevirtual 279	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   52: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   55: getstatic 145	com/tencent/common/config/provider/QZoneConfigProvider:f	Landroid/net/Uri;
    //   58: aload_2
    //   59: invokevirtual 283	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   62: pop
    //   63: aload_2
    //   64: invokevirtual 286	android/content/ContentValues:clear	()V
    //   67: iconst_1
    //   68: ireturn
    //   69: astore_0
    //   70: goto +101 -> 171
    //   73: astore_0
    //   74: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +39 -> 116
    //   80: new 112	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   87: astore_1
    //   88: aload_1
    //   89: ldc_w 288
    //   92: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: aload_0
    //   98: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: ldc 10
    //   107: iconst_2
    //   108: aload_1
    //   109: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aload_0
    //   113: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   116: aload_2
    //   117: invokevirtual 286	android/content/ContentValues:clear	()V
    //   120: iconst_0
    //   121: ireturn
    //   122: astore_0
    //   123: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +39 -> 165
    //   129: new 112	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   136: astore_1
    //   137: aload_1
    //   138: ldc_w 288
    //   141: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_1
    //   146: aload_0
    //   147: invokevirtual 268	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   150: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: ldc 10
    //   156: iconst_2
    //   157: aload_1
    //   158: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: aload_0
    //   162: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: aload_2
    //   166: invokevirtual 286	android/content/ContentValues:clear	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: aload_2
    //   172: invokevirtual 286	android/content/ContentValues:clear	()V
    //   175: aload_0
    //   176: athrow
    //   177: iconst_0
    //   178: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramString1	String
    //   0	179	1	paramString2	String
    //   33	139	2	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   49	63	69	finally
    //   74	116	69	finally
    //   123	165	69	finally
    //   49	63	73	java/lang/Exception
    //   49	63	122	android/database/SQLException
  }
  
  /* Error */
  private static boolean isConfigValid(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   11: getstatic 98	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   14: iconst_1
    //   15: anewarray 27	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 292
    //   23: aastore
    //   24: ldc_w 294
    //   27: iconst_1
    //   28: anewarray 27	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: aastore
    //   35: aconst_null
    //   36: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore 5
    //   41: aload 5
    //   43: ifnull +57 -> 100
    //   46: aload 5
    //   48: astore_3
    //   49: aload 5
    //   51: astore 4
    //   53: aload 5
    //   55: invokeinterface 298 1 0
    //   60: ifne +6 -> 66
    //   63: goto +37 -> 100
    //   66: aload 5
    //   68: astore_3
    //   69: aload 5
    //   71: astore 4
    //   73: aload 5
    //   75: invokeinterface 182 1 0
    //   80: pop
    //   81: aload 5
    //   83: astore_3
    //   84: aload 5
    //   86: astore 4
    //   88: aload 5
    //   90: iconst_0
    //   91: invokeinterface 233 2 0
    //   96: istore_1
    //   97: goto +5 -> 102
    //   100: iconst_0
    //   101: istore_1
    //   102: iload_1
    //   103: istore_2
    //   104: aload 5
    //   106: ifnull +120 -> 226
    //   109: aload 5
    //   111: invokeinterface 203 1 0
    //   116: iload_1
    //   117: istore_2
    //   118: goto +108 -> 226
    //   121: astore_0
    //   122: goto +112 -> 234
    //   125: astore 5
    //   127: aload 4
    //   129: astore_3
    //   130: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +79 -> 212
    //   136: aload 4
    //   138: astore_3
    //   139: new 112	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   146: astore 6
    //   148: aload 4
    //   150: astore_3
    //   151: aload 6
    //   153: ldc_w 300
    //   156: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 4
    //   162: astore_3
    //   163: aload 6
    //   165: aload_0
    //   166: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 4
    //   172: astore_3
    //   173: aload 6
    //   175: ldc_w 302
    //   178: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 4
    //   184: astore_3
    //   185: aload 6
    //   187: aload 5
    //   189: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 4
    //   198: astore_3
    //   199: ldc 10
    //   201: iconst_2
    //   202: aload 6
    //   204: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: aload 5
    //   209: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload 4
    //   214: ifnull +10 -> 224
    //   217: aload 4
    //   219: invokeinterface 203 1 0
    //   224: iconst_0
    //   225: istore_2
    //   226: iload_2
    //   227: ifle +5 -> 232
    //   230: iconst_1
    //   231: ireturn
    //   232: iconst_0
    //   233: ireturn
    //   234: aload_3
    //   235: ifnull +9 -> 244
    //   238: aload_3
    //   239: invokeinterface 203 1 0
    //   244: aload_0
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramString	String
    //   96	21	1	i	int
    //   103	124	2	j	int
    //   4	235	3	localObject1	Object
    //   1	217	4	localObject2	Object
    //   39	71	5	localCursor	android.database.Cursor
    //   125	83	5	localException	Exception
    //   146	57	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	41	121	finally
    //   53	63	121	finally
    //   73	81	121	finally
    //   88	97	121	finally
    //   130	136	121	finally
    //   139	148	121	finally
    //   151	160	121	finally
    //   163	170	121	finally
    //   173	182	121	finally
    //   185	196	121	finally
    //   199	212	121	finally
    //   5	41	125	java/lang/Exception
    //   53	63	125	java/lang/Exception
    //   73	81	125	java/lang/Exception
    //   88	97	125	java/lang/Exception
  }
  
  /* Error */
  private boolean saveConfig(Map<String, byte[]> paramMap, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_1
    //   7: invokeinterface 309 1 0
    //   12: ifeq +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_1
    //   18: invokeinterface 313 1 0
    //   23: astore_2
    //   24: ldc 10
    //   26: iconst_1
    //   27: iconst_2
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: ldc_w 315
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: aload_2
    //   40: invokeinterface 318 1 0
    //   45: invokestatic 323	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: aastore
    //   49: invokestatic 329	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   52: new 331	java/util/ArrayList
    //   55: dup
    //   56: invokespecial 332	java/util/ArrayList:<init>	()V
    //   59: astore_3
    //   60: aload_2
    //   61: invokeinterface 336 1 0
    //   66: astore 4
    //   68: aload 4
    //   70: invokeinterface 341 1 0
    //   75: ifeq +359 -> 434
    //   78: aload 4
    //   80: invokeinterface 345 1 0
    //   85: checkcast 27	java/lang/String
    //   88: astore_2
    //   89: aload_1
    //   90: aload_2
    //   91: invokeinterface 349 2 0
    //   96: checkcast 351	[B
    //   99: astore 6
    //   101: aload_2
    //   102: ifnull +329 -> 431
    //   105: aload 6
    //   107: ifnull +324 -> 431
    //   110: aload 6
    //   112: arraylength
    //   113: ifle +318 -> 431
    //   116: ldc 10
    //   118: iconst_1
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: ldc_w 353
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: aload_2
    //   132: aastore
    //   133: invokestatic 329	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   136: invokestatic 359	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   139: aload_2
    //   140: invokevirtual 363	common/config/service/QzoneConfig:deleteConfigs	(Ljava/lang/String;)V
    //   143: new 365	com/qq/jce/wup/UniAttribute
    //   146: dup
    //   147: invokespecial 366	com/qq/jce/wup/UniAttribute:<init>	()V
    //   150: astore 5
    //   152: aload 5
    //   154: ldc 197
    //   156: invokevirtual 369	com/qq/jce/wup/UniAttribute:setEncodeName	(Ljava/lang/String;)V
    //   159: aload 5
    //   161: aload 6
    //   163: invokevirtual 373	com/qq/jce/wup/UniAttribute:decode	([B)V
    //   166: aload 5
    //   168: invokevirtual 376	com/qq/jce/wup/UniAttribute:getKeySet	()Ljava/util/Set;
    //   171: invokeinterface 336 1 0
    //   176: astore 6
    //   178: aload 6
    //   180: invokeinterface 341 1 0
    //   185: ifeq +172 -> 357
    //   188: aload 6
    //   190: invokeinterface 345 1 0
    //   195: checkcast 27	java/lang/String
    //   198: astore 8
    //   200: aload 5
    //   202: aload 8
    //   204: invokevirtual 379	com/qq/jce/wup/UniAttribute:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   207: checkcast 27	java/lang/String
    //   210: astore 7
    //   212: aload 8
    //   214: ifnull +140 -> 354
    //   217: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +46 -> 266
    //   223: ldc 10
    //   225: iconst_2
    //   226: bipush 6
    //   228: anewarray 4	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: ldc_w 381
    //   236: aastore
    //   237: dup
    //   238: iconst_1
    //   239: aload_2
    //   240: aastore
    //   241: dup
    //   242: iconst_2
    //   243: ldc_w 383
    //   246: aastore
    //   247: dup
    //   248: iconst_3
    //   249: aload 8
    //   251: aastore
    //   252: dup
    //   253: iconst_4
    //   254: ldc_w 385
    //   257: aastore
    //   258: dup
    //   259: iconst_5
    //   260: aload 7
    //   262: aastore
    //   263: invokestatic 329	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   266: aload_2
    //   267: invokevirtual 31	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   270: astore_2
    //   271: aload 8
    //   273: invokevirtual 31	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   276: astore 8
    //   278: new 272	android/content/ContentValues
    //   281: dup
    //   282: invokespecial 273	android/content/ContentValues:<init>	()V
    //   285: astore 9
    //   287: aload 9
    //   289: ldc_w 387
    //   292: aload_2
    //   293: invokevirtual 279	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload 9
    //   298: ldc_w 389
    //   301: aload 8
    //   303: invokevirtual 279	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload 9
    //   308: ldc 184
    //   310: aload 7
    //   312: invokevirtual 279	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: invokestatic 359	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   318: aload_2
    //   319: aload 8
    //   321: aload 7
    //   323: iconst_0
    //   324: invokevirtual 393	common/config/service/QzoneConfig:updateOneConfig	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   327: aload_3
    //   328: aload 9
    //   330: invokevirtual 394	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   333: pop
    //   334: aload_2
    //   335: aload 8
    //   337: aload 7
    //   339: invokestatic 398	com/tencent/qzonehub/api/impl/QZConfigProviderUtilProxyImpl:saveMiniAppConfig	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload_0
    //   343: aload_2
    //   344: aload 8
    //   346: aload 7
    //   348: invokevirtual 401	com/tencent/qzonehub/api/impl/QZConfigProviderUtilProxyImpl:saveHighPriorityConfig	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto -173 -> 178
    //   354: goto -176 -> 178
    //   357: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   360: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   363: getstatic 98	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   366: ldc_w 403
    //   369: iconst_1
    //   370: anewarray 27	java/lang/String
    //   373: dup
    //   374: iconst_0
    //   375: aload_2
    //   376: aastore
    //   377: invokevirtual 104	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   380: pop
    //   381: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq -316 -> 68
    //   387: ldc 10
    //   389: iconst_4
    //   390: iconst_2
    //   391: anewarray 4	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: ldc_w 405
    //   399: aastore
    //   400: dup
    //   401: iconst_1
    //   402: aload_2
    //   403: aastore
    //   404: invokestatic 329	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   407: goto -339 -> 68
    //   410: astore_2
    //   411: ldc 10
    //   413: iconst_1
    //   414: aload_2
    //   415: iconst_1
    //   416: anewarray 4	java/lang/Object
    //   419: dup
    //   420: iconst_0
    //   421: ldc_w 407
    //   424: aastore
    //   425: invokestatic 408	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   428: goto -360 -> 68
    //   431: goto -363 -> 68
    //   434: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   437: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   440: getstatic 98	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   443: aload_3
    //   444: aload_3
    //   445: invokevirtual 409	java/util/ArrayList:size	()I
    //   448: anewarray 272	android/content/ContentValues
    //   451: invokevirtual 413	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   454: checkcast 415	[Landroid/content/ContentValues;
    //   457: checkcast 415	[Landroid/content/ContentValues;
    //   460: invokevirtual 265	android/content/ContentResolver:bulkInsert	(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    //   463: pop
    //   464: aload_3
    //   465: invokevirtual 416	java/util/ArrayList:clear	()V
    //   468: iconst_1
    //   469: ireturn
    //   470: astore_1
    //   471: goto +48 -> 519
    //   474: astore_1
    //   475: ldc 10
    //   477: iconst_1
    //   478: aload_1
    //   479: iconst_1
    //   480: anewarray 4	java/lang/Object
    //   483: dup
    //   484: iconst_0
    //   485: ldc_w 418
    //   488: aastore
    //   489: invokestatic 408	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   492: goto +21 -> 513
    //   495: astore_1
    //   496: ldc 10
    //   498: iconst_1
    //   499: aload_1
    //   500: iconst_1
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: ldc_w 418
    //   509: aastore
    //   510: invokestatic 408	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   513: aload_3
    //   514: invokevirtual 416	java/util/ArrayList:clear	()V
    //   517: iconst_0
    //   518: ireturn
    //   519: aload_3
    //   520: invokevirtual 416	java/util/ArrayList:clear	()V
    //   523: goto +5 -> 528
    //   526: aload_1
    //   527: athrow
    //   528: goto -2 -> 526
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	QZConfigProviderUtilProxyImpl
    //   0	531	1	paramMap	Map<String, byte[]>
    //   0	531	2	paramString	String
    //   59	461	3	localArrayList	ArrayList
    //   66	13	4	localIterator	Iterator
    //   150	51	5	localUniAttribute	com.qq.jce.wup.UniAttribute
    //   99	90	6	localObject	Object
    //   210	137	7	str1	String
    //   198	147	8	str2	String
    //   285	44	9	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   357	407	410	java/lang/Exception
    //   434	464	470	finally
    //   475	492	470	finally
    //   496	513	470	finally
    //   434	464	474	java/lang/Exception
    //   434	464	495	android/database/SQLException
  }
  
  private static void saveMiniAppConfig(String paramString1, String paramString2, String paramString3)
  {
    if (("qqminiapp".equals(paramString1)) && ("miniappshowfullscreen".equals(paramString2))) {}
    try
    {
      i = Integer.valueOf(paramString3).intValue();
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("miniappshowfullscreen");
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i).apply();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveConfig miniapp], full screen config, key: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", value: ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", uin = ");
      ((StringBuilder)localObject).append(paramString1);
      QZLog.d("QZConfigProviderUtil", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString1)
    {
      int i;
      Object localObject;
      StringBuilder localStringBuilder;
      label180:
      break label180;
    }
    paramString1 = new StringBuilder();
    paramString1.append("[saveConfig miniapp], full screen config exception. key: ");
    paramString1.append(paramString2);
    paramString1.append(", value: ");
    paramString1.append(paramString3);
    QZLog.e("QZConfigProviderUtil", 1, new Object[] { paramString1.toString() });
    return;
    if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowsetting".equals(paramString2))) {}
    try
    {
      i = Integer.valueOf(paramString3).intValue();
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("miniappfullscreenshowsetting");
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i).apply();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveConfig miniapp], setting config, key: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", value: ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", uin = ");
      ((StringBuilder)localObject).append(paramString1);
      QZLog.d("QZConfigProviderUtil", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString1)
    {
      label414:
      break label414;
    }
    paramString1 = new StringBuilder();
    paramString1.append("[saveConfig miniapp], setting config exception. key: ");
    paramString1.append(paramString2);
    paramString1.append(", value: ");
    paramString1.append(paramString3);
    QZLog.e("QZConfigProviderUtil", 1, new Object[] { paramString1.toString() });
    return;
    if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowclose".equals(paramString2))) {}
    try
    {
      i = Integer.valueOf(paramString3).intValue();
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("miniappfullscreenshowclose");
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i).apply();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveConfig miniapp], close config, key: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", value: ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", uin = ");
      ((StringBuilder)localObject).append(paramString1);
      QZLog.d("QZConfigProviderUtil", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString1)
    {
      label648:
      break label648;
    }
    paramString1 = new StringBuilder();
    paramString1.append("[saveConfig miniapp], close config exception. key: ");
    paramString1.append(paramString2);
    paramString1.append(", value: ");
    paramString1.append(paramString3);
    QZLog.e("QZConfigProviderUtil", 1, new Object[] { paramString1.toString() });
    return;
    if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowsearch".equals(paramString2))) {}
    try
    {
      i = Integer.valueOf(paramString3).intValue();
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("miniappfullscreenshowsearch");
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i).apply();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveConfig miniapp], search config, key: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", value: ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", uin = ");
      ((StringBuilder)localObject).append(paramString1);
      QZLog.d("QZConfigProviderUtil", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString1)
    {
      label882:
      break label882;
    }
    paramString1 = new StringBuilder();
    paramString1.append("[saveConfig miniapp], search config exception. key: ");
    paramString1.append(paramString2);
    paramString1.append(", value: ");
    paramString1.append(paramString3);
    QZLog.e("QZConfigProviderUtil", 1, new Object[] { paramString1.toString() });
    return;
    if (("qqminiapp".equals(paramString1)) && ("miniappfullscreentitle".equals(paramString2))) {}
    try
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("miniappfullscreentitle");
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString3).apply();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveConfig miniapp, search config, key: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", value: ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", uin = ");
      ((StringBuilder)localObject).append(paramString1);
      QZLog.d("QZConfigProviderUtil", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString1)
    {
      label1108:
      break label1108;
    }
    paramString1 = new StringBuilder();
    paramString1.append("saveConfig miniapp, search config exception. key: ");
    paramString1.append(paramString2);
    paramString1.append(", value: ");
    paramString1.append(paramString3);
    QZLog.e("QZConfigProviderUtil", 1, new Object[] { paramString1.toString() });
    return;
    if (("qqminiapp".equals(paramString1)) && (miniAppHighPrioritySecondaryKeys.contains(paramString2))) {}
    try
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString3).apply();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveConfig miniapp high priority config, key: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", value: ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", uin = ");
      ((StringBuilder)localObject).append(paramString1);
      QZLog.d("QZConfigProviderUtil", 1, ((StringBuilder)localObject).toString());
      if (!"sdk_dex_config".equals(paramString2)) {
        break label1411;
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).onDexConfigUpdate(paramString3);
      return;
    }
    catch (Exception paramString1)
    {
      label1358:
      break label1358;
    }
    paramString1 = new StringBuilder();
    paramString1.append("saveConfig miniapp high priority config exception. key: ");
    paramString1.append(paramString2);
    paramString1.append(", value: ");
    paramString1.append(paramString3);
    QZLog.e("QZConfigProviderUtil", 1, new Object[] { paramString1.toString() });
    label1411:
  }
  
  public void cleanAll()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.e, null, null);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("database clear error");
        localStringBuilder.append(localException.getMessage());
        QLog.e("QZConfigProviderUtil", 2, localStringBuilder.toString(), localException);
      }
    }
  }
  
  public ContentValues convertNavigatorConfig(String paramString, entrance_cfg paramentrance_cfg)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramentrance_cfg == null) {
      return null;
    }
    if (paramentrance_cfg.iEntranceId >= 0)
    {
      if (paramentrance_cfg.iEntranceId > 999) {
        return null;
      }
      paramString = paramString.replace(" ", "");
      QZLog.e("QZConfigProviderUtil", 2, new Object[] { "********* insertNavigatorConfigItem ******** rsp return navigator item id:", Integer.valueOf(paramentrance_cfg.iEntranceId), " item name: ", paramentrance_cfg.sEntranceName, " item icon: ", paramentrance_cfg.sEntranceIcon, " item action: ", paramentrance_cfg.sEntranceAction, " item qbossicon: ", paramentrance_cfg.sQbossEntranceIcon });
      if (!TextUtils.isEmpty(paramString))
      {
        if (TextUtils.isEmpty(paramentrance_cfg.sEntranceName)) {
          return null;
        }
        ContentValues localContentValues = new ContentValues();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("&");
        localStringBuilder.append(paramentrance_cfg.iEntranceId);
        localContentValues.put("uin", localStringBuilder.toString());
        localContentValues.put("entraceid", Integer.valueOf(paramentrance_cfg.iEntranceId));
        localContentValues.put("entracename", paramentrance_cfg.sEntranceName);
        localContentValues.put("entraceicon", paramentrance_cfg.sEntranceIcon);
        localContentValues.put("entraceaction", paramentrance_cfg.sEntranceAction);
        localContentValues.put("isDefault", Integer.valueOf(paramentrance_cfg.isDefualt));
        localContentValues.put("tabid", Integer.valueOf(paramentrance_cfg.tabid));
        localContentValues.put("qbossentraceicon", paramentrance_cfg.sQbossEntranceIcon);
        localContentValues.put("qbosstraceinfo", paramentrance_cfg.sQbossTraceInfo);
        localContentValues.put("iscannotshowteenagermode", Integer.valueOf(paramentrance_cfg.isCanNotShowOnTeenagerMod));
        return localContentValues;
      }
    }
    return null;
  }
  
  public void deleteLastUpdateLog()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.d, null, null);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteLastUpdateLog error ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("QZConfigProviderUtil", 2, localStringBuilder.toString(), localException);
      }
    }
  }
  
  /* Error */
  public String getConfigCookie()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: getstatic 133	com/tencent/common/config/provider/QZoneConfigProvider:c	Landroid/net/Uri;
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore_3
    //   21: aload_3
    //   22: ifnull +62 -> 84
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: astore_1
    //   29: aload_3
    //   30: invokeinterface 182 1 0
    //   35: ifeq +49 -> 84
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: astore_1
    //   42: new 27	java/lang/String
    //   45: dup
    //   46: aload_3
    //   47: aload_3
    //   48: ldc_w 593
    //   51: invokeinterface 187 2 0
    //   56: invokeinterface 191 2 0
    //   61: invokevirtual 195	java/lang/String:getBytes	()[B
    //   64: ldc 197
    //   66: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   69: astore 4
    //   71: aload_3
    //   72: ifnull +9 -> 81
    //   75: aload_3
    //   76: invokeinterface 203 1 0
    //   81: aload 4
    //   83: areturn
    //   84: aload_3
    //   85: ifnull +79 -> 164
    //   88: aload_3
    //   89: astore_1
    //   90: goto +68 -> 158
    //   93: astore_1
    //   94: goto +73 -> 167
    //   97: astore_3
    //   98: aload_1
    //   99: astore_2
    //   100: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +51 -> 154
    //   106: aload_1
    //   107: astore_2
    //   108: new 112	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   115: astore 4
    //   117: aload_1
    //   118: astore_2
    //   119: aload 4
    //   121: ldc_w 595
    //   124: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_1
    //   129: astore_2
    //   130: aload 4
    //   132: aload_3
    //   133: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_1
    //   141: astore_2
    //   142: ldc 10
    //   144: iconst_2
    //   145: aload 4
    //   147: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: aload_3
    //   151: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   154: aload_1
    //   155: ifnull +9 -> 164
    //   158: aload_1
    //   159: invokeinterface 203 1 0
    //   164: ldc 211
    //   166: areturn
    //   167: aload_2
    //   168: ifnull +9 -> 177
    //   171: aload_2
    //   172: invokeinterface 203 1 0
    //   177: aload_1
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	QZConfigProviderUtilProxyImpl
    //   1	89	1	localObject1	Object
    //   93	85	1	localObject2	Object
    //   3	169	2	localObject3	Object
    //   20	69	3	localCursor	android.database.Cursor
    //   97	54	3	localException	Exception
    //   69	77	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   4	21	93	finally
    //   29	38	93	finally
    //   42	71	93	finally
    //   100	106	93	finally
    //   108	117	93	finally
    //   119	128	93	finally
    //   130	140	93	finally
    //   142	154	93	finally
    //   4	21	97	java/lang/Exception
    //   29	38	97	java/lang/Exception
    //   42	71	97	java/lang/Exception
  }
  
  public String getHighPriorityConfig(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    try
    {
      paramString3 = getHighPriorityConfigSharedPreferences().getString(getHighPriorityConfigSPKey(paramString1, paramString2), paramString3);
      paramString1 = paramString3;
      if (paramString3 != null)
      {
        str = paramString3;
        paramString1 = paramString3.trim();
      }
      str = paramString1;
      paramString3 = new StringBuilder();
      str = paramString1;
      paramString3.append("getHighPriorityConfig. , secondKey: ");
      str = paramString1;
      paramString3.append(paramString2);
      str = paramString1;
      paramString3.append(", result: ");
      str = paramString1;
      paramString3.append(paramString1);
      str = paramString1;
      QZLog.d("QZConfigProviderUtil", 1, paramString3.toString());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString3 = new StringBuilder();
      paramString3.append("getHighPriorityConfig exception. secondKey: ");
      paramString3.append(paramString2);
      QZLog.e("QZConfigProviderUtil", 1, new Object[] { paramString3.toString(), paramString1 });
    }
    return str;
  }
  
  public String getHighPriorityConfigSPKey(String paramString1, String paramString2)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public SharedPreferences getHighPriorityConfigSharedPreferences()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
  }
  
  /* Error */
  public long getLastCheckTime()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   11: getstatic 139	com/tencent/common/config/provider/QZoneConfigProvider:g	Landroid/net/Uri;
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore 5
    //   23: aload 5
    //   25: ifnull +59 -> 84
    //   28: aload 5
    //   30: astore 4
    //   32: aload 5
    //   34: astore_3
    //   35: aload 5
    //   37: invokeinterface 182 1 0
    //   42: ifeq +42 -> 84
    //   45: aload 5
    //   47: astore 4
    //   49: aload 5
    //   51: astore_3
    //   52: aload 5
    //   54: aload 5
    //   56: ldc_w 622
    //   59: invokeinterface 187 2 0
    //   64: invokeinterface 626 2 0
    //   69: lstore_1
    //   70: aload 5
    //   72: ifnull +10 -> 82
    //   75: aload 5
    //   77: invokeinterface 203 1 0
    //   82: lload_1
    //   83: lreturn
    //   84: aload 5
    //   86: ifnull +88 -> 174
    //   89: aload 5
    //   91: astore_3
    //   92: goto +76 -> 168
    //   95: astore_3
    //   96: goto +80 -> 176
    //   99: astore 5
    //   101: aload_3
    //   102: astore 4
    //   104: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +57 -> 164
    //   110: aload_3
    //   111: astore 4
    //   113: new 112	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   120: astore 6
    //   122: aload_3
    //   123: astore 4
    //   125: aload 6
    //   127: ldc_w 628
    //   130: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_3
    //   135: astore 4
    //   137: aload 6
    //   139: aload 5
    //   141: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   144: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_3
    //   149: astore 4
    //   151: ldc 10
    //   153: iconst_2
    //   154: aload 6
    //   156: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: aload 5
    //   161: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload_3
    //   165: ifnull +9 -> 174
    //   168: aload_3
    //   169: invokeinterface 203 1 0
    //   174: lconst_0
    //   175: lreturn
    //   176: aload 4
    //   178: ifnull +10 -> 188
    //   181: aload 4
    //   183: invokeinterface 203 1 0
    //   188: aload_3
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	QZConfigProviderUtilProxyImpl
    //   69	14	1	l	long
    //   1	91	3	localObject1	Object
    //   95	94	3	localObject2	Object
    //   3	179	4	localObject3	Object
    //   21	69	5	localCursor	android.database.Cursor
    //   99	61	5	localException	Exception
    //   120	35	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	23	95	finally
    //   35	45	95	finally
    //   52	70	95	finally
    //   104	110	95	finally
    //   113	122	95	finally
    //   125	134	95	finally
    //   137	148	95	finally
    //   151	164	95	finally
    //   5	23	99	java/lang/Exception
    //   35	45	99	java/lang/Exception
    //   52	70	99	java/lang/Exception
  }
  
  /* Error */
  public String getLastUpdate()
  {
    // Byte code:
    //   0: ldc 211
    //   2: astore_3
    //   3: aconst_null
    //   4: astore_1
    //   5: aconst_null
    //   6: astore 4
    //   8: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   14: getstatic 588	com/tencent/common/config/provider/QZoneConfigProvider:d	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore 5
    //   26: aload_3
    //   27: astore_2
    //   28: aload 5
    //   30: ifnull +47 -> 77
    //   33: aload_3
    //   34: astore_2
    //   35: aload 5
    //   37: astore 4
    //   39: aload 5
    //   41: astore_1
    //   42: aload 5
    //   44: invokeinterface 182 1 0
    //   49: ifeq +28 -> 77
    //   52: aload 5
    //   54: astore 4
    //   56: aload 5
    //   58: astore_1
    //   59: aload 5
    //   61: aload 5
    //   63: ldc_w 631
    //   66: invokeinterface 187 2 0
    //   71: invokeinterface 191 2 0
    //   76: astore_2
    //   77: aload_2
    //   78: astore 4
    //   80: aload 5
    //   82: ifnull +92 -> 174
    //   85: aload 5
    //   87: astore_1
    //   88: aload_1
    //   89: invokeinterface 203 1 0
    //   94: aload_2
    //   95: areturn
    //   96: astore_1
    //   97: goto +80 -> 177
    //   100: astore_2
    //   101: aload_1
    //   102: astore 4
    //   104: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +55 -> 162
    //   110: aload_1
    //   111: astore 4
    //   113: new 112	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   120: astore 5
    //   122: aload_1
    //   123: astore 4
    //   125: aload 5
    //   127: ldc_w 633
    //   130: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_1
    //   135: astore 4
    //   137: aload 5
    //   139: aload_2
    //   140: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_1
    //   148: astore 4
    //   150: ldc 10
    //   152: iconst_2
    //   153: aload 5
    //   155: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: aload_2
    //   159: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   162: aload_3
    //   163: astore 4
    //   165: aload_1
    //   166: ifnull +8 -> 174
    //   169: aload_3
    //   170: astore_2
    //   171: goto -83 -> 88
    //   174: aload 4
    //   176: areturn
    //   177: aload 4
    //   179: ifnull +10 -> 189
    //   182: aload 4
    //   184: invokeinterface 203 1 0
    //   189: goto +5 -> 194
    //   192: aload_1
    //   193: athrow
    //   194: goto -2 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	QZConfigProviderUtilProxyImpl
    //   4	85	1	localObject1	Object
    //   96	97	1	localObject2	Object
    //   27	68	2	str1	String
    //   100	59	2	localException	Exception
    //   170	1	2	str2	String
    //   2	168	3	str3	String
    //   6	177	4	localObject3	Object
    //   24	130	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	26	96	finally
    //   42	52	96	finally
    //   59	77	96	finally
    //   104	110	96	finally
    //   113	122	96	finally
    //   125	134	96	finally
    //   137	147	96	finally
    //   150	162	96	finally
    //   8	26	100	java/lang/Exception
    //   42	52	100	java/lang/Exception
    //   59	77	100	java/lang/Exception
  }
  
  /* Error */
  public boolean getNavigatorConfigs(String paramString, ArrayList<entrance_cfg> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +467 -> 468
    //   4: aload_1
    //   5: invokestatic 155	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_2
    //   14: ifnonnull +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_2
    //   20: invokevirtual 416	java/util/ArrayList:clear	()V
    //   23: aload_1
    //   24: ldc 209
    //   26: ldc 211
    //   28: invokevirtual 215	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   31: astore_1
    //   32: new 112	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   39: astore 4
    //   41: aload 4
    //   43: ldc_w 637
    //   46: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: aload_1
    //   53: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 4
    //   59: ldc_w 639
    //   62: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 4
    //   68: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: astore 5
    //   73: aconst_null
    //   74: astore_1
    //   75: aconst_null
    //   76: astore 4
    //   78: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   81: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   84: getstatic 223	com/tencent/common/config/provider/QZoneConfigProvider:h	Landroid/net/Uri;
    //   87: aconst_null
    //   88: aload 5
    //   90: aconst_null
    //   91: aconst_null
    //   92: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   95: astore 5
    //   97: aload 5
    //   99: ifnull +264 -> 363
    //   102: aload 5
    //   104: astore 4
    //   106: aload 5
    //   108: astore_1
    //   109: aload 5
    //   111: invokeinterface 182 1 0
    //   116: ifeq +247 -> 363
    //   119: aload 5
    //   121: astore 4
    //   123: aload 5
    //   125: astore_1
    //   126: aload_2
    //   127: new 227	NS_UNDEAL_COUNT/entrance_cfg
    //   130: dup
    //   131: aload 5
    //   133: aload 5
    //   135: ldc 229
    //   137: invokeinterface 187 2 0
    //   142: invokeinterface 233 2 0
    //   147: new 27	java/lang/String
    //   150: dup
    //   151: aload 5
    //   153: aload 5
    //   155: ldc 235
    //   157: invokeinterface 187 2 0
    //   162: invokeinterface 191 2 0
    //   167: invokevirtual 195	java/lang/String:getBytes	()[B
    //   170: ldc 197
    //   172: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   175: new 27	java/lang/String
    //   178: dup
    //   179: aload 5
    //   181: aload 5
    //   183: ldc 237
    //   185: invokeinterface 187 2 0
    //   190: invokeinterface 191 2 0
    //   195: invokevirtual 195	java/lang/String:getBytes	()[B
    //   198: ldc 197
    //   200: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   203: new 27	java/lang/String
    //   206: dup
    //   207: aload 5
    //   209: aload 5
    //   211: ldc 239
    //   213: invokeinterface 187 2 0
    //   218: invokeinterface 191 2 0
    //   223: invokevirtual 195	java/lang/String:getBytes	()[B
    //   226: ldc 197
    //   228: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   231: aload 5
    //   233: aload 5
    //   235: ldc 241
    //   237: invokeinterface 187 2 0
    //   242: invokeinterface 233 2 0
    //   247: aload 5
    //   249: aload 5
    //   251: ldc 243
    //   253: invokeinterface 187 2 0
    //   258: invokeinterface 233 2 0
    //   263: new 27	java/lang/String
    //   266: dup
    //   267: aload 5
    //   269: aload 5
    //   271: ldc 245
    //   273: invokeinterface 187 2 0
    //   278: invokeinterface 191 2 0
    //   283: invokevirtual 195	java/lang/String:getBytes	()[B
    //   286: ldc 197
    //   288: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   291: new 27	java/lang/String
    //   294: dup
    //   295: aload 5
    //   297: aload 5
    //   299: ldc 247
    //   301: invokeinterface 187 2 0
    //   306: invokeinterface 191 2 0
    //   311: invokevirtual 195	java/lang/String:getBytes	()[B
    //   314: ldc 197
    //   316: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   319: iconst_0
    //   320: aconst_null
    //   321: aload 5
    //   323: aload 5
    //   325: ldc 249
    //   327: invokeinterface 187 2 0
    //   332: invokeinterface 233 2 0
    //   337: invokespecial 252	NS_UNDEAL_COUNT/entrance_cfg:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ILNS_UNDEAL_COUNT/st_report_info;I)V
    //   340: invokevirtual 394	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   343: pop
    //   344: aload 5
    //   346: astore 4
    //   348: aload 5
    //   350: astore_1
    //   351: aload 5
    //   353: invokeinterface 642 1 0
    //   358: istore_3
    //   359: iload_3
    //   360: ifne -241 -> 119
    //   363: aload 5
    //   365: ifnull +87 -> 452
    //   368: aload 5
    //   370: astore_1
    //   371: aload_1
    //   372: invokeinterface 203 1 0
    //   377: iconst_0
    //   378: ireturn
    //   379: astore_1
    //   380: goto +74 -> 454
    //   383: astore_2
    //   384: aload_1
    //   385: astore 4
    //   387: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq +55 -> 445
    //   393: aload_1
    //   394: astore 4
    //   396: new 112	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   403: astore 5
    //   405: aload_1
    //   406: astore 4
    //   408: aload 5
    //   410: ldc_w 644
    //   413: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_1
    //   418: astore 4
    //   420: aload 5
    //   422: aload_2
    //   423: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   426: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload_1
    //   431: astore 4
    //   433: ldc 10
    //   435: iconst_2
    //   436: aload 5
    //   438: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: aload_2
    //   442: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   445: aload_1
    //   446: ifnull +6 -> 452
    //   449: goto -78 -> 371
    //   452: iconst_0
    //   453: ireturn
    //   454: aload 4
    //   456: ifnull +10 -> 466
    //   459: aload 4
    //   461: invokeinterface 203 1 0
    //   466: aload_1
    //   467: athrow
    //   468: iconst_0
    //   469: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	QZConfigProviderUtilProxyImpl
    //   0	470	1	paramString	String
    //   0	470	2	paramArrayList	ArrayList<entrance_cfg>
    //   358	2	3	bool	boolean
    //   39	421	4	localObject1	Object
    //   71	366	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   78	97	379	finally
    //   109	119	379	finally
    //   126	344	379	finally
    //   351	359	379	finally
    //   387	393	379	finally
    //   396	405	379	finally
    //   408	417	379	finally
    //   420	430	379	finally
    //   433	445	379	finally
    //   78	97	383	java/lang/Exception
    //   109	119	383	java/lang/Exception
    //   126	344	383	java/lang/Exception
    //   351	359	383	java/lang/Exception
  }
  
  /* Error */
  public String getOneConfig(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_1
    //   10: ifnull +206 -> 216
    //   13: aload_1
    //   14: invokestatic 155	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   17: ifgt +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: aload_2
    //   23: ifnull +193 -> 216
    //   26: aload_2
    //   27: invokestatic 155	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   30: ifgt +5 -> 35
    //   33: aconst_null
    //   34: areturn
    //   35: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   38: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   41: getstatic 98	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   44: aconst_null
    //   45: ldc_w 648
    //   48: iconst_2
    //   49: anewarray 27	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_2
    //   59: aastore
    //   60: aconst_null
    //   61: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_3
    //   65: aload 4
    //   67: astore_1
    //   68: aload_3
    //   69: ifnull +44 -> 113
    //   72: aload 4
    //   74: astore_1
    //   75: aload_3
    //   76: astore_2
    //   77: aload_3
    //   78: invokeinterface 182 1 0
    //   83: ifeq +30 -> 113
    //   86: aload_3
    //   87: astore_2
    //   88: aload_3
    //   89: aload_3
    //   90: ldc 184
    //   92: invokeinterface 187 2 0
    //   97: invokeinterface 191 2 0
    //   102: astore_1
    //   103: goto +10 -> 113
    //   106: astore 4
    //   108: aload_3
    //   109: astore_1
    //   110: goto +36 -> 146
    //   113: aload_1
    //   114: astore_2
    //   115: aload_3
    //   116: ifnull +77 -> 193
    //   119: aload_1
    //   120: astore_2
    //   121: aload_3
    //   122: invokeinterface 203 1 0
    //   127: aload_1
    //   128: areturn
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   134: aload_2
    //   135: areturn
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_2
    //   139: goto +57 -> 196
    //   142: astore 4
    //   144: aconst_null
    //   145: astore_1
    //   146: aload_1
    //   147: astore_2
    //   148: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +23 -> 174
    //   154: aload_1
    //   155: astore_2
    //   156: ldc 10
    //   158: iconst_2
    //   159: aload 4
    //   161: iconst_1
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: ldc_w 650
    //   170: aastore
    //   171: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   174: aload 5
    //   176: astore_2
    //   177: aload_1
    //   178: ifnull +15 -> 193
    //   181: aload 6
    //   183: astore_2
    //   184: aload_1
    //   185: invokeinterface 203 1 0
    //   190: aload 5
    //   192: astore_2
    //   193: aload_2
    //   194: areturn
    //   195: astore_1
    //   196: aload_2
    //   197: ifnull +17 -> 214
    //   200: aload_2
    //   201: invokeinterface 203 1 0
    //   206: goto +8 -> 214
    //   209: astore_2
    //   210: aload_2
    //   211: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   214: aload_1
    //   215: athrow
    //   216: aconst_null
    //   217: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	QZConfigProviderUtilProxyImpl
    //   0	218	1	paramString1	String
    //   0	218	2	paramString2	String
    //   64	58	3	localCursor	android.database.Cursor
    //   7	66	4	localObject1	Object
    //   106	1	4	localException1	Exception
    //   142	18	4	localException2	Exception
    //   4	187	5	localObject2	Object
    //   1	181	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   77	86	106	java/lang/Exception
    //   88	103	106	java/lang/Exception
    //   121	127	129	java/lang/Exception
    //   184	190	129	java/lang/Exception
    //   35	65	136	finally
    //   35	65	142	java/lang/Exception
    //   77	86	195	finally
    //   88	103	195	finally
    //   148	154	195	finally
    //   156	174	195	finally
    //   200	206	209	java/lang/Exception
  }
  
  public boolean isEeveeSysTemPolling()
  {
    String str = getHighPriorityConfig("qqcircle", "qqcircle_enable_eevee_polling", "1");
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isEeveeSysTemPolling:");
        localStringBuilder.append(str);
        QLog.e("QZConfigProviderUtil", 1, localStringBuilder.toString());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "1".equals(str);
  }
  
  public boolean isQQCircleUseEeveeRedPoint()
  {
    return "1".equals(QZConfigProviderUtil.a("qqcircle", "qqcircle_use_eevee_red_point", "1"));
  }
  
  /* Error */
  public boolean loadAllConfigs(Map<String, java.util.concurrent.ConcurrentHashMap<String, String>> paramMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 6
    //   8: astore 4
    //   10: aload 7
    //   12: astore 5
    //   14: aload_1
    //   15: invokeinterface 668 1 0
    //   20: aload 6
    //   22: astore 4
    //   24: aload 7
    //   26: astore 5
    //   28: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   31: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   34: getstatic 98	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore 6
    //   46: aload 6
    //   48: ifnull +182 -> 230
    //   51: aload 6
    //   53: astore 4
    //   55: aload 6
    //   57: astore 5
    //   59: aload 6
    //   61: invokeinterface 642 1 0
    //   66: ifeq +159 -> 225
    //   69: aload 6
    //   71: astore 4
    //   73: aload 6
    //   75: astore 5
    //   77: aload 6
    //   79: iconst_0
    //   80: invokeinterface 191 2 0
    //   85: astore 9
    //   87: aload 6
    //   89: astore 4
    //   91: aload 6
    //   93: astore 5
    //   95: aload 6
    //   97: iconst_1
    //   98: invokeinterface 191 2 0
    //   103: astore 10
    //   105: aload 9
    //   107: ifnull -56 -> 51
    //   110: aload 10
    //   112: ifnull -61 -> 51
    //   115: aload 6
    //   117: astore 4
    //   119: aload 6
    //   121: astore 5
    //   123: aload 6
    //   125: iconst_2
    //   126: invokeinterface 191 2 0
    //   131: astore 11
    //   133: aload 6
    //   135: astore 4
    //   137: aload 6
    //   139: astore 5
    //   141: aload_1
    //   142: aload 9
    //   144: invokeinterface 349 2 0
    //   149: checkcast 670	java/util/concurrent/ConcurrentHashMap
    //   152: astore 8
    //   154: aload 8
    //   156: astore 7
    //   158: aload 8
    //   160: ifnonnull +39 -> 199
    //   163: aload 6
    //   165: astore 4
    //   167: aload 6
    //   169: astore 5
    //   171: new 670	java/util/concurrent/ConcurrentHashMap
    //   174: dup
    //   175: invokespecial 671	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   178: astore 7
    //   180: aload 6
    //   182: astore 4
    //   184: aload 6
    //   186: astore 5
    //   188: aload_1
    //   189: aload 9
    //   191: aload 7
    //   193: invokeinterface 674 3 0
    //   198: pop
    //   199: aload 7
    //   201: ifnull -150 -> 51
    //   204: aload 6
    //   206: astore 4
    //   208: aload 6
    //   210: astore 5
    //   212: aload 7
    //   214: aload 10
    //   216: aload 11
    //   218: invokevirtual 675	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   221: pop
    //   222: goto -171 -> 51
    //   225: iconst_1
    //   226: istore_2
    //   227: goto +5 -> 232
    //   230: iconst_0
    //   231: istore_2
    //   232: iload_2
    //   233: istore_3
    //   234: aload 6
    //   236: ifnull +117 -> 353
    //   239: aload 6
    //   241: invokeinterface 203 1 0
    //   246: iload_2
    //   247: ireturn
    //   248: astore_1
    //   249: iload_2
    //   250: istore_3
    //   251: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +99 -> 353
    //   257: ldc 10
    //   259: iconst_2
    //   260: aload_1
    //   261: iconst_1
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: ldc_w 677
    //   270: aastore
    //   271: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   274: iload_2
    //   275: ireturn
    //   276: astore_1
    //   277: goto +78 -> 355
    //   280: astore_1
    //   281: aload 5
    //   283: astore 4
    //   285: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +24 -> 312
    //   291: aload 5
    //   293: astore 4
    //   295: ldc 10
    //   297: iconst_2
    //   298: aload_1
    //   299: iconst_1
    //   300: anewarray 4	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: ldc_w 677
    //   308: aastore
    //   309: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   312: aload 5
    //   314: ifnull +37 -> 351
    //   317: aload 5
    //   319: invokeinterface 203 1 0
    //   324: goto +27 -> 351
    //   327: astore_1
    //   328: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +20 -> 351
    //   334: ldc 10
    //   336: iconst_2
    //   337: aload_1
    //   338: iconst_1
    //   339: anewarray 4	java/lang/Object
    //   342: dup
    //   343: iconst_0
    //   344: ldc_w 677
    //   347: aastore
    //   348: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   351: iconst_0
    //   352: istore_3
    //   353: iload_3
    //   354: ireturn
    //   355: aload 4
    //   357: ifnull +39 -> 396
    //   360: aload 4
    //   362: invokeinterface 203 1 0
    //   367: goto +29 -> 396
    //   370: astore 4
    //   372: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +21 -> 396
    //   378: ldc 10
    //   380: iconst_2
    //   381: aload 4
    //   383: iconst_1
    //   384: anewarray 4	java/lang/Object
    //   387: dup
    //   388: iconst_0
    //   389: ldc_w 677
    //   392: aastore
    //   393: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   396: goto +5 -> 401
    //   399: aload_1
    //   400: athrow
    //   401: goto -2 -> 399
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	QZConfigProviderUtilProxyImpl
    //   0	404	1	paramMap	Map<String, java.util.concurrent.ConcurrentHashMap<String, String>>
    //   226	49	2	bool1	boolean
    //   233	121	3	bool2	boolean
    //   8	353	4	localObject1	Object
    //   370	12	4	localException	Exception
    //   12	306	5	localObject2	Object
    //   4	236	6	localCursor	android.database.Cursor
    //   1	212	7	localObject3	Object
    //   152	7	8	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    //   85	105	9	str1	String
    //   103	112	10	str2	String
    //   131	86	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   239	246	248	java/lang/Exception
    //   14	20	276	finally
    //   28	46	276	finally
    //   59	69	276	finally
    //   77	87	276	finally
    //   95	105	276	finally
    //   123	133	276	finally
    //   141	154	276	finally
    //   171	180	276	finally
    //   188	199	276	finally
    //   212	222	276	finally
    //   285	291	276	finally
    //   295	312	276	finally
    //   14	20	280	java/lang/Exception
    //   28	46	280	java/lang/Exception
    //   59	69	280	java/lang/Exception
    //   77	87	280	java/lang/Exception
    //   95	105	280	java/lang/Exception
    //   123	133	280	java/lang/Exception
    //   141	154	280	java/lang/Exception
    //   171	180	280	java/lang/Exception
    //   188	199	280	java/lang/Exception
    //   212	222	280	java/lang/Exception
    //   317	324	327	java/lang/Exception
    //   360	367	370	java/lang/Exception
  }
  
  /* Error */
  public Map<String, String> loadIspConfigs()
  {
    // Byte code:
    //   0: new 682	java/util/HashMap
    //   3: dup
    //   4: invokespecial 683	java/util/HashMap:<init>	()V
    //   7: astore 4
    //   9: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   15: getstatic 145	com/tencent/common/config/provider/QZoneConfigProvider:f	Landroid/net/Uri;
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +98 -> 125
    //   30: aload_3
    //   31: astore_2
    //   32: aload_3
    //   33: invokeinterface 182 1 0
    //   38: ifeq +87 -> 125
    //   41: aload_3
    //   42: astore_2
    //   43: aload 4
    //   45: new 27	java/lang/String
    //   48: dup
    //   49: aload_3
    //   50: aload_3
    //   51: ldc_w 275
    //   54: invokeinterface 187 2 0
    //   59: invokeinterface 191 2 0
    //   64: invokevirtual 195	java/lang/String:getBytes	()[B
    //   67: ldc 197
    //   69: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   72: new 27	java/lang/String
    //   75: dup
    //   76: aload_3
    //   77: aload_3
    //   78: ldc 184
    //   80: invokeinterface 187 2 0
    //   85: invokeinterface 191 2 0
    //   90: invokevirtual 195	java/lang/String:getBytes	()[B
    //   93: ldc 197
    //   95: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   98: invokeinterface 674 3 0
    //   103: pop
    //   104: aload_3
    //   105: astore_2
    //   106: aload_3
    //   107: invokeinterface 642 1 0
    //   112: istore_1
    //   113: iload_1
    //   114: ifne -73 -> 41
    //   117: goto +8 -> 125
    //   120: astore 4
    //   122: goto +26 -> 148
    //   125: aload_3
    //   126: ifnull +9 -> 135
    //   129: aload_3
    //   130: invokeinterface 203 1 0
    //   135: aload 4
    //   137: areturn
    //   138: astore_2
    //   139: aconst_null
    //   140: astore_3
    //   141: goto +84 -> 225
    //   144: astore 4
    //   146: aconst_null
    //   147: astore_3
    //   148: aload_3
    //   149: astore_2
    //   150: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +53 -> 206
    //   156: aload_3
    //   157: astore_2
    //   158: new 112	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   165: astore 5
    //   167: aload_3
    //   168: astore_2
    //   169: aload 5
    //   171: ldc_w 685
    //   174: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_3
    //   179: astore_2
    //   180: aload 5
    //   182: aload 4
    //   184: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   187: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_3
    //   192: astore_2
    //   193: ldc 10
    //   195: iconst_2
    //   196: aload 5
    //   198: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aload 4
    //   203: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   206: aload_3
    //   207: ifnull +9 -> 216
    //   210: aload_3
    //   211: invokeinterface 203 1 0
    //   216: aconst_null
    //   217: areturn
    //   218: astore 4
    //   220: aload_2
    //   221: astore_3
    //   222: aload 4
    //   224: astore_2
    //   225: aload_3
    //   226: ifnull +9 -> 235
    //   229: aload_3
    //   230: invokeinterface 203 1 0
    //   235: goto +5 -> 240
    //   238: aload_2
    //   239: athrow
    //   240: goto -2 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	QZConfigProviderUtilProxyImpl
    //   112	2	1	bool	boolean
    //   31	75	2	localObject1	Object
    //   138	1	2	localObject2	Object
    //   149	90	2	localObject3	Object
    //   25	205	3	localObject4	Object
    //   7	37	4	localHashMap	java.util.HashMap
    //   120	16	4	localException1	Exception
    //   144	58	4	localException2	Exception
    //   218	5	4	localObject5	Object
    //   165	32	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   32	41	120	java/lang/Exception
    //   43	104	120	java/lang/Exception
    //   106	113	120	java/lang/Exception
    //   9	26	138	finally
    //   9	26	144	java/lang/Exception
    //   32	41	218	finally
    //   43	104	218	finally
    //   106	113	218	finally
    //   150	156	218	finally
    //   158	167	218	finally
    //   169	178	218	finally
    //   180	191	218	finally
    //   193	206	218	finally
  }
  
  /* Error */
  public boolean recUpdateSource(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +156 -> 157
    //   4: aload_1
    //   5: invokestatic 155	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: new 272	android/content/ContentValues
    //   16: dup
    //   17: invokespecial 273	android/content/ContentValues:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc_w 631
    //   25: aload_1
    //   26: invokevirtual 279	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   32: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   35: getstatic 588	com/tencent/common/config/provider/QZoneConfigProvider:d	Landroid/net/Uri;
    //   38: aload_2
    //   39: invokevirtual 283	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   42: pop
    //   43: aload_2
    //   44: invokevirtual 286	android/content/ContentValues:clear	()V
    //   47: iconst_1
    //   48: ireturn
    //   49: astore_1
    //   50: goto +101 -> 151
    //   53: astore_1
    //   54: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +39 -> 96
    //   60: new 112	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   67: astore_3
    //   68: aload_3
    //   69: ldc_w 689
    //   72: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_3
    //   77: aload_1
    //   78: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   81: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: ldc 10
    //   87: iconst_1
    //   88: aload_3
    //   89: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: aload_1
    //   93: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   96: aload_2
    //   97: invokevirtual 286	android/content/ContentValues:clear	()V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_1
    //   103: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +39 -> 145
    //   109: new 112	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   116: astore_3
    //   117: aload_3
    //   118: ldc_w 689
    //   121: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_3
    //   126: aload_1
    //   127: invokevirtual 268	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: ldc 10
    //   136: iconst_1
    //   137: aload_3
    //   138: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: aload_1
    //   142: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_2
    //   146: invokevirtual 286	android/content/ContentValues:clear	()V
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_2
    //   152: invokevirtual 286	android/content/ContentValues:clear	()V
    //   155: aload_1
    //   156: athrow
    //   157: iconst_0
    //   158: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	QZConfigProviderUtilProxyImpl
    //   0	159	1	paramString	String
    //   20	132	2	localContentValues	ContentValues
    //   67	71	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	43	49	finally
    //   54	96	49	finally
    //   103	145	49	finally
    //   29	43	53	java/lang/Exception
    //   29	43	102	android/database/SQLException
  }
  
  public void saveConfigCookie(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramString == null) {
      localObject = "";
    } else {
      localObject = paramString;
    }
    localContentValues.put("cookie", (String)localObject);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveConfigCookie cookie");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("ConfigProvider", 1, ((StringBuilder)localObject).toString());
    try
    {
      paramString = BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.c, localContentValues);
      if (paramString != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.toString());
        ((StringBuilder)localObject).append(" saveConfigCookie done.");
        QLog.i("QZConfigProviderUtil", 1, ((StringBuilder)localObject).toString());
      }
      else
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error!");
      }
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveConfigCookie error:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("QZConfigProviderUtil", 1, ((StringBuilder)localObject).toString(), paramString);
    }
    catch (SQLException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveConfigCookie error:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("QZConfigProviderUtil", 1, ((StringBuilder)localObject).toString(), paramString);
    }
    localContentValues.clear();
  }
  
  public void saveHighPriorityConfig(String paramString1, String paramString2, String paramString3)
  {
    if ("qqcircle".equals(paramString1)) {
      try
      {
        if (qqcircleHighPrioritySecondaryKeys.contains(paramString2))
        {
          localObject = getHighPriorityConfigSharedPreferences();
          paramString1 = getHighPriorityConfigSPKey(paramString1, paramString2);
          ((SharedPreferences)localObject).edit().putString(paramString1, paramString3).apply();
          paramString1 = new StringBuilder();
          paramString1.append("saveHighPriorityConfig.  secondKey: ");
          paramString1.append(paramString2);
          paramString1.append(", value: ");
          paramString1.append(paramString3);
          QZLog.d("QZConfigProviderUtil", 1, paramString1.toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveHighPriorityConfig. exception. secondKey: ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(", value: ");
        ((StringBuilder)localObject).append(paramString3);
        QZLog.e("QZConfigProviderUtil", 1, new Object[] { ((StringBuilder)localObject).toString(), paramString1 });
      }
    }
  }
  
  public void saveIspCheckTime(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("check_time", Long.valueOf(paramLong));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("saveIspCheckTime time:");
      localStringBuilder1.append(paramLong);
      QLog.d("QZConfigProviderUtil", 2, localStringBuilder1.toString());
    }
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.g, localContentValues);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("saveIspCheckTime error :");
        localStringBuilder2.append(localException.getMessage());
        QLog.e("QZConfigProviderUtil", 2, localStringBuilder2.toString(), localException);
      }
    }
    catch (SQLException localSQLException)
    {
      StringBuilder localStringBuilder2;
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("saveIspCheckTime error :");
        localStringBuilder2.append(localSQLException.getMessage());
        QLog.e("QZConfigProviderUtil", 2, localStringBuilder2.toString(), localSQLException);
      }
    }
    localContentValues.clear();
  }
  
  public void saveIspConfig(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if (paramMap.isEmpty()) {
      return;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      insertUpdateIspConfigItem(str, (String)paramMap.get(str));
    }
  }
  
  public void saveNavigatorBar(String paramString, ArrayList<entrance_cfg> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    if (paramArrayList.size() == 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ContentValues localContentValues = convertNavigatorConfig(paramString, (entrance_cfg)paramArrayList.next());
      if (localContentValues != null) {
        localArrayList.add(localContentValues);
      }
    }
    insertNavigatorConfigItem((ContentValues[])localArrayList.toArray(new ContentValues[0]));
  }
  
  public void updateConfigAndCookie(Map<String, byte[]> paramMap, String paramString1, String paramString2, AppRuntime paramAppRuntime)
  {
    boolean bool = saveConfig(paramMap, paramString2);
    if ((isConfigValid("PhotoUpload")) && (isConfigValid("PhotoSvrList")))
    {
      if (bool) {
        saveConfigCookie(paramString1);
      }
    }
    else {
      saveConfigCookie("");
    }
    recUpdateSource(paramString2);
    if (paramAppRuntime != null) {
      try
      {
        if (((paramAppRuntime instanceof QQAppInterface)) && (paramAppRuntime.getLongAccountUin() != 0L))
        {
          paramMap = QzoneConfig.getInstance().getConfig("QZoneSetting", "Qzone_clearCacheVersion", "");
          if ((!TextUtils.isEmpty(paramMap)) && (!LocalMultiProcConfig.getString4Uin("Qzone_clearCacheVersion", "", paramAppRuntime.getLongAccountUin()).equals(paramMap)))
          {
            QZoneHelper.clearCache(paramAppRuntime, true);
            LocalMultiProcConfig.putString4Uin("Qzone_clearCacheVersion", paramMap, paramAppRuntime.getLongAccountUin());
            return;
          }
        }
      }
      catch (Exception paramMap)
      {
        QLog.e("QZConfigProviderUtil", 1, paramMap.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QZConfigProviderUtilProxyImpl
 * JD-Core Version:    0.7.0.1
 */