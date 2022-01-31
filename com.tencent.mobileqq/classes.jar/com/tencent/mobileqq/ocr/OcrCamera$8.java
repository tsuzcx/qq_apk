package com.tencent.mobileqq.ocr;

import aubg;
import aubl;
import aubp;

public class OcrCamera$8
  implements Runnable
{
  public OcrCamera$8(aubg paramaubg, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Boolean = false;
    this.this$0.jdField_b_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Aubl != null) {
      this.this$0.jdField_a_of_type_Aubl.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = aubp.a(this.jdField_a_of_type_ArrayOfByte, aubg.a(this.this$0), aubg.b(this.this$0), aubg.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_a_of_type_AndroidGraphicsRectF, true);; str = aubp.a(this.jdField_a_of_type_ArrayOfByte, aubg.d(this.this$0), aubg.e(this.this$0), aubg.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int))
    {
      if (this.this$0.jdField_a_of_type_Aubl != null) {
        this.this$0.jdField_a_of_type_Aubl.a(str);
      }
      aubg.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */