package com.tencent.mobileqq.dating;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anmm;
import baxn;
import bbdj;
import bbgu;

public final class DatingUtil$1
  implements Runnable
{
  public DatingUtil$1(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = new anmm(this);
    localObject = bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, this.jdField_a_of_type_JavaLangString, 0, 2131720422, (DialogInterface.OnClickListener)localObject, null);
    if (localObject != null)
    {
      ((TextView)((bbgu)localObject).findViewById(2131365124)).setVisibility(8);
      TextView localTextView = (TextView)((bbgu)localObject).findViewById(2131365146);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setMinHeight(baxn.a(this.jdField_a_of_type_AndroidAppActivity, 35.0F));
      localTextView.setGravity(17);
      ((bbgu)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingUtil.1
 * JD-Core Version:    0.7.0.1
 */