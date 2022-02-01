package com.tencent.tavcut.timeline;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.tavcut.util.Util;

public class CoverSelectView$UIConfigWrapper
{
  private static final int DYNAMIC_VALUE = -1;
  Context context;
  private float coverDefaultProgress;
  private int defaultImgRes;
  private int durationBg;
  private int gradientMaskRes;
  private ImageView ivPreviewBar;
  private int lockLeft;
  private int lockRight;
  private int previbarHeight = -1;
  private int previewBarWidth;
  private int rangeLeft;
  private int rangeRight;
  private int showItemCount;
  private int timelineMaskRes;
  
  public CoverSelectView$UIConfigWrapper(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.context = paramContext;
    this.defaultImgRes = paramInt1;
    this.gradientMaskRes = paramInt2;
    this.timelineMaskRes = paramInt3;
    this.lockLeft = paramInt4;
    this.lockRight = paramInt5;
    this.rangeLeft = paramInt6;
    this.rangeRight = paramInt7;
    this.durationBg = paramInt8;
    this.showItemCount = paramInt9;
    this.previewBarWidth = ((int)Util.dp2px(paramContext, 40.0F));
    this.coverDefaultProgress = 0.5F;
  }
  
  public UIConfigWrapper setCoverDefaultProgress(float paramFloat)
  {
    this.coverDefaultProgress = paramFloat;
    return this;
  }
  
  public UIConfigWrapper setPrevibarHeight(int paramInt)
  {
    this.previbarHeight = paramInt;
    return this;
  }
  
  public UIConfigWrapper setPreviewBar(ImageView paramImageView)
  {
    this.ivPreviewBar = paramImageView;
    return this;
  }
  
  public UIConfigWrapper setPreviewBarWidth(int paramInt)
  {
    this.previewBarWidth = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.timeline.CoverSelectView.UIConfigWrapper
 * JD-Core Version:    0.7.0.1
 */