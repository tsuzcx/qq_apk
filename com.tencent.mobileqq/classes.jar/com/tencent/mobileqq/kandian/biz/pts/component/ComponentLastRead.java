package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public class ComponentLastRead
  extends LinearLayout
  implements ComponentView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  
  public ComponentLastRead(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentLastRead(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentLastRead(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null) {
      return;
    }
    int i = paramIReadInJoyModel.c();
    if ((i != 0) && (!DailyModeConfigHandler.c(i))) {
      return;
    }
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if (paramIReadInJoyModel == null) {
      return;
    }
    Object localObject = paramIReadInJoyModel.getTemplateFactory();
    if (localObject == null) {
      return;
    }
    if (!((BaseTemplateFactory)localObject).hasTemplate("ReadInjoy_last_read_cell")) {
      return;
    }
    localObject = ((BaseTemplateFactory)localObject).getTemplate("ReadInjoy_last_read_cell");
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramIReadInJoyModel.getViewFactory().inflate(paramIReadInJoyModel, (TemplateBean)localObject);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null)
      {
        removeAllViews();
        paramIReadInJoyModel = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().getComLayoutParams();
        paramIReadInJoyModel = new RelativeLayout.LayoutParams(paramIReadInJoyModel.mLayoutWidth, paramIReadInJoyModel.mLayoutHeight);
        addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, paramIReadInJoyModel);
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      CmpCtxt localCmpCtxt = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
      paramObject = (IReadInJoyModel)paramObject;
      localCmpCtxt.a(paramObject);
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.g())
      {
        a(paramObject);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null)
        {
          paramObject = this.jdField_a_of_type_AndroidContentContext;
          if ((paramObject != null) && (this.jdField_a_of_type_AndroidViewView == null))
          {
            this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramObject).inflate(2131560151, null, false);
            setBackgroundResource(2131166928);
            addView(this.jdField_a_of_type_AndroidViewView);
          }
        }
        setVisibility(0);
        setOnClickListener(new ComponentLastRead.1(this));
        ThreadManager.executeOnSubThread(new ComponentLastRead.2(this));
        return;
      }
      setVisibility(8);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentLastRead
 * JD-Core Version:    0.7.0.1
 */