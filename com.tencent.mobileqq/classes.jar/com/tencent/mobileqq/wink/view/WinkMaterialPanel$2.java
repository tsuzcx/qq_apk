package com.tencent.mobileqq.wink.view;

import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.utils.AdapterUtils;

class WinkMaterialPanel$2
  implements WinkMaterialPanelCategoryAdapter.ItemListener
{
  WinkMaterialPanel$2(WinkMaterialPanel paramWinkMaterialPanel) {}
  
  public void a(int paramInt, @Nullable MetaCategory paramMetaCategory)
  {
    if (WinkMaterialPanel.f(this.a) != null) {
      WinkMaterialPanel.f(this.a).a(paramInt, paramMetaCategory);
    }
  }
  
  public void b(int paramInt, @Nullable MetaCategory paramMetaCategory)
  {
    if (WinkMaterialPanel.f(this.a) != null) {
      WinkMaterialPanel.f(this.a).b(paramInt, paramMetaCategory);
    }
    WinkMaterialPanel.a(this.a, true);
    paramInt = MetaMaterialKt.b(WinkMaterialPanel.c(this.a), WinkMaterialPanel.d(this.a), paramInt);
    AdapterUtils.b(WinkMaterialPanel.g(this.a), WinkMaterialPanel.h(this.a).a(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.WinkMaterialPanel.2
 * JD-Core Version:    0.7.0.1
 */