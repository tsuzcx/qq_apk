package cooperation.qzone.push;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.NotificationClickReceiver;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import cooperation.qzone.report.lp.LpReportInfo_dc01245;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class MsgNotification
{
  public static final String QCIRCLE_UNREADCOUND = "qzone_unreadcount";
  public static final int RING_TYPE_MSG_SOUND = 1;
  public static final int RING_TYPE_NO_SOUND = 0;
  public static final int RING_TYPE_SYSTEM_SOUND = 2;
  public static final String TAG = "MsgNotification";
  private static MsgNotification manager = null;
  
  public static void cleanQCirclePush()
  {
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (localQQNotificationManager != null)
    {
      localQQNotificationManager.cancel("MsgNotification", 3000532);
      localQQNotificationManager.cancel("MsgNotification", 3000533);
      localQQNotificationManager.cancel("MsgNotification", 3000534);
      localQQNotificationManager.cancel("MsgNotification", 3000535);
      localQQNotificationManager.cancel("MsgNotification", 3000536);
    }
    clearQCircleUnreadCount();
  }
  
  public static void clearQCircleUnreadCount()
  {
    LocalMultiProcConfig.putInt("qzone_unreadcount3000532", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000533", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000534", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000535", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000536", 0);
  }
  
  private Intent getBrowserIntent(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent(paramQQAppInterface.getApp(), QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", paramString);
    paramQQAppInterface.putExtra("injectrecommend", true);
    paramQQAppInterface.setData(Uri.parse(paramString));
    QZoneHelper.addSource(paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static MsgNotification getInstance()
  {
    if (manager == null) {
      manager = new MsgNotification();
    }
    return manager;
  }
  
  private Intent getMyFeedIntent(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = QZoneHelper.getQzoneMyFeedActivity(paramQQAppInterface.getApp());
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getAccount());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("FromNotification", true);
    localIntent.putExtras(paramQQAppInterface);
    localIntent.addFlags(67108864);
    localIntent.putExtra("src_type", "app");
    localIntent.putExtra("isFromQQ", "true");
    localIntent.putExtra("page", "tab_remind");
    localIntent.putExtra("version", "1");
    return localIntent;
  }
  
  private Intent getQZoneDetailIntent(String paramString)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localUri = Uri.parse(paramString);
        localBundle.putString("cellid", localUri.getQueryParameter("uid"));
        localObject = localUri.getQueryParameter("subid");
        if (paramString.contains("photonum"))
        {
          localHashMap = new HashMap();
          localHashMap.put(Integer.valueOf(7), localUri.getQueryParameter("photonum"));
          if (Integer.valueOf(localUri.getQueryParameter("photonum")).intValue() <= 1) {
            continue;
          }
          str = localUri.getQueryParameter("bid");
          localObject = str;
          if (paramString.contains("bid"))
          {
            localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
            localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
            localObject = str;
          }
          localBundle.putParcelable("businessparam", new MapParcelable(localHashMap));
        }
        localBundle.putString("subid", (String)localObject);
        localBundle.putLong("targetuin", Long.parseLong(localUri.getQueryParameter("uin")));
        localBundle.putInt("appid", Integer.parseInt(localUri.getQueryParameter("appid")));
      }
      catch (Exception paramString)
      {
        Uri localUri;
        Object localObject;
        HashMap localHashMap;
        String str;
        QLog.e("MsgNotification", 1, "getQZoneDetailIntent", paramString);
        continue;
      }
      paramString = QZoneHelper.getQZoneDetailActivity();
      paramString.putExtras(localBundle);
      return paramString;
      str = "";
      localObject = str;
      if (paramString.contains("bid"))
      {
        localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
        localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
        localObject = str;
      }
    }
  }
  
  private String getTitle(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (String str = paramString; paramInt == 0; str = BaseApplication.getContext().getString(2131719715)) {
      return str;
    }
    int i = getUnreadCount(paramInt);
    if (i <= 1) {
      return str;
    }
    if (paramInt == 3000532) {
      paramString = BaseApplication.getContext().getString(2131720384);
    }
    for (;;)
    {
      return str + "(" + BaseApplication.getContext().getString(2131693315) + i + BaseApplication.getContext().getString(2131719539) + paramString + ")";
      if (paramInt == 3000533)
      {
        paramString = BaseApplication.getContext().getString(2131720385);
      }
      else if (paramInt == 3000534)
      {
        paramString = BaseApplication.getContext().getString(2131720386);
      }
      else
      {
        if (paramInt != 3000535) {
          break;
        }
        paramString = BaseApplication.getContext().getString(2131720387);
      }
    }
    return str;
  }
  
  private Intent getTranslucentActivity(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramQQAppInterface, "com.qzone.misc.web.QZoneTranslucentActivity");
    paramQQAppInterface.setAction("action_js2qzone");
    paramQQAppInterface.putExtra("cmd", "Schema");
    paramQQAppInterface.putExtra("schema", paramString);
    return paramQQAppInterface;
  }
  
  private int getUnreadCount(int paramInt)
  {
    int i = LocalMultiProcConfig.getInt("qzone_unreadcount" + paramInt, 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount" + paramInt, i + 1);
    return i + 1;
  }
  
  private Intent getUserHomeIntent(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramQQAppInterface, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramQQAppInterface.putExtra("qqid", Long.parseLong(paramString));
    paramQQAppInterface.putExtra("qzone_entry", 0);
    return paramQQAppInterface;
  }
  
  private Intent getVipReminderIntent(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = QZoneHelper.getQzoneFriendFeedActivity(paramQQAppInterface.getApp());
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getAccount());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("FromNotification", true);
    localIntent.putExtras(paramQQAppInterface);
    localIntent.addFlags(67108864);
    localIntent.putExtra("vipReminderFlag", true);
    return localIntent;
  }
  
  private void playSound(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramInt != 0)) {}
    try
    {
      paramQQAppInterface.vibratorAndAudio();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("MsgNotification", 1, paramQQAppInterface, new Object[0]);
    }
  }
  
  private void pushArriveReport(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str2 = "";
    String str1 = str2;
    Uri localUri;
    if (paramString1 != null)
    {
      localUri = Uri.parse(paramString1);
      if (!TextUtils.isEmpty(localUri.getQueryParameter("from"))) {
        break label148;
      }
      str1 = str2;
      if (localUri.getPathSegments().size() > 0) {
        str1 = (String)localUri.getPathSegments().get(0);
      }
    }
    if (paramBoolean) {
      LpReportInfo_dc00420.report(10, 0, str1, paramString2, 1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("pushReport", 2, "EXPOSE: uin: " + paramQQAppInterface.getAccount() + " schema: " + paramString1 + " pushstatkey: " + paramString2 + " fake:" + paramBoolean);
      }
      return;
      label148:
      str1 = localUri.getQueryParameter("from");
      break;
      LpReportInfo_dc00420.report(2, 0, str1, paramString2, 1);
    }
  }
  
  private int pushTypeConvertToNotifyId(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return 0;
    case 1: 
    case 300: 
      return 241;
    case 2: 
      return 244;
    case 4: 
      return 242;
    case 8: 
      return 243;
    }
    switch (paramInt2)
    {
    default: 
      return 3000536;
    case 1: 
      return 3000532;
    case 2: 
      return 3000533;
    case 3: 
      return 3000534;
    }
    return 3000535;
  }
  
  private Intent wrapPluginIntent(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    paramQQAppInterface = new Intent(paramQQAppInterface.getApp(), TranslucentActivity.class);
    paramQQAppInterface.addFlags(268435456);
    if (paramIntent != null) {
      paramQQAppInterface.putExtras(paramIntent);
    }
    return paramQQAppInterface;
  }
  
  /* Error */
  public void showNewLocalPhotoNotification(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 66	android/content/Intent
    //   3: dup
    //   4: invokespecial 293	android/content/Intent:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc_w 295
    //   14: invokestatic 301	cooperation/qzone/QzonePluginProxyActivity:setActivityNameToIntent	(Landroid/content/Intent;Ljava/lang/String;)V
    //   17: aload 7
    //   19: ldc_w 303
    //   22: invokevirtual 306	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   25: pop
    //   26: aload 7
    //   28: ldc_w 308
    //   31: ldc_w 310
    //   34: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   37: pop
    //   38: aload 7
    //   40: ldc_w 312
    //   43: aload 4
    //   45: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   48: pop
    //   49: new 66	android/content/Intent
    //   52: dup
    //   53: aload_1
    //   54: ldc_w 393
    //   57: invokespecial 77	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   60: astore 4
    //   62: aload 4
    //   64: ldc_w 394
    //   67: invokevirtual 136	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   70: pop
    //   71: aload 4
    //   73: aload 7
    //   75: invokevirtual 397	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   78: pop
    //   79: aload 4
    //   81: ldc_w 405
    //   84: sipush 245
    //   87: invokevirtual 329	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   90: pop
    //   91: aload_1
    //   92: sipush 245
    //   95: aload 4
    //   97: ldc_w 406
    //   100: invokestatic 412	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   103: astore 9
    //   105: aload_1
    //   106: invokevirtual 418	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   109: ldc_w 419
    //   112: invokestatic 425	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   115: astore 4
    //   117: aload 4
    //   119: astore 7
    //   121: aload 4
    //   123: ifnull +75 -> 198
    //   126: aload 4
    //   128: astore 7
    //   130: getstatic 430	android/os/Build$VERSION:SDK_INT	I
    //   133: bipush 11
    //   135: if_icmplt +63 -> 198
    //   138: aload_1
    //   139: invokevirtual 418	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   142: ldc_w 431
    //   145: invokevirtual 436	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   148: istore 5
    //   150: aload_1
    //   151: invokevirtual 418	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   154: ldc_w 437
    //   157: invokevirtual 436	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   160: istore 6
    //   162: iload 5
    //   164: aload 4
    //   166: invokevirtual 442	android/graphics/Bitmap:getWidth	()I
    //   169: if_icmpne +17 -> 186
    //   172: aload 4
    //   174: astore 7
    //   176: iload 6
    //   178: aload 4
    //   180: invokevirtual 445	android/graphics/Bitmap:getHeight	()I
    //   183: if_icmpeq +15 -> 198
    //   186: aload 4
    //   188: iload 5
    //   190: iload 6
    //   192: iconst_0
    //   193: invokestatic 449	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   196: astore 7
    //   198: getstatic 454	com/tencent/mobileqq/utils/kapalaiadapter/MobileIssueSettings:e	Z
    //   201: ifne +175 -> 376
    //   204: invokestatic 459	cooperation/qzone/push/QZoneNotificationAdapter:getInstance	()Lcooperation/qzone/push/QZoneNotificationAdapter;
    //   207: aload 9
    //   209: aload_1
    //   210: aload 7
    //   212: aload_2
    //   213: aload_3
    //   214: ldc_w 460
    //   217: invokevirtual 464	cooperation/qzone/push/QZoneNotificationAdapter:newNotificationForMz	(Landroid/app/PendingIntent;Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)Landroid/app/Notification;
    //   220: astore_2
    //   221: aload_1
    //   222: iconst_0
    //   223: aload_2
    //   224: invokestatic 470	com/tencent/util/BadgeUtils:a	(Landroid/content/Context;ILandroid/app/Notification;)V
    //   227: invokestatic 35	com/tencent/commonsdk/util/notification/QQNotificationManager:getInstance	()Lcom/tencent/commonsdk/util/notification/QQNotificationManager;
    //   230: astore_1
    //   231: aload_1
    //   232: ifnull +14 -> 246
    //   235: aload_1
    //   236: ldc_w 472
    //   239: sipush 245
    //   242: aload_2
    //   243: invokevirtual 476	com/tencent/commonsdk/util/notification/QQNotificationManager:notify	(Ljava/lang/String;ILandroid/app/Notification;)V
    //   246: return
    //   247: astore 4
    //   249: invokestatic 370	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq +33 -> 285
    //   255: ldc 18
    //   257: iconst_2
    //   258: new 271	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 478
    //   268: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 4
    //   273: invokevirtual 479	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   276: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 481	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: aconst_null
    //   286: astore 4
    //   288: goto -171 -> 117
    //   291: astore 8
    //   293: aload_1
    //   294: invokevirtual 418	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   297: ldc_w 482
    //   300: invokestatic 425	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   303: astore 7
    //   305: aload 7
    //   307: astore 4
    //   309: ldc 18
    //   311: iconst_1
    //   312: ldc_w 484
    //   315: aload 8
    //   317: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: aload 4
    //   322: astore 7
    //   324: goto -126 -> 198
    //   327: astore 8
    //   329: aload 4
    //   331: astore 7
    //   333: invokestatic 370	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq -138 -> 198
    //   339: ldc 18
    //   341: iconst_2
    //   342: new 271	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 478
    //   352: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload 8
    //   357: invokevirtual 479	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   360: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 481	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload 4
    //   371: astore 7
    //   373: goto -175 -> 198
    //   376: ldc_w 486
    //   379: invokestatic 491	com/tencent/mobileqq/utils/DeviceInfoUtil:k	()Ljava/lang/String;
    //   382: invokevirtual 495	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   385: ifeq +23 -> 408
    //   388: invokestatic 459	cooperation/qzone/push/QZoneNotificationAdapter:getInstance	()Lcooperation/qzone/push/QZoneNotificationAdapter;
    //   391: aload 9
    //   393: aload_1
    //   394: aload 7
    //   396: aload_2
    //   397: aload_3
    //   398: ldc_w 460
    //   401: invokevirtual 498	cooperation/qzone/push/QZoneNotificationAdapter:newNotificationForOppo	(Landroid/app/PendingIntent;Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)Landroid/app/Notification;
    //   404: astore_2
    //   405: goto -184 -> 221
    //   408: invokestatic 459	cooperation/qzone/push/QZoneNotificationAdapter:getInstance	()Lcooperation/qzone/push/QZoneNotificationAdapter;
    //   411: aload 9
    //   413: aload_1
    //   414: aload 7
    //   416: aload_2
    //   417: aload_3
    //   418: ldc_w 460
    //   421: invokevirtual 501	cooperation/qzone/push/QZoneNotificationAdapter:buildNotification	(Landroid/app/PendingIntent;Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)Landroid/app/Notification;
    //   424: astore_2
    //   425: goto -204 -> 221
    //   428: astore_1
    //   429: ldc 18
    //   431: iconst_1
    //   432: ldc_w 503
    //   435: aload_1
    //   436: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   439: return
    //   440: astore 8
    //   442: goto -113 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	MsgNotification
    //   0	445	1	paramContext	android.content.Context
    //   0	445	2	paramString1	String
    //   0	445	3	paramString2	String
    //   0	445	4	paramString3	String
    //   148	41	5	i	int
    //   160	31	6	j	int
    //   7	408	7	localObject	Object
    //   291	25	8	localThrowable	Throwable
    //   327	29	8	localOutOfMemoryError1	OutOfMemoryError
    //   440	1	8	localOutOfMemoryError2	OutOfMemoryError
    //   103	309	9	localPendingIntent	PendingIntent
    // Exception table:
    //   from	to	target	type
    //   105	117	247	java/lang/OutOfMemoryError
    //   130	172	291	java/lang/Throwable
    //   176	186	291	java/lang/Throwable
    //   186	198	291	java/lang/Throwable
    //   309	320	327	java/lang/OutOfMemoryError
    //   227	231	428	java/lang/Exception
    //   235	246	428	java/lang/Exception
    //   293	305	440	java/lang/OutOfMemoryError
  }
  
  public void showQZoneMsgNotification(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, String paramString5, String paramString6, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    if (paramQQAppInterface == null) {}
    AppRuntime.Status localStatus;
    label25:
    do
    {
      return;
      localStatus = paramQQAppInterface.getOnlineStatus();
      if (localStatus == AppRuntime.Status.dnd) {
        break;
      }
      playSound(paramInt1, paramQQAppInterface);
    } while (FriendsStatusUtil.a(paramQQAppInterface.getApp()));
    playSound(paramInt1, paramQQAppInterface);
    paramInt1 = 1;
    Object localObject3 = (QZoneManagerImp)paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    Object localObject1;
    switch (paramInt2)
    {
    default: 
      localObject1 = null;
    }
    label898:
    label1557:
    label1560:
    for (;;)
    {
      label119:
      int i = pushTypeConvertToNotifyId(paramInt2, paramInt3);
      localObject3 = new Intent();
      ((Intent)localObject3).setClass(paramQQAppInterface.getApp(), NotificationClickReceiver.class);
      ((Intent)localObject3).putExtra("realIntent", (Parcelable)localObject1);
      ((Intent)localObject3).putExtra("hostuin", paramQQAppInterface.getAccount());
      ((Intent)localObject3).putExtra("pushschema", paramString5);
      ((Intent)localObject3).putExtra("pushstatkey", paramString6);
      ((Intent)localObject3).putExtra("param_notifyid", i);
      Object localObject4 = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), i, (Intent)localObject3, 134217728);
      label240:
      Object localObject5;
      if (paramInt2 == 366)
      {
        paramString1 = getTitle(paramString1, i);
        paramInt3 = 2130847884;
        localObject1 = null;
        localObject3 = null;
        if (paramInt2 != 8) {
          break label1082;
        }
        localObject5 = NewMsgNotificationManager.a(paramQQAppInterface);
        localObject1 = localObject3;
        if (((NewMsgNotificationManager)localObject5).a(paramString3, paramString4)) {
          localObject1 = ((NewMsgNotificationManager)localObject5).a(paramString3, paramString4, null);
        }
        paramString3 = (String)localObject1;
        label296:
        if (MobileIssueSettings.e) {
          break label1390;
        }
        paramString1 = QZoneNotificationAdapter.getInstance().newNotificationForMz((PendingIntent)localObject4, paramQQAppInterface.getApp(), paramString3, paramString1, paramString2, paramInt3);
      }
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              if ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 300))
              {
                paramString2 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
                paramString2.setPackage(MobileQQ.getContext().getPackageName());
                paramString2.putExtra("pushstatkey", paramString6);
                paramString2.putExtra("mergenum", paramInt1);
                paramString2.putExtra("pushtype", paramInt2);
                paramString1.deleteIntent = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), i, paramString2, 134217728);
              }
              BadgeUtils.a(paramQQAppInterface.getApp(), 0, paramString1);
              if (localStatus != AppRuntime.Status.dnd) {
                break label1448;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("MsgNotification", 2, "showQZoneMsgNotification, dnd shield hide notify");
              return;
              if (!QLog.isColorLevel()) {
                break label25;
              }
              QLog.d("MsgNotification", 2, "showQZoneMsgNotification, dnd shield sound");
              break label25;
              localObject1 = getMyFeedIntent(paramQQAppInterface);
              ((Intent)localObject1).putExtra("launch_time", System.currentTimeMillis());
              ((Intent)localObject1).putExtra("refer", "msg_notification");
              ((Intent)localObject1).putExtra("fling_action_key", 2);
              ((Intent)localObject1).putExtra("fling_code_key", hashCode());
              localObject1 = wrapPluginIntent(paramQQAppInterface, (Intent)localObject1);
              if (localObject3 == null) {
                break label1560;
              }
              paramInt1 = ((QZoneManagerImp)localObject3).a(1);
              ((QZoneManagerImp)localObject3).a(1, paramInt1);
              if (paramInt1 > 0) {
                break label1557;
              }
              paramInt1 = 1;
              break label119;
              localObject1 = wrapPluginIntent(paramQQAppInterface, getQZoneDetailIntent(paramString5));
              break label119;
              try
              {
                for (;;)
                {
                  localObject3 = getTranslucentActivity(paramQQAppInterface, paramString5);
                  localObject1 = localObject3;
                  try
                  {
                    for (;;)
                    {
                      localObject3 = wrapPluginIntent(paramQQAppInterface, (Intent)localObject3);
                      if (paramBoolean2)
                      {
                        localObject1 = localObject3;
                        localObject4 = new QZoneClickReport.ReportInfo();
                        localObject1 = localObject3;
                        ((QZoneClickReport.ReportInfo)localObject4).actionType = String.valueOf(322);
                        localObject1 = localObject3;
                        ((QZoneClickReport.ReportInfo)localObject4).subactionType = String.valueOf(2);
                        localObject1 = localObject3;
                        ((QZoneClickReport.ReportInfo)localObject4).reserves = String.valueOf(6);
                        localObject1 = localObject3;
                        QZoneClickReport.report(paramQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject4, true);
                      }
                      localObject1 = localObject3;
                      localObject4 = Uri.parse(paramString5);
                      localObject1 = localObject3;
                      localObject5 = new QzNotificationStruct(((Uri)localObject4).getQueryParameter("room"), paramString2, paramBoolean1, paramInt2, paramString5, paramString6);
                      localObject1 = localObject3;
                      if (CliNotifyPush.a == null)
                      {
                        localObject1 = localObject3;
                        CliNotifyPush.a = Collections.synchronizedList(new ArrayList());
                      }
                      if (paramBoolean2)
                      {
                        localObject1 = localObject3;
                        CliNotifyPush.a.add(localObject5);
                      }
                      try
                      {
                        LpReportInfo_dc01245.report(Long.parseLong(((Uri)localObject4).getQueryParameter("uin")), Long.parseLong(BaseApplicationImpl.getApplication().getRuntime().getAccount()), 11, 0);
                        localObject1 = localObject3;
                      }
                      catch (Exception localException5)
                      {
                        for (;;)
                        {
                          localObject1 = localObject3;
                          QLog.e("MsgNotification", 1, localException5.getStackTrace());
                        }
                      }
                    }
                    QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_LIVE error", localException1);
                  }
                  catch (Exception localException1) {}
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  Intent localIntent;
                  Bitmap localBitmap;
                  int j;
                  int k;
                  Object localObject2 = null;
                }
              }
            }
            break label119;
            if ((paramString5 == null) || (!paramString5.startsWith("mqzonev2://arouse/openhomepage"))) {
              break label898;
            }
            try
            {
              localObject1 = getUserHomeIntent(paramQQAppInterface, Uri.parse(paramString5).getQueryParameter("uin"));
            }
            catch (Exception localException2)
            {
              try
              {
                localIntent = wrapPluginIntent(paramQQAppInterface, (Intent)localObject1);
                localObject1 = localIntent;
              }
              catch (Exception localException3)
              {
                break label884;
              }
              localException2 = localException2;
              localObject1 = null;
            }
          }
          label884:
          QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_SCHEMA error", localException2);
          break label119;
          localObject1 = wrapPluginIntent(paramQQAppInterface, getTranslucentActivity(paramQQAppInterface, paramString5));
          break label119;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("type", 2);
          break label119;
          if ((!TextUtils.isEmpty(paramString1)) && (paramInt2 == 8)) {
            break label240;
          }
          if (paramBoolean1)
          {
            if ((paramInt2 == 2) || (paramInt2 == 8) || (paramInt2 == 4))
            {
              paramString1 = BaseApplication.getContext().getString(2131718685);
              break label240;
            }
            paramString1 = BaseApplication.getContext().getString(2131718685) + "(" + BaseApplication.getContext().getString(2131693315) + paramInt1 + BaseApplication.getContext().getString(2131719539) + BaseApplication.getContext().getString(2131720383) + ")";
            break label240;
          }
          paramString1 = BaseApplication.getContext().getString(2131718685);
          break label240;
          label1082:
          if (paramInt2 == 366)
          {
            paramInt3 = 2130841588;
            localBitmap = BitmapManager.a(paramQQAppInterface.getApp().getResources(), 2130844197);
            localObject5 = NewMsgNotificationManager.a(paramQQAppInterface);
            localObject1 = localBitmap;
            if (((NewMsgNotificationManager)localObject5).a(paramString3, paramString4)) {
              localObject1 = ((NewMsgNotificationManager)localObject5).a(paramString3, paramString4, localBitmap);
            }
            paramString3 = (String)localObject1;
            break label296;
          }
          try
          {
            paramString3 = BitmapFactory.decodeResource(paramQQAppInterface.getApp().getResources(), 2130848891);
            paramString4 = paramString3;
            if (paramString3 != null) {
              paramString4 = paramString3;
            }
          }
          catch (OutOfMemoryError paramString4)
          {
            try
            {
              do
              {
                if (Build.VERSION.SDK_INT >= 11)
                {
                  j = paramQQAppInterface.getApp().getResources().getDimensionPixelSize(17104901);
                  k = paramQQAppInterface.getApp().getResources().getDimensionPixelSize(17104902);
                  if (j == paramString3.getWidth())
                  {
                    paramString4 = paramString3;
                    if (k == paramString3.getHeight()) {}
                  }
                  else
                  {
                    paramString4 = Bitmap.createScaledBitmap(paramString3, j, k, false);
                  }
                }
                paramString3 = paramString4;
                break;
                paramString4 = paramString4;
                paramString3 = (String)localObject1;
              } while (!QLog.isColorLevel());
              QLog.e("MsgNotification", 2, "Exception:" + paramString4.toString());
              paramString3 = (String)localObject1;
            }
            catch (Throwable localThrowable)
            {
              try
              {
                paramString4 = BitmapFactory.decodeResource(paramQQAppInterface.getApp().getResources(), 2130848764);
                paramString3 = paramString4;
                QLog.e("MsgNotification", 1, "use small icon ,exp:", localThrowable);
                paramString3 = paramString4;
              }
              catch (OutOfMemoryError paramString4)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("MsgNotification", 2, "Exception:" + paramString4.toString());
                }
              }
            }
          }
        }
        break label296;
        label1390:
        if ("oppo".equalsIgnoreCase(DeviceInfoUtil.k())) {
          paramString1 = QZoneNotificationAdapter.getInstance().newNotificationForOppo(localException5, paramQQAppInterface.getApp(), paramString3, paramString1, paramString2, paramInt3);
        } else {
          paramString1 = QZoneNotificationAdapter.getInstance().buildNotification(localException5, paramQQAppInterface.getApp(), paramString3, paramString1, paramString2, paramInt3);
        }
      }
      label1448:
      if (paramBoolean3) {
        try
        {
          pushArriveReport(paramQQAppInterface, paramString5, paramString6, true);
          return;
        }
        catch (Exception paramString1)
        {
          QLog.e("MsgNotification", 1, "MsgNotification.showQZoneMsgNotification notify exception ", paramString1);
        }
      }
      for (;;)
      {
        if (paramQQAppInterface != null)
        {
          QZoneHelper.preloadQzone(paramQQAppInterface, getClass().getSimpleName());
          if (GuardManager.a != null) {
            GuardManager.a.b(0, null);
          }
        }
        if (!paramBoolean2) {
          break;
        }
        pushArriveReport(paramQQAppInterface, paramString5, paramString6, false);
        return;
        paramString2 = QQNotificationManager.getInstance();
        if (paramString2 != null) {
          paramString2.notify("MsgNotification.showQZoneMsgNotification", i, paramString1);
        }
      }
    }
  }
  
  public void updateUnreadcount(int paramInt1, int paramInt2)
  {
    paramInt1 = pushTypeConvertToNotifyId(paramInt1, paramInt2);
    LocalMultiProcConfig.putInt("qzone_unreadcount" + paramInt1, LocalMultiProcConfig.getInt("qzone_unreadcount" + paramInt1, 0) + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.push.MsgNotification
 * JD-Core Version:    0.7.0.1
 */