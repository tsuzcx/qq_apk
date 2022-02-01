package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypePolymeric
  extends FeedItemCell
{
  private static final String a = "FeedItemCellTypePolymeric";
  
  public FeedItemCellTypePolymeric(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  private void a(LinearLayout paramLinearLayout, IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel.c() == 56)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setDividerWidth(AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setDividerWidth(AIOUtils.b(1.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setClipChildren(false);
    paramLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 9) || (paramInt == 10) || (paramInt == 11);
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
        Object localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readinjoy tab add dispatch touch event view fail ! e : ");
        localStringBuilder.append(paramView);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
        paramView.printStackTrace();
      }
    }
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel)) && (((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).c() == 56))
    {
      if (((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).e() == 53) {
        return b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).u().n();
      }
      return b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).u().n().l().m();
    }
    return b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).u().n().l();
  }
  
  public FeedItemCell d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric);
      }
      if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView != null))
      {
        Object localObject = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();
        if ((((AbsBaseArticleInfo)localObject).mPolymericInfo != null) && (a(((AbsBaseArticleInfo)localObject).mPolymericInfo.a)))
        {
          a(localLinearLayout, (IReadInJoyModel)this.jdField_a_of_type_JavaLangObject);
        }
        else
        {
          localObject = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((LinearLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setDividerWidth(AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView, (ViewGroup.LayoutParams)localObject);
        }
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.a(this.jdField_a_of_type_JavaLangObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePolymeric
 * JD-Core Version:    0.7.0.1
 */