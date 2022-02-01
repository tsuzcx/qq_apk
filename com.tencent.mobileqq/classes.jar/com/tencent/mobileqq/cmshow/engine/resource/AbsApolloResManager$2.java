package com.tencent.mobileqq.cmshow.engine.resource;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class AbsApolloResManager$2
  implements Runnable
{
  AbsApolloResManager$2(AbsApolloResManager paramAbsApolloResManager, String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener) {}
  
  public void run()
  {
    ApolloExtensionHandler localApolloExtensionHandler = (ApolloExtensionHandler)AbsApolloResManager.b(this.this$0).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.a)))
    {
      ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)AbsApolloResManager.b(this.this$0).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getApolloDressInfo sync : ");
      if (localApolloBaseInfo == null) {
        localObject = null;
      } else {
        localObject = localApolloBaseInfo.toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("[cmshow]cm_res", 1, localStringBuilder.toString());
      if (localApolloBaseInfo != null)
      {
        localObject = this.this$0;
        if (AbsApolloResManager.a((AbsApolloResManager)localObject, localApolloBaseInfo, this.a, this.b, AbsApolloResManager.b((AbsApolloResManager)localObject), false)) {
          return;
        }
      }
    }
    if (localApolloExtensionHandler == null)
    {
      this.b.a(null, "VasExtensionHandler is null", -5004);
      return;
    }
    if (AbsApolloResManager.c(this.this$0) != null) {
      localApolloExtensionHandler.b(AbsApolloResManager.c(this.this$0));
    }
    localObject = this.this$0;
    AbsApolloResManager.a((AbsApolloResManager)localObject, AbsApolloResManager.a((AbsApolloResManager)localObject, this.a, this.b, AbsApolloResManager.b((AbsApolloResManager)localObject)));
    localApolloExtensionHandler.a(AbsApolloResManager.c(this.this$0));
    localApolloExtensionHandler.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.2
 * JD-Core Version:    0.7.0.1
 */