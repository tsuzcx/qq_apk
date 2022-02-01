package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.Wormhole;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.WormholeView;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJViolaPicDetailConfigSp;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import org.jetbrains.annotations.Nullable;

public class ViolaHandler
  extends BaseHandler
{
  private Wormhole a = new Wormhole();
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ViolaSDKManager.getInstance().getDomManager().post(new ViolaHandler.1(this, paramAbsBaseArticleInfo));
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560392, paramViewGroup, false);
      localView.setTag(new ViolaHandler.ViolaWormholeViewHolder(this.a, (WormholeView)localView, this));
    }
    paramView = (ViolaHandler.ViolaWormholeViewHolder)localView.getTag();
    paramViewGroup = a(paramInt);
    if ((paramViewGroup instanceof BaseArticleInfo))
    {
      paramViewGroup = (AbsBaseArticleInfo)paramViewGroup;
      paramView.a(paramInt);
      paramView.a(paramViewGroup);
      paramView.a(paramViewGroup, paramInt);
    }
    return localView;
  }
  
  public void a() {}
  
  public void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (Boolean.valueOf(RIJViolaPicDetailConfigSp.a(ReadInJoyUtils.a())).booleanValue())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&album_source=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("&rowkey=");
        localStringBuilder.append(paramString);
        ViolaAccessHelper.a(paramContext, "", localStringBuilder.toString(), null);
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("ViolaHandler", 2, "jumpToGallery failed: isShowViolaPage is false");
      }
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
      a().notifyDataSetChanged();
      ReadinjoyReportUtils.a(paramAbsBaseArticleInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ViolaHandler", 2, "rowKey is empty");
    }
  }
  
  public void a(View paramView1, View paramView2, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    a(paramAbsBaseArticleInfo);
  }
  
  public void a(@Nullable View paramView, @Nullable ListView paramListView) {}
  
  public void a(@Nullable View paramView, @Nullable ListView paramListView, long paramLong) {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Wormhole localWormhole = this.a;
    if (localWormhole != null) {
      localWormhole.a(paramAbsListView);
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 136;
  }
  
  public void b() {}
  
  public void c() {}
  
  public int d()
  {
    return 4;
  }
  
  public void d() {}
  
  public void e()
  {
    Wormhole localWormhole = this.a;
    if (localWormhole != null) {
      localWormhole.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.ViolaHandler
 * JD-Core Version:    0.7.0.1
 */