package com.tencent.mobileqq.widget.navbar;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NavBarCommon
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final int CUSTOM_VIEW_MARGIN = 24;
  public static final String INDIVIDUATION_URL_SOURCE_TYPE = "individuation_url_type";
  public static final int REPORT_FROM_AIO = 40300;
  public static final int REPORT_FROM_AIO_EMOTICON_MANAGER = 40313;
  private Drawable ad;
  private View animView;
  private TextView bottomTitle;
  private TextView centerView;
  private TextView leftView;
  private TextView leftViewNotBack;
  private OnItemSelectListener listener;
  private ViewStub mBottomTitleStub;
  private ImageView mLeftBackIcon;
  private TextView mLeftBackText;
  private RelativeLayout mLoadingParent;
  private ImageView mLoadingView;
  private boolean mNotShowLeftText = true;
  private Drawable[] mOldDrawables;
  private int mOldPadding;
  protected boolean mUseOptimizMode = false;
  private ImageView rightViewImg;
  private ImageView rightViewImg1;
  private TextView rightViewText;
  private TextView rightViewText2;
  private RelativeLayout titleContainer;
  private TextView topTitle;
  
  public NavBarCommon(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public NavBarCommon(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public NavBarCommon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    View.inflate(paramContext, 2131558949, this);
    setBackgroundResource(2130850433);
    this.leftView = ((TextView)findViewById(2131369202));
    this.mLeftBackText = ((TextView)findViewById(2131379476));
    this.mLeftBackIcon = ((ImageView)findViewById(2131369563));
    this.leftViewNotBack = ((TextView)findViewById(2131369204));
    this.centerView = ((TextView)findViewById(2131369249));
    this.titleContainer = ((RelativeLayout)findViewById(2131378837));
    this.topTitle = ((TextView)findViewById(2131378880));
    this.bottomTitle = ((TextView)findViewById(2131378814));
    this.rightViewText = ((TextView)findViewById(2131369233));
    this.rightViewImg1 = ((ImageView)findViewById(2131369221));
    this.rightViewText2 = ((TextView)findViewById(2131369234));
    this.rightViewImg = ((ImageView)findViewById(2131369216));
    this.mBottomTitleStub = ((ViewStub)findViewById(2131378815));
    if (AppSetting.d)
    {
      AccessibilityUtil.b(this.leftView, Button.class.getName());
      paramContext = this.mLeftBackText;
      if (paramContext != null) {
        AccessibilityUtil.b(paramContext, Button.class.getName());
      }
      paramContext = this.mLeftBackIcon;
      if (paramContext != null) {
        AccessibilityUtil.b(paramContext, Button.class.getName());
      }
    }
  }
  
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  public void changeBg(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2131167394;
    } else {
      i = 2130850433;
    }
    setBackgroundResource(i);
    ColorStateList localColorStateList = getResources().getColorStateList(2131167051);
    this.leftView.setTextColor(localColorStateList);
    TextView localTextView = this.leftView;
    if (paramBoolean) {
      i = 2130840342;
    } else {
      i = 2130851066;
    }
    localTextView.setBackgroundResource(i);
    this.leftViewNotBack.setTextColor(localColorStateList);
    this.mLeftBackText.setTextColor(localColorStateList);
    this.centerView.setTextColor(localColorStateList);
    this.rightViewText.setTextColor(localColorStateList);
    this.rightViewText2.setTextColor(localColorStateList);
  }
  
  public TextView getLeftBackIcon()
  {
    return this.leftView;
  }
  
  public void hideLeft()
  {
    this.leftView.setVisibility(8);
    this.mLeftBackText.setVisibility(8);
    this.mLeftBackIcon.setVisibility(8);
    this.leftViewNotBack.setVisibility(8);
  }
  
  public void hideLeftText()
  {
    ViewUtils.b(this.leftViewNotBack, 8);
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
  
  public void onClick(View paramView)
  {
    if (this.listener != null)
    {
      int i = 0;
      int j = paramView.getId();
      if ((j != 2131369202) && (j != 2131379476) && (j != 2131369563))
      {
        if (j == 2131369233) {
          i = 2;
        } else if (j == 2131369216) {
          i = 4;
        } else if (j == 2131369234) {
          i = 3;
        } else if (j == 2131369221) {
          i = 5;
        } else if ((j != 2131369249) && (j != 2131378837))
        {
          if (j == 2131369204) {
            i = 8;
          }
        }
        else {
          i = 7;
        }
      }
      else {
        i = 1;
      }
      if (i != 0) {
        this.listener.onItemSelect(paramView, i);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View setBottomTitleLayoutIdAndInflateIt(String paramString, int paramInt)
  {
    this.centerView.setVisibility(8);
    this.titleContainer.setVisibility(0);
    this.topTitle.setText(paramString);
    this.topTitle.setContentDescription(paramString);
    this.mBottomTitleStub.setLayoutResource(paramInt);
    return this.mBottomTitleStub.inflate().findViewById(2131378816);
  }
  
  public void setCustomView(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, ViewUtils.a(29.0F));
    this.centerView.setVisibility(8);
    localLayoutParams1.addRule(13, -1);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.titleContainer.getLayoutParams();
    int i = ViewUtils.a(24.0F);
    localLayoutParams2.leftMargin = i;
    localLayoutParams2.rightMargin = i;
    this.titleContainer.setLayoutParams(localLayoutParams2);
    this.titleContainer.addView(paramView, localLayoutParams1);
    this.titleContainer.setVisibility(0);
  }
  
  public void setLeftBackVisible(int paramInt)
  {
    ViewUtils.b(this.leftView, paramInt);
  }
  
  public void setLeftButton(int paramInt)
  {
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131369204));
    setLayerType(this.leftViewNotBack);
    this.leftViewNotBack.setVisibility(0);
    this.leftViewNotBack.setText(paramInt);
  }
  
  public void setLeftButton(String paramString)
  {
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131369204));
    setLayerType(this.leftViewNotBack);
    this.leftViewNotBack.setVisibility(0);
    this.leftViewNotBack.setText(paramString);
  }
  
  public void setLeftViewName(int paramInt)
  {
    if (this.leftView != null)
    {
      Object localObject1 = this.leftViewNotBack;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      Object localObject2 = getContext().getString(paramInt);
      TextView localTextView = this.leftView;
      localObject1 = localObject2;
      if ("".equals(localObject2)) {
        localObject1 = getContext().getString(2131690706);
      }
      if (this.mNotShowLeftText) {
        localTextView.setText("  ");
      } else {
        localTextView.setText((CharSequence)localObject1);
      }
      localTextView.setVisibility(0);
      if (AppSetting.d)
      {
        localObject2 = localObject1;
        if (!((String)localObject1).contains(getContext().getString(2131690706)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(getContext().getString(2131690706));
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        this.leftView.setContentDescription((CharSequence)localObject2);
      }
    }
  }
  
  public void setLeftViewName(Bundle paramBundle)
  {
    Object localObject;
    if ((this.leftView != null) && (paramBundle != null))
    {
      localObject = this.leftViewNotBack;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    try
    {
      TextView localTextView = this.leftView;
      String str = paramBundle.getString("leftViewText");
      int i = paramBundle.getInt("individuation_url_type");
      localObject = str;
      if (i >= 40300)
      {
        localObject = str;
        if (i <= 40313)
        {
          localObject = str;
          if (!TextUtils.isEmpty(str))
          {
            localObject = str;
            if (str.contains(HardCodeUtil.a(2131707116))) {
              localObject = getContext().getString(2131690706);
            }
          }
        }
      }
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = getContext().getString(2131690706);
      }
      if (this.mNotShowLeftText) {
        localTextView.setText("  ");
      } else {
        localTextView.setText(paramBundle);
      }
      localTextView.setVisibility(0);
      if (AppSetting.d)
      {
        localObject = paramBundle;
        if (!paramBundle.contains(getContext().getString(2131690706)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(getContext().getString(2131690706));
          ((StringBuilder)localObject).append(paramBundle);
          localObject = ((StringBuilder)localObject).toString();
        }
        this.leftView.setContentDescription((CharSequence)localObject);
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  public void setNotShowLeftText(boolean paramBoolean)
  {
    this.mNotShowLeftText = paramBoolean;
  }
  
  public void setOnItemSelectListener(OnItemSelectListener paramOnItemSelectListener)
  {
    this.listener = paramOnItemSelectListener;
    this.leftView.setOnClickListener(this);
    paramOnItemSelectListener = this.mLeftBackText;
    if (paramOnItemSelectListener != null) {
      paramOnItemSelectListener.setOnClickListener(this);
    }
    paramOnItemSelectListener = this.mLeftBackIcon;
    if (paramOnItemSelectListener != null) {
      paramOnItemSelectListener.setOnClickListener(this);
    }
    paramOnItemSelectListener = this.leftViewNotBack;
    if (paramOnItemSelectListener != null) {
      paramOnItemSelectListener.setOnClickListener(this);
    }
    this.rightViewText.setOnClickListener(this);
    this.rightViewImg1.setOnClickListener(this);
    this.rightViewText2.setOnClickListener(this);
    this.rightViewImg.setOnClickListener(this);
    this.centerView.setOnClickListener(this);
    this.titleContainer.setOnClickListener(this);
  }
  
  public void setRightButton(int paramInt)
  {
    this.rightViewText.setVisibility(0);
    this.rightViewImg1.setVisibility(8);
    this.rightViewText.setText(paramInt);
    this.rightViewText.setEnabled(true);
    if (AppSetting.d)
    {
      TextView localTextView = this.rightViewText;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.rightViewText.getText());
      localStringBuilder.append(HardCodeUtil.a(2131707117));
      localTextView.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void setRightButton(String paramString)
  {
    this.rightViewText.setVisibility(0);
    this.rightViewImg1.setVisibility(8);
    this.rightViewText.setText(paramString);
    this.rightViewText.setEnabled(true);
    if (AppSetting.d)
    {
      paramString = this.rightViewText;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.rightViewText.getText());
      localStringBuilder.append(HardCodeUtil.a(2131707117));
      paramString.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void setRightButton2(int paramInt)
  {
    this.rightViewText2.setVisibility(0);
    this.rightViewImg.setVisibility(8);
    this.rightViewText2.setText(paramInt);
    this.rightViewText2.setEnabled(true);
    if (AppSetting.d)
    {
      TextView localTextView = this.rightViewText;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.rightViewText.getText());
      localStringBuilder.append(HardCodeUtil.a(2131707117));
      localTextView.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void setRightImage(Drawable paramDrawable)
  {
    this.rightViewImg1.setVisibility(0);
    this.rightViewText.setVisibility(8);
    this.rightViewImg1.setImageDrawable(paramDrawable);
  }
  
  public void setRightImage(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.rightViewImg1.setVisibility(0);
    this.rightViewText.setVisibility(8);
    this.rightViewImg1.setImageDrawable(paramDrawable1);
    this.rightViewImg1.setBackgroundDrawable(paramDrawable2);
  }
  
  public void setRightImage2(Drawable paramDrawable)
  {
    this.rightViewImg.setImageDrawable(paramDrawable);
    this.rightViewImg.setVisibility(0);
    this.rightViewText2.setVisibility(8);
  }
  
  public void setRightImage2Desc(String paramString)
  {
    this.rightViewImg.setContentDescription(paramString);
  }
  
  public void setRightImageDesc(String paramString)
  {
    this.rightViewImg1.setContentDescription(paramString);
  }
  
  public void setRightViewTextVisible(int paramInt)
  {
    ViewUtils.b(this.rightViewText, paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    TextView localTextView = this.centerView;
    if (localTextView != null)
    {
      localTextView.setText(paramCharSequence);
      this.centerView.setVisibility(0);
    }
    paramCharSequence = this.titleContainer;
    if (paramCharSequence != null) {
      paramCharSequence.setVisibility(8);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4)
  {
    if (this.centerView.getVisibility() != 8) {
      this.centerView.setVisibility(8);
    }
    if (this.titleContainer.getVisibility() != 0) {
      this.titleContainer.setVisibility(0);
    }
    if (!TextUtils.equals(paramCharSequence1, this.topTitle.getText()))
    {
      this.topTitle.setText(paramCharSequence1);
      this.topTitle.setContentDescription(paramCharSequence2);
    }
    if (!TextUtils.equals(paramCharSequence3, this.bottomTitle.getText()))
    {
      this.bottomTitle.setText(paramCharSequence3);
      this.bottomTitle.setContentDescription(paramCharSequence4);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    TextView localTextView = this.centerView;
    if (localTextView != null)
    {
      if (localTextView.getVisibility() != 0) {
        this.centerView.setVisibility(0);
      }
      if (!TextUtils.equals(paramCharSequence, this.centerView.getText())) {
        this.centerView.setText(paramCharSequence);
      }
      if ((!TextUtils.equals(paramString, this.centerView.getContentDescription())) && (AppSetting.d)) {
        this.centerView.setContentDescription(paramString);
      }
    }
    paramCharSequence = this.titleContainer;
    if ((paramCharSequence != null) && (paramCharSequence.getVisibility() != 8)) {
      this.titleContainer.setVisibility(8);
    }
  }
  
  public void setTitleColor(int paramInt)
  {
    TextView localTextView = this.centerView;
    if (localTextView != null)
    {
      localTextView.setTextColor(paramInt);
      this.centerView.setVisibility(0);
    }
  }
  
  public void showLeftText()
  {
    ViewUtils.b(this.leftViewNotBack, 0);
  }
  
  public boolean startTitleProgress()
  {
    if (this.centerView == null) {
      return false;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.mUseOptimizMode)
    {
      localObject1 = (RelativeLayout)findViewById(2131378837);
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
          this.mLoadingView = new ImageView(getContext());
          this.mLoadingView.setId(2131370369);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, ((View)localObject2).getId());
          ((RelativeLayout.LayoutParams)localObject1).addRule(15);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ViewUtils.a(7.0F);
          this.mLoadingParent.addView(this.mLoadingView, (ViewGroup.LayoutParams)localObject1);
          localObject1 = getResources().getDrawable(2130839404);
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
  
  public void toggleAnim(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.animView == null)
    {
      if (!paramBoolean) {
        return;
      }
      this.animView = new View(getContext());
      this.animView.setBackgroundResource(2130850433);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.animView, 0, localLayoutParams);
    }
    if (paramBoolean)
    {
      this.animView.animate().alpha(1.0F).setDuration(300L).setInterpolator(new AccelerateInterpolator()).setListener(paramAnimatorListener);
      return;
    }
    this.animView.animate().alpha(0.0F).setDuration(300L).setInterpolator(new AccelerateInterpolator()).setListener(paramAnimatorListener);
  }
  
  public void updateRedDot(int paramInt, boolean paramBoolean)
  {
    View localView;
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            localView = null;
          } else {
            localView = findViewById(2131369220);
          }
        }
        else {
          localView = findViewById(2131369215);
        }
      }
      else {
        localView = findViewById(2131369236);
      }
    }
    else {
      localView = findViewById(2131369235);
    }
    if (localView != null)
    {
      if (paramBoolean) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      localView.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.navbar.NavBarCommon
 * JD-Core Version:    0.7.0.1
 */