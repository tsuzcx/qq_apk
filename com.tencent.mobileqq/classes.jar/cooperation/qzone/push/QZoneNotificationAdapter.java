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
          break label374;
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
          if (paramBitmap != null) {
            localObject1 = paramBitmap;
          }
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
          label374:
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
    //   66: if_icmplt +68 -> 134
    //   69: aload 8
    //   71: invokevirtual 150	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   74: astore_3
    //   75: aload_3
    //   76: ifnull +14 -> 90
    //   79: aload_3
    //   80: astore 7
    //   82: aload_3
    //   83: aload_0
    //   84: getfield 16	cooperation/qzone/push/QZoneNotificationAdapter:channelId	Ljava/lang/String;
    //   87: invokestatic 156	com/tencent/commonsdk/util/notification/QQNotificationManager:addChannelIfNeed	(Landroid/app/Notification;Ljava/lang/String;)V
    //   90: aload_3
    //   91: astore 7
    //   93: aload_3
    //   94: ifnonnull +37 -> 131
    //   97: new 158	android/app/Notification
    //   100: dup
    //   101: iload 6
    //   103: aload 5
    //   105: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   108: invokespecial 161	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   111: astore 7
    //   113: aload 7
    //   115: bipush 16
    //   117: putfield 164	android/app/Notification:flags	I
    //   120: aload 7
    //   122: aload_2
    //   123: aload 4
    //   125: aload 5
    //   127: aload_1
    //   128: invokevirtual 168	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   131: aload 7
    //   133: areturn
    //   134: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   137: bipush 16
    //   139: if_icmpge +139 -> 278
    //   142: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   145: bipush 11
    //   147: if_icmplt +131 -> 278
    //   150: aload 8
    //   152: invokevirtual 171	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   155: astore_3
    //   156: goto -81 -> 75
    //   159: astore 8
    //   161: aconst_null
    //   162: astore_3
    //   163: aload_3
    //   164: astore 7
    //   166: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +18 -> 187
    //   172: aload_3
    //   173: astore 7
    //   175: ldc 186
    //   177: iconst_2
    //   178: aload 8
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   187: aload_3
    //   188: astore 7
    //   190: aload_3
    //   191: ifnonnull -60 -> 131
    //   194: new 158	android/app/Notification
    //   197: dup
    //   198: iload 6
    //   200: aload 5
    //   202: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   205: invokespecial 161	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   208: astore_3
    //   209: aload_3
    //   210: bipush 16
    //   212: putfield 164	android/app/Notification:flags	I
    //   215: aload_3
    //   216: aload_2
    //   217: aload 4
    //   219: aload 5
    //   221: aload_1
    //   222: invokevirtual 168	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   225: aload_3
    //   226: areturn
    //   227: astore_3
    //   228: aload 7
    //   230: ifnonnull +37 -> 267
    //   233: new 158	android/app/Notification
    //   236: dup
    //   237: iload 6
    //   239: aload 5
    //   241: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   244: invokespecial 161	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   247: astore 7
    //   249: aload 7
    //   251: bipush 16
    //   253: putfield 164	android/app/Notification:flags	I
    //   256: aload 7
    //   258: aload_2
    //   259: aload 4
    //   261: aload 5
    //   263: aload_1
    //   264: invokevirtual 168	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   267: aload_3
    //   268: athrow
    //   269: astore_3
    //   270: goto -42 -> 228
    //   273: astore 8
    //   275: goto -112 -> 163
    //   278: aconst_null
    //   279: astore_3
    //   280: goto -205 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	QZoneNotificationAdapter
    //   0	283	1	paramPendingIntent	PendingIntent
    //   0	283	2	paramContext	Context
    //   0	283	3	paramBitmap	Bitmap
    //   0	283	4	paramString1	String
    //   0	283	5	paramString2	String
    //   0	283	6	paramInt	int
    //   1	256	7	localObject	Object
    //   11	140	8	localBuilder	Notification.Builder
    //   159	20	8	localThrowable1	Throwable
    //   273	1	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	50	159	java/lang/Throwable
    //   54	61	159	java/lang/Throwable
    //   61	75	159	java/lang/Throwable
    //   134	156	159	java/lang/Throwable
    //   3	50	227	finally
    //   54	61	227	finally
    //   61	75	227	finally
    //   134	156	227	finally
    //   82	90	269	finally
    //   166	172	269	finally
    //   175	187	269	finally
    //   82	90	273	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.push.QZoneNotificationAdapter
 * JD-Core Version:    0.7.0.1
 */