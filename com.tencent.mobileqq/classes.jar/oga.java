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
import java.util.HashMap;

public class oga
{
  private static String a(String paramString1, String paramString2)
  {
    if (bhsr.a(paramString2)) {
      return paramString1;
    }
    paramString1 = ofz.a(paramString1, ofz.a(paramString2), false);
    QLog.i("Ecshop_JumpUtil", 2, paramString1);
    return paramString1;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("tab_id", paramInt);
    localIntent.putExtra("jump_url", paramString);
    try
    {
      bool = ofz.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      localIntent.putExtra("req_qgg_title", bool);
      localIntent.putExtra("req_qgg_hide_tab", false);
      localIntent.putExtra("big_brother_source_key", "biz_src_gzh_qqgw");
      localIntent.setFlags(603979776);
      PublicFragmentActivityForTool.b(paramContext, localIntent, EcshopNewPageFragment.class);
      if (((paramContext instanceof Activity)) && (!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof PublicFragmentActivityForTool)) && (!(paramContext instanceof UniteSearchActivity)))
      {
        ((Activity)paramContext).finish();
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
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
      localIntent.putExtra("leftViewText", paramContext.getString(2131690559));
      localIntent.setFlags(4194304);
      paramContext.startActivity(localIntent);
    } while (!(paramContext instanceof Activity));
    paramString1 = (Activity)paramContext;
    if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof PublicFragmentActivityForTool))) {
      paramString1.finish();
    }
    paramString1.overridePendingTransition(0, 0);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    QLog.i("Ecshop_JumpUtil", 2, "---jumpByTabIdInner---" + paramInt);
    if (paramInt == 0) {
      a(paramContext, "3046055438", paramString1, true);
    }
    Object localObject;
    String str;
    do
    {
      return;
      localObject = ofw.a();
      if (localObject == null) {
        break label172;
      }
      localObject = ((ofu)localObject).a(paramInt);
      if (localObject == null)
      {
        a(paramContext, "3046055438", paramString1, true);
        return;
      }
      str = ogd.a(((ofv)localObject).b, paramString3);
      if ((!bhsr.a(str)) && ((str.startsWith("http")) || (str.startsWith("https")) || (MiniAppLauncher.isMiniAppUrl(str)))) {
        break;
      }
    } while (((ofv)localObject).a != 1);
    a(paramContext, "3046055438", paramString1, paramBoolean);
    return;
    if (MiniAppLauncher.isMiniAppUrl(str))
    {
      MiniAppLauncher.startMiniApp(paramContext, str, 1035, null);
      return;
    }
    a(paramQQAppInterface, paramContext, paramInt, str, paramBoolean, paramString2, paramString3);
    return;
    label172:
    a(paramContext, "3046055438", paramString1, true);
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    // Byte code:
    //   0: ldc 204
    //   2: astore_3
    //   3: aload_0
    //   4: invokevirtual 207	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7: ldc 154
    //   9: sipush 1008
    //   12: invokevirtual 212	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   15: astore 5
    //   17: aload 5
    //   19: ifnonnull +107 -> 126
    //   22: aload_1
    //   23: ldc 154
    //   25: aload_1
    //   26: invokevirtual 216	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: ldc 217
    //   31: invokevirtual 220	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   34: iconst_1
    //   35: invokestatic 156	oga:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   38: aload_3
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 223	com/tencent/mobileqq/app/QQAppInterface:a	()Ladab;
    //   44: ldc 154
    //   46: sipush 1008
    //   49: invokevirtual 228	adab:a	(Ljava/lang/String;I)I
    //   52: istore_2
    //   53: iload_2
    //   54: ifle +109 -> 163
    //   57: ldc 230
    //   59: astore_3
    //   60: aload_0
    //   61: ldc 232
    //   63: aload_3
    //   64: new 138	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   71: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   74: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc 204
    //   79: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aload_1
    //   86: invokestatic 244	ogd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   89: iload_2
    //   90: ifle +80 -> 170
    //   93: ldc 230
    //   95: astore_3
    //   96: aload_0
    //   97: ldc 246
    //   99: aload_3
    //   100: new 138	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   107: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   110: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   113: ldc 204
    //   115: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aload_1
    //   122: invokestatic 248	ogd:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   125: return
    //   126: aload 5
    //   128: invokestatic 251	ofz:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   131: astore_3
    //   132: aload_3
    //   133: astore 4
    //   135: aload_0
    //   136: aload_1
    //   137: aload 5
    //   139: aload_0
    //   140: aload 5
    //   142: invokestatic 253	ofz:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   145: invokestatic 258	ofy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   148: ldc 204
    //   150: aload 5
    //   152: invokestatic 262	ofz:c	(Lcom/tencent/mobileqq/data/MessageRecord;)I
    //   155: invokestatic 265	oga:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;I)V
    //   158: aload_3
    //   159: astore_1
    //   160: goto -120 -> 40
    //   163: ldc_w 267
    //   166: astore_3
    //   167: goto -107 -> 60
    //   170: ldc_w 267
    //   173: astore_3
    //   174: goto -78 -> 96
    //   177: astore_3
    //   178: ldc 204
    //   180: astore_3
    //   181: aload_3
    //   182: astore 4
    //   184: aload_1
    //   185: ldc 154
    //   187: aload_1
    //   188: invokevirtual 216	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   191: ldc 217
    //   193: invokevirtual 220	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   196: iconst_1
    //   197: invokestatic 156	oga:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   200: aload_0
    //   201: invokevirtual 223	com/tencent/mobileqq/app/QQAppInterface:a	()Ladab;
    //   204: ldc 154
    //   206: sipush 1008
    //   209: invokevirtual 228	adab:a	(Ljava/lang/String;I)I
    //   212: istore_2
    //   213: iload_2
    //   214: ifle +72 -> 286
    //   217: ldc 230
    //   219: astore_1
    //   220: aload_0
    //   221: ldc 232
    //   223: aload_1
    //   224: new 138	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   231: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   234: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   237: ldc 204
    //   239: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: aload_3
    //   246: invokestatic 244	ogd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   249: iload_2
    //   250: ifle +43 -> 293
    //   253: ldc 230
    //   255: astore_1
    //   256: aload_0
    //   257: ldc 246
    //   259: aload_1
    //   260: new 138	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   267: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   270: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   273: ldc 204
    //   275: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: aload_3
    //   282: invokestatic 248	ogd:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   285: return
    //   286: ldc_w 267
    //   289: astore_1
    //   290: goto -70 -> 220
    //   293: ldc_w 267
    //   296: astore_1
    //   297: goto -41 -> 256
    //   300: astore_1
    //   301: ldc 204
    //   303: astore 4
    //   305: aload_0
    //   306: invokevirtual 223	com/tencent/mobileqq/app/QQAppInterface:a	()Ladab;
    //   309: ldc 154
    //   311: sipush 1008
    //   314: invokevirtual 228	adab:a	(Ljava/lang/String;I)I
    //   317: istore_2
    //   318: iload_2
    //   319: ifle +75 -> 394
    //   322: ldc 230
    //   324: astore_3
    //   325: aload_0
    //   326: ldc 232
    //   328: aload_3
    //   329: new 138	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   336: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   339: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   342: ldc 204
    //   344: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: aload 4
    //   352: invokestatic 244	ogd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   355: iload_2
    //   356: ifle +45 -> 401
    //   359: ldc 230
    //   361: astore_3
    //   362: aload_0
    //   363: ldc 246
    //   365: aload_3
    //   366: new 138	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   373: invokestatic 238	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   376: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   379: ldc 204
    //   381: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: aload 4
    //   389: invokestatic 248	ogd:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload_1
    //   393: athrow
    //   394: ldc_w 267
    //   397: astore_3
    //   398: goto -73 -> 325
    //   401: ldc_w 267
    //   404: astore_3
    //   405: goto -43 -> 362
    //   408: astore_1
    //   409: goto -104 -> 305
    //   412: astore 4
    //   414: goto -233 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	paramQQAppInterface	QQAppInterface
    //   0	417	1	paramContext	Context
    //   52	304	2	i	int
    //   2	172	3	str1	String
    //   177	1	3	localThrowable1	java.lang.Throwable
    //   180	225	3	str2	String
    //   133	255	4	str3	String
    //   412	1	4	localThrowable2	java.lang.Throwable
    //   15	136	5	localMessageRecord	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   3	17	177	java/lang/Throwable
    //   22	38	177	java/lang/Throwable
    //   126	132	177	java/lang/Throwable
    //   3	17	300	finally
    //   22	38	300	finally
    //   126	132	300	finally
    //   135	158	408	finally
    //   184	200	408	finally
    //   135	158	412	java/lang/Throwable
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    if ("fypbtn".equals(paramString3))
    {
      a(paramContext, paramInt, paramString1);
      return;
    }
    paramString3 = new Intent();
    paramString3.putExtra("tab_id", paramInt);
    String str = ofz.b();
    paramInt = paramQQAppInterface.a().a("3046055438", 1008);
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_JumpUtil", 2, "<<<<<<unReadPointCnt<<<<<<" + paramInt);
    }
    if (paramInt == 0) {
      if ((!bhsr.a(str)) && (!bhsr.a(ofz.a())))
      {
        paramQQAppInterface = new HashMap();
        paramQQAppInterface.put("prompt_id", str);
        paramQQAppInterface = ofz.a(paramString1, paramQQAppInterface, false);
      }
    }
    for (;;)
    {
      paramString3.putExtra("jump_url", paramQQAppInterface);
      QLog.i("Ecshop_JumpUtil", 2, paramQQAppInterface);
      try
      {
        bool = ofz.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        paramString3.putExtra("req_qgg_title", bool);
        paramString3.putExtra("req_qgg_hide_tab", paramBoolean);
        paramString3.putExtra("big_brother_source_key", "biz_src_gzh_qqgw");
        paramString3.setFlags(603979776);
        PublicFragmentActivityForTool.b(paramContext, paramString3, EcshopNewPageFragment.class);
        return;
        paramQQAppInterface = a(paramString1, paramString2);
        continue;
        paramQQAppInterface = a(paramString1, paramString2);
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          paramQQAppInterface.printStackTrace();
          boolean bool = true;
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, int paramInt)
  {
    ofz.a(paramMessageRecord.uniseq, paramInt + 1);
    paramMessageRecord = new Intent(paramContext, ChatActivity.class);
    paramMessageRecord.putExtra("uin", "3046055438");
    paramMessageRecord.putExtra("uintype", 1008);
    paramMessageRecord.putExtra("uinname", paramContext.getResources().getString(2131691677));
    paramMessageRecord.putExtra("leftViewText", paramContext.getString(2131690559));
    paramMessageRecord.putExtra("jump_minusonescreen_view", true);
    paramContext.startActivity(paramMessageRecord);
    ogd.a(paramQQAppInterface, "gouwu.fyp.show", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
    ogd.b(paramQQAppInterface, "gouwu_fyp_show", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    int i = ofz.a(paramMessageRecord.uniseq);
    if (i >= ofz.a(paramQQAppInterface, paramString1))
    {
      a(paramQQAppInterface, paramContext, paramString1, paramMessageRecord, paramString2);
      return;
    }
    a(paramQQAppInterface, paramContext, paramMessageRecord, i);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = true;
    paramString1 = "";
    for (;;)
    {
      try
      {
        int i = ofz.b(paramMessageRecord);
        QLog.e("Ecshop_JumpUtil", 1, paramMessageRecord, new Object[0]);
      }
      catch (Exception paramMessageRecord)
      {
        try
        {
          paramMessageRecord = ofz.c(paramMessageRecord);
          paramString1 = paramMessageRecord;
          if (QLog.isColorLevel())
          {
            paramString1 = paramMessageRecord;
            QLog.i("Ecshop_JumpUtil", 2, "hideTabId: " + i + " params: " + paramMessageRecord);
          }
          if (i != 1) {
            break label112;
          }
          a(paramQQAppInterface, paramInt, paramContext, paramContext.getResources().getString(2131691677), bool, paramMessageRecord, paramString2);
          return;
        }
        catch (Exception paramMessageRecord)
        {
          break label96;
        }
        paramMessageRecord = paramMessageRecord;
        i = 0;
      }
      label96:
      paramMessageRecord = paramString1;
      continue;
      label112:
      bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, MessageRecord paramMessageRecord, String paramString2)
  {
    paramString1 = ofy.a(paramQQAppInterface, paramString1, "redirectScheme");
    if (bhsr.a(paramString1))
    {
      a(paramContext, "3046055438", paramContext.getResources().getString(2131691677), true);
      return;
    }
    String str;
    try
    {
      paramString1 = ogd.a(URLDecoder.decode(paramString1, "UTF-8"), paramString2);
      str = ofy.a(paramString1);
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_JumpUtil", 2, "<<<<jumpByRedirectScheme<<<<decodedScheme: " + paramString1 + " <<<<<redirectHost: " + str);
      }
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
      a(paramContext, "3046055438", paramContext.getResources().getString(2131691677), true);
      return;
    }
    try
    {
      i = Integer.parseInt(ofy.a(paramString1, "tabId"));
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
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_JumpUtil", 2, "jumpByHost>>>>>>" + paramString1);
    }
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
    a(paramContext, "3046055438", paramContext.getResources().getString(2131691677), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oga
 * JD-Core Version:    0.7.0.1
 */