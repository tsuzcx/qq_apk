package com.tencent.mobileqq.ocr;

import avsm;
import avsr;
import avsv;

public class OcrCamera$8
  implements Runnable
{
  public OcrCamera$8(avsm paramavsm, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Boolean = false;
    this.this$0.jdField_b_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Avsr != null) {
      this.this$0.jdField_a_of_type_Avsr.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = avsv.a(this.jdField_a_of_type_ArrayOfByte, avsm.a(this.this$0), avsm.b(this.this$0), avsm.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_a_of_type_AndroidGraphicsRectF, true);; str = avsv.a(this.jdField_a_of_type_ArrayOfByte, avsm.d(this.this$0), avsm.e(this.this$0), avsm.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int))
    {
      if (this.this$0.jdField_a_of_type_Avsr != null) {
        this.this$0.jdField_a_of_type_Avsr.a(str);
      }
      avsm.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */