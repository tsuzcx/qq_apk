package common.qzone.component.cache.common;

import alsj;
import alsl;
import also;
import alsr;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class SoftHashMap
  extends AbstractMap
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private final float jdField_a_of_type_Float = 0.75F;
  private int jdField_a_of_type_Int;
  private final ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private volatile transient Collection jdField_a_of_type_JavaUtilCollection;
  private transient Set jdField_a_of_type_JavaUtilSet;
  private alsj[] jdField_a_of_type_ArrayOfAlsj = new alsj[16];
  private int jdField_b_of_type_Int = 16;
  private volatile transient Set jdField_b_of_type_JavaUtilSet;
  private volatile int c;
  
  private static int a(int paramInt)
  {
    paramInt = paramInt >>> 20 ^ paramInt >>> 12 ^ paramInt;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt2 - 1 & paramInt1;
  }
  
  private static int a(Object paramObject)
  {
    return a(paramObject.hashCode());
  }
  
  private alsj a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((alsj.a(paramObject) != i) || (!a(localObject, paramObject.get()))); paramObject = alsj.a(paramObject)) {}
    return paramObject;
  }
  
  private void a()
  {
    alsj localalsj2 = (alsj)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (localalsj2 != null)
    {
      int i = a(alsj.a(localalsj2), this.jdField_a_of_type_ArrayOfAlsj.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfAlsj[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        alsj localalsj1 = alsj.a((alsj)localObject1);
        if (localObject1 == localalsj2)
        {
          if (localObject2 == localalsj2) {
            this.jdField_a_of_type_ArrayOfAlsj[i] = localalsj1;
          }
          for (;;)
          {
            alsj.a(localalsj2, null);
            alsj.a(localalsj2, null);
            this.jdField_a_of_type_Int -= 1;
            break;
            alsj.a(localObject2, localalsj1);
          }
        }
        localObject2 = localObject1;
        localObject1 = localalsj1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    alsj[] arrayOfalsj1 = a();
    if (arrayOfalsj1.length == 1073741824)
    {
      this.jdField_b_of_type_Int = 2147483647;
      return;
    }
    alsj[] arrayOfalsj2 = new alsj[paramInt];
    a(arrayOfalsj1, arrayOfalsj2);
    this.jdField_a_of_type_ArrayOfAlsj = arrayOfalsj2;
    if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int / 2)
    {
      this.jdField_b_of_type_Int = ((int)(paramInt * this.jdField_a_of_type_Float));
      return;
    }
    a();
    a(arrayOfalsj2, arrayOfalsj1);
    this.jdField_a_of_type_ArrayOfAlsj = arrayOfalsj1;
  }
  
  private void a(alsj[] paramArrayOfalsj1, alsj[] paramArrayOfalsj2)
  {
    int i = 0;
    while (i < paramArrayOfalsj1.length)
    {
      Object localObject = paramArrayOfalsj1[i];
      paramArrayOfalsj1[i] = null;
      if (localObject != null)
      {
        alsj localalsj = alsj.a((alsj)localObject);
        if (((alsj)localObject).get() == null)
        {
          alsj.a((alsj)localObject, null);
          alsj.a((alsj)localObject, null);
          this.jdField_a_of_type_Int -= 1;
        }
        for (;;)
        {
          localObject = localalsj;
          break;
          int j = a(alsj.a((alsj)localObject), paramArrayOfalsj2.length);
          alsj.a((alsj)localObject, paramArrayOfalsj2[j]);
          paramArrayOfalsj2[j] = localObject;
        }
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    alsj[] arrayOfalsj = a();
    int j;
    for (int i = arrayOfalsj.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (alsj localalsj = arrayOfalsj[j]; localalsj != null; localalsj = alsj.a(localalsj)) {
        if (alsj.a(localalsj) == null) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || (paramObject1.equals(paramObject2));
  }
  
  private alsj[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfAlsj;
  }
  
  private alsj b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return null;
      alsj[] arrayOfalsj = a();
      Map.Entry localEntry = (Map.Entry)paramObject;
      int i = a(b(localEntry.getKey()));
      int j = a(i, arrayOfalsj.length);
      paramObject = arrayOfalsj[j];
      Object localObject = paramObject;
      while (paramObject != null)
      {
        alsj localalsj = alsj.a(paramObject);
        if ((i == alsj.a(paramObject)) && (paramObject.equals(localEntry)))
        {
          this.c += 1;
          this.jdField_a_of_type_Int -= 1;
          if (localObject == paramObject) {
            arrayOfalsj[j] = localalsj;
          }
          for (;;)
          {
            return paramObject;
            alsj.a(localObject, localalsj);
          }
        }
        localObject = paramObject;
        paramObject = localalsj;
      }
    }
  }
  
  private static Object b(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = jdField_a_of_type_JavaLangObject;
    }
    return localObject;
  }
  
  private static Object c(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == jdField_a_of_type_JavaLangObject) {
      localObject = null;
    }
    return localObject;
  }
  
  public void clear()
  {
    while (this.jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null) {}
    this.c += 1;
    alsj[] arrayOfalsj = this.jdField_a_of_type_ArrayOfAlsj;
    int i = 0;
    while (i < arrayOfalsj.length)
    {
      arrayOfalsj[i] = null;
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
    while (this.jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null) {}
  }
  
  public boolean containsKey(Object paramObject)
  {
    return a(paramObject) != null;
  }
  
  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return a();
    }
    alsj[] arrayOfalsj = a();
    int j;
    for (int i = arrayOfalsj.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (alsj localalsj = arrayOfalsj[j]; localalsj != null; localalsj = alsj.a(localalsj)) {
        if (paramObject.equals(alsj.a(localalsj))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Set entrySet()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilSet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new alsl(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = alsj.a(paramObject)) {
      if ((alsj.a(paramObject) == i) && (a(localObject, paramObject.get()))) {
        return alsj.a(paramObject);
      }
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public Set keySet()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilSet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new also(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = b(paramObject1);
    int i = a(localObject);
    alsj[] arrayOfalsj = a();
    int j = a(i, arrayOfalsj.length);
    for (paramObject1 = arrayOfalsj[j]; paramObject1 != null; paramObject1 = alsj.a(paramObject1)) {
      if ((i == alsj.a(paramObject1)) && (a(localObject, paramObject1.get())))
      {
        localObject = alsj.a(paramObject1);
        if (paramObject2 != localObject) {
          alsj.a(paramObject1, paramObject2);
        }
        return localObject;
      }
    }
    this.c += 1;
    paramObject1 = arrayOfalsj[j];
    arrayOfalsj[j] = new alsj(localObject, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, paramObject1);
    i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    if (i >= this.jdField_b_of_type_Int) {
      a(arrayOfalsj.length * 2);
    }
    return null;
  }
  
  public void putAll(Map paramMap)
  {
    int i = 1073741824;
    int j = paramMap.size();
    if (j == 0) {
      return;
    }
    if (j > this.jdField_b_of_type_Int)
    {
      j = (int)(j / this.jdField_a_of_type_Float + 1.0F);
      if (j <= 1073741824) {
        break label126;
      }
    }
    for (;;)
    {
      j = this.jdField_a_of_type_ArrayOfAlsj.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfAlsj.length) {
        a(j);
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        put(localEntry.getKey(), localEntry.getValue());
      }
      break;
      label126:
      i = j;
    }
  }
  
  public Object remove(Object paramObject)
  {
    Object localObject2 = b(paramObject);
    int i = a(localObject2);
    alsj[] arrayOfalsj = a();
    int j = a(i, arrayOfalsj.length);
    paramObject = arrayOfalsj[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      alsj localalsj = alsj.a(paramObject);
      if ((i == alsj.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.c += 1;
        this.jdField_a_of_type_Int -= 1;
        if (localObject1 == paramObject) {
          arrayOfalsj[j] = localalsj;
        }
        for (;;)
        {
          return alsj.a(paramObject);
          alsj.a(localObject1, localalsj);
        }
      }
      localObject1 = paramObject;
      paramObject = localalsj;
    }
    return null;
  }
  
  public int size()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return 0;
    }
    a();
    return this.jdField_a_of_type_Int;
  }
  
  public Collection values()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilCollection;
    if (localObject != null) {
      return localObject;
    }
    localObject = new alsr(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */