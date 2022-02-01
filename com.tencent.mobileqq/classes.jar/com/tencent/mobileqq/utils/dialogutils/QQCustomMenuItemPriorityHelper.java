package com.tencent.mobileqq.utils.dialogutils;

import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QQCustomMenuItemPriorityHelper
{
  public static final int a;
  private static int b = 2147483647;
  private static Map<String, Integer> c = new QQCustomMenuItemPriorityHelper.1();
  
  static
  {
    int i;
    if ((ViewUtils.getDensity() > 1.5F) && (FontSettingManager.getFontLevel() <= 16.0F)) {
      i = 5;
    } else {
      i = 4;
    }
    a = i;
  }
  
  public static int a(String paramString)
  {
    Object localObject = (Integer)c.get(paramString);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[menu] menu '");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("' priority not init ");
      QLog.e("QQCustomMenuItemPriorityHelper", 2, ((StringBuilder)localObject).toString());
    }
    int i = b;
    b = i - 1;
    return i;
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu)
  {
    ArrayList localArrayList = new ArrayList(paramQQCustomMenu.a);
    Collections.sort(localArrayList, new QQCustomMenuItemPriorityHelper.2());
    Iterator localIterator = localArrayList.iterator();
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject1 = localObject5;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (QQCustomMenuItem)localIterator.next();
      if (localObject1 != null) {
        if (((QQCustomMenuItem)localObject1).a.equals(BaseApplication.getContext().getString(2131897640))) {
          localObject2 = localObject1;
        } else if (((QQCustomMenuItem)localObject1).a.equals(BaseApplication.getContext().getString(2131897617))) {
          localObject3 = localObject1;
        } else if (((QQCustomMenuItem)localObject1).a.equals(BaseApplication.getContext().getString(2131897635))) {
          localObject6 = localObject1;
        } else if (((QQCustomMenuItem)localObject1).a.equals(BaseApplication.getContext().getString(2131897639))) {
          localObject5 = localObject1;
        } else if (((QQCustomMenuItem)localObject1).a.equals(BaseApplication.getContext().getString(2131897624))) {
          localObject4 = localObject1;
        }
      }
    }
    if ((localObject6 != null) && (localObject6.e))
    {
      localArrayList.remove(localObject6);
      localArrayList.add(localObject6);
    }
    if ((localObject5 != null) && (localObject5.e) && (localObject4 != null))
    {
      localArrayList.remove(localObject5);
      localArrayList.add(localArrayList.indexOf(localObject4), localObject5);
    }
    if (localObject3 != null)
    {
      localArrayList.remove(localObject3);
      localArrayList.add(localObject3);
    }
    if (localObject2 != null)
    {
      localArrayList.remove(localObject2);
      int i = localArrayList.size();
      int j = a;
      if (i >= j) {
        localArrayList.add(j - 1, localObject2);
      } else {
        localArrayList.add(localObject2);
      }
    }
    paramQQCustomMenu.a.clear();
    paramQQCustomMenu.a.addAll(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper
 * JD-Core Version:    0.7.0.1
 */