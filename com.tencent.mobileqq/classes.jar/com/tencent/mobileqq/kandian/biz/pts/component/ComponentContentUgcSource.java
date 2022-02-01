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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  CmpCtxt a;
  TextView b;
  private String c;
  private LinearLayout d;
  
  public ComponentContentUgcSource(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentContentUgcSource(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("business url is ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("ComponentContentUgcSource", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.c)) {
      return;
    }
    Object localObject = new Intent(getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
    ((Intent)localObject).putExtra("url", this.c);
    getContext().startActivity((Intent)localObject);
    localObject = this.a.a.k();
    if (localObject == null) {
      return;
    }
    PublicAccountReportUtils.a((Entity)localObject);
    RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject, this.a.a.m());
  }
  
  private void c(Context paramContext)
  {
    this.a = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public void a()
  {
    this.d.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    a(b(paramContext));
  }
  
  public void a(View paramView)
  {
    this.b = ((TextView)paramView.findViewById(2131449034));
    this.b.getPaint().setFakeBoldText(true);
    this.d = ((LinearLayout)paramView.findViewById(2131449035));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.a.a(paramObject);
      paramObject = paramObject.k();
      if (paramObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComponentContentUgcSource", 2, "article info is null");
        }
        return;
      }
      if ((RIJItemViewTypeUtils.m(paramObject)) || ((RIJItemViewTypeUtils.l(paramObject)) && (!RIJItemViewTypeUtils.r(paramObject))) || (RIJFeedsType.u(paramObject)) || ((RIJFeedsType.v(paramObject)) && (!RIJItemViewTypeUtils.q(paramObject))) || (RIJItemViewTypeUtils.c(paramObject)))
      {
        localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
        this.b.setText("");
        setVisibility(8);
      }
      else
      {
        localSpannableStringBuilder.append((CharSequence)localObject);
        this.b.setText(localSpannableStringBuilder);
        setVisibility(0);
      }
      this.c = paramObject.businessUrl;
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626345, this, true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131449035) {
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcSource
 * JD-Core Version:    0.7.0.1
 */