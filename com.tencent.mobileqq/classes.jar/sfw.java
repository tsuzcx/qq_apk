import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.1;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class sfw
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1000);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public sfw(String paramString1, String paramString2)
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
    return new sfy(paramContext, paramString1).a(paramString2);
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
      paramString = ots.a();
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
            paramString = otu.a();
            QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_NATIVE_ARTICLE ");
            break;
          }
          if (!paramString.contains("comment_feeds")) {
            break label200;
          }
          paramString = ott.a();
          QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_COMMENT_FEEDS ");
          break;
        }
      }
      QLog.d("TemplateFactory", 2, "getAladdinKeysByService | aladdinKeys: " + ((StringBuilder)localObject).toString());
      return paramString;
      label200:
      paramString = (String)localObject;
    }
  }
  
  public static void a(String paramString)
  {
    sgf.a(paramString, true);
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new StyleLoaderHelper.1(this));
  }
  
  /* Error */
  public sfq a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 43
    //   2: iconst_1
    //   3: new 45	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   10: ldc 156
    //   12: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: ifnull +15 -> 44
    //   32: ldc 161
    //   34: aload_0
    //   35: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +34 -> 75
    //   44: ldc 43
    //   46: iconst_2
    //   47: new 45	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   54: ldc 167
    //   56: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aconst_null
    //   70: astore 4
    //   72: aload 4
    //   74: areturn
    //   75: aload_0
    //   76: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   79: invokestatic 172	sgi:a	(Ljava/lang/String;)Lsfq;
    //   82: astore 5
    //   84: aload 5
    //   86: astore 4
    //   88: aload 5
    //   90: ifnonnull -18 -> 72
    //   93: aload_0
    //   94: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokestatic 175	sgi:a	(Ljava/lang/String;)Lsgj;
    //   100: astore 5
    //   102: aload 5
    //   104: getfield 180	sgj:jdField_a_of_type_Boolean	Z
    //   107: ifne +80 -> 187
    //   110: aload 5
    //   112: getfield 183	sgj:jdField_a_of_type_Int	I
    //   115: sipush 1001
    //   118: if_icmpne +38 -> 156
    //   121: ldc 43
    //   123: iconst_4
    //   124: new 45	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   131: ldc 185
    //   133: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   140: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc 187
    //   145: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aconst_null
    //   155: areturn
    //   156: ldc 43
    //   158: iconst_4
    //   159: new 45	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   166: ldc 185
    //   168: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   175: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: goto -30 -> 154
    //   187: new 192	sfq
    //   190: dup
    //   191: invokespecial 193	sfq:<init>	()V
    //   194: astore 4
    //   196: aload 4
    //   198: iconst_2
    //   199: invokevirtual 195	sfq:a	(I)V
    //   202: aload 4
    //   204: aload_0
    //   205: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   208: invokevirtual 197	sfq:a	(Ljava/lang/String;)V
    //   211: aload 4
    //   213: aload 5
    //   215: invokevirtual 200	sfq:a	(Lsgj;)V
    //   218: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   221: lstore_2
    //   222: aload_0
    //   223: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   226: invokestatic 211	ncb:a	(Ljava/lang/String;)Ljava/lang/String;
    //   229: astore 5
    //   231: ldc 43
    //   233: iconst_2
    //   234: new 45	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   241: ldc 213
    //   243: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 5
    //   248: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload 5
    //   259: ifnonnull +38 -> 297
    //   262: ldc 43
    //   264: iconst_1
    //   265: new 45	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   272: ldc 213
    //   274: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_0
    //   278: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   281: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 215
    //   286: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aconst_null
    //   296: areturn
    //   297: new 45	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   304: aload 5
    //   306: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_0
    //   310: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   313: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: astore 5
    //   321: aload 5
    //   323: aload_0
    //   324: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   327: invokestatic 220	ndl:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   330: ifne +38 -> 368
    //   333: ldc 43
    //   335: iconst_1
    //   336: new 45	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   343: ldc 222
    //   345: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_0
    //   349: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   352: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc 224
    //   357: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aconst_null
    //   367: areturn
    //   368: new 45	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   375: aload 5
    //   377: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: ldc 226
    //   382: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc 228
    //   387: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: astore 6
    //   395: new 45	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   402: aload_0
    //   403: getfield 26	sfw:b	Ljava/lang/String;
    //   406: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc 226
    //   411: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc 228
    //   416: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore 7
    //   424: new 230	sga
    //   427: dup
    //   428: aload_1
    //   429: aload 5
    //   431: aload_0
    //   432: getfield 26	sfw:b	Ljava/lang/String;
    //   435: invokespecial 233	sga:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   438: astore 5
    //   440: new 230	sga
    //   443: dup
    //   444: aload_1
    //   445: aload 6
    //   447: aload 7
    //   449: invokespecial 233	sga:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   452: astore_1
    //   453: new 235	sfs
    //   456: dup
    //   457: aload_1
    //   458: invokespecial 238	sfs:<init>	(Lsfz;)V
    //   461: astore 6
    //   463: aload_1
    //   464: invokeinterface 243 1 0
    //   469: astore 8
    //   471: aload 8
    //   473: ifnull +348 -> 821
    //   476: new 245	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser
    //   479: dup
    //   480: invokespecial 246	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:<init>	()V
    //   483: astore 7
    //   485: aload 7
    //   487: ldc 248
    //   489: invokevirtual 251	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setVersion	(Ljava/lang/String;)V
    //   492: aload 7
    //   494: aload_0
    //   495: aload_0
    //   496: getfield 26	sfw:b	Ljava/lang/String;
    //   499: invokespecial 253	sfw:a	(Ljava/lang/String;)Ljava/util/Set;
    //   502: invokevirtual 257	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setAladdinKey	(Ljava/util/Set;)V
    //   505: aload 5
    //   507: ldc_w 259
    //   510: invokeinterface 260 2 0
    //   515: astore 9
    //   517: aload 9
    //   519: ifnull +13 -> 532
    //   522: aload 7
    //   524: aload 9
    //   526: invokestatic 263	sgi:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   529: invokevirtual 266	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseDataMap	(Ljava/lang/String;)V
    //   532: aload 7
    //   534: aload 5
    //   536: ldc_w 268
    //   539: invokeinterface 260 2 0
    //   544: invokestatic 263	sgi:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   547: invokevirtual 271	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseGlobalVariable	(Ljava/lang/String;)V
    //   550: aload 8
    //   552: invokeinterface 274 1 0
    //   557: astore 8
    //   559: aload 8
    //   561: invokeinterface 97 1 0
    //   566: ifeq +192 -> 758
    //   569: aload 8
    //   571: invokeinterface 101 1 0
    //   576: checkcast 75	java/lang/String
    //   579: astore 5
    //   581: ldc 43
    //   583: iconst_2
    //   584: new 45	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 276
    //   594: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 5
    //   599: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: aload 5
    //   610: ldc_w 278
    //   613: invokevirtual 282	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   616: ifeq -57 -> 559
    //   619: ldc 43
    //   621: iconst_2
    //   622: new 45	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   629: ldc_w 284
    //   632: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload 5
    //   637: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: aload 7
    //   648: aload 4
    //   650: aload_1
    //   651: aload 5
    //   653: invokeinterface 260 2 0
    //   658: invokestatic 263	sgi:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   661: aload 6
    //   663: invokevirtual 288	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:createViewTemplate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;)V
    //   666: goto -107 -> 559
    //   669: astore_1
    //   670: ldc 43
    //   672: iconst_1
    //   673: new 45	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   680: ldc_w 290
    //   683: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload 5
    //   688: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: aload_1
    //   695: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   698: aload_1
    //   699: athrow
    //   700: astore_1
    //   701: ldc 43
    //   703: iconst_1
    //   704: ldc_w 295
    //   707: aload_1
    //   708: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   711: aconst_null
    //   712: areturn
    //   713: astore 5
    //   715: ldc 43
    //   717: iconst_1
    //   718: new 45	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   725: ldc_w 297
    //   728: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload 5
    //   733: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   736: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokestatic 300	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   742: goto -192 -> 550
    //   745: astore_1
    //   746: ldc 43
    //   748: iconst_1
    //   749: ldc_w 302
    //   752: aload_1
    //   753: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   756: aconst_null
    //   757: areturn
    //   758: ldc 43
    //   760: iconst_2
    //   761: new 45	java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   768: ldc_w 304
    //   771: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   777: lload_2
    //   778: lsub
    //   779: invokevirtual 307	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   782: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   785: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   788: ldc 43
    //   790: iconst_1
    //   791: ldc_w 309
    //   794: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   797: aload_0
    //   798: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   801: aload 4
    //   803: invokestatic 312	sgi:a	(Ljava/lang/String;Lsfq;)V
    //   806: aload_0
    //   807: invokespecial 314	sfw:b	()V
    //   810: iconst_3
    //   811: aload_0
    //   812: getfield 24	sfw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   815: invokestatic 319	swt:a	(ILjava/lang/String;)V
    //   818: aload 4
    //   820: areturn
    //   821: ldc 43
    //   823: iconst_1
    //   824: ldc_w 321
    //   827: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: aconst_null
    //   831: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	832	0	this	sfw
    //   0	832	1	paramContext	Context
    //   221	557	2	l	long
    //   70	749	4	localObject1	Object
    //   82	605	5	localObject2	Object
    //   713	19	5	localIOException	java.io.IOException
    //   393	269	6	localObject3	Object
    //   422	225	7	localObject4	Object
    //   469	101	8	localObject5	Object
    //   515	10	9	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   608	666	669	org/json/JSONException
    //   368	471	700	java/lang/OutOfMemoryError
    //   476	505	700	java/lang/OutOfMemoryError
    //   505	517	700	java/lang/OutOfMemoryError
    //   522	532	700	java/lang/OutOfMemoryError
    //   532	550	700	java/lang/OutOfMemoryError
    //   550	559	700	java/lang/OutOfMemoryError
    //   559	608	700	java/lang/OutOfMemoryError
    //   608	666	700	java/lang/OutOfMemoryError
    //   670	700	700	java/lang/OutOfMemoryError
    //   715	742	700	java/lang/OutOfMemoryError
    //   758	788	700	java/lang/OutOfMemoryError
    //   821	830	700	java/lang/OutOfMemoryError
    //   505	517	713	java/io/IOException
    //   522	532	713	java/io/IOException
    //   532	550	713	java/io/IOException
    //   368	471	745	java/lang/Exception
    //   476	505	745	java/lang/Exception
    //   505	517	745	java/lang/Exception
    //   522	532	745	java/lang/Exception
    //   532	550	745	java/lang/Exception
    //   550	559	745	java/lang/Exception
    //   559	608	745	java/lang/Exception
    //   608	666	745	java/lang/Exception
    //   670	700	745	java/lang/Exception
    //   715	742	745	java/lang/Exception
    //   758	788	745	java/lang/Exception
    //   821	830	745	java/lang/Exception
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || ("0".equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.executeOnFileThread(new StyleLoaderHelper.2(this));
  }
  
  /* Error */
  public sfq b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	sfw:b	Ljava/lang/String;
    //   4: ifnonnull +35 -> 39
    //   7: ldc 43
    //   9: iconst_2
    //   10: new 45	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 330
    //   20: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aconst_null
    //   34: astore 4
    //   36: aload 4
    //   38: areturn
    //   39: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   42: lstore_2
    //   43: aload_0
    //   44: getfield 26	sfw:b	Ljava/lang/String;
    //   47: invokestatic 172	sgi:a	(Ljava/lang/String;)Lsfq;
    //   50: astore 5
    //   52: aload 5
    //   54: astore 4
    //   56: aload 5
    //   58: ifnonnull -22 -> 36
    //   61: new 192	sfq
    //   64: dup
    //   65: invokespecial 193	sfq:<init>	()V
    //   68: astore 7
    //   70: aload 7
    //   72: iconst_1
    //   73: invokevirtual 195	sfq:a	(I)V
    //   76: aload 7
    //   78: ldc 161
    //   80: invokevirtual 197	sfq:a	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 336	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   87: astore 8
    //   89: new 45	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   96: aload_0
    //   97: getfield 26	sfw:b	Ljava/lang/String;
    //   100: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 226
    //   105: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 228
    //   110: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore 9
    //   118: new 33	sfy
    //   121: dup
    //   122: aload_1
    //   123: aload 9
    //   125: invokespecial 36	sfy:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   128: astore 10
    //   130: aload 10
    //   132: invokeinterface 243 1 0
    //   137: astore 5
    //   139: aload 5
    //   141: ifnull +633 -> 774
    //   144: ldc 43
    //   146: iconst_1
    //   147: new 45	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 338
    //   157: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 5
    //   162: invokeinterface 341 1 0
    //   167: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc_w 346
    //   173: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 26	sfw:b	Ljava/lang/String;
    //   180: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: new 245	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser
    //   192: dup
    //   193: invokespecial 246	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:<init>	()V
    //   196: astore 4
    //   198: aload 4
    //   200: aload_0
    //   201: aload_0
    //   202: getfield 26	sfw:b	Ljava/lang/String;
    //   205: invokespecial 253	sfw:a	(Ljava/lang/String;)Ljava/util/Set;
    //   208: invokevirtual 257	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setAladdinKey	(Ljava/util/Set;)V
    //   211: invokestatic 352	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   214: invokevirtual 355	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   217: ifeq +568 -> 785
    //   220: invokestatic 352	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   223: astore 4
    //   225: aload 4
    //   227: aload_0
    //   228: aload_1
    //   229: aload_0
    //   230: getfield 26	sfw:b	Ljava/lang/String;
    //   233: ldc_w 259
    //   236: invokespecial 357	sfw:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   239: invokestatic 263	sgi:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   242: invokevirtual 266	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseDataMap	(Ljava/lang/String;)V
    //   245: aload 4
    //   247: aload_0
    //   248: aload_1
    //   249: aload_0
    //   250: getfield 26	sfw:b	Ljava/lang/String;
    //   253: ldc_w 268
    //   256: invokespecial 357	sfw:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   259: invokestatic 263	sgi:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   262: invokevirtual 271	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseGlobalVariable	(Ljava/lang/String;)V
    //   265: new 359	sfr
    //   268: dup
    //   269: aload_1
    //   270: aload 9
    //   272: invokespecial 360	sfr:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   275: astore 11
    //   277: aload 5
    //   279: invokeinterface 274 1 0
    //   284: astore 12
    //   286: aload 12
    //   288: invokeinterface 97 1 0
    //   293: ifeq +319 -> 612
    //   296: aload 12
    //   298: invokeinterface 101 1 0
    //   303: checkcast 75	java/lang/String
    //   306: astore 13
    //   308: aload 13
    //   310: ldc_w 278
    //   313: invokevirtual 282	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   316: ifeq -30 -> 286
    //   319: ldc 43
    //   321: iconst_2
    //   322: new 45	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 362
    //   332: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 13
    //   337: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: invokestatic 352	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   349: invokevirtual 355	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   352: ifeq +143 -> 495
    //   355: invokestatic 352	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   358: aload_1
    //   359: aload 7
    //   361: aload 11
    //   363: new 45	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   370: aload 9
    //   372: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc 226
    //   377: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 13
    //   382: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: aload 9
    //   390: new 45	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   397: aload_0
    //   398: getfield 26	sfw:b	Ljava/lang/String;
    //   401: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: ldc_w 364
    //   407: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokevirtual 368	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:createViewTempFromAssets	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   416: goto -130 -> 286
    //   419: astore 5
    //   421: ldc 43
    //   423: iconst_1
    //   424: new 45	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   431: ldc_w 370
    //   434: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload 13
    //   439: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: aload 5
    //   447: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   450: goto -164 -> 286
    //   453: astore_1
    //   454: ldc 43
    //   456: iconst_1
    //   457: ldc_w 372
    //   460: aload_1
    //   461: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   464: aconst_null
    //   465: areturn
    //   466: astore 6
    //   468: ldc 43
    //   470: iconst_2
    //   471: ldc_w 374
    //   474: aload 6
    //   476: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   479: goto -214 -> 265
    //   482: astore_1
    //   483: ldc 43
    //   485: iconst_1
    //   486: ldc_w 374
    //   489: aload_1
    //   490: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   493: aconst_null
    //   494: areturn
    //   495: aload 10
    //   497: aload 13
    //   499: invokeinterface 260 2 0
    //   504: astore 6
    //   506: aload 6
    //   508: astore 5
    //   510: aload 6
    //   512: ifnonnull +78 -> 590
    //   515: aload 8
    //   517: new 45	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   524: aload 9
    //   526: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: ldc 226
    //   531: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload 13
    //   536: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokevirtual 379	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   545: astore 5
    //   547: ldc 43
    //   549: iconst_1
    //   550: new 45	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 381
    //   560: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 9
    //   565: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: ldc 226
    //   570: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 13
    //   575: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: ldc_w 383
    //   581: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   590: aload 4
    //   592: aload 7
    //   594: aload 5
    //   596: invokestatic 263	sgi:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   599: aload 11
    //   601: invokevirtual 288	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:createViewTemplate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;)V
    //   604: aload 5
    //   606: invokevirtual 388	java/io/InputStream:close	()V
    //   609: goto -323 -> 286
    //   612: aload 7
    //   614: invokevirtual 392	sfq:getNameTemplateMap	()Ljava/util/Map;
    //   617: astore 4
    //   619: new 45	java/lang/StringBuilder
    //   622: dup
    //   623: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   626: astore_1
    //   627: aload 4
    //   629: invokeinterface 397 1 0
    //   634: invokeinterface 91 1 0
    //   639: astore 4
    //   641: aload 4
    //   643: invokeinterface 97 1 0
    //   648: ifeq +51 -> 699
    //   651: aload 4
    //   653: invokeinterface 101 1 0
    //   658: checkcast 399	java/util/Map$Entry
    //   661: astore 5
    //   663: aload_1
    //   664: new 45	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   671: aload 5
    //   673: invokeinterface 402 1 0
    //   678: checkcast 75	java/lang/String
    //   681: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: ldc 103
    //   686: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: goto -55 -> 641
    //   699: ldc 43
    //   701: iconst_2
    //   702: new 45	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   709: ldc_w 404
    //   712: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload_1
    //   716: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   728: ldc 43
    //   730: iconst_1
    //   731: new 45	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   738: ldc_w 406
    //   741: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   747: lload_2
    //   748: lsub
    //   749: invokevirtual 307	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   752: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   758: aload_0
    //   759: getfield 26	sfw:b	Ljava/lang/String;
    //   762: aload 7
    //   764: invokestatic 312	sgi:a	(Ljava/lang/String;Lsfq;)V
    //   767: aload_0
    //   768: invokespecial 314	sfw:b	()V
    //   771: aload 7
    //   773: areturn
    //   774: ldc 43
    //   776: iconst_1
    //   777: ldc_w 408
    //   780: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   783: aconst_null
    //   784: areturn
    //   785: goto -560 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	this	sfw
    //   0	788	1	paramContext	Context
    //   42	706	2	l	long
    //   34	618	4	localObject1	Object
    //   50	228	5	localObject2	Object
    //   419	27	5	localException1	java.lang.Exception
    //   508	164	5	localObject3	Object
    //   466	9	6	localException2	java.lang.Exception
    //   504	7	6	localInputStream	InputStream
    //   68	704	7	localsfq	sfq
    //   87	429	8	localAssetManager	android.content.res.AssetManager
    //   116	448	9	str1	String
    //   128	368	10	localsfy	sfy
    //   275	325	11	localsfr	sfr
    //   284	13	12	localIterator	Iterator
    //   306	268	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   346	416	419	java/lang/Exception
    //   495	506	419	java/lang/Exception
    //   515	590	419	java/lang/Exception
    //   590	609	419	java/lang/Exception
    //   118	139	453	java/lang/OutOfMemoryError
    //   144	225	453	java/lang/OutOfMemoryError
    //   225	265	453	java/lang/OutOfMemoryError
    //   265	286	453	java/lang/OutOfMemoryError
    //   286	346	453	java/lang/OutOfMemoryError
    //   346	416	453	java/lang/OutOfMemoryError
    //   421	450	453	java/lang/OutOfMemoryError
    //   468	479	453	java/lang/OutOfMemoryError
    //   495	506	453	java/lang/OutOfMemoryError
    //   515	590	453	java/lang/OutOfMemoryError
    //   590	609	453	java/lang/OutOfMemoryError
    //   612	641	453	java/lang/OutOfMemoryError
    //   641	696	453	java/lang/OutOfMemoryError
    //   699	728	453	java/lang/OutOfMemoryError
    //   774	783	453	java/lang/OutOfMemoryError
    //   225	265	466	java/lang/Exception
    //   118	139	482	java/lang/Exception
    //   144	225	482	java/lang/Exception
    //   265	286	482	java/lang/Exception
    //   286	346	482	java/lang/Exception
    //   421	450	482	java/lang/Exception
    //   468	479	482	java/lang/Exception
    //   612	641	482	java/lang/Exception
    //   641	696	482	java/lang/Exception
    //   699	728	482	java/lang/Exception
    //   774	783	482	java/lang/Exception
  }
  
  public String toString()
  {
    return " bid :" + this.jdField_a_of_type_JavaLangString + " localPath: " + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sfw
 * JD-Core Version:    0.7.0.1
 */