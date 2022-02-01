package dov.com.qq.im.ae.gif.giftext.fragment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import org.light.device.LightDeviceUtils;

class AEGIFChunkPreviewFragment$4
  extends RecyclerView.ItemDecoration
{
  AEGIFChunkPreviewFragment$4(AEGIFChunkPreviewFragment paramAEGIFChunkPreviewFragment) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView) % 2;
    int j = (int)(LightDeviceUtils.getScreenWidth(AEGIFChunkPreviewFragment.a(this.a)) * 0.04F);
    paramRect.left = (j - i * j / 2);
    paramRect.right = ((i + 1) * j / 2);
    paramRect.bottom = j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.4
 * JD-Core Version:    0.7.0.1
 */