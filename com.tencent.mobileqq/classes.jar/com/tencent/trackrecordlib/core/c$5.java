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
    Object localObject = null;
    switch (this.a)
    {
    }
    for (;;)
    {
      localObject = new d.a().a(UiAction.SCREEN_ROTATION).a((a)localObject).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
      RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject);
      c.a(this.b, (com.tencent.trackrecordlib.c.b)localObject);
      return;
      localObject = f.a(UiActionScreenRotation.NATURAL);
      continue;
      localObject = f.a(UiActionScreenRotation.LEFT);
      continue;
      localObject = f.a(UiActionScreenRotation.ROLLBACK);
      continue;
      localObject = f.a(UiActionScreenRotation.RIGHT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c.5
 * JD-Core Version:    0.7.0.1
 */