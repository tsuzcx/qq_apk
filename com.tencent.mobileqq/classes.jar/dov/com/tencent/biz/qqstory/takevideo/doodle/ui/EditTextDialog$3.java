package dov.com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditTextDialog$3
  implements View.OnClickListener
{
  EditTextDialog$3(EditTextDialog paramEditTextDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.3
 * JD-Core Version:    0.7.0.1
 */