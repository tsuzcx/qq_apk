package com.tencent.mobileqq.kandian.repo.webarticle;

import android.text.TextUtils;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.Compiler;
import com.samskivert.mustache.Template;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/RIJWebTemplateFactory;", "", "()V", "TAG", "", "TPL_BASE_URL", "TPL_DIR", "TPL_NAME_INDEX", "fileMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "templateMap", "Lcom/samskivert/mustache/Template;", "createTemplate", "templateName", "getFileContent", "getFilePathFromTplName", "getTemplate", "loadFile", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebTemplateFactory
{
  public static final RIJWebTemplateFactory a;
  private static final HashMap<String, String> a;
  private static final HashMap<String, Template> b = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianRepoWebarticleRIJWebTemplateFactory = new RIJWebTemplateFactory();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  /* Error */
  private final void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: checkcast 58	java/io/InputStream
    //   4: astore 4
    //   6: getstatic 64	com/tencent/common/app/BaseApplicationImpl:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: astore 5
    //   11: aload 5
    //   13: ifnull +312 -> 325
    //   16: aload 4
    //   18: astore_2
    //   19: aload 4
    //   21: astore_3
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 67	com/tencent/mobileqq/kandian/repo/webarticle/RIJWebTemplateFactory:b	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 6
    //   29: aload 4
    //   31: astore_2
    //   32: aload 4
    //   34: astore_3
    //   35: aload 5
    //   37: invokevirtual 73	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   40: aload 6
    //   42: invokevirtual 79	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore 4
    //   47: aload 4
    //   49: astore_2
    //   50: aload 4
    //   52: astore_3
    //   53: aload 4
    //   55: invokevirtual 83	java/io/InputStream:available	()I
    //   58: newarray byte
    //   60: astore 5
    //   62: aload 4
    //   64: astore_2
    //   65: aload 4
    //   67: astore_3
    //   68: aload 4
    //   70: aload 5
    //   72: invokevirtual 87	java/io/InputStream:read	([B)I
    //   75: pop
    //   76: aload 4
    //   78: astore_2
    //   79: aload 4
    //   81: astore_3
    //   82: getstatic 49	com/tencent/mobileqq/kandian/repo/webarticle/RIJWebTemplateFactory:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   85: checkcast 89	java/util/Map
    //   88: aload_1
    //   89: new 91	java/lang/String
    //   92: dup
    //   93: aload 5
    //   95: getstatic 97	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   98: invokespecial 100	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   101: invokeinterface 104 3 0
    //   106: pop
    //   107: aload 4
    //   109: astore_2
    //   110: aload 4
    //   112: astore_3
    //   113: new 106	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   120: astore 5
    //   122: aload 4
    //   124: astore_2
    //   125: aload 4
    //   127: astore_3
    //   128: aload 5
    //   130: ldc 109
    //   132: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 4
    //   138: astore_2
    //   139: aload 4
    //   141: astore_3
    //   142: aload 5
    //   144: aload_1
    //   145: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 4
    //   151: astore_2
    //   152: aload 4
    //   154: astore_3
    //   155: ldc 115
    //   157: iconst_1
    //   158: aload 5
    //   160: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload 4
    //   168: ifnull +111 -> 279
    //   171: aload 4
    //   173: invokevirtual 128	java/io/InputStream:close	()V
    //   176: return
    //   177: astore_2
    //   178: new 106	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   185: astore_1
    //   186: aload_1
    //   187: ldc 130
    //   189: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: aload_2
    //   195: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: ldc 115
    //   201: iconst_1
    //   202: aload_1
    //   203: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: return
    //   210: astore_1
    //   211: goto +69 -> 280
    //   214: astore_1
    //   215: aload_3
    //   216: astore_2
    //   217: new 106	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   224: astore 4
    //   226: aload_3
    //   227: astore_2
    //   228: aload 4
    //   230: ldc 130
    //   232: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_3
    //   237: astore_2
    //   238: aload 4
    //   240: aload_1
    //   241: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_3
    //   246: astore_2
    //   247: ldc 115
    //   249: iconst_1
    //   250: aload 4
    //   252: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: aload_3
    //   259: ifnull +20 -> 279
    //   262: aload_3
    //   263: invokevirtual 128	java/io/InputStream:close	()V
    //   266: return
    //   267: astore_2
    //   268: new 106	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   275: astore_1
    //   276: goto -90 -> 186
    //   279: return
    //   280: aload_2
    //   281: ifnull +42 -> 323
    //   284: aload_2
    //   285: invokevirtual 128	java/io/InputStream:close	()V
    //   288: goto +35 -> 323
    //   291: astore_2
    //   292: new 106	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   299: astore_3
    //   300: aload_3
    //   301: ldc 130
    //   303: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_3
    //   308: aload_2
    //   309: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 115
    //   315: iconst_1
    //   316: aload_3
    //   317: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_1
    //   324: athrow
    //   325: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	RIJWebTemplateFactory
    //   0	326	1	paramString	String
    //   18	134	2	localObject1	Object
    //   177	18	2	localIOException1	java.io.IOException
    //   216	31	2	localObject2	Object
    //   267	18	2	localIOException2	java.io.IOException
    //   291	18	2	localIOException3	java.io.IOException
    //   21	296	3	localObject3	Object
    //   4	247	4	localObject4	Object
    //   9	150	5	localObject5	Object
    //   27	14	6	str	String
    // Exception table:
    //   from	to	target	type
    //   171	176	177	java/io/IOException
    //   22	29	210	finally
    //   35	47	210	finally
    //   53	62	210	finally
    //   68	76	210	finally
    //   82	107	210	finally
    //   113	122	210	finally
    //   128	136	210	finally
    //   142	149	210	finally
    //   155	166	210	finally
    //   217	226	210	finally
    //   228	236	210	finally
    //   238	245	210	finally
    //   247	258	210	finally
    //   22	29	214	java/io/IOException
    //   35	47	214	java/io/IOException
    //   53	62	214	java/io/IOException
    //   68	76	214	java/io/IOException
    //   82	107	214	java/io/IOException
    //   113	122	214	java/io/IOException
    //   128	136	214	java/io/IOException
    //   142	149	214	java/io/IOException
    //   155	166	214	java/io/IOException
    //   262	266	267	java/io/IOException
    //   284	288	291	java/io/IOException
  }
  
  private final Template b(String paramString)
  {
    try
    {
      localObject = a(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = Mustache.compiler().escapeHTML(false).defaultValue("").compile((String)localObject);
        Map localMap = (Map)b;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "template");
        localMap.put(paramString, localObject);
        return localObject;
      }
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[createTemplate] t = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("RIJWebTemplateFactory", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private final String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rij_web/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".tpl");
    return localStringBuilder.toString();
  }
  
  @Nullable
  public final Template a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "templateName");
    Object localObject2 = (Template)b.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = b(paramString);
    }
    if (localObject1 == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getTemplate] template is null, templateName = ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.e("RIJWebTemplateFactory", 1, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  @Nullable
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "templateName");
    if (TextUtils.isEmpty((CharSequence)jdField_a_of_type_JavaUtilHashMap.get(paramString)))
    {
      a(paramString);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getFileContent] hit cache, filePath = ");
      localStringBuilder.append(paramString);
      QLog.i("RIJWebTemplateFactory", 1, localStringBuilder.toString());
    }
    return (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJWebTemplateFactory
 * JD-Core Version:    0.7.0.1
 */