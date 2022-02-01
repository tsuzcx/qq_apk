package com.tencent.rmonitor.resource.runnable;

import java.io.File;
import java.util.List;

public class ReportDumpFileTask
{
  private final List<File> a;
  
  public ReportDumpFileTask(List<File> paramList)
  {
    this.a = paramList;
  }
  
  public File a()
  {
    Object localObject = null;
    while (!this.a.isEmpty())
    {
      File localFile = (File)this.a.remove(0);
      localObject = localFile;
      if (localFile != null)
      {
        localObject = localFile;
        if (localFile.exists()) {
          localObject = localFile;
        }
      }
    }
    return localObject;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 38	com/tencent/rmonitor/resource/runnable/ReportDumpFileTask:a	()Ljava/io/File;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +24 -> 30
    //   9: getstatic 43	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   12: iconst_2
    //   13: anewarray 45	java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: ldc 47
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc 49
    //   25: aastore
    //   26: invokevirtual 53	com/tencent/rmonitor/common/logger/Logger:i	([Ljava/lang/String;)V
    //   29: return
    //   30: new 55	com/tencent/rmonitor/base/reporter/data/ReportData
    //   33: dup
    //   34: iconst_0
    //   35: ldc 57
    //   37: iconst_1
    //   38: lconst_1
    //   39: lconst_1
    //   40: new 59	org/json/JSONObject
    //   43: dup
    //   44: aload_2
    //   45: invokevirtual 63	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: invokestatic 69	com/tencent/rmonitor/common/util/FileUtil:d	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   54: iconst_1
    //   55: iconst_0
    //   56: getstatic 78	com/tencent/rmonitor/base/meta/BaseInfo:userMeta	Lcom/tencent/rmonitor/base/meta/UserMeta;
    //   59: getfield 84	com/tencent/rmonitor/base/meta/UserMeta:uin	Ljava/lang/String;
    //   62: invokespecial 87	com/tencent/rmonitor/base/reporter/data/ReportData:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZLjava/lang/String;)V
    //   65: astore_3
    //   66: aload_3
    //   67: invokevirtual 91	com/tencent/rmonitor/base/reporter/data/ReportData:getPlugin	()I
    //   70: istore_1
    //   71: getstatic 96	com/tencent/rmonitor/base/plugin/monitor/PluginController:b	Lcom/tencent/rmonitor/base/plugin/monitor/PluginController;
    //   74: iload_1
    //   75: invokevirtual 99	com/tencent/rmonitor/base/plugin/monitor/PluginController:d	(I)Z
    //   78: ifeq +18 -> 96
    //   81: getstatic 104	com/tencent/rmonitor/base/reporter/ReporterMachine:a	Lcom/tencent/rmonitor/base/reporter/ReporterMachine;
    //   84: aload_3
    //   85: new 106	com/tencent/rmonitor/resource/runnable/ReportDumpFileTask$1
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 109	com/tencent/rmonitor/resource/runnable/ReportDumpFileTask$1:<init>	(Lcom/tencent/rmonitor/resource/runnable/ReportDumpFileTask;)V
    //   93: invokevirtual 112	com/tencent/rmonitor/base/reporter/ReporterMachine:b	(Lcom/tencent/rmonitor/base/reporter/data/ReportData;Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;)V
    //   96: aload_2
    //   97: invokevirtual 115	java/io/File:delete	()Z
    //   100: ifne +190 -> 290
    //   103: getstatic 43	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   106: astore_3
    //   107: new 117	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   114: astore 4
    //   116: aload 4
    //   118: ldc 120
    //   120: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 4
    //   126: aload_2
    //   127: invokevirtual 63	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   130: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 4
    //   136: ldc 126
    //   138: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_3
    //   143: iconst_2
    //   144: anewarray 45	java/lang/String
    //   147: dup
    //   148: iconst_0
    //   149: ldc 47
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: aload 4
    //   156: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: aastore
    //   160: invokevirtual 132	com/tencent/rmonitor/common/logger/Logger:e	([Ljava/lang/String;)V
    //   163: return
    //   164: astore_3
    //   165: goto +126 -> 291
    //   168: astore_3
    //   169: getstatic 43	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   172: astore 4
    //   174: new 117	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   181: astore 5
    //   183: aload 5
    //   185: ldc 134
    //   187: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 5
    //   193: aload_0
    //   194: getfield 14	com/tencent/rmonitor/resource/runnable/ReportDumpFileTask:a	Ljava/util/List;
    //   197: invokeinterface 137 1 0
    //   202: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 4
    //   208: ldc 47
    //   210: aload 5
    //   212: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: aload_3
    //   216: invokevirtual 143	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload_0
    //   220: invokevirtual 145	com/tencent/rmonitor/resource/runnable/ReportDumpFileTask:b	()V
    //   223: aload_2
    //   224: invokevirtual 115	java/io/File:delete	()Z
    //   227: ifne +63 -> 290
    //   230: getstatic 43	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   233: astore_3
    //   234: new 117	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   241: astore 4
    //   243: aload 4
    //   245: ldc 120
    //   247: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: aload_2
    //   254: invokevirtual 63	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   257: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 4
    //   263: ldc 126
    //   265: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_3
    //   270: iconst_2
    //   271: anewarray 45	java/lang/String
    //   274: dup
    //   275: iconst_0
    //   276: ldc 47
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: aload 4
    //   283: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: aastore
    //   287: invokevirtual 132	com/tencent/rmonitor/common/logger/Logger:e	([Ljava/lang/String;)V
    //   290: return
    //   291: aload_2
    //   292: invokevirtual 115	java/io/File:delete	()Z
    //   295: ifne +65 -> 360
    //   298: getstatic 43	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   301: astore 4
    //   303: new 117	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   310: astore 5
    //   312: aload 5
    //   314: ldc 120
    //   316: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 5
    //   322: aload_2
    //   323: invokevirtual 63	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   326: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 5
    //   332: ldc 126
    //   334: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 4
    //   340: iconst_2
    //   341: anewarray 45	java/lang/String
    //   344: dup
    //   345: iconst_0
    //   346: ldc 47
    //   348: aastore
    //   349: dup
    //   350: iconst_1
    //   351: aload 5
    //   353: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: aastore
    //   357: invokevirtual 132	com/tencent/rmonitor/common/logger/Logger:e	([Ljava/lang/String;)V
    //   360: aload_3
    //   361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	ReportDumpFileTask
    //   70	5	1	i	int
    //   4	319	2	localFile	File
    //   65	78	3	localObject1	Object
    //   164	1	3	localObject2	Object
    //   168	48	3	localException	java.lang.Exception
    //   233	128	3	localLogger	com.tencent.rmonitor.common.logger.Logger
    //   114	225	4	localObject3	Object
    //   181	171	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   30	96	164	finally
    //   169	223	164	finally
    //   30	96	168	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.runnable.ReportDumpFileTask
 * JD-Core Version:    0.7.0.1
 */