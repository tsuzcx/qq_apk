package com.tencent.stat.a.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class b
  extends g
{
  b(Context paramContext)
  {
    super(paramContext);
  }
  
  /* Error */
  protected void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 15
    //   4: invokestatic 19	com/tencent/stat/a/a/i:a	(Ljava/lang/String;)V
    //   7: new 21	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   14: invokestatic 30	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   17: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: ldc 36
    //   22: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokestatic 43	com/tencent/stat/a/a/b:c	()Ljava/lang/String;
    //   28: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 51	com/tencent/stat/a/a/a:a	(Ljava/lang/String;)Ljava/io/File;
    //   37: pop
    //   38: new 53	java/io/File
    //   41: dup
    //   42: invokestatic 30	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   45: invokestatic 56	com/tencent/stat/a/a/b:d	()Ljava/lang/String;
    //   48: invokespecial 59	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: ifnull +59 -> 112
    //   56: new 61	java/io/BufferedWriter
    //   59: dup
    //   60: new 63	java/io/FileWriter
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 66	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   68: invokespecial 69	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   71: astore_2
    //   72: aload_2
    //   73: new 21	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   80: aload_0
    //   81: invokevirtual 72	com/tencent/stat/a/a/b:f	()Ljava/lang/String;
    //   84: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 74
    //   89: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_1
    //   93: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokevirtual 77	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   102: aload_2
    //   103: ldc 79
    //   105: invokevirtual 77	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   108: aload_2
    //   109: invokevirtual 82	java/io/BufferedWriter:close	()V
    //   112: aload_0
    //   113: monitorexit
    //   114: return
    //   115: astore_1
    //   116: aload_1
    //   117: invokestatic 85	com/tencent/stat/a/a/i:a	(Ljava/lang/Throwable;)V
    //   120: goto -8 -> 112
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	b
    //   0	128	1	paramString	String
    //   51	58	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   56	112	115	java/io/IOException
    //   2	52	123	finally
    //   56	112	123	finally
    //   112	114	123	finally
    //   116	120	123	finally
    //   124	126	123	finally
  }
  
  protected boolean a()
  {
    return (i.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) && (Environment.getExternalStorageState().equals("mounted"));
  }
  
  protected String b()
  {
    Object localObject5 = null;
    for (;;)
    {
      try
      {
        i.a("read mid from InternalStorage");
        Object localObject6 = new File(Environment.getExternalStorageDirectory(), d());
        Object localObject1 = localObject5;
        if (localObject6 != null) {}
        try
        {
          localObject1 = a.a((File)localObject6).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label129;
          }
          localObject6 = ((String)((Iterator)localObject1).next()).split(",");
          if ((localObject6.length != 2) || (!localObject6[0].equals(f()))) {
            continue;
          }
          i.a("read mid from InternalStorage:" + localObject6[1]);
          localObject1 = localObject6[1];
        }
        catch (IOException localIOException)
        {
          i.a(localIOException);
          Object localObject2 = localObject5;
          continue;
        }
        return localObject1;
      }
      finally {}
      label129:
      Object localObject4 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.stat.a.a.b
 * JD-Core Version:    0.7.0.1
 */