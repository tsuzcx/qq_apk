package com.tencent.mobileqq.microapp.appbrand.utils;

import com.tencent.mobileqq.microapp.b.b;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

final class n
  extends b
{
  n(m paramm) {}
  
  public void a(int paramInt1, byte[] paramArrayOfByte, Map paramMap, int paramInt2)
  {
    if (paramInt1 == 200) {
      if (QLog.isDebugVersion()) {
        QLog.d(MiniLogManager.access$100(), 2, "log upload success " + this.a.a);
      }
    }
    for (;;)
    {
      new File(this.a.b).delete();
      return;
      if (QLog.isDebugVersion()) {
        QLog.d(MiniLogManager.access$100(), 2, "log upload failed " + this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.utils.n
 * JD-Core Version:    0.7.0.1
 */