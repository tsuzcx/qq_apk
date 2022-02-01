package dov.com.qq.im.ae.album.fragment;

import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.util.WeakReference;

class AEAbstractPhotoListFragment$ScaleLottieCompositionLoaderListener
  implements OnCompositionLoadedListener
{
  private WeakReference<AEAbstractPhotoListFragment> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  AEAbstractPhotoListFragment$ScaleLottieCompositionLoaderListener(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAEAbstractPhotoListFragment);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    AEAbstractPhotoListFragment localAEAbstractPhotoListFragment = (AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localAEAbstractPhotoListFragment == null) {
      return;
    }
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(false);
    if (this.jdField_a_of_type_Boolean) {
      localLottieDrawable.playAnimation();
    }
    for (;;)
    {
      localLottieDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(20.0F), ImmersiveUtils.dpToPx(20.0F));
      if (!this.b) {
        break;
      }
      AEAbstractPhotoListFragment.a(localAEAbstractPhotoListFragment, localLottieDrawable);
      AEAbstractPhotoListFragment.a(localAEAbstractPhotoListFragment).setCompoundDrawables(AEAbstractPhotoListFragment.a(localAEAbstractPhotoListFragment), null, null, null);
      return;
      localLottieDrawable.setProgress(1.0F);
    }
    AEAbstractPhotoListFragment.b(localAEAbstractPhotoListFragment, localLottieDrawable);
    AEAbstractPhotoListFragment.a(localAEAbstractPhotoListFragment).setCompoundDrawables(AEAbstractPhotoListFragment.b(localAEAbstractPhotoListFragment), null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.ScaleLottieCompositionLoaderListener
 * JD-Core Version:    0.7.0.1
 */