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
    a.put(101, AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
    a.put(105, AIOPanelUtiles.e);
    a.put(102, AIOPanelUtiles.l);
    a.put(103, AIOPanelUtiles.s);
    a.put(106, AIOPanelUtiles.w);
    a.put(104, AIOPanelUtiles.B);
    a.put(107, AIOPanelUtiles.Y);
  }
  
  private static int a(List<AIOPanelIconItem> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((((AIOPanelIconItem)paramList.get(i)).jdField_d_of_type_Int == 5) || (((AIOPanelIconItem)paramList.get(i)).jdField_d_of_type_Int == 6)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static AIOPanelIconItem a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public static AIOPanelIconItem a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = (AIOPanelIconItem)b.get(paramInt);
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (AIOPanelIconConfigProcessor.Config)QConfigManager.a().a(496);
        if (localObject != null)
        {
          List localList = ((AIOPanelIconConfigProcessor.Config)localObject).a;
          if (localList.size() > 0)
          {
            int i = 0;
            for (;;)
            {
              if (i >= localList.size()) {
                break label133;
              }
              localObject = (AIOPanelIconItem)localList.get(i);
              int[] arrayOfInt = (int[])a.get(((AIOPanelIconItem)localObject).jdField_a_of_type_Int);
              if (arrayOfInt != null)
              {
                int j = arrayOfInt[0];
                if (paramInt == j) {
                  break;
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
  }
  
  public static List<AIOPanelIconItem> a(Context paramContext)
  {
    for (;;)
    {
      int[] arrayOfInt;
      try
      {
        Object localObject = (AIOPanelIconConfigProcessor.Config)QConfigManager.a().a(496);
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
              arrayOfInt = (int[])a.get(localAIOPanelIconItem.jdField_a_of_type_Int);
              if (arrayOfInt != null) {
                break label213;
              }
              b.put(localAIOPanelIconItem.jdField_a_of_type_Int, localAIOPanelIconItem);
              j = 1;
              if (j == 0) {
                break label218;
              }
              k = localAIOPanelIconItem.jdField_a_of_type_Int;
              localAIOPanelIconItem.jdField_d_of_type_Int = k;
              localAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localAIOPanelIconItem.a();
              localAIOPanelIconItem.b = localAIOPanelIconItem.b();
              if (j == 0) {
                break label226;
              }
              j = 0;
              localAIOPanelIconItem.e = j;
              localAIOPanelIconItem.jdField_a_of_type_ArrayOfInt = arrayOfInt;
              localArrayList.add(localAIOPanelIconItem);
              i += 1;
              continue;
            }
            a(localArrayList);
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
      label213:
      int j = 0;
      continue;
      label218:
      int k = arrayOfInt[0];
      continue;
      label226:
      j = arrayOfInt[3];
    }
  }
  
  private static void a(List<AIOPanelIconItem> paramList)
  {
    Collections.sort(paramList);
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
    int[] arrayOfInt = AIOPanelUtiles.v;
    AIOPanelIconItem localAIOPanelIconItem = new AIOPanelIconItem((AIOPanelIconItem)paramList.get(i));
    localAIOPanelIconItem.jdField_d_of_type_Int = 6;
    localAIOPanelIconItem.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(arrayOfInt[1]);
    localAIOPanelIconItem.e = arrayOfInt[3];
    localAIOPanelIconItem.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    if (ShortVideoUtils.needTwoEntrance())
    {
      localAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(arrayOfInt[2]);
      paramList.add(i, localAIOPanelIconItem);
      return;
    }
    a.put(103, AIOPanelUtiles.v);
    localAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(AIOPanelUtiles.s[2]);
    paramList.set(i, localAIOPanelIconItem);
  }
  
  public static int[] a(int paramInt)
  {
    if (a != null) {
      return (int[])a.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.PlusPanelUtil
 * JD-Core Version:    0.7.0.1
 */