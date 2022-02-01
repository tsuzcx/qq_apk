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
  private View b = this.f.findViewById(2131429661);
  private View c = this.f.findViewById(2131429677);
  private View d = this.f.findViewById(2131431103);
  
  public SimpleViewCreator$CommonBottomViewHolder(SimpleViewCreator paramSimpleViewCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.d.setOnClickListener(this);
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = (CommonBottomData)paramBaseData2;
    int j = paramBaseData1.aP;
    int i = 0;
    if ((j == 14) && (paramBaseData1.b)) {
      this.d.setVisibility(0);
    } else {
      this.d.setVisibility(8);
    }
    if (paramBaseData1.a)
    {
      this.c.setVisibility(0);
      if (paramBaseData2.aP == 14) {
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
    if (paramBaseData2.aP != 14) {
      i = DisplayUtil.a(this.b.getContext(), 12.0F);
    }
    paramBaseData1.rightMargin = i;
    paramBaseData1.leftMargin = i;
  }
  
  public void onClick(View paramView)
  {
    if (this.g.aP == 14)
    {
      paramView = (BaseActivity)this.f.getContext();
      if ((paramView != null) && ((paramView instanceof FastWebActivity))) {
        ((FastWebActivity)paramView).b();
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.g.aQ;
      int i = (int)localAbsBaseArticleInfo.mChannelID;
      if (this.g.aR.a()) {
        paramView = "2";
      } else {
        paramView = "1";
      }
      ReportUtil.a(localAbsBaseArticleInfo, "0X800900A", RIJTransMergeKanDianReport.a(localAbsBaseArticleInfo, i, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.SimpleViewCreator.CommonBottomViewHolder
 * JD-Core Version:    0.7.0.1
 */