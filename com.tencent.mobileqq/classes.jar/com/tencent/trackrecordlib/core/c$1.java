package com.tencent.trackrecordlib.core;

import android.view.View;
import android.widget.EditText;
import com.tencent.trackrecordlib.b.a;
import com.tencent.trackrecordlib.b.f;
import com.tencent.trackrecordlib.c.d.a;
import com.tencent.trackrecordlib.enums.UiAction;
import com.tencent.trackrecordlib.g.i;

class c$1
  implements Runnable
{
  c$1(c paramc, int paramInt1, int paramInt2, long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong2, View paramView) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        int k = this.a & 0xFF;
        if (k != 0)
        {
          if (k != 1)
          {
            if (k != 5)
            {
              if (k != 6) {
                return;
              }
              c.g(this.j, this.d);
              c.h(this.j, this.e);
              return;
            }
            c.b(this.j, this.b);
            c.e(this.j, this.d);
            c.f(this.j, this.e);
            return;
          }
          k = (int)(this.h - c.a(this.j));
          int m = c.b(this.j);
          d.a locala = null;
          Object localObject4 = null;
          Object localObject3 = null;
          Object localObject1 = null;
          if ((m != -1) && (c.c(this.j) == -1))
          {
            boolean bool1 = c.a(this.j, this.f, this.g);
            boolean bool2 = c.b(this.j, this.h);
            if ((!bool1) && (!bool2))
            {
              localObject3 = f.a((int)this.d, (int)this.e, (int)this.f, (int)this.g);
              localObject3 = new d.a().a(UiAction.CLICK).a((a)localObject3).a(this.i.getClass().getName()).b(i.a(this.i));
              if ((!RecordManager.getInstance().b) || (!(this.i instanceof EditText))) {
                localObject1 = i.c(this.i);
              }
              localObject1 = ((d.a)localObject3).c((String)localObject1).d(i.b(this.i)).e(i.f(this.i)).f(i.d(this.i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
              RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject1);
              c.a(this.j, (com.tencent.trackrecordlib.c.b)localObject1);
            }
            else if (!bool1)
            {
              localObject1 = f.a((int)this.d, (int)this.e, (int)this.f, (int)this.g, k);
              localObject3 = new d.a().a(UiAction.LONG_PRESS).a((a)localObject1).a(this.i.getClass().getName()).b(i.a(this.i));
              if ((RecordManager.getInstance().b) && ((this.i instanceof EditText))) {
                localObject1 = locala;
              } else {
                localObject1 = i.c(this.i);
              }
              localObject1 = ((d.a)localObject3).c((String)localObject1).d(i.b(this.i)).e(i.f(this.i)).f(i.d(this.i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
              RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject1);
              c.a(this.j, (com.tencent.trackrecordlib.c.b)localObject1);
            }
            else
            {
              localObject1 = f.a((int)c.d(this.j), (int)c.e(this.j), (int)this.d, (int)this.e, (int)c.f(this.j), (int)c.g(this.j), (int)this.f, (int)this.g, k);
              localObject3 = new d.a().a(UiAction.SCROLL).a((a)localObject1).a(this.i.getClass().getName()).b(i.a(this.i));
              if ((RecordManager.getInstance().b) && ((this.i instanceof EditText))) {
                localObject1 = localObject4;
              } else {
                localObject1 = i.c(this.i);
              }
              localObject1 = ((d.a)localObject3).c((String)localObject1).d(i.b(this.i)).e(i.f(this.i)).f(i.d(this.i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
              RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject1);
              c.a(this.j, (com.tencent.trackrecordlib.c.b)localObject1);
            }
          }
          else if ((c.b(this.j) != -1) && (c.c(this.j) != -1))
          {
            if (c.b(this.j) == this.b)
            {
              localObject1 = f.a((int)c.d(this.j), (int)c.e(this.j), (int)c.h(this.j), (int)c.i(this.j), (int)this.d, (int)this.e, (int)c.j(this.j), (int)c.k(this.j));
            }
            else
            {
              if (c.c(this.j) != this.b) {
                break label1176;
              }
              localObject1 = f.a((int)c.d(this.j), (int)c.e(this.j), (int)c.h(this.j), (int)c.i(this.j), (int)c.j(this.j), (int)c.k(this.j), (int)this.d, (int)this.e);
            }
            locala = new d.a().a(UiAction.ZOOM).a((a)localObject1).a(this.i.getClass().getName()).b(i.a(this.i));
            if ((RecordManager.getInstance().b) && ((this.i instanceof EditText))) {
              localObject1 = localObject3;
            } else {
              localObject1 = i.c(this.i);
            }
            localObject1 = locala.c((String)localObject1).d(i.b(this.i)).e(i.f(this.i)).f(i.d(this.i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
            RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject1);
            c.a(this.j, (com.tencent.trackrecordlib.c.b)localObject1);
          }
          c.a(this.j, -1);
          c.b(this.j, -1);
        }
        else
        {
          c.a(this.j, this.b);
          c.a(this.j, this.c);
          c.a(this.j, this.d);
          c.b(this.j, this.e);
          c.c(this.j, this.f);
          c.d(this.j, this.g);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      label1176:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c.1
 * JD-Core Version:    0.7.0.1
 */