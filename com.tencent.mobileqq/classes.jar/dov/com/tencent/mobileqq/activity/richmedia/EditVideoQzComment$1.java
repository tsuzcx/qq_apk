package dov.com.tencent.mobileqq.activity.richmedia;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditVideoQzComment$1
  implements CompoundButton.OnCheckedChangeListener
{
  EditVideoQzComment$1(EditVideoQzComment paramEditVideoQzComment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    EditVideoQzComment.a(this.a).f = paramBoolean;
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.EditVideoQzComment.1
 * JD-Core Version:    0.7.0.1
 */