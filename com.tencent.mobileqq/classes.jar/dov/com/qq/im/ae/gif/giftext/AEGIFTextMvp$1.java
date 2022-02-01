package dov.com.qq.im.ae.gif.giftext;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import dov.com.qq.im.ae.gif.giftext.adapter.AEGIFSmartTextAdapter;

class AEGIFTextMvp$1
  extends RecyclerView.OnScrollListener
{
  AEGIFTextMvp$1(AEGIFTextMvp paramAEGIFTextMvp) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    AEGIFTextMvp.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.AEGIFTextMvp.1
 * JD-Core Version:    0.7.0.1
 */