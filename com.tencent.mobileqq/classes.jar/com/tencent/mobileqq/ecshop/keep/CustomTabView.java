package com.tencent.mobileqq.ecshop.keep;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.TabConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.widget.PageSwitchUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class CustomTabView
  extends FrameLayout
{
  public int a;
  private ArrayList<Integer> b = new CustomTabView.1(this);
  @NonNull
  private final Context c;
  private long d;
  private TextView e;
  private String f;
  private ImageView g;
  private String h;
  
  public CustomTabView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
    this.d = NetConnInfoCenter.getServerTime();
  }
  
  public CustomTabView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    this.d = NetConnInfoCenter.getServerTime();
  }
  
  private void a(EcshopConfBean.TabConfBean paramTabConfBean, TextView paramTextView, ImageView paramImageView)
  {
    this.a = paramTabConfBean.b;
    paramTextView.setTextColor(Color.parseColor(paramTabConfBean.h));
    if ((this.e != null) && (!StringUtil.isEmpty(this.f))) {
      this.e.setTextColor(Color.parseColor(this.f));
    }
    this.e = paramTextView;
    this.f = paramTabConfBean.g;
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(this.c, 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(this.c, 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(2130853309);
    paramTextView = URLDrawable.getDrawable(paramTabConfBean.f, (URLDrawable.URLDrawableOptions)localObject);
    if (paramTextView != null)
    {
      if (paramTextView.getStatus() == 2) {
        paramTextView.restartDownload();
      }
      paramImageView.setImageDrawable(paramTextView);
    }
    if ((this.g != null) && (!StringUtil.isEmpty(this.h)))
    {
      localObject = URLDrawable.getDrawable(this.h, (URLDrawable.URLDrawableOptions)localObject);
      if (paramTextView != null) {
        this.g.setImageDrawable((Drawable)localObject);
      }
    }
    this.g = paramImageView;
    this.h = paramTabConfBean.e;
  }
  
  private void b(EcshopConfBean.TabConfBean paramTabConfBean, TextView paramTextView, ImageView paramImageView)
  {
    if (paramTabConfBean == null) {
      return;
    }
    int i = paramTabConfBean.i;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.c, ReportUtil.a(paramTabConfBean.d, "tab"), 1035, new CustomTabView.3(this));
        return;
      }
      if (paramTabConfBean.b == 1)
      {
        a(paramTabConfBean, paramTextView, paramImageView);
        PageSwitchUtil.a.a(this.c, false);
        return;
      }
      paramTextView = new StringBuilder();
      paramTextView.append("can't match tabId: ");
      paramTextView.append(paramTabConfBean.b);
      QLog.i("EcshopCustomTabView", 2, paramTextView.toString());
      return;
    }
    a(paramTabConfBean, paramTextView, paramImageView);
    PageSwitchUtil.a.a(this.c, this.a, ReportUtil.a(paramTabConfBean.d, "tab"));
  }
  
  private ArrayList<EcshopConfBean.TabConfBean> getTabConfigs()
  {
    Object localObject = EcshopConfUtil.a();
    if (localObject == null)
    {
      QLog.i("EcshopCustomTabView", 2, "[CustomTabView] ecshopConfBean is null");
      return new ArrayList();
    }
    localObject = ((EcshopConfBean)localObject).k;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      return localObject;
    }
    QLog.i("EcshopCustomTabView", 2, "[CustomTabView] tabConfs is null");
    return new ArrayList();
  }
  
  public void a(View paramView)
  {
    if (paramView.getParent() == null) {
      return;
    }
    if ((paramView instanceof ViewGroup)) {
      ((ViewGroup)paramView).setClipChildren(false);
    }
    if ((paramView.getParent() instanceof View)) {
      a((View)paramView.getParent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.CustomTabView
 * JD-Core Version:    0.7.0.1
 */