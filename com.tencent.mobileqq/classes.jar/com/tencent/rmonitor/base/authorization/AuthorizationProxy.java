package com.tencent.rmonitor.base.authorization;

import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UrlMeta;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/authorization/AuthorizationProxy;", "", "()V", "authorization", "Lcom/tencent/rmonitor/base/authorization/Authorization;", "getAuthorization", "()Lcom/tencent/rmonitor/base/authorization/Authorization;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class AuthorizationProxy
{
  public static final AuthorizationProxy a = new AuthorizationProxy();
  @NotNull
  private static final Authorization b = new Authorization(new URL(BaseInfo.urlMeta.getAuthorizationUrl()));
  
  @NotNull
  public final Authorization a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.authorization.AuthorizationProxy
 * JD-Core Version:    0.7.0.1
 */