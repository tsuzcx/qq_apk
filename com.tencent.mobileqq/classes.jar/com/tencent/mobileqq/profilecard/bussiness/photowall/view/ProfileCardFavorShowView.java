package com.tencent.mobileqq.profilecard.bussiness.photowall.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

@Deprecated
public class ProfileCardFavorShowView
  extends FrameLayout
{
  public ImageView mArrowImage;
  public LinearLayout mContentContainer;
  protected Context mContext;
  public ViewGroup mGuideTipsContainer;
  public ViewGroup mRoot;
  private int mTemplateLayout = -1;
  public ViewGroup mTitleBar;
  public TextView mTitleText;
  
  public ProfileCardFavorShowView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileCardFavorShowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public ProfileCardFavorShowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.mTemplateLayout = paramInt;
    init();
  }
  
  public void addView(View paramView)
  {
    this.mContentContainer.addView(paramView);
  }
  
  public int getChildCountInContainer()
  {
    return this.mContentContainer.getChildCount();
  }
  
  public LinearLayout getContainer()
  {
    return this.mContentContainer;
  }
  
  protected int getLayout()
  {
    int i = this.mTemplateLayout;
    if (i > 0) {
      return i;
    }
    return 2131559500;
  }
  
  public View getViewInContainer(int paramInt)
  {
    return this.mContentContainer.getChildAt(paramInt);
  }
  
  protected void init()
  {
    LayoutInflater.from(this.mContext).inflate(getLayout(), this, true);
    this.mRoot = ((LinearLayout)findViewById(2131376818));
    this.mTitleBar = ((ViewGroup)findViewById(2131365027));
    this.mTitleText = ((TextView)findViewById(2131378609));
    this.mArrowImage = ((ImageView)findViewById(2131368501));
    this.mContentContainer = ((LinearLayout)findViewById(2131373110));
    this.mGuideTipsContainer = ((RelativeLayout)findViewById(2131367927));
    this.mTitleText.setTextColor(getResources().getColorStateList(2131167056));
    this.mArrowImage.setImageResource(2130839270);
  }
  
  public void removeAllViews()
  {
    this.mContentContainer.removeAllViews();
  }
  
  public void removeView(View paramView)
  {
    if (this.mContentContainer.indexOfChild(paramView) >= 0) {
      this.mContentContainer.removeView(paramView);
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
  
  public void setShowArrow(boolean paramBoolean)
  {
    ImageView localImageView = this.mArrowImage;
    if (localImageView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 4;
      }
      localImageView.setVisibility(i);
    }
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.mTitleBar;
    if (localViewGroup != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localViewGroup.setVisibility(i);
    }
  }
  
  public void setTitle(String paramString)
  {
    TextView localTextView = this.mTitleText;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void updateViewHeight(int paramInt)
  {
    ((LinearLayout.LayoutParams)this.mContentContainer.getLayoutParams()).height = (paramInt + this.mContentContainer.getPaddingTop() + this.mContentContainer.getPaddingBottom());
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView
 * JD-Core Version:    0.7.0.1
 */