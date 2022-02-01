import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;

public class oes
{
  private static void a(int paramInt, Context paramContext, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    QLog.i("Ecshop_JumpUtil", 2, "---jumpByTabIdInner---" + paramInt);
    if (paramInt == 0) {
      a(paramContext, "3046055438", paramString1, true);
    }
    Object localObject;
    do
    {
      return;
      localObject = oem.a();
      if (localObject == null) {
        break label167;
      }
      localObject = ((oek)localObject).a(paramInt);
      if (localObject == null)
      {
        a(paramContext, "3046055438", paramString1, true);
        return;
      }
      paramString3 = oev.a(((oel)localObject).b, paramString3);
      if ((!bgsp.a(paramString3)) && ((paramString3.startsWith("http")) || (paramString3.startsWith("https")) || (MiniAppLauncher.isMiniAppUrl(paramString3)))) {
        break;
      }
    } while (((oel)localObject).a != 1);
    a(paramContext, "3046055438", paramString1, paramBoolean);
    return;
    if (MiniAppLauncher.isMiniAppUrl(paramString3))
    {
      MiniAppLauncher.startMiniApp(paramContext, paramString3, 1035, null);
      return;
    }
    a(paramContext, paramInt, paramString3, paramBoolean, paramString2);
    return;
    label167:
    a(paramContext, "3046055438", paramString1, true);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    a(paramContext, paramInt, paramString, false, "");
    if (((paramContext instanceof Activity)) && (!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof PublicFragmentActivityForTool)) && (!(paramContext instanceof UniteSearchActivity)))
    {
      ((Activity)paramContext).finish();
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("tab_id", paramInt);
    if (bgsp.a(paramString2)) {
      localIntent.putExtra("jump_url", paramString1);
    }
    try
    {
      for (;;)
      {
        bool = oer.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        localIntent.putExtra("req_qgg_title", bool);
        localIntent.putExtra("req_qgg_hide_tab", paramBoolean);
        localIntent.putExtra("big_brother_source_key", "biz_src_gzh_qqgw");
        localIntent.setFlags(603979776);
        PublicFragmentActivityForTool.b(paramContext, localIntent, EcshopNewPageFragment.class);
        return;
        paramString1 = oer.a(paramString1, oer.a(paramString2), false);
        QLog.i("Ecshop_JumpUtil", 2, paramString1);
        localIntent.putExtra("jump_url", paramString1);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        boolean bool = true;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      Intent localIntent = new Intent(paramContext, ChatActivity.class);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("req_qgg_hide_tab", paramBoolean);
      localIntent.putExtra("leftViewText", paramContext.getString(2131690563));
      localIntent.setFlags(4194304);
      paramContext.startActivity(localIntent);
    } while (!(paramContext instanceof Activity));
    paramString1 = (Activity)paramContext;
    if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof PublicFragmentActivityForTool))) {
      paramString1.finish();
    }
    paramString1.overridePendingTransition(0, 0);
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    // Byte code:
    //   0: ldc 92
    //   2: astore_3
    //   3: aload_0
    //   4: invokevirtual 207	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7: ldc 35
    //   9: sipush 1008
    //   12: invokevirtual 212	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   15: astore 5
    //   17: aload 5
    //   19: ifnonnull +107 -> 126
    //   22: aload_1
    //   23: ldc 35
    //   25: aload_1
    //   26: invokevirtual 216	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: ldc 217
    //   31: invokevirtual 220	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   34: iconst_1
    //   35: invokestatic 38	oes:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   38: aload_3
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 223	com/tencent/mobileqq/app/QQAppInterface:a	()Lacvy;
    //   44: ldc 35
    //   46: sipush 1008
    //   49: invokevirtual 228	acvy:a	(Ljava/lang/String;I)I
    //   52: istore_2
    //   53: iload_2
    //   54: ifle +133 -> 187
    //   57: ldc 230
    //   59: astore_3
    //   60: aload_0
    //   61: ldc 232
    //   63: aload_3
    //   64: new 10	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   71: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   74: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc 92
    //   79: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aload_1
    //   86: invokestatic 244	oev:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   89: iload_2
    //   90: ifle +104 -> 194
    //   93: ldc 230
    //   95: astore_3
    //   96: aload_0
    //   97: ldc 246
    //   99: aload_3
    //   100: new 10	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   107: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   110: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   113: ldc 92
    //   115: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aload_1
    //   122: invokestatic 248	oev:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   125: return
    //   126: aload 5
    //   128: invokestatic 251	oer:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   131: astore_3
    //   132: aload_3
    //   133: invokestatic 252	oer:a	(Ljava/lang/String;)Z
    //   136: ifeq +37 -> 173
    //   139: ldc 230
    //   141: astore_3
    //   142: aload_3
    //   143: astore 4
    //   145: aload_0
    //   146: aload_1
    //   147: aload 5
    //   149: aload_0
    //   150: aload 5
    //   152: invokestatic 254	oer:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   155: invokestatic 259	oeq:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   158: ldc 92
    //   160: aload 5
    //   162: invokestatic 262	oer:b	(Lcom/tencent/mobileqq/data/MessageRecord;)I
    //   165: invokestatic 265	oes:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;I)V
    //   168: aload_3
    //   169: astore_1
    //   170: goto -130 -> 40
    //   173: aload_3
    //   174: invokestatic 267	oer:b	(Ljava/lang/String;)Z
    //   177: ifeq +264 -> 441
    //   180: ldc_w 269
    //   183: astore_3
    //   184: goto -42 -> 142
    //   187: ldc_w 271
    //   190: astore_3
    //   191: goto -131 -> 60
    //   194: ldc_w 271
    //   197: astore_3
    //   198: goto -102 -> 96
    //   201: astore_3
    //   202: ldc 92
    //   204: astore_3
    //   205: aload_3
    //   206: astore 4
    //   208: aload_1
    //   209: ldc 35
    //   211: aload_1
    //   212: invokevirtual 216	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   215: ldc 217
    //   217: invokevirtual 220	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   220: iconst_1
    //   221: invokestatic 38	oes:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   224: aload_0
    //   225: invokevirtual 223	com/tencent/mobileqq/app/QQAppInterface:a	()Lacvy;
    //   228: ldc 35
    //   230: sipush 1008
    //   233: invokevirtual 228	acvy:a	(Ljava/lang/String;I)I
    //   236: istore_2
    //   237: iload_2
    //   238: ifle +72 -> 310
    //   241: ldc 230
    //   243: astore_1
    //   244: aload_0
    //   245: ldc 232
    //   247: aload_1
    //   248: new 10	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   255: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   258: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   261: ldc 92
    //   263: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: aload_3
    //   270: invokestatic 244	oev:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   273: iload_2
    //   274: ifle +43 -> 317
    //   277: ldc 230
    //   279: astore_1
    //   280: aload_0
    //   281: ldc 246
    //   283: aload_1
    //   284: new 10	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   291: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   294: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   297: ldc 92
    //   299: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: aload_3
    //   306: invokestatic 248	oev:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   309: return
    //   310: ldc_w 271
    //   313: astore_1
    //   314: goto -70 -> 244
    //   317: ldc_w 271
    //   320: astore_1
    //   321: goto -41 -> 280
    //   324: astore_1
    //   325: ldc 92
    //   327: astore 4
    //   329: aload_0
    //   330: invokevirtual 223	com/tencent/mobileqq/app/QQAppInterface:a	()Lacvy;
    //   333: ldc 35
    //   335: sipush 1008
    //   338: invokevirtual 228	acvy:a	(Ljava/lang/String;I)I
    //   341: istore_2
    //   342: iload_2
    //   343: ifle +75 -> 418
    //   346: ldc 230
    //   348: astore_3
    //   349: aload_0
    //   350: ldc 232
    //   352: aload_3
    //   353: new 10	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   360: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   363: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   366: ldc 92
    //   368: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: aload 4
    //   376: invokestatic 244	oev:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   379: iload_2
    //   380: ifle +45 -> 425
    //   383: ldc 230
    //   385: astore_3
    //   386: aload_0
    //   387: ldc 246
    //   389: aload_3
    //   390: new 10	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   397: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   400: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   403: ldc 92
    //   405: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: aload 4
    //   413: invokestatic 248	oev:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload_1
    //   417: athrow
    //   418: ldc_w 271
    //   421: astore_3
    //   422: goto -73 -> 349
    //   425: ldc_w 271
    //   428: astore_3
    //   429: goto -43 -> 386
    //   432: astore_1
    //   433: goto -104 -> 329
    //   436: astore 4
    //   438: goto -233 -> 205
    //   441: ldc 92
    //   443: astore_3
    //   444: goto -302 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	paramQQAppInterface	QQAppInterface
    //   0	447	1	paramContext	Context
    //   52	328	2	i	int
    //   2	196	3	str1	String
    //   201	1	3	localThrowable1	java.lang.Throwable
    //   204	240	3	str2	String
    //   143	269	4	str3	String
    //   436	1	4	localThrowable2	java.lang.Throwable
    //   15	146	5	localMessageRecord	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   3	17	201	java/lang/Throwable
    //   22	38	201	java/lang/Throwable
    //   126	139	201	java/lang/Throwable
    //   173	180	201	java/lang/Throwable
    //   3	17	324	finally
    //   22	38	324	finally
    //   126	139	324	finally
    //   173	180	324	finally
    //   145	168	432	finally
    //   208	224	432	finally
    //   145	168	436	java/lang/Throwable
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, int paramInt)
  {
    oer.a(paramMessageRecord.uniseq, paramInt + 1);
    paramMessageRecord = new Intent(paramContext, ChatActivity.class);
    paramMessageRecord.putExtra("uin", "3046055438");
    paramMessageRecord.putExtra("uintype", 1008);
    paramMessageRecord.putExtra("uinname", paramContext.getResources().getString(2131691674));
    paramMessageRecord.putExtra("leftViewText", paramContext.getString(2131690563));
    paramMessageRecord.putExtra("jump_minusonescreen_view", true);
    paramContext.startActivity(paramMessageRecord);
    oev.a(paramQQAppInterface, "gouwu_fyp_show", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
    oev.b(paramQQAppInterface, "gouwu_fyp_show", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    int i = 1;
    try
    {
      j = Integer.parseInt(oeq.a(paramQQAppInterface, paramString1, "maxShowCount"));
      i = j;
    }
    catch (Exception localException)
    {
      int j;
      for (;;)
      {
        QLog.e("Ecshop_JumpUtil", 1, localException, new Object[0]);
      }
      a(paramQQAppInterface, paramContext, paramMessageRecord, j);
    }
    j = oer.a(paramMessageRecord.uniseq);
    if (j >= i)
    {
      a(paramQQAppInterface, paramContext, paramString1, paramMessageRecord, paramString2);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = true;
    paramQQAppInterface = "";
    for (;;)
    {
      try
      {
        int i = oer.a(paramMessageRecord);
        QLog.e("Ecshop_JumpUtil", 1, paramMessageRecord, new Object[0]);
      }
      catch (Exception paramMessageRecord)
      {
        try
        {
          paramMessageRecord = oer.c(paramMessageRecord);
          paramQQAppInterface = paramMessageRecord;
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = paramMessageRecord;
            QLog.i("Ecshop_JumpUtil", 2, "hideTabId: " + i + " params: " + paramMessageRecord);
          }
          if (i != 1) {
            break label111;
          }
          a(paramInt, paramContext, paramContext.getResources().getString(2131691674), bool, paramMessageRecord, paramString2);
          return;
        }
        catch (Exception paramMessageRecord)
        {
          break label95;
        }
        paramMessageRecord = paramMessageRecord;
        i = 0;
      }
      label95:
      paramMessageRecord = paramQQAppInterface;
      continue;
      label111:
      bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, MessageRecord paramMessageRecord, String paramString2)
  {
    paramString1 = oeq.a(paramQQAppInterface, paramString1, "redirectScheme");
    if (bgsp.a(paramString1))
    {
      a(paramContext, "3046055438", paramContext.getResources().getString(2131691674), true);
      return;
    }
    String str;
    try
    {
      paramString1 = oev.a(URLDecoder.decode(paramString1, "UTF-8"), paramString2);
      str = oeq.a(paramString1);
      if ((paramString1.startsWith("http")) || (paramString1.startsWith("https")))
      {
        paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("url", paramString1);
        paramQQAppInterface.putExtra("big_brother_source_key", "biz_src_gzh_qqgw");
        if (!(paramContext instanceof Activity)) {
          paramQQAppInterface.addFlags(268435456);
        }
        paramContext.startActivity(paramQQAppInterface);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      a(paramContext, "3046055438", paramContext.getResources().getString(2131691674), true);
      return;
    }
    try
    {
      i = Integer.parseInt(oeq.a(paramString1, "tabId"));
      b(paramQQAppInterface, paramContext, paramMessageRecord, str, paramString2, i);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e("Ecshop_JumpUtil", 2, new Object[] { Integer.valueOf(1) });
        int i = 1;
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    if ("jumpTab".equals(paramString1))
    {
      a(paramQQAppInterface, paramContext, paramMessageRecord, paramString1, paramString2, paramInt);
      return;
    }
    if ("jumpPreview".equals(paramString1))
    {
      a(paramQQAppInterface, paramContext, paramMessageRecord, paramString1, "fypgo");
      return;
    }
    a(paramContext, "3046055438", paramContext.getResources().getString(2131691674), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oes
 * JD-Core Version:    0.7.0.1
 */