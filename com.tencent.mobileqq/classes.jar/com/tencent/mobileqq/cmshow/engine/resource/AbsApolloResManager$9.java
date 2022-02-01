package com.tencent.mobileqq.cmshow.engine.resource;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class AbsApolloResManager$9
  implements Runnable
{
  AbsApolloResManager$9(AbsApolloResManager paramAbsApolloResManager, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = AbsApolloResManager.b(this.this$0);
    if (localObject1 == null)
    {
      QLog.e("[cmshow]cm_res", 1, "[checkPanelActionRes] error! app is null! ");
      return;
    }
    localObject1 = (ApolloDaoManagerServiceImpl)((AppRuntime)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
    new ArrayList();
    if (this.a) {
      localObject1 = ((ApolloDaoManagerServiceImpl)localObject1).getFavNeedDownloadAction();
    } else {
      localObject1 = ((ApolloDaoManagerServiceImpl)localObject1).getNeedDownloadAction(this.b);
    }
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0) {
        return;
      }
      Object localObject2 = new ArrayList();
      int j;
      for (int i = 0; i < ((List)localObject1).size(); i = j)
      {
        ((List)localObject2).add(((List)localObject1).get(i));
        j = i + 1;
        if ((j % 8 == 0) || (j == ((List)localObject1).size()))
        {
          AbsApolloResManager localAbsApolloResManager = this.this$0;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.b);
          localStringBuilder.append("apollo_key");
          localStringBuilder.append(i);
          localAbsApolloResManager.a((List)localObject2, localStringBuilder.toString());
          ((List)localObject2).clear();
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder("update action[");
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((StringBuilder)localObject2).append(((ApolloActionData)((Iterator)localObject1).next()).actionId);
          ((StringBuilder)localObject2).append(",");
        }
        ((StringBuilder)localObject2).append("]");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkPanelActionRes... action: ");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
        QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.9
 * JD-Core Version:    0.7.0.1
 */