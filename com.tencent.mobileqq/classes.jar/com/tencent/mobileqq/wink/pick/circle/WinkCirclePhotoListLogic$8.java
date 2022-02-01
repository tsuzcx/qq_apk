package com.tencent.mobileqq.wink.pick.circle;

import com.tencent.mobileqq.wink.pick.circle.widget.WinkCancelableProgressDialog;
import mqq.util.WeakReference;

class WinkCirclePhotoListLogic$8
  implements Runnable
{
  WinkCirclePhotoListLogic$8(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if ((this.a) && (this.b))
    {
      WinkCirclePhotoListLogic.c(this.this$0).a(((WinkCirclePhotoListFragment)this.this$0.c.get()).getString(2131886363, new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d) }));
      return;
    }
    if (this.a)
    {
      WinkCirclePhotoListLogic.c(this.this$0).a(((WinkCirclePhotoListFragment)this.this$0.c.get()).getString(2131886402, new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d) }));
      return;
    }
    if (this.b) {
      WinkCirclePhotoListLogic.c(this.this$0).a(((WinkCirclePhotoListFragment)this.this$0.c.get()).getString(2131886362, new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic.8
 * JD-Core Version:    0.7.0.1
 */