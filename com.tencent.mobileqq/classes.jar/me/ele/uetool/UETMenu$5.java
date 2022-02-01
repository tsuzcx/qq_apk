package me.ele.uetool;

import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import me.ele.uetool.view.ColorPickerFloatView;

class UETMenu$5
  implements View.OnClickListener
{
  UETMenu$5(UETMenu paramUETMenu) {}
  
  @RequiresApi(api=21)
  public void onClick(View paramView)
  {
    if (!ColorPickerFloatView.removeView()) {
      UETMenu.access$000(this.this$0, 5);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.UETMenu.5
 * JD-Core Version:    0.7.0.1
 */