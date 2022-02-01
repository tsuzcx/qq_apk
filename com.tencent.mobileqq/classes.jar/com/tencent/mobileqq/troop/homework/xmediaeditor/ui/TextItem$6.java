package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.widget.EditText;
import bfev;
import bffu;
import bfga;

public class TextItem$6
  implements Runnable
{
  public TextItem$6(bffu parambffu, bfga parambfga, bfev parambfev) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bfga.a.requestFocus();
    this.jdField_a_of_type_Bfga.a.findFocus();
    this.jdField_a_of_type_Bfga.a.setSelection(this.jdField_a_of_type_Bfev.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.6
 * JD-Core Version:    0.7.0.1
 */