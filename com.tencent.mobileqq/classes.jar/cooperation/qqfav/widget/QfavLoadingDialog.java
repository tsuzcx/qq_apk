package cooperation.qqfav.widget;

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
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.FadeIconImageView;

public class QfavLoadingDialog
  extends ReportDialog
{
  Animatable a = null;
  SlideDetectListView b = null;
  TextView c = null;
  Context d = null;
  
  public QfavLoadingDialog(Context paramContext)
  {
    super(paramContext, 2131953341);
    this.d = paramContext;
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
    this.c = ((TextView)paramContext.findViewById(2131436227));
    try
    {
      if (this.c != null)
      {
        this.c.setVisibility(0);
        this.c.setText(2131889221);
      }
      label140:
      paramContext = (FadeIconImageView)paramContext.findViewById(2131436194);
      if (paramContext != null)
      {
        paramContext.setVisibility(0);
        paramContext.setImageResource(2130841074);
      }
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "enter into QfavLoadingDialog");
      }
      return;
    }
    catch (Exception localException)
    {
      break label140;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    Animatable localAnimatable = this.a;
    if (localAnimatable != null) {
      localAnimatable.stop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.a = ((Animatable)this.d.getResources().getDrawable(2130839588));
    if (this.a != null)
    {
      TextView localTextView = this.c;
      if (localTextView != null)
      {
        localTextView.setCompoundDrawablePadding(10);
        this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.a, null, null, null);
        this.a.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavLoadingDialog
 * JD-Core Version:    0.7.0.1
 */