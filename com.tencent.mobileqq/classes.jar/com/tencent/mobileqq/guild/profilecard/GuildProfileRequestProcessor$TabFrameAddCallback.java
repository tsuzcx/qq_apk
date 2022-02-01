package com.tencent.mobileqq.guild.profilecard;

import com.tencent.mobileqq.activity.home.OnTabFrameAddCallback;
import com.tencent.mobileqq.activity.home.TabData;
import com.tencent.qphone.base.util.QLog;

class GuildProfileRequestProcessor$TabFrameAddCallback
  implements OnTabFrameAddCallback
{
  public void a(TabData paramTabData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildProfileRequestProcessor", 2, new Object[] { "onTabFrameAdd: ", paramTabData });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.GuildProfileRequestProcessor.TabFrameAddCallback
 * JD-Core Version:    0.7.0.1
 */