package dov.com.qq.im.aeeditor.module.text;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AETextStickerCategoryAdapter$1
  implements View.OnClickListener
{
  AETextStickerCategoryAdapter$1(AETextStickerCategoryAdapter paramAETextStickerCategoryAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerCategoryAdapter.a(this.jdField_a_of_type_Int);
    if (AETextStickerCategoryAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerCategoryAdapter) != null) {
      AETextStickerCategoryAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerCategoryAdapter).a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AETextStickerCategoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */