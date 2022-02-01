package com.tencent.mobileqq.kandian.biz.pts.nativemodule;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.pts.nativemodule.IPTSAllInOneJump;
import com.tencent.qphone.base.util.QLog;

public class PTSAllInOneJumpModule
  implements IPTSAllInOneJump
{
  public void allInOneJump(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[allInOneJump], url = ");
    localStringBuilder.append(paramString);
    QLog.i("PTSAllInOneJumpModule", 1, localStringBuilder.toString());
    if (BaseActivity.sTopActivity != null) {
      ReadInJoyUtils.a(BaseActivity.sTopActivity, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSAllInOneJumpModule
 * JD-Core Version:    0.7.0.1
 */