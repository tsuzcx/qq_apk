package com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.DiscoverGuildBean;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverDataCenter;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBaseBuilder;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.List;

public class QQGuildDiscoverSubTabCommonRvAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private Context a;
  private AppInterface b;
  private ArrayList<DiscoverGuildBean> c = new ArrayList();
  private QQGuildDiscoverSubTabCommonRvAdapter.QQGuildDiscoverRvItemListener d;
  private View e;
  
  public QQGuildDiscoverSubTabCommonRvAdapter(Context paramContext, AppInterface paramAppInterface)
  {
    this.a = paramContext;
    this.b = paramAppInterface;
  }
  
  private void a(QQGuildDiscoverSubTabCommonRvAdapter.SubTabCommonRvViewHolder paramSubTabCommonRvViewHolder, int paramInt)
  {
    int j = ViewUtils.dip2px(5.5F);
    int i = ViewUtils.dip2px(14.0F);
    int k;
    int m;
    if (paramInt % 2 == 0)
    {
      k = j;
      m = i;
    }
    else
    {
      m = j;
      k = i;
    }
    int n = getItemCount();
    int i1 = n - 2;
    int i2 = n % 2;
    if (paramInt >= i1 - i2) {
      n = i;
    } else {
      n = j;
    }
    if ((i2 != 0) || (paramInt != i1)) {
      i = k;
    }
    paramSubTabCommonRvViewHolder.e.setPadding(m, j, i, n);
  }
  
  public void a()
  {
    TextView localTextView = new TextView(this.a);
    localTextView.setText(this.a.getResources().getString(2131890490));
    localTextView.setHeight(0);
    localTextView.setGravity(17);
    localTextView.setTextColor(-3355444);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.e = localTextView;
    notifyItemInserted(getItemCount() - 1);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      ((TextView)this.e).setHeight(ViewUtils.dip2px(50.0F));
      return;
    }
    ((TextView)this.e).setHeight(0);
  }
  
  public void a(QQGuildDiscoverSubTabCommonRvAdapter.QQGuildDiscoverRvItemListener paramQQGuildDiscoverRvItemListener)
  {
    this.d = paramQQGuildDiscoverRvItemListener;
  }
  
  public void a(List<DiscoverGuildBean> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.c.clear();
      this.c.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.e == null) {
      return this.c.size();
    }
    return this.c.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      return 2;
    }
    return 1;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      paramRecyclerView = (GridLayoutManager)paramRecyclerView;
      paramRecyclerView.setSpanSizeLookup(new QQGuildDiscoverSubTabCommonRvAdapter.1(this, paramRecyclerView));
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (getItemViewType(paramInt) != 2)
    {
      QQGuildDiscoverSubTabCommonRvAdapter.SubTabCommonRvViewHolder localSubTabCommonRvViewHolder = (QQGuildDiscoverSubTabCommonRvAdapter.SubTabCommonRvViewHolder)paramViewHolder;
      a(localSubTabCommonRvViewHolder, paramInt);
      DiscoverGuildBean localDiscoverGuildBean = (DiscoverGuildBean)this.c.get(paramInt);
      int i = paramInt % QQGuildDiscoverDataCenter.d.length;
      if (!TextUtils.isEmpty(localDiscoverGuildBean.c)) {
        localSubTabCommonRvViewHolder.b.setText(localDiscoverGuildBean.c);
      } else {
        localSubTabCommonRvViewHolder.b.setText("");
      }
      if (!TextUtils.isEmpty(localDiscoverGuildBean.d))
      {
        localSubTabCommonRvViewHolder.c.setText(localDiscoverGuildBean.d);
      }
      else
      {
        localDiscoverGuildBean.d = QQGuildDiscoverDataCenter.e[i];
        localSubTabCommonRvViewHolder.c.setText(QQGuildDiscoverDataCenter.e[i]);
      }
      localSubTabCommonRvViewHolder.a.setCornerRadiusAndMode(ViewUtils.dpToPx(8.0F), 3);
      Object localObject;
      if (!TextUtils.isEmpty(localDiscoverGuildBean.g))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ViewUtils.dip2px(140.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ViewUtils.dip2px(100.0F);
        localObject = URLDrawable.getDrawable(localDiscoverGuildBean.g, (URLDrawable.URLDrawableOptions)localObject);
        localSubTabCommonRvViewHolder.a.setImageDrawable((Drawable)localObject);
      }
      else
      {
        localDiscoverGuildBean.g = QQGuildDiscoverDataCenter.d[i];
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ViewUtils.dip2px(140.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ViewUtils.dip2px(100.0F);
        localObject = URLDrawable.getDrawable(localDiscoverGuildBean.g, (URLDrawable.URLDrawableOptions)localObject);
        localSubTabCommonRvViewHolder.a.setImageDrawable((Drawable)localObject);
      }
      localSubTabCommonRvViewHolder.d.setVisibility(4);
      if (!TextUtils.isEmpty(localDiscoverGuildBean.f))
      {
        localObject = ((IQQGuildAvatarApi)this.b.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(localDiscoverGuildBean.f, GuildListItemBaseBuilder.a, GuildListItemBaseBuilder.a, "guild_avatar_cache_key_suffix");
        localSubTabCommonRvViewHolder.d.setImageDrawable((Drawable)localObject);
      }
      localSubTabCommonRvViewHolder.itemView.setTag(localDiscoverGuildBean);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  @RequiresApi(api=21)
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.e;
    if ((paramViewGroup != null) && (paramInt == 2)) {
      return new QQGuildDiscoverSubTabCommonRvAdapter.FooterViewHolder(this, paramViewGroup);
    }
    return new QQGuildDiscoverSubTabCommonRvAdapter.SubTabCommonRvViewHolder(this, LayoutInflater.from(this.a).inflate(2131625003, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.adapter.QQGuildDiscoverSubTabCommonRvAdapter
 * JD-Core Version:    0.7.0.1
 */