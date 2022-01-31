import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;

public final class qjh
  implements INetEngine.INetEngineListener
{
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
    //   10: invokestatic 22	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   13: return
    //   14: aload 4
    //   16: astore_2
    //   17: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +70 -> 90
    //   23: aload 4
    //   25: astore_2
    //   26: getstatic 33	com/tencent/gamecenter/appointment/GameCenterUtils:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: new 35	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   36: ldc 38
    //   38: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: getfield 48	com/tencent/mobileqq/transfile/NetResp:c	I
    //   45: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc 53
    //   50: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: getfield 56	com/tencent/mobileqq/transfile/NetResp:b	I
    //   57: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc 58
    //   62: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: getfield 60	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   69: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 62
    //   74: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: getfield 63	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   81: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 72	com/tencent/open/wadl/WLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload 4
    //   92: astore_2
    //   93: aload_1
    //   94: getfield 75	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   97: getfield 80	com/tencent/mobileqq/transfile/NetReq:a	Ljava/io/OutputStream;
    //   100: instanceof 82
    //   103: ifeq +97 -> 200
    //   106: aload 4
    //   108: astore_2
    //   109: aload_1
    //   110: getfield 75	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   113: getfield 80	com/tencent/mobileqq/transfile/NetReq:a	Ljava/io/OutputStream;
    //   116: checkcast 82	com/tencent/mobileqq/utils/PoolingByteArrayOutputStream
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 83	com/tencent/mobileqq/utils/PoolingByteArrayOutputStream:toString	()Ljava/lang/String;
    //   124: astore_3
    //   125: aload_1
    //   126: astore_2
    //   127: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +30 -> 160
    //   133: getstatic 33	com/tencent/gamecenter/appointment/GameCenterUtils:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   136: new 35	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   143: ldc 85
    //   145: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_3
    //   149: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 72	com/tencent/open/wadl/WLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_1
    //   159: astore_2
    //   160: aload_2
    //   161: invokestatic 22	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   164: return
    //   165: astore_2
    //   166: aload_3
    //   167: astore_1
    //   168: aload_2
    //   169: astore_3
    //   170: aload_1
    //   171: astore_2
    //   172: aload_3
    //   173: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   176: aload_1
    //   177: invokestatic 22	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   180: return
    //   181: astore_3
    //   182: aload_2
    //   183: astore_1
    //   184: aload_3
    //   185: astore_2
    //   186: aload_1
    //   187: invokestatic 22	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   190: aload_2
    //   191: athrow
    //   192: astore_2
    //   193: goto -7 -> 186
    //   196: astore_3
    //   197: goto -27 -> 170
    //   200: aconst_null
    //   201: astore_2
    //   202: goto -42 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	qjh
    //   0	205	1	paramNetResp	com.tencent.mobileqq.transfile.NetResp
    //   16	145	2	localObject1	Object
    //   165	4	2	localException1	java.lang.Exception
    //   171	20	2	localObject2	Object
    //   192	1	2	localObject3	Object
    //   201	1	2	localObject4	Object
    //   4	169	3	localObject5	Object
    //   181	4	3	localObject6	Object
    //   196	1	3	localException2	java.lang.Exception
    //   1	106	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   17	23	165	java/lang/Exception
    //   26	90	165	java/lang/Exception
    //   93	106	165	java/lang/Exception
    //   109	120	165	java/lang/Exception
    //   17	23	181	finally
    //   26	90	181	finally
    //   93	106	181	finally
    //   109	120	181	finally
    //   172	176	181	finally
    //   120	125	192	finally
    //   127	158	192	finally
    //   120	125	196	java/lang/Exception
    //   127	158	196	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qjh
 * JD-Core Version:    0.7.0.1
 */