package com.tencent.mobileqq.dating;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import arxy;
import bhdj;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public final class DatingUtil$1
  implements Runnable
{
  public DatingUtil$1(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = new arxy(this);
    localObject = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, this.jdField_a_of_type_JavaLangString, 0, 2131719492, (DialogInterface.OnClickListener)localObject, null);
    if (localObject != null)
    {
      ((TextView)((QQCustomDialog)localObject).findViewById(2131365621)).setVisibility(8);
      TextView localTextView = (TextView)((QQCustomDialog)localObject).findViewById(2131365644);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setMinHeight(DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 35.0F));
      localTextView.setGravity(17);
      ((QQCustomDialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingUtil.1
 * JD-Core Version:    0.7.0.1
 */