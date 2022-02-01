package com.tencent.mobileqq.qwallet.hb;

import android.os.AsyncTask;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;

class FrameAnimHelper$ZipLoadingTask
  extends AsyncTask<String, Void, AnimationView.AnimationInfo>
{
  private FrameAnimHelper$ZipLoadingTask(FrameAnimHelper paramFrameAnimHelper) {}
  
  protected AnimationView.AnimationInfo a(String... paramVarArgs)
  {
    if ("1".equals(paramVarArgs[1])) {
      return AnimationView.AnimationInfo.loadFromZip(paramVarArgs[0]);
    }
    return AnimationView.AnimationInfo.loadFromFolder(paramVarArgs[0]);
  }
  
  protected void a(AnimationView.AnimationInfo paramAnimationInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("task over info = ");
      localStringBuilder.append(paramAnimationInfo);
      QLog.i("FrameAnimHelper", 2, localStringBuilder.toString());
    }
    this.a.a(paramAnimationInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.FrameAnimHelper.ZipLoadingTask
 * JD-Core Version:    0.7.0.1
 */