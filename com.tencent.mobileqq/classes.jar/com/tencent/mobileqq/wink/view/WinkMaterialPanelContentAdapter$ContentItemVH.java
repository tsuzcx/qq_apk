package com.tencent.mobileqq.wink.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.tencent.mobileqq.wink.editor.view.WinkDownLoadingView;

public class WinkMaterialPanelContentAdapter$ContentItemVH
  extends RecyclerView.ViewHolder
{
  public CardView b;
  public ImageView c;
  public ImageView d;
  public ImageView e;
  public ImageView f;
  public WinkDownLoadingView g;
  public TextView h;
  
  public WinkMaterialPanelContentAdapter$ContentItemVH(View paramView)
  {
    super(paramView);
    this.b = ((CardView)paramView.findViewById(2131430319));
    this.c = ((ImageView)paramView.findViewById(2131436612));
    this.d = ((ImageView)paramView.findViewById(2131436566));
    this.e = ((ImageView)paramView.findViewById(2131436447));
    this.f = ((ImageView)paramView.findViewById(2131436353));
    this.g = ((WinkDownLoadingView)paramView.findViewById(2131440769));
    this.h = ((TextView)paramView.findViewById(2131448598));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.g.setBgCorner(paramInt3 / 2);
    this.g.setMinimumHeight(paramInt3);
    this.g.setMinimumWidth(paramInt3);
    this.g.setProgressSizeAndMode(paramInt1, paramInt2, false);
    this.g.setBgColor(0);
    this.g.setProgressColor(-1);
    this.g.a(false);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.f.getVisibility() != 0))
    {
      this.f.setVisibility(0);
      return;
    }
    if ((!paramBoolean) && (this.f.getVisibility() != 4)) {
      this.f.setVisibility(4);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.e.getVisibility() != 0)
      {
        this.e.setVisibility(0);
        this.g.setVisibility(0);
      }
      a(false);
    }
    else if (this.e.getVisibility() != 4)
    {
      this.e.setVisibility(4);
      this.g.setVisibility(4);
    }
    this.g.setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.WinkMaterialPanelContentAdapter.ContentItemVH
 * JD-Core Version:    0.7.0.1
 */