package cooperation.comic;

import bims;
import com.tencent.webbundle.sdk.WebBundleManager;

public class VipComicHelper$3$1
  implements Runnable
{
  public VipComicHelper$3$1(bims parambims) {}
  
  public void run()
  {
    WebBundleManager.getInstance("comic").destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.VipComicHelper.3.1
 * JD-Core Version:    0.7.0.1
 */