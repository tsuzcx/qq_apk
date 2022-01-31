package com.tencent.mobileqq.emosm;

import apmi;
import java.util.List;

public class CustomEmotionRoamingDBManagerBase$1
  implements Runnable
{
  public CustomEmotionRoamingDBManagerBase$1(apmi paramapmi, List paramList, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 15	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:this$0	Lapmi;
    //   6: getfield 31	apmi:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: getfield 15	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:this$0	Lapmi;
    //   17: getfield 31	apmi:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 37	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawgg;
    //   23: invokevirtual 43	awgg:createEntityManager	()Lawgf;
    //   26: astore 7
    //   28: aload 7
    //   30: ifnull -18 -> 12
    //   33: aload 7
    //   35: invokevirtual 48	awgf:a	()Lawgh;
    //   38: astore 5
    //   40: aload 5
    //   42: astore 4
    //   44: aload 5
    //   46: invokevirtual 52	awgh:a	()V
    //   49: iconst_0
    //   50: istore_2
    //   51: aload 5
    //   53: astore 4
    //   55: iload_1
    //   56: aload_0
    //   57: getfield 17	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   60: invokeinterface 58 1 0
    //   65: if_icmpge +164 -> 229
    //   68: aload 5
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 17	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   76: iload_1
    //   77: invokeinterface 62 2 0
    //   82: checkcast 64	com/tencent/mobileqq/data/CustomEmotionBase
    //   85: astore 6
    //   87: aload 5
    //   89: astore 4
    //   91: aload_0
    //   92: getfield 19	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:jdField_a_of_type_Int	I
    //   95: tableswitch	default:+298 -> 393, 1:+74->169, 2:+100->195, 3:+29->124, 4:+117->212
    //   125: iconst_2
    //   126: astore 4
    //   128: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +265 -> 396
    //   134: aload 5
    //   136: astore 4
    //   138: ldc 72
    //   140: iconst_2
    //   141: new 74	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   148: ldc 77
    //   150: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: getfield 19	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:jdField_a_of_type_Int	I
    //   157: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: goto +230 -> 396
    //   169: aload 5
    //   171: astore 4
    //   173: aload 6
    //   175: sipush 1000
    //   178: invokevirtual 96	com/tencent/mobileqq/data/CustomEmotionBase:setStatus	(I)V
    //   181: aload 5
    //   183: astore 4
    //   185: aload 7
    //   187: aload 6
    //   189: invokevirtual 99	awgf:a	(Lawge;)V
    //   192: goto +204 -> 396
    //   195: aload 5
    //   197: astore 4
    //   199: aload 7
    //   201: aload 6
    //   203: invokevirtual 102	awgf:a	(Lawge;)Z
    //   206: istore_3
    //   207: iload_3
    //   208: istore_2
    //   209: goto +187 -> 396
    //   212: aload 5
    //   214: astore 4
    //   216: aload 7
    //   218: aload 6
    //   220: invokevirtual 105	awgf:b	(Lawge;)Z
    //   223: istore_3
    //   224: iload_3
    //   225: istore_2
    //   226: goto +170 -> 396
    //   229: aload 5
    //   231: astore 4
    //   233: aload 5
    //   235: invokevirtual 108	awgh:c	()V
    //   238: aload 5
    //   240: ifnull +8 -> 248
    //   243: aload 5
    //   245: invokevirtual 110	awgh:b	()V
    //   248: aload 7
    //   250: invokevirtual 111	awgf:a	()V
    //   253: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq -244 -> 12
    //   259: ldc 72
    //   261: iconst_2
    //   262: new 74	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   269: ldc 113
    //   271: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_0
    //   275: getfield 19	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:jdField_a_of_type_Int	I
    //   278: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: ldc 115
    //   283: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_0
    //   287: getfield 17	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   290: invokeinterface 58 1 0
    //   295: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: ldc 117
    //   300: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload_2
    //   304: invokevirtual 120	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   307: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: return
    //   314: astore 6
    //   316: aconst_null
    //   317: astore 5
    //   319: iconst_0
    //   320: istore_2
    //   321: aload 5
    //   323: astore 4
    //   325: ldc 72
    //   327: iconst_1
    //   328: ldc 122
    //   330: aload 6
    //   332: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   335: aload 5
    //   337: ifnull +8 -> 345
    //   340: aload 5
    //   342: invokevirtual 110	awgh:b	()V
    //   345: aload 7
    //   347: invokevirtual 111	awgf:a	()V
    //   350: goto -97 -> 253
    //   353: astore 5
    //   355: aconst_null
    //   356: astore 4
    //   358: aload 4
    //   360: ifnull +8 -> 368
    //   363: aload 4
    //   365: invokevirtual 110	awgh:b	()V
    //   368: aload 7
    //   370: invokevirtual 111	awgf:a	()V
    //   373: aload 5
    //   375: athrow
    //   376: astore 5
    //   378: goto -20 -> 358
    //   381: astore 6
    //   383: iconst_0
    //   384: istore_2
    //   385: goto -64 -> 321
    //   388: astore 6
    //   390: goto -69 -> 321
    //   393: goto -269 -> 124
    //   396: iload_1
    //   397: iconst_1
    //   398: iadd
    //   399: istore_1
    //   400: goto -349 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	1
    //   1	399	1	i	int
    //   50	335	2	bool1	boolean
    //   206	19	3	bool2	boolean
    //   42	322	4	localawgh1	awgh
    //   38	303	5	localawgh2	awgh
    //   353	21	5	localObject1	Object
    //   376	1	5	localObject2	Object
    //   85	134	6	localCustomEmotionBase	com.tencent.mobileqq.data.CustomEmotionBase
    //   314	17	6	localException1	java.lang.Exception
    //   381	1	6	localException2	java.lang.Exception
    //   388	1	6	localException3	java.lang.Exception
    //   26	343	7	localawgf	awgf
    // Exception table:
    //   from	to	target	type
    //   33	40	314	java/lang/Exception
    //   33	40	353	finally
    //   44	49	376	finally
    //   55	68	376	finally
    //   72	87	376	finally
    //   91	124	376	finally
    //   128	134	376	finally
    //   138	166	376	finally
    //   173	181	376	finally
    //   185	192	376	finally
    //   199	207	376	finally
    //   216	224	376	finally
    //   233	238	376	finally
    //   325	335	376	finally
    //   44	49	381	java/lang/Exception
    //   55	68	388	java/lang/Exception
    //   72	87	388	java/lang/Exception
    //   91	124	388	java/lang/Exception
    //   128	134	388	java/lang/Exception
    //   138	166	388	java/lang/Exception
    //   173	181	388	java/lang/Exception
    //   185	192	388	java/lang/Exception
    //   199	207	388	java/lang/Exception
    //   216	224	388	java/lang/Exception
    //   233	238	388	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.1
 * JD-Core Version:    0.7.0.1
 */