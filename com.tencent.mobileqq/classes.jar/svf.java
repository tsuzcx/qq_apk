import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.1;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class svf
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1000);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public svf(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public static int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
  }
  
  private InputStream a(Context paramContext, String paramString1, String paramString2)
  {
    return new svh(paramContext, paramString1).a(paramString2);
  }
  
  private Set<String> a(String paramString)
  {
    QLog.d("TemplateFactory", 2, "getAladdinKeysByService | localPath " + paramString);
    Object localObject = new HashSet();
    if (TextUtils.isEmpty(paramString)) {
      return localObject;
    }
    if (paramString.contains("default_feeds"))
    {
      paramString = pbq.a();
      QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_DEFAULT_FEEDS ");
    }
    for (;;)
    {
      localObject = new StringBuilder();
      Iterator localIterator = paramString.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ((StringBuilder)localObject).append((String)localIterator.next() + "\n");
          continue;
          if (paramString.contains("native_article"))
          {
            paramString = pbs.a();
            QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_NATIVE_ARTICLE ");
            break;
          }
          if (!paramString.contains("comment_feeds")) {
            break label200;
          }
          paramString = pbr.a();
          QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_COMMENT_FEEDS ");
          break;
        }
      }
      QLog.d("TemplateFactory", 1, "getAladdinKeysByService | aladdinKeys: " + ((StringBuilder)localObject).toString());
      return paramString;
      label200:
      paramString = (String)localObject;
    }
  }
  
  public static void a(String paramString)
  {
    svo.a(paramString, true);
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new StyleLoaderHelper.1(this));
  }
  
  public suz a(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  /* Error */
  public suz a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 43
    //   2: iconst_1
    //   3: new 45	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   10: ldc 158
    //   12: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: ifnull +15 -> 44
    //   32: ldc 163
    //   34: aload_0
    //   35: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +34 -> 75
    //   44: ldc 43
    //   46: iconst_2
    //   47: new 45	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   54: ldc 169
    //   56: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aconst_null
    //   70: astore 5
    //   72: aload 5
    //   74: areturn
    //   75: aload_0
    //   76: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   79: invokestatic 174	svr:a	(Ljava/lang/String;)Lsuz;
    //   82: astore 6
    //   84: iload_2
    //   85: ifeq +12 -> 97
    //   88: aload 6
    //   90: astore 5
    //   92: aload 6
    //   94: ifnonnull -22 -> 72
    //   97: aload_0
    //   98: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   101: invokestatic 177	svr:a	(Ljava/lang/String;)Lsvs;
    //   104: astore 6
    //   106: aload 6
    //   108: getfield 182	svs:jdField_a_of_type_Boolean	Z
    //   111: ifne +80 -> 191
    //   114: aload 6
    //   116: getfield 185	svs:jdField_a_of_type_Int	I
    //   119: sipush 1001
    //   122: if_icmpne +38 -> 160
    //   125: ldc 43
    //   127: iconst_1
    //   128: new 45	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   135: ldc 187
    //   137: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   144: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 189
    //   149: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aconst_null
    //   159: areturn
    //   160: ldc 43
    //   162: iconst_1
    //   163: new 45	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   170: ldc 187
    //   172: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: goto -30 -> 158
    //   191: new 194	suz
    //   194: dup
    //   195: invokespecial 195	suz:<init>	()V
    //   198: astore 5
    //   200: aload 5
    //   202: iconst_2
    //   203: invokevirtual 197	suz:a	(I)V
    //   206: aload 5
    //   208: aload_0
    //   209: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   212: invokevirtual 199	suz:a	(Ljava/lang/String;)V
    //   215: aload 5
    //   217: aload 6
    //   219: invokevirtual 202	suz:a	(Lsvs;)V
    //   222: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   225: lstore_3
    //   226: aload_0
    //   227: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   230: invokestatic 213	nmp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   233: astore 6
    //   235: ldc 43
    //   237: iconst_2
    //   238: new 45	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   245: ldc 215
    //   247: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 6
    //   252: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload 6
    //   263: ifnonnull +38 -> 301
    //   266: ldc 43
    //   268: iconst_1
    //   269: new 45	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   276: ldc 215
    //   278: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_0
    //   282: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   285: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc 217
    //   290: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aconst_null
    //   300: areturn
    //   301: new 45	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   308: aload 6
    //   310: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_0
    //   314: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   317: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: astore 8
    //   325: aload 8
    //   327: aload_0
    //   328: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   331: invokestatic 222	nnz:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   334: ifne +38 -> 372
    //   337: ldc 43
    //   339: iconst_1
    //   340: new 45	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   347: ldc 224
    //   349: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_0
    //   353: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   356: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc 226
    //   361: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aconst_null
    //   371: areturn
    //   372: new 45	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   379: aload 8
    //   381: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc 228
    //   386: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: ldc 230
    //   391: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: astore 6
    //   399: new 45	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   406: aload_0
    //   407: getfield 26	svf:b	Ljava/lang/String;
    //   410: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc 228
    //   415: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc 230
    //   420: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: astore 7
    //   428: new 232	svj
    //   431: dup
    //   432: aload_1
    //   433: aload 8
    //   435: aload_0
    //   436: getfield 26	svf:b	Ljava/lang/String;
    //   439: invokespecial 235	svj:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   442: astore 8
    //   444: new 232	svj
    //   447: dup
    //   448: aload_1
    //   449: aload 6
    //   451: aload 7
    //   453: invokespecial 235	svj:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   456: astore_1
    //   457: new 237	svb
    //   460: dup
    //   461: aload_1
    //   462: invokespecial 240	svb:<init>	(Lsvi;)V
    //   465: astore 6
    //   467: aload_1
    //   468: invokeinterface 245 1 0
    //   473: astore 9
    //   475: aload 9
    //   477: ifnull +330 -> 807
    //   480: new 247	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser
    //   483: dup
    //   484: invokespecial 248	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:<init>	()V
    //   487: astore 7
    //   489: aload 7
    //   491: ldc 250
    //   493: invokevirtual 253	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setVersion	(Ljava/lang/String;)V
    //   496: aload 7
    //   498: aload_0
    //   499: aload_0
    //   500: getfield 26	svf:b	Ljava/lang/String;
    //   503: invokespecial 255	svf:a	(Ljava/lang/String;)Ljava/util/Set;
    //   506: invokevirtual 259	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setAladdinKey	(Ljava/util/Set;)V
    //   509: aload 8
    //   511: ldc_w 261
    //   514: invokeinterface 262 2 0
    //   519: astore 8
    //   521: aload 8
    //   523: ifnull +13 -> 536
    //   526: aload 7
    //   528: aload 8
    //   530: invokestatic 265	svr:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   533: invokevirtual 268	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseDataMap	(Ljava/lang/String;)V
    //   536: aload 9
    //   538: invokeinterface 271 1 0
    //   543: astore 9
    //   545: aload 9
    //   547: invokeinterface 97 1 0
    //   552: ifeq +192 -> 744
    //   555: aload 9
    //   557: invokeinterface 101 1 0
    //   562: checkcast 75	java/lang/String
    //   565: astore 8
    //   567: ldc 43
    //   569: iconst_2
    //   570: new 45	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 273
    //   580: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 8
    //   585: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: aload 8
    //   596: ldc_w 275
    //   599: invokevirtual 279	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   602: ifeq -57 -> 545
    //   605: ldc 43
    //   607: iconst_1
    //   608: new 45	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   615: ldc_w 281
    //   618: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload 8
    //   623: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: aload 7
    //   634: aload 5
    //   636: aload_1
    //   637: aload 8
    //   639: invokeinterface 262 2 0
    //   644: invokestatic 265	svr:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   647: aload 6
    //   649: invokevirtual 285	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:createViewTemplate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;)V
    //   652: goto -107 -> 545
    //   655: astore_1
    //   656: ldc 43
    //   658: iconst_1
    //   659: new 45	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   666: ldc_w 287
    //   669: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload 8
    //   674: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: aload_1
    //   681: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   684: aload_1
    //   685: athrow
    //   686: astore_1
    //   687: ldc 43
    //   689: iconst_1
    //   690: ldc_w 292
    //   693: aload_1
    //   694: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   697: aconst_null
    //   698: areturn
    //   699: astore 8
    //   701: ldc 43
    //   703: iconst_1
    //   704: new 45	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   711: ldc_w 294
    //   714: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: aload 8
    //   719: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokestatic 297	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   728: goto -192 -> 536
    //   731: astore_1
    //   732: ldc 43
    //   734: iconst_1
    //   735: ldc_w 299
    //   738: aload_1
    //   739: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   742: aconst_null
    //   743: areturn
    //   744: ldc 43
    //   746: iconst_2
    //   747: new 45	java/lang/StringBuilder
    //   750: dup
    //   751: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   754: ldc_w 301
    //   757: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   763: lload_3
    //   764: lsub
    //   765: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   768: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   774: ldc 43
    //   776: iconst_1
    //   777: ldc_w 306
    //   780: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   783: aload_0
    //   784: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   787: aload 5
    //   789: invokestatic 309	svr:a	(Ljava/lang/String;Lsuz;)V
    //   792: aload_0
    //   793: invokespecial 311	svf:b	()V
    //   796: iconst_3
    //   797: aload_0
    //   798: getfield 24	svf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   801: invokestatic 316	tyd:a	(ILjava/lang/String;)V
    //   804: aload 5
    //   806: areturn
    //   807: ldc 43
    //   809: iconst_1
    //   810: ldc_w 318
    //   813: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: aconst_null
    //   817: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	this	svf
    //   0	818	1	paramContext	Context
    //   0	818	2	paramBoolean	boolean
    //   225	539	3	l	long
    //   70	735	5	localObject1	Object
    //   82	566	6	localObject2	Object
    //   426	207	7	localObject3	Object
    //   323	350	8	localObject4	Object
    //   699	19	8	localIOException	java.io.IOException
    //   473	83	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   594	652	655	org/json/JSONException
    //   372	475	686	java/lang/OutOfMemoryError
    //   480	509	686	java/lang/OutOfMemoryError
    //   509	521	686	java/lang/OutOfMemoryError
    //   526	536	686	java/lang/OutOfMemoryError
    //   536	545	686	java/lang/OutOfMemoryError
    //   545	594	686	java/lang/OutOfMemoryError
    //   594	652	686	java/lang/OutOfMemoryError
    //   656	686	686	java/lang/OutOfMemoryError
    //   701	728	686	java/lang/OutOfMemoryError
    //   744	774	686	java/lang/OutOfMemoryError
    //   807	816	686	java/lang/OutOfMemoryError
    //   509	521	699	java/io/IOException
    //   526	536	699	java/io/IOException
    //   372	475	731	java/lang/Exception
    //   480	509	731	java/lang/Exception
    //   509	521	731	java/lang/Exception
    //   526	536	731	java/lang/Exception
    //   536	545	731	java/lang/Exception
    //   545	594	731	java/lang/Exception
    //   594	652	731	java/lang/Exception
    //   656	686	731	java/lang/Exception
    //   701	728	731	java/lang/Exception
    //   744	774	731	java/lang/Exception
    //   807	816	731	java/lang/Exception
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || ("0".equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.executeOnFileThread(new StyleLoaderHelper.2(this));
  }
  
  /* Error */
  public suz b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	svf:b	Ljava/lang/String;
    //   4: ifnonnull +35 -> 39
    //   7: ldc 43
    //   9: iconst_2
    //   10: new 45	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 327
    //   20: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aconst_null
    //   34: astore 4
    //   36: aload 4
    //   38: areturn
    //   39: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   42: lstore_2
    //   43: aload_0
    //   44: getfield 26	svf:b	Ljava/lang/String;
    //   47: invokestatic 174	svr:a	(Ljava/lang/String;)Lsuz;
    //   50: astore 5
    //   52: aload 5
    //   54: astore 4
    //   56: aload 5
    //   58: ifnonnull -22 -> 36
    //   61: new 194	suz
    //   64: dup
    //   65: invokespecial 195	suz:<init>	()V
    //   68: astore 7
    //   70: aload 7
    //   72: iconst_1
    //   73: invokevirtual 197	suz:a	(I)V
    //   76: aload 7
    //   78: ldc 163
    //   80: invokevirtual 199	suz:a	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 333	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   87: astore 8
    //   89: new 45	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   96: aload_0
    //   97: getfield 26	svf:b	Ljava/lang/String;
    //   100: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 228
    //   105: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 230
    //   110: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore 9
    //   118: new 33	svh
    //   121: dup
    //   122: aload_1
    //   123: aload 9
    //   125: invokespecial 36	svh:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   128: astore 10
    //   130: aload 10
    //   132: invokeinterface 245 1 0
    //   137: astore 5
    //   139: aload 5
    //   141: ifnull +613 -> 754
    //   144: ldc 43
    //   146: iconst_1
    //   147: new 45	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 335
    //   157: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 5
    //   162: invokeinterface 338 1 0
    //   167: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc_w 343
    //   173: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 26	svf:b	Ljava/lang/String;
    //   180: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: new 247	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser
    //   192: dup
    //   193: invokespecial 248	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:<init>	()V
    //   196: astore 4
    //   198: aload 4
    //   200: aload_0
    //   201: aload_0
    //   202: getfield 26	svf:b	Ljava/lang/String;
    //   205: invokespecial 255	svf:a	(Ljava/lang/String;)Ljava/util/Set;
    //   208: invokevirtual 259	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setAladdinKey	(Ljava/util/Set;)V
    //   211: invokestatic 349	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   214: invokevirtual 352	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   217: ifeq +548 -> 765
    //   220: invokestatic 349	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   223: astore 4
    //   225: aload 4
    //   227: aload_0
    //   228: aload_1
    //   229: aload_0
    //   230: getfield 26	svf:b	Ljava/lang/String;
    //   233: ldc_w 261
    //   236: invokespecial 354	svf:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   239: invokestatic 265	svr:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   242: invokevirtual 268	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseDataMap	(Ljava/lang/String;)V
    //   245: new 356	sva
    //   248: dup
    //   249: aload_1
    //   250: aload 9
    //   252: invokespecial 357	sva:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   255: astore 11
    //   257: aload 5
    //   259: invokeinterface 271 1 0
    //   264: astore 12
    //   266: aload 12
    //   268: invokeinterface 97 1 0
    //   273: ifeq +319 -> 592
    //   276: aload 12
    //   278: invokeinterface 101 1 0
    //   283: checkcast 75	java/lang/String
    //   286: astore 13
    //   288: aload 13
    //   290: ldc_w 275
    //   293: invokevirtual 279	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   296: ifeq -30 -> 266
    //   299: ldc 43
    //   301: iconst_2
    //   302: new 45	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 359
    //   312: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 13
    //   317: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: invokestatic 349	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   329: invokevirtual 352	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   332: ifeq +143 -> 475
    //   335: invokestatic 349	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   338: aload_1
    //   339: aload 7
    //   341: aload 11
    //   343: new 45	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   350: aload 9
    //   352: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc 228
    //   357: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 13
    //   362: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: aload 9
    //   370: new 45	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   377: aload_0
    //   378: getfield 26	svf:b	Ljava/lang/String;
    //   381: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc_w 361
    //   387: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokevirtual 365	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:createViewTempFromAssets	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   396: goto -130 -> 266
    //   399: astore 5
    //   401: ldc 43
    //   403: iconst_1
    //   404: new 45	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 367
    //   414: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 13
    //   419: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: aload 5
    //   427: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   430: goto -164 -> 266
    //   433: astore_1
    //   434: ldc 43
    //   436: iconst_1
    //   437: ldc_w 369
    //   440: aload_1
    //   441: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   444: aconst_null
    //   445: areturn
    //   446: astore 6
    //   448: ldc 43
    //   450: iconst_2
    //   451: ldc_w 371
    //   454: aload 6
    //   456: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   459: goto -214 -> 245
    //   462: astore_1
    //   463: ldc 43
    //   465: iconst_1
    //   466: ldc_w 371
    //   469: aload_1
    //   470: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   473: aconst_null
    //   474: areturn
    //   475: aload 10
    //   477: aload 13
    //   479: invokeinterface 262 2 0
    //   484: astore 6
    //   486: aload 6
    //   488: astore 5
    //   490: aload 6
    //   492: ifnonnull +78 -> 570
    //   495: aload 8
    //   497: new 45	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   504: aload 9
    //   506: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc 228
    //   511: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload 13
    //   516: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokevirtual 376	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   525: astore 5
    //   527: ldc 43
    //   529: iconst_1
    //   530: new 45	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   537: ldc_w 378
    //   540: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 9
    //   545: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: ldc 228
    //   550: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 13
    //   555: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: ldc_w 380
    //   561: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 4
    //   572: aload 7
    //   574: aload 5
    //   576: invokestatic 265	svr:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   579: aload 11
    //   581: invokevirtual 285	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:createViewTemplate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;)V
    //   584: aload 5
    //   586: invokevirtual 385	java/io/InputStream:close	()V
    //   589: goto -323 -> 266
    //   592: aload 7
    //   594: invokevirtual 389	suz:getNameTemplateMap	()Ljava/util/Map;
    //   597: astore 4
    //   599: new 45	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   606: astore_1
    //   607: aload 4
    //   609: invokeinterface 394 1 0
    //   614: invokeinterface 91 1 0
    //   619: astore 4
    //   621: aload 4
    //   623: invokeinterface 97 1 0
    //   628: ifeq +51 -> 679
    //   631: aload 4
    //   633: invokeinterface 101 1 0
    //   638: checkcast 396	java/util/Map$Entry
    //   641: astore 5
    //   643: aload_1
    //   644: new 45	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   651: aload 5
    //   653: invokeinterface 399 1 0
    //   658: checkcast 75	java/lang/String
    //   661: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc 103
    //   666: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: goto -55 -> 621
    //   679: ldc 43
    //   681: iconst_2
    //   682: new 45	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   689: ldc_w 401
    //   692: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: aload_1
    //   696: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: ldc 43
    //   710: iconst_1
    //   711: new 45	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   718: ldc_w 403
    //   721: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   727: lload_2
    //   728: lsub
    //   729: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   732: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   738: aload_0
    //   739: getfield 26	svf:b	Ljava/lang/String;
    //   742: aload 7
    //   744: invokestatic 309	svr:a	(Ljava/lang/String;Lsuz;)V
    //   747: aload_0
    //   748: invokespecial 311	svf:b	()V
    //   751: aload 7
    //   753: areturn
    //   754: ldc 43
    //   756: iconst_1
    //   757: ldc_w 405
    //   760: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   763: aconst_null
    //   764: areturn
    //   765: goto -540 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	768	0	this	svf
    //   0	768	1	paramContext	Context
    //   42	686	2	l	long
    //   34	598	4	localObject1	Object
    //   50	208	5	localObject2	Object
    //   399	27	5	localException1	java.lang.Exception
    //   488	164	5	localObject3	Object
    //   446	9	6	localException2	java.lang.Exception
    //   484	7	6	localInputStream	InputStream
    //   68	684	7	localsuz	suz
    //   87	409	8	localAssetManager	android.content.res.AssetManager
    //   116	428	9	str1	String
    //   128	348	10	localsvh	svh
    //   255	325	11	localsva	sva
    //   264	13	12	localIterator	Iterator
    //   286	268	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   326	396	399	java/lang/Exception
    //   475	486	399	java/lang/Exception
    //   495	570	399	java/lang/Exception
    //   570	589	399	java/lang/Exception
    //   118	139	433	java/lang/OutOfMemoryError
    //   144	225	433	java/lang/OutOfMemoryError
    //   225	245	433	java/lang/OutOfMemoryError
    //   245	266	433	java/lang/OutOfMemoryError
    //   266	326	433	java/lang/OutOfMemoryError
    //   326	396	433	java/lang/OutOfMemoryError
    //   401	430	433	java/lang/OutOfMemoryError
    //   448	459	433	java/lang/OutOfMemoryError
    //   475	486	433	java/lang/OutOfMemoryError
    //   495	570	433	java/lang/OutOfMemoryError
    //   570	589	433	java/lang/OutOfMemoryError
    //   592	621	433	java/lang/OutOfMemoryError
    //   621	676	433	java/lang/OutOfMemoryError
    //   679	708	433	java/lang/OutOfMemoryError
    //   754	763	433	java/lang/OutOfMemoryError
    //   225	245	446	java/lang/Exception
    //   118	139	462	java/lang/Exception
    //   144	225	462	java/lang/Exception
    //   245	266	462	java/lang/Exception
    //   266	326	462	java/lang/Exception
    //   401	430	462	java/lang/Exception
    //   448	459	462	java/lang/Exception
    //   592	621	462	java/lang/Exception
    //   621	676	462	java/lang/Exception
    //   679	708	462	java/lang/Exception
    //   754	763	462	java/lang/Exception
  }
  
  public void b(String paramString)
  {
    QLog.d("TemplateFactory", 1, "resetTemplates: " + paramString);
    suz localsuz = a(BaseApplicationImpl.getApplication(), false);
    if (localsuz == null)
    {
      QLog.d("TemplateFactory", 1, "templateFactory == null  bid : " + paramString);
      return;
    }
    localsuz.a(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet());
    svr.a(paramString, localsuz);
    suz.a();
  }
  
  public String toString()
  {
    return " bid :" + this.jdField_a_of_type_JavaLangString + " localPath: " + this.b + " config: " + nmj.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svf
 * JD-Core Version:    0.7.0.1
 */