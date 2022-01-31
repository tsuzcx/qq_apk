package com.tencent.mobileqq.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SendMessageHandler
  extends Handler
{
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile int jdField_a_of_type_Int;
  public long a;
  public final String a;
  private List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private volatile int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = System.currentTimeMillis();
  public final String b;
  public final String c = "server";
  
  public SendMessageHandler()
  {
    super(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangString = "period";
    this.jdField_b_of_type_JavaLangString = "msf";
  }
  
  public long a(long paramLong)
  {
    try
    {
      long l = this.jdField_b_of_type_Long;
      return paramLong - l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.SendMessageHandler", 2, "stopAndRemoveRunnalbes");
      }
      removeCallbacksAndMessages(null);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      return;
    }
    finally {}
  }
  
  public void a(SendMessageHandler.SendMessageRunnable paramSendMessageRunnable)
  {
    try
    {
      paramSendMessageRunnable.f = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_JavaUtilList.add(paramSendMessageRunnable);
      return;
    }
    finally
    {
      paramSendMessageRunnable = finally;
      throw paramSendMessageRunnable;
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_1
    //   4: iload_1
    //   5: aload_0
    //   6: getfield 92	com/tencent/mobileqq/utils/SendMessageHandler:jdField_b_of_type_Int	I
    //   9: if_icmpge +37 -> 46
    //   12: aload_0
    //   13: getfield 62	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   16: iload_1
    //   17: invokeinterface 106 2 0
    //   22: checkcast 95	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable
    //   25: getfield 109	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:c	Z
    //   28: istore_2
    //   29: iload_2
    //   30: ifne +9 -> 39
    //   33: iconst_0
    //   34: istore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_2
    //   38: ireturn
    //   39: iload_1
    //   40: iconst_1
    //   41: iadd
    //   42: istore_1
    //   43: goto -39 -> 4
    //   46: iconst_1
    //   47: istore_2
    //   48: goto -13 -> 35
    //   51: astore_3
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_3
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	SendMessageHandler
    //   3	40	1	i	int
    //   28	20	2	bool	boolean
    //   51	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	29	51	finally
  }
  
  /* Error */
  public boolean a(int paramInt, long paramLong1, long paramLong2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 65	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_Int	I
    //   7: if_icmpge +134 -> 141
    //   10: aload_0
    //   11: getfield 62	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   14: iload_1
    //   15: invokeinterface 106 2 0
    //   20: checkcast 95	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable
    //   23: astore 8
    //   25: aload 8
    //   27: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   30: putfield 113	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:h	J
    //   33: aload 8
    //   35: lload_2
    //   36: putfield 115	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:d	J
    //   39: aload 8
    //   41: lload 4
    //   43: putfield 118	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:e	J
    //   46: aload 8
    //   48: iconst_1
    //   49: putfield 109	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:c	Z
    //   52: aload 8
    //   54: aload 6
    //   56: putfield 121	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:a	[Ljava/lang/String;
    //   59: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +71 -> 133
    //   65: ldc 123
    //   67: iconst_2
    //   68: new 125	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   75: ldc 128
    //   77: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 134	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_Long	J
    //   84: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: ldc 139
    //   89: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload_1
    //   93: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc 144
    //   98: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: lload_2
    //   102: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   105: ldc 146
    //   107: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: lload 4
    //   112: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   115: ldc 148
    //   117: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: invokevirtual 152	com/tencent/mobileqq/utils/SendMessageHandler:toString	()Ljava/lang/String;
    //   124: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: iconst_1
    //   134: istore 7
    //   136: aload_0
    //   137: monitorexit
    //   138: iload 7
    //   140: ireturn
    //   141: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +11 -> 155
    //   147: ldc 123
    //   149: iconst_2
    //   150: ldc 155
    //   152: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: iconst_0
    //   156: istore 7
    //   158: goto -22 -> 136
    //   161: astore 6
    //   163: aload_0
    //   164: monitorexit
    //   165: aload 6
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	SendMessageHandler
    //   0	168	1	paramInt	int
    //   0	168	2	paramLong1	long
    //   0	168	4	paramLong2	long
    //   0	168	6	paramArrayOfString	String[]
    //   134	23	7	bool	boolean
    //   23	30	8	localSendMessageRunnable	SendMessageHandler.SendMessageRunnable
    // Exception table:
    //   from	to	target	type
    //   2	133	161	finally
    //   141	155	161	finally
  }
  
  /* Error */
  public boolean a(long paramLong1, long paramLong2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 92	com/tencent/mobileqq/utils/SendMessageHandler:jdField_b_of_type_Int	I
    //   6: istore 6
    //   8: aload_0
    //   9: getfield 62	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   12: invokeinterface 162 1 0
    //   17: istore 7
    //   19: iload 6
    //   21: iload 7
    //   23: if_icmplt +11 -> 34
    //   26: iconst_0
    //   27: istore 8
    //   29: aload_0
    //   30: monitorexit
    //   31: iload 8
    //   33: ireturn
    //   34: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +71 -> 108
    //   40: ldc 75
    //   42: iconst_2
    //   43: new 125	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   50: ldc 164
    //   52: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 134	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_Long	J
    //   59: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc 166
    //   64: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: lload_1
    //   68: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: ldc 168
    //   73: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: lload_3
    //   77: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: ldc 170
    //   82: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: getfield 92	com/tencent/mobileqq/utils/SendMessageHandler:jdField_b_of_type_Int	I
    //   89: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc 172
    //   94: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 5
    //   99: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 92	com/tencent/mobileqq/utils/SendMessageHandler:jdField_b_of_type_Int	I
    //   113: iconst_1
    //   114: iadd
    //   115: putfield 92	com/tencent/mobileqq/utils/SendMessageHandler:jdField_b_of_type_Int	I
    //   118: aload_0
    //   119: new 174	ajrs
    //   122: dup
    //   123: aload_0
    //   124: lload_3
    //   125: aload 5
    //   127: invokespecial 177	ajrs:<init>	(Lcom/tencent/mobileqq/utils/SendMessageHandler;JLjava/lang/String;)V
    //   130: lload_1
    //   131: invokevirtual 181	com/tencent/mobileqq/utils/SendMessageHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   134: pop
    //   135: iconst_1
    //   136: istore 8
    //   138: goto -109 -> 29
    //   141: astore 5
    //   143: aload_0
    //   144: monitorexit
    //   145: aload 5
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	SendMessageHandler
    //   0	148	1	paramLong1	long
    //   0	148	3	paramLong2	long
    //   0	148	5	paramString	String
    //   6	18	6	i	int
    //   17	7	7	j	int
    //   27	110	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	19	141	finally
    //   34	108	141	finally
    //   108	135	141	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int j = this.jdField_a_of_type_Int;
    if ((j > 0) && (this.jdField_a_of_type_JavaUtilList.size() >= j))
    {
      int i = 0;
      while (i < j) {
        try
        {
          localStringBuilder.append(((SendMessageHandler.SendMessageRunnable)this.jdField_a_of_type_JavaUtilList.get(i)).toString());
          if (i != j - 1) {
            localStringBuilder.append(",");
          }
          i += 1;
        }
        catch (Exception localException)
        {
          localStringBuilder.append(localException.getMessage());
        }
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SendMessageHandler
 * JD-Core Version:    0.7.0.1
 */