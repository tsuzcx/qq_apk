package com.tencent.mobileqq.fragment;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

@Deprecated
@TargetApi(11)
public abstract class IphoneTitleBarFragment
  extends PublicBaseFragment
{
  public static final String HIDE_TITLE_LEFT_ARROW = "hide_title_left_arrow";
  public static final int LAYER_TYPE_SOFTWARE = 1;
  protected static final String TAG = "IphoneTitleBarFragment";
  private Drawable ad;
  public TextView centerView;
  private boolean isRightHighlightButton;
  public TextView leftView;
  public TextView leftViewNotBack;
  protected View mContentView;
  protected float mDensity;
  protected ImageView mLeftBackIcon;
  protected TextView mLeftBackText;
  private RelativeLayout mLoadingParent;
  private ImageView mLoadingView;
  private Drawable[] mOldDrawables;
  private int mOldPadding;
  public View mTitleContainer = null;
  protected boolean mUseOptimizMode = false;
  protected View.OnClickListener onBackListener = new IphoneTitleBarFragment.1(this);
  public TextView rightHighLView;
  public ImageView rightViewImg;
  public TextView rightViewText;
  public RelativeLayout titleRoot;
  protected NavBarCommon vg;
  
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle) {}
  
  protected void enableRightHighlight(boolean paramBoolean)
  {
    if (this.rightHighLView != null)
    {
      if (!this.isRightHighlightButton) {
        return;
      }
      if (paramBoolean)
      {
        this.rightViewText.setVisibility(8);
        this.rightHighLView.setVisibility(0);
        return;
      }
      this.rightViewText.setVisibility(0);
      this.rightHighLView.setVisibility(8);
    }
  }
  
  protected abstract int getContentLayoutId();
  
  public View getRightTextView()
  {
    this.rightViewText = ((TextView)this.titleRoot.findViewById(2131369233));
    setLayerType(this.rightViewText);
    return this.rightViewText;
  }
  
  public View getTitleBarView()
  {
    return this.titleRoot.findViewById(2131376636);
  }
  
  public void hideTitleBar()
  {
    try
    {
      this.mTitleContainer = this.titleRoot.findViewById(2131376636);
      this.mTitleContainer.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IphoneTitleBarFragment", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  protected void init(Bundle paramBundle)
  {
    if (getBaseActivity() == null) {
      return;
    }
    ((FrameLayout)getBaseActivity().findViewById(16908290)).setForeground(getResources().getDrawable(2130850439));
    if ((isTransparent()) && (needImmersive()) && (needStatusTrans()))
    {
      ViewParent localViewParent = getBaseActivity().findViewById(16908310).getParent();
      if ((localViewParent != null) && ((localViewParent instanceof FrameLayout))) {
        ((FrameLayout)localViewParent).setVisibility(8);
      }
    }
    if (this.leftView == null)
    {
      this.vg = ((NavBarCommon)this.titleRoot.findViewById(2131376636));
      onCreateLeftView();
      try
      {
        if ((paramBundle.getBoolean("hide_title_left_arrow", false)) && (this.leftView != null)) {
          this.leftView.setBackgroundDrawable(null);
        }
        onCreateCenterView();
        onCreateRightView();
        setLeftViewName(paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("IphoneTitleBarFragment", 1, "", paramBundle);
      }
    }
  }
  
  public boolean isTitleProgressShowing()
  {
    if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
    {
      ImageView localImageView = this.mLoadingView;
      if ((localImageView != null) && (localImageView.getVisibility() != 8)) {
        return true;
      }
    }
    else if (this.ad != null)
    {
      return true;
    }
    return false;
  }
  
  protected boolean isTransparent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
    return false;
  }
  
  protected View onCreateCenterView()
  {
    this.centerView = ((TextView)this.titleRoot.findViewById(2131369249));
    return this.centerView;
  }
  
  protected View onCreateLeftView()
  {
    this.leftView = ((TextView)this.titleRoot.findViewById(2131369202));
    this.leftView.setOnClickListener(this.onBackListener);
    this.mLeftBackText = ((TextView)this.titleRoot.findViewById(2131379476));
    this.mLeftBackIcon = ((ImageView)this.titleRoot.findViewById(2131369563));
    TextView localTextView = this.mLeftBackText;
    if ((localTextView != null) && (this.mLeftBackIcon != null))
    {
      localTextView.setOnClickListener(this.onBackListener);
      this.mLeftBackIcon.setOnClickListener(this.onBackListener);
    }
    return this.leftView;
  }
  
  protected View onCreateRightView()
  {
    this.rightViewText = ((TextView)this.titleRoot.findViewById(2131369233));
    this.rightViewImg = ((ImageView)this.titleRoot.findViewById(2131369216));
    setLayerType(this.rightViewText);
    setLayerType(this.rightViewImg);
    return this.rightViewText;
  }
  
  @TargetApi(14)
  @Nullable
  public final View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView4 = paramLayoutInflater.inflate(2131558948, paramViewGroup, false);
    View localView2;
    try
    {
      View localView1 = paramLayoutInflater.inflate(getContentLayoutId(), (ViewGroup)localView4, false);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IphoneTitleBarFragment", 1, localThrowable, new Object[0]);
      localView2 = null;
    }
    try
    {
      this.titleRoot = ((RelativeLayout)localView4.findViewById(2131378893));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.titleRoot.setFitsSystemWindows(true);
        this.titleRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131376636);
      this.titleRoot.addView(localView2, localLayoutParams);
      this.mContentView = localView2;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("IphoneTitleBarFragment", 1, localRuntimeException, new Object[0]);
    }
    catch (InflateException localInflateException)
    {
      QLog.e("IphoneTitleBarFragment", 1, localInflateException, new Object[0]);
    }
    View localView3 = this.mTitleContainer;
    if (localView3 != null) {
      localView3.setVisibility(0);
    }
    this.mDensity = getResources().getDisplayMetrics().density;
    init(getArguments());
    doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView4);
    return localView4;
  }
  
  @TargetApi(11)
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.vg.setLayerType(0, null);
    }
  }
  
  public void resetLeftButton()
  {
    TextView localTextView = this.leftViewNotBack;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    setLayerType(this.leftView);
    this.leftView.setVisibility(0);
  }
  
  public View setBottomTitleLayoutIdAndInflateIt(String paramString, int paramInt)
  {
    return this.vg.setBottomTitleLayoutIdAndInflateIt(paramString, paramInt);
  }
  
  public void setLeftButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)this.titleRoot.findViewById(2131369204));
    setLayerType(this.leftViewNotBack);
    this.leftViewNotBack.setVisibility(0);
    this.leftViewNotBack.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.leftViewNotBack.setOnClickListener(this.onBackListener);
      return;
    }
    this.leftViewNotBack.setOnClickListener(paramOnClickListener);
  }
  
  public void setLeftButton(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)this.titleRoot.findViewById(2131369204));
    if (TextUtils.isEmpty(paramString))
    {
      this.leftViewNotBack.setVisibility(8);
      return;
    }
    setLayerType(this.leftViewNotBack);
    this.leftViewNotBack.setVisibility(0);
    this.leftViewNotBack.setText(paramString);
    if (paramOnClickListener == null)
    {
      this.leftViewNotBack.setOnClickListener(this.onBackListener);
      return;
    }
    this.leftViewNotBack.setOnClickListener(paramOnClickListener);
  }
  
  public void setLeftViewName(int paramInt)
  {
    this.vg.setLeftViewName(paramInt);
  }
  
  public void setLeftViewName(Bundle paramBundle)
  {
    this.vg.setLeftViewName(paramBundle);
  }
  
  public void setRightButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.isRightHighlightButton = false;
    this.rightViewText.setVisibility(0);
    setTextWithTalk(this.rightViewText, paramInt);
    this.rightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.rightViewText.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setRightButtonEnable(boolean paramBoolean)
  {
    this.rightViewText.setEnabled(paramBoolean);
  }
  
  public void setRightButtonText(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.isRightHighlightButton = false;
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramString);
    this.rightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.rightViewText.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected void setRightHighlightButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.isRightHighlightButton = true;
    Object localObject = this.rightViewText;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      this.rightViewText.setText(paramInt);
      this.rightViewText.setEnabled(false);
      this.rightHighLView = ((TextView)LayoutInflater.from(getBaseActivity()).inflate(2131558951, null));
      setLayerType(this.rightHighLView);
      this.rightHighLView.setText(paramInt);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(this.mDensity * 8.0F));
      this.vg.addView(this.rightHighLView, (ViewGroup.LayoutParams)localObject);
      this.rightHighLView.setVisibility(8);
      if (paramOnClickListener != null) {
        this.rightHighLView.setOnClickListener(paramOnClickListener);
      }
    }
  }
  
  @TargetApi(11)
  public void setRightViewTextDisable(int paramInt)
  {
    if (paramInt == 0)
    {
      this.rightViewText.setEnabled(false);
      this.rightViewText.setAlpha(0.5F);
      return;
    }
    this.rightViewText.setEnabled(true);
    this.rightViewText.setAlpha(1.0F);
  }
  
  protected void setTextWithTalk(TextView paramTextView, int paramInt)
  {
    paramTextView.setText(paramInt);
    if (AppSetting.d)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTextView.getText());
      localStringBuilder.append(HardCodeUtil.a(2131705906));
      paramTextView.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.vg.setTitle(paramCharSequence);
  }
  
  public void setTitle(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4)
  {
    this.vg.setTitle(paramCharSequence1, paramCharSequence2, paramCharSequence3, paramCharSequence4);
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    this.vg.setTitle(paramCharSequence, paramString);
  }
  
  public void showTitleBar()
  {
    try
    {
      this.mTitleContainer = this.titleRoot.findViewById(2131376636);
      this.mTitleContainer.setVisibility(0);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IphoneTitleBarFragment", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public boolean startTitleProgress()
  {
    if (this.centerView != null)
    {
      if (getBaseActivity() == null) {
        return false;
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (this.mUseOptimizMode)
      {
        localObject1 = (RelativeLayout)this.titleRoot.findViewById(2131378837);
        if (this.centerView.getVisibility() == 0)
        {
          localObject1 = this.centerView;
          localObject2 = ((TextView)localObject1).getParent();
        }
        else if ((localObject1 != null) && (((RelativeLayout)localObject1).getVisibility() == 0))
        {
          localObject2 = ((RelativeLayout)localObject1).getParent();
        }
        else
        {
          localObject1 = null;
          localObject2 = localObject1;
        }
        localObject3 = this.mLoadingParent;
        if ((localObject3 != null) && (localObject3 != localObject2))
        {
          localObject3 = this.mLoadingView;
          if (localObject3 != null)
          {
            localObject3 = ((ImageView)localObject3).getParent();
            RelativeLayout localRelativeLayout = this.mLoadingParent;
            if (localObject3 == localRelativeLayout)
            {
              localRelativeLayout.removeView(this.mLoadingView);
              this.mLoadingView = null;
            }
          }
          this.mLoadingParent = null;
        }
        if ((this.mLoadingParent == null) && ((localObject2 instanceof RelativeLayout))) {
          this.mLoadingParent = ((RelativeLayout)localObject2);
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (this.mLoadingView != null)
          {
            int i = ((View)localObject1).getId();
            localObject3 = (RelativeLayout.LayoutParams)this.mLoadingView.getLayoutParams();
            localObject2 = localObject1;
            if (localObject3.getRules()[0] != i)
            {
              localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
              ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              ((RelativeLayout.LayoutParams)localObject3).addRule(0, i);
              this.mLoadingView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              localObject2 = localObject1;
            }
          }
        }
      }
      else
      {
        localObject2 = null;
      }
      if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
      {
        localObject1 = this.mLoadingView;
        if ((localObject1 == null) || (((ImageView)localObject1).getVisibility() != 0))
        {
          if (this.mLoadingView == null)
          {
            localObject1 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
            ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.mLoadingView = new ImageView(getBaseActivity());
            this.mLoadingView.setId(2131370369);
            localObject1 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject1).addRule(0, ((View)localObject2).getId());
            ((RelativeLayout.LayoutParams)localObject1).addRule(15);
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)(DeviceInfoUtil.a() * 7.0F));
            this.mLoadingParent.addView(this.mLoadingView, (ViewGroup.LayoutParams)localObject1);
            localObject1 = getBaseActivity().getResources().getDrawable(2130839404);
            this.mLoadingView.setImageDrawable((Drawable)localObject1);
            if ((localObject1 instanceof Animatable)) {
              ((Animatable)localObject1).start();
            }
          }
          if (this.mLoadingView.getVisibility() != 0) {
            this.mLoadingView.setVisibility(0);
          }
          return true;
        }
      }
      else if (this.ad == null)
      {
        this.ad = getResources().getDrawable(2130839404);
        this.mOldDrawables = this.centerView.getCompoundDrawables();
        this.mOldPadding = this.centerView.getCompoundDrawablePadding();
        this.centerView.setCompoundDrawablePadding(10);
        localObject1 = this.centerView;
        localObject2 = this.ad;
        localObject3 = this.mOldDrawables;
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, localObject3[1], localObject3[2], localObject3[3]);
        ((Animatable)this.ad).start();
        return true;
      }
    }
    return false;
  }
  
  public boolean stopTitleProgress()
  {
    Object localObject;
    if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
    {
      localObject = this.mLoadingView;
      if ((localObject != null) && (((ImageView)localObject).getVisibility() != 8))
      {
        this.mLoadingView.setVisibility(8);
        return true;
      }
    }
    else
    {
      localObject = this.ad;
      if (localObject != null)
      {
        ((Animatable)localObject).stop();
        this.ad = null;
        this.centerView.setCompoundDrawablePadding(this.mOldPadding);
        localObject = this.centerView;
        Drawable[] arrayOfDrawable = this.mOldDrawables;
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.IphoneTitleBarFragment
 * JD-Core Version:    0.7.0.1
 */