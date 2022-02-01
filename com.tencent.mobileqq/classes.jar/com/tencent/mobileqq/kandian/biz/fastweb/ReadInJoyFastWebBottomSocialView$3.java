package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.qphone.base.util.QLog;

class ReadInJoyFastWebBottomSocialView$3
  implements Runnable
{
  ReadInJoyFastWebBottomSocialView$3(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void run()
  {
    ReadInJoyFastWebBottomSocialView.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "reset mIsWaitingForFavoriteResult = false, not to block request too long.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialView.3
 * JD-Core Version:    0.7.0.1
 */