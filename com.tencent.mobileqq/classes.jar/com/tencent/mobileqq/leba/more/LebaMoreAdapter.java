package com.tencent.mobileqq.leba.more;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.leba.business.LebaMoreVipBizProxy;
import com.tencent.mobileqq.leba.entity.LebaMoreViewItem;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.report.LebaDaTong;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.ThemeImageView;

public class LebaMoreAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  protected Drawable a;
  protected Drawable b;
  protected int c;
  protected int d;
  protected Context e;
  protected LebaMoreDataLogic f;
  protected GridLayoutManager g;
  protected LebaMoreAdapter.OnPluginClick h;
  protected boolean i;
  protected boolean j = false;
  protected LebaMoreVipBizProxy k;
  protected int l;
  
  public LebaMoreAdapter(Context paramContext, LebaMoreDataLogic paramLebaMoreDataLogic, boolean paramBoolean, LebaMoreAdapter.OnPluginClick paramOnPluginClick)
  {
    this.e = paramContext;
    this.a = paramContext.getResources().getDrawable(2130846957);
    this.b = paramContext.getResources().getDrawable(2130846952);
    this.c = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.d = ViewUtils.dip2px(24.0F);
    this.f = paramLebaMoreDataLogic;
    this.i = paramBoolean;
    this.h = paramOnPluginClick;
  }
  
  private void d(LebaMoreAdapter.PluginViewHolder paramPluginViewHolder, LebaMoreViewItem paramLebaMoreViewItem)
  {
    if (!paramLebaMoreViewItem.c.c()) {
      return;
    }
    if (paramLebaMoreViewItem.d)
    {
      this.f.a(this, paramLebaMoreViewItem, paramPluginViewHolder);
      return;
    }
    this.f.b(this, paramLebaMoreViewItem, paramPluginViewHolder);
  }
  
  private void e(LebaMoreAdapter.PluginViewHolder paramPluginViewHolder, LebaMoreViewItem paramLebaMoreViewItem)
  {
    if (!paramLebaMoreViewItem.i) {
      return;
    }
    if (paramLebaMoreViewItem.d)
    {
      this.f.a(this, paramLebaMoreViewItem, paramPluginViewHolder);
      return;
    }
    this.f.b(this, paramLebaMoreViewItem, paramPluginViewHolder);
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(GridLayoutManager paramGridLayoutManager)
  {
    this.g = paramGridLayoutManager;
  }
  
  public void a(LebaMoreVipBizProxy paramLebaMoreVipBizProxy)
  {
    this.k = paramLebaMoreVipBizProxy;
  }
  
  void a(LebaMoreAdapter.PluginViewHolder paramPluginViewHolder, LebaMoreViewItem paramLebaMoreViewItem)
  {
    if (paramPluginViewHolder != null)
    {
      if (paramPluginViewHolder.itemView == null) {
        return;
      }
      if ((paramLebaMoreViewItem != null) && (paramLebaMoreViewItem.c != null))
      {
        if (paramLebaMoreViewItem.c.b == null) {
          return;
        }
        if (this.j)
        {
          VideoReport.setElementExposePolicy(paramPluginViewHolder.itemView, ExposurePolicy.REPORT_NONE);
          VideoReport.setElementClickPolicy(paramPluginViewHolder.itemView, ClickPolicy.REPORT_NONE);
          return;
        }
        if (paramLebaMoreViewItem.e)
        {
          if (paramLebaMoreViewItem.f == 1)
          {
            LebaDaTong.c(paramPluginViewHolder.itemView, "friendmomt");
            return;
          }
          if (paramLebaMoreViewItem.f == 2)
          {
            LebaDaTong.c(paramPluginViewHolder.itemView, "wezone");
            return;
          }
          LebaDaTong.c(paramPluginViewHolder.itemView, "default");
          return;
        }
        LebaDaTong.c(paramPluginViewHolder.itemView, paramLebaMoreViewItem.c.b.getDaTongID());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void b(LebaMoreAdapter.PluginViewHolder paramPluginViewHolder, LebaMoreViewItem paramLebaMoreViewItem)
  {
    if (paramLebaMoreViewItem.e)
    {
      c(paramPluginViewHolder, paramLebaMoreViewItem);
      return;
    }
    Object localObject = paramLebaMoreViewItem.c;
    String str1 = "";
    if ((localObject != null) && (paramLebaMoreViewItem.c.b != null))
    {
      paramPluginViewHolder.itemView.setEnabled(true);
      paramPluginViewHolder.itemView.setOnClickListener(new LebaMoreAdapter.1(this, paramPluginViewHolder, paramLebaMoreViewItem));
      if (!TextUtils.isEmpty(paramLebaMoreViewItem.c.b.strResName)) {
        str1 = paramLebaMoreViewItem.c.b.strResName;
      }
      if (!str1.equals(paramPluginViewHolder.b.getText().toString())) {
        paramPluginViewHolder.b.setText(str1);
      }
      if (this.l == 2) {
        localObject = this.b;
      } else {
        localObject = this.a;
      }
      String str2;
      if (this.l == 2) {
        str2 = paramLebaMoreViewItem.c.d();
      } else {
        str2 = paramLebaMoreViewItem.c.b.strResURL;
      }
      paramPluginViewHolder.a.setVisibility(0);
      if (TextUtils.isEmpty(str2))
      {
        paramPluginViewHolder.a.setImageDrawable((Drawable)localObject);
      }
      else
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int m = this.d;
        localURLDrawableOptions.mRequestWidth = m;
        localURLDrawableOptions.mRequestHeight = m;
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(str2, localURLDrawableOptions);
        ((URLDrawable)localObject).setTargetDensity(this.c);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        paramPluginViewHolder.a.setImageDrawable((Drawable)localObject);
      }
      if ((this.j) && (paramLebaMoreViewItem.c.c()))
      {
        paramPluginViewHolder.c.setVisibility(0);
        if (paramLebaMoreViewItem.d) {
          paramPluginViewHolder.c.setImageResource(2130852441);
        } else {
          paramPluginViewHolder.c.setImageResource(2130852439);
        }
      }
      else
      {
        paramPluginViewHolder.c.setVisibility(8);
      }
      paramPluginViewHolder.c.setOnClickListener(new LebaMoreAdapter.2(this, paramPluginViewHolder, paramLebaMoreViewItem));
      if (AppSetting.e) {
        AccessibilityUtil.a(paramPluginViewHolder.itemView, str1, Button.class.getName());
      }
      return;
    }
    paramPluginViewHolder.itemView.setEnabled(false);
    paramPluginViewHolder.itemView.setOnClickListener(null);
    paramPluginViewHolder.b.setText("");
    paramPluginViewHolder.a.setVisibility(8);
    paramPluginViewHolder.c.setVisibility(8);
    if (AppSetting.e) {
      AccessibilityUtil.a(paramPluginViewHolder.itemView, "", Button.class.getName());
    }
  }
  
  public void c(LebaMoreAdapter.PluginViewHolder paramPluginViewHolder, LebaMoreViewItem paramLebaMoreViewItem)
  {
    String str = paramLebaMoreViewItem.h;
    paramPluginViewHolder.b.setText(str);
    paramPluginViewHolder.a.setVisibility(0);
    paramPluginViewHolder.a.setImageResource(paramLebaMoreViewItem.g);
    if ((paramLebaMoreViewItem.i) && (this.j))
    {
      paramPluginViewHolder.c.setVisibility(0);
      if (paramLebaMoreViewItem.d) {
        paramPluginViewHolder.c.setImageResource(2130852441);
      } else {
        paramPluginViewHolder.c.setImageResource(2130852439);
      }
    }
    else
    {
      paramPluginViewHolder.c.setVisibility(8);
    }
    paramPluginViewHolder.c.setOnClickListener(new LebaMoreAdapter.3(this, paramPluginViewHolder, paramLebaMoreViewItem));
    paramPluginViewHolder.itemView.setEnabled(true);
    paramPluginViewHolder.itemView.setOnClickListener(new LebaMoreAdapter.4(this, paramPluginViewHolder, paramLebaMoreViewItem));
    if (AppSetting.e) {
      AccessibilityUtil.a(paramPluginViewHolder.itemView, str, Button.class.getName());
    }
  }
  
  public int getItemCount()
  {
    return this.f.a();
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.f.a(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    LebaMoreViewItem localLebaMoreViewItem = this.f.b(paramInt);
    if (localLebaMoreViewItem != null) {
      if ((paramViewHolder instanceof LebaMoreAdapter.TitleViewHolder))
      {
        ((LebaMoreAdapter.TitleViewHolder)paramViewHolder).a(localLebaMoreViewItem);
      }
      else if ((paramViewHolder instanceof LebaMoreAdapter.PluginViewHolder))
      {
        LebaMoreAdapter.PluginViewHolder localPluginViewHolder = (LebaMoreAdapter.PluginViewHolder)paramViewHolder;
        b(localPluginViewHolder, localLebaMoreViewItem);
        a(localPluginViewHolder, localLebaMoreViewItem);
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1)
    {
      paramViewGroup = LayoutInflater.from(this.e).inflate(2131627498, paramViewGroup, false);
      return new LebaMoreAdapter.TitleViewHolder(this.e, paramViewGroup, this.i);
    }
    if (paramInt == 2) {
      return new LebaMoreAdapter.PluginViewHolder(LayoutInflater.from(this.e).inflate(2131627497, paramViewGroup, false), this.e, this.l, this.i);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreAdapter
 * JD-Core Version:    0.7.0.1
 */