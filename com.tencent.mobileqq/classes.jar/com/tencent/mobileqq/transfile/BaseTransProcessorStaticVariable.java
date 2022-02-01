package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.qphone.base.util.BaseApplication;

public class BaseTransProcessorStaticVariable
{
  protected static OldEngineDPCProfile TIMEOUT_PROFILE = new OldEngineDPCProfile();
  public static WeakNetLearner WEAK_NET_LEARNER = new WeakNetLearner(BaseApplication.getContext(), new BaseTransProcessorStaticVariable.1());
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransProcessorStaticVariable
 * JD-Core Version:    0.7.0.1
 */