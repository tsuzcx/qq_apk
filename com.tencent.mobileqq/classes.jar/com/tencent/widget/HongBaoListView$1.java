package com.tencent.widget;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.portal.HongBaoPendantHolder;
import com.tencent.qphone.base.util.QLog;

class HongBaoListView$1
  implements Handler.Callback
{
  HongBaoListView$1(HongBaoListView paramHongBaoListView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 5)
        {
          if (i != 6)
          {
            if (i != 7)
            {
              if (i != 8) {
                return false;
              }
              if (QLog.isColorLevel()) {
                QLog.d("HongBaoListView", 2, "handleMessage MSG_JUMP_PREGUIDE");
              }
              if (!this.a.isStackFromBottom()) {
                this.a.setStackFromBottom(true);
              }
              this.a.setStackFromBottom(false);
              if (!this.a.y)
              {
                i = (int)this.a.getResources().getDimension(2131298982);
                this.a.springBackTo(-i);
                return false;
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_PREGUIDE_END");
              }
              this.a.setIsShowingPreguide(false);
              this.a.setSpringbackOffset(0);
              return false;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_THIRD_GUIDE_HIDE");
            }
            this.a.a(300L);
            this.a.F.sendEmptyMessageDelayed(7, 300L);
            if (this.a.v != null)
            {
              this.a.v.a(false);
              return false;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_THIRD_GUIDE_SHOW");
          }
          this.a.setIsShowingPreguide(true);
          i = this.a.C / 2;
          HongBaoListView localHongBaoListView = this.a;
          localHongBaoListView.setSpringbackOffset(-localHongBaoListView.C);
          if (paramMessage.arg1 != 0) {
            i = paramMessage.arg1;
          }
          this.a.springBackTo(-i);
          if (this.a.z != null) {
            this.a.z.a(this.a.C / 5, 300L);
          }
          this.a.F.sendEmptyMessageDelayed(6, 2000L);
          if (this.a.v != null)
          {
            this.a.v.b(false);
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_FIRST_GUIDE_HIDE");
        }
        this.a.a(300L);
        this.a.F.sendEmptyMessageDelayed(7, 300L);
        if (this.a.v != null)
        {
          this.a.v.a(false);
          return false;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_FIRST_GUIDE_SHOW");
      }
      this.a.setIsShowingPreguide(true);
      if (this.a.z != null) {
        this.a.z.a(this.a.C / 5, 300L);
      }
      paramMessage = this.a;
      paramMessage.springBackTo(-paramMessage.C);
      if (this.a.v != null) {
        this.a.v.b(false);
      }
      this.a.F.sendEmptyMessageDelayed(2, 2000L);
      this.a.invalidate();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.HongBaoListView.1
 * JD-Core Version:    0.7.0.1
 */