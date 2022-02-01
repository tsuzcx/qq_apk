package com.tencent.mobileqq.ocr;

import ayzg;
import ayzl;
import ayzp;

public class OcrCamera$8
  implements Runnable
{
  public OcrCamera$8(ayzg paramayzg, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Boolean = false;
    this.this$0.jdField_b_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Ayzl != null) {
      this.this$0.jdField_a_of_type_Ayzl.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = ayzp.a(this.jdField_a_of_type_ArrayOfByte, ayzg.a(this.this$0), ayzg.b(this.this$0), ayzg.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_a_of_type_AndroidGraphicsRectF, true);; str = ayzp.a(this.jdField_a_of_type_ArrayOfByte, ayzg.d(this.this$0), ayzg.e(this.this$0), ayzg.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int))
    {
      if (this.this$0.jdField_a_of_type_Ayzl != null) {
        this.this$0.jdField_a_of_type_Ayzl.a(str);
      }
      ayzg.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */