package com.tencent.trackrecordlib.core;

import com.tencent.trackrecordlib.b.a;
import com.tencent.trackrecordlib.b.f;
import com.tencent.trackrecordlib.c.d.a;
import com.tencent.trackrecordlib.enums.UiAction;
import com.tencent.trackrecordlib.enums.UiActionKey;

class c$7
  implements Runnable
{
  c$7(c paramc) {}
  
  public void run()
  {
    Object localObject = f.a(UiActionKey.BACK);
    localObject = new d.a().a(UiAction.KEY).a((a)localObject).h(com.tencent.trackrecordlib.g.b.a()).g(com.tencent.trackrecordlib.g.b.d()).a();
    RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject);
    c.a(this.a, (com.tencent.trackrecordlib.c.b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c.7
 * JD-Core Version:    0.7.0.1
 */