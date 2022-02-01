package com.tencent.mobileqq.profilecard.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
  protected Context mContext;
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
    FrameLayout localFrameLayout = this.mContentContainer;
    if (localFrameLayout != null)
    {
      if (localFrameLayout.getChildCount() > 0)
      {
        QLog.e("ProfileContentTitleView", 1, "addContentView add fail, already exit.");
        return;
      }
      this.mContentContainer.addView(paramView);
    }
  }
  
  public View getContentView()
  {
    FrameLayout localFrameLayout = this.mContentContainer;
    if (localFrameLayout != null) {
      return localFrameLayout.getChildAt(0);
    }
    return null;
  }
  
  protected void init()
  {
    LayoutInflater.from(this.mContext).inflate(2131559579, this, true);
    this.mRoot = ((ViewGroup)findViewById(2131376818));
    this.mTitleContainer = ((ViewGroup)findViewById(2131378823));
    this.mTitleIcon = ((ImageView)findViewById(2131378828));
    this.mTitleText = ((TextView)findViewById(2131378876));
    this.mTitleTextBg = ((ViewGroup)findViewById(2131378877));
    this.mTitleArrow = ((ImageView)findViewById(2131378801));
    this.mTitleExtContainer = ((RelativeLayout)findViewById(2131378827));
    this.mContentContainer = ((FrameLayout)findViewById(2131365179));
    setIconEnable(false);
  }
  
  public void removeContentViews()
  {
    FrameLayout localFrameLayout = this.mContentContainer;
    if (localFrameLayout != null) {
      localFrameLayout.removeAllViews();
    }
  }
  
  public void setArrowEnable(boolean paramBoolean)
  {
    ImageView localImageView = this.mTitleArrow;
    if (localImageView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    ImageView localImageView = this.mTitleIcon;
    if (localImageView != null) {
      localImageView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setIconEnable(boolean paramBoolean)
  {
    ImageView localImageView = this.mTitleIcon;
    if (localImageView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  public void setMarginBottomEnable(boolean paramBoolean)
  {
    if (this.mRoot != null)
    {
      int i = 0;
      if (paramBoolean) {
        i = getResources().getDimensionPixelSize(2131297592);
      }
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mRoot.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = i;
        this.mRoot.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void setTitle(String paramString)
  {
    TextView localTextView = this.mTitleText;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setTitleBackground(Drawable paramDrawable)
  {
    ViewGroup localViewGroup = this.mTitleContainer;
    if (localViewGroup != null) {
      localViewGroup.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void updateViewHeight(int paramInt)
  {
    Object localObject = this.mContentContainer;
    if (localObject == null) {
      return;
    }
    localObject = ((FrameLayout)localObject).getLayoutParams();
    if (localObject == null) {
      return;
    }
    ((ViewGroup.LayoutParams)localObject).height = (paramInt + this.mContentContainer.getPaddingTop() + this.mContentContainer.getPaddingBottom());
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView
 * JD-Core Version:    0.7.0.1
 */