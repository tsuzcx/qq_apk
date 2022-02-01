package dov.com.qq.im.ae.album.fragment;

import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import dov.com.qq.im.ae.util.AEQLog;

class AEAbstractPhotoListFragment$5
  implements Runnable
{
  AEAbstractPhotoListFragment$5(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment) {}
  
  public void run()
  {
    int i = AEAbstractPhotoListFragment.a(this.this$0).indexOfChild(AEAbstractPhotoListFragment.a(this.this$0));
    int j = Math.min(AEAbstractPhotoListFragment.a(this.this$0).getWidth(), AEAbstractPhotoListFragment.a(this.this$0).getHeight());
    AEQLog.b("PhotoListActivity", "createVideoPreviewView--length=" + j);
    AEAbstractPhotoListFragment.a(this.this$0).addView(this.this$0.a, Math.max(0, i + 1), new FrameLayout.LayoutParams(j, j));
    this.this$0.a.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.5
 * JD-Core Version:    0.7.0.1
 */