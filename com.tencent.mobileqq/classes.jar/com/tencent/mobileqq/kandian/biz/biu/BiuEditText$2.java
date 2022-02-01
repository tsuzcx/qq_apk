package com.tencent.mobileqq.kandian.biz.biu;

import android.text.Editable;
import com.tencent.mobileqq.kandian.base.view.widget.text.ISpan;
import java.util.Comparator;

class BiuEditText$2
  implements Comparator<ISpan>
{
  BiuEditText$2(BiuEditText paramBiuEditText, Editable paramEditable) {}
  
  public int a(ISpan paramISpan1, ISpan paramISpan2)
  {
    return this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramISpan1) - this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramISpan2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.BiuEditText.2
 * JD-Core Version:    0.7.0.1
 */