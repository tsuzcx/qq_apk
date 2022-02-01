package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.view.View;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyNewFeedsActivity$17
  extends ReadInJoyObserver
{
  ReadInJoyNewFeedsActivity$17(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onComponentLastReadShow");
    }
    this.a.runOnUiThread(new ReadInJoyNewFeedsActivity.17.1(this));
  }
  
  public void b_(int paramInt1, int paramInt2) {}
  
  public void m_(int paramInt)
  {
    this.a.d(paramInt);
  }
  
  public void n_(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity.17
 * JD-Core Version:    0.7.0.1
 */