package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public abstract class FeedItemCellTypeNewPolymericBaseHeader
  extends FeedItemCell
{
  private void a(LinearLayout paramLinearLayout, IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel.c() == 56)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setDividerWidth(AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setDividerWidth(AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (RIJFeedsType.D(paramIReadInJoyModel.a())) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setClipChildren(false);
    paramLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView);
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof ReadInJoyNewFeedsActivity)) {
      return;
    }
    if (RIJShowKanDianTabSp.c()) {
      try
      {
        localObject = (ReadinjoyTabFrame)FrameHelperActivity.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext).a(ReadinjoyTabFrame.class);
        if (localObject != null)
        {
          ((ReadinjoyTabFrame)localObject).b(paramView);
          return;
        }
      }
      catch (Exception paramView)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readinjoy tab add dispatch touch event view fail ! e : ");
        ((StringBuilder)localObject).append(paramView);
        QLog.d("FeedItemCellTypeNewPolymericBaseHeader", 2, ((StringBuilder)localObject).toString());
        paramView.printStackTrace();
      }
    }
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return v().u().n().l();
  }
  
  protected abstract void a(LinearLayout paramLinearLayout);
  
  public FeedItemCell d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      a(localLinearLayout);
      if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView != null))
      {
        ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();
        a(localLinearLayout, (IReadInJoyModel)this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentWhiteSpace != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentWhiteSpace);
      }
      a(localLinearLayout);
      b(a());
      return this;
    }
    throw new Exception("buildComponent() must after buildComponent()!");
  }
  
  public FeedItemCell e()
  {
    return this;
  }
  
  public FeedItemCell o()
  {
    super.o();
    w();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.a(this.jdField_a_of_type_JavaLangObject);
    }
    try
    {
      e();
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("FeedItemCellTypeNewPolymericBaseHeader", 1, localException, new Object[0]);
    }
    return this;
  }
  
  public FeedItemCell p()
  {
    super.p();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    return this;
  }
  
  protected abstract FeedItemCell v();
  
  protected abstract FeedItemCell w();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNewPolymericBaseHeader
 * JD-Core Version:    0.7.0.1
 */