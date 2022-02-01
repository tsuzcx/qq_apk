package com.tencent.weseevideo.model.utils;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.tavcut.util.Logger;
import java.util.Collection;
import java.util.List;

public class CollectionUtils
{
  public static final int NOT_FIND_POSITION = -1;
  private static final String TAG = "CollectionUtils";
  
  public static <T> void add(Collection<T> paramCollection, T paramT)
  {
    if (paramCollection != null)
    {
      if (paramT == null) {
        return;
      }
      paramCollection.add(paramT);
    }
  }
  
  @Nullable
  public static <T> List<T> checkListType(List paramList, Class<T> paramClass)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return null;
      }
      if (paramClass.isAssignableFrom(paramList.get(0).getClass())) {
        return paramList;
      }
    }
    return null;
  }
  
  public static <T> T findElement(List<T> paramList, CollectionUtils.ElementCompare paramElementCompare)
  {
    int i = findPosition(paramList, paramElementCompare);
    if (i == -1) {
      return null;
    }
    return obtain(paramList, i);
  }
  
  public static <T> int findPosition(List<T> paramList, CollectionUtils.ElementCompare paramElementCompare)
  {
    if (paramList == null)
    {
      Logger.d("CollectionUtils", "findPosition() list == null.");
      return -1;
    }
    if (paramElementCompare == null)
    {
      Logger.d("CollectionUtils", "findPosition() compare == null");
      return -1;
    }
    int i = 0;
    while (i < paramList.size())
    {
      if (paramElementCompare.compared(paramList.get(i))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static boolean isEmpty(Collection<?> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static <T> T obtain(List<T> paramList, int paramInt)
  {
    if (paramList == null)
    {
      Logger.d("CollectionUtils", "obtain() list == null.");
      return null;
    }
    if (paramInt < 0)
    {
      Logger.d("CollectionUtils", "obtain() position < 0.");
      return null;
    }
    if (paramInt >= paramList.size())
    {
      Logger.d("CollectionUtils", "obtain() position >= list.size().");
      return null;
    }
    return paramList.get(paramInt);
  }
  
  public static boolean outOfBounds(SparseArray paramSparseArray, int paramInt)
  {
    return (paramSparseArray == null) || (paramInt < 0) || (paramInt >= paramSparseArray.size());
  }
  
  public static boolean outOfBounds(Collection paramCollection, int paramInt)
  {
    return (paramCollection == null) || (paramInt < 0) || (paramInt >= paramCollection.size());
  }
  
  public static <T> void remove(Collection<T> paramCollection, T paramT)
  {
    if (paramCollection != null)
    {
      if (paramT == null) {
        return;
      }
      paramCollection.remove(paramT);
    }
  }
  
  public static int size(Collection paramCollection)
  {
    if (paramCollection == null) {
      return 0;
    }
    return paramCollection.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.utils.CollectionUtils
 * JD-Core Version:    0.7.0.1
 */