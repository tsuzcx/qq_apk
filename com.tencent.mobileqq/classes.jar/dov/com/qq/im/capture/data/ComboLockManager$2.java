package dov.com.qq.im.capture.data;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import bfur;
import bmsd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ComboLockManager$2
  implements Runnable
{
  public ComboLockManager$2(bmsd parambmsd, Context paramContext, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    bfur.a(localBaseActivity, 0, this.jdField_a_of_type_AndroidContentContext.getString(2131719384), localBaseActivity.getString(2131719381), 2131719382, 2131719383, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.data.ComboLockManager.2
 * JD-Core Version:    0.7.0.1
 */