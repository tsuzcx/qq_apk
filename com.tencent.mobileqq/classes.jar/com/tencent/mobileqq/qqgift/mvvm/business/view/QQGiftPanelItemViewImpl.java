package com.tencent.mobileqq.qqgift.mvvm.business.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelViewModel;
import com.tencent.mobileqq.qqgift.utils.QQGiftImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;

public class QQGiftPanelItemViewImpl
  extends FrameLayout
  implements IQQGiftPanelItemView
{
  public Drawable a;
  private ImageView b;
  private ImageView c;
  private RoundImageView d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private RelativeLayout j;
  private RelativeLayout k;
  private boolean l;
  private QQGiftPanelViewModel m;
  private RelativeLayout n;
  
  public QQGiftPanelItemViewImpl(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQGiftPanelItemViewImpl(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QQGiftPanelItemViewImpl(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131627981, this);
    this.n = ((RelativeLayout)findViewById(2131445016));
    this.b = ((ImageView)findViewById(2131436394));
    this.c = ((ImageView)findViewById(2131436395));
    this.d = ((RoundImageView)findViewById(2131436393));
    this.d.setmRadius(ViewUtils.dip2px(8.0F), true);
    this.e = ((TextView)findViewById(2131448494));
    this.f = ((TextView)findViewById(2131448495));
    this.g = ((ImageView)findViewById(2131436396));
    this.h = ((TextView)findViewById(2131448492));
    this.i = ((TextView)findViewById(2131448493));
    this.k = ((RelativeLayout)findViewById(2131444974));
    this.j = ((RelativeLayout)findViewById(2131444975));
    this.a = QQGiftImageUtil.a(getContext());
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (!this.l)
    {
      this.b.setImageDrawable(paramDrawable1);
      return;
    }
    this.c.setImageDrawable(paramDrawable1);
    this.d.setImageDrawable(paramDrawable2);
  }
  
  private void a(View paramView)
  {
    try
    {
      paramView = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.1F, 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.1F, 1.0F }) });
      paramView.setDuration(300L);
      paramView.start();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("QQGiftPanelItemViewImpl", 1, paramView, new Object[0]);
    }
  }
  
  private void setDtElement(GiftServiceData paramGiftServiceData)
  {
    VideoReport.setElementId(this.n, "em_yes_gift_panel_send");
    Object localObject = this.n;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramGiftServiceData.hashCode());
    localStringBuilder.append("gift_send");
    VideoReport.setElementReuseIdentifier(localObject, localStringBuilder.toString());
    VideoReport.setElementClickPolicy(this.n, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.n, ExposurePolicy.REPORT_ALL);
    localObject = new HashMap();
    ((Map)localObject).put("yes_gift_price", Integer.valueOf(paramGiftServiceData.c));
    ((Map)localObject).put("yes_gift_name", paramGiftServiceData.b);
    ((Map)localObject).put("yes_gift_id", Integer.valueOf(paramGiftServiceData.a));
    ((Map)localObject).put("dt_pgid", "pg_sgrp_stream_aio");
    VideoReport.setElementParams(this.n, (Map)localObject);
    VideoReport.reportEvent("imp", this.n, null);
  }
  
  private void setDtReport(GiftServiceData paramGiftServiceData)
  {
    try
    {
      setDtElement(paramGiftServiceData);
      return;
    }
    catch (Exception paramGiftServiceData)
    {
      QLog.e("QQGiftPanelItemViewImpl", 1, paramGiftServiceData, new Object[0]);
    }
  }
  
  public void a(int paramInt)
  {
    a(this.a, null);
    QQGiftPanelViewModel localQQGiftPanelViewModel = this.m;
    if ((localQQGiftPanelViewModel != null) && (localQQGiftPanelViewModel.f() != null)) {
      this.m.f().g().a(paramInt, new QQGiftPanelItemViewImpl.ResCallback(this));
    }
  }
  
  public void a(String paramString)
  {
    TextView localTextView;
    if (this.l) {
      localTextView = this.f;
    } else {
      localTextView = this.e;
    }
    if (this.l) {
      paramString = getResources().getString(2131897853);
    }
    localTextView.setText(paramString);
  }
  
  public void b(int paramInt)
  {
    this.g.setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void c(int paramInt)
  {
    TextView localTextView;
    if (this.l) {
      localTextView = this.i;
    } else {
      localTextView = this.h;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localTextView.setText(localStringBuilder.toString());
  }
  
  public void setIsSelected(GiftServiceData paramGiftServiceData, int paramInt)
  {
    if (paramGiftServiceData != null)
    {
      boolean bool = paramGiftServiceData.i;
      Object localObject = this.k;
      int i2 = 0;
      if (bool) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((RelativeLayout)localObject).setVisibility(i1);
      localObject = this.j;
      int i1 = i2;
      if (bool) {
        i1 = 8;
      }
      ((RelativeLayout)localObject).setVisibility(i1);
      if ((!this.l) && (bool))
      {
        a(this);
        localObject = this.m;
        if (localObject != null) {
          ((QQGiftPanelViewModel)localObject).b(paramGiftServiceData, paramInt);
        }
      }
      this.l = bool;
      setDtReport(paramGiftServiceData);
    }
  }
  
  public void setViewModel(QQGiftPanelViewModel paramQQGiftPanelViewModel)
  {
    this.m = paramQQGiftPanelViewModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPanelItemViewImpl
 * JD-Core Version:    0.7.0.1
 */