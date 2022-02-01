package com.tencent.mobileqq.hotpic;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class HotPicPageView$HotPicFooter
  implements HotPicFooterInterface
{
  int a = 1;
  HotPicPageView.HotPicAdapter b;
  public boolean c = false;
  
  public HotPicPageView$HotPicFooter(HotPicPageView paramHotPicPageView, HotPicPageView.HotPicAdapter paramHotPicAdapter)
  {
    this.b = paramHotPicAdapter;
  }
  
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    HotPicPageView localHotPicPageView = this.d;
    return new HotPicPageView.MyViewHolder(localHotPicPageView, LayoutInflater.from(localHotPicPageView.b).inflate(2131627959, paramViewGroup, false), null);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams1;
    if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(paramViewHolder.itemView.getLayoutParams())) {
      localLayoutParams1 = (StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
    } else {
      localLayoutParams1 = null;
    }
    StaggeredGridLayoutManager.LayoutParams localLayoutParams2 = localLayoutParams1;
    if (localLayoutParams1 == null)
    {
      localLayoutParams2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
      paramViewHolder.itemView.setLayoutParams(localLayoutParams2);
    }
    localLayoutParams2.setFullSpan(true);
    paramInt = this.d.l;
    if ((!this.c) && (paramInt != -20) && (this.a == 1))
    {
      HotPicManager.a(this.d.c).e(paramInt);
      this.c = true;
    }
    if (this.a == 1)
    {
      paramViewHolder.itemView.findViewById(2131435178).setVisibility(0);
      paramViewHolder.itemView.findViewById(2131435179).setVisibility(4);
      return;
    }
    if (HotPicPageView.p())
    {
      paramViewHolder.itemView.findViewById(2131435179).setVisibility(0);
      paramViewHolder.itemView.findViewById(2131435178).setVisibility(8);
      return;
    }
    ThreadManager.getUIHandler().post(new HotPicPageView.HotPicFooter.1(this, paramViewHolder));
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.HotPicFooter
 * JD-Core Version:    0.7.0.1
 */