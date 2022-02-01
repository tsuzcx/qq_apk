package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.net.Uri;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;

class ViolaHandler$1$1
  implements Runnable
{
  ViolaHandler$1$1(ViolaHandler.1 param1, String paramString) {}
  
  public void run()
  {
    if ("1".equals(Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("v_feeds_preload"))) {
      ReadInJoyWebDataManager.a().c(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.ViolaHandler.1.1
 * JD-Core Version:    0.7.0.1
 */