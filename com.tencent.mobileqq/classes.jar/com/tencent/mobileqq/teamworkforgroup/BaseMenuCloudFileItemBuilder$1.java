package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseMenuCloudFileItemBuilder$1
  implements View.OnClickListener
{
  BaseMenuCloudFileItemBuilder$1(BaseMenuCloudFileItemBuilder paramBaseMenuCloudFileItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (Utils.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      ICloudFile localICloudFile = (ICloudFile)paramView.getTag(-10);
      if (paramView.getId() == 2131364746) {
        BaseMenuCloudFileItemBuilder.a(this.a, localICloudFile);
      } else if (BaseMenuCloudFileItemBuilder.a(this.a) != null) {
        BaseMenuCloudFileItemBuilder.a(this.a).a(paramView.getId(), localICloudFile);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.BaseMenuCloudFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */