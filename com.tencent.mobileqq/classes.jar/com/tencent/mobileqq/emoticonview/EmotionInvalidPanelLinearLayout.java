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
    if (this.emotionPkg.jobType == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.isSmallEmotion = bool;
      this.rowNum = paramInt1;
      this.columnNum = paramInt2;
      new DisplayMetrics();
      this.widthPixels = paramContext.getResources().getDisplayMetrics().widthPixels;
      super.setOrientation(1);
      init();
      return;
    }
  }
  
  public void init()
  {
    long l = System.currentTimeMillis();
    super.removeAllViews();
    int i = 0;
    while (i < this.rowNum)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.context);
      int j = (int)(72.0F * this.mDensity);
      if (this.isSmallEmotion) {
        j = (this.widthPixels - (int)(18.0F * this.mDensity) * 8) / 7;
      }
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, j);
      localLinearLayout.setOrientation(0);
      label107:
      Object localObject1;
      Object localObject3;
      if (this.isSmallEmotion)
      {
        localLayoutParams.topMargin = ((int)(18.0F * this.mDensity));
        j = 0;
        if (j >= this.columnNum) {
          break label629;
        }
        if (!this.isSmallEmotion) {
          break label276;
        }
        localObject1 = new URLImageView(this.context);
        ((URLImageView)localObject1).setId(2131365977);
        int k = (this.widthPixels - (int)(18.0F * this.mDensity) * 8) / 7;
        localObject3 = new LinearLayout.LayoutParams(k, k);
        ((LinearLayout.LayoutParams)localObject3).leftMargin = ((int)(18.0F * this.mDensity));
        ((URLImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((URLImageView)localObject1).setVisibility(8);
        ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
        ((URLImageView)localObject1).setAdjustViewBounds(false);
        ((URLImageView)localObject1).setFocusable(true);
        ((URLImageView)localObject1).setFocusableInTouchMode(true);
        localLinearLayout.addView((View)localObject1);
      }
      for (;;)
      {
        j += 1;
        break label107;
        if (i == 0)
        {
          localLayoutParams.topMargin = ((int)(16.0F * this.mDensity));
          break;
        }
        localLayoutParams.topMargin = ((int)(14.0F * this.mDensity));
        break;
        label276:
        localObject3 = new RelativeLayout(this.context);
        localObject1 = new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int)(72.0F * this.mDensity));
        ((RelativeLayout)localObject3).setFocusable(true);
        ((RelativeLayout)localObject3).setFocusableInTouchMode(true);
        ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        try
        {
          localObject1 = new TextView(this.context);
          if (localObject1 != null)
          {
            ((TextView)localObject1).setVisibility(8);
            ((TextView)localObject1).setId(2131365982);
            ((TextView)localObject1).setTextSize(11.0F);
            localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams1.addRule(12);
            localLayoutParams1.addRule(14);
            localLayoutParams1.topMargin = ((int)(5.0F * this.mDensity));
            ((RelativeLayout)localObject3).addView((View)localObject1, localLayoutParams1);
          }
          localObject1 = new URLImageView(this.context);
          ((URLImageView)localObject1).setId(2131365977);
          RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams((int)(56.0F * this.mDensity), (int)(56.0F * this.mDensity));
          localLayoutParams1.addRule(13, -1);
          localLayoutParams1.addRule(2, 2131365982);
          localLayoutParams1.addRule(14);
          ((URLImageView)localObject1).setVisibility(8);
          ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
          ((URLImageView)localObject1).setAdjustViewBounds(false);
          ((RelativeLayout)localObject3).addView((View)localObject1, localLayoutParams1);
          localObject1 = new ImageView(this.context);
          ((ImageView)localObject1).setVisibility(8);
          ((ImageView)localObject1).setId(2131365983);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(7, 2131365977);
          localLayoutParams1.addRule(8, 2131365977);
          ((RelativeLayout)localObject3).addView((View)localObject1, localLayoutParams1);
          if (AppSetting.c) {
            ((RelativeLayout)localObject3).setFocusable(true);
          }
          if (AppSetting.c) {
            ((RelativeLayout)localObject3).setFocusable(true);
          }
          localLinearLayout.addView((View)localObject3);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
      label629:
      super.addView(localLinearLayout, localLayoutParams);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassicEmoticonPanelView", 2, "[Performance] EmoticonLinearLayout create duration: " + (System.currentTimeMillis() - l) + "issmallemotion = " + this.isSmallEmotion);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionInvalidPanelLinearLayout
 * JD-Core Version:    0.7.0.1
 */