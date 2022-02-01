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
    if (jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager == null) {
        jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager = new EmotionPanelPayBackListenerManager();
      }
      return jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager;
    }
    finally {}
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
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        EmotionPanelPayBackListener localEmotionPanelPayBackListener = (EmotionPanelPayBackListener)((WeakReference)localIterator.next()).get();
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
    }
    paramEmotionPanelPayBackListener = new WeakReference(paramEmotionPanelPayBackListener);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramEmotionPanelPayBackListener);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager
 * JD-Core Version:    0.7.0.1
 */