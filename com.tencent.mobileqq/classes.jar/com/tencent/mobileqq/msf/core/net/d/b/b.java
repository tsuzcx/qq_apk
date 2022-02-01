package com.tencent.mobileqq.msf.core.net.d.b;

import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;

class b
  extends LruCache
{
  b(a parama, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, Thread paramThread, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = 0;
    int i;
    if (paramArrayOfByte1 != null) {
      i = paramArrayOfByte1.length;
    } else {
      i = 0;
    }
    if (paramArrayOfByte2 != null) {
      j = paramArrayOfByte2.length;
    }
    QLog.d("BufferPool", 1, new Object[] { "[entryRemoved] ev: ", Boolean.valueOf(paramBoolean), ", thread: ", paramThread, ", old: ", Integer.valueOf(i), ", new: ", Integer.valueOf(j) });
    super.entryRemoved(paramBoolean, paramThread, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  protected byte[] a(Thread paramThread)
  {
    QLog.d("BufferPool", 1, new Object[] { "[create] alloc buffer size: ", Integer.valueOf(a.d()), ", thread: ", paramThread });
    return new byte[a.d()];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.b.b
 * JD-Core Version:    0.7.0.1
 */