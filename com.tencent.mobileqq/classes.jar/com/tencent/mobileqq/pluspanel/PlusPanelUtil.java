package com.tencent.mobileqq.pluspanel;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusPanelUtil
{
  private static final SparseArray<int[]> a = new SparseArray();
  private static final SparseArray<AIOPanelIconItem> b = new SparseArray();
  
  static
  {
    a.put(101, AIOPanelUtiles.b);
    a.put(105, AIOPanelUtiles.f);
    a.put(102, AIOPanelUtiles.m);
    a.put(103, AIOPanelUtiles.t);
    a.put(106, AIOPanelUtiles.x);
    a.put(104, AIOPanelUtiles.C);
    a.put(107, AIOPanelUtiles.Z);
  }
  
  private static int a(List<AIOPanelIconItem> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      j = i;
      if (((AIOPanelIconItem)paramList.get(i)).g == 5) {
        return j;
      }
      if (((AIOPanelIconItem)paramList.get(i)).g == 6) {
        return i;
      }
      i += 1;
    }
    int j = -1;
    return j;
  }
  
  public static AIOPanelIconItem a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (AIOPanelIconItem)b.get(paramInt);
    }
    try
    {
      Object localObject = (AIOPanelIconConfigProcessor.Config)QConfigManager.b().b(496);
      if (localObject != null)
      {
        localObject = ((AIOPanelIconConfigProcessor.Config)localObject).a;
        if (((List)localObject).size() > 0)
        {
          int i = 0;
          while (i < ((List)localObject).size())
          {
            AIOPanelIconItem localAIOPanelIconItem = (AIOPanelIconItem)((List)localObject).get(i);
            int[] arrayOfInt = (int[])a.get(localAIOPanelIconItem.a);
            if (arrayOfInt != null)
            {
              int j = arrayOfInt[0];
              if (paramInt == j) {
                return localAIOPanelIconItem;
              }
            }
            i += 1;
          }
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("PlusPanelUtil", 1, localException, new Object[0]);
    }
  }
  
  public static List<AIOPanelIconItem> a(Context paramContext)
  {
    for (;;)
    {
      int[] arrayOfInt;
      try
      {
        Object localObject = (AIOPanelIconConfigProcessor.Config)QConfigManager.b().b(496);
        if (localObject != null)
        {
          localObject = ((AIOPanelIconConfigProcessor.Config)localObject).a;
          if (((List)localObject).size() > 0)
          {
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            if (i < ((List)localObject).size())
            {
              AIOPanelIconItem localAIOPanelIconItem = (AIOPanelIconItem)((List)localObject).get(i);
              arrayOfInt = (int[])a.get(localAIOPanelIconItem.a);
              if (arrayOfInt != null) {
                break label222;
              }
              b.put(localAIOPanelIconItem.a, localAIOPanelIconItem);
              j = 1;
              if (j == 0) {
                break label227;
              }
              k = localAIOPanelIconItem.a;
              localAIOPanelIconItem.g = k;
              localAIOPanelIconItem.m = localAIOPanelIconItem.a();
              localAIOPanelIconItem.n = localAIOPanelIconItem.b();
              if (j == 0) {
                break label235;
              }
              j = 0;
              localAIOPanelIconItem.o = j;
              localAIOPanelIconItem.p = arrayOfInt;
              localArrayList.add(localAIOPanelIconItem);
              i += 1;
              continue;
            }
            b(localArrayList);
            a(localArrayList, paramContext);
            return localArrayList;
          }
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("PlusPanelUtil", 1, paramContext, new Object[0]);
      }
      return new ArrayList();
      label222:
      int j = 0;
      continue;
      label227:
      int k = arrayOfInt[0];
      continue;
      label235:
      j = arrayOfInt[3];
    }
  }
  
  private static void a(List<AIOPanelIconItem> paramList, Context paramContext)
  {
    int i = a(paramList);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PlusPanelUtil", 2, "did not have camera icon");
      }
      return;
    }
    int[] arrayOfInt = AIOPanelUtiles.w;
    AIOPanelIconItem localAIOPanelIconItem = new AIOPanelIconItem((AIOPanelIconItem)paramList.get(i));
    localAIOPanelIconItem.g = 6;
    localAIOPanelIconItem.h = paramContext.getResources().getString(arrayOfInt[1]);
    localAIOPanelIconItem.o = arrayOfInt[3];
    localAIOPanelIconItem.p = arrayOfInt;
    if (ShortVideoUtils.needTwoEntrance())
    {
      localAIOPanelIconItem.m = paramContext.getResources().getDrawable(arrayOfInt[2]);
      paramList.add(i, localAIOPanelIconItem);
      return;
    }
    a.put(103, AIOPanelUtiles.w);
    localAIOPanelIconItem.m = paramContext.getResources().getDrawable(AIOPanelUtiles.t[2]);
    paramList.set(i, localAIOPanelIconItem);
  }
  
  public static int[] a(int paramInt)
  {
    SparseArray localSparseArray = a;
    if (localSparseArray != null) {
      return (int[])localSparseArray.get(paramInt);
    }
    return null;
  }
  
  public static AIOPanelIconItem b(int paramInt)
  {
    return a(paramInt, false);
  }
  
  private static void b(List<AIOPanelIconItem> paramList)
  {
    Collections.sort(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.PlusPanelUtil
 * JD-Core Version:    0.7.0.1
 */