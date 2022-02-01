package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ReportHandler;
import com.tencent.mobileqq.data.PushBannerReportLog;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class JumpActionLegacy$32
  extends Thread
{
  JumpActionLegacy$32(JumpActionLegacy paramJumpActionLegacy) {}
  
  public void run()
  {
    Object localObject1 = (String)this.this$0.f.get("version");
    Object localObject3 = ReportHandler.a(this.this$0.d, this.this$0.e, (String)localObject1, "");
    localObject1 = this.this$0.H.getEntityManagerFactory().createEntityManager();
    Object localObject4 = ((EntityManager)localObject1).query(PushBannerReportLog.class);
    Object localObject2;
    if ((localObject4 != null) && (((List)localObject4).size() >= 9))
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put(localObject3, Integer.valueOf(1));
      localObject3 = ((List)localObject4).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (PushBannerReportLog)((Iterator)localObject3).next();
        if (((HashMap)localObject2).containsKey(((PushBannerReportLog)localObject4).getLog())) {
          ((HashMap)localObject2).put(((PushBannerReportLog)localObject4).getLog(), Integer.valueOf(((Integer)((HashMap)localObject2).get(((PushBannerReportLog)localObject4).getLog())).intValue() + 1));
        } else {
          ((HashMap)localObject2).put(((PushBannerReportLog)localObject4).getLog(), Integer.valueOf(1));
        }
      }
      localObject3 = new ArrayList();
      localObject4 = ((HashMap)localObject2).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
        String str = (String)((Map.Entry)localObject5).getKey();
        localObject5 = (Integer)((Map.Entry)localObject5).getValue();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("|");
        localStringBuilder.append(localObject5);
        ((List)localObject3).add(localStringBuilder.toString());
      }
      ((ReportHandler)this.this$0.H.getBusinessHandler(BusinessHandlerFactory.REPORT_HANDLER)).a((String[])((List)localObject3).toArray(new String[((List)localObject3).size()]));
      ((EntityManager)localObject1).drop(PushBannerReportLog.class);
      ((HashMap)localObject2).clear();
    }
    else
    {
      localObject2 = new PushBannerReportLog();
      ((PushBannerReportLog)localObject2).setLog((String)localObject3);
      ((EntityManager)localObject1).persist((Entity)localObject2);
    }
    ((EntityManager)localObject1).close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.32
 * JD-Core Version:    0.7.0.1
 */