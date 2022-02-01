package com.tencent.mobileqq.kandian.biz.pts.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CornerTextImageView
  extends ImageBase
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
  
  public CornerTextImageView(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext.getContext());
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = new KandianUrlImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramContext);
    paramContext = new FrameLayout.LayoutParams(Utils.dp2px(30.0D), Utils.dp2px(18.0D));
    paramContext.gravity = 85;
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#80000000"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
  }
  
  public void a()
  {
    Resources localResources = this.mContext.getContext().getResources();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.a != null))
    {
      float f3 = localResources.getDisplayMetrics().widthPixels - AIOUtils.b(24.0F, localResources);
      int j = (int)(f3 * 0.598F);
      float f1 = localResources.getDisplayMetrics().density;
      int i;
      float f2;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.a.a.size() > 0)
      {
        i = ((UGCPicInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.a.a.get(0)).a;
        int k = ((UGCPicInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.a.a.get(0)).b;
        f2 = AIOUtils.b(i / 2, localResources);
        f1 = AIOUtils.b(k / 2, localResources);
        i = ((UGCPicInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.a.a.get(0)).c;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("CornerTextImageView", 2, "ugc pic info is null");
        }
        f2 = 115.0F * f1;
        f1 = 1037.0F * f1;
        i = 0;
      }
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
      if ((f2 < f3) && (f1 < j))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        float f4;
        if (f2 < f3)
        {
          f4 = j;
          if (f1 > f4)
          {
            if (f1 / f2 > 4.0F)
            {
              f2 = AIOUtils.b(150.0F, localResources);
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718071);
            }
            else
            {
              f2 = f4 / f1 * f2;
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            }
            f1 = f4;
            break label610;
          }
        }
        if ((f2 > f3) && (f1 < j))
        {
          if (f2 / f1 > 4.0F)
          {
            f1 = AIOUtils.b(150.0F, localResources);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718072);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            f2 = f3;
          }
          else
          {
            f1 *= f3 / f2;
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            f2 = f3;
          }
        }
        else if (f1 / f2 > 4.0F)
        {
          f1 = j;
          f2 = AIOUtils.b(150.0F, localResources);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718071);
        }
        else if (f2 / f1 > 4.0F)
        {
          f1 = AIOUtils.b(150.0F, localResources);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718072);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          f2 = f3;
        }
        else
        {
          f4 = j;
          if ((f1 - f4) / (f2 - f3) < 0.598F)
          {
            f1 *= f3 / f2;
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            f2 = f3;
          }
          else
          {
            f2 = f4 / f1 * f2;
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            f1 = f4;
          }
        }
      }
      label610:
      if (i == 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718070);
      }
      localLayoutParams.width = ((int)f2);
      localLayoutParams.height = ((int)f1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setPadding(0, 0, 0, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CornerTextImageView", 2, "info is null");
    }
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramIReadInJoyModel);
    a();
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void loadImage(String paramString)
  {
    super.loadImage(paramString);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImagePlaceHolder(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(new URL(paramString));
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    loadImage(this.mSrc);
    refresh();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    super.setAttribute(paramInt, paramObject);
    if (paramInt != 1009) {
      return false;
    }
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
    return true;
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.CornerTextImageView
 * JD-Core Version:    0.7.0.1
 */