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
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.TabConfBean;
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
  private long jdField_a_of_type_Long;
  @NonNull
  private final Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new CustomTabView.1(this);
  private String b;
  
  public CustomTabView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
  }
  
  public CustomTabView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
  }
  
  private void a(EcshopConfBean.TabConfBean paramTabConfBean, TextView paramTextView, ImageView paramImageView)
  {
    this.jdField_a_of_type_Int = paramTabConfBean.jdField_a_of_type_Int;
    paramTextView.setTextColor(Color.parseColor(paramTabConfBean.f));
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(this.jdField_a_of_type_JavaLangString));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_JavaLangString = paramTabConfBean.e;
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(2130851078);
    paramTextView = URLDrawable.getDrawable(paramTabConfBean.d, (URLDrawable.URLDrawableOptions)localObject);
    if (paramTextView != null)
    {
      if (paramTextView.getStatus() == 2) {
        paramTextView.restartDownload();
      }
      paramImageView.setImageDrawable(paramTextView);
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (!StringUtil.a(this.jdField_b_of_type_JavaLangString)))
    {
      localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if (paramTextView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_b_of_type_JavaLangString = paramTabConfBean.c;
  }
  
  private void b(EcshopConfBean.TabConfBean paramTabConfBean, TextView paramTextView, ImageView paramImageView)
  {
    if (paramTabConfBean == null) {
      return;
    }
    int i = paramTabConfBean.jdField_b_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidContentContext, ReportUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString, "tab"), 1035, new CustomTabView.3(this));
        return;
      }
      if (paramTabConfBean.jdField_a_of_type_Int == 1)
      {
        a(paramTabConfBean, paramTextView, paramImageView);
        PageSwitchUtil.a.a(this.jdField_a_of_type_AndroidContentContext, false);
        return;
      }
      paramTextView = new StringBuilder();
      paramTextView.append("can't match tabId: ");
      paramTextView.append(paramTabConfBean.jdField_a_of_type_Int);
      QLog.i("EcshopCustomTabView", 2, paramTextView.toString());
      return;
    }
    a(paramTabConfBean, paramTextView, paramImageView);
    PageSwitchUtil.a.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, ReportUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString, "tab"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.CustomTabView
 * JD-Core Version:    0.7.0.1
 */