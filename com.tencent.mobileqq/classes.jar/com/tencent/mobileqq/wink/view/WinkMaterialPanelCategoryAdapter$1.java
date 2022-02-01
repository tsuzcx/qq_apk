package com.tencent.mobileqq.wink.view;

import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WinkMaterialPanelCategoryAdapter$1
  implements View.OnClickListener
{
  WinkMaterialPanelCategoryAdapter$1(WinkMaterialPanelCategoryAdapter paramWinkMaterialPanelCategoryAdapter, int paramInt, MetaCategory paramMetaCategory) {}
  
  public void onClick(View paramView)
  {
    this.c.a(this.a);
    WinkMaterialPanelCategoryAdapter.a(this.c).b(this.a, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.WinkMaterialPanelCategoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */