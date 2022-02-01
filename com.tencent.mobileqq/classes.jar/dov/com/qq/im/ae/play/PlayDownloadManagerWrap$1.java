package dov.com.qq.im.ae.play;

import bluy;
import blvb;
import blvj;

class PlayDownloadManagerWrap$1
  implements Runnable
{
  PlayDownloadManagerWrap$1(PlayDownloadManagerWrap paramPlayDownloadManagerWrap, bluy parambluy, blvb paramblvb, blvj paramblvj) {}
  
  public void run()
  {
    this.val$materialManager.a(this.val$materialManager.getApp(), this.val$templateInfo, this.val$downloadListener);
    this.val$templateInfo.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap.1
 * JD-Core Version:    0.7.0.1
 */