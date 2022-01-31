package com.tencent.mobileqq.mini.mainpage;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class MainPageFragment$2
  implements MiniAppCmdInterface
{
  MainPageFragment$2(MainPageFragment paramMainPageFragment) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    boolean bool = true;
    int i;
    MainPageFragment localMainPageFragment;
    if (paramBoolean)
    {
      i = paramJSONObject.optInt("likeNum");
      int j = paramJSONObject.optInt("doLike");
      paramJSONObject = paramJSONObject.opt("mini_app_info_data");
      MainPageFragment.access$102(this.this$0, i);
      localMainPageFragment = this.this$0;
      if (j != 1) {
        break label74;
      }
    }
    label74:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      MainPageFragment.access$202(localMainPageFragment, paramBoolean);
      AppBrandTask.runTaskOnUiThread(new MainPageFragment.2.1(this, i, paramJSONObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment.2
 * JD-Core Version:    0.7.0.1
 */