package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

public class SmartList<E>
  extends AbstractList<E>
  implements RandomAccess
{
  private Object myElem;
  private int mySize;
  
  public void add(int paramInt, E paramE)
  {
    if (paramInt >= 0)
    {
      int i = this.mySize;
      if (paramInt <= i)
      {
        if (i == 0)
        {
          this.myElem = paramE;
        }
        else if ((i == 1) && (paramInt == 0))
        {
          this.myElem = new Object[] { paramE, this.myElem };
        }
        else
        {
          i = this.mySize;
          Object[] arrayOfObject1 = new Object[i + 1];
          if (i == 1)
          {
            arrayOfObject1[0] = this.myElem;
          }
          else
          {
            Object[] arrayOfObject2 = (Object[])this.myElem;
            System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, paramInt);
            System.arraycopy(arrayOfObject2, paramInt, arrayOfObject1, paramInt + 1, this.mySize - paramInt);
          }
          arrayOfObject1[paramInt] = paramE;
          this.myElem = arrayOfObject1;
        }
        this.mySize += 1;
        this.modCount += 1;
        return;
      }
    }
    paramE = new StringBuilder();
    paramE.append("Index: ");
    paramE.append(paramInt);
    paramE.append(", Size: ");
    paramE.append(this.mySize);
    throw new IndexOutOfBoundsException(paramE.toString());
  }
  
  public boolean add(E paramE)
  {
    int j = this.mySize;
    if (j == 0)
    {
      this.myElem = paramE;
    }
    else if (j == 1)
    {
      this.myElem = new Object[] { this.myElem, paramE };
    }
    else
    {
      Object localObject = (Object[])this.myElem;
      int k = localObject.length;
      if (j >= k)
      {
        int i = k * 3 / 2 + 1;
        j += 1;
        if (i < j) {
          i = j;
        }
        Object[] arrayOfObject = new Object[i];
        this.myElem = arrayOfObject;
        System.arraycopy(localObject, 0, arrayOfObject, 0, k);
        localObject = arrayOfObject;
      }
      localObject[this.mySize] = paramE;
    }
    this.mySize += 1;
    this.modCount += 1;
    return true;
  }
  
  public void clear()
  {
    this.myElem = null;
    this.mySize = 0;
    this.modCount += 1;
  }
  
  public E get(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.mySize;
      if (paramInt < i)
      {
        if (i == 1) {
          return this.myElem;
        }
        return ((Object[])(Object[])this.myElem)[paramInt];
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size: ");
    localStringBuilder.append(this.mySize);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  @NotNull
  public Iterator<E> iterator()
  {
    int i = this.mySize;
    if (i == 0)
    {
      localObject = SmartList.EmptyIterator.getInstance();
      if (localObject == null) {
        $$$reportNull$$$0(2);
      }
      return localObject;
    }
    if (i == 1) {
      return new SmartList.SingletonIterator(this);
    }
    Object localObject = super.iterator();
    if (localObject == null) {
      $$$reportNull$$$0(3);
    }
    return localObject;
  }
  
  public E remove(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.mySize;
      if (paramInt < i)
      {
        if (i == 1)
        {
          localObject = this.myElem;
          this.myElem = null;
        }
        else
        {
          Object[] arrayOfObject = (Object[])this.myElem;
          localObject = arrayOfObject[paramInt];
          if (i == 2)
          {
            this.myElem = arrayOfObject[(1 - paramInt)];
          }
          else
          {
            i = i - paramInt - 1;
            if (i > 0) {
              System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i);
            }
            arrayOfObject[(this.mySize - 1)] = null;
          }
        }
        this.mySize -= 1;
        this.modCount += 1;
        return localObject;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Index: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", Size: ");
    ((StringBuilder)localObject).append(this.mySize);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public E set(int paramInt, E paramE)
  {
    if (paramInt >= 0)
    {
      int i = this.mySize;
      if (paramInt < i)
      {
        if (i == 1)
        {
          localObject = this.myElem;
          this.myElem = paramE;
          return localObject;
        }
        Object localObject = (Object[])this.myElem;
        E ? = localObject[paramInt];
        localObject[paramInt] = paramE;
        return ?;
      }
    }
    paramE = new StringBuilder();
    paramE.append("Index: ");
    paramE.append(paramInt);
    paramE.append(", Size: ");
    paramE.append(this.mySize);
    throw new IndexOutOfBoundsException(paramE.toString());
  }
  
  public int size()
  {
    return this.mySize;
  }
  
  @NotNull
  public <T> T[] toArray(@NotNull T[] paramArrayOfT)
  {
    if (paramArrayOfT == null) {
      $$$reportNull$$$0(4);
    }
    int i = paramArrayOfT.length;
    int j = this.mySize;
    if (j == 1)
    {
      if (i != 0)
      {
        paramArrayOfT[0] = this.myElem;
      }
      else
      {
        paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 1);
        paramArrayOfT[0] = this.myElem;
        if (paramArrayOfT == null) {
          $$$reportNull$$$0(5);
        }
        return paramArrayOfT;
      }
    }
    else
    {
      if (i < j)
      {
        paramArrayOfT = (Object[])Arrays.copyOf((Object[])this.myElem, j, paramArrayOfT.getClass());
        if (paramArrayOfT == null) {
          $$$reportNull$$$0(6);
        }
        return paramArrayOfT;
      }
      if (j != 0) {
        System.arraycopy(this.myElem, 0, paramArrayOfT, 0, j);
      }
    }
    j = this.mySize;
    if (i > j) {
      paramArrayOfT[j] = null;
    }
    if (paramArrayOfT == null) {
      $$$reportNull$$$0(7);
    }
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.SmartList
 * JD-Core Version:    0.7.0.1
 */