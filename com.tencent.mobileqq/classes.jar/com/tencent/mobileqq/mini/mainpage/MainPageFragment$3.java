package com.tencent.mobileqq.mini.mainpage;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class MainPageFragment$3
  implements EIPCResultCallback
{
  MainPageFragment$3(MainPageFragment paramMainPageFragment, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.code == -100))
    {
      AppBrandTask.runTaskOnUiThread(new MainPageFragment.3.1(this));
      return;
    }
    MainPageFragment.access$600(this.this$0, this.val$miniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment.3
 * JD-Core Version:    0.7.0.1
 */