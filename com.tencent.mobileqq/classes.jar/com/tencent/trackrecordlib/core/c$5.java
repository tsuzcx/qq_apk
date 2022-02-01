package com.tencent.trackrecordlib.core;

import com.tencent.trackrecordlib.b.a;
import com.tencent.trackrecordlib.b.f;
import com.tencent.trackrecordlib.c.d.a;
import com.tencent.trackrecordlib.enums.UiAction;
import com.tencent.trackrecordlib.enums.UiActionScreenRotation;

class c$5
  implements Runnable
{
  c$5(c paramc, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            localObject = null;
          } else {
            localObject = f.a(UiActionScreenRotation.RIGHT);
          }
        }
        else {
          localObject = f.a(UiActionScreenRotation.ROLLBACK);
        }
      }
      else {
        localObject = f.a(UiActionScreenRotation.LEFT);
      }
    }
    else {
      localObject = f.a(UiActionScreenRotation.NATURAL);
    }
    Object localObject = new d.a().a(UiAction.SCREEN_ROTATION).a((a)localObject).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
    RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject);
    c.a(this.b, (com.tencent.trackrecordlib.c.b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c.5
 * JD-Core Version:    0.7.0.1
 */