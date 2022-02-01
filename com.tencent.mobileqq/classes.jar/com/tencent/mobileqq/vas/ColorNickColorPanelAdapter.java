package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ColorNickColorPanelAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public ColorNickColorPanelAdapter.PureColorAdapter a;
  public Drawable b;
  private ArrayList<ColorNickColorPanelAdapter.ColorItem> c = new ArrayList();
  private LayoutInflater d;
  private int e = -1;
  private ColorNickColorPanelAdapter.OnColorSelectListener f;
  private int g;
  
  public ColorNickColorPanelAdapter(Context paramContext, ColorNickColorPanelAdapter.OnColorSelectListener paramOnColorSelectListener)
  {
    this.d = LayoutInflater.from(paramContext);
    this.f = paramOnColorSelectListener;
    this.a = new ColorNickColorPanelAdapter.PureColorAdapter();
    this.b = paramContext.getResources().getDrawable(2130848961);
    this.g = DisplayUtil.a(paramContext, 2.0F);
  }
  
  public void a(int paramInt)
  {
    int i = this.e;
    this.e = paramInt;
    if (i > 0) {
      notifyItemChanged(i);
    }
    i = this.e;
    if (i > 0) {
      notifyItemChanged(i);
    }
    if (paramInt > 0) {
      this.a.a(-1);
    }
  }
  
  public void a(List<ColorNickColorPanelAdapter.ColorItem> paramList, boolean paramBoolean)
  {
    this.c.clear();
    this.c.addAll(paramList);
    if (paramBoolean) {
      this.c.add(new ColorNickColorPanelAdapter.ColorItem(4, null, 0, null));
    }
    notifyDataSetChanged();
  }
  
  public ColorNickColorPanelAdapter.ColorItem b(int paramInt)
  {
    return (ColorNickColorPanelAdapter.ColorItem)this.c.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
  
  public long getItemId(int paramInt)
  {
    ColorNickColorPanelAdapter.ColorItem localColorItem = (ColorNickColorPanelAdapter.ColorItem)this.c.get(paramInt);
    if (localColorItem.a == 3) {
      return localColorItem.d;
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ColorNickColorPanelAdapter.ColorItem)this.c.get(paramInt)).a;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new ColorNickColorPanelAdapter.1(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (ColorNickColorPanelAdapter.ColorItem)this.c.get(paramInt);
    int i = ((ColorNickColorPanelAdapter.ColorItem)localObject1).a;
    Object localObject2;
    if (i != 1)
    {
      if ((i == 3) && ((paramViewHolder instanceof ColorNickColorPanelAdapter.GradientViewHolder)))
      {
        localObject2 = (ColorNickColorPanelAdapter.GradientViewHolder)paramViewHolder;
        ((ColorNickColorPanelAdapter.GradientViewHolder)localObject2).a = paramInt;
        Object localObject3 = (GridLayoutManager.LayoutParams)((ColorNickColorPanelAdapter.GradientViewHolder)localObject2).itemView.getLayoutParams();
        if (paramInt % 3 == 0) {
          ((GridLayoutManager.LayoutParams)localObject3).rightMargin = 0;
        } else {
          ((GridLayoutManager.LayoutParams)localObject3).rightMargin = this.g;
        }
        if (paramInt == this.e) {
          ((ColorNickColorPanelAdapter.GradientViewHolder)localObject2).c.setVisibility(0);
        } else {
          ((ColorNickColorPanelAdapter.GradientViewHolder)localObject2).c.setVisibility(8);
        }
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = this.b;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = localDrawable;
        localObject1 = URLDrawable.getDrawable(((ColorNickColorPanelAdapter.ColorItem)localObject1).c, (URLDrawable.URLDrawableOptions)localObject3);
        ((ColorNickColorPanelAdapter.GradientViewHolder)localObject2).b.setImageDrawable((Drawable)localObject1);
      }
    }
    else if ((paramViewHolder instanceof ColorNickColorPanelAdapter.TitleViewHolder))
    {
      localObject2 = (ColorNickColorPanelAdapter.TitleViewHolder)paramViewHolder;
      if (((ColorNickColorPanelAdapter.TitleViewHolder)localObject2).b == 1) {
        ((ColorNickColorPanelAdapter.TitleViewHolder)localObject2).a.setText(((ColorNickColorPanelAdapter.ColorItem)localObject1).b);
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return null;
          }
          return new ColorNickColorPanelAdapter.TitleViewHolder(this.d.inflate(2131628296, paramViewGroup, false), 4);
        }
        return new ColorNickColorPanelAdapter.GradientViewHolder(this.d.inflate(2131628298, paramViewGroup, false), this, this.f);
      }
      return new ColorNickColorPanelAdapter.PureColorViewHolder(this.d.inflate(2131628300, paramViewGroup, false), this.f, this.a, this);
    }
    return new ColorNickColorPanelAdapter.TitleViewHolder(this.d.inflate(2131628297, paramViewGroup, false), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickColorPanelAdapter
 * JD-Core Version:    0.7.0.1
 */