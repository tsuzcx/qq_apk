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
  protected List<List<BaseDanmaku>> b;
  private int c;
  
  public R2LWindow(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    super(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
  }
  
  private int a(BaseDanmaku paramBaseDanmaku)
  {
    int j = -1;
    int i = j;
    if (paramBaseDanmaku != null)
    {
      i = j;
      if (this.jdField_a_of_type_ArrayOfInt != null)
      {
        if (this.jdField_b_of_type_JavaUtilList == null) {
          return -1;
        }
        i = 0;
        j = -1;
        while (i < this.jdField_a_of_type_ArrayOfInt.length)
        {
          if (paramBaseDanmaku.e() == this.jdField_a_of_type_ArrayOfInt[i]) {
            j = i;
          }
          i += 1;
        }
        if (this.jdField_b_of_type_JavaUtilList.size() <= j) {
          return -1;
        }
        i = j;
      }
    }
    return i;
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
      i = this.c;
      this.jdField_a_of_type_ArrayOfInt = new int[i];
      paramWindowConfig = new BaseDanmaku[i];
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku;
      if (localObject != null) {
        System.arraycopy(localObject, 0, paramWindowConfig, 0, Math.min(paramWindowConfig.length, localObject.length));
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku = paramWindowConfig;
      paramWindowConfig = this.jdField_b_of_type_JavaUtilList;
      if (paramWindowConfig != null)
      {
        i = paramWindowConfig.size();
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
    Object localObject = new StringBuilder("[");
    int i = 0;
    while (i < this.c)
    {
      paramWindowConfig = this.jdField_a_of_type_ArrayOfInt;
      paramWindowConfig[i] = (i * j + this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(paramWindowConfig[i]);
      if (i != this.c - 1) {
        paramWindowConfig = ", ";
      } else {
        paramWindowConfig = "";
      }
      ((StringBuilder)localObject).append(paramWindowConfig);
      i += 1;
    }
    ((StringBuilder)localObject).append("]");
    Logger.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(j), localObject });
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
        int k = (int)localR2LDanmaku.d();
        b(localR2LDanmaku);
        localR2LDanmaku.c(l - (int)((localR2LDanmaku.f() - k) / -localR2LDanmaku.c()));
        localR2LDanmaku.i(paramArrayOfInt[i]);
        localR2LDanmaku.h(k);
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
    int i3 = DanmakuContext.a().e();
    int i = Logger.jdField_a_of_type_Int;
    Object localObject1 = "Danmaku_R2LWindow";
    if (i >= 5) {
      Logger.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilTreeSet.size()) });
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    for (int j = 0; localIterator.hasNext(); j = i)
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
      localIterator.remove();
      if ((!localBaseDanmaku.b(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a())) && (!localBaseDanmaku.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer.a())) && (!a(localBaseDanmaku)))
      {
        if (!localBaseDanmaku.b()) {
          DanmakuMeasureManager.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext, localBaseDanmaku);
        }
        int k = localBaseDanmaku.b(this.c);
        if (k >= 0) {
          m = k;
        } else {
          m = localBaseDanmaku.a(this.c);
        }
        i = 2147483647;
        int i1;
        if (k >= 0) {
          i1 = m + 1;
        } else {
          i1 = this.c + m;
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startLayout, startLine = ");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(", maxLine = ");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(", danmaku = ");
        ((StringBuilder)localObject2).append(localBaseDanmaku);
        Logger.c((String)localObject1, ((StringBuilder)localObject2).toString());
        while (m < i1)
        {
          int n = m;
          for (;;)
          {
            k = this.c;
            if (n < k) {
              break;
            }
            n -= k;
          }
          if (Logger.jdField_a_of_type_Int >= 5)
          {
            Logger.b((String)localObject1, new Object[] { localBaseDanmaku, " try layout" });
            k = 0;
            while (k < this.c)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("row ");
              localStringBuilder.append(k);
              localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku;
              if (localObject2[k] == null) {
                localObject2 = " null";
              } else {
                localObject2 = localObject2[k];
              }
              localStringBuilder.append(localObject2);
              Logger.b((String)localObject1, localStringBuilder.toString());
              k += 1;
            }
          }
          localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku;
          if (localObject2[n] == null)
          {
            localObject2[n] = localBaseDanmaku;
            ((List)this.jdField_b_of_type_JavaUtilList.get(n)).add(localBaseDanmaku);
            this.jdField_a_of_type_Int += 1;
            a(localBaseDanmaku, this.jdField_a_of_type_ArrayOfInt[n], i3);
            if (Logger.jdField_a_of_type_Int >= 4) {
              Logger.b((String)localObject1, new Object[] { localBaseDanmaku, " layout success:", Integer.valueOf(n), ",top:", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[n]) });
            }
            m = j;
          }
          for (;;)
          {
            k = 1;
            j = m;
            break label771;
            if (localObject2[n].a()) {
              break label760;
            }
            int i2 = DanmakuUtils.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[n], localBaseDanmaku, this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a());
            k = j;
            j = i;
            if (i2 < i)
            {
              j = i2;
              k = n;
            }
            if (j >= 0) {
              break;
            }
            this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[n] = localBaseDanmaku;
            ((List)this.jdField_b_of_type_JavaUtilList.get(n)).add(localBaseDanmaku);
            this.jdField_a_of_type_Int += 1;
            a(localBaseDanmaku, this.jdField_a_of_type_ArrayOfInt[n], i3);
            if (Logger.jdField_a_of_type_Int >= 4)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfInt[n]);
              ((StringBuilder)localObject2).append(", hitTime = ");
              ((StringBuilder)localObject2).append(j);
              Logger.b((String)localObject1, new Object[] { localBaseDanmaku, " layout success:", Integer.valueOf(n), ",top:", ((StringBuilder)localObject2).toString() });
              m = k;
              i = j;
            }
            else
            {
              m = k;
              i = j;
            }
          }
          i = j;
          j = k;
          label760:
          m += 1;
        }
        k = 0;
        label771:
        localObject2 = localObject1;
        int m = k;
        if (k == 0)
        {
          m = k;
          if (localBaseDanmaku.a(i))
          {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku[j] = localBaseDanmaku;
            ((List)this.jdField_b_of_type_JavaUtilList.get(j)).add(localBaseDanmaku);
            this.jdField_a_of_type_Int += 1;
            a(localBaseDanmaku, this.jdField_a_of_type_ArrayOfInt[j], i3);
            if (Logger.jdField_a_of_type_Int >= 4)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_ArrayOfInt[j]);
              ((StringBuilder)localObject1).append(", danmakuRepeatTime = ");
              ((StringBuilder)localObject1).append(localBaseDanmaku.e());
              Logger.b((String)localObject2, new Object[] { localBaseDanmaku, " layout success:", Integer.valueOf(j), ",top:", ((StringBuilder)localObject1).toString() });
            }
            m = 1;
          }
        }
        if (m == 0)
        {
          this.jdField_a_of_type_JavaUtilList.add(localBaseDanmaku);
          if (Logger.jdField_a_of_type_Int >= 4) {
            Logger.b((String)localObject2, new Object[] { localBaseDanmaku, " can not in window" });
          }
        }
        localObject1 = localObject2;
        i = j;
        if (localBaseDanmaku.h())
        {
          localObject1 = localObject2;
          i = j;
          if (m != 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("must show danmaku layout success :");
            ((StringBuilder)localObject1).append(localBaseDanmaku);
            Logger.b((String)localObject2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
            i = j;
          }
        }
      }
      else
      {
        if (Logger.jdField_a_of_type_Int >= 5) {
          Logger.b((String)localObject1, new Object[] { localBaseDanmaku, " is out side" });
        }
        this.jdField_a_of_type_JavaUtilList.add(localBaseDanmaku);
        i = j;
      }
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
          BaseDanmaku[] arrayOfBaseDanmaku = this.jdField_a_of_type_ArrayOfComTencentMobileqqDanmakuDataBaseDanmaku;
          if (localBaseDanmaku == arrayOfBaseDanmaku[i]) {
            arrayOfBaseDanmaku[i] = null;
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
            Logger.a("Danmaku_R2LWindow", new Object[] { "onClick:", localBaseDanmaku, "[left:", Float.valueOf(localBaseDanmaku.d()), ",top:", Float.valueOf(localBaseDanmaku.e()), "]" });
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
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (localList != null)
    {
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        localList = (List)this.jdField_b_of_type_JavaUtilList.get(i);
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
    if (j < 0) {
      return;
    }
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
  
  public void d(BaseDanmaku paramBaseDanmaku)
  {
    int i = a(paramBaseDanmaku);
    if (i < 0) {
      return;
    }
    paramBaseDanmaku = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
    while (paramBaseDanmaku.hasNext()) {
      ((BaseDanmaku)paramBaseDanmaku.next()).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.R2LWindow
 * JD-Core Version:    0.7.0.1
 */