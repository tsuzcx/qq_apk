package com.tencent.mobileqq.ptt;

import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;

class LSRecordPanel$13
  implements Runnable
{
  LSRecordPanel$13(LSRecordPanel paramLSRecordPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    int i = AudioPanel.a(this.jdField_a_of_type_Int);
    this.this$0.b(i);
    LSRecordPanel.a(this.this$0).setText(AudioPanel.a(this.jdField_a_of_type_Double));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordPanel.13
 * JD-Core Version:    0.7.0.1
 */