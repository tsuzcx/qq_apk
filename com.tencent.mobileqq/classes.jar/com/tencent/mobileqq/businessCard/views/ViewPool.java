package com.tencent.mobileqq.businessCard.views;

import android.annotation.TargetApi;
import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;

public class ViewPool
{
  Context jdField_a_of_type_AndroidContentContext;
  ViewPool.ViewPoolConsumer jdField_a_of_type_ComTencentMobileqqBusinessCardViewsViewPool$ViewPoolConsumer;
  LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public ViewPool(Context paramContext, ViewPool.ViewPoolConsumer paramViewPoolConsumer)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsViewPool$ViewPoolConsumer = paramViewPoolConsumer;
  }
  
  @TargetApi(9)
  Object a(Object paramObject1, Object paramObject2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      paramObject1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsViewPool$ViewPoolConsumer.a(this.jdField_a_of_type_AndroidContentContext);
      bool1 = true;
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsViewPool$ViewPoolConsumer.a(paramObject1, paramObject2, bool1);
      return paramObject1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsViewPool$ViewPoolConsumer.a(localObject, paramObject1)) {
        localIterator.remove();
      }
    }
    for (;;)
    {
      bool1 = bool2;
      paramObject1 = localObject;
      if (localObject != null) {
        break;
      }
      paramObject1 = this.jdField_a_of_type_JavaUtilLinkedList.pop();
      bool1 = bool2;
      break;
      localObject = null;
    }
  }
  
  @TargetApi(9)
  void a(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsViewPool$ViewPoolConsumer.a(paramObject);
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 10) {
      this.jdField_a_of_type_JavaUtilLinkedList.push(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.ViewPool
 * JD-Core Version:    0.7.0.1
 */