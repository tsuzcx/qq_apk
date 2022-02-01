package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class UpdateBubbleZip
  extends Step
{
  protected boolean doStep()
  {
    TroopNotificationUtils.a();
    FileUtils.a(BaseApplicationImpl.sApplication.getDir("classic_emoticon", 0).getPath());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateBubbleZip
 * JD-Core Version:    0.7.0.1
 */