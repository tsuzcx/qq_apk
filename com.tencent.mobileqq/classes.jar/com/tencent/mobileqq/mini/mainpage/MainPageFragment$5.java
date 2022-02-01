package com.tencent.mobileqq.mini.mainpage;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class MainPageFragment$5
  implements MiniAppCmdInterface
{
  MainPageFragment$5(MainPageFragment paramMainPageFragment) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = (COMM.StCommonExt)paramJSONObject.opt("ext");
      if (paramJSONObject != null) {
        MainPageFragment.access$802(this.this$0, paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment.5
 * JD-Core Version:    0.7.0.1
 */