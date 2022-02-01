package com.tencent.viola.ui.component;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.lottie.IVLottieViewProxy;
import com.tencent.viola.ui.view.lottie.VLottieView;
import org.json.JSONObject;

public class VLottie
  extends VComponent<View>
{
  public final int STATE_ANIMATIONCANCEL = 2;
  public final int STATE_ANIMATIONEND = 3;
  public final int STATE_ANIMATIONSTART = 1;
  private Animator.AnimatorListener animatorListener = new VLottie.1(this);
  private String mUrl;
  
  public VLottie(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public VLottie(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer, int paramInt)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer, paramInt);
  }
  
  private void clear()
  {
    IVLottieViewProxy localIVLottieViewProxy = getLottieView();
    if (localIVLottieViewProxy != null)
    {
      localIVLottieViewProxy.v_cancelAnimation();
      localIVLottieViewProxy.v_removeAnimatorListener(this.animatorListener);
    }
  }
  
  private void fireAnimEvent(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", paramInt);
      fireEvent("stateChange", localJSONObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void destroy()
  {
    super.destroy();
    clear();
  }
  
  public IVLottieViewProxy getLottieView()
  {
    if ((getHostView() instanceof IVLottieViewProxy)) {
      return (IVLottieViewProxy)getHostView();
    }
    return null;
  }
  
  protected View initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VLottieView(paramContext);
    paramContext.loop(true);
    paramContext.addAnimatorListener(this.animatorListener);
    return paramContext.getRealView();
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    clear();
  }
  
  @JSMethod(uiThread=true)
  public void pause()
  {
    if (getLottieView() != null) {
      getLottieView().v_pauseAnimation();
    }
  }
  
  @JSMethod(uiThread=true)
  public void play()
  {
    if ((!TextUtils.isEmpty(this.mUrl)) && (getLottieView() != null)) {
      getLottieView().v_playAnimation();
    }
  }
  
  @JSMethod(uiThread=true)
  public void resume()
  {
    if (getLottieView() != null) {
      getLottieView().v_resumeAnimation();
    }
  }
  
  @VComponentProp(name="loop")
  public void setLoop(boolean paramBoolean)
  {
    if (getLottieView() != null) {
      getLottieView().v_loop(paramBoolean);
    }
  }
  
  @VComponentProp(name="src")
  public void setSrc(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(this.mUrl, paramString)) && (getLottieView() != null))
    {
      this.mUrl = paramString;
      getLottieView().v_setAnimation(this.mUrl, new VLottie.2(this));
    }
  }
  
  @JSMethod(uiThread=true)
  public void stop()
  {
    if (getLottieView() != null) {
      getLottieView().v_cancelAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VLottie
 * JD-Core Version:    0.7.0.1
 */