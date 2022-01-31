package com.tencent.mobileqq.dating;

import amvz;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import azvv;
import babr;
import bafb;

public final class DatingUtil$1
  implements Runnable
{
  public DatingUtil$1(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = new amvz(this);
    localObject = babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, this.jdField_a_of_type_JavaLangString, 0, 2131654515, (DialogInterface.OnClickListener)localObject, null);
    if (localObject != null)
    {
      ((TextView)((bafb)localObject).findViewById(2131299557)).setVisibility(8);
      TextView localTextView = (TextView)((bafb)localObject).findViewById(2131299579);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setMinHeight(azvv.a(this.jdField_a_of_type_AndroidAppActivity, 35.0F));
      localTextView.setGravity(17);
      ((bafb)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingUtil.1
 * JD-Core Version:    0.7.0.1
 */