package com.tencent.mobileqq.magicface.model;

class MagicfaceDecoder$1
  implements Runnable
{
  MagicfaceDecoder$1(MagicfaceDecoder paramMagicfaceDecoder) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    MagicfaceDecoder localMagicfaceDecoder = this.this$0;
    localMagicfaceDecoder.jdField_a_of_type_Boolean = true;
    if (localMagicfaceDecoder.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener.a();
    }
    this.this$0.a();
    localMagicfaceDecoder = this.this$0;
    localMagicfaceDecoder.jdField_a_of_type_Boolean = false;
    if (localMagicfaceDecoder.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener.b();
    }
    Thread.currentThread().setPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceDecoder.1
 * JD-Core Version:    0.7.0.1
 */