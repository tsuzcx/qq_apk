package com.tencent.mobileqq.guild.setting;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;

class QQGuildDescriptionEditFragment$7
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QQGuildDescriptionEditFragment$7(QQGuildDescriptionEditFragment paramQQGuildDescriptionEditFragment) {}
  
  public void onGlobalLayout()
  {
    Object localObject = this.a.getActivity();
    if (localObject != null)
    {
      Rect localRect = new Rect();
      ((Activity)localObject).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      int i = localRect.height();
      if (QQGuildDescriptionEditFragment.d(this.a) == 0)
      {
        QQGuildDescriptionEditFragment.a(this.a, i);
        return;
      }
      if (QQGuildDescriptionEditFragment.d(this.a) != i)
      {
        localObject = this.a;
        QQGuildDescriptionEditFragment.b((QQGuildDescriptionEditFragment)localObject, QQGuildDescriptionEditFragment.d((QQGuildDescriptionEditFragment)localObject) - i);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mSoftKeyboardHeight change getWindowVisibleDisplayFrame(rect) height: ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" mSoftKeyboardHeight:");
          ((StringBuilder)localObject).append(QQGuildDescriptionEditFragment.e(this.a));
          QLog.i("QQGuildDescriptionEditFragment", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildDescriptionEditFragment.7
 * JD-Core Version:    0.7.0.1
 */