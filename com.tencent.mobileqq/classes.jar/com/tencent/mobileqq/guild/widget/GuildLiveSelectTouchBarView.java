package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.SelectTouchBarView;

public class GuildLiveSelectTouchBarView
  extends SelectTouchBarView
{
  public GuildLiveSelectTouchBarView(Context paramContext)
  {
    super(paramContext);
    c();
    d();
  }
  
  private void c()
  {
    this.a.setBackgroundColor(getResources().getColor(2131166237));
    this.a.setTextColor(getResources().getColor(2131166239));
    int i = getContext().getResources().getDimensionPixelOffset(2131297608);
    this.a.setPadding(i, 0, i, 0);
  }
  
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131428092);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(0.5F));
    localLayoutParams.addRule(13);
    int i = getContext().getResources().getDimensionPixelOffset(2131297607);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    View localView = new View(getContext());
    localView.setBackgroundColor(getResources().getColor(2131166238));
    localRelativeLayout.addView(localView, 0, localLayoutParams);
  }
  
  public void a() {}
  
  protected void a(RelativeLayout paramRelativeLayout) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.GuildLiveSelectTouchBarView
 * JD-Core Version:    0.7.0.1
 */