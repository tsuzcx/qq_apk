package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemViewHolder
{
  public int a;
  public TroopCateListProvider.TroopCateInfo b;
  View c;
  ImageView d;
  View e;
  TextView f;
  TextView g;
  View h;
  public ViewGroup i;
  View.OnTouchListener j = new SingleItemViewHolder.1(this);
  
  public SingleItemViewHolder(View paramView, int paramInt)
  {
    this.c = paramView;
    this.a = paramInt;
    this.d = ((ImageView)paramView.findViewById(2131449017));
    this.f = ((TextView)paramView.findViewById(2131449020));
    this.g = ((TextView)paramView.findViewById(2131449016));
    this.h = paramView.findViewById(2131449018);
    this.e = paramView.findViewById(2131449021);
  }
  
  public void a(Context paramContext, TroopCateListProvider.TroopCateInfo paramTroopCateInfo, View.OnClickListener paramOnClickListener)
  {
    paramContext = this.i;
    if (paramContext != null) {
      paramContext.setVisibility(0);
    }
    this.g.setAlpha(1.0F);
    this.e.setTranslationY(0.0F);
    this.h.setRotation(0.0F);
    this.c.setTag(this);
    this.f.setText(paramTroopCateInfo.b);
    this.f.setContentDescription(paramTroopCateInfo.b);
    this.b = paramTroopCateInfo;
    if (paramTroopCateInfo.d != 0) {
      this.d.setImageResource(paramTroopCateInfo.d);
    } else if (paramTroopCateInfo.d != 0) {
      this.d.setImageResource(paramTroopCateInfo.d);
    }
    this.g.setVisibility(8);
    if (paramTroopCateInfo.h) {
      this.h.setVisibility(0);
    } else {
      this.h.setVisibility(8);
    }
    this.c.setOnTouchListener(this.j);
    this.c.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.SingleItemViewHolder
 * JD-Core Version:    0.7.0.1
 */