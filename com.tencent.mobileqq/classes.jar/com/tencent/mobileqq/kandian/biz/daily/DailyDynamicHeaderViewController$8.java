package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import org.json.JSONObject;

final class DailyDynamicHeaderViewController$8
  implements ViewFactory.FoundClickableViewListener
{
  DailyDynamicHeaderViewController$8(String paramString, JSONObject paramJSONObject) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()) != 1075)
    {
      paramViewBase.setOnClickListener(new DailyDynamicHeaderViewController.8.2(this));
      return;
    }
    paramViewBase.setOnClickListener(new DailyDynamicHeaderViewController.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderViewController.8
 * JD-Core Version:    0.7.0.1
 */