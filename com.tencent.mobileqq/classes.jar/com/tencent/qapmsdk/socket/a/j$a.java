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
    if (this.g.z) {
      this.d.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    label173:
    do
    {
      paramArrayOfByte = this.d.toByteArray();
      for (;;)
      {
        Object localObject;
        if (this.i < paramArrayOfByte.length)
        {
          if (this.b == 0L)
          {
            localObject = a(paramArrayOfByte);
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              long l = 0L;
              localObject = localObject.split(";")[0];
              paramInt2 = 0;
              if (paramInt2 < ((String)localObject).length())
              {
                paramInt1 = localObject.getBytes()[paramInt2];
                if ((paramInt1 >= 48) && (paramInt1 <= 57)) {
                  paramInt1 -= 48;
                }
                for (;;)
                {
                  l = l << 4 | paramInt1;
                  paramInt2 += 1;
                  break;
                  if ((paramInt1 >= 97) && (paramInt1 <= 102))
                  {
                    paramInt1 = paramInt1 - 97 + 10;
                  }
                  else
                  {
                    if ((paramInt1 < 65) || (paramInt1 > 70)) {
                      break label173;
                    }
                    paramInt1 = paramInt1 - 65 + 10;
                  }
                }
              }
              if (l == 0L) {
                this.h = true;
              }
              this.b = l;
            }
          }
          if (!this.h) {}
        }
        else
        {
          return;
        }
        if (this.b != 0L)
        {
          localObject = a(paramArrayOfByte, (int)this.b);
          this.c += localObject.length;
          this.b -= localObject.length;
        }
      }
      this.c += paramInt2;
      this.a -= paramInt2;
    } while (this.a != 0L);
    this.h = true;
  }
  
  byte[] a()
  {
    return this.j.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j.a
 * JD-Core Version:    0.7.0.1
 */