package com.tencent.mobileqq.kandian.biz.ugc;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.kandian.biz.biu.BiuTextBuilder;

class ReadInJoyBaseDeliverActivity$4
  extends Editable.Factory
{
  ReadInJoyBaseDeliverActivity$4(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof BiuTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new BiuTextBuilder(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.4
 * JD-Core Version:    0.7.0.1
 */