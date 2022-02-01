package com.tencent.tkd.topicsdk.bean;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class DisplayItem$copyCoverToBaseDir$1
  extends Lambda
  implements Function0<Unit>
{
  DisplayItem$copyCoverToBaseDir$1(DisplayItem paramDisplayItem, File paramFile)
  {
    super(0);
  }
  
  /* Error */
  public final void invoke()
  {
    // Byte code:
    //   0: new 49	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 31	com/tencent/tkd/topicsdk/bean/DisplayItem$copyCoverToBaseDir$1:$cover	Ljava/io/File;
    //   8: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore_1
    //   12: new 54	java/io/FileOutputStream
    //   15: dup
    //   16: new 56	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: getfield 29	com/tencent/tkd/topicsdk/bean/DisplayItem$copyCoverToBaseDir$1:this$0	Lcom/tencent/tkd/topicsdk/bean/DisplayItem;
    //   24: invokevirtual 62	com/tencent/tkd/topicsdk/bean/DisplayItem:getBackupCoverPath	()Ljava/lang/String;
    //   27: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore_2
    //   34: getstatic 72	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   37: aload_1
    //   38: checkcast 74	java/io/InputStream
    //   41: aload_2
    //   42: checkcast 76	java/io/OutputStream
    //   45: invokevirtual 79	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   48: aload_1
    //   49: invokevirtual 82	java/io/FileInputStream:close	()V
    //   52: aload_2
    //   53: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   56: return
    //   57: astore_3
    //   58: goto +16 -> 74
    //   61: astore_3
    //   62: ldc 85
    //   64: aload_3
    //   65: checkcast 87	java/lang/Throwable
    //   68: invokestatic 92	com/tencent/tkd/topicsdk/framework/TLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: goto -23 -> 48
    //   74: aload_1
    //   75: invokevirtual 82	java/io/FileInputStream:close	()V
    //   78: aload_2
    //   79: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   82: goto +5 -> 87
    //   85: aload_3
    //   86: athrow
    //   87: goto -2 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	1
    //   11	64	1	localFileInputStream	java.io.FileInputStream
    //   33	46	2	localFileOutputStream	java.io.FileOutputStream
    //   57	1	3	localObject	java.lang.Object
    //   61	25	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   34	48	57	finally
    //   62	71	57	finally
    //   34	48	61	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.DisplayItem.copyCoverToBaseDir.1
 * JD-Core Version:    0.7.0.1
 */