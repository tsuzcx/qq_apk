package dov.com.qq.im.ae.gif.giftext.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.BaseVMPeakActivity;

class AEGIFChunkPreviewFragment$2
  implements View.OnClickListener
{
  AEGIFChunkPreviewFragment$2(AEGIFChunkPreviewFragment paramAEGIFChunkPreviewFragment) {}
  
  public void onClick(View paramView)
  {
    AEGIFChunkPreviewFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */