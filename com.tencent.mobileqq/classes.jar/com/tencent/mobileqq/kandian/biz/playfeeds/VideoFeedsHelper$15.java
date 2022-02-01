package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.qphone.base.util.QLog;

final class VideoFeedsHelper$15
  implements Ox978RespCallBack
{
  VideoFeedsHelper$15(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("followPubAccount() onFollowPublicAccount uin=");
      paramString.append(this.a);
      paramString.append(", isSuccess=");
      paramString.append(paramBoolean);
      paramString.append(", isUGC=");
      paramString.append(this.b);
      paramString.append(", data=");
      paramString.append(paramInt);
      QLog.d("VideoFeedsHelper", 2, paramString.toString());
    }
    VideoFeedsHelper.a(paramBoolean, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.15
 * JD-Core Version:    0.7.0.1
 */