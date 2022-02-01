package com.tencent.mobileqq.kandian.base.utils;

final class KandianUGStatisticUtils$1
  implements Runnable
{
  KandianUGStatisticUtils$1(String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 21	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: getfield 12	com/tencent/mobileqq/kandian/base/utils/KandianUGStatisticUtils$1:a	Ljava/lang/String;
    //   13: invokespecial 23	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 27	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 29	java/net/HttpURLConnection
    //   22: astore_2
    //   23: aload_2
    //   24: ldc 31
    //   26: invokevirtual 34	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   29: aload_2
    //   30: invokevirtual 38	java/net/HttpURLConnection:getResponseCode	()I
    //   33: pop
    //   34: aload_2
    //   35: ifnull +44 -> 79
    //   38: aload_2
    //   39: invokevirtual 41	java/net/HttpURLConnection:disconnect	()V
    //   42: return
    //   43: astore_1
    //   44: goto +36 -> 80
    //   47: astore_1
    //   48: aload_1
    //   49: astore_3
    //   50: goto +15 -> 65
    //   53: astore_3
    //   54: aload_1
    //   55: astore_2
    //   56: aload_3
    //   57: astore_1
    //   58: goto +22 -> 80
    //   61: astore_3
    //   62: aload 4
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: aload_3
    //   68: invokevirtual 44	java/lang/Exception:printStackTrace	()V
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 41	java/net/HttpURLConnection:disconnect	()V
    //   79: return
    //   80: aload_2
    //   81: ifnull +7 -> 88
    //   84: aload_2
    //   85: invokevirtual 41	java/net/HttpURLConnection:disconnect	()V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	1
    //   4	1	1	localObject1	Object
    //   43	1	1	localObject2	Object
    //   47	8	1	localException1	java.lang.Exception
    //   57	32	1	localObject3	Object
    //   22	63	2	localObject4	Object
    //   49	1	3	localException2	java.lang.Exception
    //   53	4	3	localObject5	Object
    //   61	7	3	localException3	java.lang.Exception
    //   1	62	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   23	34	43	finally
    //   23	34	47	java/lang/Exception
    //   5	23	53	finally
    //   67	71	53	finally
    //   5	23	61	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils.1
 * JD-Core Version:    0.7.0.1
 */