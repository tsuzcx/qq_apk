package io.flutter.embedding.engine.loader;

import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

class ResourceExtractor$ExtractTask
  extends AsyncTask<Void, Void, Void>
{
  @NonNull
  private final AssetManager mAssetManager;
  @NonNull
  private final String mDataDirPath;
  @NonNull
  private final PackageManager mPackageManager;
  @NonNull
  private final String mPackageName;
  @NonNull
  private final HashSet<String> mResources;
  
  ResourceExtractor$ExtractTask(@NonNull String paramString1, @NonNull HashSet<String> paramHashSet, @NonNull String paramString2, @NonNull PackageManager paramPackageManager, @NonNull AssetManager paramAssetManager)
  {
    this.mDataDirPath = paramString1;
    this.mResources = paramHashSet;
    this.mAssetManager = paramAssetManager;
    this.mPackageName = paramString2;
    this.mPackageManager = paramPackageManager;
  }
  
  /* Error */
  @androidx.annotation.WorkerThread
  private boolean extractAPK(@NonNull File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mResources	Ljava/util/HashSet;
    //   4: invokevirtual 50	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   7: astore 5
    //   9: aload 5
    //   11: invokeinterface 56 1 0
    //   16: ifeq +251 -> 267
    //   19: aload 5
    //   21: invokeinterface 60 1 0
    //   26: checkcast 62	java/lang/String
    //   29: astore_3
    //   30: new 64	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   37: astore_2
    //   38: aload_2
    //   39: ldc 67
    //   41: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: aload_3
    //   47: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: pop
    //   56: new 77	java/io/File
    //   59: dup
    //   60: aload_1
    //   61: aload_3
    //   62: invokespecial 80	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: astore_2
    //   66: aload_2
    //   67: invokevirtual 83	java/io/File:exists	()Z
    //   70: ifeq +6 -> 76
    //   73: goto -64 -> 9
    //   76: aload_2
    //   77: invokevirtual 87	java/io/File:getParentFile	()Ljava/io/File;
    //   80: ifnull +11 -> 91
    //   83: aload_2
    //   84: invokevirtual 87	java/io/File:getParentFile	()Ljava/io/File;
    //   87: invokevirtual 90	java/io/File:mkdirs	()Z
    //   90: pop
    //   91: aload_0
    //   92: getfield 27	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mAssetManager	Landroid/content/res/AssetManager;
    //   95: aload_3
    //   96: invokevirtual 96	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   99: astore 6
    //   101: aconst_null
    //   102: astore 4
    //   104: aload 4
    //   106: astore_3
    //   107: new 98	java/io/FileOutputStream
    //   110: dup
    //   111: aload_2
    //   112: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   115: astore 7
    //   117: aload 6
    //   119: aload 7
    //   121: invokestatic 107	io/flutter/embedding/engine/loader/ResourceExtractor:access$200	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   124: aload 4
    //   126: astore_3
    //   127: aload 7
    //   129: invokevirtual 112	java/io/OutputStream:close	()V
    //   132: aload 6
    //   134: ifnull -125 -> 9
    //   137: aload 6
    //   139: invokevirtual 115	java/io/InputStream:close	()V
    //   142: goto -133 -> 9
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_3
    //   148: goto +7 -> 155
    //   151: astore_3
    //   152: aload_3
    //   153: athrow
    //   154: astore_2
    //   155: aload_3
    //   156: ifnull +14 -> 170
    //   159: aload 4
    //   161: astore_3
    //   162: aload 7
    //   164: invokevirtual 112	java/io/OutputStream:close	()V
    //   167: goto +11 -> 178
    //   170: aload 4
    //   172: astore_3
    //   173: aload 7
    //   175: invokevirtual 112	java/io/OutputStream:close	()V
    //   178: aload 4
    //   180: astore_3
    //   181: aload_2
    //   182: athrow
    //   183: astore_2
    //   184: goto +8 -> 192
    //   187: astore_2
    //   188: aload_2
    //   189: astore_3
    //   190: aload_2
    //   191: athrow
    //   192: aload 6
    //   194: ifnull +20 -> 214
    //   197: aload_3
    //   198: ifnull +11 -> 209
    //   201: aload 6
    //   203: invokevirtual 115	java/io/InputStream:close	()V
    //   206: goto +8 -> 214
    //   209: aload 6
    //   211: invokevirtual 115	java/io/InputStream:close	()V
    //   214: aload_2
    //   215: athrow
    //   216: astore_1
    //   217: new 64	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   224: astore_2
    //   225: aload_2
    //   226: ldc 117
    //   228: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_2
    //   233: aload_1
    //   234: invokevirtual 120	java/io/IOException:getMessage	()Ljava/lang/String;
    //   237: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: ldc 122
    //   243: aload_2
    //   244: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 128	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   250: pop
    //   251: aload_0
    //   252: getfield 23	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mDataDirPath	Ljava/lang/String;
    //   255: aload_0
    //   256: getfield 25	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mResources	Ljava/util/HashSet;
    //   259: invokestatic 132	io/flutter/embedding/engine/loader/ResourceExtractor:access$100	(Ljava/lang/String;Ljava/util/HashSet;)V
    //   262: iconst_0
    //   263: ireturn
    //   264: goto -255 -> 9
    //   267: iconst_1
    //   268: ireturn
    //   269: astore_2
    //   270: goto -6 -> 264
    //   273: astore_3
    //   274: goto -96 -> 178
    //   277: astore_3
    //   278: goto -64 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	ExtractTask
    //   0	281	1	paramFile	File
    //   37	75	2	localObject1	java.lang.Object
    //   145	1	2	localObject2	java.lang.Object
    //   154	28	2	localObject3	java.lang.Object
    //   183	1	2	localObject4	java.lang.Object
    //   187	28	2	localThrowable1	java.lang.Throwable
    //   224	20	2	localStringBuilder	java.lang.StringBuilder
    //   269	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   29	119	3	localObject5	java.lang.Object
    //   151	5	3	localThrowable2	java.lang.Throwable
    //   161	37	3	localObject6	java.lang.Object
    //   273	1	3	localThrowable3	java.lang.Throwable
    //   277	1	3	localThrowable4	java.lang.Throwable
    //   102	77	4	localObject7	java.lang.Object
    //   7	13	5	localIterator	java.util.Iterator
    //   99	111	6	localInputStream	java.io.InputStream
    //   115	59	7	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   117	124	145	finally
    //   117	124	151	java/lang/Throwable
    //   152	154	154	finally
    //   107	117	183	finally
    //   127	132	183	finally
    //   162	167	183	finally
    //   173	178	183	finally
    //   181	183	183	finally
    //   190	192	183	finally
    //   107	117	187	java/lang/Throwable
    //   127	132	187	java/lang/Throwable
    //   173	178	187	java/lang/Throwable
    //   181	183	187	java/lang/Throwable
    //   30	73	216	java/io/IOException
    //   76	91	216	java/io/IOException
    //   91	101	216	java/io/IOException
    //   137	142	216	java/io/IOException
    //   201	206	216	java/io/IOException
    //   209	214	216	java/io/IOException
    //   214	216	216	java/io/IOException
    //   30	73	269	java/io/FileNotFoundException
    //   76	91	269	java/io/FileNotFoundException
    //   91	101	269	java/io/FileNotFoundException
    //   137	142	269	java/io/FileNotFoundException
    //   201	206	269	java/io/FileNotFoundException
    //   209	214	269	java/io/FileNotFoundException
    //   214	216	269	java/io/FileNotFoundException
    //   162	167	273	java/lang/Throwable
    //   201	206	277	java/lang/Throwable
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = new File(this.mDataDirPath);
    String str = ResourceExtractor.access$000(paramVarArgs, this.mPackageManager, this.mPackageName);
    if (str == null) {
      return null;
    }
    ResourceExtractor.access$100(this.mDataDirPath, this.mResources);
    if (!extractAPK(paramVarArgs)) {
      return null;
    }
    if (str != null) {}
    try
    {
      new File(paramVarArgs, str).createNewFile();
      return null;
    }
    catch (IOException paramVarArgs)
    {
      label71:
      break label71;
    }
    Log.w("ResourceExtractor", "Failed to write resource timestamp");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.ResourceExtractor.ExtractTask
 * JD-Core Version:    0.7.0.1
 */