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
    ICloudFile localICloudFile;
    if (Utils.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localICloudFile = (ICloudFile)paramView.getTag(-10);
      if (paramView.getId() != 2131364860) {
        break label47;
      }
      BaseMenuCloudFileItemBuilder.a(this.a, localICloudFile);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label47:
      if (BaseMenuCloudFileItemBuilder.a(this.a) != null) {
        BaseMenuCloudFileItemBuilder.a(this.a).a(paramView.getId(), localICloudFile);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.BaseMenuCloudFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */