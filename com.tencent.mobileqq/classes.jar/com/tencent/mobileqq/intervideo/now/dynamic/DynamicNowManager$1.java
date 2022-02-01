package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.intervideo.yiqikan.OnOpenCloseRoomCallback;
import com.tencent.qphone.base.util.QLog;

class DynamicNowManager$1
  implements OnOpenCloseRoomCallback
{
  DynamicNowManager$1(DynamicNowManager paramDynamicNowManager, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openWatchTogetherRoom  enter success  retCode= ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(";msg=");
    localStringBuilder.append(paramString);
    QLog.i("XProxy|NowProxy", 1, localStringBuilder.toString());
    this.a.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.1
 * JD-Core Version:    0.7.0.1
 */