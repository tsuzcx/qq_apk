package com.tencent.viola.ui.action;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.animation.AnimationBean;
import com.tencent.viola.ui.animation.AnimationBean.Style;
import com.tencent.viola.ui.animation.AnimationModule.AnimationHolder;
import com.tencent.viola.ui.animation.BackgroundColorProperty;
import com.tencent.viola.ui.animation.HeightProperty;
import com.tencent.viola.ui.animation.WidthProperty;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponent.AnimationInfo;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.context.RenderActionContext;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.BorderDrawable;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.SingleFunctionParser;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.List;
import org.json.JSONObject;

public class MethodAnimation
  implements DOMAction, RenderAction
{
  private static final String TAG = "MethodAnimation";
  @Nullable
  private final JSONObject animation;
  @Nullable
  private final String callback;
  @Nullable
  private AnimationBean mAnimationBean;
  @NonNull
  private final String ref;
  
  public MethodAnimation(@NonNull String paramString1, @NonNull AnimationBean paramAnimationBean, @Nullable String paramString2)
  {
    this.ref = paramString1;
    this.mAnimationBean = paramAnimationBean;
    this.callback = paramString2;
    this.animation = null;
  }
  
  public MethodAnimation(@NonNull String paramString1, @Nullable JSONObject paramJSONObject, @Nullable String paramString2)
  {
    this.ref = paramString1;
    this.animation = paramJSONObject;
    this.callback = paramString2;
  }
  
  @Nullable
  private ObjectAnimator createAnimator(VComponent paramVComponent, int paramInt)
  {
    if (paramVComponent == null) {
      return null;
    }
    View localView = paramVComponent.getHostView();
    if (localView == null) {
      return null;
    }
    AnimationBean.Style localStyle = this.mAnimationBean.styles;
    if (localStyle != null)
    {
      List localList = localStyle.getHolders();
      if (!TextUtils.isEmpty(localStyle.backgroundColor))
      {
        paramVComponent = ViolaUtils.getBorderDrawable(paramVComponent);
        if (paramVComponent != null) {
          localList.add(PropertyValuesHolder.ofObject(new BackgroundColorProperty(), new ArgbEvaluator(), new Integer[] { Integer.valueOf(paramVComponent.getColor()), Integer.valueOf(ViolaUtils.getColor(localStyle.backgroundColor)) }));
        } else if ((localView.getBackground() instanceof ColorDrawable)) {
          localList.add(PropertyValuesHolder.ofObject(new BackgroundColorProperty(), new ArgbEvaluator(), new Integer[] { Integer.valueOf(((ColorDrawable)localView.getBackground()).getColor()), Integer.valueOf(ViolaUtils.getColor(localStyle.backgroundColor)) }));
        }
      }
      if ((localView.getLayoutParams() != null) && ((!TextUtils.isEmpty(localStyle.width)) || (!TextUtils.isEmpty(localStyle.height))))
      {
        paramVComponent = localView.getLayoutParams();
        if (!TextUtils.isEmpty(localStyle.width)) {
          localList.add(PropertyValuesHolder.ofInt(new WidthProperty(), new int[] { paramVComponent.width, (int)FlexConvertUtils.converPxByViewportToRealPx(localStyle.width, paramInt) }));
        }
        if (!TextUtils.isEmpty(localStyle.height)) {
          localList.add(PropertyValuesHolder.ofInt(new HeightProperty(), new int[] { paramVComponent.height, (int)FlexConvertUtils.converPxByViewportToRealPx(localStyle.height, paramInt) }));
        }
      }
      if (localStyle.getPivot() != null)
      {
        paramVComponent = localStyle.getPivot();
        localView.setPivotX(((Float)paramVComponent.first).floatValue());
        localView.setPivotY(((Float)paramVComponent.second).floatValue());
      }
      paramVComponent = ObjectAnimator.ofPropertyValuesHolder(localView, (PropertyValuesHolder[])localList.toArray(new PropertyValuesHolder[localList.size()]));
      paramVComponent.setStartDelay(this.mAnimationBean.delay);
      return paramVComponent;
    }
    return null;
  }
  
  @Nullable
  private Animator.AnimatorListener createAnimatorListener(ViolaInstance paramViolaInstance, @Nullable String paramString, VComponent paramVComponent, VComponent.AnimationInfo paramAnimationInfo)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return new MethodAnimation.2(this, paramViolaInstance, paramVComponent, paramAnimationInfo, paramString);
    }
    return null;
  }
  
  @Nullable
  private Interpolator createTimeInterpolator()
  {
    Object localObject = this.mAnimationBean.timingFunction;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      int i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        break;
      case 3105774: 
        if (((String)localObject).equals("ease")) {
          i = 3;
        }
        break;
      case -361990811: 
        if (((String)localObject).equals("ease-in-out")) {
          i = 2;
        }
        break;
      case -789192465: 
        if (((String)localObject).equals("ease-out")) {
          i = 1;
        }
        break;
      case -1102672091: 
        if (((String)localObject).equals("linear")) {
          i = 4;
        }
        break;
      case -1965120668: 
        if (((String)localObject).equals("ease-in")) {
          i = 0;
        }
        break;
      }
      if ((i != 0) && ((i != 1) && ((i != 2) && ((i != 3) && (i == 4))))) {}
    }
    try
    {
      localObject = new SingleFunctionParser(this.mAnimationBean.timingFunction, new MethodAnimation.3(this)).parse("cubic-bezier");
      if ((localObject != null) && (((List)localObject).size() == 4))
      {
        localObject = PathInterpolatorCompat.create(((Float)((List)localObject).get(0)).floatValue(), ((Float)((List)localObject).get(1)).floatValue(), ((Float)((List)localObject).get(2)).floatValue(), ((Float)((List)localObject).get(3)).floatValue());
        return localObject;
      }
      return null;
    }
    catch (RuntimeException localRuntimeException) {}
    return PathInterpolatorCompat.create(0.0F, 0.0F, 1.0F, 1.0F);
    return PathInterpolatorCompat.create(0.25F, 0.1F, 0.25F, 1.0F);
    return PathInterpolatorCompat.create(0.42F, 0.0F, 0.58F, 1.0F);
    return PathInterpolatorCompat.create(0.0F, 0.0F, 0.58F, 1.0F);
    return PathInterpolatorCompat.create(0.42F, 0.0F, 1.0F, 1.0F);
    return null;
    return null;
  }
  
  private void dealStartAnim(VComponent paramVComponent, ViolaInstance paramViolaInstance)
  {
    ObjectAnimator localObjectAnimator = createAnimator(paramVComponent, paramViolaInstance.getInstanceViewPortWidth());
    VComponent.AnimationInfo localAnimationInfo = new VComponent.AnimationInfo(localObjectAnimator, this.mAnimationBean);
    if (localObjectAnimator != null)
    {
      paramViolaInstance = createAnimatorListener(paramViolaInstance, this.callback, paramVComponent, localAnimationInfo);
      if (Build.VERSION.SDK_INT < 18) {
        paramVComponent.getHostView().setLayerType(2, null);
      }
      Interpolator localInterpolator = createTimeInterpolator();
      if (paramViolaInstance != null) {
        localObjectAnimator.addListener(paramViolaInstance);
      }
      if (localInterpolator != null) {
        localObjectAnimator.setInterpolator(localInterpolator);
      }
      paramVComponent.getHostView().setCameraDistance(this.mAnimationBean.styles.getCameraDistance());
      paramVComponent.addAnimationInfo(localAnimationInfo);
      localObjectAnimator.setDuration(this.mAnimationBean.duration);
      localObjectAnimator.start();
    }
  }
  
  private void startAnimation(@NonNull ViolaInstance paramViolaInstance, @Nullable VComponent paramVComponent)
  {
    AnimationBean localAnimationBean;
    if (paramVComponent != null)
    {
      localAnimationBean = this.mAnimationBean;
      if (localAnimationBean != null) {
        paramVComponent.setNeedLayoutOnAnimation(localAnimationBean.needLayout);
      }
      if (paramVComponent.getHostView() == null)
      {
        paramVComponent.postAnimation(new AnimationModule.AnimationHolder(this.mAnimationBean, this.callback));
        return;
      }
      localAnimationBean = this.mAnimationBean;
      if (localAnimationBean == null) {}
    }
    try
    {
      if (localAnimationBean.topIndex)
      {
        ViolaUtils.bringIndexToRootView(paramVComponent, paramViolaInstance.getRootComp());
        ViolaSDKManager.getInstance().postOnUiThread(new MethodAnimation.1(this, paramVComponent, paramViolaInstance));
        return;
      }
      dealStartAnim(paramVComponent, paramViolaInstance);
      return;
    }
    catch (RuntimeException paramViolaInstance) {}
  }
  
  public void executeDom(DOMActionContext paramDOMActionContext)
  {
    try
    {
      if ((!paramDOMActionContext.isDestory()) && (this.animation != null))
      {
        localObject = paramDOMActionContext.getDomByRef(this.ref);
        if ((localObject != null) && (paramDOMActionContext.getInstance() != null))
        {
          AnimationBean localAnimationBean = new AnimationBean(this.animation);
          if (localAnimationBean.styles != null)
          {
            int i = (int)((DomObject)localObject).getLayoutWidth();
            int j = (int)((DomObject)localObject).getLayoutHeight();
            localAnimationBean.styles.init(localAnimationBean.styles.transformOrigin, localAnimationBean.styles.transform, i, j, paramDOMActionContext.getInstance().getInstanceViewPortWidth());
            this.mAnimationBean = localAnimationBean;
            paramDOMActionContext.postRenderTask(this);
            return;
          }
        }
      }
    }
    catch (RuntimeException paramDOMActionContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RuntimeException :");
      ((StringBuilder)localObject).append(paramDOMActionContext.getMessage());
      ViolaLogUtils.e("MethodAnimation", ((StringBuilder)localObject).toString());
    }
  }
  
  public void executeRender(RenderActionContext paramRenderActionContext)
  {
    if (this.mAnimationBean != null)
    {
      ViolaInstance localViolaInstance = paramRenderActionContext.getInstance();
      if (localViolaInstance != null) {
        startAnimation(localViolaInstance, paramRenderActionContext.getComponent(this.ref));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.action.MethodAnimation
 * JD-Core Version:    0.7.0.1
 */