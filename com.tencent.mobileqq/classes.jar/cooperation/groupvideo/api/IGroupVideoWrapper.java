package cooperation.groupvideo.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGroupVideoWrapper
  extends QRouteApi
{
  public abstract Object getProxy();
  
  public abstract int getPstnUserNumberInMAV(long paramLong, int paramInt);
  
  public abstract void init(AppInterface paramAppInterface);
  
  public abstract void initialize(IGroupVideoWrapper.OnGVideoReadyListener paramOnGVideoReadyListener);
  
  public abstract void onUpdateTroopList();
  
  public abstract void processS2C(byte[] paramArrayOfByte);
  
  public abstract void uninitialize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.groupvideo.api.IGroupVideoWrapper
 * JD-Core Version:    0.7.0.1
 */