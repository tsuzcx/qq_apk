package com.tencent.mobileqq.search.ftsmsg;

import com.tencent.mobileqq.app.GlobalSearchObserver;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class FTSMessageSearchEngine$8
  extends GlobalSearchObserver
{
  FTSMessageSearchEngine$8(FTSMessageSearchEngine paramFTSMessageSearchEngine) {}
  
  public void a(boolean paramBoolean, ArrayList<ArrayList<String>> paramArrayList, ArrayList<String> paramArrayList1)
  {
    super.a(paramBoolean, paramArrayList, paramArrayList1);
    paramArrayList1 = (String)paramArrayList1.get(0);
    StringBuilder localStringBuilder = new StringBuilder(64);
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      paramArrayList = ((ArrayList)paramArrayList.get(0)).iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (String)paramArrayList.next();
        if (((String)localObject).charAt(0) < '')
        {
          localObject = SQLiteFTSUtils.a((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              localStringBuilder.append(localObject[i]);
              localStringBuilder.append(" ");
              i += 1;
            }
          }
        }
        else
        {
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" ");
        }
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("svcSeg result = [");
        paramArrayList.append(localStringBuilder.toString().trim());
        paramArrayList.append("]");
        QLog.d("FTSMessageSearchEngine", 2, paramArrayList.toString());
      }
    }
    FTSMessageSearchEngine.a(this.a).put(paramArrayList1, localStringBuilder);
    paramArrayList = FTSMessageSearchEngine.b(this.a).get(paramArrayList1);
    if (paramArrayList != null) {
      try
      {
        paramArrayList.notify();
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.8
 * JD-Core Version:    0.7.0.1
 */