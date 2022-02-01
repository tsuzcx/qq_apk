package com.tencent.mobileqq.ocr;

import aysx;
import aytc;
import aytg;

public class OcrCamera$8
  implements Runnable
{
  public OcrCamera$8(aysx paramaysx, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Boolean = false;
    this.this$0.jdField_b_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Aytc != null) {
      this.this$0.jdField_a_of_type_Aytc.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = aytg.a(this.jdField_a_of_type_ArrayOfByte, aysx.a(this.this$0), aysx.b(this.this$0), aysx.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_a_of_type_AndroidGraphicsRectF, true);; str = aytg.a(this.jdField_a_of_type_ArrayOfByte, aysx.d(this.this$0), aysx.e(this.this$0), aysx.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int))
    {
      if (this.this$0.jdField_a_of_type_Aytc != null) {
        this.this$0.jdField_a_of_type_Aytc.a(str);
      }
      aysx.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */