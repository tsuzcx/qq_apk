package com.tencent.mobileqq.extendfriend.wiget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.apollo.face.Util;
import java.util.ArrayList;
import java.util.List;

class HeadsPanelAnimationView$3
  implements Handler.Callback
{
  HeadsPanelAnimationView$3(HeadsPanelAnimationView paramHeadsPanelAnimationView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (this.a.b.size() == 0)
      {
        QLog.d("MatchViewHolder", 1, "MSG_START_ANIMATION uinList is empty!");
        return false;
      }
      this.a.b();
      if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      Util.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (String)this.a.b.get(this.a.b.size() - 1));
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
      return false;
    }
    paramMessage = (ArrayList)paramMessage.obj;
    if (this.a.jdField_a_of_type_Boolean)
    {
      paramMessage = Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 2, paramMessage);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 500L);
      return false;
    }
    HeadsPanelAnimationView.a(this.a, paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.HeadsPanelAnimationView.3
 * JD-Core Version:    0.7.0.1
 */