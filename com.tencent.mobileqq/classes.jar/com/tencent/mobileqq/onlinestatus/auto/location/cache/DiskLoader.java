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
  private static File jdField_a_of_type_JavaIoFile;
  private final int jdField_a_of_type_Int;
  
  DiskLoader(String paramString, int paramInt)
  {
    super(paramString);
    Loader.a = "DiskLoader";
    this.jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_JavaIoFile = new File(MobileQQ.sMobileQQ.getCacheDir(), "/poi/");
    jdField_a_of_type_JavaIoFile.mkdirs();
  }
  
  private void a()
  {
    int i = a();
    int j = this.jdField_a_of_type_Int;
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
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append(" overFlowSize: ");
        ((StringBuilder)localObject2).append(k);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = null;
      i = 0;
      while (i < k)
      {
        File[] arrayOfFile = jdField_a_of_type_JavaIoFile.listFiles();
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
  
  private void a(PoiBean paramPoiBean, File paramFile)
  {
    Gson localGson = new GsonBuilder().create();
    paramFile = new FileWriter(paramFile);
    localGson.toJson(paramPoiBean, paramFile);
    paramFile.flush();
    paramFile.close();
  }
  
  public int a()
  {
    String[] arrayOfString = jdField_a_of_type_JavaIoFile.list();
    if (arrayOfString == null) {
      return 0;
    }
    return arrayOfString.length;
  }
  
  PoiBean a(File paramFile)
  {
    return (PoiBean)new GsonBuilder().create().fromJson(new FileReader(paramFile), PoiBean.class);
  }
  
  public LatLng a(File paramFile)
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
  
  public File a(LatLng paramLatLng)
  {
    File localFile = jdField_a_of_type_JavaIoFile;
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
    a();
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
    //   0: getstatic 38	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3: invokevirtual 86	java/io/File:listFiles	()[Ljava/io/File;
    //   6: astore 11
    //   8: aload 11
    //   10: ifnull +454 -> 464
    //   13: aload 11
    //   15: arraylength
    //   16: ifne +6 -> 22
    //   19: goto +445 -> 464
    //   22: aload 11
    //   24: arraylength
    //   25: istore 4
    //   27: iconst_0
    //   28: istore 5
    //   30: iload 5
    //   32: iload 4
    //   34: if_icmpge +357 -> 391
    //   37: aload 11
    //   39: iload 5
    //   41: aaload
    //   42: astore 10
    //   44: aload_0
    //   45: aload_0
    //   46: aload 10
    //   48: invokevirtual 241	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:a	(Ljava/io/File;)Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;
    //   51: aload_1
    //   52: iload_2
    //   53: invokevirtual 244	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:a	(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;I)Z
    //   56: ifeq +326 -> 382
    //   59: aload_0
    //   60: aload 10
    //   62: invokevirtual 246	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:a	(Ljava/io/File;)Lcom/tencent/mobileqq/onlinestatus/auto/location/cache/PoiBean;
    //   65: astore 12
    //   67: aload_0
    //   68: ldc 248
    //   70: aload 12
    //   72: invokevirtual 224	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:a	(Ljava/lang/String;Lcom/tencent/mobileqq/onlinestatus/auto/location/cache/PoiBean;)V
    //   75: aload_3
    //   76: aload 12
    //   78: invokeinterface 253 2 0
    //   83: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +78 -> 164
    //   89: getstatic 17	com/tencent/mobileqq/onlinestatus/auto/location/cache/Loader:a	Ljava/lang/String;
    //   92: astore 13
    //   94: new 54	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   101: astore 14
    //   103: aload 14
    //   105: ldc 58
    //   107: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 14
    //   113: aload_0
    //   114: getfield 65	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:b	Ljava/lang/String;
    //   117: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 14
    //   123: ldc 255
    //   125: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 14
    //   131: aload_1
    //   132: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 14
    //   138: ldc_w 257
    //   141: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 14
    //   147: aload 12
    //   149: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 13
    //   155: iconst_2
    //   156: aload 14
    //   158: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload 10
    //   166: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   169: invokevirtual 266	java/io/File:setLastModified	(J)Z
    //   172: ifne +138 -> 310
    //   175: aload 10
    //   177: invokevirtual 90	java/io/File:lastModified	()J
    //   180: lstore 6
    //   182: aload_0
    //   183: aload 12
    //   185: aload 10
    //   187: invokespecial 235	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:a	(Lcom/tencent/mobileqq/onlinestatus/auto/location/cache/PoiBean;Ljava/io/File;)V
    //   190: aload 10
    //   192: invokevirtual 90	java/io/File:lastModified	()J
    //   195: lstore 8
    //   197: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +110 -> 310
    //   203: getstatic 17	com/tencent/mobileqq/onlinestatus/auto/location/cache/Loader:a	Ljava/lang/String;
    //   206: astore 12
    //   208: new 54	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   215: astore 13
    //   217: aload 13
    //   219: ldc 58
    //   221: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 13
    //   227: aload_0
    //   228: getfield 65	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:b	Ljava/lang/String;
    //   231: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 13
    //   237: ldc_w 268
    //   240: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 13
    //   246: aload 10
    //   248: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 13
    //   254: ldc_w 270
    //   257: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 13
    //   263: lload 6
    //   265: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 13
    //   271: ldc_w 272
    //   274: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 13
    //   280: lload 8
    //   282: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 12
    //   288: iconst_2
    //   289: aload 13
    //   291: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: goto +13 -> 310
    //   300: astore 10
    //   302: goto +17 -> 319
    //   305: astore 10
    //   307: goto +12 -> 319
    //   310: iconst_1
    //   311: ireturn
    //   312: astore 10
    //   314: goto +5 -> 319
    //   317: astore 10
    //   319: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +60 -> 382
    //   325: getstatic 17	com/tencent/mobileqq/onlinestatus/auto/location/cache/Loader:a	Ljava/lang/String;
    //   328: astore 12
    //   330: new 54	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   337: astore 13
    //   339: aload 13
    //   341: ldc 58
    //   343: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 13
    //   349: aload_0
    //   350: getfield 65	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:b	Ljava/lang/String;
    //   353: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 13
    //   359: ldc_w 274
    //   362: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 12
    //   368: iconst_2
    //   369: aload 13
    //   371: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: aload 10
    //   376: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   379: goto +3 -> 382
    //   382: iload 5
    //   384: iconst_1
    //   385: iadd
    //   386: istore 5
    //   388: goto -358 -> 30
    //   391: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +68 -> 462
    //   397: getstatic 17	com/tencent/mobileqq/onlinestatus/auto/location/cache/Loader:a	Ljava/lang/String;
    //   400: astore_3
    //   401: new 54	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   408: astore 10
    //   410: aload 10
    //   412: ldc 58
    //   414: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 10
    //   420: aload_0
    //   421: getfield 65	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:b	Ljava/lang/String;
    //   424: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 10
    //   430: ldc 255
    //   432: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 10
    //   438: aload_1
    //   439: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 10
    //   445: ldc_w 276
    //   448: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_3
    //   453: iconst_2
    //   454: aload 10
    //   456: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 278	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: iconst_0
    //   463: ireturn
    //   464: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   467: ifeq +68 -> 535
    //   470: getstatic 17	com/tencent/mobileqq/onlinestatus/auto/location/cache/Loader:a	Ljava/lang/String;
    //   473: astore_3
    //   474: new 54	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   481: astore 10
    //   483: aload 10
    //   485: ldc 58
    //   487: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload 10
    //   493: aload_0
    //   494: getfield 65	com/tencent/mobileqq/onlinestatus/auto/location/cache/DiskLoader:b	Ljava/lang/String;
    //   497: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 10
    //   503: ldc 255
    //   505: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 10
    //   511: aload_1
    //   512: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 10
    //   518: ldc_w 280
    //   521: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload_3
    //   526: iconst_2
    //   527: aload 10
    //   529: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 278	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: iconst_0
    //   536: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	DiskLoader
    //   0	537	1	paramLatLng	LatLng
    //   0	537	2	paramInt	int
    //   0	537	3	paramOnPoiLoadListener	PoiLoader.OnPoiLoadListener
    //   25	10	4	i	int
    //   28	359	5	j	int
    //   180	84	6	l1	long
    //   195	86	8	l2	long
    //   42	205	10	localFile	File
    //   300	1	10	localException1	java.lang.Exception
    //   305	1	10	localException2	java.lang.Exception
    //   312	1	10	localException3	java.lang.Exception
    //   317	58	10	localException4	java.lang.Exception
    //   408	120	10	localStringBuilder1	StringBuilder
    //   6	32	11	arrayOfFile	File[]
    //   65	302	12	localObject1	Object
    //   92	278	13	localObject2	Object
    //   101	56	14	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   225	297	300	java/lang/Exception
    //   190	225	305	java/lang/Exception
    //   75	164	312	java/lang/Exception
    //   164	190	312	java/lang/Exception
    //   59	75	317	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.DiskLoader
 * JD-Core Version:    0.7.0.1
 */