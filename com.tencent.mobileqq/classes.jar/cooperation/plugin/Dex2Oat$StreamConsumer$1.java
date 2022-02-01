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
    //   24: ifle +6 -> 30
    //   27: goto -13 -> 14
    //   30: aload_0
    //   31: getfield 16	cooperation/plugin/Dex2Oat$StreamConsumer$1:a	Ljava/io/InputStream;
    //   34: invokevirtual 25	java/io/InputStream:close	()V
    //   37: return
    //   38: astore_2
    //   39: aload_0
    //   40: getfield 16	cooperation/plugin/Dex2Oat$StreamConsumer$1:a	Ljava/io/InputStream;
    //   43: invokevirtual 25	java/io/InputStream:close	()V
    //   46: aload_2
    //   47: athrow
    //   48: astore_2
    //   49: goto -19 -> 30
    //   52: astore_2
    //   53: return
    //   54: astore_3
    //   55: goto -9 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	1
    //   22	2	1	i	int
    //   13	6	2	arrayOfByte	byte[]
    //   38	9	2	localObject	Object
    //   48	1	2	localIOException	java.io.IOException
    //   52	1	2	localException1	java.lang.Exception
    //   54	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   14	23	38	finally
    //   14	23	48	java/io/IOException
    //   30	37	52	java/lang/Exception
    //   39	46	54	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.Dex2Oat.StreamConsumer.1
 * JD-Core Version:    0.7.0.1
 */