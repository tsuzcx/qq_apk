package com.tencent.mobileqq.magicface.model;

import atyq;

public class MagicfaceXBigDecoder$2
  implements Runnable
{
  public MagicfaceXBigDecoder$2(atyq paramatyq) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   4: getfield 25	atyq:jdField_a_of_type_Boolean	Z
    //   7: ifeq +210 -> 217
    //   10: aload_0
    //   11: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   14: iconst_0
    //   15: putfield 28	atyq:jdField_b_of_type_Boolean	Z
    //   18: aload_0
    //   19: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   22: aload_0
    //   23: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   26: getfield 32	atyq:d	[B
    //   29: aload_0
    //   30: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   33: getfield 36	atyq:h	I
    //   36: invokevirtual 39	atyq:a	([BI)I
    //   39: istore_1
    //   40: aload_0
    //   41: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   44: iload_1
    //   45: aload_0
    //   46: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   49: getfield 36	atyq:h	I
    //   52: isub
    //   53: putfield 42	atyq:g	I
    //   56: aload_0
    //   57: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   60: getfield 42	atyq:g	I
    //   63: ifge +4 -> 67
    //   66: return
    //   67: aload_0
    //   68: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   71: aload_0
    //   72: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   75: getfield 42	atyq:g	I
    //   78: aload_0
    //   79: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   82: getfield 36	atyq:h	I
    //   85: aload_0
    //   86: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   89: getfield 32	atyq:d	[B
    //   92: invokevirtual 45	atyq:b	(II[B)V
    //   95: aload_0
    //   96: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   99: iload_1
    //   100: putfield 36	atyq:h	I
    //   103: aload_0
    //   104: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   107: getfield 48	atyq:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   110: aload_0
    //   111: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   114: getfield 51	atyq:e	[B
    //   117: aload_0
    //   118: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   121: getfield 42	atyq:g	I
    //   124: aload_0
    //   125: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   128: getfield 54	atyq:f	[B
    //   131: invokevirtual 60	com/tencent/mobileqq/magicface/DecoderUtil:decodeAlphaDecoder	([BI[B)I
    //   134: pop
    //   135: aload_0
    //   136: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   139: iconst_1
    //   140: putfield 28	atyq:jdField_b_of_type_Boolean	Z
    //   143: aload_0
    //   144: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   147: getfield 63	atyq:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   150: astore_2
    //   151: aload_2
    //   152: monitorenter
    //   153: aload_0
    //   154: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   157: getfield 63	atyq:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   160: invokevirtual 66	java/lang/Object:notify	()V
    //   163: aload_2
    //   164: monitorexit
    //   165: aload_0
    //   166: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   169: getfield 68	atyq:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   172: astore_2
    //   173: aload_2
    //   174: monitorenter
    //   175: aload_0
    //   176: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$2:this$0	Latyq;
    //   179: getfield 68	atyq:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   182: invokevirtual 71	java/lang/Object:wait	()V
    //   185: aload_2
    //   186: monitorexit
    //   187: goto -187 -> 0
    //   190: astore_3
    //   191: aload_2
    //   192: monitorexit
    //   193: aload_3
    //   194: athrow
    //   195: astore_2
    //   196: goto -196 -> 0
    //   199: astore_3
    //   200: aload_2
    //   201: monitorexit
    //   202: aload_3
    //   203: athrow
    //   204: astore_2
    //   205: goto -40 -> 165
    //   208: astore_2
    //   209: aload_2
    //   210: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   213: return
    //   214: astore_2
    //   215: aload_2
    //   216: athrow
    //   217: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	2
    //   39	61	1	i	int
    //   195	6	2	localException1	java.lang.Exception
    //   204	1	2	localException2	java.lang.Exception
    //   208	2	2	localException3	java.lang.Exception
    //   214	2	2	localObject2	Object
    //   190	4	3	localObject3	Object
    //   199	4	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   175	187	190	finally
    //   191	193	190	finally
    //   165	175	195	java/lang/Exception
    //   193	195	195	java/lang/Exception
    //   153	165	199	finally
    //   200	202	199	finally
    //   143	153	204	java/lang/Exception
    //   202	204	204	java/lang/Exception
    //   0	66	208	java/lang/Exception
    //   67	143	208	java/lang/Exception
    //   0	66	214	finally
    //   67	143	214	finally
    //   143	153	214	finally
    //   165	175	214	finally
    //   193	195	214	finally
    //   202	204	214	finally
    //   209	213	214	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder.2
 * JD-Core Version:    0.7.0.1
 */