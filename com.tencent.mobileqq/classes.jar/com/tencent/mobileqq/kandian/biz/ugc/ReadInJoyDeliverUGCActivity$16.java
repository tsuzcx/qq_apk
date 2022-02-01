package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.qphone.base.util.QLog;

class ReadInJoyDeliverUGCActivity$16
  implements Runnable
{
  ReadInJoyDeliverUGCActivity$16(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, Object paramObject, int paramInt) {}
  
  public void run()
  {
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic");
    if (ReadInJoyDeliverUGCActivity.a(this.this$0, this.jdField_a_of_type_JavaLangObject)) {
      return;
    }
    String str = ReadInJoyDeliverUGCActivity.a(this.this$0, this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Int);
    if (str == null) {
      return;
    }
    Object localObject = new ReadInJoyDeliverUGCActivity.UploadImage(this.this$0, str, this.jdField_a_of_type_Int).a();
    if (((ReadInJoyDeliverUGCActivity.UploadImage)localObject).a()) {
      return;
    }
    long l = ((ReadInJoyDeliverUGCActivity.UploadImage)localObject).a();
    localObject = new ReadInJoyDeliverUGCActivity.CompressFile(this.this$0, str, l).a();
    if (((ReadInJoyDeliverUGCActivity.CompressFile)localObject).a()) {
      return;
    }
    ReadInJoyDeliverUGCActivity.a(this.this$0, str, l, (ReadInJoyDeliverUGCActivity.CompressFile)localObject, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.16
 * JD-Core Version:    0.7.0.1
 */