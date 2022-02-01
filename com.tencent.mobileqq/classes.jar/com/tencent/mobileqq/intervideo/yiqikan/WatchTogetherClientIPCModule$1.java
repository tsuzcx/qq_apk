package com.tencent.mobileqq.intervideo.yiqikan;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class WatchTogetherClientIPCModule$1
  implements Runnable
{
  WatchTogetherClientIPCModule$1(WatchTogetherClientIPCModule paramWatchTogetherClientIPCModule, String paramString, WatchTogetherFloatingData paramWatchTogetherFloatingData) {}
  
  public void run()
  {
    boolean bool2 = "ACTION_SHOW_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(this.a);
    boolean bool1 = true;
    if (bool2)
    {
      if (WatchFloatingWindowController.c().a(BaseApplicationImpl.getContext(), this.b) != 0) {
        bool1 = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call TogetherBusinessIPCModule show=");
        localStringBuilder.append(bool1);
        QLog.d("WatchTogetherClientIPCModule", 2, localStringBuilder.toString());
      }
    }
    else
    {
      if ("ACTION_QUIT_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(this.a))
      {
        WatchFloatingWindowController.c().a(this.b.getCurUin(), this.b.getCurType(), true);
        return;
      }
      if ("ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS".equals(this.a)) {
        WatchFloatingWindowController.c().b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherClientIPCModule.1
 * JD-Core Version:    0.7.0.1
 */