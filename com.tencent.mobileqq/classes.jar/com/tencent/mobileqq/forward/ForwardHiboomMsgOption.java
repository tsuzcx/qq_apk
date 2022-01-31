package com.tencent.mobileqq.forward;

import android.content.Intent;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Set;

public class ForwardHiboomMsgOption
  extends ForwardBaseOption
{
  public ForwardHiboomMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a()
  {
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public boolean a()
  {
    super.a();
    return true;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardHiboomMsgOption
 * JD-Core Version:    0.7.0.1
 */