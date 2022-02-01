package com.tencent.widget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.qphone.base.util.QLog;

class ARMapHongBaoListView$1
  implements Handler.Callback
{
  ARMapHongBaoListView$1(ARMapHongBaoListView paramARMapHongBaoListView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return false;
            }
            this.a.setIsShowingPreguide(false);
            return false;
          }
          if (((Bundle)paramMessage.obj).getBoolean("isSpringBack")) {
            ARMapHongBaoListView.a(this.a, paramMessage.what);
          }
          ARMapHongBaoListView.b(this.a).sendEmptyMessageDelayed(5, 300L);
          if (ARMapHongBaoListView.a(this.a) != null)
          {
            ARMapHongBaoListView.a(this.a).a(false);
            return false;
          }
        }
        else
        {
          this.a.setIsShowingPreguide(true);
          i = this.a.C;
          if (paramMessage.arg1 != 0) {
            i = paramMessage.arg1;
          }
          if (this.a.a != null) {
            this.a.a.a(this.a.C / 3, 300L);
          }
          Message localMessage = Message.obtain(ARMapHongBaoListView.b(this.a), 4);
          localMessage.obj = paramMessage.obj;
          ARMapHongBaoListView.b(this.a).sendMessageDelayed(localMessage, 2000L);
          if ((ARMapHongBaoListView.a(this.a) != null) && (this.a.c))
          {
            ARMapHongBaoListView.a(this.a).b(false);
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARMapHongBaoListView", 2, "ARMapHongBaoListView handleMessage MSG_WHAT_GUIDE_HIDE");
        }
        if (ARMapHongBaoListView.a(this.a) != null) {
          ARMapHongBaoListView.a(this.a).a(false);
        }
        ARMapHongBaoListView.a(this.a, paramMessage.what);
        ARMapHongBaoListView.b(this.a).sendEmptyMessageDelayed(5, 300L);
        return false;
      }
    }
    else
    {
      this.a.setIsShowingPreguide(true);
      boolean bool1 = paramMessage.getData().getBoolean("isFirstCall", false);
      boolean bool2 = paramMessage.getData().getBoolean("isListViewSpring", false);
      boolean bool3 = paramMessage.getData().getBoolean("isPendantBounce", false);
      int j = paramMessage.getData().getInt("pendantBountCnt", 0);
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("ARMapHongBaoListView handleMessage MSG_WHAT_GUIDE_SHOW, ");
        paramMessage.append(bool1);
        paramMessage.append(",");
        paramMessage.append(bool2);
        paramMessage.append(",");
        paramMessage.append(bool3);
        paramMessage.append(",");
        paramMessage.append(j);
        QLog.d("ARMapHongBaoListView", 2, paramMessage.toString());
      }
      if ((bool1) && (bool2) && (ARMapHongBaoListView.a(this.a) != null) && (this.a.c)) {
        ARMapHongBaoListView.a(this.a).b(false);
      }
      i = j;
      if (bool3)
      {
        i = j;
        if (j > 0)
        {
          float f = j * 1.0F / 6.0F;
          if (this.a.a != null) {
            this.a.a.a((int)(this.a.C * f), j * 300L);
          }
          i = j - 1;
          if (i > 0)
          {
            paramMessage = Message.obtain(ARMapHongBaoListView.b(this.a), 1);
            paramMessage.getData().putBoolean("isFirstCall", false);
            paramMessage.getData().putBoolean("isListViewSpring", false);
            paramMessage.getData().putBoolean("isPendantBounce", bool3);
            paramMessage.getData().putInt("pendantBountCnt", i);
            ARMapHongBaoListView.b(this.a).sendMessageDelayed(paramMessage, j * 300L + 200L);
          }
        }
      }
      if (i == 0)
      {
        paramMessage = Message.obtain(ARMapHongBaoListView.b(this.a), 2);
        ARMapHongBaoListView.b(this.a).sendMessageDelayed(paramMessage, 1200L);
      }
      this.a.invalidate();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ARMapHongBaoListView.1
 * JD-Core Version:    0.7.0.1
 */