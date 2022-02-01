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
  private static Map<String, Integer> a;
  private static int b = 2147483647;
  
  static
  {
    if ((ViewUtils.a() > 1.5F) && (FontSettingManager.getFontLevel() <= 16.0F)) {}
    for (int i = 5;; i = 4)
    {
      jdField_a_of_type_Int = i;
      jdField_a_of_type_JavaUtilMap = new QQCustomMenuItemPriorityHelper.1();
      return;
    }
  }
  
  public static int a(String paramString)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQCustomMenuItemPriorityHelper", 2, "[menu] menu '" + paramString + "' priority not init ");
    }
    int i = b;
    b = i - 1;
    return i;
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu)
  {
    Object localObject2 = null;
    ArrayList localArrayList = new ArrayList(paramQQCustomMenu.a);
    Collections.sort(localArrayList, new QQCustomMenuItemPriorityHelper.2());
    Iterator localIterator = localArrayList.iterator();
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (QQCustomMenuItem)localIterator.next();
      if (localObject1 != null) {
        if (((QQCustomMenuItem)localObject1).jdField_a_of_type_JavaLangString.equals(BaseApplication.getContext().getString(2131699502))) {
          localObject3 = localObject1;
        } else if (((QQCustomMenuItem)localObject1).jdField_a_of_type_JavaLangString.equals(BaseApplication.getContext().getString(2131699481))) {
          localObject4 = localObject1;
        } else if (((QQCustomMenuItem)localObject1).jdField_a_of_type_JavaLangString.equals(BaseApplication.getContext().getString(2131699497))) {
          localObject5 = localObject1;
        } else if (((QQCustomMenuItem)localObject1).jdField_a_of_type_JavaLangString.equals(BaseApplication.getContext().getString(2131699501))) {
          localObject6 = localObject1;
        } else {
          if (!((QQCustomMenuItem)localObject1).jdField_a_of_type_JavaLangString.equals(BaseApplication.getContext().getString(2131699487))) {
            break label341;
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      if ((localObject5 != null) && (localObject5.jdField_a_of_type_Boolean))
      {
        localArrayList.remove(localObject5);
        localArrayList.add(localObject5);
      }
      if ((localObject6 != null) && (localObject6.jdField_a_of_type_Boolean) && (localObject2 != null))
      {
        localArrayList.remove(localObject6);
        localArrayList.add(localArrayList.indexOf(localObject2), localObject6);
      }
      if (localObject4 != null)
      {
        localArrayList.remove(localObject4);
        localArrayList.add(localObject4);
      }
      if (localObject3 != null)
      {
        localArrayList.remove(localObject3);
        if (localArrayList.size() < jdField_a_of_type_Int) {
          break label331;
        }
        localArrayList.add(jdField_a_of_type_Int - 1, localObject3);
      }
      for (;;)
      {
        paramQQCustomMenu.a.clear();
        paramQQCustomMenu.a.addAll(localArrayList);
        return;
        label331:
        localArrayList.add(localObject3);
      }
      label341:
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper
 * JD-Core Version:    0.7.0.1
 */