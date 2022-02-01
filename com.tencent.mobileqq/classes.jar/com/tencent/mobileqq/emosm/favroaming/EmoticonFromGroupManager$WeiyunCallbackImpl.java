package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.WeiyunCallback;
import mqq.os.MqqHandler;

class EmoticonFromGroupManager$WeiyunCallbackImpl
  implements WeiYunLogicCenter.WeiyunCallback
{
  public MqqHandler a;
  
  public EmoticonFromGroupManager$WeiyunCallbackImpl(MqqHandler paramMqqHandler)
  {
    this.a = paramMqqHandler;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.a != null) {
      this.a.sendMessageDelayed(this.a.obtainMessage(101, paramInt, 0, paramString), 1500L);
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.a != null) {
      this.a.sendEmptyMessageDelayed(100, 1500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.WeiyunCallbackImpl
 * JD-Core Version:    0.7.0.1
 */