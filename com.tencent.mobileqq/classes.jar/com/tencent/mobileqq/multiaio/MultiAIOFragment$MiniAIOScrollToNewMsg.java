package com.tencent.mobileqq.multiaio;

import com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.qphone.base.util.QLog;

class MultiAIOFragment$MiniAIOScrollToNewMsg
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  private MultiAIOFragment$MiniAIOScrollToNewMsg(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void a(int paramInt)
  {
    if (this.b != paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "setPosition() from = [" + this.b + "], to = [" + paramInt + "]");
      }
      this.jdField_a_of_type_Int = this.b;
      this.b = paramInt;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "run() called MiniAIOScrollToNewMsg");
    }
    MultiAIOFragment.a(this.this$0).b(this.b);
    MultiAIOFragment.a(this.this$0).b();
    if ((this.jdField_a_of_type_Int != this.b) && (this.jdField_a_of_type_Boolean) && (MultiAIOFragment.b(this.this$0) != null))
    {
      if (!MultiAIOFragment.b(this.this$0).equals(MultiAIOFragment.a(this.this$0))) {
        break label159;
      }
      MultiAIOFragment.a("0X8009F7E", 1);
    }
    label159:
    while (!MultiAIOFragment.b(this.this$0).equals(MultiAIOFragment.a(this.this$0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "run() MiniAIOScrollToNewMsg pageChanged from = " + this.jdField_a_of_type_Int + " to = " + this.b + ", view = " + MultiAIOFragment.b(this.this$0));
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "run() MiniAIOScrollToNewMsg mClickAvatarTab = " + MultiAIOFragment.a(this.this$0));
    }
    if (MultiAIOFragment.a(this.this$0)) {
      MultiAIOFragment.a("0X8009F7E", 3);
    }
    for (;;)
    {
      MultiAIOFragment.a(this.this$0, false);
      break;
      MultiAIOFragment.a("0X8009F7E", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.MiniAIOScrollToNewMsg
 * JD-Core Version:    0.7.0.1
 */