package com.tencent.mobileqq.mini.mainpage;

import ajjy;
import amda;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;

class MainPageFragment$3$1
  implements Runnable
{
  MainPageFragment$3$1(MainPageFragment.3 param3) {}
  
  public void run()
  {
    if (this.this$1.val$miniAppInfo != null)
    {
      this.this$1.val$miniAppInfo.topType = 0;
      MainPageFragment.access$500(this.this$1.this$0, this.this$1.val$miniAppInfo);
    }
    if (amda.g())
    {
      bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131640645) + amda.c() + ajjy.a(2131640641), 0).a();
      return;
    }
    bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131628633), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment.3.1
 * JD-Core Version:    0.7.0.1
 */