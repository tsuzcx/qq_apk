package com.tencent.mobileqq.danmaku.core;

import android.graphics.Canvas;
import android.graphics.Point;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.data.R2LDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.WindowConfig;
import com.tencent.mobileqq.danmaku.tool.DanmakuDrawTimer;
import com.tencent.mobileqq.danmaku.tool.PlayerTimer;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;
import com.tencent.mobileqq.danmaku.util.DanmakuUtils;
import com.tencent.mobileqq.danmaku.util.Logger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class R2LWindow
  extends AbsWindow
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private BaseDanmaku[] jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku;
  protected int b;
  private List<List<BaseDanmaku>> b;
  private int c;
  
  protected R2LWindow(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    super(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
  }
  
  private int a(BaseDanmaku paramBaseDanmaku)
  {
    if ((paramBaseDanmaku == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_JavaUtilList == null)) {}
    int j;
    do
    {
      return -1;
      int i = 0;
      j = -1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramBaseDanmaku.c() == this.jdField_a_of_type_ArrayOfInt[i]) {
          j = i;
        }
        i += 1;
      }
    } while (this.jdField_b_of_type_JavaUtilList.size() <= j);
    return j;
  }
  
  private void a(BaseDanmaku paramBaseDanmaku, int paramInt1, int paramInt2)
  {
    if (paramBaseDanmaku.e()) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.a(paramBaseDanmaku, this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext);
    }
    paramBaseDanmaku.a(paramInt2, paramInt1, this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer.a(), this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a());
  }
  
  private void a(WindowConfig paramWindowConfig)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.c != paramWindowConfig.a()))
    {
      this.c = paramWindowConfig.a();
      this.jdField_a_of_type_ArrayOfInt = new int[this.c];
      paramWindowConfig = new BaseDanmaku[this.c];
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku != null) {
        System.arraycopy(this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku, 0, paramWindowConfig, 0, Math.min(paramWindowConfig.length, this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku.length));
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku = paramWindowConfig;
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i < this.c) {
          while (i < this.c)
          {
            this.jdField_b_of_type_JavaUtilList.add(new LinkedList());
            i += 1;
          }
        }
        i -= 1;
        while (i >= this.c)
        {
          this.jdField_b_of_type_JavaUtilList.remove(i);
          i -= 1;
        }
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList(this.c);
      i = 0;
      while (i < this.c)
      {
        this.jdField_b_of_type_JavaUtilList.add(new LinkedList());
        i += 1;
      }
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a();
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = 0;
    if (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = (i * j + this.jdField_b_of_type_Int);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[i]);
      if (i != this.c - 1) {}
      for (paramWindowConfig = ", ";; paramWindowConfig = "")
      {
        localStringBuilder2.append(paramWindowConfig);
        i += 1;
        break;
      }
    }
    localStringBuilder1.append("]");
    Logger.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(j), localStringBuilder1 });
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  private void a(List<List<BaseDanmaku>> paramList, int[] paramArrayOfInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        R2LDanmaku localR2LDanmaku = (R2LDanmaku)localIterator.next();
        localR2LDanmaku.a();
        long l = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a();
        int k = (int)localR2LDanmaku.b();
        b(localR2LDanmaku);
        localR2LDanmaku.c(l - (int)((localR2LDanmaku.f() - k) / -localR2LDanmaku.a()));
        localR2LDanmaku.h(paramArrayOfInt[i]);
        localR2LDanmaku.g(k);
      }
      i += 1;
    }
  }
  
  private boolean a(BaseDanmaku paramBaseDanmaku)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramBaseDanmaku))
      {
        Logger.b("Danmaku_R2LWindow", new Object[] { paramBaseDanmaku, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    int i2 = DanmakuContext.a().e();
    if (Logger.jdField_a_of_type_Int >= 5) {
      Logger.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilTreeSet.size()) });
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    int i = 0;
    BaseDanmaku localBaseDanmaku;
    int k;
    int j;
    int m;
    label252:
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localBaseDanmaku = (BaseDanmaku)localIterator.next();
        localIterator.remove();
        if ((localBaseDanmaku.b(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a())) || (localBaseDanmaku.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer.a())) || (a(localBaseDanmaku)))
        {
          if (Logger.jdField_a_of_type_Int >= 5) {
            Logger.b("Danmaku_R2LWindow", new Object[] { localBaseDanmaku, " is out side" });
          }
          this.jdField_a_of_type_JavaUtilList.add(localBaseDanmaku);
        }
        else
        {
          if (!localBaseDanmaku.b()) {
            DanmakuMeasureManager.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext, localBaseDanmaku);
          }
          k = localBaseDanmaku.b(this.c);
          if (k >= 0)
          {
            j = k;
            m = 2147483647;
            if (k < 0) {
              break label295;
            }
          }
          label295:
          for (int n = j + 1;; n = this.c + j)
          {
            Logger.c("Danmaku_R2LWindow", "startLayout, startLine = " + j + ", maxLine = " + n + ", danmaku = " + localBaseDanmaku);
            k = j;
            j = m;
            if (k >= n) {
              break label1016;
            }
            m = k;
            while (m >= this.c) {
              m -= this.c;
            }
            j = localBaseDanmaku.a(this.c);
            break;
          }
          if (Logger.jdField_a_of_type_Int >= 5)
          {
            Logger.b("Danmaku_R2LWindow", new Object[] { localBaseDanmaku, " try layout" });
            i1 = 0;
            if (i1 < this.c)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("row ").append(i1);
              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[i1] == null) {}
              for (Object localObject = " null";; localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[i1])
              {
                Logger.b("Danmaku_R2LWindow", localObject);
                i1 += 1;
                break;
              }
            }
          }
          if (this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[m] == null)
          {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[m] = localBaseDanmaku;
            ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localBaseDanmaku);
            this.jdField_a_of_type_Int += 1;
            a(localBaseDanmaku, this.jdField_a_of_type_ArrayOfInt[m], i2);
            if (Logger.jdField_a_of_type_Int >= 4) {
              Logger.b("Danmaku_R2LWindow", new Object[] { localBaseDanmaku, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[m]) });
            }
            m = 1;
            k = i;
            i = m;
          }
        }
      }
    }
    for (;;)
    {
      m = i;
      if (i == 0)
      {
        m = i;
        if (localBaseDanmaku.a(j))
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[k] = localBaseDanmaku;
          ((List)this.jdField_b_of_type_JavaUtilList.get(k)).add(localBaseDanmaku);
          this.jdField_a_of_type_Int += 1;
          a(localBaseDanmaku, this.jdField_a_of_type_ArrayOfInt[k], i2);
          if (Logger.jdField_a_of_type_Int >= 4) {
            Logger.b("Danmaku_R2LWindow", new Object[] { localBaseDanmaku, " layout success:", Integer.valueOf(k), ",top:", this.jdField_a_of_type_ArrayOfInt[k] + ", danmakuRepeatTime = " + localBaseDanmaku.e() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(localBaseDanmaku);
        if (Logger.jdField_a_of_type_Int >= 4) {
          Logger.b("Danmaku_R2LWindow", new Object[] { localBaseDanmaku, " can not in window" });
        }
      }
      if ((localBaseDanmaku.h()) && (m != 0)) {
        Logger.b("Danmaku_R2LWindow", "must show danmaku layout success :" + localBaseDanmaku);
      }
      i = k;
      break;
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[m].a())
      {
        m = i;
        i = j;
        j = m;
        label804:
        k += 1;
        m = i;
        i = j;
        j = m;
        break label252;
      }
      i1 = DanmakuUtils.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[m], localBaseDanmaku, this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a());
      if (i1 < j) {
        j = m;
      }
      for (i = i1;; i = i1)
      {
        if (i < 0)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[m] = localBaseDanmaku;
          ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localBaseDanmaku);
          this.jdField_a_of_type_Int += 1;
          a(localBaseDanmaku, this.jdField_a_of_type_ArrayOfInt[m], i2);
          if (Logger.jdField_a_of_type_Int >= 4) {
            Logger.b("Danmaku_R2LWindow", new Object[] { localBaseDanmaku, " layout success:", Integer.valueOf(m), ",top:", this.jdField_a_of_type_ArrayOfInt[m] + ", hitTime = " + i });
          }
          k = 1;
          m = i;
          i = k;
          k = j;
          j = m;
          break;
          return;
        }
        break label804;
        i1 = j;
        j = i;
      }
      label1016:
      k = i;
      i = 0;
    }
  }
  
  private void f()
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
        if ((localBaseDanmaku.b(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a())) || (!localBaseDanmaku.c()))
        {
          if (localBaseDanmaku == this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[i]) {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[i] = null;
          }
          localIterator.remove();
          this.jdField_a_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localBaseDanmaku);
        }
      }
      i += 1;
    }
  }
  
  public BaseDanmaku a(TouchPoint paramTouchPoint)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
        if ((localBaseDanmaku.d()) && (localBaseDanmaku.a(paramTouchPoint.jdField_a_of_type_AndroidGraphicsPoint.x, paramTouchPoint.jdField_a_of_type_AndroidGraphicsPoint.y, paramTouchPoint.jdField_a_of_type_Int, paramTouchPoint.jdField_a_of_type_Long)))
        {
          if (Logger.jdField_a_of_type_Int >= 5) {
            Logger.a("Danmaku_R2LWindow", new Object[] { "onClick:", localBaseDanmaku, "[left:", Float.valueOf(localBaseDanmaku.b()), ",top:", Float.valueOf(localBaseDanmaku.c()), "]" });
          }
          return localBaseDanmaku;
        }
      }
      i += 1;
    }
    Logger.a("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    WindowConfig localWindowConfig = DanmakuContext.a();
    this.jdField_b_of_type_Int = localWindowConfig.b();
    a(localWindowConfig);
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      int j = this.jdField_b_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        List localList = (List)this.jdField_b_of_type_JavaUtilList.get(i);
        if ((localList != null) && (localList.size() > 0)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public void b()
  {
    e();
    f();
  }
  
  public void b(Canvas paramCanvas, long paramLong)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
        localBaseDanmaku.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.c(), this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a());
        if (!localBaseDanmaku.c(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a())) {
          a(paramCanvas, localBaseDanmaku);
        }
      }
      i += 1;
    }
  }
  
  public void c()
  {
    int j = 0;
    int i = 0;
    while (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
        localIterator.remove();
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localBaseDanmaku);
      }
      i += 1;
    }
  }
  
  public void c(BaseDanmaku paramBaseDanmaku)
  {
    int j = a(paramBaseDanmaku);
    if (j < 0) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(j)).iterator();
      while (localIterator.hasNext())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
        j = i;
        if (localBaseDanmaku == paramBaseDanmaku) {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          localBaseDanmaku.c();
          i = j;
        }
      }
    }
  }
  
  public void d(BaseDanmaku paramBaseDanmaku)
  {
    int i = a(paramBaseDanmaku);
    if (i < 0) {}
    for (;;)
    {
      return;
      paramBaseDanmaku = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (paramBaseDanmaku.hasNext()) {
        ((BaseDanmaku)paramBaseDanmaku.next()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.R2LWindow
 * JD-Core Version:    0.7.0.1
 */