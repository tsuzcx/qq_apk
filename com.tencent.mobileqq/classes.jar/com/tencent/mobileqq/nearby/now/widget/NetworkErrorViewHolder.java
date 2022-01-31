package com.tencent.mobileqq.nearby.now.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NetworkErrorViewHolder
  extends CommonViewHolder
{
  public NetworkErrorViewHolder(View paramView)
  {
    super(paramView);
  }
  
  public static NetworkErrorViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new NetworkErrorViewHolder(LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.NetworkErrorViewHolder
 * JD-Core Version:    0.7.0.1
 */