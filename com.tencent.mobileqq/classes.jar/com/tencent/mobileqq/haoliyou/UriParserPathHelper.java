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
  public static String a;
  private static ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Context a;
  private UriParserPathHelper.IOnFileCopyFinishListener jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper$IOnFileCopyFinishListener;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  public boolean a;
  private boolean b;
  
  public UriParserPathHelper(Activity paramActivity, boolean paramBoolean, UriParserPathHelper.IOnFileCopyFinishListener paramIOnFileCopyFinishListener)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
    this.b = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper$IOnFileCopyFinishListener = paramIOnFileCopyFinishListener;
  }
  
  /* Error */
  public static String a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 78	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore_3
    //   4: aload_3
    //   5: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   8: aload_0
    //   9: iconst_1
    //   10: anewarray 86	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc 88
    //   17: aastore
    //   18: aload_1
    //   19: aload_2
    //   20: aconst_null
    //   21: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +46 -> 72
    //   29: aload_0
    //   30: invokeinterface 100 1 0
    //   35: ifeq +37 -> 72
    //   38: aload_0
    //   39: aload_0
    //   40: ldc 88
    //   42: invokeinterface 104 2 0
    //   47: invokeinterface 108 2 0
    //   52: astore_1
    //   53: aload_0
    //   54: ifnull +9 -> 63
    //   57: aload_0
    //   58: invokeinterface 111 1 0
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
    //   87: invokeinterface 111 1 0
    //   92: aload_1
    //   93: athrow
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: ifnull +9 -> 106
    //   100: aload_0
    //   101: invokeinterface 111 1 0
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
  
  private void a()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  private void a(Uri paramUri, String paramString, InputStream paramInputStream, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    ThreadManager.post(new UriParserPathHelper.3(this, paramString, paramInputStream, paramLong, paramUri), 5, null, true);
    if (!this.b) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext.getString(2131691299), HardCodeUtil.a(2131715698), new UriParserPathHelper.4(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new UriParserPathHelper.5(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    paramString = paramString.listFiles();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
        localObject.delete();
      }
      i += 1;
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
    //   7: invokevirtual 205	android/net/Uri:getScheme	()Ljava/lang/String;
    //   10: astore 7
    //   12: new 207	java/lang/StringBuilder
    //   15: dup
    //   16: ldc 209
    //   18: invokespecial 210	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: astore 11
    //   23: aload 11
    //   25: ldc 212
    //   27: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 11
    //   33: aload_0
    //   34: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 7
    //   40: ifnull +214 -> 254
    //   43: aload 7
    //   45: ldc 221
    //   47: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +6 -> 56
    //   53: goto +201 -> 254
    //   56: aload 7
    //   58: ldc 227
    //   60: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: istore_3
    //   64: iload_3
    //   65: ifeq +604 -> 669
    //   68: aload_1
    //   69: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   72: aload_0
    //   73: iconst_1
    //   74: anewarray 86	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: ldc 88
    //   81: aastore
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore 7
    //   90: aload 7
    //   92: ldc 88
    //   94: invokeinterface 104 2 0
    //   99: istore_2
    //   100: aload 7
    //   102: invokeinterface 100 1 0
    //   107: pop
    //   108: aload 7
    //   110: iload_2
    //   111: invokeinterface 108 2 0
    //   116: astore 8
    //   118: aload 7
    //   120: invokeinterface 111 1 0
    //   125: aload 8
    //   127: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: ifne +45 -> 175
    //   133: ldc 235
    //   135: iconst_1
    //   136: iconst_2
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: ldc 237
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: aload 8
    //   149: aastore
    //   150: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   153: new 173	java/io/File
    //   156: dup
    //   157: aload 8
    //   159: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
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
    //   184: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   208: ldc 235
    //   210: iconst_1
    //   211: ldc 253
    //   213: aload 7
    //   215: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   218: aload 11
    //   220: ldc 248
    //   222: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 11
    //   228: iconst_0
    //   229: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: goto +436 -> 669
    //   236: aload 11
    //   238: ldc 248
    //   240: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 11
    //   246: iconst_0
    //   247: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 7
    //   253: athrow
    //   254: new 173	java/io/File
    //   257: dup
    //   258: aload_0
    //   259: invokevirtual 260	android/net/Uri:getPath	()Ljava/lang/String;
    //   262: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
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
    //   285: ldc_w 262
    //   288: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   317: ldc 235
    //   319: iconst_1
    //   320: ldc_w 264
    //   323: aload 7
    //   325: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   353: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
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
    //   372: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
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
    //   390: ldc_w 266
    //   393: invokeinterface 269 2 0
    //   398: istore_2
    //   399: iload_3
    //   400: istore 5
    //   402: iload_3
    //   403: istore 6
    //   405: aload_1
    //   406: invokeinterface 100 1 0
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
    //   432: invokeinterface 108 2 0
    //   437: astore 7
    //   439: iload_3
    //   440: istore 5
    //   442: iload_3
    //   443: istore 6
    //   445: aload 12
    //   447: aload_0
    //   448: invokevirtual 273	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
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
    //   470: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   473: ifne +33 -> 506
    //   476: iload_3
    //   477: istore 5
    //   479: iload_3
    //   480: istore 6
    //   482: ldc 235
    //   484: iconst_1
    //   485: iconst_2
    //   486: anewarray 4	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: ldc_w 275
    //   494: aastore
    //   495: dup
    //   496: iconst_1
    //   497: aload 7
    //   499: aastore
    //   500: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
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
    //   523: invokevirtual 280	java/io/InputStream:close	()V
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
    //   563: invokeinterface 111 1 0
    //   568: iload 5
    //   570: istore 4
    //   572: aload 11
    //   574: ldc_w 282
    //   577: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   609: ldc 235
    //   611: iconst_1
    //   612: ldc_w 284
    //   615: aload_1
    //   616: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   619: iload_3
    //   620: istore 4
    //   622: aload_0
    //   623: ifnull -51 -> 572
    //   626: aload_0
    //   627: invokeinterface 111 1 0
    //   632: iload_3
    //   633: istore 4
    //   635: goto -63 -> 572
    //   638: aload_1
    //   639: ifnull +9 -> 648
    //   642: aload_1
    //   643: invokeinterface 111 1 0
    //   648: aload 11
    //   650: ldc_w 282
    //   653: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   99	333	2	i	int
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
    //   6: getfield 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   9: invokevirtual 288	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 86	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc 88
    //   21: aastore
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: astore_3
    //   31: aload_1
    //   32: astore 4
    //   34: aload_1
    //   35: ldc 88
    //   37: invokeinterface 104 2 0
    //   42: istore_2
    //   43: aload_1
    //   44: astore_3
    //   45: aload_1
    //   46: astore 4
    //   48: aload_1
    //   49: invokeinterface 100 1 0
    //   54: pop
    //   55: aload_1
    //   56: astore_3
    //   57: aload_1
    //   58: astore 4
    //   60: aload_1
    //   61: iload_2
    //   62: invokeinterface 108 2 0
    //   67: astore 5
    //   69: aload_1
    //   70: ifnull +9 -> 79
    //   73: aload_1
    //   74: invokeinterface 111 1 0
    //   79: aload 5
    //   81: areturn
    //   82: astore_1
    //   83: goto +33 -> 116
    //   86: astore_1
    //   87: aload 4
    //   89: astore_3
    //   90: ldc 235
    //   92: iconst_1
    //   93: ldc_w 290
    //   96: aload_1
    //   97: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload 4
    //   102: ifnull +10 -> 112
    //   105: aload 4
    //   107: invokeinterface 111 1 0
    //   112: ldc_w 292
    //   115: areturn
    //   116: aload_3
    //   117: ifnull +9 -> 126
    //   120: aload_3
    //   121: invokeinterface 111 1 0
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	UriParserPathHelper
    //   0	128	1	paramUri	Uri
    //   42	20	2	i	int
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
  
  private void b(String paramString)
  {
    if (!this.b) {
      return;
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131756189);
    localQQCustomDialog.setContentView(2131558978);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131719632));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690706), new UriParserPathHelper.6(this));
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  /* Error */
  private String c(Uri paramUri)
  {
    // Byte code:
    //   0: getstatic 27	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_1
    //   4: invokevirtual 331	android/net/Uri:toString	()Ljava/lang/String;
    //   7: invokevirtual 335	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 86	java/lang/String
    //   13: astore 6
    //   15: aload 6
    //   17: ifnull +21 -> 38
    //   20: new 173	java/io/File
    //   23: dup
    //   24: aload 6
    //   26: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 178	java/io/File:exists	()Z
    //   32: ifeq +6 -> 38
    //   35: aload 6
    //   37: areturn
    //   38: aconst_null
    //   39: putstatic 337	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   46: invokevirtual 288	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   49: astore 10
    //   51: aload 10
    //   53: aload_1
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore 7
    //   63: aload 7
    //   65: ifnonnull +30 -> 95
    //   68: aload 7
    //   70: astore 6
    //   72: ldc 235
    //   74: iconst_1
    //   75: ldc_w 339
    //   78: invokestatic 343	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload 7
    //   83: ifnull +10 -> 93
    //   86: aload 7
    //   88: invokeinterface 111 1 0
    //   93: aconst_null
    //   94: areturn
    //   95: aload 7
    //   97: astore 6
    //   99: aload 7
    //   101: ldc_w 266
    //   104: invokeinterface 269 2 0
    //   109: istore_2
    //   110: aload 7
    //   112: astore 6
    //   114: aload 7
    //   116: ldc_w 345
    //   119: invokeinterface 269 2 0
    //   124: istore_3
    //   125: aload 7
    //   127: astore 6
    //   129: aload 7
    //   131: invokeinterface 100 1 0
    //   136: pop
    //   137: aload 7
    //   139: astore 6
    //   141: aload 7
    //   143: iload_3
    //   144: invokeinterface 349 2 0
    //   149: lstore 4
    //   151: iload_2
    //   152: iconst_m1
    //   153: if_icmpne +60 -> 213
    //   156: aload 7
    //   158: astore 6
    //   160: new 207	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   167: astore 8
    //   169: aload 7
    //   171: astore 6
    //   173: aload 8
    //   175: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   178: invokevirtual 353	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 7
    //   184: astore 6
    //   186: aload 8
    //   188: ldc_w 292
    //   191: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 7
    //   197: astore 6
    //   199: aload 8
    //   201: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: astore 8
    //   206: aload 8
    //   208: astore 6
    //   210: goto +21 -> 231
    //   213: aload 7
    //   215: astore 6
    //   217: aload 7
    //   219: iload_2
    //   220: invokeinterface 108 2 0
    //   225: astore 8
    //   227: aload 8
    //   229: astore 6
    //   231: aload 7
    //   233: ifnull +10 -> 243
    //   236: aload 7
    //   238: invokeinterface 111 1 0
    //   243: goto +157 -> 400
    //   246: astore_1
    //   247: goto +541 -> 788
    //   250: astore 8
    //   252: goto +15 -> 267
    //   255: astore_1
    //   256: aconst_null
    //   257: astore 6
    //   259: goto +529 -> 788
    //   262: astore 8
    //   264: aconst_null
    //   265: astore 7
    //   267: aload 7
    //   269: astore 6
    //   271: ldc 235
    //   273: iconst_1
    //   274: ldc_w 290
    //   277: aload 8
    //   279: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: aload 7
    //   284: astore 6
    //   286: ldc_w 356
    //   289: aload_1
    //   290: invokevirtual 359	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   293: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   296: ifne +44 -> 340
    //   299: aload 7
    //   301: astore 6
    //   303: ldc 235
    //   305: iconst_1
    //   306: iconst_2
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: ldc_w 361
    //   315: aastore
    //   316: dup
    //   317: iconst_1
    //   318: aload_1
    //   319: invokevirtual 359	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   322: aastore
    //   323: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   326: aload 7
    //   328: ifnull +10 -> 338
    //   331: aload 7
    //   333: invokeinterface 111 1 0
    //   338: aconst_null
    //   339: areturn
    //   340: aload 7
    //   342: astore 6
    //   344: new 173	java/io/File
    //   347: dup
    //   348: aload_0
    //   349: aload_1
    //   350: invokespecial 363	com/tencent/mobileqq/haoliyou/UriParserPathHelper:b	(Landroid/net/Uri;)Ljava/lang/String;
    //   353: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   356: invokevirtual 366	java/io/File:getName	()Ljava/lang/String;
    //   359: astore 9
    //   361: aload 7
    //   363: astore 6
    //   365: aload_0
    //   366: getfield 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   369: invokevirtual 288	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   372: aload_1
    //   373: invokevirtual 273	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   376: invokevirtual 369	java/io/InputStream:available	()I
    //   379: istore_2
    //   380: iload_2
    //   381: i2l
    //   382: lstore 4
    //   384: aload 7
    //   386: ifnull +10 -> 396
    //   389: aload 7
    //   391: invokeinterface 111 1 0
    //   396: aload 9
    //   398: astore 6
    //   400: lload 4
    //   402: l2f
    //   403: invokestatic 375	com/tencent/mobileqq/utils/FileUtils:getAvailableExternalMemorySize	()F
    //   406: fcmpl
    //   407: ifle +18 -> 425
    //   410: aload_0
    //   411: getfield 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   414: ldc_w 376
    //   417: invokevirtual 377	android/app/Activity:getString	(I)Ljava/lang/String;
    //   420: putstatic 337	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   423: aconst_null
    //   424: areturn
    //   425: new 207	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   432: astore 7
    //   434: aload 7
    //   436: aload_0
    //   437: getfield 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   440: invokevirtual 381	android/app/Activity:getExternalCacheDir	()Ljava/io/File;
    //   443: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 7
    //   449: ldc_w 383
    //   452: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload 7
    //   458: ldc_w 385
    //   461: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload 7
    //   467: ldc_w 383
    //   470: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload 7
    //   476: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: astore 7
    //   481: new 207	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   488: astore 8
    //   490: aload 8
    //   492: aload 7
    //   494: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 8
    //   500: aload 7
    //   502: aload 6
    //   504: invokestatic 389	com/tencent/mobileqq/utils/FileUtils:getUnitFileName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   507: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 8
    //   513: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: astore 6
    //   518: aload 7
    //   520: invokestatic 391	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	(Ljava/lang/String;)V
    //   523: new 173	java/io/File
    //   526: dup
    //   527: aload 7
    //   529: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   532: astore 7
    //   534: aload 7
    //   536: invokevirtual 178	java/io/File:exists	()Z
    //   539: ifne +22 -> 561
    //   542: aload 7
    //   544: invokevirtual 394	java/io/File:mkdirs	()Z
    //   547: ifne +14 -> 561
    //   550: ldc_w 395
    //   553: invokestatic 144	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   556: putstatic 337	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   559: aconst_null
    //   560: areturn
    //   561: aload 10
    //   563: aload_1
    //   564: invokevirtual 273	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   567: astore 7
    //   569: aload 7
    //   571: ifnonnull +14 -> 585
    //   574: ldc 235
    //   576: iconst_1
    //   577: ldc_w 397
    //   580: invokestatic 343	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   583: aconst_null
    //   584: areturn
    //   585: lload 4
    //   587: ldc2_w 398
    //   590: lcmp
    //   591: ifle +141 -> 732
    //   594: aload_0
    //   595: iconst_1
    //   596: putfield 401	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_Boolean	Z
    //   599: new 118	com/tencent/mobileqq/utils/QQCustomDialog
    //   602: dup
    //   603: aload_0
    //   604: getfield 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   607: ldc_w 293
    //   610: invokespecial 296	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   613: astore 8
    //   615: aload 8
    //   617: ldc_w 297
    //   620: invokevirtual 300	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   623: aload 8
    //   625: aload_0
    //   626: getfield 64	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   629: ldc_w 301
    //   632: invokevirtual 139	android/content/Context:getString	(I)Ljava/lang/String;
    //   635: invokevirtual 305	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   638: pop
    //   639: aload 8
    //   641: aload_0
    //   642: getfield 64	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   645: ldc_w 402
    //   648: invokevirtual 139	android/content/Context:getString	(I)Ljava/lang/String;
    //   651: invokevirtual 309	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   654: pop
    //   655: aload 8
    //   657: iconst_0
    //   658: invokevirtual 313	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   661: aload 8
    //   663: iconst_0
    //   664: invokevirtual 316	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   667: aload 8
    //   669: aload_0
    //   670: getfield 64	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   673: ldc_w 403
    //   676: invokevirtual 139	android/content/Context:getString	(I)Ljava/lang/String;
    //   679: new 405	com/tencent/mobileqq/haoliyou/UriParserPathHelper$1
    //   682: dup
    //   683: aload_0
    //   684: aload 7
    //   686: invokespecial 408	com/tencent/mobileqq/haoliyou/UriParserPathHelper$1:<init>	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;Ljava/io/InputStream;)V
    //   689: invokevirtual 324	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   692: pop
    //   693: aload 8
    //   695: aload_0
    //   696: getfield 64	com/tencent/mobileqq/haoliyou/UriParserPathHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   699: ldc_w 409
    //   702: invokevirtual 139	android/content/Context:getString	(I)Ljava/lang/String;
    //   705: new 411	com/tencent/mobileqq/haoliyou/UriParserPathHelper$2
    //   708: dup
    //   709: aload_0
    //   710: aload_1
    //   711: aload 6
    //   713: aload 7
    //   715: lload 4
    //   717: invokespecial 413	com/tencent/mobileqq/haoliyou/UriParserPathHelper$2:<init>	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   720: invokevirtual 416	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   723: pop
    //   724: aload 8
    //   726: invokevirtual 164	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   729: aload 6
    //   731: areturn
    //   732: aload_0
    //   733: aload_1
    //   734: aload 6
    //   736: aload 7
    //   738: lload 4
    //   740: invokespecial 167	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   743: aload 6
    //   745: areturn
    //   746: astore_1
    //   747: ldc 235
    //   749: iconst_1
    //   750: ldc_w 418
    //   753: aload_1
    //   754: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   757: aconst_null
    //   758: areturn
    //   759: aload 7
    //   761: astore 6
    //   763: ldc 235
    //   765: iconst_1
    //   766: ldc_w 420
    //   769: aload 8
    //   771: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   774: aload 7
    //   776: ifnull +10 -> 786
    //   779: aload 7
    //   781: invokeinterface 111 1 0
    //   786: aconst_null
    //   787: areturn
    //   788: aload 6
    //   790: ifnull +10 -> 800
    //   793: aload 6
    //   795: invokeinterface 111 1 0
    //   800: aload_1
    //   801: athrow
    //   802: astore_1
    //   803: goto -44 -> 759
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	806	0	this	UriParserPathHelper
    //   0	806	1	paramUri	Uri
    //   109	272	2	i	int
    //   124	20	3	j	int
    //   149	590	4	l	long
    //   13	781	6	localObject1	Object
    //   61	719	7	localObject2	Object
    //   167	61	8	localObject3	Object
    //   250	1	8	localException1	Exception
    //   262	16	8	localException2	Exception
    //   488	282	8	localObject4	Object
    //   359	38	9	str	String
    //   49	513	10	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   72	81	246	finally
    //   99	110	246	finally
    //   114	125	246	finally
    //   129	137	246	finally
    //   141	151	246	finally
    //   160	169	246	finally
    //   173	182	246	finally
    //   186	195	246	finally
    //   199	206	246	finally
    //   217	227	246	finally
    //   271	282	246	finally
    //   286	299	246	finally
    //   303	326	246	finally
    //   344	361	246	finally
    //   365	380	246	finally
    //   763	774	246	finally
    //   72	81	250	java/lang/Exception
    //   99	110	250	java/lang/Exception
    //   114	125	250	java/lang/Exception
    //   129	137	250	java/lang/Exception
    //   141	151	250	java/lang/Exception
    //   160	169	250	java/lang/Exception
    //   173	182	250	java/lang/Exception
    //   186	195	250	java/lang/Exception
    //   199	206	250	java/lang/Exception
    //   217	227	250	java/lang/Exception
    //   51	63	255	finally
    //   51	63	262	java/lang/Exception
    //   425	559	746	java/lang/Exception
    //   561	569	746	java/lang/Exception
    //   574	583	746	java/lang/Exception
    //   594	729	746	java/lang/Exception
    //   732	743	746	java/lang/Exception
    //   344	361	802	java/lang/Exception
    //   365	380	802	java/lang/Exception
  }
  
  protected String a()
  {
    String str2 = jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131719013);
    }
    return str1;
  }
  
  public String a(Uri paramUri)
  {
    return a(paramUri, true);
  }
  
  public String a(Uri paramUri, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uri= ");
      ((StringBuilder)localObject1).append(paramUri);
      QLog.d("UriParserPathHelper", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_Boolean = false;
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
      int j = ((List)localObject1).size();
      int i = 1;
      if ((j >= 2) && ("document".equals(((List)localObject1).get(0))))
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
            break label607;
          }
        }
        QLog.d("UriParserPathHelper", 2, "handle exeption ", localException);
      }
      else if ((localException.size() >= 2) && ("my_external".equals(localException.get(0))) && ("com.android.contacts.files".equals(paramUri.getAuthority())))
      {
        paramUri = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
        while (i < localException.size())
        {
          paramUri.append('/');
          paramUri.append((String)localException.get(i));
          i += 1;
        }
        return paramUri.toString();
      }
    }
    label607:
    return b(paramUri, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0;
  }
  
  public String b(Uri paramUri, boolean paramBoolean)
  {
    QLog.e("UriParserPathHelper", 2, new Object[] { "getFilePathAsync copy", Boolean.valueOf(paramBoolean) });
    String str = paramUri.getScheme();
    if ((str != null) && (!str.equals("file")))
    {
      if (str.equals("content")) {
        try
        {
          str = b(paramUri);
          if ((!new File(str).canRead()) && (paramBoolean))
          {
            str = c(paramUri);
            return str;
          }
          return str;
        }
        catch (Throwable localThrowable)
        {
          if (QLog.isColorLevel()) {
            QLog.e("UriParserPathHelper", 2, "Exception", localThrowable);
          }
          if (paramBoolean) {
            return c(paramUri);
          }
        }
      }
      return null;
    }
    return new File(paramUri.getPath()).getAbsolutePath();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleMessage.progress: ");
          ((StringBuilder)localObject).append(paramMessage.arg1);
          QLog.i("UriParserPathHelper", 1, ((StringBuilder)localObject).toString());
          localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setProgress(paramMessage.arg1);
          }
        }
      }
      else {
        a();
      }
    }
    else
    {
      a();
      b(a());
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper$IOnFileCopyFinishListener;
      if (paramMessage != null)
      {
        paramMessage.a(null);
        this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper$IOnFileCopyFinishListener = null;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.UriParserPathHelper
 * JD-Core Version:    0.7.0.1
 */