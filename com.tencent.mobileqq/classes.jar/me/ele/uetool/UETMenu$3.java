package me.ele.uetool;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UETMenu$3
  implements View.OnClickListener
{
  UETMenu$3(UETMenu paramUETMenu) {}
  
  public void onClick(View paramView)
  {
    UETMenu.access$000(this.this$0, 3);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.UETMenu.3
 * JD-Core Version:    0.7.0.1
 */