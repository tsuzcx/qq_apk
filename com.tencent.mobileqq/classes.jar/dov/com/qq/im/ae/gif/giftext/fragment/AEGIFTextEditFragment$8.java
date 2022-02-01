package dov.com.qq.im.ae.gif.giftext.fragment;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.report.AEBaseDataReporter;

class AEGIFTextEditFragment$8
  implements View.OnClickListener
{
  AEGIFTextEditFragment$8(AEGIFTextEditFragment paramAEGIFTextEditFragment) {}
  
  public void onClick(View paramView)
  {
    AEBaseDataReporter.a().ao();
    AEGIFTextEditFragment.b(this.a);
    new Handler().postDelayed(new AEGIFTextEditFragment.8.1(this), 200L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.8
 * JD-Core Version:    0.7.0.1
 */