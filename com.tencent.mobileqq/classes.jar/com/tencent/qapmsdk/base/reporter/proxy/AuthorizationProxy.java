package com.tencent.qapmsdk.base.reporter.proxy;

import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UrlMeta;
import com.tencent.qapmsdk.base.reporter.authorization.Authorization;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy;", "", "()V", "authorization", "Lcom/tencent/qapmsdk/base/reporter/authorization/Authorization;", "getAuthorization", "()Lcom/tencent/qapmsdk/base/reporter/authorization/Authorization;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class AuthorizationProxy
{
  public static final AuthorizationProxy INSTANCE = new AuthorizationProxy();
  @NotNull
  private static final Authorization authorization = new Authorization(new URL(BaseInfo.urlMeta.getAuthorizationUrl()));
  
  @NotNull
  public final Authorization getAuthorization()
  {
    return authorization;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.proxy.AuthorizationProxy
 * JD-Core Version:    0.7.0.1
 */