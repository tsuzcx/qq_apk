package com.tencent.qqmini.miniapp.util.logmonitor;

import java.util.ArrayList;

final class LogBeanUtil$1
  implements LogLoader.LoadHandler
{
  LogBeanUtil$1(String paramString, ArrayList paramArrayList, ILoadLogListener paramILoadLogListener) {}
  
  public void handLine(String paramString)
  {
    paramString = LogBeanUtil.createBeanFromLine(paramString);
    String str;
    if (paramString != null)
    {
      str = paramString.msg;
      if (this.val$keyErrFilter == null) {
        break label42;
      }
      if (str.contains(this.val$keyErrFilter)) {
        LogBeanUtil.access$000(paramString, str, this.val$list);
      }
    }
    return;
    label42:
    LogBeanUtil.access$000(paramString, str, this.val$list);
  }
  
  public void onComplete()
  {
    LogBeanUtil.access$102(null);
    this.val$listener.onLoaded(this.val$list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.logmonitor.LogBeanUtil.1
 * JD-Core Version:    0.7.0.1
 */