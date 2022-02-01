package com.tencent.mobileqq.qcall;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;

class QCallDetailActivity$10
  extends VipFunCallObserver
{
  QCallDetailActivity$10(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 2) {
      return;
    }
    paramObject = (Bundle)paramObject;
    if (paramObject == null) {
      return;
    }
    if (!TextUtils.isEmpty(QCallDetailActivity.b(this.a)))
    {
      if (!QCallDetailActivity.b(this.a).equals(paramObject.getString("uin"))) {
        return;
      }
      if (this.a.app != null) {
        this.a.app.removeObserver(this);
      }
      if (paramBoolean) {
        this.a.runOnUiThread(new QCallDetailActivity.10.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.10
 * JD-Core Version:    0.7.0.1
 */