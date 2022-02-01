package com.tencent.mobileqq.magicface;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import java.util.concurrent.CountDownLatch;

class DecoderUtil$1
  implements OnLoadListener
{
  DecoderUtil$1(DecoderUtil paramDecoderUtil, CountDownLatch paramCountDownLatch) {}
  
  /* Error */
  public void onLoadResult(int paramInt, com.tencent.mobileqq.soload.biz.entity.LoadExtResult paramLoadExtResult)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +35 -> 36
    //   4: aload_2
    //   5: invokevirtual 29	com/tencent/mobileqq/soload/biz/entity/LoadExtResult:isSucc	()Z
    //   8: ifne +6 -> 14
    //   11: goto +25 -> 36
    //   14: aload_2
    //   15: ldc 31
    //   17: invokevirtual 35	com/tencent/mobileqq/soload/biz/entity/LoadExtResult:getSoLoadPath	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_2
    //   21: aload_2
    //   22: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +38 -> 63
    //   28: aload_2
    //   29: invokestatic 46	com/tencent/mobileqq/magicface/DecoderUtil:access$002	(Ljava/lang/String;)Ljava/lang/String;
    //   32: pop
    //   33: goto +30 -> 63
    //   36: ldc 48
    //   38: iconst_2
    //   39: ldc 50
    //   41: invokestatic 56	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: getfield 15	com/tencent/mobileqq/magicface/DecoderUtil$1:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   48: invokevirtual 61	java/util/concurrent/CountDownLatch:countDown	()V
    //   51: return
    //   52: ldc 48
    //   54: iconst_1
    //   55: aload_2
    //   56: iconst_0
    //   57: anewarray 4	java/lang/Object
    //   60: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   63: aload_0
    //   64: getfield 15	com/tencent/mobileqq/magicface/DecoderUtil$1:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   67: invokevirtual 61	java/util/concurrent/CountDownLatch:countDown	()V
    //   70: return
    //   71: aload_0
    //   72: getfield 15	com/tencent/mobileqq/magicface/DecoderUtil$1:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   75: invokevirtual 61	java/util/concurrent/CountDownLatch:countDown	()V
    //   78: aload_2
    //   79: athrow
    //   80: astore_2
    //   81: goto -10 -> 71
    //   84: astore_2
    //   85: goto -33 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	1
    //   0	88	1	paramInt	int
    //   0	88	2	paramLoadExtResult	com.tencent.mobileqq.soload.biz.entity.LoadExtResult
    // Exception table:
    //   from	to	target	type
    //   4	11	80	finally
    //   14	33	80	finally
    //   36	44	80	finally
    //   52	63	80	finally
    //   4	11	84	java/lang/Exception
    //   14	33	84	java/lang/Exception
    //   36	44	84	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.DecoderUtil.1
 * JD-Core Version:    0.7.0.1
 */