package com.tencent.mobileqq.kandian.biz.fastweb;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class FastWebActivity$SmoothScrollTask
  implements Runnable
{
  private final View a;
  private final AbsListView b;
  private final int c;
  private final int d;
  private final boolean e;
  
  public FastWebActivity$SmoothScrollTask(FastWebActivity paramFastWebActivity, View paramView, AbsListView paramAbsListView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramView;
    this.b = paramAbsListView;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramBoolean;
  }
  
  public void run()
  {
    int i = this.a.getBottom() + this.b.getTop() - this.b.getBottom() - this.b.getPaddingBottom();
    this.b.setInterpolator(FastWebActivity.af(this.this$0));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjust scroll Before:");
      localStringBuilder.append(this.c - i);
      localStringBuilder.append(", After:");
      localStringBuilder.append(this.d / 2);
      QLog.d("FastWebActivity", 2, localStringBuilder.toString());
    }
    if (this.e) {
      i -= this.d / 2;
    } else {
      i += this.d / 2;
    }
    int j = i + 1;
    float f1 = FastWebActivity.ag(this.this$0);
    float f2 = j;
    i = (int)(f1 * 1000.0F * 2.0F * f2 / this.b.getFlingVelocityY());
    if (this.e) {
      i = (int)(FastWebActivity.ag(this.this$0) * 1000.0F * 2.0F * f2 / FastWebActivity.ah(this.this$0));
    }
    this.b.smoothScrollByImmediately(j, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.SmoothScrollTask
 * JD-Core Version:    0.7.0.1
 */