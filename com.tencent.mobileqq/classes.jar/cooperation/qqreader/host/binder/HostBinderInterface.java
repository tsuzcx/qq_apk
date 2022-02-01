package cooperation.qqreader.host.binder;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginInterface;

public class HostBinderInterface
{
  private PluginInterface a;
  
  public HostBinderInterface(PluginInterface paramPluginInterface)
  {
    this.a = paramPluginInterface;
  }
  
  public String getNickName()
  {
    return this.a.getNickName();
  }
  
  public long getUin()
  {
    return this.a.getUin();
  }
  
  public Bundle transfer(String paramString, Bundle paramBundle)
  {
    return this.a.transfer(paramString, paramBundle);
  }
  
  public void transferAsync(String paramString, Bundle paramBundle, HostBinderInterface.TransferCallback paramTransferCallback)
  {
    this.a.transferAsync(paramString, paramBundle, new HostBinderInterface.1(this, paramTransferCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.binder.HostBinderInterface
 * JD-Core Version:    0.7.0.1
 */