package com.tencent.mobileqq.kandian.repo.webarticle;

import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/RIJWebResourceUtil;", "", "()V", "ARTICLE_CSS_URL", "", "ARTICLE_NEW_CSS_URL", "BEACON_WEB_SCRIPT_URL", "CSS_EXT", "DEFAULT_ARTICLE_CSS", "DEFAULT_ARTICLE_NEW_CSS", "DEFAULT_BEACON_WEB_SCRIPT", "JS_EXT", "RES_BID", "TAG", "fileMap", "Ljava/util/concurrent/ConcurrentHashMap;", "resourceUrlList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFileContent", "filePath", "getResDir", "getWebResourceContent", "url", "getWebResourceResponse", "Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;", "isResourceUrlIntercept", "", "loadFile", "", "preloadResource", "forceLoad", "updateResourceOfflinePkg", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebResourceUtil
{
  public static final RIJWebResourceUtil a;
  private static final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = CollectionsKt.arrayListOf(new String[] { "https://tkd-fe.cdn-go.cn/KdDetailPage/latest/themes/default/client/article/article.css", "https://watchspot.cdn-go.cn/article-new/latest/css/article_new.css", "https://beaconcdn.qq.com/sdk/3.1.50/beacon_web.min.js", "https://watchspot.cdn-go.cn/article-new/latest/css/article_related_card_new.css", "https://watchspot.cdn-go.cn/article-new/latest/css/article_recommend_new.css" });
  private static final ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianRepoWebarticleRIJWebResourceUtil = new RIJWebResourceUtil();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(OfflineEnvHelper.a("3948"));
    localStringBuilder.append("3948");
    return localStringBuilder.toString();
  }
  
  /* Error */
  private final void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 118	java/lang/CharSequence
    //   4: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +12 -> 19
    //   10: ldc 126
    //   12: iconst_1
    //   13: ldc 128
    //   15: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: return
    //   19: aconst_null
    //   20: checkcast 136	java/io/InputStream
    //   23: astore_3
    //   24: new 138	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 4
    //   34: aload_3
    //   35: astore_2
    //   36: aload 4
    //   38: invokevirtual 144	java/io/File:exists	()Z
    //   41: ifne +47 -> 88
    //   44: aload_3
    //   45: astore_2
    //   46: new 85	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   53: astore 4
    //   55: aload_3
    //   56: astore_2
    //   57: aload 4
    //   59: ldc 146
    //   61: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: astore_2
    //   67: aload 4
    //   69: aload_1
    //   70: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_3
    //   75: astore_2
    //   76: ldc 126
    //   78: iconst_1
    //   79: aload 4
    //   81: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: return
    //   88: aload_3
    //   89: astore_2
    //   90: new 148	java/io/FileInputStream
    //   93: dup
    //   94: aload 4
    //   96: invokespecial 151	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   99: checkcast 136	java/io/InputStream
    //   102: astore 4
    //   104: aload 4
    //   106: invokevirtual 155	java/io/InputStream:available	()I
    //   109: newarray byte
    //   111: astore_2
    //   112: aload 4
    //   114: aload_2
    //   115: invokevirtual 159	java/io/InputStream:read	([B)I
    //   118: pop
    //   119: getstatic 60	com/tencent/mobileqq/kandian/repo/webarticle/RIJWebResourceUtil:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   122: checkcast 161	java/util/Map
    //   125: aload_1
    //   126: new 62	java/lang/String
    //   129: dup
    //   130: aload_2
    //   131: getstatic 167	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   134: invokespecial 170	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   137: invokeinterface 174 3 0
    //   142: pop
    //   143: new 85	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   150: astore_2
    //   151: aload_2
    //   152: ldc 176
    //   154: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_2
    //   159: aload_1
    //   160: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 126
    //   166: iconst_1
    //   167: aload_2
    //   168: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload 4
    //   176: invokevirtual 179	java/io/InputStream:close	()V
    //   179: return
    //   180: astore_2
    //   181: new 85	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   188: astore_1
    //   189: aload_1
    //   190: ldc 181
    //   192: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_1
    //   197: aload_2
    //   198: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: ldc 126
    //   204: iconst_1
    //   205: aload_1
    //   206: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: return
    //   213: astore_1
    //   214: aload 4
    //   216: astore_2
    //   217: goto +152 -> 369
    //   220: astore_1
    //   221: aload 4
    //   223: astore_3
    //   224: goto +15 -> 239
    //   227: astore_1
    //   228: aload 4
    //   230: astore_3
    //   231: goto +73 -> 304
    //   234: astore_1
    //   235: goto +134 -> 369
    //   238: astore_1
    //   239: aload_3
    //   240: astore_2
    //   241: new 85	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   248: astore 4
    //   250: aload_3
    //   251: astore_2
    //   252: aload 4
    //   254: ldc 186
    //   256: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_3
    //   261: astore_2
    //   262: aload 4
    //   264: aload_1
    //   265: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_3
    //   270: astore_2
    //   271: ldc 126
    //   273: iconst_1
    //   274: aload 4
    //   276: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_3
    //   283: ifnull +85 -> 368
    //   286: aload_3
    //   287: invokevirtual 179	java/io/InputStream:close	()V
    //   290: return
    //   291: astore_2
    //   292: new 85	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   299: astore_1
    //   300: goto -111 -> 189
    //   303: astore_1
    //   304: aload_3
    //   305: astore_2
    //   306: new 85	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   313: astore 4
    //   315: aload_3
    //   316: astore_2
    //   317: aload 4
    //   319: ldc 181
    //   321: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_3
    //   326: astore_2
    //   327: aload 4
    //   329: aload_1
    //   330: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_3
    //   335: astore_2
    //   336: ldc 126
    //   338: iconst_1
    //   339: aload 4
    //   341: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload_3
    //   348: ifnull +20 -> 368
    //   351: aload_3
    //   352: invokevirtual 179	java/io/InputStream:close	()V
    //   355: return
    //   356: astore_2
    //   357: new 85	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   364: astore_1
    //   365: goto -176 -> 189
    //   368: return
    //   369: aload_2
    //   370: ifnull +42 -> 412
    //   373: aload_2
    //   374: invokevirtual 179	java/io/InputStream:close	()V
    //   377: goto +35 -> 412
    //   380: astore_2
    //   381: new 85	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   388: astore_3
    //   389: aload_3
    //   390: ldc 181
    //   392: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_3
    //   397: aload_2
    //   398: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: ldc 126
    //   404: iconst_1
    //   405: aload_3
    //   406: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: goto +5 -> 417
    //   415: aload_1
    //   416: athrow
    //   417: goto -2 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	this	RIJWebResourceUtil
    //   0	420	1	paramString	String
    //   35	133	2	localObject1	Object
    //   180	18	2	localIOException1	java.io.IOException
    //   216	55	2	localObject2	Object
    //   291	1	2	localIOException2	java.io.IOException
    //   305	31	2	localObject3	Object
    //   356	18	2	localIOException3	java.io.IOException
    //   380	18	2	localIOException4	java.io.IOException
    //   23	383	3	localObject4	Object
    //   32	308	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   174	179	180	java/io/IOException
    //   104	174	213	finally
    //   104	174	220	java/lang/Throwable
    //   104	174	227	java/io/IOException
    //   36	44	234	finally
    //   46	55	234	finally
    //   57	65	234	finally
    //   67	74	234	finally
    //   76	87	234	finally
    //   90	104	234	finally
    //   241	250	234	finally
    //   252	260	234	finally
    //   262	269	234	finally
    //   271	282	234	finally
    //   306	315	234	finally
    //   317	325	234	finally
    //   327	334	234	finally
    //   336	347	234	finally
    //   36	44	238	java/lang/Throwable
    //   46	55	238	java/lang/Throwable
    //   57	65	238	java/lang/Throwable
    //   67	74	238	java/lang/Throwable
    //   76	87	238	java/lang/Throwable
    //   90	104	238	java/lang/Throwable
    //   286	290	291	java/io/IOException
    //   36	44	303	java/io/IOException
    //   46	55	303	java/io/IOException
    //   57	65	303	java/io/IOException
    //   67	74	303	java/io/IOException
    //   76	87	303	java/io/IOException
    //   90	104	303	java/io/IOException
    //   351	355	356	java/io/IOException
    //   373	377	380	java/io/IOException
  }
  
  private final boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilArrayList.contains(paramString);
  }
  
  private final String b(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)))
    {
      a(paramString);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getFileContent] hit cache, filePath = ");
      localStringBuilder.append(paramString);
      QLog.i("RIJWebResourceUtil", 1, localStringBuilder.toString());
    }
    return (String)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  @Nullable
  public final WebResourceResponse a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    boolean bool = RIJWebArticleUtil.a.f();
    Object localObject1 = null;
    if (!bool) {
      return null;
    }
    if (a(paramString))
    {
      Object localObject2 = (CharSequence)paramString;
      String str = paramString.substring(StringsKt.lastIndexOf$default((CharSequence)localObject2, '/', 0, false, 6, null) + 1, paramString.length());
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = paramString.substring(StringsKt.lastIndexOf$default((CharSequence)localObject2, ".", 0, false, 6, null) + 1, paramString.length());
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if ((StringsKt.equals(paramString, "css", true)) || (StringsKt.equals(paramString, "js", true)))
      {
        if (StringsKt.equals(paramString, "css", true)) {
          paramString = "text/css";
        } else {
          paramString = "text/javascript";
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a());
        ((StringBuilder)localObject2).append('/');
        ((StringBuilder)localObject2).append(str);
        str = b(((StringBuilder)localObject2).toString());
        if (!TextUtils.isEmpty((CharSequence)str))
        {
          if (str != null)
          {
            localObject1 = Charsets.UTF_8;
            if (str != null)
            {
              localObject1 = str.getBytes((Charset)localObject1);
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
          }
          return new WebResourceResponse(paramString, "utf-8", (InputStream)new BufferedInputStream((InputStream)new ByteArrayInputStream((byte[])localObject1)));
        }
      }
    }
    return null;
  }
  
  @Nullable
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (a(paramString))
    {
      paramString = paramString.substring(StringsKt.lastIndexOf$default((CharSequence)paramString, '/', 0, false, 6, null) + 1, paramString.length());
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append('/');
      localStringBuilder.append(paramString);
      paramString = b(localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)paramString)) {
        return paramString;
      }
    }
    return "";
  }
  
  public final void a()
  {
    ThreadManager.excute((Runnable)RIJWebResourceUtil.updateResourceOfflinePkg.runnable.1.a, 128, null, true);
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[preloadResource] do not preload, forceLoad = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", size = ");
      localStringBuilder.append(jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      QLog.i("RIJWebResourceUtil", 1, localStringBuilder.toString());
      return;
    }
    ThreadManager.excute((Runnable)RIJWebResourceUtil.preloadResource.runnable.1.a, 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJWebResourceUtil
 * JD-Core Version:    0.7.0.1
 */