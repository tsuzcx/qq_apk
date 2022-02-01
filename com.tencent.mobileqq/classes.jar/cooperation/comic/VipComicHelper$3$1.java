package cooperation.comic;

import bmbj;
import com.tencent.webbundle.sdk.WebBundleManager;

public class VipComicHelper$3$1
  implements Runnable
{
  public VipComicHelper$3$1(bmbj parambmbj) {}
  
  public void run()
  {
    WebBundleManager.getInstance("comic").destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.comic.VipComicHelper.3.1
 * JD-Core Version:    0.7.0.1
 */