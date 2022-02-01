package com.tencent.qmsp.sdk.c;

import com.tencent.qmsp.sdk.d.e;
import java.io.File;

final class k$b
  implements a.a
{
  public k.f a;
  
  k$b(k paramk) {}
  
  public void a()
  {
    this.a.d = 26;
  }
  
  public void run()
  {
    Object localObject = this.a.h;
    int i;
    if ((localObject != null) && (!((String)localObject).contains("..")))
    {
      localObject = new File(this.a.h);
      if (!((File)localObject).exists())
      {
        localObject = this.a;
        i = 12;
      }
      else
      {
        this.a.i = new o();
        i = this.a.b;
        if ((i != 2) && (i != 1)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((i == 1) && (!e.b((File)localObject, null)))
        {
          this.a.d = 10;
          return;
        }
        localObject = new Object[1];
        k.f localf = this.a;
        localf.d = f.a(2L, localf.b, localf.a, 0L, localf.h, null, null, (Object[])localObject);
        if ((localObject[0] == null) || (!(localObject[0] instanceof Integer))) {
          return;
        }
        this.a.f = ((Integer)localObject[0]).intValue();
      }
    }
    else
    {
      localObject = this.a;
      i = 15;
    }
    ((k.f)localObject).d = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.k.b
 * JD-Core Version:    0.7.0.1
 */