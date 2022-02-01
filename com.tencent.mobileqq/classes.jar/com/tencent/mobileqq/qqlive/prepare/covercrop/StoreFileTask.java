package com.tencent.mobileqq.qqlive.prepare.covercrop;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class StoreFileTask
{
  private Bitmap a;
  private String b;
  
  private File a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("StoreFileTask", 1, "the file path is null");
      return null;
    }
    Object localObject = new File(paramString);
    try
    {
      if (!((File)localObject).exists())
      {
        int i = paramString.lastIndexOf('/');
        if ((i > 0) && (i < paramString.length() - 1))
        {
          paramString = new File(paramString.substring(0, i));
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
        }
      }
      else
      {
        ((File)localObject).delete();
      }
      ((File)localObject).createNewFile();
      return localObject;
    }
    catch (IOException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("storeImageToFile IOException ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("StoreFileTask", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  /* Error */
  private String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 27	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: getfield 82	com/tencent/mobileqq/qqlive/prepare/covercrop/StoreFileTask:b	Ljava/lang/String;
    //   14: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 35	java/io/File:exists	()Z
    //   22: ifne +12 -> 34
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 82	com/tencent/mobileqq/qqlive/prepare/covercrop/StoreFileTask:b	Ljava/lang/String;
    //   30: invokespecial 84	com/tencent/mobileqq/qqlive/prepare/covercrop/StoreFileTask:a	(Ljava/lang/String;)Ljava/io/File;
    //   33: pop
    //   34: new 86	java/io/FileOutputStream
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   42: astore_3
    //   43: aload_3
    //   44: astore_2
    //   45: aload_1
    //   46: getstatic 95	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   49: bipush 80
    //   51: aload_3
    //   52: invokevirtual 101	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   55: pop
    //   56: aload_3
    //   57: astore_2
    //   58: aload_0
    //   59: getfield 82	com/tencent/mobileqq/qqlive/prepare/covercrop/StoreFileTask:b	Ljava/lang/String;
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   67: aload_1
    //   68: areturn
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   74: aload_1
    //   75: areturn
    //   76: astore_2
    //   77: aload_3
    //   78: astore_1
    //   79: aload_2
    //   80: astore_3
    //   81: goto +12 -> 93
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_2
    //   87: goto +70 -> 157
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_2
    //   95: new 60	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   102: astore 4
    //   104: aload_1
    //   105: astore_2
    //   106: aload 4
    //   108: ldc 109
    //   110: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_1
    //   115: astore_2
    //   116: aload 4
    //   118: aload_3
    //   119: invokevirtual 112	java/io/IOException:getMessage	()Ljava/lang/String;
    //   122: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_1
    //   127: astore_2
    //   128: ldc 17
    //   130: iconst_1
    //   131: aload 4
    //   133: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 25	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_1
    //   140: ifnull +14 -> 154
    //   143: aload_1
    //   144: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_1
    //   157: aload_2
    //   158: ifnull +15 -> 173
    //   161: aload_2
    //   162: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   165: goto +8 -> 173
    //   168: astore_2
    //   169: aload_2
    //   170: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	StoreFileTask
    //   0	175	1	paramBitmap	Bitmap
    //   17	41	2	localObject1	Object
    //   69	2	2	localIOException1	IOException
    //   76	4	2	localIOException2	IOException
    //   86	76	2	localBitmap	Bitmap
    //   168	2	2	localIOException3	IOException
    //   42	39	3	localObject2	Object
    //   90	29	3	localIOException4	IOException
    //   102	30	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   63	67	69	java/io/IOException
    //   45	56	76	java/io/IOException
    //   58	63	76	java/io/IOException
    //   18	34	84	finally
    //   34	43	84	finally
    //   18	34	90	java/io/IOException
    //   34	43	90	java/io/IOException
    //   143	147	149	java/io/IOException
    //   45	56	156	finally
    //   58	63	156	finally
    //   95	104	156	finally
    //   106	114	156	finally
    //   116	126	156	finally
    //   128	139	156	finally
    //   161	165	168	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.covercrop.StoreFileTask
 * JD-Core Version:    0.7.0.1
 */