package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;

class ForwardQFavBatchOption$1
  implements Runnable
{
  ForwardQFavBatchOption$1(ForwardQFavBatchOption paramForwardQFavBatchOption, Bundle paramBundle, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, Intent paramIntent) {}
  
  public void run()
  {
    int j = this.a.getInt("qfavType");
    switch (j)
    {
    case 4: 
    default: 
      return;
    case 7: 
      ForwardQFavBatchOption.a(this.this$0, this.a, this.h, this.b, this.c, this.d, this.e, this.f, this.g);
      return;
    case 6: 
    case 8: 
      ForwardQFavBatchOption.a(this.this$0, this.a, j, this.b, this.c, this.d, this.e, this.f, this.g);
      return;
    case 5: 
      ForwardQFavBatchOption.a(this.this$0, this.i, this.a, this.h, this.b, this.c, this.d, this.e, this.f, this.g);
      return;
    case 3: 
      ForwardQFavBatchOption.a(this.this$0, this.a, this.e);
      return;
    case 2: 
      ForwardQFavBatchOption.c(this.this$0, this.a, j, this.b, this.c, this.d, this.e, this.f, this.g);
      return;
    }
    ForwardQFavBatchOption.b(this.this$0, this.a, j, this.b, this.c, this.d, this.e, this.f, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption.1
 * JD-Core Version:    0.7.0.1
 */