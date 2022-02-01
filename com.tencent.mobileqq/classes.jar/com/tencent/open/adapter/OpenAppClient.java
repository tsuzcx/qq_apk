package com.tencent.open.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.component.cache.CacheManager;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.manager.TicketManager;

public class OpenAppClient
{
  protected static int a;
  public static final String a;
  protected static boolean a;
  protected static int b;
  protected static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = OpenAppClient.class.getName();
    jdField_a_of_type_Int = 7;
    jdField_b_of_type_Int = 11;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_JavaLangString = null;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    for (;;)
    {
      String str2;
      Object localObject;
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        jdField_a_of_type_Boolean = true;
        str2 = paramBundle.getString("schemaurl");
        localObject = paramBundle.getString("uin");
        String str1 = paramBundle.getString("vkey");
        if (localObject != null)
        {
          paramBundle = (Bundle)localObject;
          if (!((String)localObject).equals("0")) {}
        }
        else
        {
          paramBundle = String.valueOf(CommonDataAdapter.a().a());
        }
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = CommonDataAdapter.a().a();
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          ThreadManager.executeOnSubThread(new OpenAppClient.GetVkeyRunnable(paramActivity, 1, str2));
          continue;
        }
        jdField_a_of_type_Boolean = false;
      }
      finally {}
      AppClient.a(paramActivity, str2, paramBundle, (String)localObject);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    LogUtility.b(jdField_a_of_type_JavaLangString, "onPcPushMsgForground " + paramString);
    if (APNUtil.c(paramContext)) {
      a(paramContext, Common.a(paramString));
    }
  }
  
  /* Error */
  protected static void a(Context paramContext, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3: new 91	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   10: ldc 127
    //   12: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 106	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: iconst_m1
    //   26: istore_2
    //   27: iconst_m1
    //   28: istore_3
    //   29: aload_1
    //   30: ldc 132
    //   32: invokevirtual 138	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 48	java/lang/String
    //   38: astore 11
    //   40: aload_1
    //   41: ldc 140
    //   43: invokevirtual 138	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 48	java/lang/String
    //   49: astore 12
    //   51: aload_1
    //   52: ldc 142
    //   54: invokevirtual 138	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 48	java/lang/String
    //   60: astore 8
    //   62: aload_1
    //   63: ldc 144
    //   65: invokevirtual 138	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 48	java/lang/String
    //   71: astore 13
    //   73: aload_1
    //   74: ldc 146
    //   76: invokevirtual 138	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 48	java/lang/String
    //   82: astore 9
    //   84: aload_1
    //   85: ldc 148
    //   87: invokevirtual 138	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 48	java/lang/String
    //   93: astore_1
    //   94: aload_1
    //   95: astore 7
    //   97: aload_1
    //   98: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +7 -> 108
    //   104: ldc 150
    //   106: astore 7
    //   108: new 91	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   115: ldc 152
    //   117: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 11
    //   122: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore 14
    //   130: invokestatic 157	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   133: aload 11
    //   135: invokevirtual 159	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore_1
    //   139: aload 12
    //   141: invokestatic 164	com/tencent/open/business/base/AppUtil:a	(Ljava/lang/String;)I
    //   144: ifle +9 -> 153
    //   147: aload 12
    //   149: invokestatic 164	com/tencent/open/business/base/AppUtil:a	(Ljava/lang/String;)I
    //   152: istore_2
    //   153: aload_1
    //   154: invokestatic 166	com/tencent/open/business/base/AppUtil:b	(Ljava/lang/String;)I
    //   157: ifle +8 -> 165
    //   160: aload_1
    //   161: invokestatic 166	com/tencent/open/business/base/AppUtil:b	(Ljava/lang/String;)I
    //   164: istore_3
    //   165: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: new 91	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   175: ldc 168
    //   177: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload_2
    //   181: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc 173
    //   186: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload_3
    //   190: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: ldc 175
    //   195: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_3
    //   199: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 177	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload 8
    //   210: invokestatic 182	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   213: invokevirtual 186	java/lang/Integer:intValue	()I
    //   216: istore 4
    //   218: aconst_null
    //   219: astore_1
    //   220: aconst_null
    //   221: astore 10
    //   223: aload 9
    //   225: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne +167 -> 395
    //   231: aload 9
    //   233: ldc 188
    //   235: invokevirtual 192	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   238: astore 15
    //   240: aload 15
    //   242: ifnull +296 -> 538
    //   245: aload 15
    //   247: arraylength
    //   248: iconst_2
    //   249: if_icmplt +289 -> 538
    //   252: new 91	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   259: astore 8
    //   261: iconst_0
    //   262: istore 5
    //   264: aload 8
    //   266: astore_1
    //   267: iload 5
    //   269: aload 15
    //   271: arraylength
    //   272: if_icmpge +268 -> 540
    //   275: iload 5
    //   277: iconst_1
    //   278: if_icmpeq +74 -> 352
    //   281: aload 8
    //   283: aload 15
    //   285: iload 5
    //   287: aaload
    //   288: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: iload 5
    //   294: aload 15
    //   296: arraylength
    //   297: iconst_1
    //   298: isub
    //   299: if_icmpeq +11 -> 310
    //   302: aload 8
    //   304: ldc 194
    //   306: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: iload 5
    //   312: iconst_1
    //   313: iadd
    //   314: istore 5
    //   316: goto -52 -> 264
    //   319: astore_1
    //   320: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   323: new 91	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   330: ldc 196
    //   332: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 8
    //   337: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 199	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: iconst_0
    //   347: istore 4
    //   349: goto -131 -> 218
    //   352: aload 8
    //   354: aload 15
    //   356: iload 5
    //   358: aaload
    //   359: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc 194
    //   364: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc 201
    //   369: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: goto -81 -> 292
    //   376: astore 10
    //   378: aload 8
    //   380: astore_1
    //   381: aload 10
    //   383: astore 8
    //   385: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   388: ldc 203
    //   390: aload 8
    //   392: invokestatic 206	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   395: aload 9
    //   397: astore 8
    //   399: aload_1
    //   400: ifnull +9 -> 409
    //   403: aload_1
    //   404: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: astore 8
    //   409: new 208	com/tencent/open/downloadnew/common/NoticeParam
    //   412: dup
    //   413: invokespecial 209	com/tencent/open/downloadnew/common/NoticeParam:<init>	()V
    //   416: astore_1
    //   417: aload_1
    //   418: aload 11
    //   420: putfield 210	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   423: aload_1
    //   424: aload 7
    //   426: putfield 211	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   429: aload_1
    //   430: aload 12
    //   432: putfield 214	com/tencent/open/downloadnew/common/NoticeParam:d	Ljava/lang/String;
    //   435: aload_1
    //   436: aload 14
    //   438: putfield 217	com/tencent/open/downloadnew/common/NoticeParam:f	Ljava/lang/String;
    //   441: new 36	android/os/Bundle
    //   444: dup
    //   445: invokespecial 218	android/os/Bundle:<init>	()V
    //   448: astore 9
    //   450: aload 9
    //   452: ldc 220
    //   454: aload 11
    //   456: invokevirtual 223	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: aload 9
    //   461: ldc 146
    //   463: aload 8
    //   465: invokevirtual 223	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: aload 9
    //   470: ldc 225
    //   472: aload 13
    //   474: invokevirtual 223	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload 9
    //   479: ldc 227
    //   481: aload 12
    //   483: invokevirtual 223	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: aload 9
    //   488: ldc 229
    //   490: ldc 231
    //   492: invokevirtual 223	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: iload 4
    //   497: iload_2
    //   498: if_icmpgt +45 -> 543
    //   501: ldc 233
    //   503: ldc 235
    //   505: aload 11
    //   507: invokestatic 240	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload_1
    //   511: iconst_2
    //   512: putfield 241	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_Int	I
    //   515: aload_1
    //   516: aload 13
    //   518: putfield 243	com/tencent/open/downloadnew/common/NoticeParam:e	Ljava/lang/String;
    //   521: aload_1
    //   522: aload 9
    //   524: invokestatic 248	com/tencent/open/downloadnew/common/IntentFactory:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   527: putfield 251	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   530: invokestatic 256	com/tencent/open/downloadnew/common/AppNotificationManager:a	()Lcom/tencent/open/downloadnew/common/AppNotificationManager;
    //   533: aload_1
    //   534: invokevirtual 259	com/tencent/open/downloadnew/common/AppNotificationManager:a	(Lcom/tencent/open/downloadnew/common/NoticeParam;)V
    //   537: return
    //   538: aconst_null
    //   539: astore_1
    //   540: goto -145 -> 395
    //   543: iload 4
    //   545: iload_3
    //   546: if_icmpgt +86 -> 632
    //   549: ldc 233
    //   551: ldc_w 261
    //   554: aload 11
    //   556: invokestatic 240	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload_1
    //   560: iconst_3
    //   561: putfield 241	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_Int	I
    //   564: aload_1
    //   565: aload 13
    //   567: putfield 243	com/tencent/open/downloadnew/common/NoticeParam:e	Ljava/lang/String;
    //   570: aload_1
    //   571: aload 9
    //   573: invokestatic 248	com/tencent/open/downloadnew/common/IntentFactory:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   576: putfield 251	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   579: invokestatic 256	com/tencent/open/downloadnew/common/AppNotificationManager:a	()Lcom/tencent/open/downloadnew/common/AppNotificationManager;
    //   582: aload_1
    //   583: invokevirtual 259	com/tencent/open/downloadnew/common/AppNotificationManager:a	(Lcom/tencent/open/downloadnew/common/NoticeParam;)V
    //   586: invokestatic 157	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   589: aload 11
    //   591: invokevirtual 159	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   594: astore_1
    //   595: invokestatic 157	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   598: aload 11
    //   600: invokevirtual 263	com/tencent/open/downloadnew/DownloadManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   603: astore 7
    //   605: aload_1
    //   606: invokestatic 264	com/tencent/open/business/base/AppUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   609: ifnull +13 -> 622
    //   612: aload_0
    //   613: aload_1
    //   614: aload 7
    //   616: invokestatic 267	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   619: ifeq -82 -> 537
    //   622: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   625: ldc_w 269
    //   628: invokestatic 199	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: return
    //   632: invokestatic 157	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   635: aload 11
    //   637: invokevirtual 272	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   640: ifnull +13 -> 653
    //   643: ldc 233
    //   645: ldc_w 274
    //   648: aload 11
    //   650: invokestatic 240	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   653: aload 9
    //   655: invokestatic 248	com/tencent/open/downloadnew/common/IntentFactory:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   658: astore_0
    //   659: aload 12
    //   661: ifnull +54 -> 715
    //   664: aload 12
    //   666: invokevirtual 277	java/lang/String:trim	()Ljava/lang/String;
    //   669: ldc 150
    //   671: invokevirtual 52	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   674: ifne +41 -> 715
    //   677: iconst_1
    //   678: istore 6
    //   680: new 279	com/tencent/open/downloadnew/DownloadInfo
    //   683: dup
    //   684: aload 11
    //   686: aload 13
    //   688: invokevirtual 277	java/lang/String:trim	()Ljava/lang/String;
    //   691: aload 12
    //   693: aload 7
    //   695: aload 8
    //   697: aload_0
    //   698: ldc_w 281
    //   701: iload 6
    //   703: invokespecial 284	com/tencent/open/downloadnew/DownloadInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;Z)V
    //   706: astore_0
    //   707: invokestatic 157	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   710: aload_0
    //   711: invokevirtual 287	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   714: return
    //   715: iconst_0
    //   716: istore 6
    //   718: goto -38 -> 680
    //   721: astore 8
    //   723: aload 10
    //   725: astore_1
    //   726: goto -341 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	729	0	paramContext	Context
    //   0	729	1	paramHashMap	java.util.HashMap<String, String>
    //   26	473	2	i	int
    //   28	519	3	j	int
    //   216	331	4	k	int
    //   262	95	5	m	int
    //   678	39	6	bool	boolean
    //   95	599	7	localObject1	Object
    //   60	636	8	localObject2	Object
    //   721	1	8	localException1	Exception
    //   82	572	9	localObject3	Object
    //   221	1	10	localObject4	Object
    //   376	348	10	localException2	Exception
    //   38	647	11	str1	String
    //   49	643	12	str2	String
    //   71	616	13	str3	String
    //   128	309	14	str4	String
    //   238	117	15	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   208	218	319	java/lang/NumberFormatException
    //   267	275	376	java/lang/Exception
    //   281	292	376	java/lang/Exception
    //   292	310	376	java/lang/Exception
    //   352	373	376	java/lang/Exception
    //   231	240	721	java/lang/Exception
    //   245	261	721	java/lang/Exception
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    CacheManager.a(CommonDataAdapter.a().a());
    String str = "";
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        break label70;
      }
      ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
      str = ((QQAppInterface)paramAppInterface).getAccount();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {}
      label70:
      try
      {
        CommonDataAdapter.a().a(Long.valueOf(str).longValue());
        return;
      }
      catch (Exception paramAppInterface) {}
      if ((paramAppInterface instanceof BrowserAppInterface))
      {
        str = ((BrowserAppInterface)paramAppInterface).getAccount();
        ThreadManager.executeOnNetWorkThread(new OpenAppClient.GetVkeyRunnable(paramAppInterface, 0, ""));
      }
    }
  }
  
  /* Error */
  protected static boolean a(Context paramContext, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 338	java/util/HashMap:size	()I
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ldc_w 340
    //   17: invokevirtual 138	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 48	java/lang/String
    //   23: invokestatic 343	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   26: istore_2
    //   27: iload_2
    //   28: iconst_1
    //   29: if_icmpne +84 -> 113
    //   32: aload_1
    //   33: ldc 132
    //   35: invokevirtual 138	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 48	java/lang/String
    //   41: invokestatic 348	com/tencent/open/downloadnew/DownloadApi:a	(Ljava/lang/String;)Z
    //   44: istore_3
    //   45: iload_3
    //   46: ifeq +23 -> 69
    //   49: iconst_0
    //   50: ireturn
    //   51: astore 4
    //   53: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: ldc_w 350
    //   59: aload 4
    //   61: invokestatic 352	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   64: iconst_m1
    //   65: istore_2
    //   66: goto -39 -> 27
    //   69: new 354	com/tencent/open/adapter/OpenAppClient$2
    //   72: dup
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial 356	com/tencent/open/adapter/OpenAppClient$2:<init>	(Landroid/content/Context;Ljava/util/HashMap;)V
    //   78: invokestatic 83	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   81: iconst_1
    //   82: ireturn
    //   83: astore_0
    //   84: new 91	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 358
    //   94: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_1
    //   105: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: aload_1
    //   109: aload_0
    //   110: invokestatic 206	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: iconst_0
    //   114: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   0	115	1	paramHashMap	java.util.HashMap<String, String>
    //   26	40	2	i	int
    //   44	2	3	bool	boolean
    //   51	9	4	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   13	27	51	java/lang/NumberFormatException
    //   32	45	83	java/lang/Exception
    //   69	81	83	java/lang/Exception
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        jdField_a_of_type_Boolean = true;
        String str = paramBundle.getString("schemaurl");
        paramBundle.getString("uin");
        if (TextUtils.isEmpty(str)) {
          jdField_a_of_type_Boolean = false;
        } else {
          try
          {
            ThreadManager.executeOnNetWorkThread(new OpenAppClient.GetVkeyRunnable(paramActivity, 2, new URL(str).getQuery()));
          }
          catch (MalformedURLException paramActivity)
          {
            paramActivity.printStackTrace();
            jdField_a_of_type_Boolean = false;
          }
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient
 * JD-Core Version:    0.7.0.1
 */