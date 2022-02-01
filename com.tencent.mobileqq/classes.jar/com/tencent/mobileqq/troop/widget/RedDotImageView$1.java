package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

class RedDotImageView$1
  implements Runnable
{
  public void run()
  {
    Object localObject = this.a.getApplication();
    int i = SharedPreUtils.h((Context)localObject);
    boolean bool = SharedPreUtils.b((Context)localObject, this.a.getCurrentAccountUin(), i, this.b);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" show redDot: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    this.this$0.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotImageView.1
 * JD-Core Version:    0.7.0.1
 */