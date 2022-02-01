package com.tencent.mobileqq.startup.step;

import ajfq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class UpdateBubbleZip
  extends Step
{
  protected boolean doStep()
  {
    ajfq.a();
    FileUtils.deleteDirectory(BaseApplicationImpl.sApplication.getDir("classic_emoticon", 0).getPath());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateBubbleZip
 * JD-Core Version:    0.7.0.1
 */