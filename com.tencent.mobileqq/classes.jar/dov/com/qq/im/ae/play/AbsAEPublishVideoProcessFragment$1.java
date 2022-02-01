package dov.com.qq.im.ae.play;

import bmbx;
import com.tencent.tavcut.TAVCut.Callback;

class AbsAEPublishVideoProcessFragment$1
  implements TAVCut.Callback
{
  AbsAEPublishVideoProcessFragment$1(AbsAEPublishVideoProcessFragment paramAbsAEPublishVideoProcessFragment) {}
  
  public void onDone(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case -1: 
      bmbx.d("AbsAEPublishVideoProces", "初始化TAVCut失败：tavkit so库加载异常");
      return;
    case -2: 
      bmbx.d("AbsAEPublishVideoProces", "初始化TAVCut失败：pag so库加载异常");
      return;
    }
    bmbx.a("AbsAEPublishVideoProces", "初始化TAVCut成功");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AbsAEPublishVideoProcessFragment.1
 * JD-Core Version:    0.7.0.1
 */