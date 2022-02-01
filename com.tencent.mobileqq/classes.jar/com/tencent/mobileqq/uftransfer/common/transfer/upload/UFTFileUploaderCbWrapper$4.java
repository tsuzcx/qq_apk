package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploaderCallback;

class UFTFileUploaderCbWrapper$4
  implements Runnable
{
  UFTFileUploaderCbWrapper$4(UFTFileUploaderCbWrapper paramUFTFileUploaderCbWrapper, boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2, Object paramObject) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.this$0.b) {
        return;
      }
      this.this$0.a(true);
    }
    else if (this.this$0.c())
    {
      return;
    }
    if (this.this$0.a != null) {
      this.this$0.a.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaLangObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper.4
 * JD-Core Version:    0.7.0.1
 */