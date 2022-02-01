package com.tencent.mobileqq.qqexpand.widget;

import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.qqexpand.utils.ExpandLimitChatResourceUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

class MatchingView$2
  implements Runnable
{
  MatchingView$2(MatchingView paramMatchingView) {}
  
  public void run()
  {
    Object localObject = ExpandLimitChatResourceUtil.b("expend_match_ellipisis.json");
    try
    {
      localObject = new BufferedInputStream(new FileInputStream((String)localObject));
      LottieComposition.Factory.fromInputStream(this.this$0.getContext(), (InputStream)localObject, new MatchingView.2.1(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MatchingView", 1, "loadEllipsisAnimation fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.MatchingView.2
 * JD-Core Version:    0.7.0.1
 */