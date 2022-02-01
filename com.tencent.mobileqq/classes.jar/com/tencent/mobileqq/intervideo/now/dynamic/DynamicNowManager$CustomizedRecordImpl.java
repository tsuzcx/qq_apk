package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedRecord;
import com.tencent.qqinterface.CommonCallback;

class DynamicNowManager$CustomizedRecordImpl
  implements CustomizedRecord
{
  public void getRecordInfo(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    PluginManagerInterfaceImpl.a().c(paramBundle, paramCommonCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.CustomizedRecordImpl
 * JD-Core Version:    0.7.0.1
 */