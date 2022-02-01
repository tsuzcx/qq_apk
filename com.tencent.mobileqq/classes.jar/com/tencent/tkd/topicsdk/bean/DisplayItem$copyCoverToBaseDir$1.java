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
    //   0: aload_0
    //   1: getfield 29	com/tencent/tkd/topicsdk/bean/DisplayItem$copyCoverToBaseDir$1:this$0	Lcom/tencent/tkd/topicsdk/bean/DisplayItem;
    //   4: aload_0
    //   5: getfield 31	com/tencent/tkd/topicsdk/bean/DisplayItem$copyCoverToBaseDir$1:$cover	Ljava/io/File;
    //   8: invokestatic 53	com/tencent/tkd/topicsdk/bean/DisplayItem:access$getBackUpCoverInputStream	(Lcom/tencent/tkd/topicsdk/bean/DisplayItem;Ljava/io/File;)Ljava/io/FileInputStream;
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 29	com/tencent/tkd/topicsdk/bean/DisplayItem$copyCoverToBaseDir$1:this$0	Lcom/tencent/tkd/topicsdk/bean/DisplayItem;
    //   16: invokestatic 57	com/tencent/tkd/topicsdk/bean/DisplayItem:access$getBackUpCoverOutputStream	(Lcom/tencent/tkd/topicsdk/bean/DisplayItem;)Ljava/io/FileOutputStream;
    //   19: astore_2
    //   20: aload_1
    //   21: ifnull +81 -> 102
    //   24: aload_2
    //   25: ifnonnull +6 -> 31
    //   28: goto +74 -> 102
    //   31: getstatic 63	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   34: aload_1
    //   35: checkcast 65	java/io/InputStream
    //   38: aload_2
    //   39: checkcast 67	java/io/OutputStream
    //   42: invokevirtual 70	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   45: aload_1
    //   46: invokevirtual 75	java/io/FileInputStream:close	()V
    //   49: aload_2
    //   50: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   53: return
    //   54: astore_3
    //   55: goto +29 -> 84
    //   58: astore_3
    //   59: ldc 80
    //   61: aload_3
    //   62: checkcast 82	java/lang/Throwable
    //   65: invokestatic 87	com/tencent/tkd/topicsdk/framework/TLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 75	java/io/FileInputStream:close	()V
    //   76: aload_2
    //   77: ifnull +6 -> 83
    //   80: goto -31 -> 49
    //   83: return
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 75	java/io/FileInputStream:close	()V
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   100: aload_3
    //   101: athrow
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 75	java/io/FileInputStream:close	()V
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   118: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	1
    //   11	96	1	localFileInputStream	java.io.FileInputStream
    //   19	96	2	localFileOutputStream	java.io.FileOutputStream
    //   54	1	3	localObject	java.lang.Object
    //   58	43	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   31	45	54	finally
    //   59	68	54	finally
    //   31	45	58	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.DisplayItem.copyCoverToBaseDir.1
 * JD-Core Version:    0.7.0.1
 */