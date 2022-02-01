package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;

class DynamicNowManager$13
  implements ActionCallback
{
  DynamicNowManager$13(DynamicNowManager paramDynamicNowManager, DynamicNowManager.OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback) {}
  
  public void onResult(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager$OnOpenCloseRoomCallback.a(i, "");
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.13
 * JD-Core Version:    0.7.0.1
 */