package dov.com.qq.im.ae.gif.giftext.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEGIFChunkPreviewAdapter$4
  implements View.OnClickListener
{
  AEGIFChunkPreviewAdapter$4(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter) {}
  
  public void onClick(View paramView)
  {
    AEGIFChunkPreviewAdapter.a(this.a).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.4
 * JD-Core Version:    0.7.0.1
 */