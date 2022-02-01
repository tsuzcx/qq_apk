package dov.com.qq.im.aeeditor.module.edit;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;

class AEEditorImageEditFragment$7
  implements View.OnClickListener
{
  AEEditorImageEditFragment$7(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onClick(View paramView)
  {
    AEEditorImageEditFragment.a(this.a);
    AEReportUtils.c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.7
 * JD-Core Version:    0.7.0.1
 */