package cooperation.comic;

import bghn;
import com.tencent.webbundle.sdk.WebBundleManager;

public class VipComicHelper$2$1
  implements Runnable
{
  public VipComicHelper$2$1(bghn parambghn) {}
  
  public void run()
  {
    WebBundleManager.getInstance("comic").destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.comic.VipComicHelper.2.1
 * JD-Core Version:    0.7.0.1
 */