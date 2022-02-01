package com.tencent.mobileqq.onlinestatus.config;

import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AutoStatusElement
{
  public OnlineStatusItem a;
  public String a;
  public List<AutoStatusItem> a;
  public OnlineStatusItem b;
  public List<WeatherUrl> b;
  
  public AutoStatusElement()
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem = null;
  }
  
  public AutoStatusElement(List<AutoStatusItem> paramList, OnlineStatusItem paramOnlineStatusItem1, List<WeatherUrl> paramList1, String paramString, OnlineStatusItem paramOnlineStatusItem2)
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem = null;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem = paramOnlineStatusItem1;
    this.jdField_b_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem = paramOnlineStatusItem2;
  }
  
  public List<AutoStatusItem> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return localArrayList;
    }
    if (paramBoolean)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      return localArrayList;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AutoStatusItem localAutoStatusItem = (AutoStatusItem)localIterator.next();
      if (!localAutoStatusItem.b) {
        localArrayList.add(localAutoStatusItem);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.AutoStatusElement
 * JD-Core Version:    0.7.0.1
 */