package com.tencent.mobileqq.writetogether.data;

class CursorManager$1
  implements Runnable
{
  CursorManager$1(CursorManager paramCursorManager, UserEditInfo paramUserEditInfo) {}
  
  public void run()
  {
    UserEditInfo localUserEditInfo1 = this.this$0.a();
    UserEditInfo localUserEditInfo2 = this.a;
    boolean bool = true;
    localUserEditInfo2.jdField_c_of_type_Boolean = true;
    if ((localUserEditInfo1 == null) || (localUserEditInfo1.jdField_c_of_type_Int != this.a.jdField_c_of_type_Int) || (!CursorManager.a(this.this$0))) {
      bool = false;
    }
    localUserEditInfo2.a = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.CursorManager.1
 * JD-Core Version:    0.7.0.1
 */