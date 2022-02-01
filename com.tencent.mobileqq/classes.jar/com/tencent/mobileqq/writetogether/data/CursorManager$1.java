package com.tencent.mobileqq.writetogether.data;

class CursorManager$1
  implements Runnable
{
  CursorManager$1(CursorManager paramCursorManager, UserEditInfo paramUserEditInfo) {}
  
  public void run()
  {
    UserEditInfo localUserEditInfo1 = this.this$0.b();
    UserEditInfo localUserEditInfo2 = this.a;
    boolean bool = true;
    localUserEditInfo2.j = true;
    if ((localUserEditInfo1 == null) || (localUserEditInfo1.f != this.a.f) || (!CursorManager.a(this.this$0))) {
      bool = false;
    }
    localUserEditInfo2.e = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.CursorManager.1
 * JD-Core Version:    0.7.0.1
 */