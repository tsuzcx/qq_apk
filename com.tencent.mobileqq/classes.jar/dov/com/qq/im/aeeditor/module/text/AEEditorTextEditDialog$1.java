package dov.com.qq.im.aeeditor.module.text;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.report.AEBaseDataReporter;

class AEEditorTextEditDialog$1
  implements View.OnClickListener
{
  AEEditorTextEditDialog$1(AEEditorTextEditDialog paramAEEditorTextEditDialog) {}
  
  public void onClick(View paramView)
  {
    AEBaseDataReporter.a().w();
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextEditDialog.1
 * JD-Core Version:    0.7.0.1
 */