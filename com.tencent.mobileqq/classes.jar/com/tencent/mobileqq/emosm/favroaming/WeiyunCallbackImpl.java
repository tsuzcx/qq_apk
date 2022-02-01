package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.mobileqq.weiyun.WeiyunCallback;
import mqq.os.MqqHandler;

public class WeiyunCallbackImpl
  implements WeiyunCallback
{
  public MqqHandler a;
  
  public WeiyunCallbackImpl(MqqHandler paramMqqHandler)
  {
    this.a = paramMqqHandler;
  }
  
  public void a(int paramInt, String paramString)
  {
    MqqHandler localMqqHandler = this.a;
    if (localMqqHandler != null) {
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(101, paramInt, 0, paramString), 1500L);
    }
  }
  
  public void a(Object paramObject)
  {
    paramObject = this.a;
    if (paramObject != null) {
      paramObject.sendEmptyMessageDelayed(100, 1500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.WeiyunCallbackImpl
 * JD-Core Version:    0.7.0.1
 */