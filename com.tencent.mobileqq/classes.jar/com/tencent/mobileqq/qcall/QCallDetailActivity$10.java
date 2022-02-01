package com.tencent.mobileqq.qcall;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vipav.VipFunCallObserver;

class QCallDetailActivity$10
  extends VipFunCallObserver
{
  QCallDetailActivity$10(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramObject = (Bundle)paramObject;
      } while ((paramObject == null) || (TextUtils.isEmpty(QCallDetailActivity.a(this.a))) || (!QCallDetailActivity.a(this.a).equals(paramObject.getString("uin"))));
      if (this.a.app != null) {
        this.a.app.removeObserver(this);
      }
    } while (!paramBoolean);
    this.a.runOnUiThread(new QCallDetailActivity.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.10
 * JD-Core Version:    0.7.0.1
 */