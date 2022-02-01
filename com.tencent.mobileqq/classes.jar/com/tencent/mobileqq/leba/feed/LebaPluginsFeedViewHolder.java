package com.tencent.mobileqq.leba.feed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.entity.UpdateRedTouchParam;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.leba.report.LebaDaTong;
import com.tencent.mobileqq.leba.utils.LebaPluginViewUtil;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import mqq.app.AppRuntime;

public class LebaPluginsFeedViewHolder
{
  public RedTouch a;
  public View b;
  private TextView c;
  private ImageView d;
  
  public LebaPluginsFeedViewHolder(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2) {
      this.b = paramLayoutInflater.inflate(2131627489, paramViewGroup, false);
    } else {
      this.b = paramLayoutInflater.inflate(2131627488, paramViewGroup, false);
    }
    this.c = ((TextView)this.b.findViewById(2131448598));
    this.d = ((ImageView)this.b.findViewById(2131436420));
    this.a = new RedTouch(paramContext, this.b.findViewById(2131431302)).c(17).d(12).e(12).a();
  }
  
  void a(View paramView, LebaViewItem paramLebaViewItem)
  {
    if (paramView != null)
    {
      if (paramLebaViewItem == null) {
        return;
      }
      LebaDaTong.a(paramView, paramLebaViewItem);
      VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
    }
  }
  
  public void a(@NonNull LebaPluginsFeedViewHolder.BindDataParam paramBindDataParam)
  {
    LebaViewItem localLebaViewItem = paramBindDataParam.a;
    LebaPluginViewUtil.a(this.d, this.c, this.b, localLebaViewItem);
    b(paramBindDataParam);
    a(this.b, localLebaViewItem);
  }
  
  public void b(@NonNull LebaPluginsFeedViewHolder.BindDataParam paramBindDataParam)
  {
    LebaViewItem localLebaViewItem = paramBindDataParam.a;
    AppRuntime localAppRuntime = paramBindDataParam.b;
    Context localContext = paramBindDataParam.c;
    paramBindDataParam = paramBindDataParam.d;
    if (this.a == null) {
      return;
    }
    if ((localLebaViewItem != null) && (localLebaViewItem.b != null) && (paramBindDataParam != null) && (localLebaViewItem.h != 2))
    {
      UpdateRedTouchParam localUpdateRedTouchParam = new UpdateRedTouchParam();
      localUpdateRedTouchParam.a = localAppRuntime;
      localUpdateRedTouchParam.b = localContext;
      localUpdateRedTouchParam.c = this.a;
      localUpdateRedTouchParam.d = localLebaViewItem.a;
      localUpdateRedTouchParam.e = localLebaViewItem.b.strPkgName;
      localUpdateRedTouchParam.g = true;
      paramBindDataParam.a(localUpdateRedTouchParam);
      return;
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.feed.LebaPluginsFeedViewHolder
 * JD-Core Version:    0.7.0.1
 */