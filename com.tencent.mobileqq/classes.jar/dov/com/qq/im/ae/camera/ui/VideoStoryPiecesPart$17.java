package dov.com.qq.im.ae.camera.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.arch.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.part.AEVideoStoryStateViewModel;

class VideoStoryPiecesPart$17
  implements Animator.AnimatorListener
{
  VideoStoryPiecesPart$17(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPiecesPart", 2, "ptv panel down");
    }
    if (VideoStoryPiecesPart.a(this.a) != null)
    {
      VideoStoryPiecesPart.a(this.a).setAlpha(1.0F);
      VideoStoryPiecesPart.a(this.a).setVisibility(4);
      VideoStoryPiecesPart.a(this.a).b().postValue(Boolean.valueOf(false));
    }
    VideoStoryPiecesPart.f(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.17
 * JD-Core Version:    0.7.0.1
 */