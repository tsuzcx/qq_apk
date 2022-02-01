package cooperation.qqindividuality;

import android.content.Context;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class QQIndividualityBridgeActivity$QQProgressDialogEx
  extends QQProgressDialog
{
  public QQIndividualityBridgeActivity$QQProgressDialogEx(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onBackPressed()
  {
    if (this.a.e)
    {
      super.onBackPressed();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "tool process has started, cancel by the tool");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity.QQProgressDialogEx
 * JD-Core Version:    0.7.0.1
 */