package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ArticleTopicData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleTopicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.HorizontalLabelLayout;
import java.util.List;

class SimpleViewCreator$ArticleTopicFlagViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private HorizontalLabelLayout b;
  
  public SimpleViewCreator$ArticleTopicFlagViewHolder(SimpleViewCreator paramSimpleViewCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.b = ((HorizontalLabelLayout)paramView);
  }
  
  private View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626230, (ViewGroup)this.f, false);
  }
  
  private void a(String paramString, ArticleTopicInfo paramArticleTopicInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    long l1 = paramAbsBaseArticleInfo.mArticleID;
    long l2 = paramArticleTopicInfo.c;
    PublicAccountReportUtils.a(null, "CliOper", "", RIJQQAppInterfaceUtil.d(), paramString, paramString, 0, 0, String.valueOf(l1), String.valueOf(l2), paramAbsBaseArticleInfo.innerUniqueID, "", false);
  }
  
  public SpannableStringBuilder a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append("# ");
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#07D0B0")), 0, localSpannableStringBuilder.length(), 33);
    double d1 = 0.0D;
    int i = 0;
    while (i < paramString.length())
    {
      double d2;
      if (StringUtil.isChinese(paramString.charAt(i))) {
        d2 = 1.0D;
      } else {
        d2 = 0.5D;
      }
      d1 += d2;
      if (d1 >= 11.0D) {
        break;
      }
      i += 1;
    }
    Object localObject = paramString;
    if (i < paramString.length() - 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, i + 1));
      ((StringBuilder)localObject).append(ReadInJoyConstants.b);
      localObject = ((StringBuilder)localObject).toString();
    }
    localSpannableStringBuilder.append((CharSequence)localObject);
    return localSpannableStringBuilder;
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = (ArticleTopicData)paramBaseData2;
    int j = paramBaseData1.a.size();
    View localView;
    if (this.b.getChildCount() < j)
    {
      int k = this.b.getChildCount();
      i = 0;
      while (i < j - k)
      {
        localView = a(this.b.getContext());
        this.b.addView(localView);
        localView.setOnClickListener(this);
        i += 1;
      }
    }
    int i = 0;
    while (i < this.b.getChildCount())
    {
      localView = this.b.getChildAt(i);
      if (i < j)
      {
        localView.setVisibility(0);
        ArticleTopicInfo localArticleTopicInfo = (ArticleTopicInfo)paramBaseData1.a.get(i);
        localView.setTag(localArticleTopicInfo);
        ((TextView)localView.findViewById(2131444241)).setText(a(localArticleTopicInfo.a));
        if ((!paramBoolean) && (!paramBaseData1.b))
        {
          a("0X800919F", localArticleTopicInfo, paramBaseData2.aQ);
          paramBaseData1.b = true;
        }
      }
      else
      {
        localView.setVisibility(8);
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    ArticleTopicInfo localArticleTopicInfo = (ArticleTopicInfo)paramView.getTag();
    if (localArticleTopicInfo != null)
    {
      ReadInJoyUtils.a(paramView.getContext(), localArticleTopicInfo.b);
      a("0X80091A0", localArticleTopicInfo, this.g.aQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.SimpleViewCreator.ArticleTopicFlagViewHolder
 * JD-Core Version:    0.7.0.1
 */