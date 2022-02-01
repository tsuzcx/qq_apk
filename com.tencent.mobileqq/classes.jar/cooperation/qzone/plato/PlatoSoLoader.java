package cooperation.qzone.plato;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class PlatoSoLoader
{
  public static final String SO_PLATO_LAYOUT_NAME = "libplato-layout.so";
  public static final String SO_PLATO_NATIVE_NAME = "libplatonative.so";
  public static final String SO_V8_NAME = "libv8rt.so";
  private static final String TAG = "PlatoSoLoader";
  public static AtomicBoolean sV8LibLoaded = new AtomicBoolean(false);
  
  static
  {
    System.loadLibrary("c++_shared");
  }
  
  public static String getSoPath(String paramString1, String paramString2)
  {
    return paramString1 + File.separator + paramString2;
  }
  
  /* Error */
  public static boolean loadV8So(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 29	cooperation/qzone/plato/PlatoSoLoader:sV8LibLoaded	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 66	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifne +87 -> 96
    //   12: aload_0
    //   13: ldc 14
    //   15: invokestatic 68	cooperation/qzone/plato/PlatoSoLoader:getSoPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_2
    //   19: aload_0
    //   20: ldc 11
    //   22: invokestatic 68	cooperation/qzone/plato/PlatoSoLoader:getSoPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_0
    //   27: ldc 8
    //   29: invokestatic 68	cooperation/qzone/plato/PlatoSoLoader:getSoPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_0
    //   33: aload_2
    //   34: invokestatic 73	ypi:e	(Ljava/lang/String;)Z
    //   37: ifeq +59 -> 96
    //   40: aload_3
    //   41: invokestatic 73	ypi:e	(Ljava/lang/String;)Z
    //   44: ifeq +52 -> 96
    //   47: aload_0
    //   48: invokestatic 73	ypi:e	(Ljava/lang/String;)Z
    //   51: istore_1
    //   52: iload_1
    //   53: ifeq +43 -> 96
    //   56: getstatic 29	cooperation/qzone/plato/PlatoSoLoader:sV8LibLoaded	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: iconst_0
    //   60: iconst_1
    //   61: invokevirtual 77	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   64: pop
    //   65: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +28 -> 96
    //   71: ldc 17
    //   73: iconst_2
    //   74: new 44	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   81: ldc 84
    //   83: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: getstatic 29	cooperation/qzone/plato/PlatoSoLoader:sV8LibLoaded	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   99: invokevirtual 66	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   102: istore_1
    //   103: ldc 2
    //   105: monitorexit
    //   106: iload_1
    //   107: ireturn
    //   108: astore_0
    //   109: ldc 17
    //   111: iconst_1
    //   112: new 44	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   119: ldc 90
    //   121: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 96	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: goto -69 -> 65
    //   137: astore_0
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload_0
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   51	56	1	bool	boolean
    //   18	69	2	str1	String
    //   25	16	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   56	65	108	java/lang/Throwable
    //   3	52	137	finally
    //   56	65	137	finally
    //   65	96	137	finally
    //   96	103	137	finally
    //   109	134	137	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plato.PlatoSoLoader
 * JD-Core Version:    0.7.0.1
 */