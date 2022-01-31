package com.tencent.mobileqq.model;

import advn;
import com.tencent.mobileqq.app.ThreadManager;

public class QueryTask
{
  public QueryCallback a;
  public QueryTask.Query a;
  
  public QueryTask(QueryTask.Query paramQuery, QueryCallback paramQueryCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqModelQueryTask$Query = paramQuery;
    this.jdField_a_of_type_ComTencentMobileqqModelQueryCallback = paramQueryCallback;
  }
  
  public void a(Object paramObject)
  {
    ThreadManager.post(new advn(this, paramObject), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */