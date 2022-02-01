package dov.com.qq.im.aeeditor.module.edit.multi;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.util.AEFastClickThrottle;
import dov.com.qq.im.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;

class AEEditorMultiCutEditFragment$12
  implements View.OnClickListener
{
  AEEditorMultiCutEditFragment$12(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (AEFastClickThrottle.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AEEditorMultiCutEditFragment.a(this.a).a())
      {
        AEEditorMultiCutEditFragment.d(this.a, false);
        AEEditorMultiCutEditFragment.a(this.a).b();
      }
      else
      {
        AEEditorMultiCutEditFragment.d(this.a, true);
        AEEditorMultiCutEditFragment.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.12
 * JD-Core Version:    0.7.0.1
 */