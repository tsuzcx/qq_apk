package com.tencent.mobileqq.kandian.biz.video.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;

public class ReadInJoyVideoInfoViewGroup
  extends LinearLayout
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  
  public ReadInJoyVideoInfoViewGroup(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ReadInJoyVideoInfoViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @TargetApi(11)
  public ReadInJoyVideoInfoViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    int j;
    int i;
    if ((getMeasuredWidth() != 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (!this.jdField_a_of_type_Boolean))
    {
      removeAllViews();
      j = getMeasuredWidth();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mLabelListObj != null) {
        i = 0;
      }
    }
    for (;;)
    {
      articlesummary.ChannelInfo localChannelInfo;
      Object localObject2;
      Object localObject1;
      int k;
      Object localObject3;
      if (i < this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mLabelListObj.size())
      {
        localChannelInfo = (articlesummary.ChannelInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mLabelListObj.get(i);
        if (this.b != localChannelInfo.uint32_channel_id.get())
        {
          localObject2 = RIJFeedsType.a(localChannelInfo);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = new ReadInJoyVideoTopicTextView(this.jdField_a_of_type_AndroidContentContext);
            ((ReadInJoyVideoTopicTextView)localObject1).setTopicText((String)localObject2);
            int m = ((ReadInJoyVideoTopicTextView)localObject1).a();
            k = m;
            if (i != 0) {
              k = m + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
            }
            if (j <= DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F) + k) {
              break label442;
            }
            k = j - k;
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            if (i != 0) {
              ((LinearLayout.LayoutParams)localObject2).setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, 0, 0);
            }
            ((ReadInJoyVideoTopicTextView)localObject1).setId(2131376059);
            ((ReadInJoyVideoTopicTextView)localObject1).setTag(localChannelInfo);
            localObject3 = this.jdField_a_of_type_AndroidWidgetBaseAdapter;
            if ((localObject3 instanceof ReadInJoyBaseAdapter)) {
              ((ReadInJoyVideoTopicTextView)localObject1).setOnClickListener((ReadInJoyBaseAdapter)localObject3);
            }
            ((ReadInJoyVideoTopicTextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            addView((View)localObject1);
            j = k;
            if (!this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID))) {
              localObject3 = new JSONObject();
            }
          }
        }
      }
      try
      {
        ((JSONObject)localObject3).put("channel_id", this.b);
        label307:
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        if (localChannelInfo.uint32_is_topic.get() == 1) {
          localObject1 = "0X80088BA";
        } else {
          localObject1 = "0X8007BE5";
        }
        if (localChannelInfo.uint32_is_topic.get() == 1) {
          localObject2 = "0X80088BA";
        } else {
          localObject2 = "0X8007BE5";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localChannelInfo.uint32_channel_id.get());
        localStringBuilder.append("");
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", (String)localObject1, (String)localObject2, 0, 0, "2", "", localStringBuilder.toString(), VideoReporter.a("", "", "", "", (JSONObject)localObject3), false);
        j = k;
        i += 1;
        continue;
        label442:
        this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID));
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        break label307;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getDefaultSize(0, paramInt1);
    int i = j;
    if (j == 0) {
      i = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_Int = i;
    super.onMeasure(paramInt1, paramInt2);
    a();
  }
  
  public void setArticleInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseAdapter paramBaseAdapter, int paramInt, Set<Long> paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.b = paramInt;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyVideoInfoViewGroup
 * JD-Core Version:    0.7.0.1
 */