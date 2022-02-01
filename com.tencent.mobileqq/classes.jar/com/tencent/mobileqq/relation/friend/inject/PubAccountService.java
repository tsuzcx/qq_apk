package com.tencent.mobileqq.relation.friend.inject;

import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.friend.inject.IPubAccountInjectService;
import mqq.app.AppRuntime;

public class PubAccountService
  implements IPubAccountInjectService
{
  public String a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = (PublicAccountInfo)((IPublicAccountDataManager)paramAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfoCache(paramString);
    if (paramAppRuntime != null) {
      return paramAppRuntime.name;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.friend.inject.PubAccountService
 * JD-Core Version:    0.7.0.1
 */