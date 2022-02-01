package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginRecoverReceiver;

public class SetPlugin
  extends Step
{
  protected boolean doStep()
  {
    PluginRecoverReceiver.register(BaseApplicationImpl.sApplication, new MyPluginRecoverReceiver());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetPlugin
 * JD-Core Version:    0.7.0.1
 */