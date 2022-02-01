package com.tencent.mobileqq.selectmember.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DiscussionListAdapter2$2
  implements View.OnClickListener
{
  DiscussionListAdapter2$2(DiscussionListAdapter2 paramDiscussionListAdapter2) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof DiscussionListAdapter2.ViewTag))
    {
      localObject = (DiscussionListAdapter2.ViewTag)localObject;
      if ((((DiscussionListAdapter2.ViewTag)localObject).a != null) && (this.a.a != null)) {
        this.a.a.a(((DiscussionListAdapter2.ViewTag)localObject).a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.adapter.DiscussionListAdapter2.2
 * JD-Core Version:    0.7.0.1
 */