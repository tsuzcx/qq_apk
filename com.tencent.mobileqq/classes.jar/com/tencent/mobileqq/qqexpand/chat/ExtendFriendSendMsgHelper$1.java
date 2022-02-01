package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendSendMsgHelper$1
  extends ExpandObserver
{
  ExtendFriendSendMsgHelper$1(ExtendFriendSendMsgHelper paramExtendFriendSendMsgHelper) {}
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    String str = (String)arrayOfObject[0];
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      paramObject = (String)arrayOfObject[1];
      if (ExtendFriendSendMsgHelper.a(this.a) != null) {
        ExtendFriendSendMsgHelper.a(this.a).enterAio(str, paramObject);
      }
    }
    else if (paramObject != null)
    {
      int i = ((Integer)arrayOfObject[1]).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode resetCode=%s", new Object[] { Integer.valueOf(i) }));
      }
      if (i == 20)
      {
        if (ExtendFriendSendMsgHelper.a(this.a) != null) {
          ExtendFriendSendMsgHelper.a(this.a).showMatchCountDialog();
        }
      }
      else if (i == 21)
      {
        if (ExtendFriendSendMsgHelper.a(this.a) != null) {
          ExtendFriendSendMsgHelper.a(this.a).showToast(2131896888);
        }
      }
      else if (ExtendFriendSendMsgHelper.a(this.a) != null) {
        ExtendFriendSendMsgHelper.a(this.a).showToast(2131916977);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */