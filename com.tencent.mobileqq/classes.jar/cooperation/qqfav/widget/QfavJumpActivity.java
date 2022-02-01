package cooperation.qqfav.widget;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpForwardPkgManager;
import com.tencent.mobileqq.utils.JumpForwardPkgUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qqfav.QfavPluginProxyActivity;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class QfavJumpActivity
  extends BaseActivity
  implements Handler.Callback
{
  protected static String a;
  private QQMapActivityProxy jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  /* Error */
  private String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 38	cooperation/qqfav/widget/QfavJumpActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 9
    //   6: aload 9
    //   8: aload_1
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 44	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 7
    //   18: aload 7
    //   20: ifnonnull +39 -> 59
    //   23: aload 7
    //   25: astore 6
    //   27: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +15 -> 45
    //   33: aload 7
    //   35: astore 6
    //   37: ldc 52
    //   39: iconst_2
    //   40: ldc 54
    //   42: invokestatic 58	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload 7
    //   47: ifnull +10 -> 57
    //   50: aload 7
    //   52: invokeinterface 63 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: aload 7
    //   61: astore 6
    //   63: aload 7
    //   65: ldc 65
    //   67: invokeinterface 69 2 0
    //   72: istore_2
    //   73: aload 7
    //   75: astore 6
    //   77: aload 7
    //   79: ldc 71
    //   81: invokeinterface 74 2 0
    //   86: istore_3
    //   87: aload 7
    //   89: astore 6
    //   91: aload 7
    //   93: invokeinterface 77 1 0
    //   98: pop
    //   99: aload 7
    //   101: astore 6
    //   103: aload 7
    //   105: iload_3
    //   106: invokeinterface 81 2 0
    //   111: lstore 4
    //   113: aload 7
    //   115: astore 6
    //   117: lload 4
    //   119: l2f
    //   120: invokestatic 87	com/tencent/mobileqq/utils/FileUtils:getAvailableExternalMemorySize	()F
    //   123: fcmpl
    //   124: ifle +30 -> 154
    //   127: aload 7
    //   129: astore 6
    //   131: aload_0
    //   132: ldc 88
    //   134: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   137: putstatic 94	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   140: aload 7
    //   142: ifnull +10 -> 152
    //   145: aload 7
    //   147: invokeinterface 63 1 0
    //   152: aconst_null
    //   153: areturn
    //   154: aload 7
    //   156: astore 6
    //   158: aload 7
    //   160: iload_2
    //   161: invokeinterface 95 2 0
    //   166: astore 10
    //   168: aload 7
    //   170: astore 6
    //   172: aload_0
    //   173: invokevirtual 99	cooperation/qqfav/widget/QfavJumpActivity:getExternalCacheDir	()Ljava/io/File;
    //   176: astore 8
    //   178: aload 8
    //   180: ifnull +54 -> 234
    //   183: aload 7
    //   185: astore 6
    //   187: new 101	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   194: astore 11
    //   196: aload 7
    //   198: astore 6
    //   200: aload 11
    //   202: aload 8
    //   204: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 7
    //   210: astore 6
    //   212: aload 11
    //   214: ldc 108
    //   216: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 7
    //   222: astore 6
    //   224: aload 11
    //   226: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: astore 8
    //   231: goto +53 -> 284
    //   234: aload 7
    //   236: astore 6
    //   238: new 101	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   245: astore 8
    //   247: aload 7
    //   249: astore 6
    //   251: aload 8
    //   253: ldc 108
    //   255: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 7
    //   261: astore 6
    //   263: aload 8
    //   265: aload_0
    //   266: invokevirtual 118	cooperation/qqfav/widget/QfavJumpActivity:getCacheDir	()Ljava/io/File;
    //   269: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 7
    //   275: astore 6
    //   277: aload 8
    //   279: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: astore 8
    //   284: aload 7
    //   286: astore 6
    //   288: new 101	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   295: astore 11
    //   297: aload 7
    //   299: astore 6
    //   301: aload 11
    //   303: aload 8
    //   305: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 7
    //   311: astore 6
    //   313: aload 11
    //   315: ldc 120
    //   317: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 7
    //   323: astore 6
    //   325: aload 11
    //   327: ldc 122
    //   329: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 7
    //   335: astore 6
    //   337: aload 11
    //   339: ldc 120
    //   341: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 7
    //   347: astore 6
    //   349: aload 11
    //   351: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: astore 11
    //   356: aload 7
    //   358: astore 6
    //   360: aload 11
    //   362: invokestatic 125	cooperation/qqfav/widget/QfavJumpActivity:b	(Ljava/lang/String;)V
    //   365: aload 7
    //   367: astore 6
    //   369: new 101	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   376: astore 8
    //   378: aload 7
    //   380: astore 6
    //   382: aload 8
    //   384: aload 11
    //   386: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 7
    //   392: astore 6
    //   394: aload 8
    //   396: aload 11
    //   398: iconst_1
    //   399: anewarray 127	java/lang/String
    //   402: dup
    //   403: iconst_0
    //   404: aload 10
    //   406: aastore
    //   407: iconst_0
    //   408: aaload
    //   409: invokestatic 131	com/tencent/mobileqq/utils/FileUtils:getUnitFileName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   412: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 7
    //   418: astore 6
    //   420: aload 8
    //   422: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: astore 8
    //   427: aload 7
    //   429: astore 6
    //   431: new 133	java/io/File
    //   434: dup
    //   435: aload 11
    //   437: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   440: astore 10
    //   442: aload 7
    //   444: astore 6
    //   446: aload 10
    //   448: invokevirtual 138	java/io/File:exists	()Z
    //   451: ifne +42 -> 493
    //   454: aload 7
    //   456: astore 6
    //   458: aload 10
    //   460: invokevirtual 141	java/io/File:mkdirs	()Z
    //   463: ifne +30 -> 493
    //   466: aload 7
    //   468: astore 6
    //   470: aload_0
    //   471: ldc 142
    //   473: invokestatic 146	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   476: invokespecial 148	cooperation/qqfav/widget/QfavJumpActivity:a	(Ljava/lang/String;)V
    //   479: aload 7
    //   481: ifnull +10 -> 491
    //   484: aload 7
    //   486: invokeinterface 63 1 0
    //   491: aconst_null
    //   492: areturn
    //   493: aload 7
    //   495: astore 6
    //   497: aload 9
    //   499: aload_1
    //   500: invokevirtual 152	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   503: astore_1
    //   504: aload_1
    //   505: ifnonnull +39 -> 544
    //   508: aload 7
    //   510: astore 6
    //   512: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   515: ifeq +15 -> 530
    //   518: aload 7
    //   520: astore 6
    //   522: ldc 52
    //   524: iconst_2
    //   525: ldc 154
    //   527: invokestatic 58	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   530: aload 7
    //   532: ifnull +10 -> 542
    //   535: aload 7
    //   537: invokeinterface 63 1 0
    //   542: aconst_null
    //   543: areturn
    //   544: lload 4
    //   546: ldc2_w 155
    //   549: lcmp
    //   550: ifle +157 -> 707
    //   553: aload 7
    //   555: astore 6
    //   557: aload_0
    //   558: iconst_1
    //   559: putfield 158	cooperation/qqfav/widget/QfavJumpActivity:jdField_b_of_type_Boolean	Z
    //   562: aload 7
    //   564: astore 6
    //   566: new 160	com/tencent/mobileqq/utils/QQCustomDialog
    //   569: dup
    //   570: aload_0
    //   571: ldc 161
    //   573: invokespecial 164	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   576: astore 9
    //   578: aload 7
    //   580: astore 6
    //   582: aload 9
    //   584: ldc 165
    //   586: invokevirtual 169	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   589: aload 7
    //   591: astore 6
    //   593: aload 9
    //   595: aload_0
    //   596: ldc 170
    //   598: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   601: invokevirtual 174	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   604: pop
    //   605: aload 7
    //   607: astore 6
    //   609: aload 9
    //   611: aload_0
    //   612: ldc 175
    //   614: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   617: invokevirtual 179	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   620: pop
    //   621: aload 7
    //   623: astore 6
    //   625: aload 9
    //   627: iconst_0
    //   628: invokevirtual 183	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   631: aload 7
    //   633: astore 6
    //   635: aload 9
    //   637: iconst_0
    //   638: invokevirtual 186	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   641: aload 7
    //   643: astore 6
    //   645: aload 9
    //   647: aload_0
    //   648: ldc 187
    //   650: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   653: new 189	cooperation/qqfav/widget/QfavJumpActivity$1
    //   656: dup
    //   657: aload_0
    //   658: aload_1
    //   659: invokespecial 192	cooperation/qqfav/widget/QfavJumpActivity$1:<init>	(Lcooperation/qqfav/widget/QfavJumpActivity;Ljava/io/InputStream;)V
    //   662: invokevirtual 196	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   665: pop
    //   666: aload 7
    //   668: astore 6
    //   670: aload 9
    //   672: aload_0
    //   673: ldc 197
    //   675: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   678: new 199	cooperation/qqfav/widget/QfavJumpActivity$2
    //   681: dup
    //   682: aload_0
    //   683: aload 8
    //   685: aload_1
    //   686: lload 4
    //   688: invokespecial 202	cooperation/qqfav/widget/QfavJumpActivity$2:<init>	(Lcooperation/qqfav/widget/QfavJumpActivity;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   691: invokevirtual 205	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   694: pop
    //   695: aload 7
    //   697: astore 6
    //   699: aload 9
    //   701: invokevirtual 208	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   704: goto +16 -> 720
    //   707: aload 7
    //   709: astore 6
    //   711: aload_0
    //   712: aload 8
    //   714: aload_1
    //   715: lload 4
    //   717: invokespecial 211	cooperation/qqfav/widget/QfavJumpActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   720: aload 7
    //   722: ifnull +10 -> 732
    //   725: aload 7
    //   727: invokeinterface 63 1 0
    //   732: aload 8
    //   734: areturn
    //   735: astore 8
    //   737: aload 7
    //   739: astore_1
    //   740: goto +14 -> 754
    //   743: astore_1
    //   744: aconst_null
    //   745: astore 6
    //   747: goto +50 -> 797
    //   750: astore 8
    //   752: aconst_null
    //   753: astore_1
    //   754: aload_1
    //   755: astore 6
    //   757: aload_0
    //   758: iconst_0
    //   759: putfield 213	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_Boolean	Z
    //   762: aload_1
    //   763: astore 6
    //   765: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   768: ifeq +16 -> 784
    //   771: aload_1
    //   772: astore 6
    //   774: ldc 52
    //   776: iconst_2
    //   777: ldc 215
    //   779: aload 8
    //   781: invokestatic 218	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   784: aload_1
    //   785: ifnull +9 -> 794
    //   788: aload_1
    //   789: invokeinterface 63 1 0
    //   794: aconst_null
    //   795: areturn
    //   796: astore_1
    //   797: aload 6
    //   799: ifnull +10 -> 809
    //   802: aload 6
    //   804: invokeinterface 63 1 0
    //   809: aload_1
    //   810: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	811	0	this	QfavJumpActivity
    //   0	811	1	paramUri	Uri
    //   72	89	2	i	int
    //   86	20	3	j	int
    //   111	605	4	l	long
    //   25	778	6	localObject1	Object
    //   16	722	7	localCursor	android.database.Cursor
    //   176	557	8	localObject2	Object
    //   735	1	8	localException1	Exception
    //   750	30	8	localException2	Exception
    //   4	696	9	localObject3	Object
    //   166	293	10	localObject4	Object
    //   194	242	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   27	33	735	java/lang/Exception
    //   37	45	735	java/lang/Exception
    //   63	73	735	java/lang/Exception
    //   77	87	735	java/lang/Exception
    //   91	99	735	java/lang/Exception
    //   103	113	735	java/lang/Exception
    //   117	127	735	java/lang/Exception
    //   131	140	735	java/lang/Exception
    //   158	168	735	java/lang/Exception
    //   172	178	735	java/lang/Exception
    //   187	196	735	java/lang/Exception
    //   200	208	735	java/lang/Exception
    //   212	220	735	java/lang/Exception
    //   224	231	735	java/lang/Exception
    //   238	247	735	java/lang/Exception
    //   251	259	735	java/lang/Exception
    //   263	273	735	java/lang/Exception
    //   277	284	735	java/lang/Exception
    //   288	297	735	java/lang/Exception
    //   301	309	735	java/lang/Exception
    //   313	321	735	java/lang/Exception
    //   325	333	735	java/lang/Exception
    //   337	345	735	java/lang/Exception
    //   349	356	735	java/lang/Exception
    //   360	365	735	java/lang/Exception
    //   369	378	735	java/lang/Exception
    //   382	390	735	java/lang/Exception
    //   394	416	735	java/lang/Exception
    //   420	427	735	java/lang/Exception
    //   431	442	735	java/lang/Exception
    //   446	454	735	java/lang/Exception
    //   458	466	735	java/lang/Exception
    //   470	479	735	java/lang/Exception
    //   497	504	735	java/lang/Exception
    //   512	518	735	java/lang/Exception
    //   522	530	735	java/lang/Exception
    //   557	562	735	java/lang/Exception
    //   566	578	735	java/lang/Exception
    //   582	589	735	java/lang/Exception
    //   593	605	735	java/lang/Exception
    //   609	621	735	java/lang/Exception
    //   625	631	735	java/lang/Exception
    //   635	641	735	java/lang/Exception
    //   645	666	735	java/lang/Exception
    //   670	695	735	java/lang/Exception
    //   699	704	735	java/lang/Exception
    //   711	720	735	java/lang/Exception
    //   6	18	743	finally
    //   6	18	750	java/lang/Exception
    //   27	33	796	finally
    //   37	45	796	finally
    //   63	73	796	finally
    //   77	87	796	finally
    //   91	99	796	finally
    //   103	113	796	finally
    //   117	127	796	finally
    //   131	140	796	finally
    //   158	168	796	finally
    //   172	178	796	finally
    //   187	196	796	finally
    //   200	208	796	finally
    //   212	220	796	finally
    //   224	231	796	finally
    //   238	247	796	finally
    //   251	259	796	finally
    //   263	273	796	finally
    //   277	284	796	finally
    //   288	297	796	finally
    //   301	309	796	finally
    //   313	321	796	finally
    //   325	333	796	finally
    //   337	345	796	finally
    //   349	356	796	finally
    //   360	365	796	finally
    //   369	378	796	finally
    //   382	390	796	finally
    //   394	416	796	finally
    //   420	427	796	finally
    //   431	442	796	finally
    //   446	454	796	finally
    //   458	466	796	finally
    //   470	479	796	finally
    //   497	504	796	finally
    //   512	518	796	finally
    //   522	530	796	finally
    //   557	562	796	finally
    //   566	578	796	finally
    //   582	589	796	finally
    //   593	605	796	finally
    //   609	621	796	finally
    //   625	631	796	finally
    //   635	641	796	finally
    //   645	666	796	finally
    //   670	695	796	finally
    //   699	704	796	finally
    //   711	720	796	finally
    //   757	762	796	finally
    //   765	771	796	finally
    //   774	784	796	finally
  }
  
  private void a()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  private void a(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this, 2131756189);
    localQQCustomDialog.setContentView(2131558978);
    localQQCustomDialog.setTitle(getString(2131719632));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(getString(2131690706), new QfavJumpActivity.6(this));
    localQQCustomDialog.show();
  }
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new QfavJumpActivity.3(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, getString(2131691299), HardCodeUtil.a(2131709581), new QfavJumpActivity.4(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new QfavJumpActivity.5(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private boolean a(Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if ((!"android.intent.action.SEND".equals(localObject)) && (!"android.intent.action.SEND_MULTIPLE".equals(localObject)))
    {
      if ("qqfav.action.ENTER_QQMAP".equals(localObject))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.app.getAccount());
        }
        paramIntent.setClassName("com.tencent.mobileqq", "cooperation.qqfav.widget.LocationDetailActivity");
        paramIntent.setAction(null);
        super.startActivityForResult(paramIntent, 2);
        return true;
      }
      return false;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramIntent);
    ((Intent)localObject).putExtra("nOperation", 8);
    QfavPluginProxyActivity.a(this, this.app.getAccount(), (Intent)localObject, 1);
    return true;
  }
  
  private static void b(String paramString)
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
  
  protected String a()
  {
    String str2 = jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = getString(2131719013);
    }
    return str1;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 == 2)
      {
        QQMapActivityProxy localQQMapActivityProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy;
        if (localQQMapActivityProxy != null) {
          localQQMapActivityProxy.a();
        }
        setResult(paramInt2, paramIntent);
      }
      super.finish();
      return;
    }
    if ((paramInt2 != -1) || (!a(getIntent()))) {
      super.finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    try
    {
      this.mNeedStatusTrans = false;
      super.doOnCreate(paramBundle);
      if (!JumpForwardPkgUtil.a(this, true))
      {
        super.finish();
        return false;
      }
      localObject1 = super.getIntent();
      if (localObject1 == null)
      {
        super.finish();
        return false;
      }
      paramBundle = ((Intent)localObject1).getAction();
      String str = ((Intent)localObject1).getType();
      this.jdField_b_of_type_JavaLangString = null;
      if (("android.intent.action.SEND".equals(paramBundle)) || ("android.intent.action.SEND_MULTIPLE".equals(paramBundle)))
      {
        paramBundle = ((Intent)localObject1).getParcelableExtra("android.intent.extra.STREAM");
        int i;
        try
        {
          if ((paramBundle instanceof Uri))
          {
            Object localObject2 = ForwardFileOption.a(this, (Uri)paramBundle);
            if (localObject2 != null)
            {
              localObject2 = new File((String)localObject2);
              if (((File)localObject2).exists())
              {
                boolean bool = ((File)localObject2).isFile();
                if (bool)
                {
                  i = 1;
                  break label149;
                }
              }
            }
          }
          i = 0;
          label149:
          j = i;
          try
          {
            if (TextUtils.isEmpty(str)) {
              break label248;
            }
            j = i;
            if (!str.startsWith("image")) {
              break label248;
            }
            j = i;
            if (i != 0) {
              break label248;
            }
            j = i;
            if (!(paramBundle instanceof Uri)) {
              break label248;
            }
            this.jdField_b_of_type_JavaLangString = a((Uri)paramBundle);
            paramBundle = this.jdField_b_of_type_JavaLangString;
            j = i;
            if (paramBundle == null) {
              break label248;
            }
            return true;
          }
          catch (Exception paramBundle) {}
          new ArrayList();
        }
        catch (Exception paramBundle)
        {
          i = 0;
        }
        ((Intent)localObject1).getParcelableArrayListExtra("android.intent.extra.STREAM");
        QLog.e("qqfav|QfavJumpActivity", 1, paramBundle.toString());
        int j = i;
        label248:
        if ((!TextUtils.isEmpty(str)) && ((str.startsWith("image")) || (str.startsWith("text"))) && (j == 0))
        {
          ((Intent)localObject1).setClass(this, JumpActivity.class);
          ((Intent)localObject1).putExtra("qqfav_extra_from_system_share", true);
          super.startActivity((Intent)localObject1);
          super.finish();
          return false;
        }
      }
      if (!this.app.isLogin())
      {
        paramBundle = new Intent();
        paramBundle.addFlags(67371008);
        paramBundle.putExtra("isActionSend", true);
        RouteUtils.a(this, paramBundle, "/base/login", 0);
        return true;
      }
      if (!a((Intent)localObject1)) {
        super.finish();
      }
      return true;
    }
    catch (Exception paramBundle)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QfavJumpActivity doOnCreate|exp:");
      ((StringBuilder)localObject1).append(paramBundle.getMessage());
      QLog.e("qqfav|QfavJumpActivity", 1, ((StringBuilder)localObject1).toString());
      super.finish();
    }
    return false;
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("progress: ");
          localStringBuilder.append(paramMessage.arg1);
          QLog.i("qqfav|QfavJumpActivity", 2, localStringBuilder.toString());
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setProgress(paramMessage.arg1);
        }
      }
      else
      {
        a();
        paramMessage = super.getIntent();
        paramMessage.setClass(this, JumpActivity.class);
        paramMessage.putExtra("android.intent.extra.STREAM", this.jdField_b_of_type_JavaLangString);
        paramMessage.putExtra("qqfav_extra_from_system_share", true);
        super.startActivity(paramMessage);
        super.finish();
      }
    }
    else
    {
      a();
      a(a());
    }
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean showPreview()
  {
    try
    {
      boolean bool = JumpForwardPkgManager.a(this);
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      label11:
      break label11;
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity
 * JD-Core Version:    0.7.0.1
 */