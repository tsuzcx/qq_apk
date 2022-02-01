package com.tencent.mobileqq.profilecard.bussiness.favor.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.MobileQQ;

public class ProfileCardFavorItemDetailView
  extends LinearLayout
{
  public static final int ADD_LABEL_TO_ROW1_LEFT = 1;
  public static final int ADD_LABEL_TO_ROW1_RIGHT = 2;
  public static final int ADD_LABEL_TO_ROW2_LEFT = 3;
  public static final int ADD_LABEL_TO_ROW2_RIGHT = 4;
  public static final int ADD_LABEL_TO_ROW3_LEFT = 5;
  public static final int ADD_LABEL_TO_ROW3_RIGHT = 6;
  private static final String TAG = "NEW_CARD_FAVOR";
  private Context ctx;
  private View mContentView;
  private ImageView mFavorIcon;
  public TextView row1Content;
  LinearLayout row1Left;
  LinearLayout row1Right;
  public TextView row2Content;
  LinearLayout row2Left;
  LinearLayout row2Right;
  public TextView row3Content;
  LinearLayout row3Left;
  LinearLayout row3Right;
  
  public ProfileCardFavorItemDetailView(Context paramContext)
  {
    super(paramContext);
    this.ctx = paramContext;
    init();
  }
  
  public ProfileCardFavorItemDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ctx = paramContext;
    init();
  }
  
  private void init()
  {
    this.mContentView = LayoutInflater.from(this.ctx).inflate(2131625520, this, true);
    this.mFavorIcon = ((ImageView)this.mContentView.findViewById(2131432811));
    if (ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime())) {
      this.mFavorIcon.setColorFilter(1996488704);
    }
    this.row1Left = ((LinearLayout)this.mContentView.findViewById(2131431282));
    this.row1Right = ((LinearLayout)this.mContentView.findViewById(2131431283));
    this.row2Left = ((LinearLayout)this.mContentView.findViewById(2131431285));
    this.row2Right = ((LinearLayout)this.mContentView.findViewById(2131431286));
    this.row3Left = ((LinearLayout)this.mContentView.findViewById(2131431288));
    this.row3Right = ((LinearLayout)this.mContentView.findViewById(2131431289));
    this.row1Content = ((TextView)this.mContentView.findViewById(2131450231));
    this.row2Content = ((TextView)this.mContentView.findViewById(2131450232));
    this.row3Content = ((TextView)this.mContentView.findViewById(2131450233));
  }
  
  public void addLabel(Drawable paramDrawable, String paramString, int paramInt1, int paramInt2)
  {
    paramDrawable = new ProfileCardFavorItemDetailView.Label(this, this.ctx, paramDrawable, paramString, paramInt1);
    paramString = new LinearLayout.LayoutParams(-2, Utils.a(15.0F, getResources()));
    paramString.leftMargin = Utils.a(4.0F, getResources());
    paramDrawable.setLayoutParams(paramString);
    switch (paramInt2)
    {
    default: 
      return;
    case 6: 
      this.row3Right.addView(paramDrawable);
      return;
    case 5: 
      this.row3Left.addView(paramDrawable);
      return;
    case 4: 
      this.row2Right.addView(paramDrawable);
      return;
    case 3: 
      this.row2Left.addView(paramDrawable);
      return;
    case 2: 
      this.row1Right.addView(paramDrawable);
      return;
    }
    this.row1Left.addView(paramDrawable);
  }
  
  public void addLabel(String paramString, int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(16777215);
    URLImageView localURLImageView = new URLImageView(this.ctx);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
    localURLDrawableOptions.mFailedDrawable = localColorDrawable;
    localURLDrawableOptions.mRequestHeight = Utils.a(15.0F, getResources());
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramString.getStatus() == 2) {
      localURLImageView.setVisibility(8);
    }
    localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localURLImageView.setImageDrawable(paramString);
    localURLImageView.setMaxHeight(Utils.a(15.0F, getResources()));
    localURLImageView.setAdjustViewBounds(true);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.leftMargin = Utils.a(4.0F, getResources());
    localURLImageView.setLayoutParams(paramString);
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      this.row3Right.addView(localURLImageView);
      return;
    case 5: 
      this.row3Left.addView(localURLImageView);
      return;
    case 4: 
      this.row2Right.addView(localURLImageView);
      return;
    case 3: 
      this.row2Left.addView(localURLImageView);
      return;
    case 2: 
      this.row1Right.addView(localURLImageView);
      return;
    }
    this.row1Left.addView(localURLImageView);
  }
  
  public void setContent(String paramString)
  {
    this.row2Content.setText(paramString);
  }
  
  public void setDesc(String paramString)
  {
    this.row3Content.setText(paramString);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mFavorIcon.setImageDrawable(paramDrawable);
  }
  
  public void setNeedTopMargin(boolean paramBoolean)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
    if (localLayoutParams != null)
    {
      int i;
      if (paramBoolean) {
        i = Utils.a(14.0F, getResources());
      } else {
        i = 0;
      }
      localLayoutParams.topMargin = i;
      this.mContentView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setTitle(String paramString)
  {
    this.row1Content.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.favor.view.ProfileCardFavorItemDetailView
 * JD-Core Version:    0.7.0.1
 */