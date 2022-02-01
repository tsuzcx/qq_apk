package com.tencent.mobileqq.search.view;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class NetSearchTemplateHorSlidingContainerView
  extends NetSearchTemplateBaseView
  implements HorizontalListView.OnScrollStateChangedListener
{
  public HorizontalListView a;
  public NetSearchTemplateHorSlidingContainerItem b;
  
  public NetSearchTemplateHorSlidingContainerView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.a = ((HorizontalListView)((LinearLayout)b(paramInt)).findViewById(2131445450));
    this.a.setOnScrollStateChangedListener(this);
    this.a.setOnTouchListener(new NetSearchTemplateHorSlidingContainerView.1(this));
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097) {
      this.b.w = this.a.getCurrentX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateHorSlidingContainerView
 * JD-Core Version:    0.7.0.1
 */