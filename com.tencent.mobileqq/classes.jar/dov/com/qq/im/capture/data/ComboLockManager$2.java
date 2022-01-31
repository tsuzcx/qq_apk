package dov.com.qq.im.capture.data;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import bbdj;
import bbgu;
import com.tencent.mobileqq.app.BaseActivity;

class ComboLockManager$2
  implements Runnable
{
  ComboLockManager$2(ComboLockManager paramComboLockManager, Context paramContext, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    bbdj.a(localBaseActivity, 0, this.jdField_a_of_type_AndroidContentContext.getString(2131720665), localBaseActivity.getString(2131720662), 2131720663, 2131720664, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.ComboLockManager.2
 * JD-Core Version:    0.7.0.1
 */