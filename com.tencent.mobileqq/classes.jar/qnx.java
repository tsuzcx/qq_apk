import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;

public class qnx
  implements INetEngine.INetEngineListener
{
  public qnx(GameCenterCheck paramGameCenterCheck) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  /* Error */
  public void a(com.tencent.mobileqq.transfile.NetResp paramNetResp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_1
    //   6: ifnonnull +8 -> 14
    //   9: aconst_null
    //   10: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   13: return
    //   14: aload 4
    //   16: astore_2
    //   17: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +69 -> 89
    //   23: aload 4
    //   25: astore_2
    //   26: ldc 34
    //   28: new 36	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   35: ldc 39
    //   37: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: getfield 49	com/tencent/mobileqq/transfile/NetResp:c	I
    //   44: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 54
    //   49: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_1
    //   53: getfield 57	com/tencent/mobileqq/transfile/NetResp:b	I
    //   56: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: ldc 59
    //   61: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: getfield 61	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   68: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc 63
    //   73: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: getfield 66	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   80: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 75	com/tencent/open/wadl/WLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 4
    //   91: astore_2
    //   92: aload_1
    //   93: getfield 78	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   96: getfield 83	com/tencent/mobileqq/transfile/NetReq:a	Ljava/io/OutputStream;
    //   99: instanceof 85
    //   102: ifeq +109 -> 211
    //   105: aload 4
    //   107: astore_2
    //   108: aload_1
    //   109: getfield 78	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   112: getfield 83	com/tencent/mobileqq/transfile/NetReq:a	Ljava/io/OutputStream;
    //   115: checkcast 85	com/tencent/mobileqq/utils/PoolingByteArrayOutputStream
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 86	com/tencent/mobileqq/utils/PoolingByteArrayOutputStream:toString	()Ljava/lang/String;
    //   123: astore_2
    //   124: aload_0
    //   125: getfield 12	qnx:a	Lcom/tencent/gamecenter/appointment/GameCenterCheck;
    //   128: aload_2
    //   129: invokevirtual 91	com/tencent/gamecenter/appointment/GameCenterCheck:a	(Ljava/lang/String;)V
    //   132: ldc 93
    //   134: invokestatic 98	com/tencent/gamecenter/appointment/GameCenterUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   137: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   140: ifeq +25 -> 165
    //   143: ldc 106
    //   145: invokestatic 98	com/tencent/gamecenter/appointment/GameCenterUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   148: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   151: ifeq +14 -> 165
    //   154: ldc 108
    //   156: invokestatic 98	com/tencent/gamecenter/appointment/GameCenterUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifne +6 -> 168
    //   165: invokestatic 112	com/tencent/gamecenter/appointment/GameCenterBroadcastReceiver:a	()V
    //   168: invokestatic 114	com/tencent/gamecenter/appointment/GameCenterCheck:b	()V
    //   171: aload_1
    //   172: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   175: return
    //   176: astore_2
    //   177: aload_3
    //   178: astore_1
    //   179: aload_2
    //   180: astore_3
    //   181: aload_1
    //   182: astore_2
    //   183: aload_3
    //   184: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   187: aload_1
    //   188: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   191: return
    //   192: astore_3
    //   193: aload_2
    //   194: astore_1
    //   195: aload_3
    //   196: astore_2
    //   197: aload_1
    //   198: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   201: aload_2
    //   202: athrow
    //   203: astore_2
    //   204: goto -7 -> 197
    //   207: astore_3
    //   208: goto -27 -> 181
    //   211: aconst_null
    //   212: astore_1
    //   213: goto -42 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	qnx
    //   0	216	1	paramNetResp	com.tencent.mobileqq.transfile.NetResp
    //   16	113	2	localObject1	Object
    //   176	4	2	localException1	java.lang.Exception
    //   182	20	2	localObject2	Object
    //   203	1	2	localObject3	Object
    //   4	180	3	localObject4	Object
    //   192	4	3	localObject5	Object
    //   207	1	3	localException2	java.lang.Exception
    //   1	105	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   17	23	176	java/lang/Exception
    //   26	89	176	java/lang/Exception
    //   92	105	176	java/lang/Exception
    //   108	119	176	java/lang/Exception
    //   17	23	192	finally
    //   26	89	192	finally
    //   92	105	192	finally
    //   108	119	192	finally
    //   183	187	192	finally
    //   119	165	203	finally
    //   165	168	203	finally
    //   168	171	203	finally
    //   119	165	207	java/lang/Exception
    //   165	168	207	java/lang/Exception
    //   168	171	207	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qnx
 * JD-Core Version:    0.7.0.1
 */