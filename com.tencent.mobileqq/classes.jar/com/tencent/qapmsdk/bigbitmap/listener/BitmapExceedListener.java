package com.tencent.qapmsdk.bigbitmap.listener;

import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.reporter.IPluginReport;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.io.File;

public class BitmapExceedListener
  implements IBitmapExceedListener
{
  private static final long MIN_FILE_SIZE = 0L;
  private String bigBitmapDirName = AppInfo.obtainProcessPackageName(BaseInfo.app) + "@10@BitmapOverDecode";
  private String bigBitmapInfoFilePath = new File(FileUtil.getRootPath(), "dumpfile/" + this.bigBitmapDirName + "/BitmapOverDecode.csv").getAbsolutePath();
  @Nullable
  private IPluginReport reporter = null;
  
  /* Error */
  public void onBitmapExceed(java.util.List<com.tencent.qapmsdk.bigbitmap.datainfo.ExceedBitmapInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 51	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 68	com/tencent/qapmsdk/bigbitmap/listener/BitmapExceedListener:bigBitmapInfoFilePath	Ljava/lang/String;
    //   10: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 78	java/io/File:exists	()Z
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: getfield 68	com/tencent/qapmsdk/bigbitmap/listener/BitmapExceedListener:bigBitmapInfoFilePath	Ljava/lang/String;
    //   25: ldc 80
    //   27: iconst_0
    //   28: invokestatic 84	com/tencent/qapmsdk/common/util/FileUtil:writeFile	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   31: pop
    //   32: getstatic 90	com/tencent/qapmsdk/base/reporter/uploaddata/FlushFile:INSTANCE	Lcom/tencent/qapmsdk/base/reporter/uploaddata/FlushFile;
    //   35: aload_0
    //   36: getfield 68	com/tencent/qapmsdk/bigbitmap/listener/BitmapExceedListener:bigBitmapInfoFilePath	Ljava/lang/String;
    //   39: aload_1
    //   40: invokevirtual 94	com/tencent/qapmsdk/base/reporter/uploaddata/FlushFile:flush	(Ljava/lang/String;Ljava/util/List;)V
    //   43: aload_2
    //   44: invokevirtual 98	java/io/File:length	()J
    //   47: lconst_0
    //   48: lcmp
    //   49: ifle +128 -> 177
    //   52: getstatic 103	com/tencent/qapmsdk/base/monitorplugin/PluginController:INSTANCE	Lcom/tencent/qapmsdk/base/monitorplugin/PluginController;
    //   55: getstatic 109	com/tencent/qapmsdk/base/config/PluginCombination:bigBitmapPlugin	Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;
    //   58: getfield 115	com/tencent/qapmsdk/base/config/DefaultPluginConfig:plugin	I
    //   61: invokevirtual 119	com/tencent/qapmsdk/base/monitorplugin/PluginController:canCollect	(I)Z
    //   64: ifeq +113 -> 177
    //   67: aload_2
    //   68: invokevirtual 123	java/io/File:getParentFile	()Ljava/io/File;
    //   71: invokevirtual 126	java/io/File:getParent	()Ljava/lang/String;
    //   74: astore_3
    //   75: new 24	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   82: invokestatic 131	com/tencent/qapmsdk/common/util/TimeUtil:getFormatDateMs	()Ljava/lang/String;
    //   85: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 133
    //   90: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: getfield 49	com/tencent/qapmsdk/bigbitmap/listener/BitmapExceedListener:bigBitmapDirName	Ljava/lang/String;
    //   97: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 135
    //   102: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: astore 4
    //   107: getstatic 139	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   110: getfield 144	com/tencent/qapmsdk/base/meta/UserMeta:version	Ljava/lang/String;
    //   113: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: ifeq +64 -> 180
    //   119: ldc 152
    //   121: astore_1
    //   122: new 51	java/io/File
    //   125: dup
    //   126: aload_3
    //   127: aload 4
    //   129: aload_1
    //   130: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 154
    //   135: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: astore_1
    //   145: aload_2
    //   146: invokevirtual 123	java/io/File:getParentFile	()Ljava/io/File;
    //   149: aload_1
    //   150: invokevirtual 158	java/io/File:renameTo	(Ljava/io/File;)Z
    //   153: ifeq +24 -> 177
    //   156: aload_0
    //   157: getfield 22	com/tencent/qapmsdk/bigbitmap/listener/BitmapExceedListener:reporter	Lcom/tencent/qapmsdk/common/reporter/IPluginReport;
    //   160: ifnull +17 -> 177
    //   163: aload_0
    //   164: getfield 22	com/tencent/qapmsdk/bigbitmap/listener/BitmapExceedListener:reporter	Lcom/tencent/qapmsdk/common/reporter/IPluginReport;
    //   167: aload_1
    //   168: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   171: invokeinterface 164 2 0
    //   176: pop
    //   177: aload_0
    //   178: monitorexit
    //   179: return
    //   180: getstatic 139	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   183: getfield 144	com/tencent/qapmsdk/base/meta/UserMeta:version	Ljava/lang/String;
    //   186: astore_1
    //   187: goto -65 -> 122
    //   190: astore_1
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_1
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	BitmapExceedListener
    //   0	195	1	paramList	java.util.List<com.tencent.qapmsdk.bigbitmap.datainfo.ExceedBitmapInfo>
    //   13	133	2	localFile	File
    //   74	53	3	str	String
    //   105	23	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	32	190	finally
    //   32	119	190	finally
    //   122	177	190	finally
    //   180	187	190	finally
  }
  
  public void setReporter(@Nullable IPluginReport paramIPluginReport)
  {
    try
    {
      this.reporter = paramIPluginReport;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.listener.BitmapExceedListener
 * JD-Core Version:    0.7.0.1
 */