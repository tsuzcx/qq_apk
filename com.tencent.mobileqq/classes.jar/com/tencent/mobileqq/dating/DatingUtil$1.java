package com.tencent.mobileqq.dating;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import apdt;
import bcwh;
import bdcd;
import bdfq;

public final class DatingUtil$1
  implements Runnable
{
  public DatingUtil$1(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = new apdt(this);
    localObject = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, this.jdField_a_of_type_JavaLangString, 0, 2131720960, (DialogInterface.OnClickListener)localObject, null);
    if (localObject != null)
    {
      ((TextView)((bdfq)localObject).findViewById(2131365209)).setVisibility(8);
      TextView localTextView = (TextView)((bdfq)localObject).findViewById(2131365231);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setMinHeight(bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 35.0F));
      localTextView.setGravity(17);
      ((bdfq)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingUtil.1
 * JD-Core Version:    0.7.0.1
 */