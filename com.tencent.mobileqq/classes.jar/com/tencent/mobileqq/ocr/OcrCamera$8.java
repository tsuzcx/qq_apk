package com.tencent.mobileqq.ocr;

import avwv;
import avxa;
import avxe;

public class OcrCamera$8
  implements Runnable
{
  public OcrCamera$8(avwv paramavwv, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Boolean = false;
    this.this$0.jdField_b_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Avxa != null) {
      this.this$0.jdField_a_of_type_Avxa.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = avxe.a(this.jdField_a_of_type_ArrayOfByte, avwv.a(this.this$0), avwv.b(this.this$0), avwv.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_a_of_type_AndroidGraphicsRectF, true);; str = avxe.a(this.jdField_a_of_type_ArrayOfByte, avwv.d(this.this$0), avwv.e(this.this$0), avwv.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int))
    {
      if (this.this$0.jdField_a_of_type_Avxa != null) {
        this.this$0.jdField_a_of_type_Avxa.a(str);
      }
      avwv.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */