package com.tencent.mobileqq.guild.vas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

class GiftListPageAdapter$ViewHolder
{
  private View b;
  private RecyclerView c;
  
  public GiftListPageAdapter$ViewHolder(GiftListPageAdapter paramGiftListPageAdapter, @NonNull ViewGroup paramViewGroup)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628327, null, false);
    this.c = ((RecyclerView)this.b.findViewById(2131434259));
    paramGiftListPageAdapter = new GiftListPageAdapter.ViewHolder.1(this, paramViewGroup.getContext(), GiftListPageAdapter.a(paramGiftListPageAdapter), paramGiftListPageAdapter);
    this.c.setLayoutManager(paramGiftListPageAdapter);
  }
  
  public void a(int paramInt)
  {
    if (this.c != null)
    {
      GiftListPageItemAdapter localGiftListPageItemAdapter = new GiftListPageItemAdapter(GiftListPageAdapter.b(this.a), paramInt);
      localGiftListPageItemAdapter.a(new GiftListPageAdapter.ViewHolder.2(this));
      this.c.setAdapter(localGiftListPageItemAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.adapter.GiftListPageAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */