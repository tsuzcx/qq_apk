package common.qzone.component.cache.common;

import ampz;
import amqb;
import amqe;
import amqh;
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
  private ampz[] jdField_a_of_type_ArrayOfAmpz = new ampz[16];
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
  
  private ampz a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((ampz.a(paramObject) != i) || (!a(localObject, paramObject.get()))); paramObject = ampz.a(paramObject)) {}
    return paramObject;
  }
  
  private void a()
  {
    ampz localampz2 = (ampz)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (localampz2 != null)
    {
      int i = a(ampz.a(localampz2), this.jdField_a_of_type_ArrayOfAmpz.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfAmpz[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        ampz localampz1 = ampz.a((ampz)localObject1);
        if (localObject1 == localampz2)
        {
          if (localObject2 == localampz2) {
            this.jdField_a_of_type_ArrayOfAmpz[i] = localampz1;
          }
          for (;;)
          {
            ampz.a(localampz2, null);
            ampz.a(localampz2, null);
            this.jdField_a_of_type_Int -= 1;
            break;
            ampz.a(localObject2, localampz1);
          }
        }
        localObject2 = localObject1;
        localObject1 = localampz1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    ampz[] arrayOfampz1 = a();
    if (arrayOfampz1.length == 1073741824)
    {
      this.jdField_b_of_type_Int = 2147483647;
      return;
    }
    ampz[] arrayOfampz2 = new ampz[paramInt];
    a(arrayOfampz1, arrayOfampz2);
    this.jdField_a_of_type_ArrayOfAmpz = arrayOfampz2;
    if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int / 2)
    {
      this.jdField_b_of_type_Int = ((int)(paramInt * this.jdField_a_of_type_Float));
      return;
    }
    a();
    a(arrayOfampz2, arrayOfampz1);
    this.jdField_a_of_type_ArrayOfAmpz = arrayOfampz1;
  }
  
  private void a(ampz[] paramArrayOfampz1, ampz[] paramArrayOfampz2)
  {
    int i = 0;
    while (i < paramArrayOfampz1.length)
    {
      Object localObject = paramArrayOfampz1[i];
      paramArrayOfampz1[i] = null;
      if (localObject != null)
      {
        ampz localampz = ampz.a((ampz)localObject);
        if (((ampz)localObject).get() == null)
        {
          ampz.a((ampz)localObject, null);
          ampz.a((ampz)localObject, null);
          this.jdField_a_of_type_Int -= 1;
        }
        for (;;)
        {
          localObject = localampz;
          break;
          int j = a(ampz.a((ampz)localObject), paramArrayOfampz2.length);
          ampz.a((ampz)localObject, paramArrayOfampz2[j]);
          paramArrayOfampz2[j] = localObject;
        }
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    ampz[] arrayOfampz = a();
    int j;
    for (int i = arrayOfampz.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (ampz localampz = arrayOfampz[j]; localampz != null; localampz = ampz.a(localampz)) {
        if (ampz.a(localampz) == null) {
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
  
  private ampz[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfAmpz;
  }
  
  private ampz b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return null;
      ampz[] arrayOfampz = a();
      Map.Entry localEntry = (Map.Entry)paramObject;
      int i = a(b(localEntry.getKey()));
      int j = a(i, arrayOfampz.length);
      paramObject = arrayOfampz[j];
      Object localObject = paramObject;
      while (paramObject != null)
      {
        ampz localampz = ampz.a(paramObject);
        if ((i == ampz.a(paramObject)) && (paramObject.equals(localEntry)))
        {
          this.c += 1;
          this.jdField_a_of_type_Int -= 1;
          if (localObject == paramObject) {
            arrayOfampz[j] = localampz;
          }
          for (;;)
          {
            return paramObject;
            ampz.a(localObject, localampz);
          }
        }
        localObject = paramObject;
        paramObject = localampz;
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
    ampz[] arrayOfampz = this.jdField_a_of_type_ArrayOfAmpz;
    int i = 0;
    while (i < arrayOfampz.length)
    {
      arrayOfampz[i] = null;
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
    ampz[] arrayOfampz = a();
    int j;
    for (int i = arrayOfampz.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (ampz localampz = arrayOfampz[j]; localampz != null; localampz = ampz.a(localampz)) {
        if (paramObject.equals(ampz.a(localampz))) {
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
    localObject = new amqb(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = ampz.a(paramObject)) {
      if ((ampz.a(paramObject) == i) && (a(localObject, paramObject.get()))) {
        return ampz.a(paramObject);
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
    localObject = new amqe(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = b(paramObject1);
    int i = a(localObject);
    ampz[] arrayOfampz = a();
    int j = a(i, arrayOfampz.length);
    for (paramObject1 = arrayOfampz[j]; paramObject1 != null; paramObject1 = ampz.a(paramObject1)) {
      if ((i == ampz.a(paramObject1)) && (a(localObject, paramObject1.get())))
      {
        localObject = ampz.a(paramObject1);
        if (paramObject2 != localObject) {
          ampz.a(paramObject1, paramObject2);
        }
        return localObject;
      }
    }
    this.c += 1;
    paramObject1 = arrayOfampz[j];
    arrayOfampz[j] = new ampz(localObject, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, paramObject1);
    i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    if (i >= this.jdField_b_of_type_Int) {
      a(arrayOfampz.length * 2);
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
      j = this.jdField_a_of_type_ArrayOfAmpz.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfAmpz.length) {
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
    ampz[] arrayOfampz = a();
    int j = a(i, arrayOfampz.length);
    paramObject = arrayOfampz[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      ampz localampz = ampz.a(paramObject);
      if ((i == ampz.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.c += 1;
        this.jdField_a_of_type_Int -= 1;
        if (localObject1 == paramObject) {
          arrayOfampz[j] = localampz;
        }
        for (;;)
        {
          return ampz.a(paramObject);
          ampz.a(localObject1, localampz);
        }
      }
      localObject1 = paramObject;
      paramObject = localampz;
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
    localObject = new amqh(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */