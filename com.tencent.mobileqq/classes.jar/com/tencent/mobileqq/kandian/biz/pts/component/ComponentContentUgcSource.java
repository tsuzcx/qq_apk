package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ComponentContentUgcSource
  extends LinearLayout
  implements View.OnClickListener, ComponentInheritView
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  private String jdField_a_of_type_JavaLangString;
  
  public ComponentContentUgcSource(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentUgcSource(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("business url is ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ComponentContentUgcSource", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject = new Intent(getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
    getContext().startActivity((Intent)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if (localObject == null) {
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportLabelsClick((Entity)localObject);
    RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560299, this, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380120));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131380121));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramObject);
      paramObject = paramObject.a();
      if (paramObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComponentContentUgcSource", 2, "article info is null");
        }
        return;
      }
      if ((RIJItemViewTypeUtils.m(paramObject)) || ((RIJItemViewTypeUtils.l(paramObject)) && (!RIJItemViewTypeUtils.r(paramObject))) || (RIJFeedsType.o(paramObject)) || ((RIJFeedsType.p(paramObject)) && (!RIJItemViewTypeUtils.q(paramObject))) || (RIJItemViewTypeUtils.c(paramObject)))
      {
        localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      Object localObject = paramObject.businessName;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (!TextUtils.isEmpty(paramObject.businessNamePrefix))
      {
        localSpannableStringBuilder.append(paramObject.businessNamePrefix);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#07D0B0")), 0, localSpannableStringBuilder.length(), 33);
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        setVisibility(8);
      }
      else
      {
        localSpannableStringBuilder.append((CharSequence)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
        setVisibility(0);
      }
      this.jdField_a_of_type_JavaLangString = paramObject.businessUrl;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131380121) {
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcSource
 * JD-Core Version:    0.7.0.1
 */