package cooperation.qzone.webviewplugin;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.Window;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class QzoneQunFeedJsPlugin$LoadingDialog
  extends Dialog
{
  QzoneQunFeedJsPlugin$LoadingDialog(Context paramContext)
  {
    super(paramContext, 2131756040);
    setContentView(2131562238);
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
      if (QLog.isColorLevel()) {
        QLog.e("QzoneQunFeedJsPlugin", 2, localException, new Object[0]);
      }
    }
  }
  
  public void setTitle(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      str = null;
    } else {
      str = getContext().getResources().getString(paramInt);
    }
    setTitle(str);
  }
  
  public void setTitle(String paramString)
  {
    ((TextView)findViewById(2131378784)).setText(paramString);
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
      if (QLog.isColorLevel()) {
        QLog.e("QzoneQunFeedJsPlugin", 2, localException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.LoadingDialog
 * JD-Core Version:    0.7.0.1
 */