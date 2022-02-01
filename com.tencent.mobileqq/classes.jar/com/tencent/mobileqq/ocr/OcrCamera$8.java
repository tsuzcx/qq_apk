package com.tencent.mobileqq.ocr;

class OcrCamera$8
  implements Runnable
{
  OcrCamera$8(OcrCamera paramOcrCamera, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Boolean = false;
    this.this$0.jdField_b_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = OcrImageUtil.a(this.jdField_a_of_type_ArrayOfByte, OcrCamera.a(this.this$0), OcrCamera.b(this.this$0), OcrCamera.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_a_of_type_AndroidGraphicsRectF, true);; str = OcrImageUtil.a(this.jdField_a_of_type_ArrayOfByte, OcrCamera.d(this.this$0), OcrCamera.e(this.this$0), OcrCamera.c(this.this$0), this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int))
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback.a(str);
      }
      OcrCamera.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */