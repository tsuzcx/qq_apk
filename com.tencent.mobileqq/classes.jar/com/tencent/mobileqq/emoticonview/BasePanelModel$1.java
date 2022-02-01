package com.tencent.mobileqq.emoticonview;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;

class BasePanelModel$1
  implements Runnable
{
  BasePanelModel$1(BasePanelModel paramBasePanelModel, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    ((EmoticonHandlerProxy)BasePanelModel.access$000(this.this$0).getBusinessHandler(EmoticonHandler.a)).getCommonUsedSmallYellowEmoitonRequest();
    this.val$sp.edit().putLong("lastRequestTime", System.currentTimeMillis()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BasePanelModel.1
 * JD-Core Version:    0.7.0.1
 */