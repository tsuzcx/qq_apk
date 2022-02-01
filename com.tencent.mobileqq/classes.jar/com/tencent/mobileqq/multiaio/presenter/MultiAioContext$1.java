package com.tencent.mobileqq.multiaio.presenter;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class MultiAioContext$1
  implements Runnable
{
  MultiAioContext$1(MultiAioContext paramMultiAioContext, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject1 = MultiAIOHelper.a(this.a, this.b, this.c, this.d, this.e, this.f);
    if (((List)localObject1).size() > 0) {
      ThreadManager.getSubThreadHandler().postDelayed(new MultiAioContext.1.1(this), 100L);
    }
    MultiAioContext.a(this.this$0, (List)localObject1);
    QQMessageFacade localQQMessageFacade = this.b.getMessageFacade();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (RecentBaseData)((Iterator)localObject1).next();
      if ((localObject2 instanceof RecentUserBaseData))
      {
        localObject2 = ((RecentUserBaseData)localObject2).e();
        localQQMessageFacade.c(((RecentUser)localObject2).uin, ((RecentUser)localObject2).getType(), 8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.presenter.MultiAioContext.1
 * JD-Core Version:    0.7.0.1
 */