package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.shortvideo.ResultListener;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class BlessSelectMemberActivity$11
  implements ResultListener
{
  BlessSelectMemberActivity$11(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void a(int paramInt)
  {
    this.a.runOnUiThread(new BlessSelectMemberActivity.11.1(this));
    if (BlessSelectMemberActivity.g() != null) {
      BlessSelectMemberActivity.g().sendEmptyMessage(1);
    }
    synchronized (BlessSelectMemberActivity.h())
    {
      BlessSelectMemberActivity.h().set(true);
      BlessSelectMemberActivity.h().notifyAll();
      this.a.finish();
      return;
    }
  }
  
  public void a(String arg1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    BlessSelectMemberActivity.a = ???;
    synchronized (BlessSelectMemberActivity.h())
    {
      BlessSelectMemberActivity.h().set(true);
      BlessSelectMemberActivity.h().notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.11
 * JD-Core Version:    0.7.0.1
 */