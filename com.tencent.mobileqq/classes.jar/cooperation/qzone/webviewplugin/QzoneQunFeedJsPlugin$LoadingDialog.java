package cooperation.qzone.webviewplugin;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.Window;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QzoneQunFeedJsPlugin$LoadingDialog
  extends ReportDialog
{
  QzoneQunFeedJsPlugin$LoadingDialog(Context paramContext)
  {
    super(paramContext, 2131755682);
    setContentView(2131562264);
    getWindow().setFlags(1024, 2048);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QzoneQunFeedJsPlugin", 2, localException, new Object[0]);
    }
  }
  
  public void setTitle(int paramInt)
  {
    if (paramInt == 0) {}
    for (String str = null;; str = getContext().getResources().getString(paramInt))
    {
      setTitle(str);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    ((TextView)findViewById(2131379001)).setText(paramString);
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QzoneQunFeedJsPlugin", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.LoadingDialog
 * JD-Core Version:    0.7.0.1
 */