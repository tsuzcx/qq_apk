package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.kandian.base.image.imageloader.CloseableBitmap;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class ReadInJoyDeliverVideoActivity$5
  implements IPublicAccountImageDownListener
{
  ReadInJoyDeliverVideoActivity$5(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Object paramObject)
  {
    if ((paramObject instanceof CloseableBitmap))
    {
      paramURL = (CloseableBitmap)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment cover download success");
      }
      ReadInJoyDeliverVideoActivity.d(this.a, ShortVideoPreviewActivity.coverToLocalImage(paramURL.b()));
      if (QLog.isColorLevel())
      {
        paramURL = new StringBuilder();
        paramURL.append("king moment local cover is ");
        paramURL.append(ReadInJoyDeliverVideoActivity.j(this.a));
        QLog.d("ReadInJoyDeliverVideoActivity", 2, paramURL.toString());
      }
      this.a.setRightViewTextDisable(1);
    }
  }
  
  public void a(URL paramURL, Throwable paramThrowable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverVideoActivity.5
 * JD-Core Version:    0.7.0.1
 */