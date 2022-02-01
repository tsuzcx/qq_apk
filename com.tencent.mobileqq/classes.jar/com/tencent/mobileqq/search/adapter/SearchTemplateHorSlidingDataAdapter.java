package com.tencent.mobileqq.search.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem.ImageInfo;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalOneView;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalOneItem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class SearchTemplateHorSlidingDataAdapter
  extends BaseAdapter
{
  public static final String a = "SearchTemplateHorSlidingDataAdapter";
  public List<NetSearchTemplateHorizontalBaseItem> b;
  public NetSearchTemplateHorSlidingContainerItem c;
  public int d;
  public HorizontalListView e;
  public float f;
  public long g;
  public float h;
  public int i = 0;
  
  public SearchTemplateHorSlidingDataAdapter(NetSearchTemplateHorSlidingContainerItem paramNetSearchTemplateHorSlidingContainerItem, int paramInt, HorizontalListView paramHorizontalListView)
  {
    this.c = paramNetSearchTemplateHorSlidingContainerItem;
    this.d = paramInt;
    this.e = paramHorizontalListView;
    paramHorizontalListView.setOnScrollListener(new SearchTemplateHorSlidingDataAdapter.1(this, paramHorizontalListView));
  }
  
  public NetSearchTemplateHorizontalBaseItem a(int paramInt)
  {
    return (NetSearchTemplateHorizontalBaseItem)this.b.get(paramInt);
  }
  
  public List<NetSearchTemplateHorizontalBaseItem> a()
  {
    return this.b;
  }
  
  public void a(List<NetSearchTemplateHorizontalBaseItem> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    if (TextUtils.isEmpty(this.c.u)) {
      return this.b.size();
    }
    return this.b.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == this.b.size()) && (!TextUtils.isEmpty(this.c.u))) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = getItemViewType(paramInt);
    View localView;
    Object localObject1;
    Object localObject2;
    if (j != 1)
    {
      if (j == 2)
      {
        localView = paramView;
        if (paramView == null) {
          localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625868, paramViewGroup, false);
        }
        localObject1 = new FrameLayout.LayoutParams(-1, (int)this.h);
        ((FrameLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(paramViewGroup.getContext(), 6.0F);
        paramView = (LinearLayout)localView.findViewById(2131431280);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (ImageView)localView.findViewById(2131438863);
        localObject2 = (TextView)localView.findViewById(2131438890);
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
        {
          paramView.setBackgroundResource(2130839569);
          ((TextView)localObject2).setTextColor(Color.parseColor("#4A4A4A"));
          ((ImageView)localObject1).setImageResource(2130843382);
        }
        else
        {
          paramView.setBackgroundResource(2130839568);
          ((TextView)localObject2).setTextColor(Color.parseColor("#737373"));
          ((ImageView)localObject1).setImageResource(2130843381);
        }
        ((TextView)localObject2).setText(this.c.t);
        localView.setOnClickListener(new SearchTemplateHorSlidingDataAdapter.2(this, paramViewGroup));
        paramView = localView;
      }
    }
    else
    {
      localObject2 = (NetSearchTemplateHorizontalOneItem)this.b.get(paramInt);
      ((NetSearchTemplateHorizontalOneItem)localObject2).b(this.c.f);
      if (paramView == null)
      {
        paramView = new NetSearchTemplateHorizontalOneView(paramViewGroup, 0);
        localView = paramView.h();
        localView.setTag(paramView);
        localObject1 = paramView;
        paramView = localView;
      }
      else
      {
        localObject1 = (NetSearchTemplateHorizontalOneView)paramView.getTag();
      }
      float f1 = this.c.f;
      f1 = (float)(DeviceInfoUtil.F() - DisplayUtil.a(paramView.getContext(), 13.5F)) / (f1 + 0.5F);
      if ((this.c.f == 5) || (this.c.f == 6))
      {
        f1 = (float)((DeviceInfoUtil.F() - DisplayUtil.a(paramView.getContext(), 32.0F)) / 3L);
        this.e.setDividerWidth(10);
      }
      this.f = (DisplayUtil.a(this.e.getContext(), 3.0F) + f1);
      switch (((NetSearchTemplateHorizontalOneItem)localObject2).q.a)
      {
      default: 
        this.h = (136.0F * f1 / 220.0F);
        break;
      case 11: 
        this.h = f1;
        break;
      case 10: 
        this.h = (228.0F * f1 / 162.0F);
        break;
      case 9: 
        this.h = f1;
        break;
      case 8: 
        this.h = (136.0F * f1 / 220.0F);
      }
      ((NetSearchTemplateHorizontalOneView)localObject1).h().setLayoutParams(new LinearLayout.LayoutParams((int)f1, -2));
      ((NetSearchTemplateHorizontalOneItem)localObject2).a((NetSearchTemplateHorizontalBaseView)localObject1);
      ((NetSearchTemplateHorizontalOneItem)localObject2).e(this.c.ah);
      ((NetSearchTemplateHorizontalOneView)localObject1).h().measure(1073741824, 0);
      this.i = Math.max(((NetSearchTemplateHorizontalOneView)localObject1).h().getMeasuredHeight(), this.i);
      this.e.getLayoutParams().height = this.i;
      this.g = ((NetSearchTemplateHorizontalOneItem)localObject2).i;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.SearchTemplateHorSlidingDataAdapter
 * JD-Core Version:    0.7.0.1
 */