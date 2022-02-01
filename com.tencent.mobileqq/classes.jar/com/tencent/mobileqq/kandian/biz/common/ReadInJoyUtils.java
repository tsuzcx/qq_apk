package com.tencent.mobileqq.kandian.biz.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.EncryptUinHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.account.RIJUserLevelDialog;
import com.tencent.mobileqq.kandian.biz.account.RIJUserLevelDialog.DialogSettingInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class ReadInJoyUtils
{
  public static String a;
  public static HashMap<Integer, ReadInJoyBaseViewController> a = new HashMap();
  public static volatile boolean a;
  
  public static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt2 != 0))
    {
      if (paramInt1 + 1 == paramInt2) {
        return 1;
      }
      return 0;
    }
    return -1;
  }
  
  public static Integer a(Context paramContext, String paramString)
  {
    return RIJJumpUtils.a(paramContext, paramString, null);
  }
  
  public static String a()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(a(), true, true);
    String str2 = localSharedPreferences.getString("iid", "");
    String str1 = Aladdin.getConfig(454).getString("key_for_iid", "");
    if (TextUtils.isEmpty(str2)) {
      return a(localSharedPreferences, str1);
    }
    if (TextUtils.equals(str2, str1))
    {
      str2 = localSharedPreferences.getString(str1, "");
      if (TextUtils.isEmpty(str2)) {
        return a(localSharedPreferences, str1);
      }
      return str2;
    }
    return a(localSharedPreferences, str1);
  }
  
  public static String a(int paramInt)
  {
    return BaseApplication.getContext().getResources().getString(paramInt);
  }
  
  private static String a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    EncryptUinHandler localEncryptUinHandler = new EncryptUinHandler((AppInterface)RIJQQAppInterfaceUtil.a());
    localEncryptUinHandler.a(new ReadInJoyUtils.1(paramSharedPreferences, paramString));
    return localEncryptUinHandler.a();
  }
  
  public static String a(Bitmap paramBitmap)
  {
    return a(paramBitmap, Bitmap.CompressFormat.PNG, 100);
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnull +166 -> 169
    //   6: new 121	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush 1024
    //   13: invokespecial 124	java/io/ByteArrayOutputStream:<init>	(I)V
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: aload 4
    //   26: invokevirtual 130	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   29: pop
    //   30: aload 4
    //   32: astore_3
    //   33: aload 4
    //   35: invokevirtual 134	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: iconst_2
    //   39: invokestatic 140	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload 4
    //   45: astore_1
    //   46: goto +127 -> 173
    //   49: astore_0
    //   50: goto +13 -> 63
    //   53: astore_0
    //   54: aconst_null
    //   55: astore_3
    //   56: goto +76 -> 132
    //   59: astore_0
    //   60: aconst_null
    //   61: astore 4
    //   63: aload 4
    //   65: astore_3
    //   66: aload_0
    //   67: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   70: aload 4
    //   72: astore_3
    //   73: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +15 -> 91
    //   79: aload 4
    //   81: astore_3
    //   82: ldc 151
    //   84: iconst_2
    //   85: ldc 153
    //   87: aload_0
    //   88: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload 4
    //   93: ifnull +36 -> 129
    //   96: aload 4
    //   98: invokevirtual 160	java/io/ByteArrayOutputStream:flush	()V
    //   101: aload 4
    //   103: invokevirtual 163	java/io/ByteArrayOutputStream:close	()V
    //   106: goto +23 -> 129
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   114: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +12 -> 129
    //   120: ldc 151
    //   122: iconst_2
    //   123: ldc 153
    //   125: aload_0
    //   126: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_0
    //   132: aload_3
    //   133: ifnull +34 -> 167
    //   136: aload_3
    //   137: invokevirtual 160	java/io/ByteArrayOutputStream:flush	()V
    //   140: aload_3
    //   141: invokevirtual 163	java/io/ByteArrayOutputStream:close	()V
    //   144: goto +23 -> 167
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   152: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +12 -> 167
    //   158: ldc 151
    //   160: iconst_2
    //   161: ldc 153
    //   163: aload_1
    //   164: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: aload_0
    //   168: athrow
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_3
    //   172: astore_1
    //   173: aload_1
    //   174: ifnull +33 -> 207
    //   177: aload_1
    //   178: invokevirtual 160	java/io/ByteArrayOutputStream:flush	()V
    //   181: aload_1
    //   182: invokevirtual 163	java/io/ByteArrayOutputStream:close	()V
    //   185: aload_0
    //   186: areturn
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   192: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +12 -> 207
    //   198: ldc 151
    //   200: iconst_2
    //   201: ldc 153
    //   203: aload_1
    //   204: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   207: aload_0
    //   208: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramBitmap	Bitmap
    //   0	209	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	209	2	paramInt	int
    //   1	171	3	localObject	Object
    //   16	86	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   21	30	49	java/lang/Exception
    //   33	43	49	java/lang/Exception
    //   6	18	53	finally
    //   6	18	59	java/lang/Exception
    //   96	106	109	java/io/IOException
    //   21	30	131	finally
    //   33	43	131	finally
    //   66	70	131	finally
    //   73	79	131	finally
    //   82	91	131	finally
    //   136	144	147	java/io/IOException
    //   177	185	187	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    return RIJAppSetting.a(paramString);
  }
  
  @Deprecated
  public static AppRuntime a()
  {
    return RIJQQAppInterfaceUtil.a();
  }
  
  public static void a()
  {
    com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.a = -1;
  }
  
  public static void a(int paramInt)
  {
    com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.a = paramInt;
  }
  
  public static void a(int paramInt, List<TopicInfo> paramList, String paramString)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TopicInfo localTopicInfo = (TopicInfo)paramList.next();
      if (localTopicInfo != null) {
        a("0X8009817", paramInt, localTopicInfo.a(), paramString);
      }
    }
  }
  
  public static void a(Context paramContext, RIJUserLevelDialog.DialogSettingInfo paramDialogSettingInfo)
  {
    if (paramContext == null)
    {
      QLog.d("ReadInJoyUtils", 1, "showErrorDialog! context is null!");
      return;
    }
    paramContext = new RIJUserLevelDialog(paramContext);
    paramContext.a(paramDialogSettingInfo);
    paramContext.show();
  }
  
  private static void a(View paramView, float[] paramArrayOfFloat)
  {
    if ((paramView instanceof VideoView))
    {
      paramView = (VideoView)paramView;
      paramArrayOfFloat[0] = ((float)paramView.getCurrentProgress());
      paramArrayOfFloat[1] = paramView.getCurrentRatio();
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean, View paramView)
  {
    float[] arrayOfFloat = new float[2];
    a(paramView, arrayOfFloat);
    ReadInJoyLogicEngineEventDispatcher.a().a(new ReadInJoyUtils.2(paramBoolean, paramAbsBaseArticleInfo, arrayOfFloat));
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    String str;
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          str = "-1";
        }
      }
    }
    for (;;)
    {
      break;
      str = "3";
      continue;
      str = "2";
      continue;
      str = "1";
    }
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, String.valueOf(paramLong), str, paramString2, "", false);
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("reportSelectedTopic error:");
        paramString2.append(paramString1.toString());
        QLog.e("ReadInJoyUtils", 1, paramString2.toString());
      }
    }
  }
  
  public static boolean a()
  {
    return (((Boolean)RIJSPUtils.a("preload_controller", Boolean.valueOf(true))).booleanValue()) && (ReadInJoyHelper.m());
  }
  
  public static boolean a(Context paramContext)
  {
    return RIJAppSetting.a(paramContext);
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    return RIJAppSetting.a(paramAppInterface);
  }
  
  public static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return RIJMergeKanDianMessage.a(paramAbsStructMsg);
  }
  
  public static boolean a(String paramString, long paramLong, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJFeedsType.a(paramString, paramLong, paramAbsBaseArticleInfo);
  }
  
  private static byte[] a(String paramString, int paramInt, Bundle paramBundle)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = paramString;
    localHttpNetReq.mHttpMethod = paramInt;
    if (paramBundle != null)
    {
      paramString = paramBundle.keySet().iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        Object localObject = paramBundle.get(str);
        if ((localObject instanceof String)) {
          localHttpNetReq.mReqProperties.put(str, (String)localObject);
        }
      }
    }
    return HttpEngineServiceImpl.transSync(localHttpNetReq).mRespData;
  }
  
  public static byte[] a(String paramString, int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    for (;;)
    {
      try
      {
        if (b()) {
          return a(paramString, paramInt, paramBundle2);
        }
        BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
        if (paramInt == 0)
        {
          str = "GET";
          paramString = HttpUtil.openUrlForByte(localBaseApplication, paramString, str, paramBundle1, paramBundle2);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramBundle1 = new StringBuilder();
        paramBundle1.append("sendHttpRequest error! msg=");
        paramBundle1.append(paramString);
        QLog.e("ReadInJoyUtils", 1, paramBundle1.toString());
        return null;
      }
      String str = "POST";
    }
  }
  
  public static Integer b(Context paramContext, String paramString)
  {
    return RIJJumpUtils.a(paramContext, paramString);
  }
  
  @Deprecated
  public static String b()
  {
    return RIJDeviceUtil.a();
  }
  
  public static void b() {}
  
  private static boolean b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(424);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("use_new_http_engine", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  @Deprecated
  public static String c()
  {
    return RIJDeviceUtil.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils
 * JD-Core Version:    0.7.0.1
 */