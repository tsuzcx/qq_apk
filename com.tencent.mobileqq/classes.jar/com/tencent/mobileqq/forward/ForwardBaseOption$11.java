package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ForwardBaseOption$11
  implements Runnable
{
  ForwardBaseOption$11(ForwardBaseOption paramForwardBaseOption, String paramString, QQCustomDialog paramQQCustomDialog) {}
  
  public void run()
  {
    Object localObject1;
    if (!this.this$0.w)
    {
      localObject2 = ForwardBaseOption.c(this.this$0, this.a);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        this.this$0.b(this.b);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView getNormalDrawable null");
        }
      }
    }
    else
    {
      localObject2 = ForwardBaseOption.h(this.this$0);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView getURLDrawable null");
        }
        return;
      }
    }
    Object localObject2 = this.this$0;
    ((ForwardBaseOption)localObject2).a(localObject1, ((ForwardBaseOption)localObject2).w);
    localObject2 = (ArrayList)this.this$0.t.get("PhotoConst.PHOTO_PATHS");
    ForwardBaseOption localForwardBaseOption = this.this$0;
    int i;
    if (localObject2 != null) {
      i = ((ArrayList)localObject2).size();
    } else {
      i = 0;
    }
    localForwardBaseOption.a(localObject1, true, i, this.this$0.w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.11
 * JD-Core Version:    0.7.0.1
 */