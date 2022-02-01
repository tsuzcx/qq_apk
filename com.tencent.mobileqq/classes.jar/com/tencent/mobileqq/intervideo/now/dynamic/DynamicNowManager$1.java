package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.intervideo.yiqikan.OnOpenCloseRoomCallback;
import com.tencent.qphone.base.util.QLog;

class DynamicNowManager$1
  implements DynamicNowManager.OnOpenCloseRoomCallback
{
  DynamicNowManager$1(DynamicNowManager paramDynamicNowManager, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.i("XProxy|NowProxy", 1, "openWatchTogetherRoom  enter success  retCode= " + paramInt + ";msg=" + paramString);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanOnOpenCloseRoomCallback.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.1
 * JD-Core Version:    0.7.0.1
 */