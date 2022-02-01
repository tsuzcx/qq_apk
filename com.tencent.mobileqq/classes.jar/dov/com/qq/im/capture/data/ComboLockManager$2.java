package dov.com.qq.im.capture.data;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import bglp;
import bgpa;
import boln;
import com.tencent.mobileqq.app.BaseActivity;

public class ComboLockManager$2
  implements Runnable
{
  public ComboLockManager$2(boln paramboln, Context paramContext, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    bglp.a(localBaseActivity, 0, this.jdField_a_of_type_AndroidContentContext.getString(2131718949), localBaseActivity.getString(2131718946), 2131718947, 2131718948, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.data.ComboLockManager.2
 * JD-Core Version:    0.7.0.1
 */