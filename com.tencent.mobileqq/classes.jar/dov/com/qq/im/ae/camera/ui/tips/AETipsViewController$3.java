package dov.com.qq.im.ae.camera.ui.tips;

import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

class AETipsViewController$3
  implements PAGView.PAGViewListener
{
  AETipsViewController$3(AETipsViewController paramAETipsViewController) {}
  
  public void onAnimationCancel(PAGView paramPAGView)
  {
    AETipsViewController.a(this.a).setVisibility(8);
  }
  
  public void onAnimationEnd(PAGView paramPAGView)
  {
    AETipsViewController.a(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(PAGView paramPAGView) {}
  
  public void onAnimationStart(PAGView paramPAGView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.tips.AETipsViewController.3
 * JD-Core Version:    0.7.0.1
 */