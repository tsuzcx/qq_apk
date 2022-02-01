package com.tencent.mobileqq.pic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class BaseStrategy$TrafficStat
{
  public long a;
  private SharedPreferences a;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public long e = 0L;
  private long f = 0L;
  private long g = 0L;
  
  public BaseStrategy$TrafficStat()
  {
    this.jdField_a_of_type_Long = 0L;
    a();
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_pic_predown", 0);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_update_time", System.currentTimeMillis());
    this.b = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_xg_c2c", 0L);
    this.c = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_xg_grp", 0L);
    this.d = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_wifi_c2c", 0L);
    this.e = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_wifi_grp", 0L);
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:f	J
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +47 -> 55
    //   11: invokestatic 77	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
    //   14: aload_0
    //   15: getfield 19	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:jdField_a_of_type_Long	J
    //   18: invokevirtual 81	java/util/TimeZone:getOffset	(J)I
    //   21: i2l
    //   22: lstore_3
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 19	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:jdField_a_of_type_Long	J
    //   28: lload_3
    //   29: ladd
    //   30: ldc2_w 82
    //   33: ldiv
    //   34: ldc2_w 82
    //   37: lmul
    //   38: lload_3
    //   39: lsub
    //   40: putfield 23	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:g	J
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 23	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:g	J
    //   48: ldc2_w 82
    //   51: ladd
    //   52: putfield 21	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:f	J
    //   55: lload_1
    //   56: aload_0
    //   57: getfield 21	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:f	J
    //   60: lcmp
    //   61: ifgt +12 -> 73
    //   64: lload_1
    //   65: aload_0
    //   66: getfield 23	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:g	J
    //   69: lcmp
    //   70: ifge +46 -> 116
    //   73: aload_0
    //   74: lconst_0
    //   75: putfield 21	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:f	J
    //   78: aload_0
    //   79: lconst_0
    //   80: putfield 23	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:g	J
    //   83: aload_0
    //   84: lconst_0
    //   85: putfield 31	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:e	J
    //   88: aload_0
    //   89: lconst_0
    //   90: putfield 29	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:d	J
    //   93: aload_0
    //   94: lconst_0
    //   95: putfield 27	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:c	J
    //   98: aload_0
    //   99: lconst_0
    //   100: putfield 25	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:b	J
    //   103: aload_0
    //   104: lload_1
    //   105: putfield 19	com/tencent/mobileqq/pic/BaseStrategy$TrafficStat:jdField_a_of_type_Long	J
    //   108: iconst_0
    //   109: istore 5
    //   111: aload_0
    //   112: monitorexit
    //   113: iload 5
    //   115: ireturn
    //   116: iconst_1
    //   117: istore 5
    //   119: goto -8 -> 111
    //   122: astore 6
    //   124: aload_0
    //   125: monitorexit
    //   126: aload 6
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	TrafficStat
    //   0	129	1	paramLong	long
    //   22	17	3	l	long
    //   109	9	5	bool	boolean
    //   122	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	55	122	finally
    //   55	73	122	finally
    //   73	108	122	finally
  }
  
  public long[] a()
  {
    try
    {
      a(System.currentTimeMillis());
      long l1 = this.b;
      long l2 = this.c;
      long l3 = this.d;
      long l4 = this.e;
      return new long[] { l1, l2, l3, l4 };
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putLong("key_update_time", this.jdField_a_of_type_Long);
      localEditor.putLong("key_xg_c2c", this.b);
      localEditor.putLong("key_xg_grp", this.c);
      localEditor.putLong("key_wifi_c2c", this.d);
      localEditor.putLong("key_wifi_grp", this.e);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BaseStrategy.TrafficStat
 * JD-Core Version:    0.7.0.1
 */