package com.tencent.mobileqq.intervideo.od;

import com.tencent.qphone.base.util.QLog;

class ODLoadingActivity$1
  implements Runnable
{
  ODLoadingActivity$1(ODLoadingActivity paramODLoadingActivity) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showLoadingDialog:");
    localStringBuilder.append(ODLoadingActivity.a(this.this$0));
    QLog.e("ODLoadingActivity", 2, localStringBuilder.toString());
    if (!ODLoadingActivity.a(this.this$0)) {
      ODLoadingActivity.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODLoadingActivity.1
 * JD-Core Version:    0.7.0.1
 */