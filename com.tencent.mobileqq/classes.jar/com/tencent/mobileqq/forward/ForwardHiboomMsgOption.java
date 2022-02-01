package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Set;

public class ForwardHiboomMsgOption
  extends ForwardBaseOption
{
  public ForwardHiboomMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected View a()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_hiboom_id");
    HiBoomTextView localHiBoomTextView = new HiBoomTextView(this.jdField_a_of_type_AndroidAppActivity);
    localHiBoomTextView.setHiBoom(i, 0, HiBoomManager.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
    localHiBoomTextView.setText(this.jdField_a_of_type_JavaLangString);
    localHiBoomTextView.setMaxSize(HiBoomManager.jdField_a_of_type_Int);
    localHiBoomTextView.setLayoutParams(new RelativeLayout.LayoutParams(500, 500));
    return localHiBoomTextView;
  }
  
  public boolean a()
  {
    super.a();
    return true;
  }
  
  protected void b()
  {
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
  }
  
  protected boolean m()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardHiboomMsgOption
 * JD-Core Version:    0.7.0.1
 */