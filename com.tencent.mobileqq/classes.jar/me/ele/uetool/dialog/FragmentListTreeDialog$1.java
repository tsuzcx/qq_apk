package me.ele.uetool.dialog;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FragmentListTreeDialog$1
  implements CompoundButton.OnCheckedChangeListener
{
  FragmentListTreeDialog$1(FragmentListTreeDialog paramFragmentListTreeDialog) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    FragmentListTreeDialog.access$000(this.this$0, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.FragmentListTreeDialog.1
 * JD-Core Version:    0.7.0.1
 */