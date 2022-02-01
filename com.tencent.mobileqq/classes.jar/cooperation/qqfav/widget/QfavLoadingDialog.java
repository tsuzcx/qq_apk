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
  Context jdField_a_of_type_AndroidContentContext = null;
  Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = null;
  
  public QfavLoadingDialog(Context paramContext)
  {
    super(paramContext, 2131756192);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131560767, null);
    setContentView(paramContext);
    Object localObject = getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    ((Window)localObject).setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
    localObject = (TextView)paramContext.findViewById(2131369202);
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(2131690706);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131369249));
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692234);
      }
      label140:
      paramContext = (FadeIconImageView)paramContext.findViewById(2131369216);
      if (paramContext != null)
      {
        paramContext.setVisibility(0);
        paramContext.setImageResource(2130840334);
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
    Animatable localAnimatable = this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable;
    if (localAnimatable != null) {
      localAnimatable.stop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839404));
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null)
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        localTextView.setCompoundDrawablePadding(10);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable, null, null, null);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavLoadingDialog
 * JD-Core Version:    0.7.0.1
 */