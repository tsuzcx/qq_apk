package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IApolloRunnableTask;
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
    if (this.a.isEmpty()) {}
    for (Object localObject = new String[0];; localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]))
    {
      break;
      localObject = new ArrayList();
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((ArrayList)localObject).add(localEntry.getKey());
        ((ArrayList)localObject).add(localEntry.getValue());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]HttpUtil", 2, new Object[] { "ApolloHttpUtil httpResponseCallback http:", Long.valueOf(this.this$0.b), " url:", this.this$0.c, " method:", this.this$0.d });
    }
    this.this$0.e.getSavaWrapper().httpResponseCallback(this.this$0.b, this.b, (String[])localObject, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.5.1
 * JD-Core Version:    0.7.0.1
 */