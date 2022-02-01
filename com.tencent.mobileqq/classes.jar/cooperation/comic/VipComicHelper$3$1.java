package cooperation.comic;

import com.tencent.webbundle.sdk.WebBundleManager;

class VipComicHelper$3$1
  implements Runnable
{
  VipComicHelper$3$1(VipComicHelper.3 param3) {}
  
  public void run()
  {
    WebBundleManager.getInstance("comic").destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicHelper.3.1
 * JD-Core Version:    0.7.0.1
 */