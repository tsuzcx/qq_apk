package dov.com.qq.im.ae.camera.ui.bottom;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.view.AECircleCaptureStyle;

class AECircleBottomListPart$2
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  AECircleBottomListPart$2(AECircleBottomListPart paramAECircleBottomListPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    AEBottomListAdapter.a(VideoStoryPiecesPart.a(paramRatio).f);
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AECircleBottomListPart.2
 * JD-Core Version:    0.7.0.1
 */