package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import aupt;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class ForwardCompositeOption
  extends aupt
{
  public ForwardCompositeOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public boolean c()
  {
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardCompositeOption
 * JD-Core Version:    0.7.0.1
 */