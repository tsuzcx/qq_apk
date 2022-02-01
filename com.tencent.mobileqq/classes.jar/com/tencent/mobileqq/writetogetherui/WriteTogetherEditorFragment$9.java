package com.tencent.mobileqq.writetogetherui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.easysync2.ChangesetTracker;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.data.OpenDocParam;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WriteTogetherEditorFragment$9
  implements View.OnClickListener
{
  WriteTogetherEditorFragment$9(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void onClick(View paramView)
  {
    WriteTogetherEditorFragment.a(this.a, true);
    WriteTogetherEditorFragment.e(this.a);
    if ((WriteTogetherUtils.a(WriteTogetherEditorFragment.a(this.a).f)) || (!WriteTogetherEditorFragment.a(this.a).a())) {
      WriteTogetherEditorFragment.f(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.9
 * JD-Core Version:    0.7.0.1
 */