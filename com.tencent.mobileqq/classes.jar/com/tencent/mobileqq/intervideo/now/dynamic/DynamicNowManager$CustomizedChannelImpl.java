package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedChannel;
import com.tencent.qqinterface.CommonCallback;

class DynamicNowManager$CustomizedChannelImpl
  implements CustomizedChannel
{
  public void onSendTask(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    PluginManagerInterfaceImpl.a().a(paramBundle, paramCommonCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.CustomizedChannelImpl
 * JD-Core Version:    0.7.0.1
 */