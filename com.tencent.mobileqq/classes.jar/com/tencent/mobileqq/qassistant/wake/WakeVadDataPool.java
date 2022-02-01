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
    VadHelper localVadHelper = this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper;
    if ((localVadHelper == null) || (localVadHelper.a))
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
    }
    finally {}
  }
  
  private byte[] a()
  {
    try
    {
      byte[] arrayOfByte;
      if (this.jdField_b_of_type_JavaUtilQueue.isEmpty()) {
        arrayOfByte = new byte[3200];
      } else {
        arrayOfByte = (byte[])this.jdField_b_of_type_JavaUtilQueue.poll();
      }
      this.jdField_a_of_type_JavaUtilSet.add(arrayOfByte);
      return arrayOfByte;
    }
    finally {}
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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
      if (i != 1)
      {
        if (i == 3) {
          this.d = 0;
        }
      }
      else
      {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilQueue);
        this.jdField_a_of_type_JavaUtilQueue.clear();
        b();
      }
      localArrayList.add(paramArrayOfByte);
    }
    else if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          int j = this.d;
          if (j > 20)
          {
            this.d = 0;
            this.c = 1;
            this.jdField_a_of_type_JavaUtilQueue.clear();
            b(paramArrayOfByte);
          }
          else
          {
            this.d = (j + 1);
            localArrayList.add(paramArrayOfByte);
          }
        }
      }
      else
      {
        this.c = 3;
        this.d = 1;
        localArrayList.add(paramArrayOfByte);
      }
    }
    else
    {
      b(paramArrayOfByte);
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("status：");
    paramArrayOfByte.append(this.c);
    paramArrayOfByte.append(",preStatus:");
    paramArrayOfByte.append(i);
    paramArrayOfByte.append(",nextCount:");
    paramArrayOfByte.append(this.d);
    paramArrayOfByte.append(",onlinePreData.size:");
    paramArrayOfByte.append(this.jdField_a_of_type_JavaUtilQueue.size());
    paramArrayOfByte.append(",outData.size:");
    paramArrayOfByte.append(localArrayList.size());
    AssistantUtils.a("HelloQQWake", paramArrayOfByte.toString());
    return localArrayList;
  }
  
  public void a()
  {
    VadHelper localVadHelper = this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper;
    if (localVadHelper != null) {
      localVadHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeVadDataPool
 * JD-Core Version:    0.7.0.1
 */