package com.tencent.mobileqq.mini.mainpage;

import ajyc;
import amtc;
import bcpw;
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
    if (amtc.g())
    {
      bcpw.a(BaseApplicationImpl.getApplication(), ajyc.a(2131706430) + amtc.c() + ajyc.a(2131706426), 0).a();
      return;
    }
    bcpw.a(BaseApplicationImpl.getApplication(), ajyc.a(2131694283), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment.3.1
 * JD-Core Version:    0.7.0.1
 */