package com.tencent.mobileqq.ocr;

import aubi;
import aubn;
import aubr;

public class OcrCamera$8
  implements Runnable
{
  public OcrCamera$8(aubi paramaubi, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Boolean = false;
    this.this$0.jdField_b_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Aubn != null) {
      this.this$0.jdField_a_of_type_Aubn.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = aubr.a(this.jdField_a_of_type_ArrayOfByte, aubi.a(this.this$0), aubi.b(this.this$0), aubi.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_a_of_type_AndroidGraphicsRectF, true);; str = aubr.a(this.jdField_a_of_type_ArrayOfByte, aubi.d(this.this$0), aubi.e(this.this$0), aubi.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int))
    {
      if (this.this$0.jdField_a_of_type_Aubn != null) {
        this.this$0.jdField_a_of_type_Aubn.a(str);
      }
      aubi.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */