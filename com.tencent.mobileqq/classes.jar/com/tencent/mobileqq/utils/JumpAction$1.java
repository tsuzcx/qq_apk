package com.tencent.mobileqq.utils;

import ambt;
import awge;
import awgf;
import awgg;
import bdhk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PushBannerReportLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class JumpAction$1
  extends Thread
{
  public JumpAction$1(bdhk parambdhk) {}
  
  public void run()
  {
    Object localObject1 = (String)this.this$0.a.get("version");
    Object localObject3 = ambt.a(this.this$0.b, this.this$0.c, (String)localObject1, "");
    localObject1 = bdhk.a(this.this$0).getEntityManagerFactory().createEntityManager();
    Object localObject4 = ((awgf)localObject1).a(PushBannerReportLog.class);
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
        ((List)localObject3).add(str + "|" + localObject5);
      }
      localObject4 = bdhk.a(this.this$0);
      bdhk.a(this.this$0);
      ((ambt)((QQAppInterface)localObject4).a(5)).a((String[])((List)localObject3).toArray(new String[((List)localObject3).size()]));
      ((awgf)localObject1).a(PushBannerReportLog.class);
      ((HashMap)localObject2).clear();
    }
    for (;;)
    {
      ((awgf)localObject1).a();
      return;
      localObject2 = new PushBannerReportLog();
      ((PushBannerReportLog)localObject2).setLog((String)localObject3);
      ((awgf)localObject1).a((awge)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.1
 * JD-Core Version:    0.7.0.1
 */