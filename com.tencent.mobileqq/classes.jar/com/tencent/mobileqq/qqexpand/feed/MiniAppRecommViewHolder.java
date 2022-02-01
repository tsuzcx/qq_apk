package com.tencent.mobileqq.qqexpand.feed;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo;
import com.tencent.mobileqq.qqexpand.widget.WrapContentLinearLayoutManager;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.vip.tianshu.TianShuManager;
import mqq.app.AppRuntime;

public class MiniAppRecommViewHolder
  extends RecyclerView.ViewHolder
{
  private final Activity a;
  private final ViewGroup b;
  private final ViewGroup c;
  private final TextView d;
  private final RecyclerView e;
  private final MiniAppRecommViewHolder.MiniAppAdapter f;
  
  public MiniAppRecommViewHolder(View paramView, Activity paramActivity)
  {
    super(paramView);
    this.a = paramActivity;
    this.b = ((ViewGroup)paramView.findViewById(2131445137));
    this.c = ((ViewGroup)paramView.findViewById(2131431322));
    this.d = ((TextView)paramView.findViewById(2131447150));
    this.e = ((RecyclerView)paramView.findViewById(2131438439));
    int i = AIOUtils.b(4.0F, paramActivity.getResources());
    int j = i * 3;
    paramView = new RoundedColorDrawable(-1, j, j, i);
    this.c.setBackgroundDrawable(paramView);
    this.e.setItemAnimator(null);
    this.f = new MiniAppRecommViewHolder.MiniAppAdapter(this);
    this.e.setAdapter(this.f);
    paramView = new WrapContentLinearLayoutManager(paramActivity, 0, false);
    paramView.setAutoMeasureEnabled(false);
    this.e.setLayoutManager(paramView);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.c = 1;
    localTianShuReportData.f = "tianshu.78";
    localTianShuReportData.g = "tianshu.78";
    localTianShuReportData.h = Integer.toString(paramInt3);
    localTianShuReportData.i = "";
    localTianShuReportData.o = l;
    localTianShuReportData.p = paramInt1;
    localTianShuReportData.l = Integer.toString(paramInt2);
    localTianShuReportData.q = 1;
    localTianShuReportData.r = 1;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  public void a(MiniAppRecommInfo paramMiniAppRecommInfo, int paramInt)
  {
    if (paramMiniAppRecommInfo == null) {
      return;
    }
    ViewGroup localViewGroup = this.b;
    localViewGroup.setPadding(localViewGroup.getPaddingLeft(), paramInt, this.b.getPaddingRight(), this.b.getPaddingBottom());
    this.d.setText(paramMiniAppRecommInfo.headDesc);
    this.f.a(paramMiniAppRecommInfo.appInfoList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.MiniAppRecommViewHolder
 * JD-Core Version:    0.7.0.1
 */