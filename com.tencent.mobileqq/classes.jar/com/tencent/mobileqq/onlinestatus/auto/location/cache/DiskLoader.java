package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import mqq.app.MobileQQ;

class DiskLoader
  extends Loader
{
  private static File c;
  private final int d;
  
  DiskLoader(String paramString, int paramInt)
  {
    super(paramString);
    Loader.a = "DiskLoader";
    this.d = paramInt;
    c = new File(MobileQQ.sMobileQQ.getCacheDir(), "/poi/");
    c.mkdirs();
  }
  
  private void a(PoiBean paramPoiBean, File paramFile)
  {
    Gson localGson = new GsonBuilder().create();
    paramFile = new FileWriter(paramFile);
    localGson.toJson(paramPoiBean, paramFile);
    paramFile.flush();
    paramFile.close();
  }
  
  private void b()
  {
    int i = a();
    int j = this.d;
    if (i > j - 1)
    {
      int k = i - j + 1;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = Loader.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[status][poiLoader][");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append("] handlerCacheSizeLimit. curCacheSize: ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" mDiskCacheSizeLimit: ");
        ((StringBuilder)localObject2).append(this.d);
        ((StringBuilder)localObject2).append(" overFlowSize: ");
        ((StringBuilder)localObject2).append(k);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = null;
      i = 0;
      while (i < k)
      {
        File[] arrayOfFile = c.listFiles();
        int m = arrayOfFile.length;
        j = 0;
        Object localObject3;
        while (j < m)
        {
          localObject3 = arrayOfFile[j];
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((File)localObject3).lastModified() >= ((File)localObject1).lastModified()) {}
          }
          else
          {
            localObject2 = localObject3;
          }
          j += 1;
          localObject1 = localObject2;
        }
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = Loader.a;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[status][poiLoader][");
            ((StringBuilder)localObject3).append(this.b);
            ((StringBuilder)localObject3).append("] handlerCacheSizeLimit. delete: ");
            ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
            ((StringBuilder)localObject3).append(" lastModified: ");
            ((StringBuilder)localObject3).append(((File)localObject1).lastModified());
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          }
          ((File)localObject1).delete();
        }
        i += 1;
      }
    }
  }
  
  public int a()
  {
    String[] arrayOfString = c.list();
    if (arrayOfString == null) {
      return 0;
    }
    return arrayOfString.length;
  }
  
  PoiBean a(File paramFile)
  {
    return (PoiBean)new GsonBuilder().create().fromJson(new FileReader(paramFile), PoiBean.class);
  }
  
  public File a(LatLng paramLatLng)
  {
    File localFile = c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("poi-");
    localStringBuilder.append(paramLatLng.latitude);
    localStringBuilder.append("-");
    localStringBuilder.append(paramLatLng.longitude);
    return new File(localFile, localStringBuilder.toString());
  }
  
  public void a(LatLng paramLatLng, int paramInt, PoiBean paramPoiBean)
  {
    Object localObject1;
    Object localObject2;
    if (a(paramLatLng, paramInt, new DiskLoader.1(this, paramLatLng, paramInt, paramPoiBean)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = Loader.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[status][poiLoader][");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append("] diskPut [fail already exist]. latLng: ");
        ((StringBuilder)localObject2).append(paramLatLng);
        ((StringBuilder)localObject2).append(" acceptAccuracy: ");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" poiBean: ");
        ((StringBuilder)localObject2).append(paramPoiBean);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    b();
    try
    {
      a("diskPut", paramPoiBean);
      localObject1 = a(paramLatLng);
      ((File)localObject1).createNewFile();
      if (QLog.isColorLevel())
      {
        localObject2 = Loader.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][poiLoader][");
        localStringBuilder.append(this.b);
        localStringBuilder.append("] diskPut. latLng: ");
        localStringBuilder.append(paramLatLng);
        localStringBuilder.append(" cacheFile: ");
        localStringBuilder.append(((File)localObject1).getName());
        localStringBuilder.append(" poiBean: ");
        localStringBuilder.append(paramPoiBean);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      a(paramPoiBean, (File)localObject1);
      return;
    }
    catch (IOException paramLatLng)
    {
      if (QLog.isColorLevel())
      {
        paramPoiBean = Loader.a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[status][poiLoader][");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append("] PoiCache diskPut Error");
        QLog.e(paramPoiBean, 2, ((StringBuilder)localObject1).toString(), paramLatLng);
      }
    }
  }
  
  /* Error */
  public boolean a(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    // Byte code:
    //   0: getstatic 40	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:c	Ljava/io/File;
    //   3: invokevirtual 114	java/io/File:listFiles	()[Ljava/io/File;
    //   6: astore 11
    //   8: aload 11
    //   10: ifnull +448 -> 458
    //   13: aload 11
    //   15: arraylength
    //   16: ifne +6 -> 22
    //   19: goto +439 -> 458
    //   22: aload 11
    //   24: arraylength
    //   25: istore 4
    //   27: iconst_0
    //   28: istore 5
    //   30: iload 5
    //   32: iload 4
    //   34: if_icmpge +352 -> 386
    //   37: aload 11
    //   39: iload 5
    //   41: aaload
    //   42: astore 10
    //   44: aload_0
    //   45: aload_0
    //   46: aload 10
    //   48: invokevirtual 214	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:b	(Ljava/io/File;)Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;
    //   51: aload_1
    //   52: iload_2
    //   53: invokevirtual 217	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:a	(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;I)Z
    //   56: ifeq +321 -> 377
    //   59: aload_0
    //   60: aload 10
    //   62: invokevirtual 219	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:a	(Ljava/io/File;)Lcom/tencent/mobileqq/onlinestatus/auto/location/cache/PoiBean;
    //   65: astore 12
    //   67: aload_0
    //   68: ldc 221
    //   70: aload 12
    //   72: invokevirtual 189	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:a	(Ljava/lang/String;Lcom/tencent/mobileqq/onlinestatus/auto/location/cache/PoiBean;)V
    //   75: aload_3
    //   76: aload 12
    //   78: invokeinterface 226 2 0
    //   83: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +77 -> 163
    //   89: getstatic 19	com/tencent/mobileqq/onlinestatus/auto/location/cache/Loader:a	Ljava/lang/String;
    //   92: astore 13
    //   94: new 85	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   101: astore 14
    //   103: aload 14
    //   105: ldc 88
    //   107: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 14
    //   113: aload_0
    //   114: getfield 94	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:b	Ljava/lang/String;
    //   117: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 14
    //   123: ldc 228
    //   125: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 14
    //   131: aload_1
    //   132: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 14
    //   138: ldc 230
    //   140: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 14
    //   146: aload 12
    //   148: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 13
    //   154: iconst_2
    //   155: aload 14
    //   157: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload 10
    //   165: invokestatic 235	java/lang/System:currentTimeMillis	()J
    //   168: invokevirtual 239	java/io/File:setLastModified	(J)Z
    //   171: ifne +135 -> 306
    //   174: aload 10
    //   176: invokevirtual 118	java/io/File:lastModified	()J
    //   179: lstore 6
    //   181: aload_0
    //   182: aload 12
    //   184: aload 10
    //   186: invokespecial 203	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:a	(Lcom/tencent/mobileqq/onlinestatus/auto/location/cache/PoiBean;Ljava/io/File;)V
    //   189: aload 10
    //   191: invokevirtual 118	java/io/File:lastModified	()J
    //   194: lstore 8
    //   196: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +107 -> 306
    //   202: getstatic 19	com/tencent/mobileqq/onlinestatus/auto/location/cache/Loader:a	Ljava/lang/String;
    //   205: astore 12
    //   207: new 85	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   214: astore 13
    //   216: aload 13
    //   218: ldc 88
    //   220: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 13
    //   226: aload_0
    //   227: getfield 94	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:b	Ljava/lang/String;
    //   230: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 13
    //   236: ldc 241
    //   238: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 13
    //   244: aload 10
    //   246: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 13
    //   252: ldc 243
    //   254: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 13
    //   260: lload 6
    //   262: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 13
    //   268: ldc 245
    //   270: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 13
    //   276: lload 8
    //   278: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 12
    //   284: iconst_2
    //   285: aload 13
    //   287: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: goto +13 -> 306
    //   296: astore 10
    //   298: goto +17 -> 315
    //   301: astore 10
    //   303: goto +12 -> 315
    //   306: iconst_1
    //   307: ireturn
    //   308: astore 10
    //   310: goto +5 -> 315
    //   313: astore 10
    //   315: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +59 -> 377
    //   321: getstatic 19	com/tencent/mobileqq/onlinestatus/auto/location/cache/Loader:a	Ljava/lang/String;
    //   324: astore 12
    //   326: new 85	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   333: astore 13
    //   335: aload 13
    //   337: ldc 88
    //   339: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 13
    //   345: aload_0
    //   346: getfield 94	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:b	Ljava/lang/String;
    //   349: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 13
    //   355: ldc 247
    //   357: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 12
    //   363: iconst_2
    //   364: aload 13
    //   366: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: aload 10
    //   371: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   374: goto +3 -> 377
    //   377: iload 5
    //   379: iconst_1
    //   380: iadd
    //   381: istore 5
    //   383: goto -353 -> 30
    //   386: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq +67 -> 456
    //   392: getstatic 19	com/tencent/mobileqq/onlinestatus/auto/location/cache/Loader:a	Ljava/lang/String;
    //   395: astore_3
    //   396: new 85	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   403: astore 10
    //   405: aload 10
    //   407: ldc 88
    //   409: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 10
    //   415: aload_0
    //   416: getfield 94	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:b	Ljava/lang/String;
    //   419: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 10
    //   425: ldc 228
    //   427: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload 10
    //   433: aload_1
    //   434: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload 10
    //   440: ldc 249
    //   442: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload_3
    //   447: iconst_2
    //   448: aload 10
    //   450: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: iconst_0
    //   457: ireturn
    //   458: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   461: ifeq +67 -> 528
    //   464: getstatic 19	com/tencent/mobileqq/onlinestatus/auto/location/cache/Loader:a	Ljava/lang/String;
    //   467: astore_3
    //   468: new 85	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   475: astore 10
    //   477: aload 10
    //   479: ldc 88
    //   481: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload 10
    //   487: aload_0
    //   488: getfield 94	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:b	Ljava/lang/String;
    //   491: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 10
    //   497: ldc 228
    //   499: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 10
    //   505: aload_1
    //   506: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 10
    //   512: ldc 253
    //   514: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload_3
    //   519: iconst_2
    //   520: aload 10
    //   522: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: iconst_0
    //   529: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	this	DiskLoader
    //   0	530	1	paramLatLng	LatLng
    //   0	530	2	paramInt	int
    //   0	530	3	paramOnPoiLoadListener	PoiLoader.OnPoiLoadListener
    //   25	10	4	i	int
    //   28	354	5	j	int
    //   179	82	6	l1	long
    //   194	83	8	l2	long
    //   42	203	10	localFile	File
    //   296	1	10	localException1	java.lang.Exception
    //   301	1	10	localException2	java.lang.Exception
    //   308	1	10	localException3	java.lang.Exception
    //   313	57	10	localException4	java.lang.Exception
    //   403	118	10	localStringBuilder1	StringBuilder
    //   6	32	11	arrayOfFile	File[]
    //   65	297	12	localObject1	Object
    //   92	273	13	localObject2	Object
    //   101	55	14	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   224	293	296	java/lang/Exception
    //   189	224	301	java/lang/Exception
    //   75	163	308	java/lang/Exception
    //   163	189	308	java/lang/Exception
    //   59	75	313	java/lang/Exception
  }
  
  public LatLng b(File paramFile)
  {
    paramFile = paramFile.getName();
    Object localObject1 = paramFile.split("-");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = Loader.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][poiLoader][");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] disk getLatLngFromPoiFile file: ");
      localStringBuilder.append(paramFile);
      localStringBuilder.append(" array: ");
      localStringBuilder.append(Arrays.toString((Object[])localObject1));
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    if (localObject1.length >= 3) {
      try
      {
        paramFile = new LatLng(Double.parseDouble(localObject1[1]), Double.parseDouble(localObject1[2]));
        return paramFile;
      }
      catch (NumberFormatException paramFile)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = Loader.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[status][poiLoader][");
          ((StringBuilder)localObject2).append(this.b);
          ((StringBuilder)localObject2).append("] PoiCache Parse File To LatLng Error");
          QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString(), paramFile);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.DiskLoader
 * JD-Core Version:    0.7.0.1
 */