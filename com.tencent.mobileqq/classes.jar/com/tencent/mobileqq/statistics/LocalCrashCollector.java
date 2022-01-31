package com.tencent.mobileqq.statistics;

import android.os.Looper;
import bfmt;
import com.tencent.mobileqq.activity.BaseChatPie;
import mqq.os.MqqHandler;

public class LocalCrashCollector
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("");
  protected final MqqHandler a;
  
  public LocalCrashCollector(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), null, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 25	com/tencent/mobileqq/statistics/LocalCrashCollector:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   7: invokevirtual 53	java/lang/StringBuilder:length	()I
    //   10: ifle +19 -> 29
    //   13: aload_0
    //   14: getfield 25	com/tencent/mobileqq/statistics/LocalCrashCollector:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   17: iconst_0
    //   18: aload_0
    //   19: getfield 25	com/tencent/mobileqq/statistics/LocalCrashCollector:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   22: invokevirtual 53	java/lang/StringBuilder:length	()I
    //   25: invokevirtual 57	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: new 59	java/io/File
    //   32: dup
    //   33: ldc 61
    //   35: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_3
    //   39: aload_3
    //   40: invokevirtual 66	java/io/File:exists	()Z
    //   43: ifne +8 -> 51
    //   46: aload_3
    //   47: invokevirtual 69	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: aload_3
    //   52: new 71	axqh
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 74	axqh:<init>	(Lcom/tencent/mobileqq/statistics/LocalCrashCollector;)V
    //   60: invokevirtual 78	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   63: astore 8
    //   65: aload 8
    //   67: ifnull +9 -> 76
    //   70: aload 8
    //   72: arraylength
    //   73: ifgt +35 -> 108
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 44	com/tencent/mobileqq/statistics/LocalCrashCollector:jdField_a_of_type_Int	I
    //   81: aconst_null
    //   82: astore_3
    //   83: aload_3
    //   84: ifnull +7 -> 91
    //   87: aload_3
    //   88: invokevirtual 83	java/io/FileWriter:close	()V
    //   91: aload_0
    //   92: getfield 38	com/tencent/mobileqq/statistics/LocalCrashCollector:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   95: new 85	com/tencent/mobileqq/statistics/LocalCrashCollector$3
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 86	com/tencent/mobileqq/statistics/LocalCrashCollector$3:<init>	(Lcom/tencent/mobileqq/statistics/LocalCrashCollector;)V
    //   103: invokevirtual 92	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   106: pop
    //   107: return
    //   108: aload_0
    //   109: aload 8
    //   111: arraylength
    //   112: putfield 44	com/tencent/mobileqq/statistics/LocalCrashCollector:jdField_a_of_type_Int	I
    //   115: aload 8
    //   117: new 94	axqi
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 95	axqi:<init>	(Lcom/tencent/mobileqq/statistics/LocalCrashCollector;)V
    //   125: invokestatic 101	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   128: aload 8
    //   130: arraylength
    //   131: istore_2
    //   132: iconst_0
    //   133: istore_1
    //   134: aconst_null
    //   135: astore_3
    //   136: iload_1
    //   137: iload_2
    //   138: if_icmpge +180 -> 318
    //   141: aload 8
    //   143: iload_1
    //   144: aaload
    //   145: astore 6
    //   147: new 103	java/io/FileReader
    //   150: dup
    //   151: aload 6
    //   153: invokespecial 106	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   156: astore 4
    //   158: aload 4
    //   160: astore 5
    //   162: aload 6
    //   164: invokevirtual 109	java/io/File:length	()J
    //   167: l2i
    //   168: newarray char
    //   170: astore_3
    //   171: aload 4
    //   173: astore 5
    //   175: aload 4
    //   177: aload_3
    //   178: invokevirtual 113	java/io/FileReader:read	([C)I
    //   181: pop
    //   182: aload 4
    //   184: astore 5
    //   186: aload_3
    //   187: invokestatic 119	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   190: astore_3
    //   191: aload 4
    //   193: astore 5
    //   195: aload_0
    //   196: getfield 25	com/tencent/mobileqq/statistics/LocalCrashCollector:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   199: aload_3
    //   200: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 125
    //   205: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 4
    //   211: astore 5
    //   213: aload 4
    //   215: ifnull +12 -> 227
    //   218: aload 4
    //   220: invokevirtual 126	java/io/FileReader:close	()V
    //   223: aload 4
    //   225: astore 5
    //   227: iload_1
    //   228: iconst_1
    //   229: iadd
    //   230: istore_1
    //   231: aload 5
    //   233: astore_3
    //   234: goto -98 -> 136
    //   237: astore 6
    //   239: aload 4
    //   241: astore_3
    //   242: aload_3
    //   243: astore 5
    //   245: aload 6
    //   247: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   250: aload_3
    //   251: astore 5
    //   253: aload_3
    //   254: ifnull -27 -> 227
    //   257: aload_3
    //   258: invokevirtual 126	java/io/FileReader:close	()V
    //   261: aload_3
    //   262: astore 5
    //   264: goto -37 -> 227
    //   267: astore 4
    //   269: aload_3
    //   270: astore 5
    //   272: goto -45 -> 227
    //   275: astore 4
    //   277: aload 5
    //   279: astore_3
    //   280: aload_3
    //   281: ifnull +7 -> 288
    //   284: aload_3
    //   285: invokevirtual 126	java/io/FileReader:close	()V
    //   288: aload 4
    //   290: athrow
    //   291: astore 5
    //   293: aconst_null
    //   294: astore_3
    //   295: aload_3
    //   296: astore 4
    //   298: aload 5
    //   300: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   303: aload_3
    //   304: ifnull -213 -> 91
    //   307: aload_3
    //   308: invokevirtual 83	java/io/FileWriter:close	()V
    //   311: goto -220 -> 91
    //   314: astore_3
    //   315: goto -224 -> 91
    //   318: new 80	java/io/FileWriter
    //   321: dup
    //   322: ldc 131
    //   324: invokespecial 132	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   327: astore_3
    //   328: aload_3
    //   329: astore 4
    //   331: aload_3
    //   332: aload_0
    //   333: getfield 25	com/tencent/mobileqq/statistics/LocalCrashCollector:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   336: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokevirtual 139	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   342: aload_3
    //   343: astore 4
    //   345: aload_3
    //   346: invokevirtual 142	java/io/FileWriter:flush	()V
    //   349: goto -266 -> 83
    //   352: astore 5
    //   354: goto -59 -> 295
    //   357: astore_3
    //   358: aload 7
    //   360: astore 4
    //   362: aload 4
    //   364: ifnull +8 -> 372
    //   367: aload 4
    //   369: invokevirtual 83	java/io/FileWriter:close	()V
    //   372: aload_3
    //   373: athrow
    //   374: astore_3
    //   375: aload 4
    //   377: astore 5
    //   379: goto -152 -> 227
    //   382: astore_3
    //   383: goto -95 -> 288
    //   386: astore_3
    //   387: goto -296 -> 91
    //   390: astore 4
    //   392: goto -20 -> 372
    //   395: astore_3
    //   396: goto -34 -> 362
    //   399: astore 4
    //   401: goto -121 -> 280
    //   404: astore 6
    //   406: goto -164 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	LocalCrashCollector
    //   133	98	1	i	int
    //   131	8	2	j	int
    //   38	270	3	localObject1	Object
    //   314	1	3	localException1	java.lang.Exception
    //   327	19	3	localFileWriter	java.io.FileWriter
    //   357	16	3	localObject2	Object
    //   374	1	3	localException2	java.lang.Exception
    //   382	1	3	localException3	java.lang.Exception
    //   386	1	3	localException4	java.lang.Exception
    //   395	1	3	localObject3	Object
    //   156	84	4	localFileReader	java.io.FileReader
    //   267	1	4	localException5	java.lang.Exception
    //   275	14	4	localObject4	Object
    //   296	80	4	localObject5	Object
    //   390	1	4	localException6	java.lang.Exception
    //   399	1	4	localObject6	Object
    //   160	118	5	localObject7	Object
    //   291	8	5	localException7	java.lang.Exception
    //   352	1	5	localException8	java.lang.Exception
    //   377	1	5	localObject8	Object
    //   145	18	6	localFile	java.io.File
    //   237	9	6	localException9	java.lang.Exception
    //   404	1	6	localException10	java.lang.Exception
    //   1	358	7	localObject9	Object
    //   63	79	8	arrayOfFile	java.io.File[]
    // Exception table:
    //   from	to	target	type
    //   162	171	237	java/lang/Exception
    //   175	182	237	java/lang/Exception
    //   186	191	237	java/lang/Exception
    //   195	209	237	java/lang/Exception
    //   257	261	267	java/lang/Exception
    //   162	171	275	finally
    //   175	182	275	finally
    //   186	191	275	finally
    //   195	209	275	finally
    //   245	250	275	finally
    //   3	29	291	java/lang/Exception
    //   29	51	291	java/lang/Exception
    //   51	65	291	java/lang/Exception
    //   70	76	291	java/lang/Exception
    //   76	81	291	java/lang/Exception
    //   108	132	291	java/lang/Exception
    //   288	291	291	java/lang/Exception
    //   318	328	291	java/lang/Exception
    //   307	311	314	java/lang/Exception
    //   331	342	352	java/lang/Exception
    //   345	349	352	java/lang/Exception
    //   3	29	357	finally
    //   29	51	357	finally
    //   51	65	357	finally
    //   70	76	357	finally
    //   76	81	357	finally
    //   108	132	357	finally
    //   218	223	357	finally
    //   257	261	357	finally
    //   284	288	357	finally
    //   288	291	357	finally
    //   318	328	357	finally
    //   218	223	374	java/lang/Exception
    //   284	288	382	java/lang/Exception
    //   87	91	386	java/lang/Exception
    //   367	372	390	java/lang/Exception
    //   298	303	395	finally
    //   331	342	395	finally
    //   345	349	395	finally
    //   147	158	399	finally
    //   147	158	404	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector
 * JD-Core Version:    0.7.0.1
 */