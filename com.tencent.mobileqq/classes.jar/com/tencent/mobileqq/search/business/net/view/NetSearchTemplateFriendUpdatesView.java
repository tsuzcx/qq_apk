package com.tencent.mobileqq.search.business.net.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.SquareImageView;

public class NetSearchTemplateFriendUpdatesView
  extends NetSearchTemplateBaseView
{
  public URLImageView A;
  public TextView B;
  public URLImageView C;
  public TextView D;
  public int E;
  public ImageView a;
  public ImageView b;
  public TextView c;
  public LinearLayout d;
  public SquareImageView n;
  public ImageView o;
  public FrameLayout p;
  public RelativeLayout q;
  public LinearLayout y;
  public TextView z;
  
  public NetSearchTemplateFriendUpdatesView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    View localView = b(this.m);
    this.b = ((ImageView)localView.findViewById(2131431472));
    this.a = ((ImageView)localView.findViewById(2131435219));
    this.c = ((TextView)localView.findViewById(2131446828));
    this.d = ((LinearLayout)localView.findViewById(2131440280));
    this.p = ((FrameLayout)localView.findViewById(2131446037));
    this.n = ((SquareImageView)this.p.findViewById(2131435463));
    this.o = ((ImageView)this.p.findViewById(2131436849));
    this.E = this.d.getChildCount();
    this.y = ((LinearLayout)localView.findViewById(2131432273));
    this.q = ((RelativeLayout)localView.findViewById(2131432287));
    this.z = ((TextView)localView.findViewById(2131444205));
    this.A = ((URLImageView)localView.findViewById(2131450388));
    this.B = ((TextView)localView.findViewById(2131450390));
    this.C = ((URLImageView)localView.findViewById(2131431082));
    this.D = ((TextView)localView.findViewById(2131431117));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateFriendUpdatesView
 * JD-Core Version:    0.7.0.1
 */