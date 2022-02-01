package com.tencent.viola.ui.view.lottie;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.view.View;
import com.tencent.viola.ui.component.VLottie;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;

public class VLottieView
  extends View
  implements IVView<VLottie>
{
  WeakReference<VLottie> mWeakReference;
  IVLottieViewProxy vLottieViewProxy;
  
  public VLottieView(Context paramContext)
  {
    super(paramContext);
    this.vLottieViewProxy = VLottieView.Factory.createVLottieView(paramContext);
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    IVLottieViewProxy localIVLottieViewProxy = this.vLottieViewProxy;
    if (localIVLottieViewProxy != null) {
      localIVLottieViewProxy.v_addAnimatorListener(paramAnimatorListener);
    }
  }
  
  public void bindComponent(VLottie paramVLottie)
  {
    this.mWeakReference = new WeakReference(paramVLottie);
  }
  
  public void cancelAnimation()
  {
    IVLottieViewProxy localIVLottieViewProxy = this.vLottieViewProxy;
    if (localIVLottieViewProxy != null) {
      localIVLottieViewProxy.v_cancelAnimation();
    }
  }
  
  public VLottie getComponent()
  {
    WeakReference localWeakReference = this.mWeakReference;
    if (localWeakReference != null) {
      return (VLottie)localWeakReference.get();
    }
    return null;
  }
  
  public View getRealView()
  {
    IVLottieViewProxy localIVLottieViewProxy = this.vLottieViewProxy;
    if ((localIVLottieViewProxy != null) && ((localIVLottieViewProxy instanceof View))) {
      return (View)localIVLottieViewProxy;
    }
    return new View(getContext());
  }
  
  public void loop(boolean paramBoolean)
  {
    IVLottieViewProxy localIVLottieViewProxy = this.vLottieViewProxy;
    if (localIVLottieViewProxy != null) {
      localIVLottieViewProxy.v_loop(paramBoolean);
    }
  }
  
  public void pauseAnimation()
  {
    IVLottieViewProxy localIVLottieViewProxy = this.vLottieViewProxy;
    if (localIVLottieViewProxy != null) {
      localIVLottieViewProxy.v_pauseAnimation();
    }
  }
  
  public void playAnimation()
  {
    IVLottieViewProxy localIVLottieViewProxy = this.vLottieViewProxy;
    if (localIVLottieViewProxy != null) {
      localIVLottieViewProxy.v_playAnimation();
    }
  }
  
  public void resumeAnimation()
  {
    IVLottieViewProxy localIVLottieViewProxy = this.vLottieViewProxy;
    if (localIVLottieViewProxy != null) {
      localIVLottieViewProxy.v_resumeAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.lottie.VLottieView
 * JD-Core Version:    0.7.0.1
 */