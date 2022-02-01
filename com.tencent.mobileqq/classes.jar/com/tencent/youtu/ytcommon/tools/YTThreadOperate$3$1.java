package com.tencent.youtu.ytcommon.tools;

class YTThreadOperate$3$1
  implements Runnable
{
  YTThreadOperate$3$1(YTThreadOperate.3 param3, Object paramObject) {}
  
  public void run()
  {
    if (this.this$0.val$uiCallback != null) {}
    try
    {
      this.this$0.val$uiCallback.callback(this.val$temp);
      return;
    }
    catch (Exception localException)
    {
      YTException.report(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTThreadOperate.3.1
 * JD-Core Version:    0.7.0.1
 */