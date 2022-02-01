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
    //   7: astore_2
    //   8: aload_2
    //   9: invokeinterface 56 1 0
    //   14: ifeq +198 -> 212
    //   17: aload_2
    //   18: invokeinterface 60 1 0
    //   23: checkcast 62	java/lang/String
    //   26: astore_3
    //   27: new 64	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   34: astore 4
    //   36: aload 4
    //   38: ldc 67
    //   40: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: pop
    //   57: new 77	java/io/File
    //   60: dup
    //   61: aload_1
    //   62: aload_3
    //   63: invokespecial 80	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   66: astore 4
    //   68: aload 4
    //   70: invokevirtual 83	java/io/File:exists	()Z
    //   73: ifeq +6 -> 79
    //   76: goto -68 -> 8
    //   79: aload 4
    //   81: invokevirtual 87	java/io/File:getParentFile	()Ljava/io/File;
    //   84: ifnull +12 -> 96
    //   87: aload 4
    //   89: invokevirtual 87	java/io/File:getParentFile	()Ljava/io/File;
    //   92: invokevirtual 90	java/io/File:mkdirs	()Z
    //   95: pop
    //   96: aload_0
    //   97: getfield 27	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mAssetManager	Landroid/content/res/AssetManager;
    //   100: aload_3
    //   101: invokevirtual 96	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   104: astore_3
    //   105: new 98	java/io/FileOutputStream
    //   108: dup
    //   109: aload 4
    //   111: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   114: astore 5
    //   116: aload_3
    //   117: aload 5
    //   119: invokestatic 107	io/flutter/embedding/engine/loader/ResourceExtractor:access$200	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   122: aload 5
    //   124: invokevirtual 112	java/io/OutputStream:close	()V
    //   127: aload_3
    //   128: ifnull -120 -> 8
    //   131: aload_3
    //   132: invokevirtual 115	java/io/InputStream:close	()V
    //   135: goto -127 -> 8
    //   138: astore 4
    //   140: aload 5
    //   142: invokevirtual 112	java/io/OutputStream:close	()V
    //   145: aload 4
    //   147: athrow
    //   148: astore 4
    //   150: aload_3
    //   151: ifnull +7 -> 158
    //   154: aload_3
    //   155: invokevirtual 115	java/io/InputStream:close	()V
    //   158: aload 4
    //   160: athrow
    //   161: astore_1
    //   162: new 64	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   169: astore_2
    //   170: aload_2
    //   171: ldc 117
    //   173: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_2
    //   178: aload_1
    //   179: invokevirtual 120	java/io/IOException:getMessage	()Ljava/lang/String;
    //   182: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: ldc 122
    //   188: aload_2
    //   189: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 128	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   195: pop
    //   196: aload_0
    //   197: getfield 23	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mDataDirPath	Ljava/lang/String;
    //   200: aload_0
    //   201: getfield 25	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mResources	Ljava/util/HashSet;
    //   204: invokestatic 132	io/flutter/embedding/engine/loader/ResourceExtractor:access$100	(Ljava/lang/String;Ljava/util/HashSet;)V
    //   207: iconst_0
    //   208: ireturn
    //   209: goto -201 -> 8
    //   212: iconst_1
    //   213: ireturn
    //   214: astore_3
    //   215: goto -6 -> 209
    //   218: astore 5
    //   220: goto -75 -> 145
    //   223: astore_3
    //   224: goto -66 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	ExtractTask
    //   0	227	1	paramFile	File
    //   7	182	2	localObject1	java.lang.Object
    //   26	129	3	localObject2	java.lang.Object
    //   214	1	3	localFileNotFoundException	java.io.FileNotFoundException
    //   223	1	3	localThrowable1	java.lang.Throwable
    //   34	76	4	localObject3	java.lang.Object
    //   138	8	4	localThrowable2	java.lang.Throwable
    //   148	11	4	localThrowable3	java.lang.Throwable
    //   114	27	5	localFileOutputStream	java.io.FileOutputStream
    //   218	1	5	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   116	122	138	java/lang/Throwable
    //   105	116	148	java/lang/Throwable
    //   122	127	148	java/lang/Throwable
    //   145	148	148	java/lang/Throwable
    //   27	76	161	java/io/IOException
    //   79	96	161	java/io/IOException
    //   96	105	161	java/io/IOException
    //   105	116	161	java/io/IOException
    //   116	122	161	java/io/IOException
    //   122	127	161	java/io/IOException
    //   131	135	161	java/io/IOException
    //   140	145	161	java/io/IOException
    //   145	148	161	java/io/IOException
    //   154	158	161	java/io/IOException
    //   158	161	161	java/io/IOException
    //   27	76	214	java/io/FileNotFoundException
    //   79	96	214	java/io/FileNotFoundException
    //   96	105	214	java/io/FileNotFoundException
    //   105	116	214	java/io/FileNotFoundException
    //   116	122	214	java/io/FileNotFoundException
    //   122	127	214	java/io/FileNotFoundException
    //   131	135	214	java/io/FileNotFoundException
    //   140	145	214	java/io/FileNotFoundException
    //   145	148	214	java/io/FileNotFoundException
    //   154	158	214	java/io/FileNotFoundException
    //   158	161	214	java/io/FileNotFoundException
    //   140	145	218	java/lang/Throwable
    //   154	158	223	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.ResourceExtractor.ExtractTask
 * JD-Core Version:    0.7.0.1
 */