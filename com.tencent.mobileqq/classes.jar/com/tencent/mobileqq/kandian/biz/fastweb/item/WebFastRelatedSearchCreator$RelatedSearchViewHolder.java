package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJArticleInteractBarAladdinConfig;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.RelatedSearchData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.RelatedSearchData.SearchWord;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

class WebFastRelatedSearchCreator$RelatedSearchViewHolder
  extends BaseItemViewHolder
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private List<TextView> jdField_a_of_type_JavaUtilList;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private List<LinearLayout> jdField_b_of_type_JavaUtilList;
  private final int e = 2;
  
  private WebFastRelatedSearchCreator$RelatedSearchViewHolder(View paramView, BaseData paramBaseData, Context paramContext)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376818));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377091));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377092));
    if (paramBaseData.u == 20) {
      a((RelatedSearchData)paramBaseData);
    }
  }
  
  private void a(RelatedSearchData paramRelatedSearchData)
  {
    int i = paramRelatedSearchData.jdField_a_of_type_JavaUtilList.size();
    if (i <= 0) {
      return;
    }
    int k = (i + 1) / 2;
    i = 0;
    while (i < k)
    {
      int j = ViewUtils.a(13.0F);
      float f;
      if (i == k - 1) {
        f = 5.0F;
      } else {
        f = 15.0F;
      }
      int m = ViewUtils.a(f);
      paramRelatedSearchData = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramRelatedSearchData.setOrientation(0);
      Object localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(j, 0, j, m);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramRelatedSearchData, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_JavaUtilList.add(paramRelatedSearchData);
      j = 0;
      while (j < 2)
      {
        localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 0.5F);
        ((TextView)localObject).setTextSize(2, 16.0F);
        ((TextView)localObject).setTextColor(Color.parseColor("#4D7CAF"));
        ((TextView)localObject).setIncludeFontPadding(false);
        ((TextView)localObject).setMaxLines(1);
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        m = ViewUtils.a(5.0F);
        ((TextView)localObject).setPadding(m, 0, m, m);
        paramRelatedSearchData.addView((View)localObject, localLayoutParams);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        j += 1;
      }
      i += 1;
    }
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.u == 20)
    {
      paramBaseData1 = (RelatedSearchData)paramBaseData2;
      int j = paramBaseData1.jdField_a_of_type_JavaUtilList.size();
      int k = (j + 1) / 2;
      int i = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        if (i >= k) {
          ((LinearLayout)this.jdField_b_of_type_JavaUtilList.get(i)).setVisibility(8);
        } else {
          ((LinearLayout)this.jdField_b_of_type_JavaUtilList.get(i)).setVisibility(0);
        }
        i += 1;
      }
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (i >= j)
        {
          ((TextView)this.jdField_a_of_type_JavaUtilList.get(i)).setVisibility(8);
        }
        else
        {
          ((TextView)this.jdField_a_of_type_JavaUtilList.get(i)).setVisibility(0);
          ((TextView)this.jdField_a_of_type_JavaUtilList.get(i)).setText(((RelatedSearchData.SearchWord)paramBaseData1.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString);
          RelatedSearchData.SearchWord localSearchWord = (RelatedSearchData.SearchWord)paramBaseData1.jdField_a_of_type_JavaUtilList.get(i);
          ((TextView)this.jdField_a_of_type_JavaUtilList.get(i)).setOnClickListener(new WebFastRelatedSearchCreator.RelatedSearchViewHolder.1(this, i + 1, localSearchWord, paramBaseData2));
        }
        i += 1;
      }
      return;
    }
    paramBaseData1 = new IllegalArgumentException();
    for (;;)
    {
      throw paramBaseData1;
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.u == 20)
    {
      Object localObject = (RelatedSearchData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData;
      if (!WebFastRelatedSearchCreator.a)
      {
        int j = 0;
        int i = 0;
        while (i < ((RelatedSearchData)localObject).jdField_a_of_type_JavaUtilList.size())
        {
          RelatedSearchData.SearchWord localSearchWord = (RelatedSearchData.SearchWord)((RelatedSearchData)localObject).jdField_a_of_type_JavaUtilList.get(i);
          i += 1;
          try
          {
            WebFastRelatedSearchCreator.a("0X800983E", new RIJTransMergeKanDianReport.ReportR5Builder().addRowkey(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.a.j).addRelatedSearch(localSearchWord, i).addTitle(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.a.c).addSid(((RelatedSearchData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData).jdField_a_of_type_JavaLangString).build());
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
          }
        }
        try
        {
          localObject = new RIJTransMergeKanDianReport.ReportR5Builder().addRowkey(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.a.j).addTitle(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.a.c);
          i = j;
          if (RIJArticleInteractBarAladdinConfig.b()) {
            i = 1;
          }
          WebFastRelatedSearchCreator.a("0X8009857", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addAdRelativePos(i).addSid(((RelatedSearchData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData).jdField_a_of_type_JavaLangString).build());
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
        }
        WebFastRelatedSearchCreator.a = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastRelatedSearchCreator.RelatedSearchViewHolder
 * JD-Core Version:    0.7.0.1
 */