package com.tencent.mobileqq.qassistant.wake;

import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.utils.VadHelper;
import com.wx.voice.vad.WXVadData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WakeVadDataPool
{
  private final int jdField_a_of_type_Int = 20;
  private VadHelper jdField_a_of_type_ComTencentMobileqqUtilsVadHelper;
  private Queue<byte[]> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private Set<byte[]> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final int jdField_b_of_type_Int = 7;
  private Queue<byte[]> jdField_b_of_type_JavaUtilQueue = new LinkedList();
  private int c = 3;
  private int d = 0;
  
  public WakeVadDataPool()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper.a))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper = new VadHelper();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper.a();
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      this.jdField_b_of_type_JavaUtilQueue.offer(paramArrayOfByte);
      this.jdField_a_of_type_JavaUtilSet.remove(paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  /* Error */
  private byte[] a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/mobileqq/qassistant/wake/WakeVadDataPool:jdField_b_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   6: invokeinterface 68 1 0
    //   11: ifeq +24 -> 35
    //   14: sipush 3200
    //   17: newarray byte
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 31	com/tencent/mobileqq/qassistant/wake/WakeVadDataPool:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   24: aload_1
    //   25: invokeinterface 71 2 0
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: aload_0
    //   36: getfield 36	com/tencent/mobileqq/qassistant/wake/WakeVadDataPool:jdField_b_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   39: invokeinterface 75 1 0
    //   44: checkcast 77	[B
    //   47: astore_1
    //   48: goto -28 -> 20
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	WakeVadDataPool
    //   19	29	1	arrayOfByte	byte[]
    //   51	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	51	finally
    //   20	31	51	finally
    //   35	48	51	finally
  }
  
  private void b()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        byte[] arrayOfByte = (byte[])localIterator.next();
        this.jdField_b_of_type_JavaUtilQueue.offer(arrayOfByte);
      }
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    finally {}
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = a();
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 7) {
      a((byte[])this.jdField_a_of_type_JavaUtilQueue.poll());
    }
    this.jdField_a_of_type_JavaUtilQueue.offer(arrayOfByte);
  }
  
  public ArrayList<byte[]> a(byte[] paramArrayOfByte)
  {
    WXVadData localWXVadData = this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper.a(paramArrayOfByte);
    ArrayList localArrayList = new ArrayList();
    if (localWXVadData == null)
    {
      AssistantUtils.a("HelloQQWake", "vadOnlineProcess isError ");
      localArrayList.add(paramArrayOfByte);
      return localArrayList;
    }
    int i = this.c;
    if (localWXVadData.RET_STATE == 2)
    {
      this.c = 2;
      switch (i)
      {
      case 2: 
      default: 
        localArrayList.add(paramArrayOfByte);
      }
    }
    for (;;)
    {
      AssistantUtils.a("HelloQQWake", "status：" + this.c + ",preStatus:" + i + ",nextCount:" + this.d + ",onlinePreData.size:" + this.jdField_a_of_type_JavaUtilQueue.size() + ",outData.size:" + localArrayList.size());
      return localArrayList;
      this.d = 0;
      break;
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilQueue);
      this.jdField_a_of_type_JavaUtilQueue.clear();
      b();
      break;
      switch (i)
      {
      default: 
        break;
      case 1: 
        b(paramArrayOfByte);
        break;
      case 2: 
        this.c = 3;
        this.d = 1;
        localArrayList.add(paramArrayOfByte);
        break;
      case 3: 
        if (this.d > 20)
        {
          this.d = 0;
          this.c = 1;
          this.jdField_a_of_type_JavaUtilQueue.clear();
          b(paramArrayOfByte);
        }
        else
        {
          this.d += 1;
          localArrayList.add(paramArrayOfByte);
        }
        break;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeVadDataPool
 * JD-Core Version:    0.7.0.1
 */