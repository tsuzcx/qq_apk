package com.tencent.qqmini.miniapp.util.logmonitor;

import java.util.ArrayList;

final class LogBeanUtil$1
  implements LogLoader.LoadHandler
{
  LogBeanUtil$1(String paramString, ArrayList paramArrayList, ILoadLogListener paramILoadLogListener) {}
  
  public void handLine(String paramString)
  {
    paramString = LogBeanUtil.createBeanFromLine(paramString);
    if (paramString != null)
    {
      String str1 = paramString.msg;
      String str2 = this.val$keyErrFilter;
      if (str2 != null)
      {
        if (str1.contains(str2)) {
          LogBeanUtil.access$000(paramString, str1, this.val$list);
        }
      }
      else {
        LogBeanUtil.access$000(paramString, str1, this.val$list);
      }
    }
  }
  
  public void onComplete()
  {
    LogBeanUtil.access$102(null);
    this.val$listener.onLoaded(this.val$list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.logmonitor.LogBeanUtil.1
 * JD-Core Version:    0.7.0.1
 */