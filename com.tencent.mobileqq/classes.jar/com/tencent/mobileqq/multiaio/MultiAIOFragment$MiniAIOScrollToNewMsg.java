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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPosition() from = [");
        localStringBuilder.append(this.b);
        localStringBuilder.append("], to = [");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
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
      StringBuilder localStringBuilder;
      if (MultiAIOFragment.b(this.this$0).equals(MultiAIOFragment.a(this.this$0)))
      {
        MultiAIOFragment.a("0X8009F7E", 1);
      }
      else if (MultiAIOFragment.b(this.this$0).equals(MultiAIOFragment.a(this.this$0)))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("run() MiniAIOScrollToNewMsg mClickAvatarTab = ");
          localStringBuilder.append(MultiAIOFragment.a(this.this$0));
          QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
        }
        if (MultiAIOFragment.a(this.this$0)) {
          MultiAIOFragment.a("0X8009F7E", 3);
        } else {
          MultiAIOFragment.a("0X8009F7E", 2);
        }
        MultiAIOFragment.a(this.this$0, false);
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("run() MiniAIOScrollToNewMsg pageChanged from = ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(" to = ");
        localStringBuilder.append(this.b);
        localStringBuilder.append(", view = ");
        localStringBuilder.append(MultiAIOFragment.b(this.this$0));
        QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.MiniAIOScrollToNewMsg
 * JD-Core Version:    0.7.0.1
 */