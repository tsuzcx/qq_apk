package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class EmotionPanelListViewPool
{
  private static EmotionPanelListViewPool jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewPool;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static EmotionPanelListViewPool a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewPool == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewPool == null) {
        jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewPool = new EmotionPanelListViewPool();
      }
      return jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewPool;
    }
    finally {}
  }
  
  public EmotionPanelListView a(Context paramContext)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      paramContext = (EmotionPanelListView)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (QLog.isColorLevel()) {
        Log.d("EmotionPanelListViewPool", "from listview pool and poolSize = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      return paramContext;
    }
    return new EmotionPanelListView(paramContext);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      Log.d("EmotionPanelListViewPool", "destory");
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
  }
  
  public void a(EmotionPanelListView paramEmotionPanelListView)
  {
    if (paramEmotionPanelListView == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(paramEmotionPanelListView);
      }
      while (QLog.isColorLevel())
      {
        Log.d("EmotionPanelListViewPool", "relase listview");
        return;
        if (!this.jdField_a_of_type_JavaUtilList.contains(paramEmotionPanelListView)) {
          this.jdField_a_of_type_JavaUtilList.add(0, paramEmotionPanelListView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListViewPool
 * JD-Core Version:    0.7.0.1
 */