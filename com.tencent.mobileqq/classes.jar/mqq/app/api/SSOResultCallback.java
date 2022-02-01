package mqq.app.api;

import com.tencent.mobileqq.qroute.QRouteApi;

public abstract interface SSOResultCallback
  extends QRouteApi
{
  public abstract void callback(SSOResponse paramSSOResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.api.SSOResultCallback
 * JD-Core Version:    0.7.0.1
 */