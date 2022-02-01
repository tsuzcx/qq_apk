package cooperation.qzone.push;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class QZoneNotificationAdapter
{
  private static volatile QZoneNotificationAdapter notificationAdapter;
  private String channelId = "CHANNEL_ID_SHOW_BADGE";
  
  public static QZoneNotificationAdapter getInstance()
  {
    if (notificationAdapter == null) {}
    try
    {
      if (notificationAdapter == null) {
        notificationAdapter = new QZoneNotificationAdapter();
      }
      return notificationAdapter;
    }
    finally {}
  }
  
  public Notification buildNotification(PendingIntent paramPendingIntent, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, int paramInt)
  {
    paramContext = new NotificationCompat.Builder(paramContext).setSmallIcon(paramInt).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString2);
    paramContext.setContentTitle(paramString1).setContentText(paramString2).setContentIntent(paramPendingIntent);
    if ((SdkInfoUtil.isOreo()) && (SdkInfoUtil.isTargetSDKOreo())) {
      paramContext.setChannelId(this.channelId);
    }
    if (paramBitmap != null) {
      paramContext.setLargeIcon(paramBitmap);
    }
    return paramContext.build();
  }
  
  @TargetApi(16)
  public Notification newNotificationForMz(PendingIntent paramPendingIntent, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, int paramInt)
  {
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject1 = localObject5;
    for (;;)
    {
      try
      {
        localBuilder = new Notification.Builder(paramContext);
        localObject1 = localObject5;
        Method localMethod = Class.forName("android.app.Notification$Builder").getDeclaredMethod("setInternalApp", new Class[] { Integer.TYPE });
        if (localMethod == null) {
          break label370;
        }
        localObject1 = localObject5;
        localMethod.invoke(localBuilder, new Object[] { Integer.valueOf(1) });
        localObject1 = localObject5;
        localBuilder.setContentIntent(paramPendingIntent).setSmallIcon(paramInt).setWhen(System.currentTimeMillis()).setAutoCancel(true).setTicker(paramString2).setContentTitle(paramString1).setContentText(paramString2);
        if (paramBitmap != null)
        {
          localObject1 = localObject5;
          localBuilder.setLargeIcon(paramBitmap);
        }
        localObject1 = localObject5;
        if (Build.VERSION.SDK_INT >= 16)
        {
          localObject1 = localObject5;
          paramBitmap = localBuilder.build();
          localObject1 = paramBitmap;
        }
      }
      catch (Throwable localThrowable1)
      {
        Notification.Builder localBuilder;
        paramBitmap = null;
      }
      finally
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("QZoneNotification.newNotificationForMeizu", 2, localThrowable1, new Object[0]);
          }
          localObject2 = paramBitmap;
          if (paramBitmap != null) {
            continue;
          }
          paramBitmap = new Notification(paramInt, paramString2, System.currentTimeMillis());
          paramBitmap.flags = 16;
          paramBitmap.setLatestEventInfo(paramContext, paramString1, paramString2, paramPendingIntent);
          return paramBitmap;
        }
        finally
        {
          Object localObject2 = paramBitmap;
          paramBitmap = localObject4;
        }
        paramBitmap = finally;
        if (localObject2 == null)
        {
          localObject2 = new Notification(paramInt, paramString2, System.currentTimeMillis());
          ((Notification)localObject2).flags = 16;
          ((Notification)localObject2).setLatestEventInfo(paramContext, paramString1, paramString2, paramPendingIntent);
        }
      }
      try
      {
        QQNotificationManager.addChannelIfNeed(paramBitmap, this.channelId);
        localObject1 = paramBitmap;
        if (paramBitmap == null)
        {
          localObject1 = new Notification(paramInt, paramString2, System.currentTimeMillis());
          ((Notification)localObject1).flags = 16;
          ((Notification)localObject1).setLatestEventInfo(paramContext, paramString1, paramString2, paramPendingIntent);
        }
        return localObject1;
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      paramBitmap = localObject3;
      localObject1 = localObject5;
      if (Build.VERSION.SDK_INT < 16)
      {
        paramBitmap = localObject3;
        localObject1 = localObject5;
        if (Build.VERSION.SDK_INT >= 11)
        {
          localObject1 = localObject5;
          paramBitmap = localBuilder.getNotification();
          continue;
          label370:
          paramBitmap = null;
        }
      }
    }
  }
  
  /* Error */
  @TargetApi(16)
  public Notification newNotificationForOppo(PendingIntent paramPendingIntent, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 90	android/app/Notification$Builder
    //   6: dup
    //   7: aload_2
    //   8: invokespecial 91	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   11: astore 8
    //   13: aload 8
    //   15: aload_1
    //   16: invokevirtual 124	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   19: iload 6
    //   21: invokevirtual 127	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   24: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   27: invokevirtual 130	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   30: iconst_1
    //   31: invokevirtual 133	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   34: aload 5
    //   36: invokevirtual 136	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   39: aload 4
    //   41: invokevirtual 138	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   44: aload 5
    //   46: invokevirtual 140	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   49: pop
    //   50: aload_3
    //   51: ifnull +10 -> 61
    //   54: aload 8
    //   56: aload_3
    //   57: invokevirtual 143	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   60: pop
    //   61: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   64: bipush 16
    //   66: if_icmplt +64 -> 130
    //   69: aload 8
    //   71: invokevirtual 150	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   74: astore_3
    //   75: aload_3
    //   76: astore 7
    //   78: aload_3
    //   79: aload_0
    //   80: getfield 16	cooperation/qzone/push/QZoneNotificationAdapter:channelId	Ljava/lang/String;
    //   83: invokestatic 156	com/tencent/commonsdk/util/notification/QQNotificationManager:addChannelIfNeed	(Landroid/app/Notification;Ljava/lang/String;)V
    //   86: aload_3
    //   87: astore 7
    //   89: aload_3
    //   90: ifnonnull +37 -> 127
    //   93: new 158	android/app/Notification
    //   96: dup
    //   97: iload 6
    //   99: aload 5
    //   101: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   104: invokespecial 161	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   107: astore 7
    //   109: aload 7
    //   111: bipush 16
    //   113: putfield 164	android/app/Notification:flags	I
    //   116: aload 7
    //   118: aload_2
    //   119: aload 4
    //   121: aload 5
    //   123: aload_1
    //   124: invokevirtual 168	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   127: aload 7
    //   129: areturn
    //   130: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   133: bipush 16
    //   135: if_icmpge +139 -> 274
    //   138: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   141: bipush 11
    //   143: if_icmplt +131 -> 274
    //   146: aload 8
    //   148: invokevirtual 171	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   151: astore_3
    //   152: goto -77 -> 75
    //   155: astore 8
    //   157: aconst_null
    //   158: astore_3
    //   159: aload_3
    //   160: astore 7
    //   162: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +18 -> 183
    //   168: aload_3
    //   169: astore 7
    //   171: ldc 186
    //   173: iconst_2
    //   174: aload 8
    //   176: iconst_0
    //   177: anewarray 4	java/lang/Object
    //   180: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   183: aload_3
    //   184: astore 7
    //   186: aload_3
    //   187: ifnonnull -60 -> 127
    //   190: new 158	android/app/Notification
    //   193: dup
    //   194: iload 6
    //   196: aload 5
    //   198: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   201: invokespecial 161	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   204: astore_3
    //   205: aload_3
    //   206: bipush 16
    //   208: putfield 164	android/app/Notification:flags	I
    //   211: aload_3
    //   212: aload_2
    //   213: aload 4
    //   215: aload 5
    //   217: aload_1
    //   218: invokevirtual 168	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   221: aload_3
    //   222: areturn
    //   223: astore_3
    //   224: aload 7
    //   226: ifnonnull +37 -> 263
    //   229: new 158	android/app/Notification
    //   232: dup
    //   233: iload 6
    //   235: aload 5
    //   237: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   240: invokespecial 161	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   243: astore 7
    //   245: aload 7
    //   247: bipush 16
    //   249: putfield 164	android/app/Notification:flags	I
    //   252: aload 7
    //   254: aload_2
    //   255: aload 4
    //   257: aload 5
    //   259: aload_1
    //   260: invokevirtual 168	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   263: aload_3
    //   264: athrow
    //   265: astore_3
    //   266: goto -42 -> 224
    //   269: astore 8
    //   271: goto -112 -> 159
    //   274: aconst_null
    //   275: astore_3
    //   276: goto -201 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	QZoneNotificationAdapter
    //   0	279	1	paramPendingIntent	PendingIntent
    //   0	279	2	paramContext	Context
    //   0	279	3	paramBitmap	Bitmap
    //   0	279	4	paramString1	String
    //   0	279	5	paramString2	String
    //   0	279	6	paramInt	int
    //   1	252	7	localObject	Object
    //   11	136	8	localBuilder	Notification.Builder
    //   155	20	8	localThrowable1	Throwable
    //   269	1	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	50	155	java/lang/Throwable
    //   54	61	155	java/lang/Throwable
    //   61	75	155	java/lang/Throwable
    //   130	152	155	java/lang/Throwable
    //   3	50	223	finally
    //   54	61	223	finally
    //   61	75	223	finally
    //   130	152	223	finally
    //   78	86	265	finally
    //   162	168	265	finally
    //   171	183	265	finally
    //   78	86	269	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.push.QZoneNotificationAdapter
 * JD-Core Version:    0.7.0.1
 */