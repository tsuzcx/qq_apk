package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.mobileqq.intervideo.huayang.IHuayangLoadbackgroudActivityUtil;
import cooperation.qzone.util.ProcessUtils;

public class HuayangLoadbackgroudActivityUtilImpl
  implements IHuayangLoadbackgroudActivityUtil
{
  public void init()
  {
    Object localObject = ProcessUtils.getCurProcessName(BaseApplicationImpl.sApplication);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.sApplication.getPackageName());
    localStringBuilder.append(":troophomework");
    if (TextUtils.equals((CharSequence)localObject, localStringBuilder.toString()))
    {
      localObject = new IntentFilter("action_iv_plugin_update");
      BaseApplicationImpl.sApplication.registerReceiver(HuayangLoadbackgroudActivity.a(), (IntentFilter)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangLoadbackgroudActivityUtilImpl
 * JD-Core Version:    0.7.0.1
 */