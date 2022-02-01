package com.tencent.mobileqq.cmshow.engine.resource;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler.OnQueryBaseInfoListener;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.qphone.base.util.QLog;

class AbsApolloResManager$3
  implements ApolloExtensionHandler.OnQueryBaseInfoListener
{
  AbsApolloResManager$3(AbsApolloResManager paramAbsApolloResManager, String paramString, AppInterface paramAppInterface, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener) {}
  
  public boolean a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getApolloDressInfo onGetBaseInfo : ");
    String str;
    if (paramApolloBaseInfo == null) {
      str = null;
    } else {
      str = paramApolloBaseInfo.toString();
    }
    localStringBuilder.append(str);
    QLog.d("[cmshow]cm_res", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a)))
    {
      AbsApolloResManager.a(this.d, this.b, this.a, paramApolloBaseInfo, this.c);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getApolloDressInfo onDressUpdated : ");
    Object localObject2 = null;
    Object localObject1;
    if (paramApolloBaseInfo == null) {
      localObject1 = null;
    } else {
      localObject1 = paramApolloBaseInfo.toString();
    }
    localStringBuilder.append((String)localObject1);
    QLog.d("[cmshow]cm_res", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a)))
    {
      paramString = paramApolloBaseInfo;
      if (paramApolloBaseInfo == null)
      {
        paramApolloBaseInfo = ((IApolloDaoManagerService)this.b.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(this.a);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getApolloDressInfo onDressUpdated getApolloBaseInfo : ");
        if (paramApolloBaseInfo == null) {
          paramString = localObject2;
        } else {
          paramString = paramApolloBaseInfo.toString();
        }
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("[cmshow]cm_res", 1, ((StringBuilder)localObject1).toString());
        paramString = paramApolloBaseInfo;
      }
      AbsApolloResManager.a(this.d, this.b, this.a, paramString, this.c);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.3
 * JD-Core Version:    0.7.0.1
 */