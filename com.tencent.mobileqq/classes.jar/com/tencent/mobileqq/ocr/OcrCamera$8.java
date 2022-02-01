package com.tencent.mobileqq.ocr;

import aygn;
import aygs;
import aygw;

public class OcrCamera$8
  implements Runnable
{
  public OcrCamera$8(aygn paramaygn, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Boolean = false;
    this.this$0.jdField_b_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Aygs != null) {
      this.this$0.jdField_a_of_type_Aygs.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = aygw.a(this.jdField_a_of_type_ArrayOfByte, aygn.a(this.this$0), aygn.b(this.this$0), aygn.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_a_of_type_AndroidGraphicsRectF, true);; str = aygw.a(this.jdField_a_of_type_ArrayOfByte, aygn.d(this.this$0), aygn.e(this.this$0), aygn.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int))
    {
      if (this.this$0.jdField_a_of_type_Aygs != null) {
        this.this$0.jdField_a_of_type_Aygs.a(str);
      }
      aygn.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */