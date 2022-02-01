package dov.com.qq.im.aeeditor.module.edit;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEEditorVideoEditFragment$4
  implements View.OnClickListener
{
  AEEditorVideoEditFragment$4(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onClick(View paramView)
  {
    AEEditorVideoEditFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.4
 * JD-Core Version:    0.7.0.1
 */