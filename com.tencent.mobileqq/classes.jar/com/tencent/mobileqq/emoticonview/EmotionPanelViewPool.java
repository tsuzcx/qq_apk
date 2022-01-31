package com.tencent.mobileqq.emoticonview;

import android.util.Log;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class EmotionPanelViewPool
{
  private static EmotionPanelViewPool jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPool;
  private Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public static EmotionPanelViewPool a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPool == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPool == null) {
        jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPool = new EmotionPanelViewPool();
      }
      return jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPool;
    }
    finally {}
  }
  
  public View a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (View)((ArrayList)localObject).remove(0);
        if (QLog.isColorLevel()) {
          Log.d("EmotionPanelViewPool", "getView from pool : paneyType = " + paramInt);
        }
        return localObject;
      }
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPool", 2, "destory");
    }
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localArrayList != null) {
          localArrayList.clear();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList;
      if (this.jdField_a_of_type_JavaUtilMap == null)
      {
        this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
        localArrayList = new ArrayList();
        localArrayList.add(paramView);
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localArrayList);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
      {
        localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        if ((localArrayList != null) && (!localArrayList.contains(paramView))) {
          localArrayList.add(0, paramView);
        }
      }
      while (QLog.isColorLevel())
      {
        Log.d("EmotionPanelViewPool", "relase view panelType = " + paramInt);
        return;
        localArrayList = new ArrayList();
        localArrayList.add(0, paramView);
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPool
 * JD-Core Version:    0.7.0.1
 */