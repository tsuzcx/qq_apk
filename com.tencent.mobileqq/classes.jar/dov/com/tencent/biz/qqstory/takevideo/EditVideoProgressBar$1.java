package dov.com.tencent.biz.qqstory.takevideo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditVideoProgressBar$1
  implements View.OnClickListener
{
  EditVideoProgressBar$1(EditVideoProgressBar paramEditVideoProgressBar) {}
  
  public void onClick(View paramView)
  {
    if (EditVideoProgressBar.a(this.a) != null)
    {
      if ((EditVideoProgressBar.a(this.a).a() != 1) || (EditVideoProgressBar.a(this.a) != 1)) {
        break label71;
      }
      EditVideoProgressBar.a(this.a);
      EditVideoProgressBar.a(this.a).setImageResource(2130848052);
      EditVideoProgressBar.a(this.a, 2);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label71:
      if ((EditVideoProgressBar.a(this.a).a() == 2) && (EditVideoProgressBar.a(this.a) == 2))
      {
        EditVideoProgressBar.b(this.a);
        EditVideoProgressBar.a(this.a).setImageResource(2130848053);
        EditVideoProgressBar.a(this.a, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoProgressBar.1
 * JD-Core Version:    0.7.0.1
 */