package com.tencent.mobileqq.multiaio;

import com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.qphone.base.util.QLog;

class MultiAIOFragment$MiniAIOScrollToNewMsg
  implements Runnable
{
  private int a;
  private int b;
  private boolean c;
  
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
      this.a = this.b;
      this.b = paramInt;
      this.c = true;
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "run() called MiniAIOScrollToNewMsg");
    }
    MultiAIOFragment.i(this.this$0).b(this.b);
    MultiAIOFragment.c(this.this$0).c();
    if ((this.a != this.b) && (this.c) && (MultiAIOFragment.j(this.this$0) != null))
    {
      StringBuilder localStringBuilder;
      if (MultiAIOFragment.j(this.this$0).equals(MultiAIOFragment.d(this.this$0)))
      {
        MultiAIOFragment.a("0X8009F7E", 1);
      }
      else if (MultiAIOFragment.j(this.this$0).equals(MultiAIOFragment.c(this.this$0)))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("run() MiniAIOScrollToNewMsg mClickAvatarTab = ");
          localStringBuilder.append(MultiAIOFragment.k(this.this$0));
          QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
        }
        if (MultiAIOFragment.k(this.this$0)) {
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
        localStringBuilder.append(this.a);
        localStringBuilder.append(" to = ");
        localStringBuilder.append(this.b);
        localStringBuilder.append(", view = ");
        localStringBuilder.append(MultiAIOFragment.j(this.this$0));
        QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
      }
    }
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.MiniAIOScrollToNewMsg
 * JD-Core Version:    0.7.0.1
 */