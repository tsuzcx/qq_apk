package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import org.json.JSONObject;

class MainPageFragment$4
  implements AsyncResult
{
  MainPageFragment$4(MainPageFragment paramMainPageFragment) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      int i = paramJSONObject.optInt("likeNum");
      int j = paramJSONObject.optInt("doLike");
      paramJSONObject = paramJSONObject.opt("mini_app_info_data");
      MainPageFragment.access$302(this.this$0, i);
      MainPageFragment localMainPageFragment = this.this$0;
      paramBoolean = true;
      if (j != 1) {
        paramBoolean = false;
      }
      MainPageFragment.access$402(localMainPageFragment, paramBoolean);
      AppBrandTask.runTaskOnUiThread(new MainPageFragment.4.1(this, i, paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MainPageFragment.4
 * JD-Core Version:    0.7.0.1
 */