package com.tencent.mobileqq.utils.kapalaiadapter;

import akop;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotificationFactory;
import java.lang.reflect.Method;

public class KapalaiAdapterUtil
{
  private DualSimManager a = DualSimManager.a();
  
  public static KapalaiAdapterUtil a()
  {
    return akop.a;
  }
  
  public int a()
  {
    return 1;
  }
  
  @TargetApi(16)
  public Notification a(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          paramContext = NotificationFactory.a("CHANNEL_ID_HIDE_BADGE", paramInt, null, System.currentTimeMillis());
          localObject = paramContext;
          if (paramContext == null) {
            localObject = NotificationFactory.a("CHANNEL_ID_HIDE_BADGE", paramInt, null, System.currentTimeMillis());
          }
          return localObject;
        }
        paramContext = NotificationFactory.a("CHANNEL_ID_HIDE_BADGE");
        Object localObject = Class.forName("android.app.Notification$Builder").getDeclaredMethod("setInternalApp", new Class[] { Integer.TYPE });
        if (localObject != null)
        {
          ((Method)localObject).invoke(paramContext, new Object[] { Integer.valueOf(1) });
          if (Build.VERSION.SDK_INT >= 16)
          {
            paramContext = paramContext.build();
            continue;
          }
          if ((Build.VERSION.SDK_INT < 16) && (Build.VERSION.SDK_INT >= 11))
          {
            paramContext = paramContext.getNotification();
            continue;
            return null;
          }
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("newNotificationForMeizu", 2, paramContext.getMessage());
        }
        if (0 == 0) {
          return NotificationFactory.a("CHANNEL_ID_HIDE_BADGE", paramInt, null, System.currentTimeMillis());
        }
      }
      finally
      {
        if (0 == 0) {
          NotificationFactory.a("CHANNEL_ID_HIDE_BADGE", paramInt, null, System.currentTimeMillis());
        }
      }
      paramContext = null;
    }
  }
  
  /* Error */
  @TargetApi(16)
  public Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload 7
    //   2: invokevirtual 116	com/tencent/mobileqq/app/QQAppInterface:a	()Z
    //   5: istore 10
    //   7: invokestatic 122	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: iconst_0
    //   11: aload_1
    //   12: ldc 123
    //   14: invokestatic 129	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   17: astore 11
    //   19: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +29 -> 51
    //   25: ldc 131
    //   27: iconst_2
    //   28: new 133	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   35: ldc 136
    //   37: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 11
    //   42: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: ldc 150
    //   53: istore 9
    //   55: aload_1
    //   56: ldc 152
    //   58: iconst_m1
    //   59: invokevirtual 158	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   62: sipush 1008
    //   65: if_icmpne +149 -> 214
    //   68: getstatic 164	com/tencent/mobileqq/app/AppConstants:t	Ljava/lang/String;
    //   71: aload_1
    //   72: ldc 166
    //   74: invokevirtual 170	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +127 -> 207
    //   83: iload 9
    //   85: istore 8
    //   87: aload_1
    //   88: ldc 178
    //   90: iconst_0
    //   91: invokevirtual 182	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   94: ifeq +7 -> 101
    //   97: ldc 183
    //   99: istore 8
    //   101: getstatic 39	android/os/Build$VERSION:SDK_INT	I
    //   104: bipush 11
    //   106: if_icmpge +205 -> 311
    //   109: new 185	android/app/Notification
    //   112: dup
    //   113: iload 8
    //   115: aload_3
    //   116: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   119: invokespecial 188	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   122: astore_1
    //   123: aload_1
    //   124: aload 11
    //   126: putfield 192	android/app/Notification:contentIntent	Landroid/app/PendingIntent;
    //   129: iload 10
    //   131: ifeq +24 -> 155
    //   134: aload_1
    //   135: aload_1
    //   136: getfield 195	android/app/Notification:flags	I
    //   139: bipush 32
    //   141: ior
    //   142: putfield 195	android/app/Notification:flags	I
    //   145: aload_1
    //   146: aload_1
    //   147: getfield 195	android/app/Notification:flags	I
    //   150: iconst_2
    //   151: ior
    //   152: putfield 195	android/app/Notification:flags	I
    //   155: invokestatic 122	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   158: aload 7
    //   160: invokestatic 200	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   163: ifeq +42 -> 205
    //   166: invokestatic 206	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   169: bipush 11
    //   171: invokevirtual 210	java/util/Calendar:get	(I)I
    //   174: pop
    //   175: aload_1
    //   176: aload_1
    //   177: getfield 195	android/app/Notification:flags	I
    //   180: iconst_1
    //   181: ior
    //   182: putfield 195	android/app/Notification:flags	I
    //   185: aload_1
    //   186: ldc 211
    //   188: putfield 214	android/app/Notification:ledARGB	I
    //   191: aload_1
    //   192: sipush 2000
    //   195: putfield 217	android/app/Notification:ledOffMS	I
    //   198: aload_1
    //   199: sipush 2000
    //   202: putfield 220	android/app/Notification:ledOnMS	I
    //   205: aload_1
    //   206: areturn
    //   207: ldc 221
    //   209: istore 8
    //   211: goto -124 -> 87
    //   214: aload_1
    //   215: ldc 152
    //   217: iconst_m1
    //   218: invokevirtual 158	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   221: sipush 1010
    //   224: if_icmpne +28 -> 252
    //   227: getstatic 224	com/tencent/mobileqq/app/AppConstants:X	Ljava/lang/String;
    //   230: invokestatic 227	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   233: aload_1
    //   234: ldc 166
    //   236: invokevirtual 170	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   239: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   242: ifeq +10 -> 252
    //   245: ldc 228
    //   247: istore 8
    //   249: goto -162 -> 87
    //   252: aload_1
    //   253: ldc 152
    //   255: iconst_m1
    //   256: invokevirtual 158	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   259: sipush 1001
    //   262: if_icmpeq +20 -> 282
    //   265: iload 9
    //   267: istore 8
    //   269: aload_1
    //   270: ldc 152
    //   272: iconst_m1
    //   273: invokevirtual 158	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   276: sipush 10002
    //   279: if_icmpne -192 -> 87
    //   282: iload 9
    //   284: istore 8
    //   286: getstatic 231	com/tencent/mobileqq/app/AppConstants:G	Ljava/lang/String;
    //   289: invokestatic 227	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   292: aload_1
    //   293: ldc 166
    //   295: invokevirtual 170	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   298: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: ifeq -214 -> 87
    //   304: ldc 232
    //   306: istore 8
    //   308: goto -221 -> 87
    //   311: new 87	android/app/Notification$Builder
    //   314: dup
    //   315: invokestatic 122	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   318: invokespecial 235	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   321: iload 8
    //   323: invokevirtual 239	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   326: iconst_1
    //   327: invokevirtual 243	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   330: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   333: invokevirtual 247	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   336: aload_3
    //   337: invokevirtual 251	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   340: astore_1
    //   341: iload 10
    //   343: ifeq +9 -> 352
    //   346: aload_1
    //   347: iconst_1
    //   348: invokevirtual 254	android/app/Notification$Builder:setOngoing	(Z)Landroid/app/Notification$Builder;
    //   351: pop
    //   352: ldc 57
    //   354: invokestatic 63	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   357: ldc 65
    //   359: iconst_1
    //   360: anewarray 59	java/lang/Class
    //   363: dup
    //   364: iconst_0
    //   365: getstatic 71	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   368: aastore
    //   369: invokevirtual 75	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   372: astore 12
    //   374: aload 12
    //   376: ifnull +21 -> 397
    //   379: aload 12
    //   381: aload_1
    //   382: iconst_1
    //   383: anewarray 4	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: iconst_1
    //   389: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   392: aastore
    //   393: invokevirtual 85	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   396: pop
    //   397: invokestatic 122	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   400: aload 7
    //   402: invokestatic 200	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   405: ifeq +25 -> 430
    //   408: invokestatic 206	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   411: bipush 11
    //   413: invokevirtual 210	java/util/Calendar:get	(I)I
    //   416: pop
    //   417: aload_1
    //   418: ldc 211
    //   420: sipush 2000
    //   423: sipush 2000
    //   426: invokevirtual 258	android/app/Notification$Builder:setLights	(III)Landroid/app/Notification$Builder;
    //   429: pop
    //   430: iload 6
    //   432: ifeq +55 -> 487
    //   435: aload_2
    //   436: ifnull +9 -> 445
    //   439: aload_1
    //   440: aload_2
    //   441: invokevirtual 262	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   444: pop
    //   445: aload_1
    //   446: aload 4
    //   448: invokevirtual 265	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   451: aload 5
    //   453: invokevirtual 268	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   456: aload 11
    //   458: invokevirtual 272	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   461: pop
    //   462: getstatic 39	android/os/Build$VERSION:SDK_INT	I
    //   465: bipush 16
    //   467: if_icmplt +50 -> 517
    //   470: aload_1
    //   471: invokevirtual 91	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   474: astore_1
    //   475: aload_1
    //   476: areturn
    //   477: astore 12
    //   479: aload 12
    //   481: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   484: goto -87 -> 397
    //   487: aload_1
    //   488: aload 4
    //   490: invokevirtual 265	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   493: aload 5
    //   495: invokevirtual 268	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   498: aload 11
    //   500: invokevirtual 272	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   503: pop
    //   504: aload_2
    //   505: ifnull -43 -> 462
    //   508: aload_1
    //   509: aload_2
    //   510: invokevirtual 262	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   513: pop
    //   514: goto -52 -> 462
    //   517: getstatic 39	android/os/Build$VERSION:SDK_INT	I
    //   520: bipush 16
    //   522: if_icmpge +16 -> 538
    //   525: getstatic 39	android/os/Build$VERSION:SDK_INT	I
    //   528: bipush 11
    //   530: if_icmplt +8 -> 538
    //   533: aload_1
    //   534: invokevirtual 94	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   537: areturn
    //   538: new 185	android/app/Notification
    //   541: dup
    //   542: iload 8
    //   544: aload_3
    //   545: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   548: invokespecial 188	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   551: astore_1
    //   552: aload_1
    //   553: areturn
    //   554: astore_1
    //   555: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +14 -> 572
    //   561: ldc_w 277
    //   564: iconst_2
    //   565: aload_1
    //   566: invokevirtual 106	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   569: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   572: new 185	android/app/Notification
    //   575: dup
    //   576: iload 8
    //   578: aload_3
    //   579: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   582: invokespecial 188	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   585: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	this	KapalaiAdapterUtil
    //   0	586	1	paramIntent	Intent
    //   0	586	2	paramBitmap	Bitmap
    //   0	586	3	paramString1	String
    //   0	586	4	paramString2	String
    //   0	586	5	paramString3	String
    //   0	586	6	paramBoolean	boolean
    //   0	586	7	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   85	492	8	i	int
    //   53	230	9	j	int
    //   5	337	10	bool	boolean
    //   17	482	11	localPendingIntent	android.app.PendingIntent
    //   372	8	12	localMethod	Method
    //   477	3	12	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   352	374	477	java/lang/Exception
    //   379	397	477	java/lang/Exception
    //   462	475	554	java/lang/Exception
    //   517	538	554	java/lang/Exception
    //   538	552	554	java/lang/Exception
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra(a(), Integer.parseInt(b()));
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap != null) {
      return Bitmap.createScaledBitmap(paramBitmap, paramInt, paramInt, true);
    }
    return null;
  }
  
  public String a()
  {
    return DualSimManager.a;
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent.setFlags(337641472);
  }
  
  public void a(Window paramWindow)
  {
    paramWindow.setType(2004);
  }
  
  public boolean a()
  {
    return (!this.a.a(0)) && (this.a.a(1));
  }
  
  public String b()
  {
    return DualSimManager.c;
  }
  
  public void b(Window paramWindow)
  {
    paramWindow.setType(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil
 * JD-Core Version:    0.7.0.1
 */