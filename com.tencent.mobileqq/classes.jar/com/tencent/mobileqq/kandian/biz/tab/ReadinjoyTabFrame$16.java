package com.tencent.mobileqq.kandian.biz.tab;

import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.utils.ImageUtil;
import java.net.MalformedURLException;
import java.net.URL;

class ReadinjoyTabFrame$16
  implements Runnable
{
  public void run()
  {
    try
    {
      this.a.setRound(true);
      this.a.setImagePlaceHolder(ImageUtil.m()).setImage(new URL(ReadInJoyUserInfoModule.a(this.b)));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.16
 * JD-Core Version:    0.7.0.1
 */