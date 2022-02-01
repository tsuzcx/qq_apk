package com.tencent.mobileqq.ocr;

import axmo;
import axmt;
import axmx;

public class OcrCamera$8
  implements Runnable
{
  public OcrCamera$8(axmo paramaxmo, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Boolean = false;
    this.this$0.jdField_b_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Axmt != null) {
      this.this$0.jdField_a_of_type_Axmt.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = axmx.a(this.jdField_a_of_type_ArrayOfByte, axmo.a(this.this$0), axmo.b(this.this$0), axmo.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_a_of_type_AndroidGraphicsRectF, true);; str = axmx.a(this.jdField_a_of_type_ArrayOfByte, axmo.d(this.this$0), axmo.e(this.this$0), axmo.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int))
    {
      if (this.this$0.jdField_a_of_type_Axmt != null) {
        this.this$0.jdField_a_of_type_Axmt.a(str);
      }
      axmo.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */