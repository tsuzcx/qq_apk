package dov.com.qq.im.aeeditor.module.text;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.report.AEBaseDataReporter;

class AEEditorTextEditDialog$2
  implements View.OnClickListener
{
  AEEditorTextEditDialog$2(AEEditorTextEditDialog paramAEEditorTextEditDialog) {}
  
  public void onClick(View paramView)
  {
    AEBaseDataReporter.a().x();
    AEEditorTextEditDialog.a(this.a);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextEditDialog.2
 * JD-Core Version:    0.7.0.1
 */