package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class EmotionInvalidPanelLinearLayout
  extends LinearLayout
{
  public static final int BIG_EMOTION_ROWNUM = 3;
  public static final String LOG_TAG = "ClassicEmoticonPanelView";
  public static final int SMALL_EMOTION_ROWNUM = 4;
  private int columnNum;
  private Context context;
  private EmoticonPackage emotionPkg;
  private boolean isSmallEmotion;
  private float mDensity;
  private int rowNum;
  protected int widthPixels;
  
  public EmotionInvalidPanelLinearLayout(Context paramContext, EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.context = paramContext;
    this.emotionPkg = paramEmoticonPackage;
    this.mDensity = super.getContext().getResources().getDisplayMetrics().density;
    boolean bool;
    if (this.emotionPkg.jobType == 4) {
      bool = true;
    } else {
      bool = false;
    }
    this.isSmallEmotion = bool;
    this.rowNum = paramInt1;
    this.columnNum = paramInt2;
    new DisplayMetrics();
    this.widthPixels = paramContext.getResources().getDisplayMetrics().widthPixels;
    super.setOrientation(1);
    init();
  }
  
  public void init()
  {
    long l = System.currentTimeMillis();
    super.removeAllViews();
    int i = 0;
    Object localObject1;
    while (i < this.rowNum)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.context);
      float f = this.mDensity;
      int j = (int)(f * 72.0F);
      if (this.isSmallEmotion) {
        j = (this.widthPixels - (int)(f * 18.0F) * 8) / 7;
      }
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, j);
      localLinearLayout.setOrientation(0);
      if (this.isSmallEmotion) {
        localLayoutParams.topMargin = ((int)(this.mDensity * 18.0F));
      } else if (i == 0) {
        localLayoutParams.topMargin = ((int)(this.mDensity * 16.0F));
      } else {
        localLayoutParams.topMargin = ((int)(this.mDensity * 14.0F));
      }
      j = 0;
      while (j < this.columnNum)
      {
        RelativeLayout localRelativeLayout;
        if (this.isSmallEmotion)
        {
          localObject1 = new URLImageView(this.context);
          ((URLImageView)localObject1).setId(2131378202);
          int k = (this.widthPixels - (int)(this.mDensity * 18.0F) * 8) / 7;
          localObject2 = new LinearLayout.LayoutParams(k, k);
          ((LinearLayout.LayoutParams)localObject2).leftMargin = ((int)(this.mDensity * 18.0F));
          ((URLImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((URLImageView)localObject1).setVisibility(8);
          ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
          ((URLImageView)localObject1).setAdjustViewBounds(false);
          ((URLImageView)localObject1).setFocusable(true);
          ((URLImageView)localObject1).setFocusableInTouchMode(true);
          localLinearLayout.addView((View)localObject1);
        }
        else
        {
          localRelativeLayout = new RelativeLayout(this.context);
          localObject1 = new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int)(this.mDensity * 72.0F));
          localRelativeLayout.setFocusable(true);
          localRelativeLayout.setFocusableInTouchMode(true);
          localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = null;
        }
        try
        {
          localObject2 = new TextView(this.context);
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          label352:
          break label352;
        }
        if (localObject1 != null)
        {
          ((TextView)localObject1).setVisibility(8);
          ((TextView)localObject1).setId(2131374392);
          ((TextView)localObject1).setTextSize(11.0F);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(this.mDensity * 5.0F));
          localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        localObject1 = new URLImageView(this.context);
        ((URLImageView)localObject1).setId(2131378202);
        f = this.mDensity;
        Object localObject2 = new RelativeLayout.LayoutParams((int)(f * 56.0F), (int)(f * 56.0F));
        ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131374392);
        ((RelativeLayout.LayoutParams)localObject2).addRule(14);
        ((URLImageView)localObject1).setVisibility(8);
        ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
        ((URLImageView)localObject1).setAdjustViewBounds(false);
        localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject1 = new ImageView(this.context);
        ((ImageView)localObject1).setVisibility(8);
        ((ImageView)localObject1).setId(2131374393);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131378202);
        ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131378202);
        localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        if (AppSetting.d) {
          localRelativeLayout.setFocusable(true);
        }
        if (AppSetting.d) {
          localRelativeLayout.setFocusable(true);
        }
        localLinearLayout.addView(localRelativeLayout);
        j += 1;
      }
      super.addView(localLinearLayout, localLayoutParams);
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[Performance] EmoticonLinearLayout create duration: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject1).append("issmallemotion = ");
      ((StringBuilder)localObject1).append(this.isSmallEmotion);
      QLog.d("ClassicEmoticonPanelView", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionInvalidPanelLinearLayout
 * JD-Core Version:    0.7.0.1
 */