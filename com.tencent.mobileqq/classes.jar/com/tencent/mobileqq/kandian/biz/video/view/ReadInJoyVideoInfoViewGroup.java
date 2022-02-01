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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;

public class ReadInJoyVideoInfoViewGroup
  extends LinearLayout
{
  private Context a;
  private int b = 0;
  private int c = 0;
  private boolean d = false;
  private BaseAdapter e;
  private AbsBaseArticleInfo f;
  private Set<Long> g;
  
  public ReadInJoyVideoInfoViewGroup(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public ReadInJoyVideoInfoViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  @TargetApi(11)
  public ReadInJoyVideoInfoViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  private void a()
  {
    int j;
    int i;
    if ((getMeasuredWidth() != 0) && (this.f != null) && (!this.d))
    {
      removeAllViews();
      j = getMeasuredWidth();
      if (this.f.mLabelListObj != null) {
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
      if (i < this.f.mLabelListObj.size())
      {
        localChannelInfo = (articlesummary.ChannelInfo)this.f.mLabelListObj.get(i);
        if (this.c != localChannelInfo.uint32_channel_id.get())
        {
          localObject2 = RIJFeedsType.a(localChannelInfo);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = new ReadInJoyVideoTopicTextView(this.a);
            ((ReadInJoyVideoTopicTextView)localObject1).setTopicText((String)localObject2);
            int m = ((ReadInJoyVideoTopicTextView)localObject1).getViewWidth();
            k = m;
            if (i != 0) {
              k = m + DisplayUtil.a(this.a, 10.0F);
            }
            if (j <= DisplayUtil.a(this.a, 1.0F) + k) {
              break label428;
            }
            k = j - k;
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            if (i != 0) {
              ((LinearLayout.LayoutParams)localObject2).setMargins(DisplayUtil.a(this.a, 10.0F), 0, 0, 0);
            }
            ((ReadInJoyVideoTopicTextView)localObject1).setId(2131444259);
            ((ReadInJoyVideoTopicTextView)localObject1).setTag(localChannelInfo);
            localObject3 = this.e;
            if ((localObject3 instanceof ReadInJoyBaseAdapter)) {
              ((ReadInJoyVideoTopicTextView)localObject1).setOnClickListener((ReadInJoyBaseAdapter)localObject3);
            }
            ((ReadInJoyVideoTopicTextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            addView((View)localObject1);
            j = k;
            if (!this.g.contains(Long.valueOf(this.f.mArticleID))) {
              localObject3 = new JSONObject();
            }
          }
        }
      }
      try
      {
        ((JSONObject)localObject3).put("channel_id", this.c);
        label307:
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
        PublicAccountReportUtils.a(null, "", (String)localObject1, (String)localObject2, 0, 0, "2", "", localStringBuilder.toString(), VideoReporter.a("", "", "", "", (JSONObject)localObject3), false);
        j = k;
        i += 1;
        continue;
        label428:
        this.g.add(Long.valueOf(this.f.mArticleID));
        this.d = true;
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
      i = this.b;
    }
    this.b = i;
    super.onMeasure(paramInt1, paramInt2);
    a();
  }
  
  public void setArticleInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseAdapter paramBaseAdapter, int paramInt, Set<Long> paramSet)
  {
    this.f = paramAbsBaseArticleInfo;
    this.e = paramBaseAdapter;
    this.c = paramInt;
    this.d = false;
    this.g = paramSet;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyVideoInfoViewGroup
 * JD-Core Version:    0.7.0.1
 */