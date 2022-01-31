package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.widget.EditText;
import bceh;
import bcfg;
import bcfm;

public class TextItem$6
  implements Runnable
{
  public TextItem$6(bcfg parambcfg, bcfm parambcfm, bceh parambceh) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bcfm.a.requestFocus();
    this.jdField_a_of_type_Bcfm.a.findFocus();
    this.jdField_a_of_type_Bcfm.a.setSelection(this.jdField_a_of_type_Bceh.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.6
 * JD-Core Version:    0.7.0.1
 */