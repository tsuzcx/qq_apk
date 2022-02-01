package dov.com.qq.im.ae.gif.giftext.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEGIFSinglePreviewFragment$7
  implements View.OnClickListener
{
  AEGIFSinglePreviewFragment$7(AEGIFSinglePreviewFragment paramAEGIFSinglePreviewFragment) {}
  
  public void onClick(View paramView)
  {
    AEGIFSinglePreviewFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.7
 * JD-Core Version:    0.7.0.1
 */