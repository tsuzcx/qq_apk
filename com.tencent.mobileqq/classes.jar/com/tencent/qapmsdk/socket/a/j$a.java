package com.tencent.qapmsdk.socket.a;

import android.text.TextUtils;
import com.tencent.qapmsdk.socket.c.a;
import com.tencent.qapmsdk.socket.c.c;
import java.io.ByteArrayOutputStream;

class j$a
  extends j.b
{
  long a;
  long b;
  int c = 0;
  ByteArrayOutputStream d = new ByteArrayOutputStream();
  c e = new c();
  
  j$a(boolean paramBoolean, a parama)
  {
    super(paramBoolean, parama);
  }
  
  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.g.z)
    {
      this.d.write(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = this.d.toByteArray();
      while (this.i < paramArrayOfByte.length)
      {
        Object localObject;
        if (this.b == 0L)
        {
          localObject = a(paramArrayOfByte);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = ((String)localObject).split(";");
            paramInt1 = 0;
            localObject = localObject[0];
            l = 0L;
            while (paramInt1 < ((String)localObject).length())
            {
              paramInt2 = localObject.getBytes()[paramInt1];
              if ((paramInt2 >= 48) && (paramInt2 <= 57))
              {
                paramInt2 -= 48;
              }
              else
              {
                if ((paramInt2 >= 97) && (paramInt2 <= 102)) {
                  paramInt2 -= 97;
                }
                for (;;)
                {
                  paramInt2 += 10;
                  break;
                  if ((paramInt2 < 65) || (paramInt2 > 70)) {
                    break label179;
                  }
                  paramInt2 -= 65;
                }
              }
              l = l << 4 | paramInt2;
              paramInt1 += 1;
            }
            label179:
            if (l == 0L) {
              this.h = true;
            }
            this.b = l;
          }
        }
        if (this.h) {
          return;
        }
        long l = this.b;
        if (l != 0L)
        {
          localObject = a(paramArrayOfByte, (int)l);
          this.c += localObject.length;
          this.b -= localObject.length;
        }
      }
    }
    this.c += paramInt2;
    this.a -= paramInt2;
    if (this.a == 0L) {
      this.h = true;
    }
  }
  
  byte[] a()
  {
    return this.j.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j.a
 * JD-Core Version:    0.7.0.1
 */