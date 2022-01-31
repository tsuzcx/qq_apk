package cooperation.wadl.ipc;

import bdot;
import bici;

public class WadlProxyServiceManager$1
  implements Runnable
{
  public WadlProxyServiceManager$1(bici parambici) {}
  
  public void run()
  {
    bdot.b("WadlProxyServiceManager", "##@failed to lauch servie: reset mServiceConnecting status.");
    this.this$0.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceManager.1
 * JD-Core Version:    0.7.0.1
 */