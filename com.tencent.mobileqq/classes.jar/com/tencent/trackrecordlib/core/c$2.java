package com.tencent.trackrecordlib.core;

import android.view.KeyEvent;
import com.tencent.trackrecordlib.b.a;
import com.tencent.trackrecordlib.b.f;
import com.tencent.trackrecordlib.c.d.a;
import com.tencent.trackrecordlib.enums.UiAction;
import com.tencent.trackrecordlib.enums.UiActionKey;

class c$2
  implements Runnable
{
  c$2(c paramc, KeyEvent paramKeyEvent) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.a.getAction() != 1) {
          break;
        }
        localObject = null;
        switch (this.a.getKeyCode())
        {
        case 3: 
          localObject = new d.a().a(UiAction.KEY).a((a)localObject).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
          RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject);
          c.a(this.b, (com.tencent.trackrecordlib.c.b)localObject);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        localThrowable.printStackTrace();
        return;
      }
      localObject = f.a(UiActionKey.HOME);
      continue;
      localObject = f.a(UiActionKey.BACK);
      continue;
      localObject = f.a(UiActionKey.VOLUME_PLUS);
      continue;
      localObject = f.a(UiActionKey.VOLUME_SUB);
      continue;
      localObject = f.a(UiActionKey.LOCK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c.2
 * JD-Core Version:    0.7.0.1
 */