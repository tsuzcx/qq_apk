package com.tencent.mobileqq.emoticon;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class EmotionPanelPayBackListenerManager
{
  private static EmotionPanelPayBackListenerManager jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager;
  ArrayList<WeakReference<EmotionPanelPayBackListener>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static EmotionPanelPayBackListenerManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager == null) {
          jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager = new EmotionPanelPayBackListenerManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmotionPanelPayBackListener localEmotionPanelPayBackListener = (EmotionPanelPayBackListener)((WeakReference)((Iterator)localObject).next()).get();
        if (localEmotionPanelPayBackListener != null) {
          localEmotionPanelPayBackListener.onPayBack(paramInt);
        }
      }
    }
  }
  
  public void a(EmotionPanelPayBackListener paramEmotionPanelPayBackListener)
  {
    if (paramEmotionPanelPayBackListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramEmotionPanelPayBackListener) {
          return;
        }
      }
      paramEmotionPanelPayBackListener = new WeakReference(paramEmotionPanelPayBackListener);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramEmotionPanelPayBackListener);
      return;
    }
    for (;;)
    {
      throw paramEmotionPanelPayBackListener;
    }
  }
  
  public void b(EmotionPanelPayBackListener paramEmotionPanelPayBackListener)
  {
    if (paramEmotionPanelPayBackListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramEmotionPanelPayBackListener) {
          localIterator.remove();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramEmotionPanelPayBackListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager
 * JD-Core Version:    0.7.0.1
 */