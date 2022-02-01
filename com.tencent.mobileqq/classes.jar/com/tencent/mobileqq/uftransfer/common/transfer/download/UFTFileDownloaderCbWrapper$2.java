package com.tencent.mobileqq.uftransfer.common.transfer.download;

import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileDownloaderCallback;

class UFTFileDownloaderCbWrapper$2
  implements Runnable
{
  UFTFileDownloaderCbWrapper$2(UFTFileDownloaderCbWrapper paramUFTFileDownloaderCbWrapper, boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2, Object paramObject) {}
  
  public void run()
  {
    if (this.this$0.c) {
      return;
    }
    this.this$0.a(true);
    if (this.this$0.a != null) {
      this.this$0.a.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaLangObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.download.UFTFileDownloaderCbWrapper.2
 * JD-Core Version:    0.7.0.1
 */