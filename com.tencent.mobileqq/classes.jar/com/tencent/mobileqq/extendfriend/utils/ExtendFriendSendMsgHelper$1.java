package com.tencent.mobileqq.extendfriend.utils;

import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendSendMsgHelper$1
  extends ExtendFriendObserver
{
  ExtendFriendSendMsgHelper$1(ExtendFriendSendMsgHelper paramExtendFriendSendMsgHelper) {}
  
  public void onGetSigBy0xb4cCode(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        int i;
        do
        {
          Object[] arrayOfObject;
          do
          {
            String str;
            do
            {
              return;
              arrayOfObject = (Object[])paramObject;
              str = (String)arrayOfObject[0];
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
              }
              if (!paramBoolean) {
                break;
              }
              paramObject = (String)arrayOfObject[1];
            } while (ExtendFriendSendMsgHelper.a(this.a) == null);
            ExtendFriendSendMsgHelper.a(this.a).enterAio(str, paramObject);
            return;
          } while (paramObject == null);
          i = ((Integer)arrayOfObject[1]).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode resetCode=%s", new Object[] { Integer.valueOf(i) }));
          }
          if (i != 20) {
            break;
          }
        } while (ExtendFriendSendMsgHelper.a(this.a) == null);
        ExtendFriendSendMsgHelper.a(this.a).showMatchCountDialog();
        return;
        if (i != 21) {
          break;
        }
      } while (ExtendFriendSendMsgHelper.a(this.a) == null);
      ExtendFriendSendMsgHelper.a(this.a).showToast(2131698838);
      return;
    } while (ExtendFriendSendMsgHelper.a(this.a) == null);
    ExtendFriendSendMsgHelper.a(this.a).showToast(2131719697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */