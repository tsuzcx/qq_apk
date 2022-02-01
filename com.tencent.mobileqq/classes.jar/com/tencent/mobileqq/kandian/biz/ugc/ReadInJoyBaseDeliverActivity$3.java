package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ReadInJoyBaseDeliverActivity$3
  implements QQPermissionCallback
{
  ReadInJoyBaseDeliverActivity$3(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("ReadInJoyBaseDeliverActivity", 1, "request position permissions, deny");
    QQToast.a(this.a.getActivity(), 2131718329, 0).a();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("ReadInJoyBaseDeliverActivity", 1, "request position permissions, grant");
    ReadInJoyBaseDeliverActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.3
 * JD-Core Version:    0.7.0.1
 */