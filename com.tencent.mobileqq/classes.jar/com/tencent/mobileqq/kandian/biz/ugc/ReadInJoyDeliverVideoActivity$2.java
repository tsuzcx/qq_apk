package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.kandian.biz.ugc.capture.ReadInJoyVideoCompositeManager.OnVideoCompositeListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ReadInJoyDeliverVideoActivity$2
  implements ReadInJoyVideoCompositeManager.OnVideoCompositeListener
{
  ReadInJoyDeliverVideoActivity$2(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    paramPublishVideoEntry = new StringBuilder();
    paramPublishVideoEntry.append("onError: code - ");
    paramPublishVideoEntry.append(paramInt);
    paramPublishVideoEntry.append(" msg - ");
    paramPublishVideoEntry.append(paramString);
    QLog.d("ReadInJoyDeliverVideoActivity", 2, paramPublishVideoEntry.toString());
    ReadInJoyDeliverVideoActivity.a(this.a).post(new ReadInJoyDeliverVideoActivity.2.2(this));
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    paramPublishVideoEntry = new StringBuilder();
    paramPublishVideoEntry.append("onSuccess: outputPath - ");
    paramPublishVideoEntry.append(paramString);
    QLog.d("ReadInJoyDeliverVideoActivity", 2, paramPublishVideoEntry.toString());
    ReadInJoyDeliverVideoActivity.b(this.a, paramString);
    ReadInJoyDeliverVideoActivity.a(this.a).post(new ReadInJoyDeliverVideoActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverVideoActivity.2
 * JD-Core Version:    0.7.0.1
 */