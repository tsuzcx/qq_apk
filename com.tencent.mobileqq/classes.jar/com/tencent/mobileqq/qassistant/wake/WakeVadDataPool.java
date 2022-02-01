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
  private Queue<byte[]> a = new LinkedList();
  private final int b = 20;
  private final int c = 7;
  private int d = 3;
  private int e = 0;
  private VadHelper f;
  private Set<byte[]> g = new HashSet();
  private Queue<byte[]> h = new LinkedList();
  
  public WakeVadDataPool()
  {
    VadHelper localVadHelper = this.f;
    if ((localVadHelper == null) || (localVadHelper.a))
    {
      this.f = new VadHelper();
      this.f.c();
      this.f.a();
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      this.h.offer(paramArrayOfByte);
      this.g.remove(paramArrayOfByte);
    }
    finally {}
  }
  
  private byte[] b()
  {
    try
    {
      byte[] arrayOfByte;
      if (this.h.isEmpty()) {
        arrayOfByte = new byte[3200];
      } else {
        arrayOfByte = (byte[])this.h.poll();
      }
      this.g.add(arrayOfByte);
      return arrayOfByte;
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        byte[] arrayOfByte = (byte[])localIterator.next();
        this.h.offer(arrayOfByte);
      }
      this.g.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = b();
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    if (this.a.size() > 7) {
      b((byte[])this.a.poll());
    }
    this.a.offer(arrayOfByte);
  }
  
  public ArrayList<byte[]> a(byte[] paramArrayOfByte)
  {
    WXVadData localWXVadData = this.f.a(paramArrayOfByte);
    ArrayList localArrayList = new ArrayList();
    if (localWXVadData == null)
    {
      AssistantUtils.a("HelloQQWake", "vadOnlineProcess isError ");
      localArrayList.add(paramArrayOfByte);
      return localArrayList;
    }
    int i = this.d;
    if (localWXVadData.RET_STATE == 2)
    {
      this.d = 2;
      if (i != 1)
      {
        if (i == 3) {
          this.e = 0;
        }
      }
      else
      {
        localArrayList.addAll(this.a);
        this.a.clear();
        c();
      }
      localArrayList.add(paramArrayOfByte);
    }
    else if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          int j = this.e;
          if (j > 20)
          {
            this.e = 0;
            this.d = 1;
            this.a.clear();
            c(paramArrayOfByte);
          }
          else
          {
            this.e = (j + 1);
            localArrayList.add(paramArrayOfByte);
          }
        }
      }
      else
      {
        this.d = 3;
        this.e = 1;
        localArrayList.add(paramArrayOfByte);
      }
    }
    else
    {
      c(paramArrayOfByte);
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("status：");
    paramArrayOfByte.append(this.d);
    paramArrayOfByte.append(",preStatus:");
    paramArrayOfByte.append(i);
    paramArrayOfByte.append(",nextCount:");
    paramArrayOfByte.append(this.e);
    paramArrayOfByte.append(",onlinePreData.size:");
    paramArrayOfByte.append(this.a.size());
    paramArrayOfByte.append(",outData.size:");
    paramArrayOfByte.append(localArrayList.size());
    AssistantUtils.a("HelloQQWake", paramArrayOfByte.toString());
    return localArrayList;
  }
  
  public void a()
  {
    VadHelper localVadHelper = this.f;
    if (localVadHelper != null) {
      localVadHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeVadDataPool
 * JD-Core Version:    0.7.0.1
 */