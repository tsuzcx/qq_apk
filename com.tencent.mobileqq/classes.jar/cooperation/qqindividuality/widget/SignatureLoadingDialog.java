package cooperation.qqindividuality.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class SignatureLoadingDialog
  extends ReportDialog
{
  Animatable b = null;
  SlideDetectListView c = null;
  TextView d = null;
  Context e = null;
  
  public SignatureLoadingDialog(Context paramContext)
  {
    super(paramContext, 2131953341);
    this.e = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131627025, null);
    setContentView(paramContext);
    Object localObject = getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    ((Window)localObject).setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
    localObject = (TextView)paramContext.findViewById(2131436180);
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(2131887625);
    }
    this.d = ((TextView)paramContext.findViewById(2131436227));
    try
    {
      if (this.d != null)
      {
        this.d.setVisibility(0);
        this.d.setText(HardCodeUtil.a(2131911540));
      }
      label143:
      if (QLog.isColorLevel()) {
        QLog.d("SignatureLoadingDialog", 2, "enter into SignatureLoading");
      }
      return;
    }
    catch (Exception paramContext)
    {
      break label143;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    Animatable localAnimatable = this.b;
    if (localAnimatable != null) {
      localAnimatable.stop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.b = ((Animatable)this.e.getResources().getDrawable(2130839590));
    if (this.b != null)
    {
      TextView localTextView = this.d;
      if (localTextView != null)
      {
        localTextView.setCompoundDrawablePadding(10);
        this.d.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.b, null, null, null);
        this.b.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqindividuality.widget.SignatureLoadingDialog
 * JD-Core Version:    0.7.0.1
 */