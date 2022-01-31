package com.tencent.richmediabrowser.view.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.richmediabrowser.view.BrowserBaseScene;

public class GalleryPageView
  extends AbstractGalleryPageView
{
  Runnable fadeTask = new GalleryPageView.3(this);
  private boolean firstTimeShowPage = true;
  AlphaAnimation hideAnimation = new AlphaAnimation(1.0F, 0.0F);
  public int pageBottomMargin = 3;
  BrowserBaseScene scene;
  AlphaAnimation showAnimation = new AlphaAnimation(0.0F, 1.0F);
  TextView textView;
  
  public void clean()
  {
    if (this.showAnimation != null) {
      this.showAnimation.setAnimationListener(null);
    }
    if (this.hideAnimation != null) {
      this.hideAnimation.setAnimationListener(null);
    }
    if (this.textView != null) {
      this.textView.clearAnimation();
    }
  }
  
  public void init(Context paramContext, BrowserBaseScene paramBrowserBaseScene, int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBrowserBaseScene.getRootView();
    this.textView = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, this.pageBottomMargin, paramContext.getResources().getDisplayMetrics()) + paramInt);
    this.textView.setTextColor(Color.parseColor("#e6e9e9e9"));
    this.textView.setTextSize(2, 15.0F);
    localRelativeLayout.addView(this.textView, localLayoutParams);
    this.textView.setVisibility(4);
    this.showAnimation.setDuration(300L);
    this.hideAnimation.setDuration(300L);
    this.scene = paramBrowserBaseScene;
    this.showAnimation.setAnimationListener(new GalleryPageView.1(this));
    this.hideAnimation.setAnimationListener(new GalleryPageView.2(this));
  }
  
  public void setVisibility(int paramInt)
  {
    this.textView.setVisibility(paramInt);
  }
  
  public void startPageAnimation(AdapterView paramAdapterView, int paramInt)
  {
    if (paramAdapterView.getCount() > 1)
    {
      this.textView.setText(paramInt + 1 + "/" + paramAdapterView.getCount());
      if (this.textView.getVisibility() == 4)
      {
        this.textView.setVisibility(0);
        this.textView.startAnimation(this.showAnimation);
        if (this.firstTimeShowPage)
        {
          this.textView.postDelayed(this.fadeTask, 3000L);
          this.firstTimeShowPage = false;
          return;
        }
        this.textView.postDelayed(this.fadeTask, 2000L);
        return;
      }
      this.textView.removeCallbacks(this.fadeTask);
      this.textView.clearAnimation();
      this.textView.postDelayed(this.fadeTask, 2000L);
      return;
    }
    this.textView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.GalleryPageView
 * JD-Core Version:    0.7.0.1
 */