package com.tencent.timi.game.live.impl.danmuku;

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
import com.tencent.common.danmaku.util.DrawUtils;
import com.tencent.common.danmaku.util.Logger;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class TimiR2LWindow
  extends AbsWindow
{
  private static final int j = Utils.a(56.0F, BaseApplication.getContext().getResources());
  private static final int k = Utils.a(26.0F, BaseApplication.getContext().getResources());
  protected int i;
  private int l;
  private int[] m;
  private BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>[] n;
  private List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> o;
  private int[] p;
  private BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>[] q;
  private List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> r;
  private int s;
  
  private BaseDanmaku<DanmakuDataBean, DanmakuUIConfig> a(TouchPoint paramTouchPoint, List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList)
  {
    if (paramList == null) {
      return null;
    }
    int i1 = 0;
    while (i1 < paramList.size())
    {
      int i2 = 0;
      while (i2 < ((List)paramList.get(i1)).size())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)((List)paramList.get(i1)).get(i2);
        if ((localBaseDanmaku.E()) && (localBaseDanmaku.a(paramTouchPoint.b.x, paramTouchPoint.b.y, paramTouchPoint.c, paramTouchPoint.a)))
        {
          if (Logger.a >= 5) {
            Logger.a("TimiR2LWindow", new Object[] { "onClick:", localBaseDanmaku, "[left:", Float.valueOf(localBaseDanmaku.s()), ",top:", Float.valueOf(localBaseDanmaku.t()), "]" });
          }
          return localBaseDanmaku;
        }
        i2 += 1;
      }
      i1 += 1;
    }
    return null;
  }
  
  private void a(Canvas paramCanvas, List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i1 = 0;
    while (i1 < paramList.size())
    {
      int i2 = 0;
      while (i2 < ((List)paramList.get(i1)).size())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)((List)paramList.get(i1)).get(i2);
        localBaseDanmaku.a(this.h.e(), this.h.b());
        if (!localBaseDanmaku.c(this.h.b())) {
          a(paramCanvas, localBaseDanmaku);
        }
        i2 += 1;
      }
      i1 += 1;
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
      int i8 = DanmakuContext.a().j();
      if ((!paramBaseDanmaku.b(this.h.b())) && (!paramBaseDanmaku.a(this.g.a())) && (!e(paramBaseDanmaku)))
      {
        if (!paramBaseDanmaku.n()) {
          DanmakuMeasureManager.a(this.e, paramBaseDanmaku);
        }
        int i2 = paramBaseDanmaku.d(paramInt);
        if (i2 >= 0) {
          i3 = i2;
        } else {
          i3 = paramBaseDanmaku.c(paramInt);
        }
        int i1 = 2147483647;
        int i5;
        if (i2 >= 0) {
          i5 = i3 + 1;
        } else {
          i5 = i3 + paramInt;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startLayout, startLine = ");
        ((StringBuilder)localObject).append(i3);
        ((StringBuilder)localObject).append(", maxLine = ");
        ((StringBuilder)localObject).append(i5);
        ((StringBuilder)localObject).append(", danmaku = ");
        ((StringBuilder)localObject).append(paramBaseDanmaku);
        Logger.c("TimiR2LWindow", ((StringBuilder)localObject).toString());
        int i6;
        for (i2 = 0; i3 < i5; i2 = i6)
        {
          i4 = i3;
          while (i4 >= paramInt) {
            i4 -= paramInt;
          }
          if (Logger.a >= 5)
          {
            Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " try layout" });
            i6 = 0;
            while (i6 < paramInt)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("row ");
              localStringBuilder.append(i6);
              if (paramArrayOfBaseDanmaku[i6] == null) {
                localObject = " null";
              } else {
                localObject = paramArrayOfBaseDanmaku[i6];
              }
              localStringBuilder.append(localObject);
              Logger.b("TimiR2LWindow", localStringBuilder.toString());
              i6 += 1;
            }
          }
          if (paramArrayOfBaseDanmaku[i4] == null)
          {
            paramArrayOfBaseDanmaku[i4] = paramBaseDanmaku;
            ((List)paramList.get(i4)).add(paramBaseDanmaku);
            this.a += 1;
            a(paramBaseDanmaku, paramArrayOfInt[i4], i8);
            i3 = i1;
            paramInt = i2;
            if (Logger.a >= 4)
            {
              Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " layout success:", Integer.valueOf(i4), ",top:", Integer.valueOf(paramArrayOfInt[i4]) });
              paramInt = i2;
              i3 = i1;
            }
          }
          for (;;)
          {
            i1 = 1;
            break label696;
            if (paramArrayOfBaseDanmaku[i4].g()) {
              break;
            }
            i6 = DanmakuUtils.a(paramArrayOfBaseDanmaku[i4], paramBaseDanmaku, this.h.b());
            if (i6 < i1)
            {
              i1 = i6;
              i2 = i4;
            }
            i7 = i1;
            i6 = i2;
            if (i1 >= 0) {
              break label665;
            }
            paramArrayOfBaseDanmaku[i4] = paramBaseDanmaku;
            ((List)paramList.get(i4)).add(paramBaseDanmaku);
            this.a += 1;
            a(paramBaseDanmaku, paramArrayOfInt[i4], i8);
            i3 = i1;
            paramInt = i2;
            if (Logger.a >= 4)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramArrayOfInt[i4]);
              ((StringBuilder)localObject).append(", hitTime = ");
              ((StringBuilder)localObject).append(i1);
              Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " layout success:", Integer.valueOf(i4), ",top:", ((StringBuilder)localObject).toString() });
              i3 = i1;
              paramInt = i2;
            }
          }
          i6 = i2;
          int i7 = i1;
          label665:
          i3 += 1;
          i1 = i7;
        }
        int i4 = 0;
        paramInt = i2;
        int i3 = i1;
        i1 = i4;
        label696:
        i2 = i1;
        if (i1 == 0)
        {
          i2 = i1;
          if (paramBaseDanmaku.a(i3))
          {
            paramArrayOfBaseDanmaku[paramInt] = paramBaseDanmaku;
            ((List)paramList.get(paramInt)).add(paramBaseDanmaku);
            this.a += 1;
            a(paramBaseDanmaku, paramArrayOfInt[paramInt], i8);
            if (Logger.a >= 4)
            {
              paramArrayOfBaseDanmaku = new StringBuilder();
              paramArrayOfBaseDanmaku.append(paramArrayOfInt[paramInt]);
              paramArrayOfBaseDanmaku.append(", danmakuRepeatTime = ");
              paramArrayOfBaseDanmaku.append(paramBaseDanmaku.D());
              Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " layout success:", Integer.valueOf(paramInt), ",top:", paramArrayOfBaseDanmaku.toString() });
            }
            i2 = 1;
          }
        }
        if (i2 == 0)
        {
          this.c.add(paramBaseDanmaku);
          if (Logger.a >= 4) {
            Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " can not in window" });
          }
        }
        if ((paramBaseDanmaku.P()) && (i2 != 0))
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
      int i2 = 0;
      int i1 = 0;
      while (i2 < paramList.size())
      {
        int i3 = 0;
        while (i3 < ((List)paramList.get(i2)).size())
        {
          paramArrayOfInt = (BaseDanmaku)((List)paramList.get(i2)).get(i3);
          if (paramArrayOfInt == paramBaseDanmaku) {
            i1 = 1;
          }
          if (i1 != 0) {
            paramArrayOfInt.f();
          }
          i3 += 1;
        }
        i2 += 1;
      }
    }
  }
  
  private void a(WindowConfig paramWindowConfig)
  {
    if ((this.m == null) || (this.l != paramWindowConfig.b()))
    {
      this.l = paramWindowConfig.b();
      i1 = this.l;
      this.m = new int[i1];
      paramWindowConfig = new BaseDanmaku[i1];
      localObject = this.n;
      if (localObject != null) {
        System.arraycopy(localObject, 0, paramWindowConfig, 0, Math.min(paramWindowConfig.length, localObject.length));
      }
      this.n = paramWindowConfig;
      paramWindowConfig = this.o;
      if (paramWindowConfig != null)
      {
        i1 = paramWindowConfig.size();
        if (i1 < this.l) {
          while (i1 < this.l)
          {
            this.o.add(new LinkedList());
            i1 += 1;
          }
        }
        i1 -= 1;
        while (i1 >= this.l)
        {
          this.o.remove(i1);
          i1 -= 1;
        }
      }
      this.o = new ArrayList(this.l);
      i1 = 0;
      while (i1 < this.l)
      {
        this.o.add(new LinkedList());
        i1 += 1;
      }
    }
    int i2 = this.e.c();
    Object localObject = new StringBuilder("[");
    int i1 = 0;
    while (i1 < this.l)
    {
      paramWindowConfig = this.m;
      paramWindowConfig[i1] = (i1 * i2 + this.i);
      ((StringBuilder)localObject).append(paramWindowConfig[i1]);
      if (i1 != this.l - 1) {
        paramWindowConfig = ", ";
      } else {
        paramWindowConfig = "";
      }
      ((StringBuilder)localObject).append(paramWindowConfig);
      i1 += 1;
    }
    if ((this.p == null) && (this.s > 0)) {
      this.p = new int[3];
    }
    if ((this.q == null) && (this.s > 0)) {
      this.q = new BaseDanmaku[3];
    }
    if ((this.r == null) && (this.s > 0)) {
      this.r = new TimiR2LWindow.1(this);
    }
    i1 = this.s;
    if (i1 > 0)
    {
      int i3 = (int)(i1 / 2 - DrawUtils.a(j) / 2.0F - k);
      i1 = 0;
      while (i1 < 3)
      {
        this.p[i1] = (k * i1 + i3);
        i1 += 1;
      }
      a(this.r, this.p);
    }
    ((StringBuilder)localObject).append("]");
    Logger.b("TimiR2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.l), Integer.valueOf(this.i), Integer.valueOf(i2), localObject });
    a(this.o, this.m);
  }
  
  private void a(List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      if (paramList == null) {
        return;
      }
      int i2 = paramList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        Iterator localIterator = ((List)paramList.get(i1)).iterator();
        while (localIterator.hasNext())
        {
          R2LDanmaku localR2LDanmaku = (R2LDanmaku)localIterator.next();
          localR2LDanmaku.a();
          long l1 = this.h.b();
          int i3 = (int)localR2LDanmaku.s();
          b(localR2LDanmaku);
          localR2LDanmaku.h(l1 - (int)((localR2LDanmaku.H() - i3) / -localR2LDanmaku.i()));
          localR2LDanmaku.i(paramArrayOfInt[i1]);
          localR2LDanmaku.h(i3);
        }
        i1 += 1;
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
      int i1 = 0;
      if (i1 < paramList.size())
      {
        Iterator localIterator = ((List)paramList.get(i1)).iterator();
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            i1 += 1;
            break;
          }
          BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
          if ((localBaseDanmaku.b(this.h.b())) || (!localBaseDanmaku.p()))
          {
            if (localBaseDanmaku == paramArrayOfBaseDanmaku[i1]) {
              paramArrayOfBaseDanmaku[i1] = null;
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
      int i3 = 0;
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= paramArrayOfBaseDanmaku.length) {
          break;
        }
        paramArrayOfBaseDanmaku[i1] = null;
        i1 += 1;
      }
      while (i2 < paramList.size())
      {
        paramArrayOfBaseDanmaku = ((List)paramList.get(i2)).iterator();
        while (paramArrayOfBaseDanmaku.hasNext())
        {
          BaseDanmaku localBaseDanmaku = (BaseDanmaku)paramArrayOfBaseDanmaku.next();
          paramArrayOfBaseDanmaku.remove();
          this.a -= 1;
          this.c.add(localBaseDanmaku);
        }
        i2 += 1;
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
      int i2 = 0;
      int i1 = 0;
      while (i2 < paramList.size())
      {
        int i3 = 0;
        while (i3 < ((List)paramList.get(i2)).size())
        {
          paramArrayOfInt = (BaseDanmaku)((List)paramList.get(i2)).get(i3);
          if (paramArrayOfInt == paramBaseDanmaku) {
            i1 = 1;
          }
          if (i1 != 0) {
            paramArrayOfInt.h();
          }
          i3 += 1;
        }
        i2 += 1;
      }
    }
  }
  
  private int c(BaseDanmaku<DanmakuDataBean, DanmakuUIConfig> paramBaseDanmaku, int[] paramArrayOfInt, List<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>> paramList)
  {
    int i2 = -1;
    int i1 = i2;
    if (paramArrayOfInt != null)
    {
      if (paramList == null) {
        return -1;
      }
      i1 = i2;
      if (paramBaseDanmaku != null)
      {
        i1 = 0;
        i2 = -1;
        while (i1 < paramArrayOfInt.length)
        {
          if (paramBaseDanmaku.t() == paramArrayOfInt[i1]) {
            i2 = i1;
          }
          i1 += 1;
        }
        if (paramList.size() <= i2) {
          return -1;
        }
        i1 = i2;
      }
    }
    return i1;
  }
  
  private boolean e(BaseDanmaku<DanmakuDataBean, DanmakuUIConfig> paramBaseDanmaku)
  {
    int i1 = 0;
    while (i1 < this.o.size())
    {
      if (((List)this.o.get(i1)).contains(paramBaseDanmaku))
      {
        Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " is repeat" });
        return true;
      }
      i1 += 1;
    }
    if (this.r != null)
    {
      i1 = 0;
      while (i1 < this.r.size())
      {
        if (((List)this.r.get(i1)).contains(paramBaseDanmaku))
        {
          Logger.b("TimiR2LWindow", new Object[] { paramBaseDanmaku, " is repeat" });
          return true;
        }
        i1 += 1;
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
      if (localBaseDanmaku.q() == 1) {
        a(localBaseDanmaku, this.l, this.m, this.n, this.o);
      } else {
        a(localBaseDanmaku, 3, this.p, this.q, this.r);
      }
    }
  }
  
  public BaseDanmaku a(TouchPoint paramTouchPoint)
  {
    BaseDanmaku localBaseDanmaku = a(paramTouchPoint, this.r);
    if (localBaseDanmaku != null) {
      return localBaseDanmaku;
    }
    paramTouchPoint = a(paramTouchPoint, this.o);
    if (paramTouchPoint != null) {
      return paramTouchPoint;
    }
    Logger.a("TimiR2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    WindowConfig localWindowConfig = DanmakuContext.a();
    this.i = localWindowConfig.c();
    a(localWindowConfig);
    a(this.o, this.m);
  }
  
  public void b()
  {
    g();
    a(this.o, this.n);
    a(this.r, this.q);
  }
  
  public void b(Canvas paramCanvas, long paramLong)
  {
    a(paramCanvas, this.o);
    a(paramCanvas, this.r);
  }
  
  public void c()
  {
    a(this.n, this.o);
    a(this.q, this.r);
  }
  
  public void c(BaseDanmaku paramBaseDanmaku)
  {
    a(paramBaseDanmaku, this.m, this.o);
    a(paramBaseDanmaku, this.p, this.r);
  }
  
  public void d(BaseDanmaku paramBaseDanmaku)
  {
    b(paramBaseDanmaku, this.m, this.o);
    b(paramBaseDanmaku, this.p, this.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.TimiR2LWindow
 * JD-Core Version:    0.7.0.1
 */