package dov.com.qq.im.ae.album.fragment;

import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bllh;
import bmbx;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class AEAbstractPhotoListFragment$4
  implements Runnable
{
  public AEAbstractPhotoListFragment$4(bllh parambllh) {}
  
  public void run()
  {
    int i = bllh.a(this.this$0).indexOfChild(bllh.a(this.this$0));
    int j = Math.min(bllh.a(this.this$0).getWidth(), bllh.a(this.this$0).getHeight());
    bmbx.b("PhotoListActivity", "createVideoPreviewView--length=" + j);
    bllh.a(this.this$0).addView(this.this$0.a, Math.max(0, i + 1), new FrameLayout.LayoutParams(j, j));
    this.this$0.a.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.4
 * JD-Core Version:    0.7.0.1
 */