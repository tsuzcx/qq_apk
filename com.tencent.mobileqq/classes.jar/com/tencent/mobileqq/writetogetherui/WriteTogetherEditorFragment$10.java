package com.tencent.mobileqq.writetogetherui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WriteTogetherEditorFragment$10
  implements View.OnClickListener
{
  WriteTogetherEditorFragment$10(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void onClick(View paramView)
  {
    WriteTogetherEditorFragment.g(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.10
 * JD-Core Version:    0.7.0.1
 */