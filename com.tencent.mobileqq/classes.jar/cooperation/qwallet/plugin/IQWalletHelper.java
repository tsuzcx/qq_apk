package cooperation.qwallet.plugin;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQWalletHelper
  extends QRouteApi
{
  public abstract String getQWalletExternalPath();
  
  public abstract String getQWalletInternalPath();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.IQWalletHelper
 * JD-Core Version:    0.7.0.1
 */