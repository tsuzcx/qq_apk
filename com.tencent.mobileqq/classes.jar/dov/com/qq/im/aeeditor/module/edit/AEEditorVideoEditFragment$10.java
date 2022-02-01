package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.edit.widgets.AEEditorCheckGroupView;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextPart;

class AEEditorVideoEditFragment$10
  implements StickerOperationCallback
{
  AEEditorVideoEditFragment$10(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
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
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.d();
    this.a.s();
    AEQLog.a(AEEditorVideoEditFragment.g(), "[onDeleteButtonClick]textEditorData = null");
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
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = null;
    AEQLog.a(AEEditorVideoEditFragment.g(), "[onStickerOutsideClick]textEditorData = null");
  }
  
  public void onStickerSelect(TextEditorData paramTextEditorData)
  {
    if ((paramTextEditorData != null) && (this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null) && (paramTextEditorData.getItemID().equals(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID())) && (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() == 0))
    {
      onTextEditButtonClick(paramTextEditorData);
      return;
    }
    String str;
    StringBuilder localStringBuilder;
    if ((paramTextEditorData != null) && (!"sticker_lyric".equals(paramTextEditorData.getStickerType())))
    {
      this.a.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2131377173);
      this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
      this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setType(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID()));
      this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData);
      str = AEEditorVideoEditFragment.g();
      localStringBuilder = new StringBuilder().append("[onStickerSelect]textEditorData is null ?: ");
      if (paramTextEditorData != null) {
        break label185;
      }
    }
    label185:
    for (boolean bool = true;; bool = false)
    {
      AEQLog.a(str, bool);
      return;
      if (paramTextEditorData == null) {
        break;
      }
      this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.d();
      break;
    }
  }
  
  public void onStickerTouchEnd(TextEditorData paramTextEditorData)
  {
    if ("sticker_lyric".equals(paramTextEditorData.getStickerType()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessageDelayed(0, 2000L);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() != 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessageDelayed(0, 2000L);
    }
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
    int i = this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID());
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setType(i);
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData);
  }
  
  public void onStickerTouchStart(TextEditorData paramTextEditorData)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
  }
  
  public void onTextEditButtonClick(TextEditorData paramTextEditorData)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      paramTextEditorData.setType(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData.getItemID()));
    }
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart.a(this.a.getActivity(), paramTextEditorData, this.a.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    if (paramTextEditorData.getType() != 3) {
      this.a.g(false);
    }
  }
  
  public void onUpdateTextStickerDone(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setUniqueID(paramString);
      this.a.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      AEQLog.d(AEEditorVideoEditFragment.g(), "[onUpdateTextStickerDone] uniqueId:" + paramString);
      return;
    }
    AEQLog.d(AEEditorVideoEditFragment.g(), "[onUpdateTextStickerDone] mCurrentTextEditorData null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.10
 * JD-Core Version:    0.7.0.1
 */