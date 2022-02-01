package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.qphone.base.util.QLog;

class ReadInJoyDeliverUGCActivity$16
  implements Runnable
{
  ReadInJoyDeliverUGCActivity$16(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, Object paramObject, int paramInt) {}
  
  public void run()
  {
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic");
    if (ReadInJoyDeliverUGCActivity.a(this.this$0, this.a)) {
      return;
    }
    String str = ReadInJoyDeliverUGCActivity.a(this.this$0, this.a, this.b);
    if (str == null) {
      return;
    }
    Object localObject = new ReadInJoyDeliverUGCActivity.UploadImage(this.this$0, str, this.b).c();
    if (((ReadInJoyDeliverUGCActivity.UploadImage)localObject).a()) {
      return;
    }
    long l = ((ReadInJoyDeliverUGCActivity.UploadImage)localObject).b();
    localObject = new ReadInJoyDeliverUGCActivity.CompressFile(this.this$0, str, l).e();
    if (((ReadInJoyDeliverUGCActivity.CompressFile)localObject).a()) {
      return;
    }
    ReadInJoyDeliverUGCActivity.a(this.this$0, str, l, (ReadInJoyDeliverUGCActivity.CompressFile)localObject, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.16
 * JD-Core Version:    0.7.0.1
 */