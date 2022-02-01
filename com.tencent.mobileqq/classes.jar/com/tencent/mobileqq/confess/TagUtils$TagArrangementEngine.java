package com.tencent.mobileqq.confess;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class TagUtils$TagArrangementEngine
{
  public ArrayList<TagUtils.TagOriginal> a = new ArrayList();
  public Rect b = new Rect();
  public ArrayList<Rect> c = new ArrayList();
  public ArrayList<Rect> d = new ArrayList();
  public ArrayList<Rect> e = new ArrayList();
  public ArrayList<Rect> f = new ArrayList();
  public ArrayList<TagUtils.Tag> g = new ArrayList();
  public ArrayList<Rect> h = new ArrayList();
  private Rect i = new Rect();
  private boolean j = false;
  
  private Rect a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt4 <= paramInt2) && (paramInt3 <= paramInt1))
    {
      Rect localRect;
      if (paramRect.width() - paramInt3 < TagUtils.a + 8)
      {
        paramInt7 = paramInt1;
      }
      else
      {
        this.i.set(paramRect);
        if (paramInt5 == -1)
        {
          localRect = this.i;
          localRect.left += paramInt3;
        }
        else if (paramInt5 == 1)
        {
          localRect = this.i;
          localRect.right -= paramInt3;
        }
        else
        {
          localRect = this.i;
          localRect.right = (localRect.left + (this.i.width() - paramInt3) / 2);
        }
        paramInt7 = paramInt1;
        if (a(this.i, paramRect, paramInt8))
        {
          paramInt1 = paramInt3;
          if (this.i.width() > paramInt8 + 8)
          {
            if (paramInt5 == -1)
            {
              localRect = this.i;
              localRect.left += 8;
            }
            else if (paramInt5 == 1)
            {
              localRect = this.i;
              localRect.right -= 8;
            }
            else
            {
              localRect = this.i;
              localRect.right -= 8;
            }
            paramInt1 = paramInt3;
            if (a(this.i, paramRect, paramInt8)) {
              paramInt1 = paramInt3 + 8;
            }
          }
          paramInt7 = paramInt1;
        }
      }
      if (paramRect.height() - paramInt4 >= TagUtils.a + 8)
      {
        this.i.set(paramRect);
        if (paramInt6 == -1)
        {
          localRect = this.i;
          localRect.top += paramInt4;
        }
        else if (paramInt6 == 1)
        {
          localRect = this.i;
          localRect.bottom -= paramInt4;
        }
        else
        {
          localRect = this.i;
          localRect.bottom = (localRect.top + (this.i.bottom - this.i.height()) / 2);
        }
        if (a(this.i, paramRect, paramInt8))
        {
          paramInt1 = paramInt4;
          if (this.i.height() > paramInt8 + 8)
          {
            if (paramInt6 == -1)
            {
              localRect = this.i;
              localRect.top += 8;
            }
            else if (paramInt6 == 1)
            {
              localRect = this.i;
              localRect.bottom -= 8;
            }
            else
            {
              localRect = this.i;
              localRect.bottom -= 8;
            }
            paramInt1 = paramInt4;
            if (a(this.i, paramRect, paramInt8)) {
              paramInt1 = paramInt4 + 8;
            }
          }
          paramInt2 = paramInt1;
        }
      }
      paramRect = new Rect(paramRect);
      if (paramInt6 == -1)
      {
        paramRect.bottom = (paramRect.top + paramInt2);
      }
      else if (paramInt6 == 1)
      {
        paramRect.top = (paramRect.bottom - paramInt2);
      }
      else
      {
        paramRect.top += (paramRect.height() - paramInt2) / 2;
        paramRect.bottom = (paramRect.top + paramInt2);
      }
      if (paramInt5 == -1)
      {
        paramRect.right = (paramRect.left + paramInt7);
        return paramRect;
      }
      if (paramInt5 == 1)
      {
        paramRect.left = (paramRect.right - paramInt7);
        return paramRect;
      }
      paramRect.left += (paramRect.width() - paramInt7) / 2;
      paramRect.right = (paramRect.left + paramInt7);
      return paramRect;
    }
    return null;
  }
  
  private Rect a(Rect paramRect, boolean paramBoolean)
  {
    int m = paramRect.width() * paramRect.height();
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      TagUtils.Tag localTag = (TagUtils.Tag)localIterator.next();
      int k = localTag.c.width();
      int n = localTag.c.height();
      if (((paramBoolean) || (m * 5 < k * n) || (m <= 576)) && (a(paramRect, localTag.c)))
      {
        localTag.c.union(paramRect);
        a(localTag, localTag.c);
        return paramRect;
      }
      if (paramBoolean)
      {
        Rect localRect = new Rect(paramRect);
        n = localRect.left;
        int i1 = localTag.c.left;
        k = 1;
        if ((n <= i1) && (localRect.right >= localTag.c.right))
        {
          localRect.left = localTag.c.left;
          localRect.right = localTag.c.right;
        }
        else if ((paramRect.top <= localTag.c.top) && (paramRect.bottom >= localTag.c.bottom))
        {
          localRect.top = localTag.c.top;
          localRect.bottom = localTag.c.bottom;
        }
        else
        {
          k = 0;
        }
        if ((k != 0) && (a(localRect, localTag.c)))
        {
          localTag.c.union(localRect);
          a(localTag, localTag.c);
          return localRect;
        }
      }
    }
    return null;
  }
  
  private Rect a(TagUtils.TagOriginal paramTagOriginal, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = paramTagOriginal.g;
    int i1 = paramTagOriginal.b;
    int n = 1;
    int k = m;
    if (i1 >= 1) {
      k = Math.max(24, (int)(m * (0.95F - TagUtils.b.nextInt(10) / 100.0F))) / 4 * 4;
    }
    int i2 = 0;
    Object localObject1 = null;
    m = k;
    k = n;
    while ((i2 < 10) && (m >= 24))
    {
      float f1 = m;
      int i3 = (int)(paramTagOriginal.e * f1);
      localObject2 = localObject1;
      n = k;
      float f2 = f1;
      i1 = m;
      if (paramInt1 * paramInt2 >= m * i3)
      {
        Iterator localIterator = paramTagOriginal.h.iterator();
        for (;;)
        {
          localObject2 = localObject1;
          n = k;
          f2 = f1;
          i1 = m;
          if (!localIterator.hasNext()) {
            break;
          }
          k = ((Integer)localIterator.next()).intValue();
          i1 = i3 / k;
          n = m;
          localObject1 = a(paramRect, paramInt1, paramInt2, i1, m * k, paramInt3, paramInt4, m, 24);
          if (localObject1 != null)
          {
            m = n;
            break label250;
          }
          m = n;
        }
      }
      m = i1;
      f1 = f2;
      k = n;
      localObject1 = localObject2;
      label250:
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        n = k;
        break label336;
      }
      i1 = m;
      localObject2 = localObject1;
      n = k;
      m = i1;
      if (i1 <= 24) {
        break label336;
      }
      m = Math.max(24, (int)(f1 * (0.95F - TagUtils.b.nextInt(6) / 100.0F))) / 4 * 4;
      i2 += 1;
    }
    n = k;
    Object localObject2 = localObject1;
    label336:
    if (localObject2 == null) {
      return null;
    }
    if ((localObject2 != null) && (n > 0))
    {
      paramTagOriginal = new TagUtils.Tag(paramTagOriginal, -1, localObject2, m, true, n);
      a(paramTagOriginal, localObject2);
      this.g.add(paramTagOriginal);
      return localObject2;
    }
    return null;
  }
  
  private void a()
  {
    this.a.clear();
    this.b.setEmpty();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.g.clear();
    this.h.clear();
    this.i.setEmpty();
    this.j = false;
  }
  
  private void a(Rect paramRect)
  {
    int k = this.c.size();
    Rect localRect1 = new Rect();
    k -= 1;
    while (k >= 0)
    {
      Rect localRect2 = (Rect)this.c.get(k);
      localRect1.set(paramRect);
      if (localRect1.intersect(localRect2)) {
        a(localRect2, localRect1, false);
      }
      k -= 1;
    }
  }
  
  private void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    this.c.remove(paramRect1);
    if (paramBoolean) {
      this.f.add(paramRect2);
    }
    if (paramRect2.equals(paramRect1)) {
      return;
    }
    Point localPoint1 = new Point(paramRect1.left, paramRect1.top);
    Point localPoint2 = new Point(paramRect1.left, paramRect1.bottom);
    Point localPoint3 = new Point(paramRect1.right, paramRect1.top);
    Point localPoint4 = new Point(paramRect1.right, paramRect1.bottom);
    Point localPoint5 = new Point(paramRect2.left, paramRect2.top);
    Point localPoint6 = new Point(paramRect2.left, paramRect2.bottom);
    Point localPoint7 = new Point(paramRect2.right, paramRect2.top);
    Point localPoint8 = new Point(paramRect2.right, paramRect2.bottom);
    if ((localPoint1.equals(localPoint5)) && (localPoint2.equals(localPoint6)))
    {
      this.c.add(new Rect(paramRect2.right, paramRect2.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((localPoint1.equals(localPoint5)) && (localPoint3.equals(localPoint7)))
    {
      this.c.add(new Rect(paramRect2.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((localPoint4.equals(localPoint8)) && (localPoint3.equals(localPoint7)))
    {
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect2.bottom));
      return;
    }
    if ((localPoint2.equals(localPoint6)) && (localPoint4.equals(localPoint8)))
    {
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.right, paramRect2.top));
      return;
    }
    if (localPoint1.equals(localPoint5))
    {
      this.c.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      this.c.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (localPoint3.equals(localPoint7))
    {
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.c.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (localPoint4.equals(localPoint8))
    {
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      return;
    }
    if (localPoint2.equals(localPoint6))
    {
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.c.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((paramRect1.left == paramRect2.left) && (paramRect1.right == paramRect2.right))
    {
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.c.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((paramRect1.top == paramRect2.top) && (paramRect1.bottom == paramRect2.bottom))
    {
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.c.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.left == paramRect2.left)
    {
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.c.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      this.c.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.top == paramRect2.top)
    {
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.c.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      this.c.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.right == paramRect2.right)
    {
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.c.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.bottom == paramRect2.bottom)
    {
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.c.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
    this.c.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
    this.c.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
    this.c.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
  }
  
  private void a(TagUtils.Tag paramTag, Rect paramRect)
  {
    Object localObject1 = paramRect;
    paramTag.h.clear();
    int i6 = paramTag.i;
    int i7 = paramTag.d;
    float f1 = paramTag.a.e;
    if (Math.abs(((Rect)localObject1).left - this.b.left) <= 1) {
      k = 1;
    } else {
      k = 0;
    }
    if (Math.abs(((Rect)localObject1).right - this.b.right) <= 1) {
      m = 1;
    } else {
      m = 0;
    }
    if (Math.abs(((Rect)localObject1).top - this.b.top) <= 1) {
      n = 1;
    } else {
      n = 0;
    }
    if (Math.abs(((Rect)localObject1).bottom - this.b.bottom) <= 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = k;
    int i5 = m;
    int i3 = n;
    int i4 = i1;
    Object localObject2;
    if (!this.e.isEmpty())
    {
      localObject2 = this.e.iterator();
      for (;;)
      {
        i2 = k;
        i5 = m;
        i3 = n;
        i4 = i1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        Rect localRect = (Rect)((Iterator)localObject2).next();
        i2 = m;
        if (Math.abs(localRect.left - ((Rect)localObject1).right) <= 1) {
          i2 = 1;
        }
        i3 = k;
        if (Math.abs(localRect.right - ((Rect)localObject1).left) <= 1) {
          i3 = 1;
        }
        i4 = i1;
        if (Math.abs(localRect.top - ((Rect)localObject1).bottom) <= 1) {
          i4 = 1;
        }
        k = i3;
        m = i2;
        i1 = i4;
        if (Math.abs(localRect.bottom - ((Rect)localObject1).top) <= 1)
        {
          n = 1;
          k = i3;
          m = i2;
          i1 = i4;
        }
      }
    }
    if ((i2 != 0) && (i5 != 0))
    {
      k = 1;
    }
    else
    {
      if ((i2 != 0) || (i5 != 0)) {
        break label384;
      }
      k = 0;
    }
    i2 = 0;
    int m = k;
    break label416;
    label384:
    if (i2 != 0) {
      k = -1;
    } else if (i5 != 0) {
      k = 1;
    } else {
      k = 0;
    }
    m = 0;
    i2 = k;
    label416:
    if ((i3 != 0) && (i4 != 0))
    {
      k = 1;
    }
    else
    {
      if ((i3 != 0) || (i4 != 0)) {
        break label458;
      }
      k = 0;
    }
    i3 = 0;
    int n = k;
    break label490;
    label458:
    if (i3 != 0) {
      k = -1;
    } else if (i4 != 0) {
      k = 1;
    } else {
      k = 0;
    }
    n = 0;
    i3 = k;
    label490:
    int i8 = paramTag.a.f / i6;
    float f4 = paramRect.width();
    float f3 = i7;
    float f2 = i6;
    f1 = f4 - f1 * f3 / f2;
    if (i8 <= 1)
    {
      k = (int)(f1 / 2.0F);
      m = k;
      f1 = 0.0F;
    }
    else
    {
      if (m != 0)
      {
        k = 0;
        f1 = (f1 - 0) / (i8 - 1);
      }
      for (;;)
      {
        m = 0;
        break label639;
        k = 0;
        if (i2 == -1)
        {
          f1 = (f1 - 0) / i8;
          m = (int)f1;
          break label639;
        }
        if (i2 != 1) {
          break;
        }
        f1 = (f1 - 0) / i8;
        k = (int)f1;
      }
      f1 /= (i8 + 1);
      k = (int)f1;
      m = k;
    }
    label639:
    f4 = paramRect.height() - i7 * i6;
    if (i6 <= 1)
    {
      n = (int)(f4 / 2.0F);
      i1 = n;
      f2 = 0.0F;
    }
    for (;;)
    {
      break;
      if (n != 0)
      {
        n = 0;
        f2 = (f4 - 0) / (i6 - 1);
      }
      for (;;)
      {
        i1 = 0;
        break;
        n = 0;
        if (i3 == -1)
        {
          f2 = (f4 - 0) / f2;
          i1 = (int)f2;
          break;
        }
        if (i3 != 1) {
          break label753;
        }
        f2 = (f4 - 0) / f2;
        n = (int)f2;
      }
      label753:
      f2 = f4 / (i6 + 1);
      n = (int)f2;
      i1 = n;
    }
    f4 = Math.max(f1, 0.0F);
    int k = Math.max(k, 0);
    Math.max(m, 0);
    float f5 = Math.max(f2, 0.0F);
    m = Math.max(n, 0);
    Math.max(i1, 0);
    boolean bool = TagUtils.b.nextBoolean();
    f1 = ((Rect)localObject1).top + m;
    m = 0;
    n = k;
    k = m;
    int i1 = i6;
    while (k < i1)
    {
      f2 = paramRect.left + n;
      i4 = 0;
      while (i4 < i8)
      {
        i5 = k * i8 + i4;
        m = i5;
        if (bool)
        {
          m = i5;
          if (i8 == 2)
          {
            m = i5;
            if (i1 > 2) {
              if (i4 == 0) {
                m = k;
              } else {
                m = i1 + k;
              }
            }
          }
        }
        localObject1 = (Pair)paramTag.a.d.get(m);
        localObject2 = new TagUtils.Tag.Child(new Rect(Math.round(f2), Math.round(f1), Math.round(f2 + ((Float)((Pair)localObject1).second).floatValue() * f3), Math.round(f1 + f3)), (String)((Pair)localObject1).first);
        paramTag.h.add(localObject2);
        f2 = f2 + ((Float)((Pair)localObject1).second).floatValue() * f3 + f4;
        i4 += 1;
      }
      f1 = f1 + f3 + f5;
      k += 1;
    }
    paramTag.f = i2;
    paramTag.g = i3;
  }
  
  private void a(ArrayList<TagUtils.TagOriginal> paramArrayList, boolean paramBoolean)
  {
    Collections.sort(paramArrayList, new TagUtils.TagArrangementEngine.4(this, paramBoolean, paramArrayList));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.c.isEmpty()) {
      return;
    }
    new Rect();
    int m;
    for (int k = 0; (this.c.size() > 0) && (k < 100); k = m)
    {
      m = k + 1;
      Collections.sort(this.c, new TagUtils.TagArrangementEngine.2(this));
      int n = this.c.size();
      Rect localRect1 = null;
      Rect localRect2 = localRect1;
      k = 0;
      while (k < n)
      {
        localRect1 = (Rect)this.c.get(k);
        localRect2 = a(localRect1, paramBoolean);
        if (localRect2 != null)
        {
          k = 1;
          break label121;
        }
        k += 1;
      }
      k = 0;
      label121:
      if ((k == 0) || (localRect1 == null) || (localRect2 == null)) {
        break;
      }
      if (localRect2.equals(localRect1)) {
        this.c.remove(localRect1);
      }
      a(localRect2);
      b();
      this.d.add(localRect2);
    }
  }
  
  private boolean a(Rect paramRect1, Rect paramRect2)
  {
    if (!paramRect1.contains(paramRect2))
    {
      if (paramRect2.contains(paramRect1)) {
        return true;
      }
      if ((Math.abs(paramRect1.width() - paramRect2.width()) <= 2) && (Math.abs(paramRect1.left - paramRect2.left) <= 2) && (((paramRect1.top < paramRect2.top) && (paramRect1.bottom + 2 > paramRect2.top)) || ((paramRect2.top < paramRect1.top) && (paramRect2.bottom + 2 > paramRect1.top)))) {
        return true;
      }
      return (Math.abs(paramRect1.height() - paramRect2.height()) <= 2) && (Math.abs(paramRect1.top - paramRect2.top) <= 2) && (((paramRect1.left < paramRect2.left) && (paramRect1.right + 2 > paramRect2.left)) || ((paramRect2.left < paramRect1.left) && (paramRect2.right + 2 > paramRect1.left)));
    }
    return true;
  }
  
  private boolean a(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (a((TagUtils.TagOriginal)localIterator.next(), paramRect1, paramInt)) {
        return true;
      }
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      Rect localRect = (Rect)localIterator.next();
      if ((localRect != paramRect2) && (a(localRect, paramRect1))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(TagUtils.TagOriginal paramTagOriginal, Rect paramRect, int paramInt)
  {
    Iterator localIterator = paramTagOriginal.h.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (((paramRect.width() + 8) * localInteger.intValue() >= paramTagOriginal.e * paramInt) && (paramRect.height() + 8 >= localInteger.intValue() * paramInt)) {
        return true;
      }
    }
    return false;
  }
  
  private Rect b(Rect paramRect)
  {
    boolean bool;
    int k;
    int m;
    int n;
    Object localObject2;
    if (this.j)
    {
      bool = false;
      k = 0;
      m = 1;
    }
    else
    {
      bool = this.e.isEmpty();
      m = -1;
      if (!bool)
      {
        localObject1 = this.e.iterator();
        k = -1;
        n = m;
        for (;;)
        {
          m = n;
          i1 = k;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (Rect)((Iterator)localObject1).next();
          if (((Rect)localObject2).left == paramRect.right) {
            n = 1;
          } else if (((Rect)localObject2).top == paramRect.bottom) {
            k = 1;
          }
        }
      }
      i1 = -1;
      k = i1;
      if (Math.abs(paramRect.top - this.b.top) > Math.abs(paramRect.bottom - this.b.bottom)) {
        k = 1;
      }
      if (Math.abs(paramRect.left - this.b.left) > Math.abs(paramRect.right - this.b.right)) {
        m = 1;
      }
      if (paramRect.width() < paramRect.height())
      {
        n = k;
        bool = true;
        k = m;
        m = n;
      }
      else
      {
        n = m;
        bool = false;
        m = k;
        k = n;
      }
    }
    a(this.a, bool);
    int i2 = this.b.width();
    int i3 = this.b.height();
    if (this.a.size() <= 2)
    {
      n = i2;
      i1 = i3;
      if (this.g.size() < 1) {}
    }
    else
    {
      double d1 = i3;
      Double.isNaN(d1);
      i1 = (int)(d1 * 0.85D);
      d1 = i2;
      Double.isNaN(d1);
      n = (int)(d1 * 0.85D);
    }
    int i1 = Math.min(paramRect.width(), i1);
    i2 = Math.min(paramRect.height(), n);
    if (this.j) {
      n = TagUtils.b.nextInt(this.a.size());
    } else {
      n = TagUtils.b.nextInt(Math.min(this.a.size(), 3));
    }
    if (n != 0)
    {
      localObject1 = (TagUtils.TagOriginal)this.a.get(0);
      localObject2 = this.a;
      ((ArrayList)localObject2).set(0, ((ArrayList)localObject2).get(n));
      this.a.set(n, localObject1);
    }
    Object localObject1 = this.a.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = a((TagUtils.TagOriginal)((Iterator)localObject1).next(), paramRect, i1, i2, k, m);
      if (localObject2 != null) {
        return localObject2;
      }
    }
    return null;
  }
  
  private void b()
  {
    if (this.c.size() <= 1) {
      return;
    }
    int k = this.c.size();
    Rect localRect1 = null;
    k -= 1;
    while (k >= 0)
    {
      Rect localRect2 = (Rect)this.c.get(k);
      int i1 = 0;
      int m = k - 1;
      int n;
      for (;;)
      {
        n = i1;
        if (m < 0) {
          break;
        }
        localRect1 = (Rect)this.c.get(m);
        if (a(localRect2, localRect1))
        {
          n = 1;
          break;
        }
        m -= 1;
      }
      if (n != 0)
      {
        localRect1.union(localRect2);
        this.c.remove(localRect2);
      }
      else if ((localRect2.width() <= 1) || (localRect2.height() <= 1))
      {
        this.c.remove(localRect2);
      }
      k -= 1;
    }
  }
  
  private Rect c()
  {
    if (this.c.isEmpty()) {
      return null;
    }
    Collections.sort(this.c, new TagUtils.TagArrangementEngine.1(this));
    Object localObject = (Rect)this.c.get(TagUtils.b.nextInt(Math.min(this.c.size(), 3)));
    if (this.h.contains(localObject))
    {
      localObject = this.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Rect localRect = (Rect)((Iterator)localObject).next();
        if (!this.h.contains(localRect)) {
          return localRect;
        }
      }
      return null;
    }
    return localObject;
  }
  
  private void d()
  {
    if (this.c.isEmpty()) {
      return;
    }
    new Rect();
    int i2 = 0;
    while ((this.c.size() > 0) && (i2 < 200))
    {
      Collections.sort(this.c, new TagUtils.TagArrangementEngine.3(this));
      int m = this.c.size();
      int i1 = TagUtils.a;
      Object localObject2 = null;
      Object localObject1 = null;
      int i3 = 0;
      int k = 0;
      int n = -1;
      Object localObject3;
      int i4;
      int i5;
      int i6;
      for (;;)
      {
        localObject3 = localObject1;
        i4 = k;
        i5 = n;
        i6 = i1;
        if (i3 >= m) {
          break;
        }
        localObject2 = (Rect)this.c.get(i3);
        if ((((Rect)localObject2).width() >= TagUtils.a) && (((Rect)localObject2).height() >= TagUtils.a))
        {
          Iterator localIterator1 = this.a.iterator();
          while (localIterator1.hasNext())
          {
            localObject3 = (TagUtils.TagOriginal)localIterator1.next();
            Iterator localIterator2 = ((TagUtils.TagOriginal)localObject3).h.iterator();
            while (localIterator2.hasNext())
            {
              Integer localInteger = (Integer)localIterator2.next();
              if ((((Rect)localObject2).width() * localInteger.intValue() >= ((TagUtils.TagOriginal)localObject3).e * TagUtils.a) && (((Rect)localObject2).height() >= TagUtils.a * localInteger.intValue()))
              {
                float f1 = ((TagUtils.TagOriginal)localObject3).e / localInteger.intValue();
                float f2 = localInteger.intValue();
                float f3 = Math.min(((Rect)localObject2).width() / f1, ((Rect)localObject2).height() / f2) / 4.0F * 4.0F;
                if (((Rect)localObject2).width() * (((Rect)localObject2).height() - f2 * f3) + ((Rect)localObject2).height() * (((Rect)localObject2).width() - f1 * f3) < 2.147484E+009F)
                {
                  i1 = (int)f3;
                  n = localInteger.intValue();
                  localObject1 = localObject3;
                  k = 1;
                }
              }
            }
          }
          localObject3 = localObject1;
          i6 = k;
          i5 = n;
          i4 = i1;
          if (k != 0)
          {
            localObject3 = localObject1;
            i4 = k;
            i5 = n;
            i6 = i1;
            break;
          }
        }
        else
        {
          i4 = i1;
          i5 = n;
          i6 = k;
          localObject3 = localObject1;
        }
        i3 += 1;
        localObject1 = localObject3;
        k = i6;
        n = i5;
        i1 = i4;
      }
      if ((i4 == 0) || (localObject2 == null) || (i5 <= 0) || (localObject3 == null)) {
        break;
      }
      this.c.remove(localObject2);
      localObject1 = a((Rect)localObject2, ((Rect)localObject2).width(), ((Rect)localObject2).height(), (int)(i6 * ((TagUtils.TagOriginal)localObject3).e / i5), i6 * i5, -1, -1, i6, TagUtils.a);
      if (localObject1 == null) {
        return;
      }
      a((Rect)localObject2, (Rect)localObject1, true);
      localObject2 = new TagUtils.Tag((TagUtils.TagOriginal)localObject3, -1, (Rect)localObject1, i6, false, i5);
      a((TagUtils.Tag)localObject2, (Rect)localObject1);
      this.g.add(localObject2);
      a((Rect)localObject1);
      b();
      i2 += 1;
    }
  }
  
  public ArrayList<TagUtils.Tag> a(ArrayList<TagUtils.TagOriginal> paramArrayList, Rect paramRect, ArrayList<Rect> paramArrayList1)
  {
    a();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()) && (paramRect != null))
    {
      System.currentTimeMillis();
      this.a.addAll(paramArrayList);
      this.b.set(paramRect);
      if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty()))
      {
        this.e.addAll(paramArrayList1);
        k = 1;
      }
      else
      {
        k = 0;
      }
      this.c.add(this.b);
      if (k != 0)
      {
        paramArrayList = this.e.iterator();
        while (paramArrayList.hasNext())
        {
          paramRect = (Rect)paramArrayList.next();
          a(this.b, paramRect, true);
          a(paramRect);
          b();
        }
        this.j = true;
        paramArrayList = (Rect)this.c.get(0);
        paramRect = b(paramArrayList);
        if (paramRect != null)
        {
          a(paramArrayList, paramRect, true);
          a(paramRect);
          b();
        }
        this.j = false;
      }
      int m = 0;
      int k = 0;
      while ((this.c.size() > 0) && (m < 200) && (k < 100))
      {
        m += 1;
        paramArrayList = c();
        if (paramArrayList == null) {
          break;
        }
        paramRect = b(paramArrayList);
        if (paramRect == null)
        {
          k += 1;
          this.h.add(paramArrayList);
        }
        else
        {
          this.h.clear();
          a(paramArrayList, paramRect, true);
          a(paramRect);
          b();
        }
      }
      a(false);
      TagUtils.a = 12;
      paramArrayList = this.a.iterator();
      k = 1;
      while (paramArrayList.hasNext())
      {
        paramRect = (TagUtils.TagOriginal)paramArrayList.next();
        paramRect.a();
        if (paramRect.f != 13) {
          k = 0;
        }
      }
      if (k != 0) {
        TagUtils.a = 8;
      }
      d();
      a(true);
      return this.g;
    }
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TagUtils.TagArrangementEngine
 * JD-Core Version:    0.7.0.1
 */