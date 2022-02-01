package dov.com.qq.im.ae.play;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.image.ApngImage;

class AEPlayShowPageView$1
  extends RecyclerView.OnScrollListener
{
  AEPlayShowPageView$1(AEPlayShowPageView paramAEPlayShowPageView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      ApngImage.resumeAll();
    }
    for (;;)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      return;
      ApngImage.pauseAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPageView.1
 * JD-Core Version:    0.7.0.1
 */