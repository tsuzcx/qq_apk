package cooperation.plugin;

final class Dex2Oat$StreamConsumer$1
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	cooperation/plugin/Dex2Oat$StreamConsumer$1:a	Ljava/io/InputStream;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: sipush 256
    //   11: newarray byte
    //   13: astore_2
    //   14: aload_0
    //   15: getfield 16	cooperation/plugin/Dex2Oat$StreamConsumer$1:a	Ljava/io/InputStream;
    //   18: aload_2
    //   19: invokevirtual 22	java/io/InputStream:read	([B)I
    //   22: istore_1
    //   23: iload_1
    //   24: ifgt -10 -> 14
    //   27: aload_0
    //   28: getfield 16	cooperation/plugin/Dex2Oat$StreamConsumer$1:a	Ljava/io/InputStream;
    //   31: invokevirtual 25	java/io/InputStream:close	()V
    //   34: return
    //   35: astore_2
    //   36: return
    //   37: astore_2
    //   38: aload_0
    //   39: getfield 16	cooperation/plugin/Dex2Oat$StreamConsumer$1:a	Ljava/io/InputStream;
    //   42: invokevirtual 25	java/io/InputStream:close	()V
    //   45: return
    //   46: astore_2
    //   47: return
    //   48: astore_2
    //   49: aload_0
    //   50: getfield 16	cooperation/plugin/Dex2Oat$StreamConsumer$1:a	Ljava/io/InputStream;
    //   53: invokevirtual 25	java/io/InputStream:close	()V
    //   56: aload_2
    //   57: athrow
    //   58: astore_3
    //   59: goto -3 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	1
    //   22	2	1	i	int
    //   13	6	2	arrayOfByte	byte[]
    //   35	1	2	localException1	java.lang.Exception
    //   37	1	2	localIOException	java.io.IOException
    //   46	1	2	localException2	java.lang.Exception
    //   48	9	2	localObject	Object
    //   58	1	3	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   27	34	35	java/lang/Exception
    //   14	23	37	java/io/IOException
    //   38	45	46	java/lang/Exception
    //   14	23	48	finally
    //   49	56	58	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.Dex2Oat.StreamConsumer.1
 * JD-Core Version:    0.7.0.1
 */