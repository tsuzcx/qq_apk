package com.tencent.mobileqq.hotpic;

import android.util.SparseArray;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class HotpicDownloadDispatcher
  implements URLDrawable.DownloadListener
{
  int jdField_a_of_type_Int = 1;
  SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private HotPicPageView jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private LinkedList<URLDrawable> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  boolean jdField_a_of_type_Boolean = false;
  volatile int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  
  public HotpicDownloadDispatcher(HotPicPageView paramHotPicPageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView = paramHotPicPageView;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_b_of_type_Int == 0)
    {
      b(true);
      return;
    }
    b(false);
  }
  
  private void c()
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_Int -= 1;
        while ((this.jdField_b_of_type_Int < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
        {
          Object localObject3 = (URLDrawable)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
          if (((URLDrawable)localObject3).getStatus() != 1) {
            if (((URLDrawable)localObject3).getStatus() == 2)
            {
              ((URLDrawable)localObject3).restartDownload();
              this.jdField_b_of_type_Int += 1;
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("handlerNext,restartDownload, current ");
                ((StringBuilder)localObject3).append(this.jdField_b_of_type_Int);
                QLog.i("HotPicManager.Panel.HotpicDownloadDispatcher", 2, ((StringBuilder)localObject3).toString());
              }
            }
            else
            {
              ((URLDrawable)localObject3).startDownload();
              this.jdField_b_of_type_Int += 1;
            }
          }
        }
        if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView != null) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.m();
        }
        return;
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
  }
  
  public void a()
  {
    try
    {
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramURLDrawable);
    paramURLDrawable.startDownload();
    a(paramURLDrawable, paramInt);
  }
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    label176:
    for (;;)
    {
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {
            return;
          }
          this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
          paramURLDrawable.setDownloadListener(this);
          if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Int)
          {
            if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramURLDrawable))
            {
              paramURLDrawable.setAutoDownload(false);
              this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramURLDrawable);
              int i = this.jdField_a_of_type_JavaUtilLinkedList.size();
              if (!this.jdField_b_of_type_Boolean) {
                break label176;
              }
              paramInt = 20;
              if (i > paramInt)
              {
                paramURLDrawable = (URLDrawable)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
                paramURLDrawable.setAutoDownload(true);
                paramURLDrawable.setDownloadListener(null);
              }
            }
          }
          else
          {
            if (paramURLDrawable.getStatus() == 2) {
              paramURLDrawable.restartDownload();
            }
            this.jdField_b_of_type_Int += 1;
          }
          return;
        }
        paramInt = 15;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext()) {
        ((URLDrawable)localIterator.next()).setDownloadListener(null);
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        ((URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(0)).setDownloadListener(null);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 3;
      } else {
        i = 4;
      }
      this.jdField_a_of_type_Int = i;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    this.jdField_a_of_type_JavaUtilSet.remove(Integer.valueOf(paramInt));
    c();
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    int i = (int)paramLong;
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
    this.jdField_a_of_type_JavaUtilSet.remove(Integer.valueOf(i));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.b(i);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotpicDownloadDispatcher
 * JD-Core Version:    0.7.0.1
 */