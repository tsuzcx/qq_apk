package com.tencent.mobileqq.msgbackup.authentication;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp;

public class MsgBackupObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, MsgBackupQryStateRsp paramMsgBackupQryStateRsp) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            b(paramBoolean);
            return;
          }
          a(paramBoolean, (MsgBackupQryStateRsp)paramObject);
          return;
        }
        a(paramBoolean);
        return;
      }
      b(paramBoolean, paramObject);
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.authentication.MsgBackupObserver
 * JD-Core Version:    0.7.0.1
 */