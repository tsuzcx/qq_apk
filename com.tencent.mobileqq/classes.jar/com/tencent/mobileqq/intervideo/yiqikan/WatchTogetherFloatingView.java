package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;

public class WatchTogetherFloatingView
  extends FrameLayout
{
  private ViewGroup a;
  private TouchWebView b;
  private RelativeLayout c;
  private TextView d;
  private LinearLayout e;
  private ImageView f;
  private int g = 0;
  private WatchTogetherFloatingView.UIHandle h = new WatchTogetherFloatingView.UIHandle(this);
  
  public WatchTogetherFloatingView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void b()
  {
    this.a = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131627291, this, true));
    this.c = ((RelativeLayout)this.a.findViewById(2131444946));
    this.d = ((TextView)this.a.findViewById(2131448570));
    this.e = ((LinearLayout)this.a.findViewById(2131437489));
    this.f = ((ImageView)this.a.findViewById(2131436552));
  }
  
  private void c()
  {
    if ((getParent() instanceof FrameLayout))
    {
      View localView = ((FrameLayout)getParent().getParent()).findViewById(2131442576);
      if (localView != null)
      {
        String str = getContext().getString(2131897471);
        int i = this.g;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2) {
              str = getContext().getString(2131897468);
            }
          }
          else {
            str = getContext().getString(2131897471);
          }
        }
        else {
          str = getContext().getString(2131897469);
        }
        localView.setContentDescription(str);
      }
    }
  }
  
  public void a()
  {
    this.h.sendEmptyMessage(3);
    this.c.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.g = 2;
    c();
    TouchWebView localTouchWebView = this.b;
    if (localTouchWebView != null) {
      localTouchWebView.loadUrl("about:blank");
    }
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    if (this.a != null)
    {
      if (paramTouchWebView == null) {
        return;
      }
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = ((TouchWebView)localObject).getParent();
        ViewGroup localViewGroup = this.a;
        if (localObject == localViewGroup) {
          localViewGroup.removeView(this.b);
        }
      }
      paramTouchWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.a.addView(paramTouchWebView, 0);
      this.b = paramTouchWebView;
    }
  }
  
  public void a(String paramString)
  {
    a(true);
    TouchWebView localTouchWebView = this.b;
    if (localTouchWebView != null)
    {
      localTouchWebView.loadUrl("about:blank");
      this.b.loadUrl(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h.sendEmptyMessage(1);
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.g = 0;
    }
    else
    {
      this.h.sendEmptyMessage(3);
      this.d.setVisibility(8);
      this.c.setVisibility(8);
      this.e.setVisibility(8);
      this.g = 1;
    }
    c();
  }
  
  public int getLoadingState()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView
 * JD-Core Version:    0.7.0.1
 */