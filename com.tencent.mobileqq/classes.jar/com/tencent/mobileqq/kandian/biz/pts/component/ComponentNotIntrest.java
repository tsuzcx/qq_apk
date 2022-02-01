package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public class ComponentNotIntrest
  extends FrameLayout
  implements View.OnClickListener, ComponentView
{
  public View a;
  CmpCtxt a;
  
  public ComponentNotIntrest(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentNotIntrest(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentNotIntrest(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560153, this, true).findViewById(2131380181);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a((IReadInJoyModel)paramObject);
      b();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a())
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(AIOUtils.b(5.0F, getResources()), AIOUtils.b(5.0F, getResources()), AIOUtils.b(5.0F, getResources()), AIOUtils.b(5.0F, getResources()));
      return;
    }
    if (RIJFeedsType.C(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a()))
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(AIOUtils.b(5.0F, getResources()), AIOUtils.b(5.0F, getResources()), AIOUtils.b(9.0F, getResources()), AIOUtils.b(5.0F, getResources()));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(AIOUtils.b(12.0F, getResources()), AIOUtils.b(9.0F, getResources()), AIOUtils.b(12.0F, getResources()), AIOUtils.b(9.0F, getResources()));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener.a(paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentNotIntrest
 * JD-Core Version:    0.7.0.1
 */