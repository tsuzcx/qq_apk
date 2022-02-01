package dov.com.qq.im.capture.adapter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;

class QIMPtvTemplateAdapter$5
  implements DialogInterface.OnClickListener
{
  QIMPtvTemplateAdapter$5(QIMPtvTemplateAdapter paramQIMPtvTemplateAdapter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.excute(new QIMPtvTemplateAdapter.5.1(this), 128, null, true);
    QIMCommonLoadingProgress.a(this.a.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.5
 * JD-Core Version:    0.7.0.1
 */