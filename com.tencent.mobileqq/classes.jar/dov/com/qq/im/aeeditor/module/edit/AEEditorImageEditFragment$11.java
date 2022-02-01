package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.edit.widgets.AEEditorCheckGroupView;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextPart;

class AEEditorImageEditFragment$11
  implements StickerOperationCallback
{
  AEEditorImageEditFragment$11(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onAddStickerDone(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setUniqueID(paramString);
      this.a.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    }
  }
  
  public void onDeleteButtonClick(String paramString)
  {
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = null;
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(null);
    ViewUtils.b(AEEditorImageEditFragment.a(this.a), 0);
    this.a.s();
  }
  
  public void onStickerClick(TextEditorData paramTextEditorData)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() != 0)
    {
      onStickerSelect(paramTextEditorData);
      return;
    }
    onTextEditButtonClick(paramTextEditorData);
  }
  
  public void onStickerMoving(String paramString) {}
  
  public void onStickerOutsideClick()
  {
    this.a.j();
    this.a.k();
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = null;
    AEQLog.a("AEEditorImageEditFragment", "[onStickerOutsideClick]textEditorData = null");
  }
  
  public void onStickerSelect(TextEditorData paramTextEditorData)
  {
    if ((paramTextEditorData != null) && (this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null) && (paramTextEditorData.getItemID().equals(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID())) && (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() == 0))
    {
      onTextEditButtonClick(paramTextEditorData);
      return;
    }
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2131377173);
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setType(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID()));
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData);
    ViewUtils.b(AEEditorImageEditFragment.a(this.a), 4);
  }
  
  public void onStickerTouchEnd(TextEditorData paramTextEditorData)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() != 0) {
      AEEditorImageEditFragment.a(this.a).setScrollable(true);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() != 0) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessageDelayed(0, 2000L);
    }
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
    int i = this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID());
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setType(i);
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData);
  }
  
  public void onStickerTouchStart(TextEditorData paramTextEditorData)
  {
    AEEditorImageEditFragment.a(this.a).setScrollable(false);
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
  }
  
  public void onTextEditButtonClick(TextEditorData paramTextEditorData)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      paramTextEditorData.setType(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData.getItemID()));
    }
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart.a(this.a.getActivity(), paramTextEditorData, AEEditorImageEditFragment.a(this.a));
  }
  
  public void onUpdateTextStickerDone(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setUniqueID(paramString);
      this.a.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      AEQLog.d("AEEditorImageEditFragment", "[onUpdateTextStickerDone] uniqueId:" + paramString);
      return;
    }
    AEQLog.d("AEEditorImageEditFragment", "[onUpdateTextStickerDone] mCurrentTextEditorData null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.11
 * JD-Core Version:    0.7.0.1
 */