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
  public Rect a;
  public ArrayList<TagUtils.TagOriginal> a;
  private boolean a;
  private Rect b;
  public ArrayList<Rect> b;
  public ArrayList<Rect> c = new ArrayList();
  public ArrayList<Rect> d = new ArrayList();
  public ArrayList<Rect> e = new ArrayList();
  public ArrayList<TagUtils.Tag> f = new ArrayList();
  public ArrayList<Rect> g = new ArrayList();
  
  public TagUtils$TagArrangementEngine()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Rect a()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, new TagUtils.TagArrangementEngine.1(this));
    Object localObject = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(TagUtils.jdField_a_of_type_JavaUtilRandom.nextInt(Math.min(this.jdField_b_of_type_JavaUtilArrayList.size(), 3)));
    if (this.g.contains(localObject))
    {
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Rect localRect = (Rect)((Iterator)localObject).next();
        if (!this.g.contains(localRect)) {
          return localRect;
        }
      }
      return null;
    }
    return localObject;
  }
  
  private Rect a(Rect paramRect)
  {
    boolean bool;
    int i;
    int j;
    int k;
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      bool = false;
      i = 0;
      j = 1;
    }
    else
    {
      bool = this.d.isEmpty();
      j = -1;
      if (!bool)
      {
        localObject1 = this.d.iterator();
        i = -1;
        k = j;
        for (;;)
        {
          j = k;
          m = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (Rect)((Iterator)localObject1).next();
          if (((Rect)localObject2).left == paramRect.right) {
            k = 1;
          } else if (((Rect)localObject2).top == paramRect.bottom) {
            i = 1;
          }
        }
      }
      m = -1;
      i = m;
      if (Math.abs(paramRect.top - this.jdField_a_of_type_AndroidGraphicsRect.top) > Math.abs(paramRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom)) {
        i = 1;
      }
      if (Math.abs(paramRect.left - this.jdField_a_of_type_AndroidGraphicsRect.left) > Math.abs(paramRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right)) {
        j = 1;
      }
      if (paramRect.width() < paramRect.height())
      {
        k = i;
        bool = true;
        i = j;
        j = k;
      }
      else
      {
        k = j;
        bool = false;
        j = i;
        i = k;
      }
    }
    a(this.jdField_a_of_type_JavaUtilArrayList, bool);
    int n = this.jdField_a_of_type_AndroidGraphicsRect.width();
    int i1 = this.jdField_a_of_type_AndroidGraphicsRect.height();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 2)
    {
      k = n;
      m = i1;
      if (this.f.size() < 1) {}
    }
    else
    {
      double d1 = i1;
      Double.isNaN(d1);
      m = (int)(d1 * 0.85D);
      d1 = n;
      Double.isNaN(d1);
      k = (int)(d1 * 0.85D);
    }
    int m = Math.min(paramRect.width(), m);
    n = Math.min(paramRect.height(), k);
    if (this.jdField_a_of_type_Boolean) {
      k = TagUtils.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_JavaUtilArrayList.size());
    } else {
      k = TagUtils.jdField_a_of_type_JavaUtilRandom.nextInt(Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), 3));
    }
    if (k != 0)
    {
      localObject1 = (TagUtils.TagOriginal)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      ((ArrayList)localObject2).set(0, ((ArrayList)localObject2).get(k));
      this.jdField_a_of_type_JavaUtilArrayList.set(k, localObject1);
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = a((TagUtils.TagOriginal)((Iterator)localObject1).next(), paramRect, m, n, i, j);
      if (localObject2 != null) {
        return localObject2;
      }
    }
    return null;
  }
  
  private Rect a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt4 <= paramInt2) && (paramInt3 <= paramInt1))
    {
      Rect localRect;
      if (paramRect.width() - paramInt3 < TagUtils.jdField_a_of_type_Int + 8)
      {
        paramInt7 = paramInt1;
      }
      else
      {
        this.jdField_b_of_type_AndroidGraphicsRect.set(paramRect);
        if (paramInt5 == -1)
        {
          localRect = this.jdField_b_of_type_AndroidGraphicsRect;
          localRect.left += paramInt3;
        }
        else if (paramInt5 == 1)
        {
          localRect = this.jdField_b_of_type_AndroidGraphicsRect;
          localRect.right -= paramInt3;
        }
        else
        {
          localRect = this.jdField_b_of_type_AndroidGraphicsRect;
          localRect.right = (localRect.left + (this.jdField_b_of_type_AndroidGraphicsRect.width() - paramInt3) / 2);
        }
        paramInt7 = paramInt1;
        if (a(this.jdField_b_of_type_AndroidGraphicsRect, paramRect, paramInt8))
        {
          paramInt1 = paramInt3;
          if (this.jdField_b_of_type_AndroidGraphicsRect.width() > paramInt8 + 8)
          {
            if (paramInt5 == -1)
            {
              localRect = this.jdField_b_of_type_AndroidGraphicsRect;
              localRect.left += 8;
            }
            else if (paramInt5 == 1)
            {
              localRect = this.jdField_b_of_type_AndroidGraphicsRect;
              localRect.right -= 8;
            }
            else
            {
              localRect = this.jdField_b_of_type_AndroidGraphicsRect;
              localRect.right -= 8;
            }
            paramInt1 = paramInt3;
            if (a(this.jdField_b_of_type_AndroidGraphicsRect, paramRect, paramInt8)) {
              paramInt1 = paramInt3 + 8;
            }
          }
          paramInt7 = paramInt1;
        }
      }
      if (paramRect.height() - paramInt4 >= TagUtils.jdField_a_of_type_Int + 8)
      {
        this.jdField_b_of_type_AndroidGraphicsRect.set(paramRect);
        if (paramInt6 == -1)
        {
          localRect = this.jdField_b_of_type_AndroidGraphicsRect;
          localRect.top += paramInt4;
        }
        else if (paramInt6 == 1)
        {
          localRect = this.jdField_b_of_type_AndroidGraphicsRect;
          localRect.bottom -= paramInt4;
        }
        else
        {
          localRect = this.jdField_b_of_type_AndroidGraphicsRect;
          localRect.bottom = (localRect.top + (this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_b_of_type_AndroidGraphicsRect.height()) / 2);
        }
        if (a(this.jdField_b_of_type_AndroidGraphicsRect, paramRect, paramInt8))
        {
          paramInt1 = paramInt4;
          if (this.jdField_b_of_type_AndroidGraphicsRect.height() > paramInt8 + 8)
          {
            if (paramInt6 == -1)
            {
              localRect = this.jdField_b_of_type_AndroidGraphicsRect;
              localRect.top += 8;
            }
            else if (paramInt6 == 1)
            {
              localRect = this.jdField_b_of_type_AndroidGraphicsRect;
              localRect.bottom -= 8;
            }
            else
            {
              localRect = this.jdField_b_of_type_AndroidGraphicsRect;
              localRect.bottom -= 8;
            }
            paramInt1 = paramInt4;
            if (a(this.jdField_b_of_type_AndroidGraphicsRect, paramRect, paramInt8)) {
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
    int j = paramRect.width() * paramRect.height();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      TagUtils.Tag localTag = (TagUtils.Tag)localIterator.next();
      int i = localTag.jdField_a_of_type_AndroidGraphicsRect.width();
      int k = localTag.jdField_a_of_type_AndroidGraphicsRect.height();
      if (((paramBoolean) || (j * 5 < i * k) || (j <= 576)) && (a(paramRect, localTag.jdField_a_of_type_AndroidGraphicsRect)))
      {
        localTag.jdField_a_of_type_AndroidGraphicsRect.union(paramRect);
        a(localTag, localTag.jdField_a_of_type_AndroidGraphicsRect);
        return paramRect;
      }
      if (paramBoolean)
      {
        Rect localRect = new Rect(paramRect);
        k = localRect.left;
        int m = localTag.jdField_a_of_type_AndroidGraphicsRect.left;
        i = 1;
        if ((k <= m) && (localRect.right >= localTag.jdField_a_of_type_AndroidGraphicsRect.right))
        {
          localRect.left = localTag.jdField_a_of_type_AndroidGraphicsRect.left;
          localRect.right = localTag.jdField_a_of_type_AndroidGraphicsRect.right;
        }
        else if ((paramRect.top <= localTag.jdField_a_of_type_AndroidGraphicsRect.top) && (paramRect.bottom >= localTag.jdField_a_of_type_AndroidGraphicsRect.bottom))
        {
          localRect.top = localTag.jdField_a_of_type_AndroidGraphicsRect.top;
          localRect.bottom = localTag.jdField_a_of_type_AndroidGraphicsRect.bottom;
        }
        else
        {
          i = 0;
        }
        if ((i != 0) && (a(localRect, localTag.jdField_a_of_type_AndroidGraphicsRect)))
        {
          localTag.jdField_a_of_type_AndroidGraphicsRect.union(localRect);
          a(localTag, localTag.jdField_a_of_type_AndroidGraphicsRect);
          return localRect;
        }
      }
    }
    return null;
  }
  
  private Rect a(TagUtils.TagOriginal paramTagOriginal, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramTagOriginal.c;
    int m = paramTagOriginal.jdField_a_of_type_Int;
    int k = 1;
    int i = j;
    if (m >= 1) {
      i = Math.max(24, (int)(j * (0.95F - TagUtils.jdField_a_of_type_JavaUtilRandom.nextInt(10) / 100.0F))) / 4 * 4;
    }
    int n = 0;
    Object localObject1 = null;
    j = i;
    i = k;
    while ((n < 10) && (j >= 24))
    {
      float f1 = j;
      int i1 = (int)(paramTagOriginal.jdField_a_of_type_Float * f1);
      localObject2 = localObject1;
      k = i;
      float f2 = f1;
      m = j;
      if (paramInt1 * paramInt2 >= j * i1)
      {
        Iterator localIterator = paramTagOriginal.jdField_a_of_type_JavaUtilSet.iterator();
        for (;;)
        {
          localObject2 = localObject1;
          k = i;
          f2 = f1;
          m = j;
          if (!localIterator.hasNext()) {
            break;
          }
          i = ((Integer)localIterator.next()).intValue();
          m = i1 / i;
          k = j;
          localObject1 = a(paramRect, paramInt1, paramInt2, m, j * i, paramInt3, paramInt4, j, 24);
          if (localObject1 != null)
          {
            j = k;
            break label250;
          }
          j = k;
        }
      }
      j = m;
      f1 = f2;
      i = k;
      localObject1 = localObject2;
      label250:
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        k = i;
        break label336;
      }
      m = j;
      localObject2 = localObject1;
      k = i;
      j = m;
      if (m <= 24) {
        break label336;
      }
      j = Math.max(24, (int)(f1 * (0.95F - TagUtils.jdField_a_of_type_JavaUtilRandom.nextInt(6) / 100.0F))) / 4 * 4;
      n += 1;
    }
    k = i;
    Object localObject2 = localObject1;
    label336:
    if (localObject2 == null) {
      return null;
    }
    if ((localObject2 != null) && (k > 0))
    {
      paramTagOriginal = new TagUtils.Tag(paramTagOriginal, -1, localObject2, j, true, k);
      a(paramTagOriginal, localObject2);
      this.f.add(paramTagOriginal);
      return localObject2;
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.g.clear();
    this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Rect paramRect)
  {
    int i = this.jdField_b_of_type_JavaUtilArrayList.size();
    Rect localRect1 = new Rect();
    i -= 1;
    while (i >= 0)
    {
      Rect localRect2 = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      localRect1.set(paramRect);
      if (localRect1.intersect(localRect2)) {
        a(localRect2, localRect1, false);
      }
      i -= 1;
    }
  }
  
  private void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramRect1);
    if (paramBoolean) {
      this.e.add(paramRect2);
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
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect2.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((localPoint1.equals(localPoint5)) && (localPoint3.equals(localPoint7)))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((localPoint4.equals(localPoint8)) && (localPoint3.equals(localPoint7)))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect2.bottom));
      return;
    }
    if ((localPoint2.equals(localPoint6)) && (localPoint4.equals(localPoint8)))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.right, paramRect2.top));
      return;
    }
    if (localPoint1.equals(localPoint5))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (localPoint3.equals(localPoint7))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (localPoint4.equals(localPoint8))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      return;
    }
    if (localPoint2.equals(localPoint6))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((paramRect1.left == paramRect2.left) && (paramRect1.right == paramRect2.right))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((paramRect1.top == paramRect2.top) && (paramRect1.bottom == paramRect2.bottom))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.left == paramRect2.left)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.top == paramRect2.top)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.right == paramRect2.right)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.bottom == paramRect2.bottom)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
    this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
    this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
    this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
  }
  
  private void a(TagUtils.Tag paramTag, Rect paramRect)
  {
    Object localObject1 = paramRect;
    paramTag.jdField_a_of_type_JavaUtilArrayList.clear();
    int i4 = paramTag.e;
    int i5 = paramTag.b;
    float f1 = paramTag.jdField_a_of_type_ComTencentMobileqqConfessTagUtils$TagOriginal.jdField_a_of_type_Float;
    if (Math.abs(((Rect)localObject1).left - this.jdField_a_of_type_AndroidGraphicsRect.left) <= 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (Math.abs(((Rect)localObject1).right - this.jdField_a_of_type_AndroidGraphicsRect.right) <= 1) {
      j = 1;
    } else {
      j = 0;
    }
    if (Math.abs(((Rect)localObject1).top - this.jdField_a_of_type_AndroidGraphicsRect.top) <= 1) {
      k = 1;
    } else {
      k = 0;
    }
    if (Math.abs(((Rect)localObject1).bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom) <= 1) {
      m = 1;
    } else {
      m = 0;
    }
    int n = i;
    int i3 = j;
    int i1 = k;
    int i2 = m;
    Object localObject2;
    if (!this.d.isEmpty())
    {
      localObject2 = this.d.iterator();
      for (;;)
      {
        n = i;
        i3 = j;
        i1 = k;
        i2 = m;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        Rect localRect = (Rect)((Iterator)localObject2).next();
        n = j;
        if (Math.abs(localRect.left - ((Rect)localObject1).right) <= 1) {
          n = 1;
        }
        i1 = i;
        if (Math.abs(localRect.right - ((Rect)localObject1).left) <= 1) {
          i1 = 1;
        }
        i2 = m;
        if (Math.abs(localRect.top - ((Rect)localObject1).bottom) <= 1) {
          i2 = 1;
        }
        i = i1;
        j = n;
        m = i2;
        if (Math.abs(localRect.bottom - ((Rect)localObject1).top) <= 1)
        {
          k = 1;
          i = i1;
          j = n;
          m = i2;
        }
      }
    }
    if ((n != 0) && (i3 != 0))
    {
      i = 1;
    }
    else
    {
      if ((n != 0) || (i3 != 0)) {
        break label384;
      }
      i = 0;
    }
    n = 0;
    int j = i;
    break label416;
    label384:
    if (n != 0) {
      i = -1;
    } else if (i3 != 0) {
      i = 1;
    } else {
      i = 0;
    }
    j = 0;
    n = i;
    label416:
    if ((i1 != 0) && (i2 != 0))
    {
      i = 1;
    }
    else
    {
      if ((i1 != 0) || (i2 != 0)) {
        break label458;
      }
      i = 0;
    }
    i1 = 0;
    int k = i;
    break label490;
    label458:
    if (i1 != 0) {
      i = -1;
    } else if (i2 != 0) {
      i = 1;
    } else {
      i = 0;
    }
    k = 0;
    i1 = i;
    label490:
    int i6 = paramTag.jdField_a_of_type_ComTencentMobileqqConfessTagUtils$TagOriginal.b / i4;
    float f4 = paramRect.width();
    float f3 = i5;
    float f2 = i4;
    f1 = f4 - f1 * f3 / f2;
    if (i6 <= 1)
    {
      i = (int)(f1 / 2.0F);
      j = i;
      f1 = 0.0F;
    }
    else
    {
      if (j != 0)
      {
        i = 0;
        f1 = (f1 - 0) / (i6 - 1);
      }
      for (;;)
      {
        j = 0;
        break label639;
        i = 0;
        if (n == -1)
        {
          f1 = (f1 - 0) / i6;
          j = (int)f1;
          break label639;
        }
        if (n != 1) {
          break;
        }
        f1 = (f1 - 0) / i6;
        i = (int)f1;
      }
      f1 /= (i6 + 1);
      i = (int)f1;
      j = i;
    }
    label639:
    f4 = paramRect.height() - i5 * i4;
    if (i4 <= 1)
    {
      k = (int)(f4 / 2.0F);
      m = k;
      f2 = 0.0F;
    }
    for (;;)
    {
      break;
      if (k != 0)
      {
        k = 0;
        f2 = (f4 - 0) / (i4 - 1);
      }
      for (;;)
      {
        m = 0;
        break;
        k = 0;
        if (i1 == -1)
        {
          f2 = (f4 - 0) / f2;
          m = (int)f2;
          break;
        }
        if (i1 != 1) {
          break label753;
        }
        f2 = (f4 - 0) / f2;
        k = (int)f2;
      }
      label753:
      f2 = f4 / (i4 + 1);
      k = (int)f2;
      m = k;
    }
    f4 = Math.max(f1, 0.0F);
    int i = Math.max(i, 0);
    Math.max(j, 0);
    float f5 = Math.max(f2, 0.0F);
    j = Math.max(k, 0);
    Math.max(m, 0);
    boolean bool = TagUtils.jdField_a_of_type_JavaUtilRandom.nextBoolean();
    f1 = ((Rect)localObject1).top + j;
    j = 0;
    k = i;
    i = j;
    int m = i4;
    while (i < m)
    {
      f2 = paramRect.left + k;
      i2 = 0;
      while (i2 < i6)
      {
        i3 = i * i6 + i2;
        j = i3;
        if (bool)
        {
          j = i3;
          if (i6 == 2)
          {
            j = i3;
            if (m > 2) {
              if (i2 == 0) {
                j = i;
              } else {
                j = m + i;
              }
            }
          }
        }
        localObject1 = (Pair)paramTag.jdField_a_of_type_ComTencentMobileqqConfessTagUtils$TagOriginal.jdField_a_of_type_JavaUtilArrayList.get(j);
        localObject2 = new TagUtils.Tag.Child(new Rect(Math.round(f2), Math.round(f1), Math.round(f2 + ((Float)((Pair)localObject1).second).floatValue() * f3), Math.round(f1 + f3)), (String)((Pair)localObject1).first);
        paramTag.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        f2 = f2 + ((Float)((Pair)localObject1).second).floatValue() * f3 + f4;
        i2 += 1;
      }
      f1 = f1 + f3 + f5;
      i += 1;
    }
    paramTag.c = n;
    paramTag.d = i1;
  }
  
  private void a(ArrayList<TagUtils.TagOriginal> paramArrayList, boolean paramBoolean)
  {
    Collections.sort(paramArrayList, new TagUtils.TagArrangementEngine.4(this, paramBoolean, paramArrayList));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    new Rect();
    int j;
    for (int i = 0; (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (i < 100); i = j)
    {
      j = i + 1;
      Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, new TagUtils.TagArrangementEngine.2(this));
      int k = this.jdField_b_of_type_JavaUtilArrayList.size();
      Rect localRect1 = null;
      Rect localRect2 = localRect1;
      i = 0;
      while (i < k)
      {
        localRect1 = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        localRect2 = a(localRect1, paramBoolean);
        if (localRect2 != null)
        {
          i = 1;
          break label121;
        }
        i += 1;
      }
      i = 0;
      label121:
      if ((i == 0) || (localRect1 == null) || (localRect2 == null)) {
        break;
      }
      if (localRect2.equals(localRect1)) {
        this.jdField_b_of_type_JavaUtilArrayList.remove(localRect1);
      }
      a(localRect2);
      b();
      this.c.add(localRect2);
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (a((TagUtils.TagOriginal)localIterator.next(), paramRect1, paramInt)) {
        return true;
      }
    }
    localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
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
    Iterator localIterator = paramTagOriginal.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (((paramRect.width() + 8) * localInteger.intValue() >= paramTagOriginal.jdField_a_of_type_Float * paramInt) && (paramRect.height() + 8 >= localInteger.intValue() * paramInt)) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 1) {
      return;
    }
    int i = this.jdField_b_of_type_JavaUtilArrayList.size();
    Rect localRect1 = null;
    i -= 1;
    while (i >= 0)
    {
      Rect localRect2 = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      int m = 0;
      int j = i - 1;
      int k;
      for (;;)
      {
        k = m;
        if (j < 0) {
          break;
        }
        localRect1 = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(j);
        if (a(localRect2, localRect1))
        {
          k = 1;
          break;
        }
        j -= 1;
      }
      if (k != 0)
      {
        localRect1.union(localRect2);
        this.jdField_b_of_type_JavaUtilArrayList.remove(localRect2);
      }
      else if ((localRect2.width() <= 1) || (localRect2.height() <= 1))
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(localRect2);
      }
      i -= 1;
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    new Rect();
    int n = 0;
    while ((this.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (n < 200))
    {
      Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, new TagUtils.TagArrangementEngine.3(this));
      int j = this.jdField_b_of_type_JavaUtilArrayList.size();
      int m = TagUtils.jdField_a_of_type_Int;
      Object localObject2 = null;
      Object localObject1 = null;
      int i1 = 0;
      int i = 0;
      int k = -1;
      Object localObject3;
      int i2;
      int i3;
      int i4;
      for (;;)
      {
        localObject3 = localObject1;
        i2 = i;
        i3 = k;
        i4 = m;
        if (i1 >= j) {
          break;
        }
        localObject2 = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
        if ((((Rect)localObject2).width() >= TagUtils.jdField_a_of_type_Int) && (((Rect)localObject2).height() >= TagUtils.jdField_a_of_type_Int))
        {
          Iterator localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator1.hasNext())
          {
            localObject3 = (TagUtils.TagOriginal)localIterator1.next();
            Iterator localIterator2 = ((TagUtils.TagOriginal)localObject3).jdField_a_of_type_JavaUtilSet.iterator();
            while (localIterator2.hasNext())
            {
              Integer localInteger = (Integer)localIterator2.next();
              if ((((Rect)localObject2).width() * localInteger.intValue() >= ((TagUtils.TagOriginal)localObject3).jdField_a_of_type_Float * TagUtils.jdField_a_of_type_Int) && (((Rect)localObject2).height() >= TagUtils.jdField_a_of_type_Int * localInteger.intValue()))
              {
                float f1 = ((TagUtils.TagOriginal)localObject3).jdField_a_of_type_Float / localInteger.intValue();
                float f2 = localInteger.intValue();
                float f3 = Math.min(((Rect)localObject2).width() / f1, ((Rect)localObject2).height() / f2) / 4.0F * 4.0F;
                if (((Rect)localObject2).width() * (((Rect)localObject2).height() - f2 * f3) + ((Rect)localObject2).height() * (((Rect)localObject2).width() - f1 * f3) < 2.147484E+009F)
                {
                  m = (int)f3;
                  k = localInteger.intValue();
                  localObject1 = localObject3;
                  i = 1;
                }
              }
            }
          }
          localObject3 = localObject1;
          i4 = i;
          i3 = k;
          i2 = m;
          if (i != 0)
          {
            localObject3 = localObject1;
            i2 = i;
            i3 = k;
            i4 = m;
            break;
          }
        }
        else
        {
          i2 = m;
          i3 = k;
          i4 = i;
          localObject3 = localObject1;
        }
        i1 += 1;
        localObject1 = localObject3;
        i = i4;
        k = i3;
        m = i2;
      }
      if ((i2 == 0) || (localObject2 == null) || (i3 <= 0) || (localObject3 == null)) {
        break;
      }
      this.jdField_b_of_type_JavaUtilArrayList.remove(localObject2);
      localObject1 = a((Rect)localObject2, ((Rect)localObject2).width(), ((Rect)localObject2).height(), (int)(i4 * ((TagUtils.TagOriginal)localObject3).jdField_a_of_type_Float / i3), i4 * i3, -1, -1, i4, TagUtils.jdField_a_of_type_Int);
      if (localObject1 == null) {
        return;
      }
      a((Rect)localObject2, (Rect)localObject1, true);
      localObject2 = new TagUtils.Tag((TagUtils.TagOriginal)localObject3, -1, (Rect)localObject1, i4, false, i3);
      a((TagUtils.Tag)localObject2, (Rect)localObject1);
      this.f.add(localObject2);
      a((Rect)localObject1);
      b();
      n += 1;
    }
  }
  
  public ArrayList<TagUtils.Tag> a(ArrayList<TagUtils.TagOriginal> paramArrayList, Rect paramRect, ArrayList<Rect> paramArrayList1)
  {
    a();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()) && (paramRect != null))
    {
      System.currentTimeMillis();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
      if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty()))
      {
        this.d.addAll(paramArrayList1);
        i = 1;
      }
      else
      {
        i = 0;
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidGraphicsRect);
      if (i != 0)
      {
        paramArrayList = this.d.iterator();
        while (paramArrayList.hasNext())
        {
          paramRect = (Rect)paramArrayList.next();
          a(this.jdField_a_of_type_AndroidGraphicsRect, paramRect, true);
          a(paramRect);
          b();
        }
        this.jdField_a_of_type_Boolean = true;
        paramArrayList = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        paramRect = a(paramArrayList);
        if (paramRect != null)
        {
          a(paramArrayList, paramRect, true);
          a(paramRect);
          b();
        }
        this.jdField_a_of_type_Boolean = false;
      }
      int j = 0;
      int i = 0;
      while ((this.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (j < 200) && (i < 100))
      {
        j += 1;
        paramArrayList = a();
        if (paramArrayList == null) {
          break;
        }
        paramRect = a(paramArrayList);
        if (paramRect == null)
        {
          i += 1;
          this.g.add(paramArrayList);
        }
        else
        {
          this.g.clear();
          a(paramArrayList, paramRect, true);
          a(paramRect);
          b();
        }
      }
      a(false);
      TagUtils.jdField_a_of_type_Int = 12;
      paramArrayList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = 1;
      while (paramArrayList.hasNext())
      {
        paramRect = (TagUtils.TagOriginal)paramArrayList.next();
        paramRect.a();
        if (paramRect.b != 13) {
          i = 0;
        }
      }
      if (i != 0) {
        TagUtils.jdField_a_of_type_Int = 8;
      }
      c();
      a(true);
      return this.f;
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TagUtils.TagArrangementEngine
 * JD-Core Version:    0.7.0.1
 */