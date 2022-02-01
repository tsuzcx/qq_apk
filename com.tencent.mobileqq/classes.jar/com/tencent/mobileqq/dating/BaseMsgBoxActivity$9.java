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
    oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)this.this$0.app.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).e(70);
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mRedpointObserver.onDataChange(): redDotInfo=");
      if (localRedDotInfo == null)
      {
        localObject = "is null";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" num=");
        ((StringBuilder)localObject).append(localRedDotInfo.uint32_number.get());
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("Q.msg_box", 2, localStringBuilder.toString());
    }
    boolean bool;
    if ((localRedDotInfo != null) && (localRedDotInfo.bool_display_reddot.get())) {
      bool = true;
    } else {
      bool = false;
    }
    this.a.a(bool);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mRedpointObserver.onDataChange(): showRedDot=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.msg_box", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.9
 * JD-Core Version:    0.7.0.1
 */