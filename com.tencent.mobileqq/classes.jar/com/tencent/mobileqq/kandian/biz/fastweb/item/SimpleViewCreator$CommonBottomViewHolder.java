package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.CommonBottomData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.util.DisplayUtil;

class SimpleViewCreator$CommonBottomViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private View b = this.jdField_a_of_type_AndroidViewView.findViewById(2131363738);
  private View c = this.jdField_a_of_type_AndroidViewView.findViewById(2131363753);
  private View d = this.jdField_a_of_type_AndroidViewView.findViewById(2131364976);
  
  public SimpleViewCreator$CommonBottomViewHolder(SimpleViewCreator paramSimpleViewCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.d.setOnClickListener(this);
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = (CommonBottomData)paramBaseData2;
    int j = paramBaseData1.u;
    int i = 0;
    if ((j == 14) && (paramBaseData1.b)) {
      this.d.setVisibility(0);
    } else {
      this.d.setVisibility(8);
    }
    if (paramBaseData1.a)
    {
      this.c.setVisibility(0);
      if (paramBaseData2.u == 14) {
        this.c.getLayoutParams().height = DisplayUtil.a(this.c.getContext(), 6.0F);
      } else {
        this.c.getLayoutParams().height = DisplayUtil.a(this.c.getContext(), 10.0F);
      }
    }
    else
    {
      this.c.setVisibility(8);
    }
    paramBaseData1 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    if (paramBaseData2.u != 14) {
      i = DisplayUtil.a(this.b.getContext(), 12.0F);
    }
    paramBaseData1.rightMargin = i;
    paramBaseData1.leftMargin = i;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.u == 14)
    {
      paramView = (BaseActivity)this.jdField_a_of_type_AndroidViewView.getContext();
      if ((paramView != null) && ((paramView instanceof FastWebActivity))) {
        ((FastWebActivity)paramView).a();
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.b;
      int i = (int)localAbsBaseArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.a.a()) {
        paramView = "2";
      } else {
        paramView = "1";
      }
      ReportUtil.a(localAbsBaseArticleInfo, "0X800900A", RIJTransMergeKanDianReport.a(localAbsBaseArticleInfo, i, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.SimpleViewCreator.CommonBottomViewHolder
 * JD-Core Version:    0.7.0.1
 */