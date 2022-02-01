package com.tencent.mobileqq.kandian.repo.pts;

import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PTSEventDispatcher
{
  private static PTSEventDispatcher jdField_a_of_type_ComTencentMobileqqKandianRepoPtsPTSEventDispatcher;
  private final List<PTSEventDispatcher.PTSObserver> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static PTSEventDispatcher a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianRepoPtsPTSEventDispatcher == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianRepoPtsPTSEventDispatcher == null) {
          jdField_a_of_type_ComTencentMobileqqKandianRepoPtsPTSEventDispatcher = new PTSEventDispatcher();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianRepoPtsPTSEventDispatcher;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void a(int paramInt, List<Long> paramList, long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((PTSEventDispatcher.PTSObserver)localIterator.next()).a(paramInt, paramList, paramLong);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((PTSEventDispatcher.PTSObserver)localIterator.next()).a(paramInt, paramList, paramBoolean1, paramBoolean2, paramToServiceMsg);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(PTSEventDispatcher.PTSObserver paramPTSObserver)
  {
    if (paramPTSObserver == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramPTSObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramPTSObserver);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.PTSEventDispatcher
 * JD-Core Version:    0.7.0.1
 */