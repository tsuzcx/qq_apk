package com.tencent.mobileqq.guild.vas.adapter;

import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import java.util.List;
import mqq.util.WeakReference;

public class GiftListPageItemAdapter
  extends RecyclerView.Adapter
  implements View.OnClickListener
{
  public static int a;
  private static WeakReference<View> g;
  private List<giftList.GroupGiftItem> b;
  private int c;
  private int d;
  private GiftListPageItemAdapter.OnItemClickListener e;
  private int f = 8;
  private float h = 0.8F;
  private float i = 0.9F;
  private int j = 300;
  
  public GiftListPageItemAdapter(List<giftList.GroupGiftItem> paramList, int paramInt)
  {
    this.c = paramInt;
    this.b = paramList;
    this.d = (this.f * paramInt);
  }
  
  private void a(View paramView)
  {
    Object localObject1 = g;
    RelativeLayout localRelativeLayout1 = null;
    Object localObject2;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
    {
      localRelativeLayout1 = (RelativeLayout)((View)g.get()).findViewById(2131436927);
      localObject1 = (ImageView)((View)g.get()).findViewById(2131435563);
      localObject2 = (TextView)((View)g.get()).findViewById(2131447060);
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramView.findViewById(2131436927);
    ImageView localImageView = (ImageView)paramView.findViewById(2131435563);
    paramView = (TextView)paramView.findViewById(2131447060);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addListener(new GiftListPageItemAdapter.1(this, localRelativeLayout2, localImageView, paramView, localRelativeLayout1, (ImageView)localObject1, (TextView)localObject2));
    localValueAnimator.setDuration(this.j);
    localValueAnimator.addUpdateListener(new GiftListPageItemAdapter.2(this, localRelativeLayout2, localImageView, paramView, localRelativeLayout1, (ImageView)localObject1, (TextView)localObject2));
    localValueAnimator.start();
  }
  
  public void a(GiftListPageItemAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.e = paramOnItemClickListener;
  }
  
  public int getItemCount()
  {
    int k = this.b.size();
    int m = this.f;
    if (k / m > this.c) {
      return m;
    }
    return this.b.size() % this.f;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((GiftListPageItemAdapter.ViewHolder)paramViewHolder).a(this.d + paramInt);
  }
  
  public void onClick(View paramView) {}
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new GiftListPageItemAdapter.ViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628328, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.adapter.GiftListPageItemAdapter
 * JD-Core Version:    0.7.0.1
 */