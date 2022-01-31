package com.tencent.mobileqq.microapp.b;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class e
  extends b
{
  e(d paramd) {}
  
  public void a(int paramInt1, byte[] paramArrayOfByte, Map paramMap, int paramInt2)
  {
    if ((!this.a.a.get()) && (paramArrayOfByte != null))
    {
      byte[] arrayOfByte1 = paramArrayOfByte;
      if ("application/json".equals(d.a(this.a).g)) {}
      for (;;)
      {
        try
        {
          str = new String(paramArrayOfByte, "utf-8");
        }
        catch (Throwable localThrowable2)
        {
          String str;
          QLog.e("RequestTask", 1, localThrowable2, new Object[0]);
          arrayOfByte3 = paramArrayOfByte;
          continue;
        }
        try
        {
          arrayOfByte1 = new JSONObject(str).toString().getBytes();
          paramArrayOfByte = arrayOfByte1;
        }
        catch (Throwable localThrowable1)
        {
          arrayOfByte2 = str.getBytes();
          paramArrayOfByte = arrayOfByte2;
        }
      }
      arrayOfByte1 = paramArrayOfByte;
      if (d.a(this.a).h != null) {
        d.a(this.a).h.a(paramInt1, arrayOfByte1, paramMap, d.a(this.a).j);
      }
    }
    do
    {
      return;
      byte[] arrayOfByte2;
      byte[] arrayOfByte3;
      if (d.a(this.a).h != null) {
        d.a(this.a).h.a(paramInt1, null, paramMap, d.a(this.a).j);
      }
    } while (!QLog.isColorLevel());
    QLog.d("RequestTask", 2, "[run] abort");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.b.e
 * JD-Core Version:    0.7.0.1
 */