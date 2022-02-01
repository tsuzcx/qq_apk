package com.tencent.mobileqq.kandian.repo.feeds;

import java.util.List;

class ChannelInfoModule$4
  implements Runnable
{
  ChannelInfoModule$4(ChannelInfoModule paramChannelInfoModule, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().d(false, null);
      return;
    }
    SpecialChannelFilter.a().a(this.jdField_a_of_type_JavaUtilList);
    this.this$0.f(this.jdField_a_of_type_JavaUtilList);
    ReadInJoyLogicEngineEventDispatcher.a().d(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelInfoModule.4
 * JD-Core Version:    0.7.0.1
 */