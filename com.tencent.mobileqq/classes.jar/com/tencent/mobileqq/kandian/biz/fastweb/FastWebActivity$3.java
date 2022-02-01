package com.tencent.mobileqq.kandian.biz.fastweb;

import android.content.Intent;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout.SuspensionGestureListener;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$3
  implements CommonSuspensionGestureLayout.SuspensionGestureListener
{
  FastWebActivity$3(FastWebActivity paramFastWebActivity) {}
  
  public void a()
  {
    QLog.d("FastWebActivity", 2, "mFloating onPageExposure");
  }
  
  public void a(int paramInt)
  {
    QLog.d("FastWebActivity", 2, "mFloating onStateChange");
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d("FastWebActivity", 2, "mFloating onCustomAnimStart");
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    FastWebActivity.a(this.a, true);
    FastWebActivity.b(this.a, false);
    FastWebActivity.c(this.a);
    if ((paramInt2 != 3) && (paramInt2 != 5)) {
      this.a.overridePendingTransition(0, 0);
    }
    if (paramInt2 == 5)
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("float_layer_finsh_action");
      this.a.sendBroadcast((Intent)localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mFloating mCommonSuspensionGestureLayout onPageClose type = ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("FastWebActivity", 2, ((StringBuilder)localObject).toString());
  }
  
  public void b()
  {
    QLog.d("FastWebActivity", 2, "mFloating onPopAnimStart");
  }
  
  public void b(int paramInt)
  {
    QLog.d("FastWebActivity", 2, "mFloating onPositionStateChange");
  }
  
  public void c()
  {
    QLog.d("FastWebActivity", 2, "mFloating onPopAnimEnd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.3
 * JD-Core Version:    0.7.0.1
 */