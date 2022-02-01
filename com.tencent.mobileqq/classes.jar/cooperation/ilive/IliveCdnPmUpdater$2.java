package cooperation.ilive;

import java.io.File;
import java.util.concurrent.Callable;

class IliveCdnPmUpdater$2
  implements Callable<Boolean>
{
  IliveCdnPmUpdater$2(IliveCdnPmUpdater paramIliveCdnPmUpdater, File paramFile) {}
  
  public Boolean a()
  {
    boolean bool;
    if ((IliveCdnPmUpdater.a(this.b).exists()) && (this.a == IliveCdnPmUpdater.a(this.b))) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IliveCdnPmUpdater.2
 * JD-Core Version:    0.7.0.1
 */