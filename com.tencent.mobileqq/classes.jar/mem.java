import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.GetRedBag.1;
import com.tencent.av.ui.redbag.GetRedBag.2;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class mem
  extends mek
{
  ResultReceiver a;
  public Runnable a;
  public WeakReference<men> a;
  public mfa a;
  public String g;
  public String h;
  
  mem(med parammed)
  {
    super(parammed);
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidOsResultReceiver = null;
  }
  
  static int a(String paramString1, String paramString2, String paramString3)
  {
    if (("0".equals(paramString2)) && (("0".equals(paramString3)) || ("1".equals(paramString3))))
    {
      if ((TextUtils.isEmpty(paramString1)) || (paramString1.equals("0"))) {
        return 7;
      }
      return 0;
    }
    if (("66231409".equals(paramString2)) || (("0".equals(paramString2)) && ("5".equals(paramString3)))) {
      return 8;
    }
    if (("66231411".equals(paramString2)) || ("66231412".equals(paramString2))) {
      return 5;
    }
    if (("0".equals(paramString2)) && ("7".equals(paramString3))) {
      return 6;
    }
    return 9;
  }
  
  private static void a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, PayBridgeActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pay_requestcode", 5);
    QLog.w("GetRedBag", 1, "startActivity, PayBridgeActivity begin");
    paramContext.startActivity(localIntent);
    QLog.w("GetRedBag", 1, "startActivity, PayBridgeActivity end");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putParcelable("receiver", paramResultReceiver);
    a(paramQQAppInterface.getApp(), paramBundle);
  }
  
  /* Error */
  private boolean a(int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aload_0
    //   4: getfield 113	mem:i	Ljava/lang/String;
    //   7: astore 6
    //   9: new 115	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   16: ldc 120
    //   18: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_1
    //   22: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: ldc 129
    //   27: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: astore 7
    //   32: aload_2
    //   33: ifnull +581 -> 614
    //   36: iconst_1
    //   37: istore 5
    //   39: aload 6
    //   41: iconst_1
    //   42: aload 7
    //   44: iload 5
    //   46: invokevirtual 132	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: ldc 134
    //   51: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 82	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_2
    //   61: ifnull +708 -> 769
    //   64: ldc 139
    //   66: invokestatic 144	ajjy:a	(I)Ljava/lang/String;
    //   69: aload_2
    //   70: invokestatic 149	com/tencent/mobileqq/utils/AudioHelper:a	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   73: aload_2
    //   74: ldc 151
    //   76: invokevirtual 155	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_2
    //   80: ldc 157
    //   82: astore 6
    //   84: ldc 159
    //   86: astore 9
    //   88: aload_2
    //   89: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +554 -> 646
    //   95: new 161	org/json/JSONObject
    //   98: dup
    //   99: aload_2
    //   100: invokespecial 164	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   103: astore 7
    //   105: new 115	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   112: ldc 159
    //   114: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 7
    //   119: ldc 166
    //   121: sipush -9999
    //   124: invokevirtual 170	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   127: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: astore_2
    //   134: aload 7
    //   136: ldc 172
    //   138: ldc 174
    //   140: invokevirtual 178	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 11
    //   145: aload 7
    //   147: ldc 180
    //   149: invokevirtual 182	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   152: astore 6
    //   154: aload 6
    //   156: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +600 -> 759
    //   162: new 161	org/json/JSONObject
    //   165: dup
    //   166: aload 6
    //   168: invokespecial 164	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   171: astore 8
    //   173: aload 8
    //   175: ldc 184
    //   177: ldc 186
    //   179: invokevirtual 178	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   182: astore 9
    //   184: aload_0
    //   185: aload 8
    //   187: ldc 188
    //   189: aconst_null
    //   190: invokevirtual 178	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: putfield 190	mem:g	Ljava/lang/String;
    //   196: aload_0
    //   197: aload 8
    //   199: ldc 192
    //   201: aconst_null
    //   202: invokevirtual 178	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   205: putfield 194	mem:h	Ljava/lang/String;
    //   208: aload 8
    //   210: ldc 196
    //   212: ldc 198
    //   214: invokevirtual 178	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 7
    //   219: aload 8
    //   221: ldc 200
    //   223: aconst_null
    //   224: invokevirtual 178	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 10
    //   229: aload 7
    //   231: astore 8
    //   233: aload 10
    //   235: astore 7
    //   237: aload 7
    //   239: astore 10
    //   241: aload 6
    //   243: astore 7
    //   245: aload_2
    //   246: astore 6
    //   248: aload 8
    //   250: astore_2
    //   251: aload 11
    //   253: astore 8
    //   255: aload_2
    //   256: astore 13
    //   258: aload 9
    //   260: astore 12
    //   262: aload 6
    //   264: astore 11
    //   266: iconst_5
    //   267: invokestatic 203	com/tencent/mobileqq/utils/AudioHelper:a	(I)I
    //   270: iconst_1
    //   271: if_icmpne +122 -> 393
    //   274: aload_0
    //   275: invokevirtual 206	mem:a	()Lmed;
    //   278: astore 14
    //   280: aload_2
    //   281: astore 13
    //   283: aload 9
    //   285: astore 12
    //   287: aload 6
    //   289: astore 11
    //   291: aload 14
    //   293: ifnull +100 -> 393
    //   296: aload_2
    //   297: astore 13
    //   299: aload 9
    //   301: astore 12
    //   303: aload 6
    //   305: astore 11
    //   307: aload 14
    //   309: getfield 211	med:a	Lmej;
    //   312: ifnull +81 -> 393
    //   315: aload_2
    //   316: astore 13
    //   318: aload 9
    //   320: astore 12
    //   322: aload 6
    //   324: astore 11
    //   326: aload 14
    //   328: getfield 211	med:a	Lmej;
    //   331: getfield 217	mej:jdField_c_of_type_Boolean	Z
    //   334: ifeq +59 -> 393
    //   337: aload_2
    //   338: astore 13
    //   340: aload 9
    //   342: astore 12
    //   344: aload 6
    //   346: astore 11
    //   348: aload 14
    //   350: getfield 211	med:a	Lmej;
    //   353: getfield 219	mej:a	Ljava/lang/String;
    //   356: aload_0
    //   357: getfield 221	mem:jdField_a_of_type_Mfa	Lmfa;
    //   360: getfield 225	mfa:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   363: invokestatic 228	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   366: ifeq +27 -> 393
    //   369: ldc 230
    //   371: astore 13
    //   373: aload 14
    //   375: getfield 211	med:a	Lmej;
    //   378: getfield 233	mej:b	Ljava/lang/String;
    //   381: astore 11
    //   383: aload 14
    //   385: getfield 211	med:a	Lmej;
    //   388: getfield 234	mej:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   391: astore 12
    //   393: aload 13
    //   395: aload 11
    //   397: aload 12
    //   399: invokestatic 236	mem:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   402: istore_3
    //   403: aload_0
    //   404: getfield 221	mem:jdField_a_of_type_Mfa	Lmfa;
    //   407: aload 13
    //   409: putfield 237	mfa:i	Ljava/lang/String;
    //   412: aload_0
    //   413: getfield 221	mem:jdField_a_of_type_Mfa	Lmfa;
    //   416: aload 8
    //   418: putfield 238	mfa:h	Ljava/lang/String;
    //   421: aload_0
    //   422: getfield 221	mem:jdField_a_of_type_Mfa	Lmfa;
    //   425: aload 10
    //   427: putfield 239	mfa:g	Ljava/lang/String;
    //   430: aload_0
    //   431: getfield 221	mem:jdField_a_of_type_Mfa	Lmfa;
    //   434: aload 11
    //   436: putfield 242	mfa:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   439: aload_0
    //   440: getfield 221	mem:jdField_a_of_type_Mfa	Lmfa;
    //   443: aload 12
    //   445: putfield 245	mfa:f	Ljava/lang/String;
    //   448: aload_0
    //   449: getfield 113	mem:i	Ljava/lang/String;
    //   452: iconst_1
    //   453: new 115	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   460: ldc 247
    //   462: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload 11
    //   467: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc 249
    //   472: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload 8
    //   477: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: ldc 251
    //   482: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload 12
    //   487: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: ldc 253
    //   492: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_0
    //   496: getfield 190	mem:g	Ljava/lang/String;
    //   499: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc 255
    //   504: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_0
    //   508: getfield 194	mem:h	Ljava/lang/String;
    //   511: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: ldc_w 257
    //   517: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload 13
    //   522: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc_w 259
    //   528: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload 10
    //   533: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: ldc_w 261
    //   539: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: iload_3
    //   543: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: ldc_w 263
    //   549: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload 7
    //   554: invokestatic 266	com/tencent/mobileqq/utils/AudioHelper:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   557: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc 134
    //   562: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 82	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: iload_3
    //   572: istore 4
    //   574: iload_1
    //   575: bipush 253
    //   577: if_icmpne +15 -> 592
    //   580: iload_3
    //   581: istore 4
    //   583: iload_3
    //   584: iconst_3
    //   585: if_icmpne +7 -> 592
    //   588: bipush 10
    //   590: istore 4
    //   592: aload_0
    //   593: getfield 221	mem:jdField_a_of_type_Mfa	Lmfa;
    //   596: iload 4
    //   598: putfield 269	mfa:jdField_e_of_type_Int	I
    //   601: aload_0
    //   602: invokevirtual 271	mem:b	()V
    //   605: aload_0
    //   606: getfield 221	mem:jdField_a_of_type_Mfa	Lmfa;
    //   609: invokestatic 276	mey:b	(Lmfa;)V
    //   612: iconst_1
    //   613: ireturn
    //   614: iconst_0
    //   615: istore 5
    //   617: goto -578 -> 39
    //   620: astore 8
    //   622: aconst_null
    //   623: astore 7
    //   625: ldc 159
    //   627: astore 9
    //   629: ldc 198
    //   631: astore_2
    //   632: aload 8
    //   634: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   637: astore 8
    //   639: aload 12
    //   641: astore 10
    //   643: goto -388 -> 255
    //   646: aconst_null
    //   647: astore 7
    //   649: ldc_w 281
    //   652: astore 8
    //   654: ldc 159
    //   656: astore 9
    //   658: ldc 198
    //   660: astore_2
    //   661: aload 12
    //   663: astore 10
    //   665: goto -410 -> 255
    //   668: astore 8
    //   670: aload_2
    //   671: astore 6
    //   673: aconst_null
    //   674: astore 7
    //   676: ldc 198
    //   678: astore_2
    //   679: ldc 159
    //   681: astore 9
    //   683: goto -51 -> 632
    //   686: astore 8
    //   688: aload_2
    //   689: astore 7
    //   691: aload 6
    //   693: astore 10
    //   695: ldc 198
    //   697: astore_2
    //   698: ldc 159
    //   700: astore 9
    //   702: aload 7
    //   704: astore 6
    //   706: aload 10
    //   708: astore 7
    //   710: goto -78 -> 632
    //   713: astore 8
    //   715: aload_2
    //   716: astore 7
    //   718: aload 6
    //   720: astore 10
    //   722: ldc 198
    //   724: astore_2
    //   725: aload 7
    //   727: astore 6
    //   729: aload 10
    //   731: astore 7
    //   733: goto -101 -> 632
    //   736: astore 8
    //   738: aload_2
    //   739: astore 10
    //   741: aload 6
    //   743: astore 11
    //   745: aload 7
    //   747: astore_2
    //   748: aload 10
    //   750: astore 6
    //   752: aload 11
    //   754: astore 7
    //   756: goto -124 -> 632
    //   759: ldc 198
    //   761: astore 8
    //   763: aconst_null
    //   764: astore 7
    //   766: goto -529 -> 237
    //   769: iconst_3
    //   770: istore_3
    //   771: goto -200 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	774	0	this	mem
    //   0	774	1	paramInt	int
    //   0	774	2	paramBundle	Bundle
    //   402	369	3	i	int
    //   572	25	4	j	int
    //   37	579	5	bool	boolean
    //   7	744	6	localObject1	java.lang.Object
    //   30	735	7	localObject2	java.lang.Object
    //   171	305	8	localObject3	java.lang.Object
    //   620	13	8	localException1	Exception
    //   637	16	8	str1	String
    //   668	1	8	localException2	Exception
    //   686	1	8	localException3	Exception
    //   713	1	8	localException4	Exception
    //   736	1	8	localException5	Exception
    //   761	1	8	str2	String
    //   86	615	9	str3	String
    //   227	522	10	localObject4	java.lang.Object
    //   143	610	11	localObject5	java.lang.Object
    //   1	661	12	localObject6	java.lang.Object
    //   256	265	13	localObject7	java.lang.Object
    //   278	106	14	localmed	med
    // Exception table:
    //   from	to	target	type
    //   95	134	620	java/lang/Exception
    //   134	154	668	java/lang/Exception
    //   154	184	686	java/lang/Exception
    //   184	219	713	java/lang/Exception
    //   219	229	736	java/lang/Exception
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      QLog.w(this.i, 1, "getRedBag, removeDelayRunnable");
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      QLog.w(this.i, 1, "getRedBag，超时逻辑已启动, resultCode[" + paramInt + "]");
      return;
    }
    String str = this.i;
    StringBuilder localStringBuilder = new StringBuilder().append("getRedBag，启动超时逻辑, resultCode[").append(paramInt).append("], mApp[");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.jdField_a_of_type_JavaLangRunnable = new GetRedBag.2(this, paramInt);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
      return;
    }
  }
  
  public void a(String paramString)
  {
    QLog.w(this.i, 1, "GetRedBag, cancel[" + paramString + "]");
    this.jdField_a_of_type_Mfa.jdField_e_of_type_Int = 4;
    b();
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, mfa parammfa, WeakReference<men> paramWeakReference)
  {
    this.jdField_a_of_type_Mfa = parammfa;
    if (paramVideoAppInterface == null)
    {
      QLog.w(this.i, 1, "GetRedBag, app为空");
      return false;
    }
    long l = mez.a(paramVideoAppInterface);
    if (l == 0L)
    {
      QLog.w(this.i, 1, "GetRedBag, userId为空");
      parammfa.jdField_e_of_type_Int = 2;
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsResultReceiver == null) {
      this.jdField_a_of_type_AndroidOsResultReceiver = new GetRedBag.1(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    }
    String str = a(paramVideoAppInterface);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("listid", parammfa.jdField_c_of_type_JavaLangString);
      localJSONObject2.put("authkey", parammfa.d);
      localJSONObject2.put("name", str);
      localJSONObject2.put("channel", "16384");
      localJSONObject2.put("silence_grap", "1");
      localJSONObject2.put("grouptype", "0");
      localJSONObject2.put("groupid", "" + l);
      localJSONObject1.put("userId", l);
      localJSONObject1.put("viewTag", "graphb");
      localJSONObject1.put("app_info", "appid#0|bargainor_id#0|channel#bqredpacket");
      localJSONObject1.put("come_from", 2);
      localJSONObject1.put("extra_data", localJSONObject2);
      this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
      paramWeakReference = new Bundle();
      paramWeakReference.putString("json", localJSONObject1.toString());
      paramWeakReference.putString("callbackSn", "0");
      if ((paramAVActivity != null) && (paramAVActivity.b() != -1) && (paramAVActivity.b() != 5))
      {
        paramWeakReference.putParcelable("receiver", this.jdField_a_of_type_AndroidOsResultReceiver);
        a(paramAVActivity, paramWeakReference);
        QLog.w(this.i, 1, "GetRedBag, userName[" + str + "], userId[" + l + "], redPocketId[" + parammfa.jdField_c_of_type_JavaLangString + "], json[" + AudioHelper.a(localJSONObject1) + "], Activity[" + paramAVActivity + "]");
        parammfa.jdField_e_of_type_Int = 1;
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        QLog.w(this.i, 1, "发通知到主进程抢红包");
        paramVideoAppInterface.a(2, 0, 0, paramWeakReference, this.jdField_a_of_type_AndroidOsResultReceiver);
        a(-3, 20000L);
      }
    }
  }
  
  void b()
  {
    a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      men localmen = (men)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localmen != null) {
        localmen.a(this);
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    if (this.jdField_a_of_type_Mfa.jdField_e_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ljg.b(bool, this.jdField_a_of_type_Mfa.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Mfa.f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mem
 * JD-Core Version:    0.7.0.1
 */