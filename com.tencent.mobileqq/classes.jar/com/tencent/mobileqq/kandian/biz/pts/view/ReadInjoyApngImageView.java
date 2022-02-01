package com.tencent.mobileqq.kandian.biz.pts.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.Date;

public class ReadInjoyApngImageView
  extends ImageBase
{
  private static final Drawable a;
  protected NativeReadInjoyImageView a;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
  }
  
  public ReadInjoyApngImageView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView = new NativeReadInjoyImageView(paramVafContext.getContext());
  }
  
  private static long a(Date paramDate1, Date paramDate2)
  {
    return Math.abs((paramDate1.getTime() - paramDate2.getTime()) / 86400000L);
  }
  
  private void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new ReadInjoyApngImageView.1(this, paramString), 1500L);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  }
  
  public void loadImage(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http")) && (!DateUtils.isToday(SharedPreUtils.b("search_word_prefix_ug_weishi_opt_day_show_time"))))
    {
      SharedPreUtils.a("search_word_prefix_ug_weishi_opt_day_show_time", System.currentTimeMillis());
      if (a(new Date(System.currentTimeMillis()), new Date(SharedPreUtils.b("search_word_prefix_ug_weishi_opt_week_first_show_time"))) > 7L)
      {
        SharedPreUtils.a("search_word_prefix_ug_weishi_opt_week_first_show_time", System.currentTimeMillis());
        SharedPreUtils.a("search_word_prefix_ug_weishi_opt_week_first_show_count", 1);
        a(paramString);
        return;
      }
      if (SharedPreUtils.a("search_word_prefix_ug_weishi_opt_week_first_show_count") < 3)
      {
        SharedPreUtils.a("search_word_prefix_ug_weishi_opt_week_first_show_count", SharedPreUtils.a("search_word_prefix_ug_weishi_opt_week_first_show_count") + 1);
        a(paramString);
      }
    }
  }
  
  protected void onComDraw(Canvas paramCanvas)
  {
    super.onComDraw(paramCanvas);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(this.mScaleType, ImageView.ScaleType.CENTER_CROP));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    loadImage(this.mSrc);
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageSrc(null);
    this.mSrc = null;
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyApngImageView
 * JD-Core Version:    0.7.0.1
 */