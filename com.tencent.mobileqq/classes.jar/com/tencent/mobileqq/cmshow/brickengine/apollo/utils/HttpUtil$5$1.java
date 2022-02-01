package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class HttpUtil$5$1
  extends IApolloRunnableTask
{
  HttpUtil$5$1(HttpUtil.5 param5, Map paramMap, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty()) {}
    for (Object localObject = new String[0];; localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]))
    {
      break;
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((ArrayList)localObject).add(localEntry.getKey());
        ((ArrayList)localObject).add(localEntry.getValue());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]HttpUtil", 2, new Object[] { "ApolloHttpUtil httpResponseCallback http:", Long.valueOf(this.this$0.jdField_a_of_type_Long), " url:", this.this$0.jdField_a_of_type_JavaLangString, " method:", this.this$0.b });
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.getSavaWrapper().httpResponseCallback(this.this$0.jdField_a_of_type_Long, this.jdField_a_of_type_Int, (String[])localObject, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.5.1
 * JD-Core Version:    0.7.0.1
 */