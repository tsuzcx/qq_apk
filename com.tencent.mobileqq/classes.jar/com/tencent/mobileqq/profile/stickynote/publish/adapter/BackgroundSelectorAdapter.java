package com.tencent.mobileqq.profile.stickynote.publish.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.profile.stickynote.publish.bean.BackgroundSelectBean;
import com.tencent.mobileqq.widget.RoundedImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class BackgroundSelectorAdapter
  extends RecyclerView.Adapter<BackgroundSelectorAdapter.BackgroundSelectorViewHolder>
{
  private Context a;
  private LayoutInflater b;
  private List<BackgroundSelectBean> c;
  private BackgroundSelectorAdapter.OnSelectListener d;
  private int e;
  
  public BackgroundSelectorAdapter(List<BackgroundSelectBean> paramList, Context paramContext, BackgroundSelectorAdapter.OnSelectListener paramOnSelectListener)
  {
    this.c = paramList;
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.d = paramOnSelectListener;
  }
  
  public BackgroundSelectorAdapter.BackgroundSelectorViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new BackgroundSelectorAdapter.BackgroundSelectorViewHolder(this, this.b.inflate(2131627736, paramViewGroup, false));
  }
  
  public void a(BackgroundSelectorAdapter.BackgroundSelectorViewHolder paramBackgroundSelectorViewHolder, int paramInt)
  {
    Object localObject = this.c;
    if ((localObject != null) && (((List)localObject).size() > paramInt) && (((BackgroundSelectBean)this.c.get(paramInt)).c != null) && (paramBackgroundSelectorViewHolder != null) && (paramBackgroundSelectorViewHolder.b != null))
    {
      paramBackgroundSelectorViewHolder.a = ((BackgroundSelectBean)this.c.get(paramInt)).b;
      paramBackgroundSelectorViewHolder.b.setBackground(((BackgroundSelectBean)this.c.get(paramInt)).c.getConstantState().newDrawable());
      if (paramBackgroundSelectorViewHolder.a)
      {
        this.e = paramInt;
        paramBackgroundSelectorViewHolder.b.setBorderWidth(AIOUtils.b(4.0F, this.a.getResources()));
        paramBackgroundSelectorViewHolder.b.setCornerRadius(AIOUtils.b(2.0F, this.a.getResources()));
        localObject = this.d;
        if (localObject != null) {
          ((BackgroundSelectorAdapter.OnSelectListener)localObject).a((BackgroundSelectBean)this.c.get(paramInt));
        }
      }
      else
      {
        paramBackgroundSelectorViewHolder.b.setBorderWidth(AIOUtils.b(2.0F, this.a.getResources()));
        paramBackgroundSelectorViewHolder.b.setCornerRadius(AIOUtils.b(2.0F, this.a.getResources()));
      }
      a(paramBackgroundSelectorViewHolder.b, paramBackgroundSelectorViewHolder.a);
      paramBackgroundSelectorViewHolder.b.setOnClickListener(new BackgroundSelectorAdapter.1(this, paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramBackgroundSelectorViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(RoundedImageView paramRoundedImageView, boolean paramBoolean)
  {
    if (paramRoundedImageView != null)
    {
      paramRoundedImageView = (ViewGroup.MarginLayoutParams)paramRoundedImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramRoundedImageView.height = AIOUtils.b(28.0F, this.a.getResources());
        paramRoundedImageView.width = AIOUtils.b(28.0F, this.a.getResources());
        paramRoundedImageView.setMargins(AIOUtils.b(20.0F, this.a.getResources()), AIOUtils.b(6.0F, this.a.getResources()), AIOUtils.b(6.0F, this.a.getResources()), AIOUtils.b(6.0F, this.a.getResources()));
        return;
      }
      paramRoundedImageView.height = AIOUtils.b(24.0F, this.a.getResources());
      paramRoundedImageView.width = AIOUtils.b(24.0F, this.a.getResources());
      paramRoundedImageView.setMargins(AIOUtils.b(22.0F, this.a.getResources()), AIOUtils.b(8.0F, this.a.getResources()), AIOUtils.b(8.0F, this.a.getResources()), AIOUtils.b(8.0F, this.a.getResources()));
    }
  }
  
  public int getItemCount()
  {
    List localList = this.c;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.adapter.BackgroundSelectorAdapter
 * JD-Core Version:    0.7.0.1
 */