package com.tencent.smtt.sdk.ui.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      if (((View)localObject).getTag() == a.a(this.a)) {
        this.a.onClick((View)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.a.2
 * JD-Core Version:    0.7.0.1
 */