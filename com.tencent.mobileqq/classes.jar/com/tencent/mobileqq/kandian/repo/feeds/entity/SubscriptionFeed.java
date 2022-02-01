package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.repo.feeds.api.IRIJSubscriptionFeeds;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionFeed
{
  public int a;
  public long a;
  public String a;
  public WeakReference<MessageRecord> a;
  public List<SubscriptionFeedItem> a;
  public int b = 0;
  
  public SubscriptionFeed()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a()
  {
    if (((IRIJSubscriptionFeeds)QRoute.api(IRIJSubscriptionFeeds.class)).clearUnreadMsg(this.jdField_a_of_type_JavaLangString)) {
      this.b = 0;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (SubscriptionFeed)paramObject;
      String str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        return str.equals(paramObject.jdField_a_of_type_JavaLangString);
      }
      return paramObject.jdField_a_of_type_JavaLangString == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed
 * JD-Core Version:    0.7.0.1
 */