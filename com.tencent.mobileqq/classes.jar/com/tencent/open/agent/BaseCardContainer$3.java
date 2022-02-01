package com.tencent.open.agent;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.open.agent.util.SSOLog;

class BaseCardContainer$3
  implements Runnable
{
  BaseCardContainer$3(BaseCardContainer paramBaseCardContainer, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    SSOLog.a("BaseCardContainer", new Object[] { "-->genGameUrlImg: set error img" });
    this.this$0.a.setImageDrawable(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BaseCardContainer.3
 * JD-Core Version:    0.7.0.1
 */