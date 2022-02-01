package com.tencent.mobileqq.winkpublish.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PublishBubblePopupView
  extends RelativePopupWindow
  implements View.OnClickListener
{
  private LayoutInflater a;
  private View b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private TextView h;
  
  public PublishBubblePopupView(Context paramContext)
  {
    super(paramContext);
    this.a = LayoutInflater.from(paramContext);
    a(2131627212);
    setOutsideTouchable(true);
    setFocusable(true);
    setTouchable(true);
  }
  
  public void a(int paramInt)
  {
    this.b = this.a.inflate(paramInt, null);
    this.c = ((ImageView)this.b.findViewById(2131427878));
    this.e = ((ImageView)this.b.findViewById(2131427882));
    this.d = ((ImageView)this.b.findViewById(2131427881));
    this.f = ((ImageView)this.b.findViewById(2131427879));
    this.g = ((ImageView)this.b.findViewById(2131427880));
    this.h = ((TextView)this.b.findViewById(2131427875));
    setBackgroundDrawable(new ColorDrawable(0));
    this.b.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.b.setOnClickListener(this);
    super.setContentView(this.b);
  }
  
  public void a(String paramString)
  {
    this.h.setText(paramString);
  }
  
  public void b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                this.d.setVisibility(8);
                this.c.setVisibility(8);
                this.e.setVisibility(8);
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                return;
              }
              this.e.setVisibility(0);
              this.c.setVisibility(8);
              this.d.setVisibility(8);
              this.f.setVisibility(8);
              this.g.setVisibility(8);
              RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
              localLayoutParams.addRule(14, -1);
              localLayoutParams.addRule(7, 0);
              this.e.setLayoutParams(localLayoutParams);
              return;
            }
            this.f.setVisibility(0);
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            this.e.setVisibility(8);
            this.g.setVisibility(8);
            return;
          }
          this.g.setVisibility(0);
          this.d.setVisibility(8);
          this.c.setVisibility(8);
          this.e.setVisibility(8);
          this.f.setVisibility(8);
          return;
        }
        this.e.setVisibility(0);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        return;
      }
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.g.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.PublishBubblePopupView
 * JD-Core Version:    0.7.0.1
 */