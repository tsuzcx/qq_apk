package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import auxu;
import avrl;
import bhpc;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.util.Set;

public class ForwardHiboomMsgOption
  extends auxu
{
  public ForwardHiboomMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public View a()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_hiboom_id");
    HiBoomTextView localHiBoomTextView = new HiBoomTextView(this.jdField_a_of_type_AndroidAppActivity);
    localHiBoomTextView.setHiBoom(i, 0, avrl.jdField_a_of_type_Avre);
    localHiBoomTextView.setText(this.jdField_a_of_type_JavaLangString);
    localHiBoomTextView.setMaxSize(avrl.jdField_a_of_type_Int);
    localHiBoomTextView.setLayoutParams(new RelativeLayout.LayoutParams(500, 500));
    return localHiBoomTextView;
  }
  
  public void a()
  {
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (n()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public boolean a()
  {
    super.a();
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bhpc.setMessage(null);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean j()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardHiboomMsgOption
 * JD-Core Version:    0.7.0.1
 */