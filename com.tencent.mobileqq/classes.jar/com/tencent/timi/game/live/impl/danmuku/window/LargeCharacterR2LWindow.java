package com.tencent.timi.game.live.impl.danmuku.window;

import android.graphics.Canvas;
import android.graphics.Point;
import com.tencent.common.danmaku.core.AbsWindow;
import com.tencent.common.danmaku.core.CacheDrawManager;
import com.tencent.common.danmaku.core.DanmakuMeasureManager;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.data.R2LDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.WindowConfig;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import com.tencent.common.danmaku.tool.PlayerTimer;
import com.tencent.common.danmaku.tool.TouchPoint;
import com.tencent.common.danmaku.util.DanmakuUtils;
import com.tencent.common.danmaku.util.Logger;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.live.impl.danmuku.DanmakuDataBean;
import com.tencent.timi.game.live.impl.danmuku.DanmakuUIConfig;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class LargeCharacterR2LWindow
  extends AbsWindow
{
  private static final int i = Utils.a(56.0F, BaseApplication.getContext().getResources());
  private static final int j = Utils.a(26.0F, BaseApplication.getContext().getResources());
  private int[] k;
  private BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>[] l;
  private List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> m;
  
  private BaseDanmaku<DanmakuDataBean, DanmakuUIConfig> a(TouchPoint paramTouchPoint, List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList)
  {
    if (paramList == null) {
      return null;
    }
    int n = 0;
    while (n < paramList.size())
    {
      int i1 = 0;
      while (i1 < ((List)paramList.get(n)).size())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)((List)paramList.get(n)).get(i1);
        if ((localBaseDanmaku.E()) && (localBaseDanmaku.a(paramTouchPoint.b.x, paramTouchPoint.b.y, paramTouchPoint.c, paramTouchPoint.a)))
        {
          if (Logger.a >= 5) {
            Logger.a("TimiR2LWindow", new Object[] { "onClick:", localBaseDanmaku, "[left:", Float.valueOf(localBaseDanmaku.s()), ",top:", Float.valueOf(localBaseDanmaku.t()), "]" });
          }
          return localBaseDanmaku;
        }
        i1 += 1;
      }
      n += 1;
    }
    return null;
  }
  
  private void a(Canvas paramCanvas, List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList)
  {
    if (paramList == null) {
      return;
    }
    int n = 0;
    while (n < paramList.size())
    {
      int i1 = 0;
      while (i1 < ((List)paramList.get(n)).size())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)((List)paramList.get(n)).get(i1);
        localBaseDanmaku.a(this.h.e(), this.h.b());
        if (!localBaseDanmaku.c(this.h.b())) {
          a(paramCanvas, localBaseDanmaku);
        }
        i1 += 1;
      }
      n += 1;
    }
  }
  
  private void a(BaseDanmaku paramBaseDanmaku, int paramInt1, int paramInt2)
  {
    if (paramBaseDanmaku.J()) {
      this.f.a(paramBaseDanmaku, this.e);
    }
    paramBaseDanmaku.a(paramInt2, paramInt1, this.g.a(), this.h.b());
  }
  
  private void a(BaseDanmaku<DanmakuDataBean, DanmakuUIConfig> paramBaseDanmaku, int paramInt, int[] paramArrayOfInt, BaseDanmaku[] paramArrayOfBaseDanmaku, List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfBaseDanmaku != null))
    {
      if (paramList == null) {
        return;
      }
      int i7 = DanmakuContext.a().j();
      if ((!paramBaseDanmaku.b(this.h.b())) && (!paramBaseDanmaku.a(this.g.a())) && (!e(paramBaseDanmaku)))
      {
        if (!paramBaseDanmaku.n()) {
          DanmakuMeasureManager.a(this.e, paramBaseDanmaku);
        }
        int i1 = paramBaseDanmaku.d(paramInt);
        if (i1 >= 0) {
          i2 = i1;
        } else {
          i2 = paramBaseDanmaku.c(paramInt);
        }
        int n = 2147483647;
        int i4;
        if (i1 >= 0) {
          i4 = i2 + 1;
        } else {
          i4 = i2 + paramInt;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startLayout, startLine = ");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(", maxLine = ");
        ((StringBuilder)localObject).append(i4);
        ((StringBuilder)localObject).append(", danmaku = ");
        ((StringBuilder)localObject).append(paramBaseDanmaku);
        Logger.c("TimiR2LWindow", ((StringBuilder)localObject).toString());
        int i5;
        for (i1 = 0; i2 < i4; i1 = i5)
        {
          i3 = i2;
          while (i3 >= paramInt) {
            i3 -= paramInt;
          }
          if (Logger.a >= 5)
          {
            Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " try layout" });
            i5 = 0;
            while (i5 < paramInt)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("row ");
              localStringBuilder.append(i5);
              if (paramArrayOfBaseDanmaku[i5] == null) {
                localObject = " null";
              } else {
                localObject = paramArrayOfBaseDanmaku[i5];
              }
              localStringBuilder.append(localObject);
              Logger.b("TimiR2LWindow", localStringBuilder.toString());
              i5 += 1;
            }
          }
          if (paramArrayOfBaseDanmaku[i3] == null)
          {
            paramArrayOfBaseDanmaku[i3] = paramBaseDanmaku;
            ((List)paramList.get(i3)).add(paramBaseDanmaku);
            this.a += 1;
            a(paramBaseDanmaku, paramArrayOfInt[i3], i7);
            i2 = n;
            paramInt = i1;
            if (Logger.a >= 4)
            {
              Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " layout success:", Integer.valueOf(i3), ",top:", Integer.valueOf(paramArrayOfInt[i3]) });
              paramInt = i1;
              i2 = n;
            }
          }
          for (;;)
          {
            n = 1;
            break label696;
            if (paramArrayOfBaseDanmaku[i3].g()) {
              break;
            }
            i5 = DanmakuUtils.a(paramArrayOfBaseDanmaku[i3], paramBaseDanmaku, this.h.b());
            if (i5 < n)
            {
              n = i5;
              i1 = i3;
            }
            i6 = n;
            i5 = i1;
            if (n >= 0) {
              break label665;
            }
            paramArrayOfBaseDanmaku[i3] = paramBaseDanmaku;
            ((List)paramList.get(i3)).add(paramBaseDanmaku);
            this.a += 1;
            a(paramBaseDanmaku, paramArrayOfInt[i3], i7);
            i2 = n;
            paramInt = i1;
            if (Logger.a >= 4)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramArrayOfInt[i3]);
              ((StringBuilder)localObject).append(", hitTime = ");
              ((StringBuilder)localObject).append(n);
              Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " layout success:", Integer.valueOf(i3), ",top:", ((StringBuilder)localObject).toString() });
              i2 = n;
              paramInt = i1;
            }
          }
          i5 = i1;
          int i6 = n;
          label665:
          i2 += 1;
          n = i6;
        }
        int i3 = 0;
        paramInt = i1;
        int i2 = n;
        n = i3;
        label696:
        i1 = n;
        if (n == 0)
        {
          i1 = n;
          if (paramBaseDanmaku.a(i2))
          {
            paramArrayOfBaseDanmaku[paramInt] = paramBaseDanmaku;
            ((List)paramList.get(paramInt)).add(paramBaseDanmaku);
            this.a += 1;
            a(paramBaseDanmaku, paramArrayOfInt[paramInt], i7);
            if (Logger.a >= 4)
            {
              paramArrayOfBaseDanmaku = new StringBuilder();
              paramArrayOfBaseDanmaku.append(paramArrayOfInt[paramInt]);
              paramArrayOfBaseDanmaku.append(", danmakuRepeatTime = ");
              paramArrayOfBaseDanmaku.append(paramBaseDanmaku.D());
              Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " layout success:", Integer.valueOf(paramInt), ",top:", paramArrayOfBaseDanmaku.toString() });
            }
            i1 = 1;
          }
        }
        if (i1 == 0)
        {
          this.c.add(paramBaseDanmaku);
          if (Logger.a >= 4) {
            Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " can not in window" });
          }
        }
        if ((paramBaseDanmaku.P()) && (i1 != 0))
        {
          paramArrayOfInt = new StringBuilder();
          paramArrayOfInt.append("must show danmaku layout success :");
          paramArrayOfInt.append(paramBaseDanmaku);
          Logger.b("TimiR2LWindow", paramArrayOfInt.toString());
        }
        return;
      }
      if (Logger.a >= 5)
      {
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append(paramBaseDanmaku);
        paramArrayOfInt.append(" is out side");
        Logger.b("TimiR2LWindow", paramArrayOfInt.toString());
      }
      this.c.add(paramBaseDanmaku);
    }
  }
  
  private void a(BaseDanmaku<DanmakuDataBean, DanmakuUIConfig> paramBaseDanmaku, int[] paramArrayOfInt, List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList)
  {
    if (paramArrayOfInt != null)
    {
      if (paramList == null) {
        return;
      }
      if (c(paramBaseDanmaku, paramArrayOfInt, paramList) < 0) {
        return;
      }
      int i1 = 0;
      int n = 0;
      while (i1 < paramList.size())
      {
        int i2 = 0;
        while (i2 < ((List)paramList.get(i1)).size())
        {
          paramArrayOfInt = (BaseDanmaku)((List)paramList.get(i1)).get(i2);
          if (paramArrayOfInt == paramBaseDanmaku) {
            n = 1;
          }
          if (n != 0) {
            paramArrayOfInt.f();
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
  }
  
  private void a(List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      if (paramList == null) {
        return;
      }
      int i1 = paramList.size();
      int n = 0;
      while (n < i1)
      {
        Iterator localIterator = ((List)paramList.get(n)).iterator();
        while (localIterator.hasNext())
        {
          R2LDanmaku localR2LDanmaku = (R2LDanmaku)localIterator.next();
          localR2LDanmaku.a();
          long l1 = this.h.b();
          int i2 = (int)localR2LDanmaku.s();
          b(localR2LDanmaku);
          localR2LDanmaku.h(l1 - (int)((localR2LDanmaku.H() - i2) / -localR2LDanmaku.i()));
          localR2LDanmaku.i(paramArrayOfInt[n]);
          localR2LDanmaku.h(i2);
        }
        n += 1;
      }
    }
  }
  
  private void a(List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList, BaseDanmaku[] paramArrayOfBaseDanmaku)
  {
    if (paramList != null)
    {
      if (paramArrayOfBaseDanmaku == null) {
        return;
      }
      int n = 0;
      if (n < paramList.size())
      {
        Iterator localIterator = ((List)paramList.get(n)).iterator();
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            n += 1;
            break;
          }
          BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
          if ((localBaseDanmaku.b(this.h.b())) || (!localBaseDanmaku.p()))
          {
            if (localBaseDanmaku == paramArrayOfBaseDanmaku[n]) {
              paramArrayOfBaseDanmaku[n] = null;
            }
            localIterator.remove();
            this.a -= 1;
            this.c.add(localBaseDanmaku);
          }
        }
      }
    }
  }
  
  private void a(BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>[] paramArrayOfBaseDanmaku, List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList)
  {
    if (paramArrayOfBaseDanmaku != null)
    {
      if (paramList == null) {
        return;
      }
      int i2 = 0;
      int n = 0;
      int i1;
      for (;;)
      {
        i1 = i2;
        if (n >= paramArrayOfBaseDanmaku.length) {
          break;
        }
        paramArrayOfBaseDanmaku[n] = null;
        n += 1;
      }
      while (i1 < paramList.size())
      {
        paramArrayOfBaseDanmaku = ((List)paramList.get(i1)).iterator();
        while (paramArrayOfBaseDanmaku.hasNext())
        {
          BaseDanmaku localBaseDanmaku = (BaseDanmaku)paramArrayOfBaseDanmaku.next();
          paramArrayOfBaseDanmaku.remove();
          this.a -= 1;
          this.c.add(localBaseDanmaku);
        }
        i1 += 1;
      }
    }
  }
  
  private void b(BaseDanmaku<DanmakuDataBean, DanmakuUIConfig> paramBaseDanmaku, int[] paramArrayOfInt, List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList)
  {
    if (paramArrayOfInt != null)
    {
      if (paramList == null) {
        return;
      }
      if (c(paramBaseDanmaku, paramArrayOfInt, paramList) < 0) {
        return;
      }
      int i1 = 0;
      int n = 0;
      while (i1 < paramList.size())
      {
        int i2 = 0;
        while (i2 < ((List)paramList.get(i1)).size())
        {
          paramArrayOfInt = (BaseDanmaku)((List)paramList.get(i1)).get(i2);
          if (paramArrayOfInt == paramBaseDanmaku) {
            n = 1;
          }
          if (n != 0) {
            paramArrayOfInt.h();
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
  }
  
  private int c(BaseDanmaku<DanmakuDataBean, DanmakuUIConfig> paramBaseDanmaku, int[] paramArrayOfInt, List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList)
  {
    int i1 = -1;
    int n = i1;
    if (paramArrayOfInt != null)
    {
      if (paramList == null) {
        return -1;
      }
      n = i1;
      if (paramBaseDanmaku != null)
      {
        n = 0;
        i1 = -1;
        while (n < paramArrayOfInt.length)
        {
          if (paramBaseDanmaku.t() == paramArrayOfInt[n]) {
            i1 = n;
          }
          n += 1;
        }
        if (paramList.size() <= i1) {
          return -1;
        }
        n = i1;
      }
    }
    return n;
  }
  
  private boolean e(BaseDanmaku<DanmakuDataBean, DanmakuUIConfig> paramBaseDanmaku)
  {
    if (this.m != null)
    {
      int n = 0;
      while (n < this.m.size())
      {
        if (((List)this.m.get(n)).contains(paramBaseDanmaku))
        {
          Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " is repeat" });
          return true;
        }
        n += 1;
      }
    }
    return false;
  }
  
  private void g()
  {
    if (Logger.a >= 5) {
      Logger.b("TimiR2LWindow", new Object[] { Integer.valueOf(this.b.size()) });
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
      localIterator.remove();
      a(localBaseDanmaku, 3, this.k, this.l, this.m);
    }
  }
  
  public BaseDanmaku a(TouchPoint paramTouchPoint)
  {
    paramTouchPoint = a(paramTouchPoint, this.m);
    if (paramTouchPoint != null) {
      return paramTouchPoint;
    }
    Logger.a("TimiR2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    a(this.m, this.k);
  }
  
  public void b()
  {
    g();
    a(this.m, this.l);
  }
  
  public void b(Canvas paramCanvas, long paramLong)
  {
    a(paramCanvas, this.m);
  }
  
  public void c()
  {
    a(this.l, this.m);
  }
  
  public void c(BaseDanmaku paramBaseDanmaku)
  {
    a(paramBaseDanmaku, this.k, this.m);
  }
  
  public void d(BaseDanmaku paramBaseDanmaku)
  {
    b(paramBaseDanmaku, this.k, this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.window.LargeCharacterR2LWindow
 * JD-Core Version:    0.7.0.1
 */