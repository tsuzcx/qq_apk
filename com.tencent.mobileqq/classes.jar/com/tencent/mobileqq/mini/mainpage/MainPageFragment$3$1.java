package com.tencent.mobileqq.mini.mainpage;

import amtj;
import apyt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

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
    if (apyt.c())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), amtj.a(2131705553) + apyt.a() + amtj.a(2131705549), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), amtj.a(2131693819), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment.3.1
 * JD-Core Version:    0.7.0.1
 */