package com.tencent.mobileqq.intervideo.yiqikan;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class WatchTogetherClientIPCModule$1
  implements Runnable
{
  WatchTogetherClientIPCModule$1(WatchTogetherClientIPCModule paramWatchTogetherClientIPCModule, String paramString, WatchTogetherFloatingData paramWatchTogetherFloatingData) {}
  
  public void run()
  {
    boolean bool2 = "ACTION_SHOW_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString);
    boolean bool1 = true;
    if (bool2)
    {
      if (WatchFloatingWindowController.a().a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData) != 0) {
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
      if ("ACTION_QUIT_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        WatchFloatingWindowController.a().a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType(), true);
        return;
      }
      if ("ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS".equals(this.jdField_a_of_type_JavaLangString)) {
        WatchFloatingWindowController.a().b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherClientIPCModule.1
 * JD-Core Version:    0.7.0.1
 */