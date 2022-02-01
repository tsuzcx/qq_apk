package com.tencent.mobileqq.forward;

import android.os.Bundle;

class ForwardQFavBatchOption$2
  implements Runnable
{
  ForwardQFavBatchOption$2(ForwardQFavBatchOption paramForwardQFavBatchOption, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    if (this.a.getInt("qfavType") != 3) {
      return;
    }
    ForwardQFavBatchOption.b(this.this$0, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption.2
 * JD-Core Version:    0.7.0.1
 */