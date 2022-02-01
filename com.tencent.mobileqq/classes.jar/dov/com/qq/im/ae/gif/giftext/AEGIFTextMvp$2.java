package dov.com.qq.im.ae.gif.giftext;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEGIFTextMvp$2
  implements View.OnClickListener
{
  AEGIFTextMvp$2(AEGIFTextMvp paramAEGIFTextMvp) {}
  
  public void onClick(View paramView)
  {
    this.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.AEGIFTextMvp.2
 * JD-Core Version:    0.7.0.1
 */