package com.tencent.mobileqq.kandian.repo.feeds;

import android.util.SparseArray;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SpecialChannelFilter
{
  private static SpecialChannelFilter a;
  private SparseArray<ChannelInfo> b = new SparseArray();
  private HashSet<Integer> c = new HashSet();
  private boolean d = true;
  
  public static SpecialChannelFilter a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new SpecialChannelFilter();
        }
      }
      finally {}
    }
    return a;
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == 9999;
  }
  
  public void a(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int i = ((Integer)paramList.next()).intValue();
        this.b.remove(i);
        this.c.remove(Integer.valueOf(i));
      }
    }
  }
  
  public void b(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        int k = this.b.keyAt(i);
        if ((!a(k)) && (!paramList.contains(Integer.valueOf(k)))) {
          localArrayList.add(Integer.valueOf(k));
        }
        i += 1;
      }
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        i = ((Integer)paramList.next()).intValue();
        this.b.remove(i);
        this.c.remove(Integer.valueOf(i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SpecialChannelFilter
 * JD-Core Version:    0.7.0.1
 */