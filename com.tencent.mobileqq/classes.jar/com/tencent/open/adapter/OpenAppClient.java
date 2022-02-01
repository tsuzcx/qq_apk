package com.tencent.open.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import bizw;
import bjhq;
import bjht;
import bjkj;
import bjko;
import bjmj;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.manager.TicketManager;

public class OpenAppClient
{
  protected static int a;
  public static final String a;
  protected static boolean a;
  protected static int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = OpenAppClient.class.getName();
    jdField_a_of_type_Int = 7;
    jdField_b_of_type_Int = 11;
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
          paramBundle = String.valueOf(bizw.a().a());
        }
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = bizw.a().a();
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          ThreadManager.executeOnSubThread(new OpenAppClient.GetVkeyRunnable(paramActivity, 1, str2));
          continue;
        }
        jdField_a_of_type_Boolean = false;
      }
      finally {}
      bjhq.a(paramActivity, str2, paramBundle, (String)localObject);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    bjko.b(jdField_a_of_type_JavaLangString, "onPcPushMsgForground " + paramString);
    if (bjkj.c(paramContext)) {
      a(paramContext, bjht.a(paramString));
    }
  }
  
  /* Error */
  protected static void a(Context paramContext, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3: new 89	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   10: ldc 125
    //   12: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 104	bjko:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: iconst_m1
    //   26: istore_2
    //   27: iconst_m1
    //   28: istore_3
    //   29: aload_1
    //   30: ldc 130
    //   32: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 46	java/lang/String
    //   38: astore 11
    //   40: aload_1
    //   41: ldc 138
    //   43: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 46	java/lang/String
    //   49: astore 12
    //   51: aload_1
    //   52: ldc 140
    //   54: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 46	java/lang/String
    //   60: astore 8
    //   62: aload_1
    //   63: ldc 142
    //   65: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 46	java/lang/String
    //   71: astore 13
    //   73: aload_1
    //   74: ldc 144
    //   76: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 46	java/lang/String
    //   82: astore 9
    //   84: aload_1
    //   85: ldc 146
    //   87: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 46	java/lang/String
    //   93: astore_1
    //   94: aload_1
    //   95: astore 7
    //   97: aload_1
    //   98: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +7 -> 108
    //   104: ldc 148
    //   106: astore 7
    //   108: new 89	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   115: ldc 150
    //   117: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 11
    //   122: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore 14
    //   130: invokestatic 155	bjna:a	()Lbjna;
    //   133: aload 11
    //   135: invokevirtual 157	bjna:a	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore_1
    //   139: aload 12
    //   141: invokestatic 162	bjlo:a	(Ljava/lang/String;)I
    //   144: ifle +9 -> 153
    //   147: aload 12
    //   149: invokestatic 162	bjlo:a	(Ljava/lang/String;)I
    //   152: istore_2
    //   153: aload_1
    //   154: invokestatic 164	bjlo:b	(Ljava/lang/String;)I
    //   157: ifle +8 -> 165
    //   160: aload_1
    //   161: invokestatic 164	bjlo:b	(Ljava/lang/String;)I
    //   164: istore_3
    //   165: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: new 89	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   175: ldc 166
    //   177: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload_2
    //   181: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc 171
    //   186: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload_3
    //   190: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: ldc 173
    //   195: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_3
    //   199: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 175	bjko:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload 8
    //   210: invokestatic 180	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   213: invokevirtual 184	java/lang/Integer:intValue	()I
    //   216: istore 4
    //   218: aconst_null
    //   219: astore_1
    //   220: aconst_null
    //   221: astore 10
    //   223: aload 9
    //   225: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne +167 -> 395
    //   231: aload 9
    //   233: ldc 186
    //   235: invokevirtual 190	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   238: astore 15
    //   240: aload 15
    //   242: ifnull +296 -> 538
    //   245: aload 15
    //   247: arraylength
    //   248: iconst_2
    //   249: if_icmplt +289 -> 538
    //   252: new 89	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 90	java/lang/StringBuilder:<init>	()V
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
    //   288: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: iload 5
    //   294: aload 15
    //   296: arraylength
    //   297: iconst_1
    //   298: isub
    //   299: if_icmpeq +11 -> 310
    //   302: aload 8
    //   304: ldc 192
    //   306: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: iload 5
    //   312: iconst_1
    //   313: iadd
    //   314: istore 5
    //   316: goto -52 -> 264
    //   319: astore_1
    //   320: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   323: new 89	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   330: ldc 194
    //   332: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 8
    //   337: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 197	bjko:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: iconst_0
    //   347: istore 4
    //   349: goto -131 -> 218
    //   352: aload 8
    //   354: aload 15
    //   356: iload 5
    //   358: aaload
    //   359: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc 192
    //   364: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc 199
    //   369: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: goto -81 -> 292
    //   376: astore 10
    //   378: aload 8
    //   380: astore_1
    //   381: aload 10
    //   383: astore 8
    //   385: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   388: ldc 201
    //   390: aload 8
    //   392: invokestatic 204	bjko:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   395: aload 9
    //   397: astore 8
    //   399: aload_1
    //   400: ifnull +9 -> 409
    //   403: aload_1
    //   404: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: astore 8
    //   409: new 206	com/tencent/open/downloadnew/common/NoticeParam
    //   412: dup
    //   413: invokespecial 207	com/tencent/open/downloadnew/common/NoticeParam:<init>	()V
    //   416: astore_1
    //   417: aload_1
    //   418: aload 11
    //   420: putfield 208	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   423: aload_1
    //   424: aload 7
    //   426: putfield 210	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   429: aload_1
    //   430: aload 12
    //   432: putfield 213	com/tencent/open/downloadnew/common/NoticeParam:d	Ljava/lang/String;
    //   435: aload_1
    //   436: aload 14
    //   438: putfield 216	com/tencent/open/downloadnew/common/NoticeParam:f	Ljava/lang/String;
    //   441: new 34	android/os/Bundle
    //   444: dup
    //   445: invokespecial 217	android/os/Bundle:<init>	()V
    //   448: astore 9
    //   450: aload 9
    //   452: ldc 219
    //   454: aload 11
    //   456: invokevirtual 222	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: aload 9
    //   461: ldc 144
    //   463: aload 8
    //   465: invokevirtual 222	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: aload 9
    //   470: ldc 224
    //   472: aload 13
    //   474: invokevirtual 222	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload 9
    //   479: ldc 226
    //   481: aload 12
    //   483: invokevirtual 222	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: aload 9
    //   488: ldc 228
    //   490: ldc 230
    //   492: invokevirtual 222	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: iload 4
    //   497: iload_2
    //   498: if_icmpgt +45 -> 543
    //   501: ldc 232
    //   503: ldc 234
    //   505: aload 11
    //   507: invokestatic 239	bjlu:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload_1
    //   511: iconst_2
    //   512: putfield 240	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_Int	I
    //   515: aload_1
    //   516: aload 13
    //   518: putfield 242	com/tencent/open/downloadnew/common/NoticeParam:e	Ljava/lang/String;
    //   521: aload_1
    //   522: aload 9
    //   524: invokestatic 247	bjoq:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   527: putfield 250	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   530: invokestatic 255	bjom:a	()Lbjom;
    //   533: aload_1
    //   534: invokevirtual 258	bjom:a	(Lcom/tencent/open/downloadnew/common/NoticeParam;)V
    //   537: return
    //   538: aconst_null
    //   539: astore_1
    //   540: goto -145 -> 395
    //   543: iload 4
    //   545: iload_3
    //   546: if_icmpgt +86 -> 632
    //   549: ldc 232
    //   551: ldc_w 260
    //   554: aload 11
    //   556: invokestatic 239	bjlu:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload_1
    //   560: iconst_3
    //   561: putfield 240	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_Int	I
    //   564: aload_1
    //   565: aload 13
    //   567: putfield 242	com/tencent/open/downloadnew/common/NoticeParam:e	Ljava/lang/String;
    //   570: aload_1
    //   571: aload 9
    //   573: invokestatic 247	bjoq:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   576: putfield 250	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   579: invokestatic 255	bjom:a	()Lbjom;
    //   582: aload_1
    //   583: invokevirtual 258	bjom:a	(Lcom/tencent/open/downloadnew/common/NoticeParam;)V
    //   586: invokestatic 155	bjna:a	()Lbjna;
    //   589: aload 11
    //   591: invokevirtual 157	bjna:a	(Ljava/lang/String;)Ljava/lang/String;
    //   594: astore_1
    //   595: invokestatic 155	bjna:a	()Lbjna;
    //   598: aload 11
    //   600: invokevirtual 262	bjna:b	(Ljava/lang/String;)Ljava/lang/String;
    //   603: astore 7
    //   605: aload_1
    //   606: invokestatic 263	bjlo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   609: ifnull +13 -> 622
    //   612: aload_0
    //   613: aload_1
    //   614: aload 7
    //   616: invokestatic 266	bjlo:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   619: ifeq -82 -> 537
    //   622: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   625: ldc_w 268
    //   628: invokestatic 197	bjko:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: return
    //   632: invokestatic 155	bjna:a	()Lbjna;
    //   635: aload 11
    //   637: invokevirtual 271	bjna:a	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   640: ifnull +13 -> 653
    //   643: ldc 232
    //   645: ldc_w 273
    //   648: aload 11
    //   650: invokestatic 239	bjlu:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   653: aload 9
    //   655: invokestatic 247	bjoq:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   658: astore_0
    //   659: aload 12
    //   661: ifnull +54 -> 715
    //   664: aload 12
    //   666: invokevirtual 276	java/lang/String:trim	()Ljava/lang/String;
    //   669: ldc 148
    //   671: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   674: ifne +41 -> 715
    //   677: iconst_1
    //   678: istore 6
    //   680: new 278	com/tencent/open/downloadnew/DownloadInfo
    //   683: dup
    //   684: aload 11
    //   686: aload 13
    //   688: invokevirtual 276	java/lang/String:trim	()Ljava/lang/String;
    //   691: aload 12
    //   693: aload 7
    //   695: aload 8
    //   697: aload_0
    //   698: ldc_w 280
    //   701: iload 6
    //   703: invokespecial 283	com/tencent/open/downloadnew/DownloadInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;Z)V
    //   706: astore_0
    //   707: invokestatic 155	bjna:a	()Lbjna;
    //   710: aload_0
    //   711: invokevirtual 286	bjna:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
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
    bjmj.a(bizw.a().a());
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
        bizw.a().a(Long.valueOf(str).longValue());
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
    //   5: invokevirtual 337	java/util/HashMap:size	()I
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ldc_w 339
    //   17: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 46	java/lang/String
    //   23: invokestatic 342	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   26: istore_2
    //   27: iload_2
    //   28: iconst_1
    //   29: if_icmpne +84 -> 113
    //   32: aload_1
    //   33: ldc 130
    //   35: invokevirtual 136	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 46	java/lang/String
    //   41: invokestatic 347	bjmu:a	(Ljava/lang/String;)Z
    //   44: istore_3
    //   45: iload_3
    //   46: ifeq +23 -> 69
    //   49: iconst_0
    //   50: ireturn
    //   51: astore 4
    //   53: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: ldc_w 349
    //   59: aload 4
    //   61: invokestatic 351	bjko:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   64: iconst_m1
    //   65: istore_2
    //   66: goto -39 -> 27
    //   69: new 353	com/tencent/open/adapter/OpenAppClient$2
    //   72: dup
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial 355	com/tencent/open/adapter/OpenAppClient$2:<init>	(Landroid/content/Context;Ljava/util/HashMap;)V
    //   78: invokestatic 81	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   81: iconst_1
    //   82: ireturn
    //   83: astore_0
    //   84: new 89	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 357
    //   94: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_1
    //   105: getstatic 19	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: aload_1
    //   109: aload_0
    //   110: invokestatic 204	bjko:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient
 * JD-Core Version:    0.7.0.1
 */