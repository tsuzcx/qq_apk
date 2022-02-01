package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.send.PanelData;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;

class HongBaoPanel$HongBaoAdapter
  extends RecyclerView.Adapter<HongBaoPanel.MyViewHolder>
{
  private List<PanelData> b = new ArrayList();
  private HongBaoPanel.OnHolderItemClickListener c;
  
  HongBaoPanel$HongBaoAdapter(HongBaoPanel paramHongBaoPanel) {}
  
  public HongBaoPanel.MyViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    HongBaoPanel localHongBaoPanel = this.a;
    return new HongBaoPanel.MyViewHolder(localHongBaoPanel, LayoutInflater.from(localHongBaoPanel.b).inflate(R.layout.c, paramViewGroup, false), this.c);
  }
  
  public PanelData a(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() > 0) && (this.b.size() > paramInt)) {
      return (PanelData)this.b.get(paramInt);
    }
    return null;
  }
  
  public List<PanelData> a()
  {
    return this.b;
  }
  
  public void a(HongBaoPanel.MyViewHolder paramMyViewHolder, int paramInt)
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      if (this.b.size() <= paramInt) {
        return;
      }
      localObject1 = (PanelData)this.b.get(paramInt);
      Object localObject2 = this.a;
      Object localObject3 = paramMyViewHolder.c;
      String str = ((PanelData)this.b.get(paramInt)).c;
      int i;
      if (HongBaoPanel.c(this.a).equals("#5B6175")) {
        i = this.a.b.getResources().getColor(R.color.j);
      } else {
        i = Color.parseColor(HongBaoPanel.c(this.a));
      }
      HongBaoPanel.a((HongBaoPanel)localObject2, (TextView)localObject3, str, i, 0);
      paramMyViewHolder.b.setImageResource(R.drawable.m);
      if (!StringUtil.isEmpty(((PanelData)localObject1).d))
      {
        paramMyViewHolder.b.setTag(((PanelData)localObject1).d);
        localObject2 = HongBaoPanel.a(this.a, paramInt, ((PanelData)localObject1).d, paramMyViewHolder.b);
        if ((localObject2 != null) && (((RedPacketInfo)localObject2).icon != null)) {
          paramMyViewHolder.b.setImageBitmap(((RedPacketInfo)localObject2).icon);
        }
      }
      if (this.a.k != null)
      {
        localObject1 = this.a.k.getShowInfo(((PanelData)localObject1).a);
        if (localObject1 != null)
        {
          localObject2 = paramMyViewHolder.e;
          if (((IQWalletRedService.ShowInfo)localObject1).a) {
            paramInt = 0;
          } else {
            paramInt = 8;
          }
          ((RelativeLayout)localObject2).setVisibility(paramInt);
          if (((IQWalletRedService.ShowInfo)localObject1).b)
          {
            paramMyViewHolder.d.setVisibility(0);
            try
            {
              localObject2 = new ColorDrawable(0);
              ((Drawable)localObject2).setAlpha(0);
              localObject3 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
              ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
              localObject1 = URLDrawable.getDrawable(((IQWalletRedService.ShowInfo)localObject1).c, (URLDrawable.URLDrawableOptions)localObject3);
              paramMyViewHolder.d.setImageDrawable((Drawable)localObject1);
              return;
            }
            catch (Throwable paramMyViewHolder)
            {
              paramMyViewHolder.printStackTrace();
              return;
            }
          }
          paramMyViewHolder.d.setVisibility(8);
        }
      }
    }
  }
  
  public void a(HongBaoPanel.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    this.c = paramOnHolderItemClickListener;
  }
  
  public void a(List<PanelData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      this.b.clear();
      this.b.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel.HongBaoAdapter
 * JD-Core Version:    0.7.0.1
 */