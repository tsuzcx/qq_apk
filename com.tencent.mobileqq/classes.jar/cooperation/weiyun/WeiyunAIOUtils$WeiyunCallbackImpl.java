package cooperation.weiyun;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.weiyun.WeiyunCallback;
import mqq.os.MqqHandler;

class WeiyunAIOUtils$WeiyunCallbackImpl
  implements WeiyunCallback
{
  public MqqHandler a;
  private int b;
  private Context c;
  private QQAppInterface d;
  
  public WeiyunAIOUtils$WeiyunCallbackImpl(MqqHandler paramMqqHandler, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.a = paramMqqHandler;
    this.b = paramInt;
    this.c = paramContext;
    this.d = paramQQAppInterface;
  }
  
  public void a(int paramInt, String paramString)
  {
    MqqHandler localMqqHandler = this.a;
    if (localMqqHandler != null)
    {
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(101, paramInt, 0, paramString), 1500L);
      return;
    }
    ThreadManager.getUIHandler().post(new WeiyunAIOUtils.WeiyunCallbackImpl.2(this, paramString));
  }
  
  public void a(Object paramObject)
  {
    paramObject = this.a;
    if (paramObject != null)
    {
      paramObject.sendEmptyMessageDelayed(100, 1500L);
      return;
    }
    ThreadManager.getUIHandler().post(new WeiyunAIOUtils.WeiyunCallbackImpl.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl
 * JD-Core Version:    0.7.0.1
 */