import com.tencent.qphone.base.remote.ToServiceMsg;

public class sak
{
  private static sak jdField_a_of_type_Sak;
  private ToServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public static sak a()
  {
    if (jdField_a_of_type_Sak == null) {}
    try
    {
      if (jdField_a_of_type_Sak == null) {
        jdField_a_of_type_Sak = new sak();
      }
      return jdField_a_of_type_Sak;
    }
    finally {}
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 26	saj:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   6: ifne +14 -> 20
    //   9: ldc 28
    //   11: iconst_1
    //   12: ldc 30
    //   14: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: invokestatic 39	saj:a	()J
    //   23: lstore_2
    //   24: aload_0
    //   25: getfield 41	sak:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   28: ifnonnull +16 -> 44
    //   31: aload_0
    //   32: new 43	com/tencent/biz/pubaccount/readinjoy/weaknet/WeakNetManager$1
    //   35: dup
    //   36: aload_0
    //   37: lload_2
    //   38: invokespecial 46	com/tencent/biz/pubaccount/readinjoy/weaknet/WeakNetManager$1:<init>	(Lsak;J)V
    //   41: putfield 41	sak:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   44: invokestatic 52	onk:b	()Landroid/os/Handler;
    //   47: aload_0
    //   48: getfield 41	sak:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   51: invokevirtual 58	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   54: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +11 -> 68
    //   60: ldc 28
    //   62: iconst_2
    //   63: ldc 64
    //   65: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload_0
    //   69: aload_1
    //   70: putfield 16	sak:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   73: invokestatic 52	onk:b	()Landroid/os/Handler;
    //   76: aload_0
    //   77: getfield 41	sak:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   80: lload_2
    //   81: invokevirtual 68	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   84: pop
    //   85: ldc 28
    //   87: iconst_1
    //   88: iconst_2
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: ldc 70
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: lload_2
    //   100: invokestatic 76	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   103: aastore
    //   104: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   107: goto -90 -> 17
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	sak
    //   0	115	1	paramToServiceMsg	ToServiceMsg
    //   23	77	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	17	110	finally
    //   20	44	110	finally
    //   44	68	110	finally
    //   68	107	110	finally
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	sak:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   6: aload_1
    //   7: if_acmpne +29 -> 36
    //   10: invokestatic 52	onk:b	()Landroid/os/Handler;
    //   13: aload_0
    //   14: getfield 41	sak:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   17: invokevirtual 58	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 16	sak:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   25: ldc 28
    //   27: iconst_1
    //   28: ldc 81
    //   30: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: ldc 28
    //   38: iconst_1
    //   39: ldc 83
    //   41: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: goto -11 -> 33
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	sak
    //   0	52	1	paramToServiceMsg	ToServiceMsg
    // Exception table:
    //   from	to	target	type
    //   2	33	47	finally
    //   36	44	47	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sak
 * JD-Core Version:    0.7.0.1
 */