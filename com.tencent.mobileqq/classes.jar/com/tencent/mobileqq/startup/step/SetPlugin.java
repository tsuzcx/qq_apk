package com.tencent.mobileqq.startup.step;

import ahrh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginRecoverReceiver;

public class SetPlugin
  extends Step
{
  protected boolean a()
  {
    PluginRecoverReceiver.register(BaseApplicationImpl.sApplication, new ahrh());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetPlugin
 * JD-Core Version:    0.7.0.1
 */