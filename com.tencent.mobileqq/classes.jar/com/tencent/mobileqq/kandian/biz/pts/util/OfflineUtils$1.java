package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper;

final class OfflineUtils$1
  implements Runnable
{
  OfflineUtils$1(boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {
      return;
    }
    TemplateFactory.d();
    TemplateFactory.a("default_feeds", true);
    new StyleConfigHelper().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils.1
 * JD-Core Version:    0.7.0.1
 */