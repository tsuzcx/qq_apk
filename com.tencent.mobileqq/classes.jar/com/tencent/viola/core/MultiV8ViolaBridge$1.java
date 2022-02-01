package com.tencent.viola.core;

import com.tencent.viola.utils.ViolaLogUtils;

class MultiV8ViolaBridge$1
  implements Runnable
{
  MultiV8ViolaBridge$1(MultiV8ViolaBridge paramMultiV8ViolaBridge, MultiV8ViolaBridge.V8ViolaRuntime paramV8ViolaRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    this.val$finalRuntime.createInstance(this.val$instanceId, this.val$template, this.val$data, this.val$config);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createRuntime, runtimeName: ");
    localStringBuilder.append(this.val$runtimeName);
    localStringBuilder.append("instanceId: ");
    localStringBuilder.append(this.val$instanceId);
    ViolaLogUtils.e("MultiV8ViolaBridge", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.MultiV8ViolaBridge.1
 * JD-Core Version:    0.7.0.1
 */