package com.tencent.mobileqq.kandian.biz.tab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.biz.widgets.TabLayout.TabAdapter;
import com.tencent.biz.widgets.TabLayout.TabAdapter.TabViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.db.struct.ReportData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import java.util.Map;

public class ReadInJoyTabAdapter
  extends TabLayout.TabAdapter<TabChannelCoverInfo>
{
  public static final String d = "ReadInJoyTabAdapter";
  private TabLayout e;
  private Map<Integer, BaseReportData> f;
  private ReadInJoyChannelViewPagerController g;
  
  public ReadInJoyTabAdapter(Context paramContext, List<TabChannelCoverInfo> paramList, TabLayout paramTabLayout, ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController)
  {
    super(paramContext, paramList);
    this.e = paramTabLayout;
    this.g = paramReadInJoyChannelViewPagerController;
  }
  
  private void a(TabLayout.TabAdapter.TabViewHolder paramTabViewHolder, int paramInt, TextView paramTextView)
  {
    if (this.g != null)
    {
      paramTabViewHolder = paramTabViewHolder.a(2131436062);
      if (paramInt == this.g.k())
      {
        paramTextView.setTextColor(paramTextView.getResources().getColor(2131167856));
        paramTextView.setTypeface(Typeface.defaultFromStyle(1));
        paramTabViewHolder.setVisibility(0);
      }
      else
      {
        paramTextView.setTextColor(paramTextView.getResources().getColor(2131167857));
        paramTextView.setTypeface(Typeface.defaultFromStyle(0));
        paramTabViewHolder.setVisibility(4);
      }
      if (this.g.d() == 0)
      {
        paramTextView = (ViewGroup.MarginLayoutParams)paramTabViewHolder.getLayoutParams();
        paramTextView.leftMargin = ViewUtils.dpToPx(0.0F);
        paramTextView.rightMargin = ViewUtils.dpToPx(0.0F);
        paramTabViewHolder.setLayoutParams(paramTextView);
      }
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(this.g.k());
    int i;
    if (localTabChannelCoverInfo != null) {
      i = localTabChannelCoverInfo.mChannelCoverId;
    } else {
      i = 0;
    }
    VideoReport.reportEvent("clck", new RIJDtParamBuilder().a(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId)).a("14").b("channel_bar").c("click_channel").a().a("eid", "channel_button").a("ref_channel", Integer.valueOf(i)).c());
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt, ImageView paramImageView1, ImageView paramImageView2)
  {
    if (paramTabChannelCoverInfo.redPoint != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      if (paramTabChannelCoverInfo.redPoint.a)
      {
        long l = System.currentTimeMillis() / 1000L;
        boolean bool = a(paramTabChannelCoverInfo, l);
        if ((paramTabChannelCoverInfo.redPoint.b <= l) && ((paramTabChannelCoverInfo.redPoint.c == 0L) || (paramTabChannelCoverInfo.redPoint.c >= l)))
        {
          a(paramTabChannelCoverInfo, paramInt, paramImageView1, paramImageView2, bool);
          return;
        }
        paramImageView2.setVisibility(8);
        paramImageView1.setVisibility(8);
        return;
      }
      paramImageView2.setVisibility(8);
      paramImageView1.setVisibility(8);
      return;
    }
    paramImageView2.setVisibility(8);
    paramImageView1.setVisibility(8);
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean)
  {
    if (paramTabChannelCoverInfo.redPoint.e == 0)
    {
      paramImageView2.setVisibility(0);
    }
    else if ((paramInt < e()) && (!paramBoolean))
    {
      if (ReadInJoyChannelViewPagerController.d)
      {
        paramImageView1.setVisibility(0);
        paramImageView2 = new TranslateAnimation(1, 1.0F, 1, -1.0F, 1, -1.0F, 1, 1.0F);
        paramImageView2.setDuration(3000L);
        paramImageView2.setRepeatCount(1);
        paramImageView2.setStartOffset(1000L);
        paramImageView2.setFillAfter(true);
        paramImageView1.startAnimation(paramImageView2);
      }
      paramTabChannelCoverInfo.redPoint.d = (System.currentTimeMillis() / 1000L);
      this.g.a(paramTabChannelCoverInfo);
      return;
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo1, TextView paramTextView, ImageView paramImageView1, ImageView paramImageView2, TabChannelCoverInfo paramTabChannelCoverInfo2)
  {
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo2.mChannelCoverPicUrl))
    {
      paramImageView2.setVisibility(0);
      paramImageView2.setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo2.mChannelCoverPicUrl, true));
    }
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo2.mIconUrl))
    {
      paramImageView1.setVisibility(0);
      try
      {
        paramImageView1.setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo2.mIconUrl, true));
      }
      catch (Exception paramImageView1)
      {
        if (QLog.isColorLevel())
        {
          paramImageView2 = d;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("load channel cover error : ");
          localStringBuilder.append(paramImageView1);
          QLog.d(paramImageView2, 2, localStringBuilder.toString());
        }
      }
    }
    if ((!TextUtils.isEmpty(paramTabChannelCoverInfo2.mChannelCoverName)) && (paramTabChannelCoverInfo2.onlyCover == 0))
    {
      paramTextView.setText(paramTabChannelCoverInfo1.mChannelCoverName);
      int i;
      if (paramTabChannelCoverInfo1.fontsColor != 0) {
        i = paramTabChannelCoverInfo1.fontsColor;
      } else {
        i = -16777216;
      }
      paramTextView.setTextColor(i);
      paramTextView.setVisibility(0);
    }
  }
  
  private void a(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].setVisibility(8);
      i += 1;
    }
  }
  
  private int e()
  {
    if (ChannelModeConfigHandler.a()) {
      return 11;
    }
    return 6;
  }
  
  protected int a()
  {
    return 2131626279;
  }
  
  protected void a(TabLayout.TabAdapter.TabViewHolder paramTabViewHolder, TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    TextView localTextView = (TextView)paramTabViewHolder.a(2131448814);
    Object localObject = (ImageView)paramTabViewHolder.a(2131436420);
    ImageView localImageView1 = (ImageView)paramTabViewHolder.a(2131436423);
    ImageView localImageView2 = (ImageView)paramTabViewHolder.a(2131439233);
    a(new View[] { localTextView, localObject, localImageView1, localImageView2 });
    ImageView localImageView3 = (ImageView)paramTabViewHolder.a(2131436550);
    if (paramTabChannelCoverInfo != null)
    {
      a(paramTabChannelCoverInfo, localTextView, (ImageView)localObject, localImageView1, paramTabChannelCoverInfo);
      a(paramTabChannelCoverInfo, paramInt, localImageView2, localImageView3);
      paramTabViewHolder.a().setOnClickListener(new ReadInJoyTabAdapter.1(this, paramTabChannelCoverInfo, paramInt, paramTabChannelCoverInfo, localImageView3));
      localObject = this.e;
      if (localObject != null)
      {
        int i = ((TabLayout)localObject).getFirstVisiblePosition();
        int j = this.e.getLastVisiblePosition();
        if ((paramInt >= i) && (paramInt <= j) && (this.f != null))
        {
          localObject = new ReportData();
          ((BaseReportData)localObject).C = paramTabChannelCoverInfo;
          ((BaseReportData)localObject).D = paramInt;
          this.f.put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), localObject);
        }
      }
    }
    a(paramTabViewHolder, paramInt, localTextView);
  }
  
  public void a(Map<Integer, BaseReportData> paramMap)
  {
    this.f = paramMap;
  }
  
  @VisibleForTesting
  boolean a(TabChannelCoverInfo paramTabChannelCoverInfo, long paramLong)
  {
    return (paramTabChannelCoverInfo.redPoint.d != 0L) && ((float)(paramLong - paramTabChannelCoverInfo.redPoint.d) > 2.5F) && ((float)(paramLong / 3600L - paramTabChannelCoverInfo.redPoint.d / 3600L) < 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyTabAdapter
 * JD-Core Version:    0.7.0.1
 */