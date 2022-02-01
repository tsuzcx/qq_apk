package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.SocketImpl;

public final class h
  extends Socket
{
  private static final String a = "MSFSocket";
  
  private int b()
  {
    int j = -1;
    int i;
    try
    {
      Object localObject1 = Socket.class.getDeclaredField("impl");
      ((Field)localObject1).setAccessible(true);
      localObject1 = (SocketImpl)((Field)localObject1).get(this);
      Object localObject2 = Socket.class.getClassLoader().loadClass("java.net.SocketImpl").getDeclaredMethod("getFileDescriptor", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      localObject1 = (FileDescriptor)((Method)localObject2).invoke(localObject1, new Object[0]);
      if (localObject1 == null)
      {
        i = j;
      }
      else
      {
        localObject2 = FileDescriptor.class.getDeclaredField("descriptor");
        ((Field)localObject2).setAccessible(true);
        i = ((Integer)((Field)localObject2).get(localObject1)).intValue();
      }
    }
    catch (Throwable localThrowable)
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("MSFSocket", 1, "getSocketFd fail", localThrowable);
        i = j;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSocketFd = ");
      localStringBuilder.append(i);
      QLog.d("MSFSocket", 1, localStringBuilder.toString());
    }
    return i;
  }
  
  public long a()
  {
    long l3 = 0L;
    long l2 = l3;
    try
    {
      int i = b();
      long l1 = l3;
      if (i != -1)
      {
        l2 = l3;
        l1 = CodecWarpper.getPacketLossLength(i);
      }
      l2 = l1;
      l3 = l1;
      if (QLog.isColorLevel())
      {
        l2 = l1;
        StringBuilder localStringBuilder = new StringBuilder();
        l2 = l1;
        localStringBuilder.append("getLossPacketLength = ");
        l2 = l1;
        localStringBuilder.append(l1);
        l2 = l1;
        QLog.d("MSFSocket", 1, localStringBuilder.toString());
        return l1;
      }
    }
    catch (Throwable localThrowable)
    {
      l3 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("MSFSocket", 1, "getLossPacketLength fail", localThrowable);
        l3 = l2;
      }
    }
    return l3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.h
 * JD-Core Version:    0.7.0.1
 */