package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;
import com.tencent.mobileqq.intervideo.yiqikan.OnOpenCloseRoomCallback;

class DynamicNowManager$13
  implements ActionCallback
{
  DynamicNowManager$13(DynamicNowManager paramDynamicNowManager, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback) {}
  
  public void onResult(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
    }
    catch (Exception paramString)
    {
      int i;
      label8:
      break label8;
    }
    i = -1;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanOnOpenCloseRoomCallback.a(i, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.13
 * JD-Core Version:    0.7.0.1
 */