package com.tencent.mobileqq.intervideo.yiqikan;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class WatchTogetherClientIPCModule$1
  implements Runnable
{
  WatchTogetherClientIPCModule$1(WatchTogetherClientIPCModule paramWatchTogetherClientIPCModule, String paramString, WatchTogetherFloatingData paramWatchTogetherFloatingData) {}
  
  public void run()
  {
    boolean bool = true;
    if ("ACTION_SHOW_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
      if (WatchFloatingWindowController.a().a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData) == 0) {
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherClientIPCModule", 2, "call TogetherBusinessIPCModule show=" + bool);
        }
      }
    }
    do
    {
      return;
      bool = false;
      break;
      if ("ACTION_QUIT_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        WatchFloatingWindowController.a().a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType(), true);
        return;
      }
    } while (!"ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS".equals(this.jdField_a_of_type_JavaLangString));
    WatchFloatingWindowController.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherClientIPCModule.1
 * JD-Core Version:    0.7.0.1
 */