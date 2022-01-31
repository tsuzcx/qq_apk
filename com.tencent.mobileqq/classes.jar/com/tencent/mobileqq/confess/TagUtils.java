package com.tencent.mobileqq.confess;

import absh;
import absi;
import absj;
import absk;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class TagUtils
{
  public static Paint a;
  static Rect a;
  public static Random a;
  
  static
  {
    jdField_a_of_type_JavaUtilRandom = new Random();
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
    jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public static float a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      jdField_a_of_type_AndroidGraphicsPaint.setTextSize(36.0F);
      return jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString) / 36.0F;
    }
    return 1.0F;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt <= 2) {
      return jdField_a_of_type_JavaUtilRandom.nextInt(8) - 4 + 74;
    }
    if (paramInt <= 4) {
      return jdField_a_of_type_JavaUtilRandom.nextInt(8) - 4 + 70;
    }
    if (paramInt <= 6) {
      return jdField_a_of_type_JavaUtilRandom.nextInt(8) - 4 + 66;
    }
    if (paramInt <= 8) {
      return jdField_a_of_type_JavaUtilRandom.nextInt(8) - 4 + 62;
    }
    return jdField_a_of_type_JavaUtilRandom.nextInt(8) - 4 + 60;
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ArrayList paramArrayList1, ArrayList paramArrayList2, Rect paramRect, int paramInt5, int paramInt6)
  {
    if ((paramInt4 <= paramInt2) && (paramInt3 <= paramInt1)) {
      if (paramRect.width() - paramInt3 >= 18) {}
    }
    for (;;)
    {
      if (paramRect.height() - paramInt4 < 18) {}
      for (;;)
      {
        paramArrayList1 = new Rect(paramRect);
        if (paramBoolean2) {
          paramArrayList1.bottom = (paramArrayList1.top + paramInt2);
        }
        for (;;)
        {
          if (!paramBoolean3) {
            break label403;
          }
          paramArrayList1.left = ((paramArrayList1.width() - paramInt1) / 2);
          paramArrayList1.right = (paramArrayList1.left + paramInt1);
          return paramArrayList1;
          jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
          label123:
          Rect localRect;
          if (paramBoolean1)
          {
            jdField_a_of_type_AndroidGraphicsRect.left += paramInt3;
            if (!a(jdField_a_of_type_AndroidGraphicsRect, paramRect, paramArrayList2, paramArrayList1, paramInt6)) {
              break label219;
            }
            if (jdField_a_of_type_AndroidGraphicsRect.width() <= paramInt6 + 8) {
              break label445;
            }
            if (!paramBoolean1) {
              break label221;
            }
            localRect = jdField_a_of_type_AndroidGraphicsRect;
            localRect.left += 8;
          }
          for (;;)
          {
            paramInt1 = paramInt3;
            if (a(jdField_a_of_type_AndroidGraphicsRect, paramRect, paramArrayList2, paramArrayList1, paramInt6)) {
              paramInt1 = paramInt3 + 8;
            }
            break;
            jdField_a_of_type_AndroidGraphicsRect.right -= paramInt3;
            break label123;
            label219:
            break;
            label221:
            localRect = jdField_a_of_type_AndroidGraphicsRect;
            localRect.right -= 8;
          }
          jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
          if (paramBoolean2)
          {
            jdField_a_of_type_AndroidGraphicsRect.top += paramInt4;
            label269:
            if (!a(jdField_a_of_type_AndroidGraphicsRect, paramRect, paramArrayList2, paramArrayList1, paramInt6)) {
              break label365;
            }
            if (jdField_a_of_type_AndroidGraphicsRect.height() <= paramInt6 + 8) {
              break label440;
            }
            if (!paramBoolean2) {
              break label367;
            }
            localRect = jdField_a_of_type_AndroidGraphicsRect;
            localRect.top += 8;
          }
          for (;;)
          {
            paramInt2 = paramInt4;
            if (a(jdField_a_of_type_AndroidGraphicsRect, paramRect, paramArrayList2, paramArrayList1, paramInt6)) {
              paramInt2 = paramInt4 + 8;
            }
            break;
            jdField_a_of_type_AndroidGraphicsRect.bottom -= paramInt4;
            break label269;
            label365:
            break;
            label367:
            localRect = jdField_a_of_type_AndroidGraphicsRect;
            localRect.bottom -= 8;
          }
          paramArrayList1.top = (paramArrayList1.bottom - paramInt2);
        }
        label403:
        if (paramBoolean1)
        {
          paramArrayList1.right = (paramArrayList1.left + paramInt1);
          return paramArrayList1;
        }
        paramArrayList1.left = (paramArrayList1.right - paramInt1);
        return paramArrayList1;
        return null;
        label440:
        paramInt2 = paramInt4;
      }
      label445:
      paramInt1 = paramInt3;
    }
  }
  
  public static Rect a(Rect paramRect1, ArrayList paramArrayList1, ArrayList paramArrayList2, Rect paramRect2, Rect paramRect3, ArrayList paramArrayList3)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    if (((paramRect3 != null) && (paramRect1.bottom == paramRect3.top)) || (Math.abs(paramRect1.top - paramRect2.top) > Math.abs(paramRect1.bottom - paramRect2.bottom))) {
      bool1 = false;
    }
    if (((paramRect3 != null) && (paramRect1.right == paramRect3.left)) || (Math.abs(paramRect1.left - paramRect2.left) > Math.abs(paramRect1.right - paramRect2.right))) {
      bool2 = false;
    }
    if (paramRect1.width() < paramRect1.height()) {
      bool3 = true;
    }
    a(paramArrayList1, bool3);
    int k = paramRect2.width();
    int m = paramRect2.height();
    if (paramArrayList1.size() <= 2)
    {
      j = m;
      i = k;
      if (paramArrayList2.size() < 1) {}
    }
    else
    {
      j = (int)(0.85D * m);
      i = (int)(0.85D * k);
    }
    int j = Math.min(paramRect1.width(), j);
    int i = Math.min(paramRect1.height(), i);
    k = paramArrayList1.size();
    Iterator localIterator = paramArrayList1.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (TagUtils.TagOriginal)localIterator.next();
      if (jdField_a_of_type_JavaUtilRandom.nextInt(k) + 0 >= k - 1) {}
      for (bool3 = true;; bool3 = false)
      {
        localObject = a((TagUtils.TagOriginal)localObject, paramArrayList2, paramArrayList1, paramRect1, paramArrayList3, paramRect2, paramRect3, j, i, bool2, bool1, bool3);
        if (localObject == null) {
          break;
        }
        return localObject;
      }
    }
    return null;
  }
  
  public static Rect a(TagUtils.TagOriginal paramTagOriginal, ArrayList paramArrayList1, ArrayList paramArrayList2, Rect paramRect1, ArrayList paramArrayList3, Rect paramRect2, Rect paramRect3, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = paramTagOriginal.c;
    int i = j;
    if (paramTagOriginal.jdField_a_of_type_Int >= 1) {
      i = Math.max(24, (int)(j * (0.95F - jdField_a_of_type_JavaUtilRandom.nextInt(20) / 100.0F)));
    }
    Object localObject2 = null;
    j = 1;
    int n = 0;
    int m = i;
    Object localObject3 = localObject2;
    int k = j;
    Object localObject1;
    label139:
    boolean bool;
    if (n < 10)
    {
      localObject3 = localObject2;
      k = j;
      if (m >= 24)
      {
        k = (int)(m * paramTagOriginal.jdField_a_of_type_Float);
        localObject1 = localObject2;
        i = j;
        if (paramInt1 * paramInt2 >= m * k)
        {
          localObject3 = paramTagOriginal.jdField_a_of_type_JavaUtilSet.iterator();
          i = j;
          localObject1 = localObject2;
          if (((Iterator)localObject3).hasNext())
          {
            i = ((Integer)((Iterator)localObject3).next()).intValue();
            j = k / i;
            if ((!paramArrayList1.isEmpty()) || (paramArrayList2.size() > 3)) {
              break label243;
            }
            bool = true;
            label189:
            localObject1 = a(paramInt1, paramInt2, j, m * i, paramBoolean1, paramBoolean2, bool, paramArrayList3, paramArrayList2, paramRect1, m, 24);
            if (localObject1 == null) {
              break label249;
            }
          }
        }
        if (localObject1 != null) {
          paramArrayList2 = (ArrayList)localObject1;
        }
      }
    }
    for (;;)
    {
      if (paramArrayList2 == null)
      {
        if (paramBoolean3) {}
        return null;
        label243:
        bool = false;
        break label189;
        label249:
        break label139;
        localObject3 = localObject1;
        k = i;
        if (m <= 24) {
          break label355;
        }
        m = Math.max(24, (int)(m * (0.95F - jdField_a_of_type_JavaUtilRandom.nextInt(6) / 100.0F)));
        n += 1;
        localObject2 = localObject1;
        j = i;
        break;
      }
      if ((paramArrayList2 != null) && (i > 0))
      {
        paramTagOriginal = new TagUtils.Tag(paramTagOriginal, -1, paramArrayList2, m, true, i);
        a(paramTagOriginal, paramArrayList2, paramRect2, paramRect3);
        paramArrayList1.add(paramTagOriginal);
        return paramArrayList2;
      }
      return null;
      label355:
      paramArrayList2 = (ArrayList)localObject3;
      i = k;
    }
  }
  
  public static Rect a(ArrayList paramArrayList, Rect paramRect1, Rect paramRect2, Rect paramRect3, boolean paramBoolean)
  {
    int k = paramRect1.width() * paramRect1.height();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      TagUtils.Tag localTag = (TagUtils.Tag)paramArrayList.next();
      int i = localTag.jdField_a_of_type_AndroidGraphicsRect.width();
      int j = localTag.jdField_a_of_type_AndroidGraphicsRect.height();
      if (((paramBoolean) || (k * 5 < i * j) || (k <= 576)) && (a(paramRect1, localTag.jdField_a_of_type_AndroidGraphicsRect)))
      {
        localTag.jdField_a_of_type_AndroidGraphicsRect.union(paramRect1);
        a(localTag, localTag.jdField_a_of_type_AndroidGraphicsRect, paramRect2, paramRect3);
        return paramRect1;
      }
      if (paramBoolean)
      {
        Rect localRect = new Rect(paramRect1);
        j = 0;
        if ((localRect.left <= localTag.jdField_a_of_type_AndroidGraphicsRect.left) && (localRect.right >= localTag.jdField_a_of_type_AndroidGraphicsRect.right))
        {
          localRect.left = localTag.jdField_a_of_type_AndroidGraphicsRect.left;
          localRect.right = localTag.jdField_a_of_type_AndroidGraphicsRect.right;
          i = 1;
        }
        while ((i != 0) && (a(localRect, localTag.jdField_a_of_type_AndroidGraphicsRect)))
        {
          localTag.jdField_a_of_type_AndroidGraphicsRect.union(localRect);
          a(localTag, localTag.jdField_a_of_type_AndroidGraphicsRect, paramRect2, paramRect3);
          return localRect;
          i = j;
          if (paramRect1.top <= localTag.jdField_a_of_type_AndroidGraphicsRect.top)
          {
            i = j;
            if (paramRect1.bottom >= localTag.jdField_a_of_type_AndroidGraphicsRect.bottom)
            {
              localRect.top = localTag.jdField_a_of_type_AndroidGraphicsRect.top;
              localRect.bottom = localTag.jdField_a_of_type_AndroidGraphicsRect.bottom;
              i = 1;
            }
          }
        }
      }
    }
    return null;
  }
  
  public static Rect a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Object localObject;
    if (paramArrayList1.isEmpty()) {
      localObject = null;
    }
    Rect localRect;
    do
    {
      return localObject;
      Collections.sort(paramArrayList1, new absh(paramArrayList2));
      localRect = (Rect)paramArrayList1.get(jdField_a_of_type_JavaUtilRandom.nextInt(Math.min(paramArrayList1.size(), 2)));
      localObject = localRect;
    } while (!paramArrayList2.contains(localRect));
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      localObject = (Rect)paramArrayList1.next();
      if (!paramArrayList2.contains(localObject)) {
        return localObject;
      }
    }
    return null;
  }
  
  public static ArrayList a(ArrayList paramArrayList1, Rect paramRect1, Rect paramRect2, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4)
  {
    System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    paramArrayList2.add(paramRect1);
    if (paramRect2 != null) {
      a(paramRect1, paramArrayList4, paramArrayList2, paramRect2, true);
    }
    if (paramArrayList1.isEmpty()) {
      return localArrayList1;
    }
    Rect localRect1 = new Rect();
    ArrayList localArrayList2 = new ArrayList();
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((paramArrayList2.size() > 0) && (i < 100) && (j < 100))
      {
        i += 1;
        if ((!localArrayList1.isEmpty()) || (paramArrayList1.size() > 3)) {
          break label169;
        }
      }
      label169:
      for (Object localObject = (Rect)paramArrayList2.get(0); localObject == null; localObject = a(paramArrayList2, localArrayList2))
      {
        a(paramArrayList2, paramArrayList4, localArrayList1, paramRect1, paramRect2, paramArrayList3, false);
        localObject = paramArrayList1.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((TagUtils.TagOriginal)((Iterator)localObject).next()).a();
        }
      }
      Rect localRect2 = a((Rect)localObject, paramArrayList1, localArrayList1, paramRect1, paramRect2, paramArrayList2);
      if (localRect2 == null)
      {
        localArrayList2.add(localObject);
        j += 1;
      }
      else
      {
        localArrayList2.clear();
        a((Rect)localObject, paramArrayList4, paramArrayList2, localRect2, true);
        int k = paramArrayList2.size() - 1;
        while (k >= 0)
        {
          localObject = (Rect)paramArrayList2.get(k);
          localRect1.set(localRect2);
          if (localRect1.intersect((Rect)localObject)) {
            a((Rect)localObject, paramArrayList4, paramArrayList2, localRect1, false);
          }
          k -= 1;
        }
        a(paramArrayList2);
      }
    }
    a(paramArrayList2, paramArrayList1, paramArrayList4, localArrayList1, paramRect1, paramRect2);
    a(paramArrayList2, paramArrayList4, localArrayList1, paramRect1, paramRect2, paramArrayList3, true);
    return localArrayList1;
  }
  
  public static void a(Rect paramRect1, ArrayList paramArrayList1, ArrayList paramArrayList2, Rect paramRect2, boolean paramBoolean)
  {
    paramArrayList2.remove(paramRect1);
    if (paramBoolean) {
      paramArrayList1.add(paramRect2);
    }
    if (paramRect2.equals(paramRect1)) {
      return;
    }
    paramArrayList1 = new Point(paramRect1.left, paramRect1.top);
    Point localPoint1 = new Point(paramRect1.left, paramRect1.bottom);
    Point localPoint2 = new Point(paramRect1.right, paramRect1.top);
    Point localPoint3 = new Point(paramRect1.right, paramRect1.bottom);
    Point localPoint4 = new Point(paramRect2.left, paramRect2.top);
    Point localPoint5 = new Point(paramRect2.left, paramRect2.bottom);
    Point localPoint6 = new Point(paramRect2.right, paramRect2.top);
    Point localPoint7 = new Point(paramRect2.right, paramRect2.bottom);
    if ((paramArrayList1.equals(localPoint4)) && (localPoint1.equals(localPoint5)))
    {
      paramArrayList2.add(new Rect(paramRect2.right, paramRect2.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((paramArrayList1.equals(localPoint4)) && (localPoint2.equals(localPoint6)))
    {
      paramArrayList2.add(new Rect(paramRect2.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((localPoint3.equals(localPoint7)) && (localPoint2.equals(localPoint6)))
    {
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect2.bottom));
      return;
    }
    if ((localPoint1.equals(localPoint5)) && (localPoint3.equals(localPoint7)))
    {
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.right, paramRect2.top));
      return;
    }
    if (paramArrayList1.equals(localPoint4))
    {
      paramArrayList2.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      paramArrayList2.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (localPoint2.equals(localPoint6))
    {
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      paramArrayList2.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (localPoint3.equals(localPoint7))
    {
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      return;
    }
    if (localPoint1.equals(localPoint5))
    {
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      paramArrayList2.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.left == paramRect2.left)
    {
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      paramArrayList2.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      paramArrayList2.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.top == paramRect2.top)
    {
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      paramArrayList2.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      paramArrayList2.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.right == paramRect2.right)
    {
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      paramArrayList2.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.right == paramRect2.right)
    {
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      paramArrayList2.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
    paramArrayList2.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
    paramArrayList2.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
    paramArrayList2.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
  }
  
  public static void a(TagUtils.Tag paramTag, Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    paramTag.jdField_a_of_type_JavaUtilArrayList.clear();
    int i3 = paramTag.d;
    int i4 = paramTag.b;
    float f1 = paramTag.jdField_a_of_type_ComTencentMobileqqConfessTagUtils$TagOriginal.jdField_a_of_type_Float;
    Paint.Align localAlign = Paint.Align.CENTER;
    int i;
    int j;
    if ((Math.abs(paramRect1.left - paramRect2.left) <= 1) || ((paramRect3 != null) && (Math.abs(paramRect1.left - paramRect3.right) <= 1)))
    {
      i = 1;
      if ((Math.abs(paramRect1.right - paramRect2.right) > 1) && ((paramRect3 == null) || (Math.abs(paramRect1.right - paramRect3.left) > 1))) {
        break label692;
      }
      j = 1;
      label111:
      if ((i == 0) || (j == 0)) {
        break label698;
      }
    }
    label1024:
    for (;;)
    {
      label160:
      label199:
      int n;
      if ((Math.abs(paramRect1.top - paramRect2.top) <= 1) || ((paramRect3 != null) && (Math.abs(paramRect1.top - paramRect3.bottom) <= 1)))
      {
        i = 1;
        if ((Math.abs(paramRect1.bottom - paramRect2.bottom) > 1) && ((paramRect3 == null) || (Math.abs(paramRect1.bottom - paramRect3.top) > 1))) {
          break label743;
        }
        j = 1;
        if ((i == 0) || (j == 0)) {
          break label749;
        }
        n = 0;
      }
      for (;;)
      {
        float f2 = 0.0F;
        int i5 = paramTag.jdField_a_of_type_ComTencentMobileqqConfessTagUtils$TagOriginal.b / i3;
        int i1 = paramRect1.width() - (int)(f1 * i4 / i3);
        int k;
        int m;
        label268:
        label320:
        int i6;
        float f3;
        int i2;
        label358:
        float f4;
        label407:
        boolean bool;
        if ((i1 < 8) || (i5 <= 1))
        {
          k = i1 / 2;
          m = k;
          f1 = f2;
          i = k;
          j = m;
          if (f2 > 4.0F)
          {
            if (localAlign != Paint.Align.CENTER) {
              break label813;
            }
            i = (int)f2;
            f1 = (i1 - i * 2) / (i5 - 1);
            j = i;
          }
          i6 = paramRect1.height() - i3 * i4;
          f3 = 0.0F;
          if ((i6 >= 8) && (i3 > 1)) {
            break label883;
          }
          i1 = i6 / 2;
          i2 = i1;
          f2 = f3;
          k = i1;
          m = i2;
          if (f3 > 4.0F)
          {
            if (n != 0) {
              break label905;
            }
            k = (int)f3;
            f2 = (i6 - k * 2) / (i3 - 1);
            m = k;
          }
          f3 = Math.max(f1, 0.0F);
          i1 = Math.max(j, 0);
          Math.max(i, 0);
          f4 = Math.max(f2, 0.0F);
          i = Math.max(m, 0);
          Math.max(k, 0);
          bool = jdField_a_of_type_JavaUtilRandom.nextBoolean();
          f1 = i + paramRect1.top;
          i = 0;
        }
        for (;;)
        {
          if (i >= i3) {
            break label1005;
          }
          f2 = paramRect1.left + i1;
          k = 0;
          label494:
          if (k < i5)
          {
            m = i * i5 + k;
            j = m;
            if (bool)
            {
              j = m;
              if (i5 == 2)
              {
                j = m;
                if (i3 > 2) {
                  if (k != 0) {
                    break label971;
                  }
                }
              }
            }
            for (j = i;; j = i3 + i)
            {
              paramRect2 = (Pair)paramTag.jdField_a_of_type_ComTencentMobileqqConfessTagUtils$TagOriginal.jdField_a_of_type_JavaUtilArrayList.get(j);
              j = Math.round(f2);
              m = Math.round(f1);
              float f5 = i4;
              paramRect3 = new TagUtils.Tag.Child(new Rect(j, m, Math.round(((Float)paramRect2.second).floatValue() * f5 + f2), Math.round(i4 + f1)), (String)paramRect2.first);
              paramTag.jdField_a_of_type_JavaUtilArrayList.add(paramRect3);
              f5 = i4;
              float f6 = ((Float)paramRect2.second).floatValue();
              k += 1;
              f2 = f6 * f5 + f2 + f3;
              break label494;
              i = 0;
              break;
              j = 0;
              break label111;
              if ((i == 0) && (j == 0)) {
                break label1024;
              }
              if (i != 0) {
                localAlign = Paint.Align.LEFT;
              }
              for (;;)
              {
                break;
                if (j != 0) {
                  localAlign = Paint.Align.RIGHT;
                }
              }
              i = 0;
              break label160;
              j = 0;
              break label199;
              if ((i == 0) && (j == 0)) {
                break label1018;
              }
              if (i != 0) {
                i = -1;
              }
              for (;;)
              {
                n = i;
                break;
                if (j != 0) {
                  i = -1;
                } else {
                  i = 0;
                }
              }
              k = 4;
              f2 = (i1 - 8) / (i5 - 1);
              m = 4;
              break label268;
              if (localAlign == Paint.Align.LEFT)
              {
                j = 4;
                f1 = (i1 - 4) / i5;
                i = (int)f1;
                break label320;
              }
              f1 = f2;
              i = k;
              j = m;
              if (localAlign != Paint.Align.RIGHT) {
                break label320;
              }
              i = 4;
              f1 = (i1 - 4) / i5;
              j = (int)f1;
              break label320;
              label883:
              i1 = 4;
              f3 = (i6 - 8) / (i3 - 1);
              i2 = 4;
              break label358;
              if (n == -1)
              {
                m = 4;
                f2 = (i6 - 4) / i3;
                k = (int)f2;
                break label407;
              }
              f2 = f3;
              k = i1;
              m = i2;
              if (n != 1) {
                break label407;
              }
              k = 4;
              f2 = (i6 - 4) / i3;
              m = (int)f2;
              break label407;
            }
          }
          label692:
          label698:
          label743:
          label749:
          f2 = i4;
          label813:
          label971:
          i += 1;
          label905:
          f1 = f2 + f1 + f4;
        }
        label1005:
        paramTag.jdField_a_of_type_AndroidGraphicsPaint$Align = localAlign;
        paramTag.c = n;
        return;
        label1018:
        n = 0;
      }
    }
  }
  
  public static void a(ArrayList paramArrayList)
  {
    if (paramArrayList.size() <= 1) {
      return;
    }
    int i = paramArrayList.size() - 1;
    Rect localRect1 = null;
    label18:
    Rect localRect2;
    if (i >= 0)
    {
      localRect2 = (Rect)paramArrayList.get(i);
      j = i - 1;
      label36:
      if (j < 0) {
        break label121;
      }
      localRect1 = (Rect)paramArrayList.get(j);
      if (!a(localRect2, localRect1)) {
        break label84;
      }
    }
    label84:
    label121:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        localRect1.union(localRect2);
        paramArrayList.remove(localRect2);
      }
      for (;;)
      {
        i -= 1;
        break label18;
        break;
        j -= 1;
        break label36;
        if ((localRect2.width() <= 6) || (localRect2.height() <= 6)) {
          paramArrayList.remove(localRect2);
        }
      }
    }
  }
  
  public static void a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, Rect paramRect1, Rect paramRect2, ArrayList paramArrayList4, boolean paramBoolean)
  {
    if (paramArrayList1.isEmpty()) {}
    label20:
    label221:
    label225:
    for (;;)
    {
      return;
      int i = 0;
      Rect localRect3 = new Rect();
      Rect localRect1;
      Rect localRect2;
      if ((paramArrayList1.size() > 0) && (i < 100))
      {
        Collections.sort(paramArrayList1, new absi());
        int k = paramArrayList1.size();
        localRect1 = null;
        localRect2 = null;
        j = 0;
        if (j >= k) {
          break label221;
        }
        localRect2 = (Rect)paramArrayList1.get(j);
        localRect1 = a(paramArrayList3, localRect2, paramRect1, paramRect2, paramBoolean);
        if (localRect1 == null) {}
      }
      for (int j = 1;; j = 0)
      {
        if ((j == 0) || (localRect2 == null) || (localRect1 == null)) {
          break label225;
        }
        if (localRect1.equals(localRect2)) {
          paramArrayList1.remove(localRect2);
        }
        j = paramArrayList1.size() - 1;
        for (;;)
        {
          if (j >= 0)
          {
            localRect2 = (Rect)paramArrayList1.get(j);
            localRect3.set(localRect2);
            if (localRect3.intersect(localRect1)) {
              a(localRect2, paramArrayList2, paramArrayList1, localRect3, false);
            }
            j -= 1;
            continue;
            j += 1;
            break;
          }
        }
        a(paramArrayList1);
        paramArrayList4.add(localRect1);
        i += 1;
        break label20;
        break;
      }
    }
  }
  
  public static void a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, Rect paramRect1, Rect paramRect2)
  {
    if (paramArrayList1.isEmpty()) {
      return;
    }
    int i2 = 0;
    Rect localRect2 = new Rect();
    label20:
    Object localObject2;
    int i;
    Object localObject1;
    int j;
    int k;
    Rect localRect1;
    int m;
    int n;
    int i1;
    if ((paramArrayList1.size() > 0) && (i2 < 100))
    {
      Collections.sort(paramArrayList1, new absj());
      int i4 = paramArrayList1.size();
      localObject2 = null;
      i = 0;
      localObject1 = null;
      j = -1;
      k = 10;
      int i3 = 0;
      while (i3 < i4)
      {
        localRect1 = (Rect)paramArrayList1.get(i3);
        m = k;
        n = j;
        localObject2 = localObject1;
        i1 = i;
        if (localRect1.width() >= 10)
        {
          if (localRect1.height() < 10)
          {
            i1 = i;
            localObject2 = localObject1;
            n = j;
            m = k;
          }
        }
        else
        {
          label140:
          i3 += 1;
          k = m;
          j = n;
          localObject1 = localObject2;
          i = i1;
          localObject2 = localRect1;
          continue;
        }
        Iterator localIterator1 = paramArrayList2.iterator();
        while (localIterator1.hasNext())
        {
          TagUtils.TagOriginal localTagOriginal = (TagUtils.TagOriginal)localIterator1.next();
          Iterator localIterator2 = localTagOriginal.jdField_a_of_type_JavaUtilSet.iterator();
          i1 = i;
          localObject2 = localObject1;
          n = j;
          m = k;
          label225:
          k = m;
          j = n;
          localObject1 = localObject2;
          i = i1;
          if (localIterator2.hasNext())
          {
            localObject1 = (Integer)localIterator2.next();
            if ((localRect1.width() * ((Integer)localObject1).intValue() < localTagOriginal.jdField_a_of_type_Float * 10.0F) || (localRect1.height() < ((Integer)localObject1).intValue() * 10)) {
              break label670;
            }
            float f1 = localTagOriginal.jdField_a_of_type_Float / ((Integer)localObject1).intValue();
            float f2 = ((Integer)localObject1).intValue();
            float f3 = Math.min(localRect1.width() / f1, localRect1.height() / f2);
            float f4 = localRect1.width();
            float f5 = localRect1.height();
            float f6 = localRect1.height();
            if ((localRect1.width() - f1 * f3) * f6 + (f5 - f2 * f3) * f4 >= 2.147484E+009F) {
              break label670;
            }
            i = (int)f3;
            j = ((Integer)localObject1).intValue();
            k = 1;
            localObject1 = localTagOriginal;
          }
        }
      }
    }
    for (;;)
    {
      m = i;
      n = j;
      localObject2 = localObject1;
      i1 = k;
      break label225;
      m = k;
      n = j;
      localObject2 = localObject1;
      i1 = i;
      if (i == 0) {
        break label140;
      }
      localObject2 = localRect1;
      for (;;)
      {
        if ((i == 0) || (localObject2 == null) || (j <= 0) || (localObject1 == null)) {
          break label668;
        }
        paramArrayList1.remove(localObject2);
        localRect1 = a(localObject2.width(), localObject2.height(), (int)(k * ((TagUtils.TagOriginal)localObject1).jdField_a_of_type_Float / j), k * j, true, true, false, paramArrayList1, paramArrayList2, localObject2, k, 10);
        if (localRect1 == null) {
          break;
        }
        a(localObject2, paramArrayList3, paramArrayList1, localRect1, true);
        localObject1 = new TagUtils.Tag((TagUtils.TagOriginal)localObject1, -1, localRect1, k, false, j);
        a((TagUtils.Tag)localObject1, localRect1, paramRect1, paramRect2);
        paramArrayList4.add(localObject1);
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          localObject1 = (Rect)paramArrayList1.get(i);
          localRect2.set((Rect)localObject1);
          if (localRect2.intersect(localRect1)) {
            a((Rect)localObject1, paramArrayList3, paramArrayList1, localRect2, false);
          }
          i -= 1;
        }
        a(paramArrayList1);
        i2 += 1;
        break label20;
        break;
      }
      label668:
      break;
      label670:
      i = m;
      j = n;
      localObject1 = localObject2;
      k = i1;
    }
  }
  
  public static void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Collections.sort(paramArrayList, new absk(paramBoolean, paramArrayList));
  }
  
  public static boolean a(int paramInt)
  {
    return ((paramInt >= 19968) && (paramInt <= 40959)) || (paramInt == 65292) || (paramInt == 12290) || (paramInt == 65281) || (paramInt == 8220) || (paramInt == 8221) || (paramInt == 65288) || (paramInt == 65289) || (paramInt == 126) || (paramInt == 65311);
  }
  
  public static boolean a(Rect paramRect1, Rect paramRect2)
  {
    if ((paramRect1.contains(paramRect2)) || (paramRect2.contains(paramRect1))) {}
    while (((Math.abs(paramRect1.width() - paramRect2.width()) <= 2) && (Math.abs(paramRect1.left - paramRect2.left) <= 2) && (((paramRect1.top < paramRect2.top) && (paramRect1.bottom + 2 > paramRect2.top)) || ((paramRect2.top < paramRect1.top) && (paramRect2.bottom + 2 > paramRect1.top)))) || ((Math.abs(paramRect1.height() - paramRect2.height()) <= 2) && (Math.abs(paramRect1.top - paramRect2.top) <= 2) && (((paramRect1.left < paramRect2.left) && (paramRect1.right + 2 > paramRect2.left)) || ((paramRect2.left < paramRect1.left) && (2 + paramRect2.right > paramRect1.left))))) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Rect paramRect1, Rect paramRect2, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext()) {
      if (a((TagUtils.TagOriginal)paramArrayList1.next(), paramRect1, paramInt)) {
        return true;
      }
    }
    paramArrayList1 = paramArrayList2.iterator();
    while (paramArrayList1.hasNext())
    {
      paramArrayList2 = (Rect)paramArrayList1.next();
      if ((paramArrayList2 != paramRect2) && (a(paramArrayList2, paramRect1))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(TagUtils.TagOriginal paramTagOriginal, Rect paramRect, int paramInt)
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
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label37;
      }
      if (!a(paramString.codePointAt(i))) {
        break;
      }
      i += 1;
    }
    label37:
    return true;
  }
  
  public static boolean a(String paramString, ArrayList paramArrayList)
  {
    paramString = paramString.trim();
    int j = -1;
    boolean bool = true;
    int i = 0;
    if (i < paramString.length())
    {
      String str;
      if (a(paramString.codePointAt(i)))
      {
        str = paramString.substring(i, i + 1);
        paramArrayList.add(new Pair(str, Float.valueOf(a(str))));
      }
      for (;;)
      {
        i += 1;
        break;
        int k = j;
        if (j == -1) {
          k = i;
        }
        if (i + 1 < paramString.length())
        {
          j = k;
          if (!a(paramString.codePointAt(i + 1))) {}
        }
        else
        {
          str = paramString.substring(k, i + 1);
          paramArrayList.add(new Pair(str, Float.valueOf(a(str))));
          j = -1;
        }
        bool = false;
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TagUtils
 * JD-Core Version:    0.7.0.1
 */