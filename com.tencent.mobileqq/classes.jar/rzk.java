import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

public class rzk
  implements smj
{
  public rzk(FastWebActivity paramFastWebActivity) {}
  
  public void a()
  {
    QLog.d(FastWebActivity.a(this.a), 2, "mFloating onPageExposure");
  }
  
  public void a(int paramInt)
  {
    QLog.d(FastWebActivity.a(this.a), 2, "mFloating onStateChange");
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d(FastWebActivity.a(this.a), 2, "mFloating onCustomAnimStart");
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    FastWebActivity.a(this.a, true);
    FastWebActivity.a(this.a, false);
    FastWebActivity.b(this.a);
    if ((paramInt2 != 3) && (paramInt2 != 5)) {
      this.a.overridePendingTransition(0, 0);
    }
    if (paramInt2 == 5)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("float_layer_finsh_action");
      this.a.sendBroadcast(localIntent);
    }
    QLog.d(FastWebActivity.a(this.a), 2, "mFloating mCommonSuspensionGestureLayout onPageClose type = " + paramInt2);
  }
  
  public void b()
  {
    QLog.d(FastWebActivity.a(this.a), 2, "mFloating onPopAnimStart");
  }
  
  public void b(int paramInt)
  {
    QLog.d(FastWebActivity.a(this.a), 2, "mFloating onPositionStateChange");
  }
  
  public void c()
  {
    QLog.d(FastWebActivity.a(this.a), 2, "mFloating onPopAnimEnd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rzk
 * JD-Core Version:    0.7.0.1
 */