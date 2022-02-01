package me.ele.uetool;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UETMenu$6
  implements View.OnClickListener
{
  UETMenu$6(UETMenu paramUETMenu) {}
  
  public void onClick(View paramView)
  {
    UETMenu.access$102(this.this$0, System.currentTimeMillis());
    if (UETMenu.access$200(this.this$0)) {
      UETMenu.access$300(this.this$0);
    }
    if (!UETMenu.access$400(this.this$0))
    {
      UETMenu.access$500(this.this$0);
      UETMenu.access$600(this.this$0).sendEmptyMessageDelayed(0, 5000L);
    }
    UETMenu.access$700(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.UETMenu.6
 * JD-Core Version:    0.7.0.1
 */