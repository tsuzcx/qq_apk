package com.tencent.mobileqq.ocr;

import atek;
import atep;
import atet;

public class OcrCamera$8
  implements Runnable
{
  public OcrCamera$8(atek paramatek, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Boolean = false;
    this.this$0.jdField_b_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Atep != null) {
      this.this$0.jdField_a_of_type_Atep.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = atet.a(this.jdField_a_of_type_ArrayOfByte, atek.a(this.this$0), atek.b(this.this$0), atek.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_a_of_type_AndroidGraphicsRectF, true);; str = atet.a(this.jdField_a_of_type_ArrayOfByte, atek.d(this.this$0), atek.e(this.this$0), atek.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int))
    {
      if (this.this$0.jdField_a_of_type_Atep != null) {
        this.this$0.jdField_a_of_type_Atep.a(str);
      }
      atek.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */