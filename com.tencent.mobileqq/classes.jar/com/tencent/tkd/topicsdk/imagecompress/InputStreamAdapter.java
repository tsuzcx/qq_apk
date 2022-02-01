package com.tencent.tkd.topicsdk.imagecompress;

import java.io.InputStream;

public abstract class InputStreamAdapter
  implements InputStreamProvider
{
  private InputStream a;
  
  public InputStream a()
  {
    c();
    this.a = b();
    return this.a;
  }
  
  public abstract InputStream b();
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/tencent/tkd/topicsdk/imagecompress/InputStreamAdapter:a	Ljava/io/InputStream;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +37 -> 43
    //   9: aload_1
    //   10: invokevirtual 29	java/io/InputStream:close	()V
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield 22	com/tencent/tkd/topicsdk/imagecompress/InputStreamAdapter:a	Ljava/io/InputStream;
    //   18: return
    //   19: astore_1
    //   20: goto +16 -> 36
    //   23: astore_1
    //   24: ldc 31
    //   26: aload_1
    //   27: invokevirtual 35	java/io/IOException:toString	()Ljava/lang/String;
    //   30: invokestatic 41	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: goto -20 -> 13
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 22	com/tencent/tkd/topicsdk/imagecompress/InputStreamAdapter:a	Ljava/io/InputStream;
    //   41: aload_1
    //   42: athrow
    //   43: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	InputStreamAdapter
    //   4	6	1	localInputStream	InputStream
    //   19	1	1	localObject	Object
    //   23	19	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   9	13	19	finally
    //   24	33	19	finally
    //   9	13	23	java/io/IOException
  }
  
  public boolean d()
  {
    String str = e();
    if (str == null) {
      return false;
    }
    return str.toLowerCase().endsWith("gif");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.InputStreamAdapter
 * JD-Core Version:    0.7.0.1
 */