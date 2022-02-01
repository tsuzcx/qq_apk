package com.tencent.qqprotect.qsec;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.util.Pair;
import java.io.File;
import org.xmlpull.v1.XmlPullParser;

final class CloudAVEngineImpl$AVEngineCache$CacheFileReader
{
  private CloudAVEngineImpl.AVEngineCache.CacheFileVisitor a;
  private File b;
  
  public CloudAVEngineImpl$AVEngineCache$CacheFileReader(File paramFile, CloudAVEngineImpl.AVEngineCache.CacheFileVisitor paramCacheFileVisitor)
  {
    this.b = paramFile;
    this.a = paramCacheFileVisitor;
  }
  
  private Pair<String, ICloudAVEngine.ResultBundle> a(XmlPullParser paramXmlPullParser)
  {
    try
    {
      String str = paramXmlPullParser.getAttributeValue(null, "Key");
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      ICloudAVEngine.ResultBundle localResultBundle = new ICloudAVEngine.ResultBundle();
      localResultBundle.a = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "AttrType"));
      localResultBundle.b = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "Category"));
      localResultBundle.c = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "SubCategory"));
      localResultBundle.e = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "Action"));
      localResultBundle.d = Long.parseLong(paramXmlPullParser.getAttributeValue(null, "ExpireTime"));
      paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "ExtraInfo");
      if (!TextUtils.isEmpty(paramXmlPullParser)) {
        localResultBundle.g = Base64.decode(paramXmlPullParser, 0);
      }
      paramXmlPullParser = new Pair(str, localResultBundle);
      return paramXmlPullParser;
    }
    catch (Exception paramXmlPullParser)
    {
      paramXmlPullParser.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: new 101	javax/crypto/spec/IvParameterSpec
    //   3: dup
    //   4: invokestatic 106	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache:b	()[B
    //   7: invokespecial 109	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   10: astore 4
    //   12: new 111	javax/crypto/spec/SecretKeySpec
    //   15: dup
    //   16: invokestatic 113	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache:c	()[B
    //   19: ldc 115
    //   21: invokespecial 118	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   24: astore 5
    //   26: ldc 120
    //   28: invokestatic 126	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   31: astore 6
    //   33: aload 6
    //   35: iconst_2
    //   36: aload 5
    //   38: aload 4
    //   40: invokevirtual 130	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   43: new 132	javax/crypto/CipherInputStream
    //   46: dup
    //   47: new 134	java/io/BufferedInputStream
    //   50: dup
    //   51: new 136	java/io/FileInputStream
    //   54: dup
    //   55: aload_0
    //   56: getfield 15	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileReader:b	Ljava/io/File;
    //   59: invokespecial 139	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 142	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: aload 6
    //   67: invokespecial 145	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   70: astore 6
    //   72: aload 6
    //   74: astore 4
    //   76: invokestatic 151	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   79: astore 8
    //   81: aload 6
    //   83: astore 4
    //   85: aload 8
    //   87: aload 6
    //   89: ldc 153
    //   91: invokeinterface 157 3 0
    //   96: aload 6
    //   98: astore 4
    //   100: aload 8
    //   102: invokeinterface 161 1 0
    //   107: istore_3
    //   108: iconst_0
    //   109: istore_1
    //   110: aconst_null
    //   111: astore 7
    //   113: iload_3
    //   114: iconst_1
    //   115: if_icmpeq +218 -> 333
    //   118: iload_3
    //   119: iconst_2
    //   120: if_icmpne +101 -> 221
    //   123: aload 6
    //   125: astore 4
    //   127: aload 8
    //   129: invokeinterface 165 1 0
    //   134: astore 9
    //   136: aload 6
    //   138: astore 4
    //   140: aload 9
    //   142: ldc 167
    //   144: invokevirtual 173	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   147: ifeq +27 -> 174
    //   150: aload 6
    //   152: astore 4
    //   154: aload 8
    //   156: aconst_null
    //   157: ldc 175
    //   159: invokeinterface 29 3 0
    //   164: invokestatic 46	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   167: iconst_1
    //   168: if_icmpeq +317 -> 485
    //   171: goto +162 -> 333
    //   174: iload_1
    //   175: istore_2
    //   176: aload 7
    //   178: astore 5
    //   180: iload_1
    //   181: ifeq +131 -> 312
    //   184: iload_1
    //   185: istore_2
    //   186: aload 7
    //   188: astore 5
    //   190: aload 6
    //   192: astore 4
    //   194: aload 9
    //   196: ldc 177
    //   198: invokevirtual 173	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   201: ifeq +111 -> 312
    //   204: aload 6
    //   206: astore 4
    //   208: aload_0
    //   209: aload 8
    //   211: invokespecial 179	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileReader:a	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/tencent/util/Pair;
    //   214: astore 5
    //   216: iload_1
    //   217: istore_2
    //   218: goto +94 -> 312
    //   221: iload_1
    //   222: istore_2
    //   223: aload 7
    //   225: astore 5
    //   227: iload_3
    //   228: iconst_3
    //   229: if_icmpne +83 -> 312
    //   232: iload_1
    //   233: istore_2
    //   234: aload 7
    //   236: astore 5
    //   238: aload 6
    //   240: astore 4
    //   242: ldc 177
    //   244: aload 8
    //   246: invokeinterface 165 1 0
    //   251: invokevirtual 173	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   254: ifeq +58 -> 312
    //   257: iload_1
    //   258: istore_2
    //   259: aload 7
    //   261: astore 5
    //   263: aload 7
    //   265: ifnull +47 -> 312
    //   268: aload 6
    //   270: astore 4
    //   272: aload_0
    //   273: getfield 17	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileReader:a	Lcom/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileVisitor;
    //   276: ifnull +218 -> 494
    //   279: aload 6
    //   281: astore 4
    //   283: aload_0
    //   284: getfield 17	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileReader:a	Lcom/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileVisitor;
    //   287: aload 7
    //   289: getfield 183	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   292: checkcast 169	java/lang/String
    //   295: aload 7
    //   297: getfield 186	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   300: checkcast 37	com/tencent/qqprotect/qsec/ICloudAVEngine$ResultBundle
    //   303: invokevirtual 191	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileVisitor:a	(Ljava/lang/String;Lcom/tencent/qqprotect/qsec/ICloudAVEngine$ResultBundle;)Z
    //   306: ifne +188 -> 494
    //   309: goto +24 -> 333
    //   312: aload 6
    //   314: astore 4
    //   316: aload 8
    //   318: invokeinterface 194 1 0
    //   323: istore_3
    //   324: iload_2
    //   325: istore_1
    //   326: aload 5
    //   328: astore 7
    //   330: goto -217 -> 113
    //   333: aload 6
    //   335: invokevirtual 199	java/io/InputStream:close	()V
    //   338: goto +10 -> 348
    //   341: astore 4
    //   343: aload 4
    //   345: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   348: aload_0
    //   349: getfield 17	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileReader:a	Lcom/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileVisitor;
    //   352: astore 4
    //   354: aload 4
    //   356: ifnull +73 -> 429
    //   359: goto +65 -> 424
    //   362: astore 7
    //   364: aload 6
    //   366: astore 5
    //   368: goto +16 -> 384
    //   371: astore 4
    //   373: aconst_null
    //   374: astore 5
    //   376: goto +64 -> 440
    //   379: astore 7
    //   381: aconst_null
    //   382: astore 5
    //   384: aload 5
    //   386: astore 4
    //   388: aload 7
    //   390: invokevirtual 95	java/lang/Exception:printStackTrace	()V
    //   393: aload 5
    //   395: ifnull +18 -> 413
    //   398: aload 5
    //   400: invokevirtual 199	java/io/InputStream:close	()V
    //   403: goto +10 -> 413
    //   406: astore 4
    //   408: aload 4
    //   410: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   413: aload_0
    //   414: getfield 17	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileReader:a	Lcom/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileVisitor;
    //   417: astore 4
    //   419: aload 4
    //   421: ifnull +8 -> 429
    //   424: aload 4
    //   426: invokevirtual 202	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileVisitor:a	()V
    //   429: return
    //   430: astore 6
    //   432: aload 4
    //   434: astore 5
    //   436: aload 6
    //   438: astore 4
    //   440: aload 5
    //   442: ifnull +18 -> 460
    //   445: aload 5
    //   447: invokevirtual 199	java/io/InputStream:close	()V
    //   450: goto +10 -> 460
    //   453: astore 5
    //   455: aload 5
    //   457: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   460: aload_0
    //   461: getfield 17	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileReader:a	Lcom/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileVisitor;
    //   464: astore 5
    //   466: aload 5
    //   468: ifnull +8 -> 476
    //   471: aload 5
    //   473: invokevirtual 202	com/tencent/qqprotect/qsec/CloudAVEngineImpl$AVEngineCache$CacheFileVisitor:a	()V
    //   476: goto +6 -> 482
    //   479: aload 4
    //   481: athrow
    //   482: goto -3 -> 479
    //   485: iconst_1
    //   486: istore_2
    //   487: aload 7
    //   489: astore 5
    //   491: goto -179 -> 312
    //   494: aconst_null
    //   495: astore 5
    //   497: iload_1
    //   498: istore_2
    //   499: goto -187 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	502	0	this	CacheFileReader
    //   109	389	1	i	int
    //   175	324	2	j	int
    //   107	217	3	k	int
    //   10	305	4	localObject1	Object
    //   341	3	4	localIOException1	java.io.IOException
    //   352	3	4	localCacheFileVisitor	CloudAVEngineImpl.AVEngineCache.CacheFileVisitor
    //   371	1	4	localObject2	Object
    //   386	1	4	localObject3	Object
    //   406	3	4	localIOException2	java.io.IOException
    //   417	63	4	localObject4	Object
    //   24	422	5	localObject5	Object
    //   453	3	5	localIOException3	java.io.IOException
    //   464	32	5	localObject6	Object
    //   31	334	6	localObject7	Object
    //   430	7	6	localObject8	Object
    //   111	218	7	localObject9	Object
    //   362	1	7	localException1	Exception
    //   379	109	7	localException2	Exception
    //   79	238	8	localXmlPullParser	XmlPullParser
    //   134	61	9	str	String
    // Exception table:
    //   from	to	target	type
    //   333	338	341	java/io/IOException
    //   76	81	362	java/lang/Exception
    //   85	96	362	java/lang/Exception
    //   100	108	362	java/lang/Exception
    //   127	136	362	java/lang/Exception
    //   140	150	362	java/lang/Exception
    //   154	171	362	java/lang/Exception
    //   194	204	362	java/lang/Exception
    //   208	216	362	java/lang/Exception
    //   242	257	362	java/lang/Exception
    //   272	279	362	java/lang/Exception
    //   283	309	362	java/lang/Exception
    //   316	324	362	java/lang/Exception
    //   0	72	371	finally
    //   0	72	379	java/lang/Exception
    //   398	403	406	java/io/IOException
    //   76	81	430	finally
    //   85	96	430	finally
    //   100	108	430	finally
    //   127	136	430	finally
    //   140	150	430	finally
    //   154	171	430	finally
    //   194	204	430	finally
    //   208	216	430	finally
    //   242	257	430	finally
    //   272	279	430	finally
    //   283	309	430	finally
    //   316	324	430	finally
    //   388	393	430	finally
    //   445	450	453	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.AVEngineCache.CacheFileReader
 * JD-Core Version:    0.7.0.1
 */