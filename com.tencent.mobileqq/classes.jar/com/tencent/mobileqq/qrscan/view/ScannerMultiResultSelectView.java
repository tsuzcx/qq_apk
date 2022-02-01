package com.tencent.mobileqq.qrscan.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.QMiniResult;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class ScannerMultiResultSelectView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ScannerResult jdField_a_of_type_ComTencentMobileqqQrscanScannerResult;
  private ScannerMultiResultSelectView.ImageData jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$ImageData;
  private ScannerMultiResultSelectView.MultiSelectListener jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$MultiSelectListener;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ScannerMultiResultSelectView.3(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  private int d = 0;
  
  public ScannerMultiResultSelectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScannerMultiResultSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScannerMultiResultSelectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Rect a(RectF paramRectF)
  {
    int j = this.jdField_b_of_type_Int;
    int m = this.c;
    int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    int k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    if ((!paramRectF.isEmpty()) && (k > 0) && (i > 0))
    {
      float f1 = i * 1.0F / k;
      float f2 = j;
      float f3 = m;
      int n;
      if (f1 > 1.0F * f2 / f3)
      {
        j = j * k / i;
        k = (int)(paramRectF.left * f2);
        i = (int)(paramRectF.right * f2);
        n = m / 2 - j / 2;
        f1 = paramRectF.top;
        f2 = j;
        m = (int)(f1 * f2) + n;
        j = (int)(paramRectF.bottom * f2) + n;
        n = i;
      }
      else
      {
        k = m * i / k;
        m = (int)(paramRectF.top * f3);
        i = (int)(paramRectF.bottom * f3);
        j = j / 2 - k / 2;
        f1 = paramRectF.left;
        f2 = k;
        k = (int)(f1 * f2);
        n = (int)(paramRectF.right * f2) + j;
        k += j;
        j = i;
      }
      return new Rect(k, m, n, j);
    }
    return new Rect(0, 0, j, m);
  }
  
  private View a()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = new DiniFlyAnimationView(getContext());
    localDiniFlyAnimationView.setImageAssetsFolder("qr_scan_multi_point/images");
    localDiniFlyAnimationView.setAnimation("qr_scan_multi_point/data.json");
    localDiniFlyAnimationView.setRepeatCount(-1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.a(54.0F), ViewUtils.a(54.0F));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localDiniFlyAnimationView, localLayoutParams);
    localDiniFlyAnimationView.setOnClickListener(this);
    localDiniFlyAnimationView.setVisibility(8);
    return localDiniFlyAnimationView;
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(2131560445, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368461));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364259));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378732));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((View)localObject).findViewById(2131372924));
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    setBackgroundColor(-16777216);
    paramRelativeLayout.addView(this, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_Boolean = true;
    if (LiuHaiUtils.b()) {
      ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = ViewUtils.a(60.0F);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildAt(i);
      if ((localObject instanceof DiniFlyAnimationView))
      {
        localObject = (DiniFlyAnimationView)localObject;
        if ((paramBoolean) && (!((DiniFlyAnimationView)localObject).isAnimating())) {
          ((DiniFlyAnimationView)localObject).playAnimation();
        } else if ((!paramBoolean) && (((DiniFlyAnimationView)localObject).isAnimating())) {
          ((DiniFlyAnimationView)localObject).cancelAnimation();
        }
      }
      i += 1;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject1 == null)
    {
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
    Object localObject2;
    int i;
    if (((this.jdField_a_of_type_Int & 0x1) != 0) && (this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult.d()))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QBarResult)((Iterator)localObject1).next();
        a().setTag(localObject2);
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = i;
    if ((this.jdField_a_of_type_Int & 0x2) != 0)
    {
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult.c())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult.b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (QMiniResult)((Iterator)localObject1).next();
          a().setTag(localObject2);
        }
        j = i | 0x2;
      }
    }
    if (j == 1) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131716634);
    } else if (j == 2) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131716633);
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131716632);
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.c > 0)) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  private void c()
  {
    ScannerMultiResultSelectView.ImageData localImageData = this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$ImageData;
    if (localImageData == null) {
      return;
    }
    ThreadManagerV2.excute(new ScannerMultiResultSelectView.1(this, localImageData), 16, null, true);
  }
  
  private void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAfterDecodeBitmap mShowing：");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(" mBitmap:");
      localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsBitmap);
      localStringBuilder.append(" mScannerResult:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult);
      QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, localStringBuilder.toString());
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    ThreadManager.getUIHandler().post(new ScannerMultiResultSelectView.2(this));
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    a(false);
    setVisibility(8);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$MultiSelectListener;
    if (localObject != null) {
      ((ScannerMultiResultSelectView.MultiSelectListener)localObject).a();
    }
  }
  
  public void a(RelativeLayout paramRelativeLayout, ScannerResult paramScannerResult, int paramInt1, ScannerMultiResultSelectView.ImageData paramImageData, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show requestType：");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" scannerResult:");
      localStringBuilder.append(paramScannerResult);
      localStringBuilder.append(" data:");
      localStringBuilder.append(paramImageData);
      QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult = paramScannerResult;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$ImageData = paramImageData;
    if (!this.jdField_a_of_type_Boolean) {
      a(paramRelativeLayout);
    }
    b();
    setVisibility(0);
    this.jdField_b_of_type_Boolean = true;
    this.d = paramInt2;
    ReportController.b(null, "dc00898", "", "", "0X800B5E1", "0X800B5E1", this.d, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$MultiSelectListener != null) && (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 1000L))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (paramView.getId() == 2131364259)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$MultiSelectListener.a();
        ReportController.b(null, "dc00898", "", "", "0X800B5E3", "0X800B5E3", this.d, 0, "", "", "", "");
      }
      else
      {
        Object localObject = paramView.getTag();
        if ((localObject != null) && ((localObject instanceof QBarResult)))
        {
          this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$MultiSelectListener.a((QBarResult)localObject, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$ImageData);
          a(false);
          ReportController.b(null, "dc00898", "", "", "0X800B5E2", "0X800B5E2", this.d, 0, "", "", "", "");
        }
        else if ((localObject != null) && ((localObject instanceof QMiniResult)))
        {
          this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$MultiSelectListener.a((QMiniResult)localObject, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$ImageData);
          a(false);
          ReportController.b(null, "dc00898", "", "", "0X800B5E2", "0X800B5E2", this.d, 0, "", "", "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if ((paramInt1 > 0) && (paramInt2 > 0) && ((paramInt1 != this.jdField_b_of_type_Int) || (paramInt2 != this.c)))
    {
      this.jdField_b_of_type_Int = paramInt1;
      this.c = paramInt2;
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void setMultiSelectListener(ScannerMultiResultSelectView.MultiSelectListener paramMultiSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$MultiSelectListener = paramMultiSelectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView
 * JD-Core Version:    0.7.0.1
 */