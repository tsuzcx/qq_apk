package dov.com.tencent.biz.qqstory.takevideo.fw;

import android.app.Dialog;
import android.content.DialogInterface.OnShowListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XEditText;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

public class FwReasonInputDialog
  extends ReportDialog
  implements TextWatcher, View.OnClickListener
{
  private DialogInterface.OnShowListener jdField_a_of_type_AndroidContentDialogInterface$OnShowListener;
  private KeyboardAndEmojiManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager;
  XEditText jdField_a_of_type_ComTencentWidgetXEditText;
  private EditVideoPartManager jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
  String jdField_a_of_type_JavaLangString;
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void dismiss()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentWidgetXEditText.getText().toString();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager.a();
    if (isShowing()) {
      super.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    super.setOnShowListener(paramOnShowListener);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener = paramOnShowListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.fw.FwReasonInputDialog
 * JD-Core Version:    0.7.0.1
 */