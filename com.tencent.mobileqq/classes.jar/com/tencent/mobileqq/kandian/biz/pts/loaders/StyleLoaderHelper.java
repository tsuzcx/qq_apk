package com.tencent.mobileqq.kandian.biz.pts.loaders;

import android.content.Context;
import android.content.res.AssetManager.AssetInputStream;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.loaders.file.ReadAssetFile;
import com.tencent.mobileqq.kandian.biz.pts.loaders.file.ReadFile;
import com.tencent.mobileqq.kandian.biz.pts.loaders.file.ReadMergeFile;
import com.tencent.mobileqq.kandian.biz.pts.realtime.RealTimeTemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils.ConfigData;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.PtsAladdinKeyConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.PtsCommentFeedsAladdinKeyConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.PtsNativeFeedsAladdinKeyConfigHandler;
import com.tencent.mobileqq.kandian.repo.pts.ProteusReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class StyleLoaderHelper
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1000);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public StyleLoaderHelper(String paramString1, String paramString2)
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
    return new ReadAssetFile(paramContext, paramString1).a(paramString2);
  }
  
  private String a(String paramString1, String paramString2, String paramString3, InputStream paramInputStream)
  {
    if ((paramInputStream instanceof AssetManager.AssetInputStream))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("/");
      paramString1.append(paramString3);
      return paramString1.toString();
    }
    paramString2 = paramString3;
    if ((paramInputStream instanceof FileInputStream))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("/");
      paramString2.append(paramString3);
      paramString2 = paramString2.toString();
    }
    return paramString2;
  }
  
  private Set<String> a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getAladdinKeysByService | localPath ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("TemplateFactory", 2, ((StringBuilder)localObject1).toString());
    localObject1 = new HashSet();
    if (TextUtils.isEmpty(paramString)) {
      return localObject1;
    }
    if (paramString.contains("default_feeds"))
    {
      localObject1 = PtsAladdinKeyConfigHandler.a();
      QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_DEFAULT_FEEDS ");
    }
    else if (paramString.contains("native_article"))
    {
      localObject1 = PtsNativeFeedsAladdinKeyConfigHandler.a();
      QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_NATIVE_ARTICLE ");
    }
    else if (paramString.contains("comment_feeds"))
    {
      localObject1 = PtsCommentFeedsAladdinKeyConfigHandler.a();
      QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_COMMENT_FEEDS ");
    }
    paramString = new StringBuilder();
    Object localObject2 = ((Set)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Iterator)localObject2).next());
      localStringBuilder.append("\n");
      paramString.append(localStringBuilder.toString());
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getAladdinKeysByService | aladdinKeys: ");
    ((StringBuilder)localObject2).append(paramString.toString());
    QLog.d("TemplateFactory", 1, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  public static void a(String paramString)
  {
    RealTimeTemplateFactory.a(paramString, true);
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new StyleLoaderHelper.1(this));
  }
  
  public TemplateFactory a(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  public TemplateFactory a(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("tryLoadTemplateFromOfflineDir ");
    ((StringBuilder)localObject1).append(this);
    QLog.d("TemplateFactory", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_JavaLangString;
    if ((localObject1 != null) && (!"0".equals(localObject1)))
    {
      localObject1 = OfflineUtils.a(this.jdField_a_of_type_JavaLangString);
      if ((paramBoolean) && (localObject1 != null)) {
        return localObject1;
      }
      localObject1 = OfflineUtils.a(this.jdField_a_of_type_JavaLangString);
      if (!((OfflineUtils.ConfigData)localObject1).jdField_a_of_type_Boolean)
      {
        if (((OfflineUtils.ConfigData)localObject1).jdField_a_of_type_Int == 1001)
        {
          paramContext = new StringBuilder();
          paramContext.append("tryLoadTemplateFromOfflineDir: ");
          paramContext.append(this.jdField_a_of_type_JavaLangString);
          paramContext.append("  1. 请检查离线包是否下载完成 2.是否包含proteus_config.geojson");
          QLog.e("TemplateFactory", 1, paramContext.toString());
          return null;
        }
        paramContext = new StringBuilder();
        paramContext.append("tryLoadTemplateFromOfflineDir: ");
        paramContext.append(this.jdField_a_of_type_JavaLangString);
        paramContext.append(" invalid");
        QLog.e("TemplateFactory", 1, paramContext.toString());
        return null;
      }
      Object localObject2 = new TemplateFactory();
      ((TemplateFactory)localObject2).a(2);
      ((TemplateFactory)localObject2).a(this.jdField_a_of_type_JavaLangString);
      ((TemplateFactory)localObject2).a((OfflineUtils.ConfigData)localObject1);
      long l = System.currentTimeMillis();
      localObject1 = OfflineEnvHelper.a(this.jdField_a_of_type_JavaLangString);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("tryLoadTemplateFromOfflineDir:");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.d("TemplateFactory", 2, ((StringBuilder)localObject3).toString());
      if (localObject1 == null)
      {
        paramContext = new StringBuilder();
        paramContext.append("tryLoadTemplateFromOfflineDir:");
        paramContext.append(this.jdField_a_of_type_JavaLangString);
        paramContext.append(" 没找到该离线包,请确认离线包是否下载完成");
        QLog.d("TemplateFactory", 1, paramContext.toString());
        return null;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
      localObject1 = ((StringBuilder)localObject3).toString();
      if (!OfflineSecurity.a((String)localObject1, this.jdField_a_of_type_JavaLangString))
      {
        paramContext = new StringBuilder();
        paramContext.append("tryReadJsonFromOfflineDir:");
        paramContext.append(this.jdField_a_of_type_JavaLangString);
        paramContext.append(" 安全检查: 离线包被修改过,不使用离线包");
        QLog.d("TemplateFactory", 1, paramContext.toString());
        return null;
      }
      try
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("/");
        ((StringBuilder)localObject3).append("styles");
        localObject3 = ((StringBuilder)localObject3).toString();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.b);
        ((StringBuilder)localObject4).append("/");
        ((StringBuilder)localObject4).append("styles");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = new ReadMergeFile(paramContext, (String)localObject1, this.b);
        ReadMergeFile localReadMergeFile = new ReadMergeFile(paramContext, (String)localObject3, (String)localObject4);
        OfflineComplementFileStringLoader localOfflineComplementFileStringLoader = new OfflineComplementFileStringLoader(localReadMergeFile);
        paramContext = localReadMergeFile.a();
        ProteusParser localProteusParser;
        Object localObject5;
        if (paramContext != null)
        {
          localProteusParser = new ProteusParser();
          localProteusParser.setVersion("8.7.0");
          localProteusParser.setAladdinKey(a(this.b));
          try
          {
            localObject1 = ((ReadFile)localObject1).a("style_map.geojson");
            if (localObject1 != null) {
              localProteusParser.parseDataMap(OfflineUtils.a((InputStream)localObject1));
            }
          }
          catch (IOException localIOException)
          {
            localObject5 = new StringBuilder();
          }
        }
        try
        {
          ((StringBuilder)localObject5).append("data_map.geojson or global_variable.geojson not exist ! ");
          ((StringBuilder)localObject5).append(localIOException);
          QLog.i("TemplateFactory", 1, ((StringBuilder)localObject5).toString());
          localObject5 = paramContext.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            Object localObject6 = (String)((Iterator)localObject5).next();
            paramContext = new StringBuilder();
            paramContext.append("加载样式 | fileName ");
            paramContext.append((String)localObject6);
            QLog.d("TemplateFactory", 1, paramContext.toString());
            String str = "";
            paramContext = str;
            try
            {
              if (((String)localObject6).endsWith(".geojson"))
              {
                paramContext = str;
                ((ReadMergeFile)localReadMergeFile).a((String)localObject6);
                paramContext = str;
                InputStream localInputStream = localReadMergeFile.a((String)localObject6);
                paramContext = str;
                str = a((String)localObject3, (String)localObject4, (String)localObject6, localInputStream);
                paramContext = str;
                localProteusParser.createViewTemplate((BaseTemplateFactory)localObject2, OfflineUtils.a(localInputStream), localOfflineComplementFileStringLoader);
                paramContext = str;
                localObject6 = new StringBuilder();
                paramContext = str;
                ((StringBuilder)localObject6).append("加载样式成功 | filePath: ");
                paramContext = str;
                ((StringBuilder)localObject6).append(str);
                paramContext = str;
                QLog.d("TemplateFactory", 1, ((StringBuilder)localObject6).toString());
              }
            }
            catch (JSONException localJSONException)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("tryLoadTemplateFromOfflineDir: 该文件不符合Json格式,请检查 ");
              ((StringBuilder)localObject2).append(paramContext);
              QLog.e("TemplateFactory", 1, ((StringBuilder)localObject2).toString(), localJSONException);
              throw localJSONException;
            }
          }
          paramContext = new StringBuilder();
          paramContext.append("tryLoadTemplateFromOfflineDir: spent ");
          paramContext.append(System.currentTimeMillis() - l);
          paramContext.append("ms");
          QLog.d("TemplateFactory", 2, paramContext.toString());
          QLog.d("TemplateFactory", 1, "tryLoadTemplateFromOfflineDir: successfully load template from Offline Dir.");
          OfflineUtils.a(this.jdField_a_of_type_JavaLangString, (TemplateFactory)localObject2);
          b();
          ProteusReportUtil.a(3, this.jdField_a_of_type_JavaLangString);
          return localObject2;
        }
        catch (OutOfMemoryError paramContext) {}
        QLog.d("TemplateFactory", 1, "tryLoadTemplateFromOfflineDir: styles folder is empty");
        return null;
      }
      catch (Exception paramContext)
      {
        QLog.e("TemplateFactory", 1, "tryLoadTemplateFromOfflineDir:离线包加载出现错误, 将使用本地样式", paramContext);
        return null;
      }
      catch (OutOfMemoryError paramContext) {}
      QLog.e("TemplateFactory", 1, "tryLoadTemplateFromOfflineDir: oom 将使用本地样式", paramContext);
      return null;
    }
    paramContext = new StringBuilder();
    paramContext.append("使用用本地样式: ");
    paramContext.append(this);
    QLog.d("TemplateFactory", 2, paramContext.toString());
    return null;
  }
  
  public void a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null)
    {
      if ("0".equals(str)) {
        return;
      }
      ThreadManager.executeOnFileThread(new StyleLoaderHelper.2(this));
    }
  }
  
  /* Error */
  public TemplateFactory b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 10
    //   3: ldc_w 341
    //   6: astore 7
    //   8: aload 10
    //   10: getfield 26	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   13: ifnonnull +38 -> 51
    //   16: new 45	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_1
    //   25: ldc_w 285
    //   28: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: aload 10
    //   35: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 63
    //   41: iconst_2
    //   42: aload_1
    //   43: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aconst_null
    //   50: areturn
    //   51: invokestatic 215	java/lang/System:currentTimeMillis	()J
    //   54: lstore_2
    //   55: aload 10
    //   57: getfield 26	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   60: invokestatic 179	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/kandian/biz/pts/factory/TemplateFactory;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +6 -> 73
    //   70: aload 5
    //   72: areturn
    //   73: new 201	com/tencent/mobileqq/kandian/biz/pts/factory/TemplateFactory
    //   76: dup
    //   77: invokespecial 202	com/tencent/mobileqq/kandian/biz/pts/factory/TemplateFactory:<init>	()V
    //   80: astore 6
    //   82: aload 6
    //   84: iconst_1
    //   85: invokevirtual 204	com/tencent/mobileqq/kandian/biz/pts/factory/TemplateFactory:a	(I)V
    //   88: aload 6
    //   90: ldc 170
    //   92: invokevirtual 206	com/tencent/mobileqq/kandian/biz/pts/factory/TemplateFactory:a	(Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokevirtual 347	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   99: astore 12
    //   101: new 45	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   108: astore 5
    //   110: aload 5
    //   112: aload 10
    //   114: getfield 26	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   117: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: ldc 52
    //   123: astore 8
    //   125: aload 5
    //   127: ldc 52
    //   129: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: ldc 235
    //   137: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 5
    //   143: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore 5
    //   148: aload 7
    //   150: astore 9
    //   152: new 33	com/tencent/mobileqq/kandian/biz/pts/loaders/file/ReadAssetFile
    //   155: dup
    //   156: aload_1
    //   157: aload 5
    //   159: invokespecial 36	com/tencent/mobileqq/kandian/biz/pts/loaders/file/ReadAssetFile:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   162: astore 14
    //   164: aload 7
    //   166: astore 9
    //   168: aload 14
    //   170: invokeinterface 250 1 0
    //   175: astore 15
    //   177: aload 15
    //   179: ifnull +890 -> 1069
    //   182: aload 7
    //   184: astore 9
    //   186: new 45	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   193: astore 11
    //   195: aload 7
    //   197: astore 9
    //   199: aload 11
    //   201: ldc_w 349
    //   204: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 7
    //   210: astore 9
    //   212: aload 11
    //   214: aload 15
    //   216: invokeinterface 352 1 0
    //   221: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 7
    //   227: astore 9
    //   229: aload 11
    //   231: ldc_w 357
    //   234: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 7
    //   240: astore 9
    //   242: aload 11
    //   244: aload 10
    //   246: getfield 26	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   249: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 7
    //   255: astore 9
    //   257: ldc 63
    //   259: iconst_1
    //   260: aload 11
    //   262: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: aload 7
    //   270: astore 9
    //   272: new 252	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser
    //   275: dup
    //   276: invokespecial 253	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:<init>	()V
    //   279: astore 11
    //   281: aload 7
    //   283: astore 9
    //   285: aload 11
    //   287: aload 10
    //   289: aload 10
    //   291: getfield 26	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   294: invokespecial 260	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:a	(Ljava/lang/String;)Ljava/util/Set;
    //   297: invokevirtual 264	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setAladdinKey	(Ljava/util/Set;)V
    //   300: aload 7
    //   302: astore 9
    //   304: invokestatic 363	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   307: invokevirtual 366	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   310: istore 4
    //   312: iload 4
    //   314: ifeq +20 -> 334
    //   317: invokestatic 363	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   320: astore 11
    //   322: goto +12 -> 334
    //   325: astore_1
    //   326: ldc_w 341
    //   329: astore 5
    //   331: goto +775 -> 1106
    //   334: aload 11
    //   336: aload 10
    //   338: aload_1
    //   339: aload 10
    //   341: getfield 26	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   344: ldc_w 266
    //   347: invokespecial 368	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   350: invokestatic 270	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   353: invokevirtual 273	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseDataMap	(Ljava/lang/String;)V
    //   356: goto +24 -> 380
    //   359: astore_1
    //   360: goto +759 -> 1119
    //   363: astore 10
    //   365: aload 7
    //   367: astore 9
    //   369: ldc 63
    //   371: iconst_2
    //   372: ldc_w 341
    //   375: aload 10
    //   377: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   380: aload 7
    //   382: astore 9
    //   384: new 370	com/tencent/mobileqq/kandian/biz/pts/loaders/AssetsComplementFileStringLoader
    //   387: dup
    //   388: aload_1
    //   389: aload 5
    //   391: invokespecial 371	com/tencent/mobileqq/kandian/biz/pts/loaders/AssetsComplementFileStringLoader:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   394: astore 13
    //   396: aload 7
    //   398: astore 9
    //   400: aload 15
    //   402: invokeinterface 281 1 0
    //   407: astore 18
    //   409: aload 7
    //   411: astore 9
    //   413: aload 18
    //   415: invokeinterface 118 1 0
    //   420: istore 4
    //   422: iload 4
    //   424: ifeq +433 -> 857
    //   427: aload 18
    //   429: invokeinterface 122 1 0
    //   434: checkcast 82	java/lang/String
    //   437: astore 15
    //   439: aload 15
    //   441: ldc_w 287
    //   444: invokevirtual 291	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   447: ifeq +399 -> 846
    //   450: new 45	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   457: astore 9
    //   459: aload 9
    //   461: ldc_w 373
    //   464: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 9
    //   470: aload 15
    //   472: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: ldc 63
    //   478: iconst_2
    //   479: aload 9
    //   481: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: invokestatic 363	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   490: invokevirtual 366	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   493: istore 4
    //   495: iload 4
    //   497: ifeq +110 -> 607
    //   500: invokestatic 363	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   503: astore 10
    //   505: new 45	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   512: astore 9
    //   514: aload 9
    //   516: aload 5
    //   518: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload 9
    //   524: aload 8
    //   526: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 9
    //   532: aload 15
    //   534: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 9
    //   540: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: astore 16
    //   545: new 45	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   552: astore 9
    //   554: aload 9
    //   556: aload_0
    //   557: getfield 26	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   560: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 9
    //   566: ldc_w 375
    //   569: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 9
    //   575: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: astore 17
    //   580: aload 5
    //   582: astore 9
    //   584: aload 10
    //   586: aload_1
    //   587: aload 6
    //   589: aload 13
    //   591: aload 16
    //   593: aload 9
    //   595: aload 17
    //   597: invokevirtual 379	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:createViewTempFromAssets	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   600: aload 9
    //   602: astore 5
    //   604: goto +242 -> 846
    //   607: aload 5
    //   609: astore 9
    //   611: aload 8
    //   613: astore 10
    //   615: aload 15
    //   617: astore 16
    //   619: aload 14
    //   621: aload 16
    //   623: invokeinterface 267 2 0
    //   628: astore 17
    //   630: aload 17
    //   632: ifnonnull +518 -> 1150
    //   635: new 45	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   642: astore 17
    //   644: aload 17
    //   646: aload 9
    //   648: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload 17
    //   654: aload 10
    //   656: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload 17
    //   662: aload 16
    //   664: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 12
    //   670: aload 17
    //   672: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokevirtual 384	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   678: astore 17
    //   680: new 45	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   687: astore 19
    //   689: aload 19
    //   691: ldc_w 386
    //   694: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload 19
    //   700: aload 9
    //   702: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload 19
    //   708: aload 10
    //   710: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload 19
    //   716: aload 16
    //   718: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: aload 19
    //   724: ldc_w 388
    //   727: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: ldc 63
    //   733: iconst_1
    //   734: aload 19
    //   736: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   742: aload 17
    //   744: astore 10
    //   746: goto +3 -> 749
    //   749: aload 5
    //   751: astore 9
    //   753: aload 10
    //   755: invokestatic 270	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   758: astore 16
    //   760: aload 11
    //   762: aload 6
    //   764: aload 16
    //   766: aload 13
    //   768: invokevirtual 298	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:createViewTemplate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;)V
    //   771: aload 10
    //   773: invokevirtual 393	java/io/InputStream:close	()V
    //   776: aload 9
    //   778: astore 5
    //   780: goto +66 -> 846
    //   783: astore 10
    //   785: aload 9
    //   787: astore 5
    //   789: goto +15 -> 804
    //   792: astore 10
    //   794: goto +5 -> 799
    //   797: astore 10
    //   799: goto +5 -> 804
    //   802: astore 10
    //   804: new 45	java/lang/StringBuilder
    //   807: dup
    //   808: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   811: astore 9
    //   813: aload 9
    //   815: ldc_w 395
    //   818: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: aload 9
    //   824: aload 15
    //   826: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: pop
    //   830: ldc 63
    //   832: iconst_1
    //   833: aload 9
    //   835: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: aload 10
    //   840: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   843: goto +3 -> 846
    //   846: goto -437 -> 409
    //   849: astore_1
    //   850: goto +252 -> 1102
    //   853: astore_1
    //   854: goto +265 -> 1119
    //   857: aload 6
    //   859: invokevirtual 399	com/tencent/mobileqq/kandian/biz/pts/factory/TemplateFactory:getNameTemplateMap	()Ljava/util/Map;
    //   862: astore 5
    //   864: new 45	java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   871: astore_1
    //   872: aload 5
    //   874: invokeinterface 404 1 0
    //   879: invokeinterface 112 1 0
    //   884: astore 5
    //   886: aload 5
    //   888: invokeinterface 118 1 0
    //   893: istore 4
    //   895: iload 4
    //   897: ifeq +65 -> 962
    //   900: aload 5
    //   902: invokeinterface 122 1 0
    //   907: checkcast 406	java/util/Map$Entry
    //   910: astore 8
    //   912: new 45	java/lang/StringBuilder
    //   915: dup
    //   916: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   919: astore 9
    //   921: aload 9
    //   923: aload 8
    //   925: invokeinterface 409 1 0
    //   930: checkcast 82	java/lang/String
    //   933: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: pop
    //   937: aload 9
    //   939: ldc 124
    //   941: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: pop
    //   945: aload_1
    //   946: aload 9
    //   948: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: goto -69 -> 886
    //   958: astore_1
    //   959: goto -105 -> 854
    //   962: new 45	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   969: astore 5
    //   971: aload 5
    //   973: ldc_w 411
    //   976: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: aload 5
    //   982: aload_1
    //   983: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: ldc 63
    //   992: iconst_2
    //   993: aload 5
    //   995: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1001: new 45	java/lang/StringBuilder
    //   1004: dup
    //   1005: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1008: astore_1
    //   1009: aload_1
    //   1010: ldc_w 413
    //   1013: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: pop
    //   1017: aload_1
    //   1018: invokestatic 215	java/lang/System:currentTimeMillis	()J
    //   1021: lload_2
    //   1022: lsub
    //   1023: invokevirtual 310	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1026: pop
    //   1027: ldc 63
    //   1029: iconst_1
    //   1030: aload_1
    //   1031: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1034: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1037: aload_0
    //   1038: getfield 26	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   1041: aload 6
    //   1043: invokestatic 317	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/kandian/biz/pts/factory/TemplateFactory;)V
    //   1046: aload_0
    //   1047: invokespecial 319	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:b	()V
    //   1050: aload 6
    //   1052: areturn
    //   1053: aload 7
    //   1055: astore 5
    //   1057: astore_1
    //   1058: goto +28 -> 1086
    //   1061: astore_1
    //   1062: goto +28 -> 1090
    //   1065: astore_1
    //   1066: goto +24 -> 1090
    //   1069: ldc_w 341
    //   1072: astore 5
    //   1074: ldc 63
    //   1076: iconst_1
    //   1077: ldc_w 415
    //   1080: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: aconst_null
    //   1084: areturn
    //   1085: astore_1
    //   1086: goto +20 -> 1106
    //   1089: astore_1
    //   1090: goto +29 -> 1119
    //   1093: astore_1
    //   1094: goto +25 -> 1119
    //   1097: astore_1
    //   1098: aload 9
    //   1100: astore 7
    //   1102: aload 7
    //   1104: astore 5
    //   1106: ldc 63
    //   1108: iconst_1
    //   1109: aload 5
    //   1111: aload_1
    //   1112: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1115: aconst_null
    //   1116: areturn
    //   1117: astore 5
    //   1119: ldc 63
    //   1121: iconst_1
    //   1122: ldc_w 417
    //   1125: aload_1
    //   1126: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1129: aconst_null
    //   1130: areturn
    //   1131: astore 9
    //   1133: goto +5 -> 1138
    //   1136: astore 9
    //   1138: goto +5 -> 1143
    //   1141: astore 9
    //   1143: aload 9
    //   1145: astore 10
    //   1147: goto -343 -> 804
    //   1150: aload 17
    //   1152: astore 10
    //   1154: goto -405 -> 749
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1157	0	this	StyleLoaderHelper
    //   0	1157	1	paramContext	Context
    //   54	968	2	l	long
    //   310	586	4	bool	boolean
    //   63	1047	5	localObject1	Object
    //   80	971	6	localTemplateFactory	TemplateFactory
    //   6	1097	7	localObject2	Object
    //   123	801	8	localObject3	Object
    //   150	949	9	localObject4	Object
    //   1	339	10	localStyleLoaderHelper	StyleLoaderHelper
    //   363	13	10	localException1	Exception
    //   503	269	10	localObject5	Object
    //   783	1	10	localException2	Exception
    //   792	1	10	localException3	Exception
    //   797	1	10	localException4	Exception
    //   802	37	10	localException5	Exception
    //   193	568	11	localObject6	Object
    //   99	570	12	localAssetManager	android.content.res.AssetManager
    //   394	373	13	localAssetsComplementFileStringLoader	AssetsComplementFileStringLoader
    //   162	458	14	localReadAssetFile	ReadAssetFile
    //   175	650	15	localObject7	Object
    //   543	222	16	localObject8	Object
    //   578	165	17	localObject9	Object
    //   407	21	18	localIterator	Iterator
    //   687	48	19	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   317	322	325	java/lang/Exception
    //   317	322	359	java/lang/OutOfMemoryError
    //   334	356	359	java/lang/OutOfMemoryError
    //   334	356	363	java/lang/Exception
    //   760	776	783	java/lang/Exception
    //   644	742	792	java/lang/Exception
    //   753	760	792	java/lang/Exception
    //   584	600	797	java/lang/Exception
    //   619	630	797	java/lang/Exception
    //   635	644	797	java/lang/Exception
    //   487	495	802	java/lang/Exception
    //   427	487	849	java/lang/Exception
    //   427	487	853	java/lang/OutOfMemoryError
    //   487	495	853	java/lang/OutOfMemoryError
    //   500	545	853	java/lang/OutOfMemoryError
    //   545	554	853	java/lang/OutOfMemoryError
    //   554	580	853	java/lang/OutOfMemoryError
    //   584	600	958	java/lang/OutOfMemoryError
    //   619	630	958	java/lang/OutOfMemoryError
    //   635	644	958	java/lang/OutOfMemoryError
    //   644	742	958	java/lang/OutOfMemoryError
    //   753	760	958	java/lang/OutOfMemoryError
    //   760	776	958	java/lang/OutOfMemoryError
    //   804	843	958	java/lang/OutOfMemoryError
    //   900	955	958	java/lang/OutOfMemoryError
    //   804	843	1053	java/lang/Exception
    //   857	886	1053	java/lang/Exception
    //   886	895	1053	java/lang/Exception
    //   900	955	1053	java/lang/Exception
    //   962	1001	1053	java/lang/Exception
    //   857	886	1061	java/lang/OutOfMemoryError
    //   886	895	1061	java/lang/OutOfMemoryError
    //   962	1001	1061	java/lang/OutOfMemoryError
    //   199	208	1065	java/lang/OutOfMemoryError
    //   212	225	1065	java/lang/OutOfMemoryError
    //   229	238	1065	java/lang/OutOfMemoryError
    //   242	253	1065	java/lang/OutOfMemoryError
    //   257	268	1065	java/lang/OutOfMemoryError
    //   272	281	1065	java/lang/OutOfMemoryError
    //   285	300	1065	java/lang/OutOfMemoryError
    //   304	312	1065	java/lang/OutOfMemoryError
    //   369	380	1065	java/lang/OutOfMemoryError
    //   384	396	1065	java/lang/OutOfMemoryError
    //   400	409	1065	java/lang/OutOfMemoryError
    //   413	422	1065	java/lang/OutOfMemoryError
    //   1074	1083	1085	java/lang/Exception
    //   1074	1083	1089	java/lang/OutOfMemoryError
    //   152	164	1093	java/lang/OutOfMemoryError
    //   168	177	1093	java/lang/OutOfMemoryError
    //   186	195	1093	java/lang/OutOfMemoryError
    //   152	164	1097	java/lang/Exception
    //   168	177	1097	java/lang/Exception
    //   186	195	1097	java/lang/Exception
    //   199	208	1097	java/lang/Exception
    //   212	225	1097	java/lang/Exception
    //   229	238	1097	java/lang/Exception
    //   242	253	1097	java/lang/Exception
    //   257	268	1097	java/lang/Exception
    //   272	281	1097	java/lang/Exception
    //   285	300	1097	java/lang/Exception
    //   304	312	1097	java/lang/Exception
    //   369	380	1097	java/lang/Exception
    //   384	396	1097	java/lang/Exception
    //   400	409	1097	java/lang/Exception
    //   413	422	1097	java/lang/Exception
    //   554	580	1131	java/lang/Exception
    //   545	554	1136	java/lang/Exception
    //   500	545	1141	java/lang/Exception
  }
  
  public void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resetTemplates: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("TemplateFactory", 1, ((StringBuilder)localObject).toString());
    localObject = a(BaseApplicationImpl.getApplication(), false);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("templateFactory == null  bid : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TemplateFactory", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ((TemplateFactory)localObject).a(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet());
    OfflineUtils.a(paramString, (TemplateFactory)localObject);
    TemplateFactory.a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" bid :");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" localPath: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" config: ");
    localStringBuilder.append(HtmlOffline.a(this.jdField_a_of_type_JavaLangString));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.StyleLoaderHelper
 * JD-Core Version:    0.7.0.1
 */