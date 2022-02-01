package cooperation.qqindividuality;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqindividuality.widget.SignatureLoadingDialog;

class QQIndividualityBridgeActivity$SignatureLoadingDialogEx
  extends SignatureLoadingDialog
{
  public QQIndividualityBridgeActivity$SignatureLoadingDialogEx(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onBackPressed()
  {
    if (this.a.a)
    {
      super.onBackPressed();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "tool process has started, cancel by the tool");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity.SignatureLoadingDialogEx
 * JD-Core Version:    0.7.0.1
 */