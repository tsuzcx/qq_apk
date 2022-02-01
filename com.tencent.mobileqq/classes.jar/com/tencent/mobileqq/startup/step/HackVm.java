package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import com.tencent.qqperf.opt.vm.HackVmImpl;

public class HackVm
  extends Step
{
  protected boolean doStep()
  {
    if ((Build.VERSION.SDK_INT <= 20) && ((this.mId == 41) || (this.mId == 43))) {
      HackVmImpl.a();
    }
    if ((Build.VERSION.SDK_INT < 24) && ((this.mId == 42) || (this.mId == 43))) {
      HackVmImpl.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.HackVm
 * JD-Core Version:    0.7.0.1
 */