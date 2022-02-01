package com.tencent.mobileqq.haoliyou;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class UriParserPathHelper
  implements Handler.Callback
{
  public static String b;
  private static ConcurrentHashMap<String, String> d = new ConcurrentHashMap();
  public Context a;
  public boolean c;
  private Activity e;
  private UriParserPathHelper.IOnFileCopyFinishListener f;
  private final MqqHandler g = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private QQCustomDialog h;
  private AtomicInteger i = new AtomicInteger(0);
  private boolean j;
  
  public UriParserPathHelper(Activity paramActivity, boolean paramBoolean, UriParserPathHelper.IOnFileCopyFinishListener paramIOnFileCopyFinishListener)
  {
    this.e = paramActivity;
    this.a = BaseApplicationImpl.getApplication().getApplicationContext();
    this.j = paramBoolean;
    this.f = paramIOnFileCopyFinishListener;
  }
  
  /* Error */
  public static String a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 85	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore_3
    //   4: aload_3
    //   5: invokevirtual 91	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   8: aload_0
    //   9: iconst_1
    //   10: anewarray 93	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc 95
    //   17: aastore
    //   18: aload_1
    //   19: aload_2
    //   20: aconst_null
    //   21: invokevirtual 101	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +46 -> 72
    //   29: aload_0
    //   30: invokeinterface 107 1 0
    //   35: ifeq +37 -> 72
    //   38: aload_0
    //   39: aload_0
    //   40: ldc 95
    //   42: invokeinterface 111 2 0
    //   47: invokeinterface 115 2 0
    //   52: astore_1
    //   53: aload_0
    //   54: ifnull +9 -> 63
    //   57: aload_0
    //   58: invokeinterface 118 1 0
    //   63: aload_1
    //   64: areturn
    //   65: astore_1
    //   66: goto +16 -> 82
    //   69: goto +27 -> 96
    //   72: aload_0
    //   73: ifnull +33 -> 106
    //   76: goto +24 -> 100
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_0
    //   82: aload_0
    //   83: ifnull +9 -> 92
    //   86: aload_0
    //   87: invokeinterface 118 1 0
    //   92: aload_1
    //   93: athrow
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: ifnull +9 -> 106
    //   100: aload_0
    //   101: invokeinterface 118 1 0
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: goto -15 -> 94
    //   112: astore_1
    //   113: goto -44 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramUri	Uri
    //   0	116	1	paramString	String
    //   0	116	2	paramArrayOfString	String[]
    //   3	2	3	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    // Exception table:
    //   from	to	target	type
    //   29	53	65	finally
    //   4	25	79	finally
    //   4	25	108	java/lang/Throwable
    //   29	53	112	java/lang/Throwable
  }
  
  private void a(Uri paramUri, String paramString, InputStream paramInputStream, long paramLong)
  {
    this.i.incrementAndGet();
    ThreadManager.post(new UriParserPathHelper.3(this, paramString, paramInputStream, paramLong, paramUri), 5, null, true);
    if (!this.j) {
      return;
    }
    if (this.h == null)
    {
      this.h = DialogUtil.a(this.e, this.a.getString(2131888250), HardCodeUtil.a(2131898212), new UriParserPathHelper.4(this));
      this.h.setOnDismissListener(new UriParserPathHelper.5(this));
    }
    this.h.show();
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    paramString = paramString.listFiles();
    int m = paramString.length;
    int k = 0;
    while (k < m)
    {
      Object localObject = paramString[k];
      if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
        localObject.delete();
      }
      k += 1;
    }
  }
  
  /* Error */
  public static boolean a(Uri paramUri, Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: invokevirtual 206	android/net/Uri:getScheme	()Ljava/lang/String;
    //   10: astore 7
    //   12: new 208	java/lang/StringBuilder
    //   15: dup
    //   16: ldc 210
    //   18: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: astore 11
    //   23: aload 11
    //   25: ldc 213
    //   27: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 11
    //   33: aload_0
    //   34: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 7
    //   40: ifnull +214 -> 254
    //   43: aload 7
    //   45: ldc 222
    //   47: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +6 -> 56
    //   53: goto +201 -> 254
    //   56: aload 7
    //   58: ldc 228
    //   60: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: istore_3
    //   64: iload_3
    //   65: ifeq +604 -> 669
    //   68: aload_1
    //   69: invokevirtual 91	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   72: aload_0
    //   73: iconst_1
    //   74: anewarray 93	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: ldc 95
    //   81: aastore
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: invokevirtual 101	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore 7
    //   90: aload 7
    //   92: ldc 95
    //   94: invokeinterface 111 2 0
    //   99: istore_2
    //   100: aload 7
    //   102: invokeinterface 107 1 0
    //   107: pop
    //   108: aload 7
    //   110: iload_2
    //   111: invokeinterface 115 2 0
    //   116: astore 8
    //   118: aload 7
    //   120: invokeinterface 118 1 0
    //   125: aload 8
    //   127: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: ifne +45 -> 175
    //   133: ldc 236
    //   135: iconst_1
    //   136: iconst_2
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: ldc 238
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: aload 8
    //   149: aastore
    //   150: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   153: new 174	java/io/File
    //   156: dup
    //   157: aload 8
    //   159: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: invokevirtual 246	java/io/File:canRead	()Z
    //   165: istore_3
    //   166: iload_3
    //   167: ifeq +8 -> 175
    //   170: iconst_1
    //   171: istore_3
    //   172: goto +5 -> 177
    //   175: iconst_0
    //   176: istore_3
    //   177: iload_3
    //   178: istore 4
    //   180: aload 11
    //   182: ldc 248
    //   184: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: iload_3
    //   189: istore 4
    //   191: aload 11
    //   193: iload_3
    //   194: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: goto +130 -> 328
    //   201: astore 7
    //   203: goto +33 -> 236
    //   206: astore 7
    //   208: ldc 236
    //   210: iconst_1
    //   211: ldc 253
    //   213: aload 7
    //   215: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   218: aload 11
    //   220: ldc 248
    //   222: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 11
    //   228: iconst_0
    //   229: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: goto +436 -> 669
    //   236: aload 11
    //   238: ldc 248
    //   240: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 11
    //   246: iconst_0
    //   247: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 7
    //   253: athrow
    //   254: new 174	java/io/File
    //   257: dup
    //   258: aload_0
    //   259: invokevirtual 259	android/net/Uri:getPath	()Ljava/lang/String;
    //   262: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   265: invokevirtual 246	java/io/File:canRead	()Z
    //   268: istore_3
    //   269: iload_3
    //   270: ifeq +8 -> 278
    //   273: iconst_1
    //   274: istore_3
    //   275: goto +5 -> 280
    //   278: iconst_0
    //   279: istore_3
    //   280: iload_3
    //   281: istore 4
    //   283: aload 11
    //   285: ldc_w 261
    //   288: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: iload_3
    //   293: istore 4
    //   295: aload 11
    //   297: iload_3
    //   298: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: goto +26 -> 328
    //   305: astore 7
    //   307: iload 4
    //   309: istore_3
    //   310: goto +7 -> 317
    //   313: astore 7
    //   315: iconst_0
    //   316: istore_3
    //   317: ldc 236
    //   319: iconst_1
    //   320: ldc_w 263
    //   323: aload 7
    //   325: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   328: iload_3
    //   329: ifne +338 -> 667
    //   332: aload_1
    //   333: ifnull +334 -> 667
    //   336: aconst_null
    //   337: astore 10
    //   339: aconst_null
    //   340: astore 8
    //   342: aconst_null
    //   343: astore 9
    //   345: iload_3
    //   346: istore 4
    //   348: aload 10
    //   350: astore 7
    //   352: aload_1
    //   353: invokevirtual 91	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   356: astore 12
    //   358: iload_3
    //   359: istore 4
    //   361: aload 10
    //   363: astore 7
    //   365: aload 12
    //   367: aload_0
    //   368: aconst_null
    //   369: aconst_null
    //   370: aconst_null
    //   371: aconst_null
    //   372: invokevirtual 101	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   375: astore_1
    //   376: iload_3
    //   377: istore 5
    //   379: aload_1
    //   380: ifnull +174 -> 554
    //   383: iload_3
    //   384: istore 5
    //   386: iload_3
    //   387: istore 6
    //   389: aload_1
    //   390: ldc_w 265
    //   393: invokeinterface 268 2 0
    //   398: istore_2
    //   399: iload_3
    //   400: istore 5
    //   402: iload_3
    //   403: istore 6
    //   405: aload_1
    //   406: invokeinterface 107 1 0
    //   411: pop
    //   412: iload_2
    //   413: iconst_m1
    //   414: if_icmpne +10 -> 424
    //   417: aload 9
    //   419: astore 7
    //   421: goto +18 -> 439
    //   424: iload_3
    //   425: istore 5
    //   427: iload_3
    //   428: istore 6
    //   430: aload_1
    //   431: iload_2
    //   432: invokeinterface 115 2 0
    //   437: astore 7
    //   439: iload_3
    //   440: istore 5
    //   442: iload_3
    //   443: istore 6
    //   445: aload 12
    //   447: aload_0
    //   448: invokevirtual 272	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   451: astore_0
    //   452: iload_3
    //   453: istore 4
    //   455: aload_0
    //   456: ifnull +50 -> 506
    //   459: iload_3
    //   460: istore 4
    //   462: iload_3
    //   463: istore 5
    //   465: iload_3
    //   466: istore 6
    //   468: aload 7
    //   470: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   473: ifne +33 -> 506
    //   476: iload_3
    //   477: istore 5
    //   479: iload_3
    //   480: istore 6
    //   482: ldc 236
    //   484: iconst_1
    //   485: iconst_2
    //   486: anewarray 4	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: ldc_w 274
    //   494: aastore
    //   495: dup
    //   496: iconst_1
    //   497: aload 7
    //   499: aastore
    //   500: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   503: iconst_1
    //   504: istore 4
    //   506: iload 4
    //   508: istore 5
    //   510: aload_0
    //   511: ifnull +43 -> 554
    //   514: iload 4
    //   516: istore 5
    //   518: iload 4
    //   520: istore 6
    //   522: aload_0
    //   523: invokevirtual 279	java/io/InputStream:close	()V
    //   526: iload 4
    //   528: istore 5
    //   530: goto +24 -> 554
    //   533: astore_0
    //   534: iload 5
    //   536: istore 4
    //   538: goto +100 -> 638
    //   541: astore 7
    //   543: aload_1
    //   544: astore_0
    //   545: aload 7
    //   547: astore_1
    //   548: iload 6
    //   550: istore_3
    //   551: goto +52 -> 603
    //   554: iload 5
    //   556: istore 4
    //   558: aload_1
    //   559: ifnull +13 -> 572
    //   562: aload_1
    //   563: invokeinterface 118 1 0
    //   568: iload 5
    //   570: istore 4
    //   572: aload 11
    //   574: ldc_w 281
    //   577: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 11
    //   583: iload 4
    //   585: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: iload 4
    //   591: ireturn
    //   592: astore_0
    //   593: aload 7
    //   595: astore_1
    //   596: goto +42 -> 638
    //   599: astore_1
    //   600: aload 8
    //   602: astore_0
    //   603: iload_3
    //   604: istore 4
    //   606: aload_0
    //   607: astore 7
    //   609: ldc 236
    //   611: iconst_1
    //   612: ldc_w 283
    //   615: aload_1
    //   616: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   619: iload_3
    //   620: istore 4
    //   622: aload_0
    //   623: ifnull -51 -> 572
    //   626: aload_0
    //   627: invokeinterface 118 1 0
    //   632: iload_3
    //   633: istore 4
    //   635: goto -63 -> 572
    //   638: aload_1
    //   639: ifnull +9 -> 648
    //   642: aload_1
    //   643: invokeinterface 118 1 0
    //   648: aload 11
    //   650: ldc_w 281
    //   653: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload 11
    //   659: iload 4
    //   661: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   664: pop
    //   665: aload_0
    //   666: athrow
    //   667: iload_3
    //   668: ireturn
    //   669: iconst_0
    //   670: istore_3
    //   671: goto -343 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	674	0	paramUri	Uri
    //   0	674	1	paramContext	Context
    //   99	333	2	k	int
    //   63	608	3	bool1	boolean
    //   178	482	4	bool2	boolean
    //   377	192	5	bool3	boolean
    //   387	162	6	bool4	boolean
    //   10	109	7	localObject1	Object
    //   201	1	7	localObject2	Object
    //   206	46	7	localThrowable	Throwable
    //   305	1	7	localException1	Exception
    //   313	11	7	localException2	Exception
    //   350	148	7	localObject3	Object
    //   541	53	7	localException3	Exception
    //   607	1	7	localUri	Uri
    //   116	485	8	str	String
    //   343	75	9	localObject4	Object
    //   337	25	10	localObject5	Object
    //   21	637	11	localStringBuilder	StringBuilder
    //   356	90	12	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   68	166	201	finally
    //   208	218	201	finally
    //   68	166	206	java/lang/Throwable
    //   180	188	305	java/lang/Exception
    //   191	198	305	java/lang/Exception
    //   283	292	305	java/lang/Exception
    //   295	302	305	java/lang/Exception
    //   43	53	313	java/lang/Exception
    //   56	64	313	java/lang/Exception
    //   218	233	313	java/lang/Exception
    //   236	254	313	java/lang/Exception
    //   254	269	313	java/lang/Exception
    //   389	399	533	finally
    //   405	412	533	finally
    //   430	439	533	finally
    //   445	452	533	finally
    //   468	476	533	finally
    //   482	503	533	finally
    //   522	526	533	finally
    //   389	399	541	java/lang/Exception
    //   405	412	541	java/lang/Exception
    //   430	439	541	java/lang/Exception
    //   445	452	541	java/lang/Exception
    //   468	476	541	java/lang/Exception
    //   482	503	541	java/lang/Exception
    //   522	526	541	java/lang/Exception
    //   352	358	592	finally
    //   365	376	592	finally
    //   609	619	592	finally
    //   352	358	599	java/lang/Exception
    //   365	376	599	java/lang/Exception
  }
  
  /* Error */
  private String b(Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 60	com/tencent/mobileqq/haoliyou/UriParserPathHelper:e	Landroid/app/Activity;
    //   9: invokevirtual 288	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 93	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc 95
    //   21: aastore
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 101	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: astore_3
    //   31: aload_1
    //   32: astore 4
    //   34: aload_1
    //   35: ldc 95
    //   37: invokeinterface 111 2 0
    //   42: istore_2
    //   43: aload_1
    //   44: astore_3
    //   45: aload_1
    //   46: astore 4
    //   48: aload_1
    //   49: invokeinterface 107 1 0
    //   54: pop
    //   55: aload_1
    //   56: astore_3
    //   57: aload_1
    //   58: astore 4
    //   60: aload_1
    //   61: iload_2
    //   62: invokeinterface 115 2 0
    //   67: astore 5
    //   69: aload_1
    //   70: ifnull +9 -> 79
    //   73: aload_1
    //   74: invokeinterface 118 1 0
    //   79: aload 5
    //   81: areturn
    //   82: astore_1
    //   83: goto +33 -> 116
    //   86: astore_1
    //   87: aload 4
    //   89: astore_3
    //   90: ldc 236
    //   92: iconst_1
    //   93: ldc_w 290
    //   96: aload_1
    //   97: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload 4
    //   102: ifnull +10 -> 112
    //   105: aload 4
    //   107: invokeinterface 118 1 0
    //   112: ldc_w 292
    //   115: areturn
    //   116: aload_3
    //   117: ifnull +9 -> 126
    //   120: aload_3
    //   121: invokeinterface 118 1 0
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	UriParserPathHelper
    //   0	128	1	paramUri	Uri
    //   42	20	2	k	int
    //   4	117	3	localUri1	Uri
    //   1	105	4	localUri2	Uri
    //   67	13	5	str	String
    // Exception table:
    //   from	to	target	type
    //   5	29	82	finally
    //   34	43	82	finally
    //   48	55	82	finally
    //   60	69	82	finally
    //   90	100	82	finally
    //   5	29	86	java/lang/Exception
    //   34	43	86	java/lang/Exception
    //   48	55	86	java/lang/Exception
    //   60	69	86	java/lang/Exception
  }
  
  /* Error */
  private String b(Uri paramUri, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 35	com/tencent/mobileqq/haoliyou/UriParserPathHelper:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_1
    //   4: invokevirtual 296	android/net/Uri:toString	()Ljava/lang/String;
    //   7: invokevirtual 300	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 93	java/lang/String
    //   13: astore 7
    //   15: iload_2
    //   16: ifeq +26 -> 42
    //   19: aload 7
    //   21: ifnull +21 -> 42
    //   24: new 174	java/io/File
    //   27: dup
    //   28: aload 7
    //   30: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: invokevirtual 179	java/io/File:exists	()Z
    //   36: ifeq +6 -> 42
    //   39: aload 7
    //   41: areturn
    //   42: aconst_null
    //   43: putstatic 302	com/tencent/mobileqq/haoliyou/UriParserPathHelper:b	Ljava/lang/String;
    //   46: aload_0
    //   47: getfield 60	com/tencent/mobileqq/haoliyou/UriParserPathHelper:e	Landroid/app/Activity;
    //   50: invokevirtual 288	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   53: astore 11
    //   55: aload 11
    //   57: aload_1
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 101	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 8
    //   67: aload 8
    //   69: ifnonnull +30 -> 99
    //   72: aload 8
    //   74: astore 7
    //   76: ldc 236
    //   78: iconst_1
    //   79: ldc_w 304
    //   82: invokestatic 307	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload 8
    //   87: ifnull +10 -> 97
    //   90: aload 8
    //   92: invokeinterface 118 1 0
    //   97: aconst_null
    //   98: areturn
    //   99: aload 8
    //   101: astore 7
    //   103: aload 8
    //   105: ldc_w 265
    //   108: invokeinterface 268 2 0
    //   113: istore_3
    //   114: aload 8
    //   116: astore 7
    //   118: aload 8
    //   120: ldc_w 309
    //   123: invokeinterface 268 2 0
    //   128: istore 4
    //   130: aload 8
    //   132: astore 7
    //   134: aload 8
    //   136: invokeinterface 107 1 0
    //   141: pop
    //   142: aload 8
    //   144: astore 7
    //   146: aload 8
    //   148: iload 4
    //   150: invokeinterface 313 2 0
    //   155: lstore 5
    //   157: iload_3
    //   158: iconst_m1
    //   159: if_icmpne +60 -> 219
    //   162: aload 8
    //   164: astore 7
    //   166: new 208	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   173: astore 9
    //   175: aload 8
    //   177: astore 7
    //   179: aload 9
    //   181: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   184: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 8
    //   190: astore 7
    //   192: aload 9
    //   194: ldc_w 292
    //   197: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 8
    //   203: astore 7
    //   205: aload 9
    //   207: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: astore 9
    //   212: aload 9
    //   214: astore 7
    //   216: goto +21 -> 237
    //   219: aload 8
    //   221: astore 7
    //   223: aload 8
    //   225: iload_3
    //   226: invokeinterface 115 2 0
    //   231: astore 9
    //   233: aload 9
    //   235: astore 7
    //   237: aload 8
    //   239: ifnull +10 -> 249
    //   242: aload 8
    //   244: invokeinterface 118 1 0
    //   249: goto +157 -> 406
    //   252: astore_1
    //   253: goto +541 -> 794
    //   256: astore 9
    //   258: goto +15 -> 273
    //   261: astore_1
    //   262: aconst_null
    //   263: astore 7
    //   265: goto +529 -> 794
    //   268: astore 9
    //   270: aconst_null
    //   271: astore 8
    //   273: aload 8
    //   275: astore 7
    //   277: ldc 236
    //   279: iconst_1
    //   280: ldc_w 290
    //   283: aload 9
    //   285: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: aload 8
    //   290: astore 7
    //   292: ldc_w 320
    //   295: aload_1
    //   296: invokevirtual 323	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   299: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: ifne +44 -> 346
    //   305: aload 8
    //   307: astore 7
    //   309: ldc 236
    //   311: iconst_1
    //   312: iconst_2
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: ldc_w 325
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: aload_1
    //   325: invokevirtual 323	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   328: aastore
    //   329: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   332: aload 8
    //   334: ifnull +10 -> 344
    //   337: aload 8
    //   339: invokeinterface 118 1 0
    //   344: aconst_null
    //   345: areturn
    //   346: aload 8
    //   348: astore 7
    //   350: new 174	java/io/File
    //   353: dup
    //   354: aload_0
    //   355: aload_1
    //   356: invokespecial 327	com/tencent/mobileqq/haoliyou/UriParserPathHelper:b	(Landroid/net/Uri;)Ljava/lang/String;
    //   359: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   362: invokevirtual 330	java/io/File:getName	()Ljava/lang/String;
    //   365: astore 10
    //   367: aload 8
    //   369: astore 7
    //   371: aload_0
    //   372: getfield 60	com/tencent/mobileqq/haoliyou/UriParserPathHelper:e	Landroid/app/Activity;
    //   375: invokevirtual 288	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   378: aload_1
    //   379: invokevirtual 272	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   382: invokevirtual 333	java/io/InputStream:available	()I
    //   385: istore_3
    //   386: iload_3
    //   387: i2l
    //   388: lstore 5
    //   390: aload 8
    //   392: ifnull +10 -> 402
    //   395: aload 8
    //   397: invokeinterface 118 1 0
    //   402: aload 10
    //   404: astore 7
    //   406: lload 5
    //   408: l2f
    //   409: invokestatic 339	com/tencent/mobileqq/utils/FileUtils:getAvailableExternalMemorySize	()F
    //   412: fcmpl
    //   413: ifle +18 -> 431
    //   416: aload_0
    //   417: getfield 60	com/tencent/mobileqq/haoliyou/UriParserPathHelper:e	Landroid/app/Activity;
    //   420: ldc_w 340
    //   423: invokevirtual 341	android/app/Activity:getString	(I)Ljava/lang/String;
    //   426: putstatic 302	com/tencent/mobileqq/haoliyou/UriParserPathHelper:b	Ljava/lang/String;
    //   429: aconst_null
    //   430: areturn
    //   431: new 208	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   438: astore 8
    //   440: aload 8
    //   442: aload_0
    //   443: getfield 60	com/tencent/mobileqq/haoliyou/UriParserPathHelper:e	Landroid/app/Activity;
    //   446: invokevirtual 345	android/app/Activity:getExternalCacheDir	()Ljava/io/File;
    //   449: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 8
    //   455: ldc_w 347
    //   458: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload 8
    //   464: ldc_w 349
    //   467: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 8
    //   473: ldc_w 347
    //   476: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 8
    //   482: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: astore 8
    //   487: new 208	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   494: astore 9
    //   496: aload 9
    //   498: aload 8
    //   500: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 9
    //   506: aload 8
    //   508: aload 7
    //   510: invokestatic 353	com/tencent/mobileqq/utils/FileUtils:getUnitFileName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   513: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 9
    //   519: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: astore 7
    //   524: aload 8
    //   526: invokestatic 355	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	(Ljava/lang/String;)V
    //   529: new 174	java/io/File
    //   532: dup
    //   533: aload 8
    //   535: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   538: astore 8
    //   540: aload 8
    //   542: invokevirtual 179	java/io/File:exists	()Z
    //   545: ifne +22 -> 567
    //   548: aload 8
    //   550: invokevirtual 358	java/io/File:mkdirs	()Z
    //   553: ifne +14 -> 567
    //   556: ldc_w 359
    //   559: invokestatic 143	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   562: putstatic 302	com/tencent/mobileqq/haoliyou/UriParserPathHelper:b	Ljava/lang/String;
    //   565: aconst_null
    //   566: areturn
    //   567: aload 11
    //   569: aload_1
    //   570: invokevirtual 272	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   573: astore 8
    //   575: aload 8
    //   577: ifnonnull +14 -> 591
    //   580: ldc 236
    //   582: iconst_1
    //   583: ldc_w 361
    //   586: invokestatic 307	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   589: aconst_null
    //   590: areturn
    //   591: lload 5
    //   593: ldc2_w 362
    //   596: lcmp
    //   597: ifle +141 -> 738
    //   600: aload_0
    //   601: iconst_1
    //   602: putfield 365	com/tencent/mobileqq/haoliyou/UriParserPathHelper:c	Z
    //   605: new 158	com/tencent/mobileqq/utils/QQCustomDialog
    //   608: dup
    //   609: aload_0
    //   610: getfield 60	com/tencent/mobileqq/haoliyou/UriParserPathHelper:e	Landroid/app/Activity;
    //   613: ldc_w 366
    //   616: invokespecial 369	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   619: astore 9
    //   621: aload 9
    //   623: ldc_w 370
    //   626: invokevirtual 373	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   629: aload 9
    //   631: aload_0
    //   632: getfield 72	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	Landroid/content/Context;
    //   635: ldc_w 374
    //   638: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   641: invokevirtual 378	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   644: pop
    //   645: aload 9
    //   647: aload_0
    //   648: getfield 72	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	Landroid/content/Context;
    //   651: ldc_w 379
    //   654: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   657: invokevirtual 383	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   660: pop
    //   661: aload 9
    //   663: iconst_0
    //   664: invokevirtual 387	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   667: aload 9
    //   669: iconst_0
    //   670: invokevirtual 390	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   673: aload 9
    //   675: aload_0
    //   676: getfield 72	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	Landroid/content/Context;
    //   679: ldc_w 391
    //   682: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   685: new 393	com/tencent/mobileqq/haoliyou/UriParserPathHelper$1
    //   688: dup
    //   689: aload_0
    //   690: aload 8
    //   692: invokespecial 396	com/tencent/mobileqq/haoliyou/UriParserPathHelper$1:<init>	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;Ljava/io/InputStream;)V
    //   695: invokevirtual 400	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   698: pop
    //   699: aload 9
    //   701: aload_0
    //   702: getfield 72	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	Landroid/content/Context;
    //   705: ldc_w 401
    //   708: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   711: new 403	com/tencent/mobileqq/haoliyou/UriParserPathHelper$2
    //   714: dup
    //   715: aload_0
    //   716: aload_1
    //   717: aload 7
    //   719: aload 8
    //   721: lload 5
    //   723: invokespecial 405	com/tencent/mobileqq/haoliyou/UriParserPathHelper$2:<init>	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   726: invokevirtual 408	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   729: pop
    //   730: aload 9
    //   732: invokevirtual 165	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   735: aload 7
    //   737: areturn
    //   738: aload_0
    //   739: aload_1
    //   740: aload 7
    //   742: aload 8
    //   744: lload 5
    //   746: invokespecial 168	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   749: aload 7
    //   751: areturn
    //   752: astore_1
    //   753: ldc 236
    //   755: iconst_1
    //   756: ldc_w 410
    //   759: aload_1
    //   760: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   763: aconst_null
    //   764: areturn
    //   765: aload 8
    //   767: astore 7
    //   769: ldc 236
    //   771: iconst_1
    //   772: ldc_w 412
    //   775: aload 9
    //   777: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   780: aload 8
    //   782: ifnull +10 -> 792
    //   785: aload 8
    //   787: invokeinterface 118 1 0
    //   792: aconst_null
    //   793: areturn
    //   794: aload 7
    //   796: ifnull +10 -> 806
    //   799: aload 7
    //   801: invokeinterface 118 1 0
    //   806: aload_1
    //   807: athrow
    //   808: astore_1
    //   809: goto -44 -> 765
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	812	0	this	UriParserPathHelper
    //   0	812	1	paramUri	Uri
    //   0	812	2	paramBoolean	boolean
    //   113	274	3	k	int
    //   128	21	4	m	int
    //   155	590	5	l	long
    //   13	787	7	localObject1	Object
    //   65	721	8	localObject2	Object
    //   173	61	9	localObject3	Object
    //   256	1	9	localException1	Exception
    //   268	16	9	localException2	Exception
    //   494	282	9	localObject4	Object
    //   365	38	10	str	String
    //   53	515	11	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   76	85	252	finally
    //   103	114	252	finally
    //   118	130	252	finally
    //   134	142	252	finally
    //   146	157	252	finally
    //   166	175	252	finally
    //   179	188	252	finally
    //   192	201	252	finally
    //   205	212	252	finally
    //   223	233	252	finally
    //   277	288	252	finally
    //   292	305	252	finally
    //   309	332	252	finally
    //   350	367	252	finally
    //   371	386	252	finally
    //   769	780	252	finally
    //   76	85	256	java/lang/Exception
    //   103	114	256	java/lang/Exception
    //   118	130	256	java/lang/Exception
    //   134	142	256	java/lang/Exception
    //   146	157	256	java/lang/Exception
    //   166	175	256	java/lang/Exception
    //   179	188	256	java/lang/Exception
    //   192	201	256	java/lang/Exception
    //   205	212	256	java/lang/Exception
    //   223	233	256	java/lang/Exception
    //   55	67	261	finally
    //   55	67	268	java/lang/Exception
    //   431	565	752	java/lang/Exception
    //   567	575	752	java/lang/Exception
    //   580	589	752	java/lang/Exception
    //   600	735	752	java/lang/Exception
    //   738	749	752	java/lang/Exception
    //   350	367	808	java/lang/Exception
    //   371	386	808	java/lang/Exception
  }
  
  private String b(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.e("UriParserPathHelper", 2, new Object[] { "getFilePathAsync copy", Boolean.valueOf(paramBoolean1) });
    String str = paramUri.getScheme();
    if ((str != null) && (!str.equals("file")))
    {
      if (str.equals("content")) {
        try
        {
          str = b(paramUri);
          if ((!new File(str).canRead()) && (paramBoolean1))
          {
            str = b(paramUri, paramBoolean2);
            return str;
          }
          return str;
        }
        catch (Throwable localThrowable)
        {
          if (QLog.isColorLevel()) {
            QLog.e("UriParserPathHelper", 2, "Exception", localThrowable);
          }
          if (paramBoolean1) {
            return b(paramUri, paramBoolean2);
          }
        }
      }
      return null;
    }
    return new File(paramUri.getPath()).getAbsolutePath();
  }
  
  private void b(String paramString)
  {
    if (!this.j) {
      return;
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.e, 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    localQQCustomDialog.setTitle(this.a.getString(2131917233));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(this.a.getString(2131887625), new UriParserPathHelper.6(this));
    if (!this.e.isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  private void d()
  {
    QQCustomDialog localQQCustomDialog = this.h;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  public String a(Uri paramUri)
  {
    return a(paramUri, true);
  }
  
  public String a(Uri paramUri, boolean paramBoolean)
  {
    return a(paramUri, paramBoolean, true);
  }
  
  public String a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uri= ");
      ((StringBuilder)localObject1).append(paramUri);
      QLog.d("UriParserPathHelper", 2, ((StringBuilder)localObject1).toString());
    }
    this.c = false;
    if ((VersionUtils.l()) && ("com.android.fileexplorer.fileprovider".equalsIgnoreCase(paramUri.getAuthority())))
    {
      localObject1 = paramUri.getPathSegments();
      if ((((List)localObject1).size() >= 2) && ("external_files".equalsIgnoreCase((String)((List)localObject1).get(0))))
      {
        paramUri = paramUri.getPath().replaceFirst("\\/external_files", AppConstants.SDCARD_ROOT);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Nougat path: ");
          ((StringBuilder)localObject1).append(paramUri);
          QLog.d("UriParserPathHelper", 2, ((StringBuilder)localObject1).toString());
        }
        return paramUri;
      }
    }
    else if (VersionUtils.i())
    {
      localObject1 = paramUri.getPathSegments();
      int m = ((List)localObject1).size();
      int k = 1;
      if ((m >= 2) && ("document".equals(((List)localObject1).get(0))))
      {
        Object localObject2 = (String)((List)localObject1).get(1);
        try
        {
          boolean bool = "com.android.externalstorage.documents".equals(paramUri.getAuthority());
          if (bool)
          {
            localObject1 = ((String)localObject2).split(":");
            if ("primary".equalsIgnoreCase(localObject1[0]))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory());
              ((StringBuilder)localObject2).append("/");
              ((StringBuilder)localObject2).append(localObject1[1]);
              return ((StringBuilder)localObject2).toString();
            }
          }
          else
          {
            bool = "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
            localObject1 = null;
            if (bool) {
              return a(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf((String)localObject2).longValue()), null, null);
            }
            if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
            {
              localObject2 = ((String)localObject2).split(":");
              Object localObject3 = localObject2[0];
              if ("image".equals(localObject3)) {
                localObject1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
              } else if ("video".equals(localObject3)) {
                localObject1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
              } else if ("audio".equals(localObject3)) {
                localObject1 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
              }
              localObject2 = localObject2[1];
              if (localObject1 != null) {
                return a((Uri)localObject1, "_id=?", new String[] { localObject2 });
              }
              QLog.e("UriParserPathHelper", 1, "getPathFromUri null == contentUri");
            }
            else
            {
              "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
            }
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label612;
          }
        }
        QLog.d("UriParserPathHelper", 2, "handle exeption ", localException);
      }
      else if ((localException.size() >= 2) && ("my_external".equals(localException.get(0))) && ("com.android.contacts.files".equals(paramUri.getAuthority())))
      {
        paramUri = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
        while (k < localException.size())
        {
          paramUri.append('/');
          paramUri.append((String)localException.get(k));
          k += 1;
        }
        return paramUri.toString();
      }
    }
    label612:
    return b(paramUri, paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return this.i.get() > 0;
  }
  
  protected String b()
  {
    String str2 = b;
    String str1 = str2;
    if (str2 == null) {
      str1 = this.a.getString(2131916548);
    }
    return str1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = paramMessage.what;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k == 3)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleMessage.progress: ");
          ((StringBuilder)localObject).append(paramMessage.arg1);
          QLog.i("UriParserPathHelper", 1, ((StringBuilder)localObject).toString());
          localObject = this.h;
          if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
            this.h.setProgress(paramMessage.arg1);
          }
        }
      }
      else {
        d();
      }
    }
    else
    {
      d();
      b(b());
      paramMessage = this.f;
      if (paramMessage != null)
      {
        paramMessage.a(null);
        this.f = null;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.UriParserPathHelper
 * JD-Core Version:    0.7.0.1
 */