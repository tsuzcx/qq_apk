package com.tencent.mobileqq.startup.step;

import azor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginRecoverReceiver;

public class SetPlugin
  extends Step
{
  protected boolean doStep()
  {
    PluginRecoverReceiver.register(BaseApplicationImpl.sApplication, new azor());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetPlugin
 * JD-Core Version:    0.7.0.1
 */