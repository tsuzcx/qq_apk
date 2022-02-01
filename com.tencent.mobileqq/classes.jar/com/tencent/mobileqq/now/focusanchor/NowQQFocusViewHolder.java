package com.tencent.mobileqq.now.focusanchor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.now.RecyclerHolder;
import com.tencent.mobileqq.now.focusanchor.commonwidget.RecyclerItemClickListener;
import com.tencent.mobileqq.now.widget.CircleImageView;
import com.tencent.mobileqq.now.widget.SpacesItemDecoration;

public class NowQQFocusViewHolder
  extends RecyclerHolder
{
  public CircleImageView a;
  public TextView b;
  public TextView c;
  public RecyclerView d;
  public View e;
  private long f;
  private final int g = 1000;
  
  public NowQQFocusViewHolder(View paramView)
  {
    super(paramView);
    this.a = ((CircleImageView)paramView.findViewById(2131429019));
    this.b = ((TextView)paramView.findViewById(2131448598));
    this.c = ((TextView)paramView.findViewById(2131448465));
    this.d = ((RecyclerView)paramView.findViewById(2131433500));
    this.e = paramView.findViewById(2131437404);
    int i;
    if (paramView.getContext() != null) {
      i = paramView.getContext().getResources().getDimensionPixelSize(2131299630);
    } else {
      i = -1;
    }
    if (i <= 0) {
      i = 25;
    }
    SpacesItemDecoration localSpacesItemDecoration = new SpacesItemDecoration(i);
    this.d.addItemDecoration(localSpacesItemDecoration);
    this.e.setOnClickListener(new NowQQFocusViewHolder.1(this));
    if ((paramView.getContext() instanceof Activity))
    {
      paramView = (Activity)paramView.getContext();
      this.d.addOnItemTouchListener(new RecyclerItemClickListener(paramView, new NowQQFocusViewHolder.2(this, paramView)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.NowQQFocusViewHolder
 * JD-Core Version:    0.7.0.1
 */