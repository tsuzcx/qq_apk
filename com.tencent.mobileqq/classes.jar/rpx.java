import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.1;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class rpx
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1000);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public rpx(String paramString1, String paramString2)
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
    return new rpz(paramContext, paramString1).a(paramString2);
  }
  
  public static void a(String paramString)
  {
    rqg.a(paramString, true);
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new StyleLoaderHelper.1(this));
  }
  
  public rpr a(Context paramContext)
  {
    QLog.d("TemplateFactory", 1, "tryLoadTemplateFromOfflineDir " + this);
    if ((this.jdField_a_of_type_JavaLangString == null) || ("0".equals(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("TemplateFactory", 2, "使用用本地样式: " + this);
      localObject1 = null;
    }
    do
    {
      return localObject1;
      localObject2 = rqj.a(this.jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject2 = rqj.a(this.jdField_a_of_type_JavaLangString);
    if (!((rqk)localObject2).jdField_a_of_type_Boolean)
    {
      if (((rqk)localObject2).jdField_a_of_type_Int == 1001) {
        QLog.e("TemplateFactory", 4, "tryLoadTemplateFromOfflineDir: " + this.jdField_a_of_type_JavaLangString + "  1. 请检查离线包是否下载完成 2.是否包含proteus_config.geojson");
      }
      for (;;)
      {
        return null;
        QLog.e("TemplateFactory", 4, "tryLoadTemplateFromOfflineDir: " + this.jdField_a_of_type_JavaLangString);
      }
    }
    Object localObject1 = new rpr();
    ((rpr)localObject1).a(2);
    ((rpr)localObject1).a(this.jdField_a_of_type_JavaLangString);
    ((rpr)localObject1).a((rqk)localObject2);
    long l = System.currentTimeMillis();
    localObject2 = mzh.a(this.jdField_a_of_type_JavaLangString);
    QLog.d("TemplateFactory", 2, "tryLoadTemplateFromOfflineDir:" + (String)localObject2);
    if (localObject2 == null)
    {
      QLog.d("TemplateFactory", 1, "tryLoadTemplateFromOfflineDir:" + this.jdField_a_of_type_JavaLangString + " 没找到该离线包,请确认离线包是否下载完成");
      return null;
    }
    Object localObject3 = (String)localObject2 + this.jdField_a_of_type_JavaLangString;
    if (!nap.a((String)localObject3, this.jdField_a_of_type_JavaLangString))
    {
      QLog.d("TemplateFactory", 1, "tryReadJsonFromOfflineDir:" + this.jdField_a_of_type_JavaLangString + " 安全检查: 离线包被修改过,不使用离线包");
      return null;
    }
    try
    {
      localObject2 = (String)localObject3 + "/" + "styles";
      Object localObject4 = this.b + "/" + "styles";
      localObject3 = new rqb(paramContext, (String)localObject3, this.b);
      paramContext = new rqb(paramContext, (String)localObject2, (String)localObject4);
      localObject2 = new rpt(paramContext);
      localObject4 = paramContext.a();
      if (localObject4 != null)
      {
        Object localObject5 = ((rqa)localObject3).a("style_map.geojson");
        localObject3 = new ProteusParser();
        ((ProteusParser)localObject3).setVersion("8.3.0");
        ((ProteusParser)localObject3).setAladdinKey(oph.a());
        if (localObject5 != null) {
          ((ProteusParser)localObject3).parseDataMap(rqj.a((InputStream)localObject5));
        }
        localObject5 = ((List)localObject4).iterator();
        for (;;)
        {
          if (((Iterator)localObject5).hasNext())
          {
            localObject4 = (String)((Iterator)localObject5).next();
            try
            {
              if (((String)localObject4).endsWith(".geojson"))
              {
                QLog.d("TemplateFactory", 2, "加载样式 file: " + (String)localObject4);
                ((ProteusParser)localObject3).createViewTemplate((BaseTemplateFactory)localObject1, rqj.a(paramContext.a((String)localObject4)), (ComplementFileStringLoader)localObject2);
              }
            }
            catch (JSONException paramContext)
            {
              QLog.e("TemplateFactory", 1, "tryLoadTemplateFromOfflineDir: 该文件不符合Json格式,请检查 " + (String)localObject4, paramContext);
              throw paramContext;
            }
          }
        }
      }
      return null;
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.e("TemplateFactory", 1, "tryLoadTemplateFromOfflineDir: oom 将使用本地样式", paramContext);
      return null;
      QLog.d("TemplateFactory", 2, "tryLoadTemplateFromOfflineDir: spent " + (System.currentTimeMillis() - l));
      QLog.d("TemplateFactory", 1, "tryLoadTemplateFromOfflineDir: successfully load template from Offline Dir.");
      rqj.a(this.jdField_a_of_type_JavaLangString, (rpr)localObject1);
      b();
      sez.a(3, this.jdField_a_of_type_JavaLangString);
      return localObject1;
      QLog.d("TemplateFactory", 1, "tryLoadTemplateFromOfflineDir: styles folder is empty");
      return null;
    }
    catch (Exception paramContext)
    {
      QLog.e("TemplateFactory", 1, "tryLoadTemplateFromOfflineDir:离线包加载出现错误, 将使用本地样式", paramContext);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || ("0".equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.executeOnFileThread(new StyleLoaderHelper.2(this));
  }
  
  /* Error */
  public rpr b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	rpx:b	Ljava/lang/String;
    //   4: ifnonnull +35 -> 39
    //   7: ldc 73
    //   9: iconst_2
    //   10: new 75	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 272
    //   20: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aconst_null
    //   34: astore 5
    //   36: aload 5
    //   38: areturn
    //   39: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   42: lstore_2
    //   43: aload_0
    //   44: getfield 26	rpx:b	Ljava/lang/String;
    //   47: invokestatic 110	rqj:a	(Ljava/lang/String;)Lrpr;
    //   50: astore 6
    //   52: aload 6
    //   54: astore 5
    //   56: aload 6
    //   58: ifnonnull -22 -> 36
    //   61: new 130	rpr
    //   64: dup
    //   65: invokespecial 131	rpr:<init>	()V
    //   68: astore 8
    //   70: aload 8
    //   72: iconst_1
    //   73: invokevirtual 133	rpr:a	(I)V
    //   76: aload 8
    //   78: ldc 97
    //   80: invokevirtual 135	rpr:a	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 278	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   87: astore 9
    //   89: new 75	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   96: aload_0
    //   97: getfield 26	rpx:b	Ljava/lang/String;
    //   100: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 164
    //   105: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 166
    //   110: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore 10
    //   118: new 33	rpz
    //   121: dup
    //   122: aload_1
    //   123: aload 10
    //   125: invokespecial 36	rpz:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   128: astore 11
    //   130: aload 11
    //   132: invokeinterface 181 1 0
    //   137: astore 6
    //   139: aload 6
    //   141: ifnull +400 -> 541
    //   144: ldc 73
    //   146: iconst_1
    //   147: new 75	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 280
    //   157: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 6
    //   162: invokeinterface 283 1 0
    //   167: invokevirtual 286	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: new 186	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser
    //   179: dup
    //   180: invokespecial 187	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:<init>	()V
    //   183: astore 5
    //   185: invokestatic 292	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   188: invokevirtual 295	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   191: ifeq +407 -> 598
    //   194: invokestatic 292	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   197: astore 5
    //   199: aload 5
    //   201: aload_0
    //   202: aload_1
    //   203: aload_0
    //   204: getfield 26	rpx:b	Ljava/lang/String;
    //   207: ldc 183
    //   209: invokespecial 297	rpx:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   212: invokestatic 204	rqj:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   215: invokevirtual 207	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseDataMap	(Ljava/lang/String;)V
    //   218: new 299	rps
    //   221: dup
    //   222: aload_1
    //   223: aload 10
    //   225: invokespecial 300	rps:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   228: astore 12
    //   230: aload 6
    //   232: invokeinterface 213 1 0
    //   237: astore 13
    //   239: aload 13
    //   241: invokeinterface 219 1 0
    //   246: ifeq +306 -> 552
    //   249: aload 13
    //   251: invokeinterface 223 1 0
    //   256: checkcast 99	java/lang/String
    //   259: astore 14
    //   261: aload 14
    //   263: ldc 225
    //   265: invokevirtual 229	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   268: istore 4
    //   270: iload 4
    //   272: ifeq -33 -> 239
    //   275: invokestatic 292	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   278: invokevirtual 295	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   281: ifeq +143 -> 424
    //   284: invokestatic 292	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   287: aload_1
    //   288: aload 8
    //   290: aload 12
    //   292: new 75	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   299: aload 10
    //   301: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc 164
    //   306: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload 14
    //   311: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: aload 10
    //   319: new 75	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   326: aload_0
    //   327: getfield 26	rpx:b	Ljava/lang/String;
    //   330: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc_w 302
    //   336: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokevirtual 306	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:createViewTempFromAssets	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   345: goto -106 -> 239
    //   348: astore 6
    //   350: ldc 73
    //   352: iconst_1
    //   353: new 75	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 308
    //   363: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 14
    //   368: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: aload 6
    //   376: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   379: goto -140 -> 239
    //   382: astore_1
    //   383: ldc 73
    //   385: iconst_1
    //   386: ldc_w 310
    //   389: aload_1
    //   390: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   393: aconst_null
    //   394: areturn
    //   395: astore 7
    //   397: ldc 73
    //   399: iconst_2
    //   400: ldc_w 312
    //   403: aload 7
    //   405: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   408: goto -190 -> 218
    //   411: astore_1
    //   412: ldc 73
    //   414: iconst_1
    //   415: ldc_w 312
    //   418: aload_1
    //   419: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   422: aconst_null
    //   423: areturn
    //   424: aload 11
    //   426: aload 14
    //   428: invokeinterface 184 2 0
    //   433: astore 7
    //   435: aload 7
    //   437: astore 6
    //   439: aload 7
    //   441: ifnonnull +78 -> 519
    //   444: aload 9
    //   446: new 75	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   453: aload 10
    //   455: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc 164
    //   460: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload 14
    //   465: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokevirtual 317	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   474: astore 6
    //   476: ldc 73
    //   478: iconst_1
    //   479: new 75	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   486: ldc_w 319
    //   489: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload 10
    //   494: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: ldc 164
    //   499: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 14
    //   504: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: ldc_w 321
    //   510: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: aload 5
    //   521: aload 8
    //   523: aload 6
    //   525: invokestatic 204	rqj:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   528: aload 12
    //   530: invokevirtual 235	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:createViewTemplate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;)V
    //   533: aload 6
    //   535: invokevirtual 326	java/io/InputStream:close	()V
    //   538: goto -299 -> 239
    //   541: ldc 73
    //   543: iconst_1
    //   544: ldc_w 328
    //   547: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: aconst_null
    //   551: areturn
    //   552: ldc 73
    //   554: iconst_1
    //   555: new 75	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   562: ldc_w 330
    //   565: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   571: lload_2
    //   572: lsub
    //   573: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   576: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: aload_0
    //   583: getfield 26	rpx:b	Ljava/lang/String;
    //   586: aload 8
    //   588: invokestatic 252	rqj:a	(Ljava/lang/String;Lrpr;)V
    //   591: aload_0
    //   592: invokespecial 254	rpx:b	()V
    //   595: aload 8
    //   597: areturn
    //   598: goto -399 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	this	rpx
    //   0	601	1	paramContext	Context
    //   42	530	2	l	long
    //   268	3	4	bool	boolean
    //   34	486	5	localObject1	Object
    //   50	181	6	localObject2	Object
    //   348	27	6	localException1	Exception
    //   437	97	6	localObject3	Object
    //   395	9	7	localException2	Exception
    //   433	7	7	localInputStream	InputStream
    //   68	528	8	localrpr	rpr
    //   87	358	9	localAssetManager	android.content.res.AssetManager
    //   116	377	10	str1	String
    //   128	297	11	localrpz	rpz
    //   228	301	12	localrps	rps
    //   237	13	13	localIterator	Iterator
    //   259	244	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   275	345	348	java/lang/Exception
    //   424	435	348	java/lang/Exception
    //   444	519	348	java/lang/Exception
    //   519	538	348	java/lang/Exception
    //   118	139	382	java/lang/OutOfMemoryError
    //   144	199	382	java/lang/OutOfMemoryError
    //   199	218	382	java/lang/OutOfMemoryError
    //   218	239	382	java/lang/OutOfMemoryError
    //   239	270	382	java/lang/OutOfMemoryError
    //   275	345	382	java/lang/OutOfMemoryError
    //   350	379	382	java/lang/OutOfMemoryError
    //   397	408	382	java/lang/OutOfMemoryError
    //   424	435	382	java/lang/OutOfMemoryError
    //   444	519	382	java/lang/OutOfMemoryError
    //   519	538	382	java/lang/OutOfMemoryError
    //   541	550	382	java/lang/OutOfMemoryError
    //   199	218	395	java/lang/Exception
    //   118	139	411	java/lang/Exception
    //   144	199	411	java/lang/Exception
    //   218	239	411	java/lang/Exception
    //   239	270	411	java/lang/Exception
    //   350	379	411	java/lang/Exception
    //   397	408	411	java/lang/Exception
    //   541	550	411	java/lang/Exception
  }
  
  public String toString()
  {
    return " bid :" + this.jdField_a_of_type_JavaLangString + " localPath: " + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpx
 * JD-Core Version:    0.7.0.1
 */