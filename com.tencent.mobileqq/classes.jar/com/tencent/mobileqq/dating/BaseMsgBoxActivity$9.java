package com.tencent.mobileqq.dating;

import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

class BaseMsgBoxActivity$9
  implements Runnable
{
  BaseMsgBoxActivity$9(BaseMsgBoxActivity paramBaseMsgBoxActivity, RedDotTextView paramRedDotTextView) {}
  
  public void run()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)this.this$0.app.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a(70);
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("mRedpointObserver.onDataChange(): redDotInfo=");
      if (localRedDotInfo == null)
      {
        str = "is null";
        QLog.d("Q.msg_box", 2, str);
      }
    }
    else
    {
      if ((localRedDotInfo == null) || (!localRedDotInfo.bool_display_reddot.get())) {
        break label149;
      }
    }
    label149:
    for (boolean bool = true;; bool = false)
    {
      this.a.a(bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_box", 2, "mRedpointObserver.onDataChange(): showRedDot=" + bool);
      }
      return;
      str = " num=" + localRedDotInfo.uint32_number.get();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.9
 * JD-Core Version:    0.7.0.1
 */