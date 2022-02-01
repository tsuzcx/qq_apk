package dov.com.qq.im.ae.gif.giftext.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.report.AEBaseDataReporter;

class AEGIFSinglePreviewFragment$3
  implements View.OnClickListener
{
  AEGIFSinglePreviewFragment$3(AEGIFSinglePreviewFragment paramAEGIFSinglePreviewFragment) {}
  
  public void onClick(View paramView)
  {
    AEBaseDataReporter.a().ak();
    AEGIFSinglePreviewFragment.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */