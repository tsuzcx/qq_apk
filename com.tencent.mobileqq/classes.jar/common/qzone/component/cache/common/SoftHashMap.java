package common.qzone.component.cache.common;

import amin;
import amip;
import amis;
import amiv;
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
  private amin[] jdField_a_of_type_ArrayOfAmin = new amin[16];
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
  
  private amin a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((amin.a(paramObject) != i) || (!a(localObject, paramObject.get()))); paramObject = amin.a(paramObject)) {}
    return paramObject;
  }
  
  private void a()
  {
    amin localamin2 = (amin)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (localamin2 != null)
    {
      int i = a(amin.a(localamin2), this.jdField_a_of_type_ArrayOfAmin.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfAmin[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        amin localamin1 = amin.a((amin)localObject1);
        if (localObject1 == localamin2)
        {
          if (localObject2 == localamin2) {
            this.jdField_a_of_type_ArrayOfAmin[i] = localamin1;
          }
          for (;;)
          {
            amin.a(localamin2, null);
            amin.a(localamin2, null);
            this.jdField_a_of_type_Int -= 1;
            break;
            amin.a(localObject2, localamin1);
          }
        }
        localObject2 = localObject1;
        localObject1 = localamin1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    amin[] arrayOfamin1 = a();
    if (arrayOfamin1.length == 1073741824)
    {
      this.jdField_b_of_type_Int = 2147483647;
      return;
    }
    amin[] arrayOfamin2 = new amin[paramInt];
    a(arrayOfamin1, arrayOfamin2);
    this.jdField_a_of_type_ArrayOfAmin = arrayOfamin2;
    if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int / 2)
    {
      this.jdField_b_of_type_Int = ((int)(paramInt * this.jdField_a_of_type_Float));
      return;
    }
    a();
    a(arrayOfamin2, arrayOfamin1);
    this.jdField_a_of_type_ArrayOfAmin = arrayOfamin1;
  }
  
  private void a(amin[] paramArrayOfamin1, amin[] paramArrayOfamin2)
  {
    int i = 0;
    while (i < paramArrayOfamin1.length)
    {
      Object localObject = paramArrayOfamin1[i];
      paramArrayOfamin1[i] = null;
      if (localObject != null)
      {
        amin localamin = amin.a((amin)localObject);
        if (((amin)localObject).get() == null)
        {
          amin.a((amin)localObject, null);
          amin.a((amin)localObject, null);
          this.jdField_a_of_type_Int -= 1;
        }
        for (;;)
        {
          localObject = localamin;
          break;
          int j = a(amin.a((amin)localObject), paramArrayOfamin2.length);
          amin.a((amin)localObject, paramArrayOfamin2[j]);
          paramArrayOfamin2[j] = localObject;
        }
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    amin[] arrayOfamin = a();
    int j;
    for (int i = arrayOfamin.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (amin localamin = arrayOfamin[j]; localamin != null; localamin = amin.a(localamin)) {
        if (amin.a(localamin) == null) {
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
  
  private amin[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfAmin;
  }
  
  private amin b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return null;
      amin[] arrayOfamin = a();
      Map.Entry localEntry = (Map.Entry)paramObject;
      int i = a(b(localEntry.getKey()));
      int j = a(i, arrayOfamin.length);
      paramObject = arrayOfamin[j];
      Object localObject = paramObject;
      while (paramObject != null)
      {
        amin localamin = amin.a(paramObject);
        if ((i == amin.a(paramObject)) && (paramObject.equals(localEntry)))
        {
          this.c += 1;
          this.jdField_a_of_type_Int -= 1;
          if (localObject == paramObject) {
            arrayOfamin[j] = localamin;
          }
          for (;;)
          {
            return paramObject;
            amin.a(localObject, localamin);
          }
        }
        localObject = paramObject;
        paramObject = localamin;
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
    amin[] arrayOfamin = this.jdField_a_of_type_ArrayOfAmin;
    int i = 0;
    while (i < arrayOfamin.length)
    {
      arrayOfamin[i] = null;
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
    amin[] arrayOfamin = a();
    int j;
    for (int i = arrayOfamin.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (amin localamin = arrayOfamin[j]; localamin != null; localamin = amin.a(localamin)) {
        if (paramObject.equals(amin.a(localamin))) {
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
    localObject = new amip(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = amin.a(paramObject)) {
      if ((amin.a(paramObject) == i) && (a(localObject, paramObject.get()))) {
        return amin.a(paramObject);
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
    localObject = new amis(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = b(paramObject1);
    int i = a(localObject);
    amin[] arrayOfamin = a();
    int j = a(i, arrayOfamin.length);
    for (paramObject1 = arrayOfamin[j]; paramObject1 != null; paramObject1 = amin.a(paramObject1)) {
      if ((i == amin.a(paramObject1)) && (a(localObject, paramObject1.get())))
      {
        localObject = amin.a(paramObject1);
        if (paramObject2 != localObject) {
          amin.a(paramObject1, paramObject2);
        }
        return localObject;
      }
    }
    this.c += 1;
    paramObject1 = arrayOfamin[j];
    arrayOfamin[j] = new amin(localObject, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, paramObject1);
    i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    if (i >= this.jdField_b_of_type_Int) {
      a(arrayOfamin.length * 2);
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
      j = this.jdField_a_of_type_ArrayOfAmin.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfAmin.length) {
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
    amin[] arrayOfamin = a();
    int j = a(i, arrayOfamin.length);
    paramObject = arrayOfamin[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      amin localamin = amin.a(paramObject);
      if ((i == amin.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.c += 1;
        this.jdField_a_of_type_Int -= 1;
        if (localObject1 == paramObject) {
          arrayOfamin[j] = localamin;
        }
        for (;;)
        {
          return amin.a(paramObject);
          amin.a(localObject1, localamin);
        }
      }
      localObject1 = paramObject;
      paramObject = localamin;
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
    localObject = new amiv(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */