package com.tencent.mobileqq.config.struct;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class NearbyBannerManager
  implements Manager
{
  private QQAppInterface a;
  
  public NearbyBannerManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.getApp().getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append("NearbyBannerPic");
      localObject = new File(((StringBuilder)localObject).toString());
      int i;
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = Arrays.asList(((File)localObject).listFiles());
        int j = ((List)localObject).size();
        i = 10;
        if (j > 10) {
          Collections.sort((List)localObject, new NearbyBannerManager.1(this));
        }
      }
      else
      {
        while (i < ((List)localObject).size())
        {
          a((File)((List)localObject).get(i));
          i += 1;
          continue;
          if (((File)localObject).isFile()) {
            a((File)localObject);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(File paramFile)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!paramFile.exists()) {
          break label73;
        }
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        if (!paramFile.isDirectory()) {
          break label73;
        }
        paramFile = paramFile.listFiles();
        if (paramFile != null) {
          break label74;
        }
        return;
      }
      catch (Exception paramFile)
      {
        if (!QLog.isColorLevel()) {
          break label73;
        }
        QLog.d("NearbyBannerManager", 2, "", paramFile);
      }
      if (i < paramFile.length)
      {
        a(paramFile[i]);
        i += 1;
      }
      else
      {
        label73:
        return;
        label74:
        i = 0;
      }
    }
  }
  
  public int a()
  {
    return ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a.getCurrentAccountUin(), "key_config_ver", Integer.valueOf(0))).intValue();
  }
  
  public Set<String> a()
  {
    return new HashSet(Arrays.asList(((String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a.getCurrentAccountUin(), "key_expired_banner", "")).split("\\|")));
  }
  
  public void a(int paramInt)
  {
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.getCurrentAccountUin(), "key_config_ver", Integer.valueOf(paramInt));
  }
  
  /* Error */
  public void a(PicAndAdConf paramPicAndAdConf, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 107
    //   8: iconst_2
    //   9: ldc 165
    //   11: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 20	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: aload_0
    //   26: getfield 15	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: invokevirtual 27	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   32: invokevirtual 33	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   35: invokevirtual 39	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 4
    //   44: ldc 45
    //   46: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: aload_0
    //   53: getfield 15	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   56: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   59: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 4
    //   65: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 4
    //   70: new 20	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   77: astore 5
    //   79: aload 5
    //   81: aload 4
    //   83: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 5
    //   89: ldc 45
    //   91: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 5
    //   97: ldc 170
    //   99: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new 35	java/io/File
    //   106: dup
    //   107: aload 5
    //   109: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: astore 8
    //   117: aload_0
    //   118: aload 8
    //   120: invokespecial 94	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(Ljava/io/File;)V
    //   123: aload_0
    //   124: invokespecial 172	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	()V
    //   127: new 35	java/io/File
    //   130: dup
    //   131: aload 4
    //   133: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 4
    //   138: aload 4
    //   140: invokevirtual 57	java/io/File:exists	()Z
    //   143: ifne +9 -> 152
    //   146: aload 4
    //   148: invokevirtual 175	java/io/File:mkdirs	()Z
    //   151: pop
    //   152: aload 8
    //   154: invokevirtual 178	java/io/File:createNewFile	()Z
    //   157: pop
    //   158: goto +21 -> 179
    //   161: astore 4
    //   163: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +13 -> 179
    //   169: ldc 107
    //   171: iconst_2
    //   172: ldc 109
    //   174: aload 4
    //   176: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: aload 8
    //   181: invokevirtual 57	java/io/File:exists	()Z
    //   184: ifeq +272 -> 456
    //   187: aconst_null
    //   188: astore 7
    //   190: aconst_null
    //   191: astore 6
    //   193: iconst_0
    //   194: istore_3
    //   195: new 180	java/io/BufferedOutputStream
    //   198: dup
    //   199: new 182	java/io/FileOutputStream
    //   202: dup
    //   203: aload 8
    //   205: invokespecial 184	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   208: invokespecial 187	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   211: astore 4
    //   213: new 189	java/io/DataOutputStream
    //   216: dup
    //   217: aload 4
    //   219: invokespecial 190	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   222: astore 5
    //   224: aload_1
    //   225: aload 5
    //   227: invokevirtual 195	com/tencent/mobileqq/config/struct/PicAndAdConf:a	(Ljava/io/DataOutputStream;)V
    //   230: aload 4
    //   232: invokevirtual 198	java/io/BufferedOutputStream:close	()V
    //   235: aload 5
    //   237: invokevirtual 199	java/io/DataOutputStream:close	()V
    //   240: aload_1
    //   241: invokevirtual 201	com/tencent/mobileqq/config/struct/PicAndAdConf:d	()V
    //   244: aload_0
    //   245: iload_2
    //   246: invokevirtual 203	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(I)V
    //   249: invokestatic 206	com/tencent/mobileqq/nearby/NearbyProxyUtils:a	()V
    //   252: iload_3
    //   253: istore_2
    //   254: goto +105 -> 359
    //   257: astore 6
    //   259: goto +13 -> 272
    //   262: astore 6
    //   264: goto +46 -> 310
    //   267: astore 6
    //   269: aconst_null
    //   270: astore 5
    //   272: goto +24 -> 296
    //   275: astore 6
    //   277: aconst_null
    //   278: astore 5
    //   280: goto +30 -> 310
    //   283: astore 7
    //   285: aconst_null
    //   286: astore 5
    //   288: aload 6
    //   290: astore 4
    //   292: aload 7
    //   294: astore 6
    //   296: iconst_0
    //   297: istore_3
    //   298: goto +105 -> 403
    //   301: astore 6
    //   303: aconst_null
    //   304: astore 5
    //   306: aload 7
    //   308: astore 4
    //   310: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +13 -> 326
    //   316: ldc 107
    //   318: iconst_2
    //   319: ldc 208
    //   321: aload 6
    //   323: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   326: aload 4
    //   328: ifnull +8 -> 336
    //   331: aload 4
    //   333: invokevirtual 198	java/io/BufferedOutputStream:close	()V
    //   336: aload 5
    //   338: ifnull +8 -> 346
    //   341: aload 5
    //   343: invokevirtual 199	java/io/DataOutputStream:close	()V
    //   346: aload_0
    //   347: aload 8
    //   349: invokespecial 94	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(Ljava/io/File;)V
    //   352: aload_0
    //   353: iconst_0
    //   354: invokevirtual 203	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(I)V
    //   357: iconst_1
    //   358: istore_2
    //   359: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +108 -> 470
    //   365: new 20	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   372: astore_1
    //   373: aload_1
    //   374: ldc 210
    //   376: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_1
    //   381: iload_2
    //   382: iconst_1
    //   383: ixor
    //   384: invokevirtual 213	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: ldc 107
    //   390: iconst_2
    //   391: aload_1
    //   392: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: return
    //   399: astore 6
    //   401: iconst_1
    //   402: istore_3
    //   403: aload 4
    //   405: ifnull +8 -> 413
    //   408: aload 4
    //   410: invokevirtual 198	java/io/BufferedOutputStream:close	()V
    //   413: aload 5
    //   415: ifnull +8 -> 423
    //   418: aload 5
    //   420: invokevirtual 199	java/io/DataOutputStream:close	()V
    //   423: iload_3
    //   424: ifeq +17 -> 441
    //   427: aload_0
    //   428: aload 8
    //   430: invokespecial 94	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(Ljava/io/File;)V
    //   433: aload_0
    //   434: iconst_0
    //   435: invokevirtual 203	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(I)V
    //   438: goto +15 -> 453
    //   441: aload_1
    //   442: invokevirtual 201	com/tencent/mobileqq/config/struct/PicAndAdConf:d	()V
    //   445: aload_0
    //   446: iload_2
    //   447: invokevirtual 203	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(I)V
    //   450: invokestatic 206	com/tencent/mobileqq/nearby/NearbyProxyUtils:a	()V
    //   453: aload 6
    //   455: athrow
    //   456: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +11 -> 470
    //   462: ldc 107
    //   464: iconst_2
    //   465: ldc 215
    //   467: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: return
    //   471: astore 4
    //   473: goto -238 -> 235
    //   476: astore 4
    //   478: goto -238 -> 240
    //   481: astore_1
    //   482: goto -146 -> 336
    //   485: astore_1
    //   486: goto -140 -> 346
    //   489: astore 4
    //   491: goto -78 -> 413
    //   494: astore 4
    //   496: goto -73 -> 423
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	this	NearbyBannerManager
    //   0	499	1	paramPicAndAdConf	PicAndAdConf
    //   0	499	2	paramInt	int
    //   194	230	3	i	int
    //   21	126	4	localObject1	Object
    //   161	14	4	localException1	Exception
    //   211	198	4	localObject2	Object
    //   471	1	4	localException2	Exception
    //   476	1	4	localException3	Exception
    //   489	1	4	localException4	Exception
    //   494	1	4	localException5	Exception
    //   77	342	5	localObject3	Object
    //   191	1	6	localObject4	Object
    //   257	1	6	localObject5	Object
    //   262	1	6	localException6	Exception
    //   267	1	6	localObject6	Object
    //   275	14	6	localException7	Exception
    //   294	1	6	localObject7	Object
    //   301	21	6	localException8	Exception
    //   399	55	6	localObject8	Object
    //   188	1	7	localObject9	Object
    //   283	24	7	localObject10	Object
    //   115	314	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   138	152	161	java/lang/Exception
    //   152	158	161	java/lang/Exception
    //   224	230	257	finally
    //   224	230	262	java/lang/Exception
    //   213	224	267	finally
    //   213	224	275	java/lang/Exception
    //   195	213	283	finally
    //   195	213	301	java/lang/Exception
    //   310	326	399	finally
    //   230	235	471	java/lang/Exception
    //   235	240	476	java/lang/Exception
    //   331	336	481	java/lang/Exception
    //   341	346	485	java/lang/Exception
    //   408	413	489	java/lang/Exception
    //   418	423	494	java/lang/Exception
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.NearbyBannerManager
 * JD-Core Version:    0.7.0.1
 */