package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.DataObserver;
import com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataEventDispatcher
{
  private static volatile DataEventDispatcher jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDataEventDispatcher;
  private final List<DataObserver> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static DataEventDispatcher a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDataEventDispatcher == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDataEventDispatcher == null) {
          jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDataEventDispatcher = new DataEventDispatcher();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsDataDataEventDispatcher;
  }
  
  public void a(int paramInt, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      while (localIterator.hasNext()) {
        ((DataObserver)localIterator.next()).a(paramInt, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, List<HeaderDataModel> paramList, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      while (localIterator.hasNext()) {
        ((DataObserver)localIterator.next()).a(paramInt1, paramBoolean, paramList, paramInt2);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      while (localIterator.hasNext()) {
        ((DataObserver)localIterator.next()).a(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(DataObserver paramDataObserver)
  {
    if (paramDataObserver == null) {
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramDataObserver)) {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.add(paramDataObserver);
        return;
      }
    }
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      while (localIterator.hasNext()) {
        ((DataObserver)localIterator.next()).b(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b(DataObserver paramDataObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramDataObserver);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DataEventDispatcher
 * JD-Core Version:    0.7.0.1
 */