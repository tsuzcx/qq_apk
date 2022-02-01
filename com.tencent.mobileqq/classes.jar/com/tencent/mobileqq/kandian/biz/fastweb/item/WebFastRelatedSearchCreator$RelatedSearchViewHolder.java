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
  private LinearLayout a;
  private LinearLayout b;
  private TextView c;
  private List<TextView> d;
  private List<LinearLayout> n;
  private Context o;
  private final int p = 2;
  
  private WebFastRelatedSearchCreator$RelatedSearchViewHolder(View paramView, BaseData paramBaseData, Context paramContext)
  {
    super(paramView, paramBaseData);
    this.o = paramContext;
    this.d = new ArrayList();
    this.n = new ArrayList();
    this.a = ((LinearLayout)paramView.findViewById(2131445148));
    this.b = ((LinearLayout)paramView.findViewById(2131445460));
    this.c = ((TextView)paramView.findViewById(2131445461));
    if (paramBaseData.aP == 20) {
      a((RelatedSearchData)paramBaseData);
    }
  }
  
  private void a(RelatedSearchData paramRelatedSearchData)
  {
    int i = paramRelatedSearchData.a.size();
    if (i <= 0) {
      return;
    }
    int k = (i + 1) / 2;
    i = 0;
    while (i < k)
    {
      int j = ViewUtils.dip2px(13.0F);
      float f;
      if (i == k - 1) {
        f = 5.0F;
      } else {
        f = 15.0F;
      }
      int m = ViewUtils.dip2px(f);
      paramRelatedSearchData = new LinearLayout(this.o);
      paramRelatedSearchData.setOrientation(0);
      Object localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(j, 0, j, m);
      this.b.addView(paramRelatedSearchData, (ViewGroup.LayoutParams)localObject);
      this.n.add(paramRelatedSearchData);
      j = 0;
      while (j < 2)
      {
        localObject = new TextView(this.o);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 0.5F);
        ((TextView)localObject).setTextSize(2, 16.0F);
        ((TextView)localObject).setTextColor(Color.parseColor("#4D7CAF"));
        ((TextView)localObject).setIncludeFontPadding(false);
        ((TextView)localObject).setMaxLines(1);
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        m = ViewUtils.dip2px(5.0F);
        ((TextView)localObject).setPadding(m, 0, m, m);
        paramRelatedSearchData.addView((View)localObject, localLayoutParams);
        this.d.add(localObject);
        j += 1;
      }
      i += 1;
    }
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.aP == 20)
    {
      paramBaseData1 = (RelatedSearchData)paramBaseData2;
      int j = paramBaseData1.a.size();
      int k = (j + 1) / 2;
      int i = 0;
      while (i < this.n.size())
      {
        if (i >= k) {
          ((LinearLayout)this.n.get(i)).setVisibility(8);
        } else {
          ((LinearLayout)this.n.get(i)).setVisibility(0);
        }
        i += 1;
      }
      i = 0;
      while (i < this.d.size())
      {
        if (i >= j)
        {
          ((TextView)this.d.get(i)).setVisibility(8);
        }
        else
        {
          ((TextView)this.d.get(i)).setVisibility(0);
          ((TextView)this.d.get(i)).setText(((RelatedSearchData.SearchWord)paramBaseData1.a.get(i)).a);
          RelatedSearchData.SearchWord localSearchWord = (RelatedSearchData.SearchWord)paramBaseData1.a.get(i);
          ((TextView)this.d.get(i)).setOnClickListener(new WebFastRelatedSearchCreator.RelatedSearchViewHolder.1(this, i + 1, localSearchWord, paramBaseData2));
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
    if (this.g.aP == 20)
    {
      Object localObject = (RelatedSearchData)this.g;
      if (!WebFastRelatedSearchCreator.a)
      {
        int j = 0;
        int i = 0;
        while (i < ((RelatedSearchData)localObject).a.size())
        {
          RelatedSearchData.SearchWord localSearchWord = (RelatedSearchData.SearchWord)((RelatedSearchData)localObject).a.get(i);
          i += 1;
          try
          {
            WebFastRelatedSearchCreator.a("0X800983E", new RIJTransMergeKanDianReport.ReportR5Builder().addRowkey(this.g.aR.q).addRelatedSearch(localSearchWord, i).addTitle(this.g.aR.j).addSid(((RelatedSearchData)this.g).b).build());
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
          }
        }
        try
        {
          localObject = new RIJTransMergeKanDianReport.ReportR5Builder().addRowkey(this.g.aR.q).addTitle(this.g.aR.j);
          i = j;
          if (RIJArticleInteractBarAladdinConfig.b()) {
            i = 1;
          }
          WebFastRelatedSearchCreator.a("0X8009857", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addAdRelativePos(i).addSid(((RelatedSearchData)this.g).b).build());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastRelatedSearchCreator.RelatedSearchViewHolder
 * JD-Core Version:    0.7.0.1
 */