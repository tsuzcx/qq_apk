package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;

class ReadInJoyUserInfoRepository$1
  implements Runnable
{
  ReadInJoyUserInfoRepository$1(ReadInJoyUserInfoRepository paramReadInJoyUserInfoRepository, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    if (ReadInJoyUserInfoRepository.a(this.this$0) != null) {
      ReadInJoyUserInfoRepository.a(this.this$0).updateEntity(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoRepository.1
 * JD-Core Version:    0.7.0.1
 */