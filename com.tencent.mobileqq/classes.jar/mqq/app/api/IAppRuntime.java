package mqq.app.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAppRuntime
  extends QRouteApi
{
  public abstract String getAccount();
  
  public abstract void sendReq(SSORequest paramSSORequest, SSOResultCallback paramSSOResultCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.api.IAppRuntime
 * JD-Core Version:    0.7.0.1
 */