package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEGIFSinglePreviewFragment$1
  implements View.OnClickListener
{
  AEGIFSinglePreviewFragment$1(AEGIFSinglePreviewFragment paramAEGIFSinglePreviewFragment) {}
  
  public void onClick(View paramView)
  {
    AEGIFSinglePreviewFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */