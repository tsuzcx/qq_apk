import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class mli
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  Button jdField_a_of_type_AndroidWidgetButton;
  public TextView a;
  public VideoController a;
  public Runnable a;
  mlh jdField_a_of_type_Mlh;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean;
  View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean;
  
  private void c()
  {
    int i = 2130842271;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().aA) {
      i = 2130842272;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Mlh.getCount() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695321);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().U == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695320);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695319);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      lbc.e("VoiceChangeChooseDialog", "updateDialogStyle mVideoController is null!!");
      return;
    }
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4))
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break label118;
      }
      this.jdField_a_of_type_Mlh.a(-1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(16777216);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-534962398);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    }
    for (;;)
    {
      c();
      return;
      bool = false;
      break;
      label118:
      this.jdField_a_of_type_Mlh.a(-16777216);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-2147483648);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-2170912);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Mlh = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = true;
        localObject = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772129);
        ((Animation)localObject).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().aA)
      {
        label99:
        ((ley)localObject).aA = bool;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().U != 0)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().aA);
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().aA) {
            break label205;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695319);
        }
      }
      for (;;)
      {
        c();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().aA) {
          break label233;
        }
        maf.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 1017);
        mll.a("0X8007EF4", "");
        break;
        bool = false;
        break label99;
        label205:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695318);
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_Int = 0;
      }
      label233:
      mll.a("0X8007EF3", "");
    }
  }
  
  public void show()
  {
    int j = 1;
    int k = 0;
    super.show();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.startAnimation(AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772130));
    int i = k;
    if (this.jdField_a_of_type_Mlh.getCount() == 0)
    {
      this.jdField_a_of_type_Mlh.a(mlj.a().a());
      i = k;
      if (this.jdField_a_of_type_Mlh.getCount() != 0) {
        i = 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().U == 0) {
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        this.jdField_a_of_type_Mlh.notifyDataSetChanged();
      }
      a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mli
 * JD-Core Version:    0.7.0.1
 */