package com.tencent.mobileqq.profilecard.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class ProfileContentTitleView
  extends FrameLayout
{
  private static final String TAG = "ProfileContentTitleView";
  public FrameLayout mContentContainer;
  public Context mContext;
  protected ViewGroup mRoot;
  public ImageView mTitleArrow;
  public ViewGroup mTitleContainer;
  public ViewGroup mTitleExtContainer;
  public ImageView mTitleIcon;
  public TextView mTitleText;
  public ViewGroup mTitleTextBg;
  
  public ProfileContentTitleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileContentTitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public void addContentView(View paramView)
  {
    if (this.mContentContainer != null)
    {
      if (this.mContentContainer.getChildCount() > 0) {
        QLog.e("ProfileContentTitleView", 1, "addContentView add fail, already exit.");
      }
    }
    else {
      return;
    }
    this.mContentContainer.addView(paramView);
  }
  
  public View getContentView()
  {
    if (this.mContentContainer != null) {
      return this.mContentContainer.getChildAt(0);
    }
    return null;
  }
  
  protected void init()
  {
    LayoutInflater.from(this.mContext).inflate(2131559703, this, true);
    this.mRoot = ((ViewGroup)findViewById(2131377366));
    this.mTitleContainer = ((ViewGroup)findViewById(2131379471));
    this.mTitleIcon = ((ImageView)findViewById(2131379477));
    this.mTitleText = ((TextView)findViewById(2131379527));
    this.mTitleTextBg = ((ViewGroup)findViewById(2131379528));
    this.mTitleArrow = ((ImageView)findViewById(2131379449));
    this.mTitleExtContainer = ((RelativeLayout)findViewById(2131379476));
    this.mContentContainer = ((FrameLayout)findViewById(2131365304));
    setIconEnable(false);
  }
  
  public void removeContentViews()
  {
    if (this.mContentContainer != null) {
      this.mContentContainer.removeAllViews();
    }
  }
  
  public void setArrowEnable(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.mTitleArrow != null)
    {
      localImageView = this.mTitleArrow;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (this.mTitleIcon != null) {
      this.mTitleIcon.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setIconEnable(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.mTitleIcon != null)
    {
      localImageView = this.mTitleIcon;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setMarginBottomEnable(boolean paramBoolean)
  {
    if (this.mRoot != null) {
      if (!paramBoolean) {
        break label50;
      }
    }
    label50:
    for (int i = getResources().getDimensionPixelSize(2131297601);; i = 0)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mRoot.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = i;
        this.mRoot.setLayoutParams(localLayoutParams);
      }
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    if (this.mTitleText != null) {
      this.mTitleText.setText(paramString);
    }
  }
  
  public void setTitleBackground(Drawable paramDrawable)
  {
    if (this.mTitleContainer != null) {
      this.mTitleContainer.setBackgroundDrawable(paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView
 * JD-Core Version:    0.7.0.1
 */