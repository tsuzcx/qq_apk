package com.tencent.mobileqq.model;

import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;

final class EmoticonManager$3
  implements Runnable
{
  EmoticonManager$3(IEmoticonMainPanelApp paramIEmoticonMainPanelApp) {}
  
  public void run()
  {
    VasUpdateUtil.a(this.a.getAppRuntime(), "watch_focus.json", true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.3
 * JD-Core Version:    0.7.0.1
 */