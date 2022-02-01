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
  private boolean a = false;
  private ScannerResult b;
  private int c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private FrameLayout g;
  private ScannerMultiResultSelectView.MultiSelectListener h;
  private long i = 0L;
  private boolean j = false;
  private Bitmap k;
  private int l;
  private int m;
  private int n = 0;
  private ScannerMultiResultSelectView.ImageData o;
  private Runnable p = new ScannerMultiResultSelectView.3(this);
  
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
    int i2 = this.l;
    int i4 = this.m;
    int i1 = this.k.getWidth();
    int i3 = this.k.getHeight();
    if ((!paramRectF.isEmpty()) && (i3 > 0) && (i1 > 0))
    {
      float f1 = i1 * 1.0F / i3;
      float f2 = i2;
      float f3 = i4;
      int i5;
      if (f1 > 1.0F * f2 / f3)
      {
        i2 = i2 * i3 / i1;
        i3 = (int)(paramRectF.left * f2);
        i1 = (int)(paramRectF.right * f2);
        i5 = i4 / 2 - i2 / 2;
        f1 = paramRectF.top;
        f2 = i2;
        i4 = (int)(f1 * f2) + i5;
        i2 = (int)(paramRectF.bottom * f2) + i5;
        i5 = i1;
      }
      else
      {
        i3 = i4 * i1 / i3;
        i4 = (int)(paramRectF.top * f3);
        i1 = (int)(paramRectF.bottom * f3);
        i2 = i2 / 2 - i3 / 2;
        f1 = paramRectF.left;
        f2 = i3;
        i3 = (int)(f1 * f2);
        i5 = (int)(paramRectF.right * f2) + i2;
        i3 += i2;
        i2 = i1;
      }
      return new Rect(i3, i4, i5, i2);
    }
    return new Rect(0, 0, i2, i4);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(2131626490, this, true);
    this.d = ((ImageView)((View)localObject).findViewById(2131435357));
    this.e = ((TextView)((View)localObject).findViewById(2131430272));
    this.f = ((TextView)((View)localObject).findViewById(2131447403));
    this.g = ((FrameLayout)((View)localObject).findViewById(2131440487));
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    setBackgroundColor(-16777216);
    paramRelativeLayout.addView(this, (ViewGroup.LayoutParams)localObject);
    this.e.setOnClickListener(this);
    this.a = true;
    if (LiuHaiUtils.b()) {
      ((RelativeLayout.LayoutParams)this.f.getLayoutParams()).topMargin = ViewUtils.dip2px(60.0F);
    }
  }
  
  private void c()
  {
    this.g.removeAllViews();
    Object localObject1 = this.k;
    if (localObject1 == null)
    {
      d();
      return;
    }
    this.d.setImageBitmap((Bitmap)localObject1);
    Object localObject2;
    int i1;
    if (((this.c & 0x1) != 0) && (this.b.h()))
    {
      localObject1 = this.b.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QBarResult)((Iterator)localObject1).next();
        f().setTag(localObject2);
      }
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    int i2 = i1;
    if ((this.c & 0x2) != 0)
    {
      i2 = i1;
      if (this.b.g())
      {
        localObject1 = this.b.b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (QMiniResult)((Iterator)localObject1).next();
          f().setTag(localObject2);
        }
        i2 = i1 | 0x2;
      }
    }
    if (i2 == 1) {
      this.f.setText(2131914097);
    } else if (i2 == 2) {
      this.f.setText(2131914096);
    } else {
      this.f.setText(2131914095);
    }
    if ((this.l > 0) && (this.m > 0)) {
      this.p.run();
    }
  }
  
  private void d()
  {
    ScannerMultiResultSelectView.ImageData localImageData = this.o;
    if (localImageData == null) {
      return;
    }
    ThreadManagerV2.excute(new ScannerMultiResultSelectView.1(this, localImageData), 16, null, true);
  }
  
  private void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAfterDecodeBitmap mShowing：");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" mBitmap:");
      localStringBuilder.append(this.k);
      localStringBuilder.append(" mScannerResult:");
      localStringBuilder.append(this.b);
      QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, localStringBuilder.toString());
    }
    if (!this.j) {
      return;
    }
    ThreadManager.getUIHandler().post(new ScannerMultiResultSelectView.2(this));
  }
  
  private View f()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = new DiniFlyAnimationView(getContext());
    localDiniFlyAnimationView.setImageAssetsFolder("qr_scan_multi_point/images");
    localDiniFlyAnimationView.setAnimation("qr_scan_multi_point/data.json");
    localDiniFlyAnimationView.setRepeatCount(-1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.dip2px(54.0F), ViewUtils.dip2px(54.0F));
    this.g.addView(localDiniFlyAnimationView, localLayoutParams);
    localDiniFlyAnimationView.setOnClickListener(this);
    localDiniFlyAnimationView.setVisibility(8);
    return localDiniFlyAnimationView;
  }
  
  private void setAnimState(boolean paramBoolean)
  {
    int i2 = this.g.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = this.g.getChildAt(i1);
      if ((localObject instanceof DiniFlyAnimationView))
      {
        localObject = (DiniFlyAnimationView)localObject;
        if ((paramBoolean) && (!((DiniFlyAnimationView)localObject).isAnimating())) {
          ((DiniFlyAnimationView)localObject).playAnimation();
        } else if ((!paramBoolean) && (((DiniFlyAnimationView)localObject).isAnimating())) {
          ((DiniFlyAnimationView)localObject).cancelAnimation();
        }
      }
      i1 += 1;
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
    this.b = paramScannerResult;
    this.c = paramInt1;
    this.o = paramImageData;
    if (!this.a) {
      a(paramRelativeLayout);
    }
    c();
    setVisibility(0);
    this.j = true;
    this.n = paramInt2;
    ReportController.b(null, "dc00898", "", "", "0X800B5E1", "0X800B5E1", this.n, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return this.j;
  }
  
  public void b()
  {
    if (!this.j) {
      return;
    }
    setAnimState(false);
    setVisibility(8);
    this.j = false;
    this.d.setImageBitmap(null);
    Object localObject = this.k;
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    removeCallbacks(this.p);
    this.k = null;
    localObject = this.h;
    if (localObject != null) {
      ((ScannerMultiResultSelectView.MultiSelectListener)localObject).a();
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.h != null) && (System.currentTimeMillis() - this.i >= 1000L))
    {
      this.i = System.currentTimeMillis();
      if (paramView.getId() == 2131430272)
      {
        b();
        this.h.a();
        ReportController.b(null, "dc00898", "", "", "0X800B5E3", "0X800B5E3", this.n, 0, "", "", "", "");
      }
      else
      {
        Object localObject = paramView.getTag();
        if ((localObject != null) && ((localObject instanceof QBarResult)))
        {
          this.h.a((QBarResult)localObject, this.c, this.o);
          setAnimState(false);
          ReportController.b(null, "dc00898", "", "", "0X800B5E2", "0X800B5E2", this.n, 0, "", "", "", "");
        }
        else if ((localObject != null) && ((localObject instanceof QMiniResult)))
        {
          this.h.a((QMiniResult)localObject, this.c, this.o);
          setAnimState(false);
          ReportController.b(null, "dc00898", "", "", "0X800B5E2", "0X800B5E2", this.n, 0, "", "", "", "");
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
    if ((paramInt1 > 0) && (paramInt2 > 0) && ((paramInt1 != this.l) || (paramInt2 != this.m)))
    {
      this.l = paramInt1;
      this.m = paramInt2;
      removeCallbacks(this.p);
      post(this.p);
    }
  }
  
  public void setMultiSelectListener(ScannerMultiResultSelectView.MultiSelectListener paramMultiSelectListener)
  {
    this.h = paramMultiSelectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView
 * JD-Core Version:    0.7.0.1
 */