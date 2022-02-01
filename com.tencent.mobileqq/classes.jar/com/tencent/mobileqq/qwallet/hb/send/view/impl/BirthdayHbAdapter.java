package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import java.util.ArrayList;
import java.util.List;

public class BirthdayHbAdapter
  extends RecyclerView.Adapter<BirthdayHbAdapter.MyViewHolder>
{
  private static List<BirthdayHbAdapter.DataInfo> a = new ArrayList();
  private BirthdayHbAdapter.CallBack b;
  private int c = -1;
  
  public BirthdayHbAdapter(List<BirthdayHbAdapter.DataInfo> paramList, BirthdayHbAdapter.CallBack paramCallBack)
  {
    a = paramList;
    this.b = paramCallBack;
  }
  
  public BirthdayHbAdapter.MyViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new BirthdayHbAdapter.MyViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.j, paramViewGroup, false));
  }
  
  public void a(BirthdayHbAdapter.MyViewHolder paramMyViewHolder, int paramInt)
  {
    Object localObject = paramMyViewHolder.itemView;
    boolean bool;
    if (this.c == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    ((View)localObject).setSelected(bool);
    paramMyViewHolder.itemView.setVisibility(0);
    localObject = (BirthdayHbAdapter.DataInfo)a.get(paramInt);
    if (((BirthdayHbAdapter.DataInfo)localObject).a())
    {
      paramMyViewHolder.a.setTextColor(Color.parseColor("#FFFFFBEB"));
      paramMyViewHolder.b.setTextColor(Color.parseColor("#A3FFFBEB"));
    }
    else
    {
      paramMyViewHolder.a.setTextColor(Color.parseColor("#FF3367"));
      paramMyViewHolder.b.setTextColor(Color.parseColor("#C5B88E"));
    }
    paramMyViewHolder.itemView.setSelected(((BirthdayHbAdapter.DataInfo)localObject).a());
    paramMyViewHolder.a.setText(((BirthdayHbAdapter.DataInfo)localObject).b());
    paramMyViewHolder.b.setText(((BirthdayHbAdapter.DataInfo)localObject).c());
    paramMyViewHolder.itemView.setOnClickListener(new BirthdayHbAdapter.1(this, (BirthdayHbAdapter.DataInfo)localObject));
  }
  
  public int getItemCount()
  {
    return a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.BirthdayHbAdapter
 * JD-Core Version:    0.7.0.1
 */