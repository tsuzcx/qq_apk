package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$17
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$17(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    if (!paramCompoundButton.isPressed())
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = "open_storyset";
      label27:
      StoryReportor.a("dynamic_more", (String)localObject, 0, 0, new String[0]);
      localObject = new Integer[5];
      localObject[0] = Integer.valueOf(1);
      if (!paramBoolean) {
        break label126;
      }
    }
    label126:
    for (int i = 1;; i = 0)
    {
      localObject[3] = Integer.valueOf(i);
      AssistantSettingFragment.a(this.a).getNowLiveManager().a((Integer[])localObject);
      localObject = (QQStoryHandler)AssistantSettingFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
      i = j;
      if (paramBoolean) {
        i = 2;
      }
      ((QQStoryHandler)localObject).a(i);
      break;
      localObject = "close_storyset";
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.17
 * JD-Core Version:    0.7.0.1
 */