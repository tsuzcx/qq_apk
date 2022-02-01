package com.tencent.mobileqq.olympic.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import com.tencent.qphone.base.util.QLog;

class PromotionRes$2
  implements GestureMgr.GestureStatusListener
{
  PromotionRes$2(PromotionRes paramPromotionRes, AppInterface paramAppInterface) {}
  
  public void a(int paramInt)
  {
    this.b.b[3] = paramInt;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject = PromotionRes.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadProgress, index[3], bDownloadSuc[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.b.b;
    if (paramBoolean1) {
      paramInt = 100;
    } else {
      paramInt = -1;
    }
    localObject[3] = paramInt;
    if (this.b.b() == 100) {
      PromotionRes.a(this.b, "onDownloadProgress1", this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionRes.2
 * JD-Core Version:    0.7.0.1
 */