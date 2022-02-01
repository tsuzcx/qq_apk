package dov.com.qq.im.aeeditor.module.filter;

import android.app.Dialog;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class AEEditorFilterControlPanel$7
  implements Runnable
{
  AEEditorFilterControlPanel$7(AEEditorFilterControlPanel paramAEEditorFilterControlPanel, String paramString) {}
  
  public void run()
  {
    if (AEEditorFilterControlPanel.a(this.this$0) == null)
    {
      AEEditorFilterControlPanel.a(this.this$0, new ReportDialog(this.this$0.getContext(), 2131755842));
      AEEditorFilterControlPanel.a(this.this$0).setCancelable(false);
      AEEditorFilterControlPanel.a(this.this$0).setCanceledOnTouchOutside(false);
      AEEditorFilterControlPanel.a(this.this$0).setContentView(2131559683);
    }
    TextView localTextView = (TextView)AEEditorFilterControlPanel.a(this.this$0).findViewById(2131373066);
    if (!TextUtils.isEmpty(this.a)) {
      localTextView.setText(this.a);
    }
    for (;;)
    {
      AEEditorFilterControlPanel.a(this.this$0).show();
      return;
      localTextView.setText(2131694890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.7
 * JD-Core Version:    0.7.0.1
 */