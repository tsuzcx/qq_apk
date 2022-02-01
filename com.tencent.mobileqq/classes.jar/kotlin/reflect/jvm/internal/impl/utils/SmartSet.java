package kotlin.reflect.jvm.internal.impl.utils;

import TT;;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

public final class SmartSet<T>
  extends AbstractSet<T>
{
  public static final SmartSet.Companion Companion = new SmartSet.Companion(null);
  private Object data;
  private int size;
  
  @JvmStatic
  @NotNull
  public static final <T> SmartSet<T> create()
  {
    return Companion.create();
  }
  
  public boolean add(T paramT)
  {
    if (size() == 0)
    {
      this.data = paramT;
    }
    else if (size() == 1)
    {
      if (Intrinsics.areEqual(this.data, paramT)) {
        return false;
      }
      this.data = new Object[] { this.data, paramT };
    }
    else
    {
      Object localObject;
      if (size() < 5)
      {
        localObject = this.data;
        if (localObject != null)
        {
          localObject = (Object[])localObject;
          if (ArraysKt.contains((Object[])localObject, paramT)) {
            return false;
          }
          if (size() == 4)
          {
            localObject = SetsKt.linkedSetOf(Arrays.copyOf((Object[])localObject, localObject.length));
            ((LinkedHashSet)localObject).add(paramT);
            paramT = (TT)localObject;
          }
          else
          {
            localObject = Arrays.copyOf((Object[])localObject, size() + 1);
            Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.copyOf(this, newSize)");
            localObject[(localObject.length - 1)] = paramT;
            paramT = (TT)localObject;
          }
          this.data = paramT;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      else
      {
        localObject = this.data;
        if (localObject == null) {
          break label199;
        }
        if (!TypeIntrinsics.asMutableSet(localObject).add(paramT)) {
          return false;
        }
      }
    }
    setSize(size() + 1);
    return true;
    label199:
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
  }
  
  public void clear()
  {
    this.data = null;
    setSize(0);
  }
  
  public boolean contains(Object paramObject)
  {
    if (size() == 0) {
      return false;
    }
    if (size() == 1) {
      return Intrinsics.areEqual(this.data, paramObject);
    }
    if (size() < 5)
    {
      localObject = this.data;
      if (localObject != null) {
        return ArraysKt.contains((Object[])localObject, paramObject);
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    Object localObject = this.data;
    if (localObject != null) {
      return ((Set)localObject).contains(paramObject);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Set<T>");
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  @NotNull
  public Iterator<T> iterator()
  {
    if (size() == 0) {
      return Collections.emptySet().iterator();
    }
    if (size() == 1) {
      return (Iterator)new SmartSet.SingletonIterator(this.data);
    }
    if (size() < 5)
    {
      localObject = this.data;
      if (localObject != null) {
        return (Iterator)new SmartSet.ArrayIterator((Object[])localObject);
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    Object localObject = this.data;
    if (localObject != null) {
      return TypeIntrinsics.asMutableSet(localObject).iterator();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
  }
  
  public void setSize(int paramInt)
  {
    this.size = paramInt;
  }
  
  public final int size()
  {
    return getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.SmartSet
 * JD-Core Version:    0.7.0.1
 */