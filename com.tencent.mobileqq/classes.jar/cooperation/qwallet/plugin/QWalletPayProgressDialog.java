package cooperation.qwallet.plugin;

import amtj;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QWalletPayProgressDialog
  extends ReportDialog
{
  private String mMessage = amtj.a(2131710555);
  private TextView mTextView;
  
  public QWalletPayProgressDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public QWalletPayProgressDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    try
    {
      super.setContentView(2131559375);
      paramBundle = getWindow();
      paramBundle.setLayout(-1, -1);
      paramBundle.setBackgroundDrawable(new ColorDrawable(0));
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        paramBundle.addFlags(67108864);
      }
      this.mTextView = ((TextView)super.findViewById(2131370838));
      this.mTextView.setVisibility(0);
      this.mTextView.setText(this.mMessage);
      super.setCancelable(false);
      return;
    }
    catch (OutOfMemoryError paramBundle) {}catch (Exception paramBundle) {}
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      try
      {
        super.cancel();
        return false;
      }
      catch (Exception paramKeyEvent)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            paramKeyEvent.printStackTrace();
          }
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (this.mMessage = "";; this.mMessage = paramCharSequence.toString())
    {
      if (this.mTextView != null) {
        this.mTextView.setText(this.mMessage);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPayProgressDialog
 * JD-Core Version:    0.7.0.1
 */