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
    //   7: astore 4
    //   9: aload 4
    //   11: invokeinterface 56 1 0
    //   16: ifeq +232 -> 248
    //   19: aload 4
    //   21: invokeinterface 60 1 0
    //   26: checkcast 62	java/lang/String
    //   29: astore_2
    //   30: new 64	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   37: astore_3
    //   38: aload_3
    //   39: ldc 67
    //   41: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: aload_2
    //   47: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_3
    //   52: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: pop
    //   56: new 77	java/io/File
    //   59: dup
    //   60: aload_1
    //   61: aload_2
    //   62: invokespecial 80	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: astore_3
    //   66: aload_3
    //   67: invokevirtual 83	java/io/File:exists	()Z
    //   70: ifne -61 -> 9
    //   73: aload_3
    //   74: invokevirtual 87	java/io/File:getParentFile	()Ljava/io/File;
    //   77: ifnull +11 -> 88
    //   80: aload_3
    //   81: invokevirtual 87	java/io/File:getParentFile	()Ljava/io/File;
    //   84: invokevirtual 90	java/io/File:mkdirs	()Z
    //   87: pop
    //   88: aload_0
    //   89: getfield 27	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mAssetManager	Landroid/content/res/AssetManager;
    //   92: aload_2
    //   93: invokevirtual 96	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   96: astore 5
    //   98: new 98	java/io/FileOutputStream
    //   101: dup
    //   102: aload_3
    //   103: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   106: astore 6
    //   108: aload 5
    //   110: aload 6
    //   112: invokestatic 107	io/flutter/embedding/engine/loader/ResourceExtractor:access$200	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   115: aload 6
    //   117: invokevirtual 112	java/io/OutputStream:close	()V
    //   120: aload 5
    //   122: ifnull -113 -> 9
    //   125: aload 5
    //   127: invokevirtual 115	java/io/InputStream:close	()V
    //   130: goto -121 -> 9
    //   133: astore_2
    //   134: goto -125 -> 9
    //   137: astore_2
    //   138: aconst_null
    //   139: astore_3
    //   140: aload_3
    //   141: ifnull +85 -> 226
    //   144: aload 6
    //   146: invokevirtual 112	java/io/OutputStream:close	()V
    //   149: aload_2
    //   150: athrow
    //   151: astore_3
    //   152: aload_3
    //   153: athrow
    //   154: astore_2
    //   155: aload 5
    //   157: ifnull +12 -> 169
    //   160: aload_3
    //   161: ifnull +79 -> 240
    //   164: aload 5
    //   166: invokevirtual 115	java/io/InputStream:close	()V
    //   169: aload_2
    //   170: athrow
    //   171: astore_1
    //   172: new 64	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   179: astore_2
    //   180: aload_2
    //   181: ldc 117
    //   183: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_2
    //   188: aload_1
    //   189: invokevirtual 120	java/io/IOException:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: ldc 122
    //   198: aload_2
    //   199: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 128	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   205: pop
    //   206: aload_0
    //   207: getfield 23	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mDataDirPath	Ljava/lang/String;
    //   210: aload_0
    //   211: getfield 25	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mResources	Ljava/util/HashSet;
    //   214: invokestatic 132	io/flutter/embedding/engine/loader/ResourceExtractor:access$100	(Ljava/lang/String;Ljava/util/HashSet;)V
    //   217: iconst_0
    //   218: ireturn
    //   219: astore_3
    //   220: aload_3
    //   221: athrow
    //   222: astore_2
    //   223: goto -83 -> 140
    //   226: aload 6
    //   228: invokevirtual 112	java/io/OutputStream:close	()V
    //   231: goto -82 -> 149
    //   234: astore_2
    //   235: aconst_null
    //   236: astore_3
    //   237: goto -82 -> 155
    //   240: aload 5
    //   242: invokevirtual 115	java/io/InputStream:close	()V
    //   245: goto -76 -> 169
    //   248: iconst_1
    //   249: ireturn
    //   250: astore_3
    //   251: goto -102 -> 149
    //   254: astore_3
    //   255: goto -86 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	ExtractTask
    //   0	258	1	paramFile	File
    //   29	64	2	str	String
    //   133	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   137	13	2	localObject1	java.lang.Object
    //   154	16	2	localObject2	java.lang.Object
    //   179	20	2	localStringBuilder	java.lang.StringBuilder
    //   222	1	2	localObject3	java.lang.Object
    //   234	1	2	localObject4	java.lang.Object
    //   37	104	3	localObject5	java.lang.Object
    //   151	10	3	localThrowable1	java.lang.Throwable
    //   219	2	3	localThrowable2	java.lang.Throwable
    //   236	1	3	localObject6	java.lang.Object
    //   250	1	3	localThrowable3	java.lang.Throwable
    //   254	1	3	localThrowable4	java.lang.Throwable
    //   7	13	4	localIterator	java.util.Iterator
    //   96	145	5	localInputStream	java.io.InputStream
    //   106	121	6	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   30	88	133	java/io/FileNotFoundException
    //   88	98	133	java/io/FileNotFoundException
    //   125	130	133	java/io/FileNotFoundException
    //   164	169	133	java/io/FileNotFoundException
    //   169	171	133	java/io/FileNotFoundException
    //   240	245	133	java/io/FileNotFoundException
    //   108	115	137	finally
    //   98	108	151	java/lang/Throwable
    //   115	120	151	java/lang/Throwable
    //   149	151	151	java/lang/Throwable
    //   226	231	151	java/lang/Throwable
    //   152	154	154	finally
    //   30	88	171	java/io/IOException
    //   88	98	171	java/io/IOException
    //   125	130	171	java/io/IOException
    //   164	169	171	java/io/IOException
    //   169	171	171	java/io/IOException
    //   240	245	171	java/io/IOException
    //   108	115	219	java/lang/Throwable
    //   220	222	222	finally
    //   98	108	234	finally
    //   115	120	234	finally
    //   144	149	234	finally
    //   149	151	234	finally
    //   226	231	234	finally
    //   144	149	250	java/lang/Throwable
    //   164	169	254	java/lang/Throwable
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = new File(this.mDataDirPath);
    String str = ResourceExtractor.access$000(paramVarArgs, this.mPackageManager, this.mPackageName);
    if (str == null) {}
    do
    {
      return null;
      ResourceExtractor.access$100(this.mDataDirPath, this.mResources);
    } while ((!extractAPK(paramVarArgs)) || (str == null));
    try
    {
      new File(paramVarArgs, str).createNewFile();
      return null;
    }
    catch (IOException paramVarArgs)
    {
      Log.w("ResourceExtractor", "Failed to write resource timestamp");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.ResourceExtractor.ExtractTask
 * JD-Core Version:    0.7.0.1
 */